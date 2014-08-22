/**
 */
package org.eclipse.etrice.core.fsm.fSM.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.etrice.core.fsm.fSM.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage
 * @generated
 */
public class FSMSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FSMPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FSMSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = FSMPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case FSMPackage.FSM_MODEL:
      {
        FSMModel fsmModel = (FSMModel)theEObject;
        T result = caseFSMModel(fsmModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.MODEL_COMPONENT:
      {
        ModelComponent modelComponent = (ModelComponent)theEObject;
        T result = caseModelComponent(modelComponent);
        if (result == null) result = caseIInterfaceItemOwner(modelComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.STATE_GRAPH_NODE:
      {
        StateGraphNode stateGraphNode = (StateGraphNode)theEObject;
        T result = caseStateGraphNode(stateGraphNode);
        if (result == null) result = caseStateGraphItem(stateGraphNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.STATE_GRAPH_ITEM:
      {
        StateGraphItem stateGraphItem = (StateGraphItem)theEObject;
        T result = caseStateGraphItem(stateGraphItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.STATE_GRAPH:
      {
        StateGraph stateGraph = (StateGraph)theEObject;
        T result = caseStateGraph(stateGraph);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.STATE:
      {
        State state = (State)theEObject;
        T result = caseState(state);
        if (result == null) result = caseStateGraphNode(state);
        if (result == null) result = caseStateGraphItem(state);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.SIMPLE_STATE:
      {
        SimpleState simpleState = (SimpleState)theEObject;
        T result = caseSimpleState(simpleState);
        if (result == null) result = caseState(simpleState);
        if (result == null) result = caseStateGraphNode(simpleState);
        if (result == null) result = caseStateGraphItem(simpleState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.REFINED_STATE:
      {
        RefinedState refinedState = (RefinedState)theEObject;
        T result = caseRefinedState(refinedState);
        if (result == null) result = caseState(refinedState);
        if (result == null) result = caseStateGraphNode(refinedState);
        if (result == null) result = caseStateGraphItem(refinedState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.DETAIL_CODE:
      {
        DetailCode detailCode = (DetailCode)theEObject;
        T result = caseDetailCode(detailCode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.TR_POINT:
      {
        TrPoint trPoint = (TrPoint)theEObject;
        T result = caseTrPoint(trPoint);
        if (result == null) result = caseStateGraphNode(trPoint);
        if (result == null) result = caseStateGraphItem(trPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.TRANSITION_POINT:
      {
        TransitionPoint transitionPoint = (TransitionPoint)theEObject;
        T result = caseTransitionPoint(transitionPoint);
        if (result == null) result = caseTrPoint(transitionPoint);
        if (result == null) result = caseStateGraphNode(transitionPoint);
        if (result == null) result = caseStateGraphItem(transitionPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.ENTRY_POINT:
      {
        EntryPoint entryPoint = (EntryPoint)theEObject;
        T result = caseEntryPoint(entryPoint);
        if (result == null) result = caseTrPoint(entryPoint);
        if (result == null) result = caseStateGraphNode(entryPoint);
        if (result == null) result = caseStateGraphItem(entryPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.EXIT_POINT:
      {
        ExitPoint exitPoint = (ExitPoint)theEObject;
        T result = caseExitPoint(exitPoint);
        if (result == null) result = caseTrPoint(exitPoint);
        if (result == null) result = caseStateGraphNode(exitPoint);
        if (result == null) result = caseStateGraphItem(exitPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.CHOICE_POINT:
      {
        ChoicePoint choicePoint = (ChoicePoint)theEObject;
        T result = caseChoicePoint(choicePoint);
        if (result == null) result = caseStateGraphNode(choicePoint);
        if (result == null) result = caseStateGraphItem(choicePoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.TRANSITION:
      {
        Transition transition = (Transition)theEObject;
        T result = caseTransition(transition);
        if (result == null) result = caseStateGraphItem(transition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.NON_INITIAL_TRANSITION:
      {
        NonInitialTransition nonInitialTransition = (NonInitialTransition)theEObject;
        T result = caseNonInitialTransition(nonInitialTransition);
        if (result == null) result = caseTransition(nonInitialTransition);
        if (result == null) result = caseStateGraphItem(nonInitialTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.TRANSITION_CHAIN_START_TRANSITION:
      {
        TransitionChainStartTransition transitionChainStartTransition = (TransitionChainStartTransition)theEObject;
        T result = caseTransitionChainStartTransition(transitionChainStartTransition);
        if (result == null) result = caseNonInitialTransition(transitionChainStartTransition);
        if (result == null) result = caseTransition(transitionChainStartTransition);
        if (result == null) result = caseStateGraphItem(transitionChainStartTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.INITIAL_TRANSITION:
      {
        InitialTransition initialTransition = (InitialTransition)theEObject;
        T result = caseInitialTransition(initialTransition);
        if (result == null) result = caseTransition(initialTransition);
        if (result == null) result = caseStateGraphItem(initialTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.CONTINUATION_TRANSITION:
      {
        ContinuationTransition continuationTransition = (ContinuationTransition)theEObject;
        T result = caseContinuationTransition(continuationTransition);
        if (result == null) result = caseNonInitialTransition(continuationTransition);
        if (result == null) result = caseTransition(continuationTransition);
        if (result == null) result = caseStateGraphItem(continuationTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.TRIGGERED_TRANSITION:
      {
        TriggeredTransition triggeredTransition = (TriggeredTransition)theEObject;
        T result = caseTriggeredTransition(triggeredTransition);
        if (result == null) result = caseTransitionChainStartTransition(triggeredTransition);
        if (result == null) result = caseNonInitialTransition(triggeredTransition);
        if (result == null) result = caseTransition(triggeredTransition);
        if (result == null) result = caseStateGraphItem(triggeredTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.GUARDED_TRANSITION:
      {
        GuardedTransition guardedTransition = (GuardedTransition)theEObject;
        T result = caseGuardedTransition(guardedTransition);
        if (result == null) result = caseTransitionChainStartTransition(guardedTransition);
        if (result == null) result = caseNonInitialTransition(guardedTransition);
        if (result == null) result = caseTransition(guardedTransition);
        if (result == null) result = caseStateGraphItem(guardedTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.CP_BRANCH_TRANSITION:
      {
        CPBranchTransition cpBranchTransition = (CPBranchTransition)theEObject;
        T result = caseCPBranchTransition(cpBranchTransition);
        if (result == null) result = caseNonInitialTransition(cpBranchTransition);
        if (result == null) result = caseTransition(cpBranchTransition);
        if (result == null) result = caseStateGraphItem(cpBranchTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.REFINED_TRANSITION:
      {
        RefinedTransition refinedTransition = (RefinedTransition)theEObject;
        T result = caseRefinedTransition(refinedTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.TRANSITION_TERMINAL:
      {
        TransitionTerminal transitionTerminal = (TransitionTerminal)theEObject;
        T result = caseTransitionTerminal(transitionTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.STATE_TERMINAL:
      {
        StateTerminal stateTerminal = (StateTerminal)theEObject;
        T result = caseStateTerminal(stateTerminal);
        if (result == null) result = caseTransitionTerminal(stateTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.TR_POINT_TERMINAL:
      {
        TrPointTerminal trPointTerminal = (TrPointTerminal)theEObject;
        T result = caseTrPointTerminal(trPointTerminal);
        if (result == null) result = caseTransitionTerminal(trPointTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.SUB_STATE_TR_POINT_TERMINAL:
      {
        SubStateTrPointTerminal subStateTrPointTerminal = (SubStateTrPointTerminal)theEObject;
        T result = caseSubStateTrPointTerminal(subStateTrPointTerminal);
        if (result == null) result = caseTransitionTerminal(subStateTrPointTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.CHOICEPOINT_TERMINAL:
      {
        ChoicepointTerminal choicepointTerminal = (ChoicepointTerminal)theEObject;
        T result = caseChoicepointTerminal(choicepointTerminal);
        if (result == null) result = caseTransitionTerminal(choicepointTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.TRIGGER:
      {
        Trigger trigger = (Trigger)theEObject;
        T result = caseTrigger(trigger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.MESSAGE_FROM_IF:
      {
        MessageFromIf messageFromIf = (MessageFromIf)theEObject;
        T result = caseMessageFromIf(messageFromIf);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.ABSTRACT_MESSAGE:
      {
        AbstractMessage abstractMessage = (AbstractMessage)theEObject;
        T result = caseAbstractMessage(abstractMessage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.ABSTRACT_INTERFACE_ITEM:
      {
        AbstractInterfaceItem abstractInterfaceItem = (AbstractInterfaceItem)theEObject;
        T result = caseAbstractInterfaceItem(abstractInterfaceItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.GUARD:
      {
        Guard guard = (Guard)theEObject;
        T result = caseGuard(guard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.PROTOCOL_SEMANTICS:
      {
        ProtocolSemantics protocolSemantics = (ProtocolSemantics)theEObject;
        T result = caseProtocolSemantics(protocolSemantics);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.SEMANTICS_RULE:
      {
        SemanticsRule semanticsRule = (SemanticsRule)theEObject;
        T result = caseSemanticsRule(semanticsRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.IN_SEMANTICS_RULE:
      {
        InSemanticsRule inSemanticsRule = (InSemanticsRule)theEObject;
        T result = caseInSemanticsRule(inSemanticsRule);
        if (result == null) result = caseSemanticsRule(inSemanticsRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.OUT_SEMANTICS_RULE:
      {
        OutSemanticsRule outSemanticsRule = (OutSemanticsRule)theEObject;
        T result = caseOutSemanticsRule(outSemanticsRule);
        if (result == null) result = caseSemanticsRule(outSemanticsRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FSMPackage.IINTERFACE_ITEM_OWNER:
      {
        IInterfaceItemOwner iInterfaceItemOwner = (IInterfaceItemOwner)theEObject;
        T result = caseIInterfaceItemOwner(iInterfaceItemOwner);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFSMModel(FSMModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelComponent(ModelComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Graph Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Graph Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateGraphNode(StateGraphNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Graph Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Graph Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateGraphItem(StateGraphItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Graph</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Graph</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateGraph(StateGraph object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseState(State object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleState(SimpleState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Refined State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Refined State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefinedState(RefinedState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Detail Code</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Detail Code</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDetailCode(DetailCode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tr Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tr Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrPoint(TrPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionPoint(TransitionPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entry Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entry Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntryPoint(EntryPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exit Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exit Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExitPoint(ExitPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Choice Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Choice Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChoicePoint(ChoicePoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransition(Transition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Initial Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Initial Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonInitialTransition(NonInitialTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Chain Start Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Chain Start Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionChainStartTransition(TransitionChainStartTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Initial Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Initial Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitialTransition(InitialTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Continuation Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Continuation Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContinuationTransition(ContinuationTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Triggered Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Triggered Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTriggeredTransition(TriggeredTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Guarded Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Guarded Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGuardedTransition(GuardedTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CP Branch Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CP Branch Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCPBranchTransition(CPBranchTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Refined Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Refined Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefinedTransition(RefinedTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Terminal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Terminal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionTerminal(TransitionTerminal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Terminal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Terminal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateTerminal(StateTerminal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tr Point Terminal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tr Point Terminal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrPointTerminal(TrPointTerminal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub State Tr Point Terminal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub State Tr Point Terminal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubStateTrPointTerminal(SubStateTrPointTerminal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Choicepoint Terminal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Choicepoint Terminal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChoicepointTerminal(ChoicepointTerminal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrigger(Trigger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message From If</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message From If</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessageFromIf(MessageFromIf object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Message</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Message</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractMessage(AbstractMessage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Interface Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Interface Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractInterfaceItem(AbstractInterfaceItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGuard(Guard object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Protocol Semantics</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Protocol Semantics</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProtocolSemantics(ProtocolSemantics object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Semantics Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Semantics Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSemanticsRule(SemanticsRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>In Semantics Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>In Semantics Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInSemanticsRule(InSemanticsRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Out Semantics Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Out Semantics Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutSemanticsRule(OutSemanticsRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>IInterface Item Owner</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IInterface Item Owner</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIInterfaceItemOwner(IInterfaceItemOwner object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //FSMSwitch
