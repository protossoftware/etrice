/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit.impl;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot;
import org.eclipse.etrice.etunit.converter.Etunit.ErrorType;
import org.eclipse.etrice.etunit.converter.Etunit.EtunitFactory;
import org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage;
import org.eclipse.etrice.etunit.converter.Etunit.FailureType;
import org.eclipse.etrice.etunit.converter.Etunit.TestcaseType;
import org.eclipse.etrice.etunit.converter.Etunit.Testsuite;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType;
import org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType;

import org.eclipse.etrice.etunit.converter.Etunit.util.EtunitValidator;

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
	private EClass testcaseTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testsuiteEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iso8601DATETIMEPATTERNEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType nameTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType preStringEDataType = null;

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
		EtunitPackageImpl theEtunitPackage = (EtunitPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EtunitPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EtunitPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEtunitPackage.createPackageContents();

		// Initialize created meta-data
		theEtunitPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theEtunitPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return EtunitValidator.INSTANCE;
				 }
			 });

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
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Testsuite() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Testsuites() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorType() {
		return errorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorType_Mixed() {
		return (EAttribute)errorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorType_Expected() {
		return (EAttribute)errorTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorType_Actual() {
		return (EAttribute)errorTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailureType() {
		return failureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureType_Mixed() {
		return (EAttribute)failureTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureType_Expected() {
		return (EAttribute)failureTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFailureType_Actual() {
		return (EAttribute)failureTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestcaseType() {
		return testcaseTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestcaseType_Error() {
		return (EReference)testcaseTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestcaseType_Failure() {
		return (EReference)testcaseTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestcaseType_Classname() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestcaseType_Name() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestcaseType_Time() {
		return (EAttribute)testcaseTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestsuite() {
		return testsuiteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestsuite_Testcase() {
		return (EReference)testsuiteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsuite_Errors() {
		return (EAttribute)testsuiteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsuite_Failures() {
		return (EAttribute)testsuiteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsuite_Name() {
		return (EAttribute)testsuiteEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsuite_Skipped() {
		return (EAttribute)testsuiteEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsuite_Tests() {
		return (EAttribute)testsuiteEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsuite_Time() {
		return (EAttribute)testsuiteEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestsuite_Timestamp() {
		return (EAttribute)testsuiteEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestsuitesType() {
		return testsuitesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestsuitesType_Testsuite() {
		return (EReference)testsuitesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestsuiteType() {
		return testsuiteTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getISO8601DATETIMEPATTERN() {
		return iso8601DATETIMEPATTERNEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNameType() {
		return nameTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPreString() {
		return preStringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
		createEReference(documentRootEClass, DOCUMENT_ROOT__TESTSUITE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TESTSUITES);

		errorTypeEClass = createEClass(ERROR_TYPE);
		createEAttribute(errorTypeEClass, ERROR_TYPE__MIXED);
		createEAttribute(errorTypeEClass, ERROR_TYPE__EXPECTED);
		createEAttribute(errorTypeEClass, ERROR_TYPE__ACTUAL);

		failureTypeEClass = createEClass(FAILURE_TYPE);
		createEAttribute(failureTypeEClass, FAILURE_TYPE__MIXED);
		createEAttribute(failureTypeEClass, FAILURE_TYPE__EXPECTED);
		createEAttribute(failureTypeEClass, FAILURE_TYPE__ACTUAL);

		testcaseTypeEClass = createEClass(TESTCASE_TYPE);
		createEReference(testcaseTypeEClass, TESTCASE_TYPE__ERROR);
		createEReference(testcaseTypeEClass, TESTCASE_TYPE__FAILURE);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__CLASSNAME);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__NAME);
		createEAttribute(testcaseTypeEClass, TESTCASE_TYPE__TIME);

		testsuiteEClass = createEClass(TESTSUITE);
		createEReference(testsuiteEClass, TESTSUITE__TESTCASE);
		createEAttribute(testsuiteEClass, TESTSUITE__ERRORS);
		createEAttribute(testsuiteEClass, TESTSUITE__FAILURES);
		createEAttribute(testsuiteEClass, TESTSUITE__NAME);
		createEAttribute(testsuiteEClass, TESTSUITE__SKIPPED);
		createEAttribute(testsuiteEClass, TESTSUITE__TESTS);
		createEAttribute(testsuiteEClass, TESTSUITE__TIME);
		createEAttribute(testsuiteEClass, TESTSUITE__TIMESTAMP);

		testsuitesTypeEClass = createEClass(TESTSUITES_TYPE);
		createEReference(testsuitesTypeEClass, TESTSUITES_TYPE__TESTSUITE);

		testsuiteTypeEClass = createEClass(TESTSUITE_TYPE);

		// Create data types
		iso8601DATETIMEPATTERNEDataType = createEDataType(ISO8601DATETIMEPATTERN);
		nameTypeEDataType = createEDataType(NAME_TYPE);
		preStringEDataType = createEDataType(PRE_STRING);
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
		testsuiteTypeEClass.getESuperTypes().add(this.getTestsuite());

		// Initialize classes and features; add operations and parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Testsuite(), this.getTestsuite(), null, "testsuite", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Testsuites(), this.getTestsuitesType(), null, "testsuites", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(errorTypeEClass, ErrorType.class, "ErrorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getErrorType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorType_Expected(), theXMLTypePackage.getString(), "expected", null, 1, 1, ErrorType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorType_Actual(), theXMLTypePackage.getString(), "actual", null, 1, 1, ErrorType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(failureTypeEClass, FailureType.class, "FailureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFailureType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, FailureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailureType_Expected(), theXMLTypePackage.getString(), "expected", null, 1, 1, FailureType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getFailureType_Actual(), theXMLTypePackage.getString(), "actual", null, 1, 1, FailureType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(testcaseTypeEClass, TestcaseType.class, "TestcaseType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestcaseType_Error(), this.getErrorType(), null, "error", null, 0, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestcaseType_Failure(), this.getFailureType(), null, "failure", null, 0, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_Classname(), theXMLTypePackage.getToken(), "classname", null, 1, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_Name(), theXMLTypePackage.getToken(), "name", null, 1, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestcaseType_Time(), theXMLTypePackage.getDecimal(), "time", null, 1, 1, TestcaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testsuiteEClass, Testsuite.class, "Testsuite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestsuite_Testcase(), this.getTestcaseType(), null, "testcase", null, 0, -1, Testsuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuite_Errors(), theXMLTypePackage.getInt(), "errors", null, 1, 1, Testsuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuite_Failures(), theXMLTypePackage.getInt(), "failures", null, 1, 1, Testsuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuite_Name(), this.getNameType(), "name", null, 1, 1, Testsuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuite_Skipped(), theXMLTypePackage.getInt(), "skipped", null, 0, 1, Testsuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuite_Tests(), theXMLTypePackage.getInt(), "tests", null, 1, 1, Testsuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuite_Time(), theXMLTypePackage.getDecimal(), "time", null, 1, 1, Testsuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestsuite_Timestamp(), this.getISO8601DATETIMEPATTERN(), "timestamp", null, 1, 1, Testsuite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testsuitesTypeEClass, TestsuitesType.class, "TestsuitesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestsuitesType_Testsuite(), this.getTestsuiteType(), null, "testsuite", null, 0, -1, TestsuitesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testsuiteTypeEClass, TestsuiteType.class, "TestsuiteType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(iso8601DATETIMEPATTERNEDataType, XMLGregorianCalendar.class, "ISO8601DATETIMEPATTERN", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(nameTypeEDataType, String.class, "NameType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(preStringEDataType, String.class, "PreString", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (getErrorType_Expected(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "expected",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getErrorType_Actual(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "actual",
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
		  (getFailureType_Expected(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "expected",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFailureType_Actual(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "actual",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (iso8601DATETIMEPATTERNEDataType, 
		   source, 
		   new String[] {
			 "name", "ISO8601_DATETIME_PATTERN",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#dateTime",
			 "pattern", "[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}"
		   });		
		addAnnotation
		  (nameTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "name_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#token",
			 "minLength", "1"
		   });		
		addAnnotation
		  (preStringEDataType, 
		   source, 
		   new String[] {
			 "name", "pre-string",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "whiteSpace", "preserve"
		   });		
		addAnnotation
		  (testcaseTypeEClass, 
		   source, 
		   new String[] {
			 "name", "testcase_._type",
			 "kind", "elementOnly"
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
		  (getTestcaseType_Time(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "time",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (testsuiteEClass, 
		   source, 
		   new String[] {
			 "name", "testsuite",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTestsuite_Testcase(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "testcase",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTestsuite_Errors(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "errors",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTestsuite_Failures(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "failures",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTestsuite_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTestsuite_Skipped(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "skipped",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTestsuite_Tests(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "tests",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTestsuite_Time(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "time",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTestsuite_Timestamp(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "timestamp",
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
		  (testsuiteTypeEClass, 
		   source, 
		   new String[] {
			 "name", "testsuite_._type",
			 "kind", "elementOnly"
		   });
	}

} //EtunitPackageImpl
