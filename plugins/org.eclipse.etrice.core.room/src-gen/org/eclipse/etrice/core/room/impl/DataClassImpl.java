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

import org.eclipse.etrice.core.common.base.Annotation;

import org.eclipse.etrice.core.fsm.fSM.DetailCode;

import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StandardOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.DataClassImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.DataClassImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.DataClassImpl#getUserCode1 <em>User Code1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.DataClassImpl#getUserCode2 <em>User Code2</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.DataClassImpl#getUserCode3 <em>User Code3</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.DataClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.DataClassImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataClassImpl extends ComplexTypeImpl implements DataClass
{
  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected DataClass base;

  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> annotations;

  /**
   * The cached value of the '{@link #getUserCode1() <em>User Code1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode1()
   * @generated
   * @ordered
   */
  protected DetailCode userCode1;

  /**
   * The cached value of the '{@link #getUserCode2() <em>User Code2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode2()
   * @generated
   * @ordered
   */
  protected DetailCode userCode2;

  /**
   * The cached value of the '{@link #getUserCode3() <em>User Code3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode3()
   * @generated
   * @ordered
   */
  protected DetailCode userCode3;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperations()
   * @generated
   * @ordered
   */
  protected EList<StandardOperation> operations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataClassImpl()
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
    return RoomPackage.Literals.DATA_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataClass getBase()
  {
    if (base != null && base.eIsProxy())
    {
      InternalEObject oldBase = (InternalEObject)base;
      base = (DataClass)eResolveProxy(oldBase);
      if (base != oldBase)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.DATA_CLASS__BASE, oldBase, base));
      }
    }
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataClass basicGetBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBase(DataClass newBase)
  {
    DataClass oldBase = base;
    base = newBase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.DATA_CLASS__BASE, oldBase, base));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, RoomPackage.DATA_CLASS__ANNOTATIONS);
    }
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetailCode getUserCode1()
  {
    return userCode1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUserCode1(DetailCode newUserCode1, NotificationChain msgs)
  {
    DetailCode oldUserCode1 = userCode1;
    userCode1 = newUserCode1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.DATA_CLASS__USER_CODE1, oldUserCode1, newUserCode1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserCode1(DetailCode newUserCode1)
  {
    if (newUserCode1 != userCode1)
    {
      NotificationChain msgs = null;
      if (userCode1 != null)
        msgs = ((InternalEObject)userCode1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.DATA_CLASS__USER_CODE1, null, msgs);
      if (newUserCode1 != null)
        msgs = ((InternalEObject)newUserCode1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.DATA_CLASS__USER_CODE1, null, msgs);
      msgs = basicSetUserCode1(newUserCode1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.DATA_CLASS__USER_CODE1, newUserCode1, newUserCode1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetailCode getUserCode2()
  {
    return userCode2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUserCode2(DetailCode newUserCode2, NotificationChain msgs)
  {
    DetailCode oldUserCode2 = userCode2;
    userCode2 = newUserCode2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.DATA_CLASS__USER_CODE2, oldUserCode2, newUserCode2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserCode2(DetailCode newUserCode2)
  {
    if (newUserCode2 != userCode2)
    {
      NotificationChain msgs = null;
      if (userCode2 != null)
        msgs = ((InternalEObject)userCode2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.DATA_CLASS__USER_CODE2, null, msgs);
      if (newUserCode2 != null)
        msgs = ((InternalEObject)newUserCode2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.DATA_CLASS__USER_CODE2, null, msgs);
      msgs = basicSetUserCode2(newUserCode2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.DATA_CLASS__USER_CODE2, newUserCode2, newUserCode2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetailCode getUserCode3()
  {
    return userCode3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUserCode3(DetailCode newUserCode3, NotificationChain msgs)
  {
    DetailCode oldUserCode3 = userCode3;
    userCode3 = newUserCode3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.DATA_CLASS__USER_CODE3, oldUserCode3, newUserCode3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserCode3(DetailCode newUserCode3)
  {
    if (newUserCode3 != userCode3)
    {
      NotificationChain msgs = null;
      if (userCode3 != null)
        msgs = ((InternalEObject)userCode3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.DATA_CLASS__USER_CODE3, null, msgs);
      if (newUserCode3 != null)
        msgs = ((InternalEObject)newUserCode3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.DATA_CLASS__USER_CODE3, null, msgs);
      msgs = basicSetUserCode3(newUserCode3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.DATA_CLASS__USER_CODE3, newUserCode3, newUserCode3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, RoomPackage.DATA_CLASS__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StandardOperation> getOperations()
  {
    if (operations == null)
    {
      operations = new EObjectContainmentEList<StandardOperation>(StandardOperation.class, this, RoomPackage.DATA_CLASS__OPERATIONS);
    }
    return operations;
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
      case RoomPackage.DATA_CLASS__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case RoomPackage.DATA_CLASS__USER_CODE1:
        return basicSetUserCode1(null, msgs);
      case RoomPackage.DATA_CLASS__USER_CODE2:
        return basicSetUserCode2(null, msgs);
      case RoomPackage.DATA_CLASS__USER_CODE3:
        return basicSetUserCode3(null, msgs);
      case RoomPackage.DATA_CLASS__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case RoomPackage.DATA_CLASS__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
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
      case RoomPackage.DATA_CLASS__BASE:
        if (resolve) return getBase();
        return basicGetBase();
      case RoomPackage.DATA_CLASS__ANNOTATIONS:
        return getAnnotations();
      case RoomPackage.DATA_CLASS__USER_CODE1:
        return getUserCode1();
      case RoomPackage.DATA_CLASS__USER_CODE2:
        return getUserCode2();
      case RoomPackage.DATA_CLASS__USER_CODE3:
        return getUserCode3();
      case RoomPackage.DATA_CLASS__ATTRIBUTES:
        return getAttributes();
      case RoomPackage.DATA_CLASS__OPERATIONS:
        return getOperations();
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
      case RoomPackage.DATA_CLASS__BASE:
        setBase((DataClass)newValue);
        return;
      case RoomPackage.DATA_CLASS__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case RoomPackage.DATA_CLASS__USER_CODE1:
        setUserCode1((DetailCode)newValue);
        return;
      case RoomPackage.DATA_CLASS__USER_CODE2:
        setUserCode2((DetailCode)newValue);
        return;
      case RoomPackage.DATA_CLASS__USER_CODE3:
        setUserCode3((DetailCode)newValue);
        return;
      case RoomPackage.DATA_CLASS__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case RoomPackage.DATA_CLASS__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends StandardOperation>)newValue);
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
      case RoomPackage.DATA_CLASS__BASE:
        setBase((DataClass)null);
        return;
      case RoomPackage.DATA_CLASS__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case RoomPackage.DATA_CLASS__USER_CODE1:
        setUserCode1((DetailCode)null);
        return;
      case RoomPackage.DATA_CLASS__USER_CODE2:
        setUserCode2((DetailCode)null);
        return;
      case RoomPackage.DATA_CLASS__USER_CODE3:
        setUserCode3((DetailCode)null);
        return;
      case RoomPackage.DATA_CLASS__ATTRIBUTES:
        getAttributes().clear();
        return;
      case RoomPackage.DATA_CLASS__OPERATIONS:
        getOperations().clear();
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
      case RoomPackage.DATA_CLASS__BASE:
        return base != null;
      case RoomPackage.DATA_CLASS__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case RoomPackage.DATA_CLASS__USER_CODE1:
        return userCode1 != null;
      case RoomPackage.DATA_CLASS__USER_CODE2:
        return userCode2 != null;
      case RoomPackage.DATA_CLASS__USER_CODE3:
        return userCode3 != null;
      case RoomPackage.DATA_CLASS__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case RoomPackage.DATA_CLASS__OPERATIONS:
        return operations != null && !operations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DataClassImpl
