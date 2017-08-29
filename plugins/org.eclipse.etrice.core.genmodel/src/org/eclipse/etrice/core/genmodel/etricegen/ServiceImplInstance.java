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

import org.eclipse.etrice.core.room.ServiceImplementation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Impl Instance</b></em>' which is derived from
 * {@link InterfaceItemInstance}.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance#getSvcImpl <em>Svc Impl</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getServiceImplInstance()
 * @model
 * @generated
 */
public interface ServiceImplInstance extends InterfaceItemInstance {
	/**
	 * Returns the value of the '<em><b>Svc Impl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The associated ROOM model service implementation
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Svc Impl</em>' reference.
	 * @see #setSvcImpl(ServiceImplementation)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getServiceImplInstance_SvcImpl()
	 * @model
	 * @generated
	 */
	ServiceImplementation getSvcImpl();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance#getSvcImpl <em>Svc Impl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Svc Impl</em>' reference.
	 * @see #getSvcImpl()
	 * @generated
	 */
	void setSvcImpl(ServiceImplementation value);

} // ServiceImplInstance
