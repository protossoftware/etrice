/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The super class of
 * <ul>
 *   <li>{@link Port}</li>
 *   <li>{@link SAPRef}</li>
 *   <li>{@link SPPRef}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.InterfaceItem#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getInterfaceItem()
 * @model
 * @generated
 */
public interface InterfaceItem extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>By this name the interface item is referred to in the model.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getInterfaceItem_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.InterfaceItem#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof org.eclipse.etrice.core.room.Port)\r\n\treturn ((org.eclipse.etrice.core.room.Port) this).getProtocol();\r\nelse if (this instanceof org.eclipse.etrice.core.room.SAP)\r\n\treturn ((org.eclipse.etrice.core.room.SAP) this).getProtocol();\r\nelse if (this instanceof org.eclipse.etrice.core.room.SPP)\r\n\treturn ((org.eclipse.etrice.core.room.SPP) this).getProtocol();\r\nreturn null;\r\n'"
   * @generated
   */
  GeneralProtocolClass getGeneralProtocol();

} // InterfaceItem
