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

package org.eclipse.etrice.generator.base.io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.generator.base.GeneratorException;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.logging.ILogger;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Simple implementation for resource loading and resolving.
 * Only supports file paths and <b>not</b> URIs.
 */
public class GeneratorResourceLoader implements IGeneratorResourceLoader {
	
	private Provider<ResourceSet> resourceSetProvider;
	private IGeneratorEMFSetup emfSetup;
	
	private boolean initializedEMF;
	
	@Inject
	public GeneratorResourceLoader(Provider<ResourceSet> resourceSetProvider, IGeneratorEMFSetup emfSetup) {
		this.resourceSetProvider = resourceSetProvider;
		this.emfSetup = emfSetup;
		
		initializedEMF = EMFPlugin.IS_ECLIPSE_RUNNING;
	}
	
	@Override
	public List<Resource> load(List<String> files, List<String> modelpath, Arguments arguments, ILogger logger) throws GeneratorException {
		doEMFRegistration();
		
		ResourceSet resourceSet = resourceSetProvider.get();
		Adapter resourceAddedAdapter = new ResourceAddedAdapter(logger);
		resourceSet.eAdapters().add(resourceAddedAdapter);
		
		IModelPath mp = createModelPath(modelpath, logger);
		resourceSet.getLoadOptions().putIfAbsent(ResourceSetModelPathProvider.LOAD_OPTION_MODELPATH, mp);
		
		List<Resource> resources = loadResources(files, resourceSet, logger);
		
		EcoreUtil.resolveAll(resourceSet);
		
		return resources;
	}
	
	private void doEMFRegistration() {
		if(!initializedEMF) {
			emfSetup.doEMFRegistration();
			initializedEMF = true;
		}
	}
	
	private List<Resource> loadResources(List<String> files, ResourceSet resourceSet, ILogger logger) {
		List<Resource> resources = new ArrayList<>(files.size());
		for(String f: files) {
			Resource r = loadResource(f, resourceSet, logger);
			resources.add(r);
		}
		return resources;
	}
	
	private Resource loadResource(String file, ResourceSet rs, ILogger logger) {
		Path normalizedPath = Paths.get(file).normalize();
		if(Files.exists(normalizedPath)) {
			Path realPath = toRealPath(normalizedPath);
			URI uri = createURI(realPath);
			try {
				return rs.getResource(uri, true);
			}
			catch(RuntimeException e) {
				logger.logError("could not load file " + file + "; " + e.getMessage());
				throw new GeneratorException(e);
			}
		}
		else {
			logger.logError("could not find file " + file);
			throw new GeneratorException();
		}
	}
	
	private IModelPath createModelPath(List<String> pathStrings, ILogger logger) {
		ArrayList<Path> paths = new ArrayList<>(pathStrings.size());
		for(String pathString: pathStrings) {
			Path path = Paths.get(pathString).normalize();
			if(Files.exists(path)) {
				Path realPath = toRealPath(path);
				if(Files.isDirectory(realPath)) {
					paths.add(realPath);
				}
				else if(Files.isRegularFile(realPath)) {
					FileSystem fileSystem = getFileSystem(realPath, logger);
					for(Path rootDir: fileSystem.getRootDirectories()) {
						paths.add(rootDir);
					}
				}
			}
			else {
				logger.logWarning("could not find modelpath entry " + pathString);
			}
		}
		
		FileSystemModelPath modelpath = new FileSystemModelPath(paths);
		return modelpath;
	}
	
	private FileSystem getFileSystem(Path path, ILogger logger) {
		try {
			return FileSystems.newFileSystem(path, null);
		}
		catch(ProviderNotFoundException e) {
			logger.logError("could not read modelpath entry " + path.toString());
			throw new GeneratorException(e);
		}
		catch(IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	protected URI createURI(Path path) {
		return URI.createURI(path.toUri().toString());
	}
		
	private Path toRealPath(Path path, LinkOption... options) {
		try {
			return path.toRealPath(options);
		}
		catch(IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	private class ResourceAddedAdapter extends AdapterImpl {
		
		private ILogger logger;
		
		public ResourceAddedAdapter(ILogger logger) {
			this.logger = logger;
		}
		
		@Override
		public void notifyChanged(Notification msg) {
			if(msg.getEventType() == Notification.ADD) {
				Resource addedResource = (Resource) msg.getNewValue();
				logger.logDebug("added resource " + addedResource.getURI());
			}
		}
	}
}
