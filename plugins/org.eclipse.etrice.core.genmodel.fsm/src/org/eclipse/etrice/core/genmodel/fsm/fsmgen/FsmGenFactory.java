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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage
 * @generated
 */
public interface FsmGenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FsmGenFactory eINSTANCE = org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Active Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Active Trigger</em>'.
	 * @generated
	 */
	ActiveTrigger createActiveTrigger();

	/**
	 * Returns a new object of class '<em>Expanded Model Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expanded Model Component</em>'.
	 * @generated
	 */
	ExpandedModelComponent createExpandedModelComponent();

	/**
	 * Returns a new object of class '<em>Expanded Refined State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expanded Refined State</em>'.
	 * @generated
	 */
	ExpandedRefinedState createExpandedRefinedState();

	/**
	 * Returns a new object of class '<em>Transition Chain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Chain</em>'.
	 * @generated
	 */
	TransitionChain createTransitionChain();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FsmGenPackage getFsmGenPackage();

} //FsmGenFactory
