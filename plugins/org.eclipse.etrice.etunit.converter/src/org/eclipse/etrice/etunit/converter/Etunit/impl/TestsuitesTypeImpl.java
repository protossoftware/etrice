/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Testsuites Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl#getTestsuite <em>Testsuite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestsuitesTypeImpl extends EObjectImpl implements TestsuitesType {
	/**
	 * The cached value of the '{@link #getTestsuite() <em>Testsuite</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestsuite()
	 * @generated
	 * @ordered
	 */
	protected EList<TestsuiteType> testsuite;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestsuitesTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EtunitPackage.Literals.TESTSUITES_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestsuiteType> getTestsuite() {
		if (testsuite == null) {
			testsuite = new EObjectContainmentEList<TestsuiteType>(TestsuiteType.class, this, EtunitPackage.TESTSUITES_TYPE__TESTSUITE);
		}
		return testsuite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EtunitPackage.TESTSUITES_TYPE__TESTSUITE:
				return ((InternalEList<?>)getTestsuite()).basicRemove(otherEnd, msgs);
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
			case EtunitPackage.TESTSUITES_TYPE__TESTSUITE:
				return getTestsuite();
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
			case EtunitPackage.TESTSUITES_TYPE__TESTSUITE:
				getTestsuite().clear();
				getTestsuite().addAll((Collection<? extends TestsuiteType>)newValue);
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
			case EtunitPackage.TESTSUITES_TYPE__TESTSUITE:
				getTestsuite().clear();
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
			case EtunitPackage.TESTSUITES_TYPE__TESTSUITE:
				return testsuite != null && !testsuite.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestsuitesTypeImpl
