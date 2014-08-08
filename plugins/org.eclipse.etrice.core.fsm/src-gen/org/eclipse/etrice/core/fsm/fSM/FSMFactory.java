/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage
 * @generated
 */
public interface FSMFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FSMFactory eINSTANCE = org.eclipse.etrice.core.fsm.fSM.impl.FSMFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  FSMModel createFSMModel();

  /**
   * Returns a new object of class '<em>Model Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Component</em>'.
   * @generated
   */
  ModelComponent createModelComponent();

  /**
   * Returns a new object of class '<em>State Graph Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Graph Node</em>'.
   * @generated
   */
  StateGraphNode createStateGraphNode();

  /**
   * Returns a new object of class '<em>State Graph Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Graph Item</em>'.
   * @generated
   */
  StateGraphItem createStateGraphItem();

  /**
   * Returns a new object of class '<em>State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State</em>'.
   * @generated
   */
  State createState();

  /**
   * Returns a new object of class '<em>State Graph</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Graph</em>'.
   * @generated
   */
  StateGraph createStateGraph();

  /**
   * Returns a new object of class '<em>Simple State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple State</em>'.
   * @generated
   */
  SimpleState createSimpleState();

  /**
   * Returns a new object of class '<em>Refined State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Refined State</em>'.
   * @generated
   */
  RefinedState createRefinedState();

  /**
   * Returns a new object of class '<em>Detail Code</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Detail Code</em>'.
   * @generated
   */
  DetailCode createDetailCode();

  /**
   * Returns a new object of class '<em>Tr Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tr Point</em>'.
   * @generated
   */
  TrPoint createTrPoint();

  /**
   * Returns a new object of class '<em>Transition Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Point</em>'.
   * @generated
   */
  TransitionPoint createTransitionPoint();

  /**
   * Returns a new object of class '<em>Entry Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry Point</em>'.
   * @generated
   */
  EntryPoint createEntryPoint();

  /**
   * Returns a new object of class '<em>Exit Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exit Point</em>'.
   * @generated
   */
  ExitPoint createExitPoint();

  /**
   * Returns a new object of class '<em>Choice Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choice Point</em>'.
   * @generated
   */
  ChoicePoint createChoicePoint();

  /**
   * Returns a new object of class '<em>Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition</em>'.
   * @generated
   */
  Transition createTransition();

  /**
   * Returns a new object of class '<em>Non Initial Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Initial Transition</em>'.
   * @generated
   */
  NonInitialTransition createNonInitialTransition();

  /**
   * Returns a new object of class '<em>Transition Chain Start Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Chain Start Transition</em>'.
   * @generated
   */
  TransitionChainStartTransition createTransitionChainStartTransition();

  /**
   * Returns a new object of class '<em>Initial Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Initial Transition</em>'.
   * @generated
   */
  InitialTransition createInitialTransition();

  /**
   * Returns a new object of class '<em>Continuation Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Continuation Transition</em>'.
   * @generated
   */
  ContinuationTransition createContinuationTransition();

  /**
   * Returns a new object of class '<em>Triggered Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Triggered Transition</em>'.
   * @generated
   */
  TriggeredTransition createTriggeredTransition();

  /**
   * Returns a new object of class '<em>Guarded Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guarded Transition</em>'.
   * @generated
   */
  GuardedTransition createGuardedTransition();

  /**
   * Returns a new object of class '<em>CP Branch Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CP Branch Transition</em>'.
   * @generated
   */
  CPBranchTransition createCPBranchTransition();

  /**
   * Returns a new object of class '<em>Refined Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Refined Transition</em>'.
   * @generated
   */
  RefinedTransition createRefinedTransition();

  /**
   * Returns a new object of class '<em>Transition Terminal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Terminal</em>'.
   * @generated
   */
  TransitionTerminal createTransitionTerminal();

  /**
   * Returns a new object of class '<em>State Terminal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Terminal</em>'.
   * @generated
   */
  StateTerminal createStateTerminal();

  /**
   * Returns a new object of class '<em>Tr Point Terminal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tr Point Terminal</em>'.
   * @generated
   */
  TrPointTerminal createTrPointTerminal();

  /**
   * Returns a new object of class '<em>Sub State Tr Point Terminal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub State Tr Point Terminal</em>'.
   * @generated
   */
  SubStateTrPointTerminal createSubStateTrPointTerminal();

  /**
   * Returns a new object of class '<em>Choicepoint Terminal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choicepoint Terminal</em>'.
   * @generated
   */
  ChoicepointTerminal createChoicepointTerminal();

  /**
   * Returns a new object of class '<em>Trigger</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger</em>'.
   * @generated
   */
  Trigger createTrigger();

  /**
   * Returns a new object of class '<em>Message From If</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message From If</em>'.
   * @generated
   */
  MessageFromIf createMessageFromIf();

  /**
   * Returns a new object of class '<em>Abstract Message</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Message</em>'.
   * @generated
   */
  AbstractMessage createAbstractMessage();

  /**
   * Returns a new object of class '<em>Abstract Interface Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Interface Item</em>'.
   * @generated
   */
  AbstractInterfaceItem createAbstractInterfaceItem();

  /**
   * Returns a new object of class '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard</em>'.
   * @generated
   */
  Guard createGuard();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FSMPackage getFSMPackage();

} //FSMFactory
