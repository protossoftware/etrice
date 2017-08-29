/**
 *  Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  CONTRIBUTORS:
 *  		Henrik Rentz-Reichert (initial contribution)
 *  
 */
package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optional Actor Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance#getRequiredServices <em>Required Services</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getOptionalActorInstance()
 * @model
 * @generated
 */
public interface OptionalActorInstance extends StructureInstance {
	/**
	 * Returns the value of the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Class</em>' reference.
	 * @see #setActorClass(ActorClass)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getOptionalActorInstance_ActorClass()
	 * @model
	 * @generated
	 */
	ActorClass getActorClass();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance#getActorClass <em>Actor Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor Class</em>' reference.
	 * @see #getActorClass()
	 * @generated
	 */
	void setActorClass(ActorClass value);

	/**
	 * Returns the value of the '<em><b>Required Services</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Services</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getOptionalActorInstance_RequiredServices()
	 * @model
	 * @generated
	 */
	EList<SAPInstance> getRequiredServices();

} // OptionalActorInstance
