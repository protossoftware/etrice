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
   * Returns a new object of class '<em>Testscript</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Testscript</em>'.
   * @generated
   */
  Testscript createTestscript();

  /**
   * Returns a new object of class '<em>State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State</em>'.
   * @generated
   */
  State createState();

  /**
   * Returns a new object of class '<em>State Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Declaration</em>'.
   * @generated
   */
  StateDeclaration createStateDeclaration();

  /**
   * Returns a new object of class '<em>Initial Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Initial Declaration</em>'.
   * @generated
   */
  InitialDeclaration createInitialDeclaration();

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
   * Returns a new object of class '<em>Source Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Source Declaration</em>'.
   * @generated
   */
  SourceDeclaration createSourceDeclaration();

  /**
   * Returns a new object of class '<em>Destination Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Destination Declaration</em>'.
   * @generated
   */
  DestinationDeclaration createDestinationDeclaration();

  /**
   * Returns a new object of class '<em>Transition Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Declaration</em>'.
   * @generated
   */
  TransitionDeclaration createTransitionDeclaration();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FsmtestPackage getFsmtestPackage();

} //FsmtestFactory
