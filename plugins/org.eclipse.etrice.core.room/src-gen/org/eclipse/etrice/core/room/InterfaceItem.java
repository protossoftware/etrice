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
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof <%org.eclipse.etrice.core.room.Port%>)\n\treturn ((Port) this).getProtocol();\nelse if (this instanceof <%org.eclipse.etrice.core.room.SAP%>)\n\treturn ((SAP) this).getProtocol();\nelse if (this instanceof <%org.eclipse.etrice.core.room.SPP%>)\n\treturn ((SPP) this).getProtocol();\nreturn null;\n'"
   * @generated
   */
  GeneralProtocolClass getGeneralProtocol();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getGeneralProtocol() instanceof <%org.eclipse.etrice.core.room.ProtocolClass%>)\n\treturn ((ProtocolClass)getGeneralProtocol()).getSemantics();\nelse\n\treturn null;\n'"
   * @generated
   */
  ProtocolSemantics getSemantics();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new <%org.eclipse.emf.common.util.BasicEList%><EObject>(new <%org.eclipse.etrice.core.room.util.RoomHelpers%>().getMessageListDeep(this, false));\n'"
   * @generated
   */
  EList<EObject> getAllIncomingAbstractMessages();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new <%org.eclipse.emf.common.util.BasicEList%><EObject>(new <%org.eclipse.etrice.core.room.util.RoomHelpers%>().getMessageListDeep(this, true));\n'"
   * @generated
   */
  EList<EObject> getAllOutgoingAbstractMessages();

} // InterfaceItem
