/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.etrice.generator.ui.wizard;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
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
	protected IProject modellibProject;
	protected String initialProjectName;
	protected URI modelURI;
	protected RoomValidationHelper roomValidator;
	private EmptyProjectConfigPage config;
	
	private static final String[] additionalLaunchConfigLines = new String[] {
		"<stringAttribute key=\"org.eclipse.debug.core.ATTR_REFRESH_SCOPE\" value=\"${workspace}\"/>"
	};

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		setDefaultPageImageDescriptor(ProjectCreator.getImageDescriptor("icons/NewETriceProjectWizban.gif"));
		setWindowTitle("New Empty eTrice Project");

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		runtimeProject = workspace.getRoot().getProject("org.eclipse.etrice.runtime.java");
		modellibProject = workspace.getRoot().getProject("org.eclipse.etrice.modellib.java");
		
		roomValidator = RoomValidationHelper.createInstance();
	}

	@Override
	public void addPages() {
		WizardNewProjectCreationPage newProjectCreationPage = new WizardNewProjectCreationPage(
				"NewProjectCreationPage") {
			@Override
			protected boolean validatePage() {
				if (super.validatePage()) {
					
					String projectName = getProjectName();
					if(!roomValidator.isValidFQN(projectName))
						setMessage("RoomModel name will be invalid ("+roomValidator.getMessage()+")", WizardPage.WARNING);
					
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
		
		config = new EmptyProjectConfigPage("config", runtimeProject);
		config.setTitle("Project Configuration");
		config.setDescription("Choose a build type for the project");
		addPage(config);
	}
	
	@Override
	public boolean performFinish() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					List<IProject> referencedProjects = new ArrayList<IProject>();
					if (config.useJDTBuild()){
						if(runtimeProject != null)
							referencedProjects.add(runtimeProject);
						if(modellibProject != null)
							referencedProjects.add(modellibProject);
					}
					
					ArrayList<String> natures = new ArrayList<String>(ProjectCreator.getCommonNatureIDs());
					if (config.useMVNBuild())
						natures.add("org.eclipse.m2e.core.maven2Nature");

					ArrayList<String> builders = new ArrayList<String>(ProjectCreator.getCommonBuilderIDs());
					if (config.useMVNBuild())
						builders.add("org.eclipse.m2e.core.maven2Builder");
					
					ArrayList<IClasspathEntry> pathEntries = new ArrayList<IClasspathEntry>();
					if (config.useMVNBuild()) {
						IClasspathEntry mvnContainer = JavaCore.newContainerEntry(
								new Path("org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER"),
								new IAccessRule[] {},
								new IClasspathAttribute[] {JavaCore.newClasspathAttribute("maven.pomderived", "true")},
								false);
						pathEntries.add(mvnContainer);
					}
					
					URI modelProjectURI = (projectLocation==null) ? null : URI.createFileURI(projectLocation.toOSString());
					project = ProjectCreator.createETriceProject(
							new Path(sourcePath.toString()),
							new Path(sourceGenPath.toString()),
							modelProjectURI,
							referencedProjects,
							natures,
							builders,
							pathEntries,
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

//					URI physModelURI = URI.createPlatformResourceURI("/"
//							+ baseName
//							+ "/model/"+baseName+".etphys", true);
//					ProjectCreator.createPhysicalModel(physModelURI,
//							baseName);

					URI mapModelURI = URI.createPlatformResourceURI("/"
							+ baseName
							+ "/model/Mapping.etmap", true);
					ProjectCreator.createMappingModel(mapModelURI,
							baseName);
					
					ProjectCreator.createBuildProperties(URI.createPlatformResourceURI("/"
							+baseName+"/build.properties", true),
							baseName);

					ProjectCreator.createLaunchGeneratorConfig(URI.createPlatformResourceURI("/"
							+baseName+"/generate_"+baseName+".launch", true),
							"java",
							"/"+baseName+"/model",
							baseName,
							additionalLaunchConfigLines);

					ProjectCreator.createLaunchJavaApplicationConfig(URI.createPlatformResourceURI("/"
							+baseName+"/run_"+baseName+".launch", true),
							baseName,
							baseName,
							"Node_node_subSystemRefRunner");

					ProjectCreator.findOrCreateContainer(new Path("/"
							+ baseName + "/log"),
							true, projectLocation, progressMonitor);
					
					if (config.useMVNBuild()) {
						ProjectCreator.createMavenPOM(URI.createPlatformResourceURI("/"
								+baseName+"/pom.xml", true),
								baseName,
								baseName,
								"Node_node_subSystemRefRunner");
						ProjectCreator.createMavenBuilder(URI.createPlatformResourceURI("/"
								+baseName+"/build_"+baseName+".launch", true),
								baseName);
						ProjectCreator.createMavenLauncher(URI.createPlatformResourceURI("/"
								+baseName+"/runjar_"+baseName+".launch", true),
								baseName,
								baseName);
					}
					
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
