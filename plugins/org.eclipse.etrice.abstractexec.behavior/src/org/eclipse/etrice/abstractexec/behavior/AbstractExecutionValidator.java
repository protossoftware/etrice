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

package org.eclipse.etrice.abstractexec.behavior;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.base.NullLogger;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.validation.IRoomValidator;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author rentzhnr
 *
 */
public class AbstractExecutionValidator implements IRoomValidator {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.validation.IRoomValidator#validate(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.validation.ValidationMessageAcceptor)
	 */
	@Override
	public void validate(EObject object, ValidationMessageAcceptor messageAcceptor) {

		if (!(object instanceof ActorClass))
			return;

		ActorClass ac = (ActorClass) object;

		boolean allProtocolsWithSemantics = true;
		List<InterfaceItem> ifItems = RoomHelpers.getAllInterfaceItems(ac);
		for (InterfaceItem item : ifItems) {
			GeneralProtocolClass pc = item.getGeneralProtocol();
			if (!(pc instanceof ProtocolClass))
				continue;

			if (((ProtocolClass) pc).getSemantics() == null) {
				allProtocolsWithSemantics = false;
				break;
			}
		}

		if (allProtocolsWithSemantics) {
			// begin abstract execution on state machine of expanded actor class

			NullDiagnostician diagnostician = new NullDiagnostician();
			GeneratorModelBuilder builder = new GeneratorModelBuilder(new NullLogger(), diagnostician);
			ExpandedActorClass xpac = builder.createExpandedActorClass(ac);
			
			if (xpac != null && !diagnostician.isFailed()) {
				// ActionCodeAnalyzer analyzer = new ActionCodeAnalyzer(ac);
//				ReachabilityCheck checker = new ReachabilityCheck(xpac);
//				checker.computeReachability();

				TreeIterator<EObject> it = xpac.getStateMachine().eAllContents();
				while (it.hasNext()) {
					EObject item = it.next();
					if (item instanceof StateGraphItem)
					{
//						StateGraphItem toCheck = (StateGraphItem) item;
//						if (false/*!checker.isReachable(toCheck)*/) {
//							System.out.println("Unreachable "+ toCheck.getName());
//							
//							EObject orig = xpac.getOrig(toCheck);
//							EObject container = orig.eContainer();
//							@SuppressWarnings("unchecked")
//							int idx = ((List<? extends EObject>)container.eGet(orig.eContainingFeature())).indexOf(orig);
//							
//							messageAcceptor.acceptWarning(
//									"Unreachable state/point of graph",
//									container, toCheck.eContainingFeature(), idx,
//									"UNREACHABLE", toCheck.getName());
//						}
					}
				}
			}
		}
	}

	@Override
	public String getName() {
		return "Abstract FSM Execution Validator";
	}

	@Override
	public String getDescription() {
		return "This validator checks the state machine against the protocol semantics of its ports.";
	}

}
