/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub State Tr Point Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The terminal point (source or target) of a transition ending
 * at a {@link TrPoint} of a sub {@link State}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.SubStateTrPointTerminal#getTrPoint <em>Tr Point</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.SubStateTrPointTerminal#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getSubStateTrPointTerminal()
 * @model
 * @generated
 */
public interface SubStateTrPointTerminal extends TransitionTerminal
{
  /**
   * Returns the value of the '<em><b>Tr Point</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the target entry or exit point contained in the target state.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Tr Point</em>' reference.
   * @see #setTrPoint(TrPoint)
   * @see org.eclipse.etrice.core.room.RoomPackage#getSubStateTrPointTerminal_TrPoint()
   * @model
   * @generated
   */
  TrPoint getTrPoint();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.SubStateTrPointTerminal#getTrPoint <em>Tr Point</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tr Point</em>' reference.
   * @see #getTrPoint()
   * @generated
   */
  void setTrPoint(TrPoint value);

  /**
   * Returns the value of the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the target state.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>State</em>' reference.
   * @see #setState(State)
   * @see org.eclipse.etrice.core.room.RoomPackage#getSubStateTrPointTerminal_State()
   * @model
   * @generated
   */
  State getState();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.SubStateTrPointTerminal#getState <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' reference.
   * @see #getState()
   * @generated
   */
  void setState(State value);

} // SubStateTrPointTerminal
