/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SPP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A service provision point is used to connect an actor class with a {@link ServiceImplementation}.
 * It can (similar to relay ports) delegate to another actor class (using a {@link LayerConnection})
 * or connect to a {@link ServiceImplementation} of its actor class.
 * 
 * <p>
 * An SPP is associated with a {@link ProtocolClass} and is regular to this protocol.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.SPP#getProtocol <em>Protocol</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getSPP()
 * @model
 * @generated
 */
public interface SPP extends InterfaceItem
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
   * @see org.eclipse.etrice.core.room.RoomPackage#getSPP_Protocol()
   * @model
   * @generated
   */
  ProtocolClass getProtocol();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.SPP#getProtocol <em>Protocol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Protocol</em>' reference.
   * @see #getProtocol()
   * @generated
   */
  void setProtocol(ProtocolClass value);

} // SPP
