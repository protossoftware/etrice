/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Testsuite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTestcase <em>Testcase</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getFailures <em>Failures</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getSkipped <em>Skipped</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTests <em>Tests</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTime <em>Time</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuite()
 * @model extendedMetaData="name='testsuite' kind='elementOnly'"
 * @generated
 */
public interface Testsuite extends EObject {
	/**
	 * Returns the value of the '<em><b>Testcase</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testcase</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testcase</em>' containment reference list.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuite_Testcase()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='testcase' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TestcaseType> getTestcase();

	/**
	 * Returns the value of the '<em><b>Errors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' attribute.
	 * @see #isSetErrors()
	 * @see #unsetErrors()
	 * @see #setErrors(int)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuite_Errors()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='errors' namespace='##targetNamespace'"
	 * @generated
	 */
	int getErrors();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getErrors <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Errors</em>' attribute.
	 * @see #isSetErrors()
	 * @see #unsetErrors()
	 * @see #getErrors()
	 * @generated
	 */
	void setErrors(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getErrors <em>Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetErrors()
	 * @see #getErrors()
	 * @see #setErrors(int)
	 * @generated
	 */
	void unsetErrors();

	/**
	 * Returns whether the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getErrors <em>Errors</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Errors</em>' attribute is set.
	 * @see #unsetErrors()
	 * @see #getErrors()
	 * @see #setErrors(int)
	 * @generated
	 */
	boolean isSetErrors();

	/**
	 * Returns the value of the '<em><b>Failures</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failures</em>' attribute.
	 * @see #isSetFailures()
	 * @see #unsetFailures()
	 * @see #setFailures(int)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuite_Failures()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='failures' namespace='##targetNamespace'"
	 * @generated
	 */
	int getFailures();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getFailures <em>Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failures</em>' attribute.
	 * @see #isSetFailures()
	 * @see #unsetFailures()
	 * @see #getFailures()
	 * @generated
	 */
	void setFailures(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getFailures <em>Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFailures()
	 * @see #getFailures()
	 * @see #setFailures(int)
	 * @generated
	 */
	void unsetFailures();

	/**
	 * Returns whether the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getFailures <em>Failures</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Failures</em>' attribute is set.
	 * @see #unsetFailures()
	 * @see #getFailures()
	 * @see #setFailures(int)
	 * @generated
	 */
	boolean isSetFailures();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuite_Name()
	 * @model dataType="org.eclipse.etrice.etunit.converter.Etunit.NameType" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Skipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skipped</em>' attribute.
	 * @see #isSetSkipped()
	 * @see #unsetSkipped()
	 * @see #setSkipped(int)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuite_Skipped()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='skipped' namespace='##targetNamespace'"
	 * @generated
	 */
	int getSkipped();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getSkipped <em>Skipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skipped</em>' attribute.
	 * @see #isSetSkipped()
	 * @see #unsetSkipped()
	 * @see #getSkipped()
	 * @generated
	 */
	void setSkipped(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getSkipped <em>Skipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSkipped()
	 * @see #getSkipped()
	 * @see #setSkipped(int)
	 * @generated
	 */
	void unsetSkipped();

	/**
	 * Returns whether the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getSkipped <em>Skipped</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Skipped</em>' attribute is set.
	 * @see #unsetSkipped()
	 * @see #getSkipped()
	 * @see #setSkipped(int)
	 * @generated
	 */
	boolean isSetSkipped();

	/**
	 * Returns the value of the '<em><b>Tests</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' attribute.
	 * @see #isSetTests()
	 * @see #unsetTests()
	 * @see #setTests(int)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuite_Tests()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='tests' namespace='##targetNamespace'"
	 * @generated
	 */
	int getTests();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTests <em>Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tests</em>' attribute.
	 * @see #isSetTests()
	 * @see #unsetTests()
	 * @see #getTests()
	 * @generated
	 */
	void setTests(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTests <em>Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTests()
	 * @see #getTests()
	 * @see #setTests(int)
	 * @generated
	 */
	void unsetTests();

	/**
	 * Returns whether the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTests <em>Tests</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tests</em>' attribute is set.
	 * @see #unsetTests()
	 * @see #getTests()
	 * @see #setTests(int)
	 * @generated
	 */
	boolean isSetTests();

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(BigDecimal)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuite_Time()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Decimal" required="true"
	 *        extendedMetaData="kind='attribute' name='time' namespace='##targetNamespace'"
	 * @generated
	 */
	BigDecimal getTime();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(XMLGregorianCalendar)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuite_Timestamp()
	 * @model dataType="org.eclipse.etrice.etunit.converter.Etunit.ISO8601DATETIMEPATTERN" required="true"
	 *        extendedMetaData="kind='attribute' name='timestamp' namespace='##targetNamespace'"
	 * @generated
	 */
	XMLGregorianCalendar getTimestamp();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.Testsuite#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(XMLGregorianCalendar value);

} // Testsuite
