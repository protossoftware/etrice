/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;

import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl#getSubgraph <em>Subgraph</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl#getStateGraphNode <em>State Graph Node</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl#getCaughtTriggers <em>Caught Triggers</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.NodeImpl#getInheritanceLevel <em>Inheritance Level</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends GraphItemImpl implements Node {
	/**
	 * The cached value of the '{@link #getSubgraph() <em>Subgraph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubgraph()
	 * @generated
	 * @ordered
	 */
	protected Graph subgraph;

	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> outgoing;

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> incoming;

	/**
	 * The cached value of the '{@link #getStateGraphNode() <em>State Graph Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateGraphNode()
	 * @generated
	 * @ordered
	 */
	protected StateGraphNode stateGraphNode;

	/**
	 * The cached value of the '{@link #getCaughtTriggers() <em>Caught Triggers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaughtTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<CommonTrigger> caughtTriggers;

	/**
	 * The default value of the '{@link #getInheritanceLevel() <em>Inheritance Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritanceLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int INHERITANCE_LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInheritanceLevel() <em>Inheritance Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritanceLevel()
	 * @generated
	 * @ordered
	 */
	protected int inheritanceLevel = INHERITANCE_LEVEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmGenPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Graph getGraph() {
		if (eContainerFeatureID() != FsmGenPackage.NODE__GRAPH) return null;
		return (Graph)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, FsmGenPackage.NODE__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGraph(Graph newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != FsmGenPackage.NODE__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, FsmGenPackage.GRAPH__NODES, Graph.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.NODE__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Graph getSubgraph() {
		return subgraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubgraph(Graph newSubgraph, NotificationChain msgs) {
		Graph oldSubgraph = subgraph;
		subgraph = newSubgraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmGenPackage.NODE__SUBGRAPH, oldSubgraph, newSubgraph);
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
	public void setSubgraph(Graph newSubgraph) {
		if (newSubgraph != subgraph) {
			NotificationChain msgs = null;
			if (subgraph != null)
				msgs = ((InternalEObject)subgraph).eInverseRemove(this, FsmGenPackage.GRAPH__NODE, Graph.class, msgs);
			if (newSubgraph != null)
				msgs = ((InternalEObject)newSubgraph).eInverseAdd(this, FsmGenPackage.GRAPH__NODE, Graph.class, msgs);
			msgs = basicSetSubgraph(newSubgraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.NODE__SUBGRAPH, newSubgraph, newSubgraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Link> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<Link>(Link.class, this, FsmGenPackage.NODE__OUTGOING, FsmGenPackage.LINK__SOURCE);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Link> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<Link>(Link.class, this, FsmGenPackage.NODE__INCOMING, FsmGenPackage.LINK__TARGET);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateGraphNode getStateGraphNode() {
		if (stateGraphNode != null && stateGraphNode.eIsProxy()) {
			InternalEObject oldStateGraphNode = (InternalEObject)stateGraphNode;
			stateGraphNode = (StateGraphNode)eResolveProxy(oldStateGraphNode);
			if (stateGraphNode != oldStateGraphNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmGenPackage.NODE__STATE_GRAPH_NODE, oldStateGraphNode, stateGraphNode));
			}
		}
		return stateGraphNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateGraphNode basicGetStateGraphNode() {
		return stateGraphNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStateGraphNode(StateGraphNode newStateGraphNode) {
		StateGraphNode oldStateGraphNode = stateGraphNode;
		stateGraphNode = newStateGraphNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.NODE__STATE_GRAPH_NODE, oldStateGraphNode, stateGraphNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CommonTrigger> getCaughtTriggers() {
		if (caughtTriggers == null) {
			caughtTriggers = new EObjectContainmentEList<CommonTrigger>(CommonTrigger.class, this, FsmGenPackage.NODE__CAUGHT_TRIGGERS);
		}
		return caughtTriggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInheritanceLevel() {
		return inheritanceLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInheritanceLevel(int newInheritanceLevel) {
		int oldInheritanceLevel = inheritanceLevel;
		inheritanceLevel = newInheritanceLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.NODE__INHERITANCE_LEVEL, oldInheritanceLevel, inheritanceLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		String type = "?";
		if (getStateGraphNode() instanceof RefinedState) {
			type = "RefinedState";
		}
		else if (getStateGraphNode() instanceof SimpleState) {
			type = "SimpleState";
		}
		else if (getStateGraphNode() instanceof TrPoint) {
			type = "TrPoint";
		}
		else if (getStateGraphNode() instanceof ChoicePoint) {
			type = "ChoicePoint";
		}
		return "Node " + getStateGraphNode().getName() + " (" + type + ")";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmGenPackage.NODE__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((Graph)otherEnd, msgs);
			case FsmGenPackage.NODE__SUBGRAPH:
				if (subgraph != null)
					msgs = ((InternalEObject)subgraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmGenPackage.NODE__SUBGRAPH, null, msgs);
				return basicSetSubgraph((Graph)otherEnd, msgs);
			case FsmGenPackage.NODE__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
			case FsmGenPackage.NODE__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmGenPackage.NODE__GRAPH:
				return basicSetGraph(null, msgs);
			case FsmGenPackage.NODE__SUBGRAPH:
				return basicSetSubgraph(null, msgs);
			case FsmGenPackage.NODE__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case FsmGenPackage.NODE__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case FsmGenPackage.NODE__CAUGHT_TRIGGERS:
				return ((InternalEList<?>)getCaughtTriggers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FsmGenPackage.NODE__GRAPH:
				return eInternalContainer().eInverseRemove(this, FsmGenPackage.GRAPH__NODES, Graph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmGenPackage.NODE__GRAPH:
				return getGraph();
			case FsmGenPackage.NODE__SUBGRAPH:
				return getSubgraph();
			case FsmGenPackage.NODE__OUTGOING:
				return getOutgoing();
			case FsmGenPackage.NODE__INCOMING:
				return getIncoming();
			case FsmGenPackage.NODE__STATE_GRAPH_NODE:
				if (resolve) return getStateGraphNode();
				return basicGetStateGraphNode();
			case FsmGenPackage.NODE__CAUGHT_TRIGGERS:
				return getCaughtTriggers();
			case FsmGenPackage.NODE__INHERITANCE_LEVEL:
				return getInheritanceLevel();
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
			case FsmGenPackage.NODE__GRAPH:
				setGraph((Graph)newValue);
				return;
			case FsmGenPackage.NODE__SUBGRAPH:
				setSubgraph((Graph)newValue);
				return;
			case FsmGenPackage.NODE__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends Link>)newValue);
				return;
			case FsmGenPackage.NODE__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends Link>)newValue);
				return;
			case FsmGenPackage.NODE__STATE_GRAPH_NODE:
				setStateGraphNode((StateGraphNode)newValue);
				return;
			case FsmGenPackage.NODE__CAUGHT_TRIGGERS:
				getCaughtTriggers().clear();
				getCaughtTriggers().addAll((Collection<? extends CommonTrigger>)newValue);
				return;
			case FsmGenPackage.NODE__INHERITANCE_LEVEL:
				setInheritanceLevel((Integer)newValue);
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
			case FsmGenPackage.NODE__GRAPH:
				setGraph((Graph)null);
				return;
			case FsmGenPackage.NODE__SUBGRAPH:
				setSubgraph((Graph)null);
				return;
			case FsmGenPackage.NODE__OUTGOING:
				getOutgoing().clear();
				return;
			case FsmGenPackage.NODE__INCOMING:
				getIncoming().clear();
				return;
			case FsmGenPackage.NODE__STATE_GRAPH_NODE:
				setStateGraphNode((StateGraphNode)null);
				return;
			case FsmGenPackage.NODE__CAUGHT_TRIGGERS:
				getCaughtTriggers().clear();
				return;
			case FsmGenPackage.NODE__INHERITANCE_LEVEL:
				setInheritanceLevel(INHERITANCE_LEVEL_EDEFAULT);
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
			case FsmGenPackage.NODE__GRAPH:
				return getGraph() != null;
			case FsmGenPackage.NODE__SUBGRAPH:
				return subgraph != null;
			case FsmGenPackage.NODE__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case FsmGenPackage.NODE__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case FsmGenPackage.NODE__STATE_GRAPH_NODE:
				return stateGraphNode != null;
			case FsmGenPackage.NODE__CAUGHT_TRIGGERS:
				return caughtTriggers != null && !caughtTriggers.isEmpty();
			case FsmGenPackage.NODE__INHERITANCE_LEVEL:
				return inheritanceLevel != INHERITANCE_LEVEL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FsmGenPackage.NODE___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //NodeImpl
