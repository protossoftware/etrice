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

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.abstractexec.behavior.ReachabilityValidator;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestReachability extends TestBase {

	@Before
	public void setUp() {
		prepare("reachability.room");
	}

	@Test
	public void test() {
		if (getRoomModel() == null)
			Assert.fail("could not find model");

		Set<StateGraphItem> items = getStateGraphItems();

		List<AbstractValidationDiagnostic> diagnostics = getIssueCode2diagnostic().get(ReachabilityValidator.DIAG_CODE_UNREACHABLE);
		if (diagnostics!=null) {
			for (AbstractValidationDiagnostic d : diagnostics) {
				if (d instanceof FeatureBasedDiagnostic) {
					FeatureBasedDiagnostic dx = (FeatureBasedDiagnostic) d;
					StateGraph graph = (StateGraph) dx.getSourceEObject();
					Object feature = graph.eGet(dx.getFeature());
					if (feature instanceof EList) {
						EList<?> list = (EList<?>) feature;
						Object source = list.get(dx.getIndex());
						if (source instanceof StateGraphItem) {
							checkUnreachable((StateGraphItem) source);
							items.remove(source);
						} else
							Assert.fail("unexpected test item:" + source);
					}
				}
			}
		}

		for (StateGraphItem item : items) {
			if (item instanceof InitialTransition) {
				if (item.eContainer().eContainer() instanceof ActorClass)
					continue;
				State container = (State) item.eContainer().eContainer();
				Assert.assertTrue(
						item + " is NOT marked Unreachable (or name doesn't end with '_1' ?)",
						container.getName().endsWith("_1"));
			} else
				Assert.assertTrue(
						item + " is NOT marked Unreachable (or name doesn't end with '_1' ?)",
						item.getName().endsWith("_1"));
		}
	}

	private void checkUnreachable(StateGraphItem item) {
		String name = item.getName();
		if (item instanceof RefinedTransition) {
			name = ((RefinedTransition) item).getTarget().getName();
		}
		Assert.assertTrue(
				name + " is incorrectly marked UNreachable (or name doesn't end with '_0' ?)",
				name.endsWith("_0"));
	}
}
