/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior.tests;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.abstractexec.behavior.AbstractExecutionValidator;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSemantics {

	public enum DiagCode {
		DIAG_CODE_VIOLATION_TRIGGER(
				AbstractExecutionValidator.DIAG_CODE_VIOLATION_TRIGGER, "vt"), DIAG_CODE_VIOLATION_MESSAGESEND(
				AbstractExecutionValidator.DIAG_CODE_VIOLATION_MESSAGESEND,
				"vm"), DIAG_CODE_MISSING_TRIGGER(
				AbstractExecutionValidator.DIAG_CODE_MISSING_TRIGGER, "rm"), DIAG_CODE_MISSING_MESSAGESEND(
				AbstractExecutionValidator.DIAG_CODE_MISSING_MESSAGESEND, "sm");

		public String diagCode, shortCut;

		DiagCode(String diagCode, String shortcut) {
			this.diagCode = diagCode;
			this.shortCut = shortcut;
		}
	}

	String PATTERN = ".*_("
			+ DiagCode.DIAG_CODE_VIOLATION_TRIGGER.shortCut + "|"
			+ DiagCode.DIAG_CODE_VIOLATION_MESSAGESEND.shortCut + "|"
			+ DiagCode.DIAG_CODE_MISSING_MESSAGESEND.shortCut + "|"
			+ DiagCode.DIAG_CODE_MISSING_TRIGGER.shortCut + ")+";

	TestBase basic, cashTerminal, current = null;

	private FSMNameProvider fsmNameProvider = new FSMNameProvider();
	
	@Before
	public void setUp() {
		basic = new TestBase();
		basic.prepare("semantics_basic.room");
		cashTerminal = new TestBase();
		cashTerminal.prepare("cashTerminal.room");

	}

	@Test
	public void test() {
		for (TestBase test : new TestBase[] { basic, cashTerminal }) {
			current = test;

			Set<StateGraphItem> items = current.getStateGraphItems();

			for (DiagCode marker : DiagCode.values())
				if (test.getIssueCode2diagnostic().containsKey(marker.diagCode))
					for (AbstractValidationDiagnostic d : test
							.getIssueCode2diagnostic().get(marker.diagCode))
						if (d instanceof FeatureBasedDiagnostic)
							checkDiagnostic((FeatureBasedDiagnostic) d, marker,
									items);

			for (StateGraphItem item : items) {
				Assert.assertTrue(item + " does not have warnings", !item
						.getName().matches(".*_(vt|vm|rm|sm)+"));
			}
		}

	}

	private void checkDiagnostic(FeatureBasedDiagnostic d, DiagCode marker,
			Set<StateGraphItem> items) {
		EObject container = d.getSourceEObject();
		if (container instanceof StateGraph) {
			Object feature = container.eGet(d.getFeature());
			if (feature instanceof EList) {
				EList<?> list = (EList<?>) feature;
				Object source = list.get(d.getIndex());
				if (source instanceof StateGraphItem) {
					StateGraphItem sgi = (StateGraphItem) source;
					checkItem(sgi.getName(), fsmNameProvider.getName(sgi), marker);
					items.remove(source);
				}
			}
		} else if (container instanceof Trigger) {
			if (container.eContainer() instanceof Transition) {
				Transition transition = (Transition) container.eContainer();
				checkItem(transition.getName(),
						fsmNameProvider.getName(transition),
						marker);
				items.remove(container.eContainer());
			} else
				Assert.fail("unexpected test object: " + container.eContainer());
		} else if (container instanceof Transition) {
			Transition transition = (Transition) container;
			checkItem(transition.getName(),
					fsmNameProvider.getName(transition),
					marker);
			items.remove(container);
		} else if (container instanceof State) {
			State state = (State) container;
			checkItem(state.getName(),
					fsmNameProvider.getName(state),
					marker);
			items.remove(container);
		} else
			Assert.fail("unexpected test object: " + container);
	}

	private void checkItem(String name, String longName, DiagCode diagCode) {
		int begin = name.lastIndexOf("_");
		String errorCodes = "";
		if (begin != -1)
			errorCodes = name.substring(begin);
		if (!errorCodes.contains(diagCode.shortCut)) {
			Assert.assertTrue("Missing warning (" + diagCode.diagCode
					+ ") for item " + longName + " ("
					+ current.getRoomModel().getName() + ")",
					false);
		}
	}
}
