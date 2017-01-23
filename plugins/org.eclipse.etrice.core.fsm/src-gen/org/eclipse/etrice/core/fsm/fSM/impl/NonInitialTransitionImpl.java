/**
 */
package org.eclipse.etrice.core.fsm.fSM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Initial Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.NonInitialTransitionImpl#getFrom <em>From</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NonInitialTransitionImpl extends TransitionImpl implements NonInitialTransition
{
  /**
   * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrom()
   * @generated
   * @ordered
   */
  protected TransitionTerminal from;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NonInitialTransitionImpl()
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
    return FSMPackage.Literals.NON_INITIAL_TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionTerminal getFrom()
  {
    return from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFrom(TransitionTerminal newFrom, NotificationChain msgs)
  {
    TransitionTerminal oldFrom = from;
    from = newFrom;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FSMPackage.NON_INITIAL_TRANSITION__FROM, oldFrom, newFrom);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFrom(TransitionTerminal newFrom)
  {
    if (newFrom != from)
    {
      NotificationChain msgs = null;
      if (from != null)
        msgs = ((InternalEObject)from).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FSMPackage.NON_INITIAL_TRANSITION__FROM, null, msgs);
      if (newFrom != null)
        msgs = ((InternalEObject)newFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FSMPackage.NON_INITIAL_TRANSITION__FROM, null, msgs);
      msgs = basicSetFrom(newFrom, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.NON_INITIAL_TRANSITION__FROM, newFrom, newFrom));
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
      case FSMPackage.NON_INITIAL_TRANSITION__FROM:
        return basicSetFrom(null, msgs);
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
      case FSMPackage.NON_INITIAL_TRANSITION__FROM:
        return getFrom();
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
      case FSMPackage.NON_INITIAL_TRANSITION__FROM:
        setFrom((TransitionTerminal)newValue);
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
      case FSMPackage.NON_INITIAL_TRANSITION__FROM:
        setFrom((TransitionTerminal)null);
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
      case FSMPackage.NON_INITIAL_TRANSITION__FROM:
        return from != null;
    }
    return super.eIsSet(featureID);
  }

} //NonInitialTransitionImpl
