/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tr Point Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.TrPointTerminal#getTrPoint <em>Tr Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getTrPointTerminal()
 * @model
 * @generated
 */
public interface TrPointTerminal extends TransitionTerminal
{
  /**
   * Returns the value of the '<em><b>Tr Point</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tr Point</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tr Point</em>' reference.
   * @see #setTrPoint(TrPoint)
   * @see org.eclipse.etrice.core.room.RoomPackage#getTrPointTerminal_TrPoint()
   * @model
   * @generated
   */
  TrPoint getTrPoint();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.TrPointTerminal#getTrPoint <em>Tr Point</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tr Point</em>' reference.
   * @see #getTrPoint()
   * @generated
   */
  void setTrPoint(TrPoint value);

} // TrPointTerminal
