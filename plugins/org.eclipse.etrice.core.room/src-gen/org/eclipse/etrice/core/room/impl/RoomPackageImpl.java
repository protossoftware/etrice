/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.etrice.core.common.base.BasePackage;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.CPBranchTransition;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.ContinuationTransition;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExitPoint;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.Guard;
import org.eclipse.etrice.core.room.GuardedTransition;
import org.eclipse.etrice.core.room.Import;
import org.eclipse.etrice.core.room.InMessageHandler;
import org.eclipse.etrice.core.room.InSemanticsRule;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.OutMessageHandler;
import org.eclipse.etrice.core.room.OutSemanticsRule;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.ProtocolSemantics;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RefSegment;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RefinedTransition;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomAnnotationTargetEnum;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubProtocol;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionChainStartTransition;
import org.eclipse.etrice.core.room.TransitionPoint;
import org.eclipse.etrice.core.room.TransitionTerminal;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.VarDecl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoomPackageImpl extends EPackageImpl implements RoomPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roomModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roomClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structureClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actorContainerClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refableTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass complexTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitiveTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerationTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass standardOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass generalProtocolClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass protocolClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compoundProtocolClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subProtocolEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messageHandlerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inMessageHandlerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outMessageHandlerEClass = null;

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
  private EClass actorClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interfaceItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalPortEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sppEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass serviceImplementationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalSystemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actorContainerRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subSystemRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subSystemClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalThreadEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actorInstanceMappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refPathEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refSegmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bindingEndPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass layerConnectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass saPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refSAPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relaySAPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass spPointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actorRefEClass = null;

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
  private EClass stateEClass = null;

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
  private EClass guardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum communicationTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum actorCommunicationTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum referenceTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum roomAnnotationTargetEnumEEnum = null;

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
   * @see org.eclipse.etrice.core.room.RoomPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private RoomPackageImpl()
  {
    super(eNS_URI, RoomFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link RoomPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static RoomPackage init()
  {
    if (isInited) return (RoomPackage)EPackage.Registry.INSTANCE.getEPackage(RoomPackage.eNS_URI);

    // Obtain or create and register package
    RoomPackageImpl theRoomPackage = (RoomPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RoomPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RoomPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    BasePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theRoomPackage.createPackageContents();

    // Initialize created meta-data
    theRoomPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theRoomPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(RoomPackage.eNS_URI, theRoomPackage);
    return theRoomPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoomModel()
  {
    return roomModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRoomModel_Name()
  {
    return (EAttribute)roomModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_Docu()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_Imports()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_PrimitiveTypes()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_EnumerationTypes()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_ExternalTypes()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_DataClasses()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_ProtocolClasses()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_ActorClasses()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_SubSystemClasses()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_Systems()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomModel_AnnotationTypes()
  {
    return (EReference)roomModelEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoomClass()
  {
    return roomClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRoomClass_Name()
  {
    return (EAttribute)roomClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoomClass_Docu()
  {
    return (EReference)roomClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructureClass()
  {
    return structureClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructureClass_Annotations()
  {
    return (EReference)structureClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructureClass_Bindings()
  {
    return (EReference)structureClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructureClass_Connections()
  {
    return (EReference)structureClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActorContainerClass()
  {
    return actorContainerClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorContainerClass_ServiceProvisionPoints()
  {
    return (EReference)actorContainerClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorContainerClass_UserCode1()
  {
    return (EReference)actorContainerClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorContainerClass_UserCode2()
  {
    return (EReference)actorContainerClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorContainerClass_UserCode3()
  {
    return (EReference)actorContainerClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorContainerClass_ActorRefs()
  {
    return (EReference)actorContainerClassEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarDecl()
  {
    return varDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVarDecl_Name()
  {
    return (EAttribute)varDeclEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarDecl_RefType()
  {
    return (EReference)varDeclEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefableType()
  {
    return refableTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefableType_Type()
  {
    return (EReference)refableTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRefableType_Ref()
  {
    return (EAttribute)refableTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataType()
  {
    return dataTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComplexType()
  {
    return complexTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimitiveType()
  {
    return primitiveTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimitiveType_Type()
  {
    return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimitiveType_TargetName()
  {
    return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimitiveType_CastName()
  {
    return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimitiveType_DefaultValueLiteral()
  {
    return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerationType()
  {
    return enumerationTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationType_PrimitiveType()
  {
    return (EReference)enumerationTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationType_Literals()
  {
    return (EReference)enumerationTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumLiteral()
  {
    return enumLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumLiteral_Name()
  {
    return (EAttribute)enumLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumLiteral_Literal()
  {
    return (EReference)enumLiteralEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalType()
  {
    return externalTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalType_TargetName()
  {
    return (EAttribute)externalTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalType_DefaultValueLiteral()
  {
    return (EAttribute)externalTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataClass()
  {
    return dataClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Base()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Annotations()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_UserCode1()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_UserCode2()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_UserCode3()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Attributes()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Operations()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Name()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Size()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_Type()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_DefaultValueLiteral()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_Docu()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperation()
  {
    return operationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperation_Name()
  {
    return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_Arguments()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_ReturnType()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_Docu()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_DetailCode()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStandardOperation()
  {
    return standardOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStandardOperation_Destructor()
  {
    return (EAttribute)standardOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPortOperation()
  {
    return portOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortOperation_SendsMsg()
  {
    return (EReference)portOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGeneralProtocolClass()
  {
    return generalProtocolClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGeneralProtocolClass_Annotations()
  {
    return (EReference)generalProtocolClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProtocolClass()
  {
    return protocolClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProtocolClass_CommType()
  {
    return (EAttribute)protocolClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_Base()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_UserCode1()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_UserCode2()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_UserCode3()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_IncomingMessages()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_OutgoingMessages()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_Regular()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_Conjugated()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProtocolClass_Semantics()
  {
    return (EReference)protocolClassEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompoundProtocolClass()
  {
    return compoundProtocolClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundProtocolClass_SubProtocols()
  {
    return (EReference)compoundProtocolClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubProtocol()
  {
    return subProtocolEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubProtocol_Name()
  {
    return (EAttribute)subProtocolEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubProtocol_Protocol()
  {
    return (EReference)subProtocolEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessage()
  {
    return messageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMessage_Priv()
  {
    return (EAttribute)messageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMessage_Name()
  {
    return (EAttribute)messageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessage_Data()
  {
    return (EReference)messageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessage_Docu()
  {
    return (EReference)messageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPortClass()
  {
    return portClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortClass_UserCode()
  {
    return (EReference)portClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortClass_Attributes()
  {
    return (EReference)portClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortClass_Operations()
  {
    return (EReference)portClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPortClass_MsgHandlers()
  {
    return (EReference)portClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessageHandler()
  {
    return messageHandlerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageHandler_Msg()
  {
    return (EReference)messageHandlerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageHandler_DetailCode()
  {
    return (EReference)messageHandlerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInMessageHandler()
  {
    return inMessageHandlerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutMessageHandler()
  {
    return outMessageHandlerEClass;
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
  public EClass getActorClass()
  {
    return actorClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActorClass_Abstract()
  {
    return (EAttribute)actorClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActorClass_CommType()
  {
    return (EAttribute)actorClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_Base()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_InterfacePorts()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_StructureDocu()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_InternalPorts()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_ExternalPorts()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_ServiceImplementations()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_ServiceAccessPoints()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_Attributes()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_BehaviorDocu()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_BehaviorAnnotations()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_Operations()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_StateMachine()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterfaceItem()
  {
    return interfaceItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInterfaceItem_Name()
  {
    return (EAttribute)interfaceItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPort()
  {
    return portEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPort_Conjugated()
  {
    return (EAttribute)portEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPort_Multiplicity()
  {
    return (EAttribute)portEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPort_Protocol()
  {
    return (EReference)portEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPort_Docu()
  {
    return (EReference)portEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalPort()
  {
    return externalPortEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalPort_InterfacePort()
  {
    return (EReference)externalPortEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSAP()
  {
    return sapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSAP_Protocol()
  {
    return (EReference)sapEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSPP()
  {
    return sppEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSPP_Protocol()
  {
    return (EReference)sppEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServiceImplementation()
  {
    return serviceImplementationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getServiceImplementation_Spp()
  {
    return (EReference)serviceImplementationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalSystem()
  {
    return logicalSystemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalSystem_SubSystems()
  {
    return (EReference)logicalSystemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActorContainerRef()
  {
    return actorContainerRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActorContainerRef_Name()
  {
    return (EAttribute)actorContainerRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorContainerRef_Docu()
  {
    return (EReference)actorContainerRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubSystemRef()
  {
    return subSystemRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubSystemRef_Type()
  {
    return (EReference)subSystemRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubSystemClass()
  {
    return subSystemClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubSystemClass_RelayPorts()
  {
    return (EReference)subSystemClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubSystemClass_Threads()
  {
    return (EReference)subSystemClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubSystemClass_ActorInstanceMappings()
  {
    return (EReference)subSystemClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalThread()
  {
    return logicalThreadEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLogicalThread_Name()
  {
    return (EAttribute)logicalThreadEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActorInstanceMapping()
  {
    return actorInstanceMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorInstanceMapping_Path()
  {
    return (EReference)actorInstanceMappingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorInstanceMapping_Thread()
  {
    return (EReference)actorInstanceMappingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorInstanceMapping_ActorInstanceMappings()
  {
    return (EReference)actorInstanceMappingEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefPath()
  {
    return refPathEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefPath_Refs()
  {
    return (EReference)refPathEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefSegment()
  {
    return refSegmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRefSegment_Ref()
  {
    return (EAttribute)refSegmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRefSegment_Idx()
  {
    return (EAttribute)refSegmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinding()
  {
    return bindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinding_Endpoint1()
  {
    return (EReference)bindingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinding_Endpoint2()
  {
    return (EReference)bindingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBindingEndPoint()
  {
    return bindingEndPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBindingEndPoint_ActorRef()
  {
    return (EReference)bindingEndPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBindingEndPoint_Port()
  {
    return (EReference)bindingEndPointEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBindingEndPoint_Sub()
  {
    return (EReference)bindingEndPointEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLayerConnection()
  {
    return layerConnectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLayerConnection_From()
  {
    return (EReference)layerConnectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLayerConnection_To()
  {
    return (EReference)layerConnectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSAPoint()
  {
    return saPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefSAPoint()
  {
    return refSAPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefSAPoint_Ref()
  {
    return (EReference)refSAPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelaySAPoint()
  {
    return relaySAPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelaySAPoint_Relay()
  {
    return (EReference)relaySAPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSPPoint()
  {
    return spPointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSPPoint_Ref()
  {
    return (EReference)spPointEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSPPoint_Service()
  {
    return (EReference)spPointEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActorRef()
  {
    return actorRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActorRef_RefType()
  {
    return (EAttribute)actorRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActorRef_Multiplicity()
  {
    return (EAttribute)actorRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorRef_Type()
  {
    return (EReference)actorRefEClass.getEStructuralFeatures().get(2);
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
  public EAttribute getDetailCode_Lines()
  {
    return (EAttribute)detailCodeEClass.getEStructuralFeatures().get(0);
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
  public EReference getTransition_Docu()
  {
    return (EReference)transitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition_Action()
  {
    return (EReference)transitionEClass.getEStructuralFeatures().get(3);
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
  public EReference getRefinedTransition_Docu()
  {
    return (EReference)refinedTransitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefinedTransition_Action()
  {
    return (EReference)refinedTransitionEClass.getEStructuralFeatures().get(2);
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
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportedNamespace()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportURI()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCommunicationType()
  {
    return communicationTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getActorCommunicationType()
  {
    return actorCommunicationTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getReferenceType()
  {
    return referenceTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getRoomAnnotationTargetEnum()
  {
    return roomAnnotationTargetEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomFactory getRoomFactory()
  {
    return (RoomFactory)getEFactoryInstance();
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
    roomModelEClass = createEClass(ROOM_MODEL);
    createEAttribute(roomModelEClass, ROOM_MODEL__NAME);
    createEReference(roomModelEClass, ROOM_MODEL__DOCU);
    createEReference(roomModelEClass, ROOM_MODEL__IMPORTS);
    createEReference(roomModelEClass, ROOM_MODEL__PRIMITIVE_TYPES);
    createEReference(roomModelEClass, ROOM_MODEL__ENUMERATION_TYPES);
    createEReference(roomModelEClass, ROOM_MODEL__EXTERNAL_TYPES);
    createEReference(roomModelEClass, ROOM_MODEL__DATA_CLASSES);
    createEReference(roomModelEClass, ROOM_MODEL__PROTOCOL_CLASSES);
    createEReference(roomModelEClass, ROOM_MODEL__ACTOR_CLASSES);
    createEReference(roomModelEClass, ROOM_MODEL__SUB_SYSTEM_CLASSES);
    createEReference(roomModelEClass, ROOM_MODEL__SYSTEMS);
    createEReference(roomModelEClass, ROOM_MODEL__ANNOTATION_TYPES);

    roomClassEClass = createEClass(ROOM_CLASS);
    createEAttribute(roomClassEClass, ROOM_CLASS__NAME);
    createEReference(roomClassEClass, ROOM_CLASS__DOCU);

    structureClassEClass = createEClass(STRUCTURE_CLASS);
    createEReference(structureClassEClass, STRUCTURE_CLASS__ANNOTATIONS);
    createEReference(structureClassEClass, STRUCTURE_CLASS__BINDINGS);
    createEReference(structureClassEClass, STRUCTURE_CLASS__CONNECTIONS);

    actorContainerClassEClass = createEClass(ACTOR_CONTAINER_CLASS);
    createEReference(actorContainerClassEClass, ACTOR_CONTAINER_CLASS__SERVICE_PROVISION_POINTS);
    createEReference(actorContainerClassEClass, ACTOR_CONTAINER_CLASS__USER_CODE1);
    createEReference(actorContainerClassEClass, ACTOR_CONTAINER_CLASS__USER_CODE2);
    createEReference(actorContainerClassEClass, ACTOR_CONTAINER_CLASS__USER_CODE3);
    createEReference(actorContainerClassEClass, ACTOR_CONTAINER_CLASS__ACTOR_REFS);

    varDeclEClass = createEClass(VAR_DECL);
    createEAttribute(varDeclEClass, VAR_DECL__NAME);
    createEReference(varDeclEClass, VAR_DECL__REF_TYPE);

    refableTypeEClass = createEClass(REFABLE_TYPE);
    createEReference(refableTypeEClass, REFABLE_TYPE__TYPE);
    createEAttribute(refableTypeEClass, REFABLE_TYPE__REF);

    dataTypeEClass = createEClass(DATA_TYPE);

    complexTypeEClass = createEClass(COMPLEX_TYPE);

    primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);
    createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__TYPE);
    createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__TARGET_NAME);
    createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__CAST_NAME);
    createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__DEFAULT_VALUE_LITERAL);

    enumerationTypeEClass = createEClass(ENUMERATION_TYPE);
    createEReference(enumerationTypeEClass, ENUMERATION_TYPE__PRIMITIVE_TYPE);
    createEReference(enumerationTypeEClass, ENUMERATION_TYPE__LITERALS);

    enumLiteralEClass = createEClass(ENUM_LITERAL);
    createEAttribute(enumLiteralEClass, ENUM_LITERAL__NAME);
    createEReference(enumLiteralEClass, ENUM_LITERAL__LITERAL);

    externalTypeEClass = createEClass(EXTERNAL_TYPE);
    createEAttribute(externalTypeEClass, EXTERNAL_TYPE__TARGET_NAME);
    createEAttribute(externalTypeEClass, EXTERNAL_TYPE__DEFAULT_VALUE_LITERAL);

    dataClassEClass = createEClass(DATA_CLASS);
    createEReference(dataClassEClass, DATA_CLASS__BASE);
    createEReference(dataClassEClass, DATA_CLASS__ANNOTATIONS);
    createEReference(dataClassEClass, DATA_CLASS__USER_CODE1);
    createEReference(dataClassEClass, DATA_CLASS__USER_CODE2);
    createEReference(dataClassEClass, DATA_CLASS__USER_CODE3);
    createEReference(dataClassEClass, DATA_CLASS__ATTRIBUTES);
    createEReference(dataClassEClass, DATA_CLASS__OPERATIONS);

    attributeEClass = createEClass(ATTRIBUTE);
    createEAttribute(attributeEClass, ATTRIBUTE__NAME);
    createEAttribute(attributeEClass, ATTRIBUTE__SIZE);
    createEReference(attributeEClass, ATTRIBUTE__TYPE);
    createEAttribute(attributeEClass, ATTRIBUTE__DEFAULT_VALUE_LITERAL);
    createEReference(attributeEClass, ATTRIBUTE__DOCU);

    operationEClass = createEClass(OPERATION);
    createEAttribute(operationEClass, OPERATION__NAME);
    createEReference(operationEClass, OPERATION__ARGUMENTS);
    createEReference(operationEClass, OPERATION__RETURN_TYPE);
    createEReference(operationEClass, OPERATION__DOCU);
    createEReference(operationEClass, OPERATION__DETAIL_CODE);

    standardOperationEClass = createEClass(STANDARD_OPERATION);
    createEAttribute(standardOperationEClass, STANDARD_OPERATION__DESTRUCTOR);

    portOperationEClass = createEClass(PORT_OPERATION);
    createEReference(portOperationEClass, PORT_OPERATION__SENDS_MSG);

    generalProtocolClassEClass = createEClass(GENERAL_PROTOCOL_CLASS);
    createEReference(generalProtocolClassEClass, GENERAL_PROTOCOL_CLASS__ANNOTATIONS);

    protocolClassEClass = createEClass(PROTOCOL_CLASS);
    createEAttribute(protocolClassEClass, PROTOCOL_CLASS__COMM_TYPE);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__BASE);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__USER_CODE1);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__USER_CODE2);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__USER_CODE3);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__INCOMING_MESSAGES);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__OUTGOING_MESSAGES);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__REGULAR);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__CONJUGATED);
    createEReference(protocolClassEClass, PROTOCOL_CLASS__SEMANTICS);

    compoundProtocolClassEClass = createEClass(COMPOUND_PROTOCOL_CLASS);
    createEReference(compoundProtocolClassEClass, COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS);

    subProtocolEClass = createEClass(SUB_PROTOCOL);
    createEAttribute(subProtocolEClass, SUB_PROTOCOL__NAME);
    createEReference(subProtocolEClass, SUB_PROTOCOL__PROTOCOL);

    messageEClass = createEClass(MESSAGE);
    createEAttribute(messageEClass, MESSAGE__PRIV);
    createEAttribute(messageEClass, MESSAGE__NAME);
    createEReference(messageEClass, MESSAGE__DATA);
    createEReference(messageEClass, MESSAGE__DOCU);

    portClassEClass = createEClass(PORT_CLASS);
    createEReference(portClassEClass, PORT_CLASS__USER_CODE);
    createEReference(portClassEClass, PORT_CLASS__ATTRIBUTES);
    createEReference(portClassEClass, PORT_CLASS__OPERATIONS);
    createEReference(portClassEClass, PORT_CLASS__MSG_HANDLERS);

    messageHandlerEClass = createEClass(MESSAGE_HANDLER);
    createEReference(messageHandlerEClass, MESSAGE_HANDLER__MSG);
    createEReference(messageHandlerEClass, MESSAGE_HANDLER__DETAIL_CODE);

    inMessageHandlerEClass = createEClass(IN_MESSAGE_HANDLER);

    outMessageHandlerEClass = createEClass(OUT_MESSAGE_HANDLER);

    protocolSemanticsEClass = createEClass(PROTOCOL_SEMANTICS);
    createEReference(protocolSemanticsEClass, PROTOCOL_SEMANTICS__RULES);

    semanticsRuleEClass = createEClass(SEMANTICS_RULE);
    createEReference(semanticsRuleEClass, SEMANTICS_RULE__MSG);
    createEReference(semanticsRuleEClass, SEMANTICS_RULE__FOLLOW_UPS);

    inSemanticsRuleEClass = createEClass(IN_SEMANTICS_RULE);

    outSemanticsRuleEClass = createEClass(OUT_SEMANTICS_RULE);

    actorClassEClass = createEClass(ACTOR_CLASS);
    createEAttribute(actorClassEClass, ACTOR_CLASS__ABSTRACT);
    createEAttribute(actorClassEClass, ACTOR_CLASS__COMM_TYPE);
    createEReference(actorClassEClass, ACTOR_CLASS__BASE);
    createEReference(actorClassEClass, ACTOR_CLASS__INTERFACE_PORTS);
    createEReference(actorClassEClass, ACTOR_CLASS__STRUCTURE_DOCU);
    createEReference(actorClassEClass, ACTOR_CLASS__INTERNAL_PORTS);
    createEReference(actorClassEClass, ACTOR_CLASS__EXTERNAL_PORTS);
    createEReference(actorClassEClass, ACTOR_CLASS__SERVICE_IMPLEMENTATIONS);
    createEReference(actorClassEClass, ACTOR_CLASS__SERVICE_ACCESS_POINTS);
    createEReference(actorClassEClass, ACTOR_CLASS__ATTRIBUTES);
    createEReference(actorClassEClass, ACTOR_CLASS__BEHAVIOR_DOCU);
    createEReference(actorClassEClass, ACTOR_CLASS__BEHAVIOR_ANNOTATIONS);
    createEReference(actorClassEClass, ACTOR_CLASS__OPERATIONS);
    createEReference(actorClassEClass, ACTOR_CLASS__STATE_MACHINE);

    interfaceItemEClass = createEClass(INTERFACE_ITEM);
    createEAttribute(interfaceItemEClass, INTERFACE_ITEM__NAME);

    portEClass = createEClass(PORT);
    createEAttribute(portEClass, PORT__CONJUGATED);
    createEAttribute(portEClass, PORT__MULTIPLICITY);
    createEReference(portEClass, PORT__PROTOCOL);
    createEReference(portEClass, PORT__DOCU);

    externalPortEClass = createEClass(EXTERNAL_PORT);
    createEReference(externalPortEClass, EXTERNAL_PORT__INTERFACE_PORT);

    sapEClass = createEClass(SAP);
    createEReference(sapEClass, SAP__PROTOCOL);

    sppEClass = createEClass(SPP);
    createEReference(sppEClass, SPP__PROTOCOL);

    serviceImplementationEClass = createEClass(SERVICE_IMPLEMENTATION);
    createEReference(serviceImplementationEClass, SERVICE_IMPLEMENTATION__SPP);

    logicalSystemEClass = createEClass(LOGICAL_SYSTEM);
    createEReference(logicalSystemEClass, LOGICAL_SYSTEM__SUB_SYSTEMS);

    actorContainerRefEClass = createEClass(ACTOR_CONTAINER_REF);
    createEAttribute(actorContainerRefEClass, ACTOR_CONTAINER_REF__NAME);
    createEReference(actorContainerRefEClass, ACTOR_CONTAINER_REF__DOCU);

    subSystemRefEClass = createEClass(SUB_SYSTEM_REF);
    createEReference(subSystemRefEClass, SUB_SYSTEM_REF__TYPE);

    subSystemClassEClass = createEClass(SUB_SYSTEM_CLASS);
    createEReference(subSystemClassEClass, SUB_SYSTEM_CLASS__RELAY_PORTS);
    createEReference(subSystemClassEClass, SUB_SYSTEM_CLASS__THREADS);
    createEReference(subSystemClassEClass, SUB_SYSTEM_CLASS__ACTOR_INSTANCE_MAPPINGS);

    logicalThreadEClass = createEClass(LOGICAL_THREAD);
    createEAttribute(logicalThreadEClass, LOGICAL_THREAD__NAME);

    actorInstanceMappingEClass = createEClass(ACTOR_INSTANCE_MAPPING);
    createEReference(actorInstanceMappingEClass, ACTOR_INSTANCE_MAPPING__PATH);
    createEReference(actorInstanceMappingEClass, ACTOR_INSTANCE_MAPPING__THREAD);
    createEReference(actorInstanceMappingEClass, ACTOR_INSTANCE_MAPPING__ACTOR_INSTANCE_MAPPINGS);

    refPathEClass = createEClass(REF_PATH);
    createEReference(refPathEClass, REF_PATH__REFS);

    refSegmentEClass = createEClass(REF_SEGMENT);
    createEAttribute(refSegmentEClass, REF_SEGMENT__REF);
    createEAttribute(refSegmentEClass, REF_SEGMENT__IDX);

    bindingEClass = createEClass(BINDING);
    createEReference(bindingEClass, BINDING__ENDPOINT1);
    createEReference(bindingEClass, BINDING__ENDPOINT2);

    bindingEndPointEClass = createEClass(BINDING_END_POINT);
    createEReference(bindingEndPointEClass, BINDING_END_POINT__ACTOR_REF);
    createEReference(bindingEndPointEClass, BINDING_END_POINT__PORT);
    createEReference(bindingEndPointEClass, BINDING_END_POINT__SUB);

    layerConnectionEClass = createEClass(LAYER_CONNECTION);
    createEReference(layerConnectionEClass, LAYER_CONNECTION__FROM);
    createEReference(layerConnectionEClass, LAYER_CONNECTION__TO);

    saPointEClass = createEClass(SA_POINT);

    refSAPointEClass = createEClass(REF_SA_POINT);
    createEReference(refSAPointEClass, REF_SA_POINT__REF);

    relaySAPointEClass = createEClass(RELAY_SA_POINT);
    createEReference(relaySAPointEClass, RELAY_SA_POINT__RELAY);

    spPointEClass = createEClass(SP_POINT);
    createEReference(spPointEClass, SP_POINT__REF);
    createEReference(spPointEClass, SP_POINT__SERVICE);

    actorRefEClass = createEClass(ACTOR_REF);
    createEAttribute(actorRefEClass, ACTOR_REF__REF_TYPE);
    createEAttribute(actorRefEClass, ACTOR_REF__MULTIPLICITY);
    createEReference(actorRefEClass, ACTOR_REF__TYPE);

    stateGraphNodeEClass = createEClass(STATE_GRAPH_NODE);

    stateGraphItemEClass = createEClass(STATE_GRAPH_ITEM);

    stateEClass = createEClass(STATE);
    createEReference(stateEClass, STATE__DOCU);
    createEReference(stateEClass, STATE__ENTRY_CODE);
    createEReference(stateEClass, STATE__EXIT_CODE);
    createEReference(stateEClass, STATE__DO_CODE);
    createEReference(stateEClass, STATE__SUBGRAPH);

    stateGraphEClass = createEClass(STATE_GRAPH);
    createEReference(stateGraphEClass, STATE_GRAPH__STATES);
    createEReference(stateGraphEClass, STATE_GRAPH__TR_POINTS);
    createEReference(stateGraphEClass, STATE_GRAPH__CH_POINTS);
    createEReference(stateGraphEClass, STATE_GRAPH__TRANSITIONS);
    createEReference(stateGraphEClass, STATE_GRAPH__REFINED_TRANSITIONS);

    simpleStateEClass = createEClass(SIMPLE_STATE);
    createEAttribute(simpleStateEClass, SIMPLE_STATE__NAME);

    refinedStateEClass = createEClass(REFINED_STATE);
    createEReference(refinedStateEClass, REFINED_STATE__TARGET);

    detailCodeEClass = createEClass(DETAIL_CODE);
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

    transitionEClass = createEClass(TRANSITION);
    createEAttribute(transitionEClass, TRANSITION__NAME);
    createEReference(transitionEClass, TRANSITION__TO);
    createEReference(transitionEClass, TRANSITION__DOCU);
    createEReference(transitionEClass, TRANSITION__ACTION);

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
    createEReference(refinedTransitionEClass, REFINED_TRANSITION__DOCU);
    createEReference(refinedTransitionEClass, REFINED_TRANSITION__ACTION);

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

    guardEClass = createEClass(GUARD);
    createEReference(guardEClass, GUARD__GUARD);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);
    createEAttribute(importEClass, IMPORT__IMPORT_URI);

    // Create enums
    communicationTypeEEnum = createEEnum(COMMUNICATION_TYPE);
    actorCommunicationTypeEEnum = createEEnum(ACTOR_COMMUNICATION_TYPE);
    referenceTypeEEnum = createEEnum(REFERENCE_TYPE);
    roomAnnotationTargetEnumEEnum = createEEnum(ROOM_ANNOTATION_TARGET_ENUM);
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
    structureClassEClass.getESuperTypes().add(this.getRoomClass());
    actorContainerClassEClass.getESuperTypes().add(this.getStructureClass());
    dataTypeEClass.getESuperTypes().add(this.getRoomClass());
    complexTypeEClass.getESuperTypes().add(this.getDataType());
    primitiveTypeEClass.getESuperTypes().add(this.getDataType());
    enumerationTypeEClass.getESuperTypes().add(this.getDataType());
    externalTypeEClass.getESuperTypes().add(this.getComplexType());
    dataClassEClass.getESuperTypes().add(this.getComplexType());
    standardOperationEClass.getESuperTypes().add(this.getOperation());
    portOperationEClass.getESuperTypes().add(this.getOperation());
    generalProtocolClassEClass.getESuperTypes().add(this.getRoomClass());
    protocolClassEClass.getESuperTypes().add(this.getGeneralProtocolClass());
    compoundProtocolClassEClass.getESuperTypes().add(this.getGeneralProtocolClass());
    inMessageHandlerEClass.getESuperTypes().add(this.getMessageHandler());
    outMessageHandlerEClass.getESuperTypes().add(this.getMessageHandler());
    inSemanticsRuleEClass.getESuperTypes().add(this.getSemanticsRule());
    outSemanticsRuleEClass.getESuperTypes().add(this.getSemanticsRule());
    actorClassEClass.getESuperTypes().add(this.getActorContainerClass());
    portEClass.getESuperTypes().add(this.getInterfaceItem());
    sapEClass.getESuperTypes().add(this.getInterfaceItem());
    sppEClass.getESuperTypes().add(this.getInterfaceItem());
    logicalSystemEClass.getESuperTypes().add(this.getStructureClass());
    subSystemRefEClass.getESuperTypes().add(this.getActorContainerRef());
    subSystemClassEClass.getESuperTypes().add(this.getActorContainerClass());
    refSAPointEClass.getESuperTypes().add(this.getSAPoint());
    relaySAPointEClass.getESuperTypes().add(this.getSAPoint());
    actorRefEClass.getESuperTypes().add(this.getActorContainerRef());
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
    nonInitialTransitionEClass.getESuperTypes().add(this.getTransition());
    transitionChainStartTransitionEClass.getESuperTypes().add(this.getNonInitialTransition());
    initialTransitionEClass.getESuperTypes().add(this.getTransition());
    continuationTransitionEClass.getESuperTypes().add(this.getNonInitialTransition());
    triggeredTransitionEClass.getESuperTypes().add(this.getTransitionChainStartTransition());
    guardedTransitionEClass.getESuperTypes().add(this.getTransitionChainStartTransition());
    cpBranchTransitionEClass.getESuperTypes().add(this.getNonInitialTransition());
    stateTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    trPointTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    subStateTrPointTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());
    choicepointTerminalEClass.getESuperTypes().add(this.getTransitionTerminal());

    // Initialize classes and features; add operations and parameters
    initEClass(roomModelEClass, RoomModel.class, "RoomModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRoomModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_Imports(), this.getImport(), null, "imports", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_PrimitiveTypes(), this.getPrimitiveType(), null, "primitiveTypes", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_EnumerationTypes(), this.getEnumerationType(), null, "enumerationTypes", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_ExternalTypes(), this.getExternalType(), null, "externalTypes", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_DataClasses(), this.getDataClass(), null, "dataClasses", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_ProtocolClasses(), this.getGeneralProtocolClass(), null, "protocolClasses", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_ActorClasses(), this.getActorClass(), null, "actorClasses", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_SubSystemClasses(), this.getSubSystemClass(), null, "subSystemClasses", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_Systems(), this.getLogicalSystem(), null, "systems", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_AnnotationTypes(), theBasePackage.getAnnotationType(), null, "annotationTypes", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roomClassEClass, RoomClass.class, "RoomClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRoomClass_Name(), ecorePackage.getEString(), "name", null, 0, 1, RoomClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomClass_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, RoomClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structureClassEClass, StructureClass.class, "StructureClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStructureClass_Annotations(), theBasePackage.getAnnotation(), null, "annotations", null, 0, -1, StructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStructureClass_Bindings(), this.getBinding(), null, "bindings", null, 0, -1, StructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStructureClass_Connections(), this.getLayerConnection(), null, "connections", null, 0, -1, StructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actorContainerClassEClass, ActorContainerClass.class, "ActorContainerClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActorContainerClass_ServiceProvisionPoints(), this.getSPP(), null, "serviceProvisionPoints", null, 0, -1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorContainerClass_UserCode1(), this.getDetailCode(), null, "userCode1", null, 0, 1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorContainerClass_UserCode2(), this.getDetailCode(), null, "userCode2", null, 0, 1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorContainerClass_UserCode3(), this.getDetailCode(), null, "userCode3", null, 0, 1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorContainerClass_ActorRefs(), this.getActorRef(), null, "actorRefs", null, 0, -1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varDeclEClass, VarDecl.class, "VarDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVarDecl_Name(), ecorePackage.getEString(), "name", null, 0, 1, VarDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVarDecl_RefType(), this.getRefableType(), null, "refType", null, 0, 1, VarDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refableTypeEClass, RefableType.class, "RefableType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefableType_Type(), this.getDataType(), null, "type", null, 0, 1, RefableType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRefableType_Ref(), ecorePackage.getEBoolean(), "ref", null, 0, 1, RefableType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(complexTypeEClass, ComplexType.class, "ComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPrimitiveType_Type(), theBasePackage.getLiteralType(), "type", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPrimitiveType_TargetName(), ecorePackage.getEString(), "targetName", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPrimitiveType_CastName(), ecorePackage.getEString(), "castName", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPrimitiveType_DefaultValueLiteral(), ecorePackage.getEString(), "defaultValueLiteral", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumerationTypeEClass, EnumerationType.class, "EnumerationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumerationType_PrimitiveType(), this.getPrimitiveType(), null, "primitiveType", null, 0, 1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumerationType_Literals(), this.getEnumLiteral(), null, "literals", null, 0, -1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumLiteralEClass, EnumLiteral.class, "EnumLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumLiteral_Name(), ecorePackage.getEString(), "name", null, 0, 1, EnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumLiteral_Literal(), theBasePackage.getIntLiteral(), null, "literal", null, 0, 1, EnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(enumLiteralEClass, ecorePackage.getELong(), "getLiteralValue", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(externalTypeEClass, ExternalType.class, "ExternalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExternalType_TargetName(), ecorePackage.getEString(), "targetName", null, 0, 1, ExternalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExternalType_DefaultValueLiteral(), ecorePackage.getEString(), "defaultValueLiteral", null, 0, 1, ExternalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataClassEClass, DataClass.class, "DataClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDataClass_Base(), this.getDataClass(), null, "base", null, 0, 1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Annotations(), theBasePackage.getAnnotation(), null, "annotations", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_UserCode1(), this.getDetailCode(), null, "userCode1", null, 0, 1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_UserCode2(), this.getDetailCode(), null, "userCode2", null, 0, 1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_UserCode3(), this.getDetailCode(), null, "userCode3", null, 0, 1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Operations(), this.getStandardOperation(), null, "operations", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribute_Size(), ecorePackage.getEInt(), "size", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttribute_Type(), this.getRefableType(), null, "type", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribute_DefaultValueLiteral(), ecorePackage.getEString(), "defaultValueLiteral", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttribute_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOperation_Name(), ecorePackage.getEString(), "name", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_Arguments(), this.getVarDecl(), null, "arguments", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_ReturnType(), this.getRefableType(), null, "returnType", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_DetailCode(), this.getDetailCode(), null, "detailCode", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(standardOperationEClass, StandardOperation.class, "StandardOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStandardOperation_Destructor(), ecorePackage.getEBoolean(), "destructor", null, 0, 1, StandardOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(portOperationEClass, PortOperation.class, "PortOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPortOperation_SendsMsg(), this.getMessage(), null, "sendsMsg", null, 0, 1, PortOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(generalProtocolClassEClass, GeneralProtocolClass.class, "GeneralProtocolClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGeneralProtocolClass_Annotations(), theBasePackage.getAnnotation(), null, "annotations", null, 0, -1, GeneralProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(protocolClassEClass, ProtocolClass.class, "ProtocolClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProtocolClass_CommType(), this.getCommunicationType(), "commType", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Base(), this.getProtocolClass(), null, "base", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_UserCode1(), this.getDetailCode(), null, "userCode1", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_UserCode2(), this.getDetailCode(), null, "userCode2", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_UserCode3(), this.getDetailCode(), null, "userCode3", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_IncomingMessages(), this.getMessage(), null, "incomingMessages", null, 0, -1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_OutgoingMessages(), this.getMessage(), null, "outgoingMessages", null, 0, -1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Regular(), this.getPortClass(), null, "regular", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Conjugated(), this.getPortClass(), null, "conjugated", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Semantics(), this.getProtocolSemantics(), null, "semantics", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compoundProtocolClassEClass, CompoundProtocolClass.class, "CompoundProtocolClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCompoundProtocolClass_SubProtocols(), this.getSubProtocol(), null, "subProtocols", null, 0, -1, CompoundProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subProtocolEClass, SubProtocol.class, "SubProtocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSubProtocol_Name(), ecorePackage.getEString(), "name", null, 0, 1, SubProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubProtocol_Protocol(), this.getGeneralProtocolClass(), null, "protocol", null, 0, 1, SubProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMessage_Priv(), ecorePackage.getEBoolean(), "priv", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMessage_Name(), ecorePackage.getEString(), "name", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessage_Data(), this.getVarDecl(), null, "data", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessage_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(portClassEClass, PortClass.class, "PortClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPortClass_UserCode(), this.getDetailCode(), null, "userCode", null, 0, 1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortClass_Operations(), this.getPortOperation(), null, "operations", null, 0, -1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortClass_MsgHandlers(), this.getMessageHandler(), null, "msgHandlers", null, 0, -1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageHandlerEClass, MessageHandler.class, "MessageHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMessageHandler_Msg(), this.getMessage(), null, "msg", null, 0, 1, MessageHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessageHandler_DetailCode(), this.getDetailCode(), null, "detailCode", null, 0, 1, MessageHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inMessageHandlerEClass, InMessageHandler.class, "InMessageHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(outMessageHandlerEClass, OutMessageHandler.class, "OutMessageHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(protocolSemanticsEClass, ProtocolSemantics.class, "ProtocolSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProtocolSemantics_Rules(), this.getSemanticsRule(), null, "rules", null, 0, -1, ProtocolSemantics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(semanticsRuleEClass, SemanticsRule.class, "SemanticsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSemanticsRule_Msg(), this.getMessage(), null, "msg", null, 0, 1, SemanticsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSemanticsRule_FollowUps(), this.getSemanticsRule(), null, "followUps", null, 0, -1, SemanticsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inSemanticsRuleEClass, InSemanticsRule.class, "InSemanticsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(outSemanticsRuleEClass, OutSemanticsRule.class, "OutSemanticsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(actorClassEClass, ActorClass.class, "ActorClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getActorClass_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getActorClass_CommType(), this.getActorCommunicationType(), "commType", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_Base(), this.getActorClass(), null, "base", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_InterfacePorts(), this.getPort(), null, "interfacePorts", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_StructureDocu(), theBasePackage.getDocumentation(), null, "structureDocu", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_InternalPorts(), this.getPort(), null, "internalPorts", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_ExternalPorts(), this.getExternalPort(), null, "externalPorts", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_ServiceImplementations(), this.getServiceImplementation(), null, "serviceImplementations", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_ServiceAccessPoints(), this.getSAP(), null, "serviceAccessPoints", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_BehaviorDocu(), theBasePackage.getDocumentation(), null, "behaviorDocu", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_BehaviorAnnotations(), theBasePackage.getAnnotation(), null, "behaviorAnnotations", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_Operations(), this.getStandardOperation(), null, "operations", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_StateMachine(), this.getStateGraph(), null, "stateMachine", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(actorClassEClass, this.getPort(), "getExternalEndPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(actorClassEClass, this.getPort(), "getRelayPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(actorClassEClass, this.getSPP(), "getImplementedSPPs", 0, -1, IS_UNIQUE, IS_ORDERED);

    initEClass(interfaceItemEClass, InterfaceItem.class, "InterfaceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInterfaceItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, InterfaceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(interfaceItemEClass, this.getGeneralProtocolClass(), "getGeneralProtocol", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPort_Conjugated(), ecorePackage.getEBoolean(), "conjugated", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPort_Multiplicity(), ecorePackage.getEInt(), "multiplicity", "1", 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPort_Protocol(), this.getGeneralProtocolClass(), null, "protocol", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPort_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(portEClass, ecorePackage.getEBoolean(), "isReplicated", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(externalPortEClass, ExternalPort.class, "ExternalPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExternalPort_InterfacePort(), this.getPort(), null, "interfacePort", null, 0, 1, ExternalPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sapEClass, org.eclipse.etrice.core.room.SAP.class, "SAP", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSAP_Protocol(), this.getProtocolClass(), null, "protocol", null, 0, 1, org.eclipse.etrice.core.room.SAP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sppEClass, org.eclipse.etrice.core.room.SPP.class, "SPP", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSPP_Protocol(), this.getProtocolClass(), null, "protocol", null, 0, 1, org.eclipse.etrice.core.room.SPP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(serviceImplementationEClass, ServiceImplementation.class, "ServiceImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getServiceImplementation_Spp(), this.getSPP(), null, "spp", null, 0, 1, ServiceImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalSystemEClass, LogicalSystem.class, "LogicalSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalSystem_SubSystems(), this.getSubSystemRef(), null, "subSystems", null, 0, -1, LogicalSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actorContainerRefEClass, ActorContainerRef.class, "ActorContainerRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getActorContainerRef_Name(), ecorePackage.getEString(), "name", null, 0, 1, ActorContainerRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorContainerRef_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, ActorContainerRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(actorContainerRefEClass, this.getStructureClass(), "getStructureClass", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(subSystemRefEClass, SubSystemRef.class, "SubSystemRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubSystemRef_Type(), this.getSubSystemClass(), null, "type", null, 0, 1, SubSystemRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subSystemClassEClass, SubSystemClass.class, "SubSystemClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubSystemClass_RelayPorts(), this.getPort(), null, "relayPorts", null, 0, -1, SubSystemClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubSystemClass_Threads(), this.getLogicalThread(), null, "threads", null, 0, -1, SubSystemClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubSystemClass_ActorInstanceMappings(), this.getActorInstanceMapping(), null, "actorInstanceMappings", null, 0, -1, SubSystemClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalThreadEClass, LogicalThread.class, "LogicalThread", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLogicalThread_Name(), ecorePackage.getEString(), "name", null, 0, 1, LogicalThread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actorInstanceMappingEClass, ActorInstanceMapping.class, "ActorInstanceMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActorInstanceMapping_Path(), this.getRefPath(), null, "path", null, 0, 1, ActorInstanceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorInstanceMapping_Thread(), this.getLogicalThread(), null, "thread", null, 0, 1, ActorInstanceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorInstanceMapping_ActorInstanceMappings(), this.getActorInstanceMapping(), null, "actorInstanceMappings", null, 0, -1, ActorInstanceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refPathEClass, RefPath.class, "RefPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefPath_Refs(), this.getRefSegment(), null, "refs", null, 0, -1, RefPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(refPathEClass, ecorePackage.getEString(), "toString", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(refSegmentEClass, RefSegment.class, "RefSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRefSegment_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, RefSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRefSegment_Idx(), ecorePackage.getEInt(), "idx", "-1", 0, 1, RefSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(refSegmentEClass, ecorePackage.getEString(), "toString", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(bindingEClass, Binding.class, "Binding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinding_Endpoint1(), this.getBindingEndPoint(), null, "endpoint1", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinding_Endpoint2(), this.getBindingEndPoint(), null, "endpoint2", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bindingEndPointEClass, BindingEndPoint.class, "BindingEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBindingEndPoint_ActorRef(), this.getActorContainerRef(), null, "actorRef", null, 0, 1, BindingEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBindingEndPoint_Port(), this.getPort(), null, "port", null, 0, 1, BindingEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBindingEndPoint_Sub(), this.getSubProtocol(), null, "sub", null, 0, 1, BindingEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(layerConnectionEClass, LayerConnection.class, "LayerConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLayerConnection_From(), this.getSAPoint(), null, "from", null, 0, 1, LayerConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLayerConnection_To(), this.getSPPoint(), null, "to", null, 0, 1, LayerConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(saPointEClass, SAPoint.class, "SAPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(refSAPointEClass, RefSAPoint.class, "RefSAPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefSAPoint_Ref(), this.getActorContainerRef(), null, "ref", null, 0, 1, RefSAPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relaySAPointEClass, RelaySAPoint.class, "RelaySAPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelaySAPoint_Relay(), this.getSPP(), null, "relay", null, 0, 1, RelaySAPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(spPointEClass, SPPoint.class, "SPPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSPPoint_Ref(), this.getActorContainerRef(), null, "ref", null, 0, 1, SPPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSPPoint_Service(), this.getSPP(), null, "service", null, 0, 1, SPPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actorRefEClass, ActorRef.class, "ActorRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getActorRef_RefType(), this.getReferenceType(), "refType", null, 0, 1, ActorRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getActorRef_Multiplicity(), ecorePackage.getEInt(), "multiplicity", "1", 0, 1, ActorRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorRef_Type(), this.getActorClass(), null, "type", null, 0, 1, ActorRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateGraphNodeEClass, StateGraphNode.class, "StateGraphNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stateGraphItemEClass, StateGraphItem.class, "StateGraphItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    addEOperation(stateGraphItemEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getState_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_EntryCode(), this.getDetailCode(), null, "entryCode", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_ExitCode(), this.getDetailCode(), null, "exitCode", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_DoCode(), this.getDetailCode(), null, "doCode", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_Subgraph(), this.getStateGraph(), null, "subgraph", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(stateEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(stateGraphEClass, StateGraph.class, "StateGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateGraph_States(), this.getState(), null, "states", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_TrPoints(), this.getTrPoint(), null, "trPoints", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_ChPoints(), this.getChoicePoint(), null, "chPoints", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_Transitions(), this.getTransition(), null, "transitions", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStateGraph_RefinedTransitions(), this.getRefinedTransition(), null, "refinedTransitions", null, 0, -1, StateGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleStateEClass, SimpleState.class, "SimpleState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleState_Name(), ecorePackage.getEString(), "name", null, 0, 1, SimpleState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refinedStateEClass, RefinedState.class, "RefinedState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefinedState_Target(), this.getState(), null, "target", null, 0, 1, RefinedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(detailCodeEClass, DetailCode.class, "DetailCode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
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

    initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_To(), this.getTransitionTerminal(), null, "to", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_Action(), this.getDetailCode(), null, "action", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
    initEReference(getRefinedTransition_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, RefinedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRefinedTransition_Action(), this.getDetailCode(), null, "action", null, 0, 1, RefinedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
    initEReference(getMessageFromIf_Message(), this.getMessage(), null, "message", null, 0, 1, MessageFromIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessageFromIf_From(), this.getInterfaceItem(), null, "from", null, 0, 1, MessageFromIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGuard_Guard(), this.getDetailCode(), null, "guard", null, 0, 1, Guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getImport_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(communicationTypeEEnum, CommunicationType.class, "CommunicationType");
    addEEnumLiteral(communicationTypeEEnum, CommunicationType.EVENT_DRIVEN);
    addEEnumLiteral(communicationTypeEEnum, CommunicationType.DATA_DRIVEN);
    addEEnumLiteral(communicationTypeEEnum, CommunicationType.SYNCHRONOUS);

    initEEnum(actorCommunicationTypeEEnum, ActorCommunicationType.class, "ActorCommunicationType");
    addEEnumLiteral(actorCommunicationTypeEEnum, ActorCommunicationType.EVENT_DRIVEN);
    addEEnumLiteral(actorCommunicationTypeEEnum, ActorCommunicationType.DATA_DRIVEN);
    addEEnumLiteral(actorCommunicationTypeEEnum, ActorCommunicationType.ASYNCHRONOUS);
    addEEnumLiteral(actorCommunicationTypeEEnum, ActorCommunicationType.SYNCHRONOUS);

    initEEnum(referenceTypeEEnum, ReferenceType.class, "ReferenceType");
    addEEnumLiteral(referenceTypeEEnum, ReferenceType.FIXED);
    addEEnumLiteral(referenceTypeEEnum, ReferenceType.OPTIONAL);

    initEEnum(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.class, "RoomAnnotationTargetEnum");
    addEEnumLiteral(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.DATA_CLASS);
    addEEnumLiteral(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.ACTOR_CLASS);
    addEEnumLiteral(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.ACTOR_BEHAVIOR);
    addEEnumLiteral(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.PROTOCOL_CLASS);
    addEEnumLiteral(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.COMPOUND_PROTOCOL_CLASS);
    addEEnumLiteral(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.SUBSYSTEM_CLASS);
    addEEnumLiteral(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.LOGICAL_SYSTEM_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //RoomPackageImpl
