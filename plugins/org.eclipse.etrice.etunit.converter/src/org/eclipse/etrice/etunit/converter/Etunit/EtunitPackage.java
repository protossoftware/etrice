/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * etUnit test result schema.
 *     
 * <!-- end-model-doc -->
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface EtunitPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Etunit";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/org.eclipse.etrice.etunit.converter/model/etunit.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Etunit";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EtunitPackage eINSTANCE = org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Testsuite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TESTSUITE = 3;

	/**
	 * The feature id for the '<em><b>Testsuites</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TESTSUITES = 4;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.ErrorTypeImpl <em>Error Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.ErrorTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getErrorType()
	 * @generated
	 */
	int ERROR_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TYPE__EXPECTED = 1;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TYPE__ACTUAL = 2;

	/**
	 * The number of structural features of the '<em>Error Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.FailureTypeImpl <em>Failure Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.FailureTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getFailureType()
	 * @generated
	 */
	int FAILURE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE__EXPECTED = 1;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE__ACTUAL = 2;

	/**
	 * The number of structural features of the '<em>Failure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl <em>Testcase Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestcaseType()
	 * @generated
	 */
	int TESTCASE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__ERROR = 0;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__FAILURE = 1;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__CLASSNAME = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__TIME = 4;

	/**
	 * The number of structural features of the '<em>Testcase Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl <em>Testsuite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestsuite()
	 * @generated
	 */
	int TESTSUITE = 4;

	/**
	 * The feature id for the '<em><b>Testcase</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE__TESTCASE = 0;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE__ERRORS = 1;

	/**
	 * The feature id for the '<em><b>Failures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE__FAILURES = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Skipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE__SKIPPED = 4;

	/**
	 * The feature id for the '<em><b>Tests</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE__TESTS = 5;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE__TIME = 6;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE__TIMESTAMP = 7;

	/**
	 * The number of structural features of the '<em>Testsuite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl <em>Testsuites Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestsuitesType()
	 * @generated
	 */
	int TESTSUITES_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Testsuite</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE__TESTSUITE = 0;

	/**
	 * The number of structural features of the '<em>Testsuites Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl <em>Testsuite Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestsuiteType()
	 * @generated
	 */
	int TESTSUITE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Testcase</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__TESTCASE = TESTSUITE__TESTCASE;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__ERRORS = TESTSUITE__ERRORS;

	/**
	 * The feature id for the '<em><b>Failures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__FAILURES = TESTSUITE__FAILURES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__NAME = TESTSUITE__NAME;

	/**
	 * The feature id for the '<em><b>Skipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__SKIPPED = TESTSUITE__SKIPPED;

	/**
	 * The feature id for the '<em><b>Tests</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__TESTS = TESTSUITE__TESTS;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__TIME = TESTSUITE__TIME;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__TIMESTAMP = TESTSUITE__TIMESTAMP;

	/**
	 * The number of structural features of the '<em>Testsuite Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE_FEATURE_COUNT = TESTSUITE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>ISO8601DATETIMEPATTERN</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.xml.datatype.XMLGregorianCalendar
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getISO8601DATETIMEPATTERN()
	 * @generated
	 */
	int ISO8601DATETIMEPATTERN = 7;

	/**
	 * The meta object id for the '<em>Name Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getNameType()
	 * @generated
	 */
	int NAME_TYPE = 8;

	/**
	 * The meta object id for the '<em>Pre String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getPreString()
	 * @generated
	 */
	int PRE_STRING = 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestsuite <em>Testsuite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Testsuite</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestsuite()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Testsuite();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestsuites <em>Testsuites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Testsuites</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestsuites()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Testsuites();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.ErrorType <em>Error Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.ErrorType
	 * @generated
	 */
	EClass getErrorType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getMixed()
	 * @see #getErrorType()
	 * @generated
	 */
	EAttribute getErrorType_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getExpected <em>Expected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getExpected()
	 * @see #getErrorType()
	 * @generated
	 */
	EAttribute getErrorType_Expected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getActual <em>Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actual</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getActual()
	 * @see #getErrorType()
	 * @generated
	 */
	EAttribute getErrorType_Actual();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType <em>Failure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Failure Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.FailureType
	 * @generated
	 */
	EClass getFailureType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.FailureType#getMixed()
	 * @see #getFailureType()
	 * @generated
	 */
	EAttribute getFailureType_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getExpected <em>Expected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.FailureType#getExpected()
	 * @see #getFailureType()
	 * @generated
	 */
	EAttribute getFailureType_Expected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getActual <em>Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actual</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.FailureType#getActual()
	 * @see #getFailureType()
	 * @generated
	 */
	EAttribute getFailureType_Actual();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType <em>Testcase Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Testcase Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType
	 * @generated
	 */
	EClass getTestcaseType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Error</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getError()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EReference getTestcaseType_Error();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getFailure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Failure</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getFailure()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EReference getTestcaseType_Failure();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getClassname <em>Classname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classname</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getClassname()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EAttribute getTestcaseType_Classname();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getName()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EAttribute getTestcaseType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getTime()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EAttribute getTestcaseType_Time();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite <em>Testsuite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Testsuite</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.Testsuite
	 * @generated
	 */
	EClass getTestsuite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTestcase <em>Testcase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Testcase</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTestcase()
	 * @see #getTestsuite()
	 * @generated
	 */
	EReference getTestsuite_Testcase();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Errors</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getErrors()
	 * @see #getTestsuite()
	 * @generated
	 */
	EAttribute getTestsuite_Errors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getFailures <em>Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failures</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getFailures()
	 * @see #getTestsuite()
	 * @generated
	 */
	EAttribute getTestsuite_Failures();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getName()
	 * @see #getTestsuite()
	 * @generated
	 */
	EAttribute getTestsuite_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getSkipped <em>Skipped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skipped</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getSkipped()
	 * @see #getTestsuite()
	 * @generated
	 */
	EAttribute getTestsuite_Skipped();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTests <em>Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tests</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTests()
	 * @see #getTestsuite()
	 * @generated
	 */
	EAttribute getTestsuite_Tests();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTime()
	 * @see #getTestsuite()
	 * @generated
	 */
	EAttribute getTestsuite_Time();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTimestamp()
	 * @see #getTestsuite()
	 * @generated
	 */
	EAttribute getTestsuite_Timestamp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType <em>Testsuites Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Testsuites Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType
	 * @generated
	 */
	EClass getTestsuitesType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTestsuite <em>Testsuite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Testsuite</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTestsuite()
	 * @see #getTestsuitesType()
	 * @generated
	 */
	EReference getTestsuitesType_Testsuite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType <em>Testsuite Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Testsuite Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType
	 * @generated
	 */
	EClass getTestsuiteType();

	/**
	 * Returns the meta object for data type '{@link javax.xml.datatype.XMLGregorianCalendar <em>ISO8601DATETIMEPATTERN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ISO8601DATETIMEPATTERN</em>'.
	 * @see javax.xml.datatype.XMLGregorianCalendar
	 * @model instanceClass="javax.xml.datatype.XMLGregorianCalendar"
	 *        extendedMetaData="name='ISO8601_DATETIME_PATTERN' baseType='http://www.eclipse.org/emf/2003/XMLType#dateTime' pattern='[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}'"
	 * @generated
	 */
	EDataType getISO8601DATETIMEPATTERN();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Name Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Name Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='name_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#token' minLength='1'"
	 * @generated
	 */
	EDataType getNameType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Pre String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Pre String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='pre-string' baseType='http://www.eclipse.org/emf/2003/XMLType#string' whiteSpace='preserve'"
	 * @generated
	 */
	EDataType getPreString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EtunitFactory getEtunitFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.DocumentRootImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Testsuite</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TESTSUITE = eINSTANCE.getDocumentRoot_Testsuite();

		/**
		 * The meta object literal for the '<em><b>Testsuites</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TESTSUITES = eINSTANCE.getDocumentRoot_Testsuites();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.ErrorTypeImpl <em>Error Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.ErrorTypeImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getErrorType()
		 * @generated
		 */
		EClass ERROR_TYPE = eINSTANCE.getErrorType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_TYPE__MIXED = eINSTANCE.getErrorType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Expected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_TYPE__EXPECTED = eINSTANCE.getErrorType_Expected();

		/**
		 * The meta object literal for the '<em><b>Actual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_TYPE__ACTUAL = eINSTANCE.getErrorType_Actual();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.FailureTypeImpl <em>Failure Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.FailureTypeImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getFailureType()
		 * @generated
		 */
		EClass FAILURE_TYPE = eINSTANCE.getFailureType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_TYPE__MIXED = eINSTANCE.getFailureType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Expected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_TYPE__EXPECTED = eINSTANCE.getFailureType_Expected();

		/**
		 * The meta object literal for the '<em><b>Actual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_TYPE__ACTUAL = eINSTANCE.getFailureType_Actual();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl <em>Testcase Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestcaseType()
		 * @generated
		 */
		EClass TESTCASE_TYPE = eINSTANCE.getTestcaseType();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTCASE_TYPE__ERROR = eINSTANCE.getTestcaseType_Error();

		/**
		 * The meta object literal for the '<em><b>Failure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTCASE_TYPE__FAILURE = eINSTANCE.getTestcaseType_Failure();

		/**
		 * The meta object literal for the '<em><b>Classname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTCASE_TYPE__CLASSNAME = eINSTANCE.getTestcaseType_Classname();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTCASE_TYPE__NAME = eINSTANCE.getTestcaseType_Name();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTCASE_TYPE__TIME = eINSTANCE.getTestcaseType_Time();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl <em>Testsuite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestsuite()
		 * @generated
		 */
		EClass TESTSUITE = eINSTANCE.getTestsuite();

		/**
		 * The meta object literal for the '<em><b>Testcase</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTSUITE__TESTCASE = eINSTANCE.getTestsuite_Testcase();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE__ERRORS = eINSTANCE.getTestsuite_Errors();

		/**
		 * The meta object literal for the '<em><b>Failures</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE__FAILURES = eINSTANCE.getTestsuite_Failures();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE__NAME = eINSTANCE.getTestsuite_Name();

		/**
		 * The meta object literal for the '<em><b>Skipped</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE__SKIPPED = eINSTANCE.getTestsuite_Skipped();

		/**
		 * The meta object literal for the '<em><b>Tests</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE__TESTS = eINSTANCE.getTestsuite_Tests();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE__TIME = eINSTANCE.getTestsuite_Time();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE__TIMESTAMP = eINSTANCE.getTestsuite_Timestamp();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl <em>Testsuites Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestsuitesType()
		 * @generated
		 */
		EClass TESTSUITES_TYPE = eINSTANCE.getTestsuitesType();

		/**
		 * The meta object literal for the '<em><b>Testsuite</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTSUITES_TYPE__TESTSUITE = eINSTANCE.getTestsuitesType_Testsuite();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl <em>Testsuite Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestsuiteType()
		 * @generated
		 */
		EClass TESTSUITE_TYPE = eINSTANCE.getTestsuiteType();

		/**
		 * The meta object literal for the '<em>ISO8601DATETIMEPATTERN</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.xml.datatype.XMLGregorianCalendar
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getISO8601DATETIMEPATTERN()
		 * @generated
		 */
		EDataType ISO8601DATETIMEPATTERN = eINSTANCE.getISO8601DATETIMEPATTERN();

		/**
		 * The meta object literal for the '<em>Name Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getNameType()
		 * @generated
		 */
		EDataType NAME_TYPE = eINSTANCE.getNameType();

		/**
		 * The meta object literal for the '<em>Pre String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getPreString()
		 * @generated
		 */
		EDataType PRE_STRING = eINSTANCE.getPreString();

	}

} //EtunitPackage
