/**
 */
package org.eclipse.etrice.core.fsm.fSM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guarded Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A guarded transition is very similar to a {@link CPBranchTransition}.
 * It defines a guard condition which lets the transition fire if
 * evaluated to {@code true}. This kind of transition is only
 * allowed in data driven or moixed (async) state machines.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.GuardedTransition#getGuard <em>Guard</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getGuardedTransition()
 * @model
 * @generated
 */
public interface GuardedTransition extends TransitionChainStartTransition
{
  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the guard condition of the transition specified in the code generator's target language.
   * It has to evaluate to a boolean value.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Guard</em>' containment reference.
   * @see #setGuard(DetailCode)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getGuardedTransition_Guard()
   * @model containment="true"
   * @generated
   */
  DetailCode getGuard();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.GuardedTransition#getGuard <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' containment reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(DetailCode value);

} // GuardedTransition
