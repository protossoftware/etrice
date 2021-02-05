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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedProtocolClass;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortKind;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Item Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InterfaceItemInstanceImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InterfaceItemInstanceImpl#getPeers <em>Peers</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InterfaceItemInstanceImpl#getXpProtocolClass <em>Xp Protocol Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceItemInstanceImpl extends InstanceBaseImpl implements InterfaceItemInstance {
	/**
	 * The cached value of the '{@link #getPeers() <em>Peers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeers()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceItemInstance> peers;

	/**
	 * The cached value of the '{@link #getXpProtocolClass() <em>Xp Protocol Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpProtocolClass()
	 * @generated
	 * @ordered
	 */
	protected ExpandedProtocolClass xpProtocolClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceItemInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.INTERFACE_ITEM_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProtocolClass getProtocol() {
		ProtocolClass protocol = basicGetProtocol();
		return protocol != null && protocol.eIsProxy() ? (ProtocolClass)eResolveProxy((InternalEObject)protocol) : protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated MPT
	 */
	public ProtocolClass basicGetProtocol() {
		InterfaceItem item = getInterfaceItem();
		if (item instanceof SAP)
			return ((SAP)this.getInterfaceItem()).getProtocol();
		else if (item instanceof SPP)
			return ((SPP)item).getProtocol();
		else if (item instanceof Port) {
			if (((Port)item).getProtocol() instanceof ProtocolClass)
				return (ProtocolClass) ((Port)item).getProtocol();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InterfaceItemInstance> getPeers() {
		if (peers == null) {
			peers = new EObjectResolvingEList<InterfaceItemInstance>(InterfaceItemInstance.class, this, ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS);
		}
		return peers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpandedProtocolClass getXpProtocolClass() {
		if (xpProtocolClass != null && xpProtocolClass.eIsProxy()) {
			InternalEObject oldXpProtocolClass = (InternalEObject)xpProtocolClass;
			xpProtocolClass = (ExpandedProtocolClass)eResolveProxy(oldXpProtocolClass);
			if (xpProtocolClass != oldXpProtocolClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.INTERFACE_ITEM_INSTANCE__XP_PROTOCOL_CLASS, oldXpProtocolClass, xpProtocolClass));
			}
		}
		return xpProtocolClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandedProtocolClass basicGetXpProtocolClass() {
		return xpProtocolClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXpProtocolClass(ExpandedProtocolClass newXpProtocolClass) {
		ExpandedProtocolClass oldXpProtocolClass = xpProtocolClass;
		xpProtocolClass = newXpProtocolClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.INTERFACE_ITEM_INSTANCE__XP_PROTOCOL_CLASS, oldXpProtocolClass, xpProtocolClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isReplicated() {
		if (this instanceof PortInstance) {
			PortInstance pi = (PortInstance) this;
			if (pi.getKind()==PortKind.RELAY)
				return false;
			
			return pi.getPort().isReplicated();
		}
		else if (this instanceof SAPInstance)
			return false;
		else if (this instanceof ServiceImplInstance)
			return true;
		
		assert(false): "unexpected sub class";
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSimple() {
		if (this instanceof PortInstance)
			if (((PortInstance) this).getKind()==PortKind.RELAY)
				return false;
		
		return !isReplicated();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isRelay() {
		if (this instanceof PortInstance)
			if (((PortInstance) this).getKind()==PortKind.RELAY)
				return true;
		
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InterfaceItem getInterfaceItem() {
		if (this instanceof PortInstance)
			return ((PortInstance) this).getPort();
		else if (this instanceof SAPInstance)
			return ((SAPInstance)this).getSap();
		else if (this instanceof ServiceImplInstance)
			return ((ServiceImplInstance)this).getSvcImpl().getSpp();
		
		assert(false): "unexpected sub class";
		return null;
	}

	public int getNObjIDs() {
		int n = getPeers().size();
		if (n==0)
			n = 1;
		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PROTOCOL:
				if (resolve) return getProtocol();
				return basicGetProtocol();
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				return getPeers();
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__XP_PROTOCOL_CLASS:
				if (resolve) return getXpProtocolClass();
				return basicGetXpProtocolClass();
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
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				getPeers().clear();
				getPeers().addAll((Collection<? extends InterfaceItemInstance>)newValue);
				return;
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__XP_PROTOCOL_CLASS:
				setXpProtocolClass((ExpandedProtocolClass)newValue);
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
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				getPeers().clear();
				return;
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__XP_PROTOCOL_CLASS:
				setXpProtocolClass((ExpandedProtocolClass)null);
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
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PROTOCOL:
				return basicGetProtocol() != null;
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				return peers != null && !peers.isEmpty();
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__XP_PROTOCOL_CLASS:
				return xpProtocolClass != null;
		}
		return super.eIsSet(featureID);
	}

} //InterfaceItemInstanceImpl
