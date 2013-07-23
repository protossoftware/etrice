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
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;

import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;

import org.eclipse.etrice.core.room.LogicalSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.impl.MappingImpl#getLogicalSys <em>Logical Sys</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.impl.MappingImpl#getPhysicalSys <em>Physical Sys</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.impl.MappingImpl#getSubsysMappings <em>Subsys Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends MinimalEObjectImpl.Container implements Mapping
{
  /**
   * The cached value of the '{@link #getLogicalSys() <em>Logical Sys</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogicalSys()
   * @generated
   * @ordered
   */
  protected LogicalSystem logicalSys;

  /**
   * The cached value of the '{@link #getPhysicalSys() <em>Physical Sys</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhysicalSys()
   * @generated
   * @ordered
   */
  protected PhysicalSystem physicalSys;

  /**
   * The cached value of the '{@link #getSubsysMappings() <em>Subsys Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubsysMappings()
   * @generated
   * @ordered
   */
  protected EList<SubSystemMapping> subsysMappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MappingImpl()
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
    return ETMapPackage.Literals.MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalSystem getLogicalSys()
  {
    if (logicalSys != null && logicalSys.eIsProxy())
    {
      InternalEObject oldLogicalSys = (InternalEObject)logicalSys;
      logicalSys = (LogicalSystem)eResolveProxy(oldLogicalSys);
      if (logicalSys != oldLogicalSys)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETMapPackage.MAPPING__LOGICAL_SYS, oldLogicalSys, logicalSys));
      }
    }
    return logicalSys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalSystem basicGetLogicalSys()
  {
    return logicalSys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLogicalSys(LogicalSystem newLogicalSys)
  {
    LogicalSystem oldLogicalSys = logicalSys;
    logicalSys = newLogicalSys;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETMapPackage.MAPPING__LOGICAL_SYS, oldLogicalSys, logicalSys));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhysicalSystem getPhysicalSys()
  {
    if (physicalSys != null && physicalSys.eIsProxy())
    {
      InternalEObject oldPhysicalSys = (InternalEObject)physicalSys;
      physicalSys = (PhysicalSystem)eResolveProxy(oldPhysicalSys);
      if (physicalSys != oldPhysicalSys)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ETMapPackage.MAPPING__PHYSICAL_SYS, oldPhysicalSys, physicalSys));
      }
    }
    return physicalSys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhysicalSystem basicGetPhysicalSys()
  {
    return physicalSys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPhysicalSys(PhysicalSystem newPhysicalSys)
  {
    PhysicalSystem oldPhysicalSys = physicalSys;
    physicalSys = newPhysicalSys;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETMapPackage.MAPPING__PHYSICAL_SYS, oldPhysicalSys, physicalSys));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SubSystemMapping> getSubsysMappings()
  {
    if (subsysMappings == null)
    {
      subsysMappings = new EObjectContainmentEList<SubSystemMapping>(SubSystemMapping.class, this, ETMapPackage.MAPPING__SUBSYS_MAPPINGS);
    }
    return subsysMappings;
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
      case ETMapPackage.MAPPING__SUBSYS_MAPPINGS:
        return ((InternalEList<?>)getSubsysMappings()).basicRemove(otherEnd, msgs);
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
      case ETMapPackage.MAPPING__LOGICAL_SYS:
        if (resolve) return getLogicalSys();
        return basicGetLogicalSys();
      case ETMapPackage.MAPPING__PHYSICAL_SYS:
        if (resolve) return getPhysicalSys();
        return basicGetPhysicalSys();
      case ETMapPackage.MAPPING__SUBSYS_MAPPINGS:
        return getSubsysMappings();
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
      case ETMapPackage.MAPPING__LOGICAL_SYS:
        setLogicalSys((LogicalSystem)newValue);
        return;
      case ETMapPackage.MAPPING__PHYSICAL_SYS:
        setPhysicalSys((PhysicalSystem)newValue);
        return;
      case ETMapPackage.MAPPING__SUBSYS_MAPPINGS:
        getSubsysMappings().clear();
        getSubsysMappings().addAll((Collection<? extends SubSystemMapping>)newValue);
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
      case ETMapPackage.MAPPING__LOGICAL_SYS:
        setLogicalSys((LogicalSystem)null);
        return;
      case ETMapPackage.MAPPING__PHYSICAL_SYS:
        setPhysicalSys((PhysicalSystem)null);
        return;
      case ETMapPackage.MAPPING__SUBSYS_MAPPINGS:
        getSubsysMappings().clear();
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
      case ETMapPackage.MAPPING__LOGICAL_SYS:
        return logicalSys != null;
      case ETMapPackage.MAPPING__PHYSICAL_SYS:
        return physicalSys != null;
      case ETMapPackage.MAPPING__SUBSYS_MAPPINGS:
        return subsysMappings != null && !subsysMappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MappingImpl
