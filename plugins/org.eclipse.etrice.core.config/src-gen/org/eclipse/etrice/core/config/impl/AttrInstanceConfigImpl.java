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

import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.ConfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attr Instance Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.AttrInstanceConfigImpl#isDynConfig <em>Dyn Config</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.AttrInstanceConfigImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.AttrInstanceConfigImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttrInstanceConfigImpl extends AttrConfigImpl implements AttrInstanceConfig
{
  /**
   * The default value of the '{@link #isDynConfig() <em>Dyn Config</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynConfig()
   * @generated
   * @ordered
   */
  protected static final boolean DYN_CONFIG_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDynConfig() <em>Dyn Config</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynConfig()
   * @generated
   * @ordered
   */
  protected boolean dynConfig = DYN_CONFIG_EDEFAULT;

  /**
   * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnly()
   * @generated
   * @ordered
   */
  protected static final boolean READ_ONLY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnly()
   * @generated
   * @ordered
   */
  protected boolean readOnly = READ_ONLY_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<AttrInstanceConfig> attributes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttrInstanceConfigImpl()
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
    return ConfigPackage.Literals.ATTR_INSTANCE_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDynConfig()
  {
    return dynConfig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDynConfig(boolean newDynConfig)
  {
    boolean oldDynConfig = dynConfig;
    dynConfig = newDynConfig;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ATTR_INSTANCE_CONFIG__DYN_CONFIG, oldDynConfig, dynConfig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isReadOnly()
  {
    return readOnly;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReadOnly(boolean newReadOnly)
  {
    boolean oldReadOnly = readOnly;
    readOnly = newReadOnly;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ATTR_INSTANCE_CONFIG__READ_ONLY, oldReadOnly, readOnly));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AttrInstanceConfig> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<AttrInstanceConfig>(AttrInstanceConfig.class, this, ConfigPackage.ATTR_INSTANCE_CONFIG__ATTRIBUTES);
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
      case ConfigPackage.ATTR_INSTANCE_CONFIG__ATTRIBUTES:
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
      case ConfigPackage.ATTR_INSTANCE_CONFIG__DYN_CONFIG:
        return isDynConfig();
      case ConfigPackage.ATTR_INSTANCE_CONFIG__READ_ONLY:
        return isReadOnly();
      case ConfigPackage.ATTR_INSTANCE_CONFIG__ATTRIBUTES:
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
      case ConfigPackage.ATTR_INSTANCE_CONFIG__DYN_CONFIG:
        setDynConfig((Boolean)newValue);
        return;
      case ConfigPackage.ATTR_INSTANCE_CONFIG__READ_ONLY:
        setReadOnly((Boolean)newValue);
        return;
      case ConfigPackage.ATTR_INSTANCE_CONFIG__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends AttrInstanceConfig>)newValue);
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
      case ConfigPackage.ATTR_INSTANCE_CONFIG__DYN_CONFIG:
        setDynConfig(DYN_CONFIG_EDEFAULT);
        return;
      case ConfigPackage.ATTR_INSTANCE_CONFIG__READ_ONLY:
        setReadOnly(READ_ONLY_EDEFAULT);
        return;
      case ConfigPackage.ATTR_INSTANCE_CONFIG__ATTRIBUTES:
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
      case ConfigPackage.ATTR_INSTANCE_CONFIG__DYN_CONFIG:
        return dynConfig != DYN_CONFIG_EDEFAULT;
      case ConfigPackage.ATTR_INSTANCE_CONFIG__READ_ONLY:
        return readOnly != READ_ONLY_EDEFAULT;
      case ConfigPackage.ATTR_INSTANCE_CONFIG__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
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
    result.append(" (dynConfig: ");
    result.append(dynConfig);
    result.append(", readOnly: ");
    result.append(readOnly);
    result.append(')');
    return result.toString();
  }

} //AttrInstanceConfigImpl
