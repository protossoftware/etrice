/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.etrice.core.common.base.Documentation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The super class of
 * <ul>
 *   <li>{@link SimpleState}</li>
 *   <li>{@link RefinedState}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.State#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.State#getEntryCode <em>Entry Code</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.State#getExitCode <em>Exit Code</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.State#getDoCode <em>Do Code</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.State#getSubgraph <em>Subgraph</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getState()
 * @model
 * @generated
 */
public interface State extends StateGraphNode
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
   * @see org.eclipse.etrice.core.room.RoomPackage#getState_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.State#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Entry Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional entry code written in the code generator's target language.
   * It is executed when the state is entered.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Entry Code</em>' containment reference.
   * @see #setEntryCode(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getState_EntryCode()
   * @model containment="true"
   * @generated
   */
  DetailCode getEntryCode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.State#getEntryCode <em>Entry Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Entry Code</em>' containment reference.
   * @see #getEntryCode()
   * @generated
   */
  void setEntryCode(DetailCode value);

  /**
   * Returns the value of the '<em><b>Exit Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional entry code written in the code generator's target language.
   * It is executed when the state is left.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Exit Code</em>' containment reference.
   * @see #setExitCode(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getState_ExitCode()
   * @model containment="true"
   * @generated
   */
  DetailCode getExitCode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.State#getExitCode <em>Exit Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exit Code</em>' containment reference.
   * @see #getExitCode()
   * @generated
   */
  void setExitCode(DetailCode value);

  /**
   * Returns the value of the '<em><b>Do Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional do code written in the code generator's target language.
   * It is executed whenever the actor instance is polled (applies only to
   * data driven and sync actor classes).
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Do Code</em>' containment reference.
   * @see #setDoCode(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getState_DoCode()
   * @model containment="true"
   * @generated
   */
  DetailCode getDoCode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.State#getDoCode <em>Do Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Do Code</em>' containment reference.
   * @see #getDoCode()
   * @generated
   */
  void setDoCode(DetailCode value);

  /**
   * Returns the value of the '<em><b>Subgraph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional sub state graph of this state.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Subgraph</em>' containment reference.
   * @see #setSubgraph(StateGraph)
   * @see org.eclipse.etrice.core.room.RoomPackage#getState_Subgraph()
   * @model containment="true"
   * @generated
   */
  StateGraph getSubgraph();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.State#getSubgraph <em>Subgraph</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subgraph</em>' containment reference.
   * @see #getSubgraph()
   * @generated
   */
  void setSubgraph(StateGraph value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (this instanceof <%org.eclipse.etrice.core.room.SimpleState%>)? ((SimpleState)this).getName() :(this instanceof <%org.eclipse.etrice.core.room.RefinedState%>)? (((RefinedState)this).getTarget()==null? \"\":((RefinedState)this).getTarget().getName()) :\"\";'"
   * @generated
   */
  String getName();

} // State
