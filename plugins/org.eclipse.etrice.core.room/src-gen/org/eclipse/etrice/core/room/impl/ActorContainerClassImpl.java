/**
 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SPPRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Container Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorContainerClassImpl#getIfSPPs <em>If SP Ps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorContainerClassImpl#getUserCode1 <em>User Code1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorContainerClassImpl#getUserCode2 <em>User Code2</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorContainerClassImpl#getUserCode3 <em>User Code3</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorContainerClassImpl#getActorRefs <em>Actor Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorContainerClassImpl extends StructureClassImpl implements ActorContainerClass
{
  /**
   * The cached value of the '{@link #getIfSPPs() <em>If SP Ps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfSPPs()
   * @generated
   * @ordered
   */
  protected EList<SPPRef> ifSPPs;

  /**
   * The cached value of the '{@link #getUserCode1() <em>User Code1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode1()
   * @generated
   * @ordered
   */
  protected DetailCode userCode1;

  /**
   * The cached value of the '{@link #getUserCode2() <em>User Code2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode2()
   * @generated
   * @ordered
   */
  protected DetailCode userCode2;

  /**
   * The cached value of the '{@link #getUserCode3() <em>User Code3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode3()
   * @generated
   * @ordered
   */
  protected DetailCode userCode3;

  /**
   * The cached value of the '{@link #getActorRefs() <em>Actor Refs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActorRefs()
   * @generated
   * @ordered
   */
  protected EList<ActorRef> actorRefs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActorContainerClassImpl()
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
    return RoomPackage.Literals.ACTOR_CONTAINER_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SPPRef> getIfSPPs()
  {
    if (ifSPPs == null)
    {
      ifSPPs = new EObjectContainmentEList<SPPRef>(SPPRef.class, this, RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS);
    }
    return ifSPPs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetailCode getUserCode1()
  {
    return userCode1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUserCode1(DetailCode newUserCode1, NotificationChain msgs)
  {
    DetailCode oldUserCode1 = userCode1;
    userCode1 = newUserCode1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE1, oldUserCode1, newUserCode1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserCode1(DetailCode newUserCode1)
  {
    if (newUserCode1 != userCode1)
    {
      NotificationChain msgs = null;
      if (userCode1 != null)
        msgs = ((InternalEObject)userCode1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE1, null, msgs);
      if (newUserCode1 != null)
        msgs = ((InternalEObject)newUserCode1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE1, null, msgs);
      msgs = basicSetUserCode1(newUserCode1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE1, newUserCode1, newUserCode1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetailCode getUserCode2()
  {
    return userCode2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUserCode2(DetailCode newUserCode2, NotificationChain msgs)
  {
    DetailCode oldUserCode2 = userCode2;
    userCode2 = newUserCode2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE2, oldUserCode2, newUserCode2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserCode2(DetailCode newUserCode2)
  {
    if (newUserCode2 != userCode2)
    {
      NotificationChain msgs = null;
      if (userCode2 != null)
        msgs = ((InternalEObject)userCode2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE2, null, msgs);
      if (newUserCode2 != null)
        msgs = ((InternalEObject)newUserCode2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE2, null, msgs);
      msgs = basicSetUserCode2(newUserCode2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE2, newUserCode2, newUserCode2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetailCode getUserCode3()
  {
    return userCode3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUserCode3(DetailCode newUserCode3, NotificationChain msgs)
  {
    DetailCode oldUserCode3 = userCode3;
    userCode3 = newUserCode3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE3, oldUserCode3, newUserCode3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserCode3(DetailCode newUserCode3)
  {
    if (newUserCode3 != userCode3)
    {
      NotificationChain msgs = null;
      if (userCode3 != null)
        msgs = ((InternalEObject)userCode3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE3, null, msgs);
      if (newUserCode3 != null)
        msgs = ((InternalEObject)newUserCode3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE3, null, msgs);
      msgs = basicSetUserCode3(newUserCode3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE3, newUserCode3, newUserCode3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActorRef> getActorRefs()
  {
    if (actorRefs == null)
    {
      actorRefs = new EObjectContainmentEList<ActorRef>(ActorRef.class, this, RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS);
    }
    return actorRefs;
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
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        return ((InternalEList<?>)getIfSPPs()).basicRemove(otherEnd, msgs);
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE1:
        return basicSetUserCode1(null, msgs);
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE2:
        return basicSetUserCode2(null, msgs);
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE3:
        return basicSetUserCode3(null, msgs);
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        return ((InternalEList<?>)getActorRefs()).basicRemove(otherEnd, msgs);
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
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        return getIfSPPs();
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE1:
        return getUserCode1();
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE2:
        return getUserCode2();
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE3:
        return getUserCode3();
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        return getActorRefs();
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
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        getIfSPPs().clear();
        getIfSPPs().addAll((Collection<? extends SPPRef>)newValue);
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE1:
        setUserCode1((DetailCode)newValue);
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE2:
        setUserCode2((DetailCode)newValue);
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE3:
        setUserCode3((DetailCode)newValue);
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        getActorRefs().clear();
        getActorRefs().addAll((Collection<? extends ActorRef>)newValue);
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
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        getIfSPPs().clear();
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE1:
        setUserCode1((DetailCode)null);
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE2:
        setUserCode2((DetailCode)null);
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE3:
        setUserCode3((DetailCode)null);
        return;
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        getActorRefs().clear();
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
      case RoomPackage.ACTOR_CONTAINER_CLASS__IF_SP_PS:
        return ifSPPs != null && !ifSPPs.isEmpty();
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE1:
        return userCode1 != null;
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE2:
        return userCode2 != null;
      case RoomPackage.ACTOR_CONTAINER_CLASS__USER_CODE3:
        return userCode3 != null;
      case RoomPackage.ACTOR_CONTAINER_CLASS__ACTOR_REFS:
        return actorRefs != null && !actorRefs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ActorContainerClassImpl
