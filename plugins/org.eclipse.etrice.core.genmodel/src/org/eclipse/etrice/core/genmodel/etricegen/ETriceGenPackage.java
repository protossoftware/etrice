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
package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenFactory
 * @model kind="package"
 * @generated
 */
public interface ETriceGenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "etricegen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/etrice/generator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "etricegen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ETriceGenPackage eINSTANCE = org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__LIBRARY = 0;

	/**
	 * The feature id for the '<em><b>System Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__SYSTEM_INSTANCES = 1;

	/**
	 * The feature id for the '<em><b>Own Sub System Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OWN_SUB_SYSTEM_INSTANCES = 2;

	/**
	 * The feature id for the '<em><b>Sub System Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__SUB_SYSTEM_INSTANCES = 3;

	/**
	 * The feature id for the '<em><b>Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__MODELS = 4;

	/**
	 * The feature id for the '<em><b>Imported Models</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__IMPORTED_MODELS = 5;

	/**
	 * The feature id for the '<em><b>Xp Actor Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__XP_ACTOR_CLASSES = 6;

	/**
	 * The feature id for the '<em><b>Data Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__DATA_CLASSES = 7;

	/**
	 * The feature id for the '<em><b>Protocol Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__PROTOCOL_CLASSES = 8;

	/**
	 * The feature id for the '<em><b>Actor Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__ACTOR_CLASSES = 9;

	/**
	 * The feature id for the '<em><b>Enum Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__ENUM_CLASSES = 10;

	/**
	 * The feature id for the '<em><b>Sub System Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__SUB_SYSTEM_CLASSES = 11;

	/**
	 * The feature id for the '<em><b>Optional Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OPTIONAL_INSTANCES = 12;

	/**
	 * The feature id for the '<em><b>Optional Actor Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OPTIONAL_ACTOR_CLASSES = 13;

	/**
	 * The feature id for the '<em><b>Wired Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__WIRED_INSTANCES = 14;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InstanceBaseImpl <em>Instance Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.InstanceBaseImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getInstanceBase()
	 * @generated
	 */
	int INSTANCE_BASE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_BASE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_BASE__PATH = 1;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_BASE__OBJ_ID = 2;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_BASE__THREAD_ID = 3;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_BASE__NOBJ_IDS = 4;

	/**
	 * The number of structural features of the '<em>Instance Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_BASE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.AbstractInstanceImpl <em>Abstract Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.AbstractInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getAbstractInstance()
	 * @generated
	 */
	int ABSTRACT_INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_INSTANCE__NAME = INSTANCE_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_INSTANCE__PATH = INSTANCE_BASE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_INSTANCE__OBJ_ID = INSTANCE_BASE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_INSTANCE__THREAD_ID = INSTANCE_BASE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_INSTANCE__NOBJ_IDS = INSTANCE_BASE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_INSTANCE__PORTS = INSTANCE_BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_INSTANCE_FEATURE_COUNT = INSTANCE_BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInterfaceInstanceImpl <em>Actor Interface Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInterfaceInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getActorInterfaceInstance()
	 * @generated
	 */
	int ACTOR_INTERFACE_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__NAME = ABSTRACT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__PATH = ABSTRACT_INSTANCE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__OBJ_ID = ABSTRACT_INSTANCE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__THREAD_ID = ABSTRACT_INSTANCE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__NOBJ_IDS = ABSTRACT_INSTANCE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__PORTS = ABSTRACT_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__ACTOR_CLASS = ABSTRACT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provided Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__PROVIDED_SERVICES = ABSTRACT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Optional Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__OPTIONAL_INSTANCES = ABSTRACT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE__ARRAY = ABSTRACT_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Actor Interface Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INTERFACE_INSTANCE_FEATURE_COUNT = ABSTRACT_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl <em>Structure Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getStructureInstance()
	 * @generated
	 */
	int STRUCTURE_INSTANCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__NAME = ABSTRACT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__PATH = ABSTRACT_INSTANCE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__OBJ_ID = ABSTRACT_INSTANCE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__THREAD_ID = ABSTRACT_INSTANCE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__NOBJ_IDS = ABSTRACT_INSTANCE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__PORTS = ABSTRACT_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__INSTANCES = ABSTRACT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Saps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__SAPS = ABSTRACT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Spps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__SPPS = ABSTRACT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__SERVICES = ABSTRACT_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__BINDINGS = ABSTRACT_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__CONNECTIONS = ABSTRACT_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>All Contained Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES = ABSTRACT_INSTANCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Ordered If Item Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE__ORDERED_IF_ITEM_INSTANCES = ABSTRACT_INSTANCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Structure Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_INSTANCE_FEATURE_COUNT = ABSTRACT_INSTANCE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SystemInstanceImpl <em>System Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.SystemInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getSystemInstance()
	 * @generated
	 */
	int SYSTEM_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__NAME = INSTANCE_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__PATH = INSTANCE_BASE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__OBJ_ID = INSTANCE_BASE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__THREAD_ID = INSTANCE_BASE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__NOBJ_IDS = INSTANCE_BASE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__INSTANCES = INSTANCE_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logical System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE__LOGICAL_SYSTEM = INSTANCE_BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INSTANCE_FEATURE_COUNT = INSTANCE_BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SubSystemInstanceImpl <em>Sub System Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.SubSystemInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getSubSystemInstance()
	 * @generated
	 */
	int SUB_SYSTEM_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__NAME = STRUCTURE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__PATH = STRUCTURE_INSTANCE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__OBJ_ID = STRUCTURE_INSTANCE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__THREAD_ID = STRUCTURE_INSTANCE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__NOBJ_IDS = STRUCTURE_INSTANCE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__PORTS = STRUCTURE_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__INSTANCES = STRUCTURE_INSTANCE__INSTANCES;

	/**
	 * The feature id for the '<em><b>Saps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__SAPS = STRUCTURE_INSTANCE__SAPS;

	/**
	 * The feature id for the '<em><b>Spps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__SPPS = STRUCTURE_INSTANCE__SPPS;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__SERVICES = STRUCTURE_INSTANCE__SERVICES;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__BINDINGS = STRUCTURE_INSTANCE__BINDINGS;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__CONNECTIONS = STRUCTURE_INSTANCE__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>All Contained Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__ALL_CONTAINED_INSTANCES = STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES;

	/**
	 * The feature id for the '<em><b>Ordered If Item Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__ORDERED_IF_ITEM_INSTANCES = STRUCTURE_INSTANCE__ORDERED_IF_ITEM_INSTANCES;

	/**
	 * The feature id for the '<em><b>Sub System Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__SUB_SYSTEM_CLASS = STRUCTURE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE__MAX_OBJ_ID = STRUCTURE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sub System Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_INSTANCE_FEATURE_COUNT = STRUCTURE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInstanceImpl <em>Actor Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getActorInstance()
	 * @generated
	 */
	int ACTOR_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__NAME = STRUCTURE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__PATH = STRUCTURE_INSTANCE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__OBJ_ID = STRUCTURE_INSTANCE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__THREAD_ID = STRUCTURE_INSTANCE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__NOBJ_IDS = STRUCTURE_INSTANCE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__PORTS = STRUCTURE_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__INSTANCES = STRUCTURE_INSTANCE__INSTANCES;

	/**
	 * The feature id for the '<em><b>Saps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__SAPS = STRUCTURE_INSTANCE__SAPS;

	/**
	 * The feature id for the '<em><b>Spps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__SPPS = STRUCTURE_INSTANCE__SPPS;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__SERVICES = STRUCTURE_INSTANCE__SERVICES;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__BINDINGS = STRUCTURE_INSTANCE__BINDINGS;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__CONNECTIONS = STRUCTURE_INSTANCE__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>All Contained Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__ALL_CONTAINED_INSTANCES = STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES;

	/**
	 * The feature id for the '<em><b>Ordered If Item Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__ORDERED_IF_ITEM_INSTANCES = STRUCTURE_INSTANCE__ORDERED_IF_ITEM_INSTANCES;

	/**
	 * The feature id for the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__ACTOR_CLASS = STRUCTURE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Repl Idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__REPL_IDX = STRUCTURE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unindexed Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE__UNINDEXED_NAME = STRUCTURE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Actor Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_INSTANCE_FEATURE_COUNT = STRUCTURE_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OptionalActorInstanceImpl <em>Optional Actor Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.OptionalActorInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getOptionalActorInstance()
	 * @generated
	 */
	int OPTIONAL_ACTOR_INSTANCE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__NAME = STRUCTURE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__PATH = STRUCTURE_INSTANCE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__OBJ_ID = STRUCTURE_INSTANCE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__THREAD_ID = STRUCTURE_INSTANCE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__NOBJ_IDS = STRUCTURE_INSTANCE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__PORTS = STRUCTURE_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__INSTANCES = STRUCTURE_INSTANCE__INSTANCES;

	/**
	 * The feature id for the '<em><b>Saps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__SAPS = STRUCTURE_INSTANCE__SAPS;

	/**
	 * The feature id for the '<em><b>Spps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__SPPS = STRUCTURE_INSTANCE__SPPS;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__SERVICES = STRUCTURE_INSTANCE__SERVICES;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__BINDINGS = STRUCTURE_INSTANCE__BINDINGS;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__CONNECTIONS = STRUCTURE_INSTANCE__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>All Contained Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__ALL_CONTAINED_INSTANCES = STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES;

	/**
	 * The feature id for the '<em><b>Ordered If Item Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__ORDERED_IF_ITEM_INSTANCES = STRUCTURE_INSTANCE__ORDERED_IF_ITEM_INSTANCES;

	/**
	 * The feature id for the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__ACTOR_CLASS = STRUCTURE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE__REQUIRED_SERVICES = STRUCTURE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Optional Actor Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_ACTOR_INSTANCE_FEATURE_COUNT = STRUCTURE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InterfaceItemInstanceImpl <em>Interface Item Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.InterfaceItemInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getInterfaceItemInstance()
	 * @generated
	 */
	int INTERFACE_ITEM_INSTANCE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ITEM_INSTANCE__NAME = INSTANCE_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ITEM_INSTANCE__PATH = INSTANCE_BASE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ITEM_INSTANCE__OBJ_ID = INSTANCE_BASE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ITEM_INSTANCE__THREAD_ID = INSTANCE_BASE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ITEM_INSTANCE__NOBJ_IDS = INSTANCE_BASE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ITEM_INSTANCE__PROTOCOL = INSTANCE_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Peers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ITEM_INSTANCE__PEERS = INSTANCE_BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Interface Item Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ITEM_INSTANCE_FEATURE_COUNT = INSTANCE_BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.PortInstanceImpl <em>Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.PortInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getPortInstance()
	 * @generated
	 */
	int PORT_INSTANCE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__NAME = INTERFACE_ITEM_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__PATH = INTERFACE_ITEM_INSTANCE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__OBJ_ID = INTERFACE_ITEM_INSTANCE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__THREAD_ID = INTERFACE_ITEM_INSTANCE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__NOBJ_IDS = INTERFACE_ITEM_INSTANCE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__PROTOCOL = INTERFACE_ITEM_INSTANCE__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Peers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__PEERS = INTERFACE_ITEM_INSTANCE__PEERS;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__PORT = INTERFACE_ITEM_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__KIND = INTERFACE_ITEM_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__BINDINGS = INTERFACE_ITEM_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE_FEATURE_COUNT = INTERFACE_ITEM_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.BindingInstanceImpl <em>Binding Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.BindingInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getBindingInstance()
	 * @generated
	 */
	int BINDING_INSTANCE = 11;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_INSTANCE__PORTS = 0;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_INSTANCE__BINDING = 1;

	/**
	 * The number of structural features of the '<em>Binding Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_INSTANCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SAPInstanceImpl <em>SAP Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.SAPInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getSAPInstance()
	 * @generated
	 */
	int SAP_INSTANCE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAP_INSTANCE__NAME = INTERFACE_ITEM_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAP_INSTANCE__PATH = INTERFACE_ITEM_INSTANCE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAP_INSTANCE__OBJ_ID = INTERFACE_ITEM_INSTANCE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAP_INSTANCE__THREAD_ID = INTERFACE_ITEM_INSTANCE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAP_INSTANCE__NOBJ_IDS = INTERFACE_ITEM_INSTANCE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAP_INSTANCE__PROTOCOL = INTERFACE_ITEM_INSTANCE__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Peers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAP_INSTANCE__PEERS = INTERFACE_ITEM_INSTANCE__PEERS;

	/**
	 * The feature id for the '<em><b>Sap</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAP_INSTANCE__SAP = INTERFACE_ITEM_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SAP Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAP_INSTANCE_FEATURE_COUNT = INTERFACE_ITEM_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SPPInstanceImpl <em>SPP Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.SPPInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getSPPInstance()
	 * @generated
	 */
	int SPP_INSTANCE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPP_INSTANCE__NAME = INSTANCE_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPP_INSTANCE__PATH = INSTANCE_BASE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPP_INSTANCE__OBJ_ID = INSTANCE_BASE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPP_INSTANCE__THREAD_ID = INSTANCE_BASE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPP_INSTANCE__NOBJ_IDS = INSTANCE_BASE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Spp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPP_INSTANCE__SPP = INSTANCE_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPP_INSTANCE__INCOMING = INSTANCE_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPP_INSTANCE__OUTGOING = INSTANCE_BASE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SPP Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPP_INSTANCE_FEATURE_COUNT = INSTANCE_BASE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ServiceImplInstanceImpl <em>Service Impl Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ServiceImplInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getServiceImplInstance()
	 * @generated
	 */
	int SERVICE_IMPL_INSTANCE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_IMPL_INSTANCE__NAME = INTERFACE_ITEM_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_IMPL_INSTANCE__PATH = INTERFACE_ITEM_INSTANCE__PATH;

	/**
	 * The feature id for the '<em><b>Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_IMPL_INSTANCE__OBJ_ID = INTERFACE_ITEM_INSTANCE__OBJ_ID;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_IMPL_INSTANCE__THREAD_ID = INTERFACE_ITEM_INSTANCE__THREAD_ID;

	/**
	 * The feature id for the '<em><b>NObj IDs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_IMPL_INSTANCE__NOBJ_IDS = INTERFACE_ITEM_INSTANCE__NOBJ_IDS;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_IMPL_INSTANCE__PROTOCOL = INTERFACE_ITEM_INSTANCE__PROTOCOL;

	/**
	 * The feature id for the '<em><b>Peers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_IMPL_INSTANCE__PEERS = INTERFACE_ITEM_INSTANCE__PEERS;

	/**
	 * The feature id for the '<em><b>Svc Impl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_IMPL_INSTANCE__SVC_IMPL = INTERFACE_ITEM_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Service Impl Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_IMPL_INSTANCE_FEATURE_COUNT = INTERFACE_ITEM_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ConnectionInstanceImpl <em>Connection Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ConnectionInstanceImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getConnectionInstance()
	 * @generated
	 */
	int CONNECTION_INSTANCE = 15;

	/**
	 * The feature id for the '<em><b>From AI</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__FROM_AI = 0;

	/**
	 * The feature id for the '<em><b>From SPP</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__FROM_SPP = 1;

	/**
	 * The feature id for the '<em><b>To SPP</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__TO_SPP = 2;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE__CONNECTION = 3;

	/**
	 * The number of structural features of the '<em>Connection Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_INSTANCE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedActorClassImpl <em>Expanded Actor Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedActorClassImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getExpandedActorClass()
	 * @generated
	 */
	int EXPANDED_ACTOR_CLASS = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredStructureClassImpl <em>Wired Structure Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.WiredStructureClassImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getWiredStructureClass()
	 * @generated
	 */
	int WIRED_STRUCTURE_CLASS = 16;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_STRUCTURE_CLASS__WIRES = 0;

	/**
	 * The feature id for the '<em><b>Open Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_STRUCTURE_CLASS__OPEN_BINDINGS = 1;

	/**
	 * The feature id for the '<em><b>Provided Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES = 2;

	/**
	 * The feature id for the '<em><b>Required Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES = 3;

	/**
	 * The number of structural features of the '<em>Wired Structure Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_STRUCTURE_CLASS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OpenBindingImpl <em>Open Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.OpenBindingImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getOpenBinding()
	 * @generated
	 */
	int OPEN_BINDING = 17;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_BINDING__PATH = 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_BINDING__PORT = 1;

	/**
	 * The number of structural features of the '<em>Open Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_BINDING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OpenServiceConnectionImpl <em>Open Service Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.OpenServiceConnectionImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getOpenServiceConnection()
	 * @generated
	 */
	int OPEN_SERVICE_CONNECTION = 18;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_SERVICE_CONNECTION__PATH = 0;

	/**
	 * The feature id for the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_SERVICE_CONNECTION__PROTOCOL = 1;

	/**
	 * The number of structural features of the '<em>Open Service Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_SERVICE_CONNECTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WireImpl <em>Wire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.WireImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getWire()
	 * @generated
	 */
	int WIRE = 19;

	/**
	 * The feature id for the '<em><b>Data Driven</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__DATA_DRIVEN = 0;

	/**
	 * The feature id for the '<em><b>Path1</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__PATH1 = 1;

	/**
	 * The feature id for the '<em><b>Path2</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE__PATH2 = 2;

	/**
	 * The number of structural features of the '<em>Wire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredActorClassImpl <em>Wired Actor Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.WiredActorClassImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getWiredActorClass()
	 * @generated
	 */
	int WIRED_ACTOR_CLASS = 20;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_ACTOR_CLASS__WIRES = WIRED_STRUCTURE_CLASS__WIRES;

	/**
	 * The feature id for the '<em><b>Open Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_ACTOR_CLASS__OPEN_BINDINGS = WIRED_STRUCTURE_CLASS__OPEN_BINDINGS;

	/**
	 * The feature id for the '<em><b>Provided Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_ACTOR_CLASS__PROVIDED_SERVICES = WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES;

	/**
	 * The feature id for the '<em><b>Required Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_ACTOR_CLASS__REQUIRED_SERVICES = WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES;

	/**
	 * The feature id for the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_ACTOR_CLASS__ACTOR_CLASS = WIRED_STRUCTURE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wired Actor Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_ACTOR_CLASS_FEATURE_COUNT = WIRED_STRUCTURE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredSubSystemClassImpl <em>Wired Sub System Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.WiredSubSystemClassImpl
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getWiredSubSystemClass()
	 * @generated
	 */
	int WIRED_SUB_SYSTEM_CLASS = 21;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_SUB_SYSTEM_CLASS__WIRES = WIRED_STRUCTURE_CLASS__WIRES;

	/**
	 * The feature id for the '<em><b>Open Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_SUB_SYSTEM_CLASS__OPEN_BINDINGS = WIRED_STRUCTURE_CLASS__OPEN_BINDINGS;

	/**
	 * The feature id for the '<em><b>Provided Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_SUB_SYSTEM_CLASS__PROVIDED_SERVICES = WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES;

	/**
	 * The feature id for the '<em><b>Required Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_SUB_SYSTEM_CLASS__REQUIRED_SERVICES = WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES;

	/**
	 * The feature id for the '<em><b>Sub System Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_SUB_SYSTEM_CLASS__SUB_SYSTEM_CLASS = WIRED_STRUCTURE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wired Sub System Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIRED_SUB_SYSTEM_CLASS_FEATURE_COUNT = WIRED_STRUCTURE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actor Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_ACTOR_CLASS__ACTOR_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Graph Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER = 1;

	/**
	 * The number of structural features of the '<em>Expanded Actor Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDED_ACTOR_CLASS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.etrice.core.genmodel.etricegen.PortKind <em>Port Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortKind
	 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getPortKind()
	 * @generated
	 */
	int PORT_KIND = 23;


	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#isLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Library</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#isLibrary()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_Library();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getSystemInstances <em>System Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>System Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getSystemInstances()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_SystemInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getOwnSubSystemInstances <em>Own Sub System Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Own Sub System Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getOwnSubSystemInstances()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_OwnSubSystemInstances();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getSubSystemInstances <em>Sub System Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub System Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getSubSystemInstances()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_SubSystemInstances();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Models</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getModels()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Models();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getImportedModels <em>Imported Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imported Models</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getImportedModels()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_ImportedModels();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getXpActorClasses <em>Xp Actor Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Xp Actor Classes</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getXpActorClasses()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_XpActorClasses();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getDataClasses <em>Data Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Classes</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getDataClasses()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_DataClasses();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getProtocolClasses <em>Protocol Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Protocol Classes</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getProtocolClasses()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_ProtocolClasses();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getActorClasses <em>Actor Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actor Classes</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getActorClasses()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_ActorClasses();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getEnumClasses <em>Enum Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Enum Classes</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getEnumClasses()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_EnumClasses();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getSubSystemClasses <em>Sub System Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub System Classes</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getSubSystemClasses()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_SubSystemClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getOptionalInstances <em>Optional Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Optional Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getOptionalInstances()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_OptionalInstances();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getOptionalActorClasses <em>Optional Actor Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Optional Actor Classes</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getOptionalActorClasses()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_OptionalActorClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.Root#getWiredInstances <em>Wired Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Wired Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Root#getWiredInstances()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_WiredInstances();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.InstanceBase <em>Instance Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Base</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InstanceBase
	 * @generated
	 */
	EClass getInstanceBase();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getName()
	 * @see #getInstanceBase()
	 * @generated
	 */
	EAttribute getInstanceBase_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getPath()
	 * @see #getInstanceBase()
	 * @generated
	 */
	EAttribute getInstanceBase_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getObjId <em>Obj Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obj Id</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getObjId()
	 * @see #getInstanceBase()
	 * @generated
	 */
	EAttribute getInstanceBase_ObjId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getThreadId <em>Thread Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thread Id</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getThreadId()
	 * @see #getInstanceBase()
	 * @generated
	 */
	EAttribute getInstanceBase_ThreadId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getNObjIDs <em>NObj IDs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>NObj IDs</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InstanceBase#getNObjIDs()
	 * @see #getInstanceBase()
	 * @generated
	 */
	EAttribute getInstanceBase_NObjIDs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance <em>Abstract Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance
	 * @generated
	 */
	EClass getAbstractInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance#getPorts()
	 * @see #getAbstractInstance()
	 * @generated
	 */
	EReference getAbstractInstance_Ports();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance <em>Actor Interface Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Interface Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance
	 * @generated
	 */
	EClass getActorInterfaceInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance#getActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance#getActorClass()
	 * @see #getActorInterfaceInstance()
	 * @generated
	 */
	EReference getActorInterfaceInstance_ActorClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance#getProvidedServices <em>Provided Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Provided Services</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance#getProvidedServices()
	 * @see #getActorInterfaceInstance()
	 * @generated
	 */
	EReference getActorInterfaceInstance_ProvidedServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance#getOptionalInstances <em>Optional Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Optional Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance#getOptionalInstances()
	 * @see #getActorInterfaceInstance()
	 * @generated
	 */
	EReference getActorInterfaceInstance_OptionalInstances();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance#isArray <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance#isArray()
	 * @see #getActorInterfaceInstance()
	 * @generated
	 */
	EAttribute getActorInterfaceInstance_Array();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance <em>Structure Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance
	 * @generated
	 */
	EClass getStructureInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getInstances()
	 * @see #getStructureInstance()
	 * @generated
	 */
	EReference getStructureInstance_Instances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getSaps <em>Saps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Saps</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getSaps()
	 * @see #getStructureInstance()
	 * @generated
	 */
	EReference getStructureInstance_Saps();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getSpps <em>Spps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Spps</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getSpps()
	 * @see #getStructureInstance()
	 * @generated
	 */
	EReference getStructureInstance_Spps();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getServices()
	 * @see #getStructureInstance()
	 * @generated
	 */
	EReference getStructureInstance_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getBindings()
	 * @see #getStructureInstance()
	 * @generated
	 */
	EReference getStructureInstance_Bindings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getConnections()
	 * @see #getStructureInstance()
	 * @generated
	 */
	EReference getStructureInstance_Connections();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getAllContainedInstances <em>All Contained Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Contained Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getAllContainedInstances()
	 * @see #getStructureInstance()
	 * @generated
	 */
	EReference getStructureInstance_AllContainedInstances();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getOrderedIfItemInstances <em>Ordered If Item Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ordered If Item Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.StructureInstance#getOrderedIfItemInstances()
	 * @see #getStructureInstance()
	 * @generated
	 */
	EReference getStructureInstance_OrderedIfItemInstances();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.SystemInstance <em>System Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SystemInstance
	 * @generated
	 */
	EClass getSystemInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.SystemInstance#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SystemInstance#getInstances()
	 * @see #getSystemInstance()
	 * @generated
	 */
	EReference getSystemInstance_Instances();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.SystemInstance#getLogicalSystem <em>Logical System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Logical System</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SystemInstance#getLogicalSystem()
	 * @see #getSystemInstance()
	 * @generated
	 */
	EReference getSystemInstance_LogicalSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance <em>Sub System Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub System Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
	 * @generated
	 */
	EClass getSubSystemInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance#getSubSystemClass <em>Sub System Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub System Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance#getSubSystemClass()
	 * @see #getSubSystemInstance()
	 * @generated
	 */
	EReference getSubSystemInstance_SubSystemClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance#getMaxObjId <em>Max Obj Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Obj Id</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance#getMaxObjId()
	 * @see #getSubSystemInstance()
	 * @generated
	 */
	EAttribute getSubSystemInstance_MaxObjId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInstance <em>Actor Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
	 * @generated
	 */
	EClass getActorInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInstance#getActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInstance#getActorClass()
	 * @see #getActorInstance()
	 * @generated
	 */
	EReference getActorInstance_ActorClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInstance#getReplIdx <em>Repl Idx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repl Idx</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInstance#getReplIdx()
	 * @see #getActorInstance()
	 * @generated
	 */
	EAttribute getActorInstance_ReplIdx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.ActorInstance#getUnindexedName <em>Unindexed Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unindexed Name</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ActorInstance#getUnindexedName()
	 * @see #getActorInstance()
	 * @generated
	 */
	EAttribute getActorInstance_UnindexedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance <em>Optional Actor Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optional Actor Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance
	 * @generated
	 */
	EClass getOptionalActorInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance#getActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance#getActorClass()
	 * @see #getOptionalActorInstance()
	 * @generated
	 */
	EReference getOptionalActorInstance_ActorClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance#getRequiredServices <em>Required Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Services</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance#getRequiredServices()
	 * @see #getOptionalActorInstance()
	 * @generated
	 */
	EReference getOptionalActorInstance_RequiredServices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance <em>Interface Item Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Item Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance
	 * @generated
	 */
	EClass getInterfaceItemInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Protocol</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getProtocol()
	 * @see #getInterfaceItemInstance()
	 * @generated
	 */
	EReference getInterfaceItemInstance_Protocol();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getPeers <em>Peers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Peers</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance#getPeers()
	 * @see #getInterfaceItemInstance()
	 * @generated
	 */
	EReference getInterfaceItemInstance_Peers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance <em>Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortInstance
	 * @generated
	 */
	EClass getPortInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getPort()
	 * @see #getPortInstance()
	 * @generated
	 */
	EReference getPortInstance_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getKind()
	 * @see #getPortInstance()
	 * @generated
	 */
	EAttribute getPortInstance_Kind();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bindings</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortInstance#getBindings()
	 * @see #getPortInstance()
	 * @generated
	 */
	EReference getPortInstance_Bindings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance <em>Binding Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.BindingInstance
	 * @generated
	 */
	EClass getBindingInstance();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ports</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.BindingInstance#getPorts()
	 * @see #getBindingInstance()
	 * @generated
	 */
	EReference getBindingInstance_Ports();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.BindingInstance#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Binding</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.BindingInstance#getBinding()
	 * @see #getBindingInstance()
	 * @generated
	 */
	EReference getBindingInstance_Binding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance <em>SAP Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAP Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SAPInstance
	 * @generated
	 */
	EClass getSAPInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.SAPInstance#getSap <em>Sap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sap</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SAPInstance#getSap()
	 * @see #getSAPInstance()
	 * @generated
	 */
	EReference getSAPInstance_Sap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance <em>SPP Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPP Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SPPInstance
	 * @generated
	 */
	EClass getSPPInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getSpp <em>Spp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Spp</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getSpp()
	 * @see #getSPPInstance()
	 * @generated
	 */
	EReference getSPPInstance_Spp();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getIncoming()
	 * @see #getSPPInstance()
	 * @generated
	 */
	EReference getSPPInstance_Incoming();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.SPPInstance#getOutgoing()
	 * @see #getSPPInstance()
	 * @generated
	 */
	EReference getSPPInstance_Outgoing();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance <em>Service Impl Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Impl Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance
	 * @generated
	 */
	EClass getServiceImplInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance#getSvcImpl <em>Svc Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Svc Impl</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance#getSvcImpl()
	 * @see #getServiceImplInstance()
	 * @generated
	 */
	EReference getServiceImplInstance_SvcImpl();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance <em>Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Instance</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance
	 * @generated
	 */
	EClass getConnectionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromAI <em>From AI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From AI</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromAI()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EReference getConnectionInstance_FromAI();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromSPP <em>From SPP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From SPP</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getFromSPP()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EReference getConnectionInstance_FromSPP();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getToSPP <em>To SPP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To SPP</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getToSPP()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EReference getConnectionInstance_ToSPP();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance#getConnection()
	 * @see #getConnectionInstance()
	 * @generated
	 */
	EReference getConnectionInstance_Connection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass <em>Expanded Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expanded Actor Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
	 * @generated
	 */
	EClass getExpandedActorClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getActorClass()
	 * @see #getExpandedActorClass()
	 * @generated
	 */
	EReference getExpandedActorClass_ActorClass();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getGraphContainer <em>Graph Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graph Container</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass#getGraphContainer()
	 * @see #getExpandedActorClass()
	 * @generated
	 */
	EReference getExpandedActorClass_GraphContainer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass <em>Wired Structure Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wired Structure Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass
	 * @generated
	 */
	EClass getWiredStructureClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getWires <em>Wires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Wires</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getWires()
	 * @see #getWiredStructureClass()
	 * @generated
	 */
	EReference getWiredStructureClass_Wires();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getOpenBindings <em>Open Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Open Bindings</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getOpenBindings()
	 * @see #getWiredStructureClass()
	 * @generated
	 */
	EReference getWiredStructureClass_OpenBindings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getProvidedServices <em>Provided Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided Services</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getProvidedServices()
	 * @see #getWiredStructureClass()
	 * @generated
	 */
	EReference getWiredStructureClass_ProvidedServices();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getRequiredServices <em>Required Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Services</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass#getRequiredServices()
	 * @see #getWiredStructureClass()
	 * @generated
	 */
	EReference getWiredStructureClass_RequiredServices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.OpenBinding <em>Open Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Binding</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OpenBinding
	 * @generated
	 */
	EClass getOpenBinding();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.genmodel.etricegen.OpenBinding#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OpenBinding#getPath()
	 * @see #getOpenBinding()
	 * @generated
	 */
	EAttribute getOpenBinding_Path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.OpenBinding#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OpenBinding#getPort()
	 * @see #getOpenBinding()
	 * @generated
	 */
	EReference getOpenBinding_Port();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection <em>Open Service Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Service Connection</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection
	 * @generated
	 */
	EClass getOpenServiceConnection();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection#getPath()
	 * @see #getOpenServiceConnection()
	 * @generated
	 */
	EAttribute getOpenServiceConnection_Path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection#getProtocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Protocol</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection#getProtocol()
	 * @see #getOpenServiceConnection()
	 * @generated
	 */
	EReference getOpenServiceConnection_Protocol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.Wire <em>Wire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wire</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Wire
	 * @generated
	 */
	EClass getWire();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.etrice.core.genmodel.etricegen.Wire#isDataDriven <em>Data Driven</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Driven</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Wire#isDataDriven()
	 * @see #getWire()
	 * @generated
	 */
	EAttribute getWire_DataDriven();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.genmodel.etricegen.Wire#getPath1 <em>Path1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path1</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Wire#getPath1()
	 * @see #getWire()
	 * @generated
	 */
	EAttribute getWire_Path1();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.etrice.core.genmodel.etricegen.Wire#getPath2 <em>Path2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path2</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.Wire#getPath2()
	 * @see #getWire()
	 * @generated
	 */
	EAttribute getWire_Path2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass <em>Wired Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wired Actor Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass
	 * @generated
	 */
	EClass getWiredActorClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass#getActorClass <em>Actor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass#getActorClass()
	 * @see #getWiredActorClass()
	 * @generated
	 */
	EReference getWiredActorClass_ActorClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass <em>Wired Sub System Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wired Sub System Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass
	 * @generated
	 */
	EClass getWiredSubSystemClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass#getSubSystemClass <em>Sub System Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub System Class</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass#getSubSystemClass()
	 * @see #getWiredSubSystemClass()
	 * @generated
	 */
	EReference getWiredSubSystemClass_SubSystemClass();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.etrice.core.genmodel.etricegen.PortKind <em>Port Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Kind</em>'.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.PortKind
	 * @generated
	 */
	EEnum getPortKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ETriceGenFactory getETriceGenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.RootImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Library</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT__LIBRARY = eINSTANCE.getRoot_Library();

		/**
		 * The meta object literal for the '<em><b>System Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__SYSTEM_INSTANCES = eINSTANCE.getRoot_SystemInstances();

		/**
		 * The meta object literal for the '<em><b>Own Sub System Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__OWN_SUB_SYSTEM_INSTANCES = eINSTANCE.getRoot_OwnSubSystemInstances();

		/**
		 * The meta object literal for the '<em><b>Sub System Instances</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__SUB_SYSTEM_INSTANCES = eINSTANCE.getRoot_SubSystemInstances();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__MODELS = eINSTANCE.getRoot_Models();

		/**
		 * The meta object literal for the '<em><b>Imported Models</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__IMPORTED_MODELS = eINSTANCE.getRoot_ImportedModels();

		/**
		 * The meta object literal for the '<em><b>Xp Actor Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__XP_ACTOR_CLASSES = eINSTANCE.getRoot_XpActorClasses();

		/**
		 * The meta object literal for the '<em><b>Data Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__DATA_CLASSES = eINSTANCE.getRoot_DataClasses();

		/**
		 * The meta object literal for the '<em><b>Protocol Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__PROTOCOL_CLASSES = eINSTANCE.getRoot_ProtocolClasses();

		/**
		 * The meta object literal for the '<em><b>Actor Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__ACTOR_CLASSES = eINSTANCE.getRoot_ActorClasses();

		/**
		 * The meta object literal for the '<em><b>Enum Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__ENUM_CLASSES = eINSTANCE.getRoot_EnumClasses();

		/**
		 * The meta object literal for the '<em><b>Sub System Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__SUB_SYSTEM_CLASSES = eINSTANCE.getRoot_SubSystemClasses();

		/**
		 * The meta object literal for the '<em><b>Optional Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__OPTIONAL_INSTANCES = eINSTANCE.getRoot_OptionalInstances();

		/**
		 * The meta object literal for the '<em><b>Optional Actor Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__OPTIONAL_ACTOR_CLASSES = eINSTANCE.getRoot_OptionalActorClasses();

		/**
		 * The meta object literal for the '<em><b>Wired Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__WIRED_INSTANCES = eINSTANCE.getRoot_WiredInstances();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InstanceBaseImpl <em>Instance Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.InstanceBaseImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getInstanceBase()
		 * @generated
		 */
		EClass INSTANCE_BASE = eINSTANCE.getInstanceBase();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_BASE__NAME = eINSTANCE.getInstanceBase_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_BASE__PATH = eINSTANCE.getInstanceBase_Path();

		/**
		 * The meta object literal for the '<em><b>Obj Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_BASE__OBJ_ID = eINSTANCE.getInstanceBase_ObjId();

		/**
		 * The meta object literal for the '<em><b>Thread Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_BASE__THREAD_ID = eINSTANCE.getInstanceBase_ThreadId();

		/**
		 * The meta object literal for the '<em><b>NObj IDs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_BASE__NOBJ_IDS = eINSTANCE.getInstanceBase_NObjIDs();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.AbstractInstanceImpl <em>Abstract Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.AbstractInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getAbstractInstance()
		 * @generated
		 */
		EClass ABSTRACT_INSTANCE = eINSTANCE.getAbstractInstance();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_INSTANCE__PORTS = eINSTANCE.getAbstractInstance_Ports();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInterfaceInstanceImpl <em>Actor Interface Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInterfaceInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getActorInterfaceInstance()
		 * @generated
		 */
		EClass ACTOR_INTERFACE_INSTANCE = eINSTANCE.getActorInterfaceInstance();

		/**
		 * The meta object literal for the '<em><b>Actor Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_INTERFACE_INSTANCE__ACTOR_CLASS = eINSTANCE.getActorInterfaceInstance_ActorClass();

		/**
		 * The meta object literal for the '<em><b>Provided Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_INTERFACE_INSTANCE__PROVIDED_SERVICES = eINSTANCE.getActorInterfaceInstance_ProvidedServices();

		/**
		 * The meta object literal for the '<em><b>Optional Instances</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_INTERFACE_INSTANCE__OPTIONAL_INSTANCES = eINSTANCE.getActorInterfaceInstance_OptionalInstances();

		/**
		 * The meta object literal for the '<em><b>Array</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_INTERFACE_INSTANCE__ARRAY = eINSTANCE.getActorInterfaceInstance_Array();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl <em>Structure Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getStructureInstance()
		 * @generated
		 */
		EClass STRUCTURE_INSTANCE = eINSTANCE.getStructureInstance();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_INSTANCE__INSTANCES = eINSTANCE.getStructureInstance_Instances();

		/**
		 * The meta object literal for the '<em><b>Saps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_INSTANCE__SAPS = eINSTANCE.getStructureInstance_Saps();

		/**
		 * The meta object literal for the '<em><b>Spps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_INSTANCE__SPPS = eINSTANCE.getStructureInstance_Spps();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_INSTANCE__SERVICES = eINSTANCE.getStructureInstance_Services();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_INSTANCE__BINDINGS = eINSTANCE.getStructureInstance_Bindings();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_INSTANCE__CONNECTIONS = eINSTANCE.getStructureInstance_Connections();

		/**
		 * The meta object literal for the '<em><b>All Contained Instances</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_INSTANCE__ALL_CONTAINED_INSTANCES = eINSTANCE.getStructureInstance_AllContainedInstances();

		/**
		 * The meta object literal for the '<em><b>Ordered If Item Instances</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_INSTANCE__ORDERED_IF_ITEM_INSTANCES = eINSTANCE.getStructureInstance_OrderedIfItemInstances();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SystemInstanceImpl <em>System Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.SystemInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getSystemInstance()
		 * @generated
		 */
		EClass SYSTEM_INSTANCE = eINSTANCE.getSystemInstance();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_INSTANCE__INSTANCES = eINSTANCE.getSystemInstance_Instances();

		/**
		 * The meta object literal for the '<em><b>Logical System</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_INSTANCE__LOGICAL_SYSTEM = eINSTANCE.getSystemInstance_LogicalSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SubSystemInstanceImpl <em>Sub System Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.SubSystemInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getSubSystemInstance()
		 * @generated
		 */
		EClass SUB_SYSTEM_INSTANCE = eINSTANCE.getSubSystemInstance();

		/**
		 * The meta object literal for the '<em><b>Sub System Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_SYSTEM_INSTANCE__SUB_SYSTEM_CLASS = eINSTANCE.getSubSystemInstance_SubSystemClass();

		/**
		 * The meta object literal for the '<em><b>Max Obj Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_SYSTEM_INSTANCE__MAX_OBJ_ID = eINSTANCE.getSubSystemInstance_MaxObjId();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInstanceImpl <em>Actor Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ActorInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getActorInstance()
		 * @generated
		 */
		EClass ACTOR_INSTANCE = eINSTANCE.getActorInstance();

		/**
		 * The meta object literal for the '<em><b>Actor Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_INSTANCE__ACTOR_CLASS = eINSTANCE.getActorInstance_ActorClass();

		/**
		 * The meta object literal for the '<em><b>Repl Idx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_INSTANCE__REPL_IDX = eINSTANCE.getActorInstance_ReplIdx();

		/**
		 * The meta object literal for the '<em><b>Unindexed Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_INSTANCE__UNINDEXED_NAME = eINSTANCE.getActorInstance_UnindexedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OptionalActorInstanceImpl <em>Optional Actor Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.OptionalActorInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getOptionalActorInstance()
		 * @generated
		 */
		EClass OPTIONAL_ACTOR_INSTANCE = eINSTANCE.getOptionalActorInstance();

		/**
		 * The meta object literal for the '<em><b>Actor Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIONAL_ACTOR_INSTANCE__ACTOR_CLASS = eINSTANCE.getOptionalActorInstance_ActorClass();

		/**
		 * The meta object literal for the '<em><b>Required Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIONAL_ACTOR_INSTANCE__REQUIRED_SERVICES = eINSTANCE.getOptionalActorInstance_RequiredServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.InterfaceItemInstanceImpl <em>Interface Item Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.InterfaceItemInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getInterfaceItemInstance()
		 * @generated
		 */
		EClass INTERFACE_ITEM_INSTANCE = eINSTANCE.getInterfaceItemInstance();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_ITEM_INSTANCE__PROTOCOL = eINSTANCE.getInterfaceItemInstance_Protocol();

		/**
		 * The meta object literal for the '<em><b>Peers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_ITEM_INSTANCE__PEERS = eINSTANCE.getInterfaceItemInstance_Peers();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.PortInstanceImpl <em>Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.PortInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getPortInstance()
		 * @generated
		 */
		EClass PORT_INSTANCE = eINSTANCE.getPortInstance();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_INSTANCE__PORT = eINSTANCE.getPortInstance_Port();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_INSTANCE__KIND = eINSTANCE.getPortInstance_Kind();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_INSTANCE__BINDINGS = eINSTANCE.getPortInstance_Bindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.BindingInstanceImpl <em>Binding Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.BindingInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getBindingInstance()
		 * @generated
		 */
		EClass BINDING_INSTANCE = eINSTANCE.getBindingInstance();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_INSTANCE__PORTS = eINSTANCE.getBindingInstance_Ports();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_INSTANCE__BINDING = eINSTANCE.getBindingInstance_Binding();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SAPInstanceImpl <em>SAP Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.SAPInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getSAPInstance()
		 * @generated
		 */
		EClass SAP_INSTANCE = eINSTANCE.getSAPInstance();

		/**
		 * The meta object literal for the '<em><b>Sap</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAP_INSTANCE__SAP = eINSTANCE.getSAPInstance_Sap();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.SPPInstanceImpl <em>SPP Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.SPPInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getSPPInstance()
		 * @generated
		 */
		EClass SPP_INSTANCE = eINSTANCE.getSPPInstance();

		/**
		 * The meta object literal for the '<em><b>Spp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPP_INSTANCE__SPP = eINSTANCE.getSPPInstance_Spp();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPP_INSTANCE__INCOMING = eINSTANCE.getSPPInstance_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPP_INSTANCE__OUTGOING = eINSTANCE.getSPPInstance_Outgoing();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ServiceImplInstanceImpl <em>Service Impl Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ServiceImplInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getServiceImplInstance()
		 * @generated
		 */
		EClass SERVICE_IMPL_INSTANCE = eINSTANCE.getServiceImplInstance();

		/**
		 * The meta object literal for the '<em><b>Svc Impl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_IMPL_INSTANCE__SVC_IMPL = eINSTANCE.getServiceImplInstance_SvcImpl();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ConnectionInstanceImpl <em>Connection Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ConnectionInstanceImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getConnectionInstance()
		 * @generated
		 */
		EClass CONNECTION_INSTANCE = eINSTANCE.getConnectionInstance();

		/**
		 * The meta object literal for the '<em><b>From AI</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE__FROM_AI = eINSTANCE.getConnectionInstance_FromAI();

		/**
		 * The meta object literal for the '<em><b>From SPP</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE__FROM_SPP = eINSTANCE.getConnectionInstance_FromSPP();

		/**
		 * The meta object literal for the '<em><b>To SPP</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE__TO_SPP = eINSTANCE.getConnectionInstance_ToSPP();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_INSTANCE__CONNECTION = eINSTANCE.getConnectionInstance_Connection();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedActorClassImpl <em>Expanded Actor Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ExpandedActorClassImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getExpandedActorClass()
		 * @generated
		 */
		EClass EXPANDED_ACTOR_CLASS = eINSTANCE.getExpandedActorClass();

		/**
		 * The meta object literal for the '<em><b>Actor Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANDED_ACTOR_CLASS__ACTOR_CLASS = eINSTANCE.getExpandedActorClass_ActorClass();

		/**
		 * The meta object literal for the '<em><b>Graph Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANDED_ACTOR_CLASS__GRAPH_CONTAINER = eINSTANCE.getExpandedActorClass_GraphContainer();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredStructureClassImpl <em>Wired Structure Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.WiredStructureClassImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getWiredStructureClass()
		 * @generated
		 */
		EClass WIRED_STRUCTURE_CLASS = eINSTANCE.getWiredStructureClass();

		/**
		 * The meta object literal for the '<em><b>Wires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRED_STRUCTURE_CLASS__WIRES = eINSTANCE.getWiredStructureClass_Wires();

		/**
		 * The meta object literal for the '<em><b>Open Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRED_STRUCTURE_CLASS__OPEN_BINDINGS = eINSTANCE.getWiredStructureClass_OpenBindings();

		/**
		 * The meta object literal for the '<em><b>Provided Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRED_STRUCTURE_CLASS__PROVIDED_SERVICES = eINSTANCE.getWiredStructureClass_ProvidedServices();

		/**
		 * The meta object literal for the '<em><b>Required Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRED_STRUCTURE_CLASS__REQUIRED_SERVICES = eINSTANCE.getWiredStructureClass_RequiredServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OpenBindingImpl <em>Open Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.OpenBindingImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getOpenBinding()
		 * @generated
		 */
		EClass OPEN_BINDING = eINSTANCE.getOpenBinding();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_BINDING__PATH = eINSTANCE.getOpenBinding_Path();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPEN_BINDING__PORT = eINSTANCE.getOpenBinding_Port();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.OpenServiceConnectionImpl <em>Open Service Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.OpenServiceConnectionImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getOpenServiceConnection()
		 * @generated
		 */
		EClass OPEN_SERVICE_CONNECTION = eINSTANCE.getOpenServiceConnection();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_SERVICE_CONNECTION__PATH = eINSTANCE.getOpenServiceConnection_Path();

		/**
		 * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPEN_SERVICE_CONNECTION__PROTOCOL = eINSTANCE.getOpenServiceConnection_Protocol();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WireImpl <em>Wire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.WireImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getWire()
		 * @generated
		 */
		EClass WIRE = eINSTANCE.getWire();

		/**
		 * The meta object literal for the '<em><b>Data Driven</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE__DATA_DRIVEN = eINSTANCE.getWire_DataDriven();

		/**
		 * The meta object literal for the '<em><b>Path1</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE__PATH1 = eINSTANCE.getWire_Path1();

		/**
		 * The meta object literal for the '<em><b>Path2</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIRE__PATH2 = eINSTANCE.getWire_Path2();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredActorClassImpl <em>Wired Actor Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.WiredActorClassImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getWiredActorClass()
		 * @generated
		 */
		EClass WIRED_ACTOR_CLASS = eINSTANCE.getWiredActorClass();

		/**
		 * The meta object literal for the '<em><b>Actor Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRED_ACTOR_CLASS__ACTOR_CLASS = eINSTANCE.getWiredActorClass_ActorClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.impl.WiredSubSystemClassImpl <em>Wired Sub System Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.WiredSubSystemClassImpl
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getWiredSubSystemClass()
		 * @generated
		 */
		EClass WIRED_SUB_SYSTEM_CLASS = eINSTANCE.getWiredSubSystemClass();

		/**
		 * The meta object literal for the '<em><b>Sub System Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIRED_SUB_SYSTEM_CLASS__SUB_SYSTEM_CLASS = eINSTANCE.getWiredSubSystemClass_SubSystemClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.etrice.core.genmodel.etricegen.PortKind <em>Port Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.etrice.core.genmodel.etricegen.PortKind
		 * @see org.eclipse.etrice.core.genmodel.etricegen.impl.ETriceGenPackageImpl#getPortKind()
		 * @generated
		 */
		EEnum PORT_KIND = eINSTANCE.getPortKind();

	}

} //ETriceGenPackage
