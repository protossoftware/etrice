/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.SubSystemClass#getRelayPorts <em>Relay Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.SubSystemClass#getThreads <em>Threads</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.SubSystemClass#getActorInstanceMappings <em>Actor Instance Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getSubSystemClass()
 * @model
 * @generated
 */
public interface SubSystemClass extends ActorContainerClass
{
  /**
   * Returns the value of the '<em><b>Relay Ports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relay Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relay Ports</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getSubSystemClass_RelayPorts()
   * @model containment="true"
   * @generated
   */
  EList<Port> getRelayPorts();

  /**
   * Returns the value of the '<em><b>Threads</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.LogicalThread}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Threads</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Threads</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getSubSystemClass_Threads()
   * @model containment="true"
   * @generated
   */
  EList<LogicalThread> getThreads();

  /**
   * Returns the value of the '<em><b>Actor Instance Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ActorInstanceMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor Instance Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actor Instance Mappings</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getSubSystemClass_ActorInstanceMappings()
   * @model containment="true"
   * @generated
   */
  EList<ActorInstanceMapping> getActorInstanceMappings();

} // SubSystemClass
