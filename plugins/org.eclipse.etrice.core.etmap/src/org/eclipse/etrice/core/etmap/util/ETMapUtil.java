/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etmap.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.MappingModel;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ETMapUtil {

	@SuppressWarnings("serial")
	private static class PathToPThread extends HashMap<String, PhysicalThread> {}
	@SuppressWarnings("serial")
	private static class PathToNodeRef extends HashMap<String, NodeRef> {}
	@SuppressWarnings("serial")
	private static class LThreadToPThread extends HashMap<LogicalThread, PhysicalThread> {}
	
	private static PathToPThread path2pthread = new PathToPThread();
	private static PathToNodeRef path2ndref = new PathToNodeRef();
	
	public static NodeRef getNodeRef(ActorInstance ai) {
		String path = ai.getPath();
		NodeRef nodeRef = path2ndref.get(path);
		return nodeRef;
	}
	
	public static PhysicalThread getPhysicalThread(ActorInstance ai) {
		String path = ai.getPath();
		PhysicalThread thread = path2pthread.get(path);
		return thread;
	}
	
	public static String dumpMappings() {
		StringBuilder result = new StringBuilder();
		
		ArrayList<String> keys = new ArrayList<String>(path2pthread.keySet());
		Collections.sort(keys);
		
		for (String key : keys) {
			NodeRef node = path2ndref.get(key);
			result.append("\n"+key+"\t -> "+node.getName()+":"+path2pthread.get(key).getName());
		}
		
		return result.toString();
	}
	
	public static void processModels(Root genmodel, ResourceSet rs) {
		path2pthread.clear();
		path2ndref.clear();
		
		for (Resource res : rs.getResources()) {
			if (!res.getContents().isEmpty()) {
				if (res.getContents().get(0) instanceof MappingModel) {
					processMappings(genmodel, (MappingModel) res.getContents().get(0));
				}
			}
		}
	}
	
	private static void processMappings(Root genmodel, MappingModel mdl) {
		for (Mapping mp : mdl.getMappings()) {
			for (SubSystemMapping ssmp : mp.getSubsysMappings()) {
				String path = InstanceBase.pathDelim+mp.getLogicalSys().getName()
						+InstanceBase.pathDelim+ssmp.getLogicalSubSys().getName();
				
				path2ndref.put(path, ssmp.getNode());
				
				LThreadToPThread lthread2pthread = new LThreadToPThread();
				for (ThreadMapping tmp : ssmp.getThreadMappings()) {
					lthread2pthread.put(tmp.getLogicalThread(), tmp.getPhysicalThread());
				}
				
				SubSystemClass subsys = ssmp.getLogicalSubSys().getType();
				createThreadMappings(subsys.getActorInstanceMappings(), path, lthread2pthread);
			}
		}
		addImplicitMappings(genmodel);
	}

	private static void createThreadMappings(
			EList<ActorInstanceMapping> mappings,
			String parentPath,
			LThreadToPThread lthread2pthread) {
		for (ActorInstanceMapping aim : mappings) {
			String path = parentPath+getPath(aim.getPath());
			path2pthread.put(path, lthread2pthread.get(aim.getThread()));
			
			// recursion
			createThreadMappings(aim.getActorInstanceMappings(), path, lthread2pthread);
		}
	}
	
	private static void addImplicitMappings(Root genmodel) {
		for (SystemInstance si : genmodel.getSystemInstances()) {
			for (SubSystemInstance ssi : si.getInstances()) {
				NodeRef node = path2ndref.get(ssi.getPath());
				if (node!=null) {
					PhysicalThread dflt = getDefaultThread(node);
					addImplicitMappings(ssi, dflt, node);
				}
			}
		}
	}

	private static void addImplicitMappings(StructureInstance si, PhysicalThread dflt, NodeRef node) {
		for (ActorInstance ai : si.getInstances()) {
			String path = ai.getPath();
			path2ndref.put(path, node);
			PhysicalThread thread = path2pthread.get(path);
			if (thread==null) {
				thread = dflt;
				path2pthread.put(path, dflt);
			}
			
			// recursion
			addImplicitMappings(ai, thread, node);
		}
	}
	
	private static PhysicalThread getDefaultThread(NodeRef node) {
		for (PhysicalThread thread : node.getType().getThreads()) {
			if (thread.isDefault())
				return thread;
		}
		return null;
	}
	
	private static String getPath(RefPath path) {
		StringBuilder result = new StringBuilder();
		
		for (String ref : path.getRefs()) {
			result.append(InstanceBase.pathDelim+ref);
		}
		
		return result.toString();
	}
}
