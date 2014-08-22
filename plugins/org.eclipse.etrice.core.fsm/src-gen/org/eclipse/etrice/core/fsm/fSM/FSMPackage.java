/**
 */
package org.eclipse.etrice.core.fsm.fSM;

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
 * @see org.eclipse.etrice.core.fsm.fSM.FSMFactory
 * @model kind="package"
 * @generated
 */
public interface FSMPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "fSM";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/etrice/core/fsm/FSM";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fSM";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FSMPackage eINSTANCE = org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.FSMModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMModelImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getFSMModel()
   * @generated
   */
  int FSM_MODEL = 0;

  /**
   * The feature id for the '<em><b>Components</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM_MODEL__COMPONENTS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FSM_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner <em>IInterface Item Owner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getIInterfaceItemOwner()
   * @generated
   */
  int IINTERFACE_ITEM_OWNER = 37;

  /**
   * The number of structural features of the '<em>IInterface Item Owner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IINTERFACE_ITEM_OWNER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ModelComponentImpl <em>Model Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.ModelComponentImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getModelComponent()
   * @generated
   */
  int MODEL_COMPONENT = 1;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_COMPONENT__ABSTRACT = IINTERFACE_ITEM_OWNER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Comm Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_COMPONENT__COMM_TYPE = IINTERFACE_ITEM_OWNER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Component Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_COMPONENT__COMPONENT_NAME = IINTERFACE_ITEM_OWNER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_COMPONENT__BASE = IINTERFACE_ITEM_OWNER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>State Machine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_COMPONENT__STATE_MACHINE = IINTERFACE_ITEM_OWNER_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Model Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_COMPONENT_FEATURE_COUNT = IINTERFACE_ITEM_OWNER_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphItemImpl <em>State Graph Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.StateGraphItemImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getStateGraphItem()
   * @generated
   */
  int STATE_GRAPH_ITEM = 3;

  /**
   * The number of structural features of the '<em>State Graph Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH_ITEM_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphNodeImpl <em>State Graph Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.StateGraphNodeImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getStateGraphNode()
   * @generated
   */
  int STATE_GRAPH_NODE = 2;

  /**
   * The number of structural features of the '<em>State Graph Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH_NODE_FEATURE_COUNT = STATE_GRAPH_ITEM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphImpl <em>State Graph</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.StateGraphImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getStateGraph()
   * @generated
   */
  int STATE_GRAPH = 4;

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
   * The feature id for the '<em><b>Refined Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH__REFINED_TRANSITIONS = 4;

  /**
   * The number of structural features of the '<em>State Graph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_GRAPH_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.StateImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getState()
   * @generated
   */
  int STATE = 5;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.SimpleStateImpl <em>Simple State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.SimpleStateImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getSimpleState()
   * @generated
   */
  int SIMPLE_STATE = 6;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__DOCU = STATE__DOCU;

  /**
   * The feature id for the '<em><b>Entry Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__ENTRY_CODE = STATE__ENTRY_CODE;

  /**
   * The feature id for the '<em><b>Exit Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__EXIT_CODE = STATE__EXIT_CODE;

  /**
   * The feature id for the '<em><b>Do Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__DO_CODE = STATE__DO_CODE;

  /**
   * The feature id for the '<em><b>Subgraph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__SUBGRAPH = STATE__SUBGRAPH;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE__NAME = STATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.RefinedStateImpl <em>Refined State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.RefinedStateImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getRefinedState()
   * @generated
   */
  int REFINED_STATE = 7;

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
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_STATE__TARGET = STATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Refined State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.DetailCodeImpl <em>Detail Code</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.DetailCodeImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getDetailCode()
   * @generated
   */
  int DETAIL_CODE = 8;

  /**
   * The feature id for the '<em><b>Used</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETAIL_CODE__USED = 0;

  /**
   * The feature id for the '<em><b>Lines</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETAIL_CODE__LINES = 1;

  /**
   * The number of structural features of the '<em>Detail Code</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETAIL_CODE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TrPointImpl <em>Tr Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.TrPointImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTrPoint()
   * @generated
   */
  int TR_POINT = 9;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionPointImpl <em>Transition Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.TransitionPointImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTransitionPoint()
   * @generated
   */
  int TRANSITION_POINT = 10;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.EntryPointImpl <em>Entry Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.EntryPointImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getEntryPoint()
   * @generated
   */
  int ENTRY_POINT = 11;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ExitPointImpl <em>Exit Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.ExitPointImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getExitPoint()
   * @generated
   */
  int EXIT_POINT = 12;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ChoicePointImpl <em>Choice Point</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.ChoicePointImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getChoicePoint()
   * @generated
   */
  int CHOICE_POINT = 13;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.TransitionImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 14;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.NonInitialTransitionImpl <em>Non Initial Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.NonInitialTransitionImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getNonInitialTransition()
   * @generated
   */
  int NON_INITIAL_TRANSITION = 15;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionChainStartTransitionImpl <em>Transition Chain Start Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.TransitionChainStartTransitionImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTransitionChainStartTransition()
   * @generated
   */
  int TRANSITION_CHAIN_START_TRANSITION = 16;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.InitialTransitionImpl <em>Initial Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.InitialTransitionImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getInitialTransition()
   * @generated
   */
  int INITIAL_TRANSITION = 17;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ContinuationTransitionImpl <em>Continuation Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.ContinuationTransitionImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getContinuationTransition()
   * @generated
   */
  int CONTINUATION_TRANSITION = 18;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TriggeredTransitionImpl <em>Triggered Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.TriggeredTransitionImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTriggeredTransition()
   * @generated
   */
  int TRIGGERED_TRANSITION = 19;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.GuardedTransitionImpl <em>Guarded Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.GuardedTransitionImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getGuardedTransition()
   * @generated
   */
  int GUARDED_TRANSITION = 20;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.CPBranchTransitionImpl <em>CP Branch Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.CPBranchTransitionImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getCPBranchTransition()
   * @generated
   */
  int CP_BRANCH_TRANSITION = 21;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.RefinedTransitionImpl <em>Refined Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.RefinedTransitionImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getRefinedTransition()
   * @generated
   */
  int REFINED_TRANSITION = 22;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_TRANSITION__TARGET = 0;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_TRANSITION__DOCU = 1;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_TRANSITION__ACTION = 2;

  /**
   * The number of structural features of the '<em>Refined Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFINED_TRANSITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionTerminalImpl <em>Transition Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.TransitionTerminalImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTransitionTerminal()
   * @generated
   */
  int TRANSITION_TERMINAL = 23;

  /**
   * The number of structural features of the '<em>Transition Terminal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_TERMINAL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateTerminalImpl <em>State Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.StateTerminalImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getStateTerminal()
   * @generated
   */
  int STATE_TERMINAL = 24;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TrPointTerminalImpl <em>Tr Point Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.TrPointTerminalImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTrPointTerminal()
   * @generated
   */
  int TR_POINT_TERMINAL = 25;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.SubStateTrPointTerminalImpl <em>Sub State Tr Point Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.SubStateTrPointTerminalImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getSubStateTrPointTerminal()
   * @generated
   */
  int SUB_STATE_TR_POINT_TERMINAL = 26;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ChoicepointTerminalImpl <em>Choicepoint Terminal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.ChoicepointTerminalImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getChoicepointTerminal()
   * @generated
   */
  int CHOICEPOINT_TERMINAL = 27;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TriggerImpl <em>Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.TriggerImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTrigger()
   * @generated
   */
  int TRIGGER = 28;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.MessageFromIfImpl <em>Message From If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.MessageFromIfImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getMessageFromIf()
   * @generated
   */
  int MESSAGE_FROM_IF = 29;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.AbstractMessageImpl <em>Abstract Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.AbstractMessageImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getAbstractMessage()
   * @generated
   */
  int ABSTRACT_MESSAGE = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_MESSAGE__NAME = 0;

  /**
   * The number of structural features of the '<em>Abstract Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_MESSAGE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.AbstractInterfaceItemImpl <em>Abstract Interface Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.AbstractInterfaceItemImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getAbstractInterfaceItem()
   * @generated
   */
  int ABSTRACT_INTERFACE_ITEM = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_INTERFACE_ITEM__NAME = 0;

  /**
   * The number of structural features of the '<em>Abstract Interface Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_INTERFACE_ITEM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.GuardImpl <em>Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.GuardImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getGuard()
   * @generated
   */
  int GUARD = 32;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ProtocolSemanticsImpl <em>Protocol Semantics</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.ProtocolSemanticsImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getProtocolSemantics()
   * @generated
   */
  int PROTOCOL_SEMANTICS = 33;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.SemanticsRuleImpl <em>Semantics Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.SemanticsRuleImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getSemanticsRule()
   * @generated
   */
  int SEMANTICS_RULE = 34;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.InSemanticsRuleImpl <em>In Semantics Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.InSemanticsRuleImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getInSemanticsRule()
   * @generated
   */
  int IN_SEMANTICS_RULE = 35;

  /**
   * The feature id for the '<em><b>Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_SEMANTICS_RULE__MSG = SEMANTICS_RULE__MSG;

  /**
   * The feature id for the '<em><b>Follow Ups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_SEMANTICS_RULE__FOLLOW_UPS = SEMANTICS_RULE__FOLLOW_UPS;

  /**
   * The number of structural features of the '<em>In Semantics Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_SEMANTICS_RULE_FEATURE_COUNT = SEMANTICS_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.OutSemanticsRuleImpl <em>Out Semantics Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.impl.OutSemanticsRuleImpl
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getOutSemanticsRule()
   * @generated
   */
  int OUT_SEMANTICS_RULE = 36;

  /**
   * The feature id for the '<em><b>Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUT_SEMANTICS_RULE__MSG = SEMANTICS_RULE__MSG;

  /**
   * The feature id for the '<em><b>Follow Ups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUT_SEMANTICS_RULE__FOLLOW_UPS = SEMANTICS_RULE__FOLLOW_UPS;

  /**
   * The number of structural features of the '<em>Out Semantics Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUT_SEMANTICS_RULE_FEATURE_COUNT = SEMANTICS_RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType <em>Component Communication Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
   * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getComponentCommunicationType()
   * @generated
   */
  int COMPONENT_COMMUNICATION_TYPE = 38;


  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.FSMModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.FSMModel
   * @generated
   */
  EClass getFSMModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.FSMModel#getComponents <em>Components</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Components</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.FSMModel#getComponents()
   * @see #getFSMModel()
   * @generated
   */
  EReference getFSMModel_Components();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent <em>Model Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Component</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ModelComponent
   * @generated
   */
  EClass getModelComponent();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ModelComponent#isAbstract()
   * @see #getModelComponent()
   * @generated
   */
  EAttribute getModelComponent_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getCommType <em>Comm Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Comm Type</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ModelComponent#getCommType()
   * @see #getModelComponent()
   * @generated
   */
  EAttribute getModelComponent_CommType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getComponentName <em>Component Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Component Name</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ModelComponent#getComponentName()
   * @see #getModelComponent()
   * @generated
   */
  EAttribute getModelComponent_ComponentName();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Base</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ModelComponent#getBase()
   * @see #getModelComponent()
   * @generated
   */
  EReference getModelComponent_Base();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getStateMachine <em>State Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State Machine</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ModelComponent#getStateMachine()
   * @see #getModelComponent()
   * @generated
   */
  EReference getModelComponent_StateMachine();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.StateGraphNode <em>State Graph Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Graph Node</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraphNode
   * @generated
   */
  EClass getStateGraphNode();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.StateGraphItem <em>State Graph Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Graph Item</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraphItem
   * @generated
   */
  EClass getStateGraphItem();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.StateGraph <em>State Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Graph</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraph
   * @generated
   */
  EClass getStateGraph();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.StateGraph#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraph#getStates()
   * @see #getStateGraph()
   * @generated
   */
  EReference getStateGraph_States();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.StateGraph#getTrPoints <em>Tr Points</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tr Points</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraph#getTrPoints()
   * @see #getStateGraph()
   * @generated
   */
  EReference getStateGraph_TrPoints();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.StateGraph#getChPoints <em>Ch Points</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ch Points</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraph#getChPoints()
   * @see #getStateGraph()
   * @generated
   */
  EReference getStateGraph_ChPoints();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.StateGraph#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraph#getTransitions()
   * @see #getStateGraph()
   * @generated
   */
  EReference getStateGraph_Transitions();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.StateGraph#getRefinedTransitions <em>Refined Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Refined Transitions</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateGraph#getRefinedTransitions()
   * @see #getStateGraph()
   * @generated
   */
  EReference getStateGraph_RefinedTransitions();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.State#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.State#getDocu()
   * @see #getState()
   * @generated
   */
  EReference getState_Docu();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.State#getEntryCode <em>Entry Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Entry Code</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.State#getEntryCode()
   * @see #getState()
   * @generated
   */
  EReference getState_EntryCode();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.State#getExitCode <em>Exit Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exit Code</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.State#getExitCode()
   * @see #getState()
   * @generated
   */
  EReference getState_ExitCode();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.State#getDoCode <em>Do Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Do Code</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.State#getDoCode()
   * @see #getState()
   * @generated
   */
  EReference getState_DoCode();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.State#getSubgraph <em>Subgraph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Subgraph</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.State#getSubgraph()
   * @see #getState()
   * @generated
   */
  EReference getState_Subgraph();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.SimpleState <em>Simple State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple State</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.SimpleState
   * @generated
   */
  EClass getSimpleState();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.SimpleState#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.SimpleState#getName()
   * @see #getSimpleState()
   * @generated
   */
  EAttribute getSimpleState_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.RefinedState <em>Refined State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Refined State</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.RefinedState
   * @generated
   */
  EClass getRefinedState();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.RefinedState#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.RefinedState#getTarget()
   * @see #getRefinedState()
   * @generated
   */
  EReference getRefinedState_Target();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.DetailCode <em>Detail Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Detail Code</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.DetailCode
   * @generated
   */
  EClass getDetailCode();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.DetailCode#isUsed <em>Used</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Used</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.DetailCode#isUsed()
   * @see #getDetailCode()
   * @generated
   */
  EAttribute getDetailCode_Used();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.fsm.fSM.DetailCode#getLines <em>Lines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Lines</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.DetailCode#getLines()
   * @see #getDetailCode()
   * @generated
   */
  EAttribute getDetailCode_Lines();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.TrPoint <em>Tr Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tr Point</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TrPoint
   * @generated
   */
  EClass getTrPoint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.TrPoint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TrPoint#getName()
   * @see #getTrPoint()
   * @generated
   */
  EAttribute getTrPoint_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.TransitionPoint <em>Transition Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Point</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TransitionPoint
   * @generated
   */
  EClass getTransitionPoint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.TransitionPoint#isHandler <em>Handler</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Handler</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TransitionPoint#isHandler()
   * @see #getTransitionPoint()
   * @generated
   */
  EAttribute getTransitionPoint_Handler();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.EntryPoint <em>Entry Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Point</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.EntryPoint
   * @generated
   */
  EClass getEntryPoint();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.ExitPoint <em>Exit Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exit Point</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ExitPoint
   * @generated
   */
  EClass getExitPoint();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.ChoicePoint <em>Choice Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choice Point</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ChoicePoint
   * @generated
   */
  EClass getChoicePoint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.ChoicePoint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ChoicePoint#getName()
   * @see #getChoicePoint()
   * @generated
   */
  EAttribute getChoicePoint_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.ChoicePoint#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ChoicePoint#getDocu()
   * @see #getChoicePoint()
   * @generated
   */
  EReference getChoicePoint_Docu();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.Transition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Transition#getName()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.Transition#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>To</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Transition#getTo()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_To();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.Transition#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Transition#getDocu()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Docu();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.Transition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Transition#getAction()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Action();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.NonInitialTransition <em>Non Initial Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Non Initial Transition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.NonInitialTransition
   * @generated
   */
  EClass getNonInitialTransition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.NonInitialTransition#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>From</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.NonInitialTransition#getFrom()
   * @see #getNonInitialTransition()
   * @generated
   */
  EReference getNonInitialTransition_From();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.TransitionChainStartTransition <em>Transition Chain Start Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Chain Start Transition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TransitionChainStartTransition
   * @generated
   */
  EClass getTransitionChainStartTransition();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.InitialTransition <em>Initial Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Initial Transition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.InitialTransition
   * @generated
   */
  EClass getInitialTransition();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.ContinuationTransition <em>Continuation Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Continuation Transition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ContinuationTransition
   * @generated
   */
  EClass getContinuationTransition();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.TriggeredTransition <em>Triggered Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Triggered Transition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
   * @generated
   */
  EClass getTriggeredTransition();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.TriggeredTransition#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TriggeredTransition#getTriggers()
   * @see #getTriggeredTransition()
   * @generated
   */
  EReference getTriggeredTransition_Triggers();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.GuardedTransition <em>Guarded Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guarded Transition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.GuardedTransition
   * @generated
   */
  EClass getGuardedTransition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.GuardedTransition#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.GuardedTransition#getGuard()
   * @see #getGuardedTransition()
   * @generated
   */
  EReference getGuardedTransition_Guard();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.CPBranchTransition <em>CP Branch Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CP Branch Transition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.CPBranchTransition
   * @generated
   */
  EClass getCPBranchTransition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.CPBranchTransition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.CPBranchTransition#getCondition()
   * @see #getCPBranchTransition()
   * @generated
   */
  EReference getCPBranchTransition_Condition();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.RefinedTransition <em>Refined Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Refined Transition</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.RefinedTransition
   * @generated
   */
  EClass getRefinedTransition();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.RefinedTransition#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.RefinedTransition#getTarget()
   * @see #getRefinedTransition()
   * @generated
   */
  EReference getRefinedTransition_Target();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.RefinedTransition#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.RefinedTransition#getDocu()
   * @see #getRefinedTransition()
   * @generated
   */
  EReference getRefinedTransition_Docu();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.RefinedTransition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.RefinedTransition#getAction()
   * @see #getRefinedTransition()
   * @generated
   */
  EReference getRefinedTransition_Action();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.TransitionTerminal <em>Transition Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Terminal</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TransitionTerminal
   * @generated
   */
  EClass getTransitionTerminal();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.StateTerminal <em>State Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Terminal</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateTerminal
   * @generated
   */
  EClass getStateTerminal();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.StateTerminal#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.StateTerminal#getState()
   * @see #getStateTerminal()
   * @generated
   */
  EReference getStateTerminal_State();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.TrPointTerminal <em>Tr Point Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tr Point Terminal</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TrPointTerminal
   * @generated
   */
  EClass getTrPointTerminal();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.TrPointTerminal#getTrPoint <em>Tr Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Tr Point</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.TrPointTerminal#getTrPoint()
   * @see #getTrPointTerminal()
   * @generated
   */
  EReference getTrPointTerminal_TrPoint();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal <em>Sub State Tr Point Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub State Tr Point Terminal</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal
   * @generated
   */
  EClass getSubStateTrPointTerminal();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal#getTrPoint <em>Tr Point</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Tr Point</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal#getTrPoint()
   * @see #getSubStateTrPointTerminal()
   * @generated
   */
  EReference getSubStateTrPointTerminal_TrPoint();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal#getState()
   * @see #getSubStateTrPointTerminal()
   * @generated
   */
  EReference getSubStateTrPointTerminal_State();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal <em>Choicepoint Terminal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choicepoint Terminal</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal
   * @generated
   */
  EClass getChoicepointTerminal();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal#getCp <em>Cp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Cp</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal#getCp()
   * @see #getChoicepointTerminal()
   * @generated
   */
  EReference getChoicepointTerminal_Cp();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Trigger
   * @generated
   */
  EClass getTrigger();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.Trigger#getMsgFromIfPairs <em>Msg From If Pairs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Msg From If Pairs</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Trigger#getMsgFromIfPairs()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_MsgFromIfPairs();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.Trigger#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Trigger#getGuard()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_Guard();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.MessageFromIf <em>Message From If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message From If</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.MessageFromIf
   * @generated
   */
  EClass getMessageFromIf();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.MessageFromIf#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Message</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.MessageFromIf#getMessage()
   * @see #getMessageFromIf()
   * @generated
   */
  EReference getMessageFromIf_Message();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.MessageFromIf#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>From</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.MessageFromIf#getFrom()
   * @see #getMessageFromIf()
   * @generated
   */
  EReference getMessageFromIf_From();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.AbstractMessage <em>Abstract Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Message</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.AbstractMessage
   * @generated
   */
  EClass getAbstractMessage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.AbstractMessage#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.AbstractMessage#getName()
   * @see #getAbstractMessage()
   * @generated
   */
  EAttribute getAbstractMessage_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem <em>Abstract Interface Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Interface Item</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem
   * @generated
   */
  EClass getAbstractInterfaceItem();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem#getName()
   * @see #getAbstractInterfaceItem()
   * @generated
   */
  EAttribute getAbstractInterfaceItem_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Guard
   * @generated
   */
  EClass getGuard();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.fsm.fSM.Guard#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.Guard#getGuard()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_Guard();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics <em>Protocol Semantics</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Protocol Semantics</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics
   * @generated
   */
  EClass getProtocolSemantics();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics#getRules()
   * @see #getProtocolSemantics()
   * @generated
   */
  EReference getProtocolSemantics_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.SemanticsRule <em>Semantics Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Semantics Rule</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.SemanticsRule
   * @generated
   */
  EClass getSemanticsRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.fsm.fSM.SemanticsRule#getMsg <em>Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Msg</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.SemanticsRule#getMsg()
   * @see #getSemanticsRule()
   * @generated
   */
  EReference getSemanticsRule_Msg();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.fsm.fSM.SemanticsRule#getFollowUps <em>Follow Ups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Follow Ups</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.SemanticsRule#getFollowUps()
   * @see #getSemanticsRule()
   * @generated
   */
  EReference getSemanticsRule_FollowUps();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.InSemanticsRule <em>In Semantics Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>In Semantics Rule</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.InSemanticsRule
   * @generated
   */
  EClass getInSemanticsRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.OutSemanticsRule <em>Out Semantics Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Out Semantics Rule</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.OutSemanticsRule
   * @generated
   */
  EClass getOutSemanticsRule();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner <em>IInterface Item Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IInterface Item Owner</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner
   * @generated
   */
  EClass getIInterfaceItemOwner();

  /**
   * Returns the meta object for enum '{@link org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType <em>Component Communication Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Component Communication Type</em>'.
   * @see org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
   * @generated
   */
  EEnum getComponentCommunicationType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FSMFactory getFSMFactory();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.FSMModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMModelImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getFSMModel()
     * @generated
     */
    EClass FSM_MODEL = eINSTANCE.getFSMModel();

    /**
     * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FSM_MODEL__COMPONENTS = eINSTANCE.getFSMModel_Components();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ModelComponentImpl <em>Model Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.ModelComponentImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getModelComponent()
     * @generated
     */
    EClass MODEL_COMPONENT = eINSTANCE.getModelComponent();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_COMPONENT__ABSTRACT = eINSTANCE.getModelComponent_Abstract();

    /**
     * The meta object literal for the '<em><b>Comm Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_COMPONENT__COMM_TYPE = eINSTANCE.getModelComponent_CommType();

    /**
     * The meta object literal for the '<em><b>Component Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_COMPONENT__COMPONENT_NAME = eINSTANCE.getModelComponent_ComponentName();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_COMPONENT__BASE = eINSTANCE.getModelComponent_Base();

    /**
     * The meta object literal for the '<em><b>State Machine</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_COMPONENT__STATE_MACHINE = eINSTANCE.getModelComponent_StateMachine();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphNodeImpl <em>State Graph Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.StateGraphNodeImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getStateGraphNode()
     * @generated
     */
    EClass STATE_GRAPH_NODE = eINSTANCE.getStateGraphNode();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphItemImpl <em>State Graph Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.StateGraphItemImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getStateGraphItem()
     * @generated
     */
    EClass STATE_GRAPH_ITEM = eINSTANCE.getStateGraphItem();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphImpl <em>State Graph</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.StateGraphImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getStateGraph()
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
     * The meta object literal for the '<em><b>Refined Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_GRAPH__REFINED_TRANSITIONS = eINSTANCE.getStateGraph_RefinedTransitions();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.StateImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getState()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.SimpleStateImpl <em>Simple State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.SimpleStateImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getSimpleState()
     * @generated
     */
    EClass SIMPLE_STATE = eINSTANCE.getSimpleState();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_STATE__NAME = eINSTANCE.getSimpleState_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.RefinedStateImpl <em>Refined State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.RefinedStateImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getRefinedState()
     * @generated
     */
    EClass REFINED_STATE = eINSTANCE.getRefinedState();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFINED_STATE__TARGET = eINSTANCE.getRefinedState_Target();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.DetailCodeImpl <em>Detail Code</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.DetailCodeImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getDetailCode()
     * @generated
     */
    EClass DETAIL_CODE = eINSTANCE.getDetailCode();

    /**
     * The meta object literal for the '<em><b>Used</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DETAIL_CODE__USED = eINSTANCE.getDetailCode_Used();

    /**
     * The meta object literal for the '<em><b>Lines</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DETAIL_CODE__LINES = eINSTANCE.getDetailCode_Lines();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TrPointImpl <em>Tr Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.TrPointImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTrPoint()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionPointImpl <em>Transition Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.TransitionPointImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTransitionPoint()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.EntryPointImpl <em>Entry Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.EntryPointImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getEntryPoint()
     * @generated
     */
    EClass ENTRY_POINT = eINSTANCE.getEntryPoint();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ExitPointImpl <em>Exit Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.ExitPointImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getExitPoint()
     * @generated
     */
    EClass EXIT_POINT = eINSTANCE.getExitPoint();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ChoicePointImpl <em>Choice Point</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.ChoicePointImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getChoicePoint()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.TransitionImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTransition()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.NonInitialTransitionImpl <em>Non Initial Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.NonInitialTransitionImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getNonInitialTransition()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionChainStartTransitionImpl <em>Transition Chain Start Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.TransitionChainStartTransitionImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTransitionChainStartTransition()
     * @generated
     */
    EClass TRANSITION_CHAIN_START_TRANSITION = eINSTANCE.getTransitionChainStartTransition();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.InitialTransitionImpl <em>Initial Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.InitialTransitionImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getInitialTransition()
     * @generated
     */
    EClass INITIAL_TRANSITION = eINSTANCE.getInitialTransition();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ContinuationTransitionImpl <em>Continuation Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.ContinuationTransitionImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getContinuationTransition()
     * @generated
     */
    EClass CONTINUATION_TRANSITION = eINSTANCE.getContinuationTransition();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TriggeredTransitionImpl <em>Triggered Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.TriggeredTransitionImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTriggeredTransition()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.GuardedTransitionImpl <em>Guarded Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.GuardedTransitionImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getGuardedTransition()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.CPBranchTransitionImpl <em>CP Branch Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.CPBranchTransitionImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getCPBranchTransition()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.RefinedTransitionImpl <em>Refined Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.RefinedTransitionImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getRefinedTransition()
     * @generated
     */
    EClass REFINED_TRANSITION = eINSTANCE.getRefinedTransition();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFINED_TRANSITION__TARGET = eINSTANCE.getRefinedTransition_Target();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFINED_TRANSITION__DOCU = eINSTANCE.getRefinedTransition_Docu();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFINED_TRANSITION__ACTION = eINSTANCE.getRefinedTransition_Action();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionTerminalImpl <em>Transition Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.TransitionTerminalImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTransitionTerminal()
     * @generated
     */
    EClass TRANSITION_TERMINAL = eINSTANCE.getTransitionTerminal();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.StateTerminalImpl <em>State Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.StateTerminalImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getStateTerminal()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TrPointTerminalImpl <em>Tr Point Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.TrPointTerminalImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTrPointTerminal()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.SubStateTrPointTerminalImpl <em>Sub State Tr Point Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.SubStateTrPointTerminalImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getSubStateTrPointTerminal()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ChoicepointTerminalImpl <em>Choicepoint Terminal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.ChoicepointTerminalImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getChoicepointTerminal()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.TriggerImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getTrigger()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.MessageFromIfImpl <em>Message From If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.MessageFromIfImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getMessageFromIf()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.AbstractMessageImpl <em>Abstract Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.AbstractMessageImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getAbstractMessage()
     * @generated
     */
    EClass ABSTRACT_MESSAGE = eINSTANCE.getAbstractMessage();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_MESSAGE__NAME = eINSTANCE.getAbstractMessage_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.AbstractInterfaceItemImpl <em>Abstract Interface Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.AbstractInterfaceItemImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getAbstractInterfaceItem()
     * @generated
     */
    EClass ABSTRACT_INTERFACE_ITEM = eINSTANCE.getAbstractInterfaceItem();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_INTERFACE_ITEM__NAME = eINSTANCE.getAbstractInterfaceItem_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.GuardImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getGuard()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.ProtocolSemanticsImpl <em>Protocol Semantics</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.ProtocolSemanticsImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getProtocolSemantics()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.SemanticsRuleImpl <em>Semantics Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.SemanticsRuleImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getSemanticsRule()
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
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.InSemanticsRuleImpl <em>In Semantics Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.InSemanticsRuleImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getInSemanticsRule()
     * @generated
     */
    EClass IN_SEMANTICS_RULE = eINSTANCE.getInSemanticsRule();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.impl.OutSemanticsRuleImpl <em>Out Semantics Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.impl.OutSemanticsRuleImpl
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getOutSemanticsRule()
     * @generated
     */
    EClass OUT_SEMANTICS_RULE = eINSTANCE.getOutSemanticsRule();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner <em>IInterface Item Owner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getIInterfaceItemOwner()
     * @generated
     */
    EClass IINTERFACE_ITEM_OWNER = eINSTANCE.getIInterfaceItemOwner();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType <em>Component Communication Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
     * @see org.eclipse.etrice.core.fsm.fSM.impl.FSMPackageImpl#getComponentCommunicationType()
     * @generated
     */
    EEnum COMPONENT_COMMUNICATION_TYPE = eINSTANCE.getComponentCommunicationType();

  }

} //FSMPackage
