/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Semantics Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The super class of
 * <ul>
 *   <li>{@link InSemanticsRule}</li>
 *   <li>{@link OutSemanticsRule}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.SemanticsRule#getMsg <em>Msg</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.SemanticsRule#getFollowUps <em>Follow Ups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getSemanticsRule()
 * @model
 * @generated
 */
public interface SemanticsRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The message to which this rule applies.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Msg</em>' reference.
   * @see #setMsg(Message)
   * @see org.eclipse.etrice.core.room.RoomPackage#getSemanticsRule_Msg()
   * @model
   * @generated
   */
  Message getMsg();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.SemanticsRule#getMsg <em>Msg</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Msg</em>' reference.
   * @see #getMsg()
   * @generated
   */
  void setMsg(Message value);

  /**
   * Returns the value of the '<em><b>Follow Ups</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.SemanticsRule}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The possible follow up rules.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Follow Ups</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getSemanticsRule_FollowUps()
   * @model containment="true"
   * @generated
   */
  EList<SemanticsRule> getFollowUps();

} // SemanticsRule
