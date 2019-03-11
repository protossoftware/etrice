/**
 */
package org.eclipse.etrice.etunit.converter.Etunit.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot;
import org.eclipse.etrice.etunit.converter.Etunit.ErrorType;
import org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage;
import org.eclipse.etrice.etunit.converter.Etunit.FailureType;
import org.eclipse.etrice.etunit.converter.Etunit.PropertiesType;
import org.eclipse.etrice.etunit.converter.Etunit.PropertyType;
import org.eclipse.etrice.etunit.converter.Etunit.SkippedType;
import org.eclipse.etrice.etunit.converter.Etunit.TestcaseType;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getError <em>Error</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getFailure <em>Failure</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getSkipped <em>Skipped</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getSystemErr <em>System Err</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getSystemOut <em>System Out</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getTestcase <em>Testcase</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getTestsuite <em>Testsuite</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl#getTestsuites <em>Testsuites</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot {
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
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

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
	 * The default value of the '{@link #getSystemOut() <em>System Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemOut()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_OUT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EtunitPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, EtunitPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, EtunitPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, EtunitPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorType getError() {
		return (ErrorType)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__ERROR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetError(ErrorType newError, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(EtunitPackage.Literals.DOCUMENT_ROOT__ERROR, newError, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setError(ErrorType newError) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__ERROR, newError);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FailureType getFailure() {
		return (FailureType)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__FAILURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFailure(FailureType newFailure, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(EtunitPackage.Literals.DOCUMENT_ROOT__FAILURE, newFailure, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFailure(FailureType newFailure) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__FAILURE, newFailure);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertiesType getProperties() {
		return (PropertiesType)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(PropertiesType newProperties, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(EtunitPackage.Literals.DOCUMENT_ROOT__PROPERTIES, newProperties, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperties(PropertiesType newProperties) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__PROPERTIES, newProperties);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyType getProperty() {
		return (PropertyType)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(PropertyType newProperty, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(EtunitPackage.Literals.DOCUMENT_ROOT__PROPERTY, newProperty, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperty(PropertyType newProperty) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__PROPERTY, newProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SkippedType getSkipped() {
		return (SkippedType)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__SKIPPED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSkipped(SkippedType newSkipped, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(EtunitPackage.Literals.DOCUMENT_ROOT__SKIPPED, newSkipped, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSkipped(SkippedType newSkipped) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__SKIPPED, newSkipped);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSystemErr() {
		return (String)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__SYSTEM_ERR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSystemErr(String newSystemErr) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__SYSTEM_ERR, newSystemErr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSystemOut() {
		return (String)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__SYSTEM_OUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSystemOut(String newSystemOut) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__SYSTEM_OUT, newSystemOut);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestcaseType getTestcase() {
		return (TestcaseType)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__TESTCASE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestcase(TestcaseType newTestcase, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(EtunitPackage.Literals.DOCUMENT_ROOT__TESTCASE, newTestcase, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestcase(TestcaseType newTestcase) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__TESTCASE, newTestcase);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestsuiteType getTestsuite() {
		return (TestsuiteType)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__TESTSUITE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestsuite(TestsuiteType newTestsuite, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(EtunitPackage.Literals.DOCUMENT_ROOT__TESTSUITE, newTestsuite, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestsuite(TestsuiteType newTestsuite) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__TESTSUITE, newTestsuite);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestsuitesType getTestsuites() {
		return (TestsuitesType)getMixed().get(EtunitPackage.Literals.DOCUMENT_ROOT__TESTSUITES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestsuites(TestsuitesType newTestsuites, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(EtunitPackage.Literals.DOCUMENT_ROOT__TESTSUITES, newTestsuites, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTestsuites(TestsuitesType newTestsuites) {
		((FeatureMap.Internal)getMixed()).set(EtunitPackage.Literals.DOCUMENT_ROOT__TESTSUITES, newTestsuites);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EtunitPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case EtunitPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case EtunitPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case EtunitPackage.DOCUMENT_ROOT__ERROR:
				return basicSetError(null, msgs);
			case EtunitPackage.DOCUMENT_ROOT__FAILURE:
				return basicSetFailure(null, msgs);
			case EtunitPackage.DOCUMENT_ROOT__PROPERTIES:
				return basicSetProperties(null, msgs);
			case EtunitPackage.DOCUMENT_ROOT__PROPERTY:
				return basicSetProperty(null, msgs);
			case EtunitPackage.DOCUMENT_ROOT__SKIPPED:
				return basicSetSkipped(null, msgs);
			case EtunitPackage.DOCUMENT_ROOT__TESTCASE:
				return basicSetTestcase(null, msgs);
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITE:
				return basicSetTestsuite(null, msgs);
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITES:
				return basicSetTestsuites(null, msgs);
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
			case EtunitPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case EtunitPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case EtunitPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case EtunitPackage.DOCUMENT_ROOT__ERROR:
				return getError();
			case EtunitPackage.DOCUMENT_ROOT__FAILURE:
				return getFailure();
			case EtunitPackage.DOCUMENT_ROOT__PROPERTIES:
				return getProperties();
			case EtunitPackage.DOCUMENT_ROOT__PROPERTY:
				return getProperty();
			case EtunitPackage.DOCUMENT_ROOT__SKIPPED:
				return getSkipped();
			case EtunitPackage.DOCUMENT_ROOT__SYSTEM_ERR:
				return getSystemErr();
			case EtunitPackage.DOCUMENT_ROOT__SYSTEM_OUT:
				return getSystemOut();
			case EtunitPackage.DOCUMENT_ROOT__TESTCASE:
				return getTestcase();
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITE:
				return getTestsuite();
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITES:
				return getTestsuites();
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
			case EtunitPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__ERROR:
				setError((ErrorType)newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__FAILURE:
				setFailure((FailureType)newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__PROPERTIES:
				setProperties((PropertiesType)newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__PROPERTY:
				setProperty((PropertyType)newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__SKIPPED:
				setSkipped((SkippedType)newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__SYSTEM_ERR:
				setSystemErr((String)newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__SYSTEM_OUT:
				setSystemOut((String)newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__TESTCASE:
				setTestcase((TestcaseType)newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITE:
				setTestsuite((TestsuiteType)newValue);
				return;
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITES:
				setTestsuites((TestsuitesType)newValue);
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
			case EtunitPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case EtunitPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case EtunitPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case EtunitPackage.DOCUMENT_ROOT__ERROR:
				setError((ErrorType)null);
				return;
			case EtunitPackage.DOCUMENT_ROOT__FAILURE:
				setFailure((FailureType)null);
				return;
			case EtunitPackage.DOCUMENT_ROOT__PROPERTIES:
				setProperties((PropertiesType)null);
				return;
			case EtunitPackage.DOCUMENT_ROOT__PROPERTY:
				setProperty((PropertyType)null);
				return;
			case EtunitPackage.DOCUMENT_ROOT__SKIPPED:
				setSkipped((SkippedType)null);
				return;
			case EtunitPackage.DOCUMENT_ROOT__SYSTEM_ERR:
				setSystemErr(SYSTEM_ERR_EDEFAULT);
				return;
			case EtunitPackage.DOCUMENT_ROOT__SYSTEM_OUT:
				setSystemOut(SYSTEM_OUT_EDEFAULT);
				return;
			case EtunitPackage.DOCUMENT_ROOT__TESTCASE:
				setTestcase((TestcaseType)null);
				return;
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITE:
				setTestsuite((TestsuiteType)null);
				return;
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITES:
				setTestsuites((TestsuitesType)null);
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
			case EtunitPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case EtunitPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case EtunitPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case EtunitPackage.DOCUMENT_ROOT__ERROR:
				return getError() != null;
			case EtunitPackage.DOCUMENT_ROOT__FAILURE:
				return getFailure() != null;
			case EtunitPackage.DOCUMENT_ROOT__PROPERTIES:
				return getProperties() != null;
			case EtunitPackage.DOCUMENT_ROOT__PROPERTY:
				return getProperty() != null;
			case EtunitPackage.DOCUMENT_ROOT__SKIPPED:
				return getSkipped() != null;
			case EtunitPackage.DOCUMENT_ROOT__SYSTEM_ERR:
				return SYSTEM_ERR_EDEFAULT == null ? getSystemErr() != null : !SYSTEM_ERR_EDEFAULT.equals(getSystemErr());
			case EtunitPackage.DOCUMENT_ROOT__SYSTEM_OUT:
				return SYSTEM_OUT_EDEFAULT == null ? getSystemOut() != null : !SYSTEM_OUT_EDEFAULT.equals(getSystemOut());
			case EtunitPackage.DOCUMENT_ROOT__TESTCASE:
				return getTestcase() != null;
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITE:
				return getTestsuite() != null;
			case EtunitPackage.DOCUMENT_ROOT__TESTSUITES:
				return getTestsuites() != null;
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
