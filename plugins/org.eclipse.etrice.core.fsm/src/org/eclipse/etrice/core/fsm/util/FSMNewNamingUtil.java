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

package org.eclipse.etrice.core.fsm.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Util providing new names for fsm elements.
 * <br>
 * Bug 502073 - Name conflict from subclass to base
 * 
 * @author Henrik Rentz-Reichert
 * @author Juergen Haug
 */
public class FSMNewNamingUtil {
	
	@Inject
	private FSMHelpers fsmHelpers;

	/**
	 * @param sg
	 *            a {@link StateGraph} serving as name space
	 * @return a unique name (all base and sub classes) for a new model element
	 */
	public String getUniqueName(String prefix, StateGraph sg) {
		Set<String> names = getAllNamesFromCompleteHierarchy(sg);

		for (int i = 0; i < 1000; i++) {
			String name = prefix + i;
			if (!names.contains(name))
				return name;
		}

		return "not_unique";
	}
	
	/**
	 * Returns all names from the complete inheritance hierarchy in the context of <code>sg</code>.
	 * All refined state graphs in the {@link ResourceSet} and <code>sg</code> itself are considered.
	 * @param sg the {@link StateGraph}
	 * @return a complete list of all names used by all refined {@link StateGraph}s in the {@link ResourceSet}.
	 * 
	 * @see #getAllNames(StateGraph)
	 */
	protected Set<String> getAllNamesFromCompleteHierarchy(final StateGraph sg){		
		final HashSet<StateGraph> visitedGraphs = Sets.newHashSet(sg);
		final HashSet<StateGraph> leafGraphs = Sets.newHashSet(sg);
		final LinkedList<StateGraph> stack = Lists.newLinkedList();
		stack.push(sg);

		// fix point iteration to find all stateGraphs that inherit or refine sg
		while (!stack.isEmpty()) {
			StateGraph baseGraph = stack.pop();
			EObject baseContainer = baseGraph.eContainer();
			assert (baseContainer instanceof ModelComponent || baseContainer instanceof State) : "unexpected container for StateGraph";
			Collection<Setting> usages = EcoreUtil.UsageCrossReferencer.find(baseContainer, sg.eResource().getResourceSet());
			for (Setting setting : usages) {
				StateGraph refinedGraph = null;
				if (setting.getEStructuralFeature() == FSMPackage.Literals.MODEL_COMPONENT__BASE)
					refinedGraph = ((ModelComponent) setting.getEObject()).getStateMachine();
				else if (setting.getEStructuralFeature() == FSMPackage.Literals.REFINED_STATE__TARGET)
					refinedGraph = ((RefinedState) setting.getEObject()).getSubgraph();

				if (refinedGraph != null && visitedGraphs.add(refinedGraph)) {
					stack.push(refinedGraph);
					leafGraphs.add(refinedGraph);
					leafGraphs.remove(baseGraph);
				}
			}
		}
		
		// collect all names from leaf graphs recursively.
		HashSet<String> result = Sets.newHashSet();
		for(StateGraph graph : leafGraphs)
			result.addAll(fsmHelpers.getAllNames(graph));
		
		return result;
	}

}
