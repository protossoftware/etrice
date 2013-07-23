/**
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
 *   <li>{@link org.eclipse.etrice.core.config.impl.DynamicConfigImpl#getFilePath <em>File Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.DynamicConfigImpl#getUserCode1 <em>User Code1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.DynamicConfigImpl#getUserCode2 <em>User Code2</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.DynamicConfigImpl#getPolling <em>Polling</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicConfigImpl extends MinimalEObjectImpl.Container implements DynamicConfig
{
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
   * The default value of the '{@link #getUserCode1() <em>User Code1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode1()
   * @generated
   * @ordered
   */
  protected static final String USER_CODE1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUserCode1() <em>User Code1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode1()
   * @generated
   * @ordered
   */
  protected String userCode1 = USER_CODE1_EDEFAULT;

  /**
   * The default value of the '{@link #getUserCode2() <em>User Code2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode2()
   * @generated
   * @ordered
   */
  protected static final String USER_CODE2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUserCode2() <em>User Code2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode2()
   * @generated
   * @ordered
   */
  protected String userCode2 = USER_CODE2_EDEFAULT;

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
  public String getUserCode1()
  {
    return userCode1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserCode1(String newUserCode1)
  {
    String oldUserCode1 = userCode1;
    userCode1 = newUserCode1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DYNAMIC_CONFIG__USER_CODE1, oldUserCode1, userCode1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUserCode2()
  {
    return userCode2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserCode2(String newUserCode2)
  {
    String oldUserCode2 = userCode2;
    userCode2 = newUserCode2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.DYNAMIC_CONFIG__USER_CODE2, oldUserCode2, userCode2));
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
      case ConfigPackage.DYNAMIC_CONFIG__FILE_PATH:
        return getFilePath();
      case ConfigPackage.DYNAMIC_CONFIG__USER_CODE1:
        return getUserCode1();
      case ConfigPackage.DYNAMIC_CONFIG__USER_CODE2:
        return getUserCode2();
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
      case ConfigPackage.DYNAMIC_CONFIG__FILE_PATH:
        setFilePath((String)newValue);
        return;
      case ConfigPackage.DYNAMIC_CONFIG__USER_CODE1:
        setUserCode1((String)newValue);
        return;
      case ConfigPackage.DYNAMIC_CONFIG__USER_CODE2:
        setUserCode2((String)newValue);
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
      case ConfigPackage.DYNAMIC_CONFIG__FILE_PATH:
        setFilePath(FILE_PATH_EDEFAULT);
        return;
      case ConfigPackage.DYNAMIC_CONFIG__USER_CODE1:
        setUserCode1(USER_CODE1_EDEFAULT);
        return;
      case ConfigPackage.DYNAMIC_CONFIG__USER_CODE2:
        setUserCode2(USER_CODE2_EDEFAULT);
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
      case ConfigPackage.DYNAMIC_CONFIG__FILE_PATH:
        return FILE_PATH_EDEFAULT == null ? filePath != null : !FILE_PATH_EDEFAULT.equals(filePath);
      case ConfigPackage.DYNAMIC_CONFIG__USER_CODE1:
        return USER_CODE1_EDEFAULT == null ? userCode1 != null : !USER_CODE1_EDEFAULT.equals(userCode1);
      case ConfigPackage.DYNAMIC_CONFIG__USER_CODE2:
        return USER_CODE2_EDEFAULT == null ? userCode2 != null : !USER_CODE2_EDEFAULT.equals(userCode2);
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
    result.append(" (filePath: ");
    result.append(filePath);
    result.append(", userCode1: ");
    result.append(userCode1);
    result.append(", userCode2: ");
    result.append(userCode2);
    result.append(", polling: ");
    result.append(polling);
    result.append(')');
    return result.toString();
  }

} //DynamicConfigImpl
