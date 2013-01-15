/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.BindingInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenFactory;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortKind;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SPPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;

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
	private EClass activeTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionChainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTransitionChainVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDiagnosticianEClass = null;

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
	private EClass expandedRefinedStateEClass = null;

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
		ETriceGenPackageImpl theETriceGenPackage = (ETriceGenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ETriceGenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ETriceGenPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RoomPackage.eINSTANCE.eClass();

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
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoot_Library() {
		return (EAttribute)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_SystemInstances() {
		return (EReference)rootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_OwnSubSystemInstances() {
		return (EReference)rootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_SubSystemInstances() {
		return (EReference)rootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_Models() {
		return (EReference)rootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_XpActorClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_UsedDataClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_UsedProtocolClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_UsedActorClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_UsedRoomModels() {
		return (EReference)rootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_SubSystemClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceBase() {
		return instanceBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceBase_Name() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceBase_Path() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceBase_ObjId() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceBase_ThreadId() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceBase_NObjIDs() {
		return (EAttribute)instanceBaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureInstance() {
		return structureInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureInstance_Instances() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureInstance_Ports() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureInstance_Saps() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureInstance_Spps() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureInstance_Services() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureInstance_Bindings() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureInstance_Connections() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureInstance_AllContainedInstances() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureInstance_OrderedIfItemInstances() {
		return (EReference)structureInstanceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemInstance() {
		return systemInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemInstance_Instances() {
		return (EReference)systemInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemInstance_LogicalSystem() {
		return (EReference)systemInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubSystemInstance() {
		return subSystemInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubSystemInstance_SubSystemClass() {
		return (EReference)subSystemInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubSystemInstance_MaxObjId() {
		return (EAttribute)subSystemInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorInstance() {
		return actorInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorInstance_ActorClass() {
		return (EReference)actorInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorInstance_ReplIdx() {
		return (EAttribute)actorInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorInstance_UnindexedName() {
		return (EAttribute)actorInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceItemInstance() {
		return interfaceItemInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceItemInstance_Protocol() {
		return (EReference)interfaceItemInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceItemInstance_Peers() {
		return (EReference)interfaceItemInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortInstance() {
		return portInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortInstance_Port() {
		return (EReference)portInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortInstance_Kind() {
		return (EAttribute)portInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortInstance_Bindings() {
		return (EReference)portInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingInstance() {
		return bindingInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingInstance_Ports() {
		return (EReference)bindingInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingInstance_Binding() {
		return (EReference)bindingInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSAPInstance() {
		return sapInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAPInstance_Sap() {
		return (EReference)sapInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSPPInstance() {
		return sppInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSPPInstance_Spp() {
		return (EReference)sppInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSPPInstance_Incoming() {
		return (EReference)sppInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSPPInstance_Outgoing() {
		return (EReference)sppInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceImplInstance() {
		return serviceImplInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceImplInstance_SvcImpl() {
		return (EReference)serviceImplInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionInstance() {
		return connectionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstance_FromAI() {
		return (EReference)connectionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstance_FromSPP() {
		return (EReference)connectionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstance_ToSPP() {
		return (EReference)connectionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionInstance_Connection() {
		return (EReference)connectionInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActiveTrigger() {
		return activeTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActiveTrigger_Msg() {
		return (EReference)activeTriggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActiveTrigger_Ifitem() {
		return (EReference)activeTriggerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActiveTrigger_Trigger() {
		return (EAttribute)activeTriggerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActiveTrigger_Transitions() {
		return (EReference)activeTriggerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionChain() {
		return transitionChainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionChain_Transition() {
		return (EReference)transitionChainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransitionChain_SkipEntry() {
		return (EAttribute)transitionChainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionChain_Data() {
		return (EReference)transitionChainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITransitionChainVisitor() {
		return iTransitionChainVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDiagnostician() {
		return iDiagnosticianEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandedActorClass() {
		return expandedActorClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedActorClass_ActorClass() {
		return (EReference)expandedActorClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedActorClass_StateMachine() {
		return (EReference)expandedActorClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandedRefinedState() {
		return expandedRefinedStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedRefinedState_InheritedEntry() {
		return (EReference)expandedRefinedStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedRefinedState_InheritedExit() {
		return (EReference)expandedRefinedStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandedRefinedState_InheritedDo() {
		return (EReference)expandedRefinedStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPortKind() {
		return portKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
		createEReference(rootEClass, ROOT__XP_ACTOR_CLASSES);
		createEReference(rootEClass, ROOT__USED_DATA_CLASSES);
		createEReference(rootEClass, ROOT__USED_PROTOCOL_CLASSES);
		createEReference(rootEClass, ROOT__USED_ACTOR_CLASSES);
		createEReference(rootEClass, ROOT__USED_ROOM_MODELS);
		createEReference(rootEClass, ROOT__SUB_SYSTEM_CLASSES);

		instanceBaseEClass = createEClass(INSTANCE_BASE);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__NAME);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__PATH);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__OBJ_ID);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__THREAD_ID);
		createEAttribute(instanceBaseEClass, INSTANCE_BASE__NOBJ_IDS);

		structureInstanceEClass = createEClass(STRUCTURE_INSTANCE);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__INSTANCES);
		createEReference(structureInstanceEClass, STRUCTURE_INSTANCE__PORTS);
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

		interfaceItemInstanceEClass = createEClass(INTERFACE_ITEM_INSTANCE);
		createEReference(interfaceItemInstanceEClass, INTERFACE_ITEM_INSTANCE__PROTOCOL);
		createEReference(interfaceItemInstanceEClass, INTERFACE_ITEM_INSTANCE__PEERS);

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

		activeTriggerEClass = createEClass(ACTIVE_TRIGGER);
		createEReference(activeTriggerEClass, ACTIVE_TRIGGER__MSG);
		createEReference(activeTriggerEClass, ACTIVE_TRIGGER__IFITEM);
		createEAttribute(activeTriggerEClass, ACTIVE_TRIGGER__TRIGGER);
		createEReference(activeTriggerEClass, ACTIVE_TRIGGER__TRANSITIONS);

		transitionChainEClass = createEClass(TRANSITION_CHAIN);
		createEReference(transitionChainEClass, TRANSITION_CHAIN__TRANSITION);
		createEAttribute(transitionChainEClass, TRANSITION_CHAIN__SKIP_ENTRY);
		createEReference(transitionChainEClass, TRANSITION_CHAIN__DATA);

		iTransitionChainVisitorEClass = createEClass(ITRANSITION_CHAIN_VISITOR);

		iDiagnosticianEClass = createEClass(IDIAGNOSTICIAN);

		expandedActorClassEClass = createEClass(EXPANDED_ACTOR_CLASS);
		createEReference(expandedActorClassEClass, EXPANDED_ACTOR_CLASS__ACTOR_CLASS);
		createEReference(expandedActorClassEClass, EXPANDED_ACTOR_CLASS__STATE_MACHINE);

		expandedRefinedStateEClass = createEClass(EXPANDED_REFINED_STATE);
		createEReference(expandedRefinedStateEClass, EXPANDED_REFINED_STATE__INHERITED_ENTRY);
		createEReference(expandedRefinedStateEClass, EXPANDED_REFINED_STATE__INHERITED_EXIT);
		createEReference(expandedRefinedStateEClass, EXPANDED_REFINED_STATE__INHERITED_DO);

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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		structureInstanceEClass.getESuperTypes().add(this.getInstanceBase());
		systemInstanceEClass.getESuperTypes().add(this.getInstanceBase());
		subSystemInstanceEClass.getESuperTypes().add(this.getStructureInstance());
		actorInstanceEClass.getESuperTypes().add(this.getStructureInstance());
		interfaceItemInstanceEClass.getESuperTypes().add(this.getInstanceBase());
		portInstanceEClass.getESuperTypes().add(this.getInterfaceItemInstance());
		sapInstanceEClass.getESuperTypes().add(this.getInterfaceItemInstance());
		sppInstanceEClass.getESuperTypes().add(this.getInstanceBase());
		serviceImplInstanceEClass.getESuperTypes().add(this.getInterfaceItemInstance());
		expandedRefinedStateEClass.getESuperTypes().add(theRoomPackage.getSimpleState());

		// Initialize classes and features; add operations and parameters
		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoot_Library(), ecorePackage.getEBoolean(), "library", null, 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_SystemInstances(), this.getSystemInstance(), null, "systemInstances", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_OwnSubSystemInstances(), this.getSubSystemInstance(), null, "ownSubSystemInstances", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_SubSystemInstances(), this.getSubSystemInstance(), null, "subSystemInstances", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_Models(), theRoomPackage.getRoomModel(), null, "models", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_XpActorClasses(), this.getExpandedActorClass(), null, "xpActorClasses", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_UsedDataClasses(), theRoomPackage.getDataClass(), null, "usedDataClasses", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_UsedProtocolClasses(), theRoomPackage.getProtocolClass(), null, "usedProtocolClasses", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_UsedActorClasses(), theRoomPackage.getActorClass(), null, "usedActorClasses", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_UsedRoomModels(), theRoomPackage.getRoomModel(), null, "usedRoomModels", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_SubSystemClasses(), theRoomPackage.getSubSystemClass(), null, "subSystemClasses", null, 0, -1, Root.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(rootEClass, theRoomPackage.getRoomModel(), "getReferencedModels", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getRoomClass(), "cls", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, theRoomPackage.getProtocolClass(), "getReferencedProtocolClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getActorClass(), "cls", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, this.getExpandedActorClass(), "getExpandedActorClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getActorInstance(), "ai", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(rootEClass, this.getStructureInstance(), "getInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instanceBaseEClass, InstanceBase.class, "InstanceBase", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInstanceBase_Name(), ecorePackage.getEString(), "name", null, 0, 1, InstanceBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceBase_Path(), ecorePackage.getEString(), "path", null, 0, 1, InstanceBase.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceBase_ObjId(), ecorePackage.getEInt(), "objId", null, 0, 1, InstanceBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceBase_ThreadId(), ecorePackage.getEInt(), "threadId", "-1", 0, 1, InstanceBase.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceBase_NObjIDs(), ecorePackage.getEInt(), "nObjIDs", null, 0, 1, InstanceBase.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(structureInstanceEClass, StructureInstance.class, "StructureInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureInstance_Instances(), this.getActorInstance(), null, "instances", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Ports(), this.getPortInstance(), null, "ports", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Saps(), this.getSAPInstance(), null, "saps", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Spps(), this.getSPPInstance(), null, "spps", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Services(), this.getServiceImplInstance(), null, "services", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Bindings(), this.getBindingInstance(), null, "bindings", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_Connections(), this.getConnectionInstance(), null, "connections", null, 0, -1, StructureInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_AllContainedInstances(), this.getActorInstance(), null, "allContainedInstances", null, 0, -1, StructureInstance.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStructureInstance_OrderedIfItemInstances(), this.getInterfaceItemInstance(), null, "orderedIfItemInstances", null, 0, -1, StructureInstance.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

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

		initEClass(interfaceItemInstanceEClass, InterfaceItemInstance.class, "InterfaceItemInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceItemInstance_Protocol(), theRoomPackage.getProtocolClass(), null, "protocol", null, 0, 1, InterfaceItemInstance.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceItemInstance_Peers(), this.getInterfaceItemInstance(), null, "peers", null, 0, -1, InterfaceItemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getSAPInstance_Sap(), theRoomPackage.getSAPRef(), null, "sap", null, 0, 1, SAPInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sppInstanceEClass, SPPInstance.class, "SPPInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSPPInstance_Spp(), theRoomPackage.getSPPRef(), null, "spp", null, 0, 1, SPPInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSPPInstance_Incoming(), this.getConnectionInstance(), this.getConnectionInstance_ToSPP(), "incoming", null, 0, -1, SPPInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSPPInstance_Outgoing(), this.getConnectionInstance(), this.getConnectionInstance_FromSPP(), "outgoing", null, 0, 1, SPPInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceImplInstanceEClass, ServiceImplInstance.class, "ServiceImplInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceImplInstance_SvcImpl(), theRoomPackage.getServiceImplementation(), null, "svcImpl", null, 0, 1, ServiceImplInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionInstanceEClass, ConnectionInstance.class, "ConnectionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionInstance_FromAI(), this.getActorInstance(), null, "fromAI", null, 0, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionInstance_FromSPP(), this.getSPPInstance(), this.getSPPInstance_Outgoing(), "fromSPP", null, 0, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionInstance_ToSPP(), this.getSPPInstance(), this.getSPPInstance_Incoming(), "toSPP", null, 0, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionInstance_Connection(), theRoomPackage.getLayerConnection(), null, "connection", null, 0, 1, ConnectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activeTriggerEClass, ActiveTrigger.class, "ActiveTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActiveTrigger_Msg(), theRoomPackage.getMessage(), null, "msg", null, 0, 1, ActiveTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActiveTrigger_Ifitem(), theRoomPackage.getInterfaceItem(), null, "ifitem", null, 0, 1, ActiveTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActiveTrigger_Trigger(), ecorePackage.getEString(), "trigger", null, 0, 1, ActiveTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActiveTrigger_Transitions(), theRoomPackage.getTriggeredTransition(), null, "transitions", null, 0, -1, ActiveTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionChainEClass, TransitionChain.class, "TransitionChain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransitionChain_Transition(), theRoomPackage.getTransition(), null, "transition", null, 0, 1, TransitionChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransitionChain_SkipEntry(), ecorePackage.getEBoolean(), "skipEntry", "false", 0, 1, TransitionChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionChain_Data(), theRoomPackage.getVarDecl(), null, "data", null, 0, 1, TransitionChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(transitionChainEClass, theRoomPackage.getState(), "getStateContext", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(transitionChainEClass, ecorePackage.getEBoolean(), "isHandler", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(transitionChainEClass, ecorePackage.getEString(), "genExecuteChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getITransitionChainVisitor(), "tcv", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iTransitionChainVisitorEClass, Object.class, "ITransitionChainVisitor", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(iDiagnosticianEClass, Object.class, "IDiagnostician", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(expandedActorClassEClass, ExpandedActorClass.class, "ExpandedActorClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandedActorClass_ActorClass(), theRoomPackage.getActorClass(), null, "actorClass", null, 0, 1, ExpandedActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpandedActorClass_StateMachine(), theRoomPackage.getStateGraph(), null, "stateMachine", null, 0, 1, ExpandedActorClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, null, "prepare", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIDiagnostician(), "validator", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedActorClassEClass, null, "release", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, null, "addOwnObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getStateGraphItem(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, ecorePackage.getEBoolean(), "isOwnObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getStateGraphItem(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, ecorePackage.getEInt(), "getInterfaceItemLocalId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getInterfaceItem(), "ifitem", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedActorClassEClass, ecorePackage.getEBoolean(), "hasStateMachine", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, ecorePackage.getEString(), "getTriggerCodeName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getMessageFromIf(), "mif", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, ecorePackage.getEString(), "getTriggerCodeName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "mif", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, theRoomPackage.getTransition(), "getOutgoingTransitions", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getStateGraphNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, theRoomPackage.getTransition(), "getIncomingTransitions", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getStateGraphNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, this.getActiveTrigger(), "getActiveTriggers", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getState(), "state", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedActorClassEClass, theRoomPackage.getMessageFromIf(), "getTriggers", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedActorClassEClass, theRoomPackage.getMessageFromIf(), "getOwnTriggers", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, ecorePackage.getEString(), "getMessageID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getMessageFromIf(), "mif", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, this.getTransitionChain(), "getChain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getTransition(), "trans", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedActorClassEClass, this.getTransitionChain(), "getTransitionChains", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expandedActorClassEClass, this.getTransitionChain(), "getOwnTransitionChains", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, theRoomPackage.getStateGraphNode(), "getNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getTransitionTerminal(), "tt", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, ecorePackage.getEBoolean(), "isMatching", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getTrigger(), "trig", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "trigstr", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, theRoomPackage.getContinuationTransition(), "getDefaultBranch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getTransition(), "out", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, ecorePackage.getEObject(), "getOrig", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "copy", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(expandedActorClassEClass, theRoomPackage.getVarDecl(), "getData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getTransition(), "trans", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(expandedRefinedStateEClass, ExpandedRefinedState.class, "ExpandedRefinedState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandedRefinedState_InheritedEntry(), theRoomPackage.getDetailCode(), null, "inheritedEntry", null, 0, 1, ExpandedRefinedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpandedRefinedState_InheritedExit(), theRoomPackage.getDetailCode(), null, "inheritedExit", null, 0, 1, ExpandedRefinedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpandedRefinedState_InheritedDo(), theRoomPackage.getDetailCode(), null, "inheritedDo", null, 0, 1, ExpandedRefinedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(expandedRefinedStateEClass, null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theRoomPackage.getRefinedState(), "rs", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(portKindEEnum, PortKind.class, "PortKind");
		addEEnumLiteral(portKindEEnum, PortKind.EXTERNAL);
		addEEnumLiteral(portKindEEnum, PortKind.INTERNAL);
		addEEnumLiteral(portKindEEnum, PortKind.RELAY);

		// Create resource
		createResource(eNS_URI);
	}

} //ETriceGenPackageImpl
