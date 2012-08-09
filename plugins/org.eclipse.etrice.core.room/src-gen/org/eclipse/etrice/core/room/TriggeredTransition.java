/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Triggered Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.TriggeredTransition#getTriggers <em>Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getTriggeredTransition()
 * @model
 * @generated
 */
public interface TriggeredTransition extends TransitionChainStartTransition
{
  /**
   * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Trigger}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getTriggeredTransition_Triggers()
   * @model containment="true"
   * @generated
   */
  EList<Trigger> getTriggers();

} // TriggeredTransition
