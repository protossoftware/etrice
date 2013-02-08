/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.VarDecl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Chain</b></em>'.
 * A transition chain is a connected part of the state machine. Connections are mediated by
 * choice points and entry and exit points.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.TransitionChain#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.TransitionChain#isSkipEntry <em>Skip Entry</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.TransitionChain#getData <em>Data</em>}</li>
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
	 * The associated ROOM model transition.
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
	 * If <code>true</code> then the entry code execution of the state whose history will be entered
	 * should be skipped after traversal of this chain.
	 * This is the case
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
	 * Returns the value of the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * It is the data type common to all associated transitions.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' reference.
	 * @see #setData(VarDecl)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getTransitionChain_Data()
	 * @model
	 * @generated
	 */
	VarDecl getData();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.TransitionChain#getData <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(VarDecl value);

	/**
	 * <!-- begin-user-doc -->
	 * @return the parent state of this transition (if applicable, i.e. if not already on the top level)
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	State getStateContext();

	/**
	 * <!-- begin-user-doc -->
	 * @return <code>true</code> if the starting point of the transition chain is a {@link TransitionPoint} and
	 * has its {@link org.eclipse.etrice.core.room.TransitionPoint#isHandler() handler flag} set
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
