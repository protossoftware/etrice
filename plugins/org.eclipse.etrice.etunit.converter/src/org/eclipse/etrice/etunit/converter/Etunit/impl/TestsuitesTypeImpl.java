/**
 */
package org.eclipse.etrice.etunit.converter.Etunit.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl#getTestsuite <em>Testsuite</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl#getDisabled <em>Disabled</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl#getFailures <em>Failures</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl#getTests <em>Tests</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestsuitesTypeImpl extends MinimalEObjectImpl.Container implements TestsuitesType {
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
	 * The default value of the '{@link #getDisabled() <em>Disabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisabled()
	 * @generated
	 * @ordered
	 */
	protected static final String DISABLED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisabled() <em>Disabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisabled()
	 * @generated
	 * @ordered
	 */
	protected String disabled = DISABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrors() <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected static final String ERRORS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getErrors() <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected String errors = ERRORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFailures() <em>Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailures()
	 * @generated
	 * @ordered
	 */
	protected static final String FAILURES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailures() <em>Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailures()
	 * @generated
	 * @ordered
	 */
	protected String failures = FAILURES_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTests() <em>Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTests()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTests() <em>Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTests()
	 * @generated
	 * @ordered
	 */
	protected String tests = TESTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final String TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected String time = TIME_EDEFAULT;

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
	@Override
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
	public String getDisabled() {
		return disabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisabled(String newDisabled) {
		String oldDisabled = disabled;
		disabled = newDisabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITES_TYPE__DISABLED, oldDisabled, disabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getErrors() {
		return errors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setErrors(String newErrors) {
		String oldErrors = errors;
		errors = newErrors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITES_TYPE__ERRORS, oldErrors, errors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFailures() {
		return failures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFailures(String newFailures) {
		String oldFailures = failures;
		failures = newFailures;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITES_TYPE__FAILURES, oldFailures, failures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITES_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTests() {
		return tests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTests(String newTests) {
		String oldTests = tests;
		tests = newTests;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITES_TYPE__TESTS, oldTests, tests));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTime(String newTime) {
		String oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITES_TYPE__TIME, oldTime, time));
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
			case EtunitPackage.TESTSUITES_TYPE__DISABLED:
				return getDisabled();
			case EtunitPackage.TESTSUITES_TYPE__ERRORS:
				return getErrors();
			case EtunitPackage.TESTSUITES_TYPE__FAILURES:
				return getFailures();
			case EtunitPackage.TESTSUITES_TYPE__NAME:
				return getName();
			case EtunitPackage.TESTSUITES_TYPE__TESTS:
				return getTests();
			case EtunitPackage.TESTSUITES_TYPE__TIME:
				return getTime();
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
			case EtunitPackage.TESTSUITES_TYPE__DISABLED:
				setDisabled((String)newValue);
				return;
			case EtunitPackage.TESTSUITES_TYPE__ERRORS:
				setErrors((String)newValue);
				return;
			case EtunitPackage.TESTSUITES_TYPE__FAILURES:
				setFailures((String)newValue);
				return;
			case EtunitPackage.TESTSUITES_TYPE__NAME:
				setName((String)newValue);
				return;
			case EtunitPackage.TESTSUITES_TYPE__TESTS:
				setTests((String)newValue);
				return;
			case EtunitPackage.TESTSUITES_TYPE__TIME:
				setTime((String)newValue);
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
			case EtunitPackage.TESTSUITES_TYPE__DISABLED:
				setDisabled(DISABLED_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITES_TYPE__ERRORS:
				setErrors(ERRORS_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITES_TYPE__FAILURES:
				setFailures(FAILURES_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITES_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITES_TYPE__TESTS:
				setTests(TESTS_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITES_TYPE__TIME:
				setTime(TIME_EDEFAULT);
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
			case EtunitPackage.TESTSUITES_TYPE__DISABLED:
				return DISABLED_EDEFAULT == null ? disabled != null : !DISABLED_EDEFAULT.equals(disabled);
			case EtunitPackage.TESTSUITES_TYPE__ERRORS:
				return ERRORS_EDEFAULT == null ? errors != null : !ERRORS_EDEFAULT.equals(errors);
			case EtunitPackage.TESTSUITES_TYPE__FAILURES:
				return FAILURES_EDEFAULT == null ? failures != null : !FAILURES_EDEFAULT.equals(failures);
			case EtunitPackage.TESTSUITES_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EtunitPackage.TESTSUITES_TYPE__TESTS:
				return TESTS_EDEFAULT == null ? tests != null : !TESTS_EDEFAULT.equals(tests);
			case EtunitPackage.TESTSUITES_TYPE__TIME:
				return TIME_EDEFAULT == null ? time != null : !TIME_EDEFAULT.equals(time);
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
		result.append(" (disabled: ");
		result.append(disabled);
		result.append(", errors: ");
		result.append(errors);
		result.append(", failures: ");
		result.append(failures);
		result.append(", name: ");
		result.append(name);
		result.append(", tests: ");
		result.append(tests);
		result.append(", time: ");
		result.append(time);
		result.append(')');
		return result.toString();
	}

} //TestsuitesTypeImpl
