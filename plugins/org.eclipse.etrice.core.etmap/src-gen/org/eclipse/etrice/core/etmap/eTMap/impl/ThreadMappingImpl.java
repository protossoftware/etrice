/**
 */
package org.eclipse.etrice.core.etmap.eTMap.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.etmap.eTMap.ETMapPackage;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;

import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;

import org.eclipse.etrice.core.room.LogicalThread;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thread Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.impl.ThreadMappingImpl#getLogicalThread <em>Logical Thread</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.impl.ThreadMappingImpl#getPhysicalThread <em>Physical Thread</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThreadMappingImpl extends MinimalEObjectImpl.Container implements ThreadMapping
{
  /**
   * The cached value of the '{@link #getLogicalThread() <em>Logical Thread</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogicalThread()
   * @generated
   * @ordered
   */
  protected LogicalThread logicalThread;

  /**
   * The cached value of the '{@link #getPhysicalThread() <em>Physical Thread</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhysicalThread()
   * @generated
   * @ordered
   */
  protected PhysicalThread physicalThread;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ThreadMappingImpl()
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
    return ETMapPackage.Literals.THREAD_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalThread getLogicalThread()
  {
    if (logicalThread != null && logicalThread.eIsProxy())
    {
      InternalEObject oldLogicalThread = (InternalEObject)logicalThread;
      logicalThread = (LogicalThread)eResolveProxy(oldLogicalThread);
      if (logicalThread != oldLogicalThread)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETMapPackage.THREAD_MAPPING__LOGICAL_THREAD, oldLogicalThread, logicalThread));
      }
    }
    return logicalThread;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalThread basicGetLogicalThread()
  {
    return logicalThread;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLogicalThread(LogicalThread newLogicalThread)
  {
    LogicalThread oldLogicalThread = logicalThread;
    logicalThread = newLogicalThread;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETMapPackage.THREAD_MAPPING__LOGICAL_THREAD, oldLogicalThread, logicalThread));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhysicalThread getPhysicalThread()
  {
    if (physicalThread != null && physicalThread.eIsProxy())
    {
      InternalEObject oldPhysicalThread = (InternalEObject)physicalThread;
      physicalThread = (PhysicalThread)eResolveProxy(oldPhysicalThread);
      if (physicalThread != oldPhysicalThread)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETMapPackage.THREAD_MAPPING__PHYSICAL_THREAD, oldPhysicalThread, physicalThread));
      }
    }
    return physicalThread;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhysicalThread basicGetPhysicalThread()
  {
    return physicalThread;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPhysicalThread(PhysicalThread newPhysicalThread)
  {
    PhysicalThread oldPhysicalThread = physicalThread;
    physicalThread = newPhysicalThread;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETMapPackage.THREAD_MAPPING__PHYSICAL_THREAD, oldPhysicalThread, physicalThread));
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
      case ETMapPackage.THREAD_MAPPING__LOGICAL_THREAD:
        if (resolve) return getLogicalThread();
        return basicGetLogicalThread();
      case ETMapPackage.THREAD_MAPPING__PHYSICAL_THREAD:
        if (resolve) return getPhysicalThread();
        return basicGetPhysicalThread();
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
      case ETMapPackage.THREAD_MAPPING__LOGICAL_THREAD:
        setLogicalThread((LogicalThread)newValue);
        return;
      case ETMapPackage.THREAD_MAPPING__PHYSICAL_THREAD:
        setPhysicalThread((PhysicalThread)newValue);
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
      case ETMapPackage.THREAD_MAPPING__LOGICAL_THREAD:
        setLogicalThread((LogicalThread)null);
        return;
      case ETMapPackage.THREAD_MAPPING__PHYSICAL_THREAD:
        setPhysicalThread((PhysicalThread)null);
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
      case ETMapPackage.THREAD_MAPPING__LOGICAL_THREAD:
        return logicalThread != null;
      case ETMapPackage.THREAD_MAPPING__PHYSICAL_THREAD:
        return physicalThread != null;
    }
    return super.eIsSet(featureID);
  }

} //ThreadMappingImpl
