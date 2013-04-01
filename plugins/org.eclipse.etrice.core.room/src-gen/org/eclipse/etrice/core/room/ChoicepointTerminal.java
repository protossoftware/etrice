/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choicepoint Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The terminal point (source or target) of a transition ending
 * at a {@link ChoicepointTerminal}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ChoicepointTerminal#getCp <em>Cp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getChoicepointTerminal()
 * @model
 * @generated
 */
public interface ChoicepointTerminal extends TransitionTerminal
{
  /**
   * Returns the value of the '<em><b>Cp</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the target choice point.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Cp</em>' reference.
   * @see #setCp(ChoicePoint)
   * @see org.eclipse.etrice.core.room.RoomPackage#getChoicepointTerminal_Cp()
   * @model
   * @generated
   */
  ChoicePoint getCp();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ChoicepointTerminal#getCp <em>Cp</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cp</em>' reference.
   * @see #getCp()
   * @generated
   */
  void setCp(ChoicePoint value);

} // ChoicepointTerminal
