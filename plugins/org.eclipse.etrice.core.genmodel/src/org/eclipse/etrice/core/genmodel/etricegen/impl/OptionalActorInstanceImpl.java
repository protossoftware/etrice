/**
 *  Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optional Actor Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OptionalActorInstanceImpl#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OptionalActorInstanceImpl#getRequiredServices <em>Required Services</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptionalActorInstanceImpl extends StructureInstanceImpl implements OptionalActorInstance {
	/**
	 * The cached value of the '{@link #getActorClass() <em>Actor Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorClass()
	 * @generated
	 * @ordered
	 */
	protected ActorClass actorClass;
	/**
	 * The cached value of the '{@link #getRequiredServices() <em>Required Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredServices()
	 * @generated
	 * @ordered
	 */
	protected EList<SAPInstance> requiredServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionalActorInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.OPTIONAL_ACTOR_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorClass getActorClass() {
		if (actorClass != null && actorClass.eIsProxy()) {
			InternalEObject oldActorClass = (InternalEObject)actorClass;
			actorClass = (ActorClass)eResolveProxy(oldActorClass);
			if (actorClass != oldActorClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__ACTOR_CLASS, oldActorClass, actorClass));
			}
		}
		return actorClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorClass basicGetActorClass() {
		return actorClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActorClass(ActorClass newActorClass) {
		ActorClass oldActorClass = actorClass;
		actorClass = newActorClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__ACTOR_CLASS, oldActorClass, actorClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SAPInstance> getRequiredServices() {
		if (requiredServices == null) {
			requiredServices = new EObjectResolvingEList<SAPInstance>(SAPInstance.class, this, ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__REQUIRED_SERVICES);
		}
		return requiredServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__ACTOR_CLASS:
				if (resolve) return getActorClass();
				return basicGetActorClass();
			case ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__REQUIRED_SERVICES:
				return getRequiredServices();
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
			case ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__ACTOR_CLASS:
				setActorClass((ActorClass)newValue);
				return;
			case ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__REQUIRED_SERVICES:
				getRequiredServices().clear();
				getRequiredServices().addAll((Collection<? extends SAPInstance>)newValue);
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
			case ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__ACTOR_CLASS:
				setActorClass((ActorClass)null);
				return;
			case ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__REQUIRED_SERVICES:
				getRequiredServices().clear();
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
			case ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__ACTOR_CLASS:
				return actorClass != null;
			case ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE__REQUIRED_SERVICES:
				return requiredServices != null && !requiredServices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OptionalActorInstanceImpl
