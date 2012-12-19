/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior.tests;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestReachability extends TestBase {

	public static String DIAG_CODE_UNREACHABLE = "etrice.unreachable";

	private RoomModel model = null;

	@Before
	public void setUp() {
		prepare("reachability.room");
		model = getRoomModel();
	}

	@Test
	public void test() {
		if (model == null)
			Assert.fail("could not find model");

		Set<StateGraphItem> items = new HashSet<StateGraphItem>();
		for (ActorClass ac : model.getActorClasses()) {
			if(ac.getStateMachine() == null)
				continue;
			TreeIterator<EObject> iter = ac.getStateMachine().eAllContents();
			while(iter.hasNext()){
				EObject obj = iter.next();
				if(obj instanceof StateGraphItem)
					items.add((StateGraphItem)obj);
			}
		}

		for (AbstractValidationDiagnostic d : getIssueCode2diagnostic().get(
				DIAG_CODE_UNREACHABLE)) {
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

		for (StateGraphItem item : items) {
			if (item instanceof InitialTransition) {
				if(item.eContainer().eContainer() instanceof ActorClass)
					continue;
				State container = (State) item.eContainer().eContainer();
				Assert.assertTrue(item + " is NOT marked Unreachable (or name doesn't end with '_1' ?)",
						container.getName().endsWith("_1"));
			} else
				Assert.assertTrue(item + " is NOT marked Unreachable (or name doesn't end with '_1' ?)", item
						.getName().endsWith("_1"));
		}
	}

	private void checkUnreachable(StateGraphItem item) {
		if (item instanceof InitialTransition) {
			State container = (State) item.eContainer().eContainer();
			Assert.assertTrue(item + " is incorrectly marked UNreachable (or name doesn't end with '_0' ?)",
					container.getName().endsWith("_0"));
		} else
			Assert.assertTrue(item + " is incorrectly marked UNreachable (or name doesn't end with '_0' ?)", item
					.getName().endsWith("_0"));
	}
}
