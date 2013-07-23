/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A sub system class corresponds to a process with a separate address space.
 * It has no behavior of its own and is composed of {@link ActorClass}es.
 * 
 * <p>
 * Sub systems can be connected using {@link Port}s and {@link Binding}s.
 * All ports of a sub system are relay ports.
 * </p>
 * 
 * <p>
 * Sub systems can define an arbitrary number of logical threads onto which their actor
 * instances are mapped.
 * </p>
 * 
 * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all relay ports of the sub system.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all actor instance mappings of the sub system.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of actor instance mappings.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Actor Instance Mappings</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getSubSystemClass_ActorInstanceMappings()
   * @model containment="true"
   * @generated
   */
  EList<ActorInstanceMapping> getActorInstanceMappings();

} // SubSystemClass
