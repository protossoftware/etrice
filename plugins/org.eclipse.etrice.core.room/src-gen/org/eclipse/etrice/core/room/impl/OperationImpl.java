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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Documentation;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.VarDecl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.OperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.OperationImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.OperationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.OperationImpl#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.OperationImpl#getDetailCode <em>Detail Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends MinimalEObjectImpl.Container implements Operation
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
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected EList<VarDecl> arguments;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected RefableType returnType;

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
   * The cached value of the '{@link #getDetailCode() <em>Detail Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetailCode()
   * @generated
   * @ordered
   */
  protected DetailCode detailCode;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationImpl()
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
    return RoomPackage.Literals.OPERATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.OPERATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VarDecl> getArguments()
  {
    if (arguments == null)
    {
      arguments = new EObjectContainmentEList<VarDecl>(VarDecl.class, this, RoomPackage.OPERATION__ARGUMENTS);
    }
    return arguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefableType getReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturnType(RefableType newReturnType, NotificationChain msgs)
  {
    RefableType oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.OPERATION__RETURN_TYPE, oldReturnType, newReturnType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(RefableType newReturnType)
  {
    if (newReturnType != returnType)
    {
      NotificationChain msgs = null;
      if (returnType != null)
        msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.OPERATION__RETURN_TYPE, null, msgs);
      if (newReturnType != null)
        msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.OPERATION__RETURN_TYPE, null, msgs);
      msgs = basicSetReturnType(newReturnType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.OPERATION__RETURN_TYPE, newReturnType, newReturnType));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.OPERATION__DOCU, oldDocu, newDocu);
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
        msgs = ((InternalEObject)docu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.OPERATION__DOCU, null, msgs);
      if (newDocu != null)
        msgs = ((InternalEObject)newDocu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.OPERATION__DOCU, null, msgs);
      msgs = basicSetDocu(newDocu, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.OPERATION__DOCU, newDocu, newDocu));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetailCode getDetailCode()
  {
    return detailCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDetailCode(DetailCode newDetailCode, NotificationChain msgs)
  {
    DetailCode oldDetailCode = detailCode;
    detailCode = newDetailCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.OPERATION__DETAIL_CODE, oldDetailCode, newDetailCode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDetailCode(DetailCode newDetailCode)
  {
    if (newDetailCode != detailCode)
    {
      NotificationChain msgs = null;
      if (detailCode != null)
        msgs = ((InternalEObject)detailCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.OPERATION__DETAIL_CODE, null, msgs);
      if (newDetailCode != null)
        msgs = ((InternalEObject)newDetailCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.OPERATION__DETAIL_CODE, null, msgs);
      msgs = basicSetDetailCode(newDetailCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.OPERATION__DETAIL_CODE, newDetailCode, newDetailCode));
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
      case RoomPackage.OPERATION__ARGUMENTS:
        return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
      case RoomPackage.OPERATION__RETURN_TYPE:
        return basicSetReturnType(null, msgs);
      case RoomPackage.OPERATION__DOCU:
        return basicSetDocu(null, msgs);
      case RoomPackage.OPERATION__DETAIL_CODE:
        return basicSetDetailCode(null, msgs);
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
      case RoomPackage.OPERATION__NAME:
        return getName();
      case RoomPackage.OPERATION__ARGUMENTS:
        return getArguments();
      case RoomPackage.OPERATION__RETURN_TYPE:
        return getReturnType();
      case RoomPackage.OPERATION__DOCU:
        return getDocu();
      case RoomPackage.OPERATION__DETAIL_CODE:
        return getDetailCode();
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
      case RoomPackage.OPERATION__NAME:
        setName((String)newValue);
        return;
      case RoomPackage.OPERATION__ARGUMENTS:
        getArguments().clear();
        getArguments().addAll((Collection<? extends VarDecl>)newValue);
        return;
      case RoomPackage.OPERATION__RETURN_TYPE:
        setReturnType((RefableType)newValue);
        return;
      case RoomPackage.OPERATION__DOCU:
        setDocu((Documentation)newValue);
        return;
      case RoomPackage.OPERATION__DETAIL_CODE:
        setDetailCode((DetailCode)newValue);
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
      case RoomPackage.OPERATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case RoomPackage.OPERATION__ARGUMENTS:
        getArguments().clear();
        return;
      case RoomPackage.OPERATION__RETURN_TYPE:
        setReturnType((RefableType)null);
        return;
      case RoomPackage.OPERATION__DOCU:
        setDocu((Documentation)null);
        return;
      case RoomPackage.OPERATION__DETAIL_CODE:
        setDetailCode((DetailCode)null);
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
      case RoomPackage.OPERATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case RoomPackage.OPERATION__ARGUMENTS:
        return arguments != null && !arguments.isEmpty();
      case RoomPackage.OPERATION__RETURN_TYPE:
        return returnType != null;
      case RoomPackage.OPERATION__DOCU:
        return docu != null;
      case RoomPackage.OPERATION__DETAIL_CODE:
        return detailCode != null;
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

} //OperationImpl
