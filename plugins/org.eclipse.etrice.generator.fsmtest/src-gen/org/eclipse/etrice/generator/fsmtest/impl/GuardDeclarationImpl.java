/**
 */
package org.eclipse.etrice.generator.fsmtest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.GuardDeclaration;
import org.eclipse.etrice.generator.fsmtest.SignalDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.GuardDeclarationImpl#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardDeclarationImpl extends MinimalEObjectImpl.Container implements GuardDeclaration
{
  /**
   * The cached value of the '{@link #getSignal() <em>Signal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignal()
   * @generated
   * @ordered
   */
  protected SignalDeclaration signal;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GuardDeclarationImpl()
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
    return FsmtestPackage.Literals.GUARD_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalDeclaration getSignal()
  {
    return signal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSignal(SignalDeclaration newSignal, NotificationChain msgs)
  {
    SignalDeclaration oldSignal = signal;
    signal = newSignal;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.GUARD_DECLARATION__SIGNAL, oldSignal, newSignal);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignal(SignalDeclaration newSignal)
  {
    if (newSignal != signal)
    {
      NotificationChain msgs = null;
      if (signal != null)
        msgs = ((InternalEObject)signal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.GUARD_DECLARATION__SIGNAL, null, msgs);
      if (newSignal != null)
        msgs = ((InternalEObject)newSignal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.GUARD_DECLARATION__SIGNAL, null, msgs);
      msgs = basicSetSignal(newSignal, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.GUARD_DECLARATION__SIGNAL, newSignal, newSignal));
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
      case FsmtestPackage.GUARD_DECLARATION__SIGNAL:
        return basicSetSignal(null, msgs);
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
      case FsmtestPackage.GUARD_DECLARATION__SIGNAL:
        return getSignal();
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
      case FsmtestPackage.GUARD_DECLARATION__SIGNAL:
        setSignal((SignalDeclaration)newValue);
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
      case FsmtestPackage.GUARD_DECLARATION__SIGNAL:
        setSignal((SignalDeclaration)null);
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
      case FsmtestPackage.GUARD_DECLARATION__SIGNAL:
        return signal != null;
    }
    return super.eIsSet(featureID);
  }

} //GuardDeclarationImpl
