/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.PortOperation#getSendsMsg <em>Sends Msg</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getPortOperation()
 * @model
 * @generated
 */
public interface PortOperation extends Operation
{
  /**
   * Returns the value of the '<em><b>Sends Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sends Msg</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sends Msg</em>' reference.
   * @see #setSendsMsg(Message)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPortOperation_SendsMsg()
   * @model
   * @generated
   */
  Message getSendsMsg();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.PortOperation#getSendsMsg <em>Sends Msg</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sends Msg</em>' reference.
   * @see #getSendsMsg()
   * @generated
   */
  void setSendsMsg(Message value);

} // PortOperation
