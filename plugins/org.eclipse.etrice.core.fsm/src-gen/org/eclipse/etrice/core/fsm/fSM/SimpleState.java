/**
 */
package org.eclipse.etrice.core.fsm.fSM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A simple state is the standard case of a @link State}.
 * It comprises and <em>entry</em>, <em>exit</em> and <em>do</em> code
 * and it can contain another {@link StateGraph} as sub state
 * graph.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.SimpleState#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getSimpleState()
 * @model
 * @generated
 */
public interface SimpleState extends State
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>By this name the state is referred to in the model.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getSimpleState_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.SimpleState#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // SimpleState
