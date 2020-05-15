/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.room.RoomPackage
 * @generated
 */
public interface RoomFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RoomFactory eINSTANCE = org.eclipse.etrice.core.room.impl.RoomFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  RoomModel createRoomModel();

  /**
   * Returns a new object of class '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class</em>'.
   * @generated
   */
  RoomClass createRoomClass();

  /**
   * Returns a new object of class '<em>Structure Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Structure Class</em>'.
   * @generated
   */
  StructureClass createStructureClass();

  /**
   * Returns a new object of class '<em>Actor Container Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actor Container Class</em>'.
   * @generated
   */
  ActorContainerClass createActorContainerClass();

  /**
   * Returns a new object of class '<em>Var Decl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Decl</em>'.
   * @generated
   */
  VarDecl createVarDecl();

  /**
   * Returns a new object of class '<em>Message Data</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Data</em>'.
   * @generated
   */
  MessageData createMessageData();

  /**
   * Returns a new object of class '<em>Refable Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Refable Type</em>'.
   * @generated
   */
  RefableType createRefableType();

  /**
   * Returns a new object of class '<em>Data Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type</em>'.
   * @generated
   */
  DataType createDataType();

  /**
   * Returns a new object of class '<em>Complex Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Complex Type</em>'.
   * @generated
   */
  ComplexType createComplexType();

  /**
   * Returns a new object of class '<em>Primitive Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primitive Type</em>'.
   * @generated
   */
  PrimitiveType createPrimitiveType();

  /**
   * Returns a new object of class '<em>Enumeration Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Type</em>'.
   * @generated
   */
  EnumerationType createEnumerationType();

  /**
   * Returns a new object of class '<em>Enum Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Literal</em>'.
   * @generated
   */
  EnumLiteral createEnumLiteral();

  /**
   * Returns a new object of class '<em>External Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Type</em>'.
   * @generated
   */
  ExternalType createExternalType();

  /**
   * Returns a new object of class '<em>Data Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Class</em>'.
   * @generated
   */
  DataClass createDataClass();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation</em>'.
   * @generated
   */
  Operation createOperation();

  /**
   * Returns a new object of class '<em>Standard Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Standard Operation</em>'.
   * @generated
   */
  StandardOperation createStandardOperation();

  /**
   * Returns a new object of class '<em>Port Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Operation</em>'.
   * @generated
   */
  PortOperation createPortOperation();

  /**
   * Returns a new object of class '<em>Class Structor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Structor</em>'.
   * @generated
   */
  ClassStructor createClassStructor();

  /**
   * Returns a new object of class '<em>Protocol Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Protocol Class</em>'.
   * @generated
   */
  ProtocolClass createProtocolClass();

  /**
   * Returns a new object of class '<em>Message</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message</em>'.
   * @generated
   */
  Message createMessage();

  /**
   * Returns a new object of class '<em>Port Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Class</em>'.
   * @generated
   */
  PortClass createPortClass();

  /**
   * Returns a new object of class '<em>Message Handler</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Handler</em>'.
   * @generated
   */
  MessageHandler createMessageHandler();

  /**
   * Returns a new object of class '<em>In Message Handler</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>In Message Handler</em>'.
   * @generated
   */
  InMessageHandler createInMessageHandler();

  /**
   * Returns a new object of class '<em>Out Message Handler</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Out Message Handler</em>'.
   * @generated
   */
  OutMessageHandler createOutMessageHandler();

  /**
   * Returns a new object of class '<em>Actor Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actor Class</em>'.
   * @generated
   */
  ActorClass createActorClass();

  /**
   * Returns a new object of class '<em>Interface Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interface Item</em>'.
   * @generated
   */
  InterfaceItem createInterfaceItem();

  /**
   * Returns a new object of class '<em>Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port</em>'.
   * @generated
   */
  Port createPort();

  /**
   * Returns a new object of class '<em>External Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Port</em>'.
   * @generated
   */
  ExternalPort createExternalPort();

  /**
   * Returns a new object of class '<em>SAP</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SAP</em>'.
   * @generated
   */
  SAP createSAP();

  /**
   * Returns a new object of class '<em>SPP</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SPP</em>'.
   * @generated
   */
  SPP createSPP();

  /**
   * Returns a new object of class '<em>Service Implementation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service Implementation</em>'.
   * @generated
   */
  ServiceImplementation createServiceImplementation();

  /**
   * Returns a new object of class '<em>Logical System</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical System</em>'.
   * @generated
   */
  LogicalSystem createLogicalSystem();

  /**
   * Returns a new object of class '<em>Actor Container Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actor Container Ref</em>'.
   * @generated
   */
  ActorContainerRef createActorContainerRef();

  /**
   * Returns a new object of class '<em>Sub System Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub System Ref</em>'.
   * @generated
   */
  SubSystemRef createSubSystemRef();

  /**
   * Returns a new object of class '<em>Sub System Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub System Class</em>'.
   * @generated
   */
  SubSystemClass createSubSystemClass();

  /**
   * Returns a new object of class '<em>Logical Thread</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Thread</em>'.
   * @generated
   */
  LogicalThread createLogicalThread();

  /**
   * Returns a new object of class '<em>Actor Instance Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actor Instance Mapping</em>'.
   * @generated
   */
  ActorInstanceMapping createActorInstanceMapping();

  /**
   * Returns a new object of class '<em>Ref Path</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ref Path</em>'.
   * @generated
   */
  RefPath createRefPath();

  /**
   * Returns a new object of class '<em>Ref Segment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ref Segment</em>'.
   * @generated
   */
  RefSegment createRefSegment();

  /**
   * Returns a new object of class '<em>Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binding</em>'.
   * @generated
   */
  Binding createBinding();

  /**
   * Returns a new object of class '<em>Binding End Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binding End Point</em>'.
   * @generated
   */
  BindingEndPoint createBindingEndPoint();

  /**
   * Returns a new object of class '<em>Layer Connection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Layer Connection</em>'.
   * @generated
   */
  LayerConnection createLayerConnection();

  /**
   * Returns a new object of class '<em>SA Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SA Point</em>'.
   * @generated
   */
  SAPoint createSAPoint();

  /**
   * Returns a new object of class '<em>Ref SA Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ref SA Point</em>'.
   * @generated
   */
  RefSAPoint createRefSAPoint();

  /**
   * Returns a new object of class '<em>Relay SA Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relay SA Point</em>'.
   * @generated
   */
  RelaySAPoint createRelaySAPoint();

  /**
   * Returns a new object of class '<em>SP Point</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SP Point</em>'.
   * @generated
   */
  SPPoint createSPPoint();

  /**
   * Returns a new object of class '<em>Actor Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actor Ref</em>'.
   * @generated
   */
  ActorRef createActorRef();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  RoomPackage getRoomPackage();

} //RoomFactory
