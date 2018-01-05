/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.MessageData#getDeprecatedName <em>Deprecated Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.MessageData#getRefType <em>Ref Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getMessageData()
 * @model
 * @generated
 */
public interface MessageData extends EObject
{
  /**
   * Returns the value of the '<em><b>Deprecated Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deprecated Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deprecated Name</em>' attribute.
   * @see #setDeprecatedName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getMessageData_DeprecatedName()
   * @model
   * @generated
   */
  String getDeprecatedName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.MessageData#getDeprecatedName <em>Deprecated Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deprecated Name</em>' attribute.
   * @see #getDeprecatedName()
   * @generated
   */
  void setDeprecatedName(String value);

  /**
   * Returns the value of the '<em><b>Ref Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Type</em>' containment reference.
   * @see #setRefType(RefableType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getMessageData_RefType()
   * @model containment="true"
   * @generated
   */
  RefableType getRefType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.MessageData#getRefType <em>Ref Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Type</em>' containment reference.
   * @see #getRefType()
   * @generated
   */
  void setRefType(RefableType value);

} // MessageData
