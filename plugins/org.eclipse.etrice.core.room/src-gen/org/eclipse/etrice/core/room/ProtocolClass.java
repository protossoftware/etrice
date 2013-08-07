/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>Together with {@link ActorClass} and {@link DataClass} one of
 * the main class types of the ROOM language.
 * <p>
 * A protocol class specifies a directed {@link Port} interface
 * by two sets of {@link Message}s: incoming and outgoing.
 * </p>
 * <p>
 * A protocol class can derive from a base class (single inheritance).
 * In this case it must only extend <em>one</em> of the message sets:
 * incoming <em>or</em> outgoing.
 * </p>
 * <p>
 * Optionally {@link PortClass}es may be defined for regular and
 * conjugate {@link Port}s. These classes can be used to add specific
 * behavior e.g. by adding message handlers. This kind of felxibility
 * can be used in particular for the efficient implementation of
 * services (SAPs and SPPs).
 * </p>
 * <p>
 * Last not least a so called 'legal execution tree' can be specified
 * using {@link ProtocolSemantics}.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getCommType <em>Comm Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getUserCode1 <em>User Code1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getUserCode2 <em>User Code2</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getUserCode3 <em>User Code3</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getIncomingMessages <em>Incoming Messages</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getOutgoingMessages <em>Outgoing Messages</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getRegular <em>Regular</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getConjugated <em>Conjugated</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ProtocolClass#getSemantics <em>Semantics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass()
 * @model
 * @generated
 */
public interface ProtocolClass extends GeneralProtocolClass
{
  /**
   * Returns the value of the '<em><b>Comm Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.room.CommunicationType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the communication type of the protocol.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Comm Type</em>' attribute.
   * @see org.eclipse.etrice.core.room.CommunicationType
   * @see #setCommType(CommunicationType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_CommType()
   * @model
   * @generated
   */
  CommunicationType getCommType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ProtocolClass#getCommType <em>Comm Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comm Type</em>' attribute.
   * @see org.eclipse.etrice.core.room.CommunicationType
   * @see #getCommType()
   * @generated
   */
  void setCommType(CommunicationType value);

  /**
   * Returns the value of the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The base class from which all messages are inherited.
   * The port classes and the semantics are not inherited.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Base</em>' reference.
   * @see #setBase(ProtocolClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_Base()
   * @model
   * @generated
   */
  ProtocolClass getBase();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ProtocolClass#getBase <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' reference.
   * @see #getBase()
   * @generated
   */
  void setBase(ProtocolClass value);

  /**
   * Returns the value of the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The user code is treated in a generator dependent way.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>User Code1</em>' containment reference.
   * @see #setUserCode1(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_UserCode1()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode1();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ProtocolClass#getUserCode1 <em>User Code1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code1</em>' containment reference.
   * @see #getUserCode1()
   * @generated
   */
  void setUserCode1(DetailCode value);

  /**
   * Returns the value of the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The user code is treated in a generator dependent way.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>User Code2</em>' containment reference.
   * @see #setUserCode2(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_UserCode2()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode2();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ProtocolClass#getUserCode2 <em>User Code2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code2</em>' containment reference.
   * @see #getUserCode2()
   * @generated
   */
  void setUserCode2(DetailCode value);

  /**
   * Returns the value of the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The user code is treated in a generator dependent way.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>User Code3</em>' containment reference.
   * @see #setUserCode3(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_UserCode3()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode3();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ProtocolClass#getUserCode3 <em>User Code3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code3</em>' containment reference.
   * @see #getUserCode3()
   * @generated
   */
  void setUserCode3(DetailCode value);

  /**
   * Returns the value of the '<em><b>Incoming Messages</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Message}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the set of incoming messages of this protocol.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Incoming Messages</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_IncomingMessages()
   * @model containment="true"
   * @generated
   */
  EList<Message> getIncomingMessages();

  /**
   * Returns the value of the '<em><b>Outgoing Messages</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Message}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the set of outgoing messages of this protocol.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Outgoing Messages</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_OutgoingMessages()
   * @model containment="true"
   * @generated
   */
  EList<Message> getOutgoingMessages();

  /**
   * Returns the value of the '<em><b>Regular</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the optional regular port class specification.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Regular</em>' containment reference.
   * @see #setRegular(PortClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_Regular()
   * @model containment="true"
   * @generated
   */
  PortClass getRegular();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ProtocolClass#getRegular <em>Regular</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Regular</em>' containment reference.
   * @see #getRegular()
   * @generated
   */
  void setRegular(PortClass value);

  /**
   * Returns the value of the '<em><b>Conjugated</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the optional conjugate port class specification.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Conjugated</em>' containment reference.
   * @see #setConjugated(PortClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_Conjugated()
   * @model containment="true"
   * @generated
   */
  PortClass getConjugated();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ProtocolClass#getConjugated <em>Conjugated</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conjugated</em>' containment reference.
   * @see #getConjugated()
   * @generated
   */
  void setConjugated(PortClass value);

  /**
   * Returns the value of the '<em><b>Semantics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the optional semantics specification for this protocol.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Semantics</em>' containment reference.
   * @see #setSemantics(ProtocolSemantics)
   * @see org.eclipse.etrice.core.room.RoomPackage#getProtocolClass_Semantics()
   * @model containment="true"
   * @generated
   */
  ProtocolSemantics getSemantics();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ProtocolClass#getSemantics <em>Semantics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Semantics</em>' containment reference.
   * @see #getSemantics()
   * @generated
   */
  void setSemantics(ProtocolSemantics value);

} // ProtocolClass
