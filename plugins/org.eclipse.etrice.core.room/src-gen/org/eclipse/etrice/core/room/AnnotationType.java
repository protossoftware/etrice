/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.AnnotationType#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.AnnotationType#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getAnnotationType()
 * @model
 * @generated
 */
public interface AnnotationType extends RoomClass
{
  /**
   * Returns the value of the '<em><b>Targets</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.AnnotationTargetType}.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.room.AnnotationTargetType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Targets</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Targets</em>' attribute list.
   * @see org.eclipse.etrice.core.room.AnnotationTargetType
   * @see org.eclipse.etrice.core.room.RoomPackage#getAnnotationType_Targets()
   * @model unique="false"
   * @generated
   */
  EList<AnnotationTargetType> getTargets();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.AnnotationAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getAnnotationType_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationAttribute> getAttributes();

} // AnnotationType
