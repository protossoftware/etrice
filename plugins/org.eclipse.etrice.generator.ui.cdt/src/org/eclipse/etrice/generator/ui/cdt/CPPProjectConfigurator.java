/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		hrentz (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.cdt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.settings.model.CIncludePathEntry;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICSettingEntry;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CPPProjectConfigurator extends CProjectConfigurator {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#isApplicable(org.eclipse.core.resources.IProject)
	 */
	@Override
	public boolean isApplicable(IProject project) {
		return CoreModel.hasCCNature(project);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#getCompilerId()
	 */
	@Override
	public boolean isIncludePathId(String id) {
		// NOTE: for some reason the "${workspace_loc:/${ProjName}/src-gen}" include path has to be added for the C compiler!
		return super.isIncludePathId(id);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#getIncludePaths()
	 */
	@Override
	public List<CIncludePathEntry> getIncludePaths() {
		List<CIncludePathEntry> srcIncludes = new ArrayList<CIncludePathEntry>();
		srcIncludes.add(new CIncludePathEntry("${workspace_loc:/${ProjName}/src-gen}", ICSettingEntry.LOCAL));
		return srcIncludes;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#getProjectRefInfo()
	 */
	@Override
	public Map<String, String> getProjectRefInfo(ICConfigurationDescription configDescription, String toolChain) {
		Map<String, String> projectRefInfo = configDescription.getReferenceInfo();
		if (toolChain == MINGW_TOOLCHAIN) {
			projectRefInfo.put("org.eclipse.etrice.runtime.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.1978608919");
			projectRefInfo.put("org.eclipse.etrice.runtime.cpp", "cdt.managedbuild.config.gnu.mingw.lib.debug.878140176");
			projectRefInfo.put("org.eclipse.etrice.modellib.cpp", "cdt.managedbuild.config.gnu.mingw.lib.debug.44153035");
		}
		else if (toolChain == POSIX_TOOLCHAIN) {
			projectRefInfo.put("org.eclipse.etrice.runtime.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.1978608919.294295052");
			projectRefInfo.put("org.eclipse.etrice.modellib.cpp", "cdt.managedbuild.config.gnu.mingw.lib.debug.44153035.551809464");
			projectRefInfo.put("org.eclipse.etrice.runtime.cpp", "cdt.managedbuild.config.gnu.mingw.lib.debug.878140176.190433079");
		}
		return projectRefInfo;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#copyRuntime(org.eclipse.core.resources.IProject, org.eclipse.core.runtime.IProgressMonitor, java.lang.String)
	 */
	@Override
	public void copyRuntime(IProject project, IProgressMonitor progressMonitor,
			String platform) {
		// TODO Auto-generated method stub
		
	}

}
