/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage;
import org.eclipse.etrice.etunit.converter.Etunit.FailureType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.FailureTypeImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.FailureTypeImpl#getExpected <em>Expected</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.FailureTypeImpl#getActual <em>Actual</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FailureTypeImpl extends EObjectImpl implements FailureType {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The default value of the '{@link #getExpected() <em>Expected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpected()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPECTED_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getActual() <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActual()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTUAL_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EtunitPackage.Literals.FAILURE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, EtunitPackage.FAILURE_TYPE__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpected() {
		return (String)getMixed().get(EtunitPackage.Literals.FAILURE_TYPE__EXPECTED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpected(String newExpected) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.FAILURE_TYPE__EXPECTED, newExpected);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActual() {
		return (String)getMixed().get(EtunitPackage.Literals.FAILURE_TYPE__ACTUAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActual(String newActual) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.FAILURE_TYPE__ACTUAL, newActual);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EtunitPackage.FAILURE_TYPE__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
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
			case EtunitPackage.FAILURE_TYPE__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case EtunitPackage.FAILURE_TYPE__EXPECTED:
				return getExpected();
			case EtunitPackage.FAILURE_TYPE__ACTUAL:
				return getActual();
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
			case EtunitPackage.FAILURE_TYPE__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case EtunitPackage.FAILURE_TYPE__EXPECTED:
				setExpected((String)newValue);
				return;
			case EtunitPackage.FAILURE_TYPE__ACTUAL:
				setActual((String)newValue);
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
			case EtunitPackage.FAILURE_TYPE__MIXED:
				getMixed().clear();
				return;
			case EtunitPackage.FAILURE_TYPE__EXPECTED:
				setExpected(EXPECTED_EDEFAULT);
				return;
			case EtunitPackage.FAILURE_TYPE__ACTUAL:
				setActual(ACTUAL_EDEFAULT);
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
			case EtunitPackage.FAILURE_TYPE__MIXED:
				return mixed != null && !mixed.isEmpty();
			case EtunitPackage.FAILURE_TYPE__EXPECTED:
				return EXPECTED_EDEFAULT == null ? getExpected() != null : !EXPECTED_EDEFAULT.equals(getExpected());
			case EtunitPackage.FAILURE_TYPE__ACTUAL:
				return ACTUAL_EDEFAULT == null ? getActual() != null : !ACTUAL_EDEFAULT.equals(getActual());
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //FailureTypeImpl
