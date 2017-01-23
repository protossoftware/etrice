/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A sub type of {@link DataType} for enumerations.
 * The EnumerationType can be associated with a {@link PrimitiveType} as value type for
 * the {@link EnumLiteral}s. It has to contain at least one literal.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.EnumerationType#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.EnumerationType#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getEnumerationType()
 * @model
 * @generated
 */
public interface EnumerationType extends DataType
{
  /**
   * Returns the value of the '<em><b>Primitive Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The value type of the literals.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Primitive Type</em>' reference.
   * @see #setPrimitiveType(PrimitiveType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getEnumerationType_PrimitiveType()
   * @model
   * @generated
   */
  PrimitiveType getPrimitiveType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.EnumerationType#getPrimitiveType <em>Primitive Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primitive Type</em>' reference.
   * @see #getPrimitiveType()
   * @generated
   */
  void setPrimitiveType(PrimitiveType value);

  /**
   * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.EnumLiteral}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literals</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getEnumerationType_Literals()
   * @model containment="true"
   * @generated
   */
  EList<EnumLiteral> getLiterals();

} // EnumerationType
