/**
 */
package org.eclipse.etrice.core.fsm.fSM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CP Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The choice point branch transitions is allowed only as outgoing
 * transition of {@link ChoicePoint}s.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.CPBranchTransition#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getCPBranchTransition()
 * @model
 * @generated
 */
public interface CPBranchTransition extends NonInitialTransition
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the condition of the choice point branch specified in the code generator's target language.
   * It has to evaluate to a boolean value.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(DetailCode)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getCPBranchTransition_Condition()
   * @model containment="true"
   * @generated
   */
  DetailCode getCondition();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.CPBranchTransition#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(DetailCode value);

} // CPBranchTransition
