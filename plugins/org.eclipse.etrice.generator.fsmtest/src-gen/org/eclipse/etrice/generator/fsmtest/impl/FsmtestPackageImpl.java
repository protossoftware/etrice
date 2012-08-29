/**
 */
package org.eclipse.etrice.generator.fsmtest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.etrice.generator.fsmtest.DestinationDeclaration;
import org.eclipse.etrice.generator.fsmtest.FsmtestFactory;
import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.InitialDeclaration;
import org.eclipse.etrice.generator.fsmtest.LoopsDeclaration;
import org.eclipse.etrice.generator.fsmtest.Model;
import org.eclipse.etrice.generator.fsmtest.SeedDeclaration;
import org.eclipse.etrice.generator.fsmtest.SignalDeclaration;
import org.eclipse.etrice.generator.fsmtest.SourceDeclaration;
import org.eclipse.etrice.generator.fsmtest.State;
import org.eclipse.etrice.generator.fsmtest.StateDeclaration;
import org.eclipse.etrice.generator.fsmtest.Testscript;
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
  private EClass testscriptEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateEClass = null;

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
  private EClass initialDeclarationEClass = null;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sourceDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass destinationDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionDeclarationEClass = null;

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
  public EReference getModel_Testscripts()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTestscript()
  {
    return testscriptEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestscript_Name()
  {
    return (EAttribute)testscriptEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestscript_StateDeclaration()
  {
    return (EReference)testscriptEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestscript_InitialDeclaration()
  {
    return (EReference)testscriptEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestscript_LoopsDeclaration()
  {
    return (EReference)testscriptEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestscript_SeedDeclaration()
  {
    return (EReference)testscriptEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestscript_TransitionDeclarations()
  {
    return (EReference)testscriptEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getState()
  {
    return stateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState_Name()
  {
    return (EAttribute)stateEClass.getEStructuralFeatures().get(0);
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
  public EReference getStateDeclaration_States()
  {
    return (EReference)stateDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitialDeclaration()
  {
    return initialDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitialDeclaration_Initial()
  {
    return (EReference)initialDeclarationEClass.getEStructuralFeatures().get(0);
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
  public EClass getSourceDeclaration()
  {
    return sourceDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSourceDeclaration_Ref()
  {
    return (EReference)sourceDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDestinationDeclaration()
  {
    return destinationDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDestinationDeclaration_Ref()
  {
    return (EReference)destinationDeclarationEClass.getEStructuralFeatures().get(0);
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
  public EReference getTransitionDeclaration_Source()
  {
    return (EReference)transitionDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionDeclaration_In()
  {
    return (EReference)transitionDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionDeclaration_Out()
  {
    return (EReference)transitionDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionDeclaration_Destination()
  {
    return (EReference)transitionDeclarationEClass.getEStructuralFeatures().get(3);
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
    createEReference(modelEClass, MODEL__TESTSCRIPTS);

    testscriptEClass = createEClass(TESTSCRIPT);
    createEAttribute(testscriptEClass, TESTSCRIPT__NAME);
    createEReference(testscriptEClass, TESTSCRIPT__STATE_DECLARATION);
    createEReference(testscriptEClass, TESTSCRIPT__INITIAL_DECLARATION);
    createEReference(testscriptEClass, TESTSCRIPT__LOOPS_DECLARATION);
    createEReference(testscriptEClass, TESTSCRIPT__SEED_DECLARATION);
    createEReference(testscriptEClass, TESTSCRIPT__TRANSITION_DECLARATIONS);

    stateEClass = createEClass(STATE);
    createEAttribute(stateEClass, STATE__NAME);

    stateDeclarationEClass = createEClass(STATE_DECLARATION);
    createEReference(stateDeclarationEClass, STATE_DECLARATION__STATES);

    initialDeclarationEClass = createEClass(INITIAL_DECLARATION);
    createEReference(initialDeclarationEClass, INITIAL_DECLARATION__INITIAL);

    loopsDeclarationEClass = createEClass(LOOPS_DECLARATION);
    createEAttribute(loopsDeclarationEClass, LOOPS_DECLARATION__VAL);

    seedDeclarationEClass = createEClass(SEED_DECLARATION);
    createEAttribute(seedDeclarationEClass, SEED_DECLARATION__VAL);

    signalDeclarationEClass = createEClass(SIGNAL_DECLARATION);
    createEAttribute(signalDeclarationEClass, SIGNAL_DECLARATION__PORT);
    createEAttribute(signalDeclarationEClass, SIGNAL_DECLARATION__SIGNAME);
    createEAttribute(signalDeclarationEClass, SIGNAL_DECLARATION__INT_VAL);
    createEAttribute(signalDeclarationEClass, SIGNAL_DECLARATION__STR_VAL);

    sourceDeclarationEClass = createEClass(SOURCE_DECLARATION);
    createEReference(sourceDeclarationEClass, SOURCE_DECLARATION__REF);

    destinationDeclarationEClass = createEClass(DESTINATION_DECLARATION);
    createEReference(destinationDeclarationEClass, DESTINATION_DECLARATION__REF);

    transitionDeclarationEClass = createEClass(TRANSITION_DECLARATION);
    createEReference(transitionDeclarationEClass, TRANSITION_DECLARATION__SOURCE);
    createEReference(transitionDeclarationEClass, TRANSITION_DECLARATION__IN);
    createEReference(transitionDeclarationEClass, TRANSITION_DECLARATION__OUT);
    createEReference(transitionDeclarationEClass, TRANSITION_DECLARATION__DESTINATION);
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
    initEReference(getModel_Testscripts(), this.getTestscript(), null, "Testscripts", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(testscriptEClass, Testscript.class, "Testscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTestscript_Name(), ecorePackage.getEString(), "name", null, 0, 1, Testscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestscript_StateDeclaration(), this.getStateDeclaration(), null, "stateDeclaration", null, 0, 1, Testscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestscript_InitialDeclaration(), this.getInitialDeclaration(), null, "initialDeclaration", null, 0, 1, Testscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestscript_LoopsDeclaration(), this.getLoopsDeclaration(), null, "loopsDeclaration", null, 0, 1, Testscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestscript_SeedDeclaration(), this.getSeedDeclaration(), null, "seedDeclaration", null, 0, 1, Testscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestscript_TransitionDeclarations(), this.getTransitionDeclaration(), null, "transitionDeclarations", null, 0, -1, Testscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getState_Name(), ecorePackage.getEString(), "name", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateDeclarationEClass, StateDeclaration.class, "StateDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateDeclaration_States(), this.getState(), null, "states", null, 0, -1, StateDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initialDeclarationEClass, InitialDeclaration.class, "InitialDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInitialDeclaration_Initial(), this.getState(), null, "initial", null, 0, 1, InitialDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loopsDeclarationEClass, LoopsDeclaration.class, "LoopsDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoopsDeclaration_Val(), ecorePackage.getEInt(), "val", null, 0, 1, LoopsDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(seedDeclarationEClass, SeedDeclaration.class, "SeedDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSeedDeclaration_Val(), ecorePackage.getEInt(), "val", null, 0, 1, SeedDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(signalDeclarationEClass, SignalDeclaration.class, "SignalDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSignalDeclaration_Port(), ecorePackage.getEString(), "port", null, 0, 1, SignalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSignalDeclaration_Signame(), ecorePackage.getEString(), "signame", null, 0, 1, SignalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSignalDeclaration_IntVal(), ecorePackage.getEInt(), "intVal", null, 0, 1, SignalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSignalDeclaration_StrVal(), ecorePackage.getEString(), "strVal", null, 0, 1, SignalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sourceDeclarationEClass, SourceDeclaration.class, "SourceDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSourceDeclaration_Ref(), this.getState(), null, "ref", null, 0, 1, SourceDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(destinationDeclarationEClass, DestinationDeclaration.class, "DestinationDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDestinationDeclaration_Ref(), this.getState(), null, "ref", null, 0, 1, DestinationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionDeclarationEClass, TransitionDeclaration.class, "TransitionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionDeclaration_Source(), this.getSourceDeclaration(), null, "source", null, 0, 1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionDeclaration_In(), this.getSignalDeclaration(), null, "in", null, 0, -1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionDeclaration_Out(), this.getSignalDeclaration(), null, "out", null, 0, -1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionDeclaration_Destination(), this.getDestinationDeclaration(), null, "destination", null, 0, 1, TransitionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //FsmtestPackageImpl
