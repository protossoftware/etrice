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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;

import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.TriggeredTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Active Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActiveTriggerImpl#getMsg <em>Msg</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActiveTriggerImpl#getIfitem <em>Ifitem</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActiveTriggerImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActiveTriggerImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActiveTriggerImpl extends EObjectImpl implements ActiveTrigger {
	/**
	 * The cached value of the '{@link #getMsg() <em>Msg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsg()
	 * @generated
	 * @ordered
	 */
	protected Message msg;

	/**
	 * The cached value of the '{@link #getIfitem() <em>Ifitem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfitem()
	 * @generated
	 * @ordered
	 */
	protected InterfaceItem ifitem;

	/**
	 * The default value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected String trigger = TRIGGER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TriggeredTransition> transitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActiveTriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.ACTIVE_TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getMsg() {
		if (msg != null && msg.eIsProxy()) {
			InternalEObject oldMsg = (InternalEObject)msg;
			msg = (Message)eResolveProxy(oldMsg);
			if (msg != oldMsg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.ACTIVE_TRIGGER__MSG, oldMsg, msg));
			}
		}
		return msg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetMsg() {
		return msg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsg(Message newMsg) {
		Message oldMsg = msg;
		msg = newMsg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.ACTIVE_TRIGGER__MSG, oldMsg, msg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceItem getIfitem() {
		if (ifitem != null && ifitem.eIsProxy()) {
			InternalEObject oldIfitem = (InternalEObject)ifitem;
			ifitem = (InterfaceItem)eResolveProxy(oldIfitem);
			if (ifitem != oldIfitem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.ACTIVE_TRIGGER__IFITEM, oldIfitem, ifitem));
			}
		}
		return ifitem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceItem basicGetIfitem() {
		return ifitem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfitem(InterfaceItem newIfitem) {
		InterfaceItem oldIfitem = ifitem;
		ifitem = newIfitem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.ACTIVE_TRIGGER__IFITEM, oldIfitem, ifitem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTrigger() {
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrigger(String newTrigger) {
		String oldTrigger = trigger;
		trigger = newTrigger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.ACTIVE_TRIGGER__TRIGGER, oldTrigger, trigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TriggeredTransition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectResolvingEList<TriggeredTransition>(TriggeredTransition.class, this, ETriceGenPackage.ACTIVE_TRIGGER__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.ACTIVE_TRIGGER__MSG:
				if (resolve) return getMsg();
				return basicGetMsg();
			case ETriceGenPackage.ACTIVE_TRIGGER__IFITEM:
				if (resolve) return getIfitem();
				return basicGetIfitem();
			case ETriceGenPackage.ACTIVE_TRIGGER__TRIGGER:
				return getTrigger();
			case ETriceGenPackage.ACTIVE_TRIGGER__TRANSITIONS:
				return getTransitions();
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
			case ETriceGenPackage.ACTIVE_TRIGGER__MSG:
				setMsg((Message)newValue);
				return;
			case ETriceGenPackage.ACTIVE_TRIGGER__IFITEM:
				setIfitem((InterfaceItem)newValue);
				return;
			case ETriceGenPackage.ACTIVE_TRIGGER__TRIGGER:
				setTrigger((String)newValue);
				return;
			case ETriceGenPackage.ACTIVE_TRIGGER__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends TriggeredTransition>)newValue);
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
			case ETriceGenPackage.ACTIVE_TRIGGER__MSG:
				setMsg((Message)null);
				return;
			case ETriceGenPackage.ACTIVE_TRIGGER__IFITEM:
				setIfitem((InterfaceItem)null);
				return;
			case ETriceGenPackage.ACTIVE_TRIGGER__TRIGGER:
				setTrigger(TRIGGER_EDEFAULT);
				return;
			case ETriceGenPackage.ACTIVE_TRIGGER__TRANSITIONS:
				getTransitions().clear();
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
			case ETriceGenPackage.ACTIVE_TRIGGER__MSG:
				return msg != null;
			case ETriceGenPackage.ACTIVE_TRIGGER__IFITEM:
				return ifitem != null;
			case ETriceGenPackage.ACTIVE_TRIGGER__TRIGGER:
				return TRIGGER_EDEFAULT == null ? trigger != null : !TRIGGER_EDEFAULT.equals(trigger);
			case ETriceGenPackage.ACTIVE_TRIGGER__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
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
		result.append(" (trigger: ");
		result.append(trigger);
		result.append(')');
		return result.toString();
	}

} //ActiveTriggerImpl
