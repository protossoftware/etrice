/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.DynamicConfig#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.DynamicConfig#getFilePath <em>File Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.DynamicConfig#getPolling <em>Polling</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getDynamicConfig()
 * @model
 * @generated
 */
public interface DynamicConfig extends EObject
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' attribute.
   * @see #setSource(String)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getDynamicConfig_Source()
   * @model
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.DynamicConfig#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

  /**
   * Returns the value of the '<em><b>File Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File Path</em>' attribute.
   * @see #setFilePath(String)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getDynamicConfig_FilePath()
   * @model
   * @generated
   */
  String getFilePath();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.DynamicConfig#getFilePath <em>File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File Path</em>' attribute.
   * @see #getFilePath()
   * @generated
   */
  void setFilePath(String value);

  /**
   * Returns the value of the '<em><b>Polling</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Polling</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Polling</em>' attribute.
   * @see #setPolling(int)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getDynamicConfig_Polling()
   * @model
   * @generated
   */
  int getPolling();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.DynamicConfig#getPolling <em>Polling</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Polling</em>' attribute.
   * @see #getPolling()
   * @generated
   */
  void setPolling(int value);

} // DynamicConfig
