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
import java.nio.file.Paths;
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
	public List<Resource> load(List<String> files, Arguments arguments, ILogger logger) throws GeneratorException {
		doEMFRegistration();
		
		List<Resource> resources = new ArrayList<>(files.size());
		ResourceSet resourceSet = resourceSetProvider.get();
		Adapter resourceAddedAdapter = new ResourceAddedAdapter(logger);
		resourceSet.eAdapters().add(resourceAddedAdapter);
				
		for(String f: files) {
			Resource r = loadResource(f, resourceSet, logger);
			resources.add(r);
		}
		
		EcoreUtil.resolveAll(resourceSet);
		
		return resources;
	}
	
	private void doEMFRegistration() {
		if(!initializedEMF) {
			emfSetup.doEMFRegistration();
			initializedEMF = true;
		}
	}
	
	private Resource loadResource(String file, ResourceSet rs, ILogger logger) {
		try {
			URI uri = createURI(file);
			return rs.getResource(uri, true);
		}
		catch(RuntimeException | IOException e) {
			logger.logError("couldn't load file " + file + "; " + e.getMessage());
			throw new GeneratorException(e);
		}
	}
	
	protected URI createURI(String file) throws IOException {
		String realPath = Paths.get(file).toRealPath().toString();
		URI uri = URI.createFileURI(realPath);
		return uri;
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
