/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ExternalPort#getIfport <em>Ifport</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getExternalPort()
 * @model
 * @generated
 */
public interface ExternalPort extends EObject
{
  /**
   * Returns the value of the '<em><b>Ifport</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ifport</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ifport</em>' reference.
   * @see #setIfport(Port)
   * @see org.eclipse.etrice.core.room.RoomPackage#getExternalPort_Ifport()
   * @model
   * @generated
   */
  Port getIfport();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ExternalPort#getIfport <em>Ifport</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ifport</em>' reference.
   * @see #getIfport()
   * @generated
   */
  void setIfport(Port value);

} // ExternalPort
