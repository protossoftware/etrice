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


package org.eclipse.etrice.core.etmap.ui.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etmap.eTMap.ActorInstanceMapping;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.ui.linking.ImportAwareHyperlinkHelper;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class ETMapHyperlinkHelper extends ImportAwareHyperlinkHelper {

	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(
					parseResult.getRootNode(), offset);
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
		}

		super.createHyperlinksByOffset(resource, offset, acceptor);
	}

	private EObject getCrossLinkedEObject(ActorInstanceMapping aim) {
		ActorContainerClass lastAcContainer = ETMapUtil.getParentContainer(aim);
		ActorRef lastRef = null;
		for (String ref : aim.getPath().getRefs()) {
			for (ActorRef r : lastAcContainer.getActorRefs())
				if (r.getName().equals(ref)) {
					lastRef = r;
					lastAcContainer = lastRef.getType();
					break;
				}
		}

		return lastRef;
	}

}
