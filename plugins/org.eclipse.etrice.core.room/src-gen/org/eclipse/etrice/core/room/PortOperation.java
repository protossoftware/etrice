/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The port operation is very similar to the {@link StandardOperation}
 * and is used in the {@link PortClass}.
 * <p>
 * Optionally a {@link Message} can be specified which is sent
 * when the method is invoked. For this reason these operations
 * are also shown in the 'messages' dialog of the behavior editor.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.PortOperation#getSendsMsg <em>Sends Msg</em>}</li>
 * </ul>
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This optional reference to a message means that the operation sends a message.
   * 
   * <!-- end-model-doc -->
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
