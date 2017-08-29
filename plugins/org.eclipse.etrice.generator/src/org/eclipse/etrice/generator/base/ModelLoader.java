/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver;
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger;
import org.eclipse.etrice.generator.fsm.base.NullLogger;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.xml.sax.SAXException;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ModelLoader {

	protected ILogger logger;
	
	/**
	 * The injected resource set provider
	 */
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	
	/**
	 * The injected platform relative URI resolver
	 */
	@Inject
	protected ModelLocatorUriResolver uriResolver;
	
	private ResourceSet resourceSet;
	private HashSet<URI> modelURIs = new HashSet<URI>();
	private HashSet<URI> mainModelURIs = new HashSet<URI>();
	private HashSet<URI> loadedModelURIs = new HashSet<URI>();

    public boolean loadModels(List<String> uriList) {
        return loadModels(uriList, null);
    }
    
	public boolean loadModels(List<String> uriList, ILogger logger) {
	    if (logger==null) {
	        logger = new NullLogger();
	    }
	    this.logger = logger;
	    
		resourceSet = resourceSetProvider.get();
		if (resourceSet instanceof XtextResourceSet) {
			((XtextResourceSet) resourceSet).setClasspathURIContext(getClass().getClassLoader());
		}
		modelURIs.clear();
		loadedModelURIs.clear();
		
		for (String uri : uriList) {
			addResourceURI(uriResolver.resolve(uri, null));
		}
		
		// now that we have a list of normalized input models we make a copy of them
		mainModelURIs.addAll(modelURIs);
		
		boolean ok = true;
		while (!modelURIs.isEmpty()) {
			URI uri = modelURIs.iterator().next();
			//logger.logInfo("Loading " + uriString);
			try {
				if (loadModel(uri)) {
					Resource resource = resourceSet.getResources().get(resourceSet.getResources().size()-1);
					for (EObject root : resource.getContents()) {
						Iterator<EObject> it = root.eContents().iterator();
						while (it.hasNext()) {
							EObject obj = it.next();
							String importUri = uriResolver.resolve(obj);
							if (importUri!=null) {
								addResourceURI(importUri);
							}
						}
					}
				}
			}
			catch (Exception e) {
				ok = false;
				if (e instanceof FileNotFoundException)
					logger.logError("couldn't load '"+uri+"' (file not found)", null);
				if(e instanceof SAXException)
					logger.logError("couldn't load '"+uri+"' (maybe unknown or wrong file extension, eTrice file extensions have to be lower case)", null);
				else
					logger.logError(e.getMessage(), null);
			}
			modelURIs.remove(uri);
		}
		
		// make a copy to avoid concurrent modification
		ArrayList<Resource> resources = new ArrayList<Resource>(resourceSet.getResources());
		for (Resource res : resources) {
			EcoreUtil2.resolveAll(res, CancelIndicator.NullImpl);
		}
		
		return ok;
	}

	/**
	 * Called by {@link #loadModels(List)} for each single model.
	 * 
	 * @param uri the model URI
	 * @return <code>true</code> if successfully loaded or already loaded
	 * @throws RuntimeException
	 * @throws IOException
	 */
	private boolean loadModel(URI uri)
			throws RuntimeException, IOException {
		
		if (loadedModelURIs.contains(uri))
			return true;
		
		if (resourceSet.getResource(uri, false) != null)
			// already loaded
			return false;
		
		logger.logInfo("loading model        " + uri);
		resourceSet.getResource(uri, true);	// Could throw an exception...
		loadedModelURIs.add(uri);
		return true;
	}
	
	/**
	 * This implementation of the method assumes the URI is already normalized and adds it to the
	 * list of models to load if not already loaded.
	 */
	private boolean addResourceURI(String uri) {
		URI can = null;
		if (uri.startsWith("platform:/") || uri.startsWith("classpath:/") || uri.startsWith("file:/"))
			can = URI.createURI(uri);
		else
			can = URI.createFileURI(uri);
		
		if (loadedModelURIs.contains(can))
			return false;
		
		boolean added = modelURIs.add(can);
		if (added) {
			if (loadedModelURIs.isEmpty())
				logger.logInfo("added model          "+uri);
			else
				logger.logInfo("added imported model "+uri);
		}
		return added;
	}

	/**
	 * @return
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * @return the mainModelURIs
	 */
	public HashSet<URI> getMainModelURIs() {
		return mainModelURIs;
	}
}
