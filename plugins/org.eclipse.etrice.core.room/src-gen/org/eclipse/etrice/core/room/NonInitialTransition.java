/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Initial Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The super class of
 * <ul>
 *   <li>{@link TransitionChainStartTransition}</li>
 *   <li>{@link ContinuationTransition}</li>
 *   <li>{@link CPBranchTransition}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.NonInitialTransition#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getNonInitialTransition()
 * @model
 * @generated
 */
public interface NonInitialTransition extends Transition
{
  /**
   * Returns the value of the '<em><b>From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is the source node of the transition.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>From</em>' containment reference.
   * @see #setFrom(TransitionTerminal)
   * @see org.eclipse.etrice.core.room.RoomPackage#getNonInitialTransition_From()
   * @model containment="true"
   * @generated
   */
  TransitionTerminal getFrom();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.NonInitialTransition#getFrom <em>From</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' containment reference.
   * @see #getFrom()
   * @generated
   */
  void setFrom(TransitionTerminal value);

} // NonInitialTransition
