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
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalSystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalSystemImpl#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.impl.PhysicalSystemImpl#getNodeRefs <em>Node Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PhysicalSystemImpl extends MinimalEObjectImpl.Container implements PhysicalSystem
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
   * The cached value of the '{@link #getNodeRefs() <em>Node Refs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeRefs()
   * @generated
   * @ordered
   */
  protected EList<NodeRef> nodeRefs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PhysicalSystemImpl()
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
    return ETPhysPackage.Literals.PHYSICAL_SYSTEM;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_SYSTEM__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_SYSTEM__DOCU, oldDocu, newDocu);
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
        msgs = ((InternalEObject)docu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ETPhysPackage.PHYSICAL_SYSTEM__DOCU, null, msgs);
      if (newDocu != null)
        msgs = ((InternalEObject)newDocu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ETPhysPackage.PHYSICAL_SYSTEM__DOCU, null, msgs);
      msgs = basicSetDocu(newDocu, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ETPhysPackage.PHYSICAL_SYSTEM__DOCU, newDocu, newDocu));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NodeRef> getNodeRefs()
  {
    if (nodeRefs == null)
    {
      nodeRefs = new EObjectContainmentEList<NodeRef>(NodeRef.class, this, ETPhysPackage.PHYSICAL_SYSTEM__NODE_REFS);
    }
    return nodeRefs;
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
      case ETPhysPackage.PHYSICAL_SYSTEM__DOCU:
        return basicSetDocu(null, msgs);
      case ETPhysPackage.PHYSICAL_SYSTEM__NODE_REFS:
        return ((InternalEList<?>)getNodeRefs()).basicRemove(otherEnd, msgs);
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
      case ETPhysPackage.PHYSICAL_SYSTEM__NAME:
        return getName();
      case ETPhysPackage.PHYSICAL_SYSTEM__DOCU:
        return getDocu();
      case ETPhysPackage.PHYSICAL_SYSTEM__NODE_REFS:
        return getNodeRefs();
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
      case ETPhysPackage.PHYSICAL_SYSTEM__NAME:
        setName((String)newValue);
        return;
      case ETPhysPackage.PHYSICAL_SYSTEM__DOCU:
        setDocu((Documentation)newValue);
        return;
      case ETPhysPackage.PHYSICAL_SYSTEM__NODE_REFS:
        getNodeRefs().clear();
        getNodeRefs().addAll((Collection<? extends NodeRef>)newValue);
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
      case ETPhysPackage.PHYSICAL_SYSTEM__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ETPhysPackage.PHYSICAL_SYSTEM__DOCU:
        setDocu((Documentation)null);
        return;
      case ETPhysPackage.PHYSICAL_SYSTEM__NODE_REFS:
        getNodeRefs().clear();
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
      case ETPhysPackage.PHYSICAL_SYSTEM__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ETPhysPackage.PHYSICAL_SYSTEM__DOCU:
        return docu != null;
      case ETPhysPackage.PHYSICAL_SYSTEM__NODE_REFS:
        return nodeRefs != null && !nodeRefs.isEmpty();
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

} //PhysicalSystemImpl
