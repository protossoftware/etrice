/**
 */
package org.eclipse.etrice.core.common.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>Defines the structure of {@link Annotation}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.common.base.AnnotationType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.common.base.AnnotationType#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.common.base.AnnotationType#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.common.base.AnnotationType#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotationType()
 * @model
 * @generated
 */
public interface AnnotationType extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The name of the AnnotationType
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotationType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.common.base.AnnotationType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>Optional model-level documentation
   * <!-- end-model-doc -->
   * @return the value of the '<em>Docu</em>' containment reference.
   * @see #setDocu(Documentation)
   * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotationType_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.common.base.AnnotationType#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Targets</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>A list of names representing the locations in which 
   * 			{@Annotation}s of this AnnotationType can occur
   * <!-- end-model-doc -->
   * @return the value of the '<em>Targets</em>' attribute list.
   * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotationType_Targets()
   * @model unique="false"
   * @generated
   */
  EList<String> getTargets();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.common.base.AnnotationAttribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>Defines the {@link Attribute}s that are required or allowed in 
   * 			{@Annotation} instances of this AnnotationType
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.common.base.BasePackage#getAnnotationType_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationAttribute> getAttributes();

} // AnnotationType
