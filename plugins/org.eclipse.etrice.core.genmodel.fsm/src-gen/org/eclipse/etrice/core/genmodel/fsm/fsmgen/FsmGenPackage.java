/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenFactory
 * @model kind="package"
 * @generated
 */
public interface FsmGenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fsmgen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/etrice/generator/fsm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fsmgen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FsmGenPackage eINSTANCE = org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FSMGenElementImpl <em>FSM Gen Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FSMGenElementImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getFSMGenElement()
	 * @generated
	 */
	int FSM_GEN_ELEMENT = 6;

	/**
	 * The number of structural features of the '<em>FSM Gen Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_GEN_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>FSM Gen Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_GEN_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl <em>Graph Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getGraphContainer()
	 * @generated
	 */
	int GRAPH_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONTAINER__GRAPH = FSM_GEN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONTAINER__COMPONENT = FSM_GEN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initialized Triggers In States</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONTAINER__INITIALIZED_TRIGGERS_IN_STATES = FSM_GEN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initialized Chain Heads</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONTAINER__INITIALIZED_CHAIN_HEADS = FSM_GEN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initialized Common Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONTAINER__INITIALIZED_COMMON_DATA = FSM_GEN_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ordered States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONTAINER__ORDERED_STATES = FSM_GEN_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Ordered State Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONTAINER__ORDERED_STATE_NAMES = FSM_GEN_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Graph Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONTAINER_FEATURE_COUNT = FSM_GEN_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Graph Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONTAINER_OPERATION_COUNT = FSM_GEN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = FSM_GEN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__LINKS = FSM_GEN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__STATE_GRAPH = FSM_GEN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODE = FSM_GEN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = FSM_GEN_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH___TO_STRING = FSM_GEN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_OPERATION_COUNT = FSM_GEN_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphItemImpl <em>Graph Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphItemImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getGraphItem()
	 * @generated
	 */
	int GRAPH_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ITEM__INHERITED = FSM_GEN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Graph Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ITEM_FEATURE_COUNT = FSM_GEN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Graph Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ITEM_OPERATION_COUNT = FSM_GEN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 3;

	/**
	 * The feature id for the '<em><b>Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INHERITED = GRAPH_ITEM__INHERITED;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GRAPH = GRAPH_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subgraph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SUBGRAPH = GRAPH_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING = GRAPH_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING = GRAPH_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>State Graph Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__STATE_GRAPH_NODE = GRAPH_ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Caught Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CAUGHT_TRIGGERS = GRAPH_ITEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Inheritance Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INHERITANCE_LEVEL = GRAPH_ITEM_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = GRAPH_ITEM_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE___TO_STRING = GRAPH_ITEM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = GRAPH_ITEM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.LinkImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 4;

	/**
	 * The feature id for the '<em><b>Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__INHERITED = GRAPH_ITEM__INHERITED;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__GRAPH = GRAPH_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SOURCE = GRAPH_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TARGET = GRAPH_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Chain Heads</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__CHAIN_HEADS = GRAPH_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ifitem Triggered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__IFITEM_TRIGGERED = GRAPH_ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Common Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__COMMON_DATA = GRAPH_ITEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TRANSITION = GRAPH_ITEM_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = GRAPH_ITEM_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK___TO_STRING = GRAPH_ITEM_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = GRAPH_ITEM_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.CommonTriggerImpl <em>Common Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.CommonTriggerImpl
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getCommonTrigger()
	 * @generated
	 */
	int COMMON_TRIGGER = 5;

	/**
	 * The feature id for the '<em><b>Msg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TRIGGER__MSG = FSM_GEN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ifitem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TRIGGER__IFITEM = FSM_GEN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TRIGGER__HAS_GUARD = FSM_GEN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TRIGGER__TRIGGER = FSM_GEN_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TRIGGER__LINKS = FSM_GEN_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Common Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TRIGGER_FEATURE_COUNT = FSM_GEN_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Common Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TRIGGER_OPERATION_COUNT = FSM_GEN_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer <em>Graph Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Container</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
	 * @generated
	 */
	EClass getGraphContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graph</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getGraph()
	 * @see #getGraphContainer()
	 * @generated
	 */
	EReference getGraphContainer_Graph();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getComponent()
	 * @see #getGraphContainer()
	 * @generated
	 */
	EReference getGraphContainer_Component();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedTriggersInStates <em>Initialized Triggers In States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Triggers In States</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedTriggersInStates()
	 * @see #getGraphContainer()
	 * @generated
	 */
	EAttribute getGraphContainer_InitializedTriggersInStates();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedChainHeads <em>Initialized Chain Heads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Chain Heads</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedChainHeads()
	 * @see #getGraphContainer()
	 * @generated
	 */
	EAttribute getGraphContainer_InitializedChainHeads();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedCommonData <em>Initialized Common Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Common Data</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedCommonData()
	 * @see #getGraphContainer()
	 * @generated
	 */
	EAttribute getGraphContainer_InitializedCommonData();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getOrderedStates <em>Ordered States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ordered States</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getOrderedStates()
	 * @see #getGraphContainer()
	 * @generated
	 */
	EReference getGraphContainer_OrderedStates();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getOrderedStateNames <em>Ordered State Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ordered State Names</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getOrderedStateNames()
	 * @see #getGraphContainer()
	 * @generated
	 */
	EAttribute getGraphContainer_OrderedStateNames();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getLinks()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Links();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getStateGraph <em>State Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Graph</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getStateGraph()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_StateGraph();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Node</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getNode()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Node();

	/**
	 * Returns the meta object for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#toString()
	 * @generated
	 */
	EOperation getGraph__ToString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem <em>Graph Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Item</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem
	 * @generated
	 */
	EClass getGraphItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem#isInherited <em>Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inherited</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem#isInherited()
	 * @see #getGraphItem()
	 * @generated
	 */
	EAttribute getGraphItem_Inherited();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getGraph()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Graph();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getSubgraph <em>Subgraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subgraph</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getSubgraph()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Subgraph();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getOutgoing()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getIncoming()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Incoming();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getStateGraphNode <em>State Graph Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Graph Node</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getStateGraphNode()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_StateGraphNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getCaughtTriggers <em>Caught Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Caught Triggers</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getCaughtTriggers()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_CaughtTriggers();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getInheritanceLevel <em>Inheritance Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inheritance Level</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getInheritanceLevel()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_InheritanceLevel();

	/**
	 * Returns the meta object for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#toString()
	 * @generated
	 */
	EOperation getNode__ToString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getGraph()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Graph();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getSource()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTarget()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Target();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getChainHeads <em>Chain Heads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Chain Heads</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getChainHeads()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_ChainHeads();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#isIfitemTriggered <em>Ifitem Triggered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ifitem Triggered</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#isIfitemTriggered()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_IfitemTriggered();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getCommonData <em>Common Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Common Data</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getCommonData()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_CommonData();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transition</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTransition()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Transition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#toString()
	 * @generated
	 */
	EOperation getLink__ToString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger <em>Common Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Trigger</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger
	 * @generated
	 */
	EClass getCommonTrigger();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getMsg <em>Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Msg</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getMsg()
	 * @see #getCommonTrigger()
	 * @generated
	 */
	EReference getCommonTrigger_Msg();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getIfitem <em>Ifitem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ifitem</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getIfitem()
	 * @see #getCommonTrigger()
	 * @generated
	 */
	EReference getCommonTrigger_Ifitem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getTrigger()
	 * @see #getCommonTrigger()
	 * @generated
	 */
	EAttribute getCommonTrigger_Trigger();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getLinks()
	 * @see #getCommonTrigger()
	 * @generated
	 */
	EReference getCommonTrigger_Links();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.FSMGenElement <em>FSM Gen Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Gen Element</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FSMGenElement
	 * @generated
	 */
	EClass getFSMGenElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#isHasGuard <em>Has Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Guard</em>'.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#isHasGuard()
	 * @see #getCommonTrigger()
	 * @generated
	 */
	EAttribute getCommonTrigger_HasGuard();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FsmGenFactory getFsmGenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl <em>Graph Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getGraphContainer()
		 * @generated
		 */
		EClass GRAPH_CONTAINER = eINSTANCE.getGraphContainer();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_CONTAINER__GRAPH = eINSTANCE.getGraphContainer_Graph();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_CONTAINER__COMPONENT = eINSTANCE.getGraphContainer_Component();

		/**
		 * The meta object literal for the '<em><b>Initialized Triggers In States</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_CONTAINER__INITIALIZED_TRIGGERS_IN_STATES = eINSTANCE.getGraphContainer_InitializedTriggersInStates();

		/**
		 * The meta object literal for the '<em><b>Initialized Chain Heads</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_CONTAINER__INITIALIZED_CHAIN_HEADS = eINSTANCE.getGraphContainer_InitializedChainHeads();

		/**
		 * The meta object literal for the '<em><b>Initialized Common Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_CONTAINER__INITIALIZED_COMMON_DATA = eINSTANCE.getGraphContainer_InitializedCommonData();

		/**
		 * The meta object literal for the '<em><b>Ordered States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_CONTAINER__ORDERED_STATES = eINSTANCE.getGraphContainer_OrderedStates();

		/**
		 * The meta object literal for the '<em><b>Ordered State Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_CONTAINER__ORDERED_STATE_NAMES = eINSTANCE.getGraphContainer_OrderedStateNames();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__LINKS = eINSTANCE.getGraph_Links();

		/**
		 * The meta object literal for the '<em><b>State Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__STATE_GRAPH = eINSTANCE.getGraph_StateGraph();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODE = eINSTANCE.getGraph_Node();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GRAPH___TO_STRING = eINSTANCE.getGraph__ToString();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphItemImpl <em>Graph Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphItemImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getGraphItem()
		 * @generated
		 */
		EClass GRAPH_ITEM = eINSTANCE.getGraphItem();

		/**
		 * The meta object literal for the '<em><b>Inherited</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH_ITEM__INHERITED = eINSTANCE.getGraphItem_Inherited();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__GRAPH = eINSTANCE.getNode_Graph();

		/**
		 * The meta object literal for the '<em><b>Subgraph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SUBGRAPH = eINSTANCE.getNode_Subgraph();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING = eINSTANCE.getNode_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING = eINSTANCE.getNode_Incoming();

		/**
		 * The meta object literal for the '<em><b>State Graph Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__STATE_GRAPH_NODE = eINSTANCE.getNode_StateGraphNode();

		/**
		 * The meta object literal for the '<em><b>Caught Triggers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CAUGHT_TRIGGERS = eINSTANCE.getNode_CaughtTriggers();

		/**
		 * The meta object literal for the '<em><b>Inheritance Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__INHERITANCE_LEVEL = eINSTANCE.getNode_InheritanceLevel();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE___TO_STRING = eINSTANCE.getNode__ToString();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.LinkImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__GRAPH = eINSTANCE.getLink_Graph();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__SOURCE = eINSTANCE.getLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TARGET = eINSTANCE.getLink_Target();

		/**
		 * The meta object literal for the '<em><b>Chain Heads</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__CHAIN_HEADS = eINSTANCE.getLink_ChainHeads();

		/**
		 * The meta object literal for the '<em><b>Ifitem Triggered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__IFITEM_TRIGGERED = eINSTANCE.getLink_IfitemTriggered();

		/**
		 * The meta object literal for the '<em><b>Common Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__COMMON_DATA = eINSTANCE.getLink_CommonData();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TRANSITION = eINSTANCE.getLink_Transition();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LINK___TO_STRING = eINSTANCE.getLink__ToString();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.CommonTriggerImpl <em>Common Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.CommonTriggerImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getCommonTrigger()
		 * @generated
		 */
		EClass COMMON_TRIGGER = eINSTANCE.getCommonTrigger();

		/**
		 * The meta object literal for the '<em><b>Msg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMON_TRIGGER__MSG = eINSTANCE.getCommonTrigger_Msg();

		/**
		 * The meta object literal for the '<em><b>Ifitem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMON_TRIGGER__IFITEM = eINSTANCE.getCommonTrigger_Ifitem();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMON_TRIGGER__TRIGGER = eINSTANCE.getCommonTrigger_Trigger();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMON_TRIGGER__LINKS = eINSTANCE.getCommonTrigger_Links();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FSMGenElementImpl <em>FSM Gen Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FSMGenElementImpl
		 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.FsmGenPackageImpl#getFSMGenElement()
		 * @generated
		 */
		EClass FSM_GEN_ELEMENT = eINSTANCE.getFSMGenElement();

		/**
		 * The meta object literal for the '<em><b>Has Guard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMON_TRIGGER__HAS_GUARD = eINSTANCE.getCommonTrigger_HasGuard();

	}

} //FsmGenPackage
