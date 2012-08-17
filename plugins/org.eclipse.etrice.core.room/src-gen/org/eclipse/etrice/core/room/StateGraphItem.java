/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Graph Item</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getStateGraphItem()
 * @model
 * @generated
 */
public interface StateGraphItem extends EObject
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof org.eclipse.etrice.core.room.State) return ((org.eclipse.etrice.core.room.State)this).getName();\nelse if (this instanceof org.eclipse.etrice.core.room.TrPoint) return ((org.eclipse.etrice.core.room.TrPoint)this).getName();\nelse if (this instanceof org.eclipse.etrice.core.room.ChoicePoint) return ((org.eclipse.etrice.core.room.ChoicePoint)this).getName();\nelse if (this instanceof org.eclipse.etrice.core.room.Transition) return ((org.eclipse.etrice.core.room.Transition)this).getName();\nreturn \"\";'"
   * @generated
   */
  String getName();

} // StateGraphItem
