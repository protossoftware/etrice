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
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getIn <em>In</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getOut <em>Out</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getDestination <em>Destination</em>}</li>
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
   * Returns the value of the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference.
   * @see #setSource(SourceDeclaration)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_Source()
   * @model containment="true"
   * @generated
   */
  SourceDeclaration getSource();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getSource <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' containment reference.
   * @see #getSource()
   * @generated
   */
  void setSource(SourceDeclaration value);

  /**
   * Returns the value of the '<em><b>In</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_In()
   * @model containment="true"
   * @generated
   */
  EList<SignalDeclaration> getIn();

  /**
   * Returns the value of the '<em><b>Out</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Out</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out</em>' containment reference list.
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_Out()
   * @model containment="true"
   * @generated
   */
  EList<SignalDeclaration> getOut();

  /**
   * Returns the value of the '<em><b>Destination</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Destination</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Destination</em>' containment reference.
   * @see #setDestination(DestinationDeclaration)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getTransitionDeclaration_Destination()
   * @model containment="true"
   * @generated
   */
  DestinationDeclaration getDestination();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.TransitionDeclaration#getDestination <em>Destination</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Destination</em>' containment reference.
   * @see #getDestination()
   * @generated
   */
  void setDestination(DestinationDeclaration value);

} // TransitionDeclaration
