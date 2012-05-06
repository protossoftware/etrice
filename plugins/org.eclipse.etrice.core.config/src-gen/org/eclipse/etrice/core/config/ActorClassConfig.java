/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Class Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.ActorClassConfig#getActorClass <em>Actor Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getActorClassConfig()
 * @model
 * @generated
 */
public interface ActorClassConfig extends EObject
{
  /**
   * Returns the value of the '<em><b>Actor Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor Class</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actor Class</em>' reference.
   * @see #setActorClass(ActorClass)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorClassConfig_ActorClass()
   * @model
   * @generated
   */
  ActorClass getActorClass();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ActorClassConfig#getActorClass <em>Actor Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actor Class</em>' reference.
   * @see #getActorClass()
   * @generated
   */
  void setActorClass(ActorClass value);

} // ActorClassConfig
