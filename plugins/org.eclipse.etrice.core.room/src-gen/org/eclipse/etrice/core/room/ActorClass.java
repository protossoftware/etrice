/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>Together with {@link ProtocolClass} and {@link DataClass} one of
 * the main class types of the ROOM language.
 * 
 * <p>
 * The actor class in ROOM has three compartments which aren't represented as separate model objects.
 * To understand to which compartment an attribute or reference belongs to here is a list
 * <ul>
 *   <li>Interface: everything which is visible from the outside from a model point of view
 *   <ul>
 *     <li>{@link #getIfPorts}: a list of all interface {@link Port}s</li>
 *     <li>{@link ActorContainerClass#getIfSPPs}: a list of all interface {@link SPPRef}s</li>
 *   </ul>
 *   <li>Structure: all internal structural aspects of an actor class</li>
 *   <ul>
 *     <li>{@link #getUsercode1}-3: user defined code with generator dependent meaning</li>
 *     <li>{@link #getIntPorts}: a list of all internal end {@link Port}s</li>
 *     <li>{@link #getExtPorts}: a list of all {@link ExternalPort}s (the interface ports that
 *        are end ports, not relay ports</li>
 *     <li>{@link #getServiceImplementations}: a list of all {@link ServiceImplementation}s</li>
 *     <li>{@link #getStrSAPs}: a list of all {@link SAPRef}s used by this actor class</li>
 *     <li>{@link #getAttributes}: a list of all actor class {@link Attribute}s</li>
 *     <li>{@link #getActorRefs}: a list of all referenced actor classes (an {@link ActorRef}
 *        has the meaning of a composition)</li>
 *     <li>{@link #getBindings}: a list of all port {@link Binding}s of this actor class</li>
 *     <li>{@link #getConnections}: a list of all {@link LayerConnections}</li>
 *   </ul>
 *   <li>Behavior: the behavioral aspects of an actor class</li>
 *   <ul>
 *     <li>{@link #getOperations}: a list of {@link Operation}s</li>
 *     <li>{@link #getStateMachine}: the {@link StateMachine} definition</li>
 *   </ul>
 * </ul>
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getCommType <em>Comm Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getIfPorts <em>If Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getStructureDocu <em>Structure Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getIntPorts <em>Int Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getExtPorts <em>Ext Ports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getServiceImplementations <em>Service Implementations</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getStrSAPs <em>Str SA Ps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getBehaviorDocu <em>Behavior Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorClass#getBehaviorAnnotations <em>Behavior Annotations</em>}</li>
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>If {@code true} this actor class can not be instantiated and can only be base class
   * for other actor classes.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The communication type of this actor class.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The base class from which all attributes, operations, ports, SAPs
   * and state machine are inherited.
   * 
   * <!-- end-model-doc -->
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
   * Returns the value of the '<em><b>If Ports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Port}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list containing all ports of the actor interface.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>If Ports</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_IfPorts()
   * @model containment="true"
   * @generated
   */
  EList<Port> getIfPorts();

  /**
   * Returns the value of the '<em><b>Structure Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional documentation of the actor structure.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list containing all ports of the actor structure (internal end ports).
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list containing all ports of the actor interface that are end ports.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all service implementations.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all SAPs.
   * 
   * <!-- end-model-doc -->
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
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all actor class private attributes.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Behavior Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional documentation of the actor behavior.
   * 
   * <!-- end-model-doc -->
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
   * Returns the value of the '<em><b>Behavior Annotations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Annotation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of annotations to the actor behavior.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Behavior Annotations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_BehaviorAnnotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getBehaviorAnnotations();

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.StandardOperation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all private operations of this actor class.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorClass_Operations()
   * @model containment="true"
   * @generated
   */
  EList<StandardOperation> getOperations();

  /**
   * Returns the value of the '<em><b>State Machine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the actor's optional state machine.
   * 
   * <!-- end-model-doc -->
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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<Port> ports = new org.eclipse.emf.common.util.BasicEList<Port>();\r\nfor (ExternalPort ep : getExtPorts()) {\r\n\tports.add(ep.getIfport());\r\n}\r\nreturn ports;\r\n'"
   * @generated
   */
  EList<Port> getExternalEndPorts();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<Port> ports = new org.eclipse.emf.common.util.BasicEList<Port>(getIfPorts());\r\nfor (ExternalPort ep : getExtPorts()) {\r\n\tports.remove(ep.getIfport());\r\n}\r\nreturn ports;\r\n'"
   * @generated
   */
  EList<Port> getRelayPorts();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<SPPRef> spps = new org.eclipse.emf.common.util.BasicEList<SPPRef>();\r\nfor (ServiceImplementation spp : getServiceImplementations()) {\r\n\tspps.add(spp.getSpp());\r\n}\r\nreturn spps;\r\n'"
   * @generated
   */
  EList<SPPRef> getImplementedSPPs();

} // ActorClass
