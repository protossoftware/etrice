/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.config.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ConfigPackage;

import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Class Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ActorClassConfigImpl#getActorClass <em>Actor Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorClassConfigImpl extends MinimalEObjectImpl.Container implements ActorClassConfig
{
  /**
   * The cached value of the '{@link #getActorClass() <em>Actor Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActorClass()
   * @generated
   * @ordered
   */
  protected ActorClass actorClass;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActorClassConfigImpl()
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
    return ConfigPackage.Literals.ACTOR_CLASS_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorClass getActorClass()
  {
    if (actorClass != null && actorClass.eIsProxy())
    {
      InternalEObject oldActorClass = (InternalEObject)actorClass;
      actorClass = (ActorClass)eResolveProxy(oldActorClass);
      if (actorClass != oldActorClass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR_CLASS, oldActorClass, actorClass));
      }
    }
    return actorClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorClass basicGetActorClass()
  {
    return actorClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActorClass(ActorClass newActorClass)
  {
    ActorClass oldActorClass = actorClass;
    actorClass = newActorClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR_CLASS, oldActorClass, actorClass));
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
      case ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR_CLASS:
        if (resolve) return getActorClass();
        return basicGetActorClass();
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
      case ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR_CLASS:
        setActorClass((ActorClass)newValue);
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
      case ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR_CLASS:
        setActorClass((ActorClass)null);
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
      case ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR_CLASS:
        return actorClass != null;
    }
    return super.eIsSet(featureID);
  }

} //ActorClassConfigImpl
