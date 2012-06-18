/**
 * <copyright>
 * </copyright>
 *

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
      ConfigFactory theConfigFactory = (ConfigFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/etrice/core/Config"); 
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
      case ConfigPackage.ACTOR_CLASS_CONFIG: return createActorClassConfig();
      case ConfigPackage.ACTOR_INSTANCE_CONFIG: return createActorInstanceConfig();
      case ConfigPackage.ATTR_CONFIG: return createAttrConfig();
      case ConfigPackage.ATTR_CLASS_CONFIG: return createAttrClassConfig();
      case ConfigPackage.ATTR_INSTANCE_CONFIG: return createAttrInstanceConfig();
      case ConfigPackage.REF_PATH: return createRefPath();
      case ConfigPackage.IMPORT: return createImport();
      case ConfigPackage.LITERAL: return createLiteral();
      case ConfigPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
      case ConfigPackage.NUMBER_LITERAL: return createNumberLiteral();
      case ConfigPackage.REAL_LITERAL: return createRealLiteral();
      case ConfigPackage.INT_LITERAL: return createIntLiteral();
      case ConfigPackage.STRING_LITERAL: return createStringLiteral();
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
  @Override
public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public BooleanLiteral createBooleanLiteral()
  {
    BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
    return booleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public NumberLiteral createNumberLiteral()
  {
    NumberLiteralImpl numberLiteral = new NumberLiteralImpl();
    return numberLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public RealLiteral createRealLiteral()
  {
    RealLiteralImpl realLiteral = new RealLiteralImpl();
    return realLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public IntLiteral createIntLiteral()
  {
    IntLiteralImpl intLiteral = new IntLiteralImpl();
    return intLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public StringLiteral createStringLiteral()
  {
    StringLiteralImpl stringLiteral = new StringLiteralImpl();
    return stringLiteral;
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
