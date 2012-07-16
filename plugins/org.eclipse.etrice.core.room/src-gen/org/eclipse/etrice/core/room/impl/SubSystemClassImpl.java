/**
 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.SubSystemClassImpl#getRelayPorts <em>Relay Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.SubSystemClassImpl#getThreads <em>Threads</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemClassImpl extends ActorContainerClassImpl implements SubSystemClass
{
  /**
   * The cached value of the '{@link #getRelayPorts() <em>Relay Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelayPorts()
   * @generated
   * @ordered
   */
  protected EList<Port> relayPorts;

  /**
   * The cached value of the '{@link #getThreads() <em>Threads</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThreads()
   * @generated
   * @ordered
   */
  protected EList<LogicalThread> threads;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubSystemClassImpl()
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
    return RoomPackage.Literals.SUB_SYSTEM_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Port> getRelayPorts()
  {
    if (relayPorts == null)
    {
      relayPorts = new EObjectContainmentEList<Port>(Port.class, this, RoomPackage.SUB_SYSTEM_CLASS__RELAY_PORTS);
    }
    return relayPorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LogicalThread> getThreads()
  {
    if (threads == null)
    {
      threads = new EObjectContainmentEList<LogicalThread>(LogicalThread.class, this, RoomPackage.SUB_SYSTEM_CLASS__THREADS);
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
      case RoomPackage.SUB_SYSTEM_CLASS__RELAY_PORTS:
        return ((InternalEList<?>)getRelayPorts()).basicRemove(otherEnd, msgs);
      case RoomPackage.SUB_SYSTEM_CLASS__THREADS:
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
      case RoomPackage.SUB_SYSTEM_CLASS__RELAY_PORTS:
        return getRelayPorts();
      case RoomPackage.SUB_SYSTEM_CLASS__THREADS:
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
      case RoomPackage.SUB_SYSTEM_CLASS__RELAY_PORTS:
        getRelayPorts().clear();
        getRelayPorts().addAll((Collection<? extends Port>)newValue);
        return;
      case RoomPackage.SUB_SYSTEM_CLASS__THREADS:
        getThreads().clear();
        getThreads().addAll((Collection<? extends LogicalThread>)newValue);
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
      case RoomPackage.SUB_SYSTEM_CLASS__RELAY_PORTS:
        getRelayPorts().clear();
        return;
      case RoomPackage.SUB_SYSTEM_CLASS__THREADS:
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
      case RoomPackage.SUB_SYSTEM_CLASS__RELAY_PORTS:
        return relayPorts != null && !relayPorts.isEmpty();
      case RoomPackage.SUB_SYSTEM_CLASS__THREADS:
        return threads != null && !threads.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SubSystemClassImpl
