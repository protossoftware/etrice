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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.VarDecl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expanded Actor Class</b></em>'.
 * The expanded actor class holds a state machine which includes all inherited state graph items
 * and has the refined states replaced with simple states.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedActorClass()
 * @model
 * @generated
 */
public interface ExpandedActorClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * A reference to the original {@link ActorClass}.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Class</em>' reference.
	 * @see #setActorClass(ActorClass)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedActorClass_ActorClass()
	 * @model
	 * @generated
	 */
	ActorClass getActorClass();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getActorClass <em>Actor Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor Class</em>' reference.
	 * @see #getActorClass()
	 * @generated
	 */
	void setActorClass(ActorClass value);

	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The transformed state machine with all inherited items made explicit.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machine</em>' containment reference.
	 * @see #setStateMachine(StateGraph)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedActorClass_StateMachine()
	 * @model containment="true"
	 * @generated
	 */
	StateGraph getStateMachine();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getStateMachine <em>State Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' containment reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateGraph value);

	/**
	 * <!-- begin-user-doc -->
	 * This is for <b>internal use</b> only.
	 * <!-- end-user-doc -->
	 * @model validatorType="org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician"
	 * @generated
	 */
	void prepare(IDiagnostician validator);

	/**
	 * <!-- begin-user-doc -->
	 * This is for <b>internal use</b> only.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void release();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addOwnObject(StateGraphItem obj);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isOwnObject(StateGraphItem obj);

	/**
	 * <!-- begin-user-doc -->
	 * @param ifitem an interface item (no relay port or SPP) of this actor class
	 * @return the local ID of an interface item (port, spp, sap) is computed recursively starting with
	 * the base class and an ID of 0. For each class in the class hierarchy the enumeratins
	 * starts with external ports, then internal ports, then SAPs and finally SPPs.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getInterfaceItemLocalId(InterfaceItem ifitem);

	/**
	 * <!-- begin-user-doc -->
	 * @return  <code>true</code> if a state machine is defined somewhere in actor the class hierarchy
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasStateMachine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getTriggerCodeName(MessageFromIf mif);

	/**
	 * <!-- begin-user-doc -->
	 * @param at the active trigger
	 * @return a string that can serve as the name of a constant representing this trigger.
	 * @see #getTriggerCodeName(MessageFromIf)
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getTriggerCodeName(ActiveTrigger at);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions(StateGraphNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Transition> getIncomingTransitions(StateGraphNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ActiveTrigger> getActiveTriggers(State state);

	/**
	 * <!-- begin-user-doc -->
	 * @return a sorted list of triggers of this actor class (including base classes).
	 * The elements are sorted by the trigger name (a concatenation of interface item name and message name).
	 * @see #getOwnTriggers()
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<MessageFromIf> getTriggers();

	/**
	 * <!-- begin-user-doc -->
	 * @return a sorted list of triggers of this actor class (including base classes).
	 * The elements are sorted by the trigger name (a concatenation of interface item name and message name).
	 * @see #getTriggers()
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<MessageFromIf> getOwnTriggers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getMessageID(MessageFromIf mif);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TransitionChain getChain(Transition trans);

	/**
	 * <!-- begin-user-doc -->
	 * @return a list of all {@link TransitionChain}s
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<TransitionChain> getTransitionChains();

	/**
	 * <!-- begin-user-doc -->
	 * @return a list of all {@link TransitionChain}s that aren't inherited
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<TransitionChain> getOwnTransitionChains();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isMatching(Trigger trig, String trigstr);

	/**
	 * <!-- begin-user-doc -->
	 * @param out a list of outgoing transitions
	 * @return the first {@link ContinuationTransition} in the list (which for a {@link ChoicePoint}
	 * corresponds to the unique default branch)
	 * <!-- end-user-doc -->
	 * @model outMany="true"
	 * @generated
	 */
	ContinuationTransition getDefaultBranch(EList<Transition> out);

	/**
	 * <!-- begin-user-doc -->
	 * The state machine of an {@link ExpandedActorClass} contains only copies of the original
	 * {@link StateGraphItem}s. This methods maps back to the original object if applicable.
	 * 
	 * @param copy a copied object
	 * @return the original object of the {@link RoomModel1}
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getOrig(EObject copy);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	VarDecl getData(Transition trans);

} // ExpandedActorClass
