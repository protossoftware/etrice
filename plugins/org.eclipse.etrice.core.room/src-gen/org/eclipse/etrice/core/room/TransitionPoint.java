/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.TransitionPoint#isHandler <em>Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getTransitionPoint()
 * @model
 * @generated
 */
public interface TransitionPoint extends TrPoint
{
  /**
   * Returns the value of the '<em><b>Handler</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Handler</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Handler</em>' attribute.
   * @see #setHandler(boolean)
   * @see org.eclipse.etrice.core.room.RoomPackage#getTransitionPoint_Handler()
   * @model
   * @generated
   */
  boolean isHandler();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.TransitionPoint#isHandler <em>Handler</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Handler</em>' attribute.
   * @see #isHandler()
   * @generated
   */
  void setHandler(boolean value);

} // TransitionPoint
