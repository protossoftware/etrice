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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass;

import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wired Sub System Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredSubSystemClassImpl#getSubSystemClass <em>Sub System Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WiredSubSystemClassImpl extends WiredStructureClassImpl implements WiredSubSystemClass {
	/**
	 * The cached value of the '{@link #getSubSystemClass() <em>Sub System Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSystemClass()
	 * @generated
	 * @ordered
	 */
	protected SubSystemClass subSystemClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WiredSubSystemClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.WIRED_SUB_SYSTEM_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubSystemClass getSubSystemClass() {
		if (subSystemClass != null && subSystemClass.eIsProxy()) {
			InternalEObject oldSubSystemClass = (InternalEObject)subSystemClass;
			subSystemClass = (SubSystemClass)eResolveProxy(oldSubSystemClass);
			if (subSystemClass != oldSubSystemClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.WIRED_SUB_SYSTEM_CLASS__SUB_SYSTEM_CLASS, oldSubSystemClass, subSystemClass));
			}
		}
		return subSystemClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubSystemClass basicGetSubSystemClass() {
		return subSystemClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubSystemClass(SubSystemClass newSubSystemClass) {
		SubSystemClass oldSubSystemClass = subSystemClass;
		subSystemClass = newSubSystemClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.WIRED_SUB_SYSTEM_CLASS__SUB_SYSTEM_CLASS, oldSubSystemClass, subSystemClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.WIRED_SUB_SYSTEM_CLASS__SUB_SYSTEM_CLASS:
				if (resolve) return getSubSystemClass();
				return basicGetSubSystemClass();
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
			case ETriceGenPackage.WIRED_SUB_SYSTEM_CLASS__SUB_SYSTEM_CLASS:
				setSubSystemClass((SubSystemClass)newValue);
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
			case ETriceGenPackage.WIRED_SUB_SYSTEM_CLASS__SUB_SYSTEM_CLASS:
				setSubSystemClass((SubSystemClass)null);
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
			case ETriceGenPackage.WIRED_SUB_SYSTEM_CLASS__SUB_SYSTEM_CLASS:
				return subSystemClass != null;
		}
		return super.eIsSet(featureID);
	}

} //WiredSubSystemClassImpl
