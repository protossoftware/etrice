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

package org.eclipse.etrice.core.fsm.naming;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ComposedSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.util.BaseSwitch;
import org.eclipse.etrice.core.common.naming.BaseFragmentProvider;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.FSMModel;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.util.FSMSwitch;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMFragmentProvider extends BaseFragmentProvider {

	protected class FSMPathProvider extends FSMSwitch<String> {
		
		public FSMPathProvider() {}

		@Override
		public String caseModelComponent(ModelComponent mc) {
			return mc.getComponentName();
		}
		
		@Override
		public String caseState(State s) {
			// going up two steps in the containment hierarchy either hits another state or a ModelComponent
			return doSwitch(s.eContainer().eContainer())+SEP+s.getName();
		}
		
		@Override
		public String caseTrPoint(TrPoint trp) {
			// going up two steps in the containment hierarchy either hits a state or a ModelComponent
			return doSwitch(trp.eContainer().eContainer())+SEP+trp.getName();
		}
		
		@Override
		public String caseChoicePoint(ChoicePoint cp) {
			// going up two steps in the containment hierarchy either hits a state or a ModelComponent
			return doSwitch(cp.eContainer().eContainer())+SEP+cp.getName();
		}
		
		@Override
		public String caseInitialTransition(InitialTransition t) {
			// going up two steps in the containment hierarchy either hits a state or a ModelComponent
			return doSwitch(t.eContainer().eContainer())+SEP+INIT_TRANS;
		}
		
		@Override
		public String caseNonInitialTransition(NonInitialTransition t) {
			// the transition name is optional in the ROOM DSL but will be automatically assigned
			// by the Behavior Editor
			
			// going up two steps in the containment hierarchy either hits a state or a ModelComponent
			return doSwitch(t.eContainer().eContainer())+SEP+t.getName();
		}
		
		@Override
		public String caseRefinedTransition(RefinedTransition t) {
			// the transition name is optional in the ROOM DSL but will be automatically assigned
			// by the Behavior Editor
			
			// going up two steps in the containment hierarchy either hits a state or a ModelComponent
			return doSwitch(t.eContainer().eContainer())+SEP+t.getTarget().getName();
		}
		
		@Override
		public String caseStateGraph(StateGraph sg) {
			// going up one step in the containment hierarchy either hits a state or a ModelComponent
			return doSwitch(sg.eContainer())+SEP+STATE_GRAPH;
		}
	}
	
	protected class BasePathProvider extends BaseSwitch<String> {
		public BasePathProvider() {}

		/* (non-Javadoc)
		 * @see org.eclipse.etrice.core.common.base.util.BaseSwitch#caseAnnotationType(org.eclipse.etrice.core.common.base.AnnotationType)
		 */
		@Override
		public String caseAnnotationType(AnnotationType object) {
			return object.getName();
		}
	}
	
	private class CombinedPathProvider extends ComposedSwitch<String> {
		public CombinedPathProvider() {
			this.addSwitch(new BasePathProvider());
			this.addSwitch(new FSMPathProvider());
		}
	}

	protected static final char TYPE_SEP = ':';
	protected static final char SEP = '$';
	private static final String INIT_TRANS = "initial";
	private static final String STATE_GRAPH = "sg";
	
	private CombinedPathProvider fsmPathProvider = new CombinedPathProvider();
	
	@Override
	public String getFragment(EObject obj, Fallback fallback) {
		String path = fsmPathProvider.doSwitch(obj);
		if (path!=null)
			return obj.eClass().getName()+TYPE_SEP+path;
		
		return fallback.getFragment(obj);
	}

	@Override
	public EObject getEObject(Resource resource, String fragment,
			Fallback fallback) {

		if (!resource.getContents().isEmpty()) {
			FSMModel model = (FSMModel) resource.getContents().get(0);
			EObject result = getEObject(model, fragment);
			if (result!=null)
				return result;
		}
		
		return fallback.getEObject(fragment);
	}

	private EObject getEObject(FSMModel model, String fragment) {
		int begin = 0;
		int end = fragment.indexOf(TYPE_SEP);
		if (end<0)
			return null;
		String type = fragment.substring(begin, end);

		begin = end+1;
		end = fragment.indexOf(SEP, begin);
		if (end<0)
			end = fragment.length();
		String className = fragment.substring(begin, end);
		
		ModelComponent mc = getModelComponent(model, className);
		if (type.equals(FSMPackage.eINSTANCE.getModelComponent().getName())) {
			return mc;
		}
		
		if (end<fragment.length()) {
			String remainder = fragment.substring(end+1, fragment.length());
			
			if (type.equals("BaseState")
					|| type.equals(FSMPackage.eINSTANCE.getSimpleState().getName())
					|| type.equals(FSMPackage.eINSTANCE.getRefinedState().getName())) {
				return getState(mc, remainder);
			}
			else if (type.equals(FSMPackage.eINSTANCE.getTransitionPoint().getName())
					|| type.equals(FSMPackage.eINSTANCE.getEntryPoint().getName())
					|| type.equals(FSMPackage.eINSTANCE.getExitPoint().getName())) {
				return getTrPoint(mc, remainder);
			}
			else if (type.equals(FSMPackage.eINSTANCE.getChoicePoint().getName())) {
				return getChoicePoint(mc, remainder);
			}
			else if (type.equals(FSMPackage.eINSTANCE.getInitialTransition().getName())) {
				return getInitialTransition(mc, remainder);
			}
			else if (type.equals(FSMPackage.eINSTANCE.getRefinedTransition().getName())) {
				return getRefinedTransition(mc, remainder);
			}
			else if (type.equals(FSMPackage.eINSTANCE.getContinuationTransition().getName())
					|| type.equals(FSMPackage.eINSTANCE.getCPBranchTransition().getName())
					|| type.equals(FSMPackage.eINSTANCE.getTriggeredTransition().getName())
					|| type.equals(FSMPackage.eINSTANCE.getGuardedTransition().getName())) {
				return getTransition(mc, remainder);
			}
			else if (type.equals(FSMPackage.eINSTANCE.getStateGraph().getName())
					|| type.equals("StateMachine")) {
				return getStateGraph(mc, remainder);
			}
		}
		
		return null;
	}

	public static boolean isState(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith("BaseState"))
				return true;
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getSimpleState().getName()))
				return true;
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getRefinedState().getName()))
				return true;
		}
		return false;
	}

	public static boolean isTrPoint(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getTransitionPoint().getName()))
				return true;
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getEntryPoint().getName()))
				return true;
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getExitPoint().getName()))
				return true;
		}
		return false;
	}

	public static boolean isChoicePoint(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(FSMPackage.eINSTANCE.getChoicePoint().getName());
	}

	public static boolean isStateGraph(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(FSMPackage.eINSTANCE.getStateGraph().getName());
	}

	public static boolean isTransition(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getInitialTransition().getName()))
				return true;
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getContinuationTransition().getName()))
				return true;
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getCPBranchTransition().getName()))
				return true;
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getTriggeredTransition().getName()))
				return true;
			if (uri.fragment().startsWith(FSMPackage.eINSTANCE.getRefinedTransition().getName()))
				return true;
		}
		return false;
	}
	
	private ModelComponent getModelComponent(FSMModel model, String className) {
		for (ModelComponent dc : model.getComponents()) {
			if (dc.getComponentName() != null && dc.getComponentName().equals(className))
				return dc;
		}
		return null;
	}
	
	protected Transition getTransition(ModelComponent mc, String remainder) {
		StateGraph sg = getStateGraph(mc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (Transition t : sg.getTransitions()) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
	
		return null;
	}

	protected InitialTransition getInitialTransition(ModelComponent mc, String remainder) {
		StateGraph sg = getStateGraph(mc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		if (name.equals(INIT_TRANS)) {
			for (Transition t : sg.getTransitions()) {
				if (t instanceof InitialTransition)
					return (InitialTransition) t;
			}
		}
		
		return null;
	}

	protected RefinedTransition getRefinedTransition(ModelComponent mc, String remainder) {
		StateGraph sg = getStateGraph(mc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (RefinedTransition t : sg.getRefinedTransitions()) {
			if (t.getTarget().getName().equals(name))
				return t;
		}
		
		return null;
	}

	protected ChoicePoint getChoicePoint(ModelComponent mc, String remainder) {
		StateGraph sg = getStateGraph(mc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (ChoicePoint cp : sg.getChPoints()) {
			if (cp.getName().equals(name)) {
				return cp;
			}
		}
	
		return null;
	}

	protected TrPoint getTrPoint(ModelComponent mc, String remainder) {
		StateGraph sg = getStateGraph(mc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (TrPoint tp : sg.getTrPoints()) {
			if (tp.getName().equals(name)) {
				return tp;
			}
		}
	
		return null;
	}

	protected State getState(ModelComponent mc, String remainder) {
		StateGraph sg = getStateGraph(mc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (State s : sg.getStates()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
	
		return null;
	}

	protected StateGraph getStateGraph(ModelComponent mc, String remainder) {
		StateGraph sg = mc.getStateMachine();
		if (sg==null) {
			mc.setStateMachine(FSMFactory.eINSTANCE.createStateGraph());
			sg = mc.getStateMachine();
		}
		int begin = 0;
		int end = remainder.indexOf(SEP);
		while (end>=0) {
			String name = remainder.substring(begin, end);
			boolean found = false;
			for (State s : sg.getStates()) {
				if (s.getName().equals(name)) {
					sg = s.getSubgraph();
					found = true;
					break;
				}
			}
			if (!found)
				return null;
			
			begin = end+1;
			end = remainder.indexOf(SEP, begin);
		}
		
		return sg;
	}
}
