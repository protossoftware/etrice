/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.generator.ui.wizard;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.core.common.base.BaseFactory;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.etmap.eTMap.ETMapFactory;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.MappingModel;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;
import org.eclipse.etrice.core.etphys.eTPhys.ETPhysFactory;
import org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.etphys.eTPhys.RuntimeClass;
import org.eclipse.etrice.core.etphys.util.ETPhysUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.collect.Maps;
import com.google.inject.Injector;

public class MappingBuilder {

	private ETMapFactory mapFactory = ETMapFactory.eINSTANCE;
	private ETPhysFactory physFactory = ETPhysFactory.eINSTANCE;
	private BaseFactory baseFactory = BaseFactory.eINSTANCE;
	private Map<SubSystemClass, NodeClass> nodeMap = Maps.newHashMap();
	private RoomHelpers roomHelpers = new RoomHelpers();
	
	XtextResourceSet resourceSet = null;
	XtextResource etPhysRes = null;
	XtextResource etMapRes = null;
	PhysicalModel physicalModel = null;
	MappingModel mappingModel = null;
	Import physModelImport = null;

	public MappingBuilder(RoomModel roomModel, Injector injector) {
		MappingModel mapModel = mapFactory.createMappingModel();
		mapModel.setName(roomModel.getName() + "_Mapping_Model");
		PhysicalModel physModel = physFactory.createPhysicalModel();
		physModel.setName(roomModel.getName() + "_Physical_Model");
		RuntimeClass runtimeClass = ETPhysUtil.createDefaultRuntimeClass();
		runtimeClass.setName("PS_RuntimeClass");
		physModel.getRuntimeClasses().add(runtimeClass);

		Import roomModelImport = baseFactory.createImport();
		roomModelImport.setImportURI(roomModel.eResource().getURI().toString());
		roomModelImport.setImportedNamespace(roomModel.getName() + ".*");
		mapModel.getImports().add(roomModelImport);

		physModelImport = baseFactory.createImport();
		physModelImport.setImportURI("dummy:/temp.etphys");
		physModelImport.setImportedNamespace(physModel.getName() + ".*");
		mapModel.getImports().add(physModelImport);

		for (LogicalSystem system : roomModel.getSystems()) {
			Mapping mapping = mapFactory.createMapping();
			mapModel.getMappings().add(mapping);
			mapping.setLogicalSys(system);

			PhysicalSystem physSystem = physFactory.createPhysicalSystem();
			physModel.getSystems().add(physSystem);
			mapping.setPhysicalSys(physSystem);
			physSystem.setName("PS_" + system.getName());

			for (SubSystemRef ref : system.getSubSystems()) {
				SubSystemClass subSystem = (SubSystemClass) ref.getStructureClass();

				SubSystemMapping subMapping = mapFactory.createSubSystemMapping();
				mapping.getSubsysMappings().add(subMapping);
				subMapping.setLogicalSubSys(ref);

				NodeRef nodeRef = physFactory.createNodeRef();
				physSystem.getNodeRefs().add(nodeRef);
				nodeRef.setType(getNodeClass(subSystem, runtimeClass));
				nodeRef.setName(ref.getName() + "_Node");
				subMapping.setNode(nodeRef);

				int counter = 1; // skip default thread
				for (LogicalThread logThread : subSystem.getThreads()) {
					ThreadMapping threadMapping = mapFactory.createThreadMapping();
					subMapping.getThreadMappings().add(threadMapping);
					threadMapping.setLogicalThread(logThread);
					threadMapping.setPhysicalThread(nodeRef.getType().getThreads().get(counter++));
				}
			}
		}

		resourceSet = injector.getInstance(XtextResourceSet.class);
		etPhysRes = (XtextResource) resourceSet.createResource(URI.createURI("dummy:/temp.etphys"));
		etMapRes = (XtextResource) resourceSet.createResource(URI.createURI("dummy:/temp.etmap"));

		physicalModel = physModel;
		etPhysRes.getContents().add(physicalModel);
		mappingModel = mapModel;
		etMapRes.getContents().add(mappingModel);
	}

	public void setPhysImport(String uri) {
		physModelImport.setImportURI(uri);
	}

	private NodeClass getNodeClass(SubSystemClass subSystem, RuntimeClass runtimeClass) {
		if (!nodeMap.containsKey(subSystem)) {
			NodeClass node = ETPhysUtil.createDefaultNodeClass();
			node.setName("Node_" + subSystem.getName());
			node.setRuntime(runtimeClass);
			((PhysicalModel) runtimeClass.eContainer()).getNodeClasses().add(node);

			// default thread is "PhysicalThread1" and mixed
			int counter = 2;
			for (LogicalThread logThread : subSystem.getThreads()) {
				PhysicalThread physThread = ETPhysUtil.createDefaultPhysicalThread();
				physThread.eUnset(ETPhysPackage.eINSTANCE.getPhysicalThread_Default());
				physThread.setName("PhysicalThread" + counter++);
				node.getThreads().add(physThread);

				physThread.setExecmode(determineExecMode(subSystem, logThread));
				if (physThread.getExecmode() == ExecMode.BLOCKED)
					physThread.eUnset(ETPhysPackage.eINSTANCE.getPhysicalThread_Time());
			}

			nodeMap.put(subSystem, node);
		}

		return nodeMap.get(subSystem);
	}

	private ExecMode determineExecMode(SubSystemClass subSystem, LogicalThread logThread) {
		boolean eventOnly = true;
		boolean dataOnly = true;

		for (ActorInstanceMapping aim : subSystem.getActorInstanceMappings()) {
			if (!aim.getThread().equals(logThread))
				continue;

			ActorContainerClass ac = roomHelpers.getActorContainerClass(aim);
			if (ac instanceof ActorClass) {
				eventOnly &= ((ActorClass) ac).getCommType() == ComponentCommunicationType.EVENT_DRIVEN;
				dataOnly &= ((ActorClass) ac).getCommType() == ComponentCommunicationType.DATA_DRIVEN;
			} // else ??
		}

		if (eventOnly && !dataOnly)
			return ExecMode.BLOCKED;
		if (dataOnly && !eventOnly)
			return ExecMode.POLLED;

		return ExecMode.MIXED;
	}
}