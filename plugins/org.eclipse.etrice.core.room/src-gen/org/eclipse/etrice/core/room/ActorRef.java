/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A means to compose {@link SubSystemClass}es of {@link ActorClass}es. Each ref will
 * be turned into an actor instance of the referenced type.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ActorRef#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorRef#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getActorRef()
 * @model
 * @generated
 */
public interface ActorRef extends ActorContainerRef
{
  /**
   * Returns the value of the '<em><b>Size</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * If the size is >1 then this is a replicated actor.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Size</em>' attribute.
   * @see #setSize(int)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorRef_Size()
   * @model default="1"
   * @generated
   */
  int getSize();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorRef#getSize <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' attribute.
   * @see #getSize()
   * @generated
   */
  void setSize(int value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is the type (i.e. actor class) of the actor ref.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(ActorClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorRef_Type()
   * @model
   * @generated
   */
  ActorClass getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorRef#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(ActorClass value);

} // ActorRef
