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

package org.eclipse.etrice.core.etmap.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping;
import org.eclipse.etrice.core.etmap.eTMap.RefPath;
import org.eclipse.etrice.core.etmap.ui.contentassist.AbstractETMapProposalProvider;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.ui.contentassist.ImportModelAssist;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class ETMapProposalProvider extends AbstractETMapProposalProvider {

	@Override
	public void completeImport_ImportURI(EObject model, Assignment assignment,
			final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		ImportModelAssist.addPaths(this, context, acceptor, ".room");
		ImportModelAssist.addPaths(this, context, acceptor, ".etphys");
	}

	@Override
	public void completeActorInstanceMapping_Path(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeActorInstanceMapping_Path(model, assignment, context, acceptor);

		List<ActorRef> instances = collectInstances(((ActorInstanceMapping) model));
		for (ActorRef instance : instances)
			acceptor.accept(createCompletionProposal(instance.getName(), context));
	}

	@Override
	public void completeRefPath_Refs(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completeRefPath_Refs(model, assignment, context, acceptor);

		if (model instanceof ActorInstanceMapping) {
			completeActorInstanceMapping_Path(model, assignment, context, acceptor);
			return;
		}

		RefPath path = ((RefPath) model);
		if (path.eContainer() instanceof ActorInstanceMapping) {
			List<ActorRef> instances = collectInstances((ActorInstanceMapping) path.eContainer());
			for (ActorRef instance : instances)
				acceptor.accept(createCompletionProposal(instance.getName(),
						context));
		}
	}

	private List<ActorRef> collectInstances(ActorInstanceMapping aim) {
		List<ActorRef> refs = new ArrayList<ActorRef>();

		ActorContainerClass root = ETMapUtil.getParentContainer(aim);
		if (root != null) {
			RefPath path = aim.getPath();
			if (path != null && !path.getRefs().isEmpty())
				root = ETMapUtil.getActorContainerClass(aim);
			if (root != null) {
				for (ActorContainerRef ref : RoomHelpers.getRefs(root, true)) {
					if (ref instanceof ActorRef) {
						ActorRef aRef = (ActorRef) ref;
						if (aRef.getSize() == 1)
							refs.add((ActorRef) ref);
					}
				}
			}
		}

		return refs;
	}

}
