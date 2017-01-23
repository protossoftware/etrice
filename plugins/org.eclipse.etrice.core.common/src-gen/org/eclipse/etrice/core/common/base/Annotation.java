/**
 */
package org.eclipse.etrice.core.common.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>An annotation similar to Java annotations that can be used
 * to add {@link KeyValue} pairs to certain model items. The structure 
 * of Annotations are defined by {@link AnnotationType}s.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.common.base.Annotation#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.common.base.Annotation#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The {@link AnnotationType} that defines the structure of 
   * the annotation.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(AnnotationType)
   * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotation_Type()
   * @model
   * @generated
   */
  AnnotationType getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.common.base.Annotation#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(AnnotationType value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.common.base.KeyValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of key/value pairs.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotation_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<KeyValue> getAttributes();

} // Annotation
