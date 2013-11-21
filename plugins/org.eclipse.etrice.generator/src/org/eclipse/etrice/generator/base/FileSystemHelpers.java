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

package org.eclipse.etrice.generator.base;

import java.io.File;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.util.RelativePathHelpers;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FileSystemHelpers extends RelativePathHelpers {

	/**
	 * calls {@link #getMarkerFileURI(EObject, String)} to determine the URI of the
	 * parent Eclipse project containing this object
	 * 
	 * @param obj an objected which should be located in a resource
	 * @return the URI of the Eclipse project
	 */
	public static URI getProjectURI(EObject obj) {
		return getMarkerFileURI(obj, ".project");
	}
	
	/**
	 * @param obj a model object
	 * @return <code>true</code> if the generation path is valid
	 */
	public boolean isValidGenerationLocation(EObject obj) {
		return getProjectURI(obj)!=null;
	}
	
	/**
	 * determines the URI of the first directory in the path of an object's resource
	 * which contains a file with a given name
	 * 
	 * @param obj an objected which should be located in a resource
	 * @param markerFileName name of marker file
	 * @return the URI of the first directory containing marker or <code>null</code> if not found
	 */
	public static URI getMarkerFileURI(EObject obj, String markerFileName) {
		URI mainPath = null;
		if (obj!=null && obj.eResource()!=null) {
			mainPath = obj.eResource().getURI().trimSegments(1);
			File parent = null;
			if (mainPath.isPlatform()) {
				// HOWTO: get absolute OS path suitable for java.io.File from platform scheme EMF URI
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				IFolder file = workspaceRoot.getFolder(new Path(mainPath.toPlatformString(true)));
				String osString = file.getLocation().toOSString();
				parent = new File(osString);
			}
			else {
				try {
				parent = new File(mainPath.toFileString()).getAbsoluteFile();
				mainPath = URI.createFileURI(parent.getAbsolutePath());
				}
				catch (Throwable e) {
					return null;
				}
			}
			
			boolean isProject = false;
			int nUp = 0;
			while (!isProject && parent!=null) {
				String[] contents = parent.list();
				for (int i = 0; i < contents.length; i++) {
					if (contents[i].equals(markerFileName)) {
						isProject = true;
						break;
					}
				}
				if (isProject)
					break;
				
				parent = parent.getParentFile();
				++nUp;
			}
			if (isProject && nUp>0)
				mainPath = mainPath.trimSegments(nUp);
		}
		return mainPath;
	}
	
}
