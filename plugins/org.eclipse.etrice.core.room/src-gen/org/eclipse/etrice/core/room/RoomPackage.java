/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.etrice.core.fsm.fSM.FSMPackage;

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
   * The feature id for the '<em><b>Enumeration Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__ENUMERATION_TYPES = 4;

  /**
   * The feature id for the '<em><b>External Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__EXTERNAL_TYPES = 5;

  /**
   * The feature id for the '<em><b>Data Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__DATA_CLASSES = 6;

  /**
   * The feature id for the '<em><b>Protocol Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__PROTOCOL_CLASSES = 7;

  /**
   * The feature id for the '<em><b>Actor Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__ACTOR_CLASSES = 8;

  /**
   * The feature id for the '<em><b>Sub System Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__SUB_SYSTEM_CLASSES = 9;

  /**
   * The feature id for the '<em><b>Systems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__SYSTEMS = 10;

  /**
   * The feature id for the '<em><b>Annotation Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL__ANNOTATION_TYPES = 11;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOM_MODEL_FEATURE_COUNT = 12;

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
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_CLASS__ANNOTATIONS = ROOM_CLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_CLASS__BINDINGS = ROOM_CLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Connections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_CLASS__CONNECTIONS = ROOM_CLASS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Structure Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURE_CLASS_FEATURE_COUNT = ROOM_CLASS_FEATURE_COUNT + 3;

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
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__ANNOTATIONS = STRUCTURE_CLASS__ANNOTATIONS;

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
   * The feature id for the '<em><b>Service Provision Points</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CONTAINER_CLASS__SERVICE_PROVISION_POINTS = STRUCTURE_CLASS_FEATURE_COUNT + 0;

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
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__TYPE = DATA_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__TARGET_NAME = DATA_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Cast Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__CAST_NAME = DATA_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE__DEFAULT_VALUE_LITERAL = DATA_TYPE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Primitive Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.EnumerationTypeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getEnumerationType()
   * @generated
   */
  int ENUMERATION_TYPE = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_TYPE__NAME = DATA_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_TYPE__DOCU = DATA_TYPE__DOCU;

  /**
   * The feature id for the '<em><b>Primitive Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_TYPE__PRIMITIVE_TYPE = DATA_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_TYPE__LITERALS = DATA_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enumeration Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.EnumLiteralImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getEnumLiteral()
   * @generated
   */
  int ENUM_LITERAL = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL__NAME = 0;

  /**
   * The feature id for the '<em><b>Literal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL__LITERAL = 1;

  /**
   * The number of structural features of the '<em>Enum Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ExternalTypeImpl <em>External Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ExternalTypeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getExternalType()
   * @generated
   */
  int EXTERNAL_TYPE = 11;

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
   * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TYPE__DEFAULT_VALUE_LITERAL = COMPLEX_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>External Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TYPE_FEATURE_COUNT = COMPLEX_TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.DataClassImpl <em>Data Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.DataClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getDataClass()
   * @generated
   */
  int DATA_CLASS = 12;

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
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__ANNOTATIONS = COMPLEX_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__USER_CODE1 = COMPLEX_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__USER_CODE2 = COMPLEX_TYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__USER_CODE3 = COMPLEX_TYPE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__ATTRIBUTES = COMPLEX_TYPE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS__OPERATIONS = COMPLEX_TYPE_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Data Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_CLASS_FEATURE_COUNT = COMPLEX_TYPE_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.AttributeImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 13;

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
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE = 2;

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
  int OPERATION = 14;

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
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__RETURN_TYPE = 2;

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
  int STANDARD_OPERATION = 15;

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
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__RETURN_TYPE = OPERATION__RETURN_TYPE;

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
   * The feature id for the '<em><b>Destructor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__DESTRUCTOR = OPERATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Standard Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.PortOperationImpl <em>Port Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.PortOperationImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPortOperation()
   * @generated
   */
  int PORT_OPERATION = 16;

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
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_OPERATION__RETURN_TYPE = OPERATION__RETURN_TYPE;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.GeneralProtocolClassImpl <em>General Protocol Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.GeneralProtocolClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getGeneralProtocolClass()
   * @generated
   */
  int GENERAL_PROTOCOL_CLASS = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERAL_PROTOCOL_CLASS__NAME = ROOM_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERAL_PROTOCOL_CLASS__DOCU = ROOM_CLASS__DOCU;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERAL_PROTOCOL_CLASS__ANNOTATIONS = ROOM_CLASS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>General Protocol Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERAL_PROTOCOL_CLASS_FEATURE_COUNT = ROOM_CLASS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl <em>Protocol Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ProtocolClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getProtocolClass()
   * @generated
   */
  int PROTOCOL_CLASS = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__NAME = GENERAL_PROTOCOL_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__DOCU = GENERAL_PROTOCOL_CLASS__DOCU;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__ANNOTATIONS = GENERAL_PROTOCOL_CLASS__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Comm Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__COMM_TYPE = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__BASE = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__USER_CODE1 = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__USER_CODE2 = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__USER_CODE3 = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Incoming Messages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__INCOMING_MESSAGES = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Outgoing Messages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__OUTGOING_MESSAGES = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Regular</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__REGULAR = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Conjugated</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__CONJUGATED = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Semantics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS__SEMANTICS = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 9;

  /**
   * The number of structural features of the '<em>Protocol Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS_FEATURE_COUNT = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 10;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.CompoundProtocolClassImpl <em>Compound Protocol Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.CompoundProtocolClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getCompoundProtocolClass()
   * @generated
   */
  int COMPOUND_PROTOCOL_CLASS = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_PROTOCOL_CLASS__NAME = GENERAL_PROTOCOL_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_PROTOCOL_CLASS__DOCU = GENERAL_PROTOCOL_CLASS__DOCU;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_PROTOCOL_CLASS__ANNOTATIONS = GENERAL_PROTOCOL_CLASS__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Sub Protocols</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Compound Protocol Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_PROTOCOL_CLASS_FEATURE_COUNT = GENERAL_PROTOCOL_CLASS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SubProtocolImpl <em>Sub Protocol</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SubProtocolImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSubProtocol()
   * @generated
   */
  int SUB_PROTOCOL = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_PROTOCOL__NAME = 0;

  /**
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_PROTOCOL__PROTOCOL = 1;

  /**
   * The number of structural features of the '<em>Sub Protocol</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_PROTOCOL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.MessageImpl <em>Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.MessageImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getMessage()
   * @generated
   */
  int MESSAGE = 21;

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
  int PORT_CLASS = 22;

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
  int MESSAGE_HANDLER = 23;

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
  int IN_MESSAGE_HANDLER = 24;

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
  int OUT_MESSAGE_HANDLER = 25;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ActorClassImpl <em>Actor Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ActorClassImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorClass()
   * @generated
   */
  int ACTOR_CLASS = 26;

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
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__ANNOTATIONS = ACTOR_CONTAINER_CLASS__ANNOTATIONS;

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
   * The feature id for the '<em><b>Service Provision Points</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__SERVICE_PROVISION_POINTS = ACTOR_CONTAINER_CLASS__SERVICE_PROVISION_POINTS;

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
   * The feature id for the '<em><b>Component Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__COMPONENT_NAME = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__BASE = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>State Machine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__STATE_MACHINE = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Interface Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__INTERFACE_PORTS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Structure Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__STRUCTURE_DOCU = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Internal Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__INTERNAL_PORTS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>External Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__EXTERNAL_PORTS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Service Implementations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__SERVICE_IMPLEMENTATIONS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Service Access Points</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__SERVICE_ACCESS_POINTS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__ATTRIBUTES = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Behavior Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__BEHAVIOR_DOCU = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>Behavior Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__BEHAVIOR_ANNOTATIONS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 13;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS__OPERATIONS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 14;

  /**
   * The number of structural features of the '<em>Actor Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS_FEATURE_COUNT = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 15;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.InterfaceItemImpl <em>Interface Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.InterfaceItemImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getInterfaceItem()
   * @generated
   */
  int INTERFACE_ITEM = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_ITEM__NAME = FSMPackage.ABSTRACT_INTERFACE_ITEM__NAME;

  /**
   * The number of structural features of the '<em>Interface Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_ITEM_FEATURE_COUNT = FSMPackage.ABSTRACT_INTERFACE_ITEM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.PortImpl <em>Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.PortImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getPort()
   * @generated
   */
  int PORT = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__NAME = INTERFACE_ITEM__NAME;

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
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__PROTOCOL = INTERFACE_ITEM_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__DOCU = INTERFACE_ITEM_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FEATURE_COUNT = INTERFACE_ITEM_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ExternalPortImpl <em>External Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ExternalPortImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getExternalPort()
   * @generated
   */
  int EXTERNAL_PORT = 29;

  /**
   * The feature id for the '<em><b>Interface Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_PORT__INTERFACE_PORT = 0;

  /**
   * The number of structural features of the '<em>External Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_PORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SAPImpl <em>SAP</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SAPImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSAP()
   * @generated
   */
  int SAP = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAP__NAME = INTERFACE_ITEM__NAME;

  /**
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAP__PROTOCOL = INTERFACE_ITEM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SAP</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAP_FEATURE_COUNT = INTERFACE_ITEM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.SPPImpl <em>SPP</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.SPPImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSPP()
   * @generated
   */
  int SPP = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPP__NAME = INTERFACE_ITEM__NAME;

  /**
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPP__PROTOCOL = INTERFACE_ITEM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SPP</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPP_FEATURE_COUNT = INTERFACE_ITEM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ServiceImplementationImpl <em>Service Implementation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ServiceImplementationImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getServiceImplementation()
   * @generated
   */
  int SERVICE_IMPLEMENTATION = 32;

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
  int LOGICAL_SYSTEM = 33;

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
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_SYSTEM__ANNOTATIONS = STRUCTURE_CLASS__ANNOTATIONS;

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
  int ACTOR_CONTAINER_REF = 34;

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
  int SUB_SYSTEM_REF = 35;

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
  int SUB_SYSTEM_CLASS = 36;

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
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__ANNOTATIONS = ACTOR_CONTAINER_CLASS__ANNOTATIONS;

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
   * The feature id for the '<em><b>Service Provision Points</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__SERVICE_PROVISION_POINTS = ACTOR_CONTAINER_CLASS__SERVICE_PROVISION_POINTS;

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
   * The feature id for the '<em><b>Actor Instance Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS__ACTOR_INSTANCE_MAPPINGS = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Sub System Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CLASS_FEATURE_COUNT = ACTOR_CONTAINER_CLASS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.LogicalThreadImpl <em>Logical Thread</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.LogicalThreadImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getLogicalThread()
   * @generated
   */
  int LOGICAL_THREAD = 37;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_THREAD__NAME = 0;

  /**
   * The number of structural features of the '<em>Logical Thread</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_THREAD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.ActorInstanceMappingImpl <em>Actor Instance Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.ActorInstanceMappingImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorInstanceMapping()
   * @generated
   */
  int ACTOR_INSTANCE_MAPPING = 38;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_MAPPING__PATH = 0;

  /**
   * The feature id for the '<em><b>Thread</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_MAPPING__THREAD = 1;

  /**
   * The feature id for the '<em><b>Actor Instance Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_MAPPING__ACTOR_INSTANCE_MAPPINGS = 2;

  /**
   * The number of structural features of the '<em>Actor Instance Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_MAPPING_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.RefPathImpl <em>Ref Path</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.RefPathImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefPath()
   * @generated
   */
  int REF_PATH = 39;

  /**
   * The feature id for the '<em><b>Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_PATH__REFS = 0;

  /**
   * The number of structural features of the '<em>Ref Path</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_PATH_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.RefSegmentImpl <em>Ref Segment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.RefSegmentImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefSegment()
   * @generated
   */
  int REF_SEGMENT = 40;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_SEGMENT__REF = 0;

  /**
   * The feature id for the '<em><b>Idx</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_SEGMENT__IDX = 1;

  /**
   * The number of structural features of the '<em>Ref Segment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_SEGMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.BindingImpl <em>Binding</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.BindingImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getBinding()
   * @generated
   */
  int BINDING = 41;

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
  int BINDING_END_POINT = 42;

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
   * The feature id for the '<em><b>Sub</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING_END_POINT__SUB = 2;

  /**
   * The number of structural features of the '<em>Binding End Point</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINDING_END_POINT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.impl.LayerConnectionImpl <em>Layer Connection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.impl.LayerConnectionImpl
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getLayerConnection()
   * @generated
   */
  int LAYER_CONNECTION = 43;

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
  int SA_POINT = 44;

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
  int REF_SA_POINT = 45;

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
  int RELAY_SA_POINT = 46;

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
  int SP_POINT = 47;

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
  int ACTOR_REF = 48;

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
   * The feature id for the '<em><b>Ref Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_REF__REF_TYPE = ACTOR_CONTAINER_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_REF__MULTIPLICITY = ACTOR_CONTAINER_REF_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_REF__TYPE = ACTOR_CONTAINER_REF_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Actor Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_REF_FEATURE_COUNT = ACTOR_CONTAINER_REF_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.CommunicationType <em>Communication Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.CommunicationType
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getCommunicationType()
   * @generated
   */
  int COMMUNICATION_TYPE = 49;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.ReferenceType <em>Reference Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.ReferenceType
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getReferenceType()
   * @generated
   */
  int REFERENCE_TYPE = 50;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.room.RoomAnnotationTargetEnum <em>Annotation Target Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.room.RoomAnnotationTargetEnum
   * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRoomAnnotationTargetEnum()
   * @generated
   */
  int ROOM_ANNOTATION_TARGET_ENUM = 51;


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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getEnumerationTypes <em>Enumeration Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Enumeration Types</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getEnumerationTypes()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_EnumerationTypes();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RoomModel#getAnnotationTypes <em>Annotation Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotation Types</em>'.
   * @see org.eclipse.etrice.core.room.RoomModel#getAnnotationTypes()
   * @see #getRoomModel()
   * @generated
   */
  EReference getRoomModel_AnnotationTypes();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.StructureClass#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.eclipse.etrice.core.room.StructureClass#getAnnotations()
   * @see #getStructureClass()
   * @generated
   */
  EReference getStructureClass_Annotations();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorContainerClass#getServiceProvisionPoints <em>Service Provision Points</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Service Provision Points</em>'.
   * @see org.eclipse.etrice.core.room.ActorContainerClass#getServiceProvisionPoints()
   * @see #getActorContainerClass()
   * @generated
   */
  EReference getActorContainerClass_ServiceProvisionPoints();

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
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.PrimitiveType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.etrice.core.room.PrimitiveType#getType()
   * @see #getPrimitiveType()
   * @generated
   */
  EAttribute getPrimitiveType_Type();

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
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.EnumerationType <em>Enumeration Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumeration Type</em>'.
   * @see org.eclipse.etrice.core.room.EnumerationType
   * @generated
   */
  EClass getEnumerationType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.EnumerationType#getPrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Primitive Type</em>'.
   * @see org.eclipse.etrice.core.room.EnumerationType#getPrimitiveType()
   * @see #getEnumerationType()
   * @generated
   */
  EReference getEnumerationType_PrimitiveType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.EnumerationType#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see org.eclipse.etrice.core.room.EnumerationType#getLiterals()
   * @see #getEnumerationType()
   * @generated
   */
  EReference getEnumerationType_Literals();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.EnumLiteral <em>Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Literal</em>'.
   * @see org.eclipse.etrice.core.room.EnumLiteral
   * @generated
   */
  EClass getEnumLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.EnumLiteral#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.EnumLiteral#getName()
   * @see #getEnumLiteral()
   * @generated
   */
  EAttribute getEnumLiteral_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.EnumLiteral#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Literal</em>'.
   * @see org.eclipse.etrice.core.room.EnumLiteral#getLiteral()
   * @see #getEnumLiteral()
   * @generated
   */
  EReference getEnumLiteral_Literal();

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
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ExternalType#getDefaultValueLiteral <em>Default Value Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default Value Literal</em>'.
   * @see org.eclipse.etrice.core.room.ExternalType#getDefaultValueLiteral()
   * @see #getExternalType()
   * @generated
   */
  EAttribute getExternalType_DefaultValueLiteral();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.DataClass#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.eclipse.etrice.core.room.DataClass#getAnnotations()
   * @see #getDataClass()
   * @generated
   */
  EReference getDataClass_Annotations();

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
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Attribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.etrice.core.room.Attribute#getType()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Type();

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
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.Operation#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Type</em>'.
   * @see org.eclipse.etrice.core.room.Operation#getReturnType()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_ReturnType();

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
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.StandardOperation#isDestructor <em>Destructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Destructor</em>'.
   * @see org.eclipse.etrice.core.room.StandardOperation#isDestructor()
   * @see #getStandardOperation()
   * @generated
   */
  EAttribute getStandardOperation_Destructor();

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
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.GeneralProtocolClass <em>General Protocol Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>General Protocol Class</em>'.
   * @see org.eclipse.etrice.core.room.GeneralProtocolClass
   * @generated
   */
  EClass getGeneralProtocolClass();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.GeneralProtocolClass#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.eclipse.etrice.core.room.GeneralProtocolClass#getAnnotations()
   * @see #getGeneralProtocolClass()
   * @generated
   */
  EReference getGeneralProtocolClass_Annotations();

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
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ProtocolClass#getConjugated <em>Conjugated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Conjugated</em>'.
   * @see org.eclipse.etrice.core.room.ProtocolClass#getConjugated()
   * @see #getProtocolClass()
   * @generated
   */
  EReference getProtocolClass_Conjugated();

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
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.CompoundProtocolClass <em>Compound Protocol Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compound Protocol Class</em>'.
   * @see org.eclipse.etrice.core.room.CompoundProtocolClass
   * @generated
   */
  EClass getCompoundProtocolClass();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.CompoundProtocolClass#getSubProtocols <em>Sub Protocols</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Protocols</em>'.
   * @see org.eclipse.etrice.core.room.CompoundProtocolClass#getSubProtocols()
   * @see #getCompoundProtocolClass()
   * @generated
   */
  EReference getCompoundProtocolClass_SubProtocols();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SubProtocol <em>Sub Protocol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Protocol</em>'.
   * @see org.eclipse.etrice.core.room.SubProtocol
   * @generated
   */
  EClass getSubProtocol();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.SubProtocol#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.room.SubProtocol#getName()
   * @see #getSubProtocol()
   * @generated
   */
  EAttribute getSubProtocol_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.SubProtocol#getProtocol <em>Protocol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Protocol</em>'.
   * @see org.eclipse.etrice.core.room.SubProtocol#getProtocol()
   * @see #getSubProtocol()
   * @generated
   */
  EReference getSubProtocol_Protocol();

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
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ActorClass <em>Actor Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actor Class</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass
   * @generated
   */
  EClass getActorClass();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getInterfacePorts <em>Interface Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interface Ports</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getInterfacePorts()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_InterfacePorts();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getInternalPorts <em>Internal Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Internal Ports</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getInternalPorts()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_InternalPorts();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getExternalPorts <em>External Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>External Ports</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getExternalPorts()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_ExternalPorts();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getServiceAccessPoints <em>Service Access Points</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Service Access Points</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getServiceAccessPoints()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_ServiceAccessPoints();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorClass#getBehaviorAnnotations <em>Behavior Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Behavior Annotations</em>'.
   * @see org.eclipse.etrice.core.room.ActorClass#getBehaviorAnnotations()
   * @see #getActorClass()
   * @generated
   */
  EReference getActorClass_BehaviorAnnotations();

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
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.InterfaceItem <em>Interface Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Item</em>'.
   * @see org.eclipse.etrice.core.room.InterfaceItem
   * @generated
   */
  EClass getInterfaceItem();

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
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.Port#getProtocol <em>Protocol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Protocol</em>'.
   * @see org.eclipse.etrice.core.room.Port#getProtocol()
   * @see #getPort()
   * @generated
   */
  EReference getPort_Protocol();

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
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.ExternalPort#getInterfacePort <em>Interface Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Interface Port</em>'.
   * @see org.eclipse.etrice.core.room.ExternalPort#getInterfacePort()
   * @see #getExternalPort()
   * @generated
   */
  EReference getExternalPort_InterfacePort();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SAP <em>SAP</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SAP</em>'.
   * @see org.eclipse.etrice.core.room.SAP
   * @generated
   */
  EClass getSAP();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.SAP#getProtocol <em>Protocol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Protocol</em>'.
   * @see org.eclipse.etrice.core.room.SAP#getProtocol()
   * @see #getSAP()
   * @generated
   */
  EReference getSAP_Protocol();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.SPP <em>SPP</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SPP</em>'.
   * @see org.eclipse.etrice.core.room.SPP
   * @generated
   */
  EClass getSPP();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.SPP#getProtocol <em>Protocol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Protocol</em>'.
   * @see org.eclipse.etrice.core.room.SPP#getProtocol()
   * @see #getSPP()
   * @generated
   */
  EReference getSPP_Protocol();

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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.SubSystemClass#getActorInstanceMappings <em>Actor Instance Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actor Instance Mappings</em>'.
   * @see org.eclipse.etrice.core.room.SubSystemClass#getActorInstanceMappings()
   * @see #getSubSystemClass()
   * @generated
   */
  EReference getSubSystemClass_ActorInstanceMappings();

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
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.ActorInstanceMapping <em>Actor Instance Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actor Instance Mapping</em>'.
   * @see org.eclipse.etrice.core.room.ActorInstanceMapping
   * @generated
   */
  EClass getActorInstanceMapping();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.room.ActorInstanceMapping#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see org.eclipse.etrice.core.room.ActorInstanceMapping#getPath()
   * @see #getActorInstanceMapping()
   * @generated
   */
  EReference getActorInstanceMapping_Path();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.ActorInstanceMapping#getThread <em>Thread</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Thread</em>'.
   * @see org.eclipse.etrice.core.room.ActorInstanceMapping#getThread()
   * @see #getActorInstanceMapping()
   * @generated
   */
  EReference getActorInstanceMapping_Thread();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.ActorInstanceMapping#getActorInstanceMappings <em>Actor Instance Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actor Instance Mappings</em>'.
   * @see org.eclipse.etrice.core.room.ActorInstanceMapping#getActorInstanceMappings()
   * @see #getActorInstanceMapping()
   * @generated
   */
  EReference getActorInstanceMapping_ActorInstanceMappings();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.RefPath <em>Ref Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Path</em>'.
   * @see org.eclipse.etrice.core.room.RefPath
   * @generated
   */
  EClass getRefPath();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.room.RefPath#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Refs</em>'.
   * @see org.eclipse.etrice.core.room.RefPath#getRefs()
   * @see #getRefPath()
   * @generated
   */
  EReference getRefPath_Refs();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.room.RefSegment <em>Ref Segment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Segment</em>'.
   * @see org.eclipse.etrice.core.room.RefSegment
   * @generated
   */
  EClass getRefSegment();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.RefSegment#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.eclipse.etrice.core.room.RefSegment#getRef()
   * @see #getRefSegment()
   * @generated
   */
  EAttribute getRefSegment_Ref();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.RefSegment#getIdx <em>Idx</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Idx</em>'.
   * @see org.eclipse.etrice.core.room.RefSegment#getIdx()
   * @see #getRefSegment()
   * @generated
   */
  EAttribute getRefSegment_Idx();

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
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.room.BindingEndPoint#getSub <em>Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Sub</em>'.
   * @see org.eclipse.etrice.core.room.BindingEndPoint#getSub()
   * @see #getBindingEndPoint()
   * @generated
   */
  EReference getBindingEndPoint_Sub();

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
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ActorRef#getRefType <em>Ref Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref Type</em>'.
   * @see org.eclipse.etrice.core.room.ActorRef#getRefType()
   * @see #getActorRef()
   * @generated
   */
  EAttribute getActorRef_RefType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.room.ActorRef#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see org.eclipse.etrice.core.room.ActorRef#getMultiplicity()
   * @see #getActorRef()
   * @generated
   */
  EAttribute getActorRef_Multiplicity();

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
   * Returns the meta object for enum '{@link org.eclipse.etrice.core.room.CommunicationType <em>Communication Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Communication Type</em>'.
   * @see org.eclipse.etrice.core.room.CommunicationType
   * @generated
   */
  EEnum getCommunicationType();

  /**
   * Returns the meta object for enum '{@link org.eclipse.etrice.core.room.ReferenceType <em>Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Reference Type</em>'.
   * @see org.eclipse.etrice.core.room.ReferenceType
   * @generated
   */
  EEnum getReferenceType();

  /**
   * Returns the meta object for enum '{@link org.eclipse.etrice.core.room.RoomAnnotationTargetEnum <em>Annotation Target Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Annotation Target Enum</em>'.
   * @see org.eclipse.etrice.core.room.RoomAnnotationTargetEnum
   * @generated
   */
  EEnum getRoomAnnotationTargetEnum();

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
     * The meta object literal for the '<em><b>Enumeration Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__ENUMERATION_TYPES = eINSTANCE.getRoomModel_EnumerationTypes();

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
     * The meta object literal for the '<em><b>Annotation Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOM_MODEL__ANNOTATION_TYPES = eINSTANCE.getRoomModel_AnnotationTypes();

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
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCTURE_CLASS__ANNOTATIONS = eINSTANCE.getStructureClass_Annotations();

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
     * The meta object literal for the '<em><b>Service Provision Points</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CONTAINER_CLASS__SERVICE_PROVISION_POINTS = eINSTANCE.getActorContainerClass_ServiceProvisionPoints();

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
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_TYPE__TYPE = eINSTANCE.getPrimitiveType_Type();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.EnumerationTypeImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getEnumerationType()
     * @generated
     */
    EClass ENUMERATION_TYPE = eINSTANCE.getEnumerationType();

    /**
     * The meta object literal for the '<em><b>Primitive Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATION_TYPE__PRIMITIVE_TYPE = eINSTANCE.getEnumerationType_PrimitiveType();

    /**
     * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATION_TYPE__LITERALS = eINSTANCE.getEnumerationType_Literals();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.EnumLiteralImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getEnumLiteral()
     * @generated
     */
    EClass ENUM_LITERAL = eINSTANCE.getEnumLiteral();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_LITERAL__NAME = eINSTANCE.getEnumLiteral_Name();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_LITERAL__LITERAL = eINSTANCE.getEnumLiteral_Literal();

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
     * The meta object literal for the '<em><b>Default Value Literal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_TYPE__DEFAULT_VALUE_LITERAL = eINSTANCE.getExternalType_DefaultValueLiteral();

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
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_CLASS__ANNOTATIONS = eINSTANCE.getDataClass_Annotations();

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
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

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
     * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__RETURN_TYPE = eINSTANCE.getOperation_ReturnType();

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
     * The meta object literal for the '<em><b>Destructor</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STANDARD_OPERATION__DESTRUCTOR = eINSTANCE.getStandardOperation_Destructor();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.GeneralProtocolClassImpl <em>General Protocol Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.GeneralProtocolClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getGeneralProtocolClass()
     * @generated
     */
    EClass GENERAL_PROTOCOL_CLASS = eINSTANCE.getGeneralProtocolClass();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GENERAL_PROTOCOL_CLASS__ANNOTATIONS = eINSTANCE.getGeneralProtocolClass_Annotations();

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
     * The meta object literal for the '<em><b>Conjugated</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__CONJUGATED = eINSTANCE.getProtocolClass_Conjugated();

    /**
     * The meta object literal for the '<em><b>Semantics</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS__SEMANTICS = eINSTANCE.getProtocolClass_Semantics();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.CompoundProtocolClassImpl <em>Compound Protocol Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.CompoundProtocolClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getCompoundProtocolClass()
     * @generated
     */
    EClass COMPOUND_PROTOCOL_CLASS = eINSTANCE.getCompoundProtocolClass();

    /**
     * The meta object literal for the '<em><b>Sub Protocols</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS = eINSTANCE.getCompoundProtocolClass_SubProtocols();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SubProtocolImpl <em>Sub Protocol</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SubProtocolImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSubProtocol()
     * @generated
     */
    EClass SUB_PROTOCOL = eINSTANCE.getSubProtocol();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUB_PROTOCOL__NAME = eINSTANCE.getSubProtocol_Name();

    /**
     * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_PROTOCOL__PROTOCOL = eINSTANCE.getSubProtocol_Protocol();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ActorClassImpl <em>Actor Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ActorClassImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorClass()
     * @generated
     */
    EClass ACTOR_CLASS = eINSTANCE.getActorClass();

    /**
     * The meta object literal for the '<em><b>Interface Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__INTERFACE_PORTS = eINSTANCE.getActorClass_InterfacePorts();

    /**
     * The meta object literal for the '<em><b>Structure Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__STRUCTURE_DOCU = eINSTANCE.getActorClass_StructureDocu();

    /**
     * The meta object literal for the '<em><b>Internal Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__INTERNAL_PORTS = eINSTANCE.getActorClass_InternalPorts();

    /**
     * The meta object literal for the '<em><b>External Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__EXTERNAL_PORTS = eINSTANCE.getActorClass_ExternalPorts();

    /**
     * The meta object literal for the '<em><b>Service Implementations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__SERVICE_IMPLEMENTATIONS = eINSTANCE.getActorClass_ServiceImplementations();

    /**
     * The meta object literal for the '<em><b>Service Access Points</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__SERVICE_ACCESS_POINTS = eINSTANCE.getActorClass_ServiceAccessPoints();

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
     * The meta object literal for the '<em><b>Behavior Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__BEHAVIOR_ANNOTATIONS = eINSTANCE.getActorClass_BehaviorAnnotations();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS__OPERATIONS = eINSTANCE.getActorClass_Operations();

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
     * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT__PROTOCOL = eINSTANCE.getPort_Protocol();

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
     * The meta object literal for the '<em><b>Interface Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_PORT__INTERFACE_PORT = eINSTANCE.getExternalPort_InterfacePort();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SAPImpl <em>SAP</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SAPImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSAP()
     * @generated
     */
    EClass SAP = eINSTANCE.getSAP();

    /**
     * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAP__PROTOCOL = eINSTANCE.getSAP_Protocol();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.SPPImpl <em>SPP</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.SPPImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getSPP()
     * @generated
     */
    EClass SPP = eINSTANCE.getSPP();

    /**
     * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPP__PROTOCOL = eINSTANCE.getSPP_Protocol();

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
     * The meta object literal for the '<em><b>Actor Instance Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_CLASS__ACTOR_INSTANCE_MAPPINGS = eINSTANCE.getSubSystemClass_ActorInstanceMappings();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.ActorInstanceMappingImpl <em>Actor Instance Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.ActorInstanceMappingImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getActorInstanceMapping()
     * @generated
     */
    EClass ACTOR_INSTANCE_MAPPING = eINSTANCE.getActorInstanceMapping();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_INSTANCE_MAPPING__PATH = eINSTANCE.getActorInstanceMapping_Path();

    /**
     * The meta object literal for the '<em><b>Thread</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_INSTANCE_MAPPING__THREAD = eINSTANCE.getActorInstanceMapping_Thread();

    /**
     * The meta object literal for the '<em><b>Actor Instance Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_INSTANCE_MAPPING__ACTOR_INSTANCE_MAPPINGS = eINSTANCE.getActorInstanceMapping_ActorInstanceMappings();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.RefPathImpl <em>Ref Path</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.RefPathImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefPath()
     * @generated
     */
    EClass REF_PATH = eINSTANCE.getRefPath();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_PATH__REFS = eINSTANCE.getRefPath_Refs();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.impl.RefSegmentImpl <em>Ref Segment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.impl.RefSegmentImpl
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRefSegment()
     * @generated
     */
    EClass REF_SEGMENT = eINSTANCE.getRefSegment();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REF_SEGMENT__REF = eINSTANCE.getRefSegment_Ref();

    /**
     * The meta object literal for the '<em><b>Idx</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REF_SEGMENT__IDX = eINSTANCE.getRefSegment_Idx();

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
     * The meta object literal for the '<em><b>Sub</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINDING_END_POINT__SUB = eINSTANCE.getBindingEndPoint_Sub();

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
     * The meta object literal for the '<em><b>Ref Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTOR_REF__REF_TYPE = eINSTANCE.getActorRef_RefType();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTOR_REF__MULTIPLICITY = eINSTANCE.getActorRef_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_REF__TYPE = eINSTANCE.getActorRef_Type();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.ReferenceType <em>Reference Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.ReferenceType
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getReferenceType()
     * @generated
     */
    EEnum REFERENCE_TYPE = eINSTANCE.getReferenceType();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.room.RoomAnnotationTargetEnum <em>Annotation Target Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.room.RoomAnnotationTargetEnum
     * @see org.eclipse.etrice.core.room.impl.RoomPackageImpl#getRoomAnnotationTargetEnum()
     * @generated
     */
    EEnum ROOM_ANNOTATION_TARGET_ENUM = eINSTANCE.getRoomAnnotationTargetEnum();

  }

} //RoomPackage
