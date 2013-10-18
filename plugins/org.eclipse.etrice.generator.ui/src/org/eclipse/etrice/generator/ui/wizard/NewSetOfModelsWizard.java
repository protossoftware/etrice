/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
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
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class NewSetOfModelsWizard extends Wizard implements INewWizard {
	
	private static final String[] additionalLaunchConfigLines = new String[] {
		"<stringAttribute key=\"org.eclipse.debug.core.ATTR_REFRESH_SCOPE\" value=\"${workspace}\"/>"
	};

	private IWorkbench workbench;
	private IStructuredSelection selection;
	private ModelCreationPage page;
	private URI modelURI = null;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		
		setDefaultPageImageDescriptor(ProjectCreator.getImageDescriptor("icons/NewETriceProjectWizban.gif"));
		setWindowTitle("Create new set of eTrice models");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		page = new ModelCreationPage("Create new set of models", selection);
		page.setTitle("Create a new set of eTrice models");
		addPage(page);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					String baseName = page.getBaseName();
					IPath file = page.getPath().append(baseName).addFileExtension("room");
					modelURI = URI.createPlatformResourceURI(file.toString(), true);
					ProjectCreator.createModel(modelURI, baseName);

					file = page.getPath().append(baseName).addFileExtension("etphys");
					URI physModelURI = URI.createPlatformResourceURI(file.toString(), true);
					ProjectCreator.createPhysicalModel(physModelURI, baseName);

					file = page.getPath().append(baseName).addFileExtension("etmap");
					URI mapModelURI = URI.createPlatformResourceURI(file.toString(), true);
					ProjectCreator.createMappingModel(mapModelURI, baseName);
					
					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					IProject project = (page.getPath().segmentCount()==1)?
							workspace.getRoot().getProject(page.getPath().lastSegment())
							: workspace.getRoot().getFolder(page.getPath()).getProject();
					
					ProjectCreator.createRunAndLaunchConfigurations(baseName, project, page.getPath().toString(), additionalLaunchConfigLines);
					ProjectCreator.addIncludePathsAndLibraries(project);
					ProjectCreator.addXtextNature(project, progressMonitor);
					
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

		if (modelURI != null) {
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

}
