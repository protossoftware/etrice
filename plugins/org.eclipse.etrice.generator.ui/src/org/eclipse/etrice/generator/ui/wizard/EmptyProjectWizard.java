/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.etrice.generator.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.ui.Activator;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.eclipse.ui.wizards.datatransfer.ZipFileStructureProvider;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * @author Henrik Rentz-Reichert (initial contribution and API)
 *
 */
public class EmptyProjectWizard extends Wizard implements INewWizard {

	final static String MODEL_NAME = "TemplateModel";
	final static String PROJECT_CONTENT_ZIP = "/content/org.eclipse.etrice.template.java.zip";
	
	final static String ROOM_EDITOR_ID = "org.eclipse.etrice.core.Room";
	final static String MODELLIB_WIZARD_ID = "org.eclipse.etrice.ui.runtime.NewJavaModelLibWizard";
	
	protected IWorkbench workbench;
	protected IPath projectLocation;
	protected IPath sourcePath;
	protected IPath sourceGenPath;
	protected IProject project;
	protected IProject runtimeProject;
	protected IProject modellibProject;
	protected String initialProjectName;
	private EmptyProjectConfigPage config;

	private static final String[] additionalLaunchConfigLines = new String[] { "<stringAttribute key=\"org.eclipse.debug.core.ATTR_REFRESH_SCOPE\" value=\"${workspace}\"/>" };

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		setDefaultPageImageDescriptor(ProjectCreator.getImageDescriptor("icons/NewETriceProjectWizban.gif"));
		setWindowTitle("eTrice Java Template Project");

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		runtimeProject = workspace.getRoot().getProject("org.eclipse.etrice.runtime.java");
		modellibProject = workspace.getRoot().getProject("org.eclipse.etrice.modellib.java");
	}

	@Override
	public void addPages() {
		WizardNewProjectCreationPage newProjectCreationPage = new WizardNewProjectCreationPage("NewProjectCreationPage") {
			@Override
			protected boolean validatePage() {
				if (super.validatePage()) {

					IPath locationPath = getLocationPath();
					projectLocation = Platform.getLocation().equals(locationPath) ? null : locationPath;
					IPath projectPath = getProjectHandle().getFullPath();
					sourcePath = projectPath.append("src");
					sourceGenPath = projectPath.append("src-gen");
					return true;
				}
				else {
					return false;
				}
			}
		};

		newProjectCreationPage.setInitialProjectName(initialProjectName);
		newProjectCreationPage.setTitle("Template eTrice Project");
		newProjectCreationPage.setDescription("Create the template Java project with eTrice dependencies");
		addPage(newProjectCreationPage);

		config = new EmptyProjectConfigPage("config");
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
					if (config.useJDTBuild()) {
						if (runtimeProject != null)
							referencedProjects.add(runtimeProject);
						if (modellibProject != null)
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
						IClasspathEntry mvnContainer = JavaCore
								.newContainerEntry(new Path("org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER"),
										new IAccessRule[] {}, new IClasspathAttribute[] { JavaCore
												.newClasspathAttribute("maven.pomderived", "true") }, false);
						pathEntries.add(mvnContainer);
					}

					URI modelProjectURI = (projectLocation == null) ? null : URI.createFileURI(projectLocation
							.toOSString());
					project = ProjectCreator.createETriceProject(new Path(sourcePath.toString()), new Path(
							sourceGenPath.toString()), modelProjectURI, referencedProjects, natures, builders,
							pathEntries, BasicMonitor.toMonitor(progressMonitor));

					String projectName = project.getName();
					URI projectURI = URI.createPlatformResourceURI(projectName, true);
					String modelName = MODEL_NAME;
					
					ProjectCreator.createBuildProperties(projectURI.appendSegment("build.properties"), modelName);

					ProjectCreator.createLaunchGeneratorConfig(projectURI.appendSegment("generate_Template.launch"),
							"java", "/" + projectName + "/model", "Mapping", AbstractGenerator.DEFAULT_MAIN_NAME, additionalLaunchConfigLines);

					ProjectCreator.createLaunchJavaApplicationConfig(projectURI.appendSegment("run_Template.launch"),
							projectName, MODEL_NAME, "Node_node_subSystemRefRunner");

					if (config.useMVNBuild()) {
						ProjectCreator.createMavenPOM(projectURI.appendSegment("pom.xml"), projectName, MODEL_NAME, "Node_node_subSystemRefRunner");
						ProjectCreator.createMavenBuilder(projectURI.appendSegment("build_" + modelName + ".launch"), projectName);
						ProjectCreator.createMavenLauncher(projectURI.appendSegment("runjar_" + modelName + ".launch"), projectName, MODEL_NAME);
					}
					
					importContent(project, progressMonitor);
				}
				catch (Exception e) {
					Logger.getLogger(getClass()).error(e.getMessage(), e);
				}
				finally {
					progressMonitor.done();
				}
			}
		};

		try {
			getContainer().run(false, false, operation);
		}
		catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			return false;
		}
		
		if (config.useJDTBuild())
			invokeLibraryWizard();

		IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IFile roomFile = project.getFile("/model/" + MODEL_NAME + ".room");
		if(roomFile != null && roomFile.exists()){
			BasicNewProjectResourceWizard.selectAndReveal(roomFile, activeWindow);
			try {
				activeWindow.getActivePage().openEditor(new FileEditorInput(roomFile), ROOM_EDITOR_ID, true, IWorkbenchPage.MATCH_ID);
			}
			catch (PartInitException e) {
			}
		}

		return true;
	}

	public void setInitialProjectName(String value) {
		initialProjectName = value;
	}

	private void invokeLibraryWizard() {
		if(runtimeProject != null && runtimeProject.exists() && modellibProject != null && modellibProject.exists())
			return;
		
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(MODELLIB_WIZARD_ID);
		if (descriptor == null)
			return;

		try {
			IWizard wizard = descriptor.createWizard();
			WizardDialog wd = new WizardDialog(getShell(), wizard);
			wd.setTitle(wizard.getWindowTitle());
			wd.open();	
		} catch (CoreException e) {
		}
	}
	
	protected static final IOverwriteQuery OVERWRITE_ALL_QUERY = new IOverwriteQuery() {
		public String queryOverwrite(String pathString) {
			return IOverwriteQuery.ALL;
		}
	};

	private void importContent(IProject project, IProgressMonitor progressMonitor) {
		java.net.URL contentURL = Activator.getInstance().getBundle().getEntry(PROJECT_CONTENT_ZIP);
		
		ZipFile zipFile = null;
		try {
			ImportOperation importOperation = null;
			java.net.URL resolvedURL = FileLocator.toFileURL(contentURL);
			// zip file is in jar, it gets temporary unpacked somehow
			// We need to use the 3-arg constructor of URI in order to properly escape file system chars
			java.net.URI resolvedURI = new java.net.URI(resolvedURL.getProtocol(), resolvedURL.getPath(), null);
			
			File file = new File(resolvedURI);
			if (file.isFile() && file.canRead()) {
				zipFile = new ZipFile(file);
				if (zipFile != null) {
					ZipFileStructureProvider structureProvider = new ZipFileStructureProvider(zipFile);
					importOperation = new ImportOperation(project.getFullPath(), structureProvider.getRoot(),
							structureProvider, OVERWRITE_ALL_QUERY);
				}
			}
			
			if(importOperation != null){
				importOperation.setContext(getShell());
				importOperation.run(SubMonitor.convert(progressMonitor, 1));
			}
		}
		catch (Exception e) {
			DiagnosticDialog.open(getShell(), "EmptyProjectWizardError", contentURL.toString(), BasicDiagnostic.toDiagnostic(e));
		}
		finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				}
				catch (IOException e) {
					DiagnosticDialog.open(getShell(), "EmptyProjectWizardError", "debug", BasicDiagnostic.toDiagnostic(e));
				}
			}
		}
	}
}
