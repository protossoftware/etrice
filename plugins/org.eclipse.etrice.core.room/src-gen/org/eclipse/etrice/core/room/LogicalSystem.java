/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The top level structural class. It can only contain sub systems using {@link SubSystemRef}s.
 * This way the logical system is composed of sub system instances. It also defines
 * {@link Binding}s and {@link LayerConnection}s between those sub systems.
 * 
 * <p>
 * The logical system is the root of the instance tree of the generator model.
 * Each {@link SubSystemRef} is turned into a {@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance} and each
 * {@link ActorRef} is turned into an {@link org.eclipse.etrice.core.genmodel.etricegen.ActorInstance}.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.LogicalSystem#getSubSystems <em>Sub Systems</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getLogicalSystem()
 * @model
 * @generated
 */
public interface LogicalSystem extends StructureClass
{
  /**
   * Returns the value of the '<em><b>Sub Systems</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.SubSystemRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The list of all sub systems contained in the logical system.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Sub Systems</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getLogicalSystem_SubSystems()
   * @model containment="true"
   * @generated
   */
  EList<SubSystemRef> getSubSystems();

} // LogicalSystem
