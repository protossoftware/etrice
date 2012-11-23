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

package org.eclipse.etrice.core.etmap.validation;

import java.util.HashSet;

import org.eclipse.etrice.core.etmap.eTMap.ETMapPackage;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.xtext.validation.Check;


public class ETMapJavaValidator extends AbstractETMapJavaValidator {

	public static final String DUPLICATE_SUBSYS_MAPPING = "ETMapJavaValidator.DulicateSubSysMapping";
	public static final String UNMAPPED_SUBSYS_REFS = "ETMapJavaValidator.UnmappedSubSysRefs";
	public static final String DUPLICATE_THREAD_MAPPING = "ETMapJavaValidator.DulicateThreadMapping";
	public static final String UNMAPPED_THREAD_REFS = "ETMapJavaValidator.UnmappedThreadRefs";
	public static final String NOT_EMPTY = "empty";
	public static final String EMPTY = "not-empty";
	
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
}
