/**
 */
package org.eclipse.etrice.core.common.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Annotation Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>An {@link AnnotationAttribute} that is associated with a 
 * 			{@link LiteralType}.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.common.base.BasePackage#getSimpleAnnotationAttribute()
 * @model
 * @generated
 */
public interface SimpleAnnotationAttribute extends AnnotationAttribute
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.common.base.LiteralType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The type of the attribute
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.eclipse.etrice.core.common.base.LiteralType
   * @see #setType(LiteralType)
   * @see org.eclipse.etrice.core.common.base.BasePackage#getSimpleAnnotationAttribute_Type()
   * @model
   * @generated
   */
  LiteralType getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.eclipse.etrice.core.common.base.LiteralType
   * @see #getType()
   * @generated
   */
  void setType(LiteralType value);

} // SimpleAnnotationAttribute
