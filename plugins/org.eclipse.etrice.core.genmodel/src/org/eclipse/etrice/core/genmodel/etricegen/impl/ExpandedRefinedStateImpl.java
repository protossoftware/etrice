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

package org.eclipse.etrice.core.genmodel.etricegen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.impl.SimpleStateImpl;
import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expanded Refined State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedRefinedStateImpl#getInheritedEntry <em>Inherited Entry</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedRefinedStateImpl#getInheritedExit <em>Inherited Exit</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedRefinedStateImpl#getInheritedDo <em>Inherited Do</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpandedRefinedStateImpl extends SimpleStateImpl implements ExpandedRefinedState {
	/**
	 * The cached value of the '{@link #getInheritedEntry() <em>Inherited Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedEntry()
	 * @generated
	 * @ordered
	 */
	protected DetailCode inheritedEntry;

	/**
	 * The cached value of the '{@link #getInheritedExit() <em>Inherited Exit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedExit()
	 * @generated
	 * @ordered
	 */
	protected DetailCode inheritedExit;

	/**
	 * The cached value of the '{@link #getInheritedDo() <em>Inherited Do</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedDo()
	 * @generated
	 * @ordered
	 */
	protected DetailCode inheritedDo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpandedRefinedStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.EXPANDED_REFINED_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DetailCode getInheritedEntry() {
		return inheritedEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInheritedEntry(DetailCode newInheritedEntry, NotificationChain msgs) {
		DetailCode oldInheritedEntry = inheritedEntry;
		inheritedEntry = newInheritedEntry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY, oldInheritedEntry, newInheritedEntry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedEntry(DetailCode newInheritedEntry) {
		if (newInheritedEntry != inheritedEntry) {
			NotificationChain msgs = null;
			if (inheritedEntry != null)
				msgs = ((InternalEObject)inheritedEntry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY, null, msgs);
			if (newInheritedEntry != null)
				msgs = ((InternalEObject)newInheritedEntry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY, null, msgs);
			msgs = basicSetInheritedEntry(newInheritedEntry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY, newInheritedEntry, newInheritedEntry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DetailCode getInheritedExit() {
		return inheritedExit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInheritedExit(DetailCode newInheritedExit, NotificationChain msgs) {
		DetailCode oldInheritedExit = inheritedExit;
		inheritedExit = newInheritedExit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT, oldInheritedExit, newInheritedExit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedExit(DetailCode newInheritedExit) {
		if (newInheritedExit != inheritedExit) {
			NotificationChain msgs = null;
			if (inheritedExit != null)
				msgs = ((InternalEObject)inheritedExit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT, null, msgs);
			if (newInheritedExit != null)
				msgs = ((InternalEObject)newInheritedExit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT, null, msgs);
			msgs = basicSetInheritedExit(newInheritedExit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT, newInheritedExit, newInheritedExit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DetailCode getInheritedDo() {
		return inheritedDo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInheritedDo(DetailCode newInheritedDo, NotificationChain msgs) {
		DetailCode oldInheritedDo = inheritedDo;
		inheritedDo = newInheritedDo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO, oldInheritedDo, newInheritedDo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedDo(DetailCode newInheritedDo) {
		if (newInheritedDo != inheritedDo) {
			NotificationChain msgs = null;
			if (inheritedDo != null)
				msgs = ((InternalEObject)inheritedDo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO, null, msgs);
			if (newInheritedDo != null)
				msgs = ((InternalEObject)newInheritedDo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO, null, msgs);
			msgs = basicSetInheritedDo(newInheritedDo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO, newInheritedDo, newInheritedDo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void init(RefinedState rs) {
		setName(rs.getName());
		
		// the next assignments take over the code and docu and state graph objects from rs
		// but this is a copy and thus does no harm
		setEntryCode(rs.getEntryCode());
		setExitCode(rs.getExitCode());
		setDoCode(rs.getDoCode());
		setDocu(rs.getDocu());
		setSubgraph(rs.getSubgraph());
		
		// now we collect the inherited detail code
		setInheritedEntry(RoomHelpers.getInheritedEntryCode(rs));
		setInheritedExit(RoomHelpers.getInheritedExitCode(rs));
		setInheritedDo(RoomHelpers.getInheritedDoCode(rs));
		
		// remove refined state from its container
		((StateGraph)rs.eContainer()).getStates().remove(rs);
		
		// put new state in place of SimpleState which is the ultimate target of the refined state
		State bs = RoomHelpers.getBaseState(rs);
		StateGraph parent = (StateGraph) bs.eContainer();
		parent.getStates().add(this);
		parent.getStates().remove(bs);
		for (Transition trans : parent.getTransitions()) {
			if (trans.getTo() instanceof StateTerminal) {
				if (((StateTerminal)trans.getTo()).getState()==bs)
					((StateTerminal)trans.getTo()).setState(this);
			}
			else if (trans.getTo() instanceof SubStateTrPointTerminal) {
				if (((SubStateTrPointTerminal)trans.getTo()).getState()==bs)
					((SubStateTrPointTerminal)trans.getTo()).setState(this);
			}
			if (trans instanceof NonInitialTransition) {
				if (((NonInitialTransition)trans).getFrom() instanceof StateTerminal) {
					if (((StateTerminal)((NonInitialTransition)trans).getFrom()).getState()==bs)
						((StateTerminal)((NonInitialTransition)trans).getFrom()).setState(this);
				}
				else if (((NonInitialTransition)trans).getFrom() instanceof SubStateTrPointTerminal) {
					if (((SubStateTrPointTerminal)((NonInitialTransition)trans).getFrom()).getState()==bs)
						((SubStateTrPointTerminal)((NonInitialTransition)trans).getFrom()).setState(this);
				}
			}
		}
		
		// move contents of base state to this state
		StateGraph fromSG = bs.getSubgraph();
		if (fromSG!=null) {
			StateGraph toSG = getSubgraph();
			if (toSG==null) {
				toSG = RoomFactory.eINSTANCE.createStateGraph();
				setSubgraph(toSG);
			}
			toSG.getChPoints().addAll(fromSG.getChPoints());
			toSG.getStates().addAll(fromSG.getStates());
			toSG.getTrPoints().addAll(fromSG.getTrPoints());
			toSG.getTransitions().addAll(fromSG.getTransitions());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY:
				return basicSetInheritedEntry(null, msgs);
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT:
				return basicSetInheritedExit(null, msgs);
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO:
				return basicSetInheritedDo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY:
				return getInheritedEntry();
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT:
				return getInheritedExit();
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO:
				return getInheritedDo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY:
				setInheritedEntry((DetailCode)newValue);
				return;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT:
				setInheritedExit((DetailCode)newValue);
				return;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO:
				setInheritedDo((DetailCode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY:
				setInheritedEntry((DetailCode)null);
				return;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT:
				setInheritedExit((DetailCode)null);
				return;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO:
				setInheritedDo((DetailCode)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY:
				return inheritedEntry != null;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT:
				return inheritedExit != null;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO:
				return inheritedDo != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpandedRefinedStateImpl
