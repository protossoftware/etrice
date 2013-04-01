/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A path of strings that are interpreted as {@link ActorRef}s starting at a {@link SubSystemClass}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RefPath#getRefs <em>Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRefPath()
 * @model
 * @generated
 */
public interface RefPath extends EObject
{
  /**
   * Returns the value of the '<em><b>Refs</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a path in the instance tree where each segment corresponds to the name of the
   * corresponding {@link ActorContainerRef}.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Refs</em>' attribute list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefPath_Refs()
   * @model unique="false"
   * @generated
   */
  EList<String> getRefs();

} // RefPath
