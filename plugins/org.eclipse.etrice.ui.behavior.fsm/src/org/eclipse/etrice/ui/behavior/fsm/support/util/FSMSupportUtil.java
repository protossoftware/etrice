/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.support.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.ui.FSMUiModule;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.fsm.util.FSMNewNamingUtil;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 *  Shared business logic, side-effect free util methods
 */
public class FSMSupportUtil {


	private static FSMSupportUtil instance = null;

	/**
	 * @return the instance
	 */
	public static FSMSupportUtil getInstance() {
		if (instance==null) {
			// this class has members that have to be filled by the FSMUi injector
			Injector injector = FSMUiModule.getInjector();
	        instance = injector.getInstance(FSMSupportUtil.class);
		}
		return instance;
	}

	@Inject
	private FSMHelpers fsmHelpers;
	@Inject
	private FSMValidationUtil fsmValidationUtil;
	@Inject
	private FSMNameProvider fsmNameProvider;
	@Inject
	private FSMNewNamingUtil fsmNewNamingUtil;

	/**
	 * @return the roomHelpers
	 */
	public FSMHelpers getFSMHelpers() {
		return fsmHelpers;
	}

	/**
	 * @return the validationUtil
	 */
	public FSMValidationUtil getFSMValidationUtil() {
		return fsmValidationUtil;
	}

	/**
	 * @return the roomUtil
	 */
	public FSMNewNamingUtil getFSMNewNamingUtil() {
		return fsmNewNamingUtil;
	}

	/**
	 * @return the roomNameProvider
	 */
	public FSMNameProvider getFSMNameProvider() {
		return fsmNameProvider;
	}

	public boolean isInherited(Diagram diag, EObject obj) {
		return isInherited(getModelComponent(diag), obj);
	}
	
	public boolean isInherited(ModelComponent mc, EObject obj) {
		if (obj instanceof StateGraph)
			obj = obj.eContainer();
		else if (obj instanceof ModelComponent)
			// the next line states: if a ModelComponent has no base class, then it is not inherited.
			// And vice versa: if it has a base class it is inherited
			// QUESTION: is this correct?
			// However, this method isn't called with an obj instanceof ModelComponent
			return ((ModelComponent) obj).getBase() != null;
		
		return  obj instanceof RefinedState || obj instanceof RefinedTransition || !EcoreUtil.isAncestor(mc, obj);
	}
	
	public boolean isOwnedBy(Diagram diag, EObject obj) {
		return isOwnedBy(getModelComponent(diag), obj);
	}
	
	public boolean isOwnedBy(ModelComponent mc, EObject obj) {
		return EcoreUtil.isAncestor(mc, obj);
	}

	public boolean showAsInherited(Diagram diag, State obj) {
	
		if (obj instanceof RefinedState)
			return true;
	
		return fsmHelpers.getModelComponent(obj)!=getModelComponent(diag);
	}

	public Diagram getDiagram(GraphicsAlgorithm ga) {
		if (ga.eContainer() instanceof GraphicsAlgorithm)
			return getDiagram((GraphicsAlgorithm)ga.eContainer());
		return getDiagram(ga.getPictogramElement());
	}

	public Diagram getDiagram(PictogramElement pe) {
		while (pe.eContainer()!=null) {
			if (pe.eContainer() instanceof Diagram)
				return (Diagram) pe.eContainer();
			pe = (PictogramElement) pe.eContainer();
		}
		return null;
	}

	public ModelComponent getModelComponent(Diagram diag) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diag);
		if (bo instanceof ModelComponent)
			return (ModelComponent) bo;
		return null;
	}

	public State getTargettingState(State state, Diagram diagram) {
		ModelComponent mc = getModelComponent(diagram);
		return fsmHelpers.getTargettingState(state, mc);
	}

	/**
	 * This method exploits the fact that the immediate children of the diagram are
	 * associated with the state graphs.
	 * 
	 * @param shape
	 * @return the container shape that is associated with the state graph of the diagram
	 */
	public ContainerShape getStateGraphContainer(ContainerShape shape) {
		while (shape!=null) {
			ContainerShape parent = shape.getContainer();
			if (parent instanceof Diagram)
				return shape;
			shape = parent;
		}
		return null;
	}

	public StateGraph getStateGraph(ContainerShape cs, IFeatureProvider fp) {
		ContainerShape shape = getStateGraphContainer(cs);
		Object bo = fp.getBusinessObjectForPictogramElement(shape);
		if (bo instanceof StateGraph)
			return (StateGraph) bo;
		else
			assert(false): "state graph expected";
			
		return null;
	}

	public TransitionTerminal getTransitionTerminal(Anchor anchor, IFeatureProvider fp) {
		if (anchor != null) {
			Object obj = fp.getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof TrPoint) {
				Object parent = fp.getBusinessObjectForPictogramElement((ContainerShape) anchor.getParent().eContainer());
				if (parent instanceof State) {
					State state = (parent instanceof RefinedState)? ((RefinedState)parent).getTarget() : (State)parent;
					SubStateTrPointTerminal sstpt = FSMFactory.eINSTANCE.createSubStateTrPointTerminal();
					sstpt.setState(state);
					sstpt.setTrPoint((TrPoint) obj);
					return sstpt;
				}
				else {
					TrPointTerminal tpt = FSMFactory.eINSTANCE.createTrPointTerminal();
					tpt.setTrPoint((TrPoint) obj);
					return tpt;
				}
			}
			else if (obj instanceof State) {
				State state = (obj instanceof RefinedState)? ((RefinedState)obj).getTarget() : (State)obj;
				StateTerminal st = FSMFactory.eINSTANCE.createStateTerminal();
				st.setState(state);
				return st;
			}
			else if (obj instanceof ChoicePoint) {
				ChoicepointTerminal ct = FSMFactory.eINSTANCE.createChoicepointTerminal();
				ct.setCp((ChoicePoint) obj);
				return ct;
			}
		}
		return null;
	}

	public boolean isInitialPoint(Anchor anchor, IFeatureProvider fp) {
		if (anchor!=null) {
			Object obj = fp.getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof StateGraph) {
				Object parent = fp.getBusinessObjectForPictogramElement((ContainerShape) anchor.getParent().eContainer());
				if (parent instanceof StateGraph)
					return true;
			}
		}
		return false;
	}

	public boolean canConnect(Anchor asrc, Anchor atgt, ContainerShape cs, IFeatureProvider fp) {
		return canConnect(asrc, atgt, null, cs, fp);
	}

	public boolean canConnect(Anchor asrc, Anchor atgt, Transition trans, ContainerShape cs, IFeatureProvider fp) {
		TransitionTerminal src = getTransitionTerminal(asrc, fp);
		TransitionTerminal tgt = getTransitionTerminal(atgt, fp);
		
		if (src==null && !isInitialPoint(asrc, fp))
			return false;
		if (tgt==null)
			return false;
		
		StateGraph sg = getStateGraph(cs, fp);
		if (sg==null)
			return false;
		
		return fsmValidationUtil.isConnectable(src, tgt, trans, sg).isOk();
	}

	public List<Transition> getTransitions(Diagram diagram, IFeatureProvider fp) {
		List<Transition> transitions = new ArrayList<Transition>();
		for (Connection conn : diagram.getConnections()) {
			Object bo = fp.getBusinessObjectForPictogramElement(conn);
			if (bo instanceof Transition)
				transitions.add((Transition) bo);
		}
		return transitions;
	}

}
