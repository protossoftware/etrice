/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expanded Actor Class</b></em>'.
 * The expanded actor class holds a state machine which includes all inherited state graph items
 * and has the refined states replaced with simple states.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getGraphContainer <em>Graph Container</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedActorClass()
 * @model
 * @generated
 */
public interface ExpandedActorClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * A reference to the original {@link ActorClass}.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Class</em>' reference.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedActorClass_ActorClass()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ActorClass getActorClass();

	/**
	 * Returns the value of the '<em><b>Graph Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph Container</em>' containment reference.
	 * @see #setGraphContainer(GraphContainer)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedActorClass_GraphContainer()
	 * @model containment="true"
	 * @generated
	 */
	GraphContainer getGraphContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getGraphContainer <em>Graph Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph Container</em>' containment reference.
	 * @see #getGraphContainer()
	 * @generated
	 */
	void setGraphContainer(GraphContainer value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getInterfaceItemLocalId(AbstractInterfaceItem ifitem);

} // ExpandedActorClass
