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

import org.eclipse.etrice.generator.fsmtest.ConditionDeclaration;
import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.StateDeclaration;
import org.eclipse.etrice.generator.fsmtest.TransitionDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.StateDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.StateDeclarationImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.StateDeclarationImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateDeclarationImpl extends MinimalEObjectImpl.Container implements StateDeclaration
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
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected EList<ConditionDeclaration> condition;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  protected EList<TransitionDeclaration> transitions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateDeclarationImpl()
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
    return FsmtestPackage.Literals.STATE_DECLARATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.STATE_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConditionDeclaration> getCondition()
  {
    if (condition == null)
    {
      condition = new EObjectContainmentEList<ConditionDeclaration>(ConditionDeclaration.class, this, FsmtestPackage.STATE_DECLARATION__CONDITION);
    }
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TransitionDeclaration> getTransitions()
  {
    if (transitions == null)
    {
      transitions = new EObjectContainmentEList<TransitionDeclaration>(TransitionDeclaration.class, this, FsmtestPackage.STATE_DECLARATION__TRANSITIONS);
    }
    return transitions;
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
      case FsmtestPackage.STATE_DECLARATION__CONDITION:
        return ((InternalEList<?>)getCondition()).basicRemove(otherEnd, msgs);
      case FsmtestPackage.STATE_DECLARATION__TRANSITIONS:
        return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
      case FsmtestPackage.STATE_DECLARATION__NAME:
        return getName();
      case FsmtestPackage.STATE_DECLARATION__CONDITION:
        return getCondition();
      case FsmtestPackage.STATE_DECLARATION__TRANSITIONS:
        return getTransitions();
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
      case FsmtestPackage.STATE_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case FsmtestPackage.STATE_DECLARATION__CONDITION:
        getCondition().clear();
        getCondition().addAll((Collection<? extends ConditionDeclaration>)newValue);
        return;
      case FsmtestPackage.STATE_DECLARATION__TRANSITIONS:
        getTransitions().clear();
        getTransitions().addAll((Collection<? extends TransitionDeclaration>)newValue);
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
      case FsmtestPackage.STATE_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FsmtestPackage.STATE_DECLARATION__CONDITION:
        getCondition().clear();
        return;
      case FsmtestPackage.STATE_DECLARATION__TRANSITIONS:
        getTransitions().clear();
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
      case FsmtestPackage.STATE_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FsmtestPackage.STATE_DECLARATION__CONDITION:
        return condition != null && !condition.isEmpty();
      case FsmtestPackage.STATE_DECLARATION__TRANSITIONS:
        return transitions != null && !transitions.isEmpty();
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

} //StateDeclarationImpl
