/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.common.base.Documentation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.TransitionBase#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.TransitionBase#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTransitionBase()
 * @model
 * @generated
 */
public interface TransitionBase extends EObject
{
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
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTransitionBase_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.TransitionBase#getDocu <em>Docu</em>}' containment reference.
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
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTransitionBase_Action()
   * @model containment="true"
   * @generated
   */
  DetailCode getAction();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.TransitionBase#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
  void setAction(DetailCode value);

} // TransitionBase
