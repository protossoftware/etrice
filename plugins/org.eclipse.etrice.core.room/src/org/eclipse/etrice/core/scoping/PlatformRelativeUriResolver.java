/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.scoping;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

/**
 * This URI resolver tries to resolve against the <code>URI</code> of the object's resource.
 * If this is a platform resource <code>URI</code> then it determines an absolute path and resolves against that.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class PlatformRelativeUriResolver extends ImportUriResolver {

	private Map<String, String> env = System.getenv();
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.scoping.impl.ImportUriResolver#resolve(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public String resolve(EObject object) {
		String resolve = super.resolve(object);
		
		// can't do anything about empty URIs
		if (resolve==null || resolve.trim().isEmpty())
			return null;

		return resolve(resolve, object.eResource());
	}

	/**
	 * resolves a URI against the URI of a resource (usually that of the import).
	 * The URI is resolved against a base URI (if given), environment variables are replaced
	 * and the path is normalized. If possible the URI is converted into a platform URI.
	 * 
	 * @param resolve the URI to resolve
	 * @param resource the resource against which to resolve (or @code{null})
	 * @return the resolved URI as string
	 */
	public String resolve(String resolve, Resource resource) {
		URI baseUri = resource==null? null : resource.getURI();
		resolve = resolve(resolve, baseUri);
		try {
			URIConverter converter = resource==null? null : resource.getResourceSet().getURIConverter();
			URI canonical = getCanonicalFileURI(resolve, converter);
			if (canonical.isPlatform())
				resolve = "platform:/resource"+canonical.toPlatformString(true);
			else {
				resolve = "file:/"+canonical.toFileString();

				resolve = resolve.replaceAll("\\\\", "/");
				resolve = resolve.replaceAll("//", "/");
			}
		} catch (IOException e) {
		}
		
		return resolve;
	}
	
	private String resolve(String resolve, URI baseUri) {
		resolve = substituteEnvVars(resolve);
		
		// replace (double) slashes and backslashes with single slashes
		resolve = resolve.replaceAll("\\\\", "/");
		resolve = resolve.replaceAll("//", "/");
		
		if (baseUri!=null) {
			resolve = resolveUriAgainstBase(resolve, baseUri);
		}
		return resolve;
	}

	private String substituteEnvVars(String text) {
		String pattern = "\\$\\{([A-Za-z0-9_]+)\\}";
		Pattern expr = Pattern.compile(pattern);
		Matcher matcher = expr.matcher(text);
		while (matcher.find()) {
		    String envValue = env.get(matcher.group(1));
		    if (envValue == null) {
		        envValue = "";
		    }
		    else {
		        envValue = envValue.replace("\\", "\\\\");
		    }
		    Pattern subexpr = Pattern.compile(Pattern.quote(matcher.group(0)));
		    text = subexpr.matcher(text).replaceAll(envValue);
		}

		return text;
	}

	private String resolveUriAgainstBase(String resolve, URI baseUri) {
		if (resolve==null || resolve.trim().isEmpty())
			return null;

		URI uri = URI.createURI(resolve);
		if (uri.isRelative()) {
			URI base = baseUri.trimSegments(1);
			if (base.isPlatformResource()) {
				uri = base.appendSegments(uri.segments());
				resolve = "platform:/resource"+uri.toPlatformString(true);
				return resolve;
			}
			else if (base.isRelative()) {
				base = URI.createFileURI(new File(base.toString()).getAbsolutePath());
			}
			// URI.resolve expects a trailing separator for some reason...
			base = base.appendSegment("");
			try {
				uri = uri.resolve(base);
			}
			catch (IllegalArgumentException e) {
			}
			resolve = uri.toString();
			try {
				File file = new File(uri.toFileString());
				if (file.isDirectory())
					return "path/to/directory";
				}
			catch (Throwable e) {
			}
		}
		return resolve;
	}
	
	private URI getCanonicalFileURI(String uriString, URIConverter uriConverter) throws IOException {
		URI uri;
		if (uriString.startsWith("classpath:/") || uriString.startsWith("platform:/") || uriString.startsWith("file:/")) {
			uri = URI.createURI(uriString);
		}
		else {
			uri = URI.createFileURI(uriString);
		}
		
		URI normalized = (uriConverter==null) ? uri : uriConverter.normalize(uri);
		if (normalized.isPlatform())
			return normalized;
		
		String can = normalized.toFileString();
		File f = new File(can);
		
		// now we give extensions a chance to locate the model file
		f = ModelLocator.getInstance().locateModel(f);
		
		can = f.getCanonicalPath();	// e.g. remove embedded ../
		URI canonical = URI.createFileURI(can);
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(java.net.URI.create(canonical.toString()));
			if (files.length>0) {
				IPath fullPath = files[0].getFullPath();
				String loc = fullPath.toString();
				canonical = URI.createPlatformResourceURI(loc, true);
			}
		}
		return canonical;
	}
}
