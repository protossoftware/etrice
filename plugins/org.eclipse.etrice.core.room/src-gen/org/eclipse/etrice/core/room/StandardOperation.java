/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Operation</b></em>'.
 * <!-- end-user-doc -->
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
   * <p>
   * If the meaning of the '<em>Destructor</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
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
