/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Testcase Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getError <em>Error</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getFailure <em>Failure</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType()
 * @model extendedMetaData="name='testcase_._type' kind='elementOnly'"
 * @generated
 */
public interface TestcaseType extends EObject {
	/**
	 * Returns the value of the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' containment reference.
	 * @see #setError(ErrorType)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Error()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='error' namespace='##targetNamespace'"
	 * @generated
	 */
	ErrorType getError();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getError <em>Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error</em>' containment reference.
	 * @see #getError()
	 * @generated
	 */
	void setError(ErrorType value);

	/**
	 * Returns the value of the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure</em>' containment reference.
	 * @see #setFailure(FailureType)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Failure()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='failure' namespace='##targetNamespace'"
	 * @generated
	 */
	FailureType getFailure();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getFailure <em>Failure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure</em>' containment reference.
	 * @see #getFailure()
	 * @generated
	 */
	void setFailure(FailureType value);

	/**
	 * Returns the value of the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classname</em>' attribute.
	 * @see #setClassname(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Classname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Token" required="true"
	 *        extendedMetaData="kind='attribute' name='classname' namespace='##targetNamespace'"
	 * @generated
	 */
	String getClassname();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getClassname <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classname</em>' attribute.
	 * @see #getClassname()
	 * @generated
	 */
	void setClassname(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Token" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(BigDecimal)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Time()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Decimal" required="true"
	 *        extendedMetaData="kind='attribute' name='time' namespace='##targetNamespace'"
	 * @generated
	 */
	BigDecimal getTime();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(BigDecimal value);

} // TestcaseType
