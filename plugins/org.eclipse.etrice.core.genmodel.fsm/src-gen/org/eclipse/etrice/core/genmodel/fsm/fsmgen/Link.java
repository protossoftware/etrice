/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getChainHeads <em>Chain Heads</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#isIfitemTriggered <em>Ifitem Triggered</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getCommonData <em>Common Data</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getRefinements <em>Refinements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends GraphItem {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(Graph)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getLink_Graph()
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph#getLinks
	 * @model opposite="links" transient="false"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getLink_Source()
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getOutgoing
	 * @model opposite="outgoing"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getLink_Target()
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node#getIncoming
	 * @model opposite="incoming"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Chain Heads</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chain Heads</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chain Heads</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getLink_ChainHeads()
	 * @model
	 * @generated
	 */
	EList<Link> getChainHeads();

	/**
	 * Returns the value of the '<em><b>Ifitem Triggered</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifitem Triggered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifitem Triggered</em>' attribute.
	 * @see #setIfitemTriggered(boolean)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getLink_IfitemTriggered()
	 * @model default="true"
	 * @generated
	 */
	boolean isIfitemTriggered();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#isIfitemTriggered <em>Ifitem Triggered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifitem Triggered</em>' attribute.
	 * @see #isIfitemTriggered()
	 * @generated
	 */
	void setIfitemTriggered(boolean value);

	/**
	 * Returns the value of the '<em><b>Common Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Common Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Common Data</em>' reference.
	 * @see #setCommonData(EObject)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getLink_CommonData()
	 * @model
	 * @generated
	 */
	EObject getCommonData();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getCommonData <em>Common Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Common Data</em>' reference.
	 * @see #getCommonData()
	 * @generated
	 */
	void setCommonData(EObject value);

	/**
	 * Returns the value of the '<em><b>Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' reference.
	 * @see #setTransition(Transition)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getLink_Transition()
	 * @model
	 * @generated
	 */
	Transition getTransition();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link#getTransition <em>Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition</em>' reference.
	 * @see #getTransition()
	 * @generated
	 */
	void setTransition(Transition value);

	/**
	 * Returns the value of the '<em><b>Refinements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.fsm.fSM.RefinedTransition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refinements</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getLink_Refinements()
	 * @model
	 * @generated
	 */
	EList<RefinedTransition> getRefinements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String toString();

} // Link
