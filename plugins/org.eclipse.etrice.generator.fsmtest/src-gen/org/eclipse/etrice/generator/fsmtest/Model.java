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
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.Model#getFsmDefinitions <em>Fsm Definitions</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.Model#getRandomTests <em>Random Tests</em>}</li>
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
   * Returns the value of the '<em><b>Fsm Definitions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.FsmDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fsm Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fsm Definitions</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getModel_FsmDefinitions()
   * @model containment="true"
   * @generated
   */
  EList<FsmDefinition> getFsmDefinitions();

  /**
   * Returns the value of the '<em><b>Random Tests</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.RandomTest}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Random Tests</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Random Tests</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getModel_RandomTests()
   * @model containment="true"
   * @generated
   */
  EList<RandomTest> getRandomTests();

} // Model
