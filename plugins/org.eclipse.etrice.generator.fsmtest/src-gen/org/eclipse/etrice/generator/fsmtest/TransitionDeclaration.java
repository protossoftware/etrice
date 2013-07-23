/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getPostcondition <em>Postcondition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration()
 * @model
 * @generated
 */
public interface TransitionDeclaration extends EObject
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
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Destination</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Destination</em>' reference.
   * @see #setDestination(StateDeclaration)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_Destination()
   * @model
   * @generated
   */
  StateDeclaration getDestination();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getDestination <em>Destination</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Destination</em>' reference.
   * @see #getDestination()
   * @generated
   */
  void setDestination(StateDeclaration value);

  /**
   * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trigger</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trigger</em>' containment reference.
   * @see #setTrigger(SignalDeclaration)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_Trigger()
   * @model containment="true"
   * @generated
   */
  SignalDeclaration getTrigger();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getTrigger <em>Trigger</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger</em>' containment reference.
   * @see #getTrigger()
   * @generated
   */
  void setTrigger(SignalDeclaration value);

  /**
   * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.GuardDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_Triggers()
   * @model containment="true"
   * @generated
   */
  EList<GuardDeclaration> getTriggers();

  /**
   * Returns the value of the '<em><b>Precondition</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.PreconditionDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Precondition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precondition</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_Precondition()
   * @model containment="true"
   * @generated
   */
  EList<PreconditionDeclaration> getPrecondition();

  /**
   * Returns the value of the '<em><b>Postcondition</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postcondition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postcondition</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_Postcondition()
   * @model containment="true"
   * @generated
   */
  EList<PostconditionDeclaration> getPostcondition();

} // TransitionDeclaration
