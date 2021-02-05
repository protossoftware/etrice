/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.ProtocolClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Item Instance</b></em>'.
 * <ul>
 *   <li> {@link PortInstance}</li>
 *   <li> {@link SAPInstance}</li>
 *   <li> {@link ServiceImplInstance}</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getPeers <em>Peers</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getXpProtocolClass <em>Xp Protocol Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getInterfaceItemInstance()
 * @model
 * @generated
 */
public interface InterfaceItemInstance extends InstanceBase {
	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Interface items have an associated protocol.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' reference.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getInterfaceItemInstance_Protocol()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ProtocolClass getProtocol();

	/**
	 * Returns the value of the '<em><b>Peers</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The list contains all peers to which this item is connected.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Peers</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getInterfaceItemInstance_Peers()
	 * @model
	 * @generated
	 */
	EList<InterfaceItemInstance> getPeers();

	/**
	 * Returns the value of the '<em><b>Xp Protocol Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xp Protocol Class</em>' reference.
	 * @see #setXpProtocolClass(ExpandedProtocolClass)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getInterfaceItemInstance_XpProtocolClass()
	 * @model
	 * @generated
	 */
	ExpandedProtocolClass getXpProtocolClass();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getXpProtocolClass <em>Xp Protocol Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xp Protocol Class</em>' reference.
	 * @see #getXpProtocolClass()
	 * @generated
	 */
	void setXpProtocolClass(ExpandedProtocolClass value);

	/**
	 * <!-- begin-user-doc -->
	 * @return <code>true</code> if the interface item (a port in this case) is replicated (i.e. has a
	 * {@link org.eclipse.etrice.core.room.Port#getMultiplicity() multiplicity}>1)
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isReplicated();

	/**
	 * <!-- begin-user-doc -->
	 * @return <code>true</code> if it is a port that is not replicated.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isSimple();

	/**
	 * <!-- begin-user-doc -->
	 * @return <code>true</code> if it is a relay port.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isRelay();

	/**
	 * <!-- begin-user-doc -->
	 * @return the associated {@link InterfaceItem}
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	InterfaceItem getInterfaceItem();

} // InterfaceItemInstance
