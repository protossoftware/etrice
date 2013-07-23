/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.CPBranchTransition;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ContinuationTransition;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.VarDecl;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestMultipleConnectedChoicepoint extends
		TestInstanceModelBuilderBase {
	
	private Root root;
	private HashMap<EClass, ArrayList<EObject>> instances;
	private ExpandedActorClass xpac;

	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("cpmult.room");
		xpac = getTestee();
		instances = collectInstances(xpac);
	}

	private ExpandedActorClass getTestee() {
		for (ExpandedActorClass xpac : root.getXpActorClasses()) {
			if (xpac.getActorClass().getName().equals("CPMult"))
				return xpac;
		}
		return null;
	}
	
	private Transition getTransition(String name) {
		for (Transition tr : xpac.getStateMachine().getTransitions()) {
			if (tr.getName().equals(name))
				return tr;
		}
		return null;
	}
	
	private Transition getState1Transition(String name) {
		for (State s : xpac.getStateMachine().getStates()) {
			if (s.getName().equals("state1")) {
				for (Transition tr : s.getSubgraph().getTransitions()) {
					if (tr.getName().equals(name))
						return tr;
				}
			}
		}
		return null;
	}
	
	@Test
	public void testNumbers() {
		assertEquals("number of states", 6, instances.get(RoomPackage.eINSTANCE.getSimpleState()).size());
		assertEquals("number of choice points", 1, instances.get(RoomPackage.eINSTANCE.getChoicePoint()).size());
		assertNull("number of transition points", instances.get(RoomPackage.eINSTANCE.getTransitionPoint()));
		assertEquals("number of entry points", 1, instances.get(RoomPackage.eINSTANCE.getEntryPoint()).size());
		assertEquals("number of exit points", 1, instances.get(RoomPackage.eINSTANCE.getExitPoint()).size());
		assertEquals("number of initial transitions", 1, instances.get(RoomPackage.eINSTANCE.getInitialTransition()).size());
		assertEquals("number of triggered transitions", 5, instances.get(RoomPackage.eINSTANCE.getTriggeredTransition()).size());
		assertEquals("number of continuation transitions", 3, instances.get(RoomPackage.eINSTANCE.getContinuationTransition()).size());
		assertEquals("number of branch transitions", 1, instances.get(RoomPackage.eINSTANCE.getCPBranchTransition()).size());
	}
	
	@Test
	public void testXPACGeneral() {
		EList<TransitionChain> chains = xpac.getTransitionChains();
		assertEquals("number of chains", 6, chains.size());
		assertEquals("number of triggers", 4, xpac.getTriggers().size());
	}
	
	@Test
	public void testGraph() {
		ArrayList<EObject> cps = instances.get(RoomPackage.eINSTANCE.getChoicePoint());
		ChoicePoint cp = (ChoicePoint) cps.get(0);
		assertEquals("choicepoint name", "cp0", RoomNameProvider.getFullPath(cp));
		assertEquals("number of incoming transitions", 2, xpac.getIncomingTransitions(cp).size());
		assertEquals("number of outgoing transitions", 2, xpac.getOutgoingTransitions(cp).size());
	}
	
	@Test
	public void testData() {
		Transition tr = getTransition("tr0");
		VarDecl data = xpac.getData(tr);
		assertTrue("transition is TriggeredTransition", tr instanceof TriggeredTransition);
		assertTrue("data is DataClass", data.getRefType().getType() instanceof DataClass);
		assertEquals("data of "+tr.getName(), "DC2", data.getRefType().getType().getName());
		
		tr = getState1Transition("tr2");
		data = xpac.getData(tr);
		assertTrue("transition is TriggeredTransition", tr instanceof TriggeredTransition);
		assertTrue("data is DataClass", data.getRefType().getType() instanceof DataClass);
		assertEquals("data of "+tr.getName(), "DC2", data.getRefType().getType().getName());
		
		tr = getState1Transition("tr3");
		data = xpac.getData(tr);
		assertTrue("transition is TriggeredTransition", tr instanceof TriggeredTransition);
		assertTrue("data is DataClass", data.getRefType().getType() instanceof DataClass);
		assertEquals("data of "+tr.getName(), "DC4", data.getRefType().getType().getName());
		
		tr = getTransition("tr1");
		data = xpac.getData(tr);
		assertTrue("transition is TriggeredTransition", tr instanceof TriggeredTransition);
		assertTrue("data is DataClass", data.getRefType().getType() instanceof DataClass);
		assertEquals("data of "+tr.getName(), "DC3", data.getRefType().getType().getName());
		
		tr = getTransition("tr3");
		data = xpac.getData(tr);
		assertTrue("transition is ContinuationTransition", tr instanceof ContinuationTransition);
		assertTrue("data is DataClass", data.getRefType().getType() instanceof DataClass);
		assertEquals("data of "+tr.getName(), "DC", data.getRefType().getType().getName());
		
		tr = getTransition("tr4");
		data = xpac.getData(tr);
		assertTrue("transition is CPBranchTransition", tr instanceof CPBranchTransition);
		assertTrue("data is DataClass", data.getRefType().getType() instanceof DataClass);
		assertEquals("data of "+tr.getName(), "DC", data.getRefType().getType().getName());
	}

}
