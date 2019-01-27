/**
 */
package org.eclipse.etrice.core.fsm.fSM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.Documentation;

import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Base</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionBaseImpl#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionBaseImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionBaseImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionBaseImpl extends StateGraphItemImpl implements TransitionBase
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
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> annotations;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionBaseImpl()
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
    return FSMPackage.Literals.TRANSITION_BASE;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION_BASE__DOCU, oldDocu, newDocu);
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
        msgs = ((InternalEObject)docu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION_BASE__DOCU, null, msgs);
      if (newDocu != null)
        msgs = ((InternalEObject)newDocu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION_BASE__DOCU, null, msgs);
      msgs = basicSetDocu(newDocu, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION_BASE__DOCU, newDocu, newDocu));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, FSMPackage.TRANSITION_BASE__ANNOTATIONS);
    }
    return annotations;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION_BASE__ACTION, oldAction, newAction);
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
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION_BASE__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FSMPackage.TRANSITION_BASE__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION_BASE__ACTION, newAction, newAction));
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
      case FSMPackage.TRANSITION_BASE__DOCU:
        return basicSetDocu(null, msgs);
      case FSMPackage.TRANSITION_BASE__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case FSMPackage.TRANSITION_BASE__ACTION:
        return basicSetAction(null, msgs);
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
      case FSMPackage.TRANSITION_BASE__DOCU:
        return getDocu();
      case FSMPackage.TRANSITION_BASE__ANNOTATIONS:
        return getAnnotations();
      case FSMPackage.TRANSITION_BASE__ACTION:
        return getAction();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION_BASE__DOCU:
        setDocu((Documentation)newValue);
        return;
      case FSMPackage.TRANSITION_BASE__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case FSMPackage.TRANSITION_BASE__ACTION:
        setAction((DetailCode)newValue);
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
      case FSMPackage.TRANSITION_BASE__DOCU:
        setDocu((Documentation)null);
        return;
      case FSMPackage.TRANSITION_BASE__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case FSMPackage.TRANSITION_BASE__ACTION:
        setAction((DetailCode)null);
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
      case FSMPackage.TRANSITION_BASE__DOCU:
        return docu != null;
      case FSMPackage.TRANSITION_BASE__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case FSMPackage.TRANSITION_BASE__ACTION:
        return action != null;
    }
    return super.eIsSet(featureID);
  }

} //TransitionBaseImpl
