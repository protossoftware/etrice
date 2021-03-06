/**
 * generated by Xtext
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A path of strings that are interpreted as {@link org.eclipse.etrice.core.room.ActorRef}s starting at a {@link org.eclipse.etrice.core.room.SubSystemClass}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RefPath#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRefPath()
 * @model
 * @generated
 */
public interface RefPath extends RoomElement
{
  /**
   * Returns the value of the '<em><b>Refs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.RefSegment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a path in the instance tree where each segment corresponds to the name of the
   * corresponding {@link ActorContainerRef}.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Refs</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefPath_Refs()
   * @model containment="true"
   * @generated
   */
  EList<RefSegment> getRefs();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  String toString();

} // RefPath
