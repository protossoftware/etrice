/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Protocol Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This special protocol class is used to bundle several protocols
 * in relay ports. This can be useful to avoid parallel chains
 * of {@link Binding}s traversing the structural hierarchy.
 * <p>
 * The compound protocol class consists of several {@link SubProtocol}s.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.CompoundProtocolClass#getSubProtocols <em>Sub Protocols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getCompoundProtocolClass()
 * @model
 * @generated
 */
public interface CompoundProtocolClass extends GeneralProtocolClass
{
  /**
   * Returns the value of the '<em><b>Sub Protocols</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.SubProtocol}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of sub protocols.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Sub Protocols</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getCompoundProtocolClass_SubProtocols()
   * @model containment="true"
   * @generated
   */
  EList<SubProtocol> getSubProtocols();

} // CompoundProtocolClass
