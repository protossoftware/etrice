/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.etricegen.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.etrice.core.genmodel.etricegen.*;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.BindingInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.OpenBinding;
import org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SPPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass;

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
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage
 * @generated
 */
public class ETriceGenSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ETriceGenPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETriceGenSwitch() {
		if (modelPackage == null) {
			modelPackage = ETriceGenPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
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
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ETriceGenPackage.ROOT: {
				Root root = (Root)theEObject;
				T result = caseRoot(root);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.INSTANCE_BASE: {
				InstanceBase instanceBase = (InstanceBase)theEObject;
				T result = caseInstanceBase(instanceBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.ABSTRACT_INSTANCE: {
				AbstractInstance abstractInstance = (AbstractInstance)theEObject;
				T result = caseAbstractInstance(abstractInstance);
				if (result == null) result = caseInstanceBase(abstractInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.ACTOR_INTERFACE_INSTANCE: {
				ActorInterfaceInstance actorInterfaceInstance = (ActorInterfaceInstance)theEObject;
				T result = caseActorInterfaceInstance(actorInterfaceInstance);
				if (result == null) result = caseAbstractInstance(actorInterfaceInstance);
				if (result == null) result = caseInstanceBase(actorInterfaceInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.STRUCTURE_INSTANCE: {
				StructureInstance structureInstance = (StructureInstance)theEObject;
				T result = caseStructureInstance(structureInstance);
				if (result == null) result = caseAbstractInstance(structureInstance);
				if (result == null) result = caseInstanceBase(structureInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.SYSTEM_INSTANCE: {
				SystemInstance systemInstance = (SystemInstance)theEObject;
				T result = caseSystemInstance(systemInstance);
				if (result == null) result = caseInstanceBase(systemInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.SUB_SYSTEM_INSTANCE: {
				SubSystemInstance subSystemInstance = (SubSystemInstance)theEObject;
				T result = caseSubSystemInstance(subSystemInstance);
				if (result == null) result = caseStructureInstance(subSystemInstance);
				if (result == null) result = caseAbstractInstance(subSystemInstance);
				if (result == null) result = caseInstanceBase(subSystemInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.ACTOR_INSTANCE: {
				ActorInstance actorInstance = (ActorInstance)theEObject;
				T result = caseActorInstance(actorInstance);
				if (result == null) result = caseStructureInstance(actorInstance);
				if (result == null) result = caseAbstractInstance(actorInstance);
				if (result == null) result = caseInstanceBase(actorInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.OPTIONAL_ACTOR_INSTANCE: {
				OptionalActorInstance optionalActorInstance = (OptionalActorInstance)theEObject;
				T result = caseOptionalActorInstance(optionalActorInstance);
				if (result == null) result = caseStructureInstance(optionalActorInstance);
				if (result == null) result = caseAbstractInstance(optionalActorInstance);
				if (result == null) result = caseInstanceBase(optionalActorInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE: {
				InterfaceItemInstance interfaceItemInstance = (InterfaceItemInstance)theEObject;
				T result = caseInterfaceItemInstance(interfaceItemInstance);
				if (result == null) result = caseInstanceBase(interfaceItemInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.PORT_INSTANCE: {
				PortInstance portInstance = (PortInstance)theEObject;
				T result = casePortInstance(portInstance);
				if (result == null) result = caseInterfaceItemInstance(portInstance);
				if (result == null) result = caseInstanceBase(portInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.BINDING_INSTANCE: {
				BindingInstance bindingInstance = (BindingInstance)theEObject;
				T result = caseBindingInstance(bindingInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.SAP_INSTANCE: {
				SAPInstance sapInstance = (SAPInstance)theEObject;
				T result = caseSAPInstance(sapInstance);
				if (result == null) result = caseInterfaceItemInstance(sapInstance);
				if (result == null) result = caseInstanceBase(sapInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.SPP_INSTANCE: {
				SPPInstance sppInstance = (SPPInstance)theEObject;
				T result = caseSPPInstance(sppInstance);
				if (result == null) result = caseInstanceBase(sppInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.SERVICE_IMPL_INSTANCE: {
				ServiceImplInstance serviceImplInstance = (ServiceImplInstance)theEObject;
				T result = caseServiceImplInstance(serviceImplInstance);
				if (result == null) result = caseInterfaceItemInstance(serviceImplInstance);
				if (result == null) result = caseInstanceBase(serviceImplInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.CONNECTION_INSTANCE: {
				ConnectionInstance connectionInstance = (ConnectionInstance)theEObject;
				T result = caseConnectionInstance(connectionInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.WIRED_STRUCTURE_CLASS: {
				WiredStructureClass wiredStructureClass = (WiredStructureClass)theEObject;
				T result = caseWiredStructureClass(wiredStructureClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.OPEN_BINDING: {
				OpenBinding openBinding = (OpenBinding)theEObject;
				T result = caseOpenBinding(openBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.OPEN_SERVICE_CONNECTION: {
				OpenServiceConnection openServiceConnection = (OpenServiceConnection)theEObject;
				T result = caseOpenServiceConnection(openServiceConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.WIRE: {
				Wire wire = (Wire)theEObject;
				T result = caseWire(wire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.WIRED_ACTOR_CLASS: {
				WiredActorClass wiredActorClass = (WiredActorClass)theEObject;
				T result = caseWiredActorClass(wiredActorClass);
				if (result == null) result = caseWiredStructureClass(wiredActorClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.WIRED_SUB_SYSTEM_CLASS: {
				WiredSubSystemClass wiredSubSystemClass = (WiredSubSystemClass)theEObject;
				T result = caseWiredSubSystemClass(wiredSubSystemClass);
				if (result == null) result = caseWiredStructureClass(wiredSubSystemClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ETriceGenPackage.EXPANDED_ACTOR_CLASS: {
				ExpandedActorClass expandedActorClass = (ExpandedActorClass)theEObject;
				T result = caseExpandedActorClass(expandedActorClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoot(Root object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceBase(InstanceBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractInstance(AbstractInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Interface Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Interface Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorInterfaceInstance(ActorInterfaceInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureInstance(StructureInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemInstance(SystemInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub System Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub System Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubSystemInstance(SubSystemInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorInstance(ActorInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Optional Actor Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Optional Actor Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOptionalActorInstance(OptionalActorInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Item Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Item Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceItemInstance(InterfaceItemInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortInstance(PortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingInstance(BindingInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SAP Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SAP Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSAPInstance(SAPInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPP Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPP Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPPInstance(SPPInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Impl Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Impl Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceImplInstance(ServiceImplInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionInstance(ConnectionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expanded Actor Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expanded Actor Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpandedActorClass(ExpandedActorClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wired Structure Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wired Structure Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWiredStructureClass(WiredStructureClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenBinding(OpenBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Service Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Service Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenServiceConnection(OpenServiceConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWire(Wire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wired Actor Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wired Actor Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWiredActorClass(WiredActorClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wired Sub System Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wired Sub System Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWiredSubSystemClass(WiredSubSystemClass object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //ETriceGenSwitch
