/**
 */
package org.eclipse.etrice.core.fsm.fSM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refined Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The refined transition is only allowed in {@link StateGraph}s
 * of derived {@link ActorClass}es. It targets a {@link Transition}
 * of the base class state machine.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.RefinedTransition#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getRefinedTransition()
 * @model
 * @generated
 */
public interface RefinedTransition extends TransitionBase
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the referenced transition in the base class state machine.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Transition)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getRefinedTransition_Target()
   * @model
   * @generated
   */
  Transition getTarget();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.RefinedTransition#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Transition value);

} // RefinedTransition
