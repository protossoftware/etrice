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

import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.ProtocolSemantics;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getCommType <em>Comm Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getUserCode1 <em>User Code1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getUserCode2 <em>User Code2</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getUserCode3 <em>User Code3</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getIncomingMessages <em>Incoming Messages</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getOutgoingMessages <em>Outgoing Messages</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getRegular <em>Regular</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getConjugate <em>Conjugate</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ProtocolClassImpl#getSemantics <em>Semantics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProtocolClassImpl extends GeneralProtocolClassImpl implements ProtocolClass
{
  /**
   * The default value of the '{@link #getCommType() <em>Comm Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommType()
   * @generated
   * @ordered
   */
  protected static final CommunicationType COMM_TYPE_EDEFAULT = CommunicationType.EVENT_DRIVEN;

  /**
   * The cached value of the '{@link #getCommType() <em>Comm Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommType()
   * @generated
   * @ordered
   */
  protected CommunicationType commType = COMM_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected ProtocolClass base;

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
   * The cached value of the '{@link #getIncomingMessages() <em>Incoming Messages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncomingMessages()
   * @generated
   * @ordered
   */
  protected EList<Message> incomingMessages;

  /**
   * The cached value of the '{@link #getOutgoingMessages() <em>Outgoing Messages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoingMessages()
   * @generated
   * @ordered
   */
  protected EList<Message> outgoingMessages;

  /**
   * The cached value of the '{@link #getRegular() <em>Regular</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegular()
   * @generated
   * @ordered
   */
  protected PortClass regular;

  /**
   * The cached value of the '{@link #getConjugate() <em>Conjugate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConjugate()
   * @generated
   * @ordered
   */
  protected PortClass conjugate;

  /**
   * The cached value of the '{@link #getSemantics() <em>Semantics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSemantics()
   * @generated
   * @ordered
   */
  protected ProtocolSemantics semantics;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProtocolClassImpl()
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
    return RoomPackage.Literals.PROTOCOL_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommunicationType getCommType()
  {
    return commType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCommType(CommunicationType newCommType)
  {
    CommunicationType oldCommType = commType;
    commType = newCommType == null ? COMM_TYPE_EDEFAULT : newCommType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__COMM_TYPE, oldCommType, commType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProtocolClass getBase()
  {
    if (base != null && base.eIsProxy())
    {
      InternalEObject oldBase = (InternalEObject)base;
      base = (ProtocolClass)eResolveProxy(oldBase);
      if (base != oldBase)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.PROTOCOL_CLASS__BASE, oldBase, base));
      }
    }
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProtocolClass basicGetBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBase(ProtocolClass newBase)
  {
    ProtocolClass oldBase = base;
    base = newBase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__BASE, oldBase, base));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__USER_CODE1, oldUserCode1, newUserCode1);
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
        msgs = ((InternalEObject)userCode1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__USER_CODE1, null, msgs);
      if (newUserCode1 != null)
        msgs = ((InternalEObject)newUserCode1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__USER_CODE1, null, msgs);
      msgs = basicSetUserCode1(newUserCode1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__USER_CODE1, newUserCode1, newUserCode1));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__USER_CODE2, oldUserCode2, newUserCode2);
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
        msgs = ((InternalEObject)userCode2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__USER_CODE2, null, msgs);
      if (newUserCode2 != null)
        msgs = ((InternalEObject)newUserCode2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__USER_CODE2, null, msgs);
      msgs = basicSetUserCode2(newUserCode2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__USER_CODE2, newUserCode2, newUserCode2));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__USER_CODE3, oldUserCode3, newUserCode3);
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
        msgs = ((InternalEObject)userCode3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__USER_CODE3, null, msgs);
      if (newUserCode3 != null)
        msgs = ((InternalEObject)newUserCode3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__USER_CODE3, null, msgs);
      msgs = basicSetUserCode3(newUserCode3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__USER_CODE3, newUserCode3, newUserCode3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Message> getIncomingMessages()
  {
    if (incomingMessages == null)
    {
      incomingMessages = new EObjectContainmentEList<Message>(Message.class, this, RoomPackage.PROTOCOL_CLASS__INCOMING_MESSAGES);
    }
    return incomingMessages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Message> getOutgoingMessages()
  {
    if (outgoingMessages == null)
    {
      outgoingMessages = new EObjectContainmentEList<Message>(Message.class, this, RoomPackage.PROTOCOL_CLASS__OUTGOING_MESSAGES);
    }
    return outgoingMessages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortClass getRegular()
  {
    return regular;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRegular(PortClass newRegular, NotificationChain msgs)
  {
    PortClass oldRegular = regular;
    regular = newRegular;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__REGULAR, oldRegular, newRegular);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRegular(PortClass newRegular)
  {
    if (newRegular != regular)
    {
      NotificationChain msgs = null;
      if (regular != null)
        msgs = ((InternalEObject)regular).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__REGULAR, null, msgs);
      if (newRegular != null)
        msgs = ((InternalEObject)newRegular).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__REGULAR, null, msgs);
      msgs = basicSetRegular(newRegular, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__REGULAR, newRegular, newRegular));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PortClass getConjugate()
  {
    return conjugate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConjugate(PortClass newConjugate, NotificationChain msgs)
  {
    PortClass oldConjugate = conjugate;
    conjugate = newConjugate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__CONJUGATE, oldConjugate, newConjugate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConjugate(PortClass newConjugate)
  {
    if (newConjugate != conjugate)
    {
      NotificationChain msgs = null;
      if (conjugate != null)
        msgs = ((InternalEObject)conjugate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__CONJUGATE, null, msgs);
      if (newConjugate != null)
        msgs = ((InternalEObject)newConjugate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__CONJUGATE, null, msgs);
      msgs = basicSetConjugate(newConjugate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__CONJUGATE, newConjugate, newConjugate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProtocolSemantics getSemantics()
  {
    return semantics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSemantics(ProtocolSemantics newSemantics, NotificationChain msgs)
  {
    ProtocolSemantics oldSemantics = semantics;
    semantics = newSemantics;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__SEMANTICS, oldSemantics, newSemantics);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSemantics(ProtocolSemantics newSemantics)
  {
    if (newSemantics != semantics)
    {
      NotificationChain msgs = null;
      if (semantics != null)
        msgs = ((InternalEObject)semantics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__SEMANTICS, null, msgs);
      if (newSemantics != null)
        msgs = ((InternalEObject)newSemantics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PROTOCOL_CLASS__SEMANTICS, null, msgs);
      msgs = basicSetSemantics(newSemantics, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PROTOCOL_CLASS__SEMANTICS, newSemantics, newSemantics));
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
      case RoomPackage.PROTOCOL_CLASS__USER_CODE1:
        return basicSetUserCode1(null, msgs);
      case RoomPackage.PROTOCOL_CLASS__USER_CODE2:
        return basicSetUserCode2(null, msgs);
      case RoomPackage.PROTOCOL_CLASS__USER_CODE3:
        return basicSetUserCode3(null, msgs);
      case RoomPackage.PROTOCOL_CLASS__INCOMING_MESSAGES:
        return ((InternalEList<?>)getIncomingMessages()).basicRemove(otherEnd, msgs);
      case RoomPackage.PROTOCOL_CLASS__OUTGOING_MESSAGES:
        return ((InternalEList<?>)getOutgoingMessages()).basicRemove(otherEnd, msgs);
      case RoomPackage.PROTOCOL_CLASS__REGULAR:
        return basicSetRegular(null, msgs);
      case RoomPackage.PROTOCOL_CLASS__CONJUGATE:
        return basicSetConjugate(null, msgs);
      case RoomPackage.PROTOCOL_CLASS__SEMANTICS:
        return basicSetSemantics(null, msgs);
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
      case RoomPackage.PROTOCOL_CLASS__COMM_TYPE:
        return getCommType();
      case RoomPackage.PROTOCOL_CLASS__BASE:
        if (resolve) return getBase();
        return basicGetBase();
      case RoomPackage.PROTOCOL_CLASS__USER_CODE1:
        return getUserCode1();
      case RoomPackage.PROTOCOL_CLASS__USER_CODE2:
        return getUserCode2();
      case RoomPackage.PROTOCOL_CLASS__USER_CODE3:
        return getUserCode3();
      case RoomPackage.PROTOCOL_CLASS__INCOMING_MESSAGES:
        return getIncomingMessages();
      case RoomPackage.PROTOCOL_CLASS__OUTGOING_MESSAGES:
        return getOutgoingMessages();
      case RoomPackage.PROTOCOL_CLASS__REGULAR:
        return getRegular();
      case RoomPackage.PROTOCOL_CLASS__CONJUGATE:
        return getConjugate();
      case RoomPackage.PROTOCOL_CLASS__SEMANTICS:
        return getSemantics();
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
      case RoomPackage.PROTOCOL_CLASS__COMM_TYPE:
        setCommType((CommunicationType)newValue);
        return;
      case RoomPackage.PROTOCOL_CLASS__BASE:
        setBase((ProtocolClass)newValue);
        return;
      case RoomPackage.PROTOCOL_CLASS__USER_CODE1:
        setUserCode1((DetailCode)newValue);
        return;
      case RoomPackage.PROTOCOL_CLASS__USER_CODE2:
        setUserCode2((DetailCode)newValue);
        return;
      case RoomPackage.PROTOCOL_CLASS__USER_CODE3:
        setUserCode3((DetailCode)newValue);
        return;
      case RoomPackage.PROTOCOL_CLASS__INCOMING_MESSAGES:
        getIncomingMessages().clear();
        getIncomingMessages().addAll((Collection<? extends Message>)newValue);
        return;
      case RoomPackage.PROTOCOL_CLASS__OUTGOING_MESSAGES:
        getOutgoingMessages().clear();
        getOutgoingMessages().addAll((Collection<? extends Message>)newValue);
        return;
      case RoomPackage.PROTOCOL_CLASS__REGULAR:
        setRegular((PortClass)newValue);
        return;
      case RoomPackage.PROTOCOL_CLASS__CONJUGATE:
        setConjugate((PortClass)newValue);
        return;
      case RoomPackage.PROTOCOL_CLASS__SEMANTICS:
        setSemantics((ProtocolSemantics)newValue);
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
      case RoomPackage.PROTOCOL_CLASS__COMM_TYPE:
        setCommType(COMM_TYPE_EDEFAULT);
        return;
      case RoomPackage.PROTOCOL_CLASS__BASE:
        setBase((ProtocolClass)null);
        return;
      case RoomPackage.PROTOCOL_CLASS__USER_CODE1:
        setUserCode1((DetailCode)null);
        return;
      case RoomPackage.PROTOCOL_CLASS__USER_CODE2:
        setUserCode2((DetailCode)null);
        return;
      case RoomPackage.PROTOCOL_CLASS__USER_CODE3:
        setUserCode3((DetailCode)null);
        return;
      case RoomPackage.PROTOCOL_CLASS__INCOMING_MESSAGES:
        getIncomingMessages().clear();
        return;
      case RoomPackage.PROTOCOL_CLASS__OUTGOING_MESSAGES:
        getOutgoingMessages().clear();
        return;
      case RoomPackage.PROTOCOL_CLASS__REGULAR:
        setRegular((PortClass)null);
        return;
      case RoomPackage.PROTOCOL_CLASS__CONJUGATE:
        setConjugate((PortClass)null);
        return;
      case RoomPackage.PROTOCOL_CLASS__SEMANTICS:
        setSemantics((ProtocolSemantics)null);
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
      case RoomPackage.PROTOCOL_CLASS__COMM_TYPE:
        return commType != COMM_TYPE_EDEFAULT;
      case RoomPackage.PROTOCOL_CLASS__BASE:
        return base != null;
      case RoomPackage.PROTOCOL_CLASS__USER_CODE1:
        return userCode1 != null;
      case RoomPackage.PROTOCOL_CLASS__USER_CODE2:
        return userCode2 != null;
      case RoomPackage.PROTOCOL_CLASS__USER_CODE3:
        return userCode3 != null;
      case RoomPackage.PROTOCOL_CLASS__INCOMING_MESSAGES:
        return incomingMessages != null && !incomingMessages.isEmpty();
      case RoomPackage.PROTOCOL_CLASS__OUTGOING_MESSAGES:
        return outgoingMessages != null && !outgoingMessages.isEmpty();
      case RoomPackage.PROTOCOL_CLASS__REGULAR:
        return regular != null;
      case RoomPackage.PROTOCOL_CLASS__CONJUGATE:
        return conjugate != null;
      case RoomPackage.PROTOCOL_CLASS__SEMANTICS:
        return semantics != null;
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
    result.append(" (commType: ");
    result.append(commType);
    result.append(')');
    return result.toString();
  }

} //ProtocolClassImpl
