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
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
		if (resolve==null || resolve.trim().isEmpty())
			return null;

		URI baseUri = object.eResource()==null? null:object.eResource().getURI();
		resolve = resolve(resolve, baseUri);
		
		return resolve;
	}

	public String resolve(String resolve, URI baseUri) {
		resolve = substituteEnvVars(resolve);
		resolve = resolve.replaceAll("\\\\", "/");
		resolve = resolve.replaceAll("//", "/");
		
		if (baseUri!=null) {
			resolve = resolveUriAgainstBase(resolve, baseUri);
		}
		return resolve;
	}

	public String substituteEnvVars(String text) {
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
//				Path basePath = new Path(base.toPlatformString(true));
//				if (basePath.segmentCount()<2) {
//					// it's a project
//					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(basePath.lastSegment());
//					if (project!=null) {
//						String abs = project.getRawLocationURI().toString();
//						base = URI.createURI(abs);
//					}
//				}
//				else {
//					// it's a folder
//					IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(basePath);
//					if (folder!=null) {
//						String abs = folder.getRawLocationURI().toString();
//						base = URI.createURI(abs);
//					}
//				}
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
}
