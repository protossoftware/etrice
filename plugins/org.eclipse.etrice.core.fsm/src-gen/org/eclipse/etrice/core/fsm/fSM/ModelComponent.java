/**
 */
package org.eclipse.etrice.core.fsm.fSM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getCommType <em>Comm Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getComponentName <em>Component Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getModelComponent()
 * @model
 * @generated
 */
public interface ModelComponent extends IInterfaceItemOwner
{
  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getModelComponent_Abstract()
   * @model
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Comm Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comm Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comm Type</em>' attribute.
   * @see org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
   * @see #setCommType(ComponentCommunicationType)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getModelComponent_CommType()
   * @model
   * @generated
   */
  ComponentCommunicationType getCommType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getCommType <em>Comm Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comm Type</em>' attribute.
   * @see org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
   * @see #getCommType()
   * @generated
   */
  void setCommType(ComponentCommunicationType value);

  /**
   * Returns the value of the '<em><b>Component Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Name</em>' attribute.
   * @see #setComponentName(String)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getModelComponent_ComponentName()
   * @model
   * @generated
   */
  String getComponentName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getComponentName <em>Component Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component Name</em>' attribute.
   * @see #getComponentName()
   * @generated
   */
  void setComponentName(String value);

  /**
   * Returns the value of the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' reference.
   * @see #setBase(ModelComponent)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getModelComponent_Base()
   * @model
   * @generated
   */
  ModelComponent getBase();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getBase <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' reference.
   * @see #getBase()
   * @generated
   */
  void setBase(ModelComponent value);

  /**
   * Returns the value of the '<em><b>State Machine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Machine</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Machine</em>' containment reference.
   * @see #setStateMachine(StateGraph)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getModelComponent_StateMachine()
   * @model containment="true"
   * @generated
   */
  StateGraph getStateMachine();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.ModelComponent#getStateMachine <em>State Machine</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Machine</em>' containment reference.
   * @see #getStateMachine()
   * @generated
   */
  void setStateMachine(StateGraph value);

} // ModelComponent
