/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The standard form of an operation as used by
 * {@link ActorClass} and {@link DataClass}.
 * <p>
 * If the name coincides with it's containing classes name
 * then it is a constructor (with void return type).
 * If the name additionally is preceded by a tilde ~ then it
 * is a destructor.
 * </p>
 * <p>
 * The operation has a list of {@link VarDecl} arguments, an
 * optional return {@link RefableType} and a body (specified
 * as {@link DetailCode}).
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.StandardOperation#isDestructor <em>Destructor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getStandardOperation()
 * @model
 * @generated
 */
public interface StandardOperation extends Operation
{
  /**
   * Returns the value of the '<em><b>Destructor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * If this flag is {@code true} <em>and</em> the name conincides with the class name
   * it is treated as a destructor.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Destructor</em>' attribute.
   * @see #setDestructor(boolean)
   * @see org.eclipse.etrice.core.room.RoomPackage#getStandardOperation_Destructor()
   * @model
   * @generated
   */
  boolean isDestructor();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.StandardOperation#isDestructor <em>Destructor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Destructor</em>' attribute.
   * @see #isDestructor()
   * @generated
   */
  void setDestructor(boolean value);

} // StandardOperation
