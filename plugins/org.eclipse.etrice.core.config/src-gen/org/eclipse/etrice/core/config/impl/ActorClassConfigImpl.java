/**
 */
package org.eclipse.etrice.core.config.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.ConfigPackage;

import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Class Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ActorClassConfigImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ActorClassConfigImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorClassConfigImpl extends ConfigElementImpl implements ActorClassConfig
{
  /**
   * The cached value of the '{@link #getActor() <em>Actor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActor()
   * @generated
   * @ordered
   */
  protected ActorClass actor;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<AttrClassConfig> attributes;

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
  public ActorClass getActor()
  {
    if (actor != null && actor.eIsProxy())
    {
      InternalEObject oldActor = (InternalEObject)actor;
      actor = (ActorClass)eResolveProxy(oldActor);
      if (actor != oldActor)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR, oldActor, actor));
      }
    }
    return actor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorClass basicGetActor()
  {
    return actor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActor(ActorClass newActor)
  {
    ActorClass oldActor = actor;
    actor = newActor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR, oldActor, actor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AttrClassConfig> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<AttrClassConfig>(AttrClassConfig.class, this, ConfigPackage.ACTOR_CLASS_CONFIG__ATTRIBUTES);
    }
    return attributes;
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
      case ConfigPackage.ACTOR_CLASS_CONFIG__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
      case ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR:
        if (resolve) return getActor();
        return basicGetActor();
      case ConfigPackage.ACTOR_CLASS_CONFIG__ATTRIBUTES:
        return getAttributes();
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
      case ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR:
        setActor((ActorClass)newValue);
        return;
      case ConfigPackage.ACTOR_CLASS_CONFIG__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends AttrClassConfig>)newValue);
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
      case ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR:
        setActor((ActorClass)null);
        return;
      case ConfigPackage.ACTOR_CLASS_CONFIG__ATTRIBUTES:
        getAttributes().clear();
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
      case ConfigPackage.ACTOR_CLASS_CONFIG__ACTOR:
        return actor != null;
      case ConfigPackage.ACTOR_CLASS_CONFIG__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ActorClassConfigImpl
