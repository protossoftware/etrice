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
import java.util.LinkedList;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.BindingInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortKind;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SPPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl#getSaps <em>Saps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl#getSpps <em>Spps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl#getAllContainedInstances <em>All Contained Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl#getOrderedIfItemInstances <em>Ordered If Item Instances</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructureInstanceImpl extends AbstractInstanceImpl implements StructureInstance {
	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractInstance> instances;

	/**
	 * The cached value of the '{@link #getSaps() <em>Saps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaps()
	 * @generated
	 * @ordered
	 */
	protected EList<SAPInstance> saps;

	/**
	 * The cached value of the '{@link #getSpps() <em>Spps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpps()
	 * @generated
	 * @ordered
	 */
	protected EList<SPPInstance> spps;

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceImplInstance> services;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<BindingInstance> bindings;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionInstance> connections;

	/**
	 * The cached value of the '{@link #getOrderedIfItemInstances() <em>Ordered If Item Instances</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderedIfItemInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceItemInstance> orderedIfItemInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.STRUCTURE_INSTANCE;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<AbstractInstance>(AbstractInstance.class, this, ETriceGenPackage.STRUCTURE_INSTANCE__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SAPInstance> getSaps() {
		if (saps == null) {
			saps = new EObjectContainmentEList<SAPInstance>(SAPInstance.class, this, ETriceGenPackage.STRUCTURE_INSTANCE__SAPS);
		}
		return saps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SPPInstance> getSpps() {
		if (spps == null) {
			spps = new EObjectContainmentEList<SPPInstance>(SPPInstance.class, this, ETriceGenPackage.STRUCTURE_INSTANCE__SPPS);
		}
		return spps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceImplInstance> getServices() {
		if (services == null) {
			services = new EObjectContainmentEList<ServiceImplInstance>(ServiceImplInstance.class, this, ETriceGenPackage.STRUCTURE_INSTANCE__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BindingInstance> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<BindingInstance>(BindingInstance.class, this, ETriceGenPackage.STRUCTURE_INSTANCE__BINDINGS);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionInstance> getConnections() {
		if (connections == null) {
			connections = new EObjectContainmentEList<ConnectionInstance>(ConnectionInstance.class, this, ETriceGenPackage.STRUCTURE_INSTANCE__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ActorInstance> getAllContainedInstances() {
		BasicEList<ActorInstance> result = new BasicEList<ActorInstance>();
		TreeIterator<EObject> it = eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof ActorInstance)
				result.add((ActorInstance) obj);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * for each base class, super classes first, (ports, saps and services) in this order.
	 * Relay ports are omitted.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InterfaceItemInstance> getOrderedIfItemInstances() {
		if (orderedIfItemInstances == null) {
			orderedIfItemInstances = new EObjectResolvingEList<InterfaceItemInstance>(InterfaceItemInstance.class, this, ETriceGenPackage.STRUCTURE_INSTANCE__ORDERED_IF_ITEM_INSTANCES);
			
			if (this instanceof ActorInstance) {
				ActorInstance ai = (ActorInstance) this;
				
				// create a list of base classes, super first
				LinkedList<ActorClass> classes = new LinkedList<ActorClass>();
				ActorClass ac = ai.getActorClass();
				while (ac!=null) {
					classes.addFirst(ac);
					ac = ac.getActorBase();
				}
				
				for (ActorClass a : classes) {
					for (PortInstance p : ai.getPorts()) {
						if (p.getKind()!=PortKind.RELAY && isInActorClass(p.getPort(), a))
							orderedIfItemInstances.add(p);
					}
					for (SAPInstance sap : ai.getSaps()) {
						if (isInActorClass(sap.getSap(), a))
							orderedIfItemInstances.add(sap);
					}
					for (ServiceImplInstance svc : ai.getServices()) {
						if (isInActorClass(svc.getSvcImpl(), a))
							orderedIfItemInstances.add(svc);
					}
				}
			}
		}
		return orderedIfItemInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ActorInstance> getActorInstances() {
		EList<ActorInstance> result = new BasicEList<ActorInstance>();
		
		for (AbstractInstance inst : getInstances()) {
			if (inst instanceof ActorInstance)
				result.add((ActorInstance) inst);
		}
		
		return result;
	}

	private boolean isInActorClass(EObject obj, ActorClass ac) {
		while (obj!=null) {
			obj = obj.eContainer();
			if (obj instanceof ActorClass)
				if (obj==ac)
					return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.STRUCTURE_INSTANCE__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.STRUCTURE_INSTANCE__SAPS:
				return ((InternalEList<?>)getSaps()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.STRUCTURE_INSTANCE__SPPS:
				return ((InternalEList<?>)getSpps()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.STRUCTURE_INSTANCE__SERVICES:
				return ((InternalEList<?>)getServices()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.STRUCTURE_INSTANCE__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.STRUCTURE_INSTANCE__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
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
			case ETriceGenPackage.STRUCTURE_INSTANCE__INSTANCES:
				return getInstances();
			case ETriceGenPackage.STRUCTURE_INSTANCE__SAPS:
				return getSaps();
			case ETriceGenPackage.STRUCTURE_INSTANCE__SPPS:
				return getSpps();
			case ETriceGenPackage.STRUCTURE_INSTANCE__SERVICES:
				return getServices();
			case ETriceGenPackage.STRUCTURE_INSTANCE__BINDINGS:
				return getBindings();
			case ETriceGenPackage.STRUCTURE_INSTANCE__CONNECTIONS:
				return getConnections();
			case ETriceGenPackage.STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES:
				return getAllContainedInstances();
			case ETriceGenPackage.STRUCTURE_INSTANCE__ORDERED_IF_ITEM_INSTANCES:
				return getOrderedIfItemInstances();
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
			case ETriceGenPackage.STRUCTURE_INSTANCE__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends AbstractInstance>)newValue);
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__SAPS:
				getSaps().clear();
				getSaps().addAll((Collection<? extends SAPInstance>)newValue);
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__SPPS:
				getSpps().clear();
				getSpps().addAll((Collection<? extends SPPInstance>)newValue);
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends ServiceImplInstance>)newValue);
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends BindingInstance>)newValue);
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends ConnectionInstance>)newValue);
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES:
				getAllContainedInstances().clear();
				getAllContainedInstances().addAll((Collection<? extends ActorInstance>)newValue);
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
			case ETriceGenPackage.STRUCTURE_INSTANCE__INSTANCES:
				getInstances().clear();
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__SAPS:
				getSaps().clear();
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__SPPS:
				getSpps().clear();
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__SERVICES:
				getServices().clear();
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__BINDINGS:
				getBindings().clear();
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__CONNECTIONS:
				getConnections().clear();
				return;
			case ETriceGenPackage.STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES:
				getAllContainedInstances().clear();
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
			case ETriceGenPackage.STRUCTURE_INSTANCE__INSTANCES:
				return instances != null && !instances.isEmpty();
			case ETriceGenPackage.STRUCTURE_INSTANCE__SAPS:
				return saps != null && !saps.isEmpty();
			case ETriceGenPackage.STRUCTURE_INSTANCE__SPPS:
				return spps != null && !spps.isEmpty();
			case ETriceGenPackage.STRUCTURE_INSTANCE__SERVICES:
				return services != null && !services.isEmpty();
			case ETriceGenPackage.STRUCTURE_INSTANCE__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case ETriceGenPackage.STRUCTURE_INSTANCE__CONNECTIONS:
				return connections != null && !connections.isEmpty();
			case ETriceGenPackage.STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES:
				return !getAllContainedInstances().isEmpty();
			case ETriceGenPackage.STRUCTURE_INSTANCE__ORDERED_IF_ITEM_INSTANCES:
				return orderedIfItemInstances != null && !orderedIfItemInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StructureInstanceImpl
