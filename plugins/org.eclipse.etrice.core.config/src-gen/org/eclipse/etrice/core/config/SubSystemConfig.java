/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.SubSystemConfig#getSubSystem <em>Sub System</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.SubSystemConfig#getDynConfig <em>Dyn Config</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getSubSystemConfig()
 * @model
 * @generated
 */
public interface SubSystemConfig extends ConfigElement
{
  /**
   * Returns the value of the '<em><b>Sub System</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub System</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub System</em>' reference.
   * @see #setSubSystem(SubSystemClass)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getSubSystemConfig_SubSystem()
   * @model
   * @generated
   */
  SubSystemClass getSubSystem();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.SubSystemConfig#getSubSystem <em>Sub System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub System</em>' reference.
   * @see #getSubSystem()
   * @generated
   */
  void setSubSystem(SubSystemClass value);

  /**
   * Returns the value of the '<em><b>Dyn Config</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dyn Config</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dyn Config</em>' containment reference.
   * @see #setDynConfig(DynamicConfig)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getSubSystemConfig_DynConfig()
   * @model containment="true"
   * @generated
   */
  DynamicConfig getDynConfig();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.SubSystemConfig#getDynConfig <em>Dyn Config</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dyn Config</em>' containment reference.
   * @see #getDynConfig()
   * @generated
   */
  void setDynConfig(DynamicConfig value);

} // SubSystemConfig
