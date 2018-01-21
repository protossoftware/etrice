/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.base.util;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

public class ImportHelpers {
	
	/**
	 * Returns a list of imported target eObjects for an import or absent if import is not computable.
	 * The list contains either a single exact match (name and quickFixCandidateMatcher) or candidates (name
	 * or quickFixCandidateMatcher) or empty.
	 */
	public static Optional<List<IEObjectDescription>> getImportedObjectsFor(Import imp, ImportUriResolver importUriResolver,
			Predicate<IEObjectDescription> quickFixCandidateMatcher) {

		QualifiedName importedFQN = toFQN(imp);
		if (importedFQN == null)
			return Optional.empty();

		// check in BaseJavaValidator.checkImportURI
		String uriString = importUriResolver.resolve(imp);
		if (uriString == null)
			return Optional.empty();

		URI uri = URI.createURI(uriString);
		Resource importedResource = null;
		try {
			importedResource = imp.eResource().getResourceSet().getResource(uri, true);
		} catch (RuntimeException re) {
			return Optional.empty();
		}
		IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
		if (importedResource == null || resourceServiceProvider == null)
			return Optional.empty();
		IResourceDescription.Manager manager = resourceServiceProvider.getResourceDescriptionManager();
		IResourceDescription description = manager.getResourceDescription(importedResource);

		List<IEObjectDescription> candidates = Lists.newArrayList();
		if (description != null) {
			Iterator<IEObjectDescription> iter = description.getExportedObjects().iterator();
			while (iter.hasNext()) {
				IEObjectDescription eObjDesc = iter.next();
				if (importedFQN.equals(eObjDesc.getQualifiedName())) {
					if (quickFixCandidateMatcher.apply(eObjDesc)) {
						// exact match -> early quit
						return Optional.of(Lists.newArrayList(eObjDesc));
					}
					candidates.add(eObjDesc);
				} else if (quickFixCandidateMatcher.apply(eObjDesc)) {
					candidates.add(eObjDesc);
				}
			}
		}

		return Optional.of(candidates);
	}

	public static QualifiedName toFQN(Import imp) {
		IQualifiedNameConverter nameConverter = new IQualifiedNameConverter.DefaultImpl();
		boolean isWildcard = false;
		try {
			QualifiedName orig = nameConverter.toQualifiedName(imp.getImportedNamespace());
			isWildcard = orig.getLastSegment().equals("*");
			return (isWildcard) ? orig.skipLast(1) : orig;
		} catch(IllegalArgumentException e){
			return null;
		}
	}
}
