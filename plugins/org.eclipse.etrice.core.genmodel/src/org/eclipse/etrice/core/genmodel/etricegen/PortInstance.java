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

import org.eclipse.etrice.core.room.Port;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Instance</b></em>' which is derived from
 * {@link InterfaceItemInstance}.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getPortInstance()
 * @model
 * @generated
 */
public interface PortInstance extends InterfaceItemInstance {
	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The associated {@link Port}
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(Port)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getPortInstance_Port()
	 * @model
	 * @generated
	 */
	Port getPort();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(Port value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.etrice.core.genmodel.etricegen.PortKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortKind
	 * @see #setKind(PortKind)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getPortInstance_Kind()
	 * @model
	 * @generated
	 */
	PortKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(PortKind value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The list contains all binding instances connected with this port.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getPortInstance_Bindings()
	 * @see org.eclipse.etrice.core.genmodel.etricegen.BindingInstance#getPorts
	 * @model opposite="ports"
	 * @generated
	 */
	EList<BindingInstance> getBindings();

} // PortInstance
