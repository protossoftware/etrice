/**
 */
package org.eclipse.etrice.generator.fsmtest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.GuardDeclaration;
import org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration;
import org.eclipse.etrice.generator.fsmtest.PreconditionDeclaration;
import org.eclipse.etrice.generator.fsmtest.SignalDeclaration;
import org.eclipse.etrice.generator.fsmtest.StateDeclaration;
import org.eclipse.etrice.generator.fsmtest.TransitionDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl#getPostcondition <em>Postcondition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionDeclarationImpl extends MinimalEObjectImpl.Container implements TransitionDeclaration
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestination()
   * @generated
   * @ordered
   */
  protected StateDeclaration destination;

  /**
   * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger()
   * @generated
   * @ordered
   */
  protected SignalDeclaration trigger;

  /**
   * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggers()
   * @generated
   * @ordered
   */
  protected EList<GuardDeclaration> triggers;

  /**
   * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrecondition()
   * @generated
   * @ordered
   */
  protected EList<PreconditionDeclaration> precondition;

  /**
   * The cached value of the '{@link #getPostcondition() <em>Postcondition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostcondition()
   * @generated
   * @ordered
   */
  protected EList<PostconditionDeclaration> postcondition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionDeclarationImpl()
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
    return FsmtestPackage.Literals.TRANSITION_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TRANSITION_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateDeclaration getDestination()
  {
    if (destination != null && destination.eIsProxy())
    {
      InternalEObject oldDestination = (InternalEObject)destination;
      destination = (StateDeclaration)eResolveProxy(oldDestination);
      if (destination != oldDestination)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmtestPackage.TRANSITION_DECLARATION__DESTINATION, oldDestination, destination));
      }
    }
    return destination;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateDeclaration basicGetDestination()
  {
    return destination;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDestination(StateDeclaration newDestination)
  {
    StateDeclaration oldDestination = destination;
    destination = newDestination;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TRANSITION_DECLARATION__DESTINATION, oldDestination, destination));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalDeclaration getTrigger()
  {
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTrigger(SignalDeclaration newTrigger, NotificationChain msgs)
  {
    SignalDeclaration oldTrigger = trigger;
    trigger = newTrigger;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmtestPackage.TRANSITION_DECLARATION__TRIGGER, oldTrigger, newTrigger);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrigger(SignalDeclaration newTrigger)
  {
    if (newTrigger != trigger)
    {
      NotificationChain msgs = null;
      if (trigger != null)
        msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TRANSITION_DECLARATION__TRIGGER, null, msgs);
      if (newTrigger != null)
        msgs = ((InternalEObject)newTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmtestPackage.TRANSITION_DECLARATION__TRIGGER, null, msgs);
      msgs = basicSetTrigger(newTrigger, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.TRANSITION_DECLARATION__TRIGGER, newTrigger, newTrigger));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GuardDeclaration> getTriggers()
  {
    if (triggers == null)
    {
      triggers = new EObjectContainmentEList<GuardDeclaration>(GuardDeclaration.class, this, FsmtestPackage.TRANSITION_DECLARATION__TRIGGERS);
    }
    return triggers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PreconditionDeclaration> getPrecondition()
  {
    if (precondition == null)
    {
      precondition = new EObjectContainmentEList<PreconditionDeclaration>(PreconditionDeclaration.class, this, FsmtestPackage.TRANSITION_DECLARATION__PRECONDITION);
    }
    return precondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PostconditionDeclaration> getPostcondition()
  {
    if (postcondition == null)
    {
      postcondition = new EObjectContainmentEList<PostconditionDeclaration>(PostconditionDeclaration.class, this, FsmtestPackage.TRANSITION_DECLARATION__POSTCONDITION);
    }
    return postcondition;
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
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGER:
        return basicSetTrigger(null, msgs);
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGERS:
        return ((InternalEList<?>)getTriggers()).basicRemove(otherEnd, msgs);
      case FsmtestPackage.TRANSITION_DECLARATION__PRECONDITION:
        return ((InternalEList<?>)getPrecondition()).basicRemove(otherEnd, msgs);
      case FsmtestPackage.TRANSITION_DECLARATION__POSTCONDITION:
        return ((InternalEList<?>)getPostcondition()).basicRemove(otherEnd, msgs);
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
      case FsmtestPackage.TRANSITION_DECLARATION__NAME:
        return getName();
      case FsmtestPackage.TRANSITION_DECLARATION__DESTINATION:
        if (resolve) return getDestination();
        return basicGetDestination();
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGER:
        return getTrigger();
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGERS:
        return getTriggers();
      case FsmtestPackage.TRANSITION_DECLARATION__PRECONDITION:
        return getPrecondition();
      case FsmtestPackage.TRANSITION_DECLARATION__POSTCONDITION:
        return getPostcondition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FsmtestPackage.TRANSITION_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__DESTINATION:
        setDestination((StateDeclaration)newValue);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGER:
        setTrigger((SignalDeclaration)newValue);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGERS:
        getTriggers().clear();
        getTriggers().addAll((Collection<? extends GuardDeclaration>)newValue);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__PRECONDITION:
        getPrecondition().clear();
        getPrecondition().addAll((Collection<? extends PreconditionDeclaration>)newValue);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__POSTCONDITION:
        getPostcondition().clear();
        getPostcondition().addAll((Collection<? extends PostconditionDeclaration>)newValue);
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
      case FsmtestPackage.TRANSITION_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__DESTINATION:
        setDestination((StateDeclaration)null);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGER:
        setTrigger((SignalDeclaration)null);
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGERS:
        getTriggers().clear();
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__PRECONDITION:
        getPrecondition().clear();
        return;
      case FsmtestPackage.TRANSITION_DECLARATION__POSTCONDITION:
        getPostcondition().clear();
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
      case FsmtestPackage.TRANSITION_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FsmtestPackage.TRANSITION_DECLARATION__DESTINATION:
        return destination != null;
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGER:
        return trigger != null;
      case FsmtestPackage.TRANSITION_DECLARATION__TRIGGERS:
        return triggers != null && !triggers.isEmpty();
      case FsmtestPackage.TRANSITION_DECLARATION__PRECONDITION:
        return precondition != null && !precondition.isEmpty();
      case FsmtestPackage.TRANSITION_DECLARATION__POSTCONDITION:
        return postcondition != null && !postcondition.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TransitionDeclarationImpl
