/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.SubSystemRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.SubSystemConfig#getRoot <em>Root</em>}</li>
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
   * Returns the value of the '<em><b>Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' reference.
   * @see #setRoot(LogicalSystem)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getSubSystemConfig_Root()
   * @model
   * @generated
   */
  LogicalSystem getRoot();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.SubSystemConfig#getRoot <em>Root</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(LogicalSystem value);

  /**
   * Returns the value of the '<em><b>Sub System</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub System</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub System</em>' reference.
   * @see #setSubSystem(SubSystemRef)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getSubSystemConfig_SubSystem()
   * @model
   * @generated
   */
  SubSystemRef getSubSystem();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.SubSystemConfig#getSubSystem <em>Sub System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub System</em>' reference.
   * @see #getSubSystem()
   * @generated
   */
  void setSubSystem(SubSystemRef value);

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
