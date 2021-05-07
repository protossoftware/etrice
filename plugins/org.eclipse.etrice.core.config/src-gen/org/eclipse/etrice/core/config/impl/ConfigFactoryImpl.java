/**
 * generated by Xtext
 */
package org.eclipse.etrice.core.config.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.etrice.core.config.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigFactoryImpl extends EFactoryImpl implements ConfigFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ConfigFactory init()
  {
    try
    {
      ConfigFactory theConfigFactory = (ConfigFactory)EPackage.Registry.INSTANCE.getEFactory(ConfigPackage.eNS_URI);
      if (theConfigFactory != null)
      {
        return theConfigFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ConfigFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfigFactoryImpl()
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
      case ConfigPackage.CONFIG_MODEL: return createConfigModel();
      case ConfigPackage.CONFIG_ELEMENT: return createConfigElement();
      case ConfigPackage.SUB_SYSTEM_CONFIG: return createSubSystemConfig();
      case ConfigPackage.DYNAMIC_CONFIG: return createDynamicConfig();
      case ConfigPackage.ACTOR_CLASS_CONFIG: return createActorClassConfig();
      case ConfigPackage.ACTOR_INSTANCE_CONFIG: return createActorInstanceConfig();
      case ConfigPackage.PROTOCOL_CLASS_CONFIG: return createProtocolClassConfig();
      case ConfigPackage.PORT_CLASS_CONFIG: return createPortClassConfig();
      case ConfigPackage.PORT_INSTANCE_CONFIG: return createPortInstanceConfig();
      case ConfigPackage.ATTR_CONFIG: return createAttrConfig();
      case ConfigPackage.ATTR_CLASS_CONFIG: return createAttrClassConfig();
      case ConfigPackage.ATTR_INSTANCE_CONFIG: return createAttrInstanceConfig();
      case ConfigPackage.CONFIG_VALUE_ARRAY: return createConfigValueArray();
      case ConfigPackage.CONFIG_VALUE: return createConfigValue();
      case ConfigPackage.LITERAL_CONFIG_VALUE: return createLiteralConfigValue();
      case ConfigPackage.ENUM_CONFIG_VALUE: return createEnumConfigValue();
      case ConfigPackage.REF_PATH: return createRefPath();
      case ConfigPackage.REF_SEGMENT: return createRefSegment();
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
  public ConfigModel createConfigModel()
  {
    ConfigModelImpl configModel = new ConfigModelImpl();
    return configModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConfigElement createConfigElement()
  {
    ConfigElementImpl configElement = new ConfigElementImpl();
    return configElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SubSystemConfig createSubSystemConfig()
  {
    SubSystemConfigImpl subSystemConfig = new SubSystemConfigImpl();
    return subSystemConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DynamicConfig createDynamicConfig()
  {
    DynamicConfigImpl dynamicConfig = new DynamicConfigImpl();
    return dynamicConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ActorClassConfig createActorClassConfig()
  {
    ActorClassConfigImpl actorClassConfig = new ActorClassConfigImpl();
    return actorClassConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ActorInstanceConfig createActorInstanceConfig()
  {
    ActorInstanceConfigImpl actorInstanceConfig = new ActorInstanceConfigImpl();
    return actorInstanceConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ProtocolClassConfig createProtocolClassConfig()
  {
    ProtocolClassConfigImpl protocolClassConfig = new ProtocolClassConfigImpl();
    return protocolClassConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PortClassConfig createPortClassConfig()
  {
    PortClassConfigImpl portClassConfig = new PortClassConfigImpl();
    return portClassConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PortInstanceConfig createPortInstanceConfig()
  {
    PortInstanceConfigImpl portInstanceConfig = new PortInstanceConfigImpl();
    return portInstanceConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttrConfig createAttrConfig()
  {
    AttrConfigImpl attrConfig = new AttrConfigImpl();
    return attrConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttrClassConfig createAttrClassConfig()
  {
    AttrClassConfigImpl attrClassConfig = new AttrClassConfigImpl();
    return attrClassConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttrInstanceConfig createAttrInstanceConfig()
  {
    AttrInstanceConfigImpl attrInstanceConfig = new AttrInstanceConfigImpl();
    return attrInstanceConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConfigValueArray createConfigValueArray()
  {
    ConfigValueArrayImpl configValueArray = new ConfigValueArrayImpl();
    return configValueArray;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConfigValue createConfigValue()
  {
    ConfigValueImpl configValue = new ConfigValueImpl();
    return configValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LiteralConfigValue createLiteralConfigValue()
  {
    LiteralConfigValueImpl literalConfigValue = new LiteralConfigValueImpl();
    return literalConfigValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumConfigValue createEnumConfigValue()
  {
    EnumConfigValueImpl enumConfigValue = new EnumConfigValueImpl();
    return enumConfigValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
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
  @Override
  public ConfigPackage getConfigPackage()
  {
    return (ConfigPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ConfigPackage getPackage()
  {
    return ConfigPackage.eINSTANCE;
  }

} //ConfigFactoryImpl
