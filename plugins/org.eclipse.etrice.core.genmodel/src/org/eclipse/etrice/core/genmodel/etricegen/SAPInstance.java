/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.etrice.core.room.SAPRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAP Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance#getSap <em>Sap</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSAPInstance()
 * @model
 * @generated
 */
public interface SAPInstance extends InterfaceItemInstance {
	/**
	 * Returns the value of the '<em><b>Sap</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sap</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sap</em>' reference.
	 * @see #setSap(SAPRef)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSAPInstance_Sap()
	 * @model
	 * @generated
	 */
	SAPRef getSap();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance#getSap <em>Sap</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sap</em>' reference.
	 * @see #getSap()
	 * @generated
	 */
	void setSap(SAPRef value);

} // SAPInstance
