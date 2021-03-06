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

import org.eclipse.etrice.core.room.SAP;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAP Instance</b></em>' which is derived from
 * {@link InterfaceItemInstance}.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance#getSap <em>Sap</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSAPInstance()
 * @model
 * @generated
 */
public interface SAPInstance extends InterfaceItemInstance {
	/**
	 * Returns the value of the '<em><b>Sap</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The associated ROOM model SAP.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sap</em>' reference.
	 * @see #setSap(SAP)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSAPInstance_Sap()
	 * @model
	 * @generated
	 */
	SAP getSap();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance#getSap <em>Sap</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sap</em>' reference.
	 * @see #getSap()
	 * @generated
	 */
	void setSap(SAP value);

} // SAPInstance
