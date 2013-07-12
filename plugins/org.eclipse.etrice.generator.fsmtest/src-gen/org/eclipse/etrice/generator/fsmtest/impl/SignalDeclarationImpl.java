/**
 */
package org.eclipse.etrice.generator.fsmtest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.generator.fsmtest.FsmtestPackage;
import org.eclipse.etrice.generator.fsmtest.SignalDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.SignalDeclarationImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.SignalDeclarationImpl#getSigname <em>Signame</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.SignalDeclarationImpl#getIntVal <em>Int Val</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.impl.SignalDeclarationImpl#getStrVal <em>Str Val</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignalDeclarationImpl extends MinimalEObjectImpl.Container implements SignalDeclaration
{
  /**
   * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPort()
   * @generated
   * @ordered
   */
  protected static final String PORT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPort()
   * @generated
   * @ordered
   */
  protected String port = PORT_EDEFAULT;

  /**
   * The default value of the '{@link #getSigname() <em>Signame</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSigname()
   * @generated
   * @ordered
   */
  protected static final String SIGNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSigname() <em>Signame</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSigname()
   * @generated
   * @ordered
   */
  protected String signame = SIGNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getIntVal() <em>Int Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntVal()
   * @generated
   * @ordered
   */
  protected static final int INT_VAL_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getIntVal() <em>Int Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntVal()
   * @generated
   * @ordered
   */
  protected int intVal = INT_VAL_EDEFAULT;

  /**
   * The default value of the '{@link #getStrVal() <em>Str Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrVal()
   * @generated
   * @ordered
   */
  protected static final String STR_VAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStrVal() <em>Str Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrVal()
   * @generated
   * @ordered
   */
  protected String strVal = STR_VAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SignalDeclarationImpl()
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
    return FsmtestPackage.Literals.SIGNAL_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPort()
  {
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPort(String newPort)
  {
    String oldPort = port;
    port = newPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.SIGNAL_DECLARATION__PORT, oldPort, port));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSigname()
  {
    return signame;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSigname(String newSigname)
  {
    String oldSigname = signame;
    signame = newSigname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.SIGNAL_DECLARATION__SIGNAME, oldSigname, signame));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getIntVal()
  {
    return intVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntVal(int newIntVal)
  {
    int oldIntVal = intVal;
    intVal = newIntVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.SIGNAL_DECLARATION__INT_VAL, oldIntVal, intVal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStrVal()
  {
    return strVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStrVal(String newStrVal)
  {
    String oldStrVal = strVal;
    strVal = newStrVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FsmtestPackage.SIGNAL_DECLARATION__STR_VAL, oldStrVal, strVal));
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
      case FsmtestPackage.SIGNAL_DECLARATION__PORT:
        return getPort();
      case FsmtestPackage.SIGNAL_DECLARATION__SIGNAME:
        return getSigname();
      case FsmtestPackage.SIGNAL_DECLARATION__INT_VAL:
        return getIntVal();
      case FsmtestPackage.SIGNAL_DECLARATION__STR_VAL:
        return getStrVal();
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
      case FsmtestPackage.SIGNAL_DECLARATION__PORT:
        setPort((String)newValue);
        return;
      case FsmtestPackage.SIGNAL_DECLARATION__SIGNAME:
        setSigname((String)newValue);
        return;
      case FsmtestPackage.SIGNAL_DECLARATION__INT_VAL:
        setIntVal((Integer)newValue);
        return;
      case FsmtestPackage.SIGNAL_DECLARATION__STR_VAL:
        setStrVal((String)newValue);
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
      case FsmtestPackage.SIGNAL_DECLARATION__PORT:
        setPort(PORT_EDEFAULT);
        return;
      case FsmtestPackage.SIGNAL_DECLARATION__SIGNAME:
        setSigname(SIGNAME_EDEFAULT);
        return;
      case FsmtestPackage.SIGNAL_DECLARATION__INT_VAL:
        setIntVal(INT_VAL_EDEFAULT);
        return;
      case FsmtestPackage.SIGNAL_DECLARATION__STR_VAL:
        setStrVal(STR_VAL_EDEFAULT);
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
      case FsmtestPackage.SIGNAL_DECLARATION__PORT:
        return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
      case FsmtestPackage.SIGNAL_DECLARATION__SIGNAME:
        return SIGNAME_EDEFAULT == null ? signame != null : !SIGNAME_EDEFAULT.equals(signame);
      case FsmtestPackage.SIGNAL_DECLARATION__INT_VAL:
        return intVal != INT_VAL_EDEFAULT;
      case FsmtestPackage.SIGNAL_DECLARATION__STR_VAL:
        return STR_VAL_EDEFAULT == null ? strVal != null : !STR_VAL_EDEFAULT.equals(strVal);
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
    result.append(" (port: ");
    result.append(port);
    result.append(", signame: ");
    result.append(signame);
    result.append(", intVal: ");
    result.append(intVal);
    result.append(", strVal: ");
    result.append(strVal);
    result.append(')');
    return result.toString();
  }

} //SignalDeclarationImpl
