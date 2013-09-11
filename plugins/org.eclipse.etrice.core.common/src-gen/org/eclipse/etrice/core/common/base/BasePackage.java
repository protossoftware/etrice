/**
 */
package org.eclipse.etrice.core.common.base;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.etrice.core.common.base.BaseFactory
 * @model kind="package"
 * @generated
 */
public interface BasePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "base";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/etrice/core/common/Base";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "base";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BasePackage eINSTANCE = org.eclipse.etrice.core.common.base.impl.BasePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.LiteralArrayImpl <em>Literal Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.LiteralArrayImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getLiteralArray()
   * @generated
   */
  int LITERAL_ARRAY = 0;

  /**
   * The feature id for the '<em><b>Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_ARRAY__LITERALS = 0;

  /**
   * The number of structural features of the '<em>Literal Array</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_ARRAY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.LiteralImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 1;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.BooleanLiteralImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 2;

  /**
   * The feature id for the '<em><b>Is True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__IS_TRUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.NumberLiteralImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getNumberLiteral()
   * @generated
   */
  int NUMBER_LITERAL = 3;

  /**
   * The number of structural features of the '<em>Number Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.RealLiteralImpl <em>Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.RealLiteralImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getRealLiteral()
   * @generated
   */
  int REAL_LITERAL = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__VALUE = NUMBER_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Real Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_FEATURE_COUNT = NUMBER_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.IntLiteralImpl <em>Int Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.IntLiteralImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getIntLiteral()
   * @generated
   */
  int INT_LITERAL = 5;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__VALUE = NUMBER_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL_FEATURE_COUNT = NUMBER_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.StringLiteralImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.LiteralArray <em>Literal Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Array</em>'.
   * @see org.eclipse.etrice.core.common.base.LiteralArray
   * @generated
   */
  EClass getLiteralArray();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.common.base.LiteralArray#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see org.eclipse.etrice.core.common.base.LiteralArray#getLiterals()
   * @see #getLiteralArray()
   * @generated
   */
  EReference getLiteralArray_Literals();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.eclipse.etrice.core.common.base.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see org.eclipse.etrice.core.common.base.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.common.base.BooleanLiteral#isIsTrue <em>Is True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is True</em>'.
   * @see org.eclipse.etrice.core.common.base.BooleanLiteral#isIsTrue()
   * @see #getBooleanLiteral()
   * @generated
   */
  EAttribute getBooleanLiteral_IsTrue();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.NumberLiteral <em>Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal</em>'.
   * @see org.eclipse.etrice.core.common.base.NumberLiteral
   * @generated
   */
  EClass getNumberLiteral();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal</em>'.
   * @see org.eclipse.etrice.core.common.base.RealLiteral
   * @generated
   */
  EClass getRealLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.common.base.RealLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.etrice.core.common.base.RealLiteral#getValue()
   * @see #getRealLiteral()
   * @generated
   */
  EAttribute getRealLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Literal</em>'.
   * @see org.eclipse.etrice.core.common.base.IntLiteral
   * @generated
   */
  EClass getIntLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.common.base.IntLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.etrice.core.common.base.IntLiteral#getValue()
   * @see #getIntLiteral()
   * @generated
   */
  EAttribute getIntLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see org.eclipse.etrice.core.common.base.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.common.base.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.etrice.core.common.base.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  BaseFactory getBaseFactory();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.LiteralArrayImpl <em>Literal Array</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.LiteralArrayImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getLiteralArray()
     * @generated
     */
    EClass LITERAL_ARRAY = eINSTANCE.getLiteralArray();

    /**
     * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LITERAL_ARRAY__LITERALS = eINSTANCE.getLiteralArray_Literals();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.LiteralImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.BooleanLiteralImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Is True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL__IS_TRUE = eINSTANCE.getBooleanLiteral_IsTrue();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.NumberLiteralImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getNumberLiteral()
     * @generated
     */
    EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.RealLiteralImpl <em>Real Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.RealLiteralImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getRealLiteral()
     * @generated
     */
    EClass REAL_LITERAL = eINSTANCE.getRealLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_LITERAL__VALUE = eINSTANCE.getRealLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.IntLiteralImpl <em>Int Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.IntLiteralImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getIntLiteral()
     * @generated
     */
    EClass INT_LITERAL = eINSTANCE.getIntLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_LITERAL__VALUE = eINSTANCE.getIntLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.StringLiteralImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getStringLiteral()
     * @generated
     */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

  }

} //BasePackage
