/**
 */
package org.eclipse.etrice.core.room;

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
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.DetailCode#getLines <em>Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getDetailCode()
 * @model
 * @generated
 */
public interface DetailCode extends EObject
{
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
   * @see org.eclipse.etrice.core.room.RoomPackage#getDetailCode_Lines()
   * @model unique="false"
   * @generated
   */
  EList<String> getLines();

} // DetailCode
