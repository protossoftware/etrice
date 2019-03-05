/**
 */
package org.eclipse.etrice.etunit.converter.Etunit.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot;
import org.eclipse.etrice.etunit.converter.Etunit.ErrorType;
import org.eclipse.etrice.etunit.converter.Etunit.EtunitFactory;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EtunitPackageImpl extends EPackageImpl implements EtunitPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass skippedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testcaseTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testsuitesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testsuiteTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EtunitPackageImpl() {
		super(eNS_URI, EtunitFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link EtunitPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EtunitPackage init() {
		if (isInited) return (EtunitPackage)EPackage.Registry.INSTANCE.getEPackage(EtunitPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEtunitPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EtunitPackageImpl theEtunitPackage = registeredEtunitPackage instanceof EtunitPackageImpl ? (EtunitPackageImpl)registeredEtunitPackage : new EtunitPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEtunitPackage.createPackageContents();

		// Initialize created meta-data
		theEtunitPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEtunitPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EtunitPackage.eNS_URI, theEtunitPackage);
		return theEtunitPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Error() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Failure() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Properties() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Property() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Skipped() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDocumentRoot_SystemErr() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDocumentRoot_SystemOut() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Testcase() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Testsuite() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Testsuites() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorType() {
		return errorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getErrorType_Mixed() {
		return (EAttribute)errorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getErrorType_Message() {
		return (EAttribute)errorTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getErrorType_Type() {
		return (EAttribute)errorTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFailureType() {
		return failureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFailureType_Mixed() {
		return (EAttribute)failureTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFailureType_Message() {
		return (EAttribute)failureTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFailureType_Type() {
		return (EAttribute)failureTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertiesType() {
		return propertiesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertiesType_Property() {
		return (EReference)propertiesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyType() {
		return propertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyType_Name() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyType_Value() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSkippedType() {
		return skippedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSkippedType_Mixed() {
		return (EAttribute)skippedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSkippedType_Message() {
		return (EAttribute)skippedTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestcaseType() {
		return testcaseTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestcaseType_Skipped() {
		return (EReference)testcaseTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestcaseType_Error() {
		return (EReference)testcaseTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestcaseType_Failure() {
		return (EReference)testcaseTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestcaseType_SystemOut() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestcaseType_SystemErr() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestcaseType_Assertions() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestcaseType_Classname() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestcaseType_Name() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestcaseType_Status() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestcaseType_Time() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestsuitesType() {
		return testsuitesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestsuitesType_Testsuite() {
		return (EReference)testsuitesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuitesType_Disabled() {
		return (EAttribute)testsuitesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuitesType_Errors() {
		return (EAttribute)testsuitesTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuitesType_Failures() {
		return (EAttribute)testsuitesTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuitesType_Name() {
		return (EAttribute)testsuitesTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuitesType_Tests() {
		return (EAttribute)testsuitesTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuitesType_Time() {
		return (EAttribute)testsuitesTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestsuiteType() {
		return testsuiteTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestsuiteType_Properties() {
		return (EReference)testsuiteTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestsuiteType_Testcase() {
		return (EReference)testsuiteTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_SystemOut() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_SystemErr() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Disabled() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Errors() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Failures() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Hostname() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Id() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Name() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Package() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Skipped() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Tests() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Time() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestsuiteType_Timestamp() {
		return (EAttribute)testsuiteTypeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EtunitFactory getEtunitFactory() {
		return (EtunitFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ERROR);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FAILURE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTIES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SKIPPED);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__SYSTEM_ERR);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__SYSTEM_OUT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TESTCASE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TESTSUITE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TESTSUITES);

		errorTypeEClass = createEClass(ERROR_TYPE);
		createEAttribute(errorTypeEClass, ERROR_TYPE__MIXED);
		createEAttribute(errorTypeEClass, ERROR_TYPE__MESSAGE);
		createEAttribute(errorTypeEClass, ERROR_TYPE__TYPE);

		failureTypeEClass = createEClass(FAILURE_TYPE);
		createEAttribute(failureTypeEClass, FAILURE_TYPE__MIXED);
		createEAttribute(failureTypeEClass, FAILURE_TYPE__MESSAGE);
		createEAttribute(failureTypeEClass, FAILURE_TYPE__TYPE);

		propertiesTypeEClass = createEClass(PROPERTIES_TYPE);
		createEReference(propertiesTypeEClass, PROPERTIES_TYPE__PROPERTY);

		propertyTypeEClass = createEClass(PROPERTY_TYPE);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__NAME);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__VALUE);

		skippedTypeEClass = createEClass(SKIPPED_TYPE);
		createEAttribute(skippedTypeEClass, SKIPPED_TYPE__MIXED);
		createEAttribute(skippedTypeEClass, SKIPPED_TYPE__MESSAGE);

		testcaseTypeEClass = createEClass(TESTCASE_TYPE);
		createEReference(testcaseTypeEClass, TESTCASE_TYPE__SKIPPED);
		createEReference(testcaseTypeEClass, TESTCASE_TYPE__ERROR);
		createEReference(testcaseTypeEClass, TESTCASE_TYPE__FAILURE);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__SYSTEM_OUT);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__SYSTEM_ERR);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__ASSERTIONS);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__CLASSNAME);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__NAME);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__STATUS);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__TIME);

		testsuitesTypeEClass = createEClass(TESTSUITES_TYPE);
		createEReference(testsuitesTypeEClass, TESTSUITES_TYPE__TESTSUITE);
		createEAttribute(testsuitesTypeEClass, TESTSUITES_TYPE__DISABLED);
		createEAttribute(testsuitesTypeEClass, TESTSUITES_TYPE__ERRORS);
		createEAttribute(testsuitesTypeEClass, TESTSUITES_TYPE__FAILURES);
		createEAttribute(testsuitesTypeEClass, TESTSUITES_TYPE__NAME);
		createEAttribute(testsuitesTypeEClass, TESTSUITES_TYPE__TESTS);
		createEAttribute(testsuitesTypeEClass, TESTSUITES_TYPE__TIME);

		testsuiteTypeEClass = createEClass(TESTSUITE_TYPE);
		createEReference(testsuiteTypeEClass, TESTSUITE_TYPE__PROPERTIES);
		createEReference(testsuiteTypeEClass, TESTSUITE_TYPE__TESTCASE);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__SYSTEM_OUT);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__SYSTEM_ERR);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__DISABLED);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__ERRORS);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__FAILURES);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__HOSTNAME);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__ID);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__NAME);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__PACKAGE);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__SKIPPED);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__TESTS);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__TIME);
		createEAttribute(testsuiteTypeEClass, TESTSUITE_TYPE__TIMESTAMP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Error(), this.getErrorType(), null, "error", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Failure(), this.getFailureType(), null, "failure", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Properties(), this.getPropertiesType(), null, "properties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Property(), this.getPropertyType(), null, "property", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Skipped(), this.getSkippedType(), null, "skipped", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_SystemErr(), theXMLTypePackage.getString(), "systemErr", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_SystemOut(), theXMLTypePackage.getString(), "systemOut", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Testcase(), this.getTestcaseType(), null, "testcase", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Testsuite(), this.getTestsuiteType(), null, "testsuite", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Testsuites(), this.getTestsuitesType(), null, "testsuites", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(errorTypeEClass, ErrorType.class, "ErrorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getErrorType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorType_Message(), theXMLTypePackage.getString(), "message", null, 0, 1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorType_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(failureTypeEClass, FailureType.class, "FailureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFailureType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, FailureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailureType_Message(), theXMLTypePackage.getString(), "message", null, 0, 1, FailureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailureType_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, FailureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertiesTypeEClass, PropertiesType.class, "PropertiesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertiesType_Property(), this.getPropertyType(), null, "property", null, 1, -1, PropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyTypeEClass, PropertyType.class, "PropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyType_Value(), theXMLTypePackage.getString(), "value", null, 1, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(skippedTypeEClass, SkippedType.class, "SkippedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSkippedType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, SkippedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSkippedType_Message(), theXMLTypePackage.getString(), "message", null, 0, 1, SkippedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testcaseTypeEClass, TestcaseType.class, "TestcaseType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestcaseType_Skipped(), this.getSkippedType(), null, "skipped", null, 0, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestcaseType_Error(), this.getErrorType(), null, "error", null, 0, -1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestcaseType_Failure(), this.getFailureType(), null, "failure", null, 0, -1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_SystemOut(), theXMLTypePackage.getString(), "systemOut", null, 0, -1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_SystemErr(), theXMLTypePackage.getString(), "systemErr", null, 0, -1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_Assertions(), theXMLTypePackage.getString(), "assertions", null, 0, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_Classname(), theXMLTypePackage.getString(), "classname", null, 0, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_Status(), theXMLTypePackage.getString(), "status", null, 0, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_Time(), theXMLTypePackage.getString(), "time", null, 0, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testsuitesTypeEClass, TestsuitesType.class, "TestsuitesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestsuitesType_Testsuite(), this.getTestsuiteType(), null, "testsuite", null, 0, -1, TestsuitesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuitesType_Disabled(), theXMLTypePackage.getString(), "disabled", null, 0, 1, TestsuitesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuitesType_Errors(), theXMLTypePackage.getString(), "errors", null, 0, 1, TestsuitesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuitesType_Failures(), theXMLTypePackage.getString(), "failures", null, 0, 1, TestsuitesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuitesType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TestsuitesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuitesType_Tests(), theXMLTypePackage.getString(), "tests", null, 0, 1, TestsuitesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuitesType_Time(), theXMLTypePackage.getString(), "time", null, 0, 1, TestsuitesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testsuiteTypeEClass, TestsuiteType.class, "TestsuiteType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestsuiteType_Properties(), this.getPropertiesType(), null, "properties", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestsuiteType_Testcase(), this.getTestcaseType(), null, "testcase", null, 0, -1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_SystemOut(), theXMLTypePackage.getString(), "systemOut", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_SystemErr(), theXMLTypePackage.getString(), "systemErr", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Disabled(), theXMLTypePackage.getString(), "disabled", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Errors(), theXMLTypePackage.getString(), "errors", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Failures(), theXMLTypePackage.getString(), "failures", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Hostname(), theXMLTypePackage.getString(), "hostname", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Skipped(), theXMLTypePackage.getString(), "skipped", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Tests(), theXMLTypePackage.getString(), "tests", null, 1, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Time(), theXMLTypePackage.getString(), "time", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuiteType_Timestamp(), theXMLTypePackage.getString(), "timestamp", null, 0, 1, TestsuiteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "qualified", "false"
		   });
		addAnnotation
		  (documentRootEClass,
		   source,
		   new String[] {
			   "name", "",
			   "kind", "mixed"
		   });
		addAnnotation
		  (getDocumentRoot_Mixed(),
		   source,
		   new String[] {
			   "kind", "elementWildcard",
			   "name", ":mixed"
		   });
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "xmlns:prefix"
		   });
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "xsi:schemaLocation"
		   });
		addAnnotation
		  (getDocumentRoot_Error(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "error",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDocumentRoot_Failure(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "failure",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDocumentRoot_Properties(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "properties",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDocumentRoot_Property(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "property",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDocumentRoot_Skipped(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "skipped",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDocumentRoot_SystemErr(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "system-err",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDocumentRoot_SystemOut(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "system-out",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDocumentRoot_Testcase(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "testcase",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDocumentRoot_Testsuite(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "testsuite",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getDocumentRoot_Testsuites(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "testsuites",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (errorTypeEClass,
		   source,
		   new String[] {
			   "name", "error_._type",
			   "kind", "mixed"
		   });
		addAnnotation
		  (getErrorType_Mixed(),
		   source,
		   new String[] {
			   "kind", "elementWildcard",
			   "name", ":mixed"
		   });
		addAnnotation
		  (getErrorType_Message(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "message",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getErrorType_Type(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "type",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (failureTypeEClass,
		   source,
		   new String[] {
			   "name", "failure_._type",
			   "kind", "mixed"
		   });
		addAnnotation
		  (getFailureType_Mixed(),
		   source,
		   new String[] {
			   "kind", "elementWildcard",
			   "name", ":mixed"
		   });
		addAnnotation
		  (getFailureType_Message(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "message",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getFailureType_Type(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "type",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (propertiesTypeEClass,
		   source,
		   new String[] {
			   "name", "properties_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getPropertiesType_Property(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "property",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (propertyTypeEClass,
		   source,
		   new String[] {
			   "name", "property_._type",
			   "kind", "empty"
		   });
		addAnnotation
		  (getPropertyType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getPropertyType_Value(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "value",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (skippedTypeEClass,
		   source,
		   new String[] {
			   "name", "skipped_._type",
			   "kind", "mixed"
		   });
		addAnnotation
		  (getSkippedType_Mixed(),
		   source,
		   new String[] {
			   "kind", "elementWildcard",
			   "name", ":mixed"
		   });
		addAnnotation
		  (getSkippedType_Message(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "message",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (testcaseTypeEClass,
		   source,
		   new String[] {
			   "name", "testcase_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getTestcaseType_Skipped(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "skipped",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestcaseType_Error(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "error",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestcaseType_Failure(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "failure",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestcaseType_SystemOut(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "system-out",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestcaseType_SystemErr(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "system-err",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestcaseType_Assertions(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "assertions",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestcaseType_Classname(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "classname",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestcaseType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestcaseType_Status(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "status",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestcaseType_Time(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "time",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (testsuitesTypeEClass,
		   source,
		   new String[] {
			   "name", "testsuites_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getTestsuitesType_Testsuite(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "testsuite",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuitesType_Disabled(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "disabled",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuitesType_Errors(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "errors",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuitesType_Failures(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "failures",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuitesType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuitesType_Tests(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "tests",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuitesType_Time(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "time",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (testsuiteTypeEClass,
		   source,
		   new String[] {
			   "name", "testsuite_._type",
			   "kind", "elementOnly"
		   });
		addAnnotation
		  (getTestsuiteType_Properties(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "properties",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Testcase(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "testcase",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_SystemOut(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "system-out",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_SystemErr(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "system-err",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Disabled(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "disabled",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Errors(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "errors",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Failures(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "failures",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Hostname(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "hostname",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Id(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "id",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Package(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "package",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Skipped(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "skipped",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Tests(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "tests",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Time(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "time",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTestsuiteType_Timestamp(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "timestamp",
			   "namespace", "##targetNamespace"
		   });
	}

} //EtunitPackageImpl
