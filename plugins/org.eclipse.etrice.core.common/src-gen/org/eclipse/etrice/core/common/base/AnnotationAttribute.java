/**
 */
package org.eclipse.etrice.core.common.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>Defines an attribute in an {@link AnnotationType}. This attribute 
 * 			can then be declared in respective {@link Annotation} instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.common.base.AnnotationAttribute#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.common.base.AnnotationAttribute#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotationAttribute()
 * @model
 * @generated
 */
public interface AnnotationAttribute extends EObject
{
  /**
   * Returns the value of the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>Specifies whether the attribute should be optional or not. If the 
   * 			attribute is optional, it can be omitted by {@link Annotation}s of 
   * 			the same {@link AnnotationType}.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Optional</em>' attribute.
   * @see #setOptional(boolean)
   * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotationAttribute_Optional()
   * @model
   * @generated
   */
  boolean isOptional();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.common.base.AnnotationAttribute#isOptional <em>Optional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optional</em>' attribute.
   * @see #isOptional()
   * @generated
   */
  void setOptional(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The name of the attribute
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotationAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.common.base.AnnotationAttribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // AnnotationAttribute
