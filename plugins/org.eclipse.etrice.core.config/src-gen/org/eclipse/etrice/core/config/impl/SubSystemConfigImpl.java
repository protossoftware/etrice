/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.config.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.config.DynamicConfig;
import org.eclipse.etrice.core.config.SubSystemConfig;

import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.SubSystemConfigImpl#getSubSystem <em>Sub System</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.SubSystemConfigImpl#getDynConfig <em>Dyn Config</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemConfigImpl extends ConfigElementImpl implements SubSystemConfig
{
  /**
   * The cached value of the '{@link #getSubSystem() <em>Sub System</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubSystem()
   * @generated
   * @ordered
   */
  protected SubSystemClass subSystem;

  /**
   * The cached value of the '{@link #getDynConfig() <em>Dyn Config</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDynConfig()
   * @generated
   * @ordered
   */
  protected DynamicConfig dynConfig;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubSystemConfigImpl()
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
    return ConfigPackage.Literals.SUB_SYSTEM_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubSystemClass getSubSystem()
  {
    if (subSystem != null && subSystem.eIsProxy())
    {
      InternalEObject oldSubSystem = (InternalEObject)subSystem;
      subSystem = (SubSystemClass)eResolveProxy(oldSubSystem);
      if (subSystem != oldSubSystem)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigPackage.SUB_SYSTEM_CONFIG__SUB_SYSTEM, oldSubSystem, subSystem));
      }
    }
    return subSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubSystemClass basicGetSubSystem()
  {
    return subSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubSystem(SubSystemClass newSubSystem)
  {
    SubSystemClass oldSubSystem = subSystem;
    subSystem = newSubSystem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SUB_SYSTEM_CONFIG__SUB_SYSTEM, oldSubSystem, subSystem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicConfig getDynConfig()
  {
    return dynConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDynConfig(DynamicConfig newDynConfig, NotificationChain msgs)
  {
    DynamicConfig oldDynConfig = dynConfig;
    dynConfig = newDynConfig;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.SUB_SYSTEM_CONFIG__DYN_CONFIG, oldDynConfig, newDynConfig);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDynConfig(DynamicConfig newDynConfig)
  {
    if (newDynConfig != dynConfig)
    {
      NotificationChain msgs = null;
      if (dynConfig != null)
        msgs = ((InternalEObject)dynConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.SUB_SYSTEM_CONFIG__DYN_CONFIG, null, msgs);
      if (newDynConfig != null)
        msgs = ((InternalEObject)newDynConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.SUB_SYSTEM_CONFIG__DYN_CONFIG, null, msgs);
      msgs = basicSetDynConfig(newDynConfig, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.SUB_SYSTEM_CONFIG__DYN_CONFIG, newDynConfig, newDynConfig));
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
      case ConfigPackage.SUB_SYSTEM_CONFIG__DYN_CONFIG:
        return basicSetDynConfig(null, msgs);
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
      case ConfigPackage.SUB_SYSTEM_CONFIG__SUB_SYSTEM:
        if (resolve) return getSubSystem();
        return basicGetSubSystem();
      case ConfigPackage.SUB_SYSTEM_CONFIG__DYN_CONFIG:
        return getDynConfig();
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
      case ConfigPackage.SUB_SYSTEM_CONFIG__SUB_SYSTEM:
        setSubSystem((SubSystemClass)newValue);
        return;
      case ConfigPackage.SUB_SYSTEM_CONFIG__DYN_CONFIG:
        setDynConfig((DynamicConfig)newValue);
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
      case ConfigPackage.SUB_SYSTEM_CONFIG__SUB_SYSTEM:
        setSubSystem((SubSystemClass)null);
        return;
      case ConfigPackage.SUB_SYSTEM_CONFIG__DYN_CONFIG:
        setDynConfig((DynamicConfig)null);
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
      case ConfigPackage.SUB_SYSTEM_CONFIG__SUB_SYSTEM:
        return subSystem != null;
      case ConfigPackage.SUB_SYSTEM_CONFIG__DYN_CONFIG:
        return dynConfig != null;
    }
    return super.eIsSet(featureID);
  }

} //SubSystemConfigImpl
