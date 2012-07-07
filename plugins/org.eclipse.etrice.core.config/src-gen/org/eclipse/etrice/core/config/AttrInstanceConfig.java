/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Instance Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isDynConfig <em>Dyn Config</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.AttrInstanceConfig#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrInstanceConfig()
 * @model
 * @generated
 */
public interface AttrInstanceConfig extends AttrConfig
{
  /**
   * Returns the value of the '<em><b>Dyn Config</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dyn Config</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dyn Config</em>' attribute.
   * @see #setDynConfig(boolean)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrInstanceConfig_DynConfig()
   * @model
   * @generated
   */
  boolean isDynConfig();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isDynConfig <em>Dyn Config</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dyn Config</em>' attribute.
   * @see #isDynConfig()
   * @generated
   */
  void setDynConfig(boolean value);

  /**
   * Returns the value of the '<em><b>Read Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Read Only</em>' attribute.
   * @see #setReadOnly(boolean)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrInstanceConfig_ReadOnly()
   * @model
   * @generated
   */
  boolean isReadOnly();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isReadOnly <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Read Only</em>' attribute.
   * @see #isReadOnly()
   * @generated
   */
  void setReadOnly(boolean value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.AttrInstanceConfig}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrInstanceConfig_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AttrInstanceConfig> getAttributes();

} // AttrInstanceConfig
