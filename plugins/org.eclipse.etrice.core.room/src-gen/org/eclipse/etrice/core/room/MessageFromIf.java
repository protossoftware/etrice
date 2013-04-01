/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message From If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A pair consisting of a {@link Message} arising from an
 * {@link InterfaceItem}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.MessageFromIf#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.MessageFromIf#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getMessageFromIf()
 * @model
 * @generated
 */
public interface MessageFromIf extends EObject
{
  /**
   * Returns the value of the '<em><b>Message</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the triggerering message (or event).
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Message</em>' reference.
   * @see #setMessage(Message)
   * @see org.eclipse.etrice.core.room.RoomPackage#getMessageFromIf_Message()
   * @model
   * @generated
   */
  Message getMessage();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.MessageFromIf#getMessage <em>Message</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' reference.
   * @see #getMessage()
   * @generated
   */
  void setMessage(Message value);

  /**
   * Returns the value of the '<em><b>From</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the interface item where the message occurred.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>From</em>' reference.
   * @see #setFrom(InterfaceItem)
   * @see org.eclipse.etrice.core.room.RoomPackage#getMessageFromIf_From()
   * @model
   * @generated
   */
  InterfaceItem getFrom();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.MessageFromIf#getFrom <em>From</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' reference.
   * @see #getFrom()
   * @generated
   */
  void setFrom(InterfaceItem value);

} // MessageFromIf
