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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InstanceBaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InstanceBaseImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InstanceBaseImpl#getObjId <em>Obj Id</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InstanceBaseImpl#getThreadId <em>Thread Id</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InstanceBaseImpl#getNObjIDs <em>NObj IDs</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InstanceBaseImpl extends EObjectImpl implements InstanceBase {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getObjId() <em>Obj Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjId()
	 * @generated
	 * @ordered
	 */
	protected static final int OBJ_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getObjId() <em>Obj Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjId()
	 * @generated
	 * @ordered
	 */
	protected int objId = OBJ_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getThreadId() <em>Thread Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadId()
	 * @generated
	 * @ordered
	 */
	protected static final int THREAD_ID_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getThreadId() <em>Thread Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadId()
	 * @generated
	 * @ordered
	 */
	protected int threadId = THREAD_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getNObjIDs() <em>NObj IDs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNObjIDs()
	 * @generated
	 * @ordered
	 */
	protected static final int NOBJ_IDS_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceBaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.INSTANCE_BASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.INSTANCE_BASE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * 
	 * TODOHRR: maybe this value should be cached (make attribute non-volatile)
	 */
	public String getPath() {
		String path = pathDelim+getName();
		
		EObject parent = eContainer();
		if (parent!=null && (parent instanceof InstanceBase)) {
			path = ((InstanceBase)parent).getPath() + path;
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getObjId() {
		return objId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjId(int newObjId) {
		int oldObjId = objId;
		objId = newObjId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.INSTANCE_BASE__OBJ_ID, oldObjId, objId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getThreadId() {
		if (threadId<0) {
			if (this instanceof SubSystemInstance)
				threadId = 0;
			else {
				EObject parent = eContainer();
				while (parent!=null) {
					if (parent instanceof SubSystemInstance)
						break;
					parent = parent.eContainer();
				}
				if (parent!=null) {
					threadId = ((SubSystemInstance)parent).getThreadId(this);
					if (threadId<0 && eContainer() instanceof InstanceBase)
						// not mapped, use parent thread id
						threadId = ((InstanceBase)eContainer()).getThreadId();
				}
			}
		}
		return threadId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNObjIDs() {
		return 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.INSTANCE_BASE__NAME:
				return getName();
			case ETriceGenPackage.INSTANCE_BASE__PATH:
				return getPath();
			case ETriceGenPackage.INSTANCE_BASE__OBJ_ID:
				return getObjId();
			case ETriceGenPackage.INSTANCE_BASE__THREAD_ID:
				return getThreadId();
			case ETriceGenPackage.INSTANCE_BASE__NOBJ_IDS:
				return getNObjIDs();
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
			case ETriceGenPackage.INSTANCE_BASE__NAME:
				setName((String)newValue);
				return;
			case ETriceGenPackage.INSTANCE_BASE__OBJ_ID:
				setObjId((Integer)newValue);
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
			case ETriceGenPackage.INSTANCE_BASE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ETriceGenPackage.INSTANCE_BASE__OBJ_ID:
				setObjId(OBJ_ID_EDEFAULT);
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
			case ETriceGenPackage.INSTANCE_BASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ETriceGenPackage.INSTANCE_BASE__PATH:
				return PATH_EDEFAULT == null ? getPath() != null : !PATH_EDEFAULT.equals(getPath());
			case ETriceGenPackage.INSTANCE_BASE__OBJ_ID:
				return objId != OBJ_ID_EDEFAULT;
			case ETriceGenPackage.INSTANCE_BASE__THREAD_ID:
				return threadId != THREAD_ID_EDEFAULT;
			case ETriceGenPackage.INSTANCE_BASE__NOBJ_IDS:
				return getNObjIDs() != NOBJ_IDS_EDEFAULT;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", objId: ");
		result.append(objId);
		result.append(", threadId: ");
		result.append(threadId);
		result.append(')');
		return result.toString();
	}

} //InstanceBaseImpl
