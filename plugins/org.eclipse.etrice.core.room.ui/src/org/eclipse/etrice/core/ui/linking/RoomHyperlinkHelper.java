/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.ui.linking.ImportAwareHyperlinkHelper;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.RefSegment;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.services.RoomGrammarAccess;
import org.eclipse.etrice.core.ui.util.UIExpressionUtil;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RoomHyperlinkHelper extends ImportAwareHyperlinkHelper {

	@Inject private RoomGrammarAccess grammar;
	@Inject private RoomHelpers roomHelpers;
	
	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			EObject grammarElement = leaf.getParent().getGrammarElement();
			if (grammarElement instanceof RuleCall) {
				RuleCall rc = (RuleCall) grammarElement;
				AbstractRule rule = rc.getRule();

				EObject crossLinkedEObject = null;
				if (rule.getName().equals("RefPath")) {
					EObject parent = leaf.getSemanticElement().eContainer();
					if (parent instanceof ActorInstanceMapping) {
						crossLinkedEObject = getCrossLinkedEObject((ActorInstanceMapping) parent);
					}
				}
				
				if (crossLinkedEObject != null) {
					Region region = new Region(leaf.getOffset(), leaf.getLength());
					createHyperlinksTo(resource, region, crossLinkedEObject, acceptor);
				}
			}
			
			if(leaf.getGrammarElement() instanceof RuleCall) {
				if(((RuleCall) leaf.getGrammarElement()).getRule() == grammar.getCC_STRINGRule() && leaf.getSemanticElement() instanceof DetailCode) {
					ExpressionFeature exprFeature = UIExpressionUtil.findAtOffset(leaf, offset);
					if(exprFeature != null && exprFeature.getData() instanceof EObject) {
						Region region = new Region(leaf.getOffset(), leaf.getLength());
						createHyperlinksTo(resource, region, (EObject) exprFeature.getData(), acceptor);
					}
				}
			}
		}

		super.createHyperlinksByOffset(resource, offset, acceptor);
	}

	private EObject getCrossLinkedEObject(ActorInstanceMapping aim) {
		ActorContainerClass lastAcContainer = roomHelpers.getParentContainer(aim);
		ActorRef lastRef = null;
		for (RefSegment ref : aim.getPath().getRefs()) {
			for (ActorRef r : lastAcContainer.getActorRefs())
				if (r.getName().equals(ref.getRef())) {
					lastRef = r;
					lastAcContainer = lastRef.getType();
					break;
				}
		}

		return lastRef;
	}

}
