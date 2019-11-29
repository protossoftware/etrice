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

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.collect.Multimap;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface IOrganizeImportHelper {

	public static class ImportRegionResult {
		private ITextRegion region;
		private boolean needNewLine;
		
		public ImportRegionResult(int offset, int length, boolean needNewLine) {
			super();
			this.region = new TextRegion(offset, length);
			this.needNewLine = needNewLine;
		}
		public ITextRegion getRegion() {
			return region;
		}
		public boolean isNeedNewLine() {
			return needNewLine;
		}
	}
	
	/**
	 * @return a map of all {@link EClass}es that reference to be resolved objects with the corresponding {@link EReference}s
	 */
	Multimap<EClass, EReference> getTypeReferences();

	/**
	 * @param resource the Xtext resource being processed
	 * @return the region where the imports should go to
	 */
	default ImportRegionResult getImportRegion(XtextResource resource) {
		EObject root = resource.getContents().get(0);
		TreeIterator<EObject> it = root.eAllContents();
		int begin = Integer.MAX_VALUE;
		int end = 0;
		while (it.hasNext()) {
			EObject object = it.next();
			if (object instanceof Import) {
				INode node = NodeModelUtils.findActualNodeFor(object);
				if (node!=null) {
					begin = Math.min(begin, node.getOffset());
					end = Math.max(end, node.getEndOffset());
				}
			}
		}
		if (begin < end) {
			return new ImportRegionResult(begin, end - begin, false);
		}
		else {
			return null;
		}
	}
	
	/**
	 * @param object the object we need a qualified name for
	 * @return a fully qualified name for the object
	 */
	QualifiedName getFullyQualifiedName(EObject object);
	
	/**
	 * @param refText the reference text
	 * @param type the expected {@link EClass}
	 * @param resource the current resource
	 * @return a list of qualified names that resolve this reference
	 */
	List<QualifiedName> resolveFullyQualifiedName(String refText, EClass type, Resource resource);
}
