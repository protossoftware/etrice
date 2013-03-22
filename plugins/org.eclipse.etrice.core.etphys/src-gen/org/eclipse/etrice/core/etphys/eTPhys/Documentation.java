/**
 */
package org.eclipse.etrice.core.etphys.eTPhys;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documentation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A piece of documentation that can be optionally attached at
 * certain places in the model.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.Documentation#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getDocumentation()
 * @model
 * @generated
 */
public interface Documentation extends EObject
{
  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is the documentation's contents.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Text</em>' attribute list.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getDocumentation_Text()
   * @model unique="false"
   * @generated
   */
  EList<String> getText();

} // Documentation
