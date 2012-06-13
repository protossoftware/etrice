/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getCommType <em>Comm Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getGeneralAnnotations <em>General Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getIfPorts <em>If Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getStructureDocu <em>Structure Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getIntPorts <em>Int Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getExtPorts <em>Ext Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getServiceImplementations <em>Service Implementations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getStrSAPs <em>Str SA Ps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getBehaviorDocu <em>Behavior Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass()
 * @model
 * @generated
 */
public interface ActorClass extends ActorContainerClass
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
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_Abstract()
   * @model
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorClass#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Comm Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.room.ActorCommunicationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comm Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comm Type</em>' attribute.
   * @see org.eclipse.etrice.core.room.ActorCommunicationType
   * @see #setCommType(ActorCommunicationType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_CommType()
   * @model
   * @generated
   */
  ActorCommunicationType getCommType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorClass#getCommType <em>Comm Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comm Type</em>' attribute.
   * @see org.eclipse.etrice.core.room.ActorCommunicationType
   * @see #getCommType()
   * @generated
   */
  void setCommType(ActorCommunicationType value);

  /**
   * Returns the value of the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' reference.
   * @see #setBase(ActorClass)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_Base()
   * @model
   * @generated
   */
  ActorClass getBase();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorClass#getBase <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' reference.
   * @see #getBase()
   * @generated
   */
  void setBase(ActorClass value);

  /**
   * Returns the value of the '<em><b>General Annotations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Annotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>General Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>General Annotations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_GeneralAnnotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getGeneralAnnotations();

  /**
   * Returns the value of the '<em><b>If Ports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If Ports</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_IfPorts()
   * @model containment="true"
   * @generated
   */
  EList<Port> getIfPorts();

  /**
   * Returns the value of the '<em><b>Structure Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Structure Docu</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Structure Docu</em>' containment reference.
   * @see #setStructureDocu(Documentation)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_StructureDocu()
   * @model containment="true"
   * @generated
   */
  Documentation getStructureDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorClass#getStructureDocu <em>Structure Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Structure Docu</em>' containment reference.
   * @see #getStructureDocu()
   * @generated
   */
  void setStructureDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Int Ports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Int Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Int Ports</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_IntPorts()
   * @model containment="true"
   * @generated
   */
  EList<Port> getIntPorts();

  /**
   * Returns the value of the '<em><b>Ext Ports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ExternalPort}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ext Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ext Ports</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_ExtPorts()
   * @model containment="true"
   * @generated
   */
  EList<ExternalPort> getExtPorts();

  /**
   * Returns the value of the '<em><b>Service Implementations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ServiceImplementation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service Implementations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Service Implementations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_ServiceImplementations()
   * @model containment="true"
   * @generated
   */
  EList<ServiceImplementation> getServiceImplementations();

  /**
   * Returns the value of the '<em><b>Str SA Ps</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.SAPRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Str SA Ps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Str SA Ps</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_StrSAPs()
   * @model containment="true"
   * @generated
   */
  EList<SAPRef> getStrSAPs();

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
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Behavior Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behavior Docu</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behavior Docu</em>' containment reference.
   * @see #setBehaviorDocu(Documentation)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_BehaviorDocu()
   * @model containment="true"
   * @generated
   */
  Documentation getBehaviorDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorClass#getBehaviorDocu <em>Behavior Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behavior Docu</em>' containment reference.
   * @see #getBehaviorDocu()
   * @generated
   */
  void setBehaviorDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Annotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.StandardOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_Operations()
   * @model containment="true"
   * @generated
   */
  EList<StandardOperation> getOperations();

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
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_StateMachine()
   * @model containment="true"
   * @generated
   */
  StateGraph getStateMachine();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorClass#getStateMachine <em>State Machine</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Machine</em>' containment reference.
   * @see #getStateMachine()
   * @generated
   */
  void setStateMachine(StateGraph value);

} // ActorClass
