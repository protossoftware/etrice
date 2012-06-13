/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.etrice.core.room.*;

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
 * @see org.eclipse.etrice.core.room.RoomPackage
 * @generated
 */
public class RoomSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RoomPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = RoomPackage.eINSTANCE;
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
      case RoomPackage.ROOM_MODEL:
      {
        RoomModel roomModel = (RoomModel)theEObject;
        T result = caseRoomModel(roomModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ROOM_CLASS:
      {
        RoomClass roomClass = (RoomClass)theEObject;
        T result = caseRoomClass(roomClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.STRUCTURE_CLASS:
      {
        StructureClass structureClass = (StructureClass)theEObject;
        T result = caseStructureClass(structureClass);
        if (result == null) result = caseRoomClass(structureClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_CONTAINER_CLASS:
      {
        ActorContainerClass actorContainerClass = (ActorContainerClass)theEObject;
        T result = caseActorContainerClass(actorContainerClass);
        if (result == null) result = caseStructureClass(actorContainerClass);
        if (result == null) result = caseRoomClass(actorContainerClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.VAR_DECL:
      {
        VarDecl varDecl = (VarDecl)theEObject;
        T result = caseVarDecl(varDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.REFABLE_TYPE:
      {
        RefableType refableType = (RefableType)theEObject;
        T result = caseRefableType(refableType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.DATA_TYPE:
      {
        DataType dataType = (DataType)theEObject;
        T result = caseDataType(dataType);
        if (result == null) result = caseRoomClass(dataType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.COMPLEX_TYPE:
      {
        ComplexType complexType = (ComplexType)theEObject;
        T result = caseComplexType(complexType);
        if (result == null) result = caseDataType(complexType);
        if (result == null) result = caseRoomClass(complexType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PRIMITIVE_TYPE:
      {
        PrimitiveType primitiveType = (PrimitiveType)theEObject;
        T result = casePrimitiveType(primitiveType);
        if (result == null) result = caseDataType(primitiveType);
        if (result == null) result = caseRoomClass(primitiveType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.EXTERNAL_TYPE:
      {
        ExternalType externalType = (ExternalType)theEObject;
        T result = caseExternalType(externalType);
        if (result == null) result = caseComplexType(externalType);
        if (result == null) result = caseDataType(externalType);
        if (result == null) result = caseRoomClass(externalType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.DATA_CLASS:
      {
        DataClass dataClass = (DataClass)theEObject;
        T result = caseDataClass(dataClass);
        if (result == null) result = caseComplexType(dataClass);
        if (result == null) result = caseDataType(dataClass);
        if (result == null) result = caseRoomClass(dataClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.OPERATION:
      {
        Operation operation = (Operation)theEObject;
        T result = caseOperation(operation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.STANDARD_OPERATION:
      {
        StandardOperation standardOperation = (StandardOperation)theEObject;
        T result = caseStandardOperation(standardOperation);
        if (result == null) result = caseOperation(standardOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PORT_OPERATION:
      {
        PortOperation portOperation = (PortOperation)theEObject;
        T result = casePortOperation(portOperation);
        if (result == null) result = caseOperation(portOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.GENERAL_PROTOCOL_CLASS:
      {
        GeneralProtocolClass generalProtocolClass = (GeneralProtocolClass)theEObject;
        T result = caseGeneralProtocolClass(generalProtocolClass);
        if (result == null) result = caseRoomClass(generalProtocolClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PROTOCOL_CLASS:
      {
        ProtocolClass protocolClass = (ProtocolClass)theEObject;
        T result = caseProtocolClass(protocolClass);
        if (result == null) result = caseGeneralProtocolClass(protocolClass);
        if (result == null) result = caseRoomClass(protocolClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.COMPOUND_PROTOCOL_CLASS:
      {
        CompoundProtocolClass compoundProtocolClass = (CompoundProtocolClass)theEObject;
        T result = caseCompoundProtocolClass(compoundProtocolClass);
        if (result == null) result = caseGeneralProtocolClass(compoundProtocolClass);
        if (result == null) result = caseRoomClass(compoundProtocolClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SUB_PROTOCOL:
      {
        SubProtocol subProtocol = (SubProtocol)theEObject;
        T result = caseSubProtocol(subProtocol);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.MESSAGE:
      {
        Message message = (Message)theEObject;
        T result = caseMessage(message);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PORT_CLASS:
      {
        PortClass portClass = (PortClass)theEObject;
        T result = casePortClass(portClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.MESSAGE_HANDLER:
      {
        MessageHandler messageHandler = (MessageHandler)theEObject;
        T result = caseMessageHandler(messageHandler);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.IN_MESSAGE_HANDLER:
      {
        InMessageHandler inMessageHandler = (InMessageHandler)theEObject;
        T result = caseInMessageHandler(inMessageHandler);
        if (result == null) result = caseMessageHandler(inMessageHandler);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.OUT_MESSAGE_HANDLER:
      {
        OutMessageHandler outMessageHandler = (OutMessageHandler)theEObject;
        T result = caseOutMessageHandler(outMessageHandler);
        if (result == null) result = caseMessageHandler(outMessageHandler);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PROTOCOL_SEMANTICS:
      {
        ProtocolSemantics protocolSemantics = (ProtocolSemantics)theEObject;
        T result = caseProtocolSemantics(protocolSemantics);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SEMANTICS_RULE:
      {
        SemanticsRule semanticsRule = (SemanticsRule)theEObject;
        T result = caseSemanticsRule(semanticsRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_CLASS:
      {
        ActorClass actorClass = (ActorClass)theEObject;
        T result = caseActorClass(actorClass);
        if (result == null) result = caseActorContainerClass(actorClass);
        if (result == null) result = caseStructureClass(actorClass);
        if (result == null) result = caseRoomClass(actorClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.INTERFACE_ITEM:
      {
        InterfaceItem interfaceItem = (InterfaceItem)theEObject;
        T result = caseInterfaceItem(interfaceItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PORT:
      {
        Port port = (Port)theEObject;
        T result = casePort(port);
        if (result == null) result = caseInterfaceItem(port);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.EXTERNAL_PORT:
      {
        ExternalPort externalPort = (ExternalPort)theEObject;
        T result = caseExternalPort(externalPort);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SAP_REF:
      {
        SAPRef sapRef = (SAPRef)theEObject;
        T result = caseSAPRef(sapRef);
        if (result == null) result = caseInterfaceItem(sapRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SPP_REF:
      {
        SPPRef sppRef = (SPPRef)theEObject;
        T result = caseSPPRef(sppRef);
        if (result == null) result = caseInterfaceItem(sppRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SERVICE_IMPLEMENTATION:
      {
        ServiceImplementation serviceImplementation = (ServiceImplementation)theEObject;
        T result = caseServiceImplementation(serviceImplementation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.LOGICAL_SYSTEM:
      {
        LogicalSystem logicalSystem = (LogicalSystem)theEObject;
        T result = caseLogicalSystem(logicalSystem);
        if (result == null) result = caseStructureClass(logicalSystem);
        if (result == null) result = caseRoomClass(logicalSystem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_CONTAINER_REF:
      {
        ActorContainerRef actorContainerRef = (ActorContainerRef)theEObject;
        T result = caseActorContainerRef(actorContainerRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SUB_SYSTEM_REF:
      {
        SubSystemRef subSystemRef = (SubSystemRef)theEObject;
        T result = caseSubSystemRef(subSystemRef);
        if (result == null) result = caseActorContainerRef(subSystemRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SUB_SYSTEM_CLASS:
      {
        SubSystemClass subSystemClass = (SubSystemClass)theEObject;
        T result = caseSubSystemClass(subSystemClass);
        if (result == null) result = caseActorContainerClass(subSystemClass);
        if (result == null) result = caseStructureClass(subSystemClass);
        if (result == null) result = caseRoomClass(subSystemClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.LOGICAL_THREAD:
      {
        LogicalThread logicalThread = (LogicalThread)theEObject;
        T result = caseLogicalThread(logicalThread);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_INSTANCE_PATH:
      {
        ActorInstancePath actorInstancePath = (ActorInstancePath)theEObject;
        T result = caseActorInstancePath(actorInstancePath);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.BINDING:
      {
        Binding binding = (Binding)theEObject;
        T result = caseBinding(binding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.BINDING_END_POINT:
      {
        BindingEndPoint bindingEndPoint = (BindingEndPoint)theEObject;
        T result = caseBindingEndPoint(bindingEndPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.LAYER_CONNECTION:
      {
        LayerConnection layerConnection = (LayerConnection)theEObject;
        T result = caseLayerConnection(layerConnection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SA_POINT:
      {
        SAPoint saPoint = (SAPoint)theEObject;
        T result = caseSAPoint(saPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.REF_SA_POINT:
      {
        RefSAPoint refSAPoint = (RefSAPoint)theEObject;
        T result = caseRefSAPoint(refSAPoint);
        if (result == null) result = caseSAPoint(refSAPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.RELAY_SA_POINT:
      {
        RelaySAPoint relaySAPoint = (RelaySAPoint)theEObject;
        T result = caseRelaySAPoint(relaySAPoint);
        if (result == null) result = caseSAPoint(relaySAPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SP_POINT:
      {
        SPPoint spPoint = (SPPoint)theEObject;
        T result = caseSPPoint(spPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_REF:
      {
        ActorRef actorRef = (ActorRef)theEObject;
        T result = caseActorRef(actorRef);
        if (result == null) result = caseActorContainerRef(actorRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.STATE_GRAPH_NODE:
      {
        StateGraphNode stateGraphNode = (StateGraphNode)theEObject;
        T result = caseStateGraphNode(stateGraphNode);
        if (result == null) result = caseStateGraphItem(stateGraphNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.STATE_GRAPH_ITEM:
      {
        StateGraphItem stateGraphItem = (StateGraphItem)theEObject;
        T result = caseStateGraphItem(stateGraphItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.STATE:
      {
        State state = (State)theEObject;
        T result = caseState(state);
        if (result == null) result = caseStateGraphNode(state);
        if (result == null) result = caseStateGraphItem(state);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.STATE_GRAPH:
      {
        StateGraph stateGraph = (StateGraph)theEObject;
        T result = caseStateGraph(stateGraph);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SIMPLE_STATE:
      {
        SimpleState simpleState = (SimpleState)theEObject;
        T result = caseSimpleState(simpleState);
        if (result == null) result = caseState(simpleState);
        if (result == null) result = caseStateGraphNode(simpleState);
        if (result == null) result = caseStateGraphItem(simpleState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.REFINED_STATE:
      {
        RefinedState refinedState = (RefinedState)theEObject;
        T result = caseRefinedState(refinedState);
        if (result == null) result = caseState(refinedState);
        if (result == null) result = caseStateGraphNode(refinedState);
        if (result == null) result = caseStateGraphItem(refinedState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.DETAIL_CODE:
      {
        DetailCode detailCode = (DetailCode)theEObject;
        T result = caseDetailCode(detailCode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.TR_POINT:
      {
        TrPoint trPoint = (TrPoint)theEObject;
        T result = caseTrPoint(trPoint);
        if (result == null) result = caseStateGraphNode(trPoint);
        if (result == null) result = caseStateGraphItem(trPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.TRANSITION_POINT:
      {
        TransitionPoint transitionPoint = (TransitionPoint)theEObject;
        T result = caseTransitionPoint(transitionPoint);
        if (result == null) result = caseTrPoint(transitionPoint);
        if (result == null) result = caseStateGraphNode(transitionPoint);
        if (result == null) result = caseStateGraphItem(transitionPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ENTRY_POINT:
      {
        EntryPoint entryPoint = (EntryPoint)theEObject;
        T result = caseEntryPoint(entryPoint);
        if (result == null) result = caseTrPoint(entryPoint);
        if (result == null) result = caseStateGraphNode(entryPoint);
        if (result == null) result = caseStateGraphItem(entryPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.EXIT_POINT:
      {
        ExitPoint exitPoint = (ExitPoint)theEObject;
        T result = caseExitPoint(exitPoint);
        if (result == null) result = caseTrPoint(exitPoint);
        if (result == null) result = caseStateGraphNode(exitPoint);
        if (result == null) result = caseStateGraphItem(exitPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.CHOICE_POINT:
      {
        ChoicePoint choicePoint = (ChoicePoint)theEObject;
        T result = caseChoicePoint(choicePoint);
        if (result == null) result = caseStateGraphNode(choicePoint);
        if (result == null) result = caseStateGraphItem(choicePoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.TRANSITION:
      {
        Transition transition = (Transition)theEObject;
        T result = caseTransition(transition);
        if (result == null) result = caseStateGraphItem(transition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.NON_INITIAL_TRANSITION:
      {
        NonInitialTransition nonInitialTransition = (NonInitialTransition)theEObject;
        T result = caseNonInitialTransition(nonInitialTransition);
        if (result == null) result = caseTransition(nonInitialTransition);
        if (result == null) result = caseStateGraphItem(nonInitialTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.TRANSITION_CHAIN_START_TRANSITION:
      {
        TransitionChainStartTransition transitionChainStartTransition = (TransitionChainStartTransition)theEObject;
        T result = caseTransitionChainStartTransition(transitionChainStartTransition);
        if (result == null) result = caseNonInitialTransition(transitionChainStartTransition);
        if (result == null) result = caseTransition(transitionChainStartTransition);
        if (result == null) result = caseStateGraphItem(transitionChainStartTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.INITIAL_TRANSITION:
      {
        InitialTransition initialTransition = (InitialTransition)theEObject;
        T result = caseInitialTransition(initialTransition);
        if (result == null) result = caseTransition(initialTransition);
        if (result == null) result = caseStateGraphItem(initialTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.CONTINUATION_TRANSITION:
      {
        ContinuationTransition continuationTransition = (ContinuationTransition)theEObject;
        T result = caseContinuationTransition(continuationTransition);
        if (result == null) result = caseNonInitialTransition(continuationTransition);
        if (result == null) result = caseTransition(continuationTransition);
        if (result == null) result = caseStateGraphItem(continuationTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.TRIGGERED_TRANSITION:
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
      case RoomPackage.GUARDED_TRANSITION:
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
      case RoomPackage.CP_BRANCH_TRANSITION:
      {
        CPBranchTransition cpBranchTransition = (CPBranchTransition)theEObject;
        T result = caseCPBranchTransition(cpBranchTransition);
        if (result == null) result = caseNonInitialTransition(cpBranchTransition);
        if (result == null) result = caseTransition(cpBranchTransition);
        if (result == null) result = caseStateGraphItem(cpBranchTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.TRANSITION_TERMINAL:
      {
        TransitionTerminal transitionTerminal = (TransitionTerminal)theEObject;
        T result = caseTransitionTerminal(transitionTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.STATE_TERMINAL:
      {
        StateTerminal stateTerminal = (StateTerminal)theEObject;
        T result = caseStateTerminal(stateTerminal);
        if (result == null) result = caseTransitionTerminal(stateTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.TR_POINT_TERMINAL:
      {
        TrPointTerminal trPointTerminal = (TrPointTerminal)theEObject;
        T result = caseTrPointTerminal(trPointTerminal);
        if (result == null) result = caseTransitionTerminal(trPointTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SUB_STATE_TR_POINT_TERMINAL:
      {
        SubStateTrPointTerminal subStateTrPointTerminal = (SubStateTrPointTerminal)theEObject;
        T result = caseSubStateTrPointTerminal(subStateTrPointTerminal);
        if (result == null) result = caseTransitionTerminal(subStateTrPointTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.CHOICEPOINT_TERMINAL:
      {
        ChoicepointTerminal choicepointTerminal = (ChoicepointTerminal)theEObject;
        T result = caseChoicepointTerminal(choicepointTerminal);
        if (result == null) result = caseTransitionTerminal(choicepointTerminal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.TRIGGER:
      {
        Trigger trigger = (Trigger)theEObject;
        T result = caseTrigger(trigger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.MESSAGE_FROM_IF:
      {
        MessageFromIf messageFromIf = (MessageFromIf)theEObject;
        T result = caseMessageFromIf(messageFromIf);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.GUARD:
      {
        Guard guard = (Guard)theEObject;
        T result = caseGuard(guard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.DOCUMENTATION:
      {
        Documentation documentation = (Documentation)theEObject;
        T result = caseDocumentation(documentation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ANNOTATION:
      {
        Annotation annotation = (Annotation)theEObject;
        T result = caseAnnotation(annotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.KEY_VALUE:
      {
        KeyValue keyValue = (KeyValue)theEObject;
        T result = caseKeyValue(keyValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
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
  public T caseRoomModel(RoomModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoomClass(RoomClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Structure Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structure Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructureClass(StructureClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Container Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Container Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorContainerClass(ActorContainerClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarDecl(VarDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Refable Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Refable Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefableType(RefableType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataType(DataType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplexType(ComplexType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveType(PrimitiveType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalType(ExternalType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataClass(DataClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperation(Operation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Standard Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Standard Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStandardOperation(StandardOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortOperation(PortOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>General Protocol Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>General Protocol Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGeneralProtocolClass(GeneralProtocolClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Protocol Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Protocol Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProtocolClass(ProtocolClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compound Protocol Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compound Protocol Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompoundProtocolClass(CompoundProtocolClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub Protocol</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub Protocol</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubProtocol(SubProtocol object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessage(Message object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortClass(PortClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message Handler</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message Handler</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessageHandler(MessageHandler object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>In Message Handler</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>In Message Handler</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInMessageHandler(InMessageHandler object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Out Message Handler</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Out Message Handler</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutMessageHandler(OutMessageHandler object)
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
   * Returns the result of interpreting the object as an instance of '<em>Actor Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorClass(ActorClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interface Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interface Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInterfaceItem(InterfaceItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePort(Port object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Port</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Port</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalPort(ExternalPort object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SAP Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SAP Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSAPRef(SAPRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SPP Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SPP Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSPPRef(SPPRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Service Implementation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Service Implementation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServiceImplementation(ServiceImplementation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical System</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical System</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalSystem(LogicalSystem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Container Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Container Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorContainerRef(ActorContainerRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub System Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub System Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubSystemRef(SubSystemRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub System Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub System Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubSystemClass(SubSystemClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Thread</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Thread</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalThread(LogicalThread object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Instance Path</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Instance Path</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorInstancePath(ActorInstancePath object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinding(Binding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binding End Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binding End Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBindingEndPoint(BindingEndPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Layer Connection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Layer Connection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLayerConnection(LayerConnection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SA Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SA Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSAPoint(SAPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref SA Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref SA Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefSAPoint(RefSAPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relay SA Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relay SA Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelaySAPoint(RelaySAPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SP Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SP Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSPPoint(SPPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorRef(ActorRef object)
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
   * Returns the result of interpreting the object as an instance of '<em>Documentation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Documentation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDocumentation(Documentation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotation(Annotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Key Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Key Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeyValue(KeyValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
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

} //RoomSwitch
