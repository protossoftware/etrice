/**
 */
package org.eclipse.etrice.core.config.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.config.EnumConfigValue;

import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Config Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.EnumConfigValueImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.EnumConfigValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumConfigValueImpl extends ConfigValueImpl implements EnumConfigValue
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EnumerationType type;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected EnumLiteral value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumConfigValueImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ConfigPackage.Literals.ENUM_CONFIG_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationType getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (EnumerationType)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.ENUM_CONFIG_VALUE__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationType basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(EnumerationType newType)
  {
    EnumerationType oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ENUM_CONFIG_VALUE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumLiteral getValue()
  {
    if (value != null && value.eIsProxy())
    {
      InternalEObject oldValue = (InternalEObject)value;
      value = (EnumLiteral)eResolveProxy(oldValue);
      if (value != oldValue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.ENUM_CONFIG_VALUE__VALUE, oldValue, value));
      }
    }
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumLiteral basicGetValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(EnumLiteral newValue)
  {
    EnumLiteral oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ENUM_CONFIG_VALUE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ConfigPackage.ENUM_CONFIG_VALUE__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case ConfigPackage.ENUM_CONFIG_VALUE__VALUE:
        if (resolve) return getValue();
        return basicGetValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ConfigPackage.ENUM_CONFIG_VALUE__TYPE:
        setType((EnumerationType)newValue);
        return;
      case ConfigPackage.ENUM_CONFIG_VALUE__VALUE:
        setValue((EnumLiteral)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ConfigPackage.ENUM_CONFIG_VALUE__TYPE:
        setType((EnumerationType)null);
        return;
      case ConfigPackage.ENUM_CONFIG_VALUE__VALUE:
        setValue((EnumLiteral)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ConfigPackage.ENUM_CONFIG_VALUE__TYPE:
        return type != null;
      case ConfigPackage.ENUM_CONFIG_VALUE__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

} //EnumConfigValueImpl
