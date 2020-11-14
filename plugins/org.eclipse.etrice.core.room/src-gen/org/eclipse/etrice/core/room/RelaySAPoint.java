/**
 * generated by Xtext
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relay SA Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>Links from a relay {@link SPP} of the actor class.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RelaySAPoint#getRelay <em>Relay</em>}</li>
 * </ul>
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
   * <br>This is the referenced SPP.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Relay</em>' reference.
   * @see #setRelay(SPP)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRelaySAPoint_Relay()
   * @model
   * @generated
   */
  SPP getRelay();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RelaySAPoint#getRelay <em>Relay</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relay</em>' reference.
   * @see #getRelay()
   * @generated
   */
  void setRelay(SPP value);

} // RelaySAPoint
