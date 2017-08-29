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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Wire#isDataDriven <em>Data Driven</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Wire#getPath1 <em>Path1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Wire#getPath2 <em>Path2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWire()
 * @model
 * @generated
 */
public interface Wire extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Driven</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Driven</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Driven</em>' attribute.
	 * @see #setDataDriven(boolean)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWire_DataDriven()
	 * @model
	 * @generated
	 */
	boolean isDataDriven();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.Wire#isDataDriven <em>Data Driven</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Driven</em>' attribute.
	 * @see #isDataDriven()
	 * @generated
	 */
	void setDataDriven(boolean value);

	/**
	 * Returns the value of the '<em><b>Path1</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path1</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path1</em>' attribute list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWire_Path1()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getPath1();

	/**
	 * Returns the value of the '<em><b>Path2</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path2</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path2</em>' attribute list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWire_Path2()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getPath2();

} // Wire
