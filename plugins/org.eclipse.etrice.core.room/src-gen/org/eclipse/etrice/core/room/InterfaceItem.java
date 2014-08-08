/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This is a concrete sub class of an {@link AbstractInterfaceItem}.
 * 
 * It is the super class of
 * <ul>
 *   <li>{@link Port}</li>
 *   <li>{@link SAP}</li>
 *   <li>{@link SPP}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getInterfaceItem()
 * @model
 * @generated
 */
public interface InterfaceItem extends AbstractInterfaceItem
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof <%org.eclipse.etrice.core.room.Port%>)\r\n\treturn ((Port) this).getProtocol();\r\nelse if (this instanceof <%org.eclipse.etrice.core.room.SAP%>)\r\n\treturn ((SAP) this).getProtocol();\r\nelse if (this instanceof <%org.eclipse.etrice.core.room.SPP%>)\r\n\treturn ((SPP) this).getProtocol();\r\nreturn null;\r\n'"
   * @generated
   */
  GeneralProtocolClass getGeneralProtocol();

} // InterfaceItem
