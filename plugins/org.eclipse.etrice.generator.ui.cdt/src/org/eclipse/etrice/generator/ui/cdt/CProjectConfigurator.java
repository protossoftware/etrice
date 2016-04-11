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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.settings.model.CIncludePathEntry;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICSettingEntry;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.etrice.generator.ui.wizard.WizardHelpers;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.eclipse.ui.wizards.datatransfer.ZipFileStructureProvider;

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

	protected static final IOverwriteQuery OVERWRITE_ALL_QUERY = new IOverwriteQuery() {
		public String queryOverwrite(String pathString) {
			return IOverwriteQuery.ALL;
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#copyRuntime(org
	 * .eclipse.core.resources.IProject,
	 * org.eclipse.core.runtime.IProgressMonitor, java.lang.String)
	 */
	@Override
	public void copyRuntime(IProject project, IProgressMonitor progressMonitor,
			String platform) {
		ImportOperation importOperation = null;
		ZipFile zipFile = null;
		try {
			zipFile = WizardHelpers.getRuntimeZip();
			if (zipFile != null) {
				ZipFileStructureProvider structureProvider = new ZipFileStructureProvider(zipFile);
				List<?> children = structureProvider.getChildren(structureProvider.getRoot());
				ZipEntry current = null;
				for (Object child : children) {
					if (child instanceof ZipEntry) {
						if (((ZipEntry) child).getName().equals("src/")) {
							current = (ZipEntry) child;
							break;
						}
					}
				}
				if (current!=null) {
					importOperation = new ImportOperation(
							project.getFullPath().append("c-runtime-src"),
							current,
							structureProvider,
							OVERWRITE_ALL_QUERY);
				}
			}

			if (importOperation != null) {
				importOperation.setContext(null);
				importOperation.run(new SubProgressMonitor(progressMonitor, 1));
			}
			else {
				throw new Exception("File error during runtime import");
			}
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				} catch (IOException e) {
					// Ignore.
				}
			}
		}
	}

	protected ZipFile createZipFile(File file) {
		try {
			return new ZipFile(file);
		} catch (ZipException e) {
			// Ignore
		} catch (IOException e) {
			// Ignore
		}
		return null;
	}
}
