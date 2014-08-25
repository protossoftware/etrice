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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.etrice.core.genmodel.fsm.fsmgen.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FsmGenFactoryImpl extends EFactoryImpl implements FsmGenFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FsmGenFactory init() {
		try {
			FsmGenFactory theFsmGenFactory = (FsmGenFactory)EPackage.Registry.INSTANCE.getEFactory(FsmGenPackage.eNS_URI);
			if (theFsmGenFactory != null) {
				return theFsmGenFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FsmGenFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FsmGenFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FsmGenPackage.ACTIVE_TRIGGER: return createActiveTrigger();
			case FsmGenPackage.EXPANDED_MODEL_COMPONENT: return createExpandedModelComponent();
			case FsmGenPackage.EXPANDED_REFINED_STATE: return createExpandedRefinedState();
			case FsmGenPackage.TRANSITION_CHAIN: return createTransitionChain();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveTrigger createActiveTrigger() {
		ActiveTriggerImpl activeTrigger = new ActiveTriggerImpl();
		return activeTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandedModelComponent createExpandedModelComponent() {
		ExpandedModelComponentImpl expandedModelComponent = new ExpandedModelComponentImpl();
		return expandedModelComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandedRefinedState createExpandedRefinedState() {
		ExpandedRefinedStateImpl expandedRefinedState = new ExpandedRefinedStateImpl();
		return expandedRefinedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionChain createTransitionChain() {
		TransitionChainImpl transitionChain = new TransitionChainImpl();
		return transitionChain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FsmGenPackage getFsmGenPackage() {
		return (FsmGenPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FsmGenPackage getPackage() {
		return FsmGenPackage.eINSTANCE;
	}

} //FsmGenFactoryImpl
