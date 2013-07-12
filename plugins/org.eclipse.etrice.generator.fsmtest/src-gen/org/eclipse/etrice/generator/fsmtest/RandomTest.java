/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getFsm <em>Fsm</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getLoopsDeclaration <em>Loops Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getSeedDeclaration <em>Seed Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getRandomTest()
 * @model
 * @generated
 */
public interface RandomTest extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getRandomTest_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Fsm</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fsm</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fsm</em>' reference.
   * @see #setFsm(FsmDefinition)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getRandomTest_Fsm()
   * @model
   * @generated
   */
  FsmDefinition getFsm();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getFsm <em>Fsm</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fsm</em>' reference.
   * @see #getFsm()
   * @generated
   */
  void setFsm(FsmDefinition value);

  /**
   * Returns the value of the '<em><b>Loops Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Loops Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loops Declaration</em>' containment reference.
   * @see #setLoopsDeclaration(LoopsDeclaration)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getRandomTest_LoopsDeclaration()
   * @model containment="true"
   * @generated
   */
  LoopsDeclaration getLoopsDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getLoopsDeclaration <em>Loops Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loops Declaration</em>' containment reference.
   * @see #getLoopsDeclaration()
   * @generated
   */
  void setLoopsDeclaration(LoopsDeclaration value);

  /**
   * Returns the value of the '<em><b>Seed Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Seed Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Seed Declaration</em>' containment reference.
   * @see #setSeedDeclaration(SeedDeclaration)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getRandomTest_SeedDeclaration()
   * @model containment="true"
   * @generated
   */
  SeedDeclaration getSeedDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.RandomTest#getSeedDeclaration <em>Seed Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Seed Declaration</em>' containment reference.
   * @see #getSeedDeclaration()
   * @generated
   */
  void setSeedDeclaration(SeedDeclaration value);

} // RandomTest
