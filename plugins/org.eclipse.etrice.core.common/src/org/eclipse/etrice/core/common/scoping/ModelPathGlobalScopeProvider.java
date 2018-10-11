/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.core.common.scoping;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.generator.base.io.IModelPath;
import org.eclipse.etrice.generator.base.io.IModelPathProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractScope;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;

/**
 * Provides scopes based on a {@link IModelPath}.
 */
public class ModelPathGlobalScopeProvider extends AbstractGlobalScopeProvider {
	
	/**
	 * Filters the model files.
	 */
	@FunctionalInterface
	public static interface IModelPathFileFilter extends Predicate<URI> {}
	
	private IModelPathProvider modelPathProvider;
	private IQualifiedNameProvider qualifiedNameProvider;
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
	private IModelPathFileFilter modelPathFileFilter;
	private ModelLocatorUriResolver uriResolver;
	
	@Inject
	public ModelPathGlobalScopeProvider(IModelPathProvider modelPathProvider, IQualifiedNameProvider qualifiedNameProvider,
			IResourceServiceProvider.Registry resourceServiceProviderRegistry, IModelPathFileFilter modelPathFileFilter, ModelLocatorUriResolver uriResolver) {
		this.modelPathProvider = modelPathProvider;
		this.qualifiedNameProvider = qualifiedNameProvider;
		this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
		this.modelPathFileFilter = modelPathFileFilter;
		this.uriResolver = uriResolver;
	}
	
	@Override
	protected IScope getScope(Resource context, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		return new ModelPathGlobalScope(ignoreCase, context, type, filter);
	}
	
	public AbstractScope getScope(IScope parent, Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		return new ModelPathGlobalScope(parent, isIgnoreCase(reference), context, reference.getEReferenceType(), filter);
	}
	
	private class ModelPathGlobalScope extends AbstractScope {

		private Resource context;
		private EClass type;
		private Predicate<IEObjectDescription> filter;
		
		public ModelPathGlobalScope(boolean ignoreCase, Resource context, EClass type, Predicate<IEObjectDescription> filter) {
			this(IScope.NULLSCOPE, ignoreCase, context, type, filter);
		}
		
		public ModelPathGlobalScope(IScope parent, boolean ignoreCase,
				Resource context, EClass type, Predicate<IEObjectDescription> filter) {
			super(parent, ignoreCase);
			
			this.context = context;
			this.type = type;
			this.filter = filter == null ? Predicates.alwaysTrue() : filter;
		}
		
		@Override
		protected IEObjectDescription getSingleLocalElementByName(QualifiedName name) {
			Stream<IResourceDescription> resourceDescriptions = getResourceDescriptionsByName(name);
			return getExportedObjectsByName(resourceDescriptions, name).findFirst().orElse(null);
		}
		
		@Override
		protected Iterable<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
			Stream<IResourceDescription> resourceDescriptions = getResourceDescriptionsByName(name);
			return getExportedObjectsByName(resourceDescriptions, name).collect(Collectors.toList());
		}
		
//		@Override
//		protected IEObjectDescription getSingleLocalElementByEObject(final EObject object, final URI uri) {
//			Stream<IResourceDescription> resourceDescriptions = getResourceDescriptionsByObject(object);
//			return getExportedObjectsByObject(resourceDescriptions, object).findFirst().orElse(null);
//		}
		
		@Override
		protected Iterable<IEObjectDescription> getLocalElementsByEObject(final EObject object, final URI uri) {
			Stream<IResourceDescription> resourceDescriptions = getResourceDescriptionsByObject(object);
			return getExportedObjectsByObject(resourceDescriptions, object).collect(Collectors.toList());
		}
		
		@Override
		protected Iterable<IEObjectDescription> getAllLocalElements() {
			Stream<IResourceDescription> resourceDescriptions = getAllResourceDescriptions();
			return getExportedObjectsByType(resourceDescriptions, type).collect(Collectors.toList());
		}
		
