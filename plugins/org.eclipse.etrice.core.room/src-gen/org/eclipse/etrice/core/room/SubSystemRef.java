/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A means to compose {@link LogicalSystem}s of {@link SubSystemClass}es. Each ref will
 * be turned into a sub system instance of the referenced type.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.SubSystemRef#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getSubSystemRef()
 * @model
 * @generated
 */
public interface SubSystemRef extends ActorContainerRef
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The type of the reference.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(SubSystemClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getSubSystemRef_Type()
   * @model
   * @generated
   */
  SubSystemClass getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.SubSystemRef#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(SubSystemClass value);

} // SubSystemRef
