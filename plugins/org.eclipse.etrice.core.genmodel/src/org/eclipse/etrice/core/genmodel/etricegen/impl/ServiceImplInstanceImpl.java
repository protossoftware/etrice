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

package org.eclipse.etrice.core.genmodel.etricegen.impl;


import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.room.ServiceImplementation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Impl Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ServiceImplInstanceImpl#getSvcImpl <em>Svc Impl</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceImplInstanceImpl extends InterfaceItemInstanceImpl implements ServiceImplInstance {
	/**
	 * The cached value of the '{@link #getSvcImpl() <em>Svc Impl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSvcImpl()
	 * @generated
	 * @ordered
	 */
	protected ServiceImplementation svcImpl;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImplInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.SERVICE_IMPL_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceImplementation getSvcImpl() {
		if (svcImpl != null && svcImpl.eIsProxy()) {
			InternalEObject oldSvcImpl = (InternalEObject)svcImpl;
			svcImpl = (ServiceImplementation)eResolveProxy(oldSvcImpl);
			if (svcImpl != oldSvcImpl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.SERVICE_IMPL_INSTANCE__SVC_IMPL, oldSvcImpl, svcImpl));
			}
		}
		return svcImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceImplementation basicGetSvcImpl() {
		return svcImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSvcImpl(ServiceImplementation newSvcImpl) {
		ServiceImplementation oldSvcImpl = svcImpl;
		svcImpl = newSvcImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.SERVICE_IMPL_INSTANCE__SVC_IMPL, oldSvcImpl, svcImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.SERVICE_IMPL_INSTANCE__SVC_IMPL:
				if (resolve) return getSvcImpl();
				return basicGetSvcImpl();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ETriceGenPackage.SERVICE_IMPL_INSTANCE__SVC_IMPL:
				setSvcImpl((ServiceImplementation)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.SERVICE_IMPL_INSTANCE__SVC_IMPL:
				setSvcImpl((ServiceImplementation)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.SERVICE_IMPL_INSTANCE__SVC_IMPL:
				return svcImpl != null;
		}
		return super.eIsSet(featureID);
	}

} //ServiceImplInstanceImpl
