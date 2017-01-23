/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A binding end point is a pair of an {@link ActorContainerRef} and a {@link Port} and is used
 * to uniquely describe a port of a sub actor. If the actor container ref is {@code null} then
 * a port of the actor class itself is addressed.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.BindingEndPoint#getActorRef <em>Actor Ref</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.BindingEndPoint#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.BindingEndPoint#getSub <em>Sub</em>}</li>
 * </ul>
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The actor reference holding the bound port or {@code null} in case of a local port.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the bound port.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the bound sub protocol or {@code null} if not applicable.
   * 
   * <!-- end-model-doc -->
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
