/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.config.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ConfigModel;
import org.eclipse.etrice.core.config.ConfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ConfigModelImpl#getActorClassConfigs <em>Actor Class Configs</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ConfigModelImpl#getActorInstanceConfigs <em>Actor Instance Configs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigModelImpl extends MinimalEObjectImpl.Container implements ConfigModel
{
  /**
   * The cached value of the '{@link #getActorClassConfigs() <em>Actor Class Configs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActorClassConfigs()
   * @generated
   * @ordered
   */
  protected EList<ActorClassConfig> actorClassConfigs;

  /**
   * The cached value of the '{@link #getActorInstanceConfigs() <em>Actor Instance Configs</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActorInstanceConfigs()
   * @generated
   * @ordered
   */
  protected EList<String> actorInstanceConfigs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConfigModelImpl()
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
    return ConfigPackage.Literals.CONFIG_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActorClassConfig> getActorClassConfigs()
  {
    if (actorClassConfigs == null)
    {
      actorClassConfigs = new EObjectContainmentEList<ActorClassConfig>(ActorClassConfig.class, this, ConfigPackage.CONFIG_MODEL__ACTOR_CLASS_CONFIGS);
    }
    return actorClassConfigs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getActorInstanceConfigs()
  {
    if (actorInstanceConfigs == null)
    {
      actorInstanceConfigs = new EDataTypeEList<String>(String.class, this, ConfigPackage.CONFIG_MODEL__ACTOR_INSTANCE_CONFIGS);
    }
    return actorInstanceConfigs;
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
      case ConfigPackage.CONFIG_MODEL__ACTOR_CLASS_CONFIGS:
        return ((InternalEList<?>)getActorClassConfigs()).basicRemove(otherEnd, msgs);
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
      case ConfigPackage.CONFIG_MODEL__ACTOR_CLASS_CONFIGS:
        return getActorClassConfigs();
      case ConfigPackage.CONFIG_MODEL__ACTOR_INSTANCE_CONFIGS:
        return getActorInstanceConfigs();
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
      case ConfigPackage.CONFIG_MODEL__ACTOR_CLASS_CONFIGS:
        getActorClassConfigs().clear();
        getActorClassConfigs().addAll((Collection<? extends ActorClassConfig>)newValue);
        return;
      case ConfigPackage.CONFIG_MODEL__ACTOR_INSTANCE_CONFIGS:
        getActorInstanceConfigs().clear();
        getActorInstanceConfigs().addAll((Collection<? extends String>)newValue);
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
      case ConfigPackage.CONFIG_MODEL__ACTOR_CLASS_CONFIGS:
        getActorClassConfigs().clear();
        return;
      case ConfigPackage.CONFIG_MODEL__ACTOR_INSTANCE_CONFIGS:
        getActorInstanceConfigs().clear();
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
      case ConfigPackage.CONFIG_MODEL__ACTOR_CLASS_CONFIGS:
        return actorClassConfigs != null && !actorClassConfigs.isEmpty();
      case ConfigPackage.CONFIG_MODEL__ACTOR_INSTANCE_CONFIGS:
        return actorInstanceConfigs != null && !actorInstanceConfigs.isEmpty();
    }
    return super.eIsSet(featureID);
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
    result.append(" (actorInstanceConfigs: ");
    result.append(actorInstanceConfigs);
    result.append(')');
    return result.toString();
  }

} //ConfigModelImpl
