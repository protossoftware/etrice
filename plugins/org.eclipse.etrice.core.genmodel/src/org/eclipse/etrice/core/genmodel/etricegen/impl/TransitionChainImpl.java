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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.ITransitionChainVisitor;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.ExitPoint;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionChainStartTransition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Chain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.TransitionChainImpl#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.impl.TransitionChainImpl#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionChainImpl extends EObjectImpl implements TransitionChain {
	
	private RoomHelpers roomHelpers = new RoomHelpers();
	private RoomNameProvider roomNameProvider = new RoomNameProvider();
	
	/**
	 * The cached value of the '{@link #getTransition() <em>Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransition()
	 * @generated
	 * @ordered
	 */
	protected Transition transition;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected VarDecl data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionChainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.TRANSITION_CHAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getTransition() {
		if (transition != null && transition.eIsProxy()) {
			InternalEObject oldTransition = (InternalEObject)transition;
			transition = (Transition)eResolveProxy(oldTransition);
			if (transition != oldTransition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.TRANSITION_CHAIN__TRANSITION, oldTransition, transition));
			}
		}
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition basicGetTransition() {
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransition(Transition newTransition) {
		Transition oldTransition = transition;
		transition = newTransition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.TRANSITION_CHAIN__TRANSITION, oldTransition, transition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarDecl getData() {
		if (data != null && data.eIsProxy()) {
			InternalEObject oldData = (InternalEObject)data;
			data = (VarDecl)eResolveProxy(oldData);
			if (data != oldData) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETriceGenPackage.TRANSITION_CHAIN__DATA, oldData, data));
			}
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarDecl basicGetData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(VarDecl newData) {
		VarDecl oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.TRANSITION_CHAIN__DATA, oldData, data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public State getStateContext() {
		if (getTransition().eContainer().eContainer() instanceof State)
			return (State) getTransition().eContainer().eContainer();

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isHandler() {
		if (getTransition() instanceof TransitionChainStartTransition) {
			TransitionChainStartTransition trans = (TransitionChainStartTransition)getTransition();
			if (trans.getFrom() instanceof TrPointTerminal) {
				TrPoint tp = ((TrPointTerminal)trans.getFrom()).getTrPoint();
				if (tp instanceof TransitionPoint)
					return ((TransitionPoint)tp).isHandler();
			}
			else if (trans.getFrom() instanceof SubStateTrPointTerminal) {
				TrPoint tp = ((SubStateTrPointTerminal)trans.getFrom()).getTrPoint();
				if (tp instanceof TransitionPoint)
					assert(false): "not allowed to connect TransitionPoint to exterior";
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String genExecuteChain(ITransitionChainVisitor tcv) {
		ExpandedActorClass ac = getExpandedActorClass();
		
		StringBuilder result = new StringBuilder();
		result.append(tcv.genTypedData(this));
		genChainCode(getTransition(), ac, tcv, result);
		return result.toString();
	}
	
	private void genChainCode(Transition tr,
			ExpandedActorClass ac, ITransitionChainVisitor tcv, StringBuilder result) {
		
		result.append(tcv.genActionOperationCall(tr));
		
		StateGraphNode node = roomHelpers.getNode(tr.getTo());
		EList<Transition> out = ac.getOutgoingTransitions(node);
		if (node instanceof ChoicePoint) {
			ContinuationTransition dflt = ac.getDefaultBranch(out);
			assert(dflt!=null): "ChoicePoint "+roomNameProvider.getFullPath(node)+" has no default branch!";
			
			// generate if/else
			boolean isFirst = true;
			for (Transition cond : out) {
				if (cond==dflt)
					continue;
				
				assert(cond instanceof CPBranchTransition): "The non default ChoicePoint branch "
					+roomNameProvider.getFullPath(cond)+" must be of type CPBranchTransition!";
				
				result.append(tcv.genElseIfBranch((CPBranchTransition)cond, isFirst));
				isFirst = false;

				genChainCode(cond, ac, tcv, result);
			}
			
			// generate default
			result.append(tcv.genElseBranch(dflt));
			
			genChainCode(dflt, ac, tcv, result);
			
			result.append(tcv.genEndIf());
		}
		else {
			if (node instanceof TrPoint) {
				if (node instanceof TransitionPoint) {
					// TransitionPoint is final destination of the chain
					result.append(tcv.genReturnState(getStateContext(), false));
					return;
				}
				else {
					assert(out.size()<=1): "TrPoint "+roomNameProvider.getFullPath(node)
					+" is expected to have at most one outgoing transition!";
					if (out.size()==1) {
						State state = (node.eContainer().eContainer() instanceof State)? (State)node.eContainer().eContainer():null;
						if (node instanceof EntryPoint) {
							if (state!=null && ac.isOwnObject(state) && state.getEntryCode()!=null && !state.getEntryCode().getLines().isEmpty())
								result.append(tcv.genEntryOperationCall(state));
						}
						else if (node instanceof ExitPoint) {
							if (state!=null && ac.isOwnObject(state) && state.getExitCode()!=null && !state.getExitCode().getLines().isEmpty())
								result.append(tcv.genExitOperationCall(state));
						}
						else {
							assert(false): "unexpected sub type";
						}
					}
				}
				genChainCode(out.get(0), ac, tcv, result);
			}
			else {
				// the following assertion should always hold true
				assert(node instanceof State): "A transition target can be a ChoicePoint, a TrPoint or a State!";
				
				result.append(tcv.genReturnState((State) node, true));
			}
		}
	}

	private ExpandedActorClass getExpandedActorClass() {
		EObject obj = getTransition();
		while (obj!=null) {
			obj = obj.eContainer();
			if (obj instanceof ExpandedActorClass)
				return (ExpandedActorClass) obj;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.TRANSITION_CHAIN__TRANSITION:
				if (resolve) return getTransition();
				return basicGetTransition();
			case ETriceGenPackage.TRANSITION_CHAIN__DATA:
				if (resolve) return getData();
				return basicGetData();
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
			case ETriceGenPackage.TRANSITION_CHAIN__TRANSITION:
				setTransition((Transition)newValue);
				return;
			case ETriceGenPackage.TRANSITION_CHAIN__DATA:
				setData((VarDecl)newValue);
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
			case ETriceGenPackage.TRANSITION_CHAIN__TRANSITION:
				setTransition((Transition)null);
				return;
			case ETriceGenPackage.TRANSITION_CHAIN__DATA:
				setData((VarDecl)null);
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
			case ETriceGenPackage.TRANSITION_CHAIN__TRANSITION:
				return transition != null;
			case ETriceGenPackage.TRANSITION_CHAIN__DATA:
				return data != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionChainImpl
