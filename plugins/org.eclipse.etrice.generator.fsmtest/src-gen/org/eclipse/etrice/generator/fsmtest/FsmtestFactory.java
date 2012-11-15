/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage
 * @generated
 */
public interface FsmtestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FsmtestFactory eINSTANCE = org.eclipse.etrice.generator.fsmtest.impl.FsmtestFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Fsm Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fsm Definition</em>'.
   * @generated
   */
  FsmDefinition createFsmDefinition();

  /**
   * Returns a new object of class '<em>Random Test</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Random Test</em>'.
   * @generated
   */
  RandomTest createRandomTest();

  /**
   * Returns a new object of class '<em>Guard Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard Declaration</em>'.
   * @generated
   */
  GuardDeclaration createGuardDeclaration();

  /**
   * Returns a new object of class '<em>Transition Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Declaration</em>'.
   * @generated
   */
  TransitionDeclaration createTransitionDeclaration();

  /**
   * Returns a new object of class '<em>Condition Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Condition Declaration</em>'.
   * @generated
   */
  ConditionDeclaration createConditionDeclaration();

  /**
   * Returns a new object of class '<em>Precondition Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Precondition Declaration</em>'.
   * @generated
   */
  PreconditionDeclaration createPreconditionDeclaration();

  /**
   * Returns a new object of class '<em>Postcondition Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postcondition Declaration</em>'.
   * @generated
   */
  PostconditionDeclaration createPostconditionDeclaration();

  /**
   * Returns a new object of class '<em>State Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Declaration</em>'.
   * @generated
   */
  StateDeclaration createStateDeclaration();

  /**
   * Returns a new object of class '<em>Loops Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Loops Declaration</em>'.
   * @generated
   */
  LoopsDeclaration createLoopsDeclaration();

  /**
   * Returns a new object of class '<em>Seed Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Seed Declaration</em>'.
   * @generated
   */
  SeedDeclaration createSeedDeclaration();

  /**
   * Returns a new object of class '<em>Signal Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signal Declaration</em>'.
   * @generated
   */
  SignalDeclaration createSignalDeclaration();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FsmtestPackage getFsmtestPackage();

} //FsmtestFactory
