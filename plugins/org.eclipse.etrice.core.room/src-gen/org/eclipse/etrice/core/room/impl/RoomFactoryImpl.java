/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.etrice.core.room.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoomFactoryImpl extends EFactoryImpl implements RoomFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RoomFactory init()
  {
    try
    {
      RoomFactory theRoomFactory = (RoomFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/etrice/Room"); 
      if (theRoomFactory != null)
      {
        return theRoomFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RoomFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomFactoryImpl()
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
      case RoomPackage.ROOM_MODEL: return createRoomModel();
      case RoomPackage.ROOM_CLASS: return createRoomClass();
      case RoomPackage.STRUCTURE_CLASS: return createStructureClass();
      case RoomPackage.ACTOR_CONTAINER_CLASS: return createActorContainerClass();
      case RoomPackage.VAR_DECL: return createVarDecl();
      case RoomPackage.REFABLE_TYPE: return createRefableType();
      case RoomPackage.DATA_TYPE: return createDataType();
      case RoomPackage.COMPLEX_TYPE: return createComplexType();
      case RoomPackage.PRIMITIVE_TYPE: return createPrimitiveType();
      case RoomPackage.EXTERNAL_TYPE: return createExternalType();
      case RoomPackage.DATA_CLASS: return createDataClass();
      case RoomPackage.ATTRIBUTE: return createAttribute();
      case RoomPackage.OPERATION: return createOperation();
      case RoomPackage.STANDARD_OPERATION: return createStandardOperation();
      case RoomPackage.PORT_OPERATION: return createPortOperation();
      case RoomPackage.GENERAL_PROTOCOL_CLASS: return createGeneralProtocolClass();
      case RoomPackage.PROTOCOL_CLASS: return createProtocolClass();
      case RoomPackage.COMPOUND_PROTOCOL_CLASS: return createCompoundProtocolClass();
      case RoomPackage.SUB_PROTOCOL: return createSubProtocol();
      case RoomPackage.MESSAGE: return createMessage();
      case RoomPackage.PORT_CLASS: return createPortClass();
      case RoomPackage.MESSAGE_HANDLER: return createMessageHandler();
      case RoomPackage.IN_MESSAGE_HANDLER: return createInMessageHandler();
      case RoomPackage.OUT_MESSAGE_HANDLER: return createOutMessageHandler();
      case RoomPackage.PROTOCOL_SEMANTICS: return createProtocolSemantics();
      case RoomPackage.SEMANTICS_RULE: return createSemanticsRule();
      case RoomPackage.IN_SEMANTICS_RULE: return createInSemanticsRule();
      case RoomPackage.OUT_SEMANTICS_RULE: return createOutSemanticsRule();
      case RoomPackage.ACTOR_CLASS: return createActorClass();
      case RoomPackage.INTERFACE_ITEM: return createInterfaceItem();
      case RoomPackage.PORT: return createPort();
      case RoomPackage.EXTERNAL_PORT: return createExternalPort();
      case RoomPackage.SAP_REF: return createSAPRef();
      case RoomPackage.SPP_REF: return createSPPRef();
      case RoomPackage.SERVICE_IMPLEMENTATION: return createServiceImplementation();
      case RoomPackage.LOGICAL_SYSTEM: return createLogicalSystem();
      case RoomPackage.ACTOR_CONTAINER_REF: return createActorContainerRef();
      case RoomPackage.SUB_SYSTEM_REF: return createSubSystemRef();
      case RoomPackage.SUB_SYSTEM_CLASS: return createSubSystemClass();
      case RoomPackage.LOGICAL_THREAD: return createLogicalThread();
      case RoomPackage.ACTOR_INSTANCE_PATH: return createActorInstancePath();
      case RoomPackage.BINDING: return createBinding();
      case RoomPackage.BINDING_END_POINT: return createBindingEndPoint();
      case RoomPackage.LAYER_CONNECTION: return createLayerConnection();
      case RoomPackage.SA_POINT: return createSAPoint();
      case RoomPackage.REF_SA_POINT: return createRefSAPoint();
      case RoomPackage.RELAY_SA_POINT: return createRelaySAPoint();
      case RoomPackage.SP_POINT: return createSPPoint();
      case RoomPackage.ACTOR_REF: return createActorRef();
      case RoomPackage.STATE_GRAPH_NODE: return createStateGraphNode();
      case RoomPackage.STATE_GRAPH_ITEM: return createStateGraphItem();
      case RoomPackage.STATE: return createState();
      case RoomPackage.STATE_GRAPH: return createStateGraph();
      case RoomPackage.SIMPLE_STATE: return createSimpleState();
      case RoomPackage.REFINED_STATE: return createRefinedState();
      case RoomPackage.DETAIL_CODE: return createDetailCode();
      case RoomPackage.TR_POINT: return createTrPoint();
      case RoomPackage.TRANSITION_POINT: return createTransitionPoint();
      case RoomPackage.ENTRY_POINT: return createEntryPoint();
      case RoomPackage.EXIT_POINT: return createExitPoint();
      case RoomPackage.CHOICE_POINT: return createChoicePoint();
      case RoomPackage.TRANSITION: return createTransition();
      case RoomPackage.NON_INITIAL_TRANSITION: return createNonInitialTransition();
      case RoomPackage.TRANSITION_CHAIN_START_TRANSITION: return createTransitionChainStartTransition();
      case RoomPackage.INITIAL_TRANSITION: return createInitialTransition();
      case RoomPackage.CONTINUATION_TRANSITION: return createContinuationTransition();
      case RoomPackage.TRIGGERED_TRANSITION: return createTriggeredTransition();
      case RoomPackage.GUARDED_TRANSITION: return createGuardedTransition();
      case RoomPackage.CP_BRANCH_TRANSITION: return createCPBranchTransition();
      case RoomPackage.REFINED_TRANSITION: return createRefinedTransition();
      case RoomPackage.TRANSITION_TERMINAL: return createTransitionTerminal();
      case RoomPackage.STATE_TERMINAL: return createStateTerminal();
      case RoomPackage.TR_POINT_TERMINAL: return createTrPointTerminal();
      case RoomPackage.SUB_STATE_TR_POINT_TERMINAL: return createSubStateTrPointTerminal();
      case RoomPackage.CHOICEPOINT_TERMINAL: return createChoicepointTerminal();
      case RoomPackage.TRIGGER: return createTrigger();
      case RoomPackage.MESSAGE_FROM_IF: return createMessageFromIf();
      case RoomPackage.GUARD: return createGuard();
      case RoomPackage.DOCUMENTATION: return createDocumentation();
      case RoomPackage.ANNOTATION: return createAnnotation();
      case RoomPackage.KEY_VALUE: return createKeyValue();
      case RoomPackage.IMPORT: return createImport();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case RoomPackage.LITERAL_TYPE:
        return createLiteralTypeFromString(eDataType, initialValue);
      case RoomPackage.COMMUNICATION_TYPE:
        return createCommunicationTypeFromString(eDataType, initialValue);
      case RoomPackage.ACTOR_COMMUNICATION_TYPE:
        return createActorCommunicationTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case RoomPackage.LITERAL_TYPE:
        return convertLiteralTypeToString(eDataType, instanceValue);
      case RoomPackage.COMMUNICATION_TYPE:
        return convertCommunicationTypeToString(eDataType, instanceValue);
      case RoomPackage.ACTOR_COMMUNICATION_TYPE:
        return convertActorCommunicationTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomModel createRoomModel()
  {
    RoomModelImpl roomModel = new RoomModelImpl();
    return roomModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomClass createRoomClass()
  {
    RoomClassImpl roomClass = new RoomClassImpl();
    return roomClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructureClass createStructureClass()
  {
    StructureClassImpl structureClass = new StructureClassImpl();
    return structureClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorContainerClass createActorContainerClass()
  {
    ActorContainerClassImpl actorContainerClass = new ActorContainerClassImpl();
    return actorContainerClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDecl createVarDecl()
  {
    VarDeclImpl varDecl = new VarDeclImpl();
    return varDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefableType createRefableType()
  {
    RefableTypeImpl refableType = new RefableTypeImpl();
    return refableType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType createDataType()
  {
    DataTypeImpl dataType = new DataTypeImpl();
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexType createComplexType()
  {
    ComplexTypeImpl complexType = new ComplexTypeImpl();
    return complexType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveType createPrimitiveType()
  {
    PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
    return primitiveType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalType createExternalType()
  {
    ExternalTypeImpl externalType = new ExternalTypeImpl();
    return externalType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataClass createDataClass()
  {
    DataClassImpl dataClass = new DataClassImpl();
    return dataClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StandardOperation createStandardOperation()
  {
    StandardOperationImpl standardOperation = new StandardOperationImpl();
    return standardOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortOperation createPortOperation()
  {
    PortOperationImpl portOperation = new PortOperationImpl();
    return portOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GeneralProtocolClass createGeneralProtocolClass()
  {
    GeneralProtocolClassImpl generalProtocolClass = new GeneralProtocolClassImpl();
    return generalProtocolClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProtocolClass createProtocolClass()
  {
    ProtocolClassImpl protocolClass = new ProtocolClassImpl();
    return protocolClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompoundProtocolClass createCompoundProtocolClass()
  {
    CompoundProtocolClassImpl compoundProtocolClass = new CompoundProtocolClassImpl();
    return compoundProtocolClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubProtocol createSubProtocol()
  {
    SubProtocolImpl subProtocol = new SubProtocolImpl();
    return subProtocol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Message createMessage()
  {
    MessageImpl message = new MessageImpl();
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortClass createPortClass()
  {
    PortClassImpl portClass = new PortClassImpl();
    return portClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageHandler createMessageHandler()
  {
    MessageHandlerImpl messageHandler = new MessageHandlerImpl();
    return messageHandler;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InMessageHandler createInMessageHandler()
  {
    InMessageHandlerImpl inMessageHandler = new InMessageHandlerImpl();
    return inMessageHandler;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutMessageHandler createOutMessageHandler()
  {
    OutMessageHandlerImpl outMessageHandler = new OutMessageHandlerImpl();
    return outMessageHandler;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProtocolSemantics createProtocolSemantics()
  {
    ProtocolSemanticsImpl protocolSemantics = new ProtocolSemanticsImpl();
    return protocolSemantics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SemanticsRule createSemanticsRule()
  {
    SemanticsRuleImpl semanticsRule = new SemanticsRuleImpl();
    return semanticsRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InSemanticsRule createInSemanticsRule()
  {
    InSemanticsRuleImpl inSemanticsRule = new InSemanticsRuleImpl();
    return inSemanticsRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutSemanticsRule createOutSemanticsRule()
  {
    OutSemanticsRuleImpl outSemanticsRule = new OutSemanticsRuleImpl();
    return outSemanticsRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorClass createActorClass()
  {
    ActorClassImpl actorClass = new ActorClassImpl();
    return actorClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InterfaceItem createInterfaceItem()
  {
    InterfaceItemImpl interfaceItem = new InterfaceItemImpl();
    return interfaceItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port createPort()
  {
    PortImpl port = new PortImpl();
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalPort createExternalPort()
  {
    ExternalPortImpl externalPort = new ExternalPortImpl();
    return externalPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SAPRef createSAPRef()
  {
    SAPRefImpl sapRef = new SAPRefImpl();
    return sapRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SPPRef createSPPRef()
  {
    SPPRefImpl sppRef = new SPPRefImpl();
    return sppRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceImplementation createServiceImplementation()
  {
    ServiceImplementationImpl serviceImplementation = new ServiceImplementationImpl();
    return serviceImplementation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalSystem createLogicalSystem()
  {
    LogicalSystemImpl logicalSystem = new LogicalSystemImpl();
    return logicalSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorContainerRef createActorContainerRef()
  {
    ActorContainerRefImpl actorContainerRef = new ActorContainerRefImpl();
    return actorContainerRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubSystemRef createSubSystemRef()
  {
    SubSystemRefImpl subSystemRef = new SubSystemRefImpl();
    return subSystemRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubSystemClass createSubSystemClass()
  {
    SubSystemClassImpl subSystemClass = new SubSystemClassImpl();
    return subSystemClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalThread createLogicalThread()
  {
    LogicalThreadImpl logicalThread = new LogicalThreadImpl();
    return logicalThread;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorInstancePath createActorInstancePath()
  {
    ActorInstancePathImpl actorInstancePath = new ActorInstancePathImpl();
    return actorInstancePath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Binding createBinding()
  {
    BindingImpl binding = new BindingImpl();
    return binding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BindingEndPoint createBindingEndPoint()
  {
    BindingEndPointImpl bindingEndPoint = new BindingEndPointImpl();
    return bindingEndPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LayerConnection createLayerConnection()
  {
    LayerConnectionImpl layerConnection = new LayerConnectionImpl();
    return layerConnection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SAPoint createSAPoint()
  {
    SAPointImpl saPoint = new SAPointImpl();
    return saPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefSAPoint createRefSAPoint()
  {
    RefSAPointImpl refSAPoint = new RefSAPointImpl();
    return refSAPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelaySAPoint createRelaySAPoint()
  {
    RelaySAPointImpl relaySAPoint = new RelaySAPointImpl();
    return relaySAPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SPPoint createSPPoint()
  {
    SPPointImpl spPoint = new SPPointImpl();
    return spPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorRef createActorRef()
  {
    ActorRefImpl actorRef = new ActorRefImpl();
    return actorRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateGraphNode createStateGraphNode()
  {
    StateGraphNodeImpl stateGraphNode = new StateGraphNodeImpl();
    return stateGraphNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateGraphItem createStateGraphItem()
  {
    StateGraphItemImpl stateGraphItem = new StateGraphItemImpl();
    return stateGraphItem;
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
  public StateGraph createStateGraph()
  {
    StateGraphImpl stateGraph = new StateGraphImpl();
    return stateGraph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleState createSimpleState()
  {
    SimpleStateImpl simpleState = new SimpleStateImpl();
    return simpleState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefinedState createRefinedState()
  {
    RefinedStateImpl refinedState = new RefinedStateImpl();
    return refinedState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetailCode createDetailCode()
  {
    DetailCodeImpl detailCode = new DetailCodeImpl();
    return detailCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrPoint createTrPoint()
  {
    TrPointImpl trPoint = new TrPointImpl();
    return trPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionPoint createTransitionPoint()
  {
    TransitionPointImpl transitionPoint = new TransitionPointImpl();
    return transitionPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntryPoint createEntryPoint()
  {
    EntryPointImpl entryPoint = new EntryPointImpl();
    return entryPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExitPoint createExitPoint()
  {
    ExitPointImpl exitPoint = new ExitPointImpl();
    return exitPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoicePoint createChoicePoint()
  {
    ChoicePointImpl choicePoint = new ChoicePointImpl();
    return choicePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition createTransition()
  {
    TransitionImpl transition = new TransitionImpl();
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonInitialTransition createNonInitialTransition()
  {
    NonInitialTransitionImpl nonInitialTransition = new NonInitialTransitionImpl();
    return nonInitialTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionChainStartTransition createTransitionChainStartTransition()
  {
    TransitionChainStartTransitionImpl transitionChainStartTransition = new TransitionChainStartTransitionImpl();
    return transitionChainStartTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitialTransition createInitialTransition()
  {
    InitialTransitionImpl initialTransition = new InitialTransitionImpl();
    return initialTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContinuationTransition createContinuationTransition()
  {
    ContinuationTransitionImpl continuationTransition = new ContinuationTransitionImpl();
    return continuationTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggeredTransition createTriggeredTransition()
  {
    TriggeredTransitionImpl triggeredTransition = new TriggeredTransitionImpl();
    return triggeredTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GuardedTransition createGuardedTransition()
  {
    GuardedTransitionImpl guardedTransition = new GuardedTransitionImpl();
    return guardedTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CPBranchTransition createCPBranchTransition()
  {
    CPBranchTransitionImpl cpBranchTransition = new CPBranchTransitionImpl();
    return cpBranchTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefinedTransition createRefinedTransition()
  {
    RefinedTransitionImpl refinedTransition = new RefinedTransitionImpl();
    return refinedTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionTerminal createTransitionTerminal()
  {
    TransitionTerminalImpl transitionTerminal = new TransitionTerminalImpl();
    return transitionTerminal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateTerminal createStateTerminal()
  {
    StateTerminalImpl stateTerminal = new StateTerminalImpl();
    return stateTerminal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrPointTerminal createTrPointTerminal()
  {
    TrPointTerminalImpl trPointTerminal = new TrPointTerminalImpl();
    return trPointTerminal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubStateTrPointTerminal createSubStateTrPointTerminal()
  {
    SubStateTrPointTerminalImpl subStateTrPointTerminal = new SubStateTrPointTerminalImpl();
    return subStateTrPointTerminal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoicepointTerminal createChoicepointTerminal()
  {
    ChoicepointTerminalImpl choicepointTerminal = new ChoicepointTerminalImpl();
    return choicepointTerminal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger createTrigger()
  {
    TriggerImpl trigger = new TriggerImpl();
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageFromIf createMessageFromIf()
  {
    MessageFromIfImpl messageFromIf = new MessageFromIfImpl();
    return messageFromIf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard createGuard()
  {
    GuardImpl guard = new GuardImpl();
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Documentation createDocumentation()
  {
    DocumentationImpl documentation = new DocumentationImpl();
    return documentation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation createAnnotation()
  {
    AnnotationImpl annotation = new AnnotationImpl();
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeyValue createKeyValue()
  {
    KeyValueImpl keyValue = new KeyValueImpl();
    return keyValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralType createLiteralTypeFromString(EDataType eDataType, String initialValue)
  {
    LiteralType result = LiteralType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLiteralTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommunicationType createCommunicationTypeFromString(EDataType eDataType, String initialValue)
  {
    CommunicationType result = CommunicationType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCommunicationTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorCommunicationType createActorCommunicationTypeFromString(EDataType eDataType, String initialValue)
  {
    ActorCommunicationType result = ActorCommunicationType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertActorCommunicationTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomPackage getRoomPackage()
  {
    return (RoomPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static RoomPackage getPackage()
  {
    return RoomPackage.eINSTANCE;
  }

} //RoomFactoryImpl
