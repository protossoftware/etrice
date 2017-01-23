/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.etrice.core.fsm.fSM.DetailCode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Container Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This class is the super class of the structural classes
 * <ul>
 *   <li>{@link ActorClass}</li>
 *   <li>{@link SubSystemClass}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ActorContainerClass#getServiceProvisionPoints <em>Service Provision Points</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode1 <em>User Code1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode2 <em>User Code2</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode3 <em>User Code3</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorContainerClass#getActorRefs <em>Actor Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass()
 * @model
 * @generated
 */
public interface ActorContainerClass extends StructureClass
{
  /**
   * Returns the value of the '<em><b>Service Provision Points</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.SPP}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all interface SPPs.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Service Provision Points</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass_ServiceProvisionPoints()
   * @model containment="true"
   * @generated
   */
  EList<SPP> getServiceProvisionPoints();

  /**
   * Returns the value of the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The user code is treated in a generator dependent way.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>User Code1</em>' containment reference.
   * @see #setUserCode1(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass_UserCode1()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode1();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode1 <em>User Code1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code1</em>' containment reference.
   * @see #getUserCode1()
   * @generated
   */
  void setUserCode1(DetailCode value);

  /**
   * Returns the value of the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The user code is treated in a generator dependent way.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>User Code2</em>' containment reference.
   * @see #setUserCode2(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass_UserCode2()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode2();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode2 <em>User Code2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code2</em>' containment reference.
   * @see #getUserCode2()
   * @generated
   */
  void setUserCode2(DetailCode value);

  /**
   * Returns the value of the '<em><b>User Code3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The user code is treated in a generator dependent way.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>User Code3</em>' containment reference.
   * @see #setUserCode3(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass_UserCode3()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode3();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode3 <em>User Code3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code3</em>' containment reference.
   * @see #getUserCode3()
   * @generated
   */
  void setUserCode3(DetailCode value);

  /**
   * Returns the value of the '<em><b>Actor Refs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ActorRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all actor refs.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Actor Refs</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass_ActorRefs()
   * @model containment="true"
   * @generated
   */
  EList<ActorRef> getActorRefs();

} // ActorContainerClass
