/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.BindingEndPoint#getActorRef <em>Actor Ref</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.BindingEndPoint#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.BindingEndPoint#getSub <em>Sub</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getBindingEndPoint()
 * @model
 * @generated
 */
public interface BindingEndPoint extends EObject
{
  /**
   * Returns the value of the '<em><b>Actor Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actor Ref</em>' reference.
   * @see #setActorRef(ActorContainerRef)
   * @see org.eclipse.etrice.core.room.RoomPackage#getBindingEndPoint_ActorRef()
   * @model
   * @generated
   */
  ActorContainerRef getActorRef();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.BindingEndPoint#getActorRef <em>Actor Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actor Ref</em>' reference.
   * @see #getActorRef()
   * @generated
   */
  void setActorRef(ActorContainerRef value);

  /**
   * Returns the value of the '<em><b>Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port</em>' reference.
   * @see #setPort(Port)
   * @see org.eclipse.etrice.core.room.RoomPackage#getBindingEndPoint_Port()
   * @model
   * @generated
   */
  Port getPort();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.BindingEndPoint#getPort <em>Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port</em>' reference.
   * @see #getPort()
   * @generated
   */
  void setPort(Port value);

  /**
   * Returns the value of the '<em><b>Sub</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub</em>' reference.
   * @see #setSub(SubProtocol)
   * @see org.eclipse.etrice.core.room.RoomPackage#getBindingEndPoint_Sub()
   * @model
   * @generated
   */
  SubProtocol getSub();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.BindingEndPoint#getSub <em>Sub</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub</em>' reference.
   * @see #getSub()
   * @generated
   */
  void setSub(SubProtocol value);

} // BindingEndPoint
