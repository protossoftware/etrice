/**
 */
package org.eclipse.etrice.core.common.base;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Annotation Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>An {@link AnnotationAttribute} whose possible values are defined 
 * 			by a list of String values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.common.base.EnumAnnotationAttribute#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.common.base.BasePackage#getEnumAnnotationAttribute()
 * @model
 * @generated
 */
public interface EnumAnnotationAttribute extends AnnotationAttribute
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>A list of values that define the enumeration
   * <!-- end-model-doc -->
   * @return the value of the '<em>Values</em>' attribute list.
   * @see org.eclipse.etrice.core.common.base.BasePackage#getEnumAnnotationAttribute_Values()
   * @model unique="false"
   * @generated
   */
  EList<String> getValues();

} // EnumAnnotationAttribute
