/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A means to compose {@link SubSystemClass}es of {@link ActorClass}es. Each ref will
 * be turned into an actor instance of the referenced type.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ActorRef#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorRef#getMultiplicity <em>Multiplicity</em>}</li>
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
   * Returns the value of the '<em><b>Ref Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.room.ReferenceType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Type</em>' attribute.
   * @see org.eclipse.etrice.core.room.ReferenceType
   * @see #setRefType(ReferenceType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorRef_RefType()
   * @model
   * @generated
   */
  ReferenceType getRefType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorRef#getRefType <em>Ref Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Type</em>' attribute.
   * @see org.eclipse.etrice.core.room.ReferenceType
   * @see #getRefType()
   * @generated
   */
  void setRefType(ReferenceType value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>If the size is >1 then this is a replicated actor.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Multiplicity</em>' attribute.
   * @see #setMultiplicity(int)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorRef_Multiplicity()
   * @model default="1"
   * @generated
   */
  int getMultiplicity();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorRef#getMultiplicity <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' attribute.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(int value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the type (i.e. actor class) of the actor ref.
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
