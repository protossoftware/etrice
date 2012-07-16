/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.PortClass#getUserCode <em>User Code</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.PortClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.PortClass#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.PortClass#getMsgHandlers <em>Msg Handlers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getPortClass()
 * @model
 * @generated
 */
public interface PortClass extends EObject
{
  /**
   * Returns the value of the '<em><b>User Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Code</em>' containment reference.
   * @see #setUserCode(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getPortClass_UserCode()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.PortClass#getUserCode <em>User Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code</em>' containment reference.
   * @see #getUserCode()
   * @generated
   */
  void setUserCode(DetailCode value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getPortClass_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.PortOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getPortClass_Operations()
   * @model containment="true"
   * @generated
   */
  EList<PortOperation> getOperations();

  /**
   * Returns the value of the '<em><b>Msg Handlers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.MessageHandler}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Msg Handlers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Msg Handlers</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getPortClass_MsgHandlers()
   * @model containment="true"
   * @generated
   */
  EList<MessageHandler> getMsgHandlers();

} // PortClass
