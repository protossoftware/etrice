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

package org.eclipse.etrice.core.genmodel.etricegen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.BindingInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenFactory;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedProtocolClass;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.OpenBinding;
import org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortKind;
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
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenPackage;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ETriceGenPackageImpl extends EPackageImpl implements ETriceGenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorInterfaceInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subSystemInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionalActorInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceItemInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sapInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sppInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceImplInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandedActorClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandedProtocolClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wiredStructureClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openServiceConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wiredActorClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wiredSubSystemClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum portKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ETriceGenPackageImpl() {
		super(eNS_URI, ETriceGenFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ETriceGenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ETriceGenPackage init() {
		if (isInited) return (ETriceGenPackage)EPackage.Registry.INSTANCE.getEPackage(ETriceGenPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredETriceGenPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ETriceGenPackageImpl theETriceGenPackage = registeredETriceGenPackage instanceof ETriceGenPackageImpl ? (ETriceGenPackageImpl)registeredETriceGenPackage : new ETriceGenPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		RoomPackage.eINSTANCE.eClass();
		FSMPackage.eINSTANCE.eClass();
		BasePackage.eINSTANCE.eClass();
		FsmGenPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theETriceGenPackage.createPackageContents();

		// Initialize created meta-data
		theETriceGenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theETriceGenPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ETriceGenPackage.eNS_URI, theETriceGenPackage);
		return theETriceGenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRoot_Library() {
		return (EAttribute)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_SystemInstances() {
		return (EReference)rootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_OwnSubSystemInstances() {
		return (EReference)rootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_SubSystemInstances() {
		return (EReference)rootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_Models() {
		return (EReference)rootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_ImportedModels() {
		return (EReference)rootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_XpActorClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_DataClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_ProtocolClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_XpProtocolClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_ActorClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_EnumClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_SubSystemClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_OptionalInstances() {
		return (EReference)rootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_OptionalActorClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoot_WiredInstances() {
		return (EReference)rootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInstanceBase() {
		return instanceBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInstanceBase_Name() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInstanceBase_Path() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInstanceBase_ObjId() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInstanceBase_ThreadId() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInstanceBase_NObjIDs() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractInstance() {
		return abstractInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractInstance_Ports() {
		return (EReference)abstractInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActorInterfaceInstance() {
		return actorInterfaceInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActorInterfaceInstance_ActorClass() {
		return (EReference)actorInterfaceInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActorInterfaceInstance_ProvidedServices() {
		return (EReference)actorInterfaceInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActorInterfaceInstance_OptionalInstances() {
		return (EReference)actorInterfaceInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActorInterfaceInstance_Array() {
		return (EAttribute)actorInterfaceInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructureInstance() {
		return structureInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_Instances() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_Saps() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_Spps() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_Services() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_Bindings() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_Connections() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_AllContainedInstances() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructureInstance_OrderedIfItemInstances() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSystemInstance() {
		return systemInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSystemInstance_Instances() {
		return (EReference)systemInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSystemInstance_LogicalSystem() {
		return (EReference)systemInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSubSystemInstance() {
		return subSystemInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubSystemInstance_SubSystemClass() {
		return (EReference)subSystemInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubSystemInstance_MaxObjId() {
		return (EAttribute)subSystemInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getActorInstance() {
		return actorInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActorInstance_ActorClass() {
		return (EReference)actorInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActorInstance_ReplIdx() {
		return (EAttribute)actorInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getActorInstance_UnindexedName() {
		return (EAttribute)actorInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getActorInstance_XpActorClass() {
		return (EReference)actorInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOptionalActorInstance() {
		return optionalActorInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptionalActorInstance_ActorClass() {
		return (EReference)optionalActorInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptionalActorInstance_RequiredServices() {
		return (EReference)optionalActorInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInterfaceItemInstance() {
		return interfaceItemInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterfaceItemInstance_Protocol() {
		return (EReference)interfaceItemInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterfaceItemInstance_Peers() {
		return (EReference)interfaceItemInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInterfaceItemInstance_XpProtocolClass() {
		return (EReference)interfaceItemInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPortInstance() {
		return portInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPortInstance_Port() {
		return (EReference)portInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPortInstance_Kind() {
		return (EAttribute)portInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPortInstance_Bindings() {
		return (EReference)portInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBindingInstance() {
		return bindingInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindingInstance_Ports() {
		return (EReference)bindingInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindingInstance_Binding() {
		return (EReference)bindingInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSAPInstance() {
		return sapInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSAPInstance_Sap() {
		return (EReference)sapInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSPPInstance() {
		return sppInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSPPInstance_Spp() {
		return (EReference)sppInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSPPInstance_Incoming() {
		return (EReference)sppInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSPPInstance_Outgoing() {
		return (EReference)sppInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getServiceImplInstance() {
		return serviceImplInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getServiceImplInstance_SvcImpl() {
		return (EReference)serviceImplInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectionInstance() {
		return connectionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionInstance_FromAI() {
		return (EReference)connectionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionInstance_FromSPP() {
		return (EReference)connectionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionInstance_ToSPP() {
		return (EReference)connectionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionInstance_Connection() {
		return (EReference)connectionInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpandedActorClass() {
		return expandedActorClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpandedActorClass_ActorClass() {
		return (EReference)expandedActorClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpandedActorClass_GraphContainer() {
		return (EReference)expandedActorClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExpandedActorClass_TracingEnabled() {
		return (EAttribute)expandedActorClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpandedProtocolClass() {
		return expandedProtocolClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExpandedProtocolClass_OrderedMessageNames() {
		return (EAttribute)expandedProtocolClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpandedProtocolClass_ProtocolClass() {
		return (EReference)expandedProtocolClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWiredStructureClass() {
		return wiredStructureClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWiredStructureClass_Wires() {
		return (EReference)wiredStructureClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWiredStructureClass_OpenBindings() {
		return (EReference)wiredStructureClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWiredStructureClass_ProvidedServices() {
		return (EReference)wiredStructureClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWiredStructureClass_RequiredServices() {
		return (EReference)wiredStructureClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOpenBinding() {
		return openBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOpenBinding_Path() {
		return (EAttribute)openBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOpenBinding_Port() {
		return (EReference)openBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOpenServiceConnection() {
		return openServiceConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOpenServiceConnection_Path() {
		return (EAttribute)openServiceConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOpenServiceConnection_Protocol() {
		return (EReference)openServiceConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWire() {
		return wireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWire_DataDriven() {
		return (EAttribute)wireEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWire_Path1() {
		return (EAttribute)wireEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWire_Path2() {
		return (EAttribute)wireEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWiredActorClass() {
		return wiredActorClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWiredActorClass_ActorClass() {
		return (EReference)wiredActorClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWiredSubSystemClass() {
		return wiredSubSystemClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWiredSubSystemClass_SubSystemClass() {
		return (EReference)wiredSubSystemClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPortKind() {
		return portKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ETriceGenFactory getETriceGenFactory() {
		return (ETriceGenFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		rootEClass = createEClass(ROOT);
		createEAttribute(rootEClass, ROOT__LIBRARY);
		createEReference(rootEClass, ROOT__SYSTEM_INSTANCES);
		createEReference(rootEClass, ROOT__OWN_SUB_SYSTEM_INSTANCES);
		createEReference(rootEClass, ROOT__SUB_SYSTEM_INSTANCES);
		createEReference(rootEClass, ROOT__MODELS);
		createEReference(rootEClass, ROOT__IMPORTED_MODELS);
		createEReference(rootEClass, ROOT__XP_ACTOR_CLASSES);
		createEReference(rootEClass, ROOT__DATA_CLASSES);
		createEReference(rootEClass, ROOT__PROTOCOL_CLASSES);
		createEReference(rootEClass, ROOT__XP_PROTOCOL_CLASSES);
		createEReference(rootEClass, ROOT__ACTOR_CLASSES);
		createEReference(rootEClass, ROOT__ENUM_CLASSES);
		createEReference(rootEClass, ROOT__SUB_SYSTEM_CLASSES);
		createEReference(rootEClass, ROOT__OPTIONAL_INSTANCES);
		createEReference(rootEClass, ROOT__OPTIONAL_ACTOR_CLASSES);
		createEReference(rootEClass, ROOT__WIRED_INSTANCES);

		instanceBaseEClass = createEClass(INSTANCE_BASE);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__NAME);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__PATH);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__OBJ_ID);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__THREAD_ID);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__NOBJ_IDS);

		abstractInstanceEClass = createEClass(ABSTRACT_INSTANCE);
		createEReference(abstractInstanceEClass, ABSTRACT_INSTANCE__PORTS);

		actorInterfaceInstanceEClass = createEClass(ACTOR_INTERFACE_INSTANCE);
		createEReference(actorInterfaceInstanceEClass, ACTOR_INTERFACE_INSTANCE__ACTOR_CLASS);
		createEReference(actorInterfaceInstanceEClass, ACTOR_INTERFACE_INSTANCE__PROVIDED_SERVICES);
		createEReference(actorInterfaceInstanceEClass, ACTOR_INTERFACE_INSTANCE__OPTIONAL_INSTANCES);
		createEAttribute(actorInterfaceInstanceEClass, ACTOR_INTERFACE_INSTANCE__ARRAY);

		structureInstanceEClass = createEClass(STRUCTURE_INSTANCE);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__INSTANCES);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__SAPS);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__SPPS);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__SERVICES);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__BINDINGS);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__CONNECTIONS);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__ORDERED_IF_ITEM_INSTANCES);

		systemInstanceEClass = createEClass(SYSTEM_INSTANCE);
		createEReference(systemInstanceEClass, SYSTEM_INSTANCE__INSTANCES);
		createEReference(systemInstanceEClass, SYSTEM_INSTANCE__LOGICAL_SYSTEM);

		subSystemInstanceEClass = createEClass(SUB_SYSTEM_INSTANCE);
		createEReference(subSystemInstanceEClass, SUB_SYSTEM_INSTANCE__SUB_SYSTEM_CLASS);
		createEAttribute(subSystemInstanceEClass, SUB_SYSTEM_INSTANCE__MAX_OBJ_ID);

		actorInstanceEClass = createEClass(ACTOR_INSTANCE);
		createEReference(actorInstanceEClass, ACTOR_INSTANCE__ACTOR_CLASS);
		createEAttribute(actorInstanceEClass, ACTOR_INSTANCE__REPL_IDX);
		createEAttribute(actorInstanceEClass, ACTOR_INSTANCE__UNINDEXED_NAME);
		createEReference(actorInstanceEClass, ACTOR_INSTANCE__XP_ACTOR_CLASS);

		optionalActorInstanceEClass = createEClass(OPTIONAL_ACTOR_INSTANCE);
		createEReference(optionalActorInstanceEClass, OPTIONAL_ACTOR_INSTANCE__ACTOR_CLASS);
		createEReference(optionalActorInstanceEClass, OPTIONAL_ACTOR_INSTANCE__REQUIRED_SERVICES);

		interfaceItemInstanceEClass = createEClass(INTERFACE_ITEM_INSTANCE);
		createEReference(interfaceItemInstanceEClass, INTERFACE_ITEM_INSTANCE__PROTOCOL);
		createEReference(interfaceItemInstanceEClass, INTERFACE_ITEM_INSTANCE__PEERS);
		createEReference(interfaceItemInstanceEClass, INTERFACE_ITEM_INSTANCE__XP_PROTOCOL_CLASS);

		portInstanceEClass = createEClass(PORT_INSTANCE);
		createEReference(portInstanceEClass, PORT_INSTANCE__PORT);
		createEAttribute(portInstanceEClass, PORT_INSTANCE__KIND);
		createEReference(portInstanceEClass, PORT_INSTANCE__BINDINGS);

		bindingInstanceEClass = createEClass(BINDING_INSTANCE);
		createEReference(bindingInstanceEClass, BINDING_INSTANCE__PORTS);
		createEReference(bindingInstanceEClass, BINDING_INSTANCE__BINDING);

		sapInstanceEClass = createEClass(SAP_INSTANCE);
		createEReference(sapInstanceEClass, SAP_INSTANCE__SAP);

		sppInstanceEClass = createEClass(SPP_INSTANCE);
		createEReference(sppInstanceEClass, SPP_INSTANCE__SPP);
		createEReference(sppInstanceEClass, SPP_INSTANCE__INCOMING);
		createEReference(sppInstanceEClass, SPP_INSTANCE__OUTGOING);

		serviceImplInstanceEClass = createEClass(SERVICE_IMPL_INSTANCE);
		createEReference(serviceImplInstanceEClass, SERVICE_IMPL_INSTANCE__SVC_IMPL);

		connectionInstanceEClass = createEClass(CONNECTION_INSTANCE);
		createEReference(connectionInstanceEClass, CONNECTION_INSTANCE__FROM_AI);
		createEReference(connectionInstanceEClass, CONNECTION_INSTANCE__FROM_SPP);
		createEReference(connectionInstanceEClass, CONNECTION_INSTANCE__TO_SPP);
		createEReference(connectionInstanceEClass, CONNECTION_INSTANCE__CONNECTION);

		wiredStructureClassEClass = createEClass(WIRED_STRUCTURE_CLASS);
		createEReference(wiredStructureClassEClass, WIRED_STRUCTURE_CLASS__WIRES);
		createEReference(wiredStructureClassEClass, WIRED_STRUCTURE_CLASS__OPEN_BINDINGS);
		createEReference(wiredStructureClassEClass, WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES);
		createEReference(wiredStructureClassEClass, WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES);

		openBindingEClass = createEClass(OPEN_BINDING);
		createEAttribute(openBindingEClass, OPEN_BINDING__PATH);
		createEReference(openBindingEClass, OPEN_BINDING__PORT);

		openServiceConnectionEClass = createEClass(OPEN_SERVICE_CONNECTION);
		createEAttribute(openServiceConnectionEClass, OPEN_SERVICE_CONNECTION__PATH);
		createEReference(openServiceConnectionEClass, OPEN_SERVICE_CONNECTION__PROTOCOL);

		wireEClass = createEClass(WIRE);
		createEAttribute(wireEClass, WIRE__DATA_DRIVEN);
		createEAttribute(wireEClass, WIRE__PATH1);
		createEAttribute(wireEClass, WIRE__PATH2);

		wiredActorClassEClass = createEClass(WIRED_ACTOR_CLASS);
		createEReference(wiredActorClassEClass, WIRED_ACTOR_CLASS__ACTOR_CLASS);

		wiredSubSystemClassEClass = createEClass(WIRED_SUB_SYSTEM_CLASS);
		createEReference(wiredSubSystemClassEClass, WIRED_SUB_SYSTEM_CLASS__SUB_SYSTEM_CLASS);

		expandedActorClassEClass = createEClass(EXPANDED_ACTOR_CLASS);
		createEReference(expandedActorClassEClass, EXPANDED_ACTOR_CLASS__ACTOR_CLASS);
		createEReference(expandedActorClassEClass, EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER);
		createEAttribute(expandedActorClassEClass, EXPANDED_ACTOR_CLASS__TRACING_ENABLED);

		expandedProtocolClassEClass = createEClass(EXPANDED_PROTOCOL_CLASS);
		createEAttribute(expandedProtocolClassEClass, EXPANDED_PROTOCOL_CLASS__ORDERED_MESSAGE_NAMES);
		createEReference(expandedProtocolClassEClass, EXPANDED_PROTOCOL_CLASS__PROTOCOL_CLASS);

		// Create enums
		portKindEEnum = createEEnum(PORT_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RoomPackage theRoomPackage = (RoomPackage)EPackage.Registry.INSTANCE.getEPackage(RoomPackage.eNS_URI);
		FsmGenPackage theFsmGenPackage = (FsmGenPackage)EPackage.Registry.INSTANCE.getEPackage(FsmGenPackage.eNS_URI);
		FSMPackage theFSMPackage = (FSMPackage)EPackage.Registry.INSTANCE.getEPackage(FSMPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractInstanceEClass.getESuperTypes().add(this.getInstanceBase());
		actorInterfaceInstanceEClass.getESuperTypes().add(this.getAbstractInstance());
		structureInstanceEClass.getESuperTypes().add(this.getAbstractInstance());
		systemInstanceEClass.getESuperTypes().add(this.getInstanceBase());
		subSystemInstanceEClass.getESuperTypes().add(this.getStructureInstance());
		actorInstanceEClass.getESuperTypes().add(this.getStructureInstance());
		optionalActorInstanceEClass.getESuperTypes().add(this.getStructureInstance());
		interfaceItemInstanceEClass.getESuperTypes().add(this.getInstanceBase());
		portInstanceEClass.getESuperTypes().add(this.getInterfaceItemInstance());
		sapInstanceEClass.getESuperTypes().add(this.getInterfaceItemInstance());
		sppInstanceEClass.getESuperTypes().add(this.getInstanceBase());
		serviceImplInstanceEClass.getESuperTypes().add(this.getInterfaceItemInstance());
		wiredActorClassEClass.getESuperTypes().add(this.getWiredStructureClass());
		wiredSubSystemClassEClass.getESuperTypes().add(this.getWiredStructureClass());

		// Initialize classes and features; add operations and parameters
		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoot_Library(), ecorePackage.getEBoolean(), "library", null, 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_SystemInstances(), this.getSystemInstance(), null, "systemInstances", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_OwnSubSystemInstances(), this.getSubSystemInstance(), null, "ownSubSystemInstances", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_SubSystemInstances(), this.getSubSystemInstance(), null, "subSystemInstances", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_Models(), theRoomPackage.getRoomModel(), null, "models", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_ImportedModels(), theRoomPackage.getRoomModel(), null, "importedModels", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_XpActorClasses(), this.getExpandedActorClass(), null, "xpActorClasses", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_DataClasses(), theRoomPackage.getDataClass(), null, "dataClasses", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_ProtocolClasses(), theRoomPackage.getProtocolClass(), null, "protocolClasses", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_XpProtocolClasses(), this.getExpandedProtocolClass(), null, "xpProtocolClasses", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_ActorClasses(), theRoomPackage.getActorClass(), null, "actorClasses", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_EnumClasses(), theRoomPackage.getEnumerationType(), null, "enumClasses", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_SubSystemClasses(), theRoomPackage.getSubSystemClass(), null, "subSystemClasses", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_OptionalInstances(), this.getOptionalActorInstance(), null, "optionalInstances", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_OptionalActorClasses(), theRoomPackage.getActorClass(), null, "optionalActorClasses", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_WiredInstances(), this.getWiredStructureClass(), null, "wiredInstances", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(rootEClass, theRoomPackage.getRoomModel(), "getReferencedModels", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getRoomClass(), "cls", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, theRoomPackage.getProtocolClass(), "getReferencedProtocolClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getRoomClass(), "cls", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, theRoomPackage.getDataClass(), "getReferencedDataClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getRoomClass(), "cls", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, theRoomPackage.getEnumerationType(), "getReferencedEnumClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getRoomClass(), "cls", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, theRoomPackage.getActorClass(), "getReferencedActorClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getRoomClass(), "cls", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, this.getExpandedActorClass(), "getExpandedActorClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getActorInstance(), "ai", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, this.getExpandedActorClass(), "getExpandedActorClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getActorClass(), "ac", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, this.getStructureInstance(), "getInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, theRoomPackage.getActorClass(), "getSubClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getActorClass(), "ac", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(rootEClass, null, "computeSubClasses", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instanceBaseEClass, InstanceBase.class, "InstanceBase", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInstanceBase_Name(), ecorePackage.getEString(), "name", null, 0, 1, InstanceBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceBase_Path(), ecorePackage.getEString(), "path", null, 0, 1, InstanceBase.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceBase_ObjId(), ecorePackage.getEInt(), "objId", null, 0, 1, InstanceBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceBase_ThreadId(), ecorePackage.getEInt(), "threadId", "-1", 0, 1, InstanceBase.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceBase_NObjIDs(), ecorePackage.getEInt(), "nObjIDs", null, 0, 1, InstanceBase.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(abstractInstanceEClass, AbstractInstance.class, "AbstractInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractInstance_Ports(), this.getPortInstance(), null, "ports", null, 0, -1, AbstractInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorInterfaceInstanceEClass, ActorInterfaceInstance.class, "ActorInterfaceInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActorInterfaceInstance_ActorClass(), theRoomPackage.getActorClass(), null, "actorClass", null, 0, 1, ActorInterfaceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorInterfaceInstance_ProvidedServices(), this.getServiceImplInstance(), null, "providedServices", null, 0, -1, ActorInterfaceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorInterfaceInstance_OptionalInstances(), this.getOptionalActorInstance(), null, "optionalInstances", null, 0, -1, ActorInterfaceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorInterfaceInstance_Array(), ecorePackage.getEBoolean(), "array", null, 0, 1, ActorInterfaceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureInstanceEClass, StructureInstance.class, "StructureInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureInstance_Instances(), this.getAbstractInstance(), null, "instances", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Saps(), this.getSAPInstance(), null, "saps", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Spps(), this.getSPPInstance(), null, "spps", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Services(), this.getServiceImplInstance(), null, "services", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Bindings(), this.getBindingInstance(), null, "bindings", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Connections(), this.getConnectionInstance(), null, "connections", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_AllContainedInstances(), this.getActorInstance(), null, "allContainedInstances", null, 0, -1, StructureInstance.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_OrderedIfItemInstances(), this.getInterfaceItemInstance(), null, "orderedIfItemInstances", null, 0, -1, StructureInstance.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(structureInstanceEClass, this.getActorInstance(), "getActorInstances", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(systemInstanceEClass, SystemInstance.class, "SystemInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemInstance_Instances(), this.getSubSystemInstance(), null, "instances", null, 0, -1, SystemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemInstance_LogicalSystem(), theRoomPackage.getLogicalSystem(), null, "logicalSystem", null, 0, 1, SystemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subSystemInstanceEClass, SubSystemInstance.class, "SubSystemInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubSystemInstance_SubSystemClass(), theRoomPackage.getSubSystemClass(), null, "subSystemClass", null, 0, 1, SubSystemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubSystemInstance_MaxObjId(), ecorePackage.getEInt(), "maxObjId", null, 0, 1, SubSystemInstance.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(subSystemInstanceEClass, ecorePackage.getEInt(), "getThreadId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInstanceBase(), "instance", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(actorInstanceEClass, ActorInstance.class, "ActorInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActorInstance_ActorClass(), theRoomPackage.getActorClass(), null, "actorClass", null, 0, 1, ActorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorInstance_ReplIdx(), ecorePackage.getEInt(), "replIdx", "-1", 0, 1, ActorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorInstance_UnindexedName(), ecorePackage.getEString(), "unindexedName", null, 0, 1, ActorInstance.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getActorInstance_XpActorClass(), this.getExpandedActorClass(), null, "xpActorClass", null, 0, 1, ActorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionalActorInstanceEClass, OptionalActorInstance.class, "OptionalActorInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptionalActorInstance_ActorClass(), theRoomPackage.getActorClass(), null, "actorClass", null, 0, 1, OptionalActorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptionalActorInstance_RequiredServices(), this.getSAPInstance(), null, "requiredServices", null, 0, -1, OptionalActorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceItemInstanceEClass, InterfaceItemInstance.class, "InterfaceItemInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceItemInstance_Protocol(), theRoomPackage.getProtocolClass(), null, "protocol", null, 0, 1, InterfaceItemInstance.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceItemInstance_Peers(), this.getInterfaceItemInstance(), null, "peers", null, 0, -1, InterfaceItemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceItemInstance_XpProtocolClass(), this.getExpandedProtocolClass(), null, "xpProtocolClass", null, 0, 1, InterfaceItemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(interfaceItemInstanceEClass, ecorePackage.getEBoolean(), "isReplicated", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(interfaceItemInstanceEClass, ecorePackage.getEBoolean(), "isSimple", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(interfaceItemInstanceEClass, ecorePackage.getEBoolean(), "isRelay", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(interfaceItemInstanceEClass, theRoomPackage.getInterfaceItem(), "getInterfaceItem", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(portInstanceEClass, PortInstance.class, "PortInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortInstance_Port(), theRoomPackage.getPort(), null, "port", null, 0, 1, PortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortInstance_Kind(), this.getPortKind(), "kind", null, 0, 1, PortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortInstance_Bindings(), this.getBindingInstance(), this.getBindingInstance_Ports(), "bindings", null, 0, -1, PortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingInstanceEClass, BindingInstance.class, "BindingInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingInstance_Ports(), this.getPortInstance(), this.getPortInstance_Bindings(), "ports", null, 0, 2, BindingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingInstance_Binding(), theRoomPackage.getBinding(), null, "binding", null, 0, 1, BindingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sapInstanceEClass, SAPInstance.class, "SAPInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSAPInstance_Sap(), theRoomPackage.getSAP(), null, "sap", null, 0, 1, SAPInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sppInstanceEClass, SPPInstance.class, "SPPInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSPPInstance_Spp(), theRoomPackage.getSPP(), null, "spp", null, 0, 1, SPPInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSPPInstance_Incoming(), this.getConnectionInstance(), this.getConnectionInstance_ToSPP(), "incoming", null, 0, -1, SPPInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSPPInstance_Outgoing(), this.getConnectionInstance(), this.getConnectionInstance_FromSPP(), "outgoing", null, 0, 1, SPPInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceImplInstanceEClass, ServiceImplInstance.class, "ServiceImplInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceImplInstance_SvcImpl(), theRoomPackage.getServiceImplementation(), null, "svcImpl", null, 0, 1, ServiceImplInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionInstanceEClass, ConnectionInstance.class, "ConnectionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionInstance_FromAI(), this.getAbstractInstance(), null, "fromAI", null, 0, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionInstance_FromSPP(), this.getSPPInstance(), this.getSPPInstance_Outgoing(), "fromSPP", null, 0, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionInstance_ToSPP(), this.getSPPInstance(), this.getSPPInstance_Incoming(), "toSPP", null, 0, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionInstance_Connection(), theRoomPackage.getLayerConnection(), null, "connection", null, 0, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wiredStructureClassEClass, WiredStructureClass.class, "WiredStructureClass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWiredStructureClass_Wires(), this.getWire(), null, "wires", null, 0, -1, WiredStructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWiredStructureClass_OpenBindings(), this.getOpenBinding(), null, "openBindings", null, 0, -1, WiredStructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWiredStructureClass_ProvidedServices(), this.getOpenServiceConnection(), null, "providedServices", null, 0, -1, WiredStructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWiredStructureClass_RequiredServices(), this.getOpenServiceConnection(), null, "requiredServices", null, 0, -1, WiredStructureClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openBindingEClass, OpenBinding.class, "OpenBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenBinding_Path(), ecorePackage.getEString(), "path", null, 0, -1, OpenBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOpenBinding_Port(), theRoomPackage.getPort(), null, "port", null, 0, 1, OpenBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openServiceConnectionEClass, OpenServiceConnection.class, "OpenServiceConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenServiceConnection_Path(), ecorePackage.getEString(), "path", null, 0, -1, OpenServiceConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOpenServiceConnection_Protocol(), theRoomPackage.getProtocolClass(), null, "protocol", null, 0, 1, OpenServiceConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wireEClass, Wire.class, "Wire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWire_DataDriven(), ecorePackage.getEBoolean(), "dataDriven", null, 0, 1, Wire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWire_Path1(), ecorePackage.getEString(), "path1", null, 0, -1, Wire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWire_Path2(), ecorePackage.getEString(), "path2", null, 0, -1, Wire.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wiredActorClassEClass, WiredActorClass.class, "WiredActorClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWiredActorClass_ActorClass(), theRoomPackage.getActorClass(), null, "actorClass", null, 0, 1, WiredActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wiredSubSystemClassEClass, WiredSubSystemClass.class, "WiredSubSystemClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWiredSubSystemClass_SubSystemClass(), theRoomPackage.getSubSystemClass(), null, "subSystemClass", null, 0, 1, WiredSubSystemClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expandedActorClassEClass, ExpandedActorClass.class, "ExpandedActorClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandedActorClass_ActorClass(), theRoomPackage.getActorClass(), null, "actorClass", null, 0, 1, ExpandedActorClass.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExpandedActorClass_GraphContainer(), theFsmGenPackage.getGraphContainer(), null, "graphContainer", null, 0, 1, ExpandedActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpandedActorClass_TracingEnabled(), ecorePackage.getEBoolean(), "tracingEnabled", null, 0, 1, ExpandedActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, ecorePackage.getEInt(), "getInterfaceItemLocalId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theFSMPackage.getAbstractInterfaceItem(), "ifitem", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(expandedProtocolClassEClass, ExpandedProtocolClass.class, "ExpandedProtocolClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpandedProtocolClass_OrderedMessageNames(), ecorePackage.getEString(), "orderedMessageNames", null, 0, -1, ExpandedProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpandedProtocolClass_ProtocolClass(), theRoomPackage.getProtocolClass(), null, "protocolClass", null, 0, 1, ExpandedProtocolClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(portKindEEnum, PortKind.class, "PortKind");
		addEEnumLiteral(portKindEEnum, PortKind.EXTERNAL);
		addEEnumLiteral(portKindEEnum, PortKind.INTERNAL);
		addEEnumLiteral(portKindEEnum, PortKind.RELAY);
		addEEnumLiteral(portKindEEnum, PortKind.INTERFACE);

		// Create resource
		createResource(eNS_URI);
	}

} //ETriceGenPackageImpl
