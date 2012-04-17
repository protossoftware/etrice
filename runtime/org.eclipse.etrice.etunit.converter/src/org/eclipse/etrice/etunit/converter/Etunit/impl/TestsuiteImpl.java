/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit.impl;

import java.math.BigDecimal;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage;
import org.eclipse.etrice.etunit.converter.Etunit.TestcaseType;
import org.eclipse.etrice.etunit.converter.Etunit.Testsuite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Testsuite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl#getTestcase <em>Testcase</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl#getFailures <em>Failures</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl#getSkipped <em>Skipped</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl#getTests <em>Tests</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl#getTime <em>Time</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestsuiteImpl extends EObjectImpl implements Testsuite {
	/**
	 * The cached value of the '{@link #getTestcase() <em>Testcase</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcase()
	 * @generated
	 * @ordered
	 */
	protected EList<TestcaseType> testcase;

	/**
	 * The default value of the '{@link #getErrors() <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected static final int ERRORS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getErrors() <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected int errors = ERRORS_EDEFAULT;

	/**
	 * This is true if the Errors attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean errorsESet;

	/**
	 * The default value of the '{@link #getFailures() <em>Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailures()
	 * @generated
	 * @ordered
	 */
	protected static final int FAILURES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFailures() <em>Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailures()
	 * @generated
	 * @ordered
	 */
	protected int failures = FAILURES_EDEFAULT;

	/**
	 * This is true if the Failures attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean failuresESet;

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
	 * The default value of the '{@link #getSkipped() <em>Skipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipped()
	 * @generated
	 * @ordered
	 */
	protected static final int SKIPPED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSkipped() <em>Skipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipped()
	 * @generated
	 * @ordered
	 */
	protected int skipped = SKIPPED_EDEFAULT;

	/**
	 * This is true if the Skipped attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean skippedESet;

	/**
	 * The default value of the '{@link #getTests() <em>Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTests()
	 * @generated
	 * @ordered
	 */
	protected static final int TESTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTests() <em>Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTests()
	 * @generated
	 * @ordered
	 */
	protected int tests = TESTS_EDEFAULT;

	/**
	 * This is true if the Tests attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean testsESet;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar TIMESTAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar timestamp = TIMESTAMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestsuiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EtunitPackage.Literals.TESTSUITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestcaseType> getTestcase() {
		if (testcase == null) {
			testcase = new EObjectContainmentEList<TestcaseType>(TestcaseType.class, this, EtunitPackage.TESTSUITE__TESTCASE);
		}
		return testcase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getErrors() {
		return errors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrors(int newErrors) {
		int oldErrors = errors;
		errors = newErrors;
		boolean oldErrorsESet = errorsESet;
		errorsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE__ERRORS, oldErrors, errors, !oldErrorsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetErrors() {
		int oldErrors = errors;
		boolean oldErrorsESet = errorsESet;
		errors = ERRORS_EDEFAULT;
		errorsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EtunitPackage.TESTSUITE__ERRORS, oldErrors, ERRORS_EDEFAULT, oldErrorsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetErrors() {
		return errorsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFailures() {
		return failures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailures(int newFailures) {
		int oldFailures = failures;
		failures = newFailures;
		boolean oldFailuresESet = failuresESet;
		failuresESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE__FAILURES, oldFailures, failures, !oldFailuresESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFailures() {
		int oldFailures = failures;
		boolean oldFailuresESet = failuresESet;
		failures = FAILURES_EDEFAULT;
		failuresESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EtunitPackage.TESTSUITE__FAILURES, oldFailures, FAILURES_EDEFAULT, oldFailuresESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFailures() {
		return failuresESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSkipped() {
		return skipped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSkipped(int newSkipped) {
		int oldSkipped = skipped;
		skipped = newSkipped;
		boolean oldSkippedESet = skippedESet;
		skippedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE__SKIPPED, oldSkipped, skipped, !oldSkippedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSkipped() {
		int oldSkipped = skipped;
		boolean oldSkippedESet = skippedESet;
		skipped = SKIPPED_EDEFAULT;
		skippedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EtunitPackage.TESTSUITE__SKIPPED, oldSkipped, SKIPPED_EDEFAULT, oldSkippedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSkipped() {
		return skippedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTests() {
		return tests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTests(int newTests) {
		int oldTests = tests;
		tests = newTests;
		boolean oldTestsESet = testsESet;
		testsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE__TESTS, oldTests, tests, !oldTestsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTests() {
		int oldTests = tests;
		boolean oldTestsESet = testsESet;
		tests = TESTS_EDEFAULT;
		testsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, EtunitPackage.TESTSUITE__TESTS, oldTests, TESTS_EDEFAULT, oldTestsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTests() {
		return testsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(BigDecimal newTime) {
		BigDecimal oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getTimestamp() {
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestamp(XMLGregorianCalendar newTimestamp) {
		XMLGregorianCalendar oldTimestamp = timestamp;
		timestamp = newTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE__TIMESTAMP, oldTimestamp, timestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EtunitPackage.TESTSUITE__TESTCASE:
				return ((InternalEList<?>)getTestcase()).basicRemove(otherEnd, msgs);
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
			case EtunitPackage.TESTSUITE__TESTCASE:
				return getTestcase();
			case EtunitPackage.TESTSUITE__ERRORS:
				return getErrors();
			case EtunitPackage.TESTSUITE__FAILURES:
				return getFailures();
			case EtunitPackage.TESTSUITE__NAME:
				return getName();
			case EtunitPackage.TESTSUITE__SKIPPED:
				return getSkipped();
			case EtunitPackage.TESTSUITE__TESTS:
				return getTests();
			case EtunitPackage.TESTSUITE__TIME:
				return getTime();
			case EtunitPackage.TESTSUITE__TIMESTAMP:
				return getTimestamp();
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
			case EtunitPackage.TESTSUITE__TESTCASE:
				getTestcase().clear();
				getTestcase().addAll((Collection<? extends TestcaseType>)newValue);
				return;
			case EtunitPackage.TESTSUITE__ERRORS:
				setErrors((Integer)newValue);
				return;
			case EtunitPackage.TESTSUITE__FAILURES:
				setFailures((Integer)newValue);
				return;
			case EtunitPackage.TESTSUITE__NAME:
				setName((String)newValue);
				return;
			case EtunitPackage.TESTSUITE__SKIPPED:
				setSkipped((Integer)newValue);
				return;
			case EtunitPackage.TESTSUITE__TESTS:
				setTests((Integer)newValue);
				return;
			case EtunitPackage.TESTSUITE__TIME:
				setTime((BigDecimal)newValue);
				return;
			case EtunitPackage.TESTSUITE__TIMESTAMP:
				setTimestamp((XMLGregorianCalendar)newValue);
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
			case EtunitPackage.TESTSUITE__TESTCASE:
				getTestcase().clear();
				return;
			case EtunitPackage.TESTSUITE__ERRORS:
				unsetErrors();
				return;
			case EtunitPackage.TESTSUITE__FAILURES:
				unsetFailures();
				return;
			case EtunitPackage.TESTSUITE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE__SKIPPED:
				unsetSkipped();
				return;
			case EtunitPackage.TESTSUITE__TESTS:
				unsetTests();
				return;
			case EtunitPackage.TESTSUITE__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE__TIMESTAMP:
				setTimestamp(TIMESTAMP_EDEFAULT);
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
			case EtunitPackage.TESTSUITE__TESTCASE:
				return testcase != null && !testcase.isEmpty();
			case EtunitPackage.TESTSUITE__ERRORS:
				return isSetErrors();
			case EtunitPackage.TESTSUITE__FAILURES:
				return isSetFailures();
			case EtunitPackage.TESTSUITE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EtunitPackage.TESTSUITE__SKIPPED:
				return isSetSkipped();
			case EtunitPackage.TESTSUITE__TESTS:
				return isSetTests();
			case EtunitPackage.TESTSUITE__TIME:
				return TIME_EDEFAULT == null ? time != null : !TIME_EDEFAULT.equals(time);
			case EtunitPackage.TESTSUITE__TIMESTAMP:
				return TIMESTAMP_EDEFAULT == null ? timestamp != null : !TIMESTAMP_EDEFAULT.equals(timestamp);
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
		result.append(" (errors: ");
		if (errorsESet) result.append(errors); else result.append("<unset>");
		result.append(", failures: ");
		if (failuresESet) result.append(failures); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", skipped: ");
		if (skippedESet) result.append(skipped); else result.append("<unset>");
		result.append(", tests: ");
		if (testsESet) result.append(tests); else result.append("<unset>");
		result.append(", time: ");
		result.append(time);
		result.append(", timestamp: ");
		result.append(timestamp);
		result.append(')');
		return result.toString();
	}

} //TestsuiteImpl
