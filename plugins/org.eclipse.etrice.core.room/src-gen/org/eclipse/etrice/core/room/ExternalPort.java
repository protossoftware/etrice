/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>An external port is part of the actor structure and references an interface port.
 * An interface port which is referenced by an external port is an external end port.
 * If it is not referenced it is a relay port.
 * 
 * @see {@link Port}
 * 
 * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the referenced interface port of the actor class which is now an external end port.
   * 
   * <!-- end-model-doc -->
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
