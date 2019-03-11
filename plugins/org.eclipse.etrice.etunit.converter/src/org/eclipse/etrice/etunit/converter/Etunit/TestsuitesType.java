/**
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
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTestsuite <em>Testsuite</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getDisabled <em>Disabled</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getFailures <em>Failures</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTests <em>Tests</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTime <em>Time</em>}</li>
 * </ul>
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

	/**
	 * Returns the value of the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disabled</em>' attribute.
	 * @see #setDisabled(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuitesType_Disabled()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='disabled' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDisabled();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getDisabled <em>Disabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disabled</em>' attribute.
	 * @see #getDisabled()
	 * @generated
	 */
	void setDisabled(String value);

	/**
	 * Returns the value of the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Errors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' attribute.
	 * @see #setErrors(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuitesType_Errors()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='errors' namespace='##targetNamespace'"
	 * @generated
	 */
	String getErrors();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getErrors <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Errors</em>' attribute.
	 * @see #getErrors()
	 * @generated
	 */
	void setErrors(String value);

	/**
	 * Returns the value of the '<em><b>Failures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failures</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failures</em>' attribute.
	 * @see #setFailures(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuitesType_Failures()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='failures' namespace='##targetNamespace'"
	 * @generated
	 */
	String getFailures();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getFailures <em>Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failures</em>' attribute.
	 * @see #getFailures()
	 * @generated
	 */
	void setFailures(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuitesType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Tests</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tests</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' attribute.
	 * @see #setTests(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuitesType_Tests()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='tests' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTests();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTests <em>Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tests</em>' attribute.
	 * @see #getTests()
	 * @generated
	 */
	void setTests(String value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuitesType_Time()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='time' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTime();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuitesType#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(String value);

} // TestsuitesType
