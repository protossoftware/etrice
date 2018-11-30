/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.common.base.Documentation;

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
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.InterfaceItem#getDocu <em>Docu</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getInterfaceItem()
 * @model
 * @generated
 */
public interface InterfaceItem extends AbstractInterfaceItem, RoomElement
{
  /**
   * Returns the value of the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional documentation.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Docu</em>' containment reference.
   * @see #setDocu(Documentation)
   * @see org.eclipse.etrice.core.room.RoomPackage#getInterfaceItem_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.InterfaceItem#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof &lt;%org.eclipse.etrice.core.room.Port%&gt;)\r\n\treturn ((Port) this).getProtocol();\r\nelse if (this instanceof &lt;%org.eclipse.etrice.core.room.SAP%&gt;)\r\n\treturn ((SAP) this).getProtocol();\r\nelse if (this instanceof &lt;%org.eclipse.etrice.core.room.SPP%&gt;)\r\n\treturn ((SPP) this).getProtocol();\r\nreturn null;\r\n'"
   * @generated
   */
  GeneralProtocolClass getGeneralProtocol();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getGeneralProtocol() instanceof &lt;%org.eclipse.etrice.core.room.ProtocolClass%&gt;)\r\n\treturn ((ProtocolClass)getGeneralProtocol()).getSemantics();\r\nelse\r\n\treturn null;\r\n'"
   * @generated
   */
  ProtocolSemantics getSemantics();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;EObject&gt;(new &lt;%org.eclipse.etrice.core.room.util.RoomHelpers%&gt;().getMessageListDeep(this, false));\r\n'"
   * @generated
   */
  EList<EObject> getAllIncomingAbstractMessages();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;EObject&gt;(new &lt;%org.eclipse.etrice.core.room.util.RoomHelpers%&gt;().getMessageListDeep(this, true));\r\n'"
   * @generated
   */
  EList<EObject> getAllOutgoingAbstractMessages();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getGeneralProtocol() instanceof ProtocolClass)\r\n    return ((ProtocolClass) getGeneralProtocol()).getCommType() == &lt;%org.eclipse.etrice.core.room.CommunicationType%&gt;.EVENT_DRIVEN;\r\nelse\r\n    return false;\r\n'"
   * @generated
   */
  boolean isEventDriven();

} // InterfaceItem
