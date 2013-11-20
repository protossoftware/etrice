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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.etrice.core.genmodel.builder.GenmodelConstants;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInstanceImpl#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInstanceImpl#getReplIdx <em>Repl Idx</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInstanceImpl#getUnindexedName <em>Unindexed Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorInstanceImpl extends StructureInstanceImpl implements ActorInstance {
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
	 * The default value of the '{@link #getReplIdx() <em>Repl Idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplIdx()
	 * @generated
	 * @ordered
	 */
	protected static final int REPL_IDX_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getReplIdx() <em>Repl Idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplIdx()
	 * @generated
	 * @ordered
	 */
	protected int replIdx = REPL_IDX_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnindexedName() <em>Unindexed Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnindexedName()
	 * @generated
	 * @ordered
	 */
	protected static final String UNINDEXED_NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.ACTOR_INSTANCE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS, oldActorClass, actorClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS, oldActorClass, actorClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getReplIdx() {
		return replIdx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplIdx(int newReplIdx) {
		int oldReplIdx = replIdx;
		replIdx = newReplIdx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.ACTOR_INSTANCE__REPL_IDX, oldReplIdx, replIdx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUnindexedName() {
		return (getReplIdx()>=0)? getName().substring(0, getName().lastIndexOf(GenmodelConstants.INDEX_SEP)) : getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS:
				if (resolve) return getActorClass();
				return basicGetActorClass();
			case ETriceGenPackage.ACTOR_INSTANCE__REPL_IDX:
				return getReplIdx();
			case ETriceGenPackage.ACTOR_INSTANCE__UNINDEXED_NAME:
				return getUnindexedName();
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
			case ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS:
				setActorClass((ActorClass)newValue);
				return;
			case ETriceGenPackage.ACTOR_INSTANCE__REPL_IDX:
				setReplIdx((Integer)newValue);
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
			case ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS:
				setActorClass((ActorClass)null);
				return;
			case ETriceGenPackage.ACTOR_INSTANCE__REPL_IDX:
				setReplIdx(REPL_IDX_EDEFAULT);
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
			case ETriceGenPackage.ACTOR_INSTANCE__ACTOR_CLASS:
				return actorClass != null;
			case ETriceGenPackage.ACTOR_INSTANCE__REPL_IDX:
				return replIdx != REPL_IDX_EDEFAULT;
			case ETriceGenPackage.ACTOR_INSTANCE__UNINDEXED_NAME:
				return UNINDEXED_NAME_EDEFAULT == null ? getUnindexedName() != null : !UNINDEXED_NAME_EDEFAULT.equals(getUnindexedName());
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
		result.append(" (replIdx: ");
		result.append(replIdx);
		result.append(')');
		return result.toString();
	}

} //ActorInstanceImpl
