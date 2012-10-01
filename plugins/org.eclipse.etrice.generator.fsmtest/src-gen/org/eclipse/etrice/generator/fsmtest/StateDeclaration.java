/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.StateDeclaration#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getStateDeclaration()
 * @model
 * @generated
 */
public interface StateDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.State}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getStateDeclaration_States()
   * @model containment="true"
   * @generated
   */
  EList<State> getStates();

} // StateDeclaration
