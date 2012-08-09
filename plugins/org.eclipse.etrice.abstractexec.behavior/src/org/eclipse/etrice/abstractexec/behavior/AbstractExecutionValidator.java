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
import org.eclipse.etrice.core.room.State;
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
		System.out.println("Checking class " + ac.getName());
		boolean allProtocolsWithSemantics = true;
		List<InterfaceItem> ifItems = RoomHelpers.getAllInterfaceItems(ac);
		for (InterfaceItem item : ifItems) {
			GeneralProtocolClass pc = item.getGeneralProtocol();
			if (!(pc instanceof ProtocolClass))
				continue;
			System.out.println("Checking protocolClass " + pc.getName() + " for semantics");
			if (((ProtocolClass) pc).getSemantics() == null) {
				allProtocolsWithSemantics = false;
				System.out.println("Wont execute coz semantics missing for "+ pc.getName());
				break;
			}
		}

		if (allProtocolsWithSemantics) {
			// begin abstract execution on state machine of expanded actor class
			System.out.println("Reached where all ports have protocols");
			NullDiagnostician diagnostician = new NullDiagnostician();
			GeneratorModelBuilder builder = new GeneratorModelBuilder(new NullLogger(), diagnostician);
			ExpandedActorClass xpac = builder.createExpandedActorClass(ac);
			
			if (xpac != null && !diagnostician.isFailed() ) {
				SemanticsCheck checker  = new SemanticsCheck(xpac);
				checker.checkSemantics();
				System.out.println("Final printing of rules : ");
				checker.printRules();
				System.out.println("Rule checking for " + xpac.getActorClass().getName() + " is over");
				
				TreeIterator<EObject> it = xpac.getStateMachine().eAllContents();
				while(it.hasNext())
				{
					EObject obj = it.next();
					if(obj instanceof State)
					{
						ProposalGenerator propGen = new ProposalGenerator(xpac,checker);
						State st = (State) obj;
						boolean issueWarning = propGen.getProposals(st);
						if(issueWarning)
						{
							//handle the cases accordingly by retrieving the
							//warning list once clear what exactly is to be included in warnings
						}
						else
						{
							//if there are no warnings, then proposals should be generated
						}
					}
				}
				
			}
		}
	}

}
