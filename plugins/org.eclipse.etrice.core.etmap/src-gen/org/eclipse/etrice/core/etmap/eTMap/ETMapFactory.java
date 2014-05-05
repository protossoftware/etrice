/**
 */
package org.eclipse.etrice.core.etmap.eTMap;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage
 * @generated
 */
public interface ETMapFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ETMapFactory eINSTANCE = org.eclipse.etrice.core.etmap.eTMap.impl.ETMapFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Mapping Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Model</em>'.
   * @generated
   */
  MappingModel createMappingModel();

  /**
   * Returns a new object of class '<em>Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping</em>'.
   * @generated
   */
  Mapping createMapping();

  /**
   * Returns a new object of class '<em>Sub System Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub System Mapping</em>'.
   * @generated
   */
  SubSystemMapping createSubSystemMapping();

  /**
   * Returns a new object of class '<em>Thread Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Thread Mapping</em>'.
   * @generated
   */
  ThreadMapping createThreadMapping();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ETMapPackage getETMapPackage();

} //ETMapFactory
