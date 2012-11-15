/**
 */
package org.eclipse.etrice.generator.fsmtest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.etrice.generator.fsmtest.ConditionDeclaration;
import org.eclipse.etrice.generator.fsmtest.FsmDefinition;
import org.eclipse.etrice.generator.fsmtest.FsmtestFactory;
import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.GuardDeclaration;
import org.eclipse.etrice.generator.fsmtest.LoopsDeclaration;
import org.eclipse.etrice.generator.fsmtest.Model;
import org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration;
import org.eclipse.etrice.generator.fsmtest.PreconditionDeclaration;
import org.eclipse.etrice.generator.fsmtest.RandomTest;
import org.eclipse.etrice.generator.fsmtest.SeedDeclaration;
import org.eclipse.etrice.generator.fsmtest.SignalDeclaration;
import org.eclipse.etrice.generator.fsmtest.StateDeclaration;
import org.eclipse.etrice.generator.fsmtest.TransitionDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FsmtestPackageImpl extends EPackageImpl implements FsmtestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fsmDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass randomTestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preconditionDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postconditionDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loopsDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass seedDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signalDeclarationEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FsmtestPackageImpl()
  {
    super(eNS_URI, FsmtestFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link FsmtestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FsmtestPackage init()
  {
    if (isInited) return (FsmtestPackage)EPackage.Registry.INSTANCE.getEPackage(FsmtestPackage.eNS_URI);

    // Obtain or create and register package
    FsmtestPackageImpl theFsmtestPackage = (FsmtestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FsmtestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FsmtestPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theFsmtestPackage.createPackageContents();

    // Initialize created meta-data
    theFsmtestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFsmtestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FsmtestPackage.eNS_URI, theFsmtestPackage);
    return theFsmtestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_FsmDefinitions()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_RandomTests()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFsmDefinition()
  {
    return fsmDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFsmDefinition_Name()
  {
    return (EAttribute)fsmDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFsmDefinition_States()
  {
    return (EReference)fsmDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRandomTest()
  {
    return randomTestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRandomTest_Name()
  {
    return (EAttribute)randomTestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRandomTest_Fsm()
  {
    return (EReference)randomTestEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRandomTest_LoopsDeclaration()
  {
    return (EReference)randomTestEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRandomTest_SeedDeclaration()
  {
    return (EReference)randomTestEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuardDeclaration()
  {
    return guardDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGuardDeclaration_Signal()
  {
    return (EReference)guardDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionDeclaration()
  {
    return transitionDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionDeclaration_Name()
  {
    return (EAttribute)transitionDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionDeclaration_Destination()
  {
    return (EReference)transitionDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionDeclaration_Trigger()
  {
    return (EReference)transitionDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionDeclaration_Triggers()
  {
    return (EReference)transitionDeclarationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionDeclaration_Precondition()
  {
    return (EReference)transitionDeclarationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionDeclaration_Postcondition()
  {
    return (EReference)transitionDeclarationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionDeclaration()
  {
    return conditionDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionDeclaration_Signal()
  {
    return (EReference)conditionDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreconditionDeclaration()
  {
    return preconditionDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreconditionDeclaration_Signal()
  {
    return (EReference)preconditionDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostconditionDeclaration()
  {
    return postconditionDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostconditionDeclaration_Signal()
  {
    return (EReference)postconditionDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateDeclaration()
  {
    return stateDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateDeclaration_Name()
  {
    return (EAttribute)stateDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateDeclaration_Condition()
  {
    return (EReference)stateDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateDeclaration_Transitions()
  {
    return (EReference)stateDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoopsDeclaration()
  {
    return loopsDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopsDeclaration_Val()
  {
    return (EAttribute)loopsDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSeedDeclaration()
  {
    return seedDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSeedDeclaration_Val()
  {
    return (EAttribute)seedDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignalDeclaration()
  {
    return signalDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSignalDeclaration_Port()
  {
    return (EAttribute)signalDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSignalDeclaration_Signame()
  {
    return (EAttribute)signalDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSignalDeclaration_IntVal()
  {
    return (EAttribute)signalDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSignalDeclaration_StrVal()
  {
    return (EAttribute)signalDeclarationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FsmtestFactory getFsmtestFactory()
  {
    return (FsmtestFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__FSM_DEFINITIONS);
    createEReference(modelEClass, MODEL__RANDOM_TESTS);

    fsmDefinitionEClass = createEClass(FSM_DEFINITION);
    createEAttribute(fsmDefinitionEClass, FSM_DEFINITION__NAME);
    createEReference(fsmDefinitionEClass, FSM_DEFINITION__STATES);

    randomTestEClass = createEClass(RANDOM_TEST);
    createEAttribute(randomTestEClass, RANDOM_TEST__NAME);
    createEReference(randomTestEClass, RANDOM_TEST__FSM);
    createEReference(randomTestEClass, RANDOM_TEST__LOOPS_DECLARATION);
    createEReference(randomTestEClass, RANDOM_TEST__SEED_DECLARATION);

    guardDeclarationEClass = createEClass(GUARD_DECLARATION);
    createEReference(guardDeclarationEClass, GUARD_DECLARATION__SIGNAL);

    transitionDeclarationEClass = createEClass(TRANSITION_DECLARATION);
    createEAttribute(transitionDeclarationEClass, TRANSITION_DECLARATION__NAME);
    createEReference(transitionDeclarationEClass, TRANSITION_DECLARATION__DESTINATION);
    createEReference(transitionDeclarationEClass, TRANSITION_DECLARATION__TRIGGER);
    createEReference(transitionDeclarationEClass, TRANSITION_DECLARATION__TRIGGERS);
    createEReference(transitionDeclarationEClass, TRANSITION_DECLARATION__PRECONDITION);
    createEReference(transitionDeclarationEClass, TRANSITION_DECLARATION__POSTCONDITION);

    conditionDeclarationEClass = createEClass(CONDITION_DECLARATION);
    createEReference(conditionDeclarationEClass, CONDITION_DECLARATION__SIGNAL);

    preconditionDeclarationEClass = createEClass(PRECONDITION_DECLARATION);
    createEReference(preconditionDeclarationEClass, PRECONDITION_DECLARATION__SIGNAL);

    postconditionDeclarationEClass = createEClass(POSTCONDITION_DECLARATION);
    createEReference(postconditionDeclarationEClass, POSTCONDITION_DECLARATION__SIGNAL);

    stateDeclarationEClass = createEClass(STATE_DECLARATION);
    createEAttribute(stateDeclarationEClass, STATE_DECLARATION__NAME);
    createEReference(stateDeclarationEClass, STATE_DECLARATION__CONDITION);
    createEReference(stateDeclarationEClass, STATE_DECLARATION__TRANSITIONS);

    loopsDeclarationEClass = createEClass(LOOPS_DECLARATION);
    createEAttribute(loopsDeclarationEClass, LOOPS_DECLARATION__VAL);

    seedDeclarationEClass = createEClass(SEED_DECLARATION);
    createEAttribute(seedDeclarationEClass, SEED_DECLARATION__VAL);

    signalDeclarationEClass = createEClass(SIGNAL_DECLARATION);
    createEAttribute(signalDeclarationEClass, SIGNAL_DECLARATION__PORT);
    createEAttribute(signalDeclarationEClass, SIGNAL_DECLARATION__SIGNAME);
    createEAttribute(signalDeclarationEClass, SIGNAL_DECLARATION__INT_VAL);
    createEAttribute(signalDeclarationEClass, SIGNAL_DECLARATION__STR_VAL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_FsmDefinitions(), this.getFsmDefinition(), null, "FsmDefinitions", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_RandomTests(), this.getRandomTest(), null, "RandomTests", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fsmDefinitionEClass, FsmDefinition.class, "FsmDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFsmDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, FsmDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFsmDefinition_States(), this.getStateDeclaration(), null, "states", null, 0, -1, FsmDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(randomTestEClass, RandomTest.class, "RandomTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRandomTest_Name(), ecorePackage.getEString(), "name", null, 0, 1, RandomTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRandomTest_Fsm(), this.getFsmDefinition(), null, "fsm", null, 0, 1, RandomTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRandomTest_LoopsDeclaration(), this.getLoopsDeclaration(), null, "loopsDeclaration", null, 0, 1, RandomTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRandomTest_SeedDeclaration(), this.getSeedDeclaration(), null, "seedDeclaration", null, 0, 1, RandomTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(guardDeclarationEClass, GuardDeclaration.class, "GuardDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGuardDeclaration_Signal(), this.getSignalDeclaration(), null, "signal", null, 0, 1, GuardDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionDeclarationEClass, TransitionDeclaration.class, "TransitionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransitionDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionDeclaration_Destination(), this.getStateDeclaration(), null, "destination", null, 0, 1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionDeclaration_Trigger(), this.getSignalDeclaration(), null, "trigger", null, 0, 1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionDeclaration_Triggers(), this.getGuardDeclaration(), null, "triggers", null, 0, -1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionDeclaration_Precondition(), this.getPreconditionDeclaration(), null, "precondition", null, 0, -1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionDeclaration_Postcondition(), this.getPostconditionDeclaration(), null, "postcondition", null, 0, -1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionDeclarationEClass, ConditionDeclaration.class, "ConditionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionDeclaration_Signal(), this.getSignalDeclaration(), null, "signal", null, 0, 1, ConditionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(preconditionDeclarationEClass, PreconditionDeclaration.class, "PreconditionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPreconditionDeclaration_Signal(), this.getSignalDeclaration(), null, "signal", null, 0, 1, PreconditionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postconditionDeclarationEClass, PostconditionDeclaration.class, "PostconditionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPostconditionDeclaration_Signal(), this.getSignalDeclaration(), null, "signal", null, 0, 1, PostconditionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateDeclarationEClass, StateDeclaration.class, "StateDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStateDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, StateDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateDeclaration_Condition(), this.getConditionDeclaration(), null, "condition", null, 0, -1, StateDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateDeclaration_Transitions(), this.getTransitionDeclaration(), null, "transitions", null, 0, -1, StateDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loopsDeclarationEClass, LoopsDeclaration.class, "LoopsDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoopsDeclaration_Val(), ecorePackage.getEInt(), "val", null, 0, 1, LoopsDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(seedDeclarationEClass, SeedDeclaration.class, "SeedDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSeedDeclaration_Val(), ecorePackage.getEInt(), "val", null, 0, 1, SeedDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(signalDeclarationEClass, SignalDeclaration.class, "SignalDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSignalDeclaration_Port(), ecorePackage.getEString(), "port", null, 0, 1, SignalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSignalDeclaration_Signame(), ecorePackage.getEString(), "signame", null, 0, 1, SignalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSignalDeclaration_IntVal(), ecorePackage.getEInt(), "intVal", null, 0, 1, SignalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSignalDeclaration_StrVal(), ecorePackage.getEString(), "strVal", null, 0, 1, SignalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //FsmtestPackageImpl
