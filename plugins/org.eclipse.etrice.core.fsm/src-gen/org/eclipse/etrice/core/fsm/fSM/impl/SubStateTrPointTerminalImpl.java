/**
 * generated by Xtext
 */
package org.eclipse.etrice.core.fsm.fSM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub State Tr Point Terminal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.SubStateTrPointTerminalImpl#getTrPoint <em>Tr Point</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.SubStateTrPointTerminalImpl#getState <em>State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubStateTrPointTerminalImpl extends TransitionTerminalImpl implements SubStateTrPointTerminal
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
   * The cached value of the '{@link #getState() <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected State state;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubStateTrPointTerminalImpl()
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
    return FSMPackage.Literals.SUB_STATE_TR_POINT_TERMINAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TrPoint getTrPoint()
  {
    if (trPoint != null && trPoint.eIsProxy())
    {
      InternalEObject oldTrPoint = (InternalEObject)trPoint;
      trPoint = (TrPoint)eResolveProxy(oldTrPoint);
      if (trPoint != oldTrPoint)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FSMPackage.SUB_STATE_TR_POINT_TERMINAL__TR_POINT, oldTrPoint, trPoint));
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
  @Override
  public void setTrPoint(TrPoint newTrPoint)
  {
    TrPoint oldTrPoint = trPoint;
    trPoint = newTrPoint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.SUB_STATE_TR_POINT_TERMINAL__TR_POINT, oldTrPoint, trPoint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public State getState()
  {
    if (state != null && state.eIsProxy())
    {
      InternalEObject oldState = (InternalEObject)state;
      state = (State)eResolveProxy(oldState);
      if (state != oldState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FSMPackage.SUB_STATE_TR_POINT_TERMINAL__STATE, oldState, state));
      }
    }
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State basicGetState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setState(State newState)
  {
    State oldState = state;
    state = newState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.SUB_STATE_TR_POINT_TERMINAL__STATE, oldState, state));
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
      case FSMPackage.SUB_STATE_TR_POINT_TERMINAL__TR_POINT:
        if (resolve) return getTrPoint();
        return basicGetTrPoint();
      case FSMPackage.SUB_STATE_TR_POINT_TERMINAL__STATE:
        if (resolve) return getState();
        return basicGetState();
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
      case FSMPackage.SUB_STATE_TR_POINT_TERMINAL__TR_POINT:
        setTrPoint((TrPoint)newValue);
        return;
      case FSMPackage.SUB_STATE_TR_POINT_TERMINAL__STATE:
        setState((State)newValue);
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
      case FSMPackage.SUB_STATE_TR_POINT_TERMINAL__TR_POINT:
        setTrPoint((TrPoint)null);
        return;
      case FSMPackage.SUB_STATE_TR_POINT_TERMINAL__STATE:
        setState((State)null);
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
      case FSMPackage.SUB_STATE_TR_POINT_TERMINAL__TR_POINT:
        return trPoint != null;
      case FSMPackage.SUB_STATE_TR_POINT_TERMINAL__STATE:
        return state != null;
    }
    return super.eIsSet(featureID);
  }

} //SubStateTrPointTerminalImpl
