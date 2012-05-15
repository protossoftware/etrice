/**
 * <copyright>
 * </copyright>
 *

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
   * The feature id for the '<em><b>Actor Class Configs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_MODEL__ACTOR_CLASS_CONFIGS = 0;

  /**
   * The feature id for the '<em><b>Actor Instance Configs</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_MODEL__ACTOR_INSTANCE_CONFIGS = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIG_MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.config.impl.ActorClassConfigImpl <em>Actor Class Config</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.config.impl.ActorClassConfigImpl
   * @see org.eclipse.etrice.core.config.impl.ConfigPackageImpl#getActorClassConfig()
   * @generated
   */
  int ACTOR_CLASS_CONFIG = 1;

  /**
   * The feature id for the '<em><b>Actor Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS_CONFIG__ACTOR_CLASS = 0;

  /**
   * The number of structural features of the '<em>Actor Class Config</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTOR_CLASS_CONFIG_FEATURE_COUNT = 1;


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
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.config.ConfigModel#getActorClassConfigs <em>Actor Class Configs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actor Class Configs</em>'.
   * @see org.eclipse.etrice.core.config.ConfigModel#getActorClassConfigs()
   * @see #getConfigModel()
   * @generated
   */
  EReference getConfigModel_ActorClassConfigs();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.config.ConfigModel#getActorInstanceConfigs <em>Actor Instance Configs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Actor Instance Configs</em>'.
   * @see org.eclipse.etrice.core.config.ConfigModel#getActorInstanceConfigs()
   * @see #getConfigModel()
   * @generated
   */
  EAttribute getConfigModel_ActorInstanceConfigs();

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
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.config.ActorClassConfig#getActorClass <em>Actor Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Actor Class</em>'.
   * @see org.eclipse.etrice.core.config.ActorClassConfig#getActorClass()
   * @see #getActorClassConfig()
   * @generated
   */
  EReference getActorClassConfig_ActorClass();

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
     * The meta object literal for the '<em><b>Actor Class Configs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONFIG_MODEL__ACTOR_CLASS_CONFIGS = eINSTANCE.getConfigModel_ActorClassConfigs();

    /**
     * The meta object literal for the '<em><b>Actor Instance Configs</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIG_MODEL__ACTOR_INSTANCE_CONFIGS = eINSTANCE.getConfigModel_ActorInstanceConfigs();

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
     * The meta object literal for the '<em><b>Actor Class</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTOR_CLASS_CONFIG__ACTOR_CLASS = eINSTANCE.getActorClassConfig_ActorClass();

  }

} //ConfigPackage
