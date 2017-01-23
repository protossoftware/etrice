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

import org.eclipse.etrice.core.common.base.Import;

import org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;
import org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalModelImpl#getSystems <em>Systems</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalModelImpl#getNodeClasses <em>Node Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalModelImpl#getRuntimeClasses <em>Runtime Classes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhysicalModelImpl extends MinimalEObjectImpl.Container implements PhysicalModel
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
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getSystems() <em>Systems</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystems()
   * @generated
   * @ordered
   */
  protected EList<PhysicalSystem> systems;

  /**
   * The cached value of the '{@link #getNodeClasses() <em>Node Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeClasses()
   * @generated
   * @ordered
   */
  protected EList<NodeClass> nodeClasses;

  /**
   * The cached value of the '{@link #getRuntimeClasses() <em>Runtime Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuntimeClasses()
   * @generated
   * @ordered
   */
  protected EList<RuntimeClass> runtimeClasses;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PhysicalModelImpl()
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
    return ETPhysPackage.Literals.PHYSICAL_MODEL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, ETPhysPackage.PHYSICAL_MODEL__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PhysicalSystem> getSystems()
  {
    if (systems == null)
    {
      systems = new EObjectContainmentEList<PhysicalSystem>(PhysicalSystem.class, this, ETPhysPackage.PHYSICAL_MODEL__SYSTEMS);
    }
    return systems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NodeClass> getNodeClasses()
  {
    if (nodeClasses == null)
    {
      nodeClasses = new EObjectContainmentEList<NodeClass>(NodeClass.class, this, ETPhysPackage.PHYSICAL_MODEL__NODE_CLASSES);
    }
    return nodeClasses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RuntimeClass> getRuntimeClasses()
  {
    if (runtimeClasses == null)
    {
      runtimeClasses = new EObjectContainmentEList<RuntimeClass>(RuntimeClass.class, this, ETPhysPackage.PHYSICAL_MODEL__RUNTIME_CLASSES);
    }
    return runtimeClasses;
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
      case ETPhysPackage.PHYSICAL_MODEL__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case ETPhysPackage.PHYSICAL_MODEL__SYSTEMS:
        return ((InternalEList<?>)getSystems()).basicRemove(otherEnd, msgs);
      case ETPhysPackage.PHYSICAL_MODEL__NODE_CLASSES:
        return ((InternalEList<?>)getNodeClasses()).basicRemove(otherEnd, msgs);
      case ETPhysPackage.PHYSICAL_MODEL__RUNTIME_CLASSES:
        return ((InternalEList<?>)getRuntimeClasses()).basicRemove(otherEnd, msgs);
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
      case ETPhysPackage.PHYSICAL_MODEL__NAME:
        return getName();
      case ETPhysPackage.PHYSICAL_MODEL__IMPORTS:
        return getImports();
      case ETPhysPackage.PHYSICAL_MODEL__SYSTEMS:
        return getSystems();
      case ETPhysPackage.PHYSICAL_MODEL__NODE_CLASSES:
        return getNodeClasses();
      case ETPhysPackage.PHYSICAL_MODEL__RUNTIME_CLASSES:
        return getRuntimeClasses();
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
      case ETPhysPackage.PHYSICAL_MODEL__NAME:
        setName((String)newValue);
        return;
      case ETPhysPackage.PHYSICAL_MODEL__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case ETPhysPackage.PHYSICAL_MODEL__SYSTEMS:
        getSystems().clear();
        getSystems().addAll((Collection<? extends PhysicalSystem>)newValue);
        return;
      case ETPhysPackage.PHYSICAL_MODEL__NODE_CLASSES:
        getNodeClasses().clear();
        getNodeClasses().addAll((Collection<? extends NodeClass>)newValue);
        return;
      case ETPhysPackage.PHYSICAL_MODEL__RUNTIME_CLASSES:
        getRuntimeClasses().clear();
        getRuntimeClasses().addAll((Collection<? extends RuntimeClass>)newValue);
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
      case ETPhysPackage.PHYSICAL_MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ETPhysPackage.PHYSICAL_MODEL__IMPORTS:
        getImports().clear();
        return;
      case ETPhysPackage.PHYSICAL_MODEL__SYSTEMS:
        getSystems().clear();
        return;
      case ETPhysPackage.PHYSICAL_MODEL__NODE_CLASSES:
        getNodeClasses().clear();
        return;
      case ETPhysPackage.PHYSICAL_MODEL__RUNTIME_CLASSES:
        getRuntimeClasses().clear();
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
      case ETPhysPackage.PHYSICAL_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ETPhysPackage.PHYSICAL_MODEL__IMPORTS:
        return imports != null && !imports.isEmpty();
      case ETPhysPackage.PHYSICAL_MODEL__SYSTEMS:
        return systems != null && !systems.isEmpty();
      case ETPhysPackage.PHYSICAL_MODEL__NODE_CLASSES:
        return nodeClasses != null && !nodeClasses.isEmpty();
      case ETPhysPackage.PHYSICAL_MODEL__RUNTIME_CLASSES:
        return runtimeClasses != null && !runtimeClasses.isEmpty();
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
    result.append(')');
    return result.toString();
  }

} //PhysicalModelImpl
