/**
 */
package org.eclipse.etrice.core.etmap.eTMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;

import org.eclipse.etrice.core.room.LogicalThread;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This is the mapping of a logical thread (defined in a ROOM model) to a
 * physical thread (defined in a physical model).
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.ThreadMapping#getLogicalThread <em>Logical Thread</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.ThreadMapping#getPhysicalThread <em>Physical Thread</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getThreadMapping()
 * @model
 * @generated
 */
public interface ThreadMapping extends EObject
{
  /**
   * Returns the value of the '<em><b>Logical Thread</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the logical thread being mapped.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Logical Thread</em>' reference.
   * @see #setLogicalThread(LogicalThread)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getThreadMapping_LogicalThread()
   * @model
   * @generated
   */
  LogicalThread getLogicalThread();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.ThreadMapping#getLogicalThread <em>Logical Thread</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Logical Thread</em>' reference.
   * @see #getLogicalThread()
   * @generated
   */
  void setLogicalThread(LogicalThread value);

  /**
   * Returns the value of the '<em><b>Physical Thread</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the physical thread being mapped to.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Physical Thread</em>' reference.
   * @see #setPhysicalThread(PhysicalThread)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getThreadMapping_PhysicalThread()
   * @model
   * @generated
   */
  PhysicalThread getPhysicalThread();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.ThreadMapping#getPhysicalThread <em>Physical Thread</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Physical Thread</em>' reference.
   * @see #getPhysicalThread()
   * @generated
   */
  void setPhysicalThread(PhysicalThread value);

} // ThreadMapping
