/**
 */
package org.eclipse.etrice.core.fsm.fSM.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.fsm.fSM.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage
 * @generated
 */
public class FSMAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FSMPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FSMAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = FSMPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FSMSwitch<Adapter> modelSwitch =
    new FSMSwitch<Adapter>()
    {
      @Override
      public Adapter caseFSMModel(FSMModel object)
      {
        return createFSMModelAdapter();
      }
      @Override
      public Adapter caseModelComponent(ModelComponent object)
      {
        return createModelComponentAdapter();
      }
      @Override
      public Adapter caseStateGraphNode(StateGraphNode object)
      {
        return createStateGraphNodeAdapter();
      }
      @Override
      public Adapter caseStateGraphItem(StateGraphItem object)
      {
        return createStateGraphItemAdapter();
      }
      @Override
      public Adapter caseStateGraph(StateGraph object)
      {
        return createStateGraphAdapter();
      }
      @Override
      public Adapter caseState(State object)
      {
        return createStateAdapter();
      }
      @Override
      public Adapter caseSimpleState(SimpleState object)
      {
        return createSimpleStateAdapter();
      }
      @Override
      public Adapter caseRefinedState(RefinedState object)
      {
        return createRefinedStateAdapter();
      }
      @Override
      public Adapter caseDetailCode(DetailCode object)
      {
        return createDetailCodeAdapter();
      }
      @Override
      public Adapter caseTrPoint(TrPoint object)
      {
        return createTrPointAdapter();
      }
      @Override
      public Adapter caseTransitionPoint(TransitionPoint object)
      {
        return createTransitionPointAdapter();
      }
      @Override
      public Adapter caseEntryPoint(EntryPoint object)
      {
        return createEntryPointAdapter();
      }
      @Override
      public Adapter caseExitPoint(ExitPoint object)
      {
        return createExitPointAdapter();
      }
      @Override
      public Adapter caseChoicePoint(ChoicePoint object)
      {
        return createChoicePointAdapter();
      }
      @Override
      public Adapter caseTransition(Transition object)
      {
        return createTransitionAdapter();
      }
      @Override
      public Adapter caseNonInitialTransition(NonInitialTransition object)
      {
        return createNonInitialTransitionAdapter();
      }
      @Override
      public Adapter caseTransitionChainStartTransition(TransitionChainStartTransition object)
      {
        return createTransitionChainStartTransitionAdapter();
      }
      @Override
      public Adapter caseInitialTransition(InitialTransition object)
      {
        return createInitialTransitionAdapter();
      }
      @Override
      public Adapter caseContinuationTransition(ContinuationTransition object)
      {
        return createContinuationTransitionAdapter();
      }
      @Override
      public Adapter caseTriggeredTransition(TriggeredTransition object)
      {
        return createTriggeredTransitionAdapter();
      }
      @Override
      public Adapter caseGuardedTransition(GuardedTransition object)
      {
        return createGuardedTransitionAdapter();
      }
      @Override
      public Adapter caseCPBranchTransition(CPBranchTransition object)
      {
        return createCPBranchTransitionAdapter();
      }
      @Override
      public Adapter caseRefinedTransition(RefinedTransition object)
      {
        return createRefinedTransitionAdapter();
      }
      @Override
      public Adapter caseTransitionTerminal(TransitionTerminal object)
      {
        return createTransitionTerminalAdapter();
      }
      @Override
      public Adapter caseStateTerminal(StateTerminal object)
      {
        return createStateTerminalAdapter();
      }
      @Override
      public Adapter caseTrPointTerminal(TrPointTerminal object)
      {
        return createTrPointTerminalAdapter();
      }
      @Override
      public Adapter caseSubStateTrPointTerminal(SubStateTrPointTerminal object)
      {
        return createSubStateTrPointTerminalAdapter();
      }
      @Override
      public Adapter caseChoicepointTerminal(ChoicepointTerminal object)
      {
        return createChoicepointTerminalAdapter();
      }
      @Override
      public Adapter caseTrigger(Trigger object)
      {
        return createTriggerAdapter();
      }
      @Override
      public Adapter caseMessageFromIf(MessageFromIf object)
      {
        return createMessageFromIfAdapter();
      }
      @Override
      public Adapter caseAbstractMessage(AbstractMessage object)
      {
        return createAbstractMessageAdapter();
      }
      @Override
      public Adapter caseAbstractInterfaceItem(AbstractInterfaceItem object)
      {
        return createAbstractInterfaceItemAdapter();
      }
      @Override
      public Adapter caseGuard(Guard object)
      {
        return createGuardAdapter();
      }
      @Override
      public Adapter caseProtocolSemantics(ProtocolSemantics object)
      {
        return createProtocolSemanticsAdapter();
      }
      @Override
      public Adapter caseSemanticsRule(SemanticsRule object)
      {
        return createSemanticsRuleAdapter();
      }
      @Override
      public Adapter caseInSemanticsRule(InSemanticsRule object)
      {
        return createInSemanticsRuleAdapter();
      }
      @Override
      public Adapter caseOutSemanticsRule(OutSemanticsRule object)
      {
        return createOutSemanticsRuleAdapter();
      }
      @Override
      public Adapter caseIInterfaceItemOwner(IInterfaceItemOwner object)
      {
        return createIInterfaceItemOwnerAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.FSMModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.FSMModel
   * @generated
   */
  public Adapter createFSMModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent <em>Model Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.ModelComponent
   * @generated
   */
  public Adapter createModelComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.StateGraphNode <em>State Graph Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraphNode
   * @generated
   */
  public Adapter createStateGraphNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.StateGraphItem <em>State Graph Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraphItem
   * @generated
   */
  public Adapter createStateGraphItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.StateGraph <em>State Graph</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraph
   * @generated
   */
  public Adapter createStateGraphAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.State
   * @generated
   */
  public Adapter createStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.SimpleState <em>Simple State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.SimpleState
   * @generated
   */
  public Adapter createSimpleStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.RefinedState <em>Refined State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.RefinedState
   * @generated
   */
  public Adapter createRefinedStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.DetailCode <em>Detail Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.DetailCode
   * @generated
   */
  public Adapter createDetailCodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.TrPoint <em>Tr Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.TrPoint
   * @generated
   */
  public Adapter createTrPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.TransitionPoint <em>Transition Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.TransitionPoint
   * @generated
   */
  public Adapter createTransitionPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.EntryPoint <em>Entry Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.EntryPoint
   * @generated
   */
  public Adapter createEntryPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.ExitPoint <em>Exit Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.ExitPoint
   * @generated
   */
  public Adapter createExitPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.ChoicePoint <em>Choice Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.ChoicePoint
   * @generated
   */
  public Adapter createChoicePointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.Transition
   * @generated
   */
  public Adapter createTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.NonInitialTransition <em>Non Initial Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.NonInitialTransition
   * @generated
   */
  public Adapter createNonInitialTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.TransitionChainStartTransition <em>Transition Chain Start Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.TransitionChainStartTransition
   * @generated
   */
  public Adapter createTransitionChainStartTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.InitialTransition <em>Initial Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.InitialTransition
   * @generated
   */
  public Adapter createInitialTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.ContinuationTransition <em>Continuation Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.ContinuationTransition
   * @generated
   */
  public Adapter createContinuationTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.TriggeredTransition <em>Triggered Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
   * @generated
   */
  public Adapter createTriggeredTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.GuardedTransition <em>Guarded Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.GuardedTransition
   * @generated
   */
  public Adapter createGuardedTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.CPBranchTransition <em>CP Branch Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.CPBranchTransition
   * @generated
   */
  public Adapter createCPBranchTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.RefinedTransition <em>Refined Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.RefinedTransition
   * @generated
   */
  public Adapter createRefinedTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.TransitionTerminal <em>Transition Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.TransitionTerminal
   * @generated
   */
  public Adapter createTransitionTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.StateTerminal <em>State Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.StateTerminal
   * @generated
   */
  public Adapter createStateTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.TrPointTerminal <em>Tr Point Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.TrPointTerminal
   * @generated
   */
  public Adapter createTrPointTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal <em>Sub State Tr Point Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal
   * @generated
   */
  public Adapter createSubStateTrPointTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal <em>Choicepoint Terminal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal
   * @generated
   */
  public Adapter createChoicepointTerminalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.Trigger
   * @generated
   */
  public Adapter createTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.MessageFromIf <em>Message From If</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.MessageFromIf
   * @generated
   */
  public Adapter createMessageFromIfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.AbstractMessage <em>Abstract Message</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.AbstractMessage
   * @generated
   */
  public Adapter createAbstractMessageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem <em>Abstract Interface Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem
   * @generated
   */
  public Adapter createAbstractInterfaceItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.Guard
   * @generated
   */
  public Adapter createGuardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics <em>Protocol Semantics</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics
   * @generated
   */
  public Adapter createProtocolSemanticsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.SemanticsRule <em>Semantics Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.SemanticsRule
   * @generated
   */
  public Adapter createSemanticsRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.InSemanticsRule <em>In Semantics Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.InSemanticsRule
   * @generated
   */
  public Adapter createInSemanticsRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.OutSemanticsRule <em>Out Semantics Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.OutSemanticsRule
   * @generated
   */
  public Adapter createOutSemanticsRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner <em>IInterface Item Owner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner
   * @generated
   */
  public Adapter createIInterfaceItemOwnerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //FSMAdapterFactory
