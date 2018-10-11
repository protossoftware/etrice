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
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.linking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;

import com.google.common.base.Predicates;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class ImportAwareHyperlinkHelper extends HyperlinkHelper {

	@Inject
	protected Provider<XtextHyperlink> hyperlinkProvider;

	@Inject
	protected ModelLocatorUriResolver uriResolver;

	@Inject
	protected EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Inject
	protected IGlobalScopeProvider globalScopeProvider;
	
	@Inject
	protected IQualifiedNameConverter nameConverter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper#
	 * createHyperlinksByOffset(org.eclipse.xtext.resource.XtextResource, int,
	 * org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor)
	 */
	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		XtextHyperlink link = createByImportObject(resource, offset);
		if (link == null)
			link = createByImportNode(resource, offset);
		if (link != null)
			acceptor.accept(link);

		super.createHyperlinksByOffset(resource, offset, acceptor);
	}

	private XtextHyperlink createByImportObject(XtextResource resource, int offset) {
		EObject eObject = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
		if (eObject == null || !(eObject instanceof Import))
			return null;

		Import importObj = (Import) eObject;
		
		// Create hyperlink based on the qualified name of the import using the global scope provider
		String name = importObj.getImportedNamespace();
		if(name != null) {
			QualifiedName qualifiedName = nameConverter.toQualifiedName(name);
			if(!qualifiedName.getLastSegment().equals("*")) {
				EReference reference = EcoreFactory.eINSTANCE.createEReference();
				reference.setEType(EcorePackage.eINSTANCE.getEObject());
				IScope scope = globalScopeProvider.getScope(resource, reference, Predicates.alwaysTrue());
				IEObjectDescription eod = scope.getSingleElement(qualifiedName);
				if(eod != null) {
					URI uri = eod.getEObjectURI();
					INode node = NodeModelUtils.getNode(importObj);
					XtextHyperlink result = hyperlinkProvider.get();
					result.setHyperlinkText(eod.getName().toString());
					result.setURI(uri);
					result.setHyperlinkRegion(new Region(node.getOffset(), node.getLength())); // whole import statement
					return result;
				}
			}
		}
		
		// Create hyperlink using the import uri
		if (importObj.getImportURI() == null)
			return null;

		String uritext = uriResolver.resolve(importObj.getImportURI(), resource);
		if (uritext == null)
			return null;

		XtextHyperlink result = hyperlinkProvider.get();
		result.setHyperlinkText(uritext); // ?
		try {
			result.setURI(URI.createURI(uritext));
		}
		catch (IllegalArgumentException e) {
			return null;
		}

		INode node = NodeModelUtils.getNode(importObj);
		result.setHyperlinkRegion(new Region(node.getOffset(), node.getLength())); // whole import statement

		return result;
	}

	private XtextHyperlink createByImportNode(XtextResource resource, int offset) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			EObject grammarElement = leaf.getParent().getGrammarElement();
			if (grammarElement instanceof RuleCall) {
				RuleCall rc = (RuleCall) grammarElement;
				AbstractRule rule = rc.getRule();
				if (rule.getName().equals("Import")) {
					String text = leaf.getText().substring(1, leaf.getText().length() - 1);

					String uritext = uriResolver.resolve(text, resource);
					if (uritext == null)
						return null;

					XtextHyperlink result = hyperlinkProvider.get();
					result.setHyperlinkText(uritext);
					result.setHyperlinkRegion(new Region(leaf.getOffset() + 1, leaf.getLength() - 2)); // omit ""
					try {
						result.setURI(URI.createURI(uritext));

						return result;
					}
					catch (IllegalArgumentException e) {
					}
				}
			}
		}

		return null;
	}
}
