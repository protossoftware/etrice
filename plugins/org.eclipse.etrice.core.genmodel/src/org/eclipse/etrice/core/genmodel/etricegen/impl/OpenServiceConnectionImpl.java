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
package org.eclipse.etrice.core.genmodel.etricegen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection;
import org.eclipse.etrice.core.room.ProtocolClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open Service Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OpenServiceConnectionImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OpenServiceConnectionImpl#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpenServiceConnectionImpl extends EObjectImpl implements OpenServiceConnection {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<String> path;

	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected ProtocolClass protocol;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpenServiceConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.OPEN_SERVICE_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPath() {
		if (path == null) {
			path = new EDataTypeEList<String>(String.class, this, ETriceGenPackage.OPEN_SERVICE_CONNECTION__PATH);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolClass getProtocol() {
		if (protocol != null && protocol.eIsProxy()) {
			InternalEObject oldProtocol = (InternalEObject)protocol;
			protocol = (ProtocolClass)eResolveProxy(oldProtocol);
			if (protocol != oldProtocol) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.OPEN_SERVICE_CONNECTION__PROTOCOL, oldProtocol, protocol));
			}
		}
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolClass basicGetProtocol() {
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(ProtocolClass newProtocol) {
		ProtocolClass oldProtocol = protocol;
		protocol = newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.OPEN_SERVICE_CONNECTION__PROTOCOL, oldProtocol, protocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.OPEN_SERVICE_CONNECTION__PATH:
				return getPath();
			case ETriceGenPackage.OPEN_SERVICE_CONNECTION__PROTOCOL:
				if (resolve) return getProtocol();
				return basicGetProtocol();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ETriceGenPackage.OPEN_SERVICE_CONNECTION__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends String>)newValue);
				return;
			case ETriceGenPackage.OPEN_SERVICE_CONNECTION__PROTOCOL:
				setProtocol((ProtocolClass)newValue);
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
			case ETriceGenPackage.OPEN_SERVICE_CONNECTION__PATH:
				getPath().clear();
				return;
			case ETriceGenPackage.OPEN_SERVICE_CONNECTION__PROTOCOL:
				setProtocol((ProtocolClass)null);
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
			case ETriceGenPackage.OPEN_SERVICE_CONNECTION__PATH:
				return path != null && !path.isEmpty();
			case ETriceGenPackage.OPEN_SERVICE_CONNECTION__PROTOCOL:
				return protocol != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append("OpenServiceConnection: ");
		result.append(getProtocol());
		result.append(' ');
		for (String seg : getPath()) {
			result.append(seg+'/');
		}
		return result.deleteCharAt(result.length()-1).toString();
	}

} //OpenServiceConnectionImpl
