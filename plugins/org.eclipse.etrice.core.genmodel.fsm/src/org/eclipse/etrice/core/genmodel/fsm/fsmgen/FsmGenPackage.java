/**
 *  Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  CONTRIBUTORS:
 *  		Henrik Rentz-Reichert (initial contribution)
 *  
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenFactory
 * @model kind="package"
 * @generated
 */
public interface FsmGenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fsmgen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/etrice/generator/fsm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fsmgen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FsmGenPackage eINSTANCE = org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ActiveTriggerImpl <em>Active Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ActiveTriggerImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getActiveTrigger()
	 * @generated
	 */
	int ACTIVE_TRIGGER = 0;

	/**
	 * The feature id for the '<em><b>Msg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_TRIGGER__MSG = 0;

	/**
	 * The feature id for the '<em><b>Ifitem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_TRIGGER__IFITEM = 1;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_TRIGGER__TRIGGER = 2;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_TRIGGER__TRANSITIONS = 3;

	/**
	 * The number of structural features of the '<em>Active Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_TRIGGER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl <em>Expanded Model Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getExpandedModelComponent()
	 * @generated
	 */
	int EXPANDED_MODEL_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Model Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_MODEL_COMPONENT__MODEL_COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_MODEL_COMPONENT__STATE_MACHINE = 1;

	/**
	 * The feature id for the '<em><b>Transition Chains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_MODEL_COMPONENT__TRANSITION_CHAINS = 2;

	/**
	 * The number of structural features of the '<em>Expanded Model Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_MODEL_COMPONENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedRefinedStateImpl <em>Expanded Refined State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedRefinedStateImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getExpandedRefinedState()
	 * @generated
	 */
	int EXPANDED_REFINED_STATE = 2;

	/**
	 * The feature id for the '<em><b>Docu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE__DOCU = FSMPackage.SIMPLE_STATE__DOCU;

	/**
	 * The feature id for the '<em><b>Entry Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE__ENTRY_CODE = FSMPackage.SIMPLE_STATE__ENTRY_CODE;

	/**
	 * The feature id for the '<em><b>Exit Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE__EXIT_CODE = FSMPackage.SIMPLE_STATE__EXIT_CODE;

	/**
	 * The feature id for the '<em><b>Do Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE__DO_CODE = FSMPackage.SIMPLE_STATE__DO_CODE;

	/**
	 * The feature id for the '<em><b>Subgraph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE__SUBGRAPH = FSMPackage.SIMPLE_STATE__SUBGRAPH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE__NAME = FSMPackage.SIMPLE_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Inherited Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE__INHERITED_ENTRY = FSMPackage.SIMPLE_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherited Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE__INHERITED_EXIT = FSMPackage.SIMPLE_STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inherited Do</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE__INHERITED_DO = FSMPackage.SIMPLE_STATE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Expanded Refined State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_REFINED_STATE_FEATURE_COUNT = FSMPackage.SIMPLE_STATE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link IDiagnostician <em>IDiagnostician</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see IDiagnostician
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getIDiagnostician()
	 * @generated
	 */
	int IDIAGNOSTICIAN = 3;

	/**
	 * The number of structural features of the '<em>IDiagnostician</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDIAGNOSTICIAN_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link ITransitionChainVisitor <em>ITransition Chain Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ITransitionChainVisitor
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getITransitionChainVisitor()
	 * @generated
	 */
	int ITRANSITION_CHAIN_VISITOR = 4;

	/**
	 * The number of structural features of the '<em>ITransition Chain Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITRANSITION_CHAIN_VISITOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.TransitionChainImpl <em>Transition Chain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.TransitionChainImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getTransitionChain()
	 * @generated
	 */
	int TRANSITION_CHAIN = 5;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_CHAIN__TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_CHAIN__DATA = 1;

	/**
	 * The number of structural features of the '<em>Transition Chain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_CHAIN_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger <em>Active Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Active Trigger</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger
	 * @generated
	 */
	EClass getActiveTrigger();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getMsg <em>Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Msg</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getMsg()
	 * @see #getActiveTrigger()
	 * @generated
	 */
	EReference getActiveTrigger_Msg();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getIfitem <em>Ifitem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ifitem</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getIfitem()
	 * @see #getActiveTrigger()
	 * @generated
	 */
	EReference getActiveTrigger_Ifitem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getTrigger()
	 * @see #getActiveTrigger()
	 * @generated
	 */
	EAttribute getActiveTrigger_Trigger();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transitions</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getTransitions()
	 * @see #getActiveTrigger()
	 * @generated
	 */
	EReference getActiveTrigger_Transitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent <em>Expanded Model Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expanded Model Component</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent
	 * @generated
	 */
	EClass getExpandedModelComponent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent#getModelComponent <em>Model Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Component</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent#getModelComponent()
	 * @see #getExpandedModelComponent()
	 * @generated
	 */
	EReference getExpandedModelComponent_ModelComponent();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Machine</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent#getStateMachine()
	 * @see #getExpandedModelComponent()
	 * @generated
	 */
	EReference getExpandedModelComponent_StateMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent#getTransitionChains <em>Transition Chains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transition Chains</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent#getTransitionChains()
	 * @see #getExpandedModelComponent()
	 * @generated
	 */
	EReference getExpandedModelComponent_TransitionChains();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState <em>Expanded Refined State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expanded Refined State</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState
	 * @generated
	 */
	EClass getExpandedRefinedState();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState#getInheritedEntry <em>Inherited Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inherited Entry</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState#getInheritedEntry()
	 * @see #getExpandedRefinedState()
	 * @generated
	 */
	EReference getExpandedRefinedState_InheritedEntry();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState#getInheritedExit <em>Inherited Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inherited Exit</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState#getInheritedExit()
	 * @see #getExpandedRefinedState()
	 * @generated
	 */
	EReference getExpandedRefinedState_InheritedExit();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState#getInheritedDo <em>Inherited Do</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inherited Do</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState#getInheritedDo()
	 * @see #getExpandedRefinedState()
	 * @generated
	 */
	EReference getExpandedRefinedState_InheritedDo();

	/**
	 * Returns the meta object for class '{@link IDiagnostician <em>IDiagnostician</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDiagnostician</em>'.
	 * @see IDiagnostician
	 * @model instanceClass="IDiagnostician"
	 * @generated
	 */
	EClass getIDiagnostician();

	/**
	 * Returns the meta object for class '{@link ITransitionChainVisitor <em>ITransition Chain Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITransition Chain Visitor</em>'.
	 * @see ITransitionChainVisitor
	 * @model instanceClass="ITransitionChainVisitor"
	 * @generated
	 */
	EClass getITransitionChainVisitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain <em>Transition Chain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Chain</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain
	 * @generated
	 */
	EClass getTransitionChain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transition</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain#getTransition()
	 * @see #getTransitionChain()
	 * @generated
	 */
	EReference getTransitionChain_Transition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain#getData()
	 * @see #getTransitionChain()
	 * @generated
	 */
	EReference getTransitionChain_Data();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FsmGenFactory getFsmGenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ActiveTriggerImpl <em>Active Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ActiveTriggerImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getActiveTrigger()
		 * @generated
		 */
		EClass ACTIVE_TRIGGER = eINSTANCE.getActiveTrigger();

		/**
		 * The meta object literal for the '<em><b>Msg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVE_TRIGGER__MSG = eINSTANCE.getActiveTrigger_Msg();

		/**
		 * The meta object literal for the '<em><b>Ifitem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVE_TRIGGER__IFITEM = eINSTANCE.getActiveTrigger_Ifitem();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVE_TRIGGER__TRIGGER = eINSTANCE.getActiveTrigger_Trigger();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVE_TRIGGER__TRANSITIONS = eINSTANCE.getActiveTrigger_Transitions();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl <em>Expanded Model Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedModelComponentImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getExpandedModelComponent()
		 * @generated
		 */
		EClass EXPANDED_MODEL_COMPONENT = eINSTANCE.getExpandedModelComponent();

		/**
		 * The meta object literal for the '<em><b>Model Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANDED_MODEL_COMPONENT__MODEL_COMPONENT = eINSTANCE.getExpandedModelComponent_ModelComponent();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANDED_MODEL_COMPONENT__STATE_MACHINE = eINSTANCE.getExpandedModelComponent_StateMachine();

		/**
		 * The meta object literal for the '<em><b>Transition Chains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANDED_MODEL_COMPONENT__TRANSITION_CHAINS = eINSTANCE.getExpandedModelComponent_TransitionChains();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedRefinedStateImpl <em>Expanded Refined State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.ExpandedRefinedStateImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getExpandedRefinedState()
		 * @generated
		 */
		EClass EXPANDED_REFINED_STATE = eINSTANCE.getExpandedRefinedState();

		/**
		 * The meta object literal for the '<em><b>Inherited Entry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANDED_REFINED_STATE__INHERITED_ENTRY = eINSTANCE.getExpandedRefinedState_InheritedEntry();

		/**
		 * The meta object literal for the '<em><b>Inherited Exit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANDED_REFINED_STATE__INHERITED_EXIT = eINSTANCE.getExpandedRefinedState_InheritedExit();

		/**
		 * The meta object literal for the '<em><b>Inherited Do</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANDED_REFINED_STATE__INHERITED_DO = eINSTANCE.getExpandedRefinedState_InheritedDo();

		/**
		 * The meta object literal for the '{@link IDiagnostician <em>IDiagnostician</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see IDiagnostician
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getIDiagnostician()
		 * @generated
		 */
		EClass IDIAGNOSTICIAN = eINSTANCE.getIDiagnostician();

		/**
		 * The meta object literal for the '{@link ITransitionChainVisitor <em>ITransition Chain Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ITransitionChainVisitor
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getITransitionChainVisitor()
		 * @generated
		 */
		EClass ITRANSITION_CHAIN_VISITOR = eINSTANCE.getITransitionChainVisitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.TransitionChainImpl <em>Transition Chain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.TransitionChainImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getTransitionChain()
		 * @generated
		 */
		EClass TRANSITION_CHAIN = eINSTANCE.getTransitionChain();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_CHAIN__TRANSITION = eINSTANCE.getTransitionChain_Transition();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_CHAIN__DATA = eINSTANCE.getTransitionChain_Data();

	}

} //FsmGenPackage
