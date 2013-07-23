/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A service implementation can be reagrded as the replicated peer port of all {@link SAPRef}s
 * that are bound to it following the service resolution logic.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ServiceImplementation#getSpp <em>Spp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getServiceImplementation()
 * @model
 * @generated
 */
public interface ServiceImplementation extends EObject
{
  /**
   * Returns the value of the '<em><b>Spp</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the SPP connected to the service.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Spp</em>' reference.
   * @see #setSpp(SPPRef)
   * @see org.eclipse.etrice.core.room.RoomPackage#getServiceImplementation_Spp()
   * @model
   * @generated
   */
  SPPRef getSpp();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ServiceImplementation#getSpp <em>Spp</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Spp</em>' reference.
   * @see #getSpp()
   * @generated
   */
  void setSpp(SPPRef value);

} // ServiceImplementation
