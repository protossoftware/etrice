/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.Model#getTestscripts <em>Testscripts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Testscripts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.Testscript}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Testscripts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Testscripts</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getModel_Testscripts()
   * @model containment="true"
   * @generated
   */
  EList<Testscript> getTestscripts();

} // Model
