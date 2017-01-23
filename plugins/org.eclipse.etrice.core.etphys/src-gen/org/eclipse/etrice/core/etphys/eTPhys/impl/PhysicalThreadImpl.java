/**
 */
package org.eclipse.etrice.core.etphys.eTPhys.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Thread</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl#getExecmode <em>Execmode</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl#getTime <em>Time</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl#getPrio <em>Prio</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl#getStacksize <em>Stacksize</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl#getMsgblocksize <em>Msgblocksize</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalThreadImpl#getMsgpoolsize <em>Msgpoolsize</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhysicalThreadImpl extends MinimalEObjectImpl.Container implements PhysicalThread
{
  /**
   * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefault()
   * @generated
   * @ordered
   */
  protected static final boolean DEFAULT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefault()
   * @generated
   * @ordered
   */
  protected boolean default_ = DEFAULT_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getExecmode() <em>Execmode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecmode()
   * @generated
   * @ordered
   */
  protected static final ExecMode EXECMODE_EDEFAULT = ExecMode.POLLED;

  /**
   * The cached value of the '{@link #getExecmode() <em>Execmode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecmode()
   * @generated
   * @ordered
   */
  protected ExecMode execmode = EXECMODE_EDEFAULT;

  /**
   * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTime()
   * @generated
   * @ordered
   */
  protected static final long TIME_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTime()
   * @generated
   * @ordered
   */
  protected long time = TIME_EDEFAULT;

  /**
   * The default value of the '{@link #getPrio() <em>Prio</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrio()
   * @generated
   * @ordered
   */
  protected static final long PRIO_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getPrio() <em>Prio</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrio()
   * @generated
   * @ordered
   */
  protected long prio = PRIO_EDEFAULT;

  /**
   * The default value of the '{@link #getStacksize() <em>Stacksize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStacksize()
   * @generated
   * @ordered
   */
  protected static final int STACKSIZE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getStacksize() <em>Stacksize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStacksize()
   * @generated
   * @ordered
   */
  protected int stacksize = STACKSIZE_EDEFAULT;

  /**
   * The default value of the '{@link #getMsgblocksize() <em>Msgblocksize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsgblocksize()
   * @generated
   * @ordered
   */
  protected static final int MSGBLOCKSIZE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMsgblocksize() <em>Msgblocksize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsgblocksize()
   * @generated
   * @ordered
   */
  protected int msgblocksize = MSGBLOCKSIZE_EDEFAULT;

  /**
   * The default value of the '{@link #getMsgpoolsize() <em>Msgpoolsize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsgpoolsize()
   * @generated
   * @ordered
   */
  protected static final int MSGPOOLSIZE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMsgpoolsize() <em>Msgpoolsize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsgpoolsize()
   * @generated
   * @ordered
   */
  protected int msgpoolsize = MSGPOOLSIZE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PhysicalThreadImpl()
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
    return ETPhysPackage.Literals.PHYSICAL_THREAD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDefault()
  {
    return default_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefault(boolean newDefault)
  {
    boolean oldDefault = default_;
    default_ = newDefault;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_THREAD__DEFAULT, oldDefault, default_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_THREAD__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecMode getExecmode()
  {
    return execmode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExecmode(ExecMode newExecmode)
  {
    ExecMode oldExecmode = execmode;
    execmode = newExecmode == null ? EXECMODE_EDEFAULT : newExecmode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_THREAD__EXECMODE, oldExecmode, execmode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getTime()
  {
    return time;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTime(long newTime)
  {
    long oldTime = time;
    time = newTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_THREAD__TIME, oldTime, time));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getPrio()
  {
    return prio;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrio(long newPrio)
  {
    long oldPrio = prio;
    prio = newPrio;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_THREAD__PRIO, oldPrio, prio));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getStacksize()
  {
    return stacksize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStacksize(int newStacksize)
  {
    int oldStacksize = stacksize;
    stacksize = newStacksize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_THREAD__STACKSIZE, oldStacksize, stacksize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMsgblocksize()
  {
    return msgblocksize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMsgblocksize(int newMsgblocksize)
  {
    int oldMsgblocksize = msgblocksize;
    msgblocksize = newMsgblocksize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_THREAD__MSGBLOCKSIZE, oldMsgblocksize, msgblocksize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMsgpoolsize()
  {
    return msgpoolsize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMsgpoolsize(int newMsgpoolsize)
  {
    int oldMsgpoolsize = msgpoolsize;
    msgpoolsize = newMsgpoolsize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_THREAD__MSGPOOLSIZE, oldMsgpoolsize, msgpoolsize));
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
      case ETPhysPackage.PHYSICAL_THREAD__DEFAULT:
        return isDefault();
      case ETPhysPackage.PHYSICAL_THREAD__NAME:
        return getName();
      case ETPhysPackage.PHYSICAL_THREAD__EXECMODE:
        return getExecmode();
      case ETPhysPackage.PHYSICAL_THREAD__TIME:
        return getTime();
      case ETPhysPackage.PHYSICAL_THREAD__PRIO:
        return getPrio();
      case ETPhysPackage.PHYSICAL_THREAD__STACKSIZE:
        return getStacksize();
      case ETPhysPackage.PHYSICAL_THREAD__MSGBLOCKSIZE:
        return getMsgblocksize();
      case ETPhysPackage.PHYSICAL_THREAD__MSGPOOLSIZE:
        return getMsgpoolsize();
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
      case ETPhysPackage.PHYSICAL_THREAD__DEFAULT:
        setDefault((Boolean)newValue);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__NAME:
        setName((String)newValue);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__EXECMODE:
        setExecmode((ExecMode)newValue);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__TIME:
        setTime((Long)newValue);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__PRIO:
        setPrio((Long)newValue);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__STACKSIZE:
        setStacksize((Integer)newValue);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__MSGBLOCKSIZE:
        setMsgblocksize((Integer)newValue);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__MSGPOOLSIZE:
        setMsgpoolsize((Integer)newValue);
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
      case ETPhysPackage.PHYSICAL_THREAD__DEFAULT:
        setDefault(DEFAULT_EDEFAULT);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__EXECMODE:
        setExecmode(EXECMODE_EDEFAULT);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__TIME:
        setTime(TIME_EDEFAULT);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__PRIO:
        setPrio(PRIO_EDEFAULT);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__STACKSIZE:
        setStacksize(STACKSIZE_EDEFAULT);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__MSGBLOCKSIZE:
        setMsgblocksize(MSGBLOCKSIZE_EDEFAULT);
        return;
      case ETPhysPackage.PHYSICAL_THREAD__MSGPOOLSIZE:
        setMsgpoolsize(MSGPOOLSIZE_EDEFAULT);
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
      case ETPhysPackage.PHYSICAL_THREAD__DEFAULT:
        return default_ != DEFAULT_EDEFAULT;
      case ETPhysPackage.PHYSICAL_THREAD__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ETPhysPackage.PHYSICAL_THREAD__EXECMODE:
        return execmode != EXECMODE_EDEFAULT;
      case ETPhysPackage.PHYSICAL_THREAD__TIME:
        return time != TIME_EDEFAULT;
      case ETPhysPackage.PHYSICAL_THREAD__PRIO:
        return prio != PRIO_EDEFAULT;
      case ETPhysPackage.PHYSICAL_THREAD__STACKSIZE:
        return stacksize != STACKSIZE_EDEFAULT;
      case ETPhysPackage.PHYSICAL_THREAD__MSGBLOCKSIZE:
        return msgblocksize != MSGBLOCKSIZE_EDEFAULT;
      case ETPhysPackage.PHYSICAL_THREAD__MSGPOOLSIZE:
        return msgpoolsize != MSGPOOLSIZE_EDEFAULT;
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
    result.append(" (default: ");
    result.append(default_);
    result.append(", name: ");
    result.append(name);
    result.append(", execmode: ");
    result.append(execmode);
    result.append(", time: ");
    result.append(time);
    result.append(", prio: ");
    result.append(prio);
    result.append(", stacksize: ");
    result.append(stacksize);
    result.append(", msgblocksize: ");
    result.append(msgblocksize);
    result.append(", msgpoolsize: ");
    result.append(msgpoolsize);
    result.append(')');
    return result.toString();
  }

} //PhysicalThreadImpl
