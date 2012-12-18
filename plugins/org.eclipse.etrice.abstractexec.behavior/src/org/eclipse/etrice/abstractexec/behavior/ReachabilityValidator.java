
/*******************************************************************************
 * Copyright (c) 2012 Rohit Agrawal
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Rohit Agrawal (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.abstractexec.behavior;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.base.NullLogger;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.validation.IRoomValidator;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;


public class ReachabilityValidator implements IRoomValidator {

	
	@Override
	public void validate(EObject object, ValidationMessageAcceptor messageAcceptor) {

		if (!(object instanceof ActorClass))
			return;

		ActorClass ac = (ActorClass) object;

			NullDiagnostician diagnostician = new NullDiagnostician();
			GeneratorModelBuilder builder = new GeneratorModelBuilder(new NullLogger(), diagnostician);
			ExpandedActorClass xpac = builder.createExpandedActorClass(ac);
			
			if (xpac != null && !diagnostician.isFailed()) {
				ReachabilityCheck checker = new ReachabilityCheck(xpac);
				checker.computeReachability();
				TreeIterator<EObject> it = xpac.getStateMachine().eAllContents();
				while (it.hasNext()) {
					EObject item = it.next();
					if (item instanceof StateGraphItem)
					{
						
						StateGraphItem toCheck = (StateGraphItem) item;
						//System.out.println("Checked : " + toCheck.getName());
						if (!checker.isReachable(toCheck)) {
							//System.out.println("Unreachable "+ toCheck.getName());
							
							EObject orig = xpac.getOrig(toCheck);
							EObject container = orig.eContainer();
							@SuppressWarnings("unchecked")
							int idx = ((List<? extends EObject>)container.eGet(orig.eContainingFeature())).indexOf(orig);
							messageAcceptor.acceptWarning(
									"Unreachable state/point of graph",
									xpac.getOrig(toCheck).eContainer(), xpac.getOrig(toCheck).eContainingFeature(), idx,
									"UNREACHABLE", toCheck.getName());
						}
					}
				}

			}
		
	}

}
