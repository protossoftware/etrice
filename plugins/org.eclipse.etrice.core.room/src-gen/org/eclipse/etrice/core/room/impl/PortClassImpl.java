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

import org.eclipse.etrice.core.fsm.fSM.DetailCode;

import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.PortClassImpl#getUserCode <em>User Code</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.PortClassImpl#getMsgHandlers <em>Msg Handlers</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.PortClassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.PortClassImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortClassImpl extends MinimalEObjectImpl.Container implements PortClass
{
  /**
   * The cached value of the '{@link #getUserCode() <em>User Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCode()
   * @generated
   * @ordered
   */
  protected DetailCode userCode;

  /**
   * The cached value of the '{@link #getMsgHandlers() <em>Msg Handlers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsgHandlers()
   * @generated
   * @ordered
   */
  protected EList<MessageHandler> msgHandlers;

  /**
   * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperations()
   * @generated
   * @ordered
   */
  protected EList<PortOperation> operations;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PortClassImpl()
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
    return RoomPackage.Literals.PORT_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DetailCode getUserCode()
  {
    return userCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUserCode(DetailCode newUserCode, NotificationChain msgs)
  {
    DetailCode oldUserCode = userCode;
    userCode = newUserCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.PORT_CLASS__USER_CODE, oldUserCode, newUserCode);
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
  public void setUserCode(DetailCode newUserCode)
  {
    if (newUserCode != userCode)
    {
      NotificationChain msgs = null;
      if (userCode != null)
        msgs = ((InternalEObject)userCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PORT_CLASS__USER_CODE, null, msgs);
      if (newUserCode != null)
        msgs = ((InternalEObject)newUserCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.PORT_CLASS__USER_CODE, null, msgs);
      msgs = basicSetUserCode(newUserCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.PORT_CLASS__USER_CODE, newUserCode, newUserCode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<MessageHandler> getMsgHandlers()
  {
    if (msgHandlers == null)
    {
      msgHandlers = new EObjectContainmentEList<MessageHandler>(MessageHandler.class, this, RoomPackage.PORT_CLASS__MSG_HANDLERS);
    }
    return msgHandlers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PortOperation> getOperations()
  {
    if (operations == null)
    {
      operations = new EObjectContainmentEList<PortOperation>(PortOperation.class, this, RoomPackage.PORT_CLASS__OPERATIONS);
    }
    return operations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, RoomPackage.PORT_CLASS__ATTRIBUTES);
    }
    return attributes;
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
      case RoomPackage.PORT_CLASS__USER_CODE:
        return basicSetUserCode(null, msgs);
      case RoomPackage.PORT_CLASS__MSG_HANDLERS:
        return ((InternalEList<?>)getMsgHandlers()).basicRemove(otherEnd, msgs);
      case RoomPackage.PORT_CLASS__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
      case RoomPackage.PORT_CLASS__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
      case RoomPackage.PORT_CLASS__USER_CODE:
        return getUserCode();
      case RoomPackage.PORT_CLASS__MSG_HANDLERS:
        return getMsgHandlers();
      case RoomPackage.PORT_CLASS__OPERATIONS:
        return getOperations();
      case RoomPackage.PORT_CLASS__ATTRIBUTES:
        return getAttributes();
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
      case RoomPackage.PORT_CLASS__USER_CODE:
        setUserCode((DetailCode)newValue);
        return;
      case RoomPackage.PORT_CLASS__MSG_HANDLERS:
        getMsgHandlers().clear();
        getMsgHandlers().addAll((Collection<? extends MessageHandler>)newValue);
        return;
      case RoomPackage.PORT_CLASS__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends PortOperation>)newValue);
        return;
      case RoomPackage.PORT_CLASS__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
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
      case RoomPackage.PORT_CLASS__USER_CODE:
        setUserCode((DetailCode)null);
        return;
      case RoomPackage.PORT_CLASS__MSG_HANDLERS:
        getMsgHandlers().clear();
        return;
      case RoomPackage.PORT_CLASS__OPERATIONS:
        getOperations().clear();
        return;
      case RoomPackage.PORT_CLASS__ATTRIBUTES:
        getAttributes().clear();
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
      case RoomPackage.PORT_CLASS__USER_CODE:
        return userCode != null;
      case RoomPackage.PORT_CLASS__MSG_HANDLERS:
        return msgHandlers != null && !msgHandlers.isEmpty();
      case RoomPackage.PORT_CLASS__OPERATIONS:
        return operations != null && !operations.isEmpty();
      case RoomPackage.PORT_CLASS__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PortClassImpl
