/**
 */
package org.eclipse.etrice.core.common.basetest;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.common.basetest.BasetestFactory
 * @model kind="package"
 * @generated
 */
public interface BasetestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "basetest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/etrice/core/common/BaseTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "basetest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BasetestPackage eINSTANCE = org.eclipse.etrice.core.common.basetest.impl.BasetestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.basetest.impl.BaseModelImpl <em>Base Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.basetest.impl.BaseModelImpl
   * @see org.eclipse.etrice.core.common.basetest.impl.BasetestPackageImpl#getBaseModel()
   * @generated
   */
  int BASE_MODEL = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Base Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_MODEL_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.basetest.BaseModel <em>Base Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Base Model</em>'.
   * @see org.eclipse.etrice.core.common.basetest.BaseModel
   * @generated
   */
  EClass getBaseModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.common.basetest.BaseModel#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.etrice.core.common.basetest.BaseModel#getElements()
   * @see #getBaseModel()
   * @generated
   */
  EReference getBaseModel_Elements();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  BasetestFactory getBasetestFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.basetest.impl.BaseModelImpl <em>Base Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.basetest.impl.BaseModelImpl
     * @see org.eclipse.etrice.core.common.basetest.impl.BasetestPackageImpl#getBaseModel()
     * @generated
     */
    EClass BASE_MODEL = eINSTANCE.getBaseModel();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_MODEL__ELEMENTS = eINSTANCE.getBaseModel_Elements();

  }

} //BasetestPackage
