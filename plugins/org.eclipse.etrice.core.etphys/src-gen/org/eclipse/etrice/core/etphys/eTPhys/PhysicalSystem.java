/**
 */
package org.eclipse.etrice.core.etphys.eTPhys;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.common.base.Documentation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physical System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This model object represents a complete physical system.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getNodeRefs <em>Node Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalSystem()
 * @model
 * @generated
 */
public interface PhysicalSystem extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The name of the physical system by which it is referred to in the model.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalSystem_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getName <em>Name</em>}' attribute.
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional documentation.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Docu</em>' containment reference.
   * @see #setDocu(Documentation)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalSystem_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Node Refs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.etphys.eTPhys.NodeRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>A list of referenced nodes.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Node Refs</em>' containment reference list.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalSystem_NodeRefs()
   * @model containment="true"
   * @generated
   */
  EList<NodeRef> getNodeRefs();

} // PhysicalSystem
