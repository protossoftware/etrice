/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Annotation Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.SimpleAnnotationAttribute#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getSimpleAnnotationAttribute()
 * @model
 * @generated
 */
public interface SimpleAnnotationAttribute extends AnnotationAttribute
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
   * @see org.eclipse.etrice.core.room.RoomPackage#getSimpleAnnotationAttribute_Type()
   * @model
   * @generated
   */
  LiteralType getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.SimpleAnnotationAttribute#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.eclipse.etrice.core.room.LiteralType
   * @see #getType()
   * @generated
   */
  void setType(LiteralType value);

} // SimpleAnnotationAttribute
