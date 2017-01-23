/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.ConfigValueArray#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getConfigValueArray()
 * @model
 * @generated
 */
public interface ConfigValueArray extends EObject
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.ConfigValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getConfigValueArray_Values()
   * @model containment="true"
   * @generated
   */
  EList<ConfigValue> getValues();

} // ConfigValueArray
