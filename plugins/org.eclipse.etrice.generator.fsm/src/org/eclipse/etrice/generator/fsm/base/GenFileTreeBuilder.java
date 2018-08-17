/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;

/**
 * A class that creates a tree structure from a list of file paths.
 * It allows to filter the paths before they enter the tree.
 * 
 * @author Henrik Rentz-Reichert
 */
public class GenFileTreeBuilder {
	
	private GenDir genFileTree;
	private IFileFilter filter; 
	
	/**
	 * @param uri a file URI as base path
	 * @param files a list of file paths
	 * @param filter an optional filter, may be <code>null</code>
	 */
	public GenFileTreeBuilder(String uri, Collection<String> files, IFileFilter filter) {
		this(getURI(uri), files, filter);
	}
	
	/**
	 * @param base a base URI which is subtracted from the beginning of the paths
	 * @param files a list of file paths
	 * @param filter an optional filter, may be <code>null</code>
	 */
	public GenFileTreeBuilder(URI base, Collection<String> files, IFileFilter filter) {
		this.filter = filter;
		ArrayList<String> relPaths = computeFilesAsRelativePaths(base, files);
		genFileTree = computeGenTree(relPaths);
	}
	
	/**
	 * @return the genTree composed of {@link GenItem}s
	 */
	public GenDir getGenFileTree() {
		return genFileTree;
	}
	
	private ArrayList<String> computeFilesAsRelativePaths(URI base, Collection<String> files) {
		ArrayList<String> relFiles = new ArrayList<String>(files.size());
		for (String file : files) {
			String relPath = FileSystemHelpers.getRelativePath(base, URI.createFileURI(file.replace("\\\\", "\\")));
			if (relPath!=null && (filter==null || filter.accept(relPath)))
				relFiles.add(relPath);
		}
		Collections.sort(relFiles);
		return relFiles;
	}

	private GenDir computeGenTree(ArrayList<String> relPaths) {
		GenDir root = new GenDir(null, "root");
		for (String path : relPaths) {
			String[] segments = path.split("/");
			GenDir dir = makeDir(root, segments);
			new GenFile(dir, segments[segments.length-1]);
		}
		return root;
	}
	
	private GenDir makeDir(GenDir current, String[] segments) {
		for (int i = 0; i < segments.length-1; i++) {
			GenDir next = null;
			for (GenItem item : current.getContents()) {
				if (item instanceof GenDir && item.getName().equals(segments[i])) {
					next = (GenDir) item;
					break;
				}
			}
			if (next==null) {
				next = new GenDir(current, segments[i]);
			}
			current = next;
		}
		return current;
	}

	private static URI getURI(String uri) {
		URI base = URI.createFileURI(uri);
		if (base.hasTrailingPathSeparator())
			base = base.trimSegments(1);
		return base;
	}

}
