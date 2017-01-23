/**
 */
package org.eclipse.etrice.core.fsm.fSM.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.etrice.core.common.base.BasePackage;

import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.ExitPoint;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.FSMModel;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.Guard;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner;
import org.eclipse.etrice.core.fsm.fSM.InSemanticsRule;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.OutSemanticsRule;
import org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.SemanticsRule;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.fsm.fSM.TransitionChainStartTransition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FSMPackageImpl extends EPackageImpl implements FSMPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fsmModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelComponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateGraphNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateGraphItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateGraphEClass = null;

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
  private EClass simpleStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refinedStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass detailCodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entryPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exitPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choicePointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionBaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonInitialTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionChainStartTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initialTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass continuationTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass triggeredTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardedTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cpBranchTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refinedTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trPointTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subStateTrPointTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choicepointTerminalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass triggerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messageFromIfEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractInterfaceItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass protocolSemanticsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass semanticsRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inSemanticsRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outSemanticsRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iInterfaceItemOwnerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum componentCommunicationTypeEEnum = null;

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
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private FSMPackageImpl()
  {
    super(eNS_URI, FSMFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link FSMPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static FSMPackage init()
  {
    if (isInited) return (FSMPackage)EPackage.Registry.INSTANCE.getEPackage(FSMPackage.eNS_URI);

    // Obtain or create and register package
    FSMPackageImpl theFSMPackage = (FSMPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FSMPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FSMPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    BasePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theFSMPackage.createPackageContents();

    // Initialize created meta-data
    theFSMPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFSMPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(FSMPackage.eNS_URI, theFSMPackage);
    return theFSMPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFSMModel()
  {
    return fsmModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFSMModel_Components()
  {
    return (EReference)fsmModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelComponent()
  {
    return modelComponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelComponent_Abstract()
  {
    return (EAttribute)modelComponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelComponent_CommType()
  {
    return (EAttribute)modelComponentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelComponent_ComponentName()
  {
    return (EAttribute)modelComponentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelComponent_Base()
  {
    return (EReference)modelComponentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModelComponent_StateMachine()
  {
    return (EReference)modelComponentEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateGraphNode()
  {
    return stateGraphNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateGraphItem()
  {
    return stateGraphItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateGraph()
  {
    return stateGraphEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateGraph_States()
  {
    return (EReference)stateGraphEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateGraph_TrPoints()
  {
    return (EReference)stateGraphEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateGraph_ChPoints()
  {
    return (EReference)stateGraphEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateGraph_Transitions()
  {
    return (EReference)stateGraphEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateGraph_RefinedTransitions()
  {
    return (EReference)stateGraphEClass.getEStructuralFeatures().get(4);
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
  public EReference getState_Docu()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_EntryCode()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_ExitCode()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_DoCode()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_Subgraph()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleState()
  {
    return simpleStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleState_Name()
  {
    return (EAttribute)simpleStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefinedState()
  {
    return refinedStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefinedState_Target()
  {
    return (EReference)refinedStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDetailCode()
  {
    return detailCodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDetailCode_Used()
  {
    return (EAttribute)detailCodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDetailCode_Lines()
  {
    return (EAttribute)detailCodeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrPoint()
  {
    return trPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTrPoint_Name()
  {
    return (EAttribute)trPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionPoint()
  {
    return transitionPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionPoint_Handler()
  {
    return (EAttribute)transitionPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntryPoint()
  {
    return entryPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExitPoint()
  {
    return exitPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoicePoint()
  {
    return choicePointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChoicePoint_Name()
  {
    return (EAttribute)choicePointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChoicePoint_Docu()
  {
    return (EReference)choicePointEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionBase()
  {
    return transitionBaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionBase_Docu()
  {
    return (EReference)transitionBaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionBase_Action()
  {
    return (EReference)transitionBaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransition()
  {
    return transitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransition_Name()
  {
    return (EAttribute)transitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition_To()
  {
    return (EReference)transitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonInitialTransition()
  {
    return nonInitialTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonInitialTransition_From()
  {
    return (EReference)nonInitialTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionChainStartTransition()
  {
    return transitionChainStartTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitialTransition()
  {
    return initialTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContinuationTransition()
  {
    return continuationTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTriggeredTransition()
  {
    return triggeredTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTriggeredTransition_Triggers()
  {
    return (EReference)triggeredTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuardedTransition()
  {
    return guardedTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGuardedTransition_Guard()
  {
    return (EReference)guardedTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCPBranchTransition()
  {
    return cpBranchTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCPBranchTransition_Condition()
  {
    return (EReference)cpBranchTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefinedTransition()
  {
    return refinedTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefinedTransition_Target()
  {
    return (EReference)refinedTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionTerminal()
  {
    return transitionTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateTerminal()
  {
    return stateTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateTerminal_State()
  {
    return (EReference)stateTerminalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrPointTerminal()
  {
    return trPointTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrPointTerminal_TrPoint()
  {
    return (EReference)trPointTerminalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubStateTrPointTerminal()
  {
    return subStateTrPointTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubStateTrPointTerminal_TrPoint()
  {
    return (EReference)subStateTrPointTerminalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubStateTrPointTerminal_State()
  {
    return (EReference)subStateTrPointTerminalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoicepointTerminal()
  {
    return choicepointTerminalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChoicepointTerminal_Cp()
  {
    return (EReference)choicepointTerminalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrigger()
  {
    return triggerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrigger_MsgFromIfPairs()
  {
    return (EReference)triggerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrigger_Guard()
  {
    return (EReference)triggerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessageFromIf()
  {
    return messageFromIfEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageFromIf_Message()
  {
    return (EReference)messageFromIfEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageFromIf_From()
  {
    return (EReference)messageFromIfEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractInterfaceItem()
  {
    return abstractInterfaceItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractInterfaceItem_Name()
  {
    return (EAttribute)abstractInterfaceItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuard()
  {
    return guardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGuard_Guard()
  {
    return (EReference)guardEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProtocolSemantics()
  {
    return protocolSemanticsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolSemantics_Rules()
  {
    return (EReference)protocolSemanticsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSemanticsRule()
  {
    return semanticsRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSemanticsRule_Msg()
  {
    return (EReference)semanticsRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSemanticsRule_FollowUps()
  {
    return (EReference)semanticsRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInSemanticsRule()
  {
    return inSemanticsRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutSemanticsRule()
  {
    return outSemanticsRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIInterfaceItemOwner()
  {
    return iInterfaceItemOwnerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getComponentCommunicationType()
  {
    return componentCommunicationTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FSMFactory getFSMFactory()
  {
    return (FSMFactory)getEFactoryInstance();
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
    fsmModelEClass = createEClass(FSM_MODEL);
    createEReference(fsmModelEClass, FSM_MODEL__COMPONENTS);

    modelComponentEClass = createEClass(MODEL_COMPONENT);
    createEAttribute(modelComponentEClass, MODEL_COMPONENT__ABSTRACT);
    createEAttribute(modelComponentEClass, MODEL_COMPONENT__COMM_TYPE);
    createEAttribute(modelComponentEClass, MODEL_COMPONENT__COMPONENT_NAME);
    createEReference(modelComponentEClass, MODEL_COMPONENT__BASE);
    createEReference(modelComponentEClass, MODEL_COMPONENT__STATE_MACHINE);

    stateGraphNodeEClass = createEClass(STATE_GRAPH_NODE);

    stateGraphItemEClass = createEClass(STATE_GRAPH_ITEM);

    stateGraphEClass = createEClass(STATE_GRAPH);
    createEReference(stateGraphEClass, STATE_GRAPH__STATES);
    createEReference(stateGraphEClass, STATE_GRAPH__TR_POINTS);
    createEReference(stateGraphEClass, STATE_GRAPH__CH_POINTS);
    createEReference(stateGraphEClass, STATE_GRAPH__TRANSITIONS);
    createEReference(stateGraphEClass, STATE_GRAPH__REFINED_TRANSITIONS);

    stateEClass = createEClass(STATE);
    createEReference(stateEClass, STATE__DOCU);
    createEReference(stateEClass, STATE__ENTRY_CODE);
    createEReference(stateEClass, STATE__EXIT_CODE);
    createEReference(stateEClass, STATE__DO_CODE);
    createEReference(stateEClass, STATE__SUBGRAPH);

    simpleStateEClass = createEClass(SIMPLE_STATE);
    createEAttribute(simpleStateEClass, SIMPLE_STATE__NAME);

    refinedStateEClass = createEClass(REFINED_STATE);
    createEReference(refinedStateEClass, REFINED_STATE__TARGET);

    detailCodeEClass = createEClass(DETAIL_CODE);
    createEAttribute(detailCodeEClass, DETAIL_CODE__USED);
    createEAttribute(detailCodeEClass, DETAIL_CODE__LINES);

    trPointEClass = createEClass(TR_POINT);
    createEAttribute(trPointEClass, TR_POINT__NAME);

    transitionPointEClass = createEClass(TRANSITION_POINT);
    createEAttribute(transitionPointEClass, TRANSITION_POINT__HANDLER);

    entryPointEClass = createEClass(ENTRY_POINT);

    exitPointEClass = createEClass(EXIT_POINT);

    choicePointEClass = createEClass(CHOICE_POINT);
    createEAttribute(choicePointEClass, CHOICE_POINT__NAME);
    createEReference(choicePointEClass, CHOICE_POINT__DOCU);

    transitionBaseEClass = createEClass(TRANSITION_BASE);
    createEReference(transitionBaseEClass, TRANSITION_BASE__DOCU);
    createEReference(transitionBaseEClass, TRANSITION_BASE__ACTION);

    transitionEClass = createEClass(TRANSITION);
    createEAttribute(transitionEClass, TRANSITION__NAME);
    createEReference(transitionEClass, TRANSITION__TO);

    nonInitialTransitionEClass = createEClass(NON_INITIAL_TRANSITION);
    createEReference(nonInitialTransitionEClass, NON_INITIAL_TRANSITION__FROM);

    transitionChainStartTransitionEClass = createEClass(TRANSITION_CHAIN_START_TRANSITION);

    initialTransitionEClass = createEClass(INITIAL_TRANSITION);

    continuationTransitionEClass = createEClass(CONTINUATION_TRANSITION);

    triggeredTransitionEClass = createEClass(TRIGGERED_TRANSITION);
    createEReference(triggeredTransitionEClass, TRIGGERED_TRANSITION__TRIGGERS);

    guardedTransitionEClass = createEClass(GUARDED_TRANSITION);
    createEReference(guardedTransitionEClass, GUARDED_TRANSITION__GUARD);

    cpBranchTransitionEClass = createEClass(CP_BRANCH_TRANSITION);
    createEReference(cpBranchTransitionEClass, CP_BRANCH_TRANSITION__CONDITION);

    refinedTransitionEClass = createEClass(REFINED_TRANSITION);
    createEReference(refinedTransitionEClass, REFINED_TRANSITION__TARGET);

    transitionTerminalEClass = createEClass(TRANSITION_TERMINAL);

    stateTerminalEClass = createEClass(STATE_TERMINAL);
    createEReference(stateTerminalEClass, STATE_TERMINAL__STATE);

    trPointTerminalEClass = createEClass(TR_POINT_TERMINAL);
    createEReference(trPointTerminalEClass, TR_POINT_TERMINAL__TR_POINT);

    subStateTrPointTerminalEClass = createEClass(SUB_STATE_TR_POINT_TERMINAL);
    createEReference(subStateTrPointTerminalEClass, SUB_STATE_TR_POINT_TERMINAL__TR_POINT);
    createEReference(subStateTrPointTerminalEClass, SUB_STATE_TR_POINT_TERMINAL__STATE);

    choicepointTerminalEClass = createEClass(CHOICEPOINT_TERMINAL);
    createEReference(choicepointTerminalEClass, CHOICEPOINT_TERMINAL__CP);

    triggerEClass = createEClass(TRIGGER);
    createEReference(triggerEClass, TRIGGER__MSG_FROM_IF_PAIRS);
    createEReference(triggerEClass, TRIGGER__GUARD);

    messageFromIfEClass = createEClass(MESSAGE_FROM_IF);
    createEReference(messageFromIfEClass, MESSAGE_FROM_IF__MESSAGE);
    createEReference(messageFromIfEClass, MESSAGE_FROM_IF__FROM);

    abstractInterfaceItemEClass = createEClass(ABSTRACT_INTERFACE_ITEM);
    createEAttribute(abstractInterfaceItemEClass, ABSTRACT_INTERFACE_ITEM__NAME);

    guardEClass = createEClass(GUARD);
    createEReference(guardEClass, GUARD__GUARD);

    protocolSemanticsEClass = createEClass(PROTOCOL_SEMANTICS);
    createEReference(protocolSemanticsEClass, PROTOCOL_SEMANTICS__RULES);

    semanticsRuleEClass = createEClass(SEMANTICS_RULE);
    createEReference(semanticsRuleEClass, SEMANTICS_RULE__MSG);
    createEReference(semanticsRuleEClass, SEMANTICS_RULE__FOLLOW_UPS);

    inSemanticsRuleEClass = createEClass(IN_SEMANTICS_RULE);

    outSemanticsRuleEClass = createEClass(OUT_SEMANTICS_RULE);

    iInterfaceItemOwnerEClass = createEClass(IINTERFACE_ITEM_OWNER);

    // Create enums
    componentCommunicationTypeEEnum = createEEnum(COMPONENT_COMMUNICATION_TYPE);
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

    // Obtain other dependent packages
    BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    modelComponentEClass.getESuperTypes().add(this.getIInterfaceItemOwner());
    stateGraphNodeEClass.getESuperTypes().add(this.getStateGraphItem());
    stateEClass.getESuperTypes().add(this.getStateGraphNode());
    simpleStateEClass.getESuperTypes().add(this.getState());
    refinedStateEClass.getESuperTypes().add(this.getState());
    trPointEClass.getESuperTypes().add(this.getStateGraphNode());
    transitionPointEClass.getESuperTypes().add(this.getTrPoint());
    entryPointEClass.getESuperTypes().add(this.getTrPoint());
    exitPointEClass.getESuperTypes().add(this.getTrPoint());
    choicePointEClass.getESuperTypes().add(this.getStateGraphNode());
    transitionEClass.getESuperTypes().add(this.getStateGraphItem());
    transitionEClass.getESuperTypes().add(this.getTransitionBase());
    nonInitialTransitionEClass.getESuperTypes().add(this.getTransition());
    transitionChainStartTransitionEClass.getESuperTypes().add(this.getNonInitialTransition());
    initialTransitionEClass.getESuperTypes().add(this.getTransition());
    continuationTransitionEClass.getESuperTypes().add(this.getNonInitialTransition());
    triggeredTransitionEClass.getESuperTypes().add(this.getTransitionChainStartTransition());
    guardedTransitionEClass.getESuperTypes().add(this.getTransitionChainStartTransition());
    cpBranchTransitionEClass.getESuperTypes().add(this.getNonInitialTransition());
    refinedTransitionEClass.getESuperTypes().add(this.getTransitionBase());
    stateTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    trPointTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    subStateTrPointTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    choicepointTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    inSemanticsRuleEClass.getESuperTypes().add(this.getSemanticsRule());
    outSemanticsRuleEClass.getESuperTypes().add(this.getSemanticsRule());

    // Initialize classes and features; add operations and parameters
    initEClass(fsmModelEClass, FSMModel.class, "FSMModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFSMModel_Components(), this.getModelComponent(), null, "components", null, 0, -1, FSMModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modelComponentEClass, ModelComponent.class, "ModelComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelComponent_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, ModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelComponent_CommType(), this.getComponentCommunicationType(), "commType", null, 0, 1, ModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModelComponent_ComponentName(), ecorePackage.getEString(), "componentName", null, 0, 1, ModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelComponent_Base(), this.getModelComponent(), null, "base", null, 0, 1, ModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelComponent_StateMachine(), this.getStateGraph(), null, "stateMachine", null, 0, 1, ModelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateGraphNodeEClass, StateGraphNode.class, "StateGraphNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stateGraphItemEClass, StateGraphItem.class, "StateGraphItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    addEOperation(stateGraphItemEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(stateGraphEClass, StateGraph.class, "StateGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateGraph_States(), this.getState(), null, "states", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_TrPoints(), this.getTrPoint(), null, "trPoints", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_ChPoints(), this.getChoicePoint(), null, "chPoints", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_Transitions(), this.getTransition(), null, "transitions", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_RefinedTransitions(), this.getRefinedTransition(), null, "refinedTransitions", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getState_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_EntryCode(), this.getDetailCode(), null, "entryCode", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_ExitCode(), this.getDetailCode(), null, "exitCode", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_DoCode(), this.getDetailCode(), null, "doCode", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_Subgraph(), this.getStateGraph(), null, "subgraph", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(stateEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(simpleStateEClass, SimpleState.class, "SimpleState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleState_Name(), ecorePackage.getEString(), "name", null, 0, 1, SimpleState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refinedStateEClass, RefinedState.class, "RefinedState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefinedState_Target(), this.getState(), null, "target", null, 0, 1, RefinedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(detailCodeEClass, DetailCode.class, "DetailCode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDetailCode_Used(), ecorePackage.getEBoolean(), "used", null, 0, 1, DetailCode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDetailCode_Lines(), ecorePackage.getEString(), "lines", null, 0, -1, DetailCode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trPointEClass, TrPoint.class, "TrPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTrPoint_Name(), ecorePackage.getEString(), "name", null, 0, 1, TrPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionPointEClass, TransitionPoint.class, "TransitionPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransitionPoint_Handler(), ecorePackage.getEBoolean(), "handler", null, 0, 1, TransitionPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entryPointEClass, EntryPoint.class, "EntryPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exitPointEClass, ExitPoint.class, "ExitPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(choicePointEClass, ChoicePoint.class, "ChoicePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChoicePoint_Name(), ecorePackage.getEString(), "name", null, 0, 1, ChoicePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getChoicePoint_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, ChoicePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionBaseEClass, TransitionBase.class, "TransitionBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionBase_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, TransitionBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionBase_Action(), this.getDetailCode(), null, "action", null, 0, 1, TransitionBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_To(), this.getTransitionTerminal(), null, "to", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nonInitialTransitionEClass, NonInitialTransition.class, "NonInitialTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNonInitialTransition_From(), this.getTransitionTerminal(), null, "from", null, 0, 1, NonInitialTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionChainStartTransitionEClass, TransitionChainStartTransition.class, "TransitionChainStartTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(initialTransitionEClass, InitialTransition.class, "InitialTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(continuationTransitionEClass, ContinuationTransition.class, "ContinuationTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(triggeredTransitionEClass, TriggeredTransition.class, "TriggeredTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTriggeredTransition_Triggers(), this.getTrigger(), null, "triggers", null, 0, -1, TriggeredTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(guardedTransitionEClass, GuardedTransition.class, "GuardedTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGuardedTransition_Guard(), this.getDetailCode(), null, "guard", null, 0, 1, GuardedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cpBranchTransitionEClass, CPBranchTransition.class, "CPBranchTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCPBranchTransition_Condition(), this.getDetailCode(), null, "condition", null, 0, 1, CPBranchTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refinedTransitionEClass, RefinedTransition.class, "RefinedTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefinedTransition_Target(), this.getTransition(), null, "target", null, 0, 1, RefinedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionTerminalEClass, TransitionTerminal.class, "TransitionTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stateTerminalEClass, StateTerminal.class, "StateTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateTerminal_State(), this.getState(), null, "state", null, 0, 1, StateTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trPointTerminalEClass, TrPointTerminal.class, "TrPointTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrPointTerminal_TrPoint(), this.getTrPoint(), null, "trPoint", null, 0, 1, TrPointTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subStateTrPointTerminalEClass, SubStateTrPointTerminal.class, "SubStateTrPointTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubStateTrPointTerminal_TrPoint(), this.getTrPoint(), null, "trPoint", null, 0, 1, SubStateTrPointTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubStateTrPointTerminal_State(), this.getState(), null, "state", null, 0, 1, SubStateTrPointTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choicepointTerminalEClass, ChoicepointTerminal.class, "ChoicepointTerminal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChoicepointTerminal_Cp(), this.getChoicePoint(), null, "cp", null, 0, 1, ChoicepointTerminal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(triggerEClass, Trigger.class, "Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrigger_MsgFromIfPairs(), this.getMessageFromIf(), null, "msgFromIfPairs", null, 0, -1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTrigger_Guard(), this.getGuard(), null, "guard", null, 0, 1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageFromIfEClass, MessageFromIf.class, "MessageFromIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMessageFromIf_Message(), ecorePackage.getEObject(), null, "message", null, 0, 1, MessageFromIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessageFromIf_From(), this.getAbstractInterfaceItem(), null, "from", null, 0, 1, MessageFromIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractInterfaceItemEClass, AbstractInterfaceItem.class, "AbstractInterfaceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractInterfaceItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractInterfaceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(abstractInterfaceItemEClass, ecorePackage.getEString(), "getDisplayName", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(abstractInterfaceItemEClass, this.getProtocolSemantics(), "getSemantics", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(abstractInterfaceItemEClass, ecorePackage.getEObject(), "getAllIncomingAbstractMessages", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(abstractInterfaceItemEClass, ecorePackage.getEObject(), "getAllOutgoingAbstractMessages", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(abstractInterfaceItemEClass, ecorePackage.getEBoolean(), "isEventDriven", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGuard_Guard(), this.getDetailCode(), null, "guard", null, 0, 1, Guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(protocolSemanticsEClass, ProtocolSemantics.class, "ProtocolSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProtocolSemantics_Rules(), this.getSemanticsRule(), null, "rules", null, 0, -1, ProtocolSemantics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(semanticsRuleEClass, SemanticsRule.class, "SemanticsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSemanticsRule_Msg(), ecorePackage.getEObject(), null, "msg", null, 0, 1, SemanticsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSemanticsRule_FollowUps(), this.getSemanticsRule(), null, "followUps", null, 0, -1, SemanticsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inSemanticsRuleEClass, InSemanticsRule.class, "InSemanticsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(outSemanticsRuleEClass, OutSemanticsRule.class, "OutSemanticsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(iInterfaceItemOwnerEClass, IInterfaceItemOwner.class, "IInterfaceItemOwner", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    addEOperation(iInterfaceItemOwnerEClass, this.getAbstractInterfaceItem(), "getAbstractInterfaceItems", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(iInterfaceItemOwnerEClass, this.getAbstractInterfaceItem(), "getAllAbstractInterfaceItems", 0, -1, IS_UNIQUE, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(componentCommunicationTypeEEnum, ComponentCommunicationType.class, "ComponentCommunicationType");
    addEEnumLiteral(componentCommunicationTypeEEnum, ComponentCommunicationType.EVENT_DRIVEN);
    addEEnumLiteral(componentCommunicationTypeEEnum, ComponentCommunicationType.DATA_DRIVEN);
    addEEnumLiteral(componentCommunicationTypeEEnum, ComponentCommunicationType.ASYNCHRONOUS);
    addEEnumLiteral(componentCommunicationTypeEEnum, ComponentCommunicationType.SYNCHRONOUS);

    // Create resource
    createResource(eNS_URI);
  }

} //FSMPackageImpl
