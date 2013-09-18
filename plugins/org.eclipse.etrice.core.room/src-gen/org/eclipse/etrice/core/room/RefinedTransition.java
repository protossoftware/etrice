/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.common.base.Documentation;

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
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RefinedTransition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RefinedTransition#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RefinedTransition#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRefinedTransition()
 * @model
 * @generated
 */
public interface RefinedTransition extends EObject
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
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefinedTransition_Target()
   * @model
   * @generated
   */
  Transition getTarget();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefinedTransition#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Transition value);

  /**
   * Returns the value of the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional documentation.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Docu</em>' containment reference.
   * @see #setDocu(Documentation)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefinedTransition_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefinedTransition#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional code in the code generator's target language.
   * It is execute when the transition fires.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Action</em>' containment reference.
   * @see #setAction(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefinedTransition_Action()
   * @model containment="true"
   * @generated
   */
  DetailCode getAction();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefinedTransition#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
  void setAction(DetailCode value);

} // RefinedTransition
