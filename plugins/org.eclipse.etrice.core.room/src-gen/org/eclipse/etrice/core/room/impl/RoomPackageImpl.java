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

import org.eclipse.etrice.core.fsm.fSM.FSMPackage;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.ClassStructor;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.ComplexType;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InMessageHandler;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.OutMessageHandler;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RefSegment;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomAnnotationTargetEnum;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubProtocol;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
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
  private EClass classStructorEClass = null;

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
  private EEnum communicationTypeEEnum = null;

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
    FSMPackage.eINSTANCE.eClass();

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
  public EReference getStructureClass_Connections()
  {
    return (EReference)structureClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructureClass_Bindings()
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
  public EReference getDataClass_Operations()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Structors()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataClass_Attributes()
  {
    return (EReference)dataClassEClass.getEStructuralFeatures().get(7);
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
  public EAttribute getStandardOperation_Override()
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
  public EClass getClassStructor()
  {
    return classStructorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassStructor_Name()
  {
    return (EAttribute)classStructorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassStructor_DetailCode()
  {
    return (EReference)classStructorEClass.getEStructuralFeatures().get(1);
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
  public EReference getMessage_Annotations()
  {
    return (EReference)messageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessage_Docu()
  {
    return (EReference)messageEClass.getEStructuralFeatures().get(4);
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
  public EReference getPortClass_MsgHandlers()
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
  public EReference getPortClass_Attributes()
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
  public EClass getActorClass()
  {
    return actorClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_InterfacePorts()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_StructureDocu()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_ServiceImplementations()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_Attributes()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_ServiceAccessPoints()
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
  public EReference getActorClass_BehaviorDocu()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_BehaviorAnnotations()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_Operations()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActorClass_Structors()
  {
    return (EReference)actorClassEClass.getEStructuralFeatures().get(10);
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
  public EReference getPort_Annotations()
  {
    return (EReference)portEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPort_Docu()
  {
    return (EReference)portEClass.getEStructuralFeatures().get(4);
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
  public EReference getSubSystemClass_ActorInstanceMappings()
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
  public EReference getSubSystemClass_RelayPorts()
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
  public EEnum getCommunicationType()
  {
    return communicationTypeEEnum;
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
    createEReference(structureClassEClass, STRUCTURE_CLASS__CONNECTIONS);
    createEReference(structureClassEClass, STRUCTURE_CLASS__BINDINGS);

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
    createEReference(dataClassEClass, DATA_CLASS__OPERATIONS);
    createEReference(dataClassEClass, DATA_CLASS__STRUCTORS);
    createEReference(dataClassEClass, DATA_CLASS__ATTRIBUTES);

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
    createEAttribute(standardOperationEClass, STANDARD_OPERATION__OVERRIDE);

    portOperationEClass = createEClass(PORT_OPERATION);
    createEReference(portOperationEClass, PORT_OPERATION__SENDS_MSG);

    classStructorEClass = createEClass(CLASS_STRUCTOR);
    createEAttribute(classStructorEClass, CLASS_STRUCTOR__NAME);
    createEReference(classStructorEClass, CLASS_STRUCTOR__DETAIL_CODE);

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
    createEReference(messageEClass, MESSAGE__ANNOTATIONS);
    createEReference(messageEClass, MESSAGE__DOCU);

    portClassEClass = createEClass(PORT_CLASS);
    createEReference(portClassEClass, PORT_CLASS__USER_CODE);
    createEReference(portClassEClass, PORT_CLASS__MSG_HANDLERS);
    createEReference(portClassEClass, PORT_CLASS__OPERATIONS);
    createEReference(portClassEClass, PORT_CLASS__ATTRIBUTES);

    messageHandlerEClass = createEClass(MESSAGE_HANDLER);
    createEReference(messageHandlerEClass, MESSAGE_HANDLER__MSG);
    createEReference(messageHandlerEClass, MESSAGE_HANDLER__DETAIL_CODE);

    inMessageHandlerEClass = createEClass(IN_MESSAGE_HANDLER);

    outMessageHandlerEClass = createEClass(OUT_MESSAGE_HANDLER);

    actorClassEClass = createEClass(ACTOR_CLASS);
    createEReference(actorClassEClass, ACTOR_CLASS__INTERFACE_PORTS);
    createEReference(actorClassEClass, ACTOR_CLASS__STRUCTURE_DOCU);
    createEReference(actorClassEClass, ACTOR_CLASS__SERVICE_IMPLEMENTATIONS);
    createEReference(actorClassEClass, ACTOR_CLASS__ATTRIBUTES);
    createEReference(actorClassEClass, ACTOR_CLASS__SERVICE_ACCESS_POINTS);
    createEReference(actorClassEClass, ACTOR_CLASS__INTERNAL_PORTS);
    createEReference(actorClassEClass, ACTOR_CLASS__EXTERNAL_PORTS);
    createEReference(actorClassEClass, ACTOR_CLASS__BEHAVIOR_DOCU);
    createEReference(actorClassEClass, ACTOR_CLASS__BEHAVIOR_ANNOTATIONS);
    createEReference(actorClassEClass, ACTOR_CLASS__OPERATIONS);
    createEReference(actorClassEClass, ACTOR_CLASS__STRUCTORS);

    interfaceItemEClass = createEClass(INTERFACE_ITEM);

    portEClass = createEClass(PORT);
    createEAttribute(portEClass, PORT__CONJUGATED);
    createEAttribute(portEClass, PORT__MULTIPLICITY);
    createEReference(portEClass, PORT__PROTOCOL);
    createEReference(portEClass, PORT__ANNOTATIONS);
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
    createEReference(subSystemClassEClass, SUB_SYSTEM_CLASS__ACTOR_INSTANCE_MAPPINGS);
    createEReference(subSystemClassEClass, SUB_SYSTEM_CLASS__THREADS);
    createEReference(subSystemClassEClass, SUB_SYSTEM_CLASS__RELAY_PORTS);

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

    // Create enums
    communicationTypeEEnum = createEEnum(COMMUNICATION_TYPE);
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
    FSMPackage theFSMPackage = (FSMPackage)EPackage.Registry.INSTANCE.getEPackage(FSMPackage.eNS_URI);

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
    actorClassEClass.getESuperTypes().add(this.getActorContainerClass());
    actorClassEClass.getESuperTypes().add(theFSMPackage.getModelComponent());
    interfaceItemEClass.getESuperTypes().add(theFSMPackage.getAbstractInterfaceItem());
    portEClass.getESuperTypes().add(this.getInterfaceItem());
    sapEClass.getESuperTypes().add(this.getInterfaceItem());
    sppEClass.getESuperTypes().add(this.getInterfaceItem());
    logicalSystemEClass.getESuperTypes().add(this.getStructureClass());
    subSystemRefEClass.getESuperTypes().add(this.getActorContainerRef());
    subSystemClassEClass.getESuperTypes().add(this.getActorContainerClass());
    refSAPointEClass.getESuperTypes().add(this.getSAPoint());
    relaySAPointEClass.getESuperTypes().add(this.getSAPoint());
    actorRefEClass.getESuperTypes().add(this.getActorContainerRef());

    // Initialize classes and features; add operations and parameters
    initEClass(roomModelEClass, RoomModel.class, "RoomModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRoomModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoomModel_Imports(), theBasePackage.getImport(), null, "imports", null, 0, -1, RoomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
    initEReference(getStructureClass_Connections(), this.getLayerConnection(), null, "connections", null, 0, -1, StructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStructureClass_Bindings(), this.getBinding(), null, "bindings", null, 0, -1, StructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actorContainerClassEClass, ActorContainerClass.class, "ActorContainerClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActorContainerClass_ServiceProvisionPoints(), this.getSPP(), null, "serviceProvisionPoints", null, 0, -1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorContainerClass_UserCode1(), theFSMPackage.getDetailCode(), null, "userCode1", null, 0, 1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorContainerClass_UserCode2(), theFSMPackage.getDetailCode(), null, "userCode2", null, 0, 1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorContainerClass_UserCode3(), theFSMPackage.getDetailCode(), null, "userCode3", null, 0, 1, ActorContainerClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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

    addEOperation(enumLiteralEClass, ecorePackage.getEString(), "getFullName", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(externalTypeEClass, ExternalType.class, "ExternalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExternalType_TargetName(), ecorePackage.getEString(), "targetName", null, 0, 1, ExternalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExternalType_DefaultValueLiteral(), ecorePackage.getEString(), "defaultValueLiteral", null, 0, 1, ExternalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataClassEClass, DataClass.class, "DataClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDataClass_Base(), this.getDataClass(), null, "base", null, 0, 1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Annotations(), theBasePackage.getAnnotation(), null, "annotations", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_UserCode1(), theFSMPackage.getDetailCode(), null, "userCode1", null, 0, 1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_UserCode2(), theFSMPackage.getDetailCode(), null, "userCode2", null, 0, 1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_UserCode3(), theFSMPackage.getDetailCode(), null, "userCode3", null, 0, 1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Operations(), this.getStandardOperation(), null, "operations", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Structors(), this.getClassStructor(), null, "structors", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, DataClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
    initEReference(getOperation_DetailCode(), theFSMPackage.getDetailCode(), null, "detailCode", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(standardOperationEClass, StandardOperation.class, "StandardOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStandardOperation_Override(), ecorePackage.getEBoolean(), "override", null, 0, 1, StandardOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(portOperationEClass, PortOperation.class, "PortOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPortOperation_SendsMsg(), this.getMessage(), null, "sendsMsg", null, 0, 1, PortOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classStructorEClass, ClassStructor.class, "ClassStructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClassStructor_Name(), ecorePackage.getEString(), "name", null, 0, 1, ClassStructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassStructor_DetailCode(), theFSMPackage.getDetailCode(), null, "detailCode", null, 0, 1, ClassStructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(classStructorEClass, ecorePackage.getEBoolean(), "isConstructor", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(generalProtocolClassEClass, GeneralProtocolClass.class, "GeneralProtocolClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGeneralProtocolClass_Annotations(), theBasePackage.getAnnotation(), null, "annotations", null, 0, -1, GeneralProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(protocolClassEClass, ProtocolClass.class, "ProtocolClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProtocolClass_CommType(), this.getCommunicationType(), "commType", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Base(), this.getProtocolClass(), null, "base", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_UserCode1(), theFSMPackage.getDetailCode(), null, "userCode1", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_UserCode2(), theFSMPackage.getDetailCode(), null, "userCode2", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_UserCode3(), theFSMPackage.getDetailCode(), null, "userCode3", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_IncomingMessages(), this.getMessage(), null, "incomingMessages", null, 0, -1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_OutgoingMessages(), this.getMessage(), null, "outgoingMessages", null, 0, -1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Regular(), this.getPortClass(), null, "regular", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Conjugated(), this.getPortClass(), null, "conjugated", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProtocolClass_Semantics(), theFSMPackage.getProtocolSemantics(), null, "semantics", null, 0, 1, ProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compoundProtocolClassEClass, CompoundProtocolClass.class, "CompoundProtocolClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCompoundProtocolClass_SubProtocols(), this.getSubProtocol(), null, "subProtocols", null, 0, -1, CompoundProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subProtocolEClass, SubProtocol.class, "SubProtocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSubProtocol_Name(), ecorePackage.getEString(), "name", null, 0, 1, SubProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubProtocol_Protocol(), this.getGeneralProtocolClass(), null, "protocol", null, 0, 1, SubProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMessage_Priv(), ecorePackage.getEBoolean(), "priv", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMessage_Name(), ecorePackage.getEString(), "name", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessage_Data(), this.getVarDecl(), null, "data", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessage_Annotations(), theBasePackage.getAnnotation(), null, "annotations", null, 0, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessage_Docu(), theBasePackage.getDocumentation(), null, "docu", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(portClassEClass, PortClass.class, "PortClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPortClass_UserCode(), theFSMPackage.getDetailCode(), null, "userCode", null, 0, 1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortClass_MsgHandlers(), this.getMessageHandler(), null, "msgHandlers", null, 0, -1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortClass_Operations(), this.getPortOperation(), null, "operations", null, 0, -1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, PortClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageHandlerEClass, MessageHandler.class, "MessageHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMessageHandler_Msg(), this.getMessage(), null, "msg", null, 0, 1, MessageHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessageHandler_DetailCode(), theFSMPackage.getDetailCode(), null, "detailCode", null, 0, 1, MessageHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inMessageHandlerEClass, InMessageHandler.class, "InMessageHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(outMessageHandlerEClass, OutMessageHandler.class, "OutMessageHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(actorClassEClass, ActorClass.class, "ActorClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActorClass_InterfacePorts(), this.getPort(), null, "interfacePorts", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_StructureDocu(), theBasePackage.getDocumentation(), null, "structureDocu", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_ServiceImplementations(), this.getServiceImplementation(), null, "serviceImplementations", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_ServiceAccessPoints(), this.getSAP(), null, "serviceAccessPoints", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_InternalPorts(), this.getPort(), null, "internalPorts", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_ExternalPorts(), this.getExternalPort(), null, "externalPorts", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_BehaviorDocu(), theBasePackage.getDocumentation(), null, "behaviorDocu", null, 0, 1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_BehaviorAnnotations(), theBasePackage.getAnnotation(), null, "behaviorAnnotations", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_Operations(), this.getStandardOperation(), null, "operations", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActorClass_Structors(), this.getClassStructor(), null, "structors", null, 0, -1, ActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(actorClassEClass, this.getPort(), "getExternalEndPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(actorClassEClass, this.getPort(), "getRelayPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(actorClassEClass, this.getSPP(), "getImplementedSPPs", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(actorClassEClass, this.getActorClass(), "getActorBase", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(actorClassEClass, ecorePackage.getEString(), "getComponentName", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(actorClassEClass, theFSMPackage.getAbstractInterfaceItem(), "getAbstractInterfaceItems", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(actorClassEClass, theFSMPackage.getAbstractInterfaceItem(), "getAllAbstractInterfaceItems", 0, -1, IS_UNIQUE, IS_ORDERED);

    initEClass(interfaceItemEClass, InterfaceItem.class, "InterfaceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    addEOperation(interfaceItemEClass, this.getGeneralProtocolClass(), "getGeneralProtocol", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(interfaceItemEClass, theFSMPackage.getProtocolSemantics(), "getSemantics", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(interfaceItemEClass, ecorePackage.getEObject(), "getAllIncomingAbstractMessages", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(interfaceItemEClass, ecorePackage.getEObject(), "getAllOutgoingAbstractMessages", 0, -1, IS_UNIQUE, IS_ORDERED);

    addEOperation(interfaceItemEClass, ecorePackage.getEBoolean(), "isEventDriven", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPort_Conjugated(), ecorePackage.getEBoolean(), "conjugated", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPort_Multiplicity(), ecorePackage.getEInt(), "multiplicity", "1", 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPort_Protocol(), this.getGeneralProtocolClass(), null, "protocol", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPort_Annotations(), theBasePackage.getAnnotation(), null, "annotations", null, 0, -1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
    initEReference(getSubSystemClass_ActorInstanceMappings(), this.getActorInstanceMapping(), null, "actorInstanceMappings", null, 0, -1, SubSystemClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubSystemClass_Threads(), this.getLogicalThread(), null, "threads", null, 0, -1, SubSystemClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubSystemClass_RelayPorts(), this.getPort(), null, "relayPorts", null, 0, -1, SubSystemClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

    // Initialize enums and add enum literals
    initEEnum(communicationTypeEEnum, CommunicationType.class, "CommunicationType");
    addEEnumLiteral(communicationTypeEEnum, CommunicationType.EVENT_DRIVEN);
    addEEnumLiteral(communicationTypeEEnum, CommunicationType.DATA_DRIVEN);
    addEEnumLiteral(communicationTypeEEnum, CommunicationType.SYNCHRONOUS);

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
    addEEnumLiteral(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.PORT);
    addEEnumLiteral(roomAnnotationTargetEnumEEnum, RoomAnnotationTargetEnum.MESSAGE);

    // Create resource
    createResource(eNS_URI);
  }

} //RoomPackageImpl
