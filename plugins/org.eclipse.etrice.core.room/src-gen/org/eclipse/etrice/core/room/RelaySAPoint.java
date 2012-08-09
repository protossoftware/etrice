/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relay SA Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RelaySAPoint#getRelay <em>Relay</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRelaySAPoint()
 * @model
 * @generated
 */
public interface RelaySAPoint extends SAPoint
{
  /**
   * Returns the value of the '<em><b>Relay</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relay</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relay</em>' reference.
   * @see #setRelay(SPPRef)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRelaySAPoint_Relay()
   * @model
   * @generated
   */
  SPPRef getRelay();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RelaySAPoint#getRelay <em>Relay</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relay</em>' reference.
   * @see #getRelay()
   * @generated
   */
  void setRelay(SPPRef value);

} // RelaySAPoint
