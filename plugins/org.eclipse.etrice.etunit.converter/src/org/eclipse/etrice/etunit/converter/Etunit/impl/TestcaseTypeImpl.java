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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.etunit.converter.Etunit.ErrorType;
import org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage;
import org.eclipse.etrice.etunit.converter.Etunit.FailureType;
import org.eclipse.etrice.etunit.converter.Etunit.SkippedType;
import org.eclipse.etrice.etunit.converter.Etunit.TestcaseType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Testcase Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getSkipped <em>Skipped</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getError <em>Error</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getFailure <em>Failure</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getSystemOut <em>System Out</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getSystemErr <em>System Err</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestcaseTypeImpl extends MinimalEObjectImpl.Container implements TestcaseType {
	/**
	 * The cached value of the '{@link #getSkipped() <em>Skipped</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipped()
	 * @generated
	 * @ordered
	 */
	protected SkippedType skipped;

	/**
	 * The cached value of the '{@link #getError() <em>Error</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getError()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorType> error;

	/**
	 * The cached value of the '{@link #getFailure() <em>Failure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailure()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureType> failure;

	/**
	 * The cached value of the '{@link #getSystemOut() <em>System Out</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemOut()
	 * @generated
	 * @ordered
	 */
	protected EList<String> systemOut;

	/**
	 * The cached value of the '{@link #getSystemErr() <em>System Err</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemErr()
	 * @generated
	 * @ordered
	 */
	protected EList<String> systemErr;

	/**
	 * The default value of the '{@link #getAssertions() <em>Assertions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssertions()
	 * @generated
	 * @ordered
	 */
	protected static final String ASSERTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAssertions() <em>Assertions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssertions()
	 * @generated
	 * @ordered
	 */
	protected String assertions = ASSERTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected String classname = CLASSNAME_EDEFAULT;

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
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected String status = STATUS_EDEFAULT;

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
	protected TestcaseTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EtunitPackage.Literals.TESTCASE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SkippedType getSkipped() {
		return skipped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSkipped(SkippedType newSkipped, NotificationChain msgs) {
		SkippedType oldSkipped = skipped;
		skipped = newSkipped;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTCASE_TYPE__SKIPPED, oldSkipped, newSkipped);
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
	public void setSkipped(SkippedType newSkipped) {
		if (newSkipped != skipped) {
			NotificationChain msgs = null;
			if (skipped != null)
				msgs = ((InternalEObject)skipped).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EtunitPackage.TESTCASE_TYPE__SKIPPED, null, msgs);
			if (newSkipped != null)
				msgs = ((InternalEObject)newSkipped).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EtunitPackage.TESTCASE_TYPE__SKIPPED, null, msgs);
			msgs = basicSetSkipped(newSkipped, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTCASE_TYPE__SKIPPED, newSkipped, newSkipped));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ErrorType> getError() {
		if (error == null) {
			error = new EObjectContainmentEList<ErrorType>(ErrorType.class, this, EtunitPackage.TESTCASE_TYPE__ERROR);
		}
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FailureType> getFailure() {
		if (failure == null) {
			failure = new EObjectContainmentEList<FailureType>(FailureType.class, this, EtunitPackage.TESTCASE_TYPE__FAILURE);
		}
		return failure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getSystemOut() {
		if (systemOut == null) {
			systemOut = new EDataTypeEList<String>(String.class, this, EtunitPackage.TESTCASE_TYPE__SYSTEM_OUT);
		}
		return systemOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getSystemErr() {
		if (systemErr == null) {
			systemErr = new EDataTypeEList<String>(String.class, this, EtunitPackage.TESTCASE_TYPE__SYSTEM_ERR);
		}
		return systemErr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAssertions() {
		return assertions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssertions(String newAssertions) {
		String oldAssertions = assertions;
		assertions = newAssertions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTCASE_TYPE__ASSERTIONS, oldAssertions, assertions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClassname() {
		return classname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassname(String newClassname) {
		String oldClassname = classname;
		classname = newClassname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTCASE_TYPE__CLASSNAME, oldClassname, classname));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTCASE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(String newStatus) {
		String oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTCASE_TYPE__STATUS, oldStatus, status));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EtunitPackage.TESTCASE_TYPE__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EtunitPackage.TESTCASE_TYPE__SKIPPED:
				return basicSetSkipped(null, msgs);
			case EtunitPackage.TESTCASE_TYPE__ERROR:
				return ((InternalEList<?>)getError()).basicRemove(otherEnd, msgs);
			case EtunitPackage.TESTCASE_TYPE__FAILURE:
				return ((InternalEList<?>)getFailure()).basicRemove(otherEnd, msgs);
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
			case EtunitPackage.TESTCASE_TYPE__SKIPPED:
				return getSkipped();
			case EtunitPackage.TESTCASE_TYPE__ERROR:
				return getError();
			case EtunitPackage.TESTCASE_TYPE__FAILURE:
				return getFailure();
			case EtunitPackage.TESTCASE_TYPE__SYSTEM_OUT:
				return getSystemOut();
			case EtunitPackage.TESTCASE_TYPE__SYSTEM_ERR:
				return getSystemErr();
			case EtunitPackage.TESTCASE_TYPE__ASSERTIONS:
				return getAssertions();
			case EtunitPackage.TESTCASE_TYPE__CLASSNAME:
				return getClassname();
			case EtunitPackage.TESTCASE_TYPE__NAME:
				return getName();
			case EtunitPackage.TESTCASE_TYPE__STATUS:
				return getStatus();
			case EtunitPackage.TESTCASE_TYPE__TIME:
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
			case EtunitPackage.TESTCASE_TYPE__SKIPPED:
				setSkipped((SkippedType)newValue);
				return;
			case EtunitPackage.TESTCASE_TYPE__ERROR:
				getError().clear();
				getError().addAll((Collection<? extends ErrorType>)newValue);
				return;
			case EtunitPackage.TESTCASE_TYPE__FAILURE:
				getFailure().clear();
				getFailure().addAll((Collection<? extends FailureType>)newValue);
				return;
			case EtunitPackage.TESTCASE_TYPE__SYSTEM_OUT:
				getSystemOut().clear();
				getSystemOut().addAll((Collection<? extends String>)newValue);
				return;
			case EtunitPackage.TESTCASE_TYPE__SYSTEM_ERR:
				getSystemErr().clear();
				getSystemErr().addAll((Collection<? extends String>)newValue);
				return;
			case EtunitPackage.TESTCASE_TYPE__ASSERTIONS:
				setAssertions((String)newValue);
				return;
			case EtunitPackage.TESTCASE_TYPE__CLASSNAME:
				setClassname((String)newValue);
				return;
			case EtunitPackage.TESTCASE_TYPE__NAME:
				setName((String)newValue);
				return;
			case EtunitPackage.TESTCASE_TYPE__STATUS:
				setStatus((String)newValue);
				return;
			case EtunitPackage.TESTCASE_TYPE__TIME:
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
			case EtunitPackage.TESTCASE_TYPE__SKIPPED:
				setSkipped((SkippedType)null);
				return;
			case EtunitPackage.TESTCASE_TYPE__ERROR:
				getError().clear();
				return;
			case EtunitPackage.TESTCASE_TYPE__FAILURE:
				getFailure().clear();
				return;
			case EtunitPackage.TESTCASE_TYPE__SYSTEM_OUT:
				getSystemOut().clear();
				return;
			case EtunitPackage.TESTCASE_TYPE__SYSTEM_ERR:
				getSystemErr().clear();
				return;
			case EtunitPackage.TESTCASE_TYPE__ASSERTIONS:
				setAssertions(ASSERTIONS_EDEFAULT);
				return;
			case EtunitPackage.TESTCASE_TYPE__CLASSNAME:
				setClassname(CLASSNAME_EDEFAULT);
				return;
			case EtunitPackage.TESTCASE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EtunitPackage.TESTCASE_TYPE__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case EtunitPackage.TESTCASE_TYPE__TIME:
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
			case EtunitPackage.TESTCASE_TYPE__SKIPPED:
				return skipped != null;
			case EtunitPackage.TESTCASE_TYPE__ERROR:
				return error != null && !error.isEmpty();
			case EtunitPackage.TESTCASE_TYPE__FAILURE:
				return failure != null && !failure.isEmpty();
			case EtunitPackage.TESTCASE_TYPE__SYSTEM_OUT:
				return systemOut != null && !systemOut.isEmpty();
			case EtunitPackage.TESTCASE_TYPE__SYSTEM_ERR:
				return systemErr != null && !systemErr.isEmpty();
			case EtunitPackage.TESTCASE_TYPE__ASSERTIONS:
				return ASSERTIONS_EDEFAULT == null ? assertions != null : !ASSERTIONS_EDEFAULT.equals(assertions);
			case EtunitPackage.TESTCASE_TYPE__CLASSNAME:
				return CLASSNAME_EDEFAULT == null ? classname != null : !CLASSNAME_EDEFAULT.equals(classname);
			case EtunitPackage.TESTCASE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EtunitPackage.TESTCASE_TYPE__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case EtunitPackage.TESTCASE_TYPE__TIME:
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
		result.append(" (systemOut: ");
		result.append(systemOut);
		result.append(", systemErr: ");
		result.append(systemErr);
		result.append(", assertions: ");
		result.append(assertions);
		result.append(", classname: ");
		result.append(classname);
		result.append(", name: ");
		result.append(name);
		result.append(", status: ");
		result.append(status);
		result.append(", time: ");
		result.append(time);
		result.append(')');
		return result.toString();
	}

} //TestcaseTypeImpl
