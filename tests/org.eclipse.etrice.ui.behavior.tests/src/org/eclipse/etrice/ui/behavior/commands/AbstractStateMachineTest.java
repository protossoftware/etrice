/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.ExitPoint;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.tests.base.TestBase;
import org.eclipse.etrice.ui.behavior.BehaviorTestActivator;
import org.eclipse.etrice.ui.behavior.fsm.support.StateSupport;
import org.eclipse.etrice.ui.behavior.fsm.support.TrPointSupport;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

/**
 * base class for state machine tests
 * 
 * @author Henrik Rentz-Reichert - API and initial contribution
 */
public abstract class AbstractStateMachineTest extends TestBase {

	private FSMHelpers fsmHelpers = new FSMHelpers();
	
	/**
	 * test general conditions for state graphs
	 * @param diagram the diagram
	 * @param sg the state graph to test
	 */
	protected void testStateGraph(Diagram diagram, StateGraph sg) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		assertTrue("diagram bo is actor class", bo instanceof ActorClass);

		ActorClass ac = (ActorClass) bo;
		
		List<PictogramElement> elements;
		
		// check initial transition
		{
			boolean hasInitialTransition = fsmHelpers.hasInitTransition(sg);
			
			// if this is the top level and we have an inherited initial transition we count that
			// too since its pe is also linked to the current state graph
			if (sg==ac.getStateMachine()) {
				ActorClass theAC = ac.getActorBase();
				while (theAC!=null) {
					hasInitialTransition |= fsmHelpers.hasInitTransition(theAC.getStateMachine());
					theAC = theAC.getActorBase();
				}
			}
			elements = Graphiti.getLinkService().getPictogramElements(diagram, sg);
			assertEquals("PEs for our state graph: sg and initial point", hasInitialTransition? 2:1, elements.size());
		}
		
		for (State s : sg.getStates()) {
			elements = Graphiti.getLinkService().getPictogramElements(diagram, s);
			assertEquals("PEs for our state", 1, elements.size());
			assertTrue("PE is shape", elements.get(0) instanceof Shape);
			checkStateGAs(ac, s, (Shape) elements.get(0));
		}
		
		for (ChoicePoint cp : sg.getChPoints()) {
			elements = Graphiti.getLinkService().getPictogramElements(diagram, cp);
			assertEquals("PEs for our cp", 1, elements.size());
			assertTrue("PE is shape", elements.get(0) instanceof Shape);
		}
		
		for (TrPoint tp : sg.getTrPoints()) {
			elements = Graphiti.getLinkService().getPictogramElements(diagram, tp);
			assertEquals("PEs for our tp", (tp instanceof TransitionPoint)? 1:2, elements.size());
			assertTrue("PE is shape", elements.get(0) instanceof Shape);
			checkTrpGAs(ac, tp, (Shape) elements.get(0));
		}
		
		for (Transition trans : sg.getTransitions()) {
			elements = Graphiti.getLinkService().getPictogramElements(diagram, trans);
			assertEquals("PEs for our transition", 1, elements.size());
		}
	}

	/**
	 * test general conditions for states
	 * 
	 * @param ac actor class
	 * @param s the state to test
	 * @param shape the state's shape
	 */
	private void checkStateGAs(ActorClass ac, State s, Shape shape) {
		assertNotNull("ga is there (invisible rectangle)", shape.getGraphicsAlgorithm());
		assertTrue("ga is rounded rectangle", shape.getGraphicsAlgorithm() instanceof Rectangle);
		assertFalse("ga is invisible", shape.getGraphicsAlgorithm().getFilled());
		assertFalse("ga is invisible", shape.getGraphicsAlgorithm().getLineVisible());
		assertEquals("border rect", 1, shape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().size());
		GraphicsAlgorithm borderRect = shape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
		assertTrue("border rect is rounded rectangle", borderRect instanceof RoundedRectangle);
		if (isInherited(ac,s))
			assertTrue("border rect background", isEqual(borderRect.getForeground(), StateSupport.INHERITED_COLOR));
		else
			assertTrue("border rect background", isEqual(borderRect.getForeground(), StateSupport.LINE_COLOR));
	}

	/**
	 * test general conditions for transition points
	 * 
	 * @param ac actor class
	 * @param tp the transition point to test
	 * @param shape the state's shape
	 */
	private void checkTrpGAs(ActorClass ac, TrPoint tp, Shape shape) {
		assertNotNull("ga is there (invisible rectangle)", shape.getGraphicsAlgorithm());
		assertTrue("ga is ellipse", shape.getGraphicsAlgorithm() instanceof Rectangle);
		assertFalse("ga is invisible", shape.getGraphicsAlgorithm().getFilled());
		assertFalse("ga is invisible", shape.getGraphicsAlgorithm().getLineVisible());
		int nga = 1;
		if (tp instanceof EntryPoint)
			nga = 3;
		else if (tp instanceof ExitPoint)
			nga = 2;
		assertEquals("border rect", nga, shape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().size());
		GraphicsAlgorithm borderRect = shape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
		assertTrue("border rect is rounded rectangle", borderRect instanceof Ellipse);
		if (isInherited(ac,tp))
			assertTrue("border rect background", isEqual(borderRect.getForeground(), TrPointSupport.INHERITED_COLOR));
		else
			assertTrue("border rect background", isEqual(borderRect.getForeground(), TrPointSupport.DARK_COLOR));
	}

	/**
	 * compute inheritance
	 * 
	 * @param ac actor class
	 * @param item state graph item
	 * @return true if state graph item is not owned by the given actor class
	 */
	private boolean isInherited(ActorClass ac, StateGraphItem item) {
		if (item instanceof RefinedState)
			return true;
		
		EObject owner = item.eContainer();
		while (owner!=null) {
			if (owner instanceof ActorClass)
				break;
			owner = owner.eContainer();
		}
		return ac!=owner;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.tests.base.TestBase#getModelsDirectoy()
	 */
	@Override
	protected URL getModelsDirectoy() {
		return BehaviorTestActivator.getDefault().getBundle().getEntry("models");
	}
}
