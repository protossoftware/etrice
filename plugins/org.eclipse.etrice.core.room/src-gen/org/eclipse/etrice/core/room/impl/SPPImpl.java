/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SPP;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SPP</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.SPPImpl#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SPPImpl extends InterfaceItemImpl implements SPP
{
  /**
   * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProtocol()
   * @generated
   * @ordered
   */
  protected ProtocolClass protocol;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SPPImpl()
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
    return RoomPackage.Literals.SPP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProtocolClass getProtocol()
  {
    if (protocol != null && protocol.eIsProxy())
    {
      InternalEObject oldProtocol = (InternalEObject)protocol;
      protocol = (ProtocolClass)eResolveProxy(oldProtocol);
      if (protocol != oldProtocol)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.SPP__PROTOCOL, oldProtocol, protocol));
      }
    }
    return protocol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProtocolClass basicGetProtocol()
  {
    return protocol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProtocol(ProtocolClass newProtocol)
  {
    ProtocolClass oldProtocol = protocol;
    protocol = newProtocol;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.SPP__PROTOCOL, oldProtocol, protocol));
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
      case RoomPackage.SPP__PROTOCOL:
        if (resolve) return getProtocol();
        return basicGetProtocol();
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
      case RoomPackage.SPP__PROTOCOL:
        setProtocol((ProtocolClass)newValue);
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
      case RoomPackage.SPP__PROTOCOL:
        setProtocol((ProtocolClass)null);
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
      case RoomPackage.SPP__PROTOCOL:
        return protocol != null;
    }
    return super.eIsSet(featureID);
  }

} //SPPImpl
