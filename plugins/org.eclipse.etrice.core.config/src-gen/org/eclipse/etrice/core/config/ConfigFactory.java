/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.config.ConfigPackage
 * @generated
 */
public interface ConfigFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ConfigFactory eINSTANCE = org.eclipse.etrice.core.config.impl.ConfigFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  ConfigModel createConfigModel();

  /**
   * Returns a new object of class '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element</em>'.
   * @generated
   */
  ConfigElement createConfigElement();

  /**
   * Returns a new object of class '<em>Sub System Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub System Config</em>'.
   * @generated
   */
  SubSystemConfig createSubSystemConfig();

  /**
   * Returns a new object of class '<em>Dynamic Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dynamic Config</em>'.
   * @generated
   */
  DynamicConfig createDynamicConfig();

  /**
   * Returns a new object of class '<em>Actor Class Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actor Class Config</em>'.
   * @generated
   */
  ActorClassConfig createActorClassConfig();

  /**
   * Returns a new object of class '<em>Actor Instance Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actor Instance Config</em>'.
   * @generated
   */
  ActorInstanceConfig createActorInstanceConfig();

  /**
   * Returns a new object of class '<em>Protocol Class Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Protocol Class Config</em>'.
   * @generated
   */
  ProtocolClassConfig createProtocolClassConfig();

  /**
   * Returns a new object of class '<em>Port Class Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Class Config</em>'.
   * @generated
   */
  PortClassConfig createPortClassConfig();

  /**
   * Returns a new object of class '<em>Port Instance Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Instance Config</em>'.
   * @generated
   */
  PortInstanceConfig createPortInstanceConfig();

  /**
   * Returns a new object of class '<em>Attr Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attr Config</em>'.
   * @generated
   */
  AttrConfig createAttrConfig();

  /**
   * Returns a new object of class '<em>Attr Class Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attr Class Config</em>'.
   * @generated
   */
  AttrClassConfig createAttrClassConfig();

  /**
   * Returns a new object of class '<em>Attr Instance Config</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attr Instance Config</em>'.
   * @generated
   */
  AttrInstanceConfig createAttrInstanceConfig();

  /**
   * Returns a new object of class '<em>Value Array</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Array</em>'.
   * @generated
   */
  ConfigValueArray createConfigValueArray();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  ConfigValue createConfigValue();

  /**
   * Returns a new object of class '<em>Literal Config Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Config Value</em>'.
   * @generated
   */
  LiteralConfigValue createLiteralConfigValue();

  /**
   * Returns a new object of class '<em>Enum Config Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Config Value</em>'.
   * @generated
   */
  EnumConfigValue createEnumConfigValue();

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
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ConfigPackage getConfigPackage();

} //ConfigFactory
