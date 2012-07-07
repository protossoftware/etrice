/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.config.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.config.DynamicConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.DynamicConfigImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.DynamicConfigImpl#getFilePath <em>File Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.DynamicConfigImpl#getPolling <em>Polling</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicConfigImpl extends MinimalEObjectImpl.Container implements DynamicConfig
{
  /**
   * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected String source = SOURCE_EDEFAULT;

  /**
   * The default value of the '{@link #getFilePath() <em>File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilePath()
   * @generated
   * @ordered
   */
  protected static final String FILE_PATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFilePath() <em>File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilePath()
   * @generated
   * @ordered
   */
  protected String filePath = FILE_PATH_EDEFAULT;

  /**
   * The default value of the '{@link #getPolling() <em>Polling</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPolling()
   * @generated
   * @ordered
   */
  protected static final int POLLING_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPolling() <em>Polling</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPolling()
   * @generated
   * @ordered
   */
  protected int polling = POLLING_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DynamicConfigImpl()
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
    return ConfigPackage.Literals.DYNAMIC_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(String newSource)
  {
    String oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DYNAMIC_CONFIG__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFilePath()
  {
    return filePath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFilePath(String newFilePath)
  {
    String oldFilePath = filePath;
    filePath = newFilePath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DYNAMIC_CONFIG__FILE_PATH, oldFilePath, filePath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPolling()
  {
    return polling;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPolling(int newPolling)
  {
    int oldPolling = polling;
    polling = newPolling;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DYNAMIC_CONFIG__POLLING, oldPolling, polling));
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
      case ConfigPackage.DYNAMIC_CONFIG__SOURCE:
        return getSource();
      case ConfigPackage.DYNAMIC_CONFIG__FILE_PATH:
        return getFilePath();
      case ConfigPackage.DYNAMIC_CONFIG__POLLING:
        return getPolling();
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
      case ConfigPackage.DYNAMIC_CONFIG__SOURCE:
        setSource((String)newValue);
        return;
      case ConfigPackage.DYNAMIC_CONFIG__FILE_PATH:
        setFilePath((String)newValue);
        return;
      case ConfigPackage.DYNAMIC_CONFIG__POLLING:
        setPolling((Integer)newValue);
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
      case ConfigPackage.DYNAMIC_CONFIG__SOURCE:
        setSource(SOURCE_EDEFAULT);
        return;
      case ConfigPackage.DYNAMIC_CONFIG__FILE_PATH:
        setFilePath(FILE_PATH_EDEFAULT);
        return;
      case ConfigPackage.DYNAMIC_CONFIG__POLLING:
        setPolling(POLLING_EDEFAULT);
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
      case ConfigPackage.DYNAMIC_CONFIG__SOURCE:
        return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
      case ConfigPackage.DYNAMIC_CONFIG__FILE_PATH:
        return FILE_PATH_EDEFAULT == null ? filePath != null : !FILE_PATH_EDEFAULT.equals(filePath);
      case ConfigPackage.DYNAMIC_CONFIG__POLLING:
        return polling != POLLING_EDEFAULT;
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
    result.append(" (source: ");
    result.append(source);
    result.append(", filePath: ");
    result.append(filePath);
    result.append(", polling: ");
    result.append(polling);
    result.append(')');
    return result.toString();
  }

} //DynamicConfigImpl
