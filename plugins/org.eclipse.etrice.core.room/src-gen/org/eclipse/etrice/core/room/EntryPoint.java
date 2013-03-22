/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An entry point is located at the border of a {@link State}
 * and is visible and accessible outside. Outside
 * it can be the target of a {@link Transition} and inside the source.
 * If it is not connected in the interior then it is a
 * <em>transition to history</em>.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getEntryPoint()
 * @model
 * @generated
 */
public interface EntryPoint extends TrPoint
{
} // EntryPoint
