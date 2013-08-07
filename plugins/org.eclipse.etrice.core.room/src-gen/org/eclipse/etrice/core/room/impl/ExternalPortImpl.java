/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ExternalPortImpl#getInterfacePort <em>Interface Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalPortImpl extends MinimalEObjectImpl.Container implements ExternalPort
{
  /**
   * The cached value of the '{@link #getInterfacePort() <em>Interface Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfacePort()
   * @generated
   * @ordered
   */
  protected Port interfacePort;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalPortImpl()
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
    return RoomPackage.Literals.EXTERNAL_PORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port getInterfacePort()
  {
    if (interfacePort != null && interfacePort.eIsProxy())
    {
      InternalEObject oldInterfacePort = (InternalEObject)interfacePort;
      interfacePort = (Port)eResolveProxy(oldInterfacePort);
      if (interfacePort != oldInterfacePort)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.EXTERNAL_PORT__INTERFACE_PORT, oldInterfacePort, interfacePort));
      }
    }
    return interfacePort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port basicGetInterfacePort()
  {
    return interfacePort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInterfacePort(Port newInterfacePort)
  {
    Port oldInterfacePort = interfacePort;
    interfacePort = newInterfacePort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.EXTERNAL_PORT__INTERFACE_PORT, oldInterfacePort, interfacePort));
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
      case RoomPackage.EXTERNAL_PORT__INTERFACE_PORT:
        if (resolve) return getInterfacePort();
        return basicGetInterfacePort();
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
      case RoomPackage.EXTERNAL_PORT__INTERFACE_PORT:
        setInterfacePort((Port)newValue);
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
      case RoomPackage.EXTERNAL_PORT__INTERFACE_PORT:
        setInterfacePort((Port)null);
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
      case RoomPackage.EXTERNAL_PORT__INTERFACE_PORT:
        return interfacePort != null;
    }
    return super.eIsSet(featureID);
  }

} //ExternalPortImpl
