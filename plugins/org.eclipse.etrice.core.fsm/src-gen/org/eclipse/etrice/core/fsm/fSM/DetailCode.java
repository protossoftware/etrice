/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Detail Code</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The detail code contains a list of strings which
 * are considered verbatim code of the code generator
 * target language.
 * 
 * <p>
 * The detail code is parsed by the {@link org.eclipse.etrice.generator.base.DetailCodeTranslator}
 * which replaces certain frequent constructs like access of members
 * and sending a message via a port by target language specific code.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.DetailCode#isUsed <em>Used</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.DetailCode#getLines <em>Lines</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getDetailCode()
 * @model
 * @generated
 */
public interface DetailCode extends EObject
{
  /**
   * Returns the value of the '<em><b>Used</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Used</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Used</em>' attribute.
   * @see #setUsed(boolean)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getDetailCode_Used()
   * @model
   * @generated
   */
  boolean isUsed();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.DetailCode#isUsed <em>Used</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Used</em>' attribute.
   * @see #isUsed()
   * @generated
   */
  void setUsed(boolean value);

  /**
   * Returns the value of the '<em><b>Lines</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of commands in the code generator's target language.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Lines</em>' attribute list.
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getDetailCode_Lines()
   * @model unique="false"
   * @generated
   */
  EList<String> getLines();

} // DetailCode
