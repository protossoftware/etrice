/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A service access point is similar to a {@link Port} but is not explicitly bound to a peer.
 * Rather, it is bound to a {@link ServiceImplementation} which is connected to one of the
 * containing actors.
 * 
 * <p>
 * An SAP is associated with a {@link ProtocolClass} and is conjugate to this protocol.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.SAP#getProtocol <em>Protocol</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getSAP()
 * @model
 * @generated
 */
public interface SAP extends InterfaceItem
{
  /**
   * Returns the value of the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the SAP's protocol class.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Protocol</em>' reference.
   * @see #setProtocol(ProtocolClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getSAP_Protocol()
   * @model
   * @generated
   */
  ProtocolClass getProtocol();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.SAP#getProtocol <em>Protocol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Protocol</em>' reference.
   * @see #getProtocol()
   * @generated
   */
  void setProtocol(ProtocolClass value);

} // SAP
