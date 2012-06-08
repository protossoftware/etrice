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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.base.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.base.NullLogger;
import org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
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
		
		NullDiagnostician diagnostician = new NullDiagnostician();
		GeneratorModelBuilder builder = new GeneratorModelBuilder(new NullLogger(), diagnostician);
		ExpandedActorClass xpac = builder.createExpandedActorClass(ac);
		if (xpac!=null && !diagnostician.isFailed()) {
			boolean allProtocolsWithSemantics = true;
			List<InterfaceItem> ifItems = RoomHelpers.getAllInterfaceItems(ac);
			for (InterfaceItem item : ifItems) {
				if (item.getProtocol().getSemantics()==null) {
					allProtocolsWithSemantics = false;
					break;
				}
			}
			
			if (allProtocolsWithSemantics) {
				// begin abstract execution on state machine of expanded actor class
				
				ActionCodeAnalyzer analyzer = new ActionCodeAnalyzer(ac);
			}
		}
	}

}
