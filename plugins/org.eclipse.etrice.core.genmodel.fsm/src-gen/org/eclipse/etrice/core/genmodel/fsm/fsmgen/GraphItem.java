/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem#isInherited <em>Inherited</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getGraphItem()
 * @model
 * @generated
 */
public interface GraphItem extends FSMGenElement {
	/**
	 * Returns the value of the '<em><b>Inherited</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited</em>' attribute.
	 * @see #setInherited(boolean)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getGraphItem_Inherited()
	 * @model default="false"
	 * @generated
	 */
	boolean isInherited();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem#isInherited <em>Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited</em>' attribute.
	 * @see #isInherited()
	 * @generated
	 */
	void setInherited(boolean value);

} // GraphItem
