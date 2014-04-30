/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The dynamic configuration provides a configuration at runtime.
 * The source of the configuration is abstracted by an interface.
 * <br>
 * This feature is experimental and implemented for target language java only.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.DynamicConfig#getFilePath <em>File Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.DynamicConfig#getUserCode1 <em>User Code1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.DynamicConfig#getUserCode2 <em>User Code2</em>}</li>
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
   * Returns the value of the '<em><b>File Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the file path of the configuration. In this case the source of the configuration is a simple file.
   * 
   * <!-- end-model-doc -->
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
   * Returns the value of the '<em><b>User Code1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>Defines the import statement for the implemenation of the configuration source.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>User Code1</em>' attribute.
   * @see #setUserCode1(String)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getDynamicConfig_UserCode1()
   * @model
   * @generated
   */
  String getUserCode1();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.DynamicConfig#getUserCode1 <em>User Code1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code1</em>' attribute.
   * @see #getUserCode1()
   * @generated
   */
  void setUserCode1(String value);

  /**
   * Returns the value of the '<em><b>User Code2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the constructor statement for the implemenation of the configuration source.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>User Code2</em>' attribute.
   * @see #setUserCode2(String)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getDynamicConfig_UserCode2()
   * @model
   * @generated
   */
  String getUserCode2();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.DynamicConfig#getUserCode2 <em>User Code2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code2</em>' attribute.
   * @see #getUserCode2()
   * @generated
   */
  void setUserCode2(String value);

  /**
   * Returns the value of the '<em><b>Polling</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>Defines the time interval in milliseconds to query changes from the configuration source.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Polling</em>' attribute.
   * @see #setPolling(long)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getDynamicConfig_Polling()
   * @model
   * @generated
   */
  long getPolling();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.DynamicConfig#getPolling <em>Polling</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Polling</em>' attribute.
   * @see #getPolling()
   * @generated
   */
  void setPolling(long value);

} // DynamicConfig
