/**
 * generated by Xtext
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.common.base.Import;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The root object for the ROOM Config model. It gives access to
 * the {@link SubSystemConfig sub system class},
 * {@link ActorClassConfig actor class}, {@link ProtocolClassConfig protocol class} and
 * {@link ActorInstanceConfig actor instance} configurations and the room model {@link Import imports}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.ConfigModel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ConfigModel#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ConfigModel#getConfigElements <em>Config Elements</em>}</li>
 * </ul>
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The model name is a dot separated fully qualified name and is
   * used to provide a name space.
   * 
   * <!-- end-model-doc -->
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
   * The list contents are of type {@link org.eclipse.etrice.core.common.base.Import}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all imported room models. The config elements reference these imports.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all top level config elements
   * 
   * <!-- end-model-doc -->
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
   * @generated
   */
  EList<ActorClassConfig> getActorClassConfigs();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  EList<ActorInstanceConfig> getActorInstanceConfigs();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  EList<ProtocolClassConfig> getProtocolClassConfigs();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  EList<SubSystemConfig> getSubSystemConfigs();

} // ConfigModel
