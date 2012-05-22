/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.core.genmodel.etricegen;

import java.util.HashSet;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#isLibrary <em>Library</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getSubSystemInstances <em>Sub System Instances</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getXpActorClasses <em>Xp Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getUsedDataClasses <em>Used Data Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getUsedProtocolClasses <em>Used Protocol Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getUsedActorClasses <em>Used Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getUsedRoomModels <em>Used Room Models</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getSubSystemClasses <em>Sub System Classes</em>}</li>
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
	 * If the meaning of the '<em>Library</em>' attribute isn't clear,
	 * there really should be more of a description here...
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
	 * Returns the value of the '<em><b>Sub System Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub System Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub System Instances</em>' containment reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_SubSystemInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubSystemInstance> getSubSystemInstances();

	/**
	 * Returns the value of the '<em><b>Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.etrice.core.room.RoomModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
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
	 * If the meaning of the '<em>Xp Actor Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
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
	 * If the meaning of the '<em>Used Data Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
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
	 * If the meaning of the '<em>Used Protocol Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
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
	 * If the meaning of the '<em>Used Actor Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
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
	 * If the meaning of the '<em>Used Room Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
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
	 * If the meaning of the '<em>Sub System Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub System Classes</em>' reference list.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getRoot_SubSystemClasses()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SubSystemClass> getSubSystemClasses();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<RoomModel> getReferencedModels(RoomClass cls);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ProtocolClass> getReferencedProtocolClasses(ActorClass cls);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ExpandedActorClass getExpandedActorClass(ActorInstance ai);

	// TODO: is this the right place ?
	HashSet<DataClass> getReferencedDataClasses(DataClass cls);
	HashSet<DataClass> getReferencedDataClasses(ActorClass cls);
	HashSet<DataClass> getReferencedDataClasses(ProtocolClass pc);

	
} // Root
