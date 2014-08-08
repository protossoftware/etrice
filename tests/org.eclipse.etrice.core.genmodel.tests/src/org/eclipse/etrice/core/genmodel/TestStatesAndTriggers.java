/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.genmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SAP;
import org.junit.Before;
import org.junit.Test;

public class TestStatesAndTriggers extends TestInstanceModelBuilderBase {
	
	private Root root;
	private ExpandedActorClass xpac;
	private RoomNameProvider roomNameProvider = new RoomNameProvider();
	
	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("states_triggers.room");
		xpac = getTestee();
		instances = collectInstances(xpac);
	}

	private ExpandedActorClass getTestee() {
		for (ExpandedActorClass xpac : root.getXpActorClasses()) {
			if (xpac.getActorClass().getName().equals("ATest"))
				return xpac;
		}
		return null;
	}
	
	@Test
	public void testNumbers() {
		checkSize(7, FSMPackage.eINSTANCE.getSimpleState());
		checkSize(1, FSMPackage.eINSTANCE.getChoicePoint());
		checkSize(4, FSMPackage.eINSTANCE.getTransitionPoint());
		checkSize(1, FSMPackage.eINSTANCE.getEntryPoint());
		checkSize(1, FSMPackage.eINSTANCE.getExitPoint());
		checkSize(2, FSMPackage.eINSTANCE.getInitialTransition());
		checkSize(11, FSMPackage.eINSTANCE.getTriggeredTransition());
		checkSize(3, FSMPackage.eINSTANCE.getContinuationTransition());
		checkSize(2, FSMPackage.eINSTANCE.getCPBranchTransition());
	}
	
	@Test
	public void testXPACGeneral() {
		EList<TransitionChain> chains = xpac.getTransitionChains();
		assertEquals("number of chains", 13, chains.size());
		assertEquals("numer of triggers", 7, xpac.getTriggers().size());
	}
	
	@Test
	public void testGraph() {
		ArrayList<EObject> states = instances.get(FSMPackage.eINSTANCE.getSimpleState());
//		for (EObject obj : states) {
//			LogicalSystem.out.println("state "+RoomNameProvider.getFullPath((StateGraphItem) obj));
//		}

		State s = (State) getStateGraphItem(states, "State3_State3");
		assertNotNull("state exists", s);
		assertEquals("number of incoming transitions", 3, xpac.getIncomingTransitions(s).size());
		assertEquals("number of outgoing transitions", 2, xpac.getOutgoingTransitions(s).size());
		
		assertEquals("active triggers", 6, xpac.getActiveTriggers(s).size());
		
		s = (State) getStateGraphItem(states, "State2");
		assertNotNull("state exists", s);
		assertEquals("number of incoming transitions", 4, xpac.getIncomingTransitions(s).size());
		assertEquals("number of outgoing transitions", 1, xpac.getOutgoingTransitions(s).size());
		
		assertEquals("active triggers", 3, xpac.getActiveTriggers(s).size());

		ArrayList<EObject> cps = instances.get(FSMPackage.eINSTANCE.getChoicePoint());
		
		ChoicePoint cp = (ChoicePoint) cps.get(0);
		assertEquals("choicepoint name", "CP1", roomNameProvider.getFullPath(cp));
		assertEquals("number of incoming transitions", 1, xpac.getIncomingTransitions(cp).size());
		assertEquals("number of outgoing transitions", 3, xpac.getOutgoingTransitions(cp).size());
		
		ContinuationTransition dflt = xpac.getDefaultBranch(xpac.getOutgoingTransitions(cp));
		assertNotNull("default branch", dflt);
	}
	
	@Test
	public void testChains() {
		ArrayList<EObject> cts = instances.get(FSMPackage.eINSTANCE.getContinuationTransition());
//		for (EObject obj : cts) {
//			LogicalSystem.out.println("ct "+RoomNameProvider.getFullPath((StateGraphItem) obj));
//		}
		
		Transition t = (Transition) getStateGraphItem(cts, "State3_TRANS_tr1_FROM_tp1_TO_State3");
		assertNotNull("transition", t);

		TransitionChain chain = xpac.getChain(t);
		assertNotNull("chain", chain);
		assertEquals("chain name", "TRANS_tr5_FROM_tp0_TO_State3_tp1_BY_afct", roomNameProvider.getFullPath(chain.getTransition()));
	}
	
	@Test
	public void testIfItems() {
		Port fct = xpac.getActorClass().getInterfacePorts().get(0);
		Port sub = xpac.getActorClass().getInternalPorts().get(0);
		SAP timer = xpac.getActorClass().getServiceAccessPoints().get(0);
		SAP timeout = xpac.getActorClass().getServiceAccessPoints().get(1);
		
		assertEquals("port name", "fct", fct.getName());
		assertEquals("port name", "subp", sub.getName());
		assertEquals("sap name", "timer", timer.getName());
		assertEquals("sap name", "timeout", timeout.getName());
		
		assertEquals("port local id", 0, xpac.getInterfaceItemLocalId(fct));
		assertEquals("port local id", 1, xpac.getInterfaceItemLocalId(sub));
		assertEquals("sap local id", 2, xpac.getInterfaceItemLocalId(timer));
		assertEquals("sap local id", 3, xpac.getInterfaceItemLocalId(timeout));
	}
}
