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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.MappingModel;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.RefSegment;
import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ETMapUtil {

	public static class MappedThread {
		private PhysicalThread thread = null;
		private boolean implicit = false;
		private boolean asParent = false;
		
		public MappedThread(PhysicalThread thread) {
			this(thread, false, false);
		}
		
		public MappedThread(PhysicalThread thread, boolean implicit, boolean asParent) {
			super();
			this.thread = thread;
			this.implicit = implicit;
			this.asParent = asParent;
		}

		public PhysicalThread getThread() {
			return thread;
		}

		public boolean isImplicit() {
			return implicit;
		}

		public boolean isAsParent() {
			return asParent;
		}
	}
	
	@SuppressWarnings("serial")
	private static class PathToPThread extends HashMap<String, MappedThread> {}
	
	@SuppressWarnings("serial")
	private static class PathToNodeRef extends HashMap<String, NodeRef> {}
	
	@SuppressWarnings("serial")
	private static class LThreadToPThread extends HashMap<LogicalThread, PhysicalThread> {}
	
	@SuppressWarnings("serial")
	private static class NodeRefToSubSysInstances extends HashMap<NodeRef, List<String>> {
		void put(NodeRef nr, String path) {
			List<String> list = get(nr);
			if (list==null) {
				list = new ArrayList<String>();
				put(nr, list);
			}
			list.add(path);
		}
	}
	
	private static PathToPThread path2pthread = new PathToPThread();
	private static PathToNodeRef path2ndref = new PathToNodeRef();
	private static NodeRefToSubSysInstances ndref2ssipaths = new NodeRefToSubSysInstances();
	private static HashSet<NodeRef> noderefs = new HashSet<NodeRef>();
	
	public static Collection<NodeRef> getNodeRefs() {
		return noderefs;
	}
	
	public static List<String> getSubSystemInstancePaths(NodeRef nr) {
		return ndref2ssipaths.get(nr);
	}
	
	public static NodeRef getNodeRef(AbstractInstance si) {
		String path = si.getPath();
		NodeRef nodeRef = path2ndref.get(path);
		return nodeRef;
	}
	
	public static MappedThread getMappedThread(AbstractInstance ai) {
		String path = ai.getPath();
		MappedThread thread = path2pthread.get(path);
		return thread;
	}
	
	public static String dumpMappings() {
		StringBuilder result = new StringBuilder();
		
		ArrayList<String> keys = new ArrayList<String>(path2pthread.keySet());
		Collections.sort(keys);
		
		for (String key : keys) {
			NodeRef node = path2ndref.get(key);
			MappedThread thread = path2pthread.get(key);
			result.append("\n"+key+"\t -> "+node.getName()+":"+thread.getThread().getName());
			if (thread.isImplicit())
				result.append(" (implicit)");
		}
		
		return result.toString();
	}
	
	public static void processModels(Root genmodel, ResourceSet rs, IDiagnostician diagnostician) {
		path2pthread.clear();
		path2ndref.clear();
		ndref2ssipaths.clear();
		noderefs.clear();
		
		for (Resource res : rs.getResources()) {
			if (!res.getContents().isEmpty()) {
				if (res.getContents().get(0) instanceof MappingModel) {
					processMappings(genmodel, (MappingModel) res.getContents().get(0));
				}
			}
		}
		
		for (Entry<String, MappedThread> p2t : path2pthread.entrySet()) {
			String path = p2t.getKey();
			StructureInstance si = genmodel.getInstance(path);
			if (si instanceof ActorInstance) {
				PhysicalThread thread = p2t.getValue().getThread();
				switch (((ActorInstance) si).getActorClass().getCommType()) {
				case EVENT_DRIVEN:
					if (thread.getExecmode()==ExecMode.POLLED) {
						error(diagnostician, path, "event driven", thread, "polled thread");
					}
					break;
				case DATA_DRIVEN:
					if (thread.getExecmode()==ExecMode.BLOCKED) {
						error(diagnostician, path, "data driven", thread, "blocked thread");
					}
					break;
				case ASYNCHRONOUS:
					if (thread.getExecmode()==ExecMode.BLOCKED) {
						error(diagnostician, path, "asynchronous", thread, "blocked thread");
					}
					else if (thread.getExecmode()==ExecMode.POLLED) {
						error(diagnostician, path, "asynchronous", thread, "polled thread");
					}
					break;
				case SYNCHRONOUS:
					// not implemented yet
					break;
				}
			}
		}
	}

	/**
	 * @param diagnostician
	 * @param inst
	 * @param inst_comm_type
	 * @param thread
	 * @param thread_comm_type
	 */
	private static void error(IDiagnostician diagnostician, String inst, String inst_comm_type, PhysicalThread thread, String thread_comm_type) {
		NodeRef nr = path2ndref.get(inst);
		diagnostician.error(inst_comm_type+" actor instance '"+inst+"' mapped to "
				+thread_comm_type+" '"+thread.getName()+"' of node '"+nr.getName()+"'", null, null);
	}
	
	private static void processMappings(Root genmodel, MappingModel mdl) {
		for (Mapping mp : mdl.getMappings()) {
			for (SubSystemMapping ssmp : mp.getSubsysMappings()) {
				String path = InstanceBase.pathDelim+mp.getLogicalSys().getName()
						+InstanceBase.pathDelim+ssmp.getLogicalSubSys().getName();
				
				path2ndref.put(path, ssmp.getNode());
				ndref2ssipaths.put(ssmp.getNode(), path);
				noderefs.add(ssmp.getNode());
				
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
			path2pthread.put(path, new MappedThread(lthread2pthread.get(aim.getThread())));
			
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
		for (AbstractInstance ai : si.getInstances()) {
			String path = ai.getPath();
			path2ndref.put(path, node);
			MappedThread thread = path2pthread.get(path);
			if (thread==null) {
				thread = new MappedThread(dflt, true, true);
				path2pthread.put(path, thread);
			}
			else if (thread.getThread()==dflt) {
				thread.asParent = true;
			}
			
			// recursion
			if (ai instanceof StructureInstance) {
				addImplicitMappings((StructureInstance) ai, thread.getThread(), node);
			}
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
		
		for (RefSegment ref : path.getRefs()) {
			result.append(InstanceBase.pathDelim+ref.toString());
		}
		
		return result.toString();
	}
	
}
