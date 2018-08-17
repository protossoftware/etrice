/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard.deprecated;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.ide.misc.ContainerSelectionGroup;

@SuppressWarnings("restriction")
public class SaveMappingPage extends WizardPage implements Listener, ModifyListener {

	private ContainerSelectionGroup containerGroup;
	private Text physText;
	private Text mapText;

	private IFile mappingModelPath = null;
	private IFile physModelPath = null;

	public SaveMappingPage() {
		super("save_mapping_page");
	}
	
	public IFile getMappingFilePath(){
		return mappingModelPath;
	}

	public IFile getPhysModelPath(){
		return physModelPath;
	}
	
	@Override
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		// - top level composite
		Composite topLevel = new Composite(parent, SWT.NONE);
		GridLayout gl_topLevel = new GridLayout();
		gl_topLevel.marginHeight = 0;
		topLevel.setLayout(gl_topLevel);
		topLevel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		topLevel.setFont(parent.getFont());

		// 1. resource and container group
		containerGroup = new ContainerSelectionGroup(topLevel, this, false, null, false);
		containerGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// 2. file naming
		Composite namingComp = new Composite(topLevel, SWT.NONE);
		namingComp.setLayoutData(new GridData(SWT.FILL, SWT.END, true, false));
		namingComp.setLayout(new GridLayout(3, false));

		{
			Label label = new Label(namingComp, SWT.NONE);
			label.setText("etMap file name: ");

			mapText = new Text(namingComp, SWT.BORDER);
			mapText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			mapText.addModifyListener(this);
			Label labelExt = new Label(namingComp, SWT.NONE);
			labelExt.setEnabled(false);
			labelExt.setText(".etmap");
		}
		{
			Label label = new Label(namingComp, SWT.NONE);
			label.setText("etPhys file name: ");

			physText = new Text(namingComp, SWT.BORDER);
			physText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			physText.addModifyListener(this);
			Label labelExt = new Label(namingComp, SWT.NONE);
			labelExt.setEnabled(false);
			labelExt.setText(".etphys");
		}
		setControl(topLevel);

		SelectRoomPage selectRoomPage = (SelectRoomPage) getWizard().getPages()[0];
		if (selectRoomPage.getSelectedRoomResource() != null)
			setModelPath(selectRoomPage.getSelectedRoomResource());
	}

	public void setModelPath(IFile roomFile) {
		if (getControl() == null)
			return;

		containerGroup.setSelectedContainer(roomFile.getParent());

		String roomFileName = roomFile.getName().replace("." + roomFile.getFileExtension(), "");
		mapText.setText(roomFileName);
		physText.setText(roomFileName);

		handleUserInput();
		setPageComplete();
	}

	@Override
	public void handleEvent(Event event) {
		handleUserInput();
		setPageComplete();
	}

	@Override
	public void modifyText(ModifyEvent e) {
		handleUserInput();
		setPageComplete();
	}

	private void setPageComplete() {
		setPageComplete(mappingModelPath != null && physModelPath != null);
	}

	private void handleUserInput() {
		mappingModelPath = null;
		physModelPath = null;
		setErrorMessage(null);

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath path = containerGroup.getContainerFullPath();
		if (path == null || path.isEmpty() || !root.exists(path))
			return;

		String mapFileName = mapText.getText();
		String physFileName = physText.getText();
		if (mapFileName == null || mapFileName.isEmpty() || physFileName == null || physFileName.isEmpty())
			return;

		IFile mapFileTemp = root.getFile(path.append(mapFileName).addFileExtension("etmap"));
		if (mapFileTemp.exists()) {
			setErrorMessage(mapFileTemp.getFullPath() + " already exists");
			return;
		}
		IFile physFileTemp = root.getFile(path.append(physFileName).addFileExtension("etphys"));
		if (physFileTemp.exists()) {
			setErrorMessage(physFileTemp.getFullPath() + " already exists");
			return;
		}

		mappingModelPath = mapFileTemp;
		physModelPath = physFileTemp;

	}

}
