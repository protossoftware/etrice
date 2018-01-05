/**
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
      RoomFactory theRoomFactory = (RoomFactory)EPackage.Registry.INSTANCE.getEFactory(RoomPackage.eNS_URI);
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
      case RoomPackage.MESSAGE_DATA: return createMessageData();
      case RoomPackage.REFABLE_TYPE: return createRefableType();
      case RoomPackage.DATA_TYPE: return createDataType();
      case RoomPackage.COMPLEX_TYPE: return createComplexType();
      case RoomPackage.PRIMITIVE_TYPE: return createPrimitiveType();
      case RoomPackage.ENUMERATION_TYPE: return createEnumerationType();
      case RoomPackage.ENUM_LITERAL: return createEnumLiteral();
      case RoomPackage.EXTERNAL_TYPE: return createExternalType();
      case RoomPackage.DATA_CLASS: return createDataClass();
      case RoomPackage.ATTRIBUTE: return createAttribute();
      case RoomPackage.OPERATION: return createOperation();
      case RoomPackage.STANDARD_OPERATION: return createStandardOperation();
      case RoomPackage.PORT_OPERATION: return createPortOperation();
      case RoomPackage.CLASS_STRUCTOR: return createClassStructor();
      case RoomPackage.GENERAL_PROTOCOL_CLASS: return createGeneralProtocolClass();
      case RoomPackage.PROTOCOL_CLASS: return createProtocolClass();
      case RoomPackage.COMPOUND_PROTOCOL_CLASS: return createCompoundProtocolClass();
      case RoomPackage.SUB_PROTOCOL: return createSubProtocol();
      case RoomPackage.MESSAGE: return createMessage();
      case RoomPackage.PORT_CLASS: return createPortClass();
      case RoomPackage.MESSAGE_HANDLER: return createMessageHandler();
      case RoomPackage.IN_MESSAGE_HANDLER: return createInMessageHandler();
      case RoomPackage.OUT_MESSAGE_HANDLER: return createOutMessageHandler();
      case RoomPackage.ACTOR_CLASS: return createActorClass();
      case RoomPackage.INTERFACE_ITEM: return createInterfaceItem();
      case RoomPackage.PORT: return createPort();
      case RoomPackage.EXTERNAL_PORT: return createExternalPort();
      case RoomPackage.SAP: return createSAP();
      case RoomPackage.SPP: return createSPP();
      case RoomPackage.SERVICE_IMPLEMENTATION: return createServiceImplementation();
      case RoomPackage.LOGICAL_SYSTEM: return createLogicalSystem();
      case RoomPackage.ACTOR_CONTAINER_REF: return createActorContainerRef();
      case RoomPackage.SUB_SYSTEM_REF: return createSubSystemRef();
      case RoomPackage.SUB_SYSTEM_CLASS: return createSubSystemClass();
      case RoomPackage.LOGICAL_THREAD: return createLogicalThread();
      case RoomPackage.ACTOR_INSTANCE_MAPPING: return createActorInstanceMapping();
      case RoomPackage.REF_PATH: return createRefPath();
      case RoomPackage.REF_SEGMENT: return createRefSegment();
      case RoomPackage.BINDING: return createBinding();
      case RoomPackage.BINDING_END_POINT: return createBindingEndPoint();
      case RoomPackage.LAYER_CONNECTION: return createLayerConnection();
      case RoomPackage.SA_POINT: return createSAPoint();
      case RoomPackage.REF_SA_POINT: return createRefSAPoint();
      case RoomPackage.RELAY_SA_POINT: return createRelaySAPoint();
      case RoomPackage.SP_POINT: return createSPPoint();
      case RoomPackage.ACTOR_REF: return createActorRef();
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
      case RoomPackage.COMMUNICATION_TYPE:
        return createCommunicationTypeFromString(eDataType, initialValue);
      case RoomPackage.REFERENCE_TYPE:
        return createReferenceTypeFromString(eDataType, initialValue);
      case RoomPackage.ROOM_ANNOTATION_TARGET_ENUM:
        return createRoomAnnotationTargetEnumFromString(eDataType, initialValue);
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
      case RoomPackage.COMMUNICATION_TYPE:
        return convertCommunicationTypeToString(eDataType, instanceValue);
      case RoomPackage.REFERENCE_TYPE:
        return convertReferenceTypeToString(eDataType, instanceValue);
      case RoomPackage.ROOM_ANNOTATION_TARGET_ENUM:
        return convertRoomAnnotationTargetEnumToString(eDataType, instanceValue);
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
  public MessageData createMessageData()
  {
    MessageDataImpl messageData = new MessageDataImpl();
    return messageData;
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
  public EnumerationType createEnumerationType()
  {
    EnumerationTypeImpl enumerationType = new EnumerationTypeImpl();
    return enumerationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumLiteral createEnumLiteral()
  {
    EnumLiteralImpl enumLiteral = new EnumLiteralImpl();
    return enumLiteral;
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
  public ClassStructor createClassStructor()
  {
    ClassStructorImpl classStructor = new ClassStructorImpl();
    return classStructor;
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
  public SAP createSAP()
  {
    SAPImpl sap = new SAPImpl();
    return sap;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SPP createSPP()
  {
    SPPImpl spp = new SPPImpl();
    return spp;
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
  public ActorInstanceMapping createActorInstanceMapping()
  {
    ActorInstanceMappingImpl actorInstanceMapping = new ActorInstanceMappingImpl();
    return actorInstanceMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefPath createRefPath()
  {
    RefPathImpl refPath = new RefPathImpl();
    return refPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefSegment createRefSegment()
  {
    RefSegmentImpl refSegment = new RefSegmentImpl();
    return refSegment;
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
  public ReferenceType createReferenceTypeFromString(EDataType eDataType, String initialValue)
  {
    ReferenceType result = ReferenceType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertReferenceTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomAnnotationTargetEnum createRoomAnnotationTargetEnumFromString(EDataType eDataType, String initialValue)
  {
    RoomAnnotationTargetEnum result = RoomAnnotationTargetEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRoomAnnotationTargetEnumToString(EDataType eDataType, Object instanceValue)
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
