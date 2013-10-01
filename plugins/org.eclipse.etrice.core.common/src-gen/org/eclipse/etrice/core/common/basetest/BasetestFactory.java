/**
 */
package org.eclipse.etrice.core.common.basetest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.common.basetest.BasetestPackage
 * @generated
 */
public interface BasetestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BasetestFactory eINSTANCE = org.eclipse.etrice.core.common.basetest.impl.BasetestFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Base Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Base Model</em>'.
   * @generated
   */
  BaseModel createBaseModel();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  BasetestPackage getBasetestPackage();

} //BasetestFactory
