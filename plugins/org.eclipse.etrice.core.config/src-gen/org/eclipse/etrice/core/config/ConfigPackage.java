/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.etrice.core.config.ConfigFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "config";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/etrice/core/Config";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "config";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ConfigPackage eINSTANCE = org.eclipse.etrice.core.config.impl.ConfigPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.ConfigModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.ConfigModelImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getConfigModel()
   * @generated
   */
  int CONFIG_MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_MODEL__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Config Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_MODEL__CONFIG_ELEMENTS = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.ConfigElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.ConfigElementImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getConfigElement()
   * @generated
   */
  int CONFIG_ELEMENT = 1;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.SubSystemConfigImpl <em>Sub System Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.SubSystemConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getSubSystemConfig()
   * @generated
   */
  int SUB_SYSTEM_CONFIG = 2;

  /**
   * The feature id for the '<em><b>Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CONFIG__ROOT = CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sub System</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CONFIG__SUB_SYSTEM = CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Dyn Config</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CONFIG__DYN_CONFIG = CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Sub System Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_CONFIG_FEATURE_COUNT = CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.DynamicConfigImpl <em>Dynamic Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.DynamicConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getDynamicConfig()
   * @generated
   */
  int DYNAMIC_CONFIG = 3;

  /**
   * The feature id for the '<em><b>File Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DYNAMIC_CONFIG__FILE_PATH = 0;

  /**
   * The feature id for the '<em><b>User Code1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DYNAMIC_CONFIG__USER_CODE1 = 1;

  /**
   * The feature id for the '<em><b>User Code2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DYNAMIC_CONFIG__USER_CODE2 = 2;

  /**
   * The feature id for the '<em><b>Polling</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DYNAMIC_CONFIG__POLLING = 3;

  /**
   * The number of structural features of the '<em>Dynamic Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DYNAMIC_CONFIG_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.ActorClassConfigImpl <em>Actor Class Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.ActorClassConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getActorClassConfig()
   * @generated
   */
  int ACTOR_CLASS_CONFIG = 4;

  /**
   * The feature id for the '<em><b>Actor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS_CONFIG__ACTOR = CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS_CONFIG__ATTRIBUTES = CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Actor Class Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS_CONFIG_FEATURE_COUNT = CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.ActorInstanceConfigImpl <em>Actor Instance Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.ActorInstanceConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getActorInstanceConfig()
   * @generated
   */
  int ACTOR_INSTANCE_CONFIG = 5;

  /**
   * The feature id for the '<em><b>Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_CONFIG__ROOT = CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sub System</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_CONFIG__SUB_SYSTEM = CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_CONFIG__PATH = CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_CONFIG__ATTRIBUTES = CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_CONFIG__PORTS = CONFIG_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Actor Instance Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_INSTANCE_CONFIG_FEATURE_COUNT = CONFIG_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.ProtocolClassConfigImpl <em>Protocol Class Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.ProtocolClassConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getProtocolClassConfig()
   * @generated
   */
  int PROTOCOL_CLASS_CONFIG = 6;

  /**
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS_CONFIG__PROTOCOL = CONFIG_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Regular</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS_CONFIG__REGULAR = CONFIG_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Conjugated</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS_CONFIG__CONJUGATED = CONFIG_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Protocol Class Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_CLASS_CONFIG_FEATURE_COUNT = CONFIG_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.PortClassConfigImpl <em>Port Class Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.PortClassConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getPortClassConfig()
   * @generated
   */
  int PORT_CLASS_CONFIG = 7;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_CLASS_CONFIG__ATTRIBUTES = 0;

  /**
   * The number of structural features of the '<em>Port Class Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_CLASS_CONFIG_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.PortInstanceConfigImpl <em>Port Instance Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.PortInstanceConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getPortInstanceConfig()
   * @generated
   */
  int PORT_INSTANCE_CONFIG = 8;

  /**
   * The feature id for the '<em><b>Item</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_INSTANCE_CONFIG__ITEM = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_INSTANCE_CONFIG__ATTRIBUTES = 1;

  /**
   * The number of structural features of the '<em>Port Instance Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_INSTANCE_CONFIG_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.AttrConfigImpl <em>Attr Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.AttrConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getAttrConfig()
   * @generated
   */
  int ATTR_CONFIG = 9;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_CONFIG__ATTRIBUTE = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_CONFIG__VALUE = 1;

  /**
   * The number of structural features of the '<em>Attr Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_CONFIG_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.AttrClassConfigImpl <em>Attr Class Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.AttrClassConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getAttrClassConfig()
   * @generated
   */
  int ATTR_CLASS_CONFIG = 10;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_CLASS_CONFIG__ATTRIBUTE = ATTR_CONFIG__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_CLASS_CONFIG__VALUE = ATTR_CONFIG__VALUE;

  /**
   * The feature id for the '<em><b>Min</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_CLASS_CONFIG__MIN = ATTR_CONFIG_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Max</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_CLASS_CONFIG__MAX = ATTR_CONFIG_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_CLASS_CONFIG__ATTRIBUTES = ATTR_CONFIG_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Attr Class Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_CLASS_CONFIG_FEATURE_COUNT = ATTR_CONFIG_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.AttrInstanceConfigImpl <em>Attr Instance Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.AttrInstanceConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getAttrInstanceConfig()
   * @generated
   */
  int ATTR_INSTANCE_CONFIG = 11;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_INSTANCE_CONFIG__ATTRIBUTE = ATTR_CONFIG__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_INSTANCE_CONFIG__VALUE = ATTR_CONFIG__VALUE;

  /**
   * The feature id for the '<em><b>Dyn Config</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_INSTANCE_CONFIG__DYN_CONFIG = ATTR_CONFIG_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Read Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_INSTANCE_CONFIG__READ_ONLY = ATTR_CONFIG_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_INSTANCE_CONFIG__ATTRIBUTES = ATTR_CONFIG_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Attr Instance Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTR_INSTANCE_CONFIG_FEATURE_COUNT = ATTR_CONFIG_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.ConfigValueArrayImpl <em>Value Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.ConfigValueArrayImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getConfigValueArray()
   * @generated
   */
  int CONFIG_VALUE_ARRAY = 12;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_VALUE_ARRAY__VALUES = 0;

  /**
   * The number of structural features of the '<em>Value Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_VALUE_ARRAY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.ConfigValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.ConfigValueImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getConfigValue()
   * @generated
   */
  int CONFIG_VALUE = 13;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.LiteralConfigValueImpl <em>Literal Config Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.LiteralConfigValueImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getLiteralConfigValue()
   * @generated
   */
  int LITERAL_CONFIG_VALUE = 14;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_CONFIG_VALUE__VALUE = CONFIG_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal Config Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_CONFIG_VALUE_FEATURE_COUNT = CONFIG_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.EnumConfigValueImpl <em>Enum Config Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.EnumConfigValueImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getEnumConfigValue()
   * @generated
   */
  int ENUM_CONFIG_VALUE = 15;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_CONFIG_VALUE__TYPE = CONFIG_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_CONFIG_VALUE__VALUE = CONFIG_VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enum Config Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_CONFIG_VALUE_FEATURE_COUNT = CONFIG_VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.RefPathImpl <em>Ref Path</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.RefPathImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getRefPath()
   * @generated
   */
  int REF_PATH = 16;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.RefSegmentImpl <em>Ref Segment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.RefSegmentImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getRefSegment()
   * @generated
   */
  int REF_SEGMENT = 17;

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
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.ConfigModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.etrice.core.config.ConfigModel
   * @generated
   */
  EClass getConfigModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.config.ConfigModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.config.ConfigModel#getName()
   * @see #getConfigModel()
   * @generated
   */
  EAttribute getConfigModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.ConfigModel#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.etrice.core.config.ConfigModel#getImports()
   * @see #getConfigModel()
   * @generated
   */
  EReference getConfigModel_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.ConfigModel#getConfigElements <em>Config Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Config Elements</em>'.
   * @see org.eclipse.etrice.core.config.ConfigModel#getConfigElements()
   * @see #getConfigModel()
   * @generated
   */
  EReference getConfigModel_ConfigElements();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.ConfigElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see org.eclipse.etrice.core.config.ConfigElement
   * @generated
   */
  EClass getConfigElement();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.SubSystemConfig <em>Sub System Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub System Config</em>'.
   * @see org.eclipse.etrice.core.config.SubSystemConfig
   * @generated
   */
  EClass getSubSystemConfig();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.SubSystemConfig#getRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Root</em>'.
   * @see org.eclipse.etrice.core.config.SubSystemConfig#getRoot()
   * @see #getSubSystemConfig()
   * @generated
   */
  EReference getSubSystemConfig_Root();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.SubSystemConfig#getSubSystem <em>Sub System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Sub System</em>'.
   * @see org.eclipse.etrice.core.config.SubSystemConfig#getSubSystem()
   * @see #getSubSystemConfig()
   * @generated
   */
  EReference getSubSystemConfig_SubSystem();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.config.SubSystemConfig#getDynConfig <em>Dyn Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dyn Config</em>'.
   * @see org.eclipse.etrice.core.config.SubSystemConfig#getDynConfig()
   * @see #getSubSystemConfig()
   * @generated
   */
  EReference getSubSystemConfig_DynConfig();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.DynamicConfig <em>Dynamic Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dynamic Config</em>'.
   * @see org.eclipse.etrice.core.config.DynamicConfig
   * @generated
   */
  EClass getDynamicConfig();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.config.DynamicConfig#getFilePath <em>File Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File Path</em>'.
   * @see org.eclipse.etrice.core.config.DynamicConfig#getFilePath()
   * @see #getDynamicConfig()
   * @generated
   */
  EAttribute getDynamicConfig_FilePath();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.config.DynamicConfig#getUserCode1 <em>User Code1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>User Code1</em>'.
   * @see org.eclipse.etrice.core.config.DynamicConfig#getUserCode1()
   * @see #getDynamicConfig()
   * @generated
   */
  EAttribute getDynamicConfig_UserCode1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.config.DynamicConfig#getUserCode2 <em>User Code2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>User Code2</em>'.
   * @see org.eclipse.etrice.core.config.DynamicConfig#getUserCode2()
   * @see #getDynamicConfig()
   * @generated
   */
  EAttribute getDynamicConfig_UserCode2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.config.DynamicConfig#getPolling <em>Polling</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Polling</em>'.
   * @see org.eclipse.etrice.core.config.DynamicConfig#getPolling()
   * @see #getDynamicConfig()
   * @generated
   */
  EAttribute getDynamicConfig_Polling();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.ActorClassConfig <em>Actor Class Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actor Class Config</em>'.
   * @see org.eclipse.etrice.core.config.ActorClassConfig
   * @generated
   */
  EClass getActorClassConfig();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.ActorClassConfig#getActor <em>Actor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Actor</em>'.
   * @see org.eclipse.etrice.core.config.ActorClassConfig#getActor()
   * @see #getActorClassConfig()
   * @generated
   */
  EReference getActorClassConfig_Actor();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.ActorClassConfig#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.config.ActorClassConfig#getAttributes()
   * @see #getActorClassConfig()
   * @generated
   */
  EReference getActorClassConfig_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.ActorInstanceConfig <em>Actor Instance Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actor Instance Config</em>'.
   * @see org.eclipse.etrice.core.config.ActorInstanceConfig
   * @generated
   */
  EClass getActorInstanceConfig();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Root</em>'.
   * @see org.eclipse.etrice.core.config.ActorInstanceConfig#getRoot()
   * @see #getActorInstanceConfig()
   * @generated
   */
  EReference getActorInstanceConfig_Root();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getSubSystem <em>Sub System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Sub System</em>'.
   * @see org.eclipse.etrice.core.config.ActorInstanceConfig#getSubSystem()
   * @see #getActorInstanceConfig()
   * @generated
   */
  EReference getActorInstanceConfig_SubSystem();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see org.eclipse.etrice.core.config.ActorInstanceConfig#getPath()
   * @see #getActorInstanceConfig()
   * @generated
   */
  EReference getActorInstanceConfig_Path();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.config.ActorInstanceConfig#getAttributes()
   * @see #getActorInstanceConfig()
   * @generated
   */
  EReference getActorInstanceConfig_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.ActorInstanceConfig#getPorts <em>Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ports</em>'.
   * @see org.eclipse.etrice.core.config.ActorInstanceConfig#getPorts()
   * @see #getActorInstanceConfig()
   * @generated
   */
  EReference getActorInstanceConfig_Ports();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.ProtocolClassConfig <em>Protocol Class Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Protocol Class Config</em>'.
   * @see org.eclipse.etrice.core.config.ProtocolClassConfig
   * @generated
   */
  EClass getProtocolClassConfig();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.ProtocolClassConfig#getProtocol <em>Protocol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Protocol</em>'.
   * @see org.eclipse.etrice.core.config.ProtocolClassConfig#getProtocol()
   * @see #getProtocolClassConfig()
   * @generated
   */
  EReference getProtocolClassConfig_Protocol();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.config.ProtocolClassConfig#getRegular <em>Regular</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Regular</em>'.
   * @see org.eclipse.etrice.core.config.ProtocolClassConfig#getRegular()
   * @see #getProtocolClassConfig()
   * @generated
   */
  EReference getProtocolClassConfig_Regular();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.config.ProtocolClassConfig#getConjugated <em>Conjugated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Conjugated</em>'.
   * @see org.eclipse.etrice.core.config.ProtocolClassConfig#getConjugated()
   * @see #getProtocolClassConfig()
   * @generated
   */
  EReference getProtocolClassConfig_Conjugated();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.PortClassConfig <em>Port Class Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Class Config</em>'.
   * @see org.eclipse.etrice.core.config.PortClassConfig
   * @generated
   */
  EClass getPortClassConfig();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.PortClassConfig#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.config.PortClassConfig#getAttributes()
   * @see #getPortClassConfig()
   * @generated
   */
  EReference getPortClassConfig_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.PortInstanceConfig <em>Port Instance Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Instance Config</em>'.
   * @see org.eclipse.etrice.core.config.PortInstanceConfig
   * @generated
   */
  EClass getPortInstanceConfig();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.PortInstanceConfig#getItem <em>Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Item</em>'.
   * @see org.eclipse.etrice.core.config.PortInstanceConfig#getItem()
   * @see #getPortInstanceConfig()
   * @generated
   */
  EReference getPortInstanceConfig_Item();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.PortInstanceConfig#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.config.PortInstanceConfig#getAttributes()
   * @see #getPortInstanceConfig()
   * @generated
   */
  EReference getPortInstanceConfig_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.AttrConfig <em>Attr Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Config</em>'.
   * @see org.eclipse.etrice.core.config.AttrConfig
   * @generated
   */
  EClass getAttrConfig();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.AttrConfig#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.eclipse.etrice.core.config.AttrConfig#getAttribute()
   * @see #getAttrConfig()
   * @generated
   */
  EReference getAttrConfig_Attribute();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.config.AttrConfig#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.etrice.core.config.AttrConfig#getValue()
   * @see #getAttrConfig()
   * @generated
   */
  EReference getAttrConfig_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.AttrClassConfig <em>Attr Class Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Class Config</em>'.
   * @see org.eclipse.etrice.core.config.AttrClassConfig
   * @generated
   */
  EClass getAttrClassConfig();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.config.AttrClassConfig#getMin <em>Min</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Min</em>'.
   * @see org.eclipse.etrice.core.config.AttrClassConfig#getMin()
   * @see #getAttrClassConfig()
   * @generated
   */
  EReference getAttrClassConfig_Min();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.config.AttrClassConfig#getMax <em>Max</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Max</em>'.
   * @see org.eclipse.etrice.core.config.AttrClassConfig#getMax()
   * @see #getAttrClassConfig()
   * @generated
   */
  EReference getAttrClassConfig_Max();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.AttrClassConfig#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.config.AttrClassConfig#getAttributes()
   * @see #getAttrClassConfig()
   * @generated
   */
  EReference getAttrClassConfig_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.AttrInstanceConfig <em>Attr Instance Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attr Instance Config</em>'.
   * @see org.eclipse.etrice.core.config.AttrInstanceConfig
   * @generated
   */
  EClass getAttrInstanceConfig();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isDynConfig <em>Dyn Config</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dyn Config</em>'.
   * @see org.eclipse.etrice.core.config.AttrInstanceConfig#isDynConfig()
   * @see #getAttrInstanceConfig()
   * @generated
   */
  EAttribute getAttrInstanceConfig_DynConfig();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.config.AttrInstanceConfig#isReadOnly <em>Read Only</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Read Only</em>'.
   * @see org.eclipse.etrice.core.config.AttrInstanceConfig#isReadOnly()
   * @see #getAttrInstanceConfig()
   * @generated
   */
  EAttribute getAttrInstanceConfig_ReadOnly();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.AttrInstanceConfig#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.config.AttrInstanceConfig#getAttributes()
   * @see #getAttrInstanceConfig()
   * @generated
   */
  EReference getAttrInstanceConfig_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.ConfigValueArray <em>Value Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Array</em>'.
   * @see org.eclipse.etrice.core.config.ConfigValueArray
   * @generated
   */
  EClass getConfigValueArray();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.ConfigValueArray#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.etrice.core.config.ConfigValueArray#getValues()
   * @see #getConfigValueArray()
   * @generated
   */
  EReference getConfigValueArray_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.ConfigValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see org.eclipse.etrice.core.config.ConfigValue
   * @generated
   */
  EClass getConfigValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.LiteralConfigValue <em>Literal Config Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Config Value</em>'.
   * @see org.eclipse.etrice.core.config.LiteralConfigValue
   * @generated
   */
  EClass getLiteralConfigValue();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.config.LiteralConfigValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.etrice.core.config.LiteralConfigValue#getValue()
   * @see #getLiteralConfigValue()
   * @generated
   */
  EReference getLiteralConfigValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.EnumConfigValue <em>Enum Config Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Config Value</em>'.
   * @see org.eclipse.etrice.core.config.EnumConfigValue
   * @generated
   */
  EClass getEnumConfigValue();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.EnumConfigValue#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.etrice.core.config.EnumConfigValue#getType()
   * @see #getEnumConfigValue()
   * @generated
   */
  EReference getEnumConfigValue_Type();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.EnumConfigValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.eclipse.etrice.core.config.EnumConfigValue#getValue()
   * @see #getEnumConfigValue()
   * @generated
   */
  EReference getEnumConfigValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.RefPath <em>Ref Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Path</em>'.
   * @see org.eclipse.etrice.core.config.RefPath
   * @generated
   */
  EClass getRefPath();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.RefPath#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Refs</em>'.
   * @see org.eclipse.etrice.core.config.RefPath#getRefs()
   * @see #getRefPath()
   * @generated
   */
  EReference getRefPath_Refs();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.config.RefSegment <em>Ref Segment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Segment</em>'.
   * @see org.eclipse.etrice.core.config.RefSegment
   * @generated
   */
  EClass getRefSegment();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.config.RefSegment#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.eclipse.etrice.core.config.RefSegment#getRef()
   * @see #getRefSegment()
   * @generated
   */
  EAttribute getRefSegment_Ref();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.config.RefSegment#getIdx <em>Idx</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Idx</em>'.
   * @see org.eclipse.etrice.core.config.RefSegment#getIdx()
   * @see #getRefSegment()
   * @generated
   */
  EAttribute getRefSegment_Idx();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ConfigFactory getConfigFactory();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.ConfigModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.ConfigModelImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getConfigModel()
     * @generated
     */
    EClass CONFIG_MODEL = eINSTANCE.getConfigModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIG_MODEL__NAME = eINSTANCE.getConfigModel_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONFIG_MODEL__IMPORTS = eINSTANCE.getConfigModel_Imports();

    /**
     * The meta object literal for the '<em><b>Config Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONFIG_MODEL__CONFIG_ELEMENTS = eINSTANCE.getConfigModel_ConfigElements();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.ConfigElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.ConfigElementImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getConfigElement()
     * @generated
     */
    EClass CONFIG_ELEMENT = eINSTANCE.getConfigElement();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.SubSystemConfigImpl <em>Sub System Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.SubSystemConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getSubSystemConfig()
     * @generated
     */
    EClass SUB_SYSTEM_CONFIG = eINSTANCE.getSubSystemConfig();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_CONFIG__ROOT = eINSTANCE.getSubSystemConfig_Root();

    /**
     * The meta object literal for the '<em><b>Sub System</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_CONFIG__SUB_SYSTEM = eINSTANCE.getSubSystemConfig_SubSystem();

    /**
     * The meta object literal for the '<em><b>Dyn Config</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_CONFIG__DYN_CONFIG = eINSTANCE.getSubSystemConfig_DynConfig();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.DynamicConfigImpl <em>Dynamic Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.DynamicConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getDynamicConfig()
     * @generated
     */
    EClass DYNAMIC_CONFIG = eINSTANCE.getDynamicConfig();

    /**
     * The meta object literal for the '<em><b>File Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DYNAMIC_CONFIG__FILE_PATH = eINSTANCE.getDynamicConfig_FilePath();

    /**
     * The meta object literal for the '<em><b>User Code1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DYNAMIC_CONFIG__USER_CODE1 = eINSTANCE.getDynamicConfig_UserCode1();

    /**
     * The meta object literal for the '<em><b>User Code2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DYNAMIC_CONFIG__USER_CODE2 = eINSTANCE.getDynamicConfig_UserCode2();

    /**
     * The meta object literal for the '<em><b>Polling</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DYNAMIC_CONFIG__POLLING = eINSTANCE.getDynamicConfig_Polling();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.ActorClassConfigImpl <em>Actor Class Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.ActorClassConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getActorClassConfig()
     * @generated
     */
    EClass ACTOR_CLASS_CONFIG = eINSTANCE.getActorClassConfig();

    /**
     * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS_CONFIG__ACTOR = eINSTANCE.getActorClassConfig_Actor();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS_CONFIG__ATTRIBUTES = eINSTANCE.getActorClassConfig_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.ActorInstanceConfigImpl <em>Actor Instance Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.ActorInstanceConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getActorInstanceConfig()
     * @generated
     */
    EClass ACTOR_INSTANCE_CONFIG = eINSTANCE.getActorInstanceConfig();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_INSTANCE_CONFIG__ROOT = eINSTANCE.getActorInstanceConfig_Root();

    /**
     * The meta object literal for the '<em><b>Sub System</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_INSTANCE_CONFIG__SUB_SYSTEM = eINSTANCE.getActorInstanceConfig_SubSystem();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_INSTANCE_CONFIG__PATH = eINSTANCE.getActorInstanceConfig_Path();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_INSTANCE_CONFIG__ATTRIBUTES = eINSTANCE.getActorInstanceConfig_Attributes();

    /**
     * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_INSTANCE_CONFIG__PORTS = eINSTANCE.getActorInstanceConfig_Ports();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.ProtocolClassConfigImpl <em>Protocol Class Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.ProtocolClassConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getProtocolClassConfig()
     * @generated
     */
    EClass PROTOCOL_CLASS_CONFIG = eINSTANCE.getProtocolClassConfig();

    /**
     * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS_CONFIG__PROTOCOL = eINSTANCE.getProtocolClassConfig_Protocol();

    /**
     * The meta object literal for the '<em><b>Regular</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS_CONFIG__REGULAR = eINSTANCE.getProtocolClassConfig_Regular();

    /**
     * The meta object literal for the '<em><b>Conjugated</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL_CLASS_CONFIG__CONJUGATED = eINSTANCE.getProtocolClassConfig_Conjugated();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.PortClassConfigImpl <em>Port Class Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.PortClassConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getPortClassConfig()
     * @generated
     */
    EClass PORT_CLASS_CONFIG = eINSTANCE.getPortClassConfig();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_CLASS_CONFIG__ATTRIBUTES = eINSTANCE.getPortClassConfig_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.PortInstanceConfigImpl <em>Port Instance Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.PortInstanceConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getPortInstanceConfig()
     * @generated
     */
    EClass PORT_INSTANCE_CONFIG = eINSTANCE.getPortInstanceConfig();

    /**
     * The meta object literal for the '<em><b>Item</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_INSTANCE_CONFIG__ITEM = eINSTANCE.getPortInstanceConfig_Item();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_INSTANCE_CONFIG__ATTRIBUTES = eINSTANCE.getPortInstanceConfig_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.AttrConfigImpl <em>Attr Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.AttrConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getAttrConfig()
     * @generated
     */
    EClass ATTR_CONFIG = eINSTANCE.getAttrConfig();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_CONFIG__ATTRIBUTE = eINSTANCE.getAttrConfig_Attribute();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_CONFIG__VALUE = eINSTANCE.getAttrConfig_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.AttrClassConfigImpl <em>Attr Class Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.AttrClassConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getAttrClassConfig()
     * @generated
     */
    EClass ATTR_CLASS_CONFIG = eINSTANCE.getAttrClassConfig();

    /**
     * The meta object literal for the '<em><b>Min</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_CLASS_CONFIG__MIN = eINSTANCE.getAttrClassConfig_Min();

    /**
     * The meta object literal for the '<em><b>Max</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_CLASS_CONFIG__MAX = eINSTANCE.getAttrClassConfig_Max();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_CLASS_CONFIG__ATTRIBUTES = eINSTANCE.getAttrClassConfig_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.AttrInstanceConfigImpl <em>Attr Instance Config</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.AttrInstanceConfigImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getAttrInstanceConfig()
     * @generated
     */
    EClass ATTR_INSTANCE_CONFIG = eINSTANCE.getAttrInstanceConfig();

    /**
     * The meta object literal for the '<em><b>Dyn Config</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTR_INSTANCE_CONFIG__DYN_CONFIG = eINSTANCE.getAttrInstanceConfig_DynConfig();

    /**
     * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTR_INSTANCE_CONFIG__READ_ONLY = eINSTANCE.getAttrInstanceConfig_ReadOnly();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTR_INSTANCE_CONFIG__ATTRIBUTES = eINSTANCE.getAttrInstanceConfig_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.ConfigValueArrayImpl <em>Value Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.ConfigValueArrayImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getConfigValueArray()
     * @generated
     */
    EClass CONFIG_VALUE_ARRAY = eINSTANCE.getConfigValueArray();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONFIG_VALUE_ARRAY__VALUES = eINSTANCE.getConfigValueArray_Values();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.ConfigValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.ConfigValueImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getConfigValue()
     * @generated
     */
    EClass CONFIG_VALUE = eINSTANCE.getConfigValue();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.LiteralConfigValueImpl <em>Literal Config Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.LiteralConfigValueImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getLiteralConfigValue()
     * @generated
     */
    EClass LITERAL_CONFIG_VALUE = eINSTANCE.getLiteralConfigValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LITERAL_CONFIG_VALUE__VALUE = eINSTANCE.getLiteralConfigValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.EnumConfigValueImpl <em>Enum Config Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.EnumConfigValueImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getEnumConfigValue()
     * @generated
     */
    EClass ENUM_CONFIG_VALUE = eINSTANCE.getEnumConfigValue();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_CONFIG_VALUE__TYPE = eINSTANCE.getEnumConfigValue_Type();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_CONFIG_VALUE__VALUE = eINSTANCE.getEnumConfigValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.RefPathImpl <em>Ref Path</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.RefPathImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getRefPath()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.config.impl.RefSegmentImpl <em>Ref Segment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.config.impl.RefSegmentImpl
     * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getRefSegment()
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

  }

} //ConfigPackage
