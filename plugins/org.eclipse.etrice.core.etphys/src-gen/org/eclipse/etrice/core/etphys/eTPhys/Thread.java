/**
 */
package org.eclipse.etrice.core.etphys.eTPhys;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#getExecmode <em>Execmode</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#getPrio <em>Prio</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#getStacksize <em>Stacksize</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getThread()
 * @model
 * @generated
 */
public interface Thread extends EObject
{
  /**
   * Returns the value of the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' attribute.
   * @see #setDefault(boolean)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getThread_Default()
   * @model
   * @generated
   */
  boolean isDefault();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#isDefault <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' attribute.
   * @see #isDefault()
   * @generated
   */
  void setDefault(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getThread_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Execmode</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.etrice.core.etphys.eTPhys.ExecMode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Execmode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Execmode</em>' attribute.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ExecMode
   * @see #setExecmode(ExecMode)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getThread_Execmode()
   * @model
   * @generated
   */
  ExecMode getExecmode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#getExecmode <em>Execmode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Execmode</em>' attribute.
   * @see org.eclipse.etrice.core.etphys.eTPhys.ExecMode
   * @see #getExecmode()
   * @generated
   */
  void setExecmode(ExecMode value);

  /**
   * Returns the value of the '<em><b>Prio</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prio</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prio</em>' attribute.
   * @see #setPrio(int)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getThread_Prio()
   * @model
   * @generated
   */
  int getPrio();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#getPrio <em>Prio</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prio</em>' attribute.
   * @see #getPrio()
   * @generated
   */
  void setPrio(int value);

  /**
   * Returns the value of the '<em><b>Stacksize</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stacksize</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stacksize</em>' attribute.
   * @see #setStacksize(int)
   * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage#getThread_Stacksize()
   * @model
   * @generated
   */
  int getStacksize();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etphys.eTPhys.Thread#getStacksize <em>Stacksize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stacksize</em>' attribute.
   * @see #getStacksize()
   * @generated
   */
  void setStacksize(int value);

} // Thread
