/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Instance Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An actor instance mapping maps an actor instances (described as a path of actor references)
 * to a {@link LogicalThread}
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ActorInstanceMapping#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorInstanceMapping#getThread <em>Thread</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorInstanceMapping#getActorInstanceMappings <em>Actor Instance Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getActorInstanceMapping()
 * @model
 * @generated
 */
public interface ActorInstanceMapping extends EObject
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is the path of references starting at this sub system that uniquely references an actor instance.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Path</em>' containment reference.
   * @see #setPath(RefPath)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorInstanceMapping_Path()
   * @model containment="true"
   * @generated
   */
  RefPath getPath();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorInstanceMapping#getPath <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' containment reference.
   * @see #getPath()
   * @generated
   */
  void setPath(RefPath value);

  /**
   * Returns the value of the '<em><b>Thread</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is the logical thread to which the referenced actor instance and all of its contained instances
   * are mapped.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Thread</em>' reference.
   * @see #setThread(LogicalThread)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorInstanceMapping_Thread()
   * @model
   * @generated
   */
  LogicalThread getThread();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorInstanceMapping#getThread <em>Thread</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Thread</em>' reference.
   * @see #getThread()
   * @generated
   */
  void setThread(LogicalThread value);

  /**
   * Returns the value of the '<em><b>Actor Instance Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ActorInstanceMapping}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is a list of nested mappings which override parent mappings.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Actor Instance Mappings</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorInstanceMapping_ActorInstanceMappings()
   * @model containment="true"
   * @generated
   */
  EList<ActorInstanceMapping> getActorInstanceMappings();

} // ActorInstanceMapping
