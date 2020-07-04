/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.base.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.common.base.BaseFactory;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver;
import org.eclipse.etrice.core.common.scoping.RelativeFileURIHandler;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ImportHelpers {
	
	private final static EClass EOBJECT = EcorePackage.eINSTANCE.getEObject();
	
	@Inject IQualifiedNameConverter nameConverter;
	@Inject ModelLocatorUriResolver importUriResolver;
	@Inject IGlobalScopeProvider globalScope;							// visible/imported scope
	@Inject(optional = true) IResourceDescriptions resourceDescriptions; // world/workspace scope
	
	public ModelLocatorUriResolver getUriResolver() {
		return importUriResolver;
	}

	/**
	 *  Returns elements from workspace.
	 */
	public Iterable<IEObjectDescription> findInWorskpace(QualifiedName fqn, boolean ignoreCase) {
		return getWorkspaceDescriptions().getExportedObjects(EOBJECT, fqn, ignoreCase);
	}
	
	/**
	 *  Returns elements from workspace.
	 */
	public IResourceDescriptions getWorkspaceDescriptions() {
		if(resourceDescriptions != null) {
			return resourceDescriptions;
		}
		
		throw new IllegalStateException("workspace resource descriptions not set or available");
	}
	
	/**
	 *  Returns current visible/imported scope of given resource.
	 */
	public IScope getVisibleScope(Resource context) {
		return getVisibleScope(context, EOBJECT);
	}
	
	/**
	 *  Returns current visible/imported scope of given resource.
	 */
	public IScope getVisibleScope(Resource context, EClass type) {
		return getVisibleScope(context, type, Predicates.alwaysTrue());
	}
	
	/**
	 * Returns current imported scope of given resource.
	 */
	public IScope getVisibleScope(Resource context, EClass type, Predicate<IEObjectDescription> filter) {
		EReference reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setEType((type != null) ? type : EOBJECT);
		return globalScope.getScope(context, reference, filter);
	}
	
	/**
	 *  Returns current visible/imported scope of given resource.
	 */
	public IGlobalScopeProvider getVisibleScopeProvider() {
		return globalScope;
	}
	
	/**
	 * Returns a list of imported target eObjects for an import or absent if import is not computable.
	 * The list contains either a single exact match (imported namespace && quickFixCandidateMatcher) 
	 * or candidates only (imported namespace || quickFixCandidateMatcher) or is optional empty.
	 */
	public Optional<List<IEObjectDescription>> getImportedObjectsFor(Import imp, Predicate<IEObjectDescription> quickFixCandidateMatcher) {

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
			if(imp.eResource().getResourceSet() instanceof ResourceSetImpl) {
				ResourceSetImpl rs = (ResourceSetImpl) imp.eResource().getResourceSet();
				importedResource = rs.getURIResourceMap().get(uri);
			}
			if(importedResource == null) {
				importedResource = new ResourceSetImpl().getResource(uri, true);
			}
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
					candidates.add(eObjDesc);
				} else if (quickFixCandidateMatcher.apply(eObjDesc)) {
					candidates.add(eObjDesc);
				}
			}
		}

		return Optional.of(candidates);
	}
	
	public QualifiedName toFQN(String fqn) {
		boolean isWildcard = false;
		try {
			QualifiedName orig = nameConverter.toQualifiedName(fqn);
			isWildcard = orig.getLastSegment().equals("*");
			return (isWildcard) ? orig.skipLast(1) : orig;
		} catch(IllegalArgumentException e){
			return null;
		}	
	}

	public QualifiedName toFQN(Import imp) {
		return toFQN(imp.getImportedNamespace());
	}
	
	public List<Import> createModelPathImports(String issueString, Resource resource, EClass type, boolean wildcard) {
		final List<Import> result = new ArrayList<>();
		IScope scope = getVisibleScope(resource, type);
		scope.getAllElements().forEach((eObjDesc) -> {
			if(eObjDesc.getName().getLastSegment().equalsIgnoreCase(issueString)) {
				Import imp = BaseFactory.eINSTANCE.createImport();
				imp.setImportedNamespace((wildcard) ? eObjDesc.getQualifiedName().skipLast(1) + ".*" : eObjDesc.getQualifiedName().toString());
				result.add(imp);
			}
		});
		
		return result;
	}
	
	public List<Import> createURIImports(String issueString, EClass type, URI baseURI) {
		final List<Import> result = new ArrayList<>();
		getWorkspaceDescriptions().getExportedObjectsByType(type).forEach((eObjDesc) -> {
			if(eObjDesc.getName().getLastSegment().equalsIgnoreCase(issueString)) {
				Import imp = BaseFactory.eINSTANCE.createImport();
				imp.setImportedNamespace(eObjDesc.getQualifiedName().skipLast(1) + ".*");
				imp.setImportURI(computeImportURIString(baseURI, eObjDesc.getEObjectURI()));
				result.add(imp);
			}
		});
		
		return result;
	}
	
	private String computeImportURIString(URI base, URI toImport) {
		URI trimmedBase = base.trimQuery().trimFragment();
		URI trimmedImport = toImport.trimQuery().trimFragment();
		
		RelativeFileURIHandler fileHandler = new RelativeFileURIHandler();
		fileHandler.setBaseURI(trimmedBase);
		URI resolvedRelative= fileHandler.deresolve(trimmedImport);
		
		// same project => relative
		if(base.isPlatformResource() && toImport.isPlatformResource() && Objects.equals(base.segment(1), toImport.segment(1))) {
			// check if exists
			String baseLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(base.trimSegments(1).toPlatformString(false))).getLocation().toFile().getAbsolutePath();			
			if(resolvedRelative.isRelative() && Files.exists(Paths.get(baseLocation, resolvedRelative.toString()))) {
				return resolvedRelative.toString();
			} else {
				return trimmedImport.toString();
			}
		}
		
		// both in workspace => platform resource
		if(base.isPlatformResource() && toImport.isPlatformResource()) {
			return trimmedImport.toString();
		} else {	
			// else file 
			return resolvedRelative.toString();	
		}
	}
}
