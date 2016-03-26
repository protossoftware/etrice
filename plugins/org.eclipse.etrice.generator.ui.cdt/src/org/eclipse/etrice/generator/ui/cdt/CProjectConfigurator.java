/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CProjectConfigurator extends ProjectConfigurator {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#isApplicable(org.eclipse.core.resources.IProject)
	 */
	@Override
	public boolean isApplicable(IProject project) {
		return CoreModel.hasCNature(project) && !CoreModel.hasCCNature(project);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#getCompilerId()
	 */
	@Override
	public String getCompilerId() {
		return "cdt.managedbuild.tool.gnu.c.compiler";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#getIncludePaths()
	 */
	@Override
	public List<CIncludePathEntry> getIncludePaths() {
		List<CIncludePathEntry> srcIncludes = new ArrayList<CIncludePathEntry>();
		srcIncludes.add(new CIncludePathEntry("/${ProjName}/src-gen", ICSettingEntry.LOCAL));
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
			projectRefInfo.put("org.eclipse.etrice.modellib.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.847049798");
		}
		else if (toolChain == POSIX_TOOLCHAIN) {
			projectRefInfo.put("org.eclipse.etrice.runtime.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.1978608919.294295052");
			projectRefInfo.put("org.eclipse.etrice.modellib.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.847049798.58778989");
		}
		return projectRefInfo;
	}

}
