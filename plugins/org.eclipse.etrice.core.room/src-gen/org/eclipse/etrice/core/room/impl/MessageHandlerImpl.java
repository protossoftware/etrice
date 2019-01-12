/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.fsm.fSM.DetailCode;

import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Handler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.MessageHandlerImpl#getMsg <em>Msg</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.MessageHandlerImpl#getDetailCode <em>Detail Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageHandlerImpl extends MinimalEObjectImpl.Container implements MessageHandler
{
  /**
   * The cached value of the '{@link #getMsg() <em>Msg</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsg()
   * @generated
   * @ordered
   */
  protected Message msg;

  /**
   * The cached value of the '{@link #getDetailCode() <em>Detail Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetailCode()
   * @generated
   * @ordered
   */
  protected DetailCode detailCode;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MessageHandlerImpl()
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
    return RoomPackage.Literals.MESSAGE_HANDLER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Message getMsg()
  {
    if (msg != null && msg.eIsProxy())
    {
      InternalEObject oldMsg = (InternalEObject)msg;
      msg = (Message)eResolveProxy(oldMsg);
      if (msg != oldMsg)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.MESSAGE_HANDLER__MSG, oldMsg, msg));
      }
    }
    return msg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Message basicGetMsg()
  {
    return msg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMsg(Message newMsg)
  {
    Message oldMsg = msg;
    msg = newMsg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.MESSAGE_HANDLER__MSG, oldMsg, msg));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DetailCode getDetailCode()
  {
    return detailCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDetailCode(DetailCode newDetailCode, NotificationChain msgs)
  {
    DetailCode oldDetailCode = detailCode;
    detailCode = newDetailCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.MESSAGE_HANDLER__DETAIL_CODE, oldDetailCode, newDetailCode);
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
  public void setDetailCode(DetailCode newDetailCode)
  {
    if (newDetailCode != detailCode)
    {
      NotificationChain msgs = null;
      if (detailCode != null)
        msgs = ((InternalEObject)detailCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.MESSAGE_HANDLER__DETAIL_CODE, null, msgs);
      if (newDetailCode != null)
        msgs = ((InternalEObject)newDetailCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.MESSAGE_HANDLER__DETAIL_CODE, null, msgs);
      msgs = basicSetDetailCode(newDetailCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.MESSAGE_HANDLER__DETAIL_CODE, newDetailCode, newDetailCode));
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
      case RoomPackage.MESSAGE_HANDLER__DETAIL_CODE:
        return basicSetDetailCode(null, msgs);
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
      case RoomPackage.MESSAGE_HANDLER__MSG:
        if (resolve) return getMsg();
        return basicGetMsg();
      case RoomPackage.MESSAGE_HANDLER__DETAIL_CODE:
        return getDetailCode();
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
      case RoomPackage.MESSAGE_HANDLER__MSG:
        setMsg((Message)newValue);
        return;
      case RoomPackage.MESSAGE_HANDLER__DETAIL_CODE:
        setDetailCode((DetailCode)newValue);
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
      case RoomPackage.MESSAGE_HANDLER__MSG:
        setMsg((Message)null);
        return;
      case RoomPackage.MESSAGE_HANDLER__DETAIL_CODE:
        setDetailCode((DetailCode)null);
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
      case RoomPackage.MESSAGE_HANDLER__MSG:
        return msg != null;
      case RoomPackage.MESSAGE_HANDLER__DETAIL_CODE:
        return detailCode != null;
    }
    return super.eIsSet(featureID);
  }

} //MessageHandlerImpl
