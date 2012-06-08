/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Chain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.TransitionChain#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.TransitionChain#isSkipEntry <em>Skip Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getTransitionChain()
 * @model
 * @generated
 */
public interface TransitionChain extends EObject {
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
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getTransitionChain_Transition()
	 * @model
	 * @generated
	 */
	Transition getTransition();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.TransitionChain#getTransition <em>Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition</em>' reference.
	 * @see #getTransition()
	 * @generated
	 */
	void setTransition(Transition value);

	/**
	 * Returns the value of the '<em><b>Skip Entry</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skip Entry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skip Entry</em>' attribute.
	 * @see #setSkipEntry(boolean)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getTransitionChain_SkipEntry()
	 * @model default="false"
	 * @generated
	 */
	boolean isSkipEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.TransitionChain#isSkipEntry <em>Skip Entry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skip Entry</em>' attribute.
	 * @see #isSkipEntry()
	 * @generated
	 */
	void setSkipEntry(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	State getStateContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isHandler();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model tcvType="org.eclipse.etrice.core.genmodel.etricegen.ITransitionChainVisitor"
	 * @generated
	 */
	String genExecuteChain(ITransitionChainVisitor tcv);

} // TransitionChain
