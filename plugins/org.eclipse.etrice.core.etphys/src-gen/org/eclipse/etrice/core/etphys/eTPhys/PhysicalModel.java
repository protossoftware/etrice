/**
 */
package org.eclipse.etrice.core.etphys.eTPhys;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physical Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The root object for the physical model. It gives access to the systems, node classes
 * and runtimes defined.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getSystems <em>Systems</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getNodeClasses <em>Node Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getRuntimeClasses <em>Runtime Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalModel()
 * @model
 * @generated
 */
public interface PhysicalModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The model name is a dot separated fully qualified name and is
   * used to provide a name space.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.etphys.eTPhys.Import}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A list of all imported models.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalModel_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Systems</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A list of all defined physical systems.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Systems</em>' containment reference list.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalModel_Systems()
   * @model containment="true"
   * @generated
   */
  EList<PhysicalSystem> getSystems();

  /**
   * Returns the value of the '<em><b>Node Classes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.etphys.eTPhys.NodeClass}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A list of all defined node classes.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Node Classes</em>' containment reference list.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalModel_NodeClasses()
   * @model containment="true"
   * @generated
   */
  EList<NodeClass> getNodeClasses();

  /**
   * Returns the value of the '<em><b>Runtime Classes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A list of all defined runtime classes.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Runtime Classes</em>' containment reference list.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getPhysicalModel_RuntimeClasses()
   * @model containment="true"
   * @generated
   */
  EList<RuntimeClass> getRuntimeClasses();

} // PhysicalModel
