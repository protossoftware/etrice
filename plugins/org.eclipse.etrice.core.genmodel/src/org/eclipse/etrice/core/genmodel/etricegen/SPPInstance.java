/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.etrice.core.room.SPPRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SPP Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getSpp <em>Spp</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSPPInstance()
 * @model
 * @generated
 */
public interface SPPInstance extends InstanceBase {
	/**
	 * Returns the value of the '<em><b>Spp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spp</em>' reference.
	 * @see #setSpp(SPPRef)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSPPInstance_Spp()
	 * @model
	 * @generated
	 */
	SPPRef getSpp();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getSpp <em>Spp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spp</em>' reference.
	 * @see #getSpp()
	 * @generated
	 */
	void setSpp(SPPRef value);

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getToSPP <em>To SPP</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSPPInstance_Incoming()
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getToSPP
	 * @model opposite="toSPP"
	 * @generated
	 */
	EList<ConnectionInstance> getIncoming();

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromSPP <em>From SPP</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference.
	 * @see #setOutgoing(ConnectionInstance)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSPPInstance_Outgoing()
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromSPP
	 * @model opposite="fromSPP"
	 * @generated
	 */
	ConnectionInstance getOutgoing();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getOutgoing <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' reference.
	 * @see #getOutgoing()
	 * @generated
	 */
	void setOutgoing(ConnectionInstance value);

} // SPPInstance
