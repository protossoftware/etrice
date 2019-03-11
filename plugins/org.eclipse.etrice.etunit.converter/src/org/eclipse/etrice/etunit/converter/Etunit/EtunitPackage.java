/**
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
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
	String eNS_URI = "http://www.eclipse.org/etrice/etunit/converter/etunit";

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
	 * The feature id for the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ERROR = 3;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FAILURE = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PROPERTIES = 5;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Skipped</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SKIPPED = 7;

	/**
	 * The feature id for the '<em><b>System Err</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SYSTEM_ERR = 8;

	/**
	 * The feature id for the '<em><b>System Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SYSTEM_OUT = 9;

	/**
	 * The feature id for the '<em><b>Testcase</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TESTCASE = 10;

	/**
	 * The feature id for the '<em><b>Testsuite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TESTSUITE = 11;

	/**
	 * The feature id for the '<em><b>Testsuites</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TESTSUITES = 12;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 13;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

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
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TYPE__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TYPE__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Error Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Error Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TYPE_OPERATION_COUNT = 0;

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
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Failure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Failure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAILURE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.PropertiesTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getPropertiesType()
	 * @generated
	 */
	int PROPERTIES_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Properties Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Properties Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.PropertyTypeImpl <em>Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.PropertyTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getPropertyType()
	 * @generated
	 */
	int PROPERTY_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.SkippedTypeImpl <em>Skipped Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.SkippedTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getSkippedType()
	 * @generated
	 */
	int SKIPPED_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIPPED_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIPPED_TYPE__MESSAGE = 1;

	/**
	 * The number of structural features of the '<em>Skipped Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIPPED_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Skipped Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIPPED_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl <em>Testcase Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestcaseTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestcaseType()
	 * @generated
	 */
	int TESTCASE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Skipped</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__SKIPPED = 0;

	/**
	 * The feature id for the '<em><b>Error</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__ERROR = 1;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__FAILURE = 2;

	/**
	 * The feature id for the '<em><b>System Out</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__SYSTEM_OUT = 3;

	/**
	 * The feature id for the '<em><b>System Err</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__SYSTEM_ERR = 4;

	/**
	 * The feature id for the '<em><b>Assertions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__ASSERTIONS = 5;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__CLASSNAME = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__NAME = 7;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__STATUS = 8;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE__TIME = 9;

	/**
	 * The number of structural features of the '<em>Testcase Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Testcase Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTCASE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl <em>Testsuites Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuitesTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestsuitesType()
	 * @generated
	 */
	int TESTSUITES_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Testsuite</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE__TESTSUITE = 0;

	/**
	 * The feature id for the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE__DISABLED = 1;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE__ERRORS = 2;

	/**
	 * The feature id for the '<em><b>Failures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE__FAILURES = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Tests</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE__TESTS = 5;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE__TIME = 6;

	/**
	 * The number of structural features of the '<em>Testsuites Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Testsuites Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl <em>Testsuite Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.TestsuiteTypeImpl
	 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getTestsuiteType()
	 * @generated
	 */
	int TESTSUITE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__PROPERTIES = 0;

	/**
	 * The feature id for the '<em><b>Testcase</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__TESTCASE = 1;

	/**
	 * The feature id for the '<em><b>System Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__SYSTEM_OUT = 2;

	/**
	 * The feature id for the '<em><b>System Err</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__SYSTEM_ERR = 3;

	/**
	 * The feature id for the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__DISABLED = 4;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__ERRORS = 5;

	/**
	 * The feature id for the '<em><b>Failures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__FAILURES = 6;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__HOSTNAME = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__ID = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__NAME = 9;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__PACKAGE = 10;

	/**
	 * The feature id for the '<em><b>Skipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__SKIPPED = 11;

	/**
	 * The feature id for the '<em><b>Tests</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__TESTS = 12;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__TIME = 13;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE__TIMESTAMP = 14;

	/**
	 * The number of structural features of the '<em>Testsuite Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE_FEATURE_COUNT = 15;

	/**
	 * The number of operations of the '<em>Testsuite Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTSUITE_TYPE_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Error</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getError()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Error();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getFailure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Failure</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getFailure()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Failure();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Properties</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getProperties()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getProperty()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Property();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getSkipped <em>Skipped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Skipped</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getSkipped()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Skipped();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getSystemErr <em>System Err</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Err</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getSystemErr()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_SystemErr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getSystemOut <em>System Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Out</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getSystemOut()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_SystemOut();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestcase <em>Testcase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Testcase</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestcase()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Testcase();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getMessage()
	 * @see #getErrorType()
	 * @generated
	 */
	EAttribute getErrorType_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.ErrorType#getType()
	 * @see #getErrorType()
	 * @generated
	 */
	EAttribute getErrorType_Type();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.FailureType#getMessage()
	 * @see #getFailureType()
	 * @generated
	 */
	EAttribute getFailureType_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.FailureType#getType()
	 * @see #getFailureType()
	 * @generated
	 */
	EAttribute getFailureType_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.PropertiesType <em>Properties Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.PropertiesType
	 * @generated
	 */
	EClass getPropertiesType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.etunit.converter.Etunit.PropertiesType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.PropertiesType#getProperty()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EReference getPropertiesType_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.PropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.PropertyType
	 * @generated
	 */
	EClass getPropertyType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.PropertyType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.PropertyType#getName()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.PropertyType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.PropertyType#getValue()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.etunit.converter.Etunit.SkippedType <em>Skipped Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skipped Type</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.SkippedType
	 * @generated
	 */
	EClass getSkippedType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.etunit.converter.Etunit.SkippedType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.SkippedType#getMixed()
	 * @see #getSkippedType()
	 * @generated
	 */
	EAttribute getSkippedType_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.SkippedType#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.SkippedType#getMessage()
	 * @see #getSkippedType()
	 * @generated
	 */
	EAttribute getSkippedType_Message();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSkipped <em>Skipped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Skipped</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSkipped()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EReference getTestcaseType_Skipped();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getError()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EReference getTestcaseType_Error();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getFailure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Failure</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getFailure()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EReference getTestcaseType_Failure();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSystemOut <em>System Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>System Out</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSystemOut()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EAttribute getTestcaseType_SystemOut();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSystemErr <em>System Err</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>System Err</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSystemErr()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EAttribute getTestcaseType_SystemErr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getAssertions <em>Assertions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assertions</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getAssertions()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EAttribute getTestcaseType_Assertions();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getStatus()
	 * @see #getTestcaseType()
	 * @generated
	 */
	EAttribute getTestcaseType_Status();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getDisabled <em>Disabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disabled</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getDisabled()
	 * @see #getTestsuitesType()
	 * @generated
	 */
	EAttribute getTestsuitesType_Disabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Errors</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getErrors()
	 * @see #getTestsuitesType()
	 * @generated
	 */
	EAttribute getTestsuitesType_Errors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getFailures <em>Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failures</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getFailures()
	 * @see #getTestsuitesType()
	 * @generated
	 */
	EAttribute getTestsuitesType_Failures();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getName()
	 * @see #getTestsuitesType()
	 * @generated
	 */
	EAttribute getTestsuitesType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTests <em>Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tests</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTests()
	 * @see #getTestsuitesType()
	 * @generated
	 */
	EAttribute getTestsuitesType_Tests();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTime()
	 * @see #getTestsuitesType()
	 * @generated
	 */
	EAttribute getTestsuitesType_Time();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Properties</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getProperties()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EReference getTestsuiteType_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTestcase <em>Testcase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Testcase</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTestcase()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EReference getTestsuiteType_Testcase();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSystemOut <em>System Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Out</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSystemOut()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_SystemOut();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSystemErr <em>System Err</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Err</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSystemErr()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_SystemErr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getDisabled <em>Disabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disabled</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getDisabled()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Disabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Errors</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getErrors()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Errors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getFailures <em>Failures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failures</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getFailures()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Failures();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getHostname <em>Hostname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hostname</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getHostname()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Hostname();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getId()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getName()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getPackage()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Package();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSkipped <em>Skipped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skipped</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSkipped()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Skipped();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTests <em>Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tests</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTests()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Tests();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTime()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Time();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTimestamp()
	 * @see #getTestsuiteType()
	 * @generated
	 */
	EAttribute getTestsuiteType_Timestamp();

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
	 *   <li>each operation of each class,</li>
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
		 * The meta object literal for the '<em><b>Error</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ERROR = eINSTANCE.getDocumentRoot_Error();

		/**
		 * The meta object literal for the '<em><b>Failure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FAILURE = eINSTANCE.getDocumentRoot_Failure();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PROPERTIES = eINSTANCE.getDocumentRoot_Properties();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PROPERTY = eINSTANCE.getDocumentRoot_Property();

		/**
		 * The meta object literal for the '<em><b>Skipped</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SKIPPED = eINSTANCE.getDocumentRoot_Skipped();

		/**
		 * The meta object literal for the '<em><b>System Err</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__SYSTEM_ERR = eINSTANCE.getDocumentRoot_SystemErr();

		/**
		 * The meta object literal for the '<em><b>System Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__SYSTEM_OUT = eINSTANCE.getDocumentRoot_SystemOut();

		/**
		 * The meta object literal for the '<em><b>Testcase</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TESTCASE = eINSTANCE.getDocumentRoot_Testcase();

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
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_TYPE__MESSAGE = eINSTANCE.getErrorType_Message();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_TYPE__TYPE = eINSTANCE.getErrorType_Type();

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
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_TYPE__MESSAGE = eINSTANCE.getFailureType_Message();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAILURE_TYPE__TYPE = eINSTANCE.getFailureType_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.PropertiesTypeImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getPropertiesType()
		 * @generated
		 */
		EClass PROPERTIES_TYPE = eINSTANCE.getPropertiesType();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES_TYPE__PROPERTY = eINSTANCE.getPropertiesType_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.PropertyTypeImpl <em>Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.PropertyTypeImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getPropertyType()
		 * @generated
		 */
		EClass PROPERTY_TYPE = eINSTANCE.getPropertyType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__NAME = eINSTANCE.getPropertyType_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__VALUE = eINSTANCE.getPropertyType_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.etunit.converter.Etunit.impl.SkippedTypeImpl <em>Skipped Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.SkippedTypeImpl
		 * @see org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitPackageImpl#getSkippedType()
		 * @generated
		 */
		EClass SKIPPED_TYPE = eINSTANCE.getSkippedType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKIPPED_TYPE__MIXED = eINSTANCE.getSkippedType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKIPPED_TYPE__MESSAGE = eINSTANCE.getSkippedType_Message();

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
		 * The meta object literal for the '<em><b>Skipped</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTCASE_TYPE__SKIPPED = eINSTANCE.getTestcaseType_Skipped();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTCASE_TYPE__ERROR = eINSTANCE.getTestcaseType_Error();

		/**
		 * The meta object literal for the '<em><b>Failure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTCASE_TYPE__FAILURE = eINSTANCE.getTestcaseType_Failure();

		/**
		 * The meta object literal for the '<em><b>System Out</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTCASE_TYPE__SYSTEM_OUT = eINSTANCE.getTestcaseType_SystemOut();

		/**
		 * The meta object literal for the '<em><b>System Err</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTCASE_TYPE__SYSTEM_ERR = eINSTANCE.getTestcaseType_SystemErr();

		/**
		 * The meta object literal for the '<em><b>Assertions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTCASE_TYPE__ASSERTIONS = eINSTANCE.getTestcaseType_Assertions();

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
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTCASE_TYPE__STATUS = eINSTANCE.getTestcaseType_Status();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTCASE_TYPE__TIME = eINSTANCE.getTestcaseType_Time();

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
		 * The meta object literal for the '<em><b>Disabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITES_TYPE__DISABLED = eINSTANCE.getTestsuitesType_Disabled();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITES_TYPE__ERRORS = eINSTANCE.getTestsuitesType_Errors();

		/**
		 * The meta object literal for the '<em><b>Failures</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITES_TYPE__FAILURES = eINSTANCE.getTestsuitesType_Failures();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITES_TYPE__NAME = eINSTANCE.getTestsuitesType_Name();

		/**
		 * The meta object literal for the '<em><b>Tests</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITES_TYPE__TESTS = eINSTANCE.getTestsuitesType_Tests();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITES_TYPE__TIME = eINSTANCE.getTestsuitesType_Time();

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
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTSUITE_TYPE__PROPERTIES = eINSTANCE.getTestsuiteType_Properties();

		/**
		 * The meta object literal for the '<em><b>Testcase</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTSUITE_TYPE__TESTCASE = eINSTANCE.getTestsuiteType_Testcase();

		/**
		 * The meta object literal for the '<em><b>System Out</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__SYSTEM_OUT = eINSTANCE.getTestsuiteType_SystemOut();

		/**
		 * The meta object literal for the '<em><b>System Err</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__SYSTEM_ERR = eINSTANCE.getTestsuiteType_SystemErr();

		/**
		 * The meta object literal for the '<em><b>Disabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__DISABLED = eINSTANCE.getTestsuiteType_Disabled();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__ERRORS = eINSTANCE.getTestsuiteType_Errors();

		/**
		 * The meta object literal for the '<em><b>Failures</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__FAILURES = eINSTANCE.getTestsuiteType_Failures();

		/**
		 * The meta object literal for the '<em><b>Hostname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__HOSTNAME = eINSTANCE.getTestsuiteType_Hostname();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__ID = eINSTANCE.getTestsuiteType_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__NAME = eINSTANCE.getTestsuiteType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__PACKAGE = eINSTANCE.getTestsuiteType_Package();

		/**
		 * The meta object literal for the '<em><b>Skipped</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__SKIPPED = eINSTANCE.getTestsuiteType_Skipped();

		/**
		 * The meta object literal for the '<em><b>Tests</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__TESTS = eINSTANCE.getTestsuiteType_Tests();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__TIME = eINSTANCE.getTestsuiteType_Time();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTSUITE_TYPE__TIMESTAMP = eINSTANCE.getTestsuiteType_Timestamp();

	}

} //EtunitPackage
