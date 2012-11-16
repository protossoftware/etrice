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
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etmap.eTMap.ThreadMapping;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.xtext.validation.Check;


public class ETMapJavaValidator extends AbstractETMapJavaValidator {

	@Check
	public void checkSubSystemMapping(SubSystemMapping ssm) {
		HashSet<LogicalThread> mapped = new HashSet<LogicalThread>();
		for (ThreadMapping tm : ssm.getThreadMappings()) {
			mapped.add(tm.getLogicalThread());
		}
		
		StringBuilder sb = new StringBuilder();
		for (LogicalThread lt : ssm.getLogicalSubSys().getType().getThreads()) {
			if (!mapped.contains(lt))
				sb.append("unmapped logical thread '"+lt.getName()+"'\n");
		}
		if (sb.length()>0)
			error(sb.substring(0, sb.length()-2), ETMapPackage.Literals.SUB_SYSTEM_MAPPING__THREAD_MAPPINGS);
	}
}
