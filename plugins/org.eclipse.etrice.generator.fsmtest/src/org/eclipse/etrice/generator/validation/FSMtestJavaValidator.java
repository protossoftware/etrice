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

package org.eclipse.etrice.generator.validation;

import org.eclipse.etrice.generator.fsmtest.FsmDefinition;
import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.StateDeclaration;
import org.eclipse.etrice.generator.fsmtest.TransitionDeclaration;
import org.eclipse.xtext.validation.Check;
 

public class FSMtestJavaValidator extends AbstractFSMtestJavaValidator {


	@Check
	public void CheckStateDeclaration(StateDeclaration s) {
		FsmDefinition f = (FsmDefinition) s.eContainer();
		for (StateDeclaration s1:f.getStates()) {
			if (s1 != s && s1.getName().equals(s.getName()))
				error("State names must be unique", FsmtestPackage.Literals.STATE_DECLARATION__NAME);
		}
		if (f.getStates().size()>1) {
			boolean found = false;
			for (TransitionDeclaration t1:s.getTransitions()) {
				if (t1.getDestination() != s)
					found = true;
			}
			if (!found)
				error("you cannot leave this state", FsmtestPackage.Literals.STATE_DECLARATION__NAME);
		}
		for (StateDeclaration s1:f.getStates()) {
			for (TransitionDeclaration t1:s1.getTransitions()) {
				if (t1.getDestination() == s && s1!=s)
					return;
	}
		}		
		if (f.getStates().indexOf(s) != 0)
			error("State cannot be reached", FsmtestPackage.Literals.STATE_DECLARATION__NAME);
	}

	@Check
	public void CheckTransitionDeclaration(TransitionDeclaration t) {
		FsmDefinition f = (FsmDefinition) t.eContainer().eContainer();
		for (StateDeclaration s1:f.getStates()) {
			for (TransitionDeclaration t1:s1.getTransitions()) {
				if (t1 != t && t1.getName().equals(t.getName()))
					error("Transition names must be unique", FsmtestPackage.Literals.TRANSITION_DECLARATION__NAME);
			}
		}
	}

}
