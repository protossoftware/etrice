/**
 */
package org.eclipse.etrice.core.common.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.AnnotationImpl <em>Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.AnnotationImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getAnnotation()
   * @generated
   */
  int ANNOTATION = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__ATTRIBUTES = 1;

  /**
   * The number of structural features of the '<em>Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.KeyValueImpl <em>Key Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.KeyValueImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getKeyValue()
   * @generated
   */
  int KEY_VALUE = 1;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Key Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.AnnotationTypeImpl <em>Annotation Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.AnnotationTypeImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getAnnotationType()
   * @generated
   */
  int ANNOTATION_TYPE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_TYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_TYPE__DOCU = 1;

  /**
   * The feature id for the '<em><b>Targets</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_TYPE__TARGETS = 2;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_TYPE__ATTRIBUTES = 3;

  /**
   * The number of structural features of the '<em>Annotation Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_TYPE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.AnnotationAttributeImpl <em>Annotation Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.AnnotationAttributeImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getAnnotationAttribute()
   * @generated
   */
  int ANNOTATION_ATTRIBUTE = 3;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_ATTRIBUTE__OPTIONAL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_ATTRIBUTE__NAME = 1;

  /**
   * The number of structural features of the '<em>Annotation Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_ATTRIBUTE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.SimpleAnnotationAttributeImpl <em>Simple Annotation Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.SimpleAnnotationAttributeImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getSimpleAnnotationAttribute()
   * @generated
   */
  int SIMPLE_ANNOTATION_ATTRIBUTE = 4;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANNOTATION_ATTRIBUTE__OPTIONAL = ANNOTATION_ATTRIBUTE__OPTIONAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANNOTATION_ATTRIBUTE__NAME = ANNOTATION_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANNOTATION_ATTRIBUTE__TYPE = ANNOTATION_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Annotation Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ANNOTATION_ATTRIBUTE_FEATURE_COUNT = ANNOTATION_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.EnumAnnotationAttributeImpl <em>Enum Annotation Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.EnumAnnotationAttributeImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getEnumAnnotationAttribute()
   * @generated
   */
  int ENUM_ANNOTATION_ATTRIBUTE = 5;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_ANNOTATION_ATTRIBUTE__OPTIONAL = ANNOTATION_ATTRIBUTE__OPTIONAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_ANNOTATION_ATTRIBUTE__NAME = ANNOTATION_ATTRIBUTE__NAME;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_ANNOTATION_ATTRIBUTE__VALUES = ANNOTATION_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Annotation Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_ANNOTATION_ATTRIBUTE_FEATURE_COUNT = ANNOTATION_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.DocumentationImpl <em>Documentation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.DocumentationImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getDocumentation()
   * @generated
   */
  int DOCUMENTATION = 6;

  /**
   * The feature id for the '<em><b>Lines</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__LINES = 0;

  /**
   * The number of structural features of the '<em>Documentation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.impl.LiteralArrayImpl <em>Literal Array</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.impl.LiteralArrayImpl
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getLiteralArray()
   * @generated
   */
  int LITERAL_ARRAY = 7;

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
  int LITERAL = 8;

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
  int BOOLEAN_LITERAL = 9;

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
  int NUMBER_LITERAL = 10;

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
  int REAL_LITERAL = 11;

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
  int INT_LITERAL = 12;

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
  int STRING_LITERAL = 13;

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
   * The meta object id for the '{@link org.eclipse.etrice.core.common.base.LiteralType <em>Literal Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.etrice.core.common.base.LiteralType
   * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getLiteralType()
   * @generated
   */
  int LITERAL_TYPE = 14;


  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation</em>'.
   * @see org.eclipse.etrice.core.common.base.Annotation
   * @generated
   */
  EClass getAnnotation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.etrice.core.common.base.Annotation#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.etrice.core.common.base.Annotation#getType()
   * @see #getAnnotation()
   * @generated
   */
  EReference getAnnotation_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.common.base.Annotation#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.common.base.Annotation#getAttributes()
   * @see #getAnnotation()
   * @generated
   */
  EReference getAnnotation_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.KeyValue <em>Key Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key Value</em>'.
   * @see org.eclipse.etrice.core.common.base.KeyValue
   * @generated
   */
  EClass getKeyValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.common.base.KeyValue#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.eclipse.etrice.core.common.base.KeyValue#getKey()
   * @see #getKeyValue()
   * @generated
   */
  EAttribute getKeyValue_Key();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.common.base.KeyValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.etrice.core.common.base.KeyValue#getValue()
   * @see #getKeyValue()
   * @generated
   */
  EReference getKeyValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.AnnotationType <em>Annotation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Type</em>'.
   * @see org.eclipse.etrice.core.common.base.AnnotationType
   * @generated
   */
  EClass getAnnotationType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.common.base.AnnotationType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.common.base.AnnotationType#getName()
   * @see #getAnnotationType()
   * @generated
   */
  EAttribute getAnnotationType_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.common.base.AnnotationType#getDocu <em>Docu</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Docu</em>'.
   * @see org.eclipse.etrice.core.common.base.AnnotationType#getDocu()
   * @see #getAnnotationType()
   * @generated
   */
  EReference getAnnotationType_Docu();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.common.base.AnnotationType#getTargets <em>Targets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Targets</em>'.
   * @see org.eclipse.etrice.core.common.base.AnnotationType#getTargets()
   * @see #getAnnotationType()
   * @generated
   */
  EAttribute getAnnotationType_Targets();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.common.base.AnnotationType#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.etrice.core.common.base.AnnotationType#getAttributes()
   * @see #getAnnotationType()
   * @generated
   */
  EReference getAnnotationType_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.AnnotationAttribute <em>Annotation Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Attribute</em>'.
   * @see org.eclipse.etrice.core.common.base.AnnotationAttribute
   * @generated
   */
  EClass getAnnotationAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.common.base.AnnotationAttribute#isOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see org.eclipse.etrice.core.common.base.AnnotationAttribute#isOptional()
   * @see #getAnnotationAttribute()
   * @generated
   */
  EAttribute getAnnotationAttribute_Optional();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.common.base.AnnotationAttribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.etrice.core.common.base.AnnotationAttribute#getName()
   * @see #getAnnotationAttribute()
   * @generated
   */
  EAttribute getAnnotationAttribute_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute <em>Simple Annotation Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Annotation Attribute</em>'.
   * @see org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute
   * @generated
   */
  EClass getSimpleAnnotationAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.etrice.core.common.base.SimpleAnnotationAttribute#getType()
   * @see #getSimpleAnnotationAttribute()
   * @generated
   */
  EAttribute getSimpleAnnotationAttribute_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.EnumAnnotationAttribute <em>Enum Annotation Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Annotation Attribute</em>'.
   * @see org.eclipse.etrice.core.common.base.EnumAnnotationAttribute
   * @generated
   */
  EClass getEnumAnnotationAttribute();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.common.base.EnumAnnotationAttribute#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see org.eclipse.etrice.core.common.base.EnumAnnotationAttribute#getValues()
   * @see #getEnumAnnotationAttribute()
   * @generated
   */
  EAttribute getEnumAnnotationAttribute_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.etrice.core.common.base.Documentation <em>Documentation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Documentation</em>'.
   * @see org.eclipse.etrice.core.common.base.Documentation
   * @generated
   */
  EClass getDocumentation();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.common.base.Documentation#getLines <em>Lines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Lines</em>'.
   * @see org.eclipse.etrice.core.common.base.Documentation#getLines()
   * @see #getDocumentation()
   * @generated
   */
  EAttribute getDocumentation_Lines();

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
   * Returns the meta object for enum '{@link org.eclipse.etrice.core.common.base.LiteralType <em>Literal Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Literal Type</em>'.
   * @see org.eclipse.etrice.core.common.base.LiteralType
   * @generated
   */
  EEnum getLiteralType();

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
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.AnnotationImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getAnnotation()
     * @generated
     */
    EClass ANNOTATION = eINSTANCE.getAnnotation();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION__TYPE = eINSTANCE.getAnnotation_Type();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION__ATTRIBUTES = eINSTANCE.getAnnotation_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.KeyValueImpl <em>Key Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.KeyValueImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getKeyValue()
     * @generated
     */
    EClass KEY_VALUE = eINSTANCE.getKeyValue();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_VALUE__KEY = eINSTANCE.getKeyValue_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference KEY_VALUE__VALUE = eINSTANCE.getKeyValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.AnnotationTypeImpl <em>Annotation Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.AnnotationTypeImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getAnnotationType()
     * @generated
     */
    EClass ANNOTATION_TYPE = eINSTANCE.getAnnotationType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_TYPE__NAME = eINSTANCE.getAnnotationType_Name();

    /**
     * The meta object literal for the '<em><b>Docu</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_TYPE__DOCU = eINSTANCE.getAnnotationType_Docu();

    /**
     * The meta object literal for the '<em><b>Targets</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_TYPE__TARGETS = eINSTANCE.getAnnotationType_Targets();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_TYPE__ATTRIBUTES = eINSTANCE.getAnnotationType_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.AnnotationAttributeImpl <em>Annotation Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.AnnotationAttributeImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getAnnotationAttribute()
     * @generated
     */
    EClass ANNOTATION_ATTRIBUTE = eINSTANCE.getAnnotationAttribute();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_ATTRIBUTE__OPTIONAL = eINSTANCE.getAnnotationAttribute_Optional();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION_ATTRIBUTE__NAME = eINSTANCE.getAnnotationAttribute_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.SimpleAnnotationAttributeImpl <em>Simple Annotation Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.SimpleAnnotationAttributeImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getSimpleAnnotationAttribute()
     * @generated
     */
    EClass SIMPLE_ANNOTATION_ATTRIBUTE = eINSTANCE.getSimpleAnnotationAttribute();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_ANNOTATION_ATTRIBUTE__TYPE = eINSTANCE.getSimpleAnnotationAttribute_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.EnumAnnotationAttributeImpl <em>Enum Annotation Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.EnumAnnotationAttributeImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getEnumAnnotationAttribute()
     * @generated
     */
    EClass ENUM_ANNOTATION_ATTRIBUTE = eINSTANCE.getEnumAnnotationAttribute();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_ANNOTATION_ATTRIBUTE__VALUES = eINSTANCE.getEnumAnnotationAttribute_Values();

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.impl.DocumentationImpl <em>Documentation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.impl.DocumentationImpl
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getDocumentation()
     * @generated
     */
    EClass DOCUMENTATION = eINSTANCE.getDocumentation();

    /**
     * The meta object literal for the '<em><b>Lines</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOCUMENTATION__LINES = eINSTANCE.getDocumentation_Lines();

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

    /**
     * The meta object literal for the '{@link org.eclipse.etrice.core.common.base.LiteralType <em>Literal Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.etrice.core.common.base.LiteralType
     * @see org.eclipse.etrice.core.common.base.impl.BasePackageImpl#getLiteralType()
     * @generated
     */
    EEnum LITERAL_TYPE = eINSTANCE.getLiteralType();

  }

} //BasePackage
