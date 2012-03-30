/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen;

import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.ActorInstance#getActorClass <em>Actor Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.ActorInstance#getReplIdx <em>Repl Idx</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.ActorInstance#getUnindexedName <em>Unindexed Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getActorInstance()
 * @model
 * @generated
 */
public interface ActorInstance extends StructureInstance {
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
	 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getActorInstance_ActorClass()
	 * @model
	 * @generated
	 */
	ActorClass getActorClass();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.generator.etricegen.ActorInstance#getActorClass <em>Actor Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor Class</em>' reference.
	 * @see #getActorClass()
	 * @generated
	 */
	void setActorClass(ActorClass value);

	/**
	 * Returns the value of the '<em><b>Repl Idx</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repl Idx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repl Idx</em>' attribute.
	 * @see #setReplIdx(int)
	 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getActorInstance_ReplIdx()
	 * @model default="-1"
	 * @generated
	 */
	int getReplIdx();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.generator.etricegen.ActorInstance#getReplIdx <em>Repl Idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repl Idx</em>' attribute.
	 * @see #getReplIdx()
	 * @generated
	 */
	void setReplIdx(int value);

	/**
	 * Returns the value of the '<em><b>Unindexed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unindexed Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unindexed Name</em>' attribute.
	 * @see org.eclipse.etrice.generator.etricegen.ETriceGenPackage#getActorInstance_UnindexedName()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getUnindexedName();

} // ActorInstance
