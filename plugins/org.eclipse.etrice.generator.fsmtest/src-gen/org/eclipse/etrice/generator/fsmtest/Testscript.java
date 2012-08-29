/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Testscript</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.Testscript#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.Testscript#getStateDeclaration <em>State Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.Testscript#getInitialDeclaration <em>Initial Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.Testscript#getLoopsDeclaration <em>Loops Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.Testscript#getSeedDeclaration <em>Seed Declaration</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.Testscript#getTransitionDeclarations <em>Transition Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTestscript()
 * @model
 * @generated
 */
public interface Testscript extends EObject
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
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTestscript_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>State Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Declaration</em>' containment reference.
   * @see #setStateDeclaration(StateDeclaration)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTestscript_StateDeclaration()
   * @model containment="true"
   * @generated
   */
  StateDeclaration getStateDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getStateDeclaration <em>State Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Declaration</em>' containment reference.
   * @see #getStateDeclaration()
   * @generated
   */
  void setStateDeclaration(StateDeclaration value);

  /**
   * Returns the value of the '<em><b>Initial Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Declaration</em>' containment reference.
   * @see #setInitialDeclaration(InitialDeclaration)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTestscript_InitialDeclaration()
   * @model containment="true"
   * @generated
   */
  InitialDeclaration getInitialDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getInitialDeclaration <em>Initial Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Declaration</em>' containment reference.
   * @see #getInitialDeclaration()
   * @generated
   */
  void setInitialDeclaration(InitialDeclaration value);

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
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTestscript_LoopsDeclaration()
   * @model containment="true"
   * @generated
   */
  LoopsDeclaration getLoopsDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getLoopsDeclaration <em>Loops Declaration</em>}' containment reference.
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
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTestscript_SeedDeclaration()
   * @model containment="true"
   * @generated
   */
  SeedDeclaration getSeedDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.Testscript#getSeedDeclaration <em>Seed Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Seed Declaration</em>' containment reference.
   * @see #getSeedDeclaration()
   * @generated
   */
  void setSeedDeclaration(SeedDeclaration value);

  /**
   * Returns the value of the '<em><b>Transition Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition Declarations</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTestscript_TransitionDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<TransitionDeclaration> getTransitionDeclarations();

} // Testscript
