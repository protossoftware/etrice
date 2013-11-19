/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Config Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.EnumConfigValue#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.EnumConfigValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getEnumConfigValue()
 * @model
 * @generated
 */
public interface EnumConfigValue extends ConfigValue
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EnumerationType)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getEnumConfigValue_Type()
   * @model
   * @generated
   */
  EnumerationType getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.EnumConfigValue#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EnumerationType value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(EnumLiteral)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getEnumConfigValue_Value()
   * @model
   * @generated
   */
  EnumLiteral getValue();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.EnumConfigValue#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(EnumLiteral value);

} // EnumConfigValue
