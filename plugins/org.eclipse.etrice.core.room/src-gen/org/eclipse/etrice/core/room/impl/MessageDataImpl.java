/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.room.MessageData;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.MessageDataImpl#getDeprecatedName <em>Deprecated Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.MessageDataImpl#getRefType <em>Ref Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageDataImpl extends MinimalEObjectImpl.Container implements MessageData
{
  /**
   * The default value of the '{@link #getDeprecatedName() <em>Deprecated Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeprecatedName()
   * @generated
   * @ordered
   */
  protected static final String DEPRECATED_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDeprecatedName() <em>Deprecated Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeprecatedName()
   * @generated
   * @ordered
   */
  protected String deprecatedName = DEPRECATED_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRefType() <em>Ref Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefType()
   * @generated
   * @ordered
   */
  protected RefableType refType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MessageDataImpl()
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
    return RoomPackage.Literals.MESSAGE_DATA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDeprecatedName()
  {
    return deprecatedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDeprecatedName(String newDeprecatedName)
  {
    String oldDeprecatedName = deprecatedName;
    deprecatedName = newDeprecatedName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.MESSAGE_DATA__DEPRECATED_NAME, oldDeprecatedName, deprecatedName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RefableType getRefType()
  {
    return refType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRefType(RefableType newRefType, NotificationChain msgs)
  {
    RefableType oldRefType = refType;
    refType = newRefType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.MESSAGE_DATA__REF_TYPE, oldRefType, newRefType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRefType(RefableType newRefType)
  {
    if (newRefType != refType)
    {
      NotificationChain msgs = null;
      if (refType != null)
        msgs = ((InternalEObject)refType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.MESSAGE_DATA__REF_TYPE, null, msgs);
      if (newRefType != null)
        msgs = ((InternalEObject)newRefType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.MESSAGE_DATA__REF_TYPE, null, msgs);
      msgs = basicSetRefType(newRefType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.MESSAGE_DATA__REF_TYPE, newRefType, newRefType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RoomPackage.MESSAGE_DATA__REF_TYPE:
        return basicSetRefType(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case RoomPackage.MESSAGE_DATA__DEPRECATED_NAME:
        return getDeprecatedName();
      case RoomPackage.MESSAGE_DATA__REF_TYPE:
        return getRefType();
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
      case RoomPackage.MESSAGE_DATA__DEPRECATED_NAME:
        setDeprecatedName((String)newValue);
        return;
      case RoomPackage.MESSAGE_DATA__REF_TYPE:
        setRefType((RefableType)newValue);
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
      case RoomPackage.MESSAGE_DATA__DEPRECATED_NAME:
        setDeprecatedName(DEPRECATED_NAME_EDEFAULT);
        return;
      case RoomPackage.MESSAGE_DATA__REF_TYPE:
        setRefType((RefableType)null);
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
      case RoomPackage.MESSAGE_DATA__DEPRECATED_NAME:
        return DEPRECATED_NAME_EDEFAULT == null ? deprecatedName != null : !DEPRECATED_NAME_EDEFAULT.equals(deprecatedName);
      case RoomPackage.MESSAGE_DATA__REF_TYPE:
        return refType != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (deprecatedName: ");
    result.append(deprecatedName);
    result.append(')');
    return result.toString();
  }

} //MessageDataImpl
