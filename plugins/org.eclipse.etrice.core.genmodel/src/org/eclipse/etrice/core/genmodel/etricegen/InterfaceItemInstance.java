/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.ProtocolClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Item Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getPeers <em>Peers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getInterfaceItemInstance()
 * @model
 * @generated
 */
public interface InterfaceItemInstance extends InstanceBase {
	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' reference.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getInterfaceItemInstance_Protocol()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ProtocolClass getProtocol();

	/**
	 * Returns the value of the '<em><b>Peers</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Peers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Peers</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getInterfaceItemInstance_Peers()
	 * @model
	 * @generated
	 */
	EList<InterfaceItemInstance> getPeers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isReplicated();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isSimple();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isRelay();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	InterfaceItem getInterfaceItem();

} // InterfaceItemInstance
