/**
 */
package org.eclipse.etrice.generator.fsmtest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.etrice.generator.fsmtest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FsmtestFactoryImpl extends EFactoryImpl implements FsmtestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FsmtestFactory init()
  {
    try
    {
      FsmtestFactory theFsmtestFactory = (FsmtestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/etrice/generator/FSMtest"); 
      if (theFsmtestFactory != null)
      {
        return theFsmtestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FsmtestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FsmtestFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case FsmtestPackage.MODEL: return createModel();
      case FsmtestPackage.TESTSCRIPT: return createTestscript();
      case FsmtestPackage.STATE: return createState();
      case FsmtestPackage.STATE_DECLARATION: return createStateDeclaration();
      case FsmtestPackage.INITIAL_DECLARATION: return createInitialDeclaration();
      case FsmtestPackage.LOOPS_DECLARATION: return createLoopsDeclaration();
      case FsmtestPackage.SEED_DECLARATION: return createSeedDeclaration();
      case FsmtestPackage.SIGNAL_DECLARATION: return createSignalDeclaration();
      case FsmtestPackage.SOURCE_DECLARATION: return createSourceDeclaration();
      case FsmtestPackage.DESTINATION_DECLARATION: return createDestinationDeclaration();
      case FsmtestPackage.TRANSITION_DECLARATION: return createTransitionDeclaration();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Testscript createTestscript()
  {
    TestscriptImpl testscript = new TestscriptImpl();
    return testscript;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateDeclaration createStateDeclaration()
  {
    StateDeclarationImpl stateDeclaration = new StateDeclarationImpl();
    return stateDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitialDeclaration createInitialDeclaration()
  {
    InitialDeclarationImpl initialDeclaration = new InitialDeclarationImpl();
    return initialDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopsDeclaration createLoopsDeclaration()
  {
    LoopsDeclarationImpl loopsDeclaration = new LoopsDeclarationImpl();
    return loopsDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SeedDeclaration createSeedDeclaration()
  {
    SeedDeclarationImpl seedDeclaration = new SeedDeclarationImpl();
    return seedDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalDeclaration createSignalDeclaration()
  {
    SignalDeclarationImpl signalDeclaration = new SignalDeclarationImpl();
    return signalDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SourceDeclaration createSourceDeclaration()
  {
    SourceDeclarationImpl sourceDeclaration = new SourceDeclarationImpl();
    return sourceDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DestinationDeclaration createDestinationDeclaration()
  {
    DestinationDeclarationImpl destinationDeclaration = new DestinationDeclarationImpl();
    return destinationDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionDeclaration createTransitionDeclaration()
  {
    TransitionDeclarationImpl transitionDeclaration = new TransitionDeclarationImpl();
    return transitionDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FsmtestPackage getFsmtestPackage()
  {
    return (FsmtestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FsmtestPackage getPackage()
  {
    return FsmtestPackage.eINSTANCE;
  }

} //FsmtestFactoryImpl
