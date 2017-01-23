/**
 */
package org.eclipse.etrice.core.fsm.fSM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.common.base.Documentation;

import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionImpl#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionImpl#getTo <em>To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends StateGraphItemImpl implements Transition
{
  /**
   * The cached value of the '{@link #getDocu() <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocu()
   * @generated
   * @ordered
   */
  protected Documentation docu;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected DetailCode action;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTo() <em>To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTo()
   * @generated
   * @ordered
   */
  protected TransitionTerminal to;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FSMPackage.Literals.TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Documentation getDocu()
  {
    return docu;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDocu(Documentation newDocu, NotificationChain msgs)
  {
    Documentation oldDocu = docu;
    docu = newDocu;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION__DOCU, oldDocu, newDocu);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocu(Documentation newDocu)
  {
    if (newDocu != docu)
    {
      NotificationChain msgs = null;
      if (docu != null)
        msgs = ((InternalEObject)docu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION__DOCU, null, msgs);
      if (newDocu != null)
        msgs = ((InternalEObject)newDocu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION__DOCU, null, msgs);
      msgs = basicSetDocu(newDocu, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION__DOCU, newDocu, newDocu));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetailCode getAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(DetailCode newAction, NotificationChain msgs)
  {
    DetailCode oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION__ACTION, oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(DetailCode newAction)
  {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION__ACTION, newAction, newAction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionTerminal getTo()
  {
    return to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTo(TransitionTerminal newTo, NotificationChain msgs)
  {
    TransitionTerminal oldTo = to;
    to = newTo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION__TO, oldTo, newTo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTo(TransitionTerminal newTo)
  {
    if (newTo != to)
    {
      NotificationChain msgs = null;
      if (to != null)
        msgs = ((InternalEObject)to).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION__TO, null, msgs);
      if (newTo != null)
        msgs = ((InternalEObject)newTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION__TO, null, msgs);
      msgs = basicSetTo(newTo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION__TO, newTo, newTo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION__DOCU:
        return basicSetDocu(null, msgs);
      case FSMPackage.TRANSITION__ACTION:
        return basicSetAction(null, msgs);
      case FSMPackage.TRANSITION__TO:
        return basicSetTo(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION__DOCU:
        return getDocu();
      case FSMPackage.TRANSITION__ACTION:
        return getAction();
      case FSMPackage.TRANSITION__NAME:
        return getName();
      case FSMPackage.TRANSITION__TO:
        return getTo();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION__DOCU:
        setDocu((Documentation)newValue);
        return;
      case FSMPackage.TRANSITION__ACTION:
        setAction((DetailCode)newValue);
        return;
      case FSMPackage.TRANSITION__NAME:
        setName((String)newValue);
        return;
      case FSMPackage.TRANSITION__TO:
        setTo((TransitionTerminal)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION__DOCU:
        setDocu((Documentation)null);
        return;
      case FSMPackage.TRANSITION__ACTION:
        setAction((DetailCode)null);
        return;
      case FSMPackage.TRANSITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FSMPackage.TRANSITION__TO:
        setTo((TransitionTerminal)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION__DOCU:
        return docu != null;
      case FSMPackage.TRANSITION__ACTION:
        return action != null;
      case FSMPackage.TRANSITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FSMPackage.TRANSITION__TO:
        return to != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == TransitionBase.class)
    {
      switch (derivedFeatureID)
      {
        case FSMPackage.TRANSITION__DOCU: return FSMPackage.TRANSITION_BASE__DOCU;
        case FSMPackage.TRANSITION__ACTION: return FSMPackage.TRANSITION_BASE__ACTION;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == TransitionBase.class)
    {
      switch (baseFeatureID)
      {
        case FSMPackage.TRANSITION_BASE__DOCU: return FSMPackage.TRANSITION__DOCU;
        case FSMPackage.TRANSITION_BASE__ACTION: return FSMPackage.TRANSITION__ACTION;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TransitionImpl
