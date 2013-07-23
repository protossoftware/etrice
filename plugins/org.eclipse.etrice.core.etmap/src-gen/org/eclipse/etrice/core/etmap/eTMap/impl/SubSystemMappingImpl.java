/**
 */
package org.eclipse.etrice.core.etmap.eTMap.impl;

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

import org.eclipse.etrice.core.etmap.eTMap.ETMapPackage;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;

import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;

import org.eclipse.etrice.core.room.SubSystemRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.impl.SubSystemMappingImpl#getLogicalSubSys <em>Logical Sub Sys</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.impl.SubSystemMappingImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.impl.SubSystemMappingImpl#getThreadMappings <em>Thread Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemMappingImpl extends MinimalEObjectImpl.Container implements SubSystemMapping
{
  /**
   * The cached value of the '{@link #getLogicalSubSys() <em>Logical Sub Sys</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogicalSubSys()
   * @generated
   * @ordered
   */
  protected SubSystemRef logicalSubSys;

  /**
   * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected NodeRef node;

  /**
   * The cached value of the '{@link #getThreadMappings() <em>Thread Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThreadMappings()
   * @generated
   * @ordered
   */
  protected EList<ThreadMapping> threadMappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubSystemMappingImpl()
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
    return ETMapPackage.Literals.SUB_SYSTEM_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubSystemRef getLogicalSubSys()
  {
    if (logicalSubSys != null && logicalSubSys.eIsProxy())
    {
      InternalEObject oldLogicalSubSys = (InternalEObject)logicalSubSys;
      logicalSubSys = (SubSystemRef)eResolveProxy(oldLogicalSubSys);
      if (logicalSubSys != oldLogicalSubSys)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETMapPackage.SUB_SYSTEM_MAPPING__LOGICAL_SUB_SYS, oldLogicalSubSys, logicalSubSys));
      }
    }
    return logicalSubSys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubSystemRef basicGetLogicalSubSys()
  {
    return logicalSubSys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLogicalSubSys(SubSystemRef newLogicalSubSys)
  {
    SubSystemRef oldLogicalSubSys = logicalSubSys;
    logicalSubSys = newLogicalSubSys;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETMapPackage.SUB_SYSTEM_MAPPING__LOGICAL_SUB_SYS, oldLogicalSubSys, logicalSubSys));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeRef getNode()
  {
    if (node != null && node.eIsProxy())
    {
      InternalEObject oldNode = (InternalEObject)node;
      node = (NodeRef)eResolveProxy(oldNode);
      if (node != oldNode)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETMapPackage.SUB_SYSTEM_MAPPING__NODE, oldNode, node));
      }
    }
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeRef basicGetNode()
  {
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNode(NodeRef newNode)
  {
    NodeRef oldNode = node;
    node = newNode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETMapPackage.SUB_SYSTEM_MAPPING__NODE, oldNode, node));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ThreadMapping> getThreadMappings()
  {
    if (threadMappings == null)
    {
      threadMappings = new EObjectContainmentEList<ThreadMapping>(ThreadMapping.class, this, ETMapPackage.SUB_SYSTEM_MAPPING__THREAD_MAPPINGS);
    }
    return threadMappings;
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
      case ETMapPackage.SUB_SYSTEM_MAPPING__THREAD_MAPPINGS:
        return ((InternalEList<?>)getThreadMappings()).basicRemove(otherEnd, msgs);
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
      case ETMapPackage.SUB_SYSTEM_MAPPING__LOGICAL_SUB_SYS:
        if (resolve) return getLogicalSubSys();
        return basicGetLogicalSubSys();
      case ETMapPackage.SUB_SYSTEM_MAPPING__NODE:
        if (resolve) return getNode();
        return basicGetNode();
      case ETMapPackage.SUB_SYSTEM_MAPPING__THREAD_MAPPINGS:
        return getThreadMappings();
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
      case ETMapPackage.SUB_SYSTEM_MAPPING__LOGICAL_SUB_SYS:
        setLogicalSubSys((SubSystemRef)newValue);
        return;
      case ETMapPackage.SUB_SYSTEM_MAPPING__NODE:
        setNode((NodeRef)newValue);
        return;
      case ETMapPackage.SUB_SYSTEM_MAPPING__THREAD_MAPPINGS:
        getThreadMappings().clear();
        getThreadMappings().addAll((Collection<? extends ThreadMapping>)newValue);
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
      case ETMapPackage.SUB_SYSTEM_MAPPING__LOGICAL_SUB_SYS:
        setLogicalSubSys((SubSystemRef)null);
        return;
      case ETMapPackage.SUB_SYSTEM_MAPPING__NODE:
        setNode((NodeRef)null);
        return;
      case ETMapPackage.SUB_SYSTEM_MAPPING__THREAD_MAPPINGS:
        getThreadMappings().clear();
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
      case ETMapPackage.SUB_SYSTEM_MAPPING__LOGICAL_SUB_SYS:
        return logicalSubSys != null;
      case ETMapPackage.SUB_SYSTEM_MAPPING__NODE:
        return node != null;
      case ETMapPackage.SUB_SYSTEM_MAPPING__THREAD_MAPPINGS:
        return threadMappings != null && !threadMappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SubSystemMappingImpl
