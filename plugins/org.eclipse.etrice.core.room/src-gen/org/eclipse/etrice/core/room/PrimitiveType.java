/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.PrimitiveType#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.PrimitiveType#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.PrimitiveType#getCastName <em>Cast Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.PrimitiveType#getDefaultValueLiteral <em>Default Value Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends DataType
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.room.LiteralType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.eclipse.etrice.core.room.LiteralType
   * @see #setType(LiteralType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPrimitiveType_Type()
   * @model
   * @generated
   */
  LiteralType getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.PrimitiveType#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.eclipse.etrice.core.room.LiteralType
   * @see #getType()
   * @generated
   */
  void setType(LiteralType value);

  /**
   * Returns the value of the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Name</em>' attribute.
   * @see #setTargetName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPrimitiveType_TargetName()
   * @model
   * @generated
   */
  String getTargetName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.PrimitiveType#getTargetName <em>Target Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Name</em>' attribute.
   * @see #getTargetName()
   * @generated
   */
  void setTargetName(String value);

  /**
   * Returns the value of the '<em><b>Cast Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cast Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cast Name</em>' attribute.
   * @see #setCastName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPrimitiveType_CastName()
   * @model
   * @generated
   */
  String getCastName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.PrimitiveType#getCastName <em>Cast Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cast Name</em>' attribute.
   * @see #getCastName()
   * @generated
   */
  void setCastName(String value);

  /**
   * Returns the value of the '<em><b>Default Value Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Value Literal</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Value Literal</em>' attribute.
   * @see #setDefaultValueLiteral(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPrimitiveType_DefaultValueLiteral()
   * @model
   * @generated
   */
  String getDefaultValueLiteral();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.PrimitiveType#getDefaultValueLiteral <em>Default Value Literal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Value Literal</em>' attribute.
   * @see #getDefaultValueLiteral()
   * @generated
   */
  void setDefaultValueLiteral(String value);

} // PrimitiveType
