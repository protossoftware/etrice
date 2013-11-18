/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A state graph is a directed graph composed of
 * {@link StateGraphNode}s as nodes and {@link Transition}s as edges.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.StateGraph#getStates <em>States</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.StateGraph#getTrPoints <em>Tr Points</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.StateGraph#getChPoints <em>Ch Points</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.StateGraph#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.StateGraph#getRefinedTransitions <em>Refined Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getStateGraph()
 * @model
 * @generated
 */
public interface StateGraph extends EObject
{
  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.State}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all states of this state graph.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getStateGraph_States()
   * @model containment="true"
   * @generated
   */
  EList<State> getStates();

  /**
   * Returns the value of the '<em><b>Tr Points</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.TrPoint}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all transition, entry and exit points of this state graph.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Tr Points</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getStateGraph_TrPoints()
   * @model containment="true"
   * @generated
   */
  EList<TrPoint> getTrPoints();

  /**
   * Returns the value of the '<em><b>Ch Points</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ChoicePoint}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all choice points of this state graph.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ch Points</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getStateGraph_ChPoints()
   * @model containment="true"
   * @generated
   */
  EList<ChoicePoint> getChPoints();

  /**
   * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Transition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all transitions of this state graph.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Transitions</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getStateGraph_Transitions()
   * @model containment="true"
   * @generated
   */
  EList<Transition> getTransitions();

  /**
   * Returns the value of the '<em><b>Refined Transitions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.RefinedTransition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all refined transitions of this state graph.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Refined Transitions</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getStateGraph_RefinedTransitions()
   * @model containment="true"
   * @generated
   */
  EList<RefinedTransition> getRefinedTransitions();

} // StateGraph
