/**
 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.EnumerationTypeImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.EnumerationTypeImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumerationTypeImpl extends DataTypeImpl implements EnumerationType
{
  /**
   * The cached value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimitiveType()
   * @generated
   * @ordered
   */
  protected PrimitiveType primitiveType;

  /**
   * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLiterals()
   * @generated
   * @ordered
   */
  protected EList<EnumLiteral> literals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumerationTypeImpl()
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
    return RoomPackage.Literals.ENUMERATION_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveType getPrimitiveType()
  {
    if (primitiveType != null && primitiveType.eIsProxy())
    {
      InternalEObject oldPrimitiveType = (InternalEObject)primitiveType;
      primitiveType = (PrimitiveType)eResolveProxy(oldPrimitiveType);
      if (primitiveType != oldPrimitiveType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.ENUMERATION_TYPE__PRIMITIVE_TYPE, oldPrimitiveType, primitiveType));
      }
    }
    return primitiveType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveType basicGetPrimitiveType()
  {
    return primitiveType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimitiveType(PrimitiveType newPrimitiveType)
  {
    PrimitiveType oldPrimitiveType = primitiveType;
    primitiveType = newPrimitiveType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ENUMERATION_TYPE__PRIMITIVE_TYPE, oldPrimitiveType, primitiveType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EnumLiteral> getLiterals()
  {
    if (literals == null)
    {
      literals = new EObjectContainmentEList<EnumLiteral>(EnumLiteral.class, this, RoomPackage.ENUMERATION_TYPE__LITERALS);
    }
    return literals;
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
      case RoomPackage.ENUMERATION_TYPE__LITERALS:
        return ((InternalEList<?>)getLiterals()).basicRemove(otherEnd, msgs);
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
      case RoomPackage.ENUMERATION_TYPE__PRIMITIVE_TYPE:
        if (resolve) return getPrimitiveType();
        return basicGetPrimitiveType();
      case RoomPackage.ENUMERATION_TYPE__LITERALS:
        return getLiterals();
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
      case RoomPackage.ENUMERATION_TYPE__PRIMITIVE_TYPE:
        setPrimitiveType((PrimitiveType)newValue);
        return;
      case RoomPackage.ENUMERATION_TYPE__LITERALS:
        getLiterals().clear();
        getLiterals().addAll((Collection<? extends EnumLiteral>)newValue);
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
      case RoomPackage.ENUMERATION_TYPE__PRIMITIVE_TYPE:
        setPrimitiveType((PrimitiveType)null);
        return;
      case RoomPackage.ENUMERATION_TYPE__LITERALS:
        getLiterals().clear();
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
      case RoomPackage.ENUMERATION_TYPE__PRIMITIVE_TYPE:
        return primitiveType != null;
      case RoomPackage.ENUMERATION_TYPE__LITERALS:
        return literals != null && !literals.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EnumerationTypeImpl
