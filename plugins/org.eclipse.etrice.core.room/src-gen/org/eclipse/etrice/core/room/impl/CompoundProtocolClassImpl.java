/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SubProtocol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Protocol Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.CompoundProtocolClassImpl#getSubProtocols <em>Sub Protocols</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompoundProtocolClassImpl extends GeneralProtocolClassImpl implements CompoundProtocolClass
{
  /**
   * The cached value of the '{@link #getSubProtocols() <em>Sub Protocols</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubProtocols()
   * @generated
   * @ordered
   */
  protected EList<SubProtocol> subProtocols;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompoundProtocolClassImpl()
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
    return RoomPackage.Literals.COMPOUND_PROTOCOL_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SubProtocol> getSubProtocols()
  {
    if (subProtocols == null)
    {
      subProtocols = new EObjectContainmentEList<SubProtocol>(SubProtocol.class, this, RoomPackage.COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS);
    }
    return subProtocols;
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
      case RoomPackage.COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS:
        return ((InternalEList<?>)getSubProtocols()).basicRemove(otherEnd, msgs);
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
      case RoomPackage.COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS:
        return getSubProtocols();
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
      case RoomPackage.COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS:
        getSubProtocols().clear();
        getSubProtocols().addAll((Collection<? extends SubProtocol>)newValue);
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
      case RoomPackage.COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS:
        getSubProtocols().clear();
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
      case RoomPackage.COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS:
        return subProtocols != null && !subProtocols.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CompoundProtocolClassImpl
