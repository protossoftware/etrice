/**
 *  Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  CONTRIBUTORS:
 *  		Henrik Rentz-Reichert (initial contribution)
 *  
 */
package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.ProtocolClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expanded Protocol Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedProtocolClass#getOrderedMessageNames <em>Ordered Message Names</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedProtocolClass#getProtocolClass <em>Protocol Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedProtocolClass()
 * @model
 * @generated
 */
public interface ExpandedProtocolClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Ordered Message Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Message Names</em>' attribute list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedProtocolClass_OrderedMessageNames()
	 * @model
	 * @generated
	 */
	EList<String> getOrderedMessageNames();

	/**
	 * Returns the value of the '<em><b>Protocol Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol Class</em>' reference.
	 * @see #setProtocolClass(ProtocolClass)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedProtocolClass_ProtocolClass()
	 * @model
	 * @generated
	 */
	ProtocolClass getProtocolClass();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedProtocolClass#getProtocolClass <em>Protocol Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol Class</em>' reference.
	 * @see #getProtocolClass()
	 * @generated
	 */
	void setProtocolClass(ProtocolClass value);

} // ExpandedProtocolClass
