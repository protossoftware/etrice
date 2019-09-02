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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.settings.model.CIncludePathEntry;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICSettingEntry;
import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.generator.ui.wizard.ProjectCreator;
import org.eclipse.etrice.generator.ui.wizard.WizardHelpers;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.eclipse.ui.wizards.datatransfer.ZipFileStructureProvider;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CProjectConfigurator extends ProjectConfigurator {

	private static final String C_MODELLIB_FOLDER_NAME = "etrice_modellib";
	private static final String C_RUNTIME_FOLDER_NAME = "etrice_runtime";

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
	public boolean isIncludePathId(String id) {
		if (id.startsWith("cdt.managedbuild.tool.gnu.c.compiler"))
			return true;;
		if (id.startsWith("org.eclipse.cdt.msvc.cl.inputType.c"))
			return true;
		if (id.startsWith("cdt.managedbuild.tool.gnu.c.compiler.input"))
			return true;
		if (id.startsWith("com.ifx.xmc1000.compiler.option.include.paths"))
			return true;
		if (id.startsWith("com.ifx.xmc1000.cppcompiler.option.include.paths"))
			return true;
		if (id.startsWith("com.ifx.xmc4000.compiler.option.include.paths"))
			return true;
		if (id.startsWith("com.ifx.xmc4000.cppcompiler.option.include.paths"))
			return true;
		if (id.startsWith("org.eclipse.cdt.cross.arm.gnu.sourcery.windows.c.compiler.base.input"))
			return true;
		if (id.startsWith("org.eclipse.cdt.cross.arm.gnu.sourcery.linux.c.compiler.base.input"))
			return true;
		
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#getIncludePaths()
	 */
	@Override
	public List<CIncludePathEntry> getIncludePaths() {
		List<CIncludePathEntry> srcIncludes = new ArrayList<CIncludePathEntry>();
		srcIncludes.add(new CIncludePathEntry("${workspace_loc:/${ProjName}/src-gen}", ICSettingEntry.LOCAL));
		if (isCopyRuntime()) {
			srcIncludes.add(new CIncludePathEntry("${workspace_loc:/${ProjName}/"+C_RUNTIME_FOLDER_NAME+"/src/common}", ICSettingEntry.LOCAL));
			srcIncludes.add(new CIncludePathEntry("${workspace_loc:/${ProjName}/"+C_RUNTIME_FOLDER_NAME+"/src/config}", ICSettingEntry.LOCAL));
			srcIncludes.add(new CIncludePathEntry("${workspace_loc:/${ProjName}/"+C_RUNTIME_FOLDER_NAME+"/src/util}", ICSettingEntry.LOCAL));
			srcIncludes.add(new CIncludePathEntry("${workspace_loc:/${ProjName}/"+C_RUNTIME_FOLDER_NAME+"/src/platforms/"+getPlatform()+"}", ICSettingEntry.LOCAL));
		}
		return srcIncludes;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#getProjectRefInfo()
	 */
	@Override
	public Map<String, String> getProjectRefInfo(ICConfigurationDescription configDescription, String toolChain) {
		Map<String, String> projectRefInfo = configDescription.getReferenceInfo();
		
		// need to configure these dependencies only if we don't copy the runtime
		if (!isCopyRuntime()) {
			if (toolChain == MINGW_TOOLCHAIN) {
				projectRefInfo.put("org.eclipse.etrice.runtime.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.1978608919");
				projectRefInfo.put("org.eclipse.etrice.modellib.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.847049798");
			}
			else if (toolChain == POSIX_TOOLCHAIN) {
				projectRefInfo.put("org.eclipse.etrice.runtime.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.1978608919.294295052");
				projectRefInfo.put("org.eclipse.etrice.modellib.c", "cdt.managedbuild.config.gnu.mingw.lib.debug.847049798.58778989");
			}
		}
		
		return projectRefInfo;
	}

	protected static final IOverwriteQuery OVERWRITE_ALL_QUERY = new IOverwriteQuery() {
		public String queryOverwrite(String pathString) {
			return IOverwriteQuery.ALL;
		}
	};
	
	@Override
	protected void configureModelpath(IProject project, IPath path) {
		if(!project.getFile("modelpath").exists()) {
			List<String> srcDirs = new ArrayList<>();
			IPath dir = path.removeFirstSegments(1);
			if(!dir.isEmpty()) {
				srcDirs.add(dir.toPortableString());
			}
			if(isCopyRuntime()) {
				srcDirs.add(C_MODELLIB_FOLDER_NAME + "/model");
			}
			URI modelpathURI = URI.createPlatformResourceURI(project.getFullPath().append("modelpath").toPortableString(), false);
			ProjectCreator.createModelpathDescription(modelpathURI,	srcDirs, Collections.emptyList());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#copyRuntime(org
	 * .eclipse.core.resources.IProject,
	 * org.eclipse.core.runtime.IProgressMonitor, java.lang.String)
	 */
	@Override
	public void copyRuntime(IProject project, IProgressMonitor progressMonitor, String platform) {
		copyCRuntime(project, progressMonitor);
		copyCModellib(project, progressMonitor);
	}

	/**
	 * @param project
	 * @param progressMonitor
	 */
	private void copyCRuntime(IProject project, IProgressMonitor progressMonitor) {
		ImportOperation importOperation = null;
		ZipFile zipFile = null;
		try {
			zipFile = WizardHelpers.getCRuntimeZip();
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
							project.getFullPath().append(C_RUNTIME_FOLDER_NAME),
							current,
							structureProvider,
							OVERWRITE_ALL_QUERY);
				}
			}

			if (importOperation != null) {
				importOperation.setContext(null);
				importOperation.run(SubMonitor.convert(progressMonitor, 1));
				
				IFolder folder = project.getFolder(C_RUNTIME_FOLDER_NAME);
				folder = folder.getFolder("src");
				folder = folder.getFolder("platforms");
				for (IResource platform : folder.members()) {
					if (platform.getType()==IResource.FOLDER && !platform.getName().equals(getPlatform())) {
						removeUnusedPlatform(platform, progressMonitor);
					}
				}
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

	/**
	 * @param platform
	 */
	private void removeUnusedPlatform(final IResource platform, IProgressMonitor progressMonitor) {
        
        ISchedulingRule rule = ResourcesPlugin.getWorkspace().getRuleFactory().createRule(platform);
        WorkspaceModifyOperation operation = new WorkspaceModifyOperation(rule) {

            @Override
            protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {

            	platform.delete(true, monitor);
            }

        };

        try {
        	operation.run(progressMonitor);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	/**
	 * @param project
	 * @param progressMonitor
	 */
	private void copyCModellib(IProject project, IProgressMonitor progressMonitor) {
		ZipFile zipFile = null;
		try {
			zipFile = WizardHelpers.getCModellibZip();
			if (zipFile != null) {
				ZipFileStructureProvider structureProvider = new ZipFileStructureProvider(zipFile);
				List<?> children = structureProvider.getChildren(structureProvider.getRoot());
				ZipEntry current = null;
				for (Object child : children) {
					if (child instanceof ZipEntry) {
						if (((ZipEntry) child).getName().equals("model/")) {
							current = (ZipEntry) child;
							break;
						}
					}
				}
				if (current!=null) {
					children = structureProvider.getChildren(current);
					for (Object child : children) {
						if (child instanceof ZipEntry) {
							ImportOperation importOperation = new ImportOperation(
									project.getFullPath().append(C_MODELLIB_FOLDER_NAME),
									child,
									structureProvider,
									OVERWRITE_ALL_QUERY);
							importOperation.setContext(null);
							importOperation.run(SubMonitor.convert(progressMonitor, 1));
						}
					}
				}
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

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.ui.cdt.ProjectConfigurator#customizeBuildConfig(org.eclipse.cdt.managedbuilder.core.IConfiguration)
	 */
	@Override
	protected void customizeBuildConfig(IProject project, IConfiguration buildConfig) {
		// this is not needed since we remove unused platforms from the file system
//		if (isCopyRuntime()) {
//			IFolder folder = project.getFolder(C_RUNTIME_FOLDER_NAME);
//			folder = folder.getFolder("src");
//			folder = folder.getFolder("platforms");
//			try {
//				// exclude from the build if this is a folder and not the selected platform
//				for (IResource member : folder.members()) {
//					if (member.getType()==IResource.FOLDER && !member.getName().equals(getPlatform())) {
//						IPath path = member.getProjectRelativePath();
//						IFolderInfo folderInfo = buildConfig.createFolderInfo(path);
//						if (folderInfo!=null) {
//							folderInfo.setExclude(true);
//						}
//					}
//				}
//			}
//			catch (CoreException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
