/**
 */
package org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Common Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.CommonTriggerImpl#getMsg <em>Msg</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.CommonTriggerImpl#getIfitem <em>Ifitem</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.CommonTriggerImpl#isHasGuard <em>Has Guard</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.CommonTriggerImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.fsm.fsmgen.impl.CommonTriggerImpl#getLinks <em>Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommonTriggerImpl extends FSMGenElementImpl implements CommonTrigger {
	/**
	 * The cached value of the '{@link #getMsg() <em>Msg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsg()
	 * @generated
	 * @ordered
	 */
	protected EObject msg;

	/**
	 * The cached value of the '{@link #getIfitem() <em>Ifitem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfitem()
	 * @generated
	 * @ordered
	 */
	protected AbstractInterfaceItem ifitem;

	/**
	 * The default value of the '{@link #isHasGuard() <em>Has Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasGuard()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_GUARD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasGuard() <em>Has Guard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasGuard()
	 * @generated
	 * @ordered
	 */
	protected boolean hasGuard = HAS_GUARD_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected String trigger = TRIGGER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommonTriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmGenPackage.Literals.COMMON_TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getMsg() {
		if (msg != null && msg.eIsProxy()) {
			InternalEObject oldMsg = (InternalEObject)msg;
			msg = eResolveProxy(oldMsg);
			if (msg != oldMsg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmGenPackage.COMMON_TRIGGER__MSG, oldMsg, msg));
			}
		}
		return msg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetMsg() {
		return msg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsg(EObject newMsg) {
		EObject oldMsg = msg;
		msg = newMsg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.COMMON_TRIGGER__MSG, oldMsg, msg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractInterfaceItem getIfitem() {
		if (ifitem != null && ifitem.eIsProxy()) {
			InternalEObject oldIfitem = (InternalEObject)ifitem;
			ifitem = (AbstractInterfaceItem)eResolveProxy(oldIfitem);
			if (ifitem != oldIfitem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmGenPackage.COMMON_TRIGGER__IFITEM, oldIfitem, ifitem));
			}
		}
		return ifitem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractInterfaceItem basicGetIfitem() {
		return ifitem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfitem(AbstractInterfaceItem newIfitem) {
		AbstractInterfaceItem oldIfitem = ifitem;
		ifitem = newIfitem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.COMMON_TRIGGER__IFITEM, oldIfitem, ifitem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTrigger() {
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrigger(String newTrigger) {
		String oldTrigger = trigger;
		trigger = newTrigger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.COMMON_TRIGGER__TRIGGER, oldTrigger, trigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectResolvingEList<Link>(Link.class, this, FsmGenPackage.COMMON_TRIGGER__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasGuard() {
		return hasGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasGuard(boolean newHasGuard) {
		boolean oldHasGuard = hasGuard;
		hasGuard = newHasGuard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmGenPackage.COMMON_TRIGGER__HAS_GUARD, oldHasGuard, hasGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmGenPackage.COMMON_TRIGGER__MSG:
				if (resolve) return getMsg();
				return basicGetMsg();
			case FsmGenPackage.COMMON_TRIGGER__IFITEM:
				if (resolve) return getIfitem();
				return basicGetIfitem();
			case FsmGenPackage.COMMON_TRIGGER__HAS_GUARD:
				return isHasGuard();
			case FsmGenPackage.COMMON_TRIGGER__TRIGGER:
				return getTrigger();
			case FsmGenPackage.COMMON_TRIGGER__LINKS:
				return getLinks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmGenPackage.COMMON_TRIGGER__MSG:
				setMsg((EObject)newValue);
				return;
			case FsmGenPackage.COMMON_TRIGGER__IFITEM:
				setIfitem((AbstractInterfaceItem)newValue);
				return;
			case FsmGenPackage.COMMON_TRIGGER__HAS_GUARD:
				setHasGuard((Boolean)newValue);
				return;
			case FsmGenPackage.COMMON_TRIGGER__TRIGGER:
				setTrigger((String)newValue);
				return;
			case FsmGenPackage.COMMON_TRIGGER__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
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
			case FsmGenPackage.COMMON_TRIGGER__MSG:
				setMsg((EObject)null);
				return;
			case FsmGenPackage.COMMON_TRIGGER__IFITEM:
				setIfitem((AbstractInterfaceItem)null);
				return;
			case FsmGenPackage.COMMON_TRIGGER__HAS_GUARD:
				setHasGuard(HAS_GUARD_EDEFAULT);
				return;
			case FsmGenPackage.COMMON_TRIGGER__TRIGGER:
				setTrigger(TRIGGER_EDEFAULT);
				return;
			case FsmGenPackage.COMMON_TRIGGER__LINKS:
				getLinks().clear();
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
			case FsmGenPackage.COMMON_TRIGGER__MSG:
				return msg != null;
			case FsmGenPackage.COMMON_TRIGGER__IFITEM:
				return ifitem != null;
			case FsmGenPackage.COMMON_TRIGGER__HAS_GUARD:
				return hasGuard != HAS_GUARD_EDEFAULT;
			case FsmGenPackage.COMMON_TRIGGER__TRIGGER:
				return TRIGGER_EDEFAULT == null ? trigger != null : !TRIGGER_EDEFAULT.equals(trigger);
			case FsmGenPackage.COMMON_TRIGGER__LINKS:
				return links != null && !links.isEmpty();
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
		result.append(" (hasGuard: ");
		result.append(hasGuard);
		result.append(", trigger: ");
		result.append(trigger);
		result.append(')');
		return result.toString();
	}

} //CommonTriggerImpl
