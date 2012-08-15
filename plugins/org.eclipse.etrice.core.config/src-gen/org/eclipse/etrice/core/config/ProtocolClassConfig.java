/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.etrice.core.room.ProtocolClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Class Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.ProtocolClassConfig#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ProtocolClassConfig#getRegular <em>Regular</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ProtocolClassConfig#getConjugated <em>Conjugated</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getProtocolClassConfig()
 * @model
 * @generated
 */
public interface ProtocolClassConfig extends ConfigElement
{
  /**
   * Returns the value of the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Protocol</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Protocol</em>' reference.
   * @see #setProtocol(ProtocolClass)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getProtocolClassConfig_Protocol()
   * @model
   * @generated
   */
  ProtocolClass getProtocol();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ProtocolClassConfig#getProtocol <em>Protocol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Protocol</em>' reference.
   * @see #getProtocol()
   * @generated
   */
  void setProtocol(ProtocolClass value);

  /**
   * Returns the value of the '<em><b>Regular</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Regular</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Regular</em>' containment reference.
   * @see #setRegular(PortClassConfig)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getProtocolClassConfig_Regular()
   * @model containment="true"
   * @generated
   */
  PortClassConfig getRegular();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ProtocolClassConfig#getRegular <em>Regular</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Regular</em>' containment reference.
   * @see #getRegular()
   * @generated
   */
  void setRegular(PortClassConfig value);

  /**
   * Returns the value of the '<em><b>Conjugated</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conjugated</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conjugated</em>' containment reference.
   * @see #setConjugated(PortClassConfig)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getProtocolClassConfig_Conjugated()
   * @model containment="true"
   * @generated
   */
  PortClassConfig getConjugated();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ProtocolClassConfig#getConjugated <em>Conjugated</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conjugated</em>' containment reference.
   * @see #getConjugated()
   * @generated
   */
  void setConjugated(PortClassConfig value);

} // ProtocolClassConfig
