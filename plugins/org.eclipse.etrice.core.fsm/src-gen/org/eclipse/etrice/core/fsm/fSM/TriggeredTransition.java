/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Triggered Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>Triggered transitions start at a {@link State} or a {@link TransitionPoint}.
 * It defines a list of {@link Trigger}s that specify the conditions
 * when the transition fires and is traversed. This kind of
 * transition is only allowed in event driven and mixed (async) state
 * machines.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.TriggeredTransition#getTriggers <em>Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTriggeredTransition()
 * @model
 * @generated
 */
public interface TriggeredTransition extends TransitionChainStartTransition
{
  /**
   * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.fsm.fSM.Trigger}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all triggers of the transition.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Triggers</em>' containment reference list.
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTriggeredTransition_Triggers()
   * @model containment="true"
   * @generated
   */
  EList<Trigger> getTriggers();

} // TriggeredTransition
