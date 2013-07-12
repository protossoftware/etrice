/**
 */
package org.eclipse.etrice.core.etphys.eTPhys;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage
 * @generated
 */
public interface ETPhysFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ETPhysFactory eINSTANCE = org.eclipse.etrice.core.etphys.eTPhys.impl.ETPhysFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Physical Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Physical Model</em>'.
   * @generated
   */
  PhysicalModel createPhysicalModel();

  /**
   * Returns a new object of class '<em>Physical System</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Physical System</em>'.
   * @generated
   */
  PhysicalSystem createPhysicalSystem();

  /**
   * Returns a new object of class '<em>Node Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Ref</em>'.
   * @generated
   */
  NodeRef createNodeRef();

  /**
   * Returns a new object of class '<em>Node Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Class</em>'.
   * @generated
   */
  NodeClass createNodeClass();

  /**
   * Returns a new object of class '<em>Physical Thread</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Physical Thread</em>'.
   * @generated
   */
  PhysicalThread createPhysicalThread();

  /**
   * Returns a new object of class '<em>Runtime Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Runtime Class</em>'.
   * @generated
   */
  RuntimeClass createRuntimeClass();

  /**
   * Returns a new object of class '<em>Documentation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Documentation</em>'.
   * @generated
   */
  Documentation createDocumentation();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ETPhysPackage getETPhysPackage();

} //ETPhysFactory
