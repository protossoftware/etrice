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
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.EnumLiteral#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.EnumLiteral#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
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
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this.getLiteral() != null)\n\treturn this.getLiteral().getValue();\n\n// recursively from predecessor\n<%org.eclipse.etrice.core.room.EnumerationType%> et = ((EnumerationType) this.eContainer());\nint idx = et.getLiterals().indexOf(this);\nif (idx > 0)\n\treturn et.getLiterals().get(idx - 1).getLiteralValue() + 1;\n\nreturn 0;\n'"
   * @generated
   */
  long getLiteralValue();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.etrice.core.room.EnumerationType%> et = ((EnumerationType) this.eContainer());\nreturn et.getName() + \".\" + this.getName();\n'"
   * @generated
   */
  String getFullName();

} // EnumLiteral
