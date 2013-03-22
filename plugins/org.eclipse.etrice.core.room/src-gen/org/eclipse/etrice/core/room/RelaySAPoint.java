/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relay SA Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Links from a relay {@link SPPRef} of the actor class.
 * 
 * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is the referenced SPPRef.
   * 
   * <!-- end-model-doc -->
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
