/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
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
package org.eclipse.etrice.core.common.ui.imports;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.common.base.BaseFactory;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.ui.imports.IOrganizeImportHelper.ImportRegionResult;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ImportOrganizer {
	
	private static final int IMPORT_ALL_THRESHOLD = 3;

	@Inject
	private IOrganizeImportHelper organizeImportHelper;

	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;
	
	public List<ReplaceRegion> getOrganizedImportChanges(XtextResource resource) {
		return getOrganizedImportChanges(resource, true);
	}
	
	public List<ReplaceRegion> getOrganizedImportChanges(XtextResource resource, boolean interactive) {
		Set<QualifiedName> typeUsages = getTypeUsages(resource, interactive);
		
		typeUsages = simplifyImports(typeUsages);
		
		List<ReplaceRegion> changes = getOrganizedImportChanges(resource, typeUsages);
		
		removeNullEdits(resource, changes);
		
		return changes;
	}

	protected Set<QualifiedName> getTypeUsages(XtextResource resource, boolean interactive) {
		Set<QualifiedName> result = new HashSet<>();
		
		Multimap<Pair<EClass, String>, QualifiedName> ambiguous = HashMultimap.create();
		
		Multimap<EClass, EReference> typeReferences = organizeImportHelper.getTypeReferences();
		EObject root = resource.getContents().get(0);
		TreeIterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject object = it.next();
			if (typeReferences.containsKey(object.eClass())) {
				Collection<EReference> references = typeReferences.get(object.eClass());
				references.forEach(ref -> {
					Object refObject = object.eGet(ref);
					if (refObject instanceof EObject) {
						if (((EObject) refObject).eIsProxy()) {
							List<INode> nodes = NodeModelUtils.findNodesForFeature((EObject) object, ref);
							if (!nodes.isEmpty()) {
								String refText = nodes.get(0).getText().trim();
								List<QualifiedName> resolved = organizeImportHelper.resolveFullyQualifiedName(refText, ref.getEReferenceType(), resource);
								if (resolved.size()==1) {
									result.addAll(resolved);
								}
								else if (resolved.size()>1) {
									ambiguous.putAll(new Pair<EClass, String>(object.eClass(), refText), resolved);
								}
							}
						}
						else {
							boolean isQualified = false;
							List<INode> nodes = NodeModelUtils.findNodesForFeature((EObject) object, ref);
							if (!nodes.isEmpty()) {
								// check whether this is a qualified name
								if (nodes.stream().filter(node -> !node.getText().contains(".")).count()==0l) {
									isQualified = true;
								}
							}
							if (!isQualified) {
								QualifiedName namespace = organizeImportHelper.getFullyQualifiedName((EObject) refObject);
								if (namespace!=null) {
									result.add(namespace);
								}
							}
						}
					}
				});
			}
		}
		
		if (!ambiguous.isEmpty()) {
			QualifiedName[][] namespaces = new QualifiedName[ambiguous.asMap().size()][];
			int i = 0;
			for (Collection<QualifiedName> lists : ambiguous.asMap().values()) {
				QualifiedName[] list = new QualifiedName[lists.size()];
				namespaces[i++] = lists.toArray(list);
			}
			result.addAll(doChooseImports(namespaces));
		}
		
		// remove our own namespace
		QualifiedName ownNamespace = organizeImportHelper.getFullyQualifiedName(root);
		result.removeIf(fqn -> fqn.startsWith(ownNamespace));
		
		return result;
	}
	
	protected Set<QualifiedName> doChooseImports(QualifiedName[][] openChoices) {
		NamespaceSelectionLabelProvider labelProvider = new NamespaceSelectionLabelProvider();
		NamespaceSelectionDialog dialog = new NamespaceSelectionDialog(Display.getDefault().getActiveShell(), labelProvider);
		dialog.setTitle("Organize Imports");
		dialog.setMessage("&Choose type to import:");
		dialog.setElements(openChoices);
		Set<QualifiedName> result = new HashSet<>();
		if (dialog.open() == Window.OK) {
			Object[] res = dialog.getResult();
			for (int i = 0; i < res.length; i++) {
				Object[] array= (Object[]) res[i];
				if (array.length>0 && array[0] instanceof QualifiedName) {
					result.add((QualifiedName) array[0]);
				}
			}
		}
		return result;
	}

	protected Set<QualifiedName> simplifyImports(Set<QualifiedName> typeUsages) {
		Map<QualifiedName, List<QualifiedName>> grouped = typeUsages.stream().collect(Collectors.groupingBy(fqn->fqn.skipLast(1)));
		Set<QualifiedName> result = new HashSet<>();
		grouped.forEach((namespace, names) -> {
			if (names.size() > IMPORT_ALL_THRESHOLD) {
				result.add(namespace.append("*"));
			}
			else {
				result.addAll(names);
			}
		});
		return result;
	}
	
	protected List<ReplaceRegion> getOrganizedImportChanges(XtextResource resource, Set<QualifiedName> namespaces) {
		ImportRegionResult importRegionResult = organizeImportHelper.getImportRegion(resource);
		ArrayList<ReplaceRegion> result = newArrayList();
		if (importRegionResult.getRegion()!=null) {
			ArrayList<QualifiedName> sortedNamespaces = new ArrayList<>(namespaces);
			Collections.sort(sortedNamespaces);
			List<Import> allImportDeclarations = sortedNamespaces.stream().map(namespace -> createImport(namespace)).collect(Collectors.toList());
			String lineSeparator = getLineSeparator(resource);
			String newImportSection = serializeImports(allImportDeclarations, lineSeparator);
			if (importRegionResult.isNeedNewLine()) {
				newImportSection += lineSeparator + lineSeparator + "\t";
			}
			result.add(new ReplaceRegion(importRegionResult.getRegion(), newImportSection));
			return result;
		}
		else {
			return result;
		}
	}

	protected void removeNullEdits(XtextResource resource, List<ReplaceRegion> changes) {
		Iterator<ReplaceRegion> iterator = changes.iterator();
		String document = resource.getParseResult().getRootNode().getText();
		while(iterator.hasNext()) {
			ReplaceRegion region = iterator.next();
			if (region.getText().equals(document.substring(region.getOffset(), region.getEndOffset()))) {
				iterator.remove();
			}
		}
	}
	
	protected Import createImport(QualifiedName namespace) {
		Import result = BaseFactory.eINSTANCE.createImport();
		result.setImportedNamespace(namespace.toString());
		return result;
	}
	
	protected String serializeImports(List<Import> allImportDeclarations, String newLine) {
		if (allImportDeclarations.isEmpty()) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		allImportDeclarations.forEach(imp -> appendImport(builder, imp, newLine));
		return builder.toString().trim();	// omit first \t and trailing newLine
	}
	
	protected void appendImport(StringBuilder builder, Import imp, String newLine) {
		builder.append("\timport " + imp.getImportedNamespace() + newLine);
	}

	protected String getLineSeparator(XtextResource resource) {
		return whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI()).getLineSeparator();
	}

}
