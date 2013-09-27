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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WireImpl#isDataDriven <em>Data Driven</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WireImpl#getPath1 <em>Path1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WireImpl#getPath2 <em>Path2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WireImpl extends EObjectImpl implements Wire {
	/**
	 * The default value of the '{@link #isDataDriven() <em>Data Driven</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDataDriven()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DATA_DRIVEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDataDriven() <em>Data Driven</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDataDriven()
	 * @generated
	 * @ordered
	 */
	protected boolean dataDriven = DATA_DRIVEN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPath1() <em>Path1</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath1()
	 * @generated
	 * @ordered
	 */
	protected EList<String> path1;

	/**
	 * The cached value of the '{@link #getPath2() <em>Path2</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath2()
	 * @generated
	 * @ordered
	 */
	protected EList<String> path2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.WIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDataDriven() {
		return dataDriven;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataDriven(boolean newDataDriven) {
		boolean oldDataDriven = dataDriven;
		dataDriven = newDataDriven;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.WIRE__DATA_DRIVEN, oldDataDriven, dataDriven));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPath1() {
		if (path1 == null) {
			path1 = new EDataTypeEList<String>(String.class, this, ETriceGenPackage.WIRE__PATH1);
		}
		return path1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPath2() {
		if (path2 == null) {
			path2 = new EDataTypeEList<String>(String.class, this, ETriceGenPackage.WIRE__PATH2);
		}
		return path2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.WIRE__DATA_DRIVEN:
				return isDataDriven();
			case ETriceGenPackage.WIRE__PATH1:
				return getPath1();
			case ETriceGenPackage.WIRE__PATH2:
				return getPath2();
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
			case ETriceGenPackage.WIRE__DATA_DRIVEN:
				setDataDriven((Boolean)newValue);
				return;
			case ETriceGenPackage.WIRE__PATH1:
				getPath1().clear();
				getPath1().addAll((Collection<? extends String>)newValue);
				return;
			case ETriceGenPackage.WIRE__PATH2:
				getPath2().clear();
				getPath2().addAll((Collection<? extends String>)newValue);
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
			case ETriceGenPackage.WIRE__DATA_DRIVEN:
				setDataDriven(DATA_DRIVEN_EDEFAULT);
				return;
			case ETriceGenPackage.WIRE__PATH1:
				getPath1().clear();
				return;
			case ETriceGenPackage.WIRE__PATH2:
				getPath2().clear();
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
			case ETriceGenPackage.WIRE__DATA_DRIVEN:
				return dataDriven != DATA_DRIVEN_EDEFAULT;
			case ETriceGenPackage.WIRE__PATH1:
				return path1 != null && !path1.isEmpty();
			case ETriceGenPackage.WIRE__PATH2:
				return path2 != null && !path2.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append("Wire: ");
		for (String seg : getPath1()) {
			result.append(seg+'/');
		}
		result.deleteCharAt(result.length()-1);
		result.append("<->");
		for (String seg : getPath2()) {
			result.append(seg+'/');
		}
		return result.deleteCharAt(result.length()-1).toString();
	}

} //WireImpl
