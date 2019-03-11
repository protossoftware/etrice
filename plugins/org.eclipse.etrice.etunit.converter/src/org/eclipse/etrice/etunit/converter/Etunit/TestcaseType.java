/**
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Testcase Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSkipped <em>Skipped</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getError <em>Error</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getFailure <em>Failure</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSystemOut <em>System Out</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSystemErr <em>System Err</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType()
 * @model extendedMetaData="name='testcase_._type' kind='elementOnly'"
 * @generated
 */
public interface TestcaseType extends EObject {
	/**
	 * Returns the value of the '<em><b>Skipped</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skipped</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skipped</em>' containment reference.
	 * @see #setSkipped(SkippedType)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Skipped()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='skipped' namespace='##targetNamespace'"
	 * @generated
	 */
	SkippedType getSkipped();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getSkipped <em>Skipped</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skipped</em>' containment reference.
	 * @see #getSkipped()
	 * @generated
	 */
	void setSkipped(SkippedType value);

	/**
	 * Returns the value of the '<em><b>Error</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.etunit.converter.Etunit.ErrorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' containment reference list.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Error()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='error' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ErrorType> getError();

	/**
	 * Returns the value of the '<em><b>Failure</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.etunit.converter.Etunit.FailureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure</em>' containment reference list.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Failure()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='failure' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<FailureType> getFailure();

	/**
	 * Returns the value of the '<em><b>System Out</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Out</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Out</em>' attribute list.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_SystemOut()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='system-out' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getSystemOut();

	/**
	 * Returns the value of the '<em><b>System Err</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Err</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Err</em>' attribute list.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_SystemErr()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='system-err' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getSystemErr();

	/**
	 * Returns the value of the '<em><b>Assertions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assertions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assertions</em>' attribute.
	 * @see #setAssertions(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Assertions()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='assertions' namespace='##targetNamespace'"
	 * @generated
	 */
	String getAssertions();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getAssertions <em>Assertions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assertions</em>' attribute.
	 * @see #getAssertions()
	 * @generated
	 */
	void setAssertions(String value);

	/**
	 * Returns the value of the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classname</em>' attribute.
	 * @see #setClassname(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Classname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
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
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
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
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Status()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='status' namespace='##targetNamespace'"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

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
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestcaseType_Time()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='time' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTime();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestcaseType#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(String value);

} // TestcaseType
