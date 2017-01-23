/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.etrice.core.common.base.LiteralType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A primitive type describes a type like int, char, float
 * and can represent the type with a certain precision
 * in the target language
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.PrimitiveType#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.PrimitiveType#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.PrimitiveType#getCastName <em>Cast Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.PrimitiveType#getDefaultValueLiteral <em>Default Value Literal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends DataType
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.common.base.LiteralType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is one of the basic variable types.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.eclipse.etrice.core.common.base.LiteralType
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
   * @see org.eclipse.etrice.core.common.base.LiteralType
   * @see #getType()
   * @generated
   */
  void setType(LiteralType value);

  /**
   * Returns the value of the '<em><b>Target Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the type name in the target language.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This (optional) name is used for casts to this type.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional default value literal.
   * 
   * <!-- end-model-doc -->
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
