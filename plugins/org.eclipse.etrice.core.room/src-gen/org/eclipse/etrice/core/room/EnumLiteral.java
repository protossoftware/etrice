/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.common.base.IntLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A literal value of the enumeration.
 * It can have a value associated.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.EnumLiteral#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.EnumLiteral#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getEnumLiteral()
 * @model
 * @generated
 */
public interface EnumLiteral extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The name of the literal.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getEnumLiteral_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.EnumLiteral#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Literal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The value of the literal. It is associated with a target type which defaults to
   * {@code int} and can be set explicitly using the {@link EnumerationType#getPrimitiveType()}
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Literal</em>' containment reference.
   * @see #setLiteral(IntLiteral)
   * @see org.eclipse.etrice.core.room.RoomPackage#getEnumLiteral_Literal()
   * @model containment="true"
   * @generated
   */
  IntLiteral getLiteral();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.EnumLiteral#getLiteral <em>Literal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal</em>' containment reference.
   * @see #getLiteral()
   * @generated
   */
  void setLiteral(IntLiteral value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this.getLiteral() != null)\r\n\treturn this.getLiteral().getValue();\r\n\r\n// recursively from predecessor\r\n&lt;%org.eclipse.etrice.core.room.EnumerationType%&gt; et = ((EnumerationType) this.eContainer());\r\nint idx = et.getLiterals().indexOf(this);\r\nif (idx &gt; 0)\r\n\treturn et.getLiterals().get(idx - 1).getLiteralValue() + 1;\r\n\r\nreturn 0;\r\n'"
   * @generated
   */
  long getLiteralValue();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.etrice.core.room.EnumerationType%&gt; et = ((EnumerationType) this.eContainer());\r\nreturn et.getName() + \".\" + this.getName();\r\n'"
   * @generated
   */
  String getFullName();

} // EnumLiteral
