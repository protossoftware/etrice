/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SPPRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relay SA Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.RelaySAPointImpl#getRelay <em>Relay</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelaySAPointImpl extends SAPointImpl implements RelaySAPoint
{
  /**
   * The cached value of the '{@link #getRelay() <em>Relay</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelay()
   * @generated
   * @ordered
   */
  protected SPPRef relay;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RelaySAPointImpl()
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
    return RoomPackage.Literals.RELAY_SA_POINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SPPRef getRelay()
  {
    if (relay != null && relay.eIsProxy())
    {
      InternalEObject oldRelay = (InternalEObject)relay;
      relay = (SPPRef)eResolveProxy(oldRelay);
      if (relay != oldRelay)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.RELAY_SA_POINT__RELAY, oldRelay, relay));
      }
    }
    return relay;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SPPRef basicGetRelay()
  {
    return relay;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRelay(SPPRef newRelay)
  {
    SPPRef oldRelay = relay;
    relay = newRelay;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.RELAY_SA_POINT__RELAY, oldRelay, relay));
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
      case RoomPackage.RELAY_SA_POINT__RELAY:
        if (resolve) return getRelay();
        return basicGetRelay();
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
      case RoomPackage.RELAY_SA_POINT__RELAY:
        setRelay((SPPRef)newValue);
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
      case RoomPackage.RELAY_SA_POINT__RELAY:
        setRelay((SPPRef)null);
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
      case RoomPackage.RELAY_SA_POINT__RELAY:
        return relay != null;
    }
    return super.eIsSet(featureID);
  }

} //RelaySAPointImpl
