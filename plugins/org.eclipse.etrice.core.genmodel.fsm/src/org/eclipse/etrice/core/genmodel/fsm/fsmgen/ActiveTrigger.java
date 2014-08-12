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

package org.eclipse.etrice.core.genmodel.fsm.fsmgen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.AbstractMessage;
import org.eclipse.etrice.core.fsm.fSM.Guard;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Active Trigger</b></em>'.
 * It combines information from a transition {@link Trigger} and is meant to represent a trigger which is
 * attached to a {@link State}. The active triggers of a state are computed by collecting all triggers
 * of {@link Transition}s starting at the state. Then transitions starting at {@link TrPoint}s of the parent state
 * are considered. This process is recursively done for all parent states. When a msg/ifitem pair is already
 * in the list of active triggers then further occurrences are skipped except when the first occurrences are
 * {@link Guard}ed.<br/><br/>
 * 
 * The ordered list of active triggers can be obtained from the ExpandedActorClass by calling
 * {@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getActiveTriggers(State) getActiveTriggers(State)}
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getMsg <em>Msg</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getIfitem <em>Ifitem</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getActiveTrigger()
 * @model
 * @generated
 */
public interface ActiveTrigger extends EObject {
	/**
	 * Returns the value of the '<em><b>Msg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is the triggering message (in combination with an interface item, cf. {@link #getIfitem()}
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msg</em>' reference.
	 * @see #setMsg(AbstractMessage)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getActiveTrigger_Msg()
	 * @model
	 * @generated
	 */
	AbstractMessage getMsg();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getMsg <em>Msg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Msg</em>' reference.
	 * @see #getMsg()
	 * @generated
	 */
	void setMsg(AbstractMessage value);

	/**
	 * Returns the value of the '<em><b>Ifitem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is the interface item from which the triggering message (see {@link #getMsg()} originates.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifitem</em>' reference.
	 * @see #setIfitem(AbstractInterfaceItem)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getActiveTrigger_Ifitem()
	 * @model
	 * @generated
	 */
	AbstractInterfaceItem getIfitem();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getIfitem <em>Ifitem</em>}' reference.
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
	 * A string representation of the trigger (<b>for internal use only</b>).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' attribute.
	 * @see #setTrigger(String)
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getActiveTrigger_Trigger()
	 * @model
	 * @generated
	 */
	String getTrigger();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger#getTrigger <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' attribute.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(String value);

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.fsm.fSM.TriggeredTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * An ordered list of {@link Transition}s with this trigger.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage#getActiveTrigger_Transitions()
	 * @model
	 * @generated
	 */
	EList<TriggeredTransition> getTransitions();

} // ActiveTrigger
