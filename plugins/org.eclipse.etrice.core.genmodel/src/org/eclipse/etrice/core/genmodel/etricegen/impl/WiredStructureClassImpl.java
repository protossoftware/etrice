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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.OpenBinding;
import org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wired Structure Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredStructureClassImpl#getWires <em>Wires</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredStructureClassImpl#getOpenBindings <em>Open Bindings</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredStructureClassImpl#getProvidedServices <em>Provided Services</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredStructureClassImpl#getRequiredServices <em>Required Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WiredStructureClassImpl extends EObjectImpl implements WiredStructureClass {
	/**
	 * The cached value of the '{@link #getWires() <em>Wires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWires()
	 * @generated
	 * @ordered
	 */
	protected EList<Wire> wires;

	/**
	 * The cached value of the '{@link #getOpenBindings() <em>Open Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<OpenBinding> openBindings;

	/**
	 * The cached value of the '{@link #getProvidedServices() <em>Provided Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedServices()
	 * @generated
	 * @ordered
	 */
	protected EList<OpenServiceConnection> providedServices;

	/**
	 * The cached value of the '{@link #getRequiredServices() <em>Required Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredServices()
	 * @generated
	 * @ordered
	 */
	protected EList<OpenServiceConnection> requiredServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WiredStructureClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.WIRED_STRUCTURE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Wire> getWires() {
		if (wires == null) {
			wires = new EObjectContainmentEList<Wire>(Wire.class, this, ETriceGenPackage.WIRED_STRUCTURE_CLASS__WIRES);
		}
		return wires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OpenBinding> getOpenBindings() {
		if (openBindings == null) {
			openBindings = new EObjectContainmentEList<OpenBinding>(OpenBinding.class, this, ETriceGenPackage.WIRED_STRUCTURE_CLASS__OPEN_BINDINGS);
		}
		return openBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OpenServiceConnection> getProvidedServices() {
		if (providedServices == null) {
			providedServices = new EObjectContainmentEList<OpenServiceConnection>(OpenServiceConnection.class, this, ETriceGenPackage.WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES);
		}
		return providedServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OpenServiceConnection> getRequiredServices() {
		if (requiredServices == null) {
			requiredServices = new EObjectContainmentEList<OpenServiceConnection>(OpenServiceConnection.class, this, ETriceGenPackage.WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES);
		}
		return requiredServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__WIRES:
				return ((InternalEList<?>)getWires()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__OPEN_BINDINGS:
				return ((InternalEList<?>)getOpenBindings()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES:
				return ((InternalEList<?>)getProvidedServices()).basicRemove(otherEnd, msgs);
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES:
				return ((InternalEList<?>)getRequiredServices()).basicRemove(otherEnd, msgs);
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
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__WIRES:
				return getWires();
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__OPEN_BINDINGS:
				return getOpenBindings();
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES:
				return getProvidedServices();
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES:
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
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__WIRES:
				getWires().clear();
				getWires().addAll((Collection<? extends Wire>)newValue);
				return;
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__OPEN_BINDINGS:
				getOpenBindings().clear();
				getOpenBindings().addAll((Collection<? extends OpenBinding>)newValue);
				return;
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES:
				getProvidedServices().clear();
				getProvidedServices().addAll((Collection<? extends OpenServiceConnection>)newValue);
				return;
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES:
				getRequiredServices().clear();
				getRequiredServices().addAll((Collection<? extends OpenServiceConnection>)newValue);
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
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__WIRES:
				getWires().clear();
				return;
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__OPEN_BINDINGS:
				getOpenBindings().clear();
				return;
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES:
				getProvidedServices().clear();
				return;
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES:
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
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__WIRES:
				return wires != null && !wires.isEmpty();
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__OPEN_BINDINGS:
				return openBindings != null && !openBindings.isEmpty();
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES:
				return providedServices != null && !providedServices.isEmpty();
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES:
				return requiredServices != null && !requiredServices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WiredStructureClassImpl
