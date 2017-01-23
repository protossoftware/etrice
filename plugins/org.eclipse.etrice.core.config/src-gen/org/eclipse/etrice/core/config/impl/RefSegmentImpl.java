/**
 */
package org.eclipse.etrice.core.config.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.config.RefSegment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ref Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.RefSegmentImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.RefSegmentImpl#getIdx <em>Idx</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RefSegmentImpl extends MinimalEObjectImpl.Container implements RefSegment
{
  /**
   * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected static final String REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected String ref = REF_EDEFAULT;

  /**
   * The default value of the '{@link #getIdx() <em>Idx</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdx()
   * @generated
   * @ordered
   */
  protected static final int IDX_EDEFAULT = -1;

  /**
   * The cached value of the '{@link #getIdx() <em>Idx</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdx()
   * @generated
   * @ordered
   */
  protected int idx = IDX_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RefSegmentImpl()
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
    return ConfigPackage.Literals.REF_SEGMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(String newRef)
  {
    String oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.REF_SEGMENT__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getIdx()
  {
    return idx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIdx(int newIdx)
  {
    int oldIdx = idx;
    idx = newIdx;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.REF_SEGMENT__IDX, oldIdx, idx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    return getRef() + ((getIdx()>=0)? ":"+getIdx() : "");
    
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
      case ConfigPackage.REF_SEGMENT__REF:
        return getRef();
      case ConfigPackage.REF_SEGMENT__IDX:
        return getIdx();
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
      case ConfigPackage.REF_SEGMENT__REF:
        setRef((String)newValue);
        return;
      case ConfigPackage.REF_SEGMENT__IDX:
        setIdx((Integer)newValue);
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
      case ConfigPackage.REF_SEGMENT__REF:
        setRef(REF_EDEFAULT);
        return;
      case ConfigPackage.REF_SEGMENT__IDX:
        setIdx(IDX_EDEFAULT);
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
      case ConfigPackage.REF_SEGMENT__REF:
        return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
      case ConfigPackage.REF_SEGMENT__IDX:
        return idx != IDX_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

} //RefSegmentImpl
