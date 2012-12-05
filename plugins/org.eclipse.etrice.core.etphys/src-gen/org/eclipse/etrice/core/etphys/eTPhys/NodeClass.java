/**
 */
package org.eclipse.etrice.core.etphys.eTPhys;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getRuntime <em>Runtime</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getPriomin <em>Priomin</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getPriomax <em>Priomax</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getThreads <em>Threads</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getNodeClass()
 * @model
 * @generated
 */
public interface NodeClass extends EObject
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
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getNodeClass_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getName <em>Name</em>}' attribute.
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
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getNodeClass_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Runtime</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Runtime</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Runtime</em>' reference.
   * @see #setRuntime(RuntimeClass)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getNodeClass_Runtime()
   * @model
   * @generated
   */
  RuntimeClass getRuntime();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getRuntime <em>Runtime</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Runtime</em>' reference.
   * @see #getRuntime()
   * @generated
   */
  void setRuntime(RuntimeClass value);

  /**
   * Returns the value of the '<em><b>Priomin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priomin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priomin</em>' attribute.
   * @see #setPriomin(int)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getNodeClass_Priomin()
   * @model
   * @generated
   */
  int getPriomin();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getPriomin <em>Priomin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priomin</em>' attribute.
   * @see #getPriomin()
   * @generated
   */
  void setPriomin(int value);

  /**
   * Returns the value of the '<em><b>Priomax</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priomax</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priomax</em>' attribute.
   * @see #setPriomax(int)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getNodeClass_Priomax()
   * @model
   * @generated
   */
  int getPriomax();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass#getPriomax <em>Priomax</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priomax</em>' attribute.
   * @see #getPriomax()
   * @generated
   */
  void setPriomax(int value);

  /**
   * Returns the value of the '<em><b>Threads</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Threads</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Threads</em>' containment reference list.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getNodeClass_Threads()
   * @model containment="true"
   * @generated
   */
  EList<PhysicalThread> getThreads();

} // NodeClass
