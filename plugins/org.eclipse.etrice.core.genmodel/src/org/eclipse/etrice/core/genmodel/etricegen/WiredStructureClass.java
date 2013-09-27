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
 * A representation of the model object '<em><b>Wired Structure Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getWires <em>Wires</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getOpenBindings <em>Open Bindings</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getProvidedServices <em>Provided Services</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getRequiredServices <em>Required Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWiredStructureClass()
 * @model abstract="true"
 * @generated
 */
public interface WiredStructureClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Wires</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.Wire}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wires</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wires</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWiredStructureClass_Wires()
	 * @model containment="true"
	 * @generated
	 */
	EList<Wire> getWires();

	/**
	 * Returns the value of the '<em><b>Open Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.OpenBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Bindings</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWiredStructureClass_OpenBindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<OpenBinding> getOpenBindings();

	/**
	 * Returns the value of the '<em><b>Provided Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Services</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWiredStructureClass_ProvidedServices()
	 * @model containment="true"
	 * @generated
	 */
	EList<OpenServiceConnection> getProvidedServices();

	/**
	 * Returns the value of the '<em><b>Required Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Services</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getWiredStructureClass_RequiredServices()
	 * @model containment="true"
	 * @generated
	 */
	EList<OpenServiceConnection> getRequiredServices();

} // WiredStructureClass
