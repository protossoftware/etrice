/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getExpected <em>Expected</em>}</li>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getActual <em>Actual</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getFailureType()
 * @model extendedMetaData="name='failure_._type' kind='mixed'"
 * @generated
 */
public interface FailureType extends EObject {
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
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getFailureType_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Expected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected</em>' attribute.
	 * @see #setExpected(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getFailureType_Expected()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='expected' namespace='##targetNamespace'"
	 * @generated
	 */
	String getExpected();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getExpected <em>Expected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected</em>' attribute.
	 * @see #getExpected()
	 * @generated
	 */
	void setExpected(String value);

	/**
	 * Returns the value of the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual</em>' attribute.
	 * @see #setActual(String)
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getFailureType_Actual()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='actual' namespace='##targetNamespace'"
	 * @generated
	 */
	String getActual();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.etunit.converter.Etunit.FailureType#getActual <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual</em>' attribute.
	 * @see #getActual()
	 * @generated
	 */
	void setActual(String value);

} // FailureType
