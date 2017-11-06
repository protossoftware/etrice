/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getSubgraph <em>Subgraph</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getStateGraphNode <em>State Graph Node</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getCaughtTriggers <em>Caught Triggers</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getInheritanceLevel <em>Inheritance Level</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends GraphItem {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(Graph)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getNode_Graph()
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getNodes
	 * @model opposite="nodes" transient="false"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Subgraph</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subgraph</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subgraph</em>' containment reference.
	 * @see #setSubgraph(Graph)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getNode_Subgraph()
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getNode
	 * @model opposite="node" containment="true"
	 * @generated
	 */
	Graph getSubgraph();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getSubgraph <em>Subgraph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subgraph</em>' containment reference.
	 * @see #getSubgraph()
	 * @generated
	 */
	void setSubgraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getNode_Outgoing()
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Link> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getNode_Incoming()
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Link> getIncoming();

	/**
	 * Returns the value of the '<em><b>State Graph Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Graph Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Graph Node</em>' reference.
	 * @see #setStateGraphNode(StateGraphNode)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getNode_StateGraphNode()
	 * @model
	 * @generated
	 */
	StateGraphNode getStateGraphNode();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getStateGraphNode <em>State Graph Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Graph Node</em>' reference.
	 * @see #getStateGraphNode()
	 * @generated
	 */
	void setStateGraphNode(StateGraphNode value);

	/**
	 * Returns the value of the '<em><b>Caught Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caught Triggers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caught Triggers</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getNode_CaughtTriggers()
	 * @model containment="true"
	 * @generated
	 */
	EList<CommonTrigger> getCaughtTriggers();

	/**
	 * Returns the value of the '<em><b>Inheritance Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inheritance Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inheritance Level</em>' attribute.
	 * @see #setInheritanceLevel(int)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getNode_InheritanceLevel()
	 * @model
	 * @generated
	 */
	int getInheritanceLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getInheritanceLevel <em>Inheritance Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inheritance Level</em>' attribute.
	 * @see #getInheritanceLevel()
	 * @generated
	 */
	void setInheritanceLevel(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='String type = \"?\";\r\nif (getStateGraphNode() instanceof <%org.eclipse.etrice.core.fsm.fSM.RefinedState%>) {\r\n\ttype = \"RefinedState\";\r\n}\r\nelse if (getStateGraphNode() instanceof <%org.eclipse.etrice.core.fsm.fSM.SimpleState%>) {\r\n\ttype = \"SimpleState\";\r\n}\r\nelse if (getStateGraphNode() instanceof <%org.eclipse.etrice.core.fsm.fSM.TrPoint%>) {\r\n\ttype = \"TrPoint\";\r\n}\r\nelse if (getStateGraphNode() instanceof <%org.eclipse.etrice.core.fsm.fSM.ChoicePoint%>) {\r\n\ttype = \"ChoicePoint\";\r\n}\r\nreturn \"Node \" + getStateGraphNode().getName() + \" (\" + type + \")\";'"
	 * @generated
	 */
	String toString();

} // Node
