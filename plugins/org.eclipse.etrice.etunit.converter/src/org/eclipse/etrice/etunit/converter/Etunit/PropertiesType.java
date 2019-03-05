/**
 */
package org.eclipse.etrice.etunit.converter.Etunit;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.etunit.converter.Etunit.PropertiesType#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getPropertiesType()
 * @model extendedMetaData="name='properties_._type' kind='elementOnly'"
 * @generated
 */
public interface PropertiesType extends EObject {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.etunit.converter.Etunit.PropertyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see org.eclipse.etrice.etunit.converter.Etunit.EtunitPackage#getPropertiesType_Property()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PropertyType> getProperty();

} // PropertiesType
