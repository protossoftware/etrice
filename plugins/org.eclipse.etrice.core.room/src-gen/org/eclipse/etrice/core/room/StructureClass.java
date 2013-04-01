/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This class is the super class of the structural classes
 * <ul>
 *   <li>{@link ActorContainerClass}</li>
 *   <li>{@link LogicalSystem}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.StructureClass#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.StructureClass#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.StructureClass#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getStructureClass()
 * @model
 * @generated
 */
public interface StructureClass extends RoomClass
{
  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Annotation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of structure class annotations.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getStructureClass_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Binding}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of structure class bindings.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Bindings</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getStructureClass_Bindings()
   * @model containment="true"
   * @generated
   */
  EList<Binding> getBindings();

  /**
   * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.LayerConnection}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of structure class connections.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Connections</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getStructureClass_Connections()
   * @model containment="true"
   * @generated
   */
  EList<LayerConnection> getConnections();

} // StructureClass
