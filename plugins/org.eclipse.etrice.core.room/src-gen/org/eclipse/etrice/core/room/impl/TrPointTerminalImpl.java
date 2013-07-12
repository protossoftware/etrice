/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tr Point Terminal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.TrPointTerminalImpl#getTrPoint <em>Tr Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrPointTerminalImpl extends TransitionTerminalImpl implements TrPointTerminal
{
  /**
   * The cached value of the '{@link #getTrPoint() <em>Tr Point</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrPoint()
   * @generated
   * @ordered
   */
  protected TrPoint trPoint;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TrPointTerminalImpl()
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
    return RoomPackage.Literals.TR_POINT_TERMINAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrPoint getTrPoint()
  {
    if (trPoint != null && trPoint.eIsProxy())
    {
      InternalEObject oldTrPoint = (InternalEObject)trPoint;
      trPoint = (TrPoint)eResolveProxy(oldTrPoint);
      if (trPoint != oldTrPoint)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.TR_POINT_TERMINAL__TR_POINT, oldTrPoint, trPoint));
      }
    }
    return trPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrPoint basicGetTrPoint()
  {
    return trPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrPoint(TrPoint newTrPoint)
  {
    TrPoint oldTrPoint = trPoint;
    trPoint = newTrPoint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.TR_POINT_TERMINAL__TR_POINT, oldTrPoint, trPoint));
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
      case RoomPackage.TR_POINT_TERMINAL__TR_POINT:
        if (resolve) return getTrPoint();
        return basicGetTrPoint();
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
      case RoomPackage.TR_POINT_TERMINAL__TR_POINT:
        setTrPoint((TrPoint)newValue);
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
      case RoomPackage.TR_POINT_TERMINAL__TR_POINT:
        setTrPoint((TrPoint)null);
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
      case RoomPackage.TR_POINT_TERMINAL__TR_POINT:
        return trPoint != null;
    }
    return super.eIsSet(featureID);
  }

} //TrPointTerminalImpl
