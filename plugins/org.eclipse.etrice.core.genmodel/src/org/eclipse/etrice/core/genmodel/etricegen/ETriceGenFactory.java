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

package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage
 * @generated
 */
public interface ETriceGenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ETriceGenFactory eINSTANCE = org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	Root createRoot();

	/**
	 * Returns a new object of class '<em>Structure Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure Instance</em>'.
	 * @generated
	 */
	StructureInstance createStructureInstance();

	/**
	 * Returns a new object of class '<em>Sub System Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub System Instance</em>'.
	 * @generated
	 */
	SubSystemInstance createSubSystemInstance();

	/**
	 * Returns a new object of class '<em>Actor Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor Instance</em>'.
	 * @generated
	 */
	ActorInstance createActorInstance();

	/**
	 * Returns a new object of class '<em>Interface Item Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Item Instance</em>'.
	 * @generated
	 */
	InterfaceItemInstance createInterfaceItemInstance();

	/**
	 * Returns a new object of class '<em>Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Instance</em>'.
	 * @generated
	 */
	PortInstance createPortInstance();

	/**
	 * Returns a new object of class '<em>Binding Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binding Instance</em>'.
	 * @generated
	 */
	BindingInstance createBindingInstance();

	/**
	 * Returns a new object of class '<em>SAP Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SAP Instance</em>'.
	 * @generated
	 */
	SAPInstance createSAPInstance();

	/**
	 * Returns a new object of class '<em>SPP Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SPP Instance</em>'.
	 * @generated
	 */
	SPPInstance createSPPInstance();

	/**
	 * Returns a new object of class '<em>Service Impl Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Impl Instance</em>'.
	 * @generated
	 */
	ServiceImplInstance createServiceImplInstance();

	/**
	 * Returns a new object of class '<em>Connection Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Instance</em>'.
	 * @generated
	 */
	ConnectionInstance createConnectionInstance();

	/**
	 * Returns a new object of class '<em>Active Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Active Trigger</em>'.
	 * @generated
	 */
	ActiveTrigger createActiveTrigger();

	/**
	 * Returns a new object of class '<em>Transition Chain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Chain</em>'.
	 * @generated
	 */
	TransitionChain createTransitionChain();

	/**
	 * Returns a new object of class '<em>Expanded Actor Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expanded Actor Class</em>'.
	 * @generated
	 */
	ExpandedActorClass createExpandedActorClass();

	/**
	 * Returns a new object of class '<em>Expanded Refined State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expanded Refined State</em>'.
	 * @generated
	 */
	ExpandedRefinedState createExpandedRefinedState();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ETriceGenPackage getETriceGenPackage();

} //ETriceGenFactory
