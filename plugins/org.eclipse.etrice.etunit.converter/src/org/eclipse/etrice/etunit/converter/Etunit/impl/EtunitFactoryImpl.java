/**
 */
package org.eclipse.etrice.etunit.converter.Etunit.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.etrice.etunit.converter.Etunit.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EtunitFactoryImpl extends EFactoryImpl implements EtunitFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EtunitFactory init() {
		try {
			EtunitFactory theEtunitFactory = (EtunitFactory)EPackage.Registry.INSTANCE.getEFactory(EtunitPackage.eNS_URI);
			if (theEtunitFactory != null) {
				return theEtunitFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EtunitFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtunitFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EtunitPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case EtunitPackage.ERROR_TYPE: return createErrorType();
			case EtunitPackage.FAILURE_TYPE: return createFailureType();
			case EtunitPackage.PROPERTIES_TYPE: return createPropertiesType();
			case EtunitPackage.PROPERTY_TYPE: return createPropertyType();
			case EtunitPackage.SKIPPED_TYPE: return createSkippedType();
			case EtunitPackage.TESTCASE_TYPE: return createTestcaseType();
			case EtunitPackage.TESTSUITES_TYPE: return createTestsuitesType();
			case EtunitPackage.TESTSUITE_TYPE: return createTestsuiteType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorType createErrorType() {
		ErrorTypeImpl errorType = new ErrorTypeImpl();
		return errorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FailureType createFailureType() {
		FailureTypeImpl failureType = new FailureTypeImpl();
		return failureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertiesType createPropertiesType() {
		PropertiesTypeImpl propertiesType = new PropertiesTypeImpl();
		return propertiesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyType createPropertyType() {
		PropertyTypeImpl propertyType = new PropertyTypeImpl();
		return propertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SkippedType createSkippedType() {
		SkippedTypeImpl skippedType = new SkippedTypeImpl();
		return skippedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestcaseType createTestcaseType() {
		TestcaseTypeImpl testcaseType = new TestcaseTypeImpl();
		return testcaseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestsuitesType createTestsuitesType() {
		TestsuitesTypeImpl testsuitesType = new TestsuitesTypeImpl();
		return testsuitesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestsuiteType createTestsuiteType() {
		TestsuiteTypeImpl testsuiteType = new TestsuiteTypeImpl();
		return testsuiteType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EtunitPackage getEtunitPackage() {
		return (EtunitPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EtunitPackage getPackage() {
		return EtunitPackage.eINSTANCE;
	}

} //EtunitFactoryImpl
