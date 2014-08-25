/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics;

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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getGeneralProtocol() instanceof <%org.eclipse.etrice.core.room.ProtocolClass%>)\r\n\treturn ((ProtocolClass)getGeneralProtocol()).getSemantics();\r\nelse\r\n\treturn null;\r\n'"
   * @generated
   */
  ProtocolSemantics getSemantics();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new <%org.eclipse.emf.common.util.BasicEList%><EObject>(new <%org.eclipse.etrice.core.room.util.RoomHelpers%>().getMessageListDeep(this, false));\r\n'"
   * @generated
   */
  EList<EObject> getAllIncomingAbstractMessages();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new <%org.eclipse.emf.common.util.BasicEList%><EObject>(new <%org.eclipse.etrice.core.room.util.RoomHelpers%>().getMessageListDeep(this, true));\r\n'"
   * @generated
   */
  EList<EObject> getAllOutgoingAbstractMessages();

} // InterfaceItem
