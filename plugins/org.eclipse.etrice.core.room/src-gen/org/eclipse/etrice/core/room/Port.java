/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.etrice.core.common.base.Documentation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A port defines a part of the interface of an {@link ActorClass} in a specific role.
 * The port is associated with a {@link ProtocolClass}. If it is conjugated then the
 * roles of incoming and outgoing messages of the protocol are inverted.
 * 
 * <p>
 * Ports can have a multiplicity. If it is greater one the port is called replicated.
 * </p>
 * 
 * <p>
 * Whether a port is a relay port or not is a property that is derived from how it is
 * referenced by its {@link ActorClass}:
 * <ul>
 *   <li>ports contained in the actor structure are called <em>internal end ports</em></li>
 *   <li>ports contained in the actor interface and are also referenced by an {@link ExternalPort}
 *      are called <em>external end ports</em></li>
 *   <li>ports contained in the actor interface only are called <em>relay ports</em></li>
 * </ul>
 * Relay ports delegate to sub actors and end ports are connected to the actor's state machine.
 * </p>
 * 
 * @see org.eclipse.etrice.core.room.util.RoomHelpers#isRelay(Port) RoomHelpers.isRelay(Port)
 * @see org.eclipse.etrice.core.room.util.RoomHelpers#isInternal(Port) RoomHelpers.isInternal(Port)
 * @see org.eclipse.etrice.core.room.util.RoomHelpers#isExternal(Port) RoomHelpers.isExternal(Port)
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.Port#isConjugated <em>Conjugated</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Port#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Port#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Port#getDocu <em>Docu</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getPort()
 * @model
 * @generated
 */
public interface Port extends InterfaceItem
{
  /**
   * Returns the value of the '<em><b>Conjugated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>If a port is conjugated then the roles of outgoing and incoming messages are interchanged.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Conjugated</em>' attribute.
   * @see #setConjugated(boolean)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPort_Conjugated()
   * @model
   * @generated
   */
  boolean isConjugated();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Port#isConjugated <em>Conjugated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conjugated</em>' attribute.
   * @see #isConjugated()
   * @generated
   */
  void setConjugated(boolean value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>Ports with multiplicity >1 are called relay ports. A multiplicity of {@code -1} means replicated
   * port with arbitrary multiplicity.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Multiplicity</em>' attribute.
   * @see #setMultiplicity(int)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPort_Multiplicity()
   * @model default="1"
   * @generated
   */
  int getMultiplicity();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Port#getMultiplicity <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' attribute.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(int value);

  /**
   * Returns the value of the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the port's protocol class.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Protocol</em>' reference.
   * @see #setProtocol(GeneralProtocolClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPort_Protocol()
   * @model
   * @generated
   */
  GeneralProtocolClass getProtocol();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Port#getProtocol <em>Protocol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Protocol</em>' reference.
   * @see #getProtocol()
   * @generated
   */
  void setProtocol(GeneralProtocolClass value);

  /**
   * Returns the value of the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional documentation.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Docu</em>' containment reference.
   * @see #setDocu(Documentation)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPort_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Port#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return multiplicity>1 || multiplicity==-1;'"
   * @generated
   */
  boolean isReplicated();

} // Port
