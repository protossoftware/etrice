/**
 */
package org.eclipse.etrice.core.etphys.eTPhys;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runtime Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getThreadModel <em>Thread Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getRuntimeClass()
 * @model
 * @generated
 */
public interface RuntimeClass extends EObject
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
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getRuntimeClass_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Docu</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Docu</em>' containment reference.
   * @see #setDocu(Documentation)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getRuntimeClass_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Thread Model</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.etphys.eTPhys.ThreadModel}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Thread Model</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Thread Model</em>' attribute.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ThreadModel
   * @see #setThreadModel(ThreadModel)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getRuntimeClass_ThreadModel()
   * @model
   * @generated
   */
  ThreadModel getThreadModel();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass#getThreadModel <em>Thread Model</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Thread Model</em>' attribute.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ThreadModel
   * @see #getThreadModel()
   * @generated
   */
  void setThreadModel(ThreadModel value);

} // RuntimeClass
