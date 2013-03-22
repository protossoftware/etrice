/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Layer connections are used to connect {@link SAPRef}s and {@link ServiceImplementation}s.
 * The source is described by a {@link SAPoint} and the target by a {@link SPPoint}.
 * 
 * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is source point of the layer connection.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is target point of the layer connection.
   * 
   * <!-- end-model-doc -->
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
