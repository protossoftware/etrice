/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Instance Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getActorInstanceConfig()
 * @model
 * @generated
 */
public interface ActorInstanceConfig extends ConfigElement
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
   * @see #setRoot(SubSystemClass)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorInstanceConfig_Root()
   * @model
   * @generated
   */
  SubSystemClass getRoot();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getRoot <em>Root</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(SubSystemClass value);

  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' containment reference.
   * @see #setPath(RefPath)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorInstanceConfig_Path()
   * @model containment="true"
   * @generated
   */
  RefPath getPath();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getPath <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' containment reference.
   * @see #getPath()
   * @generated
   */
  void setPath(RefPath value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.AttrInstanceConfig}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorInstanceConfig_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AttrInstanceConfig> getAttributes();

  /**
   * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.PortInstanceConfig}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ports</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorInstanceConfig_Ports()
   * @model containment="true"
   * @generated
   */
  EList<PortInstanceConfig> getPorts();

} // ActorInstanceConfig
