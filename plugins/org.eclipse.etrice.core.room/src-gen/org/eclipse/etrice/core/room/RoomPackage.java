/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.room.RoomFactory
 * @model kind="package"
 * @generated
 */
public interface RoomPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "room";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/etrice/Room";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "room";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RoomPackage eINSTANCE = org.eclipse.etrice.core.room.impl.RoomPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.RoomModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.RoomModelImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRoomModel()
   * @generated
   */
  int ROOM_MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__DOCU = 1;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__IMPORTS = 2;

  /**
   * The feature id for the '<em><b>Primitive Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__PRIMITIVE_TYPES = 3;

  /**
   * The feature id for the '<em><b>External Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__EXTERNAL_TYPES = 4;

  /**
   * The feature id for the '<em><b>Data Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__DATA_CLASSES = 5;

  /**
   * The feature id for the '<em><b>Protocol Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__PROTOCOL_CLASSES = 6;

  /**
   * The feature id for the '<em><b>Actor Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__ACTOR_CLASSES = 7;

  /**
   * The feature id for the '<em><b>Sub System Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__SUB_SYSTEM_CLASSES = 8;

  /**
   * The feature id for the '<em><b>Systems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__SYSTEMS = 9;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.RoomClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.RoomClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRoomClass()
   * @generated
   */
  int ROOM_CLASS = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_CLASS__NAME = 0;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_CLASS__DOCU = 1;

  /**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_CLASS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.StructureClassImpl <em>Structure Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.StructureClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStructureClass()
   * @generated
   */
  int STRUCTURE_CLASS = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_CLASS__NAME = ROOM_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_CLASS__DOCU = ROOM_CLASS__DOCU;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_CLASS__BINDINGS = ROOM_CLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Connections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_CLASS__CONNECTIONS = ROOM_CLASS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Structure Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_CLASS_FEATURE_COUNT = ROOM_CLASS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ActorContainerClassImpl <em>Actor Container Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ActorContainerClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorContainerClass()
   * @generated
   */
  int ACTOR_CONTAINER_CLASS = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__NAME = STRUCTURE_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__DOCU = STRUCTURE_CLASS__DOCU;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__BINDINGS = STRUCTURE_CLASS__BINDINGS;

  /**
   * The feature id for the '<em><b>Connections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__CONNECTIONS = STRUCTURE_CLASS__CONNECTIONS;

  /**
   * The feature id for the '<em><b>If SP Ps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__IF_SP_PS = STRUCTURE_CLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__USER_CODE1 = STRUCTURE_CLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__USER_CODE2 = STRUCTURE_CLASS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__USER_CODE3 = STRUCTURE_CLASS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Actor Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__ACTOR_REFS = STRUCTURE_CLASS_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Actor Container Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS_FEATURE_COUNT = STRUCTURE_CLASS_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.VarDeclImpl <em>Var Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.VarDeclImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getVarDecl()
   * @generated
   */
  int VAR_DECL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__NAME = 0;

  /**
   * The feature id for the '<em><b>Ref Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__REF_TYPE = 1;

  /**
   * The number of structural features of the '<em>Var Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.RefableTypeImpl <em>Refable Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.RefableTypeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefableType()
   * @generated
   */
  int REFABLE_TYPE = 5;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFABLE_TYPE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFABLE_TYPE__REF = 1;

  /**
   * The number of structural features of the '<em>Refable Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFABLE_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.DataTypeImpl <em>Data Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.DataTypeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getDataType()
   * @generated
   */
  int DATA_TYPE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__NAME = ROOM_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__DOCU = ROOM_CLASS__DOCU;

  /**
   * The number of structural features of the '<em>Data Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_FEATURE_COUNT = ROOM_CLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ComplexTypeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getComplexType()
   * @generated
   */
  int COMPLEX_TYPE = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_TYPE__NAME = DATA_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_TYPE__DOCU = DATA_TYPE__DOCU;

  /**
   * The number of structural features of the '<em>Complex Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.PrimitiveTypeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPrimitiveType()
   * @generated
   */
  int PRIMITIVE_TYPE = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__NAME = DATA_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__DOCU = DATA_TYPE__DOCU;

  /**
   * The feature id for the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__TARGET_NAME = DATA_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cast Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__CAST_NAME = DATA_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__DEFAULT_VALUE_LITERAL = DATA_TYPE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Primitive Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ExternalTypeImpl <em>External Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ExternalTypeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getExternalType()
   * @generated
   */
  int EXTERNAL_TYPE = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TYPE__NAME = COMPLEX_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TYPE__DOCU = COMPLEX_TYPE__DOCU;

  /**
   * The feature id for the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TYPE__TARGET_NAME = COMPLEX_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>External Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TYPE_FEATURE_COUNT = COMPLEX_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.DataClassImpl <em>Data Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.DataClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getDataClass()
   * @generated
   */
  int DATA_CLASS = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__NAME = COMPLEX_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__DOCU = COMPLEX_TYPE__DOCU;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__BASE = COMPLEX_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__USER_CODE1 = COMPLEX_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__USER_CODE2 = COMPLEX_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__USER_CODE3 = COMPLEX_TYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__ATTRIBUTES = COMPLEX_TYPE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__OPERATIONS = COMPLEX_TYPE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Data Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS_FEATURE_COUNT = COMPLEX_TYPE_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.AttributeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__SIZE = 1;

  /**
   * The feature id for the '<em><b>Ref Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__REF_TYPE = 2;

  /**
   * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__DEFAULT_VALUE_LITERAL = 3;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__DOCU = 4;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.OperationImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__ARGUMENTS = 1;

  /**
   * The feature id for the '<em><b>Returntype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__RETURNTYPE = 2;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__DOCU = 3;

  /**
   * The feature id for the '<em><b>Detail Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__DETAIL_CODE = 4;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.StandardOperationImpl <em>Standard Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.StandardOperationImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStandardOperation()
   * @generated
   */
  int STANDARD_OPERATION = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__NAME = OPERATION__NAME;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__ARGUMENTS = OPERATION__ARGUMENTS;

  /**
   * The feature id for the '<em><b>Returntype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__RETURNTYPE = OPERATION__RETURNTYPE;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__DOCU = OPERATION__DOCU;

  /**
   * The feature id for the '<em><b>Detail Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__DETAIL_CODE = OPERATION__DETAIL_CODE;

  /**
   * The number of structural features of the '<em>Standard Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.PortOperationImpl <em>Port Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.PortOperationImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPortOperation()
   * @generated
   */
  int PORT_OPERATION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_OPERATION__NAME = OPERATION__NAME;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_OPERATION__ARGUMENTS = OPERATION__ARGUMENTS;

  /**
   * The feature id for the '<em><b>Returntype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_OPERATION__RETURNTYPE = OPERATION__RETURNTYPE;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_OPERATION__DOCU = OPERATION__DOCU;

  /**
   * The feature id for the '<em><b>Detail Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_OPERATION__DETAIL_CODE = OPERATION__DETAIL_CODE;

  /**
   * The feature id for the '<em><b>Sends Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_OPERATION__SENDS_MSG = OPERATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Port Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl <em>Protocol Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ProtocolClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getProtocolClass()
   * @generated
   */
  int PROTOCOL_CLASS = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__NAME = ROOM_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__DOCU = ROOM_CLASS__DOCU;

  /**
   * The feature id for the '<em><b>Comm Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__COMM_TYPE = ROOM_CLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__BASE = ROOM_CLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__USER_CODE1 = ROOM_CLASS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__USER_CODE2 = ROOM_CLASS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__USER_CODE3 = ROOM_CLASS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Incoming Messages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__INCOMING_MESSAGES = ROOM_CLASS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Outgoing Messages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__OUTGOING_MESSAGES = ROOM_CLASS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Regular</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__REGULAR = ROOM_CLASS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Conjugate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__CONJUGATE = ROOM_CLASS_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Semantics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__SEMANTICS = ROOM_CLASS_FEATURE_COUNT + 9;

  /**
   * The number of structural features of the '<em>Protocol Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS_FEATURE_COUNT = ROOM_CLASS_FEATURE_COUNT + 10;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.MessageImpl <em>Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.MessageImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getMessage()
   * @generated
   */
  int MESSAGE = 16;

  /**
   * The feature id for the '<em><b>Priv</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__PRIV = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__NAME = 1;

  /**
   * The feature id for the '<em><b>Data</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__DATA = 2;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__DOCU = 3;

  /**
   * The number of structural features of the '<em>Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.PortClassImpl <em>Port Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.PortClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPortClass()
   * @generated
   */
  int PORT_CLASS = 17;

  /**
   * The feature id for the '<em><b>User Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_CLASS__USER_CODE = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_CLASS__ATTRIBUTES = 1;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_CLASS__OPERATIONS = 2;

  /**
   * The feature id for the '<em><b>Msg Handlers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_CLASS__MSG_HANDLERS = 3;

  /**
   * The number of structural features of the '<em>Port Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_CLASS_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.MessageHandlerImpl <em>Message Handler</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.MessageHandlerImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getMessageHandler()
   * @generated
   */
  int MESSAGE_HANDLER = 18;

  /**
   * The feature id for the '<em><b>Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_HANDLER__MSG = 0;

  /**
   * The feature id for the '<em><b>Detail Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_HANDLER__DETAIL_CODE = 1;

  /**
   * The number of structural features of the '<em>Message Handler</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_HANDLER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.InMessageHandlerImpl <em>In Message Handler</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.InMessageHandlerImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getInMessageHandler()
   * @generated
   */
  int IN_MESSAGE_HANDLER = 19;

  /**
   * The feature id for the '<em><b>Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_MESSAGE_HANDLER__MSG = MESSAGE_HANDLER__MSG;

  /**
   * The feature id for the '<em><b>Detail Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_MESSAGE_HANDLER__DETAIL_CODE = MESSAGE_HANDLER__DETAIL_CODE;

  /**
   * The number of structural features of the '<em>In Message Handler</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_MESSAGE_HANDLER_FEATURE_COUNT = MESSAGE_HANDLER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.OutMessageHandlerImpl <em>Out Message Handler</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.OutMessageHandlerImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getOutMessageHandler()
   * @generated
   */
  int OUT_MESSAGE_HANDLER = 20;

  /**
   * The feature id for the '<em><b>Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUT_MESSAGE_HANDLER__MSG = MESSAGE_HANDLER__MSG;

  /**
   * The feature id for the '<em><b>Detail Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUT_MESSAGE_HANDLER__DETAIL_CODE = MESSAGE_HANDLER__DETAIL_CODE;

  /**
   * The number of structural features of the '<em>Out Message Handler</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUT_MESSAGE_HANDLER_FEATURE_COUNT = MESSAGE_HANDLER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ProtocolSemanticsImpl <em>Protocol Semantics</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ProtocolSemanticsImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getProtocolSemantics()
   * @generated
   */
  int PROTOCOL_SEMANTICS = 21;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_SEMANTICS__RULES = 0;

  /**
   * The number of structural features of the '<em>Protocol Semantics</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_SEMANTICS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SemanticsRuleImpl <em>Semantics Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SemanticsRuleImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSemanticsRule()
   * @generated
   */
  int SEMANTICS_RULE = 22;

  /**
   * The feature id for the '<em><b>Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEMANTICS_RULE__MSG = 0;

  /**
   * The feature id for the '<em><b>Follow Ups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEMANTICS_RULE__FOLLOW_UPS = 1;

  /**
   * The number of structural features of the '<em>Semantics Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEMANTICS_RULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ActorClassImpl <em>Actor Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ActorClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorClass()
   * @generated
   */
  int ACTOR_CLASS = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__NAME = ACTOR_CONTAINER_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__DOCU = ACTOR_CONTAINER_CLASS__DOCU;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__BINDINGS = ACTOR_CONTAINER_CLASS__BINDINGS;

  /**
   * The feature id for the '<em><b>Connections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__CONNECTIONS = ACTOR_CONTAINER_CLASS__CONNECTIONS;

  /**
   * The feature id for the '<em><b>If SP Ps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__IF_SP_PS = ACTOR_CONTAINER_CLASS__IF_SP_PS;

  /**
   * The feature id for the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__USER_CODE1 = ACTOR_CONTAINER_CLASS__USER_CODE1;

  /**
   * The feature id for the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__USER_CODE2 = ACTOR_CONTAINER_CLASS__USER_CODE2;

  /**
   * The feature id for the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__USER_CODE3 = ACTOR_CONTAINER_CLASS__USER_CODE3;

  /**
   * The feature id for the '<em><b>Actor Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__ACTOR_REFS = ACTOR_CONTAINER_CLASS__ACTOR_REFS;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__ABSTRACT = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Comm Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__COMM_TYPE = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__BASE = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>If Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__IF_PORTS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Structure Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__STRUCTURE_DOCU = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Int Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__INT_PORTS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Ext Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__EXT_PORTS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Service Implementations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__SERVICE_IMPLEMENTATIONS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Str SA Ps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__STR_SA_PS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__ATTRIBUTES = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Behavior Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__BEHAVIOR_DOCU = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__ANNOTATIONS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__OPERATIONS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>State Machine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__STATE_MACHINE = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 13;

  /**
   * The number of structural features of the '<em>Actor Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS_FEATURE_COUNT = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 14;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.InterfaceItemImpl <em>Interface Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.InterfaceItemImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getInterfaceItem()
   * @generated
   */
  int INTERFACE_ITEM = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_ITEM__NAME = 0;

  /**
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_ITEM__PROTOCOL = 1;

  /**
   * The number of structural features of the '<em>Interface Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_ITEM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.PortImpl <em>Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.PortImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPort()
   * @generated
   */
  int PORT = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__NAME = INTERFACE_ITEM__NAME;

  /**
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__PROTOCOL = INTERFACE_ITEM__PROTOCOL;

  /**
   * The feature id for the '<em><b>Conjugated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__CONJUGATED = INTERFACE_ITEM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__MULTIPLICITY = INTERFACE_ITEM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__DOCU = INTERFACE_ITEM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FEATURE_COUNT = INTERFACE_ITEM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ExternalPortImpl <em>External Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ExternalPortImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getExternalPort()
   * @generated
   */
  int EXTERNAL_PORT = 26;

  /**
   * The feature id for the '<em><b>Ifport</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_PORT__IFPORT = 0;

  /**
   * The number of structural features of the '<em>External Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_PORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SAPRefImpl <em>SAP Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SAPRefImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSAPRef()
   * @generated
   */
  int SAP_REF = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAP_REF__NAME = INTERFACE_ITEM__NAME;

  /**
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAP_REF__PROTOCOL = INTERFACE_ITEM__PROTOCOL;

  /**
   * The number of structural features of the '<em>SAP Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAP_REF_FEATURE_COUNT = INTERFACE_ITEM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SPPRefImpl <em>SPP Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SPPRefImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSPPRef()
   * @generated
   */
  int SPP_REF = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPP_REF__NAME = INTERFACE_ITEM__NAME;

  /**
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPP_REF__PROTOCOL = INTERFACE_ITEM__PROTOCOL;

  /**
   * The number of structural features of the '<em>SPP Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPP_REF_FEATURE_COUNT = INTERFACE_ITEM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ServiceImplementationImpl <em>Service Implementation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ServiceImplementationImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getServiceImplementation()
   * @generated
   */
  int SERVICE_IMPLEMENTATION = 29;

  /**
   * The feature id for the '<em><b>Spp</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_IMPLEMENTATION__SPP = 0;

  /**
   * The number of structural features of the '<em>Service Implementation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_IMPLEMENTATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.LogicalSystemImpl <em>Logical System</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.LogicalSystemImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getLogicalSystem()
   * @generated
   */
  int LOGICAL_SYSTEM = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_SYSTEM__NAME = STRUCTURE_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_SYSTEM__DOCU = STRUCTURE_CLASS__DOCU;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_SYSTEM__BINDINGS = STRUCTURE_CLASS__BINDINGS;

  /**
   * The feature id for the '<em><b>Connections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_SYSTEM__CONNECTIONS = STRUCTURE_CLASS__CONNECTIONS;

  /**
   * The feature id for the '<em><b>Sub Systems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_SYSTEM__SUB_SYSTEMS = STRUCTURE_CLASS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Logical System</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_SYSTEM_FEATURE_COUNT = STRUCTURE_CLASS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ActorContainerRefImpl <em>Actor Container Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ActorContainerRefImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorContainerRef()
   * @generated
   */
  int ACTOR_CONTAINER_REF = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_REF__NAME = 0;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_REF__DOCU = 1;

  /**
   * The number of structural features of the '<em>Actor Container Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SubSystemRefImpl <em>Sub System Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SubSystemRefImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSubSystemRef()
   * @generated
   */
  int SUB_SYSTEM_REF = 32;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_REF__NAME = ACTOR_CONTAINER_REF__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_REF__DOCU = ACTOR_CONTAINER_REF__DOCU;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_REF__TYPE = ACTOR_CONTAINER_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Sub System Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_REF_FEATURE_COUNT = ACTOR_CONTAINER_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SubSystemClassImpl <em>Sub System Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SubSystemClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSubSystemClass()
   * @generated
   */
  int SUB_SYSTEM_CLASS = 33;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__NAME = ACTOR_CONTAINER_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__DOCU = ACTOR_CONTAINER_CLASS__DOCU;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__BINDINGS = ACTOR_CONTAINER_CLASS__BINDINGS;

  /**
   * The feature id for the '<em><b>Connections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__CONNECTIONS = ACTOR_CONTAINER_CLASS__CONNECTIONS;

  /**
   * The feature id for the '<em><b>If SP Ps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__IF_SP_PS = ACTOR_CONTAINER_CLASS__IF_SP_PS;

  /**
   * The feature id for the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__USER_CODE1 = ACTOR_CONTAINER_CLASS__USER_CODE1;

  /**
   * The feature id for the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__USER_CODE2 = ACTOR_CONTAINER_CLASS__USER_CODE2;

  /**
   * The feature id for the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__USER_CODE3 = ACTOR_CONTAINER_CLASS__USER_CODE3;

  /**
   * The feature id for the '<em><b>Actor Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__ACTOR_REFS = ACTOR_CONTAINER_CLASS__ACTOR_REFS;

  /**
   * The feature id for the '<em><b>Relay Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__RELAY_PORTS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Threads</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__THREADS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Sub System Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS_FEATURE_COUNT = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.LogicalThreadImpl <em>Logical Thread</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.LogicalThreadImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getLogicalThread()
   * @generated
   */
  int LOGICAL_THREAD = 34;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_THREAD__NAME = 0;

  /**
   * The feature id for the '<em><b>Prio</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_THREAD__PRIO = 1;

  /**
   * The feature id for the '<em><b>Instances</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_THREAD__INSTANCES = 2;

  /**
   * The number of structural features of the '<em>Logical Thread</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_THREAD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ActorInstancePathImpl <em>Actor Instance Path</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ActorInstancePathImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorInstancePath()
   * @generated
   */
  int ACTOR_INSTANCE_PATH = 35;

  /**
   * The feature id for the '<em><b>Segments</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_PATH__SEGMENTS = 0;

  /**
   * The number of structural features of the '<em>Actor Instance Path</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_PATH_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.BindingImpl <em>Binding</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.BindingImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getBinding()
   * @generated
   */
  int BINDING = 36;

  /**
   * The feature id for the '<em><b>Endpoint1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING__ENDPOINT1 = 0;

  /**
   * The feature id for the '<em><b>Endpoint2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING__ENDPOINT2 = 1;

  /**
   * The number of structural features of the '<em>Binding</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.BindingEndPointImpl <em>Binding End Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.BindingEndPointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getBindingEndPoint()
   * @generated
   */
  int BINDING_END_POINT = 37;

  /**
   * The feature id for the '<em><b>Actor Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING_END_POINT__ACTOR_REF = 0;

  /**
   * The feature id for the '<em><b>Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING_END_POINT__PORT = 1;

  /**
   * The number of structural features of the '<em>Binding End Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING_END_POINT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.LayerConnectionImpl <em>Layer Connection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.LayerConnectionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getLayerConnection()
   * @generated
   */
  int LAYER_CONNECTION = 38;

  /**
   * The feature id for the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYER_CONNECTION__FROM = 0;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYER_CONNECTION__TO = 1;

  /**
   * The number of structural features of the '<em>Layer Connection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYER_CONNECTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SAPointImpl <em>SA Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SAPointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSAPoint()
   * @generated
   */
  int SA_POINT = 39;

  /**
   * The number of structural features of the '<em>SA Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SA_POINT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.RefSAPointImpl <em>Ref SA Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.RefSAPointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefSAPoint()
   * @generated
   */
  int REF_SA_POINT = 40;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_SA_POINT__REF = SA_POINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Ref SA Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_SA_POINT_FEATURE_COUNT = SA_POINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.RelaySAPointImpl <em>Relay SA Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.RelaySAPointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRelaySAPoint()
   * @generated
   */
  int RELAY_SA_POINT = 41;

  /**
   * The feature id for the '<em><b>Relay</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELAY_SA_POINT__RELAY = SA_POINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Relay SA Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELAY_SA_POINT_FEATURE_COUNT = SA_POINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SPPointImpl <em>SP Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SPPointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSPPoint()
   * @generated
   */
  int SP_POINT = 42;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SP_POINT__REF = 0;

  /**
   * The feature id for the '<em><b>Service</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SP_POINT__SERVICE = 1;

  /**
   * The number of structural features of the '<em>SP Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SP_POINT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ActorRefImpl <em>Actor Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ActorRefImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorRef()
   * @generated
   */
  int ACTOR_REF = 43;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_REF__NAME = ACTOR_CONTAINER_REF__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_REF__DOCU = ACTOR_CONTAINER_REF__DOCU;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_REF__SIZE = ACTOR_CONTAINER_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_REF__TYPE = ACTOR_CONTAINER_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Actor Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_REF_FEATURE_COUNT = ACTOR_CONTAINER_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.StateGraphItemImpl <em>State Graph Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.StateGraphItemImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStateGraphItem()
   * @generated
   */
  int STATE_GRAPH_ITEM = 45;

  /**
   * The number of structural features of the '<em>State Graph Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH_ITEM_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.StateGraphNodeImpl <em>State Graph Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.StateGraphNodeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStateGraphNode()
   * @generated
   */
  int STATE_GRAPH_NODE = 44;

  /**
   * The number of structural features of the '<em>State Graph Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH_NODE_FEATURE_COUNT = STATE_GRAPH_ITEM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.StateImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getState()
   * @generated
   */
  int STATE = 46;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__DOCU = STATE_GRAPH_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Entry Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__ENTRY_CODE = STATE_GRAPH_NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Exit Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__EXIT_CODE = STATE_GRAPH_NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Do Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__DO_CODE = STATE_GRAPH_NODE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Subgraph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__SUBGRAPH = STATE_GRAPH_NODE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = STATE_GRAPH_NODE_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.StateGraphImpl <em>State Graph</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.StateGraphImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStateGraph()
   * @generated
   */
  int STATE_GRAPH = 47;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH__STATES = 0;

  /**
   * The feature id for the '<em><b>Tr Points</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH__TR_POINTS = 1;

  /**
   * The feature id for the '<em><b>Ch Points</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH__CH_POINTS = 2;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH__TRANSITIONS = 3;

  /**
   * The number of structural features of the '<em>State Graph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.BaseStateImpl <em>Base State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.BaseStateImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getBaseState()
   * @generated
   */
  int BASE_STATE = 48;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_STATE__DOCU = STATE__DOCU;

  /**
   * The feature id for the '<em><b>Entry Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_STATE__ENTRY_CODE = STATE__ENTRY_CODE;

  /**
   * The feature id for the '<em><b>Exit Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_STATE__EXIT_CODE = STATE__EXIT_CODE;

  /**
   * The feature id for the '<em><b>Do Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_STATE__DO_CODE = STATE__DO_CODE;

  /**
   * The feature id for the '<em><b>Subgraph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_STATE__SUBGRAPH = STATE__SUBGRAPH;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_STATE__NAME = STATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Base State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.RefinedStateImpl <em>Refined State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.RefinedStateImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefinedState()
   * @generated
   */
  int REFINED_STATE = 49;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_STATE__DOCU = STATE__DOCU;

  /**
   * The feature id for the '<em><b>Entry Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_STATE__ENTRY_CODE = STATE__ENTRY_CODE;

  /**
   * The feature id for the '<em><b>Exit Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_STATE__EXIT_CODE = STATE__EXIT_CODE;

  /**
   * The feature id for the '<em><b>Do Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_STATE__DO_CODE = STATE__DO_CODE;

  /**
   * The feature id for the '<em><b>Subgraph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_STATE__SUBGRAPH = STATE__SUBGRAPH;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_STATE__BASE = STATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Refined State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.DetailCodeImpl <em>Detail Code</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.DetailCodeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getDetailCode()
   * @generated
   */
  int DETAIL_CODE = 50;

  /**
   * The feature id for the '<em><b>Commands</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETAIL_CODE__COMMANDS = 0;

  /**
   * The number of structural features of the '<em>Detail Code</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETAIL_CODE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.TrPointImpl <em>Tr Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.TrPointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTrPoint()
   * @generated
   */
  int TR_POINT = 51;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TR_POINT__NAME = STATE_GRAPH_NODE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tr Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TR_POINT_FEATURE_COUNT = STATE_GRAPH_NODE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.TransitionPointImpl <em>Transition Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.TransitionPointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTransitionPoint()
   * @generated
   */
  int TRANSITION_POINT = 52;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_POINT__NAME = TR_POINT__NAME;

  /**
   * The feature id for the '<em><b>Handler</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_POINT__HANDLER = TR_POINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Transition Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_POINT_FEATURE_COUNT = TR_POINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.EntryPointImpl <em>Entry Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.EntryPointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getEntryPoint()
   * @generated
   */
  int ENTRY_POINT = 53;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_POINT__NAME = TR_POINT__NAME;

  /**
   * The number of structural features of the '<em>Entry Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_POINT_FEATURE_COUNT = TR_POINT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ExitPointImpl <em>Exit Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ExitPointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getExitPoint()
   * @generated
   */
  int EXIT_POINT = 54;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_POINT__NAME = TR_POINT__NAME;

  /**
   * The number of structural features of the '<em>Exit Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_POINT_FEATURE_COUNT = TR_POINT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ChoicePointImpl <em>Choice Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ChoicePointImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getChoicePoint()
   * @generated
   */
  int CHOICE_POINT = 55;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_POINT__NAME = STATE_GRAPH_NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_POINT__DOCU = STATE_GRAPH_NODE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Choice Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_POINT_FEATURE_COUNT = STATE_GRAPH_NODE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.TransitionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 56;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__NAME = STATE_GRAPH_ITEM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__TO = STATE_GRAPH_ITEM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__DOCU = STATE_GRAPH_ITEM_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__ACTION = STATE_GRAPH_ITEM_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = STATE_GRAPH_ITEM_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.NonInitialTransitionImpl <em>Non Initial Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.NonInitialTransitionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getNonInitialTransition()
   * @generated
   */
  int NON_INITIAL_TRANSITION = 57;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_INITIAL_TRANSITION__NAME = TRANSITION__NAME;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_INITIAL_TRANSITION__TO = TRANSITION__TO;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_INITIAL_TRANSITION__DOCU = TRANSITION__DOCU;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_INITIAL_TRANSITION__ACTION = TRANSITION__ACTION;

  /**
   * The feature id for the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_INITIAL_TRANSITION__FROM = TRANSITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Non Initial Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_INITIAL_TRANSITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.TransitionChainStartTransitionImpl <em>Transition Chain Start Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.TransitionChainStartTransitionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTransitionChainStartTransition()
   * @generated
   */
  int TRANSITION_CHAIN_START_TRANSITION = 58;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CHAIN_START_TRANSITION__NAME = NON_INITIAL_TRANSITION__NAME;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CHAIN_START_TRANSITION__TO = NON_INITIAL_TRANSITION__TO;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CHAIN_START_TRANSITION__DOCU = NON_INITIAL_TRANSITION__DOCU;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CHAIN_START_TRANSITION__ACTION = NON_INITIAL_TRANSITION__ACTION;

  /**
   * The feature id for the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CHAIN_START_TRANSITION__FROM = NON_INITIAL_TRANSITION__FROM;

  /**
   * The number of structural features of the '<em>Transition Chain Start Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CHAIN_START_TRANSITION_FEATURE_COUNT = NON_INITIAL_TRANSITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.InitialTransitionImpl <em>Initial Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.InitialTransitionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getInitialTransition()
   * @generated
   */
  int INITIAL_TRANSITION = 59;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_TRANSITION__NAME = TRANSITION__NAME;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_TRANSITION__TO = TRANSITION__TO;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_TRANSITION__DOCU = TRANSITION__DOCU;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_TRANSITION__ACTION = TRANSITION__ACTION;

  /**
   * The number of structural features of the '<em>Initial Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_TRANSITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ContinuationTransitionImpl <em>Continuation Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ContinuationTransitionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getContinuationTransition()
   * @generated
   */
  int CONTINUATION_TRANSITION = 60;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTINUATION_TRANSITION__NAME = NON_INITIAL_TRANSITION__NAME;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTINUATION_TRANSITION__TO = NON_INITIAL_TRANSITION__TO;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTINUATION_TRANSITION__DOCU = NON_INITIAL_TRANSITION__DOCU;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTINUATION_TRANSITION__ACTION = NON_INITIAL_TRANSITION__ACTION;

  /**
   * The feature id for the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTINUATION_TRANSITION__FROM = NON_INITIAL_TRANSITION__FROM;

  /**
   * The number of structural features of the '<em>Continuation Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTINUATION_TRANSITION_FEATURE_COUNT = NON_INITIAL_TRANSITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.TriggeredTransitionImpl <em>Triggered Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.TriggeredTransitionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTriggeredTransition()
   * @generated
   */
  int TRIGGERED_TRANSITION = 61;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__NAME = TRANSITION_CHAIN_START_TRANSITION__NAME;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__TO = TRANSITION_CHAIN_START_TRANSITION__TO;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__DOCU = TRANSITION_CHAIN_START_TRANSITION__DOCU;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__ACTION = TRANSITION_CHAIN_START_TRANSITION__ACTION;

  /**
   * The feature id for the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__FROM = TRANSITION_CHAIN_START_TRANSITION__FROM;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__TRIGGERS = TRANSITION_CHAIN_START_TRANSITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Triggered Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION_FEATURE_COUNT = TRANSITION_CHAIN_START_TRANSITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.GuardedTransitionImpl <em>Guarded Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.GuardedTransitionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getGuardedTransition()
   * @generated
   */
  int GUARDED_TRANSITION = 62;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARDED_TRANSITION__NAME = TRANSITION_CHAIN_START_TRANSITION__NAME;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARDED_TRANSITION__TO = TRANSITION_CHAIN_START_TRANSITION__TO;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARDED_TRANSITION__DOCU = TRANSITION_CHAIN_START_TRANSITION__DOCU;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARDED_TRANSITION__ACTION = TRANSITION_CHAIN_START_TRANSITION__ACTION;

  /**
   * The feature id for the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARDED_TRANSITION__FROM = TRANSITION_CHAIN_START_TRANSITION__FROM;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARDED_TRANSITION__GUARD = TRANSITION_CHAIN_START_TRANSITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Guarded Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARDED_TRANSITION_FEATURE_COUNT = TRANSITION_CHAIN_START_TRANSITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.CPBranchTransitionImpl <em>CP Branch Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.CPBranchTransitionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getCPBranchTransition()
   * @generated
   */
  int CP_BRANCH_TRANSITION = 63;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CP_BRANCH_TRANSITION__NAME = NON_INITIAL_TRANSITION__NAME;

  /**
   * The feature id for the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CP_BRANCH_TRANSITION__TO = NON_INITIAL_TRANSITION__TO;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CP_BRANCH_TRANSITION__DOCU = NON_INITIAL_TRANSITION__DOCU;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CP_BRANCH_TRANSITION__ACTION = NON_INITIAL_TRANSITION__ACTION;

  /**
   * The feature id for the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CP_BRANCH_TRANSITION__FROM = NON_INITIAL_TRANSITION__FROM;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CP_BRANCH_TRANSITION__CONDITION = NON_INITIAL_TRANSITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>CP Branch Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CP_BRANCH_TRANSITION_FEATURE_COUNT = NON_INITIAL_TRANSITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.TransitionTerminalImpl <em>Transition Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.TransitionTerminalImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTransitionTerminal()
   * @generated
   */
  int TRANSITION_TERMINAL = 64;

  /**
   * The number of structural features of the '<em>Transition Terminal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_TERMINAL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.StateTerminalImpl <em>State Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.StateTerminalImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStateTerminal()
   * @generated
   */
  int STATE_TERMINAL = 65;

  /**
   * The feature id for the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_TERMINAL__STATE = TRANSITION_TERMINAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>State Terminal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_TERMINAL_FEATURE_COUNT = TRANSITION_TERMINAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.TrPointTerminalImpl <em>Tr Point Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.TrPointTerminalImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTrPointTerminal()
   * @generated
   */
  int TR_POINT_TERMINAL = 66;

  /**
   * The feature id for the '<em><b>Tr Point</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TR_POINT_TERMINAL__TR_POINT = TRANSITION_TERMINAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tr Point Terminal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TR_POINT_TERMINAL_FEATURE_COUNT = TRANSITION_TERMINAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SubStateTrPointTerminalImpl <em>Sub State Tr Point Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SubStateTrPointTerminalImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSubStateTrPointTerminal()
   * @generated
   */
  int SUB_STATE_TR_POINT_TERMINAL = 67;

  /**
   * The feature id for the '<em><b>Tr Point</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_STATE_TR_POINT_TERMINAL__TR_POINT = TRANSITION_TERMINAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_STATE_TR_POINT_TERMINAL__STATE = TRANSITION_TERMINAL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Sub State Tr Point Terminal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_STATE_TR_POINT_TERMINAL_FEATURE_COUNT = TRANSITION_TERMINAL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ChoicepointTerminalImpl <em>Choicepoint Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ChoicepointTerminalImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getChoicepointTerminal()
   * @generated
   */
  int CHOICEPOINT_TERMINAL = 68;

  /**
   * The feature id for the '<em><b>Cp</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICEPOINT_TERMINAL__CP = TRANSITION_TERMINAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Choicepoint Terminal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICEPOINT_TERMINAL_FEATURE_COUNT = TRANSITION_TERMINAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.TriggerImpl <em>Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.TriggerImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTrigger()
   * @generated
   */
  int TRIGGER = 69;

  /**
   * The feature id for the '<em><b>Msg From If Pairs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER__MSG_FROM_IF_PAIRS = 0;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER__GUARD = 1;

  /**
   * The number of structural features of the '<em>Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.MessageFromIfImpl <em>Message From If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.MessageFromIfImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getMessageFromIf()
   * @generated
   */
  int MESSAGE_FROM_IF = 70;

  /**
   * The feature id for the '<em><b>Message</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_FROM_IF__MESSAGE = 0;

  /**
   * The feature id for the '<em><b>From</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_FROM_IF__FROM = 1;

  /**
   * The number of structural features of the '<em>Message From If</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_FROM_IF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.GuardImpl <em>Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.GuardImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getGuard()
   * @generated
   */
  int GUARD = 71;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__GUARD = 0;

  /**
   * The number of structural features of the '<em>Guard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.DocumentationImpl <em>Documentation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.DocumentationImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getDocumentation()
   * @generated
   */
  int DOCUMENTATION = 72;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__TEXT = 0;

  /**
   * The number of structural features of the '<em>Documentation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.AnnotationImpl <em>Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.AnnotationImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getAnnotation()
   * @generated
   */
  int ANNOTATION = 73;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__ATTRIBUTES = 1;

  /**
   * The number of structural features of the '<em>Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.KeyValueImpl <em>Key Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.KeyValueImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getKeyValue()
   * @generated
   */
  int KEY_VALUE = 74;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Key Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ImportImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 75;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = 1;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.CommunicationType <em>Communication Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.CommunicationType
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getCommunicationType()
   * @generated
   */
  int COMMUNICATION_TYPE = 76;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.ActorCommunicationType <em>Actor Communication Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.ActorCommunicationType
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorCommunicationType()
   * @generated
   */
  int ACTOR_COMMUNICATION_TYPE = 77;


  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.RoomModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel
   * @generated
   */
  EClass getRoomModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.RoomModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getName()
   * @see #getRoomModel()
   * @generated
   */
  EAttribute getRoomModel_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.RoomModel#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getDocu()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_Docu();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getImports()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getPrimitiveTypes <em>Primitive Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Primitive Types</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getPrimitiveTypes()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_PrimitiveTypes();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getExternalTypes <em>External Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>External Types</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getExternalTypes()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_ExternalTypes();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getDataClasses <em>Data Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Data Classes</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getDataClasses()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_DataClasses();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getProtocolClasses <em>Protocol Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Protocol Classes</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getProtocolClasses()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_ProtocolClasses();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getActorClasses <em>Actor Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actor Classes</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getActorClasses()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_ActorClasses();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getSubSystemClasses <em>Sub System Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub System Classes</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getSubSystemClasses()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_SubSystemClasses();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getSystems <em>Systems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Systems</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getSystems()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_Systems();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.RoomClass <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class</em>'.
   * @see org.eclipse.etrice.core.room.RoomClass
   * @generated
   */
  EClass getRoomClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.RoomClass#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.RoomClass#getName()
   * @see #getRoomClass()
   * @generated
   */
  EAttribute getRoomClass_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.RoomClass#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.RoomClass#getDocu()
   * @see #getRoomClass()
   * @generated
   */
  EReference getRoomClass_Docu();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.StructureClass <em>Structure Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Structure Class</em>'.
   * @see org.eclipse.etrice.core.room.StructureClass
   * @generated
   */
  EClass getStructureClass();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.StructureClass#getBindings <em>Bindings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bindings</em>'.
   * @see org.eclipse.etrice.core.room.StructureClass#getBindings()
   * @see #getStructureClass()
   * @generated
   */
  EReference getStructureClass_Bindings();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.StructureClass#getConnections <em>Connections</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connections</em>'.
   * @see org.eclipse.etrice.core.room.StructureClass#getConnections()
   * @see #getStructureClass()
   * @generated
   */
  EReference getStructureClass_Connections();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ActorContainerClass <em>Actor Container Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actor Container Class</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerClass
   * @generated
   */
  EClass getActorContainerClass();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorContainerClass#getIfSPPs <em>If SP Ps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>If SP Ps</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerClass#getIfSPPs()
   * @see #getActorContainerClass()
   * @generated
   */
  EReference getActorContainerClass_IfSPPs();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode1 <em>User Code1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code1</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerClass#getUserCode1()
   * @see #getActorContainerClass()
   * @generated
   */
  EReference getActorContainerClass_UserCode1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode2 <em>User Code2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code2</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerClass#getUserCode2()
   * @see #getActorContainerClass()
   * @generated
   */
  EReference getActorContainerClass_UserCode2();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode3 <em>User Code3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code3</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerClass#getUserCode3()
   * @see #getActorContainerClass()
   * @generated
   */
  EReference getActorContainerClass_UserCode3();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorContainerClass#getActorRefs <em>Actor Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actor Refs</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerClass#getActorRefs()
   * @see #getActorContainerClass()
   * @generated
   */
  EReference getActorContainerClass_ActorRefs();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.VarDecl <em>Var Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Decl</em>'.
   * @see org.eclipse.etrice.core.room.VarDecl
   * @generated
   */
  EClass getVarDecl();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.VarDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.VarDecl#getName()
   * @see #getVarDecl()
   * @generated
   */
  EAttribute getVarDecl_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.VarDecl#getRefType <em>Ref Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref Type</em>'.
   * @see org.eclipse.etrice.core.room.VarDecl#getRefType()
   * @see #getVarDecl()
   * @generated
   */
  EReference getVarDecl_RefType();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.RefableType <em>Refable Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Refable Type</em>'.
   * @see org.eclipse.etrice.core.room.RefableType
   * @generated
   */
  EClass getRefableType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.RefableType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.etrice.core.room.RefableType#getType()
   * @see #getRefableType()
   * @generated
   */
  EReference getRefableType_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.RefableType#isRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.eclipse.etrice.core.room.RefableType#isRef()
   * @see #getRefableType()
   * @generated
   */
  EAttribute getRefableType_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Type</em>'.
   * @see org.eclipse.etrice.core.room.DataType
   * @generated
   */
  EClass getDataType();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ComplexType <em>Complex Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Complex Type</em>'.
   * @see org.eclipse.etrice.core.room.ComplexType
   * @generated
   */
  EClass getComplexType();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.PrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Type</em>'.
   * @see org.eclipse.etrice.core.room.PrimitiveType
   * @generated
   */
  EClass getPrimitiveType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.PrimitiveType#getTargetName <em>Target Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Name</em>'.
   * @see org.eclipse.etrice.core.room.PrimitiveType#getTargetName()
   * @see #getPrimitiveType()
   * @generated
   */
  EAttribute getPrimitiveType_TargetName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.PrimitiveType#getCastName <em>Cast Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cast Name</em>'.
   * @see org.eclipse.etrice.core.room.PrimitiveType#getCastName()
   * @see #getPrimitiveType()
   * @generated
   */
  EAttribute getPrimitiveType_CastName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.PrimitiveType#getDefaultValueLiteral <em>Default Value Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default Value Literal</em>'.
   * @see org.eclipse.etrice.core.room.PrimitiveType#getDefaultValueLiteral()
   * @see #getPrimitiveType()
   * @generated
   */
  EAttribute getPrimitiveType_DefaultValueLiteral();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ExternalType <em>External Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Type</em>'.
   * @see org.eclipse.etrice.core.room.ExternalType
   * @generated
   */
  EClass getExternalType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ExternalType#getTargetName <em>Target Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Name</em>'.
   * @see org.eclipse.etrice.core.room.ExternalType#getTargetName()
   * @see #getExternalType()
   * @generated
   */
  EAttribute getExternalType_TargetName();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.DataClass <em>Data Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Class</em>'.
   * @see org.eclipse.etrice.core.room.DataClass
   * @generated
   */
  EClass getDataClass();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.DataClass#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Base</em>'.
   * @see org.eclipse.etrice.core.room.DataClass#getBase()
   * @see #getDataClass()
   * @generated
   */
  EReference getDataClass_Base();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.DataClass#getUserCode1 <em>User Code1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code1</em>'.
   * @see org.eclipse.etrice.core.room.DataClass#getUserCode1()
   * @see #getDataClass()
   * @generated
   */
  EReference getDataClass_UserCode1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.DataClass#getUserCode2 <em>User Code2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code2</em>'.
   * @see org.eclipse.etrice.core.room.DataClass#getUserCode2()
   * @see #getDataClass()
   * @generated
   */
  EReference getDataClass_UserCode2();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.DataClass#getUserCode3 <em>User Code3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code3</em>'.
   * @see org.eclipse.etrice.core.room.DataClass#getUserCode3()
   * @see #getDataClass()
   * @generated
   */
  EReference getDataClass_UserCode3();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.DataClass#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.room.DataClass#getAttributes()
   * @see #getDataClass()
   * @generated
   */
  EReference getDataClass_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.DataClass#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see org.eclipse.etrice.core.room.DataClass#getOperations()
   * @see #getDataClass()
   * @generated
   */
  EReference getDataClass_Operations();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.eclipse.etrice.core.room.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Attribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.Attribute#getName()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Attribute#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see org.eclipse.etrice.core.room.Attribute#getSize()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Size();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Attribute#getRefType <em>Ref Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref Type</em>'.
   * @see org.eclipse.etrice.core.room.Attribute#getRefType()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_RefType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Attribute#getDefaultValueLiteral <em>Default Value Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default Value Literal</em>'.
   * @see org.eclipse.etrice.core.room.Attribute#getDefaultValueLiteral()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_DefaultValueLiteral();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Attribute#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.Attribute#getDocu()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Docu();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see org.eclipse.etrice.core.room.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Operation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.Operation#getName()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.Operation#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.eclipse.etrice.core.room.Operation#getArguments()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Arguments();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Operation#getReturntype <em>Returntype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Returntype</em>'.
   * @see org.eclipse.etrice.core.room.Operation#getReturntype()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Returntype();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Operation#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.Operation#getDocu()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Docu();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Operation#getDetailCode <em>Detail Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Detail Code</em>'.
   * @see org.eclipse.etrice.core.room.Operation#getDetailCode()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_DetailCode();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.StandardOperation <em>Standard Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Standard Operation</em>'.
   * @see org.eclipse.etrice.core.room.StandardOperation
   * @generated
   */
  EClass getStandardOperation();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.PortOperation <em>Port Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Operation</em>'.
   * @see org.eclipse.etrice.core.room.PortOperation
   * @generated
   */
  EClass getPortOperation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.PortOperation#getSendsMsg <em>Sends Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Sends Msg</em>'.
   * @see org.eclipse.etrice.core.room.PortOperation#getSendsMsg()
   * @see #getPortOperation()
   * @generated
   */
  EReference getPortOperation_SendsMsg();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ProtocolClass <em>Protocol Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Protocol Class</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass
   * @generated
   */
  EClass getProtocolClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ProtocolClass#getCommType <em>Comm Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Comm Type</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getCommType()
   * @see #getProtocolClass()
   * @generated
   */
  EAttribute getProtocolClass_CommType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.ProtocolClass#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Base</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getBase()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_Base();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ProtocolClass#getUserCode1 <em>User Code1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code1</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getUserCode1()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_UserCode1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ProtocolClass#getUserCode2 <em>User Code2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code2</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getUserCode2()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_UserCode2();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ProtocolClass#getUserCode3 <em>User Code3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code3</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getUserCode3()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_UserCode3();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ProtocolClass#getIncomingMessages <em>Incoming Messages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Incoming Messages</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getIncomingMessages()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_IncomingMessages();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ProtocolClass#getOutgoingMessages <em>Outgoing Messages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Outgoing Messages</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getOutgoingMessages()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_OutgoingMessages();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ProtocolClass#getRegular <em>Regular</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Regular</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getRegular()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_Regular();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ProtocolClass#getConjugate <em>Conjugate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Conjugate</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getConjugate()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_Conjugate();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ProtocolClass#getSemantics <em>Semantics</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Semantics</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getSemantics()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_Semantics();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Message <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message</em>'.
   * @see org.eclipse.etrice.core.room.Message
   * @generated
   */
  EClass getMessage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Message#isPriv <em>Priv</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priv</em>'.
   * @see org.eclipse.etrice.core.room.Message#isPriv()
   * @see #getMessage()
   * @generated
   */
  EAttribute getMessage_Priv();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Message#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.Message#getName()
   * @see #getMessage()
   * @generated
   */
  EAttribute getMessage_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Message#getData <em>Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Data</em>'.
   * @see org.eclipse.etrice.core.room.Message#getData()
   * @see #getMessage()
   * @generated
   */
  EReference getMessage_Data();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Message#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.Message#getDocu()
   * @see #getMessage()
   * @generated
   */
  EReference getMessage_Docu();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.PortClass <em>Port Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Class</em>'.
   * @see org.eclipse.etrice.core.room.PortClass
   * @generated
   */
  EClass getPortClass();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.PortClass#getUserCode <em>User Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Code</em>'.
   * @see org.eclipse.etrice.core.room.PortClass#getUserCode()
   * @see #getPortClass()
   * @generated
   */
  EReference getPortClass_UserCode();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.PortClass#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.room.PortClass#getAttributes()
   * @see #getPortClass()
   * @generated
   */
  EReference getPortClass_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.PortClass#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see org.eclipse.etrice.core.room.PortClass#getOperations()
   * @see #getPortClass()
   * @generated
   */
  EReference getPortClass_Operations();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.PortClass#getMsgHandlers <em>Msg Handlers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Msg Handlers</em>'.
   * @see org.eclipse.etrice.core.room.PortClass#getMsgHandlers()
   * @see #getPortClass()
   * @generated
   */
  EReference getPortClass_MsgHandlers();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.MessageHandler <em>Message Handler</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message Handler</em>'.
   * @see org.eclipse.etrice.core.room.MessageHandler
   * @generated
   */
  EClass getMessageHandler();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.MessageHandler#getMsg <em>Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Msg</em>'.
   * @see org.eclipse.etrice.core.room.MessageHandler#getMsg()
   * @see #getMessageHandler()
   * @generated
   */
  EReference getMessageHandler_Msg();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.MessageHandler#getDetailCode <em>Detail Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Detail Code</em>'.
   * @see org.eclipse.etrice.core.room.MessageHandler#getDetailCode()
   * @see #getMessageHandler()
   * @generated
   */
  EReference getMessageHandler_DetailCode();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.InMessageHandler <em>In Message Handler</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>In Message Handler</em>'.
   * @see org.eclipse.etrice.core.room.InMessageHandler
   * @generated
   */
  EClass getInMessageHandler();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.OutMessageHandler <em>Out Message Handler</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Out Message Handler</em>'.
   * @see org.eclipse.etrice.core.room.OutMessageHandler
   * @generated
   */
  EClass getOutMessageHandler();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ProtocolSemantics <em>Protocol Semantics</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Protocol Semantics</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolSemantics
   * @generated
   */
  EClass getProtocolSemantics();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ProtocolSemantics#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolSemantics#getRules()
   * @see #getProtocolSemantics()
   * @generated
   */
  EReference getProtocolSemantics_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SemanticsRule <em>Semantics Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Semantics Rule</em>'.
   * @see org.eclipse.etrice.core.room.SemanticsRule
   * @generated
   */
  EClass getSemanticsRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.SemanticsRule#getMsg <em>Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Msg</em>'.
   * @see org.eclipse.etrice.core.room.SemanticsRule#getMsg()
   * @see #getSemanticsRule()
   * @generated
   */
  EReference getSemanticsRule_Msg();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.SemanticsRule#getFollowUps <em>Follow Ups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Follow Ups</em>'.
   * @see org.eclipse.etrice.core.room.SemanticsRule#getFollowUps()
   * @see #getSemanticsRule()
   * @generated
   */
  EReference getSemanticsRule_FollowUps();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ActorClass <em>Actor Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actor Class</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass
   * @generated
   */
  EClass getActorClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ActorClass#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#isAbstract()
   * @see #getActorClass()
   * @generated
   */
  EAttribute getActorClass_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ActorClass#getCommType <em>Comm Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Comm Type</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getCommType()
   * @see #getActorClass()
   * @generated
   */
  EAttribute getActorClass_CommType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.ActorClass#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Base</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getBase()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_Base();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getIfPorts <em>If Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>If Ports</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getIfPorts()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_IfPorts();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ActorClass#getStructureDocu <em>Structure Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Structure Docu</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getStructureDocu()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_StructureDocu();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getIntPorts <em>Int Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Int Ports</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getIntPorts()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_IntPorts();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getExtPorts <em>Ext Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ext Ports</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getExtPorts()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_ExtPorts();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getServiceImplementations <em>Service Implementations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Service Implementations</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getServiceImplementations()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_ServiceImplementations();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getStrSAPs <em>Str SA Ps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Str SA Ps</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getStrSAPs()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_StrSAPs();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getAttributes()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_Attributes();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ActorClass#getBehaviorDocu <em>Behavior Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Behavior Docu</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getBehaviorDocu()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_BehaviorDocu();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getAnnotations()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_Annotations();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getOperations()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_Operations();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ActorClass#getStateMachine <em>State Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State Machine</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getStateMachine()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_StateMachine();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.InterfaceItem <em>Interface Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Item</em>'.
   * @see org.eclipse.etrice.core.room.InterfaceItem
   * @generated
   */
  EClass getInterfaceItem();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.InterfaceItem#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.InterfaceItem#getName()
   * @see #getInterfaceItem()
   * @generated
   */
  EAttribute getInterfaceItem_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.InterfaceItem#getProtocol <em>Protocol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Protocol</em>'.
   * @see org.eclipse.etrice.core.room.InterfaceItem#getProtocol()
   * @see #getInterfaceItem()
   * @generated
   */
  EReference getInterfaceItem_Protocol();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port</em>'.
   * @see org.eclipse.etrice.core.room.Port
   * @generated
   */
  EClass getPort();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Port#isConjugated <em>Conjugated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Conjugated</em>'.
   * @see org.eclipse.etrice.core.room.Port#isConjugated()
   * @see #getPort()
   * @generated
   */
  EAttribute getPort_Conjugated();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Port#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see org.eclipse.etrice.core.room.Port#getMultiplicity()
   * @see #getPort()
   * @generated
   */
  EAttribute getPort_Multiplicity();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Port#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.Port#getDocu()
   * @see #getPort()
   * @generated
   */
  EReference getPort_Docu();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ExternalPort <em>External Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Port</em>'.
   * @see org.eclipse.etrice.core.room.ExternalPort
   * @generated
   */
  EClass getExternalPort();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.ExternalPort#getIfport <em>Ifport</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ifport</em>'.
   * @see org.eclipse.etrice.core.room.ExternalPort#getIfport()
   * @see #getExternalPort()
   * @generated
   */
  EReference getExternalPort_Ifport();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SAPRef <em>SAP Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SAP Ref</em>'.
   * @see org.eclipse.etrice.core.room.SAPRef
   * @generated
   */
  EClass getSAPRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SPPRef <em>SPP Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SPP Ref</em>'.
   * @see org.eclipse.etrice.core.room.SPPRef
   * @generated
   */
  EClass getSPPRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ServiceImplementation <em>Service Implementation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Service Implementation</em>'.
   * @see org.eclipse.etrice.core.room.ServiceImplementation
   * @generated
   */
  EClass getServiceImplementation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.ServiceImplementation#getSpp <em>Spp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Spp</em>'.
   * @see org.eclipse.etrice.core.room.ServiceImplementation#getSpp()
   * @see #getServiceImplementation()
   * @generated
   */
  EReference getServiceImplementation_Spp();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.LogicalSystem <em>Logical System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical System</em>'.
   * @see org.eclipse.etrice.core.room.LogicalSystem
   * @generated
   */
  EClass getLogicalSystem();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.LogicalSystem#getSubSystems <em>Sub Systems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Systems</em>'.
   * @see org.eclipse.etrice.core.room.LogicalSystem#getSubSystems()
   * @see #getLogicalSystem()
   * @generated
   */
  EReference getLogicalSystem_SubSystems();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ActorContainerRef <em>Actor Container Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actor Container Ref</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerRef
   * @generated
   */
  EClass getActorContainerRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ActorContainerRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerRef#getName()
   * @see #getActorContainerRef()
   * @generated
   */
  EAttribute getActorContainerRef_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ActorContainerRef#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerRef#getDocu()
   * @see #getActorContainerRef()
   * @generated
   */
  EReference getActorContainerRef_Docu();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SubSystemRef <em>Sub System Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub System Ref</em>'.
   * @see org.eclipse.etrice.core.room.SubSystemRef
   * @generated
   */
  EClass getSubSystemRef();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.SubSystemRef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.etrice.core.room.SubSystemRef#getType()
   * @see #getSubSystemRef()
   * @generated
   */
  EReference getSubSystemRef_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SubSystemClass <em>Sub System Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub System Class</em>'.
   * @see org.eclipse.etrice.core.room.SubSystemClass
   * @generated
   */
  EClass getSubSystemClass();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.SubSystemClass#getRelayPorts <em>Relay Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relay Ports</em>'.
   * @see org.eclipse.etrice.core.room.SubSystemClass#getRelayPorts()
   * @see #getSubSystemClass()
   * @generated
   */
  EReference getSubSystemClass_RelayPorts();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.SubSystemClass#getThreads <em>Threads</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Threads</em>'.
   * @see org.eclipse.etrice.core.room.SubSystemClass#getThreads()
   * @see #getSubSystemClass()
   * @generated
   */
  EReference getSubSystemClass_Threads();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.LogicalThread <em>Logical Thread</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Thread</em>'.
   * @see org.eclipse.etrice.core.room.LogicalThread
   * @generated
   */
  EClass getLogicalThread();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.LogicalThread#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.LogicalThread#getName()
   * @see #getLogicalThread()
   * @generated
   */
  EAttribute getLogicalThread_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.LogicalThread#getPrio <em>Prio</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prio</em>'.
   * @see org.eclipse.etrice.core.room.LogicalThread#getPrio()
   * @see #getLogicalThread()
   * @generated
   */
  EAttribute getLogicalThread_Prio();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.LogicalThread#getInstances <em>Instances</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instances</em>'.
   * @see org.eclipse.etrice.core.room.LogicalThread#getInstances()
   * @see #getLogicalThread()
   * @generated
   */
  EReference getLogicalThread_Instances();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ActorInstancePath <em>Actor Instance Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actor Instance Path</em>'.
   * @see org.eclipse.etrice.core.room.ActorInstancePath
   * @generated
   */
  EClass getActorInstancePath();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.room.ActorInstancePath#getSegments <em>Segments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Segments</em>'.
   * @see org.eclipse.etrice.core.room.ActorInstancePath#getSegments()
   * @see #getActorInstancePath()
   * @generated
   */
  EAttribute getActorInstancePath_Segments();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Binding <em>Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binding</em>'.
   * @see org.eclipse.etrice.core.room.Binding
   * @generated
   */
  EClass getBinding();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Binding#getEndpoint1 <em>Endpoint1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Endpoint1</em>'.
   * @see org.eclipse.etrice.core.room.Binding#getEndpoint1()
   * @see #getBinding()
   * @generated
   */
  EReference getBinding_Endpoint1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Binding#getEndpoint2 <em>Endpoint2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Endpoint2</em>'.
   * @see org.eclipse.etrice.core.room.Binding#getEndpoint2()
   * @see #getBinding()
   * @generated
   */
  EReference getBinding_Endpoint2();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.BindingEndPoint <em>Binding End Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binding End Point</em>'.
   * @see org.eclipse.etrice.core.room.BindingEndPoint
   * @generated
   */
  EClass getBindingEndPoint();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.BindingEndPoint#getActorRef <em>Actor Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Actor Ref</em>'.
   * @see org.eclipse.etrice.core.room.BindingEndPoint#getActorRef()
   * @see #getBindingEndPoint()
   * @generated
   */
  EReference getBindingEndPoint_ActorRef();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.BindingEndPoint#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Port</em>'.
   * @see org.eclipse.etrice.core.room.BindingEndPoint#getPort()
   * @see #getBindingEndPoint()
   * @generated
   */
  EReference getBindingEndPoint_Port();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.LayerConnection <em>Layer Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Layer Connection</em>'.
   * @see org.eclipse.etrice.core.room.LayerConnection
   * @generated
   */
  EClass getLayerConnection();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.LayerConnection#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>From</em>'.
   * @see org.eclipse.etrice.core.room.LayerConnection#getFrom()
   * @see #getLayerConnection()
   * @generated
   */
  EReference getLayerConnection_From();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.LayerConnection#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To</em>'.
   * @see org.eclipse.etrice.core.room.LayerConnection#getTo()
   * @see #getLayerConnection()
   * @generated
   */
  EReference getLayerConnection_To();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SAPoint <em>SA Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SA Point</em>'.
   * @see org.eclipse.etrice.core.room.SAPoint
   * @generated
   */
  EClass getSAPoint();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.RefSAPoint <em>Ref SA Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref SA Point</em>'.
   * @see org.eclipse.etrice.core.room.RefSAPoint
   * @generated
   */
  EClass getRefSAPoint();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.RefSAPoint#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.etrice.core.room.RefSAPoint#getRef()
   * @see #getRefSAPoint()
   * @generated
   */
  EReference getRefSAPoint_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.RelaySAPoint <em>Relay SA Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relay SA Point</em>'.
   * @see org.eclipse.etrice.core.room.RelaySAPoint
   * @generated
   */
  EClass getRelaySAPoint();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.RelaySAPoint#getRelay <em>Relay</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Relay</em>'.
   * @see org.eclipse.etrice.core.room.RelaySAPoint#getRelay()
   * @see #getRelaySAPoint()
   * @generated
   */
  EReference getRelaySAPoint_Relay();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SPPoint <em>SP Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SP Point</em>'.
   * @see org.eclipse.etrice.core.room.SPPoint
   * @generated
   */
  EClass getSPPoint();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.SPPoint#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.etrice.core.room.SPPoint#getRef()
   * @see #getSPPoint()
   * @generated
   */
  EReference getSPPoint_Ref();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.SPPoint#getService <em>Service</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Service</em>'.
   * @see org.eclipse.etrice.core.room.SPPoint#getService()
   * @see #getSPPoint()
   * @generated
   */
  EReference getSPPoint_Service();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ActorRef <em>Actor Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actor Ref</em>'.
   * @see org.eclipse.etrice.core.room.ActorRef
   * @generated
   */
  EClass getActorRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ActorRef#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see org.eclipse.etrice.core.room.ActorRef#getSize()
   * @see #getActorRef()
   * @generated
   */
  EAttribute getActorRef_Size();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.ActorRef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.etrice.core.room.ActorRef#getType()
   * @see #getActorRef()
   * @generated
   */
  EReference getActorRef_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.StateGraphNode <em>State Graph Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Graph Node</em>'.
   * @see org.eclipse.etrice.core.room.StateGraphNode
   * @generated
   */
  EClass getStateGraphNode();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.StateGraphItem <em>State Graph Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Graph Item</em>'.
   * @see org.eclipse.etrice.core.room.StateGraphItem
   * @generated
   */
  EClass getStateGraphItem();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see org.eclipse.etrice.core.room.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.State#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.State#getDocu()
   * @see #getState()
   * @generated
   */
  EReference getState_Docu();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.State#getEntryCode <em>Entry Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Entry Code</em>'.
   * @see org.eclipse.etrice.core.room.State#getEntryCode()
   * @see #getState()
   * @generated
   */
  EReference getState_EntryCode();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.State#getExitCode <em>Exit Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exit Code</em>'.
   * @see org.eclipse.etrice.core.room.State#getExitCode()
   * @see #getState()
   * @generated
   */
  EReference getState_ExitCode();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.State#getDoCode <em>Do Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Do Code</em>'.
   * @see org.eclipse.etrice.core.room.State#getDoCode()
   * @see #getState()
   * @generated
   */
  EReference getState_DoCode();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.State#getSubgraph <em>Subgraph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Subgraph</em>'.
   * @see org.eclipse.etrice.core.room.State#getSubgraph()
   * @see #getState()
   * @generated
   */
  EReference getState_Subgraph();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.StateGraph <em>State Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Graph</em>'.
   * @see org.eclipse.etrice.core.room.StateGraph
   * @generated
   */
  EClass getStateGraph();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.StateGraph#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see org.eclipse.etrice.core.room.StateGraph#getStates()
   * @see #getStateGraph()
   * @generated
   */
  EReference getStateGraph_States();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.StateGraph#getTrPoints <em>Tr Points</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tr Points</em>'.
   * @see org.eclipse.etrice.core.room.StateGraph#getTrPoints()
   * @see #getStateGraph()
   * @generated
   */
  EReference getStateGraph_TrPoints();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.StateGraph#getChPoints <em>Ch Points</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ch Points</em>'.
   * @see org.eclipse.etrice.core.room.StateGraph#getChPoints()
   * @see #getStateGraph()
   * @generated
   */
  EReference getStateGraph_ChPoints();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.StateGraph#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see org.eclipse.etrice.core.room.StateGraph#getTransitions()
   * @see #getStateGraph()
   * @generated
   */
  EReference getStateGraph_Transitions();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.BaseState <em>Base State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Base State</em>'.
   * @see org.eclipse.etrice.core.room.BaseState
   * @generated
   */
  EClass getBaseState();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.BaseState#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.BaseState#getName()
   * @see #getBaseState()
   * @generated
   */
  EAttribute getBaseState_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.RefinedState <em>Refined State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Refined State</em>'.
   * @see org.eclipse.etrice.core.room.RefinedState
   * @generated
   */
  EClass getRefinedState();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.RefinedState#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Base</em>'.
   * @see org.eclipse.etrice.core.room.RefinedState#getBase()
   * @see #getRefinedState()
   * @generated
   */
  EReference getRefinedState_Base();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.DetailCode <em>Detail Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Detail Code</em>'.
   * @see org.eclipse.etrice.core.room.DetailCode
   * @generated
   */
  EClass getDetailCode();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.room.DetailCode#getCommands <em>Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Commands</em>'.
   * @see org.eclipse.etrice.core.room.DetailCode#getCommands()
   * @see #getDetailCode()
   * @generated
   */
  EAttribute getDetailCode_Commands();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.TrPoint <em>Tr Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tr Point</em>'.
   * @see org.eclipse.etrice.core.room.TrPoint
   * @generated
   */
  EClass getTrPoint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.TrPoint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.TrPoint#getName()
   * @see #getTrPoint()
   * @generated
   */
  EAttribute getTrPoint_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.TransitionPoint <em>Transition Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Point</em>'.
   * @see org.eclipse.etrice.core.room.TransitionPoint
   * @generated
   */
  EClass getTransitionPoint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.TransitionPoint#isHandler <em>Handler</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Handler</em>'.
   * @see org.eclipse.etrice.core.room.TransitionPoint#isHandler()
   * @see #getTransitionPoint()
   * @generated
   */
  EAttribute getTransitionPoint_Handler();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.EntryPoint <em>Entry Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Point</em>'.
   * @see org.eclipse.etrice.core.room.EntryPoint
   * @generated
   */
  EClass getEntryPoint();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ExitPoint <em>Exit Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exit Point</em>'.
   * @see org.eclipse.etrice.core.room.ExitPoint
   * @generated
   */
  EClass getExitPoint();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ChoicePoint <em>Choice Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choice Point</em>'.
   * @see org.eclipse.etrice.core.room.ChoicePoint
   * @generated
   */
  EClass getChoicePoint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ChoicePoint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.ChoicePoint#getName()
   * @see #getChoicePoint()
   * @generated
   */
  EAttribute getChoicePoint_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ChoicePoint#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.ChoicePoint#getDocu()
   * @see #getChoicePoint()
   * @generated
   */
  EReference getChoicePoint_Docu();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see org.eclipse.etrice.core.room.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Transition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.Transition#getName()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Transition#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To</em>'.
   * @see org.eclipse.etrice.core.room.Transition#getTo()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_To();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Transition#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.room.Transition#getDocu()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Docu();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Transition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see org.eclipse.etrice.core.room.Transition#getAction()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Action();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.NonInitialTransition <em>Non Initial Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Non Initial Transition</em>'.
   * @see org.eclipse.etrice.core.room.NonInitialTransition
   * @generated
   */
  EClass getNonInitialTransition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.NonInitialTransition#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>From</em>'.
   * @see org.eclipse.etrice.core.room.NonInitialTransition#getFrom()
   * @see #getNonInitialTransition()
   * @generated
   */
  EReference getNonInitialTransition_From();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.TransitionChainStartTransition <em>Transition Chain Start Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Chain Start Transition</em>'.
   * @see org.eclipse.etrice.core.room.TransitionChainStartTransition
   * @generated
   */
  EClass getTransitionChainStartTransition();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.InitialTransition <em>Initial Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Initial Transition</em>'.
   * @see org.eclipse.etrice.core.room.InitialTransition
   * @generated
   */
  EClass getInitialTransition();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ContinuationTransition <em>Continuation Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Continuation Transition</em>'.
   * @see org.eclipse.etrice.core.room.ContinuationTransition
   * @generated
   */
  EClass getContinuationTransition();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.TriggeredTransition <em>Triggered Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Triggered Transition</em>'.
   * @see org.eclipse.etrice.core.room.TriggeredTransition
   * @generated
   */
  EClass getTriggeredTransition();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.TriggeredTransition#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see org.eclipse.etrice.core.room.TriggeredTransition#getTriggers()
   * @see #getTriggeredTransition()
   * @generated
   */
  EReference getTriggeredTransition_Triggers();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.GuardedTransition <em>Guarded Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guarded Transition</em>'.
   * @see org.eclipse.etrice.core.room.GuardedTransition
   * @generated
   */
  EClass getGuardedTransition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.GuardedTransition#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.eclipse.etrice.core.room.GuardedTransition#getGuard()
   * @see #getGuardedTransition()
   * @generated
   */
  EReference getGuardedTransition_Guard();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.CPBranchTransition <em>CP Branch Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CP Branch Transition</em>'.
   * @see org.eclipse.etrice.core.room.CPBranchTransition
   * @generated
   */
  EClass getCPBranchTransition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.CPBranchTransition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipse.etrice.core.room.CPBranchTransition#getCondition()
   * @see #getCPBranchTransition()
   * @generated
   */
  EReference getCPBranchTransition_Condition();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.TransitionTerminal <em>Transition Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Terminal</em>'.
   * @see org.eclipse.etrice.core.room.TransitionTerminal
   * @generated
   */
  EClass getTransitionTerminal();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.StateTerminal <em>State Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Terminal</em>'.
   * @see org.eclipse.etrice.core.room.StateTerminal
   * @generated
   */
  EClass getStateTerminal();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.StateTerminal#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.eclipse.etrice.core.room.StateTerminal#getState()
   * @see #getStateTerminal()
   * @generated
   */
  EReference getStateTerminal_State();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.TrPointTerminal <em>Tr Point Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tr Point Terminal</em>'.
   * @see org.eclipse.etrice.core.room.TrPointTerminal
   * @generated
   */
  EClass getTrPointTerminal();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.TrPointTerminal#getTrPoint <em>Tr Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Tr Point</em>'.
   * @see org.eclipse.etrice.core.room.TrPointTerminal#getTrPoint()
   * @see #getTrPointTerminal()
   * @generated
   */
  EReference getTrPointTerminal_TrPoint();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SubStateTrPointTerminal <em>Sub State Tr Point Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub State Tr Point Terminal</em>'.
   * @see org.eclipse.etrice.core.room.SubStateTrPointTerminal
   * @generated
   */
  EClass getSubStateTrPointTerminal();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.SubStateTrPointTerminal#getTrPoint <em>Tr Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Tr Point</em>'.
   * @see org.eclipse.etrice.core.room.SubStateTrPointTerminal#getTrPoint()
   * @see #getSubStateTrPointTerminal()
   * @generated
   */
  EReference getSubStateTrPointTerminal_TrPoint();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.SubStateTrPointTerminal#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.eclipse.etrice.core.room.SubStateTrPointTerminal#getState()
   * @see #getSubStateTrPointTerminal()
   * @generated
   */
  EReference getSubStateTrPointTerminal_State();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ChoicepointTerminal <em>Choicepoint Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choicepoint Terminal</em>'.
   * @see org.eclipse.etrice.core.room.ChoicepointTerminal
   * @generated
   */
  EClass getChoicepointTerminal();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.ChoicepointTerminal#getCp <em>Cp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Cp</em>'.
   * @see org.eclipse.etrice.core.room.ChoicepointTerminal#getCp()
   * @see #getChoicepointTerminal()
   * @generated
   */
  EReference getChoicepointTerminal_Cp();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger</em>'.
   * @see org.eclipse.etrice.core.room.Trigger
   * @generated
   */
  EClass getTrigger();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.Trigger#getMsgFromIfPairs <em>Msg From If Pairs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Msg From If Pairs</em>'.
   * @see org.eclipse.etrice.core.room.Trigger#getMsgFromIfPairs()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_MsgFromIfPairs();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Trigger#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.eclipse.etrice.core.room.Trigger#getGuard()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_Guard();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.MessageFromIf <em>Message From If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message From If</em>'.
   * @see org.eclipse.etrice.core.room.MessageFromIf
   * @generated
   */
  EClass getMessageFromIf();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.MessageFromIf#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Message</em>'.
   * @see org.eclipse.etrice.core.room.MessageFromIf#getMessage()
   * @see #getMessageFromIf()
   * @generated
   */
  EReference getMessageFromIf_Message();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.MessageFromIf#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>From</em>'.
   * @see org.eclipse.etrice.core.room.MessageFromIf#getFrom()
   * @see #getMessageFromIf()
   * @generated
   */
  EReference getMessageFromIf_From();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard</em>'.
   * @see org.eclipse.etrice.core.room.Guard
   * @generated
   */
  EClass getGuard();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Guard#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.eclipse.etrice.core.room.Guard#getGuard()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_Guard();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Documentation <em>Documentation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Documentation</em>'.
   * @see org.eclipse.etrice.core.room.Documentation
   * @generated
   */
  EClass getDocumentation();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.room.Documentation#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Text</em>'.
   * @see org.eclipse.etrice.core.room.Documentation#getText()
   * @see #getDocumentation()
   * @generated
   */
  EAttribute getDocumentation_Text();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation</em>'.
   * @see org.eclipse.etrice.core.room.Annotation
   * @generated
   */
  EClass getAnnotation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Annotation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.Annotation#getName()
   * @see #getAnnotation()
   * @generated
   */
  EAttribute getAnnotation_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.Annotation#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.room.Annotation#getAttributes()
   * @see #getAnnotation()
   * @generated
   */
  EReference getAnnotation_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.KeyValue <em>Key Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key Value</em>'.
   * @see org.eclipse.etrice.core.room.KeyValue
   * @generated
   */
  EClass getKeyValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.KeyValue#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.eclipse.etrice.core.room.KeyValue#getKey()
   * @see #getKeyValue()
   * @generated
   */
  EAttribute getKeyValue_Key();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.KeyValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.etrice.core.room.KeyValue#getValue()
   * @see #getKeyValue()
   * @generated
   */
  EAttribute getKeyValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.etrice.core.room.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.eclipse.etrice.core.room.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see org.eclipse.etrice.core.room.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the meta object for enum '{@link org.eclipse.etrice.core.room.CommunicationType <em>Communication Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Communication Type</em>'.
   * @see org.eclipse.etrice.core.room.CommunicationType
   * @generated
   */
  EEnum getCommunicationType();

  /**
   * Returns the meta object for enum '{@link org.eclipse.etrice.core.room.ActorCommunicationType <em>Actor Communication Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Actor Communication Type</em>'.
   * @see org.eclipse.etrice.core.room.ActorCommunicationType
   * @generated
   */
  EEnum getActorCommunicationType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RoomFactory getRoomFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.RoomModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.RoomModelImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRoomModel()
     * @generated
     */
    EClass ROOM_MODEL = eINSTANCE.getRoomModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROOM_MODEL__NAME = eINSTANCE.getRoomModel_Name();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__DOCU = eINSTANCE.getRoomModel_Docu();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__IMPORTS = eINSTANCE.getRoomModel_Imports();

    /**
     * The meta object literal for the '<em><b>Primitive Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__PRIMITIVE_TYPES = eINSTANCE.getRoomModel_PrimitiveTypes();

    /**
     * The meta object literal for the '<em><b>External Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__EXTERNAL_TYPES = eINSTANCE.getRoomModel_ExternalTypes();

    /**
     * The meta object literal for the '<em><b>Data Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__DATA_CLASSES = eINSTANCE.getRoomModel_DataClasses();

    /**
     * The meta object literal for the '<em><b>Protocol Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__PROTOCOL_CLASSES = eINSTANCE.getRoomModel_ProtocolClasses();

    /**
     * The meta object literal for the '<em><b>Actor Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__ACTOR_CLASSES = eINSTANCE.getRoomModel_ActorClasses();

    /**
     * The meta object literal for the '<em><b>Sub System Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__SUB_SYSTEM_CLASSES = eINSTANCE.getRoomModel_SubSystemClasses();

    /**
     * The meta object literal for the '<em><b>Systems</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__SYSTEMS = eINSTANCE.getRoomModel_Systems();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.RoomClassImpl <em>Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.RoomClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRoomClass()
     * @generated
     */
    EClass ROOM_CLASS = eINSTANCE.getRoomClass();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROOM_CLASS__NAME = eINSTANCE.getRoomClass_Name();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_CLASS__DOCU = eINSTANCE.getRoomClass_Docu();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.StructureClassImpl <em>Structure Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.StructureClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStructureClass()
     * @generated
     */
    EClass STRUCTURE_CLASS = eINSTANCE.getStructureClass();

    /**
     * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCTURE_CLASS__BINDINGS = eINSTANCE.getStructureClass_Bindings();

    /**
     * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCTURE_CLASS__CONNECTIONS = eINSTANCE.getStructureClass_Connections();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ActorContainerClassImpl <em>Actor Container Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ActorContainerClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorContainerClass()
     * @generated
     */
    EClass ACTOR_CONTAINER_CLASS = eINSTANCE.getActorContainerClass();

    /**
     * The meta object literal for the '<em><b>If SP Ps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CONTAINER_CLASS__IF_SP_PS = eINSTANCE.getActorContainerClass_IfSPPs();

    /**
     * The meta object literal for the '<em><b>User Code1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CONTAINER_CLASS__USER_CODE1 = eINSTANCE.getActorContainerClass_UserCode1();

    /**
     * The meta object literal for the '<em><b>User Code2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CONTAINER_CLASS__USER_CODE2 = eINSTANCE.getActorContainerClass_UserCode2();

    /**
     * The meta object literal for the '<em><b>User Code3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CONTAINER_CLASS__USER_CODE3 = eINSTANCE.getActorContainerClass_UserCode3();

    /**
     * The meta object literal for the '<em><b>Actor Refs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CONTAINER_CLASS__ACTOR_REFS = eINSTANCE.getActorContainerClass_ActorRefs();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.VarDeclImpl <em>Var Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.VarDeclImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getVarDecl()
     * @generated
     */
    EClass VAR_DECL = eINSTANCE.getVarDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR_DECL__NAME = eINSTANCE.getVarDecl_Name();

    /**
     * The meta object literal for the '<em><b>Ref Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_DECL__REF_TYPE = eINSTANCE.getVarDecl_RefType();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.RefableTypeImpl <em>Refable Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.RefableTypeImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefableType()
     * @generated
     */
    EClass REFABLE_TYPE = eINSTANCE.getRefableType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFABLE_TYPE__TYPE = eINSTANCE.getRefableType_Type();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFABLE_TYPE__REF = eINSTANCE.getRefableType_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.DataTypeImpl <em>Data Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.DataTypeImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getDataType()
     * @generated
     */
    EClass DATA_TYPE = eINSTANCE.getDataType();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ComplexTypeImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getComplexType()
     * @generated
     */
    EClass COMPLEX_TYPE = eINSTANCE.getComplexType();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.PrimitiveTypeImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPrimitiveType()
     * @generated
     */
    EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

    /**
     * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_TYPE__TARGET_NAME = eINSTANCE.getPrimitiveType_TargetName();

    /**
     * The meta object literal for the '<em><b>Cast Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_TYPE__CAST_NAME = eINSTANCE.getPrimitiveType_CastName();

    /**
     * The meta object literal for the '<em><b>Default Value Literal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_TYPE__DEFAULT_VALUE_LITERAL = eINSTANCE.getPrimitiveType_DefaultValueLiteral();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ExternalTypeImpl <em>External Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ExternalTypeImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getExternalType()
     * @generated
     */
    EClass EXTERNAL_TYPE = eINSTANCE.getExternalType();

    /**
     * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_TYPE__TARGET_NAME = eINSTANCE.getExternalType_TargetName();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.DataClassImpl <em>Data Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.DataClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getDataClass()
     * @generated
     */
    EClass DATA_CLASS = eINSTANCE.getDataClass();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_CLASS__BASE = eINSTANCE.getDataClass_Base();

    /**
     * The meta object literal for the '<em><b>User Code1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_CLASS__USER_CODE1 = eINSTANCE.getDataClass_UserCode1();

    /**
     * The meta object literal for the '<em><b>User Code2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_CLASS__USER_CODE2 = eINSTANCE.getDataClass_UserCode2();

    /**
     * The meta object literal for the '<em><b>User Code3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_CLASS__USER_CODE3 = eINSTANCE.getDataClass_UserCode3();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_CLASS__ATTRIBUTES = eINSTANCE.getDataClass_Attributes();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_CLASS__OPERATIONS = eINSTANCE.getDataClass_Operations();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.AttributeImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__SIZE = eINSTANCE.getAttribute_Size();

    /**
     * The meta object literal for the '<em><b>Ref Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__REF_TYPE = eINSTANCE.getAttribute_RefType();

    /**
     * The meta object literal for the '<em><b>Default Value Literal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__DEFAULT_VALUE_LITERAL = eINSTANCE.getAttribute_DefaultValueLiteral();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__DOCU = eINSTANCE.getAttribute_Docu();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.OperationImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__NAME = eINSTANCE.getOperation_Name();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__ARGUMENTS = eINSTANCE.getOperation_Arguments();

    /**
     * The meta object literal for the '<em><b>Returntype</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__RETURNTYPE = eINSTANCE.getOperation_Returntype();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__DOCU = eINSTANCE.getOperation_Docu();

    /**
     * The meta object literal for the '<em><b>Detail Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__DETAIL_CODE = eINSTANCE.getOperation_DetailCode();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.StandardOperationImpl <em>Standard Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.StandardOperationImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStandardOperation()
     * @generated
     */
    EClass STANDARD_OPERATION = eINSTANCE.getStandardOperation();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.PortOperationImpl <em>Port Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.PortOperationImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPortOperation()
     * @generated
     */
    EClass PORT_OPERATION = eINSTANCE.getPortOperation();

    /**
     * The meta object literal for the '<em><b>Sends Msg</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_OPERATION__SENDS_MSG = eINSTANCE.getPortOperation_SendsMsg();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl <em>Protocol Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ProtocolClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getProtocolClass()
     * @generated
     */
    EClass PROTOCOL_CLASS = eINSTANCE.getProtocolClass();

    /**
     * The meta object literal for the '<em><b>Comm Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROTOCOL_CLASS__COMM_TYPE = eINSTANCE.getProtocolClass_CommType();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__BASE = eINSTANCE.getProtocolClass_Base();

    /**
     * The meta object literal for the '<em><b>User Code1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__USER_CODE1 = eINSTANCE.getProtocolClass_UserCode1();

    /**
     * The meta object literal for the '<em><b>User Code2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__USER_CODE2 = eINSTANCE.getProtocolClass_UserCode2();

    /**
     * The meta object literal for the '<em><b>User Code3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__USER_CODE3 = eINSTANCE.getProtocolClass_UserCode3();

    /**
     * The meta object literal for the '<em><b>Incoming Messages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__INCOMING_MESSAGES = eINSTANCE.getProtocolClass_IncomingMessages();

    /**
     * The meta object literal for the '<em><b>Outgoing Messages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__OUTGOING_MESSAGES = eINSTANCE.getProtocolClass_OutgoingMessages();

    /**
     * The meta object literal for the '<em><b>Regular</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__REGULAR = eINSTANCE.getProtocolClass_Regular();

    /**
     * The meta object literal for the '<em><b>Conjugate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__CONJUGATE = eINSTANCE.getProtocolClass_Conjugate();

    /**
     * The meta object literal for the '<em><b>Semantics</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__SEMANTICS = eINSTANCE.getProtocolClass_Semantics();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.MessageImpl <em>Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.MessageImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getMessage()
     * @generated
     */
    EClass MESSAGE = eINSTANCE.getMessage();

    /**
     * The meta object literal for the '<em><b>Priv</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MESSAGE__PRIV = eINSTANCE.getMessage_Priv();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MESSAGE__NAME = eINSTANCE.getMessage_Name();

    /**
     * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE__DATA = eINSTANCE.getMessage_Data();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE__DOCU = eINSTANCE.getMessage_Docu();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.PortClassImpl <em>Port Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.PortClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPortClass()
     * @generated
     */
    EClass PORT_CLASS = eINSTANCE.getPortClass();

    /**
     * The meta object literal for the '<em><b>User Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_CLASS__USER_CODE = eINSTANCE.getPortClass_UserCode();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_CLASS__ATTRIBUTES = eINSTANCE.getPortClass_Attributes();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_CLASS__OPERATIONS = eINSTANCE.getPortClass_Operations();

    /**
     * The meta object literal for the '<em><b>Msg Handlers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_CLASS__MSG_HANDLERS = eINSTANCE.getPortClass_MsgHandlers();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.MessageHandlerImpl <em>Message Handler</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.MessageHandlerImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getMessageHandler()
     * @generated
     */
    EClass MESSAGE_HANDLER = eINSTANCE.getMessageHandler();

    /**
     * The meta object literal for the '<em><b>Msg</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE_HANDLER__MSG = eINSTANCE.getMessageHandler_Msg();

    /**
     * The meta object literal for the '<em><b>Detail Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE_HANDLER__DETAIL_CODE = eINSTANCE.getMessageHandler_DetailCode();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.InMessageHandlerImpl <em>In Message Handler</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.InMessageHandlerImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getInMessageHandler()
     * @generated
     */
    EClass IN_MESSAGE_HANDLER = eINSTANCE.getInMessageHandler();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.OutMessageHandlerImpl <em>Out Message Handler</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.OutMessageHandlerImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getOutMessageHandler()
     * @generated
     */
    EClass OUT_MESSAGE_HANDLER = eINSTANCE.getOutMessageHandler();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ProtocolSemanticsImpl <em>Protocol Semantics</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ProtocolSemanticsImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getProtocolSemantics()
     * @generated
     */
    EClass PROTOCOL_SEMANTICS = eINSTANCE.getProtocolSemantics();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_SEMANTICS__RULES = eINSTANCE.getProtocolSemantics_Rules();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SemanticsRuleImpl <em>Semantics Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SemanticsRuleImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSemanticsRule()
     * @generated
     */
    EClass SEMANTICS_RULE = eINSTANCE.getSemanticsRule();

    /**
     * The meta object literal for the '<em><b>Msg</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEMANTICS_RULE__MSG = eINSTANCE.getSemanticsRule_Msg();

    /**
     * The meta object literal for the '<em><b>Follow Ups</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEMANTICS_RULE__FOLLOW_UPS = eINSTANCE.getSemanticsRule_FollowUps();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ActorClassImpl <em>Actor Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ActorClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorClass()
     * @generated
     */
    EClass ACTOR_CLASS = eINSTANCE.getActorClass();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTOR_CLASS__ABSTRACT = eINSTANCE.getActorClass_Abstract();

    /**
     * The meta object literal for the '<em><b>Comm Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTOR_CLASS__COMM_TYPE = eINSTANCE.getActorClass_CommType();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__BASE = eINSTANCE.getActorClass_Base();

    /**
     * The meta object literal for the '<em><b>If Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__IF_PORTS = eINSTANCE.getActorClass_IfPorts();

    /**
     * The meta object literal for the '<em><b>Structure Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__STRUCTURE_DOCU = eINSTANCE.getActorClass_StructureDocu();

    /**
     * The meta object literal for the '<em><b>Int Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__INT_PORTS = eINSTANCE.getActorClass_IntPorts();

    /**
     * The meta object literal for the '<em><b>Ext Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__EXT_PORTS = eINSTANCE.getActorClass_ExtPorts();

    /**
     * The meta object literal for the '<em><b>Service Implementations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__SERVICE_IMPLEMENTATIONS = eINSTANCE.getActorClass_ServiceImplementations();

    /**
     * The meta object literal for the '<em><b>Str SA Ps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__STR_SA_PS = eINSTANCE.getActorClass_StrSAPs();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__ATTRIBUTES = eINSTANCE.getActorClass_Attributes();

    /**
     * The meta object literal for the '<em><b>Behavior Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__BEHAVIOR_DOCU = eINSTANCE.getActorClass_BehaviorDocu();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__ANNOTATIONS = eINSTANCE.getActorClass_Annotations();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__OPERATIONS = eINSTANCE.getActorClass_Operations();

    /**
     * The meta object literal for the '<em><b>State Machine</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__STATE_MACHINE = eINSTANCE.getActorClass_StateMachine();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.InterfaceItemImpl <em>Interface Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.InterfaceItemImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getInterfaceItem()
     * @generated
     */
    EClass INTERFACE_ITEM = eINSTANCE.getInterfaceItem();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_ITEM__NAME = eINSTANCE.getInterfaceItem_Name();

    /**
     * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE_ITEM__PROTOCOL = eINSTANCE.getInterfaceItem_Protocol();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.PortImpl <em>Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.PortImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPort()
     * @generated
     */
    EClass PORT = eINSTANCE.getPort();

    /**
     * The meta object literal for the '<em><b>Conjugated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT__CONJUGATED = eINSTANCE.getPort_Conjugated();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT__MULTIPLICITY = eINSTANCE.getPort_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT__DOCU = eINSTANCE.getPort_Docu();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ExternalPortImpl <em>External Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ExternalPortImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getExternalPort()
     * @generated
     */
    EClass EXTERNAL_PORT = eINSTANCE.getExternalPort();

    /**
     * The meta object literal for the '<em><b>Ifport</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_PORT__IFPORT = eINSTANCE.getExternalPort_Ifport();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SAPRefImpl <em>SAP Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SAPRefImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSAPRef()
     * @generated
     */
    EClass SAP_REF = eINSTANCE.getSAPRef();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SPPRefImpl <em>SPP Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SPPRefImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSPPRef()
     * @generated
     */
    EClass SPP_REF = eINSTANCE.getSPPRef();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ServiceImplementationImpl <em>Service Implementation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ServiceImplementationImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getServiceImplementation()
     * @generated
     */
    EClass SERVICE_IMPLEMENTATION = eINSTANCE.getServiceImplementation();

    /**
     * The meta object literal for the '<em><b>Spp</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_IMPLEMENTATION__SPP = eINSTANCE.getServiceImplementation_Spp();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.LogicalSystemImpl <em>Logical System</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.LogicalSystemImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getLogicalSystem()
     * @generated
     */
    EClass LOGICAL_SYSTEM = eINSTANCE.getLogicalSystem();

    /**
     * The meta object literal for the '<em><b>Sub Systems</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_SYSTEM__SUB_SYSTEMS = eINSTANCE.getLogicalSystem_SubSystems();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ActorContainerRefImpl <em>Actor Container Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ActorContainerRefImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorContainerRef()
     * @generated
     */
    EClass ACTOR_CONTAINER_REF = eINSTANCE.getActorContainerRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTOR_CONTAINER_REF__NAME = eINSTANCE.getActorContainerRef_Name();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CONTAINER_REF__DOCU = eINSTANCE.getActorContainerRef_Docu();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SubSystemRefImpl <em>Sub System Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SubSystemRefImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSubSystemRef()
     * @generated
     */
    EClass SUB_SYSTEM_REF = eINSTANCE.getSubSystemRef();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_REF__TYPE = eINSTANCE.getSubSystemRef_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SubSystemClassImpl <em>Sub System Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SubSystemClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSubSystemClass()
     * @generated
     */
    EClass SUB_SYSTEM_CLASS = eINSTANCE.getSubSystemClass();

    /**
     * The meta object literal for the '<em><b>Relay Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_CLASS__RELAY_PORTS = eINSTANCE.getSubSystemClass_RelayPorts();

    /**
     * The meta object literal for the '<em><b>Threads</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_CLASS__THREADS = eINSTANCE.getSubSystemClass_Threads();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.LogicalThreadImpl <em>Logical Thread</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.LogicalThreadImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getLogicalThread()
     * @generated
     */
    EClass LOGICAL_THREAD = eINSTANCE.getLogicalThread();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOGICAL_THREAD__NAME = eINSTANCE.getLogicalThread_Name();

    /**
     * The meta object literal for the '<em><b>Prio</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOGICAL_THREAD__PRIO = eINSTANCE.getLogicalThread_Prio();

    /**
     * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_THREAD__INSTANCES = eINSTANCE.getLogicalThread_Instances();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ActorInstancePathImpl <em>Actor Instance Path</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ActorInstancePathImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorInstancePath()
     * @generated
     */
    EClass ACTOR_INSTANCE_PATH = eINSTANCE.getActorInstancePath();

    /**
     * The meta object literal for the '<em><b>Segments</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTOR_INSTANCE_PATH__SEGMENTS = eINSTANCE.getActorInstancePath_Segments();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.BindingImpl <em>Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.BindingImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getBinding()
     * @generated
     */
    EClass BINDING = eINSTANCE.getBinding();

    /**
     * The meta object literal for the '<em><b>Endpoint1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINDING__ENDPOINT1 = eINSTANCE.getBinding_Endpoint1();

    /**
     * The meta object literal for the '<em><b>Endpoint2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINDING__ENDPOINT2 = eINSTANCE.getBinding_Endpoint2();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.BindingEndPointImpl <em>Binding End Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.BindingEndPointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getBindingEndPoint()
     * @generated
     */
    EClass BINDING_END_POINT = eINSTANCE.getBindingEndPoint();

    /**
     * The meta object literal for the '<em><b>Actor Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINDING_END_POINT__ACTOR_REF = eINSTANCE.getBindingEndPoint_ActorRef();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINDING_END_POINT__PORT = eINSTANCE.getBindingEndPoint_Port();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.LayerConnectionImpl <em>Layer Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.LayerConnectionImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getLayerConnection()
     * @generated
     */
    EClass LAYER_CONNECTION = eINSTANCE.getLayerConnection();

    /**
     * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LAYER_CONNECTION__FROM = eINSTANCE.getLayerConnection_From();

    /**
     * The meta object literal for the '<em><b>To</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LAYER_CONNECTION__TO = eINSTANCE.getLayerConnection_To();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SAPointImpl <em>SA Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SAPointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSAPoint()
     * @generated
     */
    EClass SA_POINT = eINSTANCE.getSAPoint();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.RefSAPointImpl <em>Ref SA Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.RefSAPointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefSAPoint()
     * @generated
     */
    EClass REF_SA_POINT = eINSTANCE.getRefSAPoint();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_SA_POINT__REF = eINSTANCE.getRefSAPoint_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.RelaySAPointImpl <em>Relay SA Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.RelaySAPointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRelaySAPoint()
     * @generated
     */
    EClass RELAY_SA_POINT = eINSTANCE.getRelaySAPoint();

    /**
     * The meta object literal for the '<em><b>Relay</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELAY_SA_POINT__RELAY = eINSTANCE.getRelaySAPoint_Relay();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SPPointImpl <em>SP Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SPPointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSPPoint()
     * @generated
     */
    EClass SP_POINT = eINSTANCE.getSPPoint();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SP_POINT__REF = eINSTANCE.getSPPoint_Ref();

    /**
     * The meta object literal for the '<em><b>Service</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SP_POINT__SERVICE = eINSTANCE.getSPPoint_Service();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ActorRefImpl <em>Actor Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ActorRefImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorRef()
     * @generated
     */
    EClass ACTOR_REF = eINSTANCE.getActorRef();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTOR_REF__SIZE = eINSTANCE.getActorRef_Size();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_REF__TYPE = eINSTANCE.getActorRef_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.StateGraphNodeImpl <em>State Graph Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.StateGraphNodeImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStateGraphNode()
     * @generated
     */
    EClass STATE_GRAPH_NODE = eINSTANCE.getStateGraphNode();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.StateGraphItemImpl <em>State Graph Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.StateGraphItemImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStateGraphItem()
     * @generated
     */
    EClass STATE_GRAPH_ITEM = eINSTANCE.getStateGraphItem();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.StateImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__DOCU = eINSTANCE.getState_Docu();

    /**
     * The meta object literal for the '<em><b>Entry Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__ENTRY_CODE = eINSTANCE.getState_EntryCode();

    /**
     * The meta object literal for the '<em><b>Exit Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__EXIT_CODE = eINSTANCE.getState_ExitCode();

    /**
     * The meta object literal for the '<em><b>Do Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__DO_CODE = eINSTANCE.getState_DoCode();

    /**
     * The meta object literal for the '<em><b>Subgraph</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__SUBGRAPH = eINSTANCE.getState_Subgraph();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.StateGraphImpl <em>State Graph</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.StateGraphImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStateGraph()
     * @generated
     */
    EClass STATE_GRAPH = eINSTANCE.getStateGraph();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_GRAPH__STATES = eINSTANCE.getStateGraph_States();

    /**
     * The meta object literal for the '<em><b>Tr Points</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_GRAPH__TR_POINTS = eINSTANCE.getStateGraph_TrPoints();

    /**
     * The meta object literal for the '<em><b>Ch Points</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_GRAPH__CH_POINTS = eINSTANCE.getStateGraph_ChPoints();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_GRAPH__TRANSITIONS = eINSTANCE.getStateGraph_Transitions();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.BaseStateImpl <em>Base State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.BaseStateImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getBaseState()
     * @generated
     */
    EClass BASE_STATE = eINSTANCE.getBaseState();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_STATE__NAME = eINSTANCE.getBaseState_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.RefinedStateImpl <em>Refined State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.RefinedStateImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefinedState()
     * @generated
     */
    EClass REFINED_STATE = eINSTANCE.getRefinedState();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFINED_STATE__BASE = eINSTANCE.getRefinedState_Base();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.DetailCodeImpl <em>Detail Code</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.DetailCodeImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getDetailCode()
     * @generated
     */
    EClass DETAIL_CODE = eINSTANCE.getDetailCode();

    /**
     * The meta object literal for the '<em><b>Commands</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DETAIL_CODE__COMMANDS = eINSTANCE.getDetailCode_Commands();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.TrPointImpl <em>Tr Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.TrPointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTrPoint()
     * @generated
     */
    EClass TR_POINT = eINSTANCE.getTrPoint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TR_POINT__NAME = eINSTANCE.getTrPoint_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.TransitionPointImpl <em>Transition Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.TransitionPointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTransitionPoint()
     * @generated
     */
    EClass TRANSITION_POINT = eINSTANCE.getTransitionPoint();

    /**
     * The meta object literal for the '<em><b>Handler</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION_POINT__HANDLER = eINSTANCE.getTransitionPoint_Handler();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.EntryPointImpl <em>Entry Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.EntryPointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getEntryPoint()
     * @generated
     */
    EClass ENTRY_POINT = eINSTANCE.getEntryPoint();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ExitPointImpl <em>Exit Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ExitPointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getExitPoint()
     * @generated
     */
    EClass EXIT_POINT = eINSTANCE.getExitPoint();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ChoicePointImpl <em>Choice Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ChoicePointImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getChoicePoint()
     * @generated
     */
    EClass CHOICE_POINT = eINSTANCE.getChoicePoint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHOICE_POINT__NAME = eINSTANCE.getChoicePoint_Name();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHOICE_POINT__DOCU = eINSTANCE.getChoicePoint_Docu();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.TransitionImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

    /**
     * The meta object literal for the '<em><b>To</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__TO = eINSTANCE.getTransition_To();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__DOCU = eINSTANCE.getTransition_Docu();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__ACTION = eINSTANCE.getTransition_Action();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.NonInitialTransitionImpl <em>Non Initial Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.NonInitialTransitionImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getNonInitialTransition()
     * @generated
     */
    EClass NON_INITIAL_TRANSITION = eINSTANCE.getNonInitialTransition();

    /**
     * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NON_INITIAL_TRANSITION__FROM = eINSTANCE.getNonInitialTransition_From();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.TransitionChainStartTransitionImpl <em>Transition Chain Start Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.TransitionChainStartTransitionImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTransitionChainStartTransition()
     * @generated
     */
    EClass TRANSITION_CHAIN_START_TRANSITION = eINSTANCE.getTransitionChainStartTransition();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.InitialTransitionImpl <em>Initial Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.InitialTransitionImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getInitialTransition()
     * @generated
     */
    EClass INITIAL_TRANSITION = eINSTANCE.getInitialTransition();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ContinuationTransitionImpl <em>Continuation Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ContinuationTransitionImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getContinuationTransition()
     * @generated
     */
    EClass CONTINUATION_TRANSITION = eINSTANCE.getContinuationTransition();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.TriggeredTransitionImpl <em>Triggered Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.TriggeredTransitionImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTriggeredTransition()
     * @generated
     */
    EClass TRIGGERED_TRANSITION = eINSTANCE.getTriggeredTransition();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGERED_TRANSITION__TRIGGERS = eINSTANCE.getTriggeredTransition_Triggers();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.GuardedTransitionImpl <em>Guarded Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.GuardedTransitionImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getGuardedTransition()
     * @generated
     */
    EClass GUARDED_TRANSITION = eINSTANCE.getGuardedTransition();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARDED_TRANSITION__GUARD = eINSTANCE.getGuardedTransition_Guard();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.CPBranchTransitionImpl <em>CP Branch Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.CPBranchTransitionImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getCPBranchTransition()
     * @generated
     */
    EClass CP_BRANCH_TRANSITION = eINSTANCE.getCPBranchTransition();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CP_BRANCH_TRANSITION__CONDITION = eINSTANCE.getCPBranchTransition_Condition();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.TransitionTerminalImpl <em>Transition Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.TransitionTerminalImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTransitionTerminal()
     * @generated
     */
    EClass TRANSITION_TERMINAL = eINSTANCE.getTransitionTerminal();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.StateTerminalImpl <em>State Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.StateTerminalImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getStateTerminal()
     * @generated
     */
    EClass STATE_TERMINAL = eINSTANCE.getStateTerminal();

    /**
     * The meta object literal for the '<em><b>State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_TERMINAL__STATE = eINSTANCE.getStateTerminal_State();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.TrPointTerminalImpl <em>Tr Point Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.TrPointTerminalImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTrPointTerminal()
     * @generated
     */
    EClass TR_POINT_TERMINAL = eINSTANCE.getTrPointTerminal();

    /**
     * The meta object literal for the '<em><b>Tr Point</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TR_POINT_TERMINAL__TR_POINT = eINSTANCE.getTrPointTerminal_TrPoint();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SubStateTrPointTerminalImpl <em>Sub State Tr Point Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SubStateTrPointTerminalImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSubStateTrPointTerminal()
     * @generated
     */
    EClass SUB_STATE_TR_POINT_TERMINAL = eINSTANCE.getSubStateTrPointTerminal();

    /**
     * The meta object literal for the '<em><b>Tr Point</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_STATE_TR_POINT_TERMINAL__TR_POINT = eINSTANCE.getSubStateTrPointTerminal_TrPoint();

    /**
     * The meta object literal for the '<em><b>State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_STATE_TR_POINT_TERMINAL__STATE = eINSTANCE.getSubStateTrPointTerminal_State();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ChoicepointTerminalImpl <em>Choicepoint Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ChoicepointTerminalImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getChoicepointTerminal()
     * @generated
     */
    EClass CHOICEPOINT_TERMINAL = eINSTANCE.getChoicepointTerminal();

    /**
     * The meta object literal for the '<em><b>Cp</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHOICEPOINT_TERMINAL__CP = eINSTANCE.getChoicepointTerminal_Cp();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.TriggerImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getTrigger()
     * @generated
     */
    EClass TRIGGER = eINSTANCE.getTrigger();

    /**
     * The meta object literal for the '<em><b>Msg From If Pairs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER__MSG_FROM_IF_PAIRS = eINSTANCE.getTrigger_MsgFromIfPairs();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER__GUARD = eINSTANCE.getTrigger_Guard();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.MessageFromIfImpl <em>Message From If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.MessageFromIfImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getMessageFromIf()
     * @generated
     */
    EClass MESSAGE_FROM_IF = eINSTANCE.getMessageFromIf();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE_FROM_IF__MESSAGE = eINSTANCE.getMessageFromIf_Message();

    /**
     * The meta object literal for the '<em><b>From</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE_FROM_IF__FROM = eINSTANCE.getMessageFromIf_From();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.GuardImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getGuard()
     * @generated
     */
    EClass GUARD = eINSTANCE.getGuard();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__GUARD = eINSTANCE.getGuard_Guard();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.DocumentationImpl <em>Documentation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.DocumentationImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getDocumentation()
     * @generated
     */
    EClass DOCUMENTATION = eINSTANCE.getDocumentation();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOCUMENTATION__TEXT = eINSTANCE.getDocumentation_Text();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.AnnotationImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getAnnotation()
     * @generated
     */
    EClass ANNOTATION = eINSTANCE.getAnnotation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION__NAME = eINSTANCE.getAnnotation_Name();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION__ATTRIBUTES = eINSTANCE.getAnnotation_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.KeyValueImpl <em>Key Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.KeyValueImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getKeyValue()
     * @generated
     */
    EClass KEY_VALUE = eINSTANCE.getKeyValue();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_VALUE__KEY = eINSTANCE.getKeyValue_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_VALUE__VALUE = eINSTANCE.getKeyValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ImportImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.CommunicationType <em>Communication Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.CommunicationType
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getCommunicationType()
     * @generated
     */
    EEnum COMMUNICATION_TYPE = eINSTANCE.getCommunicationType();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.ActorCommunicationType <em>Actor Communication Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.ActorCommunicationType
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorCommunicationType()
     * @generated
     */
    EEnum ACTOR_COMMUNICATION_TYPE = eINSTANCE.getActorCommunicationType();

  }

} //RoomPackage
