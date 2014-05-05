/**
 */
package org.eclipse.etrice.core.etmap.eTMap;

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
 * @see org.eclipse.etrice.core.etmap.eTMap.ETMapFactory
 * @model kind="package"
 * @generated
 */
public interface ETMapPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "eTMap";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/etrice/core/etmap/ETMap";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "eTMap";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ETMapPackage eINSTANCE = org.eclipse.etrice.core.etmap.eTMap.impl.ETMapPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etmap.eTMap.impl.MappingModelImpl <em>Mapping Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etmap.eTMap.impl.MappingModelImpl
   * @see org.eclipse.etrice.core.etmap.eTMap.impl.ETMapPackageImpl#getMappingModel()
   * @generated
   */
  int MAPPING_MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL__MAPPINGS = 2;

  /**
   * The number of structural features of the '<em>Mapping Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etmap.eTMap.impl.MappingImpl <em>Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etmap.eTMap.impl.MappingImpl
   * @see org.eclipse.etrice.core.etmap.eTMap.impl.ETMapPackageImpl#getMapping()
   * @generated
   */
  int MAPPING = 1;

  /**
   * The feature id for the '<em><b>Logical Sys</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING__LOGICAL_SYS = 0;

  /**
   * The feature id for the '<em><b>Physical Sys</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING__PHYSICAL_SYS = 1;

  /**
   * The feature id for the '<em><b>Subsys Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING__SUBSYS_MAPPINGS = 2;

  /**
   * The number of structural features of the '<em>Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etmap.eTMap.impl.SubSystemMappingImpl <em>Sub System Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etmap.eTMap.impl.SubSystemMappingImpl
   * @see org.eclipse.etrice.core.etmap.eTMap.impl.ETMapPackageImpl#getSubSystemMapping()
   * @generated
   */
  int SUB_SYSTEM_MAPPING = 2;

  /**
   * The feature id for the '<em><b>Logical Sub Sys</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_MAPPING__LOGICAL_SUB_SYS = 0;

  /**
   * The feature id for the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_MAPPING__NODE = 1;

  /**
   * The feature id for the '<em><b>Thread Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_MAPPING__THREAD_MAPPINGS = 2;

  /**
   * The number of structural features of the '<em>Sub System Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_SYSTEM_MAPPING_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etmap.eTMap.impl.ThreadMappingImpl <em>Thread Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etmap.eTMap.impl.ThreadMappingImpl
   * @see org.eclipse.etrice.core.etmap.eTMap.impl.ETMapPackageImpl#getThreadMapping()
   * @generated
   */
  int THREAD_MAPPING = 3;

  /**
   * The feature id for the '<em><b>Logical Thread</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAD_MAPPING__LOGICAL_THREAD = 0;

  /**
   * The feature id for the '<em><b>Physical Thread</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAD_MAPPING__PHYSICAL_THREAD = 1;

  /**
   * The number of structural features of the '<em>Thread Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAD_MAPPING_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etmap.eTMap.MappingModel <em>Mapping Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mapping Model</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.MappingModel
   * @generated
   */
  EClass getMappingModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etmap.eTMap.MappingModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.MappingModel#getName()
   * @see #getMappingModel()
   * @generated
   */
  EAttribute getMappingModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etmap.eTMap.MappingModel#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.MappingModel#getImports()
   * @see #getMappingModel()
   * @generated
   */
  EReference getMappingModel_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etmap.eTMap.MappingModel#getMappings <em>Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mappings</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.MappingModel#getMappings()
   * @see #getMappingModel()
   * @generated
   */
  EReference getMappingModel_Mappings();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etmap.eTMap.Mapping <em>Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mapping</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.Mapping
   * @generated
   */
  EClass getMapping();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.etmap.eTMap.Mapping#getLogicalSys <em>Logical Sys</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Logical Sys</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.Mapping#getLogicalSys()
   * @see #getMapping()
   * @generated
   */
  EReference getMapping_LogicalSys();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.etmap.eTMap.Mapping#getPhysicalSys <em>Physical Sys</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Physical Sys</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.Mapping#getPhysicalSys()
   * @see #getMapping()
   * @generated
   */
  EReference getMapping_PhysicalSys();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etmap.eTMap.Mapping#getSubsysMappings <em>Subsys Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subsys Mappings</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.Mapping#getSubsysMappings()
   * @see #getMapping()
   * @generated
   */
  EReference getMapping_SubsysMappings();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping <em>Sub System Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub System Mapping</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping
   * @generated
   */
  EClass getSubSystemMapping();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getLogicalSubSys <em>Logical Sub Sys</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Logical Sub Sys</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getLogicalSubSys()
   * @see #getSubSystemMapping()
   * @generated
   */
  EReference getSubSystemMapping_LogicalSubSys();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Node</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getNode()
   * @see #getSubSystemMapping()
   * @generated
   */
  EReference getSubSystemMapping_Node();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getThreadMappings <em>Thread Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Thread Mappings</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getThreadMappings()
   * @see #getSubSystemMapping()
   * @generated
   */
  EReference getSubSystemMapping_ThreadMappings();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etmap.eTMap.ThreadMapping <em>Thread Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Thread Mapping</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.ThreadMapping
   * @generated
   */
  EClass getThreadMapping();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.etmap.eTMap.ThreadMapping#getLogicalThread <em>Logical Thread</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Logical Thread</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.ThreadMapping#getLogicalThread()
   * @see #getThreadMapping()
   * @generated
   */
  EReference getThreadMapping_LogicalThread();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.etmap.eTMap.ThreadMapping#getPhysicalThread <em>Physical Thread</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Physical Thread</em>'.
   * @see org.eclipse.etrice.core.etmap.eTMap.ThreadMapping#getPhysicalThread()
   * @see #getThreadMapping()
   * @generated
   */
  EReference getThreadMapping_PhysicalThread();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ETMapFactory getETMapFactory();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.etmap.eTMap.impl.MappingModelImpl <em>Mapping Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etmap.eTMap.impl.MappingModelImpl
     * @see org.eclipse.etrice.core.etmap.eTMap.impl.ETMapPackageImpl#getMappingModel()
     * @generated
     */
    EClass MAPPING_MODEL = eINSTANCE.getMappingModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAPPING_MODEL__NAME = eINSTANCE.getMappingModel_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING_MODEL__IMPORTS = eINSTANCE.getMappingModel_Imports();

    /**
     * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING_MODEL__MAPPINGS = eINSTANCE.getMappingModel_Mappings();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etmap.eTMap.impl.MappingImpl <em>Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etmap.eTMap.impl.MappingImpl
     * @see org.eclipse.etrice.core.etmap.eTMap.impl.ETMapPackageImpl#getMapping()
     * @generated
     */
    EClass MAPPING = eINSTANCE.getMapping();

    /**
     * The meta object literal for the '<em><b>Logical Sys</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING__LOGICAL_SYS = eINSTANCE.getMapping_LogicalSys();

    /**
     * The meta object literal for the '<em><b>Physical Sys</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING__PHYSICAL_SYS = eINSTANCE.getMapping_PhysicalSys();

    /**
     * The meta object literal for the '<em><b>Subsys Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING__SUBSYS_MAPPINGS = eINSTANCE.getMapping_SubsysMappings();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etmap.eTMap.impl.SubSystemMappingImpl <em>Sub System Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etmap.eTMap.impl.SubSystemMappingImpl
     * @see org.eclipse.etrice.core.etmap.eTMap.impl.ETMapPackageImpl#getSubSystemMapping()
     * @generated
     */
    EClass SUB_SYSTEM_MAPPING = eINSTANCE.getSubSystemMapping();

    /**
     * The meta object literal for the '<em><b>Logical Sub Sys</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_MAPPING__LOGICAL_SUB_SYS = eINSTANCE.getSubSystemMapping_LogicalSubSys();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_MAPPING__NODE = eINSTANCE.getSubSystemMapping_Node();

    /**
     * The meta object literal for the '<em><b>Thread Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_SYSTEM_MAPPING__THREAD_MAPPINGS = eINSTANCE.getSubSystemMapping_ThreadMappings();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etmap.eTMap.impl.ThreadMappingImpl <em>Thread Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etmap.eTMap.impl.ThreadMappingImpl
     * @see org.eclipse.etrice.core.etmap.eTMap.impl.ETMapPackageImpl#getThreadMapping()
     * @generated
     */
    EClass THREAD_MAPPING = eINSTANCE.getThreadMapping();

    /**
     * The meta object literal for the '<em><b>Logical Thread</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THREAD_MAPPING__LOGICAL_THREAD = eINSTANCE.getThreadMapping_LogicalThread();

    /**
     * The meta object literal for the '<em><b>Physical Thread</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THREAD_MAPPING__PHYSICAL_THREAD = eINSTANCE.getThreadMapping_PhysicalThread();

  }

} //ETMapPackage
