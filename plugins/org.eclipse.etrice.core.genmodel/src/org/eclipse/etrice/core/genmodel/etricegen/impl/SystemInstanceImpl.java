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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.room.LogicalSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SystemInstanceImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SystemInstanceImpl#getLogicalSystem <em>Logical System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemInstanceImpl extends InstanceBaseImpl implements SystemInstance {
	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<SubSystemInstance> instances;

	/**
	 * The cached value of the '{@link #getLogicalSystem() <em>Logical System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalSystem()
	 * @generated
	 * @ordered
	 */
	protected LogicalSystem logicalSystem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.SYSTEM_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubSystemInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<SubSystemInstance>(SubSystemInstance.class, this, ETriceGenPackage.SYSTEM_INSTANCE__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalSystem getLogicalSystem() {
		if (logicalSystem != null && logicalSystem.eIsProxy()) {
			InternalEObject oldLogicalSystem = (InternalEObject)logicalSystem;
			logicalSystem = (LogicalSystem)eResolveProxy(oldLogicalSystem);
			if (logicalSystem != oldLogicalSystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.SYSTEM_INSTANCE__LOGICAL_SYSTEM, oldLogicalSystem, logicalSystem));
			}
		}
		return logicalSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalSystem basicGetLogicalSystem() {
		return logicalSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogicalSystem(LogicalSystem newLogicalSystem) {
		LogicalSystem oldLogicalSystem = logicalSystem;
		logicalSystem = newLogicalSystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.SYSTEM_INSTANCE__LOGICAL_SYSTEM, oldLogicalSystem, logicalSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.SYSTEM_INSTANCE__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.SYSTEM_INSTANCE__INSTANCES:
				return getInstances();
			case ETriceGenPackage.SYSTEM_INSTANCE__LOGICAL_SYSTEM:
				if (resolve) return getLogicalSystem();
				return basicGetLogicalSystem();
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
			case ETriceGenPackage.SYSTEM_INSTANCE__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends SubSystemInstance>)newValue);
				return;
			case ETriceGenPackage.SYSTEM_INSTANCE__LOGICAL_SYSTEM:
				setLogicalSystem((LogicalSystem)newValue);
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
			case ETriceGenPackage.SYSTEM_INSTANCE__INSTANCES:
				getInstances().clear();
				return;
			case ETriceGenPackage.SYSTEM_INSTANCE__LOGICAL_SYSTEM:
				setLogicalSystem((LogicalSystem)null);
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
			case ETriceGenPackage.SYSTEM_INSTANCE__INSTANCES:
				return instances != null && !instances.isEmpty();
			case ETriceGenPackage.SYSTEM_INSTANCE__LOGICAL_SYSTEM:
				return logicalSystem != null;
		}
		return super.eIsSet(featureID);
	}

} //SystemInstanceImpl
