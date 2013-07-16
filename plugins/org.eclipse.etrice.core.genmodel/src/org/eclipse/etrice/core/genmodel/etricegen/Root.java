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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>' which represents the root object of the
 * whole generator model.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#isLibrary <em>Library</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getSystemInstances <em>System Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getOwnSubSystemInstances <em>Own Sub System Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getSubSystemInstances <em>Sub System Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getXpActorClasses <em>Xp Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getUsedDataClasses <em>Used Data Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getUsedProtocolClasses <em>Used Protocol Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getUsedActorClasses <em>Used Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getUsedRoomModels <em>Used Room Models</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getSubSystemClasses <em>Sub System Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getOptionalInstances <em>Optional Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Return <code>true</code> if the models form a library. In this case all ROOM classes are transformed
	 * and accessible through this object regardless if they are used (referenced) or not
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library</em>' attribute.
	 * @see #setLibrary(boolean)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_Library()
	 * @model
	 * @generated
	 */
	boolean isLibrary();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#isLibrary <em>Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Library</em>' attribute.
	 * @see #isLibrary()
	 * @generated
	 */
	void setLibrary(boolean value);

	/**
	 * Returns the value of the '<em><b>System Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.SystemInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * A list of all generated system instances.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Instances</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_SystemInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<SystemInstance> getSystemInstances();

	/**
	 * Returns the value of the '<em><b>Own Sub System Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * A list of all generated top level sub system instances (i.e. sub system instances not referenced
	 * by a logical system).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Own Sub System Instances</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_OwnSubSystemInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubSystemInstance> getOwnSubSystemInstances();

	/**
	 * Returns the value of the '<em><b>Sub System Instances</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * A list of all generated sub system instances.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub System Instances</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_SubSystemInstances()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<SubSystemInstance> getSubSystemInstances();

	/**
	 * Returns the value of the '<em><b>Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.room.RoomModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is a collection of all models that have been transformed.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_Models()
	 * @model
	 * @generated
	 */
	EList<RoomModel> getModels();

	/**
	 * Returns the value of the '<em><b>Xp Actor Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is a list of all generated expanded actor classes.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xp Actor Classes</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_XpActorClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpandedActorClass> getXpActorClasses();

	/**
	 * Returns the value of the '<em><b>Used Data Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.room.DataClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is a list of all used data classes (i.e. directly or indirectly referenced starting from the top level object
	 * which is a logical system or, if no such is present, a sub system).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Data Classes</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_UsedDataClasses()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<DataClass> getUsedDataClasses();

	/**
	 * Returns the value of the '<em><b>Used Protocol Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.room.ProtocolClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is a list of all used protocol classes (i.e. directly or indirectly referenced starting from the top level object
	 * which is a logical system or, if no such is present, a sub system).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Protocol Classes</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_UsedProtocolClasses()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<ProtocolClass> getUsedProtocolClasses();

	/**
	 * Returns the value of the '<em><b>Used Actor Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.room.ActorClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is a list of all used actor classes (i.e. directly or indirectly referenced starting from the top level object
	 * which is a logical system or, if no such is present, a sub system).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Actor Classes</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_UsedActorClasses()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<ActorClass> getUsedActorClasses();

	/**
	 * Returns the value of the '<em><b>Used Room Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.room.RoomModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is a list of all used models (i.e. directly or indirectly referenced starting from the top level object
	 * which is a logical system or, if no such is present, a sub system).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Room Models</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_UsedRoomModels()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<RoomModel> getUsedRoomModels();

	/**
	 * Returns the value of the '<em><b>Sub System Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.room.SubSystemClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is a list of all used sub system classes (i.e. directly or indirectly referenced starting from the top level object
	 * which is a logical system or, if no such is present, a sub system).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub System Classes</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_SubSystemClasses()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SubSystemClass> getSubSystemClasses();

	/**
	 * Returns the value of the '<em><b>Optional Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Instances</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_OptionalInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<OptionalActorInstance> getOptionalInstances();

	/**
	 * <!-- begin-user-doc -->
	 * @param cls a room class
	 * @return all room models referenced directly or indirectly by this room class
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<RoomModel> getReferencedModels(RoomClass cls);

	/**
	 * <!-- begin-user-doc -->
	 * @param cls a {@link RoomClass}, actually an {@link ActorClass}
	 * @return all protocol classes that are directly or indirectly referenced by {@code cls} and also
	 *   descending into base classes
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ProtocolClass> getReferencedProtocolClasses(RoomClass cls);

	/**
	 * <!-- begin-user-doc -->
	 * @param cls a {@link RoomClass}, actually a {@link DataClass}, a {@link ProtocoClass} or an {@link ActorClass}
	 * @return all data classes that are directly or indirectly referenced by {@code cls} and also
	 *   descending into base classes
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<DataClass> getReferencedDataClasses(RoomClass cls);

	/**
	 * <!-- begin-user-doc -->
	 * @param cls a {@link RoomClass}, actually a {@link SubSystemClass} or an {@link ActorClass}
	 * @return all actor classes that are directly or indirectly referenced by {@code cls} but not
	 *   descending into base classes
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ActorClass> getReferencedActorClasses(RoomClass cls);

	/**
	 * <!-- begin-user-doc -->
	 * @param ai an actor instance
	 * @return the expanded actor class associated with this instance
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ExpandedActorClass getExpandedActorClass(ActorInstance ai);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	StructureInstance getInstance(String path);

} // Root
