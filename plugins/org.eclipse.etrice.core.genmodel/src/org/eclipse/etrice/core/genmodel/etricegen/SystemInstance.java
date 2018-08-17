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

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.LogicalSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Instance</b></em>' derived from
 * {@link InstanceBase}.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.SystemInstance#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.SystemInstance#getLogicalSystem <em>Logical System</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSystemInstance()
 * @model
 * @generated
 */
public interface SystemInstance extends InstanceBase {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * It contains all direct child instances.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSystemInstance_Instances()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubSystemInstance> getInstances();

	/**
	 * Returns the value of the '<em><b>Logical System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The associated ROOM logical system.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical System</em>' reference.
	 * @see #setLogicalSystem(LogicalSystem)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSystemInstance_LogicalSystem()
	 * @model
	 * @generated
	 */
	LogicalSystem getLogicalSystem();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.SystemInstance#getLogicalSystem <em>Logical System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logical System</em>' reference.
	 * @see #getLogicalSystem()
	 * @generated
	 */
	void setLogicalSystem(LogicalSystem value);

} // SystemInstance
