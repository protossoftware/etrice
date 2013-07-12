/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.BindingImpl#getEndpoint1 <em>Endpoint1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.BindingImpl#getEndpoint2 <em>Endpoint2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingImpl extends MinimalEObjectImpl.Container implements Binding
{
  /**
   * The cached value of the '{@link #getEndpoint1() <em>Endpoint1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndpoint1()
   * @generated
   * @ordered
   */
  protected BindingEndPoint endpoint1;

  /**
   * The cached value of the '{@link #getEndpoint2() <em>Endpoint2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndpoint2()
   * @generated
   * @ordered
   */
  protected BindingEndPoint endpoint2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BindingImpl()
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
    return RoomPackage.Literals.BINDING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BindingEndPoint getEndpoint1()
  {
    return endpoint1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEndpoint1(BindingEndPoint newEndpoint1, NotificationChain msgs)
  {
    BindingEndPoint oldEndpoint1 = endpoint1;
    endpoint1 = newEndpoint1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.BINDING__ENDPOINT1, oldEndpoint1, newEndpoint1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEndpoint1(BindingEndPoint newEndpoint1)
  {
    if (newEndpoint1 != endpoint1)
    {
      NotificationChain msgs = null;
      if (endpoint1 != null)
        msgs = ((InternalEObject)endpoint1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.BINDING__ENDPOINT1, null, msgs);
      if (newEndpoint1 != null)
        msgs = ((InternalEObject)newEndpoint1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.BINDING__ENDPOINT1, null, msgs);
      msgs = basicSetEndpoint1(newEndpoint1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.BINDING__ENDPOINT1, newEndpoint1, newEndpoint1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BindingEndPoint getEndpoint2()
  {
    return endpoint2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEndpoint2(BindingEndPoint newEndpoint2, NotificationChain msgs)
  {
    BindingEndPoint oldEndpoint2 = endpoint2;
    endpoint2 = newEndpoint2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.BINDING__ENDPOINT2, oldEndpoint2, newEndpoint2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEndpoint2(BindingEndPoint newEndpoint2)
  {
    if (newEndpoint2 != endpoint2)
    {
      NotificationChain msgs = null;
      if (endpoint2 != null)
        msgs = ((InternalEObject)endpoint2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.BINDING__ENDPOINT2, null, msgs);
      if (newEndpoint2 != null)
        msgs = ((InternalEObject)newEndpoint2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.BINDING__ENDPOINT2, null, msgs);
      msgs = basicSetEndpoint2(newEndpoint2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.BINDING__ENDPOINT2, newEndpoint2, newEndpoint2));
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
      case RoomPackage.BINDING__ENDPOINT1:
        return basicSetEndpoint1(null, msgs);
      case RoomPackage.BINDING__ENDPOINT2:
        return basicSetEndpoint2(null, msgs);
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
      case RoomPackage.BINDING__ENDPOINT1:
        return getEndpoint1();
      case RoomPackage.BINDING__ENDPOINT2:
        return getEndpoint2();
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
      case RoomPackage.BINDING__ENDPOINT1:
        setEndpoint1((BindingEndPoint)newValue);
        return;
      case RoomPackage.BINDING__ENDPOINT2:
        setEndpoint2((BindingEndPoint)newValue);
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
      case RoomPackage.BINDING__ENDPOINT1:
        setEndpoint1((BindingEndPoint)null);
        return;
      case RoomPackage.BINDING__ENDPOINT2:
        setEndpoint2((BindingEndPoint)null);
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
      case RoomPackage.BINDING__ENDPOINT1:
        return endpoint1 != null;
      case RoomPackage.BINDING__ENDPOINT2:
        return endpoint2 != null;
    }
    return super.eIsSet(featureID);
  }

} //BindingImpl
