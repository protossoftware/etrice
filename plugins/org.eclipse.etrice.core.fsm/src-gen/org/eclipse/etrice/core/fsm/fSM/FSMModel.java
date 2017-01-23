/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.FSMModel#getComponents <em>Components</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getFSMModel()
 * @model
 * @generated
 */
public interface FSMModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Components</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.fsm.fSM.ModelComponent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Components</em>' containment reference list.
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getFSMModel_Components()
   * @model containment="true"
   * @generated
   */
  EList<ModelComponent> getComponents();

} // FSMModel
