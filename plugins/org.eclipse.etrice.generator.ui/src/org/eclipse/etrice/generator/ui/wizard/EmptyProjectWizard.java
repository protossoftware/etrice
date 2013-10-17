/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.etrice.generator.ui.wizard;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * @author Henrik Rentz-Reichert (initial contribution and API)
 *
 */
public class EmptyProjectWizard extends Wizard implements INewWizard {
	protected IWorkbench workbench;
	protected IPath projectLocation;
	protected IPath sourcePath;
	protected IPath sourceGenPath;
	protected IProject project;
	protected IProject runtimeProject;
	protected String initialProjectName;
	protected URI modelURI;
	
	private static final String[] additionalLaunchConfigLines = new String[] {
		"<stringAttribute key=\"org.eclipse.debug.core.ATTR_REFRESH_SCOPE\" value=\"${workspace}\"/>"
	};

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		setDefaultPageImageDescriptor(ProjectCreator.getImageDescriptor("icons/NewETriceProjectWizban.gif"));
		setWindowTitle("New Empty eTrice Project");

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		runtimeProject = workspace.getRoot().getProject("org.eclipse.etrice.runtime.java");
	}

	@Override
	public void addPages() {
		WizardNewProjectCreationPage newProjectCreationPage = new WizardNewProjectCreationPage(
				"NewProjectCreationPage") {
			@Override
			protected boolean validatePage() {
				if (super.validatePage()) {
					if (runtimeProject==null || !runtimeProject.exists()) {
						setErrorMessage("the project 'org.eclipse.etrice.runtime.java' must be in the workspace");
						return false;
					}
					IPath locationPath = getLocationPath();
					projectLocation = Platform.getLocation().equals(
							locationPath) ? null : locationPath;
					IPath projectPath = getProjectHandle().getFullPath();
					sourcePath = projectPath.append("src");
					sourceGenPath = projectPath.append("src-gen");
					return true;
				} else {
					return false;
				}
			}
		};

		newProjectCreationPage.setInitialProjectName(initialProjectName);
		newProjectCreationPage.setTitle("Empty eTrice Project");
		newProjectCreationPage
				.setDescription("Create an empty Java project with eTrice dependencies");
		addPage(newProjectCreationPage);
	}
	
	@Override
	public boolean performFinish() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					URI modelProjectURI = (projectLocation==null) ? null : URI.createFileURI(projectLocation.toOSString());
					project = ProjectCreator.createETriceProject(
							new Path(sourcePath.toString()),
							new Path(sourceGenPath.toString()),
							modelProjectURI,
							runtimeProject,
							ProjectCreator.getCommonNatureIDs(),
							ProjectCreator.getCommonBuilderIDs(),
							BasicMonitor.toMonitor(progressMonitor)
						);

					String baseName = sourcePath.segment(0);
					ProjectCreator.findOrCreateContainer(new Path("/"
							+ baseName + "/model"),
							true, projectLocation, progressMonitor);
					modelURI = URI.createPlatformResourceURI("/"
							+ baseName
							+ "/model/"+baseName+".room", true);
					ProjectCreator.createModel(modelURI,
							baseName);

					URI physModelURI = URI.createPlatformResourceURI("/"
							+ baseName
							+ "/model/"+baseName+".etphys", true);
					ProjectCreator.createPhysicalModel(physModelURI,
							baseName);

					URI mapModelURI = URI.createPlatformResourceURI("/"
							+ baseName
							+ "/model/"+baseName+".etmap", true);
					ProjectCreator.createMappingModel(mapModelURI,
							baseName);
					
					ProjectCreator.createBuildProperties(URI.createPlatformResourceURI("/"
							+baseName+"/build.properties", true),
							baseName);

					ProjectCreator.createLaunchGeneratorConfig(URI.createPlatformResourceURI("/"
							+baseName+"/gen_"+baseName+".launch", true),
							"java",
							"/"+baseName+"/model",
							baseName,
							additionalLaunchConfigLines);

					ProjectCreator.createLaunchJavaApplicationConfig(URI.createPlatformResourceURI("/"
							+baseName+"/run_"+baseName+".launch", true),
							baseName,
							baseName,
							"Node_nodeRef1_subSysRef1Runner");

					ProjectCreator.findOrCreateContainer(new Path("/"
							+ baseName + "/tmp/log"),
							true, projectLocation, progressMonitor);
					
				} catch (Exception e) {
					Logger.getLogger(getClass()).error(e.getMessage(), e);
				} finally {
					progressMonitor.done();
				}
			}
		};

		try {
			getContainer().run(false, false, operation);
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			return false;
		}

		if (project != null) {
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
					.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				IFile model = workspaceRoot.getFile(new Path(modelURI.toPlatformString(true)));
				final ISelection targetSelection = new StructuredSelection(model);
				final IFileEditorInput input = new FileEditorInput(model);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget) activePart)
								.selectReveal(targetSelection);
						try {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, "org.eclipse.etrice.core.Room");
						} catch (PartInitException e) {
						}
					}
				});
			}
		}

		return true;
	}

	public void setInitialProjectName(String value) {
		initialProjectName = value;
	}
}
