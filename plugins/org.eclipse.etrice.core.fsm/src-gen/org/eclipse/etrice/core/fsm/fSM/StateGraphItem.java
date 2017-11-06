/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Graph Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The super class of
 * <ul>
 *   <li>{@link StateGraphNode}</li>
 *   <li>{@link Transition}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getStateGraphItem()
 * @model
 * @generated
 */
public interface StateGraphItem extends EObject
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.State%>) \r\n\treturn ((State)this).getName();\r\nelse if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.TrPoint%>)\r\n\treturn ((TrPoint)this).getName();\r\nelse if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.ChoicePoint%>)\r\n\treturn ((ChoicePoint)this).getName();\r\nelse if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.Transition%>)\r\n\treturn ((Transition)this).getName();\r\nelse if (this instanceof <%org.eclipse.etrice.core.fsm.fSM.RefinedTransition%>)\r\n\treturn ((RefinedTransition)this).getTarget().getName();\r\nreturn \"\";\r\n'"
   * @generated
   */
  String getName();

} // StateGraphItem
