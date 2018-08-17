/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.scoping;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;

/**
 *  TODO import resolve (and deresolve in diagrams) is not consistent 
 */
public class StandardModelLocator implements IModelLocator {

	private static final String CLASSPATH = "classpath:/";
	private static final Map<String, String> env = System.getenv();

	/**
	 * resolves a URI against the URI of a resource (usually that of the import).
	 * The URI is resolved against a base URI (if given), environment variables are replaced
	 * and the path is normalized.
	 * 
	 * @param resolve the URI to resolve
	 * @param resource the resource against which to resolve (or @code{null})
	 * @return the resolved URI as string, or null if the resource cannot be 
	 * resolved
	 */
	@Override
	public String resolve(String resolve, Resource resource) {
		URI baseUri = resource==null? null : resource.getURI();
		
		resolve = resolve(resolve, baseUri, resource);
		if(resolve == null) {
			return null;
		}
		
		try {
			URIConverter converter = resource==null? null : resource.getResourceSet().getURIConverter();
			URI canonical = getCanonicalFileURI(resolve, converter);
			// TODO handle non-file URIs more generically
			if(canonical != null && (canonical.isFile() || canonical.isArchive() || canonical.isPlatform() || canonical.scheme() == "classpath")) {
				resolve = canonical.toString();
			}
			else {
				resolve = canonical.toFileString();
				if(resolve != null) {
					resolve = resolve.replaceAll("\\\\", "/");
					resolve = resolve.replaceAll("//", "/");
					
					resolve = URI.createFileURI(resolve).toString();
				}
			}
		} catch (IOException e) {
			return null;
		}
		
		return resolve;
	}
	
