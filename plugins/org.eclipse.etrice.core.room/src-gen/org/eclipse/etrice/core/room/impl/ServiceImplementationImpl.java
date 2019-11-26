/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ServiceImplementationImpl#getSpp <em>Spp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceImplementationImpl extends MinimalEObjectImpl.Container implements ServiceImplementation
{
  /**
   * The cached value of the '{@link #getSpp() <em>Spp</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpp()
   * @generated
   * @ordered
   */
  protected SPP spp;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ServiceImplementationImpl()
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
    return RoomPackage.Literals.SERVICE_IMPLEMENTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SPP getSpp()
  {
    if (spp != null && spp.eIsProxy())
    {
      InternalEObject oldSpp = (InternalEObject)spp;
      spp = (SPP)eResolveProxy(oldSpp);
      if (spp != oldSpp)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.SERVICE_IMPLEMENTATION__SPP, oldSpp, spp));
      }
    }
    return spp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SPP basicGetSpp()
  {
    return spp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSpp(SPP newSpp)
  {
    SPP oldSpp = spp;
    spp = newSpp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.SERVICE_IMPLEMENTATION__SPP, oldSpp, spp));
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
      case RoomPackage.SERVICE_IMPLEMENTATION__SPP:
        if (resolve) return getSpp();
        return basicGetSpp();
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
      case RoomPackage.SERVICE_IMPLEMENTATION__SPP:
        setSpp((SPP)newValue);
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
      case RoomPackage.SERVICE_IMPLEMENTATION__SPP:
        setSpp((SPP)null);
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
      case RoomPackage.SERVICE_IMPLEMENTATION__SPP:
        return spp != null;
    }
    return super.eIsSet(featureID);
  }

} //ServiceImplementationImpl
