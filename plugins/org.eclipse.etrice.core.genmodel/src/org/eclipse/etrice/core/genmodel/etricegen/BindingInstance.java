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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.Binding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Instance</b></em>'.
 * In the instance model each binding is turned into (at least one) binding instances. A binding between
 * a replicated port and a port of a replicated actor is turned into as many binding instances as
 * there are instances in the actor array.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance#getPorts <em>Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance#getBinding <em>Binding</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getBindingInstance()
 * @model
 * @generated
 */
public interface BindingInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Ports</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This list of {@link PortInstance}s has exactly two members: the two ports that are connected by this binding instance.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getBindingInstance_Ports()
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getBindings
	 * @model opposite="bindings" upper="2"
	 * @generated
	 */
	EList<PortInstance> getPorts();

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * A reference to the original binding.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' reference.
	 * @see #setBinding(Binding)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getBindingInstance_Binding()
	 * @model
	 * @generated
	 */
	Binding getBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance#getBinding <em>Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(Binding value);

} // BindingInstance
