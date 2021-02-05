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
import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expanded Actor Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedActorClassImpl#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedActorClassImpl#getGraphContainer <em>Graph Container</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedActorClassImpl#isTracingEnabled <em>Tracing Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpandedActorClassImpl extends EObjectImpl implements ExpandedActorClass {
	
	/**
	 * The cached value of the '{@link #getGraphContainer() <em>Graph Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphContainer()
	 * @generated
	 * @ordered
	 */
	protected GraphContainer graphContainer;

	/**
	 * The default value of the '{@link #isTracingEnabled() <em>Tracing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTracingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRACING_ENABLED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isTracingEnabled() <em>Tracing Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTracingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean tracingEnabled = TRACING_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpandedActorClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.EXPANDED_ACTOR_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActorClass getActorClass() {
		ActorClass actorClass = basicGetActorClass();
		return actorClass != null && actorClass.eIsProxy() ? (ActorClass)eResolveProxy((InternalEObject)actorClass) : actorClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ActorClass basicGetActorClass() {
		return (ActorClass) getGraphContainer().getComponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphContainer getGraphContainer() {
		return graphContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraphContainer(GraphContainer newGraphContainer, NotificationChain msgs) {
		GraphContainer oldGraphContainer = graphContainer;
		graphContainer = newGraphContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER, oldGraphContainer, newGraphContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * we maintain a map of local IDs for interface items
	 */
	private HashMap<AbstractInterfaceItem, Integer> ifitem2localId;
	
	/**
	 * the recursive computation of the local IDs of interface items
	 */
    private int computeInterfaceItemLocalIds(ModelComponent mc, int offset) {
		if (mc.getBase()!=null) {
			// first recurse into base class
			offset = computeInterfaceItemLocalIds(mc.getBase(), offset);
		}
		
		EList<AbstractInterfaceItem> items = mc.getAbstractInterfaceItems();
		for (AbstractInterfaceItem item : items) {
			ifitem2localId.put(item, offset);
			++offset;
		}
		
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGraphContainer(GraphContainer newGraphContainer) {
		if (newGraphContainer != graphContainer) {
			NotificationChain msgs = null;
			if (graphContainer != null)
				msgs = ((InternalEObject)graphContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER, null, msgs);
			if (newGraphContainer != null)
				msgs = ((InternalEObject)newGraphContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER, null, msgs);
			msgs = basicSetGraphContainer(newGraphContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER, newGraphContainer, newGraphContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTracingEnabled() {
		return tracingEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTracingEnabled(boolean newTracingEnabled) {
		boolean oldTracingEnabled = tracingEnabled;
		tracingEnabled = newTracingEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_ACTOR_CLASS__TRACING_ENABLED, oldTracingEnabled, tracingEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getInterfaceItemLocalId(AbstractInterfaceItem ifitem) {
		if (ifitem2localId==null) {
			ifitem2localId = new HashMap<AbstractInterfaceItem, Integer>();
			computeInterfaceItemLocalIds(getActorClass(), 0);
		}
		
		Integer localId = ifitem2localId.get(ifitem);
		if (localId!=null)
			return localId.intValue();
		else
			return -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER:
				return basicSetGraphContainer(null, msgs);
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
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__ACTOR_CLASS:
				if (resolve) return getActorClass();
				return basicGetActorClass();
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER:
				return getGraphContainer();
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__TRACING_ENABLED:
				return isTracingEnabled();
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
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER:
				setGraphContainer((GraphContainer)newValue);
				return;
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__TRACING_ENABLED:
				setTracingEnabled((Boolean)newValue);
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
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER:
				setGraphContainer((GraphContainer)null);
				return;
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__TRACING_ENABLED:
				setTracingEnabled(TRACING_ENABLED_EDEFAULT);
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
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__ACTOR_CLASS:
				return basicGetActorClass() != null;
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER:
				return graphContainer != null;
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS__TRACING_ENABLED:
				return tracingEnabled != TRACING_ENABLED_EDEFAULT;
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
		result.append(" (tracingEnabled: ");
		result.append(tracingEnabled);
		result.append(')');
		return result.toString();
	}
	
} //ExpandedActorClassImpl
