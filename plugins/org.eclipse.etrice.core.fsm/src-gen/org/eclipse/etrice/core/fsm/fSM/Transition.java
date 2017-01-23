/**
 */
package org.eclipse.etrice.core.fsm.fSM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The super class of
 * <ul>
 *   <li>{@link InitialTransition}</li>
 *   <li>{@link NonInitialTransition}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.Transition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.Transition#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends StateGraphItem, TransitionBase
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional name of the transition.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTransition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.Transition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the target node of the transition.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>To</em>' containment reference.
   * @see #setTo(TransitionTerminal)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTransition_To()
   * @model containment="true"
   * @generated
   */
  TransitionTerminal getTo();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.Transition#getTo <em>To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' containment reference.
   * @see #getTo()
   * @generated
   */
  void setTo(TransitionTerminal value);

} // Transition
