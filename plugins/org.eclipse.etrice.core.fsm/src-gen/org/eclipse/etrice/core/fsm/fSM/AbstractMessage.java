/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A message in ROOM is part of a {@link ProtocolClass}. Messages are exchanged via {@link Port}s.
 * For event driven protocols the message is an object that is deliverd using a message
 * service of the runtime. For data driven systems only messages holding data are valid. In this
 * case the conjugate port is the one holding (and writing) the data and the regular port is
 * reading the data.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.AbstractMessage#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getAbstractMessage()
 * @model
 * @generated
 */
public interface AbstractMessage extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>An abstract message to be overridden in derived grammars.
   * By this name the message is referred to in the model.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getAbstractMessage_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.AbstractMessage#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // AbstractMessage
