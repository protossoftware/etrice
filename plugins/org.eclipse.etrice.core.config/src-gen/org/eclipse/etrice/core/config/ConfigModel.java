/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.ConfigModel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ConfigModel#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ConfigModel#getConfigElements <em>Config Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getConfigModel()
 * @model
 * @generated
 */
public interface ConfigModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getConfigModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ConfigModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getConfigModel_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Config Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.ConfigElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Config Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Config Elements</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getConfigModel_ConfigElements()
   * @model containment="true"
   * @generated
   */
  EList<ConfigElement> getConfigElements();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<ActorClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorClassConfig>();\r\nfor(ConfigElement element : this.getConfigElements())\r\n\tif(element instanceof ActorClassConfig)\r\n\t\tlist.add((ActorClassConfig) element);\r\nreturn list;\r\n'"
   * @generated
   */
  EList<ActorClassConfig> getActorClassConfigs();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<ActorInstanceConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorInstanceConfig>();\r\nfor(ConfigElement element : this.getConfigElements())\r\n\tif(element instanceof ActorInstanceConfig)\r\n\t\tlist.add((ActorInstanceConfig) element);\r\nreturn list;'"
   * @generated
   */
  EList<ActorInstanceConfig> getActorInstanceConfigs();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<ProtocolClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ProtocolClassConfig>();\r\nfor(ConfigElement element : this.getConfigElements())\r\n\tif(element instanceof ProtocolClassConfig)\r\n\t\tlist.add((ProtocolClassConfig) element);\r\nreturn list;\r\n'"
   * @generated
   */
  EList<ProtocolClassConfig> getProtocolClassConfigs();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<SubSystemConfig> list = new org.eclipse.emf.common.util.BasicEList<SubSystemConfig>();\r\nfor(ConfigElement element : this.getConfigElements())\r\n\tif(element instanceof SubSystemConfig)\r\n\t\tlist.add((SubSystemConfig) element);\r\nreturn list;'"
   * @generated
   */
  EList<SubSystemConfig> getSubSystemConfigs();

} // ConfigModel
