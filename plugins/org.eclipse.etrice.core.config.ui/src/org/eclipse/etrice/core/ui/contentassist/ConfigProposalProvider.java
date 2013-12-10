/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.base.LiteralType;
import org.eclipse.etrice.core.config.ActorInstanceConfig;
import org.eclipse.etrice.core.config.AttrConfig;
import org.eclipse.etrice.core.config.AttrInstanceConfig;
import org.eclipse.etrice.core.config.ConfigValueArray;
import org.eclipse.etrice.core.config.RefPath;
import org.eclipse.etrice.core.config.util.ConfigUtil;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.EnumLiteral;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.util.RoomHelpers;
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
		ImportModelAssist.addPaths(this, context, acceptor, ".room");
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

		ActorContainerClass root = config.getSubSystem().getType();
		if (root != null) {
			RefPath path = config.getPath();
			if (path != null && !path.getRefs().isEmpty())
				root = ConfigUtil.resolve(root, path);
			if (root != null) {
				for (ActorContainerRef ref : RoomHelpers.getRefs(root, true)) {
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

	@Override
	public void complete_STRING(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		Attribute attr = getAttribute(model);
		if (attr != null) {
			LiteralType type = ConfigUtil.getLiteralType(attr);
			if (type != LiteralType.CHAR)
				return;
		}

		super.complete_STRING(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_BooleanLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		String mult = "";
		Attribute attr = getAttribute(model);
		if (attr != null) {
			mult = (attr.getSize() > 0) ? "[" + attr.getSize() + "]" : "";
			LiteralType type = ConfigUtil.getLiteralType(attr);
			if (type != LiteralType.BOOL)
				return;
		}

		acceptor.accept(createCompletionProposal("", "Boolean" + mult, null,
				context));
		acceptor.accept(createCompletionProposal("true", "true", null, context));
		acceptor.accept(createCompletionProposal("false", "false", null,
				context));
	}

	@Override
	public void complete_IntLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		String mult = "";
		Attribute attr = getAttribute(model);
		if (attr != null) {
			mult = (attr.getSize() > 0) ? "[" + attr.getSize() + "]" : "";
			LiteralType type = ConfigUtil.getLiteralType(attr);
			if (type != LiteralType.INT && type != LiteralType.REAL)
				return;
		}

		acceptor.accept(createCompletionProposal("", "Integer" + mult, null,
				context));
		acceptor.accept(createCompletionProposal("", "Hexadecimal" + mult,
				null, context));
	}

	@Override
	public void complete_RealLiteral(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		String mult = "";
		Attribute attr = getAttribute(model);
		if (attr != null) {
			mult = (attr.getSize() > 0) ? "[" + attr.getSize() + "]" : "";
			LiteralType type = ConfigUtil.getLiteralType(attr);
			if (type != LiteralType.REAL)
				return;
		}

		acceptor.accept(createCompletionProposal("", "Real" + mult, null,
				context));
	}
	
	
	@Override
	public void completeEnumConfigValue_Type(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		String mult = "";
		Attribute attr = getAttribute(model);
		if(attr == null)
			return;
		
		mult = (attr.getSize() > 0) ? "[" + attr.getSize() + "]" : "";
		DataType type = attr.getType().getType();
		if(!(type instanceof EnumerationType))
			return;
		EnumerationType enumType = (EnumerationType)type;
		
		acceptor.accept(createCompletionProposal(enumType.getName(), enumType.getName(), null, context));
		for(EnumLiteral l : enumType.getLiterals())
			acceptor.accept(createCompletionProposal(l.getFullName(), l.getFullName()+mult, null, context));
	}
	
	@Override
	public void completeKeyword(Keyword keyword,
			ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		
		EObject model = contentAssistContext.getCurrentModel();
		if (model instanceof AttrConfig)
			if (hideKeyword((AttrConfig) model, keyword))
				return;
		if (model instanceof ConfigValueArray)
			if (hideKeyword((ConfigValueArray) model, keyword))
				return;
		if (keyword.getValue().equals("true")
				|| keyword.getValue().equals("false")) {
			return;
		}
		if (model instanceof AttrInstanceConfig) {
			if (hideKeyword((AttrInstanceConfig) model, keyword))
				return;
		}

		super.completeKeyword(keyword, contentAssistContext, acceptor);
	}

	private boolean hideKeyword(AttrConfig config, Keyword keyword) {
		LiteralType type = ConfigUtil.getLiteralType(config.getAttribute());
		DataType dataType = config.getAttribute().getType().getType();
		if (keyword.getValue().equals("min")
				|| keyword.getValue().equals("max")) {
			if (type != LiteralType.INT && type != LiteralType.REAL)
				return true;
		}
		if (keyword.getValue().equals("Attr")) {
			if (!(dataType instanceof PrimitiveType || dataType instanceof EnumerationType || dataType instanceof DataClass))
				return true;
		}
		if (keyword.getValue().equals("=")) {
			if (!config.getAttribute().eIsProxy())
				if (!(dataType instanceof PrimitiveType || dataType instanceof EnumerationType))
					return true;
		}

		return false;
	}

	private boolean hideKeyword(AttrInstanceConfig config, Keyword keyword) {
		if (keyword.getValue().equals("dynamic configuration")) {
			if (!(config.eContainer() instanceof ActorInstanceConfig))
				return true;
		}

		return false;
	}

	private boolean hideKeyword(ConfigValueArray array, Keyword keyword) {
		if (keyword.getValue().equals(",")) {
			if (array.eContainer() instanceof AttrConfig) {
				Attribute attr = ((AttrConfig) array.eContainer())
						.getAttribute();
				if (attr.getSize() <= array.getValues().size())
					return true;
				if (((PrimitiveType) attr.getType().getType()).getType() == LiteralType.CHAR)
					return true;
			}
		}

		return false;
	}

	private Attribute getAttribute(EObject o) {
		if (o == null)
			return null;
		if (o instanceof Attribute)
			return (Attribute) o;
		if (o instanceof AttrConfig)
			return ((AttrConfig) o).getAttribute();
		else
			return getAttribute(o.eContainer());

	}

}
