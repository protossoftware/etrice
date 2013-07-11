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

package org.eclipse.etrice.core.etphys.validation;

import org.eclipse.etrice.core.etphys.eTPhys.ETPhysPackage;
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode;
import org.eclipse.etrice.core.etphys.eTPhys.NodeClass;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.etphys.eTPhys.ThreadModel;
import org.eclipse.xtext.validation.Check;
 

public class ETPhysJavaValidator extends AbstractETPhysJavaValidator {

	public static final String ADD_TIME_INTERVAL = "ETPhysJavaValidator.addTimeInterval";
	public static final String REMOVE_TIME_INTERVAL = "ETPhysJavaValidator.removeTimeInterval";
	
	@Check
	public void checkThread(PhysicalThread thread) {
		NodeClass nc = (NodeClass) thread.eContainer();
		
		if (thread.getPrio()<nc.getPriomin())
			error("prio less than minimum", ETPhysPackage.Literals.PHYSICAL_THREAD__PRIO);
		
		if (thread.getPrio()>nc.getPriomax())
			error("prio greater than maximum", ETPhysPackage.Literals.PHYSICAL_THREAD__PRIO);
		
		if (thread.getExecmode()==ExecMode.BLOCKED) {
			if (thread.getTime()!=0)
				error("no time interval must be specified with blocked execution mode",
						ETPhysPackage.Literals.PHYSICAL_THREAD__TIME,
						REMOVE_TIME_INTERVAL);
		}
		else if (thread.getExecmode()==ExecMode.POLLED){
			if (thread.getTime()==0)
				error("a time interval must be specified with polled execution mode",
						ETPhysPackage.Literals.PHYSICAL_THREAD__TIME,
						ADD_TIME_INTERVAL);
		}
		else if (thread.getExecmode()==ExecMode.MIXED){
			if (thread.getTime()==0)
				error("a time interval must be specified with mixed execution mode",
						ETPhysPackage.Literals.PHYSICAL_THREAD__TIME,
						ADD_TIME_INTERVAL);
		}
	}
	
	@Check
	public void checkNodeClass(NodeClass nc) {
		{
			// make sure there is one and only one DefaultThread
			boolean hasDefault = false;
			for (PhysicalThread thread : nc.getThreads()) {
				if (thread.isDefault())
					if (hasDefault) {
						int idx = nc.getThreads().indexOf(thread);
						error("only one DefaultThread allowed", ETPhysPackage.Literals.NODE_CLASS__THREADS, idx);
					}
					else
						hasDefault = true;
			}
			
			if (!hasDefault)
				error("there must be one DefaultThread", ETPhysPackage.Literals.NODE_CLASS__THREADS);
		}
		
		// single threaded mode has to have one thread
		if (nc.getRuntime()!=null) {
			if (nc.getRuntime().getThreadModel()==ThreadModel.SINGLE_THREADED && nc.getThreads().size()>1)
				error("runtime is single threaded but more than one thread defined", ETPhysPackage.Literals.NODE_CLASS__THREADS);
		}
	}
}
