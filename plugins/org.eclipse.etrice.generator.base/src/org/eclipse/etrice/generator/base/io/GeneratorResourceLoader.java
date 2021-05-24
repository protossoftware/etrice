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
import org.eclipse.etrice.generator.base.io.FileSystemModelPath.ModelDirectory;
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
		ResourceSetModelPathProvider.install(resourceSet, mp);
		
		List<Resource> resources = loadResources(files, resourceSet, logger);
		
		EcoreUtil.resolveAll(resourceSet);
		
		return resources;
	}
	
	/**
	 * Executes the language setup if not already initialized.
	 */
	private void doEMFRegistration() {
		if(!initializedEMF) {
			emfSetup.doEMFRegistration();
			initializedEMF = true;
		}
	}
	
	/**
	 * @param files a list of strings that are interpreted as paths to files to load
	 * @param resourceSet a resource set used to load the resources
	 * @param logger a logger used to report problems
	 * @return the list of loaded resource
	 */
	private List<Resource> loadResources(List<String> files, ResourceSet resourceSet, ILogger logger) {
		List<Resource> resources = new ArrayList<>(files.size());
		for(String f: files) {
			Resource r = loadResource(f, resourceSet, logger);
			resources.add(r);
		}
		return resources;
	}
	
	/**
	 * @param file a string that is interpreted as a path to a file to load
	 * @param rs a resource set used to load the resource
	 * @param logger a logger used to report problems
	 * @return the loaded resource
	 */
	private Resource loadResource(String file, ResourceSet rs, ILogger logger) {
		Path path = Path.of(file).normalize();
		if(Files.exists(path)) {
			Path realPath = toRealPath(path);
			URI uri = NIOPathUtil.toEMFUri(realPath);
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
	
	/**
	 * @param pathStrings a list of strings that are interpreted as paths to containers of model files
	 * @param logger a logger used to report problems
	 * @return a file system modelpath that contains all files that are currently in the passed locations
	 */
	private IModelPath createModelPath(List<String> pathStrings, ILogger logger) {
		ArrayList<ModelDirectory> modelDirs = new ArrayList<>(pathStrings.size());
		for(String pathString: pathStrings) {
			Path path = Path.of(pathString).normalize();
			if(Files.exists(path)) {
				Path realPath = toRealPath(path);
				// If the path points to a directory, add it to the model directories.
				if(Files.isDirectory(realPath)) {
					modelDirs.add(new ModelDirectory(realPath));
				}
				// If the path references a file, try to open it as a file system (e.g. zip files)
				// and add its root directories to the model directories.
				else if(Files.isRegularFile(realPath)) {
					FileSystem fileSystem = getFileSystem(realPath, logger);
					for(Path rootDir: fileSystem.getRootDirectories()) {
						modelDirs.add(new ModelDirectory(rootDir));
					}
				}
			}
			else {
				logger.logWarning("could not find modelpath entry " + pathString);
			}
		}
		
		// Build up the index of the model directories.
		modelDirs.forEach(this::indexDirectory);
		return new FileSystemModelPath(modelDirs);
	}
	
	private void indexDirectory(ModelDirectory modelDir) {
		try {
			modelDir.indexDirectory();
		}
		catch(IOException e) {
			throw new UncheckedIOException(e);
		}
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
	
	private Path toRealPath(Path path, LinkOption... options) {
		try {
			return path.toRealPath(options);
		}
		catch(IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	/** A resource adapter that logs the uris of added resources. */
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
