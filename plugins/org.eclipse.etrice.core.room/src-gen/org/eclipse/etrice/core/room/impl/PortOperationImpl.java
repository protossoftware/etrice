/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.PortOperationImpl#getSendsMsg <em>Sends Msg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortOperationImpl extends OperationImpl implements PortOperation
{
  /**
   * The cached value of the '{@link #getSendsMsg() <em>Sends Msg</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSendsMsg()
   * @generated
   * @ordered
   */
  protected Message sendsMsg;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PortOperationImpl()
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
    return RoomPackage.Literals.PORT_OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Message getSendsMsg()
  {
    if (sendsMsg != null && sendsMsg.eIsProxy())
    {
      InternalEObject oldSendsMsg = (InternalEObject)sendsMsg;
      sendsMsg = (Message)eResolveProxy(oldSendsMsg);
      if (sendsMsg != oldSendsMsg)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.PORT_OPERATION__SENDS_MSG, oldSendsMsg, sendsMsg));
      }
    }
    return sendsMsg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Message basicGetSendsMsg()
  {
    return sendsMsg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSendsMsg(Message newSendsMsg)
  {
    Message oldSendsMsg = sendsMsg;
    sendsMsg = newSendsMsg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PORT_OPERATION__SENDS_MSG, oldSendsMsg, sendsMsg));
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
      case RoomPackage.PORT_OPERATION__SENDS_MSG:
        if (resolve) return getSendsMsg();
        return basicGetSendsMsg();
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
      case RoomPackage.PORT_OPERATION__SENDS_MSG:
        setSendsMsg((Message)newValue);
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
      case RoomPackage.PORT_OPERATION__SENDS_MSG:
        setSendsMsg((Message)null);
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
      case RoomPackage.PORT_OPERATION__SENDS_MSG:
        return sendsMsg != null;
    }
    return super.eIsSet(featureID);
  }

} //PortOperationImpl
