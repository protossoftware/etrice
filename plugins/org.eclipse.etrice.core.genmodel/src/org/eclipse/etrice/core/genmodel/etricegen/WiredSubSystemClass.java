/**
 *  Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *  
 *  CONTRIBUTORS:
 *  		Henrik Rentz-Reichert (initial contribution)
 *  
 */
package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wired Sub System Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass#getSubSystemClass <em>Sub System Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWiredSubSystemClass()
 * @model
 * @generated
 */
public interface WiredSubSystemClass extends WiredStructureClass {
	/**
	 * Returns the value of the '<em><b>Sub System Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub System Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub System Class</em>' reference.
	 * @see #setSubSystemClass(SubSystemClass)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWiredSubSystemClass_SubSystemClass()
	 * @model
	 * @generated
	 */
	SubSystemClass getSubSystemClass();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass#getSubSystemClass <em>Sub System Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub System Class</em>' reference.
	 * @see #getSubSystemClass()
	 * @generated
	 */
	void setSubSystemClass(SubSystemClass value);

} // WiredSubSystemClass
