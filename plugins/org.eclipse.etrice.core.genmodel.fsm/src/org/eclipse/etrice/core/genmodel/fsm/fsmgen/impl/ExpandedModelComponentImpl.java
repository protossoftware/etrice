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
package org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.ExitPoint;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenFactory;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expanded Actor Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#getModelComponent <em>Model Component</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl#getTransitionChains <em>Transition Chains</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpandedModelComponentImpl extends MinimalEObjectImpl.Container implements ExpandedModelComponent {
	
	/**
	 * The cached value of the '{@link #getModelComponent() <em>Model Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelComponent()
	 * @generated
	 * @ordered
	 */
	protected ModelComponent modelComponent;

	private static class NodeData {
		private LinkedList<Transition> inTrans = new LinkedList<Transition>();
		private LinkedList<Transition> outTrans = new LinkedList<Transition>();
		private LinkedList<Transition> loopTrans = null;

		LinkedList<Transition> getInTrans() {
			return inTrans;
		}

		LinkedList<Transition> getOutTrans() {
			return outTrans;
		}

		LinkedList<Transition> getLoopTransitions() {
			if (loopTrans==null) {
				loopTrans = new LinkedList<Transition>();
				for (Transition t : getOutTrans()) {
					// outgoing transitions always are NonInitialTransitions
					NonInitialTransition tr = (NonInitialTransition) t;
					
					if (tr.getFrom() instanceof StateTerminal) {
						if (tr.getTo() instanceof StateTerminal) {
							if (((StateTerminal)tr.getFrom()).getState() == ((StateTerminal)tr.getTo()).getState())
								loopTrans.add(tr);
						}
					}
					else if (tr.getFrom() instanceof TrPointTerminal) {
						if (tr.getTo() instanceof TrPointTerminal) {
							if (((TrPointTerminal)tr.getFrom()).getTrPoint() == ((TrPointTerminal)tr.getTo()).getTrPoint())
								loopTrans.add(tr);
						}
					}
				}
			}
			return loopTrans;
		}
	}

	/**
	 * transition chains may merge in a choice point or in an entry or exit point.
	 * We call all merged transition chains a transition chain bundle
	 *
	 */
	protected static class TransitionChainBundle {
		private BasicEList<TransitionChain> chains = new BasicEList<TransitionChain>();
		private EObject commonData = null;
	}
	
	protected class TransitionToChainBundleMap extends HashMap<Transition, TransitionChainBundle> {
		private static final long serialVersionUID = 1L;

		void put(Transition t, TransitionChain tc) {
			TransitionChainBundle tcb = get(t);
			if (tcb==null) {
				tcb = new TransitionChainBundle();
				put(t, tcb);
			}
			tcb.chains.add(tc);
		}
		
		/* (non-Javadoc)
		 * @see java.util.AbstractMap#toString()
		 */
//		@Override
//		public String toString() {
//			StringBuffer result = new StringBuffer();
//			for (java.util.Map.Entry<Transition, TransitionChainBundle> entry : entrySet()) {
//				result.append("transition "+fsmNameProvider.getFullPath(entry.getKey())+":\n");
//				TransitionChainBundle bundle = entry.getValue();
//				for (TransitionChain tc : bundle.chains) {
//					String data = tc.getData()!=null? " with data "+tc.getData().getRefType().getType().getName() : "";
//					result.append("  chain starting at "+fsmNameProvider.getFullPath(tc.getTransition())+data+"\n");
//				}
//				String data = bundle.commonData!=null? bundle.commonData.getRefType().getType().getName() : "-";
//				result.append("  bundle data "+data+"\n");
//			}
//			return result.toString();
//		}
	}
	
	/**
	 * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine()
	 * @generated
	 * @ordered
	 */
	protected StateGraph stateMachine;

	/**
	 * The cached value of the '{@link #getTransitionChains() <em>Transition Chains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionChains()
	 * @generated
	 * @ordered
	 */
	protected EList<TransitionChain> transitionChains;

	private static final String TRIGGER_SEP = "#";
	
	private IDiagnostician validator;

	private boolean prepared = false;
	private HashSet<StateGraphItem> ownObjects = null;
	private HashSet<Transition> targetsOfRefinedTransitions = null;
    private HashSet<Transition> baseTransitionHasDetailCode = null;
	private HashMap<AbstractInterfaceItem, Integer> ifitem2localId = null;
	private HashMap<StateGraphNode, NodeData> node2data = null;
	private HashMap<State, LinkedList<ActiveTrigger>> state2triggers = null;
	private HashMap<String, MessageFromIf> triggerstring2mif = null;
	private LinkedList<TransitionChain> trchains = null;
	private TransitionToChainBundleMap trans2chainBundle = null;
	private HashMap<EObject, EObject> copy2orig = null;
	
	private FSMHelpers fsmHelpers = new FSMHelpers();
	protected FSMNameProvider fsmNameProvider = new FSMNameProvider();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpandedModelComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmGenPackage.Literals.EXPANDED_MODEL_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelComponent getModelComponent() {
		if (modelComponent != null && modelComponent.eIsProxy()) {
			InternalEObject oldModelComponent = (InternalEObject)modelComponent;
			modelComponent = (ModelComponent)eResolveProxy(oldModelComponent);
			if (modelComponent != oldModelComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmGenPackage.EXPANDED_MODEL_COMPONENT__MODEL_COMPONENT, oldModelComponent, modelComponent));
			}
		}
		return modelComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelComponent basicGetModelComponent() {
		return modelComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelComponent(ModelComponent newModelComponent) {
		ModelComponent oldModelComponent = modelComponent;
		modelComponent = newModelComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.EXPANDED_MODEL_COMPONENT__MODEL_COMPONENT, oldModelComponent, modelComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateGraph getStateMachine() {
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateMachine(StateGraph newStateMachine, NotificationChain msgs) {
		StateGraph oldStateMachine = stateMachine;
		stateMachine = newStateMachine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmGenPackage.EXPANDED_MODEL_COMPONENT__STATE_MACHINE, oldStateMachine, newStateMachine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateMachine(StateGraph newStateMachine) {
		if (newStateMachine != stateMachine) {
			NotificationChain msgs = null;
			if (stateMachine != null)
				msgs = ((InternalEObject)stateMachine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmGenPackage.EXPANDED_MODEL_COMPONENT__STATE_MACHINE, null, msgs);
			if (newStateMachine != null)
				msgs = ((InternalEObject)newStateMachine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmGenPackage.EXPANDED_MODEL_COMPONENT__STATE_MACHINE, null, msgs);
			msgs = basicSetStateMachine(newStateMachine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.EXPANDED_MODEL_COMPONENT__STATE_MACHINE, newStateMachine, newStateMachine));
	}

	protected void validationError(String msg, EObject obj, EStructuralFeature feature) {
		validationError(msg, obj, feature, IDiagnostician.INSIGNIFICANT_INDEX);
	}
	
	protected void validationError(String msg, EObject obj, EStructuralFeature feature, int idx) {
//		assert obj.eResource() != null : "val error in artificial model object";
		if (obj.eResource()==null) {
			obj = copy2orig.get(obj);
		}
		validator.error(msg, obj, feature, idx);
	}
	
	private void buildStateGraph() {
		// create a list of state machines, derived first, base last
		ArrayList<StateGraph> stateMachines = new ArrayList<StateGraph>();
		ModelComponent orig = getModelComponent();
		if (orig.getStateMachine()!=null)
			stateMachines.add(orig.getStateMachine());
		while (orig.getBase()!=null) {
			orig = orig.getBase();
			if (orig.getStateMachine()!=null)
				stateMachines.add(orig.getStateMachine());
		}
		
		Collection<StateGraph> copiedStateMachines = createCopyOfStateMachines(stateMachines);
		
		collectContentsInNewStateMachine(copiedStateMachines);
		
		introduceExpandedRefinedStates(getStateMachine());
	}

	private void collectContentsInNewStateMachine(Collection<StateGraph> copiedStateMachines) {
		// move all state machine contents to our state machine (which we create newly)
		StateGraph myStateMachine = FSMFactory.eINSTANCE.createStateGraph();
		setStateMachine(myStateMachine);

		HashMap<Transition, DetailCode> trans2refinedAction = new HashMap<Transition, DetailCode>();
		for (StateGraph copiedStateMachine : copiedStateMachines) {
			myStateMachine.getChPoints().addAll(copiedStateMachine.getChPoints());
			myStateMachine.getStates().addAll(copiedStateMachine.getStates());
			myStateMachine.getTrPoints().addAll(copiedStateMachine.getTrPoints());
			myStateMachine.getTransitions().addAll(copiedStateMachine.getTransitions());
			
			// collect the refined action code in a hash map
			for (RefinedTransition rt : copiedStateMachine.getRefinedTransitions()) {
				if (rt.getAction()==null || rt.getAction().getLines().isEmpty())
					continue;
				
				DetailCode code = trans2refinedAction.get(rt.getTarget());
				if (code==null) {
					code = FSMFactory.eINSTANCE.createDetailCode();
					trans2refinedAction.put(rt.getTarget(), code);
				}
				
				code.getLines().addAll(0, rt.getAction().getLines());
				code.setUsed(fsmHelpers.hasDetailCode(code));
			}
		}
		
		// for refined transitions we just append the action code to the target
		// we can do this since the target is a copy just for this class
		for (Entry<Transition, DetailCode> entry : trans2refinedAction.entrySet()) {
			ownObjects.add(entry.getKey());
			targetsOfRefinedTransitions.add(entry.getKey());
			if (entry.getKey().getAction()==null) {
			    entry.getKey().setAction(entry.getValue());
			}
			else {
			    baseTransitionHasDetailCode.add(entry.getKey());
			    entry.getKey().getAction().getLines().addAll(entry.getValue().getLines());
			}
		}
	}

	private Collection<StateGraph> createCopyOfStateMachines(List<StateGraph> origStateMachines) {
		// create a self contained copy of all actor classes
		// references to interface items (ports, saps and spps) point to contents of the original actor class
		// Collection<StateGraph> all = EcoreUtil.copyAll(sms);
		// we use the copier directly since we need access to the map
		Copier copier = new Copier();
	    Collection<StateGraph> copiedStateMachines = copier.copyAll(origStateMachines);
	    copier.copyReferences();
	    for (EObject o : copier.keySet()) {
			EObject c = copier.get(o);
			copy2orig.put(c, o);
		}
		
	    if (getModelComponent().getStateMachine()!=null) {
	    	// first state machine is ours
	    	StateGraph self = copiedStateMachines.iterator().next();
	    	
	    	// flag own objects
			TreeIterator<EObject> it = self.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if (obj instanceof StateGraphItem)
					addOwnObject((StateGraphItem)obj);
			}
	    }
		return copiedStateMachines;
	}

	/**
	 * replace refined state with a ExpandedRefinedState but as replacement of the ultimate SimpleState
	 * the refined state is targeting
	 * 
	 * @param sg - the current context (will be called recursively)
	 */
	private void introduceExpandedRefinedStates(StateGraph sg) {
		// need to make a copy of the list because we will modify the original list
		ArrayList<State> states = new ArrayList<State>(sg.getStates());
		for (State s : states) {
			if (s instanceof RefinedState) {
				RefinedState rs = (RefinedState) s;
				
				ExpandedRefinedState state = FsmGenFactory.eINSTANCE.createExpandedRefinedState();
				state.init(rs);
				copy2orig.put(state, getOrig(rs));
				if (isOwnObject(rs))
					addOwnObject(state);
			}
		}
		
		// recurse down into sub graph
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				introduceExpandedRefinedStates(s.getSubgraph());
		}
	}
	
	private void addOutgoingTransition(StateGraphNode node, Transition t) {
		NodeData data = node2data.get(node);
		if (data==null) {
			data = new NodeData();
			node2data.put(node, data);
		}
		data.getOutTrans().add(t);
	}
	
	private void addIncomingTransition(StateGraphNode node, Transition t) {
		NodeData data = node2data.get(node);
		if (data==null) {
			data = new NodeData();
			node2data.put(node, data);
		}
		data.getInTrans().add(t);
	}
	
	private void findOutgoingTransitions(StateGraph sg) {
		// depth first: recurse into sub graphs of states
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				findOutgoingTransitions(s.getSubgraph());
		}

		for (Transition t : sg.getTransitions()) {
			addIncomingTransition(getAdjustedTargetNode(t), t);
			if (t instanceof NonInitialTransition) {
				addOutgoingTransition(fsmHelpers.getNode(((NonInitialTransition)t).getFrom()), t);
			}
		}
	}

	/**
	 * @param sg
	 */
	private void checkTransitionChains(StateGraph sg) {
		for (Transition t : sg.getTransitions()) {
			TransitionChain chain = getChain(t);
			if (chain==null)
				if (!getModelComponent().isAbstract()) {
					int idx = sg.getTransitions().indexOf(t);
					Transition orig = (Transition) copy2orig.get(t);
					String name = fsmNameProvider.getName(orig);
					validator.error("transition '"+name+"' is not part of a transition chain (only allowed for abstract actor classes)", orig.eContainer(), FSMPackage.eINSTANCE.getStateGraph_Transitions(), idx);
				}
		}
		
		// recursion
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				checkTransitionChains(s.getSubgraph());
		}
	}
	
	private void doChecks(StateGraph sg) {
		
		// check if empty
		if (sg.getTransitions().isEmpty() && sg.getStates().isEmpty()
				&& sg.getChPoints().isEmpty() && sg.getTrPoints().isEmpty())
			return;
		
		int initCount = 0;
		for (Transition t : sg.getTransitions()) {
			if (t instanceof InitialTransition)
				++initCount;
		}
		if (initCount==0) {
			if (sg.eContainer() instanceof State) {
				if (!getModelComponent().isAbstract()) {
					// having no initial transition in a nested state is valid only if there is no transition to history
					// except of self transitions
					// i.e. no incoming transition of the state itself
					NodeData data = node2data.get((State)sg.eContainer());
					if (data!=null && data.getLoopTransitions().size()!=data.getInTrans().size())
						validationError(getModelComponentName()+": Having no initial transition in a nested state is valid only if there is no transition to history except of self transitions!",
								sg.eContainer(), FSMPackage.eINSTANCE.getState_Subgraph());
				}
			}
			else {
				validationError(getModelComponentName()+": The TOP level has to have an initial transition!", getModelComponent().getStateMachine(), FSMPackage.eINSTANCE.getStateGraph_Transitions());
			}
		}
		else {
			if (initCount>1)
				validationError(getModelComponentName()+": There has to be exactly one initial transition!", getModelComponent().getStateMachine(), FSMPackage.eINSTANCE.getStateGraph_Transitions());
		}
		
		for (ChoicePoint cp : sg.getChPoints()) {
			NodeData data = node2data.get(cp);
			
			ChoicePoint orig = (ChoicePoint) copy2orig.get(cp);
			StateGraph origContainer = (StateGraph) orig.eContainer();
			int idx = origContainer.getChPoints().indexOf(orig);
			
			if (data==null) {
				validationError(getModelComponentName()+": ChoicePoint is not connected!", origContainer, FSMPackage.eINSTANCE.getStateGraph_ChPoints(), idx);
			}
			else {
				// several incoming transitions possible, see bug 340496
//				if (data.getInTrans().size()!=1)
//					validationError(getModelComponentName()+": ChoicePoint has "+data.getInTrans().size()+" incoming transitions!", sg, FSMPackage.eINSTANCE.getStateGraph_ChPoints(), idx);
				if (data.getOutTrans().size()<2)
					validationError(getModelComponentName()+": ChoicePoint should have 2 or more branches but has "+data.getOutTrans().size(), origContainer, FSMPackage.eINSTANCE.getStateGraph_ChPoints(), idx);
				if (getDefaultBranch(data.getOutTrans())==null)
					validationError(getModelComponentName()+": ChoicePoint has no default branch!", origContainer, FSMPackage.eINSTANCE.getStateGraph_ChPoints(), idx);
				if (!data.getLoopTransitions().isEmpty())
					validationError(getModelComponentName()+": ChoicePoint is connected to itself!", origContainer, FSMPackage.eINSTANCE.getStateGraph_ChPoints(), idx);
			}
		}
		
		for (TrPoint tp : sg.getTrPoints()) {
			NodeData data = node2data.get(tp);
			
			TrPoint orig = (TrPoint) copy2orig.get(tp);
			StateGraph origContainer = (StateGraph) orig.eContainer();
			int idx = origContainer.getTrPoints().indexOf(orig);
			
			if (data==null) {
				if (!getModelComponent(tp).isAbstract())
					validationError(getModelComponentName()+": TrPoint "+fsmNameProvider.getFullPath(tp)+" is not connected", origContainer, FSMPackage.eINSTANCE.getStateGraph_TrPoints(), idx);
			}
			else {
				if ((tp instanceof EntryPoint)||(tp instanceof ExitPoint)) {
					// non-abstract classes must have incoming transitions for entry and exit points
					if (!getModelComponent().isAbstract() && data.getInTrans().isEmpty())
						validationError(getModelComponentName()+": TrPoint "+fsmNameProvider.getFullPath(tp)+" has no incoming transition!", origContainer, FSMPackage.eINSTANCE.getStateGraph_TrPoints(), idx);
					
					if (getModelComponent(tp).isAbstract()) {
						// transition points inherited from abstract base classes
						// (of from abstract classes themselves) must not have more than one outgoing transition
						if (data.getOutTrans().size()>1)
							validationError(getModelComponentName()+": TrPoint "+fsmNameProvider.getFullPath(tp)+" must have at most one outgoing transition!", origContainer, FSMPackage.eINSTANCE.getStateGraph_TrPoints(), idx);
					}
					else {
						// non-abstract or non-inherited transition points must have one outgoing transition
						if (data.getOutTrans().size()!=1)
							validationError(getModelComponentName()+": TrPoint "+fsmNameProvider.getFullPath(tp)+" must have exactly one outgoing transition!", origContainer, FSMPackage.eINSTANCE.getStateGraph_TrPoints(), idx);
					}
					
					if (!data.getLoopTransitions().isEmpty())
						validationError(getModelComponentName()+": TrPoint "+fsmNameProvider.getFullPath(tp)+" must have no self transitions!", origContainer, FSMPackage.eINSTANCE.getStateGraph_TrPoints(), idx);
				}
				else if (tp instanceof TransitionPoint) {
					if (data.getOutTrans().size()<data.getLoopTransitions().size())
						validationError(getModelComponentName()+": TrPoint "+fsmNameProvider.getFullPath(tp)+" must have no incoming transitions!", origContainer, FSMPackage.eINSTANCE.getStateGraph_TrPoints(), idx);
				}
			}
		}
		
		// recurse into sub graphs of states
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				doChecks(s.getSubgraph());
		}
	}
	
	private void findTriggersOfState(State s) {
		LinkedList<ActiveTrigger> triggers = new LinkedList<ActiveTrigger>();
		HashMap<String, ActiveTrigger> caughtTriggers = new HashMap<String, ActiveTrigger>();
		collectTriggersAndTransitions(s, caughtTriggers, triggers);
		state2triggers.put(s, triggers);
	}
	
	private String getTriggerString(MessageFromIf mifp) {
		assert(mifp.getFrom().getName()!=null) : "ifitem name must not be null";
		assert(fsmNameProvider.getMessageName(mifp.getMessage())!=null) : "message name must not be null";
		return mifp.getFrom().getName()+TRIGGER_SEP+fsmNameProvider.getMessageName(mifp.getMessage());
	}

	private void collectOutgoingTransitions(EList<Transition> sameLevelTransitions,
			HashMap<String, ActiveTrigger> caughtTriggers,
			LinkedList<ActiveTrigger> triggers) {
		for (Transition t : sameLevelTransitions) {
			if (t instanceof TriggeredTransition) {
				TriggeredTransition tt = (TriggeredTransition) t;
				
				for (Trigger trig : ((TriggeredTransition)t).getTriggers()) {
					for (MessageFromIf mifp : trig.getMsgFromIfPairs()) {
						String tr = getTriggerString(mifp);
						ActiveTrigger at = caughtTriggers.get(tr);
						/*
						 * accept new trigger if
						 * 
						 *  - no inner or inner with guard
						 *  - accept several but only one without guard (count),
						 *    insert those with guard first in the list of the _same_ level(!)
						 */
						if (at==null) {
							// no inner transition with this trigger exists,
							// so this is a new trigger (and our unique point of ActiveTrigger creation)
							at = FsmGenFactory.eINSTANCE.createActiveTrigger();
							at.setMsg(mifp.getMessage());
							at.setIfitem(mifp.getFrom());
							at.setTrigger(tr);
							at.getTransitions().add(tt);
							caughtTriggers.put(tr, at);
							triggers.add(at);
						}
						else {
							// check guards of previous transitions
							TriggeredTransition unguarded = null;
							boolean accepted = true;
							for (TriggeredTransition t2 : at.getTransitions()) {
								for (Trigger trig2 : t2.getTriggers()) {
									if (isMatching(trig2, tr)) {
										if (!fsmHelpers.isGuarded(trig2)) {
											unguarded = t2;
											if (!sameLevelTransitions.contains(t2))
												accepted = false;
										}
									}
								}
							}
							if (accepted) {
								if (unguarded!=null) {
									// there already is an unguarded transition: require a quard
									if (!fsmHelpers.isGuarded(trig)) {
										validationError("Transitions with same trigger on same level have to be guarded!", t, FSMPackage.eINSTANCE.getTriggeredTransition_Triggers());
									}
									else {
										int idx = at.getTransitions().indexOf(unguarded);
										at.getTransitions().add(idx, tt);
									}
								}
								else {
									// just add at the end
									at.getTransitions().add(tt);
								}
							}
							// else: this trigger is already satisfied - nevertheless this is a valid situation
						}
					}
				}
			}
		}
	}

	private void collectTriggersAndTransitions(State s,
			HashMap<String, ActiveTrigger> caughtTriggers,
			LinkedList<ActiveTrigger> triggers) {
		// consider outgoing transitions of this state
		collectOutgoingTransitions(getOutgoingTransitions(s), caughtTriggers, triggers);
		
		// consider TransitionPoint transitions
		if (s.eContainer() instanceof StateGraph) {
			StateGraph sg = (StateGraph) s.eContainer();
			BasicEList<Transition> trpTransitions = new BasicEList<Transition>();
			for (TrPoint tp : sg.getTrPoints()) {
				trpTransitions.addAll(getOutgoingTransitions(tp));
			}
			collectOutgoingTransitions(trpTransitions, caughtTriggers, triggers);
			
			// go to surrounding context
			if (sg.eContainer() instanceof State) {
				collectTriggersAndTransitions((State) sg.eContainer(), caughtTriggers, triggers);
			}
		}
		else {
			// this should never happen
			assert(false): "A State must always reside in a StateGraph!";
		}
	}

	private void findLeafStateTriggers(StateGraph sg) {
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				findLeafStateTriggers(s.getSubgraph());
			else
				findTriggersOfState(s);
		}
	}

	private void fillTriggerStringMap() {
		// improve performance using maps name2ifitem and name2msgs
		HashMap<String, AbstractInterfaceItem> name2ifitem = new HashMap<String, AbstractInterfaceItem>();
		HashMap<String, List<EObject>> name2msgs = new HashMap<String, List<EObject>>();
		List<AbstractInterfaceItem> items = getAllInterfaceItems();
		for (AbstractInterfaceItem item : items) {
			name2ifitem.put(item.getName(), item);
			name2msgs.put(item.getName(), getIncomingMessages(item));      								
		}
		
		// compute a set of all trigger strings
		HashSet<String> triggers = new HashSet<String>();
		for (LinkedList<ActiveTrigger> ttlist : state2triggers.values()) {
			for (ActiveTrigger tt : ttlist) {
				triggers.add(tt.getTrigger());
			}
		}
		
		// now fill triggerstring2mif
		for (String trig : triggers) {
			String[] parts = trig.split(TRIGGER_SEP);
			
			// this should always hold true
			assert(parts.length==2): "By our convention triggers are composed of two parts separated by "
				+TRIGGER_SEP+". Here we have '"+trig+"' which doesn't consist of two parts!";
			
			AbstractInterfaceItem ii = name2ifitem.get(parts[0]);
			
			// this should always hold true
			assert(ii!=null): "The name '"+parts[0]+"' did not match an interface item (in name2ifitem)!";

			List<EObject> msgs = name2msgs.get(parts[0]);
			
			// this should always hold true
			assert(msgs!=null): "The name '"+parts[0]+"' did not match an interface item (in name2msgs)!";

			EObject msg = null;
			for (EObject m : msgs) {
				if (fsmNameProvider.getMessageName(m).equals(parts[1]))
					msg  = m;
			}
			
			// this should always hold true
			assert(msg!=null): "The message '"+parts[1]+"' did not match a message!";
			
			MessageFromIf mif = FSMFactory.eINSTANCE.createMessageFromIf();
			mif.setFrom(ii);
			mif.setMessage(msg);
			triggerstring2mif.put(trig, mif);
		}
	}

	private void collectChainTransitions(TransitionChain tc, Transition t) {
		trans2chainBundle.put(t, tc);
		
		StateGraphNode node = fsmHelpers.getNode(t.getTo());
		
		// the chain ends if a state is reached
		if (node instanceof State)
			return;
		
		// the chain ends if source and destination coincide
		if (tc.getTransition() instanceof NonInitialTransition && node==fsmHelpers.getNode(((NonInitialTransition)tc.getTransition()).getFrom()))
			return;
		
		for (Transition next : getOutgoingTransitions(node)) {
			// from the second transition in the chain on we have:
			if (next instanceof TriggeredTransition) {
				TriggeredTransition orig = (TriggeredTransition)copy2orig.get(next);
				StateGraph origContainer = (StateGraph) orig.eContainer();
				int idx = origContainer.getTransitions().indexOf(orig);
				validationError("Segments following the triggering transition can have no triggers!\n", origContainer, FSMPackage.eINSTANCE.getStateGraph_Transitions(), idx);
			}
			
			collectChainTransitions(tc, next);
		}
	}

	private void findTransitionChains(StateGraph sg, Class<?> cls) {
		findTransitionChains(sg, cls, true);
	}
	
	private void findTransitionChains(StateGraph sg, Class<?> cls, boolean includeInitial) {
		for (Transition t : sg.getTransitions()) {
			if (cls.isInstance(t) || (includeInitial && (t instanceof InitialTransition))) {
				addTransitionChain(t);
			}
		}
		
		// recurse into sub graphs of states
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				findTransitionChains(s.getSubgraph(), cls, includeInitial);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void prepare(IDiagnostician validator) {
		if (prepared)
			return;
		
		prepared = true;
		
		this.validator = validator;
		
		ifitem2localId = new HashMap<AbstractInterfaceItem, Integer>();
		ownObjects = new HashSet<StateGraphItem>();
		targetsOfRefinedTransitions = new HashSet<Transition>();
        baseTransitionHasDetailCode = new HashSet<Transition>();
		node2data = new HashMap<StateGraphNode, NodeData>();
		state2triggers = new HashMap<State, LinkedList<ActiveTrigger>>();
		triggerstring2mif = new HashMap<String, MessageFromIf>();
		trchains = new LinkedList<TransitionChain>();
		trans2chainBundle = new TransitionToChainBundleMap();
		copy2orig = new HashMap<EObject, EObject>();
		
		buildStateGraph();
		computeInterfaceItemLocalIds(getModelComponent(), 0);
		findOutgoingTransitions(getStateMachine());

		doChecks(getStateMachine());
		if (validator.isFailed())
			return;
		
		if (getModelComponent().getCommType()==ComponentCommunicationType.DATA_DRIVEN) {
			findTransitionChains(getStateMachine(), GuardedTransition.class);
		}
		else if (getModelComponent().getCommType()==ComponentCommunicationType.ASYNCHRONOUS) {
			findLeafStateTriggers(getStateMachine());
			fillTriggerStringMap();
			findTransitionChains(getStateMachine(), TriggeredTransition.class);
			computeCommonChainData();
			findTransitionChains(getStateMachine(), GuardedTransition.class, false);
			checkTransitionChains(getStateMachine());
		}
		else {
			// event driven state machine
			findLeafStateTriggers(getStateMachine());
			fillTriggerStringMap();
			findTransitionChains(getStateMachine(), TriggeredTransition.class);
			computeCommonChainData();
			checkTransitionChains(getStateMachine());
		}
	}

	/**
	 * 
	 */
	private void computeCommonChainData() {
		for (TransitionChainBundle tcb : trans2chainBundle.values()) {
			tcb.commonData = computeCommonChainData(tcb.chains);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void release() {
		if (!prepared)
			return;
		
		prepared = false;
		
		// release resources
		ifitem2localId = null;
		ownObjects = null;
		node2data = null;
		state2triggers = null;
		triggerstring2mif = null;
		trchains = null;
		trans2chainBundle = null;
		copy2orig = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addOwnObject(StateGraphItem obj) {
		ownObjects.add(obj);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isOwnObject(StateGraphItem obj) {
		return ownObjects.contains(obj);
	}
	
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean hasBaseTransitionDetailCode(Transition trans) {
        return baseTransitionHasDetailCode.contains(trans);
    }

    private int computeInterfaceItemLocalIds(ModelComponent mc, int offset) {
		if (mc.getBase()!=null) {
			// first recurse into base class
			offset = computeInterfaceItemLocalIds(mc.getBase(), offset);
		}
		
		EList<AbstractInterfaceItem> items = getOwnInterfaceItems(mc);
		for (AbstractInterfaceItem item : items) {
			ifitem2localId.put(item, offset);
			++offset;
		}
		
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getInterfaceItemLocalId(AbstractInterfaceItem ifitem) {
		Integer localId = ifitem2localId.get(ifitem);
		if (localId!=null)
			return localId.intValue();
		else
			return -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return 
	 * @generated NOT
	 */
	public EObject computeCommonChainData(EList<TransitionChain> chains) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasStateMachine() {
		ModelComponent mc = getModelComponent();
		while (mc!=null) {
			if (mc.getStateMachine()!=null)
				return true;
			mc = mc.getBase();
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTriggerCodeName(MessageFromIf mif) {
		return "TRIG_"+mif.getFrom().getName()+"__"+fsmNameProvider.getMessageName(mif.getMessage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTriggerCodeName(ActiveTrigger at) {
		String[] parts = at.getTrigger().split(TRIGGER_SEP);
		return "TRIG_"+parts[0]+"__"+parts[1];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Transition> getOutgoingTransitions(StateGraphNode node) {
		NodeData data = node2data.get(node);
		if (data==null)
			return new BasicEList<Transition>();
		else
			return new BasicEList<Transition>(data.getOutTrans());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Transition> getIncomingTransitions(StateGraphNode node) {
		NodeData data = node2data.get(node);
		if (data==null)
			return new BasicEList<Transition>();
		else
			return new BasicEList<Transition>(data.getInTrans());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ActiveTrigger> getActiveTriggers(State state) {
		LinkedList<ActiveTrigger> triggers = state2triggers.get(state);
		if (triggers==null)
			return new BasicEList<ActiveTrigger>();
		else
			return new BasicEList<ActiveTrigger>(triggers);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<MessageFromIf> getTriggers() {
		return new BasicEList<MessageFromIf>(triggerstring2mif.values());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<MessageFromIf> getOwnTriggers() {
		BasicEList<MessageFromIf> result = new BasicEList<MessageFromIf>();
		
		EList<AbstractInterfaceItem> ownIfItems = getOwnInterfaceItems(getModelComponent());
		
		for(MessageFromIf mif : triggerstring2mif.values()) {
			if (ownIfItems.contains(mif.getFrom()))
				result.add(mif);
		}
		
		Collections.sort(result, new Comparator<MessageFromIf>() {

			@Override
			public int compare(MessageFromIf o1, MessageFromIf o2) {
				return getTriggerCodeName(o1).compareTo(getTriggerCodeName(o2));
			}

			
		});
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMessageID(MessageFromIf mif) {
		// to be implemented by derived class
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TransitionChain getChain(Transition trans) {
		if (trans==null)
			return null;
		
		TransitionChainBundle tcb = trans2chainBundle.get(trans);
		if (tcb==null || tcb.chains.isEmpty())
			return null;
		
		return tcb.chains.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TransitionChain> getChains(Transition trans) {
		TransitionChainBundle tcb = trans2chainBundle.get(trans);
		if(tcb == null)
			new BasicEList<TransitionChain>();
		
		return tcb.chains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getData(Transition trans) {
		if (trans==null)
			return null;
		
		TransitionChainBundle tcb = trans2chainBundle.get(trans);
		if (tcb==null || tcb.chains.isEmpty())
			return null;
		
		if (tcb.chains.size()==1)
			return tcb.chains.get(0).getData();
		
		return tcb.commonData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EObject> getIncomingMessages(AbstractInterfaceItem ifitem) {
		return ifitem.getAllIncomingAbstractMessages();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TransitionChain addTransitionChain(Transition t) {
		TransitionChain tc = FsmGenFactory.eINSTANCE.createTransitionChain();
		tc.setTransition(t);
		
		collectChainTransitions(tc, t);
		
		trchains.add(tc);
		
		return tc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TransitionChain> getTransitionChains() {
		return new BasicEList<TransitionChain>(trchains);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TransitionChain> getOwnTransitionChains() {
		BasicEList<TransitionChain> result = new BasicEList<TransitionChain>();
		
		for (TransitionChain tc : trchains) {
			if (!targetsOfRefinedTransitions.contains(tc.getTransition()) && isOwnObject(tc.getTransition()))
				result.add(tc);
		}
		
		Collections.sort(result, new Comparator<TransitionChain>() {

			@Override
			public int compare(TransitionChain o1, TransitionChain o2) {
				return fsmNameProvider.getFullPath(o1.getTransition()).compareTo(fsmNameProvider.getFullPath(o2.getTransition()));
			}
			
		});
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<AbstractInterfaceItem> getOwnInterfaceItems(ModelComponent mc) {
		return mc.getAbstractInterfaceItems();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<AbstractInterfaceItem> getAllInterfaceItems() {
		return getModelComponent().getAllAbstractInterfaceItems();
	}

	private StateGraphNode getAdjustedTargetNode(Transition t) {
		StateGraphNode node = fsmHelpers.getNode(t.getTo());
		if (node instanceof EntryPoint) {
			NodeData data = node2data.get(node);
			if (data==null || data.getOutTrans().isEmpty()) {
				if (getModelComponent(node).isAbstract()) {
					if (node.eContainer().eContainer() instanceof State) {
						// in this case 
						State newTarget = (State) node.eContainer().eContainer();
						
						StateTerminal st = FSMFactory.eINSTANCE.createStateTerminal();
						st.setState(newTarget);
						t.setTo(st);
						
						node = newTarget;
					}
				}
			}
		}
		return node;
	}
	
	private ModelComponent getModelComponent(EObject node) {
		node = copy2orig.get(node);
		while (node!=null) {
			if (node instanceof ModelComponent)
				return (ModelComponent) node;
			node = node.eContainer();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isMatching(Trigger trig, String trigstr) {
		for (MessageFromIf mifp2 : trig.getMsgFromIfPairs()) {
			String tr2 = getTriggerString(mifp2);
			if (tr2.equals(trigstr))
				return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ContinuationTransition getDefaultBranch(EList<Transition> out) {
		return getDefaultBranch((List<Transition>)out);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EObject getOrig(EObject copy) {
		return copy2orig.get(copy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getModelComponentName() {
		return getModelComponent().getComponentName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__STATE_MACHINE:
				return basicSetStateMachine(null, msgs);
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__TRANSITION_CHAINS:
				return ((InternalEList<?>)getTransitionChains()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	private ContinuationTransition getDefaultBranch(List<Transition> out) {
		for (Transition t : out) {
			if (t instanceof ContinuationTransition)
				return (ContinuationTransition) t;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__MODEL_COMPONENT:
				if (resolve) return getModelComponent();
				return basicGetModelComponent();
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__STATE_MACHINE:
				return getStateMachine();
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__TRANSITION_CHAINS:
				return getTransitionChains();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__MODEL_COMPONENT:
				setModelComponent((ModelComponent)newValue);
				return;
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__STATE_MACHINE:
				setStateMachine((StateGraph)newValue);
				return;
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__TRANSITION_CHAINS:
				getTransitionChains().clear();
				getTransitionChains().addAll((Collection<? extends TransitionChain>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__MODEL_COMPONENT:
				setModelComponent((ModelComponent)null);
				return;
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__STATE_MACHINE:
				setStateMachine((StateGraph)null);
				return;
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__TRANSITION_CHAINS:
				getTransitionChains().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__MODEL_COMPONENT:
				return modelComponent != null;
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__STATE_MACHINE:
				return stateMachine != null;
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT__TRANSITION_CHAINS:
				return transitionChains != null && !transitionChains.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExpandedModelComponentImpl
