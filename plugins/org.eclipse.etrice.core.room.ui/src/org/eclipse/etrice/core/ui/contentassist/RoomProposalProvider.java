/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.RoomAnnotationTargetEnum;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.validation.ValidationUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class RoomProposalProvider extends AbstractRoomProposalProvider {
	
	protected class FilteredProposalCreator implements Function<IEObjectDescription, ICompletionProposal> {
		private IProposalFilter filter;
		private final ContentAssistContext contentAssistContext;
		private final String ruleName;

		protected FilteredProposalCreator(IProposalFilter filter, ContentAssistContext contentAssistContext, String ruleName) {
			this.filter = filter;
			this.contentAssistContext = contentAssistContext;
			this.ruleName = ruleName;
		}

		public ICompletionProposal apply(IEObjectDescription candidate) {
			if (candidate == null)
				return null;
			ICompletionProposal result = null;
			String proposal = candidate.getName().toString();
			if (ruleName != null)
				proposal = getValueConverter().toString(proposal, ruleName);
			EObject objectOrProxy = candidate.getEObjectOrProxy();
			
			// three new lines in code taken from org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider.DefaultProposalCreator
			if (!objectOrProxy.eIsProxy() && filter!=null)
				if (!filter.accept(contentAssistContext, candidate))
					return null;
			
			StyledString displayString = getStyledDisplayString(objectOrProxy, candidate.getQualifiedName().toString(), candidate.getName().toString());
			Image image = getImage(objectOrProxy);
			result = createCompletionProposal(proposal, displayString, image, contentAssistContext);
			getPriorityHelper().adjustCrossReferencePriority(result, contentAssistContext.getPrefix());			
			return result;
		}

	}
	
	protected class ActorRefFilter implements IProposalFilter {

		@Override
		public boolean accept(ContentAssistContext context, IEObjectDescription candidate) {
			if (!(context.getCurrentModel() instanceof ActorRef))
				// unexpected call??
				return false;
			
			ActorRef ar = (ActorRef) context.getCurrentModel();
			if (!(ar.eContainer() instanceof ActorClass))
				// can not filter due to lack of information
				return true;
			
			ActorClass ac = (ActorClass) ar.eContainer();
			
			EObject objectOrProxy = candidate.getEObjectOrProxy();
			
			if (objectOrProxy instanceof ActorClass) {
				ActorClass referenced = (ActorClass) objectOrProxy;
				return !roomHelpers.isReferencing(referenced, ac);
			}
			
			return false;
		}
		
	}

	@Inject
	private RoomHelpers roomHelpers;
	
	protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(String ruleName, ContentAssistContext contentAssistContext) {
		if (contentAssistContext!=null && contentAssistContext.getCurrentModel().eClass()==RoomPackage.eINSTANCE.getActorRef())
			return new FilteredProposalCreator(new ActorRefFilter(), contentAssistContext, ruleName);
		
		// delegate to default
		return super.getProposalFactory(ruleName, contentAssistContext);
	}
	
	@Override
	public void completeImport_ImportURI(EObject model, Assignment assignment,
			final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		ImportModelAssist.addPaths(this, context, acceptor, ".room");
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
	
	@Override
	public void complete_AnnotationTargetType(EObject model, org.eclipse.xtext.RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		EList<String> existingTargets = new BasicEList<String>();
		if(model instanceof AnnotationType) {
			existingTargets.addAll(((AnnotationType)model).getTargets());
		}
		for(RoomAnnotationTargetEnum t : RoomAnnotationTargetEnum.values()) {
			String targetName = t.getLiteral();
			if(!existingTargets.isEmpty() && !existingTargets.contains(targetName)) {
				acceptor.accept(createCompletionProposal(targetName, context));
			}
		}
	}

	private List<ActorRef> collectInstances(ActorInstanceMapping aim) {
		List<ActorRef> refs = new ArrayList<ActorRef>();

		ActorContainerClass root = roomHelpers.getParentContainer(aim);
		if (root != null) {
			RefPath path = aim.getPath();
			if (path != null && !path.getRefs().isEmpty())
				root = roomHelpers.getActorContainerClass(aim);
			if (root != null) {
				for (ActorContainerRef ref : roomHelpers.getRefs(root, true)) {
					if (ref instanceof ActorRef) {
						ActorRef aRef = (ActorRef) ref;
						if (aRef.getMultiplicity() == 1)
							refs.add((ActorRef) ref);
					}
				}
			}
		}

		return refs;
	}

//	public void completeActorRef_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		super.completeActorRef_Type(
//			    model, 
//			    assignment, 
//			    context, 
//			    acceptor);
//	}
}
