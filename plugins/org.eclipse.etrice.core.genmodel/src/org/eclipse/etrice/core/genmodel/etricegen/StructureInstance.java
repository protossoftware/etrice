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

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure Instance</b></em>'.
 * It is the base class of
 * <ul>
 *   <li> {@link ActorInstance}</li>
 *   <li> {@link SubSystemInstance}</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getSaps <em>Saps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getSpps <em>Spps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getAllContainedInstances <em>All Contained Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getOrderedIfItemInstances <em>Ordered If Item Instances</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getStructureInstance()
 * @model
 * @generated
 */
public interface StructureInstance extends AbstractInstance {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * It contains all child instances which are implicitly created by {@link ActorRef}s.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getStructureInstance_Instances()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractInstance> getInstances();

	/**
	 * Returns the value of the '<em><b>Saps</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Saps</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getStructureInstance_Saps()
	 * @model containment="true"
	 * @generated
	 */
	EList<SAPInstance> getSaps();

	/**
	 * Returns the value of the '<em><b>Spps</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spps</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getStructureInstance_Spps()
	 * @model containment="true"
	 * @generated
	 */
	EList<SPPInstance> getSpps();

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getStructureInstance_Services()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServiceImplInstance> getServices();

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getStructureInstance_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<BindingInstance> getBindings();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getStructureInstance_Connections()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConnectionInstance> getConnections();

	/**
	 * Returns the value of the '<em><b>All Contained Instances</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.ActorInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * It contains all instances of the instance's sub tree.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Contained Instances</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getStructureInstance_AllContainedInstances()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<ActorInstance> getAllContainedInstances();

	/**
	 * Returns the value of the '<em><b>Ordered If Item Instances</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The interface items are ordered base class first followed by derived classes. For each class
	 * the interface items start with port instances followed by SAP instances and service implementations.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered If Item Instances</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getStructureInstance_OrderedIfItemInstances()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	EList<InterfaceItemInstance> getOrderedIfItemInstances();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ActorInstance> getActorInstances();

} // StructureInstance
