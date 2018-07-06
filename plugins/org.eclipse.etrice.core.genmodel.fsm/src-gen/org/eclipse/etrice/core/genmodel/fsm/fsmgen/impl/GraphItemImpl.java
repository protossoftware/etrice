/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.GraphItemImpl#isInherited <em>Inherited</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphItemImpl extends FSMGenElementImpl implements GraphItem {
	/**
	 * The default value of the '{@link #isInherited() <em>Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInherited()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INHERITED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInherited() <em>Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInherited()
	 * @generated
	 * @ordered
	 */
	protected boolean inherited = INHERITED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmGenPackage.Literals.GRAPH_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInherited() {
		return inherited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInherited(boolean newInherited) {
		boolean oldInherited = inherited;
		inherited = newInherited;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.GRAPH_ITEM__INHERITED, oldInherited, inherited));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmGenPackage.GRAPH_ITEM__INHERITED:
				return isInherited();
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
			case FsmGenPackage.GRAPH_ITEM__INHERITED:
				setInherited((Boolean)newValue);
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
			case FsmGenPackage.GRAPH_ITEM__INHERITED:
				setInherited(INHERITED_EDEFAULT);
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
			case FsmGenPackage.GRAPH_ITEM__INHERITED:
				return inherited != INHERITED_EDEFAULT;
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
		result.append(" (inherited: ");
		result.append(inherited);
		result.append(')');
		return result.toString();
	}

} //GraphItemImpl
