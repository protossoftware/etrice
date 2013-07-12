/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage
 * @generated
 */
public interface EtunitFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EtunitFactory eINSTANCE = org.eclipse.etrice.etunit.converter.Etunit.impl.EtunitFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Error Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Type</em>'.
	 * @generated
	 */
	ErrorType createErrorType();

	/**
	 * Returns a new object of class '<em>Failure Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failure Type</em>'.
	 * @generated
	 */
	FailureType createFailureType();

	/**
	 * Returns a new object of class '<em>Testcase Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Testcase Type</em>'.
	 * @generated
	 */
	TestcaseType createTestcaseType();

	/**
	 * Returns a new object of class '<em>Testsuite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Testsuite</em>'.
	 * @generated
	 */
	Testsuite createTestsuite();

	/**
	 * Returns a new object of class '<em>Testsuites Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Testsuites Type</em>'.
	 * @generated
	 */
	TestsuitesType createTestsuitesType();

	/**
	 * Returns a new object of class '<em>Testsuite Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Testsuite Type</em>'.
	 * @generated
	 */
	TestsuiteType createTestsuiteType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EtunitPackage getEtunitPackage();

} //EtunitFactory
