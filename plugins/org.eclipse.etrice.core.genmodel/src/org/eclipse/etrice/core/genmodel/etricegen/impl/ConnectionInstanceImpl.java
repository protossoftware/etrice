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

package org.eclipse.etrice.core.genmodel.etricegen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.SPPInstance;

import org.eclipse.etrice.core.room.LayerConnection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ConnectionInstanceImpl#getFromAI <em>From AI</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ConnectionInstanceImpl#getFromSPP <em>From SPP</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ConnectionInstanceImpl#getToSPP <em>To SPP</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ConnectionInstanceImpl#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionInstanceImpl extends EObjectImpl implements ConnectionInstance {
	/**
	 * The cached value of the '{@link #getFromAI() <em>From AI</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromAI()
	 * @generated
	 * @ordered
	 */
	protected AbstractInstance fromAI;

	/**
	 * The cached value of the '{@link #getFromSPP() <em>From SPP</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromSPP()
	 * @generated
	 * @ordered
	 */
	protected SPPInstance fromSPP;

	/**
	 * The cached value of the '{@link #getToSPP() <em>To SPP</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToSPP()
	 * @generated
	 * @ordered
	 */
	protected SPPInstance toSPP;

	/**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
	protected LayerConnection connection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.CONNECTION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractInstance getFromAI() {
		if (fromAI != null && fromAI.eIsProxy()) {
			InternalEObject oldFromAI = (InternalEObject)fromAI;
			fromAI = (AbstractInstance)eResolveProxy(oldFromAI);
			if (fromAI != oldFromAI) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.CONNECTION_INSTANCE__FROM_AI, oldFromAI, fromAI));
			}
		}
		return fromAI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractInstance basicGetFromAI() {
		return fromAI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromAI(AbstractInstance newFromAI) {
		AbstractInstance oldFromAI = fromAI;
		fromAI = newFromAI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.CONNECTION_INSTANCE__FROM_AI, oldFromAI, fromAI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPPInstance getFromSPP() {
		if (fromSPP != null && fromSPP.eIsProxy()) {
			InternalEObject oldFromSPP = (InternalEObject)fromSPP;
			fromSPP = (SPPInstance)eResolveProxy(oldFromSPP);
			if (fromSPP != oldFromSPP) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.CONNECTION_INSTANCE__FROM_SPP, oldFromSPP, fromSPP));
			}
		}
		return fromSPP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPPInstance basicGetFromSPP() {
		return fromSPP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromSPP(SPPInstance newFromSPP, NotificationChain msgs) {
		SPPInstance oldFromSPP = fromSPP;
		fromSPP = newFromSPP;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ETriceGenPackage.CONNECTION_INSTANCE__FROM_SPP, oldFromSPP, newFromSPP);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromSPP(SPPInstance newFromSPP) {
		if (newFromSPP != fromSPP) {
			NotificationChain msgs = null;
			if (fromSPP != null)
				msgs = ((InternalEObject)fromSPP).eInverseRemove(this, ETriceGenPackage.SPP_INSTANCE__OUTGOING, SPPInstance.class, msgs);
			if (newFromSPP != null)
				msgs = ((InternalEObject)newFromSPP).eInverseAdd(this, ETriceGenPackage.SPP_INSTANCE__OUTGOING, SPPInstance.class, msgs);
			msgs = basicSetFromSPP(newFromSPP, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.CONNECTION_INSTANCE__FROM_SPP, newFromSPP, newFromSPP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPPInstance getToSPP() {
		if (toSPP != null && toSPP.eIsProxy()) {
			InternalEObject oldToSPP = (InternalEObject)toSPP;
			toSPP = (SPPInstance)eResolveProxy(oldToSPP);
			if (toSPP != oldToSPP) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.CONNECTION_INSTANCE__TO_SPP, oldToSPP, toSPP));
			}
		}
		return toSPP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPPInstance basicGetToSPP() {
		return toSPP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToSPP(SPPInstance newToSPP, NotificationChain msgs) {
		SPPInstance oldToSPP = toSPP;
		toSPP = newToSPP;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ETriceGenPackage.CONNECTION_INSTANCE__TO_SPP, oldToSPP, newToSPP);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToSPP(SPPInstance newToSPP) {
		if (newToSPP != toSPP) {
			NotificationChain msgs = null;
			if (toSPP != null)
				msgs = ((InternalEObject)toSPP).eInverseRemove(this, ETriceGenPackage.SPP_INSTANCE__INCOMING, SPPInstance.class, msgs);
			if (newToSPP != null)
				msgs = ((InternalEObject)newToSPP).eInverseAdd(this, ETriceGenPackage.SPP_INSTANCE__INCOMING, SPPInstance.class, msgs);
			msgs = basicSetToSPP(newToSPP, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.CONNECTION_INSTANCE__TO_SPP, newToSPP, newToSPP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerConnection getConnection() {
		if (connection != null && connection.eIsProxy()) {
			InternalEObject oldConnection = (InternalEObject)connection;
			connection = (LayerConnection)eResolveProxy(oldConnection);
			if (connection != oldConnection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.CONNECTION_INSTANCE__CONNECTION, oldConnection, connection));
			}
		}
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerConnection basicGetConnection() {
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnection(LayerConnection newConnection) {
		LayerConnection oldConnection = connection;
		connection = newConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.CONNECTION_INSTANCE__CONNECTION, oldConnection, connection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_SPP:
				if (fromSPP != null)
					msgs = ((InternalEObject)fromSPP).eInverseRemove(this, ETriceGenPackage.SPP_INSTANCE__OUTGOING, SPPInstance.class, msgs);
				return basicSetFromSPP((SPPInstance)otherEnd, msgs);
			case ETriceGenPackage.CONNECTION_INSTANCE__TO_SPP:
				if (toSPP != null)
					msgs = ((InternalEObject)toSPP).eInverseRemove(this, ETriceGenPackage.SPP_INSTANCE__INCOMING, SPPInstance.class, msgs);
				return basicSetToSPP((SPPInstance)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_SPP:
				return basicSetFromSPP(null, msgs);
			case ETriceGenPackage.CONNECTION_INSTANCE__TO_SPP:
				return basicSetToSPP(null, msgs);
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
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_AI:
				if (resolve) return getFromAI();
				return basicGetFromAI();
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_SPP:
				if (resolve) return getFromSPP();
				return basicGetFromSPP();
			case ETriceGenPackage.CONNECTION_INSTANCE__TO_SPP:
				if (resolve) return getToSPP();
				return basicGetToSPP();
			case ETriceGenPackage.CONNECTION_INSTANCE__CONNECTION:
				if (resolve) return getConnection();
				return basicGetConnection();
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
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_AI:
				setFromAI((AbstractInstance)newValue);
				return;
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_SPP:
				setFromSPP((SPPInstance)newValue);
				return;
			case ETriceGenPackage.CONNECTION_INSTANCE__TO_SPP:
				setToSPP((SPPInstance)newValue);
				return;
			case ETriceGenPackage.CONNECTION_INSTANCE__CONNECTION:
				setConnection((LayerConnection)newValue);
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
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_AI:
				setFromAI((AbstractInstance)null);
				return;
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_SPP:
				setFromSPP((SPPInstance)null);
				return;
			case ETriceGenPackage.CONNECTION_INSTANCE__TO_SPP:
				setToSPP((SPPInstance)null);
				return;
			case ETriceGenPackage.CONNECTION_INSTANCE__CONNECTION:
				setConnection((LayerConnection)null);
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
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_AI:
				return fromAI != null;
			case ETriceGenPackage.CONNECTION_INSTANCE__FROM_SPP:
				return fromSPP != null;
			case ETriceGenPackage.CONNECTION_INSTANCE__TO_SPP:
				return toSPP != null;
			case ETriceGenPackage.CONNECTION_INSTANCE__CONNECTION:
				return connection != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectionInstanceImpl
