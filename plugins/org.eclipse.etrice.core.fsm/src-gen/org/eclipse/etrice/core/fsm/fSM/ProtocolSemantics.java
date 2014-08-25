/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Semantics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>An optional semantics specification as part of a {@link ProtocolClass}.
 * The semantic is defined as a <em>legal execution tree</em>.
 * This tree is composed of incoming and outgoing messages and each path through
 * this tree is a valid sequence of messages exchanged through a port instance.
 * 
 * <p>
 * The semantics are composed using {@link SemanticsRule}s.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getProtocolSemantics()
 * @model
 * @generated
 */
public interface ProtocolSemantics extends EObject
{
  /**
   * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.fsm.fSM.SemanticsRule}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of semantic rules.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Rules</em>' containment reference list.
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getProtocolSemantics_Rules()
   * @model containment="true"
   * @generated
   */
  EList<SemanticsRule> getRules();

} // ProtocolSemantics
