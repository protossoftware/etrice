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

import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expanded Refined State</b></em>'.
 * The expanded refined state is a {@link SimpleState} that additionally holds inherited action codes.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedEntry <em>Inherited Entry</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedExit <em>Inherited Exit</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedDo <em>Inherited Do</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedRefinedState()
 * @model
 * @generated
 */
public interface ExpandedRefinedState extends SimpleState {
	/**
	 * Returns the value of the '<em><b>Inherited Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This {@link DetailCode} holds the pre-assembled inherited entry code of the original {@link RefinedState} 
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Entry</em>' containment reference.
	 * @see #setInheritedEntry(DetailCode)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedRefinedState_InheritedEntry()
	 * @model containment="true"
	 * @generated
	 */
	DetailCode getInheritedEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedEntry <em>Inherited Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Entry</em>' containment reference.
	 * @see #getInheritedEntry()
	 * @generated
	 */
	void setInheritedEntry(DetailCode value);

	/**
	 * Returns the value of the '<em><b>Inherited Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This {@link DetailCode} holds the pre-assembled inherited exit code of the original {@link RefinedState} 
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Exit</em>' containment reference.
	 * @see #setInheritedExit(DetailCode)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedRefinedState_InheritedExit()
	 * @model containment="true"
	 * @generated
	 */
	DetailCode getInheritedExit();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedExit <em>Inherited Exit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Exit</em>' containment reference.
	 * @see #getInheritedExit()
	 * @generated
	 */
	void setInheritedExit(DetailCode value);

	/**
	 * Returns the value of the '<em><b>Inherited Do</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This {@link DetailCode} holds the pre-assembled inherited do code of the original {@link RefinedState} 
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Do</em>' containment reference.
	 * @see #setInheritedDo(DetailCode)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedRefinedState_InheritedDo()
	 * @model containment="true"
	 * @generated
	 */
	DetailCode getInheritedDo();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedDo <em>Inherited Do</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Do</em>' containment reference.
	 * @see #getInheritedDo()
	 * @generated
	 */
	void setInheritedDo(DetailCode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void init(RefinedState rs);

} // ExpandedRefinedState
