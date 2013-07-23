/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>Aggregates one or more {@link Literal literals}.		
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.LiteralArray#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getLiteralArray()
 * @model
 * @generated
 */
public interface LiteralArray extends EObject
{
  /**
   * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.Literal}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of literals.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Literals</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getLiteralArray_Literals()
   * @model containment="true"
   * @generated
   */
  EList<Literal> getLiterals();

} // LiteralArray
