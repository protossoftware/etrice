/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.room.util;

import org.eclipse.emf.common.util.URI;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RelativePathHelpers {
	
	private static boolean bothNullOrEqual(String s1, String s2) {
		if (s1==null && s2==null)
			return true;
		if (s1==null || s2==null)
			return false;
		return s1.equals(s2);
	}

	/**
	 * the given paths are converted to file URIs (using {@link URI#createFileURI(String)}
	 * and then {@link #getRelativePath(URI, URI, boolean)} is called with <code>goUpIfNeeded=false</code>.
	 * 
	 * @param base the base path
	 * @param path the path for which the relative path is computed
	 * @return relative path (<code>null</code>if there is none)
	 */
	public static String getRelativePath(String base, String path) {
		return getRelativePath(URI.createFileURI(base), URI.createFileURI(path), false);
	}

	/**
	 * the given paths are converted to file URIs (using {@link URI#createFileURI(String)}
	 * and then {@link #getRelativePath(URI, URI, boolean)} is called.
	 * 
	 * @param base the base path
	 * @param path the path for which the relative path is computed
	 * @param goUpIfNeeded allow also ascending to parent directories
	 * @return relative path (<code>null</code>if there is none)
	 */
	public static String getRelativePath(String base, String path, boolean goUpIfNeeded) {
		return getRelativePath(URI.createFileURI(base), URI.createFileURI(path), goUpIfNeeded);
	}
	
	/**
	 * {@link #getRelativePath(URI, URI, boolean)} is called with
	 * <code>goUpIfNeeded=false</code>
	 * 
	 * @param base the base path
	 * @param path the path for which the relative path is computed
	 * @return relative path (<code>null</code>if there is none)
	 */
	public static String getRelativePath(URI base, URI path) {
		return getRelativePath(base, path, false);
	}
	
	/**
	 * compute a relative path to a given base path.
	 * Both paths must be of the same scheme and absolute and the given
	 * path has to have the first segments identical with the base path.
	 * Returned is a relative path separated by / characters.
	 * If there is no such relative path <code>null</code> is returned.
	 * 
	 * @param base the base path
	 * @param path the path for which the relative path is computed
	 * @param goUpIfNeeded allow also ascending to parent directories
	 * @return relative path (<code>null</code>if there is none)
	 */
	public static String getRelativePath(URI base, URI path, boolean goUpIfNeeded) {
		if (base==null || path==null)
			return null;
		
		if (!bothNullOrEqual(base.scheme(),path.scheme()))
			return null;
		
		if (!base.hasAbsolutePath())
			return null;
		
		if (!path.hasAbsolutePath())
			return null;
		
		if (!bothNullOrEqual(path.device(), base.device()))
			return null;
		
		StringBuffer result = new StringBuffer();
		if (goUpIfNeeded) {
			int max = base.segmentCount()<path.segmentCount()? base.segmentCount():path.segmentCount();
			int common;
			for (common=0; common<max; ++common) {
				if (!base.segment(common).equals(path.segment(common)))
					break;
			}
			for (int i=common; i<base.segmentCount(); ++i) {
				result.append("../");
			}
			for (int i=common; i<path.segmentCount(); ++i) {
				result.append(path.segment(i)+"/");
			}
			
			if (result.length()==0)
				return "";
			
			return result.substring(0, result.length()-1);
		}
		else {
			if (path.segmentCount()<base.segmentCount())
				return null;
			
			for (int i=0; i<base.segmentCount(); ++i) {
				if (!base.segment(i).equals(path.segment(i)))
					return null;
			}
			
			for (int i=base.segmentCount(); i<path.segmentCount(); ++i) {
				result.append(path.segment(i)+"/");
			}

			if(result.length()==0)
				return "";
			
			return result.substring(0, result.length()-1);
		}
	}
}
