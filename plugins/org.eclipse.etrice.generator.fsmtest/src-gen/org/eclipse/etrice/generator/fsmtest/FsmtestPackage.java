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
   * The feature id for the '<em><b>Testscripts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__TESTSCRIPTS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl <em>Testscript</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getTestscript()
   * @generated
   */
  int TESTSCRIPT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TESTSCRIPT__NAME = 0;

  /**
   * The feature id for the '<em><b>State Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TESTSCRIPT__STATE_DECLARATION = 1;

  /**
   * The feature id for the '<em><b>Initial Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TESTSCRIPT__INITIAL_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Loops Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TESTSCRIPT__LOOPS_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>Seed Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TESTSCRIPT__SEED_DECLARATION = 4;

  /**
   * The feature id for the '<em><b>Transition Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TESTSCRIPT__TRANSITION_DECLARATIONS = 5;

  /**
   * The number of structural features of the '<em>Testscript</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TESTSCRIPT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.StateImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getState()
   * @generated
   */
  int STATE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__NAME = 0;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.StateDeclarationImpl <em>State Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.StateDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getStateDeclaration()
   * @generated
   */
  int STATE_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_DECLARATION__STATES = 0;

  /**
   * The number of structural features of the '<em>State Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.InitialDeclarationImpl <em>Initial Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.InitialDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getInitialDeclaration()
   * @generated
   */
  int INITIAL_DECLARATION = 4;

  /**
   * The feature id for the '<em><b>Initial</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_DECLARATION__INITIAL = 0;

  /**
   * The number of structural features of the '<em>Initial Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.LoopsDeclarationImpl <em>Loops Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.LoopsDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getLoopsDeclaration()
   * @generated
   */
  int LOOPS_DECLARATION = 5;

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
  int SEED_DECLARATION = 6;

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
  int SIGNAL_DECLARATION = 7;

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
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.SourceDeclarationImpl <em>Source Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.SourceDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getSourceDeclaration()
   * @generated
   */
  int SOURCE_DECLARATION = 8;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_DECLARATION__REF = 0;

  /**
   * The number of structural features of the '<em>Source Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.DestinationDeclarationImpl <em>Destination Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.DestinationDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getDestinationDeclaration()
   * @generated
   */
  int DESTINATION_DECLARATION = 9;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESTINATION_DECLARATION__REF = 0;

  /**
   * The number of structural features of the '<em>Destination Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESTINATION_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl <em>Transition Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.generator.fsmtest.impl.TransitionDeclarationImpl
   * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getTransitionDeclaration()
   * @generated
   */
  int TRANSITION_DECLARATION = 10;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__SOURCE = 0;

  /**
   * The feature id for the '<em><b>In</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__IN = 1;

  /**
   * The feature id for the '<em><b>Out</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__OUT = 2;

  /**
   * The feature id for the '<em><b>Destination</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION__DESTINATION = 3;

  /**
   * The number of structural features of the '<em>Transition Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_DECLARATION_FEATURE_COUNT = 4;


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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.Model#getTestscripts <em>Testscripts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Testscripts</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Model#getTestscripts()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Testscripts();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.Testscript <em>Testscript</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Testscript</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Testscript
   * @generated
   */
  EClass getTestscript();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Testscript#getName()
   * @see #getTestscript()
   * @generated
   */
  EAttribute getTestscript_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getStateDeclaration <em>State Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Testscript#getStateDeclaration()
   * @see #getTestscript()
   * @generated
   */
  EReference getTestscript_StateDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getInitialDeclaration <em>Initial Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Testscript#getInitialDeclaration()
   * @see #getTestscript()
   * @generated
   */
  EReference getTestscript_InitialDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getLoopsDeclaration <em>Loops Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Loops Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Testscript#getLoopsDeclaration()
   * @see #getTestscript()
   * @generated
   */
  EReference getTestscript_LoopsDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getSeedDeclaration <em>Seed Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Seed Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Testscript#getSeedDeclaration()
   * @see #getTestscript()
   * @generated
   */
  EReference getTestscript_SeedDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getTransitionDeclarations <em>Transition Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transition Declarations</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.Testscript#getTransitionDeclarations()
   * @see #getTestscript()
   * @generated
   */
  EReference getTestscript_TransitionDeclarations();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.generator.fsmtest.State#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.State#getName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Name();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.StateDeclaration#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.StateDeclaration#getStates()
   * @see #getStateDeclaration()
   * @generated
   */
  EReference getStateDeclaration_States();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.InitialDeclaration <em>Initial Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Initial Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.InitialDeclaration
   * @generated
   */
  EClass getInitialDeclaration();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.generator.fsmtest.InitialDeclaration#getInitial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Initial</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.InitialDeclaration#getInitial()
   * @see #getInitialDeclaration()
   * @generated
   */
  EReference getInitialDeclaration_Initial();

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
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.SourceDeclaration <em>Source Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.SourceDeclaration
   * @generated
   */
  EClass getSourceDeclaration();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.generator.fsmtest.SourceDeclaration#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.SourceDeclaration#getRef()
   * @see #getSourceDeclaration()
   * @generated
   */
  EReference getSourceDeclaration_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.generator.fsmtest.DestinationDeclaration <em>Destination Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Destination Declaration</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.DestinationDeclaration
   * @generated
   */
  EClass getDestinationDeclaration();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.generator.fsmtest.DestinationDeclaration#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.DestinationDeclaration#getRef()
   * @see #getDestinationDeclaration()
   * @generated
   */
  EReference getDestinationDeclaration_Ref();

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
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getSource()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EReference getTransitionDeclaration_Source();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getIn <em>In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>In</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getIn()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EReference getTransitionDeclaration_In();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getOut <em>Out</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Out</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getOut()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EReference getTransitionDeclaration_Out();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getDestination <em>Destination</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Destination</em>'.
   * @see org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getDestination()
   * @see #getTransitionDeclaration()
   * @generated
   */
  EReference getTransitionDeclaration_Destination();

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
     * The meta object literal for the '<em><b>Testscripts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__TESTSCRIPTS = eINSTANCE.getModel_Testscripts();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl <em>Testscript</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.TestscriptImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getTestscript()
     * @generated
     */
    EClass TESTSCRIPT = eINSTANCE.getTestscript();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TESTSCRIPT__NAME = eINSTANCE.getTestscript_Name();

    /**
     * The meta object literal for the '<em><b>State Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TESTSCRIPT__STATE_DECLARATION = eINSTANCE.getTestscript_StateDeclaration();

    /**
     * The meta object literal for the '<em><b>Initial Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TESTSCRIPT__INITIAL_DECLARATION = eINSTANCE.getTestscript_InitialDeclaration();

    /**
     * The meta object literal for the '<em><b>Loops Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TESTSCRIPT__LOOPS_DECLARATION = eINSTANCE.getTestscript_LoopsDeclaration();

    /**
     * The meta object literal for the '<em><b>Seed Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TESTSCRIPT__SEED_DECLARATION = eINSTANCE.getTestscript_SeedDeclaration();

    /**
     * The meta object literal for the '<em><b>Transition Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TESTSCRIPT__TRANSITION_DECLARATIONS = eINSTANCE.getTestscript_TransitionDeclarations();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.StateImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__NAME = eINSTANCE.getState_Name();

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
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_DECLARATION__STATES = eINSTANCE.getStateDeclaration_States();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.InitialDeclarationImpl <em>Initial Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.InitialDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getInitialDeclaration()
     * @generated
     */
    EClass INITIAL_DECLARATION = eINSTANCE.getInitialDeclaration();

    /**
     * The meta object literal for the '<em><b>Initial</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INITIAL_DECLARATION__INITIAL = eINSTANCE.getInitialDeclaration_Initial();

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

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.SourceDeclarationImpl <em>Source Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.SourceDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getSourceDeclaration()
     * @generated
     */
    EClass SOURCE_DECLARATION = eINSTANCE.getSourceDeclaration();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOURCE_DECLARATION__REF = eINSTANCE.getSourceDeclaration_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.generator.fsmtest.impl.DestinationDeclarationImpl <em>Destination Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.generator.fsmtest.impl.DestinationDeclarationImpl
     * @see org.eclipse.etrice.generator.fsmtest.impl.FsmtestPackageImpl#getDestinationDeclaration()
     * @generated
     */
    EClass DESTINATION_DECLARATION = eINSTANCE.getDestinationDeclaration();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DESTINATION_DECLARATION__REF = eINSTANCE.getDestinationDeclaration_Ref();

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
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DECLARATION__SOURCE = eINSTANCE.getTransitionDeclaration_Source();

    /**
     * The meta object literal for the '<em><b>In</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DECLARATION__IN = eINSTANCE.getTransitionDeclaration_In();

    /**
     * The meta object literal for the '<em><b>Out</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DECLARATION__OUT = eINSTANCE.getTransitionDeclaration_Out();

    /**
     * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_DECLARATION__DESTINATION = eINSTANCE.getTransitionDeclaration_Destination();

  }

} //FsmtestPackage
