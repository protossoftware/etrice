/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Destination Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.DestinationDeclaration#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getDestinationDeclaration()
 * @model
 * @generated
 */
public interface DestinationDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(State)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getDestinationDeclaration_Ref()
   * @model
   * @generated
   */
  State getRef();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.DestinationDeclaration#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(State value);

} // DestinationDeclaration
