/**
 */
package org.eclipse.etrice.core.etphys.eTPhys;

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
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysFactory
 * @model kind="package"
 * @generated
 */
public interface ETPhysPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "eTPhys";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/etrice/core/etphys/ETPhys";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "eTPhys";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ETPhysPackage eINSTANCE = org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalModelImpl <em>Physical Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalModelImpl
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getPhysicalModel()
   * @generated
   */
  int PHYSICAL_MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_MODEL__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Systems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_MODEL__SYSTEMS = 2;

  /**
   * The feature id for the '<em><b>Node Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_MODEL__NODE_CLASSES = 3;

  /**
   * The feature id for the '<em><b>Runtime Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_MODEL__RUNTIME_CLASSES = 4;

  /**
   * The number of structural features of the '<em>Physical Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_MODEL_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalSystemImpl <em>Physical System</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalSystemImpl
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getPhysicalSystem()
   * @generated
   */
  int PHYSICAL_SYSTEM = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_SYSTEM__NAME = 0;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_SYSTEM__DOCU = 1;

  /**
   * The feature id for the '<em><b>Node Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_SYSTEM__NODE_REFS = 2;

  /**
   * The number of structural features of the '<em>Physical System</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_SYSTEM_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeRefImpl <em>Node Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.NodeRefImpl
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getNodeRef()
   * @generated
   */
  int NODE_REF = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF__TYPE = 1;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF__DOCU = 2;

  /**
   * The number of structural features of the '<em>Node Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl <em>Node Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getNodeClass()
   * @generated
   */
  int NODE_CLASS = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CLASS__NAME = 0;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CLASS__DOCU = 1;

  /**
   * The feature id for the '<em><b>Runtime</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CLASS__RUNTIME = 2;

  /**
   * The feature id for the '<em><b>Priomin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CLASS__PRIOMIN = 3;

  /**
   * The feature id for the '<em><b>Priomax</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CLASS__PRIOMAX = 4;

  /**
   * The feature id for the '<em><b>Threads</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CLASS__THREADS = 5;

  /**
   * The number of structural features of the '<em>Node Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_CLASS_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl <em>Physical Thread</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getPhysicalThread()
   * @generated
   */
  int PHYSICAL_THREAD = 4;

  /**
   * The feature id for the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_THREAD__DEFAULT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_THREAD__NAME = 1;

  /**
   * The feature id for the '<em><b>Execmode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_THREAD__EXECMODE = 2;

  /**
   * The feature id for the '<em><b>Prio</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_THREAD__PRIO = 3;

  /**
   * The feature id for the '<em><b>Stacksize</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_THREAD__STACKSIZE = 4;

  /**
   * The feature id for the '<em><b>Msgblocksize</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_THREAD__MSGBLOCKSIZE = 5;

  /**
   * The feature id for the '<em><b>Msgpoolsize</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_THREAD__MSGPOOLSIZE = 6;

  /**
   * The number of structural features of the '<em>Physical Thread</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHYSICAL_THREAD_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.RuntimeClassImpl <em>Runtime Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.RuntimeClassImpl
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getRuntimeClass()
   * @generated
   */
  int RUNTIME_CLASS = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RUNTIME_CLASS__NAME = 0;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RUNTIME_CLASS__DOCU = 1;

  /**
   * The feature id for the '<em><b>Thread Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RUNTIME_CLASS__THREAD_MODEL = 2;

  /**
   * The number of structural features of the '<em>Runtime Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RUNTIME_CLASS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.DocumentationImpl <em>Documentation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.DocumentationImpl
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getDocumentation()
   * @generated
   */
  int DOCUMENTATION = 6;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ImportImpl
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 7;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.ExecMode <em>Exec Mode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.ExecMode
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getExecMode()
   * @generated
   */
  int EXEC_MODE = 8;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.etphys.eTPhys.ThreadModel <em>Thread Model</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.etphys.eTPhys.ThreadModel
   * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getThreadModel()
   * @generated
   */
  int THREAD_MODEL = 9;


  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel <em>Physical Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Physical Model</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel
   * @generated
   */
  EClass getPhysicalModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getName()
   * @see #getPhysicalModel()
   * @generated
   */
  EAttribute getPhysicalModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getImports()
   * @see #getPhysicalModel()
   * @generated
   */
  EReference getPhysicalModel_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getSystems <em>Systems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Systems</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getSystems()
   * @see #getPhysicalModel()
   * @generated
   */
  EReference getPhysicalModel_Systems();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getNodeClasses <em>Node Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Node Classes</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getNodeClasses()
   * @see #getPhysicalModel()
   * @generated
   */
  EReference getPhysicalModel_NodeClasses();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getRuntimeClasses <em>Runtime Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Runtime Classes</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getRuntimeClasses()
   * @see #getPhysicalModel()
   * @generated
   */
  EReference getPhysicalModel_RuntimeClasses();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem <em>Physical System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Physical System</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem
   * @generated
   */
  EClass getPhysicalSystem();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getName()
   * @see #getPhysicalSystem()
   * @generated
   */
  EAttribute getPhysicalSystem_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getDocu()
   * @see #getPhysicalSystem()
   * @generated
   */
  EReference getPhysicalSystem_Docu();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getNodeRefs <em>Node Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Node Refs</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getNodeRefs()
   * @see #getPhysicalSystem()
   * @generated
   */
  EReference getPhysicalSystem_NodeRefs();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeRef <em>Node Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Ref</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeRef
   * @generated
   */
  EClass getNodeRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeRef#getName()
   * @see #getNodeRef()
   * @generated
   */
  EAttribute getNodeRef_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeRef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeRef#getType()
   * @see #getNodeRef()
   * @generated
   */
  EReference getNodeRef_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeRef#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeRef#getDocu()
   * @see #getNodeRef()
   * @generated
   */
  EReference getNodeRef_Docu();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass <em>Node Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Class</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeClass
   * @generated
   */
  EClass getNodeClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getName()
   * @see #getNodeClass()
   * @generated
   */
  EAttribute getNodeClass_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getDocu()
   * @see #getNodeClass()
   * @generated
   */
  EReference getNodeClass_Docu();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getRuntime <em>Runtime</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Runtime</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getRuntime()
   * @see #getNodeClass()
   * @generated
   */
  EReference getNodeClass_Runtime();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getPriomin <em>Priomin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priomin</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getPriomin()
   * @see #getNodeClass()
   * @generated
   */
  EAttribute getNodeClass_Priomin();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getPriomax <em>Priomax</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priomax</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getPriomax()
   * @see #getNodeClass()
   * @generated
   */
  EAttribute getNodeClass_Priomax();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getThreads <em>Threads</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Threads</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getThreads()
   * @see #getNodeClass()
   * @generated
   */
  EReference getNodeClass_Threads();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread <em>Physical Thread</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Physical Thread</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread
   * @generated
   */
  EClass getPhysicalThread();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#isDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#isDefault()
   * @see #getPhysicalThread()
   * @generated
   */
  EAttribute getPhysicalThread_Default();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getName()
   * @see #getPhysicalThread()
   * @generated
   */
  EAttribute getPhysicalThread_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getExecmode <em>Execmode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Execmode</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getExecmode()
   * @see #getPhysicalThread()
   * @generated
   */
  EAttribute getPhysicalThread_Execmode();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getPrio <em>Prio</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prio</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getPrio()
   * @see #getPhysicalThread()
   * @generated
   */
  EAttribute getPhysicalThread_Prio();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getStacksize <em>Stacksize</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Stacksize</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getStacksize()
   * @see #getPhysicalThread()
   * @generated
   */
  EAttribute getPhysicalThread_Stacksize();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getMsgblocksize <em>Msgblocksize</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msgblocksize</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getMsgblocksize()
   * @see #getPhysicalThread()
   * @generated
   */
  EAttribute getPhysicalThread_Msgblocksize();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getMsgpoolsize <em>Msgpoolsize</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msgpoolsize</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread#getMsgpoolsize()
   * @see #getPhysicalThread()
   * @generated
   */
  EAttribute getPhysicalThread_Msgpoolsize();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass <em>Runtime Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Runtime Class</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass
   * @generated
   */
  EClass getRuntimeClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getName()
   * @see #getRuntimeClass()
   * @generated
   */
  EAttribute getRuntimeClass_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getDocu()
   * @see #getRuntimeClass()
   * @generated
   */
  EReference getRuntimeClass_Docu();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getThreadModel <em>Thread Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Thread Model</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getThreadModel()
   * @see #getRuntimeClass()
   * @generated
   */
  EAttribute getRuntimeClass_ThreadModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etphys.eTPhys.Documentation <em>Documentation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Documentation</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.Documentation
   * @generated
   */
  EClass getDocumentation();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.etphys.eTPhys.Documentation#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Text</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.Documentation#getText()
   * @see #getDocumentation()
   * @generated
   */
  EAttribute getDocumentation_Text();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.etphys.eTPhys.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.etphys.eTPhys.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the meta object for enum '{@link org.eclipse.etrice.core.etphys.eTPhys.ExecMode <em>Exec Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Exec Mode</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ExecMode
   * @generated
   */
  EEnum getExecMode();

  /**
   * Returns the meta object for enum '{@link org.eclipse.etrice.core.etphys.eTPhys.ThreadModel <em>Thread Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Thread Model</em>'.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ThreadModel
   * @generated
   */
  EEnum getThreadModel();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ETPhysFactory getETPhysFactory();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalModelImpl <em>Physical Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalModelImpl
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getPhysicalModel()
     * @generated
     */
    EClass PHYSICAL_MODEL = eINSTANCE.getPhysicalModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHYSICAL_MODEL__NAME = eINSTANCE.getPhysicalModel_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHYSICAL_MODEL__IMPORTS = eINSTANCE.getPhysicalModel_Imports();

    /**
     * The meta object literal for the '<em><b>Systems</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHYSICAL_MODEL__SYSTEMS = eINSTANCE.getPhysicalModel_Systems();

    /**
     * The meta object literal for the '<em><b>Node Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHYSICAL_MODEL__NODE_CLASSES = eINSTANCE.getPhysicalModel_NodeClasses();

    /**
     * The meta object literal for the '<em><b>Runtime Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHYSICAL_MODEL__RUNTIME_CLASSES = eINSTANCE.getPhysicalModel_RuntimeClasses();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalSystemImpl <em>Physical System</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalSystemImpl
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getPhysicalSystem()
     * @generated
     */
    EClass PHYSICAL_SYSTEM = eINSTANCE.getPhysicalSystem();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHYSICAL_SYSTEM__NAME = eINSTANCE.getPhysicalSystem_Name();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHYSICAL_SYSTEM__DOCU = eINSTANCE.getPhysicalSystem_Docu();

    /**
     * The meta object literal for the '<em><b>Node Refs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHYSICAL_SYSTEM__NODE_REFS = eINSTANCE.getPhysicalSystem_NodeRefs();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeRefImpl <em>Node Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.NodeRefImpl
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getNodeRef()
     * @generated
     */
    EClass NODE_REF = eINSTANCE.getNodeRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_REF__NAME = eINSTANCE.getNodeRef_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_REF__TYPE = eINSTANCE.getNodeRef_Type();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_REF__DOCU = eINSTANCE.getNodeRef_Docu();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl <em>Node Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getNodeClass()
     * @generated
     */
    EClass NODE_CLASS = eINSTANCE.getNodeClass();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_CLASS__NAME = eINSTANCE.getNodeClass_Name();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_CLASS__DOCU = eINSTANCE.getNodeClass_Docu();

    /**
     * The meta object literal for the '<em><b>Runtime</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_CLASS__RUNTIME = eINSTANCE.getNodeClass_Runtime();

    /**
     * The meta object literal for the '<em><b>Priomin</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_CLASS__PRIOMIN = eINSTANCE.getNodeClass_Priomin();

    /**
     * The meta object literal for the '<em><b>Priomax</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_CLASS__PRIOMAX = eINSTANCE.getNodeClass_Priomax();

    /**
     * The meta object literal for the '<em><b>Threads</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_CLASS__THREADS = eINSTANCE.getNodeClass_Threads();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl <em>Physical Thread</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getPhysicalThread()
     * @generated
     */
    EClass PHYSICAL_THREAD = eINSTANCE.getPhysicalThread();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHYSICAL_THREAD__DEFAULT = eINSTANCE.getPhysicalThread_Default();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHYSICAL_THREAD__NAME = eINSTANCE.getPhysicalThread_Name();

    /**
     * The meta object literal for the '<em><b>Execmode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHYSICAL_THREAD__EXECMODE = eINSTANCE.getPhysicalThread_Execmode();

    /**
     * The meta object literal for the '<em><b>Prio</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHYSICAL_THREAD__PRIO = eINSTANCE.getPhysicalThread_Prio();

    /**
     * The meta object literal for the '<em><b>Stacksize</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHYSICAL_THREAD__STACKSIZE = eINSTANCE.getPhysicalThread_Stacksize();

    /**
     * The meta object literal for the '<em><b>Msgblocksize</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHYSICAL_THREAD__MSGBLOCKSIZE = eINSTANCE.getPhysicalThread_Msgblocksize();

    /**
     * The meta object literal for the '<em><b>Msgpoolsize</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHYSICAL_THREAD__MSGPOOLSIZE = eINSTANCE.getPhysicalThread_Msgpoolsize();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.RuntimeClassImpl <em>Runtime Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.RuntimeClassImpl
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getRuntimeClass()
     * @generated
     */
    EClass RUNTIME_CLASS = eINSTANCE.getRuntimeClass();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RUNTIME_CLASS__NAME = eINSTANCE.getRuntimeClass_Name();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RUNTIME_CLASS__DOCU = eINSTANCE.getRuntimeClass_Docu();

    /**
     * The meta object literal for the '<em><b>Thread Model</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RUNTIME_CLASS__THREAD_MODEL = eINSTANCE.getRuntimeClass_ThreadModel();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.DocumentationImpl <em>Documentation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.DocumentationImpl
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getDocumentation()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ImportImpl
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getImport()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.ExecMode <em>Exec Mode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.ExecMode
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getExecMode()
     * @generated
     */
    EEnum EXEC_MODE = eINSTANCE.getExecMode();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.etphys.eTPhys.ThreadModel <em>Thread Model</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.etphys.eTPhys.ThreadModel
     * @see org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysPackageImpl#getThreadModel()
     * @generated
     */
    EEnum THREAD_MODEL = eINSTANCE.getThreadModel();

  }

} //ETPhysPackage
