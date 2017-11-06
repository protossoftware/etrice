/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen;

import org.eclipse.etrice.core.fsm.fSM.ModelComponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedTriggersInStates <em>Initialized Triggers In States</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedChainHeads <em>Initialized Chain Heads</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedCommonData <em>Initialized Common Data</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getGraphContainer()
 * @model
 * @generated
 */
public interface GraphContainer extends FSMGenElement {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' containment reference.
	 * @see #setGraph(Graph)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getGraphContainer_Graph()
	 * @model containment="true"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getGraph <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' containment reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(ModelComponent)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getGraphContainer_Component()
	 * @model
	 * @generated
	 */
	ModelComponent getComponent();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(ModelComponent value);

	/**
	 * Returns the value of the '<em><b>Initialized Triggers In States</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized Triggers In States</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Triggers In States</em>' attribute.
	 * @see #setInitializedTriggersInStates(boolean)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getGraphContainer_InitializedTriggersInStates()
	 * @model
	 * @generated
	 */
	boolean isInitializedTriggersInStates();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedTriggersInStates <em>Initialized Triggers In States</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Triggers In States</em>' attribute.
	 * @see #isInitializedTriggersInStates()
	 * @generated
	 */
	void setInitializedTriggersInStates(boolean value);

	/**
	 * Returns the value of the '<em><b>Initialized Chain Heads</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized Chain Heads</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Chain Heads</em>' attribute.
	 * @see #setInitializedChainHeads(boolean)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getGraphContainer_InitializedChainHeads()
	 * @model
	 * @generated
	 */
	boolean isInitializedChainHeads();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedChainHeads <em>Initialized Chain Heads</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Chain Heads</em>' attribute.
	 * @see #isInitializedChainHeads()
	 * @generated
	 */
	void setInitializedChainHeads(boolean value);

	/**
	 * Returns the value of the '<em><b>Initialized Common Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized Common Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Common Data</em>' attribute.
	 * @see #setInitializedCommonData(boolean)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getGraphContainer_InitializedCommonData()
	 * @model
	 * @generated
	 */
	boolean isInitializedCommonData();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer#isInitializedCommonData <em>Initialized Common Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Common Data</em>' attribute.
	 * @see #isInitializedCommonData()
	 * @generated
	 */
	void setInitializedCommonData(boolean value);

} // GraphContainer
