/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.etrice.core.genmodel.fsm.fsmgen.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FsmGenFactoryImpl extends EFactoryImpl implements FsmGenFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FsmGenFactory init() {
		try {
			FsmGenFactory theFsmGenFactory = (FsmGenFactory)EPackage.Registry.INSTANCE.getEFactory(FsmGenPackage.eNS_URI);
			if (theFsmGenFactory != null) {
				return theFsmGenFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FsmGenFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FsmGenFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FsmGenPackage.GRAPH_CONTAINER: return createGraphContainer();
			case FsmGenPackage.GRAPH: return createGraph();
			case FsmGenPackage.GRAPH_ITEM: return createGraphItem();
			case FsmGenPackage.NODE: return createNode();
			case FsmGenPackage.LINK: return createLink();
			case FsmGenPackage.COMMON_TRIGGER: return createCommonTrigger();
			case FsmGenPackage.FSM_GEN_ELEMENT: return createFSMGenElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphContainer createGraphContainer() {
		GraphContainerImpl graphContainer = new GraphContainerImpl();
		return graphContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph createGraph() {
		GraphImpl graph = new GraphImpl();
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphItem createGraphItem() {
		GraphItemImpl graphItem = new GraphItemImpl();
		return graphItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonTrigger createCommonTrigger() {
		CommonTriggerImpl commonTrigger = new CommonTriggerImpl();
		return commonTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMGenElement createFSMGenElement() {
		FSMGenElementImpl fsmGenElement = new FSMGenElementImpl();
		return fsmGenElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FsmGenPackage getFsmGenPackage() {
		return (FsmGenPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FsmGenPackage getPackage() {
		return FsmGenPackage.eINSTANCE;
	}

} //FsmGenFactoryImpl
