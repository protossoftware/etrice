/**
 */
package org.eclipse.etrice.core.common.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documentation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A piece of documentation that can be optionally attached at
 * certain places in the model.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.common.base.Documentation#getLines <em>Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.common.base.BasePackage#getDocumentation()
 * @model
 * @generated
 */
public interface Documentation extends EObject
{
  /**
   * Returns the value of the '<em><b>Lines</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the documentation's contents.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Lines</em>' attribute list.
   * @see org.eclipse.etrice.core.common.base.BasePackage#getDocumentation_Lines()
   * @model unique="false"
   * @generated
   */
  EList<String> getLines();

} // Documentation
