/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.Documentation;
import org.eclipse.etrice.core.common.base.Import;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The root object for the ROOM model. It gives access to {@link Import imports} and
 * the {@link SubSystemClass sub system},
 * {@link ActorClass actor}, {@link ProtocolClass protocol} and
 * {@link DataClass data} classes defined.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getAnnotationTypes <em>Annotation Types</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getRoomClasses <em>Room Classes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel()
 * @model
 * @generated
 */
public interface RoomModel extends RoomElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The model name is a dot separated fully qualified name and is
   * used to provide a name space. The generators may use that also
   * to place the generated code into separate directories.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RoomModel#getName <em>Name</em>}' attribute.
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
   * <br>This is an optional documentation.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Docu</em>' containment reference.
   * @see #setDocu(Documentation)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RoomModel#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.common.base.Annotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.common.base.Import}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all imported models.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Annotation Types</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.common.base.AnnotationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation Types</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_AnnotationTypes()
   * @model containment="true"
   * @generated
   */
  EList<AnnotationType> getAnnotationTypes();

  /**
   * Returns the value of the '<em><b>Room Classes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.RoomClass}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all room classes defined by this model.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Room Classes</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_RoomClasses()
   * @model containment="true"
   * @generated
   */
  EList<RoomClass> getRoomClasses();

} // RoomModel
