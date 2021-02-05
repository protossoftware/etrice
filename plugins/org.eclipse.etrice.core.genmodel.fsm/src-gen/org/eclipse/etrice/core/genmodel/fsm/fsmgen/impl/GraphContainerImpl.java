/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;

import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl#isInitializedTriggersInStates <em>Initialized Triggers In States</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl#isInitializedChainHeads <em>Initialized Chain Heads</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl#isInitializedCommonData <em>Initialized Common Data</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl#getOrderedStates <em>Ordered States</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphContainerImpl#getOrderedStateNames <em>Ordered State Names</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphContainerImpl extends FSMGenElementImpl implements GraphContainer {
	/**
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph graph;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected ModelComponent component;

	/**
	 * The default value of the '{@link #isInitializedTriggersInStates() <em>Initialized Triggers In States</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedTriggersInStates()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIALIZED_TRIGGERS_IN_STATES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitializedTriggersInStates() <em>Initialized Triggers In States</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedTriggersInStates()
	 * @generated
	 * @ordered
	 */
	protected boolean initializedTriggersInStates = INITIALIZED_TRIGGERS_IN_STATES_EDEFAULT;

	/**
	 * The default value of the '{@link #isInitializedChainHeads() <em>Initialized Chain Heads</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedChainHeads()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIALIZED_CHAIN_HEADS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitializedChainHeads() <em>Initialized Chain Heads</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedChainHeads()
	 * @generated
	 * @ordered
	 */
	protected boolean initializedChainHeads = INITIALIZED_CHAIN_HEADS_EDEFAULT;

	/**
	 * The default value of the '{@link #isInitializedCommonData() <em>Initialized Common Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedCommonData()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIALIZED_COMMON_DATA_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitializedCommonData() <em>Initialized Common Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedCommonData()
	 * @generated
	 * @ordered
	 */
	protected boolean initializedCommonData = INITIALIZED_COMMON_DATA_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOrderedStates() <em>Ordered States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderedStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> orderedStates;

	/**
	 * The cached value of the '{@link #getOrderedStateNames() <em>Ordered State Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderedStateNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> orderedStateNames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmGenPackage.Literals.GRAPH_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Graph getGraph() {
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		Graph oldGraph = graph;
		graph = newGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmGenPackage.GRAPH_CONTAINER__GRAPH, oldGraph, newGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGraph(Graph newGraph) {
		if (newGraph != graph) {
			NotificationChain msgs = null;
			if (graph != null)
				msgs = ((InternalEObject)graph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmGenPackage.GRAPH_CONTAINER__GRAPH, null, msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmGenPackage.GRAPH_CONTAINER__GRAPH, null, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.GRAPH_CONTAINER__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelComponent getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (ModelComponent)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmGenPackage.GRAPH_CONTAINER__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelComponent basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComponent(ModelComponent newComponent) {
		ModelComponent oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.GRAPH_CONTAINER__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInitializedTriggersInStates() {
		return initializedTriggersInStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitializedTriggersInStates(boolean newInitializedTriggersInStates) {
		boolean oldInitializedTriggersInStates = initializedTriggersInStates;
		initializedTriggersInStates = newInitializedTriggersInStates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_TRIGGERS_IN_STATES, oldInitializedTriggersInStates, initializedTriggersInStates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInitializedChainHeads() {
		return initializedChainHeads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitializedChainHeads(boolean newInitializedChainHeads) {
		boolean oldInitializedChainHeads = initializedChainHeads;
		initializedChainHeads = newInitializedChainHeads;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_CHAIN_HEADS, oldInitializedChainHeads, initializedChainHeads));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInitializedCommonData() {
		return initializedCommonData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitializedCommonData(boolean newInitializedCommonData) {
		boolean oldInitializedCommonData = initializedCommonData;
		initializedCommonData = newInitializedCommonData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_COMMON_DATA, oldInitializedCommonData, initializedCommonData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<State> getOrderedStates() {
		if (orderedStates == null) {
			orderedStates = new EObjectResolvingEList<State>(State.class, this, FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATES);
		}
		return orderedStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getOrderedStateNames() {
		if (orderedStateNames == null) {
			orderedStateNames = new EDataTypeUniqueEList<String>(String.class, this, FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATE_NAMES);
		}
		return orderedStateNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmGenPackage.GRAPH_CONTAINER__GRAPH:
				return basicSetGraph(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmGenPackage.GRAPH_CONTAINER__GRAPH:
				return getGraph();
			case FsmGenPackage.GRAPH_CONTAINER__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_TRIGGERS_IN_STATES:
				return isInitializedTriggersInStates();
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_CHAIN_HEADS:
				return isInitializedChainHeads();
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_COMMON_DATA:
				return isInitializedCommonData();
			case FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATES:
				return getOrderedStates();
			case FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATE_NAMES:
				return getOrderedStateNames();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmGenPackage.GRAPH_CONTAINER__GRAPH:
				setGraph((Graph)newValue);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__COMPONENT:
				setComponent((ModelComponent)newValue);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_TRIGGERS_IN_STATES:
				setInitializedTriggersInStates((Boolean)newValue);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_CHAIN_HEADS:
				setInitializedChainHeads((Boolean)newValue);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_COMMON_DATA:
				setInitializedCommonData((Boolean)newValue);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATES:
				getOrderedStates().clear();
				getOrderedStates().addAll((Collection<? extends State>)newValue);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATE_NAMES:
				getOrderedStateNames().clear();
				getOrderedStateNames().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FsmGenPackage.GRAPH_CONTAINER__GRAPH:
				setGraph((Graph)null);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__COMPONENT:
				setComponent((ModelComponent)null);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_TRIGGERS_IN_STATES:
				setInitializedTriggersInStates(INITIALIZED_TRIGGERS_IN_STATES_EDEFAULT);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_CHAIN_HEADS:
				setInitializedChainHeads(INITIALIZED_CHAIN_HEADS_EDEFAULT);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_COMMON_DATA:
				setInitializedCommonData(INITIALIZED_COMMON_DATA_EDEFAULT);
				return;
			case FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATES:
				getOrderedStates().clear();
				return;
			case FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATE_NAMES:
				getOrderedStateNames().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FsmGenPackage.GRAPH_CONTAINER__GRAPH:
				return graph != null;
			case FsmGenPackage.GRAPH_CONTAINER__COMPONENT:
				return component != null;
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_TRIGGERS_IN_STATES:
				return initializedTriggersInStates != INITIALIZED_TRIGGERS_IN_STATES_EDEFAULT;
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_CHAIN_HEADS:
				return initializedChainHeads != INITIALIZED_CHAIN_HEADS_EDEFAULT;
			case FsmGenPackage.GRAPH_CONTAINER__INITIALIZED_COMMON_DATA:
				return initializedCommonData != INITIALIZED_COMMON_DATA_EDEFAULT;
			case FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATES:
				return orderedStates != null && !orderedStates.isEmpty();
			case FsmGenPackage.GRAPH_CONTAINER__ORDERED_STATE_NAMES:
				return orderedStateNames != null && !orderedStateNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (initializedTriggersInStates: ");
		result.append(initializedTriggersInStates);
		result.append(", initializedChainHeads: ");
		result.append(initializedChainHeads);
		result.append(", initializedCommonData: ");
		result.append(initializedCommonData);
		result.append(", orderedStateNames: ");
		result.append(orderedStateNames);
		result.append(')');
		return result.toString();
	}

} //GraphContainerImpl
