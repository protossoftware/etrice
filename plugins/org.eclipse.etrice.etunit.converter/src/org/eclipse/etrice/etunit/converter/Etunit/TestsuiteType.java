/**
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Testsuite Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTestcase <em>Testcase</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSystemOut <em>System Out</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSystemErr <em>System Err</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getDisabled <em>Disabled</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getFailures <em>Failures</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getHostname <em>Hostname</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSkipped <em>Skipped</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTests <em>Tests</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTime <em>Time</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType()
 * @model extendedMetaData="name='testsuite_._type' kind='elementOnly'"
 * @generated
 */
public interface TestsuiteType extends EObject {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(PropertiesType)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Properties()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='properties' namespace='##targetNamespace'"
	 * @generated
	 */
	PropertiesType getProperties();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(PropertiesType value);

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
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Testcase()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='testcase' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TestcaseType> getTestcase();

	/**
	 * Returns the value of the '<em><b>System Out</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Out</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Out</em>' attribute.
	 * @see #setSystemOut(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_SystemOut()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='system-out' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSystemOut();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSystemOut <em>System Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Out</em>' attribute.
	 * @see #getSystemOut()
	 * @generated
	 */
	void setSystemOut(String value);

	/**
	 * Returns the value of the '<em><b>System Err</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Err</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Err</em>' attribute.
	 * @see #setSystemErr(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_SystemErr()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='system-err' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSystemErr();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSystemErr <em>System Err</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Err</em>' attribute.
	 * @see #getSystemErr()
	 * @generated
	 */
	void setSystemErr(String value);

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
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Disabled()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='disabled' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDisabled();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getDisabled <em>Disabled</em>}' attribute.
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
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Errors()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='errors' namespace='##targetNamespace'"
	 * @generated
	 */
	String getErrors();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getErrors <em>Errors</em>}' attribute.
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
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Failures()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='failures' namespace='##targetNamespace'"
	 * @generated
	 */
	String getFailures();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getFailures <em>Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failures</em>' attribute.
	 * @see #getFailures()
	 * @generated
	 */
	void setFailures(String value);

	/**
	 * Returns the value of the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hostname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hostname</em>' attribute.
	 * @see #setHostname(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Hostname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hostname' namespace='##targetNamespace'"
	 * @generated
	 */
	String getHostname();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
	void setHostname(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute.
	 * @see #setPackage(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Package()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='package' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

	/**
	 * Returns the value of the '<em><b>Skipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skipped</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skipped</em>' attribute.
	 * @see #setSkipped(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Skipped()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='skipped' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSkipped();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getSkipped <em>Skipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skipped</em>' attribute.
	 * @see #getSkipped()
	 * @generated
	 */
	void setSkipped(String value);

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
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Tests()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='tests' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTests();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTests <em>Tests</em>}' attribute.
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
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Time()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='time' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTime();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(String value);

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getTestsuiteType_Timestamp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='timestamp' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTimestamp();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.TestsuiteType#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(String value);

} // TestsuiteType
