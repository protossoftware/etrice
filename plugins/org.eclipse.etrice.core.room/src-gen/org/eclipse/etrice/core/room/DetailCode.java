/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Detail Code</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.DetailCode#getCommands <em>Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getDetailCode()
 * @model
 * @generated
 */
public interface DetailCode extends EObject
{
  /**
   * Returns the value of the '<em><b>Commands</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Commands</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Commands</em>' attribute list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getDetailCode_Commands()
   * @model unique="false"
   * @generated
   */
  EList<String> getCommands();

} // DetailCode
