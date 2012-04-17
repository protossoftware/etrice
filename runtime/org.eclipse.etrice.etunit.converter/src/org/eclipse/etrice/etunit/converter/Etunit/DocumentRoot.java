/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestsuite <em>Testsuite</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestsuites <em>Testsuites</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Testsuite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testsuite</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testsuite</em>' containment reference.
	 * @see #setTestsuite(Testsuite)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getDocumentRoot_Testsuite()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='testsuite' namespace='##targetNamespace'"
	 * @generated
	 */
	Testsuite getTestsuite();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestsuite <em>Testsuite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testsuite</em>' containment reference.
	 * @see #getTestsuite()
	 * @generated
	 */
	void setTestsuite(Testsuite value);

	/**
	 * Returns the value of the '<em><b>Testsuites</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testsuites</em>' containment reference.
	 * @see #setTestsuites(TestsuitesType)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getDocumentRoot_Testsuites()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='testsuites' namespace='##targetNamespace'"
	 * @generated
	 */
	TestsuitesType getTestsuites();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.DocumentRoot#getTestsuites <em>Testsuites</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testsuites</em>' containment reference.
	 * @see #getTestsuites()
	 * @generated
	 */
	void setTestsuites(TestsuitesType value);

} // DocumentRoot
