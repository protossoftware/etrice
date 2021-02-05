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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedProtocolClass;

import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.ProtocolClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expanded Protocol Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedProtocolClassImpl#getOrderedMessageNames <em>Ordered Message Names</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedProtocolClassImpl#getProtocolClass <em>Protocol Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpandedProtocolClassImpl extends EObjectImpl implements ExpandedProtocolClass {
	/**
	 * The cached value of the '{@link #getOrderedMessageNames() <em>Ordered Message Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderedMessageNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> orderedMessageNames;

	/**
	 * The cached value of the '{@link #getProtocolClass() <em>Protocol Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocolClass()
	 * @generated
	 * @ordered
	 */
	protected ProtocolClass protocolClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpandedProtocolClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.EXPANDED_PROTOCOL_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getOrderedMessageNames() {
		if (orderedMessageNames == null) {
			orderedMessageNames = new EDataTypeUniqueEList<String>(String.class, this, ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__ORDERED_MESSAGE_NAMES);
		}
		return orderedMessageNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProtocolClass getProtocolClass() {
		if (protocolClass != null && protocolClass.eIsProxy()) {
			InternalEObject oldProtocolClass = (InternalEObject)protocolClass;
			protocolClass = (ProtocolClass)eResolveProxy(oldProtocolClass);
			if (protocolClass != oldProtocolClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__PROTOCOL_CLASS, oldProtocolClass, protocolClass));
			}
		}
		return protocolClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolClass basicGetProtocolClass() {
		return protocolClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProtocolClass(ProtocolClass newProtocolClass) {
		ProtocolClass oldProtocolClass = protocolClass;
		protocolClass = newProtocolClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__PROTOCOL_CLASS, oldProtocolClass, protocolClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__ORDERED_MESSAGE_NAMES:
				return getOrderedMessageNames();
			case ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__PROTOCOL_CLASS:
				if (resolve) return getProtocolClass();
				return basicGetProtocolClass();
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
			case ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__ORDERED_MESSAGE_NAMES:
				getOrderedMessageNames().clear();
				getOrderedMessageNames().addAll((Collection<? extends String>)newValue);
				return;
			case ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__PROTOCOL_CLASS:
				setProtocolClass((ProtocolClass)newValue);
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
			case ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__ORDERED_MESSAGE_NAMES:
				getOrderedMessageNames().clear();
				return;
			case ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__PROTOCOL_CLASS:
				setProtocolClass((ProtocolClass)null);
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
			case ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__ORDERED_MESSAGE_NAMES:
				return orderedMessageNames != null && !orderedMessageNames.isEmpty();
			case ETriceGenPackage.EXPANDED_PROTOCOL_CLASS__PROTOCOL_CLASS:
				return protocolClass != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (orderedMessageNames: ");
		result.append(orderedMessageNames);
		result.append(')');
		return result.toString();
	}

} //ExpandedProtocolClassImpl
