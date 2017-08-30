/**
 */
package org.eclipse.etrice.core.fsm.fSM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Detail Code</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.DetailCodeImpl#getLines <em>Lines</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.DetailCodeImpl#isUsed <em>Used</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DetailCodeImpl extends MinimalEObjectImpl.Container implements DetailCode
{
  /**
   * The cached value of the '{@link #getLines() <em>Lines</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLines()
   * @generated
   * @ordered
   */
  protected EList<String> lines;

  /**
   * The default value of the '{@link #isUsed() <em>Used</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUsed()
   * @generated
   * @ordered
   */
  protected static final boolean USED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUsed() <em>Used</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUsed()
   * @generated
   * @ordered
   */
  protected boolean used = USED_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DetailCodeImpl()
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
    return FSMPackage.Literals.DETAIL_CODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getLines()
  {
    if (lines == null)
    {
      lines = new EDataTypeEList<String>(String.class, this, FSMPackage.DETAIL_CODE__LINES);
    }
    return lines;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUsed()
  {
    return used;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUsed(boolean newUsed)
  {
    boolean oldUsed = used;
    used = newUsed;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.DETAIL_CODE__USED, oldUsed, used));
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
      case FSMPackage.DETAIL_CODE__LINES:
        return getLines();
      case FSMPackage.DETAIL_CODE__USED:
        return isUsed();
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
      case FSMPackage.DETAIL_CODE__LINES:
        getLines().clear();
        getLines().addAll((Collection<? extends String>)newValue);
        return;
      case FSMPackage.DETAIL_CODE__USED:
        setUsed((Boolean)newValue);
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
      case FSMPackage.DETAIL_CODE__LINES:
        getLines().clear();
        return;
      case FSMPackage.DETAIL_CODE__USED:
        setUsed(USED_EDEFAULT);
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
      case FSMPackage.DETAIL_CODE__LINES:
        return lines != null && !lines.isEmpty();
      case FSMPackage.DETAIL_CODE__USED:
        return used != USED_EDEFAULT;
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
    result.append(" (lines: ");
    result.append(lines);
    result.append(", used: ");
    result.append(used);
    result.append(')');
    return result.toString();
  }

} //DetailCodeImpl
