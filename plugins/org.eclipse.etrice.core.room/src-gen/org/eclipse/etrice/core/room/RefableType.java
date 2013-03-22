/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refable Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is a type with an optional reference attribute.
 * If 'ref' is {@code true} then by reference semantic is chosen.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RefableType#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RefableType#isRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRefableType()
 * @model
 * @generated
 */
public interface RefableType extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is the data type.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(DataType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefableType_Type()
   * @model
   * @generated
   */
  DataType getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefableType#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(DataType value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * If {@code true} then by reference semantics is chosen, by value semantics else.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ref</em>' attribute.
   * @see #setRef(boolean)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefableType_Ref()
   * @model
   * @generated
   */
  boolean isRef();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefableType#isRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #isRef()
   * @generated
   */
  void setRef(boolean value);

} // RefableType
