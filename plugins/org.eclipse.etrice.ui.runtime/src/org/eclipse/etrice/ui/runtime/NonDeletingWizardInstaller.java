/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.runtime;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.common.ui.wizard.ExampleInstallerWizard;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

public class NonDeletingWizardInstaller extends ExampleInstallerWizard {

	protected boolean isPerformingFinish = false;

	@Override
	protected Diagnostic deleteExistingProjects(IProgressMonitor monitor) {
		return Diagnostic.OK_INSTANCE;
	}

	@Override
	public boolean performFinish() {
		isPerformingFinish = true;
		return super.performFinish();
	}
	
	@Override
	protected void openFiles(IProgressMonitor progressMonitor) {
		super.openFiles(progressMonitor);
		
		BasicNewProjectResourceWizard.updatePerspective(wizardConfigurationElement);
		if (getFilesToOpen().size() == 1)
			BasicNewProjectResourceWizard.selectAndReveal(getFilesToOpen().get(0).getWorkspaceFile(),
					getWorkbench().getActiveWorkbenchWindow());
	}

	@Override
	protected List<ProjectDescriptor> getProjectDescriptors() {
		if (!isPerformingFinish)
			return super.getProjectDescriptors();

		List<ProjectDescriptor> newProjects = new ArrayList<ProjectDescriptor>();
		for (ProjectDescriptor desc : super.getProjectDescriptors())
			if (!desc.getProject().exists())
				newProjects.add(desc);

		return newProjects;
	}

	@Override
	public void addPages() {
		projectPage = new CustomProjectPage("projectPage", CommonUIPlugin.INSTANCE.getString("_UI_ProjectPage_title"),
				null);
		projectPage.setDescription(CommonUIPlugin.INSTANCE.getString("_UI_ProjectPage_description"));
		addPage(projectPage);
	}

	class CustomProjectPage extends ProjectPage {

		public CustomProjectPage(String pageName, String title, ImageDescriptor titleImage) {
			super(pageName, title, titleImage);
		}

		@Override
		protected void itemSelected() {
			renameButton.setEnabled(false);

			ProjectDescriptor projectDescriptor = getSelectedProjectDescriptor();
			if (projectDescriptor != null) {
				boolean exists = projectDescriptor.getProject().exists();
				String description = projectDescriptor.getDescription() != null ? projectDescriptor.getDescription()
						: "";
				if (exists) {
					String renameMessage = "* A project with this name already exists in the workspace and will not be added.";
					description = description == "" ? renameMessage : CommonUIPlugin.INSTANCE.getString(
							"_UI_ProjectDescriptionAndRename_message", new String[] { description, renameMessage });
				}
				descriptionText.setText(description);
			}
		}

	}
}
