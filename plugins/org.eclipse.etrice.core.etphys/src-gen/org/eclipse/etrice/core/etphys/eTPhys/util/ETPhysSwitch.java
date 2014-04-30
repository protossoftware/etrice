/**
 */
package org.eclipse.etrice.core.etphys.eTPhys.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.etrice.core.etphys.eTPhys.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage
 * @generated
 */
public class ETPhysSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ETPhysPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ETPhysSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ETPhysPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ETPhysPackage.PHYSICAL_MODEL:
      {
        PhysicalModel physicalModel = (PhysicalModel)theEObject;
        T result = casePhysicalModel(physicalModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ETPhysPackage.PHYSICAL_SYSTEM:
      {
        PhysicalSystem physicalSystem = (PhysicalSystem)theEObject;
        T result = casePhysicalSystem(physicalSystem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ETPhysPackage.NODE_REF:
      {
        NodeRef nodeRef = (NodeRef)theEObject;
        T result = caseNodeRef(nodeRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ETPhysPackage.NODE_CLASS:
      {
        NodeClass nodeClass = (NodeClass)theEObject;
        T result = caseNodeClass(nodeClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ETPhysPackage.PHYSICAL_THREAD:
      {
        PhysicalThread physicalThread = (PhysicalThread)theEObject;
        T result = casePhysicalThread(physicalThread);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ETPhysPackage.RUNTIME_CLASS:
      {
        RuntimeClass runtimeClass = (RuntimeClass)theEObject;
        T result = caseRuntimeClass(runtimeClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ETPhysPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Physical Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Physical Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePhysicalModel(PhysicalModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Physical System</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Physical System</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePhysicalSystem(PhysicalSystem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNodeRef(NodeRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNodeClass(NodeClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Physical Thread</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Physical Thread</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePhysicalThread(PhysicalThread object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Runtime Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Runtime Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuntimeClass(RuntimeClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ETPhysSwitch
