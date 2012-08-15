/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.DataClass#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.DataClass#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.DataClass#getUserCode1 <em>User Code1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.DataClass#getUserCode2 <em>User Code2</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.DataClass#getUserCode3 <em>User Code3</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.DataClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.DataClass#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getDataClass()
 * @model
 * @generated
 */
public interface DataClass extends ComplexType
{
  /**
   * Returns the value of the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' reference.
   * @see #setBase(DataClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getDataClass_Base()
   * @model
   * @generated
   */
  DataClass getBase();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.DataClass#getBase <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' reference.
   * @see #getBase()
   * @generated
   */
  void setBase(DataClass value);

  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Annotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getDataClass_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Code1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Code1</em>' containment reference.
   * @see #setUserCode1(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getDataClass_UserCode1()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode1();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.DataClass#getUserCode1 <em>User Code1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code1</em>' containment reference.
   * @see #getUserCode1()
   * @generated
   */
  void setUserCode1(DetailCode value);

  /**
   * Returns the value of the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Code2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Code2</em>' containment reference.
   * @see #setUserCode2(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getDataClass_UserCode2()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode2();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.DataClass#getUserCode2 <em>User Code2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code2</em>' containment reference.
   * @see #getUserCode2()
   * @generated
   */
  void setUserCode2(DetailCode value);

  /**
   * Returns the value of the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Code3</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Code3</em>' containment reference.
   * @see #setUserCode3(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getDataClass_UserCode3()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode3();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.DataClass#getUserCode3 <em>User Code3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code3</em>' containment reference.
   * @see #getUserCode3()
   * @generated
   */
  void setUserCode3(DetailCode value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getDataClass_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.StandardOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getDataClass_Operations()
   * @model containment="true"
   * @generated
   */
  EList<StandardOperation> getOperations();

} // DataClass
