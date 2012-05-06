/**
 * <copyright>
 * </copyright>
 *

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
 *   <li>{@link org.eclipse.etrice.core.config.ConfigModel#getActorClassConfigs <em>Actor Class Configs</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ConfigModel#getActorInstanceConfigs <em>Actor Instance Configs</em>}</li>
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
   * Returns the value of the '<em><b>Actor Class Configs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.ActorClassConfig}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor Class Configs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actor Class Configs</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getConfigModel_ActorClassConfigs()
   * @model containment="true"
   * @generated
   */
  EList<ActorClassConfig> getActorClassConfigs();

  /**
   * Returns the value of the '<em><b>Actor Instance Configs</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor Instance Configs</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actor Instance Configs</em>' attribute list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getConfigModel_ActorInstanceConfigs()
   * @model unique="false"
   * @generated
   */
  EList<String> getActorInstanceConfigs();

} // ConfigModel
