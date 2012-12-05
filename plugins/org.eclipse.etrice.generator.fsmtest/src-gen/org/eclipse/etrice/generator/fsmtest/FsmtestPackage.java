/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestFactory
 * @model kind="package"
 * @generated
 */
public interface FsmtestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "fsmtest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/etrice/generator/FSMtest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fsmtest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FsmtestPackage eINSTANCE = org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.ModelImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Fsm Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FSM_DEFINITIONS = 0;

  /**
   * The feature id for the '<em><b>Random Tests</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__RANDOM_TESTS = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.FsmDefinitionImpl <em>Fsm Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmDefinitionImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getFsmDefinition()
   * @generated
   */
  int FSM_DEFINITION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM_DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM_DEFINITION__STATES = 1;

  /**
   * The number of structural features of the '<em>Fsm Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.RandomTestImpl <em>Random Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.RandomTestImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getRandomTest()
   * @generated
   */
  int RANDOM_TEST = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANDOM_TEST__NAME = 0;

  /**
   * The feature id for the '<em><b>Fsm</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANDOM_TEST__FSM = 1;

  /**
   * The feature id for the '<em><b>Loops Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANDOM_TEST__LOOPS_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Seed Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANDOM_TEST__SEED_DECLARATION = 3;

  /**
   * The number of structural features of the '<em>Random Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANDOM_TEST_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.GuardDeclarationImpl <em>Guard Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.GuardDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getGuardDeclaration()
   * @generated
   */
  int GUARD_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>Signal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_DECLARATION__SIGNAL = 0;

  /**
   * The number of structural features of the '<em>Guard Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl <em>Transition Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getTransitionDeclaration()
   * @generated
   */
  int TRANSITION_DECLARATION = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__DESTINATION = 1;

  /**
   * The feature id for the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__TRIGGER = 2;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__TRIGGERS = 3;

  /**
   * The feature id for the '<em><b>Precondition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__PRECONDITION = 4;

  /**
   * The feature id for the '<em><b>Postcondition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__POSTCONDITION = 5;

  /**
   * The number of structural features of the '<em>Transition Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.ConditionDeclarationImpl <em>Condition Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.ConditionDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getConditionDeclaration()
   * @generated
   */
  int CONDITION_DECLARATION = 5;

  /**
   * The feature id for the '<em><b>Signal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_DECLARATION__SIGNAL = 0;

  /**
   * The number of structural features of the '<em>Condition Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.PreconditionDeclarationImpl <em>Precondition Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.PreconditionDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getPreconditionDeclaration()
   * @generated
   */
  int PRECONDITION_DECLARATION = 6;

  /**
   * The feature id for the '<em><b>Signal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_DECLARATION__SIGNAL = 0;

  /**
   * The number of structural features of the '<em>Precondition Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.PostconditionDeclarationImpl <em>Postcondition Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.PostconditionDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getPostconditionDeclaration()
   * @generated
   */
  int POSTCONDITION_DECLARATION = 7;

  /**
   * The feature id for the '<em><b>Signal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTCONDITION_DECLARATION__SIGNAL = 0;

  /**
   * The number of structural features of the '<em>Postcondition Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTCONDITION_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.StateDeclarationImpl <em>State Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.StateDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getStateDeclaration()
   * @generated
   */
  int STATE_DECLARATION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_DECLARATION__CONDITION = 1;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_DECLARATION__TRANSITIONS = 2;

  /**
   * The number of structural features of the '<em>State Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.LoopsDeclarationImpl <em>Loops Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.LoopsDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getLoopsDeclaration()
   * @generated
   */
  int LOOPS_DECLARATION = 9;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPS_DECLARATION__VAL = 0;

  /**
   * The number of structural features of the '<em>Loops Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOPS_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.SeedDeclarationImpl <em>Seed Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.SeedDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getSeedDeclaration()
   * @generated
   */
  int SEED_DECLARATION = 10;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEED_DECLARATION__VAL = 0;

  /**
   * The number of structural features of the '<em>Seed Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEED_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.SignalDeclarationImpl <em>Signal Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.SignalDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getSignalDeclaration()
   * @generated
   */
  int SIGNAL_DECLARATION = 11;

  /**
   * The feature id for the '<em><b>Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL_DECLARATION__PORT = 0;

  /**
   * The feature id for the '<em><b>Signame</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL_DECLARATION__SIGNAME = 1;

  /**
   * The feature id for the '<em><b>Int Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL_DECLARATION__INT_VAL = 2;

  /**
   * The feature id for the '<em><b>Str Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL_DECLARATION__STR_VAL = 3;

  /**
   * The number of structural features of the '<em>Signal Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL_DECLARATION_FEATURE_COUNT = 4;


  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.Model#getFsmDefinitions <em>Fsm Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fsm Definitions</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Model#getFsmDefinitions()
   * @see #getModel()
   * @generated
   */
  EReference getModel_FsmDefinitions();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.Model#getRandomTests <em>Random Tests</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Random Tests</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Model#getRandomTests()
   * @see #getModel()
   * @generated
   */
  EReference getModel_RandomTests();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.FsmDefinition <em>Fsm Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fsm Definition</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.FsmDefinition
   * @generated
   */
  EClass getFsmDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.FsmDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.FsmDefinition#getName()
   * @see #getFsmDefinition()
   * @generated
   */
  EAttribute getFsmDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.FsmDefinition#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.FsmDefinition#getStates()
   * @see #getFsmDefinition()
   * @generated
   */
  EReference getFsmDefinition_States();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.RandomTest <em>Random Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Random Test</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.RandomTest
   * @generated
   */
  EClass getRandomTest();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.RandomTest#getName()
   * @see #getRandomTest()
   * @generated
   */
  EAttribute getRandomTest_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getFsm <em>Fsm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Fsm</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.RandomTest#getFsm()
   * @see #getRandomTest()
   * @generated
   */
  EReference getRandomTest_Fsm();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getLoopsDeclaration <em>Loops Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Loops Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.RandomTest#getLoopsDeclaration()
   * @see #getRandomTest()
   * @generated
   */
  EReference getRandomTest_LoopsDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getSeedDeclaration <em>Seed Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Seed Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.RandomTest#getSeedDeclaration()
   * @see #getRandomTest()
   * @generated
   */
  EReference getRandomTest_SeedDeclaration();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.GuardDeclaration <em>Guard Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.GuardDeclaration
   * @generated
   */
  EClass getGuardDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.GuardDeclaration#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Signal</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.GuardDeclaration#getSignal()
   * @see #getGuardDeclaration()
   * @generated
   */
  EReference getGuardDeclaration_Signal();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration <em>Transition Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration
   * @generated
   */
  EClass getTransitionDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getName()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EAttribute getTransitionDeclaration_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getDestination <em>Destination</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Destination</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getDestination()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EReference getTransitionDeclaration_Destination();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getTrigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Trigger</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getTrigger()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EReference getTransitionDeclaration_Trigger();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getTriggers()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EReference getTransitionDeclaration_Triggers();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getPrecondition <em>Precondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Precondition</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getPrecondition()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EReference getTransitionDeclaration_Precondition();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getPostcondition <em>Postcondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Postcondition</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getPostcondition()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EReference getTransitionDeclaration_Postcondition();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.ConditionDeclaration <em>Condition Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.ConditionDeclaration
   * @generated
   */
  EClass getConditionDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.ConditionDeclaration#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Signal</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.ConditionDeclaration#getSignal()
   * @see #getConditionDeclaration()
   * @generated
   */
  EReference getConditionDeclaration_Signal();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.PreconditionDeclaration <em>Precondition Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Precondition Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.PreconditionDeclaration
   * @generated
   */
  EClass getPreconditionDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.PreconditionDeclaration#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Signal</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.PreconditionDeclaration#getSignal()
   * @see #getPreconditionDeclaration()
   * @generated
   */
  EReference getPreconditionDeclaration_Signal();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration <em>Postcondition Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postcondition Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration
   * @generated
   */
  EClass getPostconditionDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Signal</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration#getSignal()
   * @see #getPostconditionDeclaration()
   * @generated
   */
  EReference getPostconditionDeclaration_Signal();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.StateDeclaration <em>State Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.StateDeclaration
   * @generated
   */
  EClass getStateDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.StateDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.StateDeclaration#getName()
   * @see #getStateDeclaration()
   * @generated
   */
  EAttribute getStateDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.StateDeclaration#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Condition</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.StateDeclaration#getCondition()
   * @see #getStateDeclaration()
   * @generated
   */
  EReference getStateDeclaration_Condition();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.StateDeclaration#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.StateDeclaration#getTransitions()
   * @see #getStateDeclaration()
   * @generated
   */
  EReference getStateDeclaration_Transitions();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.LoopsDeclaration <em>Loops Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loops Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.LoopsDeclaration
   * @generated
   */
  EClass getLoopsDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.LoopsDeclaration#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.LoopsDeclaration#getVal()
   * @see #getLoopsDeclaration()
   * @generated
   */
  EAttribute getLoopsDeclaration_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.SeedDeclaration <em>Seed Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Seed Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.SeedDeclaration
   * @generated
   */
  EClass getSeedDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.SeedDeclaration#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.SeedDeclaration#getVal()
   * @see #getSeedDeclaration()
   * @generated
   */
  EAttribute getSeedDeclaration_Val();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration <em>Signal Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signal Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.SignalDeclaration
   * @generated
   */
  EClass getSignalDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Port</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getPort()
   * @see #getSignalDeclaration()
   * @generated
   */
  EAttribute getSignalDeclaration_Port();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getSigname <em>Signame</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Signame</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getSigname()
   * @see #getSignalDeclaration()
   * @generated
   */
  EAttribute getSignalDeclaration_Signame();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getIntVal <em>Int Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Int Val</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getIntVal()
   * @see #getSignalDeclaration()
   * @generated
   */
  EAttribute getSignalDeclaration_IntVal();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getStrVal <em>Str Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Str Val</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getStrVal()
   * @see #getSignalDeclaration()
   * @generated
   */
  EAttribute getSignalDeclaration_StrVal();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FsmtestFactory getFsmtestFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.ModelImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Fsm Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__FSM_DEFINITIONS = eINSTANCE.getModel_FsmDefinitions();

    /**
     * The meta object literal for the '<em><b>Random Tests</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__RANDOM_TESTS = eINSTANCE.getModel_RandomTests();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.FsmDefinitionImpl <em>Fsm Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmDefinitionImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getFsmDefinition()
     * @generated
     */
    EClass FSM_DEFINITION = eINSTANCE.getFsmDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FSM_DEFINITION__NAME = eINSTANCE.getFsmDefinition_Name();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FSM_DEFINITION__STATES = eINSTANCE.getFsmDefinition_States();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.RandomTestImpl <em>Random Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.RandomTestImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getRandomTest()
     * @generated
     */
    EClass RANDOM_TEST = eINSTANCE.getRandomTest();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANDOM_TEST__NAME = eINSTANCE.getRandomTest_Name();

    /**
     * The meta object literal for the '<em><b>Fsm</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANDOM_TEST__FSM = eINSTANCE.getRandomTest_Fsm();

    /**
     * The meta object literal for the '<em><b>Loops Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANDOM_TEST__LOOPS_DECLARATION = eINSTANCE.getRandomTest_LoopsDeclaration();

    /**
     * The meta object literal for the '<em><b>Seed Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANDOM_TEST__SEED_DECLARATION = eINSTANCE.getRandomTest_SeedDeclaration();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.GuardDeclarationImpl <em>Guard Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.GuardDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getGuardDeclaration()
     * @generated
     */
    EClass GUARD_DECLARATION = eINSTANCE.getGuardDeclaration();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD_DECLARATION__SIGNAL = eINSTANCE.getGuardDeclaration_Signal();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl <em>Transition Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getTransitionDeclaration()
     * @generated
     */
    EClass TRANSITION_DECLARATION = eINSTANCE.getTransitionDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION_DECLARATION__NAME = eINSTANCE.getTransitionDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DECLARATION__DESTINATION = eINSTANCE.getTransitionDeclaration_Destination();

    /**
     * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DECLARATION__TRIGGER = eINSTANCE.getTransitionDeclaration_Trigger();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DECLARATION__TRIGGERS = eINSTANCE.getTransitionDeclaration_Triggers();

    /**
     * The meta object literal for the '<em><b>Precondition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DECLARATION__PRECONDITION = eINSTANCE.getTransitionDeclaration_Precondition();

    /**
     * The meta object literal for the '<em><b>Postcondition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DECLARATION__POSTCONDITION = eINSTANCE.getTransitionDeclaration_Postcondition();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.ConditionDeclarationImpl <em>Condition Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.ConditionDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getConditionDeclaration()
     * @generated
     */
    EClass CONDITION_DECLARATION = eINSTANCE.getConditionDeclaration();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITION_DECLARATION__SIGNAL = eINSTANCE.getConditionDeclaration_Signal();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.PreconditionDeclarationImpl <em>Precondition Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.PreconditionDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getPreconditionDeclaration()
     * @generated
     */
    EClass PRECONDITION_DECLARATION = eINSTANCE.getPreconditionDeclaration();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRECONDITION_DECLARATION__SIGNAL = eINSTANCE.getPreconditionDeclaration_Signal();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.PostconditionDeclarationImpl <em>Postcondition Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.PostconditionDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getPostconditionDeclaration()
     * @generated
     */
    EClass POSTCONDITION_DECLARATION = eINSTANCE.getPostconditionDeclaration();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTCONDITION_DECLARATION__SIGNAL = eINSTANCE.getPostconditionDeclaration_Signal();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.StateDeclarationImpl <em>State Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.StateDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getStateDeclaration()
     * @generated
     */
    EClass STATE_DECLARATION = eINSTANCE.getStateDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_DECLARATION__NAME = eINSTANCE.getStateDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_DECLARATION__CONDITION = eINSTANCE.getStateDeclaration_Condition();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_DECLARATION__TRANSITIONS = eINSTANCE.getStateDeclaration_Transitions();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.LoopsDeclarationImpl <em>Loops Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.LoopsDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getLoopsDeclaration()
     * @generated
     */
    EClass LOOPS_DECLARATION = eINSTANCE.getLoopsDeclaration();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOPS_DECLARATION__VAL = eINSTANCE.getLoopsDeclaration_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.SeedDeclarationImpl <em>Seed Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.SeedDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getSeedDeclaration()
     * @generated
     */
    EClass SEED_DECLARATION = eINSTANCE.getSeedDeclaration();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SEED_DECLARATION__VAL = eINSTANCE.getSeedDeclaration_Val();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.SignalDeclarationImpl <em>Signal Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.SignalDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getSignalDeclaration()
     * @generated
     */
    EClass SIGNAL_DECLARATION = eINSTANCE.getSignalDeclaration();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNAL_DECLARATION__PORT = eINSTANCE.getSignalDeclaration_Port();

    /**
     * The meta object literal for the '<em><b>Signame</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNAL_DECLARATION__SIGNAME = eINSTANCE.getSignalDeclaration_Signame();

    /**
     * The meta object literal for the '<em><b>Int Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNAL_DECLARATION__INT_VAL = eINSTANCE.getSignalDeclaration_IntVal();

    /**
     * The meta object literal for the '<em><b>Str Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNAL_DECLARATION__STR_VAL = eINSTANCE.getSignalDeclaration_StrVal();

  }

} //FsmtestPackage
