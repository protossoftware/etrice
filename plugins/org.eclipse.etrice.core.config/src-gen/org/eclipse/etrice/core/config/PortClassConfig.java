/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Class Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This class models a configuration for an {@link org.eclipse.etrice.core.room.PortClass port class}.
 * The configuration defines the default values for all instances of the port.
 * The values are applied at generation time.
 * The config sub elements are:
 * <ul>
 * 	<li>{@link AttrClassConfig attribute class config}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.PortClassConfig#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getPortClassConfig()
 * @model
 * @generated
 */
public interface PortClassConfig extends EObject
{
  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.AttrClassConfig}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all attribute configurations.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getPortClassConfig_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AttrClassConfig> getAttributes();

} // PortClassConfig
