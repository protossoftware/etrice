/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Testsuites Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTestsuite <em>Testsuite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuitesType()
 * @model extendedMetaData="name='testsuites_._type' kind='elementOnly'"
 * @generated
 */
public interface TestsuitesType extends EObject {
	/**
	 * Returns the value of the '<em><b>Testsuite</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testsuite</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testsuite</em>' containment reference list.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuitesType_Testsuite()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='testsuite' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TestsuiteType> getTestsuite();

} // TestsuitesType
