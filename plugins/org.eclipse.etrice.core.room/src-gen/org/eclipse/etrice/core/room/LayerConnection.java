/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.LayerConnection#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.LayerConnection#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getLayerConnection()
 * @model
 * @generated
 */
public interface LayerConnection extends EObject
{
  /**
   * Returns the value of the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From</em>' containment reference.
   * @see #setFrom(SAPoint)
   * @see org.eclipse.etrice.core.room.RoomPackage#getLayerConnection_From()
   * @model containment="true"
   * @generated
   */
  SAPoint getFrom();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.LayerConnection#getFrom <em>From</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' containment reference.
   * @see #getFrom()
   * @generated
   */
  void setFrom(SAPoint value);

  /**
   * Returns the value of the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' containment reference.
   * @see #setTo(SPPoint)
   * @see org.eclipse.etrice.core.room.RoomPackage#getLayerConnection_To()
   * @model containment="true"
   * @generated
   */
  SPPoint getTo();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.LayerConnection#getTo <em>To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' containment reference.
   * @see #getTo()
   * @generated
   */
  void setTo(SPPoint value);

} // LayerConnection
