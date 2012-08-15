/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical System</b></em>'.
 * <!-- end-user-doc -->
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
   * <p>
   * If the meaning of the '<em>Sub Systems</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Systems</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getLogicalSystem_SubSystems()
   * @model containment="true"
   * @generated
   */
  EList<SubSystemRef> getSubSystems();

} // LogicalSystem
