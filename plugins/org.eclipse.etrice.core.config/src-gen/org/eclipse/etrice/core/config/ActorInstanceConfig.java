/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.SubSystemRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Instance Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This class models a configuration for an {@link org.eclipse.etrice.core.room.ActorRef actor instance}.
 * The configuration defines values for this actor instance and overrides the default values from the corresponding class config.
 * The values are applied at generation time.
 * The config sub elements are:
 * <ul>
 * 	<li>{@link AttrInstanceConfig attribute instance config}</li>
 * </ul>				
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getSubSystem <em>Sub System</em>}</li>
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the logical system that contains the {@link #getSubSystem sub system}.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Root</em>' reference.
   * @see #setRoot(LogicalSystem)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorInstanceConfig_Root()
   * @model
   * @generated
   */
  LogicalSystem getRoot();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getRoot <em>Root</em>}' reference.
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the sub system that contains the {@link #getRefPath actor instance}.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Sub System</em>' reference.
   * @see #setSubSystem(SubSystemRef)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorInstanceConfig_SubSystem()
   * @model
   * @generated
   */
  SubSystemRef getSubSystem();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getSubSystem <em>Sub System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub System</em>' reference.
   * @see #getSubSystem()
   * @generated
   */
  void setSubSystem(SubSystemRef value);

  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the path of the actor instance relative to the {@link #getSubSystem sub system}.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all attribute configurations.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all port configurations.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ports</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorInstanceConfig_Ports()
   * @model containment="true"
   * @generated
   */
  EList<PortInstanceConfig> getPorts();

} // ActorInstanceConfig