	private String resolve(String resolve, URI baseUri, Resource res) {
		resolve = substituteEnvVars(resolve);
		
		// replace (double) slashes and backslashes with single slashes
		resolve = resolve.replaceAll("\\\\", "/");
		resolve = resolve.replaceAll("//", "/");
		
		if (baseUri!=null) {
			resolve = resolveUriAgainstBase(resolve, baseUri, res);
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

	private String resolveUriAgainstBase(String resolve, URI baseUri, Resource res) {
		if (resolve==null || resolve.trim().isEmpty())
			return null;

		URI uri = URI.createURI(resolve);
		if (uri.isFile() && uri.hasRelativePath()) {
			// NOTE: deresolve (== reverse direction) is implemented in ui.RelativeFileURIHandler
			URI base = baseUri.trimSegments(1);
			if (base.isPlatformResource() && EMFPlugin.IS_ECLIPSE_RUNNING) {
				URI fileUri = resolveFileUriFromPlatformBase(uri, baseUri); // relative path ?-> baseFileURI => absolute file uri
				URI platUri = getPlatformURI(fileUri);						// absolute file uri => accessible platform uri
				if(platUri == null){
					// JH: Fix this here ? Why need we an URI mapping ? Room import does not support any logicals URIs ?
//					if(existsInFileSys(fileUri)){
//						// corresponding fileUri does exist in the file system,
//						// so try to create a mapping in URIMap
//						if (!updateURIMapEntry(res, platUri, fileUri))
//							return null;
//					}
					
					// room import is file based => can only return an fileURI here
					return fileUri.toString();	
				}
				else {
					// platUri exists in the workspace					
					removeURIMapEntry(res, platUri);
					return platUri.toString();
				}
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
		else if (uri.isPlatform()) {
			String platformResourcePath = uri.toPlatformString(true);
			
			// if workspace is not available, convert platform URI to absolute URI
			if (EcorePlugin.getWorkspaceRoot() == null) {
				URI resolvedURI = EcorePlugin.resolvePlatformResourcePath(platformResourcePath);
				if(resolvedURI != null)
					resolve = resolvedURI.toString();
			}
		}
		
		return resolve;
	}

	/**
	 * Removes an entry from the URIMap of the URIConverter associated with the
	 * given Resource.
	 * @param res
	 * @param platUri
	 */
	private void removeURIMapEntry(Resource res, URI platUri) {
		// map the absolute file uri to a platform resource path
		if(res == null) return;
		Map<URI, URI> uriMap = res.getResourceSet().getURIConverter()
				.getURIMap();
		if (uriMap.containsKey(platUri)) {
			uriMap.remove(platUri);
		}
	}

	/**
	 * Updates the URIMap in the ResourceSet of the given Resource res, so that
	 * platUri redirects to fileUri.
	 * 
	 * @param res
	 * @param platUri
	 * @param fileUri
	 * @return true if the update was successful or if the mapping already
	 *         exists, or false if platUri is mapped to a different URI
	 *         than fileUri.
	 */
	private boolean updateURIMapEntry(Resource res, URI platUri, URI fileUri) {
		// map the absolute file uri to a platform resource path
		if(res == null) return false;
		Map<URI, URI> uriMap = res.getResourceSet().getURIConverter()
				.getURIMap();
		if (uriMap.containsKey(platUri)) {
			if (!uriMap.get(platUri).equals(fileUri)) {
				return false;
			}
		} else {
			uriMap.put(platUri, fileUri);
		}
		return true;
	}

	/**
	 * Given a platform resource with URI baseUri and a target URI, resolves the
	 * target URI against the file location of baseUri. The baseUri is converted
	 * to a file URI according to the physical location given by the Eclipse
	 * workspace (see {@link getWorkspaceRoot})
	 * 
	 * @param target
	 *            The target URI to resolve
	 * @param baseUri
	 *            The base URI against which the target URI will be resolved.
	 *            Must be a platform URI and the resource at the URI must exist.
	 * @return a file URI of the target, resolved against the file location of
	 *         baseUri. Returns null if baseUri is not a platform URI or the
	 *         Eclipse WorkspaceRoot cannot be accessed.
	 */
	private URI resolveFileUriFromPlatformBase(URI target, URI baseUri) {
		if(!EMFPlugin.IS_ECLIPSE_RUNNING)
			return null;
		if (!baseUri.isPlatform())
			return null;
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (root == null)
			return null;
		IPath extBasePath = new Path(baseUri.toPlatformString(true));
		IFile extBaseFile = root.getFile(extBasePath);
		if(extBaseFile.getLocationURI() == null)
			return null;
		URI extBaseURI = URI.createFileURI(extBaseFile.getLocationURI().getPath());
		URI fileUri = target.resolve(extBaseURI, true);
		return fileUri;
	}

	/**
	 * Checks if the input URI points to an existing platform resource, in the
	 * Eclipse workspace root (see {@link getWorkspaceRoot}).
	 * 
	 * @param uri
	 *            The platform URI to check
	 * @return false if the URI does not point to an existing platform resource,
	 *         if the URI is not a platform URI, or if the Eclipse WorkspaceRoot
	 *         cannot be accessed. Otherwise true.
	 */
	private boolean existsInPlatform(URI uri) {
		if(!EMFPlugin.IS_ECLIPSE_RUNNING)
			return false;
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (root == null)
			return false;
		if (!uri.isPlatform())
			return false;
		try {
			IPath platPath = new Path(uri.toPlatformString(true));
			IFile platFile = root.getFile(platPath);
			return platFile.exists();
		} catch(IllegalArgumentException e) {
			return false;
		}
	}

	/**
	 * Checks if the input URI points to an existing file resource, using the
	 * Java file.io API.
	 * 
	 * @param uri
	 *            The file URI to check
	 * @return false if the URI does not point to an existing file resource or
	 *         if the URI is not a file URI. Otherwise true.
	 */
	private boolean existsInFileSys(URI uri) {
		if (!uri.isFile())
			return false;
		java.io.File extFile = new File(uri.toFileString());
		return (extFile.exists() && extFile.isFile());
	}
	
	private URI getCanonicalFileURI(String uriString, URIConverter uriConverter) throws IOException {
		URI uri = null;
		try {
			// try valid uri
			uri = URI.createURI(uriString);
		} catch(IllegalArgumentException e1) {
		}
		if(uri == null || !(uri.isFile() || uri.isArchive() || uri.isPlatform() || uri.scheme() == "classpath")) {
			// try file path
			uri = URI.createFileURI(uriString);
		}
		
		URI normalized = uri;
		if (uriConverter!=null) {
			try {
				normalized = uriConverter.normalize(uri);
			}
			catch (IllegalStateException e) {
				throw new IOException();
			}
			catch (ClasspathUriResolutionException e) {
				throw new IOException();
			}
		}
		
		if (normalized.isFile()) {
			String can = normalized.toFileString();
			File f = new File(can);
			
			// now we give the super class a chance to locate the model file
			f = locateFile(f);
			
			can = f.getCanonicalPath();	// e.g. remove embedded ../
			URI canonical = URI.createFileURI(can);
			return canonical;
		}
		
		return normalized;
	}

	protected File locateFile(File f) {
		return f;
	}
	
	/**
	 *  Returns a platformURI which underlying file is accessible.
	 *  Copied from GlobalNonPlatformURIEditorOpener
	 */
	public static URI getPlatformURI(URI uri) {
		if (uri.isPlatform())
			return uri;

		// HOWTO: find absolute path location in workspace (as platform URI)
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile[] files = root.findFilesForLocationURI(java.net.URI.create(uri.toString()));
		
		URI minLength = null;
		for (IFile file : files) {
			if (!file.isAccessible())	// avoid closed or other bad files
				continue;
			
			URI platURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true).appendFragment(uri.fragment());
			if(minLength == null || platURI.toString().length() < minLength.toString().length())
				minLength = platURI;
		}	

		return minLength;
	}

}
