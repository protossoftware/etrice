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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.ConfigElement;
import org.eclipse.etrice.core.config.ConfigModel;
import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.config.Import;
import org.eclipse.etrice.core.config.ProtocolClassConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ConfigModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.ConfigModelImpl#getConfigElements <em>Config Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigModelImpl extends MinimalEObjectImpl.Container implements ConfigModel
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getConfigElements() <em>Config Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfigElements()
   * @generated
   * @ordered
   */
  protected EList<ConfigElement> configElements;

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
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, ConfigPackage.CONFIG_MODEL__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConfigElement> getConfigElements()
  {
    if (configElements == null)
    {
      configElements = new EObjectContainmentEList<ConfigElement>(ConfigElement.class, this, ConfigPackage.CONFIG_MODEL__CONFIG_ELEMENTS);
    }
    return configElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActorClassConfig> getActorClassConfigs()
  {
    EList<ActorClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorClassConfig>();
             			for(ConfigElement element : this.getConfigElements())
             				if(element instanceof ActorClassConfig)
             					list.add((ActorClassConfig) element);
             		 return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActorInstanceConfig> getActorInstanceConfigs()
  {
    EList<ActorInstanceConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorInstanceConfig>();
            for(ConfigElement element : this.getConfigElements())
           		if(element instanceof ActorInstanceConfig)
                list.add((ActorInstanceConfig) element);
            return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ProtocolClassConfig> getProtocolClassConfigs()
  {
    EList<ProtocolClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ProtocolClassConfig>();
            for(ConfigElement element : this.getConfigElements())
           		if(element instanceof ProtocolClassConfig)
                list.add((ProtocolClassConfig) element);
            return list;
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
      case ConfigPackage.CONFIG_MODEL__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case ConfigPackage.CONFIG_MODEL__CONFIG_ELEMENTS:
        return ((InternalEList<?>)getConfigElements()).basicRemove(otherEnd, msgs);
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
      case ConfigPackage.CONFIG_MODEL__IMPORTS:
        return getImports();
      case ConfigPackage.CONFIG_MODEL__CONFIG_ELEMENTS:
        return getConfigElements();
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
      case ConfigPackage.CONFIG_MODEL__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case ConfigPackage.CONFIG_MODEL__CONFIG_ELEMENTS:
        getConfigElements().clear();
        getConfigElements().addAll((Collection<? extends ConfigElement>)newValue);
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
      case ConfigPackage.CONFIG_MODEL__IMPORTS:
        getImports().clear();
        return;
      case ConfigPackage.CONFIG_MODEL__CONFIG_ELEMENTS:
        getConfigElements().clear();
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
      case ConfigPackage.CONFIG_MODEL__IMPORTS:
        return imports != null && !imports.isEmpty();
      case ConfigPackage.CONFIG_MODEL__CONFIG_ELEMENTS:
        return configElements != null && !configElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConfigModelImpl
