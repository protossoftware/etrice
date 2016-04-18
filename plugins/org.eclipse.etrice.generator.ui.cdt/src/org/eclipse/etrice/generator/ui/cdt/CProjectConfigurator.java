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
import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.cdt.managedbuilder.core.IFolderInfo;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
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

	private static final String C_MODELLIB_NAME = "etrice-c-modellib";
	private static final String C_RUNTIME_FOLDER_NAME = "etrice-c-runtime";

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
					IPath modelFolderPath = getPath();
					for (Object child : children) {
						if (child instanceof ZipEntry) {
							if (! ((ZipEntry) child).isDirectory()) {
								ImportOperation importOperation = new ImportOperation(
										modelFolderPath,
										child,
										structureProvider,
										OVERWRITE_ALL_QUERY);
								importOperation.setContext(null);
								importOperation.run(new SubProgressMonitor(progressMonitor, 1));
							}
						}
					}
			        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			        final IContainer modelFolder = root.getFolder(modelFolderPath.append("model"));
			        final IPath newPath = modelFolder.getFullPath().removeLastSegments(1).append(C_MODELLIB_NAME);
			        
			        ISchedulingRule rule = ResourcesPlugin.getWorkspace().getRuleFactory().createRule(modelFolder);
			        WorkspaceModifyOperation operation = new WorkspaceModifyOperation(rule) {

			            @Override
			            protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {

			                modelFolder.move(newPath, true, monitor);
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
		if (isCopyRuntime()) {
			IFolder folder = project.getFolder(C_RUNTIME_FOLDER_NAME);
			folder = folder.getFolder("src");
			folder = folder.getFolder("platforms");
			try {
				// exclude from the build if this is a folder and not the selected platform
				for (IResource member : folder.members()) {
					if (member.getType()==IResource.FOLDER && !member.getName().equals(getPlatform())) {
						IPath path = member.getProjectRelativePath();
						IFolderInfo folderInfo = buildConfig.createFolderInfo(path);
						if (folderInfo!=null) {
							folderInfo.setExclude(true);
						}
					}
				}
			}
			catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
}
