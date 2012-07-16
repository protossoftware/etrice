/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Handler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.MessageHandler#getMsg <em>Msg</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.MessageHandler#getDetailCode <em>Detail Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getMessageHandler()
 * @model
 * @generated
 */
public interface MessageHandler extends EObject
{
  /**
   * Returns the value of the '<em><b>Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Msg</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Msg</em>' reference.
   * @see #setMsg(Message)
   * @see org.eclipse.etrice.core.room.RoomPackage#getMessageHandler_Msg()
   * @model
   * @generated
   */
  Message getMsg();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.MessageHandler#getMsg <em>Msg</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Msg</em>' reference.
   * @see #getMsg()
   * @generated
   */
  void setMsg(Message value);

  /**
   * Returns the value of the '<em><b>Detail Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Detail Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Detail Code</em>' containment reference.
   * @see #setDetailCode(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getMessageHandler_DetailCode()
   * @model containment="true"
   * @generated
   */
  DetailCode getDetailCode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.MessageHandler#getDetailCode <em>Detail Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Detail Code</em>' containment reference.
   * @see #getDetailCode()
   * @generated
   */
  void setDetailCode(DetailCode value);

} // MessageHandler
