/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etmap.validation;

import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.etmap.eTMap.ETMapPackage;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;


public class ETMapValidator extends AbstractETMapValidator {

	public static final String DUPLICATE_SUBSYS_MAPPING = "ETMapJavaValidator.DulicateSubSysMapping";
	public static final String UNMAPPED_SUBSYS_REFS = "ETMapJavaValidator.UnmappedSubSysRefs";
	public static final String DUPLICATE_THREAD_MAPPING = "ETMapJavaValidator.DulicateThreadMapping";
	public static final String UNMAPPED_THREAD_REFS = "ETMapJavaValidator.UnmappedThreadRefs";
	public static final String WRONG_NAMESPACE = "ETMapJavaValidator.WrongNamespace";
	public static final String NOT_EMPTY = "empty";
	public static final String EMPTY = "not-empty";
	
	@Inject ImportUriResolver importUriResolver;
	
	@Check
	public void checkMapping(Mapping mp) {
		HashSet<SubSystemRef> mapped = new HashSet<SubSystemRef>();
		for (SubSystemMapping ssm : mp.getSubsysMappings()) {
			if (!mapped.add(ssm.getLogicalSubSys())) {
				int idx = mp.getSubsysMappings().indexOf(ssm);
				error("duplicate mapping", ETMapPackage.Literals.MAPPING__SUBSYS_MAPPINGS, idx, DUPLICATE_SUBSYS_MAPPING);
			}
		}

		StringBuilder msg = new StringBuilder();
		StringBuilder fix = new StringBuilder();
		for (SubSystemRef ssr : mp.getLogicalSys().getSubSystems()) {
			if (!mapped.contains(ssr)) {
				msg.append("unmapped sub system reference '"+ssr.getName()+"'\n");
				String nodeRef = mp.getPhysicalSys().getNodeRefs().isEmpty()?
						"no_node_ref_defined" : mp.getPhysicalSys().getNodeRefs().get(0).getName();
				fix.append("\t\tSubSystemMapping "+ssr.getName()+" -> "+nodeRef+" {}\n");
			}
		}
		if (msg.length()>0)
			error(
					msg.substring(0, msg.length()-2),
					ETMapPackage.Literals.MAPPING__SUBSYS_MAPPINGS,
					UNMAPPED_SUBSYS_REFS,
					fix.toString(),
					mapped.isEmpty()? EMPTY:NOT_EMPTY);
	}
	
	@Check
	public void checkSubSystemMapping(SubSystemMapping ssm) {
		HashSet<LogicalThread> mapped = new HashSet<LogicalThread>();
		for (ThreadMapping tm : ssm.getThreadMappings()) {
			if (!mapped.add(tm.getLogicalThread())) {
				int idx = ssm.getThreadMappings().indexOf(tm);
				error("duplicate mapping", ETMapPackage.Literals.SUB_SYSTEM_MAPPING__THREAD_MAPPINGS, idx, DUPLICATE_THREAD_MAPPING);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		StringBuilder fix = new StringBuilder();
		for (LogicalThread lt : ssm.getLogicalSubSys().getType().getThreads()) {
			if (!mapped.contains(lt)) {
				sb.append("unmapped logical thread '"+lt.getName()+"'\n");
				String pthread = ssm.getNode().getType().getThreads().isEmpty()?
						"no_physical_thread_defined" : ssm.getNode().getType().getThreads().get(0).getName();
				fix.append("\t\t\tThreadMapping "+lt.getName()+" -> "+pthread+"\n");
			}
		}
		if (sb.length()>0)
			error(
					sb.substring(0, sb.length()-2),
					ETMapPackage.Literals.SUB_SYSTEM_MAPPING__THREAD_MAPPINGS,
					UNMAPPED_THREAD_REFS,
					fix.toString(),
					mapped.isEmpty()? EMPTY:NOT_EMPTY);
	}
	
	@Check
	public void checkImportedNamespace(Import imp) {
		if (imp.getImportedNamespace()==null)
			return;
		
		if (imp.getImportURI()==null)
			return;
		
		String uriString = importUriResolver.resolve(imp);
		
		URI uri = URI.createURI(uriString);
		ResourceSet rs = new ResourceSetImpl();

		try {
			Resource res = rs.getResource(uri, true);
			if (res==null)
				return;
			
			if (res.getContents().isEmpty()) {
				error("referenced model is empty", BasePackage.Literals.IMPORT__IMPORT_URI);
				return;
			}
			
			if (uri.lastSegment().endsWith(".room")) {
				if (!(res.getContents().get(0) instanceof RoomModel)) {
					error("referenced model is no ROOM model (but has .room extension)", BasePackage.Literals.IMPORT__IMPORT_URI);
					return;
				}
				
				RoomModel model = (RoomModel) res.getContents().get(0);
				if (!imp.getImportedNamespace().equals(model.getName()+".*")) {
					error("the imported namespace should be '"+model.getName()+".*'", BasePackage.Literals.IMPORT__IMPORTED_NAMESPACE, WRONG_NAMESPACE, model.getName()+".*");
				}
			}
			else if (uri.lastSegment().endsWith(".etphys")) {
				if (!(res.getContents().get(0) instanceof PhysicalModel)) {
					error("referenced model is no eTrice physical model (but has .etphys extension)", BasePackage.Literals.IMPORT__IMPORT_URI);
					return;
				}
				
				PhysicalModel model = (PhysicalModel) res.getContents().get(0);
				if (!imp.getImportedNamespace().equals(model.getName()+".*")) {
					error("the imported namespace should be '"+model.getName()+".*'", BasePackage.Literals.IMPORT__IMPORTED_NAMESPACE, WRONG_NAMESPACE, model.getName()+".*");
				}
			}
			else {
				error("referenced model has unexpected file extension", BasePackage.Literals.IMPORT__IMPORT_URI);
			}
		}
		catch (RuntimeException re) {
			warning("could not load referenced model", BasePackage.Literals.IMPORT__IMPORT_URI);
			return;
		}
	}
}
