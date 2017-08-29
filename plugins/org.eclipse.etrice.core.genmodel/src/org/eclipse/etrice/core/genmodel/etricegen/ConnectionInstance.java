/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.SPP;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Instance</b></em>'.
 * In the instance model each layer connection is turned into a connection instance.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromAI <em>From AI</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromSPP <em>From SPP</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getToSPP <em>To SPP</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getConnection <em>Connection</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getConnectionInstance()
 * @model
 * @generated
 */
public interface ConnectionInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>From AI</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is the source {@link ActorInstance} of this connection.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From AI</em>' reference.
	 * @see #setFromAI(AbstractInstance)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getConnectionInstance_FromAI()
	 * @model
	 * @generated
	 */
	AbstractInstance getFromAI();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromAI <em>From AI</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From AI</em>' reference.
	 * @see #getFromAI()
	 * @generated
	 */
	void setFromAI(AbstractInstance value);

	/**
	 * Returns the value of the '<em><b>From SPP</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is the source {@link SPP} of this connection.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From SPP</em>' reference.
	 * @see #setFromSPP(SPPInstance)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getConnectionInstance_FromSPP()
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getOutgoing
	 * @model opposite="outgoing"
	 * @generated
	 */
	SPPInstance getFromSPP();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromSPP <em>From SPP</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From SPP</em>' reference.
	 * @see #getFromSPP()
	 * @generated
	 */
	void setFromSPP(SPPInstance value);

	/**
	 * Returns the value of the '<em><b>To SPP</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is the destination {@link SPP} of this connection.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To SPP</em>' reference.
	 * @see #setToSPP(SPPInstance)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getConnectionInstance_ToSPP()
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getIncoming
	 * @model opposite="incoming"
	 * @generated
	 */
	SPPInstance getToSPP();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getToSPP <em>To SPP</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To SPP</em>' reference.
	 * @see #getToSPP()
	 * @generated
	 */
	void setToSPP(SPPInstance value);

	/**
	 * Returns the value of the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is a reference to the original {@link LayerConnection}.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection</em>' reference.
	 * @see #setConnection(LayerConnection)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getConnectionInstance_Connection()
	 * @model
	 * @generated
	 */
	LayerConnection getConnection();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getConnection <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection</em>' reference.
	 * @see #getConnection()
	 * @generated
	 */
	void setConnection(LayerConnection value);

} // ConnectionInstance