		private Stream<IEObjectDescription> getExportedObjectsByName(Stream<IResourceDescription> resourceDescriptions, QualifiedName name) {
			return resourceDescriptions.map(rd -> rd.getExportedObjects(type, name, isIgnoreCase()))
					.flatMap(eods -> StreamSupport.stream(eods.spliterator(), false))
					.filter(filter::apply);
		}
		
		private Stream<IEObjectDescription> getExportedObjectsByType(Stream<IResourceDescription> resourceDescriptions, EClass type) {
			return resourceDescriptions.map(rd -> rd.getExportedObjectsByType(type))
					.flatMap(eods -> StreamSupport.stream(eods.spliterator(), false))
					.filter(filter::apply);
		}
		
		private Stream<IEObjectDescription> getExportedObjectsByObject(Stream<IResourceDescription> resourceDescriptions, EObject object) {
			return resourceDescriptions.map(rd -> rd.getExportedObjectsByObject(object))
					.flatMap(eods -> StreamSupport.stream(eods.spliterator(), false))
					.filter(filter::apply);
		}
		
		private Stream<IResourceDescription> getResourceDescriptionsByObject(EObject object) {
			QualifiedName name = qualifiedNameProvider.getFullyQualifiedName(object);
			if(name != null) {
				return getResourceDescriptionsByName(name);
			}
			return Stream.empty();
		}
		
		private Stream<IResourceDescription> getResourceDescriptionsByName(QualifiedName name) {
			IModelPath modelPath = modelPathProvider.get(context);
			Stream<URI> files = modelPath.getFiles(name);
			return getResourceDescriptions(files);
		}
		
		private Stream<IResourceDescription> getAllResourceDescriptions() {
			IModelPath modelPath = modelPathProvider.get(context);
			Stream<URI> files = modelPath.getAllFiles();
			return getResourceDescriptions(files);
		}
		
		private Stream<IResourceDescription> getResourceDescriptions(Stream<URI> files) {
			IResourceDescriptions descriptions = ModelPathGlobalScopeProvider.this.getResourceDescriptions(context);
			ResourceSet resourceSet = context.getResourceSet();
			return files.filter(modelPathFileFilter)
					.map(uri -> getResourceDescription(uri, descriptions, resourceSet))
					.flatMap(rd -> streamOptional(rd));
		}
		
		/**
		 * Tries to retrieve a resource description for the specified resource.
		 * If the resource description is not present in the index, a new resource description is computed using the resource set.
		 * 
		 * @param uri the uri of the resource
		 * @param descriptions the index
		 * @param resourceSet a resource set used to load the resource
		 * @return an optional of the requested resource descriptions
		 */
		private Optional<IResourceDescription> getResourceDescription(URI uri, IResourceDescriptions descriptions, ResourceSet resourceSet) {
			uri = resolveURI(uri);
			IResourceDescription resourceDescription = descriptions.getResourceDescription(uri);
			if(resourceDescription != null) {
				return Optional.of(resourceDescription);
			}
			else {
				IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(uri);
				if(resourceServiceProvider != null) {
					Resource resource = resourceSet.getResource(uri, true);
					IResourceDescription.Manager descriptionManager = resourceServiceProvider.getResourceDescriptionManager();
					resourceDescription = descriptionManager.getResourceDescription(resource);
					return Optional.of(resourceDescription);
				}
			}
			return Optional.empty();
		}
		
		private URI resolveURI(URI uri) {
			String uriStr = uriResolver.resolve(uri.toString(), null);
			return URI.createURI(uriStr);
		}
	}
	
	/**
	 * This method for {@link Optional} is first introduced in Java 9 :(
	 */
	private static <T> Stream<T> streamOptional(Optional<T> optional) {
		return optional.isPresent() ? Stream.of(optional.get()) : Stream.empty();
	}
	
}
