/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.fsm.fSM.DetailCode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Structor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>Represents either the constructor (ctor) or destructor (dtor) of a ROOM class.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ClassStructor#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ClassStructor#getDetailCode <em>Detail Code</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getClassStructor()
 * @model
 * @generated
 */
public interface ClassStructor extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getClassStructor_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ClassStructor#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Detail Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Detail Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Detail Code</em>' containment reference.
   * @see #setDetailCode(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getClassStructor_DetailCode()
   * @model containment="true"
   * @generated
   */
  DetailCode getDetailCode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ClassStructor#getDetailCode <em>Detail Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Detail Code</em>' containment reference.
   * @see #getDetailCode()
   * @generated
   */
  void setDetailCode(DetailCode value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return \"ctor\".equals(this.getName());\r\n'"
   * @generated
   */
  boolean isConstructor();

} // ClassStructor
