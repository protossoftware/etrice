/**
 */
package org.eclipse.etrice.generator.fsmtest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.generator.fsmtest.FsmDefinition;
import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.Model;
import org.eclipse.etrice.generator.fsmtest.RandomTest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.ModelImpl#getFsmDefinitions <em>Fsm Definitions</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.ModelImpl#getRandomTests <em>Random Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getFsmDefinitions() <em>Fsm Definitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFsmDefinitions()
   * @generated
   * @ordered
   */
  protected EList<FsmDefinition> fsmDefinitions;

  /**
   * The cached value of the '{@link #getRandomTests() <em>Random Tests</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRandomTests()
   * @generated
   * @ordered
   */
  protected EList<RandomTest> randomTests;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return FsmtestPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FsmDefinition> getFsmDefinitions()
  {
    if (fsmDefinitions == null)
    {
      fsmDefinitions = new EObjectContainmentEList<FsmDefinition>(FsmDefinition.class, this, FsmtestPackage.MODEL__FSM_DEFINITIONS);
    }
    return fsmDefinitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RandomTest> getRandomTests()
  {
    if (randomTests == null)
    {
      randomTests = new EObjectContainmentEList<RandomTest>(RandomTest.class, this, FsmtestPackage.MODEL__RANDOM_TESTS);
    }
    return randomTests;
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
      case FsmtestPackage.MODEL__FSM_DEFINITIONS:
        return ((InternalEList<?>)getFsmDefinitions()).basicRemove(otherEnd, msgs);
      case FsmtestPackage.MODEL__RANDOM_TESTS:
        return ((InternalEList<?>)getRandomTests()).basicRemove(otherEnd, msgs);
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
      case FsmtestPackage.MODEL__FSM_DEFINITIONS:
        return getFsmDefinitions();
      case FsmtestPackage.MODEL__RANDOM_TESTS:
        return getRandomTests();
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
      case FsmtestPackage.MODEL__FSM_DEFINITIONS:
        getFsmDefinitions().clear();
        getFsmDefinitions().addAll((Collection<? extends FsmDefinition>)newValue);
        return;
      case FsmtestPackage.MODEL__RANDOM_TESTS:
        getRandomTests().clear();
        getRandomTests().addAll((Collection<? extends RandomTest>)newValue);
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
      case FsmtestPackage.MODEL__FSM_DEFINITIONS:
        getFsmDefinitions().clear();
        return;
      case FsmtestPackage.MODEL__RANDOM_TESTS:
        getRandomTests().clear();
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
      case FsmtestPackage.MODEL__FSM_DEFINITIONS:
        return fsmDefinitions != null && !fsmDefinitions.isEmpty();
      case FsmtestPackage.MODEL__RANDOM_TESTS:
        return randomTests != null && !randomTests.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
