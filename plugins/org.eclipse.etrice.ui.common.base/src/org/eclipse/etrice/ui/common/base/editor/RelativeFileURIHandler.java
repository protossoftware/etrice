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

package org.eclipse.etrice.ui.common.base.editor;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.etrice.core.common.ui.linking.GlobalNonPlatformURIEditorOpener;

/**
 *  {@linkplain URIHandler} which deresolves to relative file uri and resolves to absolute file uri. <br>
 *  Used to persist portable model references. <br>
 *  <br>
 *  TODO serialize room includes path <=> deresolve in StandardModelLocator
 */
public class RelativeFileURIHandler extends URIHandlerImpl {
	
	private final static Logger LOG = Logger.getLogger(RelativeFileURIHandler.class);
	
	public static Map<Object, Object> addToOptions(Map<Object, Object> options) {
		options.put(XMIResource.OPTION_URI_HANDLER, new RelativeFileURIHandler((URIHandler) options.get(XMIResource.OPTION_URI_HANDLER)));
		return options;
	}
	
	final protected URIHandler fallback;
	
	public RelativeFileURIHandler(URIHandler fallback) {
		this.fallback = fallback;
	}
	
	/**
	 *  @return absolute file uri
	 */
	@Override
	public URI resolve(URI uri) {	
		if (resolve && baseURI != null && uri.isFile() && uri.hasRelativePath()) {
			URI baseFileURI = toFileURI(baseURI);
			URI fileURI = toFileURI(uri);
			
			URI resolvedFileURI = fileURI.resolve(baseFileURI, true);	
		//	System.out.println("resolve: " + fileURI + " -> " + baseFileURI + " = " + resolvedFileURI);
			URI platURI = GlobalNonPlatformURIEditorOpener.getPlatformURI(resolvedFileURI);
			
			return (platURI != null) ? platURI : resolvedFileURI;
		}
		
		return (fallback != null) ? fallback.resolve(uri) : uri;
	}

	/**
	 *  @return shorter relative file path
	 */
	@Override
	public URI deresolve(URI uri) {		
		if (resolve && baseURI != null) {
			URI baseFileURI = toFileURI(baseURI);
			URI fileURI = toFileURI(uri);
	
			URI relativeFileURI = fileURI.deresolve(baseFileURI, true, true, true);
			if(relativeFileURI.isFile() && relativeFileURI.hasRelativePath()) {
		//		System.out.println("deresolve: " + fileURI + " -> " + baseFileURI + " = " + relativeFileURI);
				return relativeFileURI;
			}
		}
		
		return (fallback != null) ? fallback.deresolve(uri) : uri;
	}

	private static URI toFileURI(URI uri) {
		if (uri.isFile()) {
			return uri;
		} else if (uri.isPlatform()) {
			IPath path = null;
			if(uri.segmentCount() == 2){
				path = ResourcesPlugin.getWorkspace().getRoot().getProject(uri.lastSegment()).getLocation();
			} else if(uri.segmentCount() > 2){
				path = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(false))).getLocation();
			}
			if(path != null) {
				return URI.createFileURI(path.toOSString()).appendQuery(uri.query()).appendFragment(uri.fragment());
			}
		}
		
		LOG.error("unhandled uri " + uri);
		return uri;
	}
}
