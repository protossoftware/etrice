/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Common Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getMsg <em>Msg</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getIfitem <em>Ifitem</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#isHasGuard <em>Has Guard</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getLinks <em>Links</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getCommonTrigger()
 * @model
 * @generated
 */
public interface CommonTrigger extends FSMGenElement {
	/**
	 * Returns the value of the '<em><b>Msg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Msg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msg</em>' reference.
	 * @see #setMsg(EObject)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getCommonTrigger_Msg()
	 * @model
	 * @generated
	 */
	EObject getMsg();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getMsg <em>Msg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Msg</em>' reference.
	 * @see #getMsg()
	 * @generated
	 */
	void setMsg(EObject value);

	/**
	 * Returns the value of the '<em><b>Ifitem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifitem</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifitem</em>' reference.
	 * @see #setIfitem(AbstractInterfaceItem)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getCommonTrigger_Ifitem()
	 * @model
	 * @generated
	 */
	AbstractInterfaceItem getIfitem();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getIfitem <em>Ifitem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ifitem</em>' reference.
	 * @see #getIfitem()
	 * @generated
	 */
	void setIfitem(AbstractInterfaceItem value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' attribute.
	 * @see #setTrigger(String)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getCommonTrigger_Trigger()
	 * @model
	 * @generated
	 */
	String getTrigger();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#getTrigger <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' attribute.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(String value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getCommonTrigger_Links()
	 * @model
	 * @generated
	 */
	EList<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>Has Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Guard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Guard</em>' attribute.
	 * @see #setHasGuard(boolean)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getCommonTrigger_HasGuard()
	 * @model
	 * @generated
	 */
	boolean isHasGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger#isHasGuard <em>Has Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Guard</em>' attribute.
	 * @see #isHasGuard()
	 * @generated
	 */
	void setHasGuard(boolean value);

} // CommonTrigger
