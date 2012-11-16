/**
 */
package org.eclipse.etrice.core.etmap.eTMap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Instance Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping#getThread <em>Thread</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping#getActorInstanceMappings <em>Actor Instance Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getActorInstanceMapping()
 * @model
 * @generated
 */
public interface ActorInstanceMapping extends EObject
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' containment reference.
   * @see #setPath(RefPath)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getActorInstanceMapping_Path()
   * @model containment="true"
   * @generated
   */
  RefPath getPath();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping#getPath <em>Path</em>}' containment reference.
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
   * <p>
   * If the meaning of the '<em>Thread</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Thread</em>' reference.
   * @see #setThread(org.eclipse.etrice.core.etphys.eTPhys.Thread)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getActorInstanceMapping_Thread()
   * @model
   * @generated
   */
  org.eclipse.etrice.core.etphys.eTPhys.Thread getThread();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping#getThread <em>Thread</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Thread</em>' reference.
   * @see #getThread()
   * @generated
   */
  void setThread(org.eclipse.etrice.core.etphys.eTPhys.Thread value);

  /**
   * Returns the value of the '<em><b>Actor Instance Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor Instance Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actor Instance Mappings</em>' containment reference list.
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getActorInstanceMapping_ActorInstanceMappings()
   * @model containment="true"
   * @generated
   */
  EList<ActorInstanceMapping> getActorInstanceMappings();

} // ActorInstanceMapping
