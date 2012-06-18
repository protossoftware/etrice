/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.config.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.config.AttrClassConfig;
import org.eclipse.etrice.core.config.ConfigPackage;
import org.eclipse.etrice.core.config.NumberLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attr Class Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.impl.AttrClassConfigImpl#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.impl.AttrClassConfigImpl#getMax <em>Max</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttrClassConfigImpl extends AttrConfigImpl implements AttrClassConfig
{
  /**
   * The cached value of the '{@link #getMin() <em>Min</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMin()
   * @generated
   * @ordered
   */
  protected NumberLiteral min;

  /**
   * The cached value of the '{@link #getMax() <em>Max</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMax()
   * @generated
   * @ordered
   */
  protected NumberLiteral max;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttrClassConfigImpl()
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
    return ConfigPackage.Literals.ATTR_CLASS_CONFIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public NumberLiteral getMin()
  {
    return min;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMin(NumberLiteral newMin, NotificationChain msgs)
  {
    NumberLiteral oldMin = min;
    min = newMin;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.ATTR_CLASS_CONFIG__MIN, oldMin, newMin);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public void setMin(NumberLiteral newMin)
  {
    if (newMin != min)
    {
      NotificationChain msgs = null;
      if (min != null)
        msgs = ((InternalEObject)min).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ATTR_CLASS_CONFIG__MIN, null, msgs);
      if (newMin != null)
        msgs = ((InternalEObject)newMin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ATTR_CLASS_CONFIG__MIN, null, msgs);
      msgs = basicSetMin(newMin, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ATTR_CLASS_CONFIG__MIN, newMin, newMin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public NumberLiteral getMax()
  {
    return max;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMax(NumberLiteral newMax, NotificationChain msgs)
  {
    NumberLiteral oldMax = max;
    max = newMax;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigPackage.ATTR_CLASS_CONFIG__MAX, oldMax, newMax);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public void setMax(NumberLiteral newMax)
  {
    if (newMax != max)
    {
      NotificationChain msgs = null;
      if (max != null)
        msgs = ((InternalEObject)max).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ATTR_CLASS_CONFIG__MAX, null, msgs);
      if (newMax != null)
        msgs = ((InternalEObject)newMax).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigPackage.ATTR_CLASS_CONFIG__MAX, null, msgs);
      msgs = basicSetMax(newMax, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.ATTR_CLASS_CONFIG__MAX, newMax, newMax));
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
      case ConfigPackage.ATTR_CLASS_CONFIG__MIN:
        return basicSetMin(null, msgs);
      case ConfigPackage.ATTR_CLASS_CONFIG__MAX:
        return basicSetMax(null, msgs);
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
      case ConfigPackage.ATTR_CLASS_CONFIG__MIN:
        return getMin();
      case ConfigPackage.ATTR_CLASS_CONFIG__MAX:
        return getMax();
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
      case ConfigPackage.ATTR_CLASS_CONFIG__MIN:
        setMin((NumberLiteral)newValue);
        return;
      case ConfigPackage.ATTR_CLASS_CONFIG__MAX:
        setMax((NumberLiteral)newValue);
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
      case ConfigPackage.ATTR_CLASS_CONFIG__MIN:
        setMin((NumberLiteral)null);
        return;
      case ConfigPackage.ATTR_CLASS_CONFIG__MAX:
        setMax((NumberLiteral)null);
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
      case ConfigPackage.ATTR_CLASS_CONFIG__MIN:
        return min != null;
      case ConfigPackage.ATTR_CLASS_CONFIG__MAX:
        return max != null;
    }
    return super.eIsSet(featureID);
  }

} //AttrClassConfigImpl
