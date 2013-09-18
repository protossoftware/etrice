/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.etrice.core.common.base.Documentation;

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
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.Transition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Transition#getTo <em>To</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Transition#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Transition#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends StateGraphItem
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
   * @see org.eclipse.etrice.core.room.RoomPackage#getTransition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Transition#getName <em>Name</em>}' attribute.
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
   * @see org.eclipse.etrice.core.room.RoomPackage#getTransition_To()
   * @model containment="true"
   * @generated
   */
  TransitionTerminal getTo();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Transition#getTo <em>To</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' containment reference.
   * @see #getTo()
   * @generated
   */
  void setTo(TransitionTerminal value);

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
   * @see org.eclipse.etrice.core.room.RoomPackage#getTransition_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Transition#getDocu <em>Docu</em>}' containment reference.
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
   * @see org.eclipse.etrice.core.room.RoomPackage#getTransition_Action()
   * @model containment="true"
   * @generated
   */
  DetailCode getAction();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Transition#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
  void setAction(DetailCode value);

} // Transition
