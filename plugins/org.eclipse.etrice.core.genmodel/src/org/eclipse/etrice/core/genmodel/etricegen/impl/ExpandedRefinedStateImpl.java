/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.core.genmodel.etricegen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState;
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
	 * The default value of the '{@link #getInheritedEntry() <em>Inherited Entry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedEntry()
	 * @generated
	 * @ordered
	 */
	protected static final String INHERITED_ENTRY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInheritedEntry() <em>Inherited Entry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedEntry()
	 * @generated
	 * @ordered
	 */
	protected String inheritedEntry = INHERITED_ENTRY_EDEFAULT;

	/**
	 * The default value of the '{@link #getInheritedExit() <em>Inherited Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedExit()
	 * @generated
	 * @ordered
	 */
	protected static final String INHERITED_EXIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInheritedExit() <em>Inherited Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedExit()
	 * @generated
	 * @ordered
	 */
	protected String inheritedExit = INHERITED_EXIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInheritedDo() <em>Inherited Do</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedDo()
	 * @generated
	 * @ordered
	 */
	protected static final String INHERITED_DO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInheritedDo() <em>Inherited Do</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedDo()
	 * @generated
	 * @ordered
	 */
	protected String inheritedDo = INHERITED_DO_EDEFAULT;

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
	public String getInheritedEntry() {
		return inheritedEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedEntry(String newInheritedEntry) {
		String oldInheritedEntry = inheritedEntry;
		inheritedEntry = newInheritedEntry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_ENTRY, oldInheritedEntry, inheritedEntry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInheritedExit() {
		return inheritedExit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedExit(String newInheritedExit) {
		String oldInheritedExit = inheritedExit;
		inheritedExit = newInheritedExit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT, oldInheritedExit, inheritedExit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInheritedDo() {
		return inheritedDo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedDo(String newInheritedDo) {
		String oldInheritedDo = inheritedDo;
		inheritedDo = newInheritedDo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO, oldInheritedDo, inheritedDo));
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
				setInheritedEntry((String)newValue);
				return;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT:
				setInheritedExit((String)newValue);
				return;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO:
				setInheritedDo((String)newValue);
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
				setInheritedEntry(INHERITED_ENTRY_EDEFAULT);
				return;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT:
				setInheritedExit(INHERITED_EXIT_EDEFAULT);
				return;
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO:
				setInheritedDo(INHERITED_DO_EDEFAULT);
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
				return INHERITED_ENTRY_EDEFAULT == null ? inheritedEntry != null : !INHERITED_ENTRY_EDEFAULT.equals(inheritedEntry);
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_EXIT:
				return INHERITED_EXIT_EDEFAULT == null ? inheritedExit != null : !INHERITED_EXIT_EDEFAULT.equals(inheritedExit);
			case ETriceGenPackage.EXPANDED_REFINED_STATE__INHERITED_DO:
				return INHERITED_DO_EDEFAULT == null ? inheritedDo != null : !INHERITED_DO_EDEFAULT.equals(inheritedDo);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (inheritedEntry: ");
		result.append(inheritedEntry);
		result.append(", inheritedExit: ");
		result.append(inheritedExit);
		result.append(", inheritedDo: ");
		result.append(inheritedDo);
		result.append(')');
		return result.toString();
	}

} //ExpandedRefinedStateImpl
