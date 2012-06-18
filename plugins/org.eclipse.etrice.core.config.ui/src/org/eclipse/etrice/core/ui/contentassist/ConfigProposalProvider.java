/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.config.ActorClassConfig;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrConfig;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.config.util.ConfigUtil;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.LiteralType;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.ui.contentassist.AbstractConfigProposalProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
public class ConfigProposalProvider extends AbstractConfigProposalProvider {

	@Override
	public void completeImport_ImportURI(EObject model, Assignment assignment,
			final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		final IPath rootPath = ResourcesPlugin.getWorkspace().getRoot()
				.getFullPath();
		URI configURI = context.getRootModel().eResource().getURI();
		final IPath configPath = new Path(configURI.toPlatformString(false)
				.replace(configURI.lastSegment(), ""));
		IResourceProxyVisitor visitor = new IResourceProxyVisitor() {

			@Override
			public boolean visit(IResourceProxy proxy) throws CoreException {
				if (proxy.getType() != IResource.FILE)
					return true;

				String name = proxy.getName();
				if (name.regionMatches(true, name.length() - 4, "room", 0, 4)) {
					IPath relConfigPath = proxy.requestFullPath()
							.makeRelativeTo(configPath);
					IPath relWorkspacePath = proxy.requestFullPath()
							.makeRelativeTo(rootPath);
					String proposal = "\"" + relConfigPath.toString() + "\"";
					String displayString = relConfigPath.lastSegment() + " - "
							+ relWorkspacePath;
					acceptor.accept(createCompletionProposal(proposal,
							new StyledString(displayString), null, context));
				}
				return false;
			}
		};
		try {
			ResourcesPlugin.getWorkspace().getRoot()
					.accept(visitor, IResource.NONE);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void completeActorInstanceConfig_Path(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeActorInstanceConfig_Path(model, assignment, context,
				acceptor);

		List<ActorRef> instances = collectInstances(((ActorInstanceConfig) model));
		for (ActorRef instance : instances)
			acceptor.accept(createCompletionProposal(instance.getName(),
					context));
	}

	@Override
	public void completeRefPath_Refs(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completeRefPath_Refs(model, assignment, context, acceptor);

		if (model instanceof ActorInstanceConfig) {
			completeActorInstanceConfig_Path(model, assignment, context,
					acceptor);
			return;
		}

		RefPath path = ((RefPath) model);
		if (path.eContainer() instanceof ActorInstanceConfig) {
			List<ActorRef> instances = collectInstances((ActorInstanceConfig) path
					.eContainer());
			for (ActorRef instance : instances)
				acceptor.accept(createCompletionProposal(instance.getName(),
						context));
		}
	}

	private List<ActorRef> collectInstances(ActorInstanceConfig config) {
		List<ActorRef> refs = new ArrayList<ActorRef>();

		ActorContainerClass root = config.getRoot();
		RefPath path = config.getPath();
		if (path != null)
			root = ConfigUtil.resolve(root, path);
		if (root != null) {
			for (ActorContainerRef ref : RoomHelpers.getRefs(root, true)) {
				if (ref instanceof ActorRef)
					refs.add((ActorRef) ref);
			}
		}

		return refs;
	}

	@Override
	public void complete_STRING(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof AttrConfig) {
			LiteralType type = ConfigUtil.getLiteralType(((AttrConfig) model)
					.getAttribute());
			if (type != LiteralType.CHAR)
				return;
		}

		super.complete_STRING(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_IntLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof AttrConfig) {
			LiteralType type = ConfigUtil.getLiteralType(((AttrConfig) model)
					.getAttribute());
			if (type != LiteralType.INT && type != LiteralType.REAL)
				return;
		}

		acceptor.accept(createCompletionProposal("", "Integer", null, context));
		acceptor.accept(createCompletionProposal("", "Hexadecimal", null,
				context));
	}

	@Override
	public void complete_RealLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof AttrConfig) {
			LiteralType type = ConfigUtil.getLiteralType(((AttrConfig) model)
					.getAttribute());
			if (type != LiteralType.REAL)
				return;
		}

		acceptor.accept(createCompletionProposal("", "Real value", null,
				context));
	}

	private static final String[] noneClassAttributes = new String[] {};
	private static final String[] noneInstanceAttributes = new String[] {
			"min", "max" };

	@Override
	public void completeKeyword(Keyword keyword,
			ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {

		if (contentAssistContext.getCurrentModel() instanceof AttrConfig) {
			AttrConfig config = (AttrConfig) contentAssistContext
					.getCurrentModel();
			if (hideAttributeKeyword(config, keyword))
				return;
			if (hideBooleanLiteralKeyword(config, keyword))
				return;
		}

		super.completeKeyword(keyword, contentAssistContext, acceptor);
	}

	private boolean hideBooleanLiteralKeyword(AttrConfig config, Keyword keyword) {
		LiteralType type = ConfigUtil.getLiteralType(config.getAttribute());
		if (type != LiteralType.BOOL)
			return true;

		return false;
	}

	private boolean hideAttributeKeyword(AttrConfig config, Keyword keyword) {
		String[] hideKeywords = new String[0];
		if (config.eContainer() instanceof ActorClassConfig)
			hideKeywords = noneClassAttributes;
		else if (config.eContainer() instanceof ActorInstanceConfig)
			hideKeywords = noneInstanceAttributes;

		for (String s : hideKeywords)
			if (s.equalsIgnoreCase(keyword.getValue()))
				return true;

		return false;
	}
}
