/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.room.InterfaceItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Instance Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This class models a configuration for an {@link org.eclipse.etrice.core.room.InterfaceItem interface item} (e.g. port instance).
 * The configuration defines values for this interface item and overrides the default values from the corresponding class config.
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
 *   <li>{@link org.eclipse.etrice.core.config.PortInstanceConfig#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.PortInstanceConfig#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getPortInstanceConfig()
 * @model
 * @generated
 */
public interface PortInstanceConfig extends EObject
{
  /**
   * Returns the value of the '<em><b>Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the interface item.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Item</em>' reference.
   * @see #setItem(InterfaceItem)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getPortInstanceConfig_Item()
   * @model
   * @generated
   */
  InterfaceItem getItem();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.PortInstanceConfig#getItem <em>Item</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Item</em>' reference.
   * @see #getItem()
   * @generated
   */
  void setItem(InterfaceItem value);

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
   * @see org.eclipse.etrice.core.config.ConfigPackage#getPortInstanceConfig_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AttrInstanceConfig> getAttributes();

} // PortInstanceConfig
