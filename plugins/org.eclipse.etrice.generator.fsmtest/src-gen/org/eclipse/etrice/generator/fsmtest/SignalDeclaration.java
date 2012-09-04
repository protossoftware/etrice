/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getSigname <em>Signame</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getIntVal <em>Int Val</em>}</li>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getStrVal <em>Str Val</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getSignalDeclaration()
 * @model
 * @generated
 */
public interface SignalDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port</em>' attribute.
   * @see #setPort(String)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getSignalDeclaration_Port()
   * @model
   * @generated
   */
  String getPort();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getPort <em>Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port</em>' attribute.
   * @see #getPort()
   * @generated
   */
  void setPort(String value);

  /**
   * Returns the value of the '<em><b>Signame</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signame</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signame</em>' attribute.
   * @see #setSigname(String)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getSignalDeclaration_Signame()
   * @model
   * @generated
   */
  String getSigname();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getSigname <em>Signame</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signame</em>' attribute.
   * @see #getSigname()
   * @generated
   */
  void setSigname(String value);

  /**
   * Returns the value of the '<em><b>Int Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Int Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Int Val</em>' attribute.
   * @see #setIntVal(int)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getSignalDeclaration_IntVal()
   * @model
   * @generated
   */
  int getIntVal();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getIntVal <em>Int Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Int Val</em>' attribute.
   * @see #getIntVal()
   * @generated
   */
  void setIntVal(int value);

  /**
   * Returns the value of the '<em><b>Str Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Str Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Str Val</em>' attribute.
   * @see #setStrVal(String)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getSignalDeclaration_StrVal()
   * @model
   * @generated
   */
  String getStrVal();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.SignalDeclaration#getStrVal <em>Str Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Str Val</em>' attribute.
   * @see #getStrVal()
   * @generated
   */
  void setStrVal(String value);

} // SignalDeclaration
