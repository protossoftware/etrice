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
package org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedRefinedState;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenFactory;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.TransitionChain;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FsmGenPackageImpl extends EPackageImpl implements FsmGenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activeTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandedModelComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandedRefinedStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDiagnosticianEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTransitionChainVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionChainEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FsmGenPackageImpl() {
		super(eNS_URI, FsmGenFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FsmGenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FsmGenPackage init() {
		if (isInited) return (FsmGenPackage)EPackage.Registry.INSTANCE.getEPackage(FsmGenPackage.eNS_URI);

		// Obtain or create and register package
		FsmGenPackageImpl theFsmGenPackage = (FsmGenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FsmGenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FsmGenPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RoomPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFsmGenPackage.createPackageContents();

		// Initialize created meta-data
		theFsmGenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFsmGenPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FsmGenPackage.eNS_URI, theFsmGenPackage);
		return theFsmGenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActiveTrigger() {
		return activeTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActiveTrigger_Msg() {
		return (EReference)activeTriggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActiveTrigger_Ifitem() {
		return (EReference)activeTriggerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActiveTrigger_Trigger() {
		return (EAttribute)activeTriggerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActiveTrigger_Transitions() {
		return (EReference)activeTriggerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandedModelComponent() {
		return expandedModelComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedModelComponent_ModelComponent() {
		return (EReference)expandedModelComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedModelComponent_StateMachine() {
		return (EReference)expandedModelComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedModelComponent_TransitionChains() {
		return (EReference)expandedModelComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandedRefinedState() {
		return expandedRefinedStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedRefinedState_InheritedEntry() {
		return (EReference)expandedRefinedStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedRefinedState_InheritedExit() {
		return (EReference)expandedRefinedStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedRefinedState_InheritedDo() {
		return (EReference)expandedRefinedStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDiagnostician() {
		return iDiagnosticianEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITransitionChainVisitor() {
		return iTransitionChainVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionChain() {
		return transitionChainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionChain_Transition() {
		return (EReference)transitionChainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionChain_Data() {
		return (EReference)transitionChainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FsmGenFactory getFsmGenFactory() {
		return (FsmGenFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		activeTriggerEClass = createEClass(ACTIVE_TRIGGER);
		createEReference(activeTriggerEClass, ACTIVE_TRIGGER__MSG);
		createEReference(activeTriggerEClass, ACTIVE_TRIGGER__IFITEM);
		createEAttribute(activeTriggerEClass, ACTIVE_TRIGGER__TRIGGER);
		createEReference(activeTriggerEClass, ACTIVE_TRIGGER__TRANSITIONS);

		expandedModelComponentEClass = createEClass(EXPANDED_MODEL_COMPONENT);
		createEReference(expandedModelComponentEClass, EXPANDED_MODEL_COMPONENT__MODEL_COMPONENT);
		createEReference(expandedModelComponentEClass, EXPANDED_MODEL_COMPONENT__STATE_MACHINE);
		createEReference(expandedModelComponentEClass, EXPANDED_MODEL_COMPONENT__TRANSITION_CHAINS);

		expandedRefinedStateEClass = createEClass(EXPANDED_REFINED_STATE);
		createEReference(expandedRefinedStateEClass, EXPANDED_REFINED_STATE__INHERITED_ENTRY);
		createEReference(expandedRefinedStateEClass, EXPANDED_REFINED_STATE__INHERITED_EXIT);
		createEReference(expandedRefinedStateEClass, EXPANDED_REFINED_STATE__INHERITED_DO);

		iDiagnosticianEClass = createEClass(IDIAGNOSTICIAN);

		iTransitionChainVisitorEClass = createEClass(ITRANSITION_CHAIN_VISITOR);

		transitionChainEClass = createEClass(TRANSITION_CHAIN);
		createEReference(transitionChainEClass, TRANSITION_CHAIN__TRANSITION);
		createEReference(transitionChainEClass, TRANSITION_CHAIN__DATA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		FSMPackage theFSMPackage = (FSMPackage)EPackage.Registry.INSTANCE.getEPackage(FSMPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		expandedRefinedStateEClass.getESuperTypes().add(theFSMPackage.getSimpleState());

		// Initialize classes and features; add operations and parameters
		initEClass(activeTriggerEClass, ActiveTrigger.class, "ActiveTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActiveTrigger_Msg(), theFSMPackage.getAbstractMessage(), null, "msg", null, 0, 1, ActiveTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActiveTrigger_Ifitem(), theFSMPackage.getAbstractInterfaceItem(), null, "ifitem", null, 0, 1, ActiveTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActiveTrigger_Trigger(), ecorePackage.getEString(), "trigger", null, 0, 1, ActiveTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActiveTrigger_Transitions(), theFSMPackage.getTriggeredTransition(), null, "transitions", null, 0, -1, ActiveTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expandedModelComponentEClass, ExpandedModelComponent.class, "ExpandedModelComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandedModelComponent_ModelComponent(), theFSMPackage.getModelComponent(), null, "modelComponent", null, 0, 1, ExpandedModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpandedModelComponent_StateMachine(), theFSMPackage.getStateGraph(), null, "stateMachine", null, 0, 1, ExpandedModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpandedModelComponent_TransitionChains(), this.getTransitionChain(), null, "transitionChains", null, 0, -1, ExpandedModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(expandedModelComponentEClass, null, "prepare", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIDiagnostician(), "validator", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedModelComponentEClass, null, "release", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, null, "addOwnObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getStateGraphItem(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, ecorePackage.getEBoolean(), "isOwnObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getStateGraphItem(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedModelComponentEClass, ecorePackage.getEBoolean(), "hasStateMachine", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, ecorePackage.getEString(), "getTriggerCodeName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getMessageFromIf(), "mif", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, ecorePackage.getEString(), "getTriggerCodeName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getActiveTrigger(), "at", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, theFSMPackage.getTransition(), "getOutgoingTransitions", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getStateGraphNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, theFSMPackage.getTransition(), "getIncomingTransitions", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getStateGraphNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, this.getActiveTrigger(), "getActiveTriggers", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getState(), "state", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedModelComponentEClass, theFSMPackage.getMessageFromIf(), "getTriggers", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedModelComponentEClass, theFSMPackage.getMessageFromIf(), "getOwnTriggers", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, ecorePackage.getEString(), "getMessageID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getMessageFromIf(), "mif", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, this.getTransitionChain(), "getChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getTransition(), "trans", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedModelComponentEClass, this.getTransitionChain(), "getOwnTransitionChains", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, theFSMPackage.getAbstractInterfaceItem(), "getOwnInterfaceItems", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getModelComponent(), "mc", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedModelComponentEClass, theFSMPackage.getAbstractInterfaceItem(), "getAllInterfaceItems", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, ecorePackage.getEBoolean(), "isMatching", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getTrigger(), "trig", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "trigstr", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, theFSMPackage.getContinuationTransition(), "getDefaultBranch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getTransition(), "out", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, ecorePackage.getEObject(), "getOrig", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "copy", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedModelComponentEClass, ecorePackage.getEString(), "getModelComponentName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, ecorePackage.getEObject(), "getData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getTransition(), "trans", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, theFSMPackage.getAbstractMessage(), "getIncomingMessages", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getAbstractInterfaceItem(), "ifitem", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, this.getTransitionChain(), "addTransitionChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getTransition(), "trans", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, ecorePackage.getEInt(), "getInterfaceItemLocalId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getAbstractInterfaceItem(), "ifitem", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedModelComponentEClass, ecorePackage.getEObject(), "computeCommonChainData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTransitionChain(), "chains", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(expandedRefinedStateEClass, ExpandedRefinedState.class, "ExpandedRefinedState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandedRefinedState_InheritedEntry(), theFSMPackage.getDetailCode(), null, "inheritedEntry", null, 0, 1, ExpandedRefinedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpandedRefinedState_InheritedExit(), theFSMPackage.getDetailCode(), null, "inheritedExit", null, 0, 1, ExpandedRefinedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpandedRefinedState_InheritedDo(), theFSMPackage.getDetailCode(), null, "inheritedDo", null, 0, 1, ExpandedRefinedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(expandedRefinedStateEClass, null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getRefinedState(), "rs", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iDiagnosticianEClass, Object.class, "IDiagnostician", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(iTransitionChainVisitorEClass, Object.class, "ITransitionChainVisitor", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(transitionChainEClass, TransitionChain.class, "TransitionChain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransitionChain_Transition(), theFSMPackage.getTransition(), null, "transition", null, 0, 1, TransitionChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionChain_Data(), ecorePackage.getEObject(), null, "data", null, 0, 1, TransitionChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(transitionChainEClass, theFSMPackage.getState(), "getStateContext", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(transitionChainEClass, ecorePackage.getEBoolean(), "isHandler", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(transitionChainEClass, ecorePackage.getEString(), "genExecuteChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getITransitionChainVisitor(), "tcv", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //FsmGenPackageImpl
