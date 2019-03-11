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
import org.eclipse.etrice.etunit.converter.Etunit.PropertiesType;
import org.eclipse.etrice.etunit.converter.Etunit.TestcaseType;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Testsuite Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getTestcase <em>Testcase</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getSystemOut <em>System Out</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getSystemErr <em>System Err</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getDisabled <em>Disabled</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getFailures <em>Failures</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getSkipped <em>Skipped</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getTests <em>Tests</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getTime <em>Time</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestsuiteTypeImpl extends MinimalEObjectImpl.Container implements TestsuiteType {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected PropertiesType properties;

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
	 * The default value of the '{@link #getSystemOut() <em>System Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemOut()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_OUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemOut() <em>System Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemOut()
	 * @generated
	 * @ordered
	 */
	protected String systemOut = SYSTEM_OUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemErr() <em>System Err</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemErr()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_ERR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemErr() <em>System Err</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemErr()
	 * @generated
	 * @ordered
	 */
	protected String systemErr = SYSTEM_ERR_EDEFAULT;

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
	 * The default value of the '{@link #getHostname() <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected static final String HOSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostname() <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected String hostname = HOSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSkipped() <em>Skipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipped()
	 * @generated
	 * @ordered
	 */
	protected static final String SKIPPED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSkipped() <em>Skipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipped()
	 * @generated
	 * @ordered
	 */
	protected String skipped = SKIPPED_EDEFAULT;

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
	 * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMESTAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected String timestamp = TIMESTAMP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestsuiteTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EtunitPackage.Literals.TESTSUITE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertiesType getProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(PropertiesType newProperties, NotificationChain msgs) {
		PropertiesType oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__PROPERTIES, oldProperties, newProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperties(PropertiesType newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null)
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EtunitPackage.TESTSUITE_TYPE__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EtunitPackage.TESTSUITE_TYPE__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestcaseType> getTestcase() {
		if (testcase == null) {
			testcase = new EObjectContainmentEList<TestcaseType>(TestcaseType.class, this, EtunitPackage.TESTSUITE_TYPE__TESTCASE);
		}
		return testcase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSystemOut() {
		return systemOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSystemOut(String newSystemOut) {
		String oldSystemOut = systemOut;
		systemOut = newSystemOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__SYSTEM_OUT, oldSystemOut, systemOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSystemErr() {
		return systemErr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSystemErr(String newSystemErr) {
		String oldSystemErr = systemErr;
		systemErr = newSystemErr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__SYSTEM_ERR, oldSystemErr, systemErr));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__DISABLED, oldDisabled, disabled));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__ERRORS, oldErrors, errors));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__FAILURES, oldFailures, failures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHostname() {
		return hostname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHostname(String newHostname) {
		String oldHostname = hostname;
		hostname = newHostname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__HOSTNAME, oldHostname, hostname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSkipped() {
		return skipped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSkipped(String newSkipped) {
		String oldSkipped = skipped;
		skipped = newSkipped;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__SKIPPED, oldSkipped, skipped));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__TESTS, oldTests, tests));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimestamp(String newTimestamp) {
		String oldTimestamp = timestamp;
		timestamp = newTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTSUITE_TYPE__TIMESTAMP, oldTimestamp, timestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EtunitPackage.TESTSUITE_TYPE__PROPERTIES:
				return basicSetProperties(null, msgs);
			case EtunitPackage.TESTSUITE_TYPE__TESTCASE:
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
			case EtunitPackage.TESTSUITE_TYPE__PROPERTIES:
				return getProperties();
			case EtunitPackage.TESTSUITE_TYPE__TESTCASE:
				return getTestcase();
			case EtunitPackage.TESTSUITE_TYPE__SYSTEM_OUT:
				return getSystemOut();
			case EtunitPackage.TESTSUITE_TYPE__SYSTEM_ERR:
				return getSystemErr();
			case EtunitPackage.TESTSUITE_TYPE__DISABLED:
				return getDisabled();
			case EtunitPackage.TESTSUITE_TYPE__ERRORS:
				return getErrors();
			case EtunitPackage.TESTSUITE_TYPE__FAILURES:
				return getFailures();
			case EtunitPackage.TESTSUITE_TYPE__HOSTNAME:
				return getHostname();
			case EtunitPackage.TESTSUITE_TYPE__ID:
				return getId();
			case EtunitPackage.TESTSUITE_TYPE__NAME:
				return getName();
			case EtunitPackage.TESTSUITE_TYPE__PACKAGE:
				return getPackage();
			case EtunitPackage.TESTSUITE_TYPE__SKIPPED:
				return getSkipped();
			case EtunitPackage.TESTSUITE_TYPE__TESTS:
				return getTests();
			case EtunitPackage.TESTSUITE_TYPE__TIME:
				return getTime();
			case EtunitPackage.TESTSUITE_TYPE__TIMESTAMP:
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
			case EtunitPackage.TESTSUITE_TYPE__PROPERTIES:
				setProperties((PropertiesType)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__TESTCASE:
				getTestcase().clear();
				getTestcase().addAll((Collection<? extends TestcaseType>)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__SYSTEM_OUT:
				setSystemOut((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__SYSTEM_ERR:
				setSystemErr((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__DISABLED:
				setDisabled((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__ERRORS:
				setErrors((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__FAILURES:
				setFailures((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__HOSTNAME:
				setHostname((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__ID:
				setId((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__NAME:
				setName((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__PACKAGE:
				setPackage((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__SKIPPED:
				setSkipped((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__TESTS:
				setTests((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__TIME:
				setTime((String)newValue);
				return;
			case EtunitPackage.TESTSUITE_TYPE__TIMESTAMP:
				setTimestamp((String)newValue);
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
			case EtunitPackage.TESTSUITE_TYPE__PROPERTIES:
				setProperties((PropertiesType)null);
				return;
			case EtunitPackage.TESTSUITE_TYPE__TESTCASE:
				getTestcase().clear();
				return;
			case EtunitPackage.TESTSUITE_TYPE__SYSTEM_OUT:
				setSystemOut(SYSTEM_OUT_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__SYSTEM_ERR:
				setSystemErr(SYSTEM_ERR_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__DISABLED:
				setDisabled(DISABLED_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__ERRORS:
				setErrors(ERRORS_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__FAILURES:
				setFailures(FAILURES_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__HOSTNAME:
				setHostname(HOSTNAME_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__SKIPPED:
				setSkipped(SKIPPED_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__TESTS:
				setTests(TESTS_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case EtunitPackage.TESTSUITE_TYPE__TIMESTAMP:
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
			case EtunitPackage.TESTSUITE_TYPE__PROPERTIES:
				return properties != null;
			case EtunitPackage.TESTSUITE_TYPE__TESTCASE:
				return testcase != null && !testcase.isEmpty();
			case EtunitPackage.TESTSUITE_TYPE__SYSTEM_OUT:
				return SYSTEM_OUT_EDEFAULT == null ? systemOut != null : !SYSTEM_OUT_EDEFAULT.equals(systemOut);
			case EtunitPackage.TESTSUITE_TYPE__SYSTEM_ERR:
				return SYSTEM_ERR_EDEFAULT == null ? systemErr != null : !SYSTEM_ERR_EDEFAULT.equals(systemErr);
			case EtunitPackage.TESTSUITE_TYPE__DISABLED:
				return DISABLED_EDEFAULT == null ? disabled != null : !DISABLED_EDEFAULT.equals(disabled);
			case EtunitPackage.TESTSUITE_TYPE__ERRORS:
				return ERRORS_EDEFAULT == null ? errors != null : !ERRORS_EDEFAULT.equals(errors);
			case EtunitPackage.TESTSUITE_TYPE__FAILURES:
				return FAILURES_EDEFAULT == null ? failures != null : !FAILURES_EDEFAULT.equals(failures);
			case EtunitPackage.TESTSUITE_TYPE__HOSTNAME:
				return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
			case EtunitPackage.TESTSUITE_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case EtunitPackage.TESTSUITE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EtunitPackage.TESTSUITE_TYPE__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case EtunitPackage.TESTSUITE_TYPE__SKIPPED:
				return SKIPPED_EDEFAULT == null ? skipped != null : !SKIPPED_EDEFAULT.equals(skipped);
			case EtunitPackage.TESTSUITE_TYPE__TESTS:
				return TESTS_EDEFAULT == null ? tests != null : !TESTS_EDEFAULT.equals(tests);
			case EtunitPackage.TESTSUITE_TYPE__TIME:
				return TIME_EDEFAULT == null ? time != null : !TIME_EDEFAULT.equals(time);
			case EtunitPackage.TESTSUITE_TYPE__TIMESTAMP:
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (systemOut: ");
		result.append(systemOut);
		result.append(", systemErr: ");
		result.append(systemErr);
		result.append(", disabled: ");
		result.append(disabled);
		result.append(", errors: ");
		result.append(errors);
		result.append(", failures: ");
		result.append(failures);
		result.append(", hostname: ");
		result.append(hostname);
		result.append(", id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", package: ");
		result.append(package_);
		result.append(", skipped: ");
		result.append(skipped);
		result.append(", tests: ");
		result.append(tests);
		result.append(", time: ");
		result.append(time);
		result.append(", timestamp: ");
		result.append(timestamp);
		result.append(')');
		return result.toString();
	}

} //TestsuiteTypeImpl
