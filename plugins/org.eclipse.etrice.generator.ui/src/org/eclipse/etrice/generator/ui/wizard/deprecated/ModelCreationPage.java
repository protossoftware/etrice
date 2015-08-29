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

package org.eclipse.etrice.generator.ui.wizard.deprecated;

import java.util.Iterator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.internal.ide.misc.ResourceAndContainerGroup;

/**
 * @author Henrik Rentz-Reichert
 *
 */
@SuppressWarnings("restriction")
public class ModelCreationPage extends WizardPage implements Listener {
	private static final int SIZING_CONTAINER_GROUP_HEIGHT = 250;

	protected RoomValidationHelper roomValidator;
	private ResourceAndContainerGroup resourceGroup;
	private IStructuredSelection selection;
	
	/**
	 * @param pageName
	 * @param selection
	 */
	public ModelCreationPage(String pageName, IStructuredSelection selection) {
		super(pageName);
		roomValidator = RoomValidationHelper.createInstance();
		
		this.selection = selection;
	}
	
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		// top level group
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout());
		topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
				| GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());
		
		// resource and container group
		resourceGroup = new ResourceAndContainerGroup(
				topLevel,
				this,
				"Base name for new models:",
				"file",
				false,
				SIZING_CONTAINER_GROUP_HEIGHT);
		initialPopulateContainerNameField();
		validatePage();
		
		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(topLevel);
	}
	
	protected void initialPopulateContainerNameField() {
		@SuppressWarnings("rawtypes")
		Iterator it = selection.iterator();
		if (it.hasNext()) {
			Object object = it.next();
			IResource selectedResource = null;
			if (object instanceof IResource) {
				selectedResource = (IResource) object;
			} else if (object instanceof IAdaptable) {
				selectedResource = (IResource) ((IAdaptable) object)
						.getAdapter(IResource.class);
			}
			if (selectedResource != null) {
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}
				if (selectedResource.isAccessible()) {
					resourceGroup.setContainerFullPath(selectedResource
							.getFullPath());
				}
			}
		}
	}

	/**
	 * Returns whether this page's controls currently all contain valid values.
	 * 
	 * @return <code>true</code> if all controls are valid, and
	 *         <code>false</code> if at least one is invalid
	 */
	protected boolean validatePage() {
		boolean valid = true;

		if (!resourceGroup.areAllValuesValid()) {
			// if blank name then fail silently
			if (resourceGroup.getProblemType() == ResourceAndContainerGroup.PROBLEM_RESOURCE_EMPTY
					|| resourceGroup.getProblemType() == ResourceAndContainerGroup.PROBLEM_CONTAINER_EMPTY) {
				setMessage(resourceGroup.getProblemMessage());
				setErrorMessage(null);
			} else {
				setErrorMessage(resourceGroup.getProblemMessage());
			}
			valid = false;
		}

		String resourceName = resourceGroup.getResource();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus result = workspace.validateName(resourceName, IResource.FILE);
		if (!result.isOK()) {
			setErrorMessage(result.getMessage());
			return false;
		}
		
		IPath folder = resourceGroup.getContainerFullPath();
		IPath file = folder.append(resourceName).addFileExtension("etmap");
		if (workspace.getRoot().exists(file)) {
			setErrorMessage("file '"+file+"' already exists in the workspace");
			return false;
		}
		file = folder.append(resourceName).addFileExtension("etphys");
		if (workspace.getRoot().exists(file)) {
			setErrorMessage("file '"+file+"' already exists in the workspace");
			return false;
		}
		file = folder.append(resourceName).addFileExtension("room");
		if (workspace.getRoot().exists(file)) {
			setErrorMessage("file '"+file+"' already exists in the workspace");
			return false;
		}
		if(!roomValidator.isValidFQN(getBaseName())){
			setErrorMessage("Invalid roomModel name ("+roomValidator.getMessage()+")");
			return false;
		}
		if (valid) {
			setErrorMessage(null);
			setMessage(null);
		}
		
		return valid;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	@Override
	public void handleEvent(Event event) {
		setPageComplete(validatePage());
	}

	public IPath getPath() {
		return resourceGroup.getContainerFullPath();
	}
	
	public String getBaseName() {
		return resourceGroup.getResource();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			resourceGroup.setFocus();
		}
	}
}
