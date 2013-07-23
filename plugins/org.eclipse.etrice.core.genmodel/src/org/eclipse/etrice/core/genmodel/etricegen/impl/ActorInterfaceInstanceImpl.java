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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Interface Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInterfaceInstanceImpl#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInterfaceInstanceImpl#getProvidedServices <em>Provided Services</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInterfaceInstanceImpl#getOptionalInstances <em>Optional Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInterfaceInstanceImpl#isArray <em>Array</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorInterfaceInstanceImpl extends AbstractInstanceImpl implements ActorInterfaceInstance {
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
	 * The cached value of the '{@link #getProvidedServices() <em>Provided Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedServices()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceImplInstance> providedServices;
	/**
	 * The cached value of the '{@link #getOptionalInstances() <em>Optional Instances</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<OptionalActorInstance> optionalInstances;

	/**
	 * The default value of the '{@link #isArray() <em>Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArray()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ARRAY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isArray() <em>Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArray()
	 * @generated
	 * @ordered
	 */
	protected boolean array = ARRAY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorInterfaceInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.ACTOR_INTERFACE_INSTANCE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ACTOR_CLASS, oldActorClass, actorClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ACTOR_CLASS, oldActorClass, actorClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceImplInstance> getProvidedServices() {
		if (providedServices == null) {
			providedServices = new EObjectResolvingEList<ServiceImplInstance>(ServiceImplInstance.class, this, ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__PROVIDED_SERVICES);
		}
		return providedServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OptionalActorInstance> getOptionalInstances() {
		if (optionalInstances == null) {
			optionalInstances = new EObjectResolvingEList<OptionalActorInstance>(OptionalActorInstance.class, this, ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__OPTIONAL_INSTANCES);
		}
		return optionalInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isArray() {
		return array;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArray(boolean newArray) {
		boolean oldArray = array;
		array = newArray;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ARRAY, oldArray, array));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ACTOR_CLASS:
				if (resolve) return getActorClass();
				return basicGetActorClass();
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__PROVIDED_SERVICES:
				return getProvidedServices();
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__OPTIONAL_INSTANCES:
				return getOptionalInstances();
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ARRAY:
				return isArray();
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
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ACTOR_CLASS:
				setActorClass((ActorClass)newValue);
				return;
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__PROVIDED_SERVICES:
				getProvidedServices().clear();
				getProvidedServices().addAll((Collection<? extends ServiceImplInstance>)newValue);
				return;
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__OPTIONAL_INSTANCES:
				getOptionalInstances().clear();
				getOptionalInstances().addAll((Collection<? extends OptionalActorInstance>)newValue);
				return;
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ARRAY:
				setArray((Boolean)newValue);
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
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ACTOR_CLASS:
				setActorClass((ActorClass)null);
				return;
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__PROVIDED_SERVICES:
				getProvidedServices().clear();
				return;
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__OPTIONAL_INSTANCES:
				getOptionalInstances().clear();
				return;
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ARRAY:
				setArray(ARRAY_EDEFAULT);
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
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ACTOR_CLASS:
				return actorClass != null;
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__PROVIDED_SERVICES:
				return providedServices != null && !providedServices.isEmpty();
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__OPTIONAL_INSTANCES:
				return optionalInstances != null && !optionalInstances.isEmpty();
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE__ARRAY:
				return array != ARRAY_EDEFAULT;
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
		result.append(" (array: ");
		result.append(array);
		result.append(')');
		return result.toString();
	}

} //ActorInterfaceInstanceImpl
