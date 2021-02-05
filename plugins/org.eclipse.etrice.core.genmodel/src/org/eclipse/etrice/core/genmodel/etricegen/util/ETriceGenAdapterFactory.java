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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage
 * @generated
 */
public class ETriceGenAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ETriceGenPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETriceGenAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ETriceGenPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ETriceGenSwitch<Adapter> modelSwitch =
		new ETriceGenSwitch<Adapter>() {
			@Override
			public Adapter caseRoot(Root object) {
				return createRootAdapter();
			}
			@Override
			public Adapter caseInstanceBase(InstanceBase object) {
				return createInstanceBaseAdapter();
			}
			@Override
			public Adapter caseAbstractInstance(AbstractInstance object) {
				return createAbstractInstanceAdapter();
			}
			@Override
			public Adapter caseActorInterfaceInstance(ActorInterfaceInstance object) {
				return createActorInterfaceInstanceAdapter();
			}
			@Override
			public Adapter caseStructureInstance(StructureInstance object) {
				return createStructureInstanceAdapter();
			}
			@Override
			public Adapter caseSystemInstance(SystemInstance object) {
				return createSystemInstanceAdapter();
			}
			@Override
			public Adapter caseSubSystemInstance(SubSystemInstance object) {
				return createSubSystemInstanceAdapter();
			}
			@Override
			public Adapter caseActorInstance(ActorInstance object) {
				return createActorInstanceAdapter();
			}
			@Override
			public Adapter caseOptionalActorInstance(OptionalActorInstance object) {
				return createOptionalActorInstanceAdapter();
			}
			@Override
			public Adapter caseInterfaceItemInstance(InterfaceItemInstance object) {
				return createInterfaceItemInstanceAdapter();
			}
			@Override
			public Adapter casePortInstance(PortInstance object) {
				return createPortInstanceAdapter();
			}
			@Override
			public Adapter caseBindingInstance(BindingInstance object) {
				return createBindingInstanceAdapter();
			}
			@Override
			public Adapter caseSAPInstance(SAPInstance object) {
				return createSAPInstanceAdapter();
			}
			@Override
			public Adapter caseSPPInstance(SPPInstance object) {
				return createSPPInstanceAdapter();
			}
			@Override
			public Adapter caseServiceImplInstance(ServiceImplInstance object) {
				return createServiceImplInstanceAdapter();
			}
			@Override
			public Adapter caseConnectionInstance(ConnectionInstance object) {
				return createConnectionInstanceAdapter();
			}
			@Override
			public Adapter caseWiredStructureClass(WiredStructureClass object) {
				return createWiredStructureClassAdapter();
			}
			@Override
			public Adapter caseOpenBinding(OpenBinding object) {
				return createOpenBindingAdapter();
			}
			@Override
			public Adapter caseOpenServiceConnection(OpenServiceConnection object) {
				return createOpenServiceConnectionAdapter();
			}
			@Override
			public Adapter caseWire(Wire object) {
				return createWireAdapter();
			}
			@Override
			public Adapter caseWiredActorClass(WiredActorClass object) {
				return createWiredActorClassAdapter();
			}
			@Override
			public Adapter caseWiredSubSystemClass(WiredSubSystemClass object) {
				return createWiredSubSystemClassAdapter();
			}
			@Override
			public Adapter caseExpandedActorClass(ExpandedActorClass object) {
				return createExpandedActorClassAdapter();
			}
			@Override
			public Adapter caseExpandedProtocolClass(ExpandedProtocolClass object) {
				return createExpandedProtocolClassAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root
	 * @generated
	 */
	public Adapter createRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.InstanceBase <em>Instance Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InstanceBase
	 * @generated
	 */
	public Adapter createInstanceBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance <em>Abstract Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance
	 * @generated
	 */
	public Adapter createAbstractInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance <em>Actor Interface Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance
	 * @generated
	 */
	public Adapter createActorInterfaceInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance <em>Structure Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance
	 * @generated
	 */
	public Adapter createStructureInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.SystemInstance <em>System Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SystemInstance
	 * @generated
	 */
	public Adapter createSystemInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance <em>Sub System Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
	 * @generated
	 */
	public Adapter createSubSystemInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInstance <em>Actor Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
	 * @generated
	 */
	public Adapter createActorInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance <em>Optional Actor Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance
	 * @generated
	 */
	public Adapter createOptionalActorInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance <em>Interface Item Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance
	 * @generated
	 */
	public Adapter createInterfaceItemInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance <em>Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortInstance
	 * @generated
	 */
	public Adapter createPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance <em>Binding Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.BindingInstance
	 * @generated
	 */
	public Adapter createBindingInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance <em>SAP Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SAPInstance
	 * @generated
	 */
	public Adapter createSAPInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance <em>SPP Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SPPInstance
	 * @generated
	 */
	public Adapter createSPPInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance <em>Service Impl Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance
	 * @generated
	 */
	public Adapter createServiceImplInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance <em>Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance
	 * @generated
	 */
	public Adapter createConnectionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass <em>Expanded Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
	 * @generated
	 */
	public Adapter createExpandedActorClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedProtocolClass <em>Expanded Protocol Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ExpandedProtocolClass
	 * @generated
	 */
	public Adapter createExpandedProtocolClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass <em>Wired Structure Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass
	 * @generated
	 */
	public Adapter createWiredStructureClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.OpenBinding <em>Open Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OpenBinding
	 * @generated
	 */
	public Adapter createOpenBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection <em>Open Service Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection
	 * @generated
	 */
	public Adapter createOpenServiceConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.Wire <em>Wire</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Wire
	 * @generated
	 */
	public Adapter createWireAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass <em>Wired Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass
	 * @generated
	 */
	public Adapter createWiredActorClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass <em>Wired Sub System Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass
	 * @generated
	 */
	public Adapter createWiredSubSystemClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ETriceGenAdapterFactory
