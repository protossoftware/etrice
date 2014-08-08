/**
 */
package org.eclipse.etrice.core.fsm.fSM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exit Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>An exit point is located at the border of a {@link State}
 * and is visible and accessible outside. Outside
 * it can be the source of a {@link Transition} and inside the target.
 * If it is not connected in the interior then it is a
 * <em>group transition</em>.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getExitPoint()
 * @model
 * @generated
 */
public interface ExitPoint extends TrPoint
{
} // ExitPoint
