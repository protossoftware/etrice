/**
 */
package org.eclipse.etrice.core.room.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SubProtocol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.BindingEndPointImpl#getActorRef <em>Actor Ref</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.BindingEndPointImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.BindingEndPointImpl#getSub <em>Sub</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingEndPointImpl extends MinimalEObjectImpl.Container implements BindingEndPoint
{
  /**
   * The cached value of the '{@link #getActorRef() <em>Actor Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActorRef()
   * @generated
   * @ordered
   */
  protected ActorContainerRef actorRef;

  /**
   * The cached value of the '{@link #getPort() <em>Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPort()
   * @generated
   * @ordered
   */
  protected Port port;

  /**
   * The cached value of the '{@link #getSub() <em>Sub</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSub()
   * @generated
   * @ordered
   */
  protected SubProtocol sub;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BindingEndPointImpl()
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
    return RoomPackage.Literals.BINDING_END_POINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorContainerRef getActorRef()
  {
    if (actorRef != null && actorRef.eIsProxy())
    {
      InternalEObject oldActorRef = (InternalEObject)actorRef;
      actorRef = (ActorContainerRef)eResolveProxy(oldActorRef);
      if (actorRef != oldActorRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.BINDING_END_POINT__ACTOR_REF, oldActorRef, actorRef));
      }
    }
    return actorRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActorContainerRef basicGetActorRef()
  {
    return actorRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActorRef(ActorContainerRef newActorRef)
  {
    ActorContainerRef oldActorRef = actorRef;
    actorRef = newActorRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.BINDING_END_POINT__ACTOR_REF, oldActorRef, actorRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port getPort()
  {
    if (port != null && port.eIsProxy())
    {
      InternalEObject oldPort = (InternalEObject)port;
      port = (Port)eResolveProxy(oldPort);
      if (port != oldPort)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.BINDING_END_POINT__PORT, oldPort, port));
      }
    }
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port basicGetPort()
  {
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPort(Port newPort)
  {
    Port oldPort = port;
    port = newPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.BINDING_END_POINT__PORT, oldPort, port));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubProtocol getSub()
  {
    if (sub != null && sub.eIsProxy())
    {
      InternalEObject oldSub = (InternalEObject)sub;
      sub = (SubProtocol)eResolveProxy(oldSub);
      if (sub != oldSub)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.BINDING_END_POINT__SUB, oldSub, sub));
      }
    }
    return sub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubProtocol basicGetSub()
  {
    return sub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSub(SubProtocol newSub)
  {
    SubProtocol oldSub = sub;
    sub = newSub;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.BINDING_END_POINT__SUB, oldSub, sub));
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
      case RoomPackage.BINDING_END_POINT__ACTOR_REF:
        if (resolve) return getActorRef();
        return basicGetActorRef();
      case RoomPackage.BINDING_END_POINT__PORT:
        if (resolve) return getPort();
        return basicGetPort();
      case RoomPackage.BINDING_END_POINT__SUB:
        if (resolve) return getSub();
        return basicGetSub();
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
      case RoomPackage.BINDING_END_POINT__ACTOR_REF:
        setActorRef((ActorContainerRef)newValue);
        return;
      case RoomPackage.BINDING_END_POINT__PORT:
        setPort((Port)newValue);
        return;
      case RoomPackage.BINDING_END_POINT__SUB:
        setSub((SubProtocol)newValue);
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
      case RoomPackage.BINDING_END_POINT__ACTOR_REF:
        setActorRef((ActorContainerRef)null);
        return;
      case RoomPackage.BINDING_END_POINT__PORT:
        setPort((Port)null);
        return;
      case RoomPackage.BINDING_END_POINT__SUB:
        setSub((SubProtocol)null);
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
      case RoomPackage.BINDING_END_POINT__ACTOR_REF:
        return actorRef != null;
      case RoomPackage.BINDING_END_POINT__PORT:
        return port != null;
      case RoomPackage.BINDING_END_POINT__SUB:
        return sub != null;
    }
    return super.eIsSet(featureID);
  }

} //BindingEndPointImpl
