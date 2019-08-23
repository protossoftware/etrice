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

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.generator.base.io.IModelPath;
import org.eclipse.etrice.generator.base.io.IModelPath.ModelFile;
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
	public static interface IModelPathFileFilter extends Predicate<ModelFile> {}
	
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
			return getResourceDescriptionsByName(name)
					.flatMap(fdp -> getExportedObjectsByName(fdp, name))
					.findFirst().orElse(null);
		}
		
		@Override
		protected Iterable<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
			return getResourceDescriptionsByName(name)
					.flatMap(fdp -> getExportedObjectsByName(fdp, name))
					.collect(Collectors.toList());
		}
		
		
//		@Override
//		protected IEObjectDescription getSingleLocalElementByEObject(final EObject object, final URI uri) {
//			return getResourceDescriptionsByObject(object)
//					.flatMap(fdp -> getExportedObjectsByObject(fdp, object))
//					.findFirst().orElse(null);
//		}
		
		@Override
		protected Iterable<IEObjectDescription> getLocalElementsByEObject(final EObject object, final URI uri) {
			return getResourceDescriptionsByObject(object)
					.flatMap(fdp -> getExportedObjectsByObject(fdp, object))
					.collect(Collectors.toList());
		}
		
		@Override
		protected Iterable<IEObjectDescription> getAllLocalElements() {
			return getAllResourceDescriptions()
					.flatMap(fdp -> getExportedObjectsByType(fdp, type))
					.collect(Collectors.toList());
		}
		
		private Stream<IEObjectDescription> getExportedObjectsByName(FileDescriptionPair fdp, QualifiedName name) {
			return filterEObjectDescriptions(fdp.rd.getExportedObjects(type, name, isIgnoreCase()), fdp.mf);
		}
		
		private Stream<IEObjectDescription> getExportedObjectsByType(FileDescriptionPair fdp, EClass type) {
			return filterEObjectDescriptions(fdp.rd.getExportedObjectsByType(type), fdp.mf);
		}
		
		private Stream<IEObjectDescription> getExportedObjectsByObject(FileDescriptionPair fdp, EObject object) {
			return filterEObjectDescriptions(fdp.rd.getExportedObjectsByObject(object), fdp.mf);
		}
		
		private Stream<IEObjectDescription> filterEObjectDescriptions(Iterable<IEObjectDescription> eods, ModelFile mf) {
			return StreamSupport.stream(eods.spliterator(), false)
				.filter(eo -> eo.getQualifiedName().startsWith(mf.name))
				.filter(filter::apply);
		}
		
		private Stream<FileDescriptionPair> getResourceDescriptionsByObject(EObject object) {
			QualifiedName name = qualifiedNameProvider.getFullyQualifiedName(object);
			if(name != null) {
				return getResourceDescriptionsByName(name);
			}
			return Stream.empty();
		}
		
		private Stream<FileDescriptionPair> getResourceDescriptionsByName(QualifiedName name) {
			IModelPath modelPath = modelPathProvider.get(context);
			Builder<QualifiedName> builder = Stream.builder();
			while(!name.isEmpty()) {
				builder.add(name);
				name = name.skipLast(1);
			}
			Stream<ModelFile> files = builder.build().flatMap(n -> modelPath.getFiles(n));
			return getResourceDescriptions(files);
		}
		
		private Stream<FileDescriptionPair> getAllResourceDescriptions() {
			IModelPath modelPath = modelPathProvider.get(context);
			return getResourceDescriptions(modelPath.getAllFiles());
		}
		
		private Stream<FileDescriptionPair> getResourceDescriptions(Stream<ModelFile> files) {
			IResourceDescriptions descriptions = ModelPathGlobalScopeProvider.this.getResourceDescriptions(context);
			ResourceSet resourceSet = context.getResourceSet();
			return files.filter(modelPathFileFilter)
				.flatMap(mf -> getResourceDescription(mf.uri, descriptions, resourceSet).map(rd -> new FileDescriptionPair(mf, rd)));
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
		private Stream<IResourceDescription> getResourceDescription(URI uri, IResourceDescriptions descriptions, ResourceSet resourceSet) {
			uri = resolveURI(uri);
			IResourceDescription resourceDescription = descriptions.getResourceDescription(uri);
			if(resourceDescription != null) {
				return Stream.of(resourceDescription);
			}
			else {
				IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(uri);
				if(resourceServiceProvider != null) {
					Resource resource = resourceSet.getResource(uri, true);
					IResourceDescription.Manager descriptionManager = resourceServiceProvider.getResourceDescriptionManager();
					resourceDescription = descriptionManager.getResourceDescription(resource);
					return Stream.of(resourceDescription);
				}
			}
			return Stream.empty();
		}
		
		private URI resolveURI(URI uri) {
			String uriStr = uriResolver.resolve(uri.toString(), null);
			return URI.createURI(uriStr);
		}
	}
	
	private static final class FileDescriptionPair {
		public final ModelFile mf;
		public final IResourceDescription rd;
		
		public FileDescriptionPair(ModelFile modelFile, IResourceDescription resourceDescription) {
			this.mf = modelFile;
			this.rd = resourceDescription;
		}
	}
	
}
