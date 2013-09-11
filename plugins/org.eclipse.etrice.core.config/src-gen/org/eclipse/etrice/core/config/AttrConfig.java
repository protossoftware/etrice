/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.common.base.LiteralArray;

import org.eclipse.etrice.core.room.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>It is the super class of
 * <ul>
 * 	<li>{@link AttrClassConfig}</li>
 * 	<li>{@link AttrInstanceConfig}</li>
 * </ul>				
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.AttrConfig#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.AttrConfig#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrConfig()
 * @model
 * @generated
 */
public interface AttrConfig extends EObject
{
  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the attribute.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(Attribute)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrConfig_Attribute()
   * @model
   * @generated
   */
  Attribute getAttribute();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.AttrConfig#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(Attribute value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the value of {@link #getAttribute attribute}.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(LiteralArray)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getAttrConfig_Value()
   * @model containment="true"
   * @generated
   */
  LiteralArray getValue();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.AttrConfig#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(LiteralArray value);

} // AttrConfig
