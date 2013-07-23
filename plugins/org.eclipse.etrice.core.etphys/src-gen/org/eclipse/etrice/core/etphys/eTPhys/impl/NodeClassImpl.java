/**
 */
package org.eclipse.etrice.core.etphys.eTPhys.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.etphys.eTPhys.Documentation;
import org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl#getRuntime <em>Runtime</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl#getPriomin <em>Priomin</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl#getPriomax <em>Priomax</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.NodeClassImpl#getThreads <em>Threads</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeClassImpl extends MinimalEObjectImpl.Container implements NodeClass
{
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
   * The cached value of the '{@link #getDocu() <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocu()
   * @generated
   * @ordered
   */
  protected Documentation docu;

  /**
   * The cached value of the '{@link #getRuntime() <em>Runtime</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuntime()
   * @generated
   * @ordered
   */
  protected RuntimeClass runtime;

  /**
   * The default value of the '{@link #getPriomin() <em>Priomin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriomin()
   * @generated
   * @ordered
   */
  protected static final int PRIOMIN_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPriomin() <em>Priomin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriomin()
   * @generated
   * @ordered
   */
  protected int priomin = PRIOMIN_EDEFAULT;

  /**
   * The default value of the '{@link #getPriomax() <em>Priomax</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriomax()
   * @generated
   * @ordered
   */
  protected static final int PRIOMAX_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getPriomax() <em>Priomax</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriomax()
   * @generated
   * @ordered
   */
  protected int priomax = PRIOMAX_EDEFAULT;

  /**
   * The cached value of the '{@link #getThreads() <em>Threads</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThreads()
   * @generated
   * @ordered
   */
  protected EList<PhysicalThread> threads;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeClassImpl()
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
    return ETPhysPackage.Literals.NODE_CLASS;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.NODE_CLASS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Documentation getDocu()
  {
    return docu;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDocu(Documentation newDocu, NotificationChain msgs)
  {
    Documentation oldDocu = docu;
    docu = newDocu;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ETPhysPackage.NODE_CLASS__DOCU, oldDocu, newDocu);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocu(Documentation newDocu)
  {
    if (newDocu != docu)
    {
      NotificationChain msgs = null;
      if (docu != null)
        msgs = ((InternalEObject)docu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ETPhysPackage.NODE_CLASS__DOCU, null, msgs);
      if (newDocu != null)
        msgs = ((InternalEObject)newDocu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ETPhysPackage.NODE_CLASS__DOCU, null, msgs);
      msgs = basicSetDocu(newDocu, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.NODE_CLASS__DOCU, newDocu, newDocu));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuntimeClass getRuntime()
  {
    if (runtime != null && runtime.eIsProxy())
    {
      InternalEObject oldRuntime = (InternalEObject)runtime;
      runtime = (RuntimeClass)eResolveProxy(oldRuntime);
      if (runtime != oldRuntime)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETPhysPackage.NODE_CLASS__RUNTIME, oldRuntime, runtime));
      }
    }
    return runtime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuntimeClass basicGetRuntime()
  {
    return runtime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRuntime(RuntimeClass newRuntime)
  {
    RuntimeClass oldRuntime = runtime;
    runtime = newRuntime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.NODE_CLASS__RUNTIME, oldRuntime, runtime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPriomin()
  {
    return priomin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriomin(int newPriomin)
  {
    int oldPriomin = priomin;
    priomin = newPriomin;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.NODE_CLASS__PRIOMIN, oldPriomin, priomin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPriomax()
  {
    return priomax;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriomax(int newPriomax)
  {
    int oldPriomax = priomax;
    priomax = newPriomax;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.NODE_CLASS__PRIOMAX, oldPriomax, priomax));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PhysicalThread> getThreads()
  {
    if (threads == null)
    {
      threads = new EObjectContainmentEList<PhysicalThread>(PhysicalThread.class, this, ETPhysPackage.NODE_CLASS__THREADS);
    }
    return threads;
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
      case ETPhysPackage.NODE_CLASS__DOCU:
        return basicSetDocu(null, msgs);
      case ETPhysPackage.NODE_CLASS__THREADS:
        return ((InternalEList<?>)getThreads()).basicRemove(otherEnd, msgs);
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
      case ETPhysPackage.NODE_CLASS__NAME:
        return getName();
      case ETPhysPackage.NODE_CLASS__DOCU:
        return getDocu();
      case ETPhysPackage.NODE_CLASS__RUNTIME:
        if (resolve) return getRuntime();
        return basicGetRuntime();
      case ETPhysPackage.NODE_CLASS__PRIOMIN:
        return getPriomin();
      case ETPhysPackage.NODE_CLASS__PRIOMAX:
        return getPriomax();
      case ETPhysPackage.NODE_CLASS__THREADS:
        return getThreads();
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
      case ETPhysPackage.NODE_CLASS__NAME:
        setName((String)newValue);
        return;
      case ETPhysPackage.NODE_CLASS__DOCU:
        setDocu((Documentation)newValue);
        return;
      case ETPhysPackage.NODE_CLASS__RUNTIME:
        setRuntime((RuntimeClass)newValue);
        return;
      case ETPhysPackage.NODE_CLASS__PRIOMIN:
        setPriomin((Integer)newValue);
        return;
      case ETPhysPackage.NODE_CLASS__PRIOMAX:
        setPriomax((Integer)newValue);
        return;
      case ETPhysPackage.NODE_CLASS__THREADS:
        getThreads().clear();
        getThreads().addAll((Collection<? extends PhysicalThread>)newValue);
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
      case ETPhysPackage.NODE_CLASS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ETPhysPackage.NODE_CLASS__DOCU:
        setDocu((Documentation)null);
        return;
      case ETPhysPackage.NODE_CLASS__RUNTIME:
        setRuntime((RuntimeClass)null);
        return;
      case ETPhysPackage.NODE_CLASS__PRIOMIN:
        setPriomin(PRIOMIN_EDEFAULT);
        return;
      case ETPhysPackage.NODE_CLASS__PRIOMAX:
        setPriomax(PRIOMAX_EDEFAULT);
        return;
      case ETPhysPackage.NODE_CLASS__THREADS:
        getThreads().clear();
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
      case ETPhysPackage.NODE_CLASS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ETPhysPackage.NODE_CLASS__DOCU:
        return docu != null;
      case ETPhysPackage.NODE_CLASS__RUNTIME:
        return runtime != null;
      case ETPhysPackage.NODE_CLASS__PRIOMIN:
        return priomin != PRIOMIN_EDEFAULT;
      case ETPhysPackage.NODE_CLASS__PRIOMAX:
        return priomax != PRIOMAX_EDEFAULT;
      case ETPhysPackage.NODE_CLASS__THREADS:
        return threads != null && !threads.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", priomin: ");
    result.append(priomin);
    result.append(", priomax: ");
    result.append(priomax);
    result.append(')');
    return result.toString();
  }

} //NodeClassImpl
