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
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<ActorClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorClassConfig>();\r\n\t       \t\t\tfor(ConfigElement element : this.getConfigElements())\r\n\t       \t\t\t\tif(element instanceof ActorClassConfig)\r\n\t       \t\t\t\t\tlist.add((ActorClassConfig) element);\r\n\t       \t\t return list;'"
   * @generated
   */
  EList<ActorClassConfig> getActorClassConfigs();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<ActorInstanceConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorInstanceConfig>();\r\n\t\t\t\tfor(ConfigElement element : this.getConfigElements())\r\n\t\t\t \t\tif(element instanceof ActorInstanceConfig)\r\n\t\t\t\t\t\tlist.add((ActorInstanceConfig) element);\r\n\t\t\t\treturn list;'"
   * @generated
   */
  EList<ActorInstanceConfig> getActorInstanceConfigs();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<ProtocolClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ProtocolClassConfig>();\r\n\t\t\t\tfor(ConfigElement element : this.getConfigElements())\r\n\t\t\t \t\tif(element instanceof ProtocolClassConfig)\r\n\t\t\t\t\t\tlist.add((ProtocolClassConfig) element);\r\n\t\t\t\treturn list;'"
   * @generated
   */
  EList<ProtocolClassConfig> getProtocolClassConfigs();

} // ConfigModel
