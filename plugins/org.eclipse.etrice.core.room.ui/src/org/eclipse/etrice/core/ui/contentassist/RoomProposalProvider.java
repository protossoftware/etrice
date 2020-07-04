/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.contentassist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.ui.contentassist.ImportModelAssist;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.RoomAnnotationTargetEnum;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.services.RoomGrammarAccess;
import org.eclipse.etrice.core.ui.util.UIExpressionUtil;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.expressions.ui.contentassist.RoomExpressionProposalProvider;
import org.eclipse.etrice.generator.base.io.IModelPath;
import org.eclipse.etrice.generator.base.io.IModelPathProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class RoomProposalProvider extends AbstractRoomProposalProvider {

	@Inject protected RoomHelpers roomHelpers;	
	@Inject protected RoomNameProvider roomNameProvider;
	@Inject protected RoomGrammarAccess grammar;
	@Inject protected IModelPathProvider modelPathProvider;
	@Inject protected IWhitespaceInformationProvider whiteSpaceInfo;
	
	@Override
	public void complete_RoomModel(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Resource resource = context.getResource();
		if(model == null || model.eContents().isEmpty()) {
			IModelPath modelPath = modelPathProvider.get(resource);
			Optional<QualifiedName> modelPathFQN = modelPath.getQualifiedName(resource.getURI());
			String modelName = modelPathFQN.map(fqn -> fqn.toString()).orElse(resource.getURI().trimFileExtension().lastSegment());
			
			String lineSep = whiteSpaceInfo.getLineSeparatorInformation(resource.getURI()).getLineSeparator();
			String indent = whiteSpaceInfo.getIndentationInformation(resource.getURI()).getIndentString();
			
			String proposalStr = "RoomModel " + modelName + " {" + lineSep + lineSep + indent + "import etrice.api.types.*" + lineSep + lineSep + indent + lineSep + "}";
			ICompletionProposal proposal = createCompletionProposal(proposalStr, "RoomModel - empty template", null, context);	
			if(proposal instanceof ConfigurableCompletionProposal) {
				ConfigurableCompletionProposal configProposal = (ConfigurableCompletionProposal) proposal;
				configProposal.setSelectionStart(proposalStr.length() - (lineSep + "}").length());
				configProposal.setSelectionLength(1);
			}
			acceptor.accept(proposal);		
		} else {
			super.complete_RoomModel(model, ruleCall, context, acceptor);
		}
	}
	
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if(keyword == grammar.getVarDeclAccess().getVarargsVarargsKeyword_3_0()) {
			// hide keyword from user
			return;
		}
		
		super.completeKeyword(keyword, context, acceptor);
	}
	
	@Override
	public void completeActorRef_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((CrossReference)assignment.getTerminal()), context, acceptor, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription candidate) {
				ActorRef ar = (ActorRef) model;
				if (!(ar.eContainer() instanceof ActorClass)) {
					// can not filter due to lack of information
					return true;
				}
				
				ActorClass ac = (ActorClass) ar.eContainer();
				
				EObject objectOrProxy = candidate.getEObjectOrProxy();
				
				if (objectOrProxy instanceof ActorClass) {
					ActorClass referenced = (ActorClass) objectOrProxy;
					return !roomHelpers.isReferencing(referenced, ac);
				}
				
				return false;
			}
		});
	}
	
	@Override
	public void completeImport_ImportedNamespace(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupImportedNamespace(model, context, acceptor, RoomPackage.eINSTANCE.getRoomClass(), BasePackage.eINSTANCE.getAnnotationType());
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
	
	@Override
	public void complete_ID(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if(model instanceof StandardOperation){
			StandardOperation op = (StandardOperation) model;
			List<? extends Operation> superOps = Lists.newArrayList();
			EObject roomClass = roomHelpers.getRoomClass(op);
			if(roomClass instanceof ActorClass && ((ActorClass)roomClass).getActorBase() != null)
				superOps = roomHelpers.getLatestOperations(((ActorClass)roomClass).getActorBase());
			else if(roomClass instanceof DataClass && ((DataClass)roomClass).getBase() != null)
				superOps = roomHelpers.getLatestOperations(((DataClass)roomClass).getBase());
			for(Operation superOp : superOps){
				String signature = roomNameProvider.getSignature(superOp);
				String superClassName = roomHelpers.getRoomClass(superOp).getName();
				acceptor.accept(createCompletionProposal(signature, signature+" - "+superClassName, getImage(superOp), context));
			}
		}
		super.complete_ID(model, ruleCall, context, acceptor);
	}

	private List<ActorRef> collectInstances(ActorInstanceMapping aim) {
		List<ActorRef> refs = new ArrayList<ActorRef>();

		ActorContainerClass root = roomHelpers.getParentContainer(aim);
		if (root != null) {
			RefPath path = aim.getPath();
			if(path != null && !path.getRefs().isEmpty() && path.getRefs().get(0) != null && 
					path.getRefs().get(0).getRef() != null)
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
	
	@Inject
	RoomExpressionProposalProvider expressionProposalAdapter;
	//@Inject private DCUtil util;
	
	@Override
	public void complete_CC_STRING(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (context.getCurrentNode().getSemanticElement() instanceof DetailCode) {
			String text = context.getCurrentNode().getText();
			int localOffset = context.getOffset() - context.getCurrentNode().getOffset();
			int globalOffset = context.getOffset();
			DetailCode detailCode = (DetailCode) context.getCurrentNode().getSemanticElement();
			IDetailExpressionProvider exprPovider = UIExpressionUtil.getExpressionProvider(detailCode);
			for(ICompletionProposal proposal : expressionProposalAdapter.createProposals(exprPovider, text, localOffset, globalOffset))
				acceptor.accept(proposal);
			
			// new implementation TODO
			//util.getProposals(context.getCurrentNode(), context.getOffset());
		}

		super.complete_CC_STRING(model, ruleCall, context, acceptor);
	}

}
