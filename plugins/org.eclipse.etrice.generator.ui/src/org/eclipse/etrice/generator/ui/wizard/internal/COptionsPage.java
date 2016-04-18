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

package org.eclipse.etrice.generator.ui.wizard.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.ui.wizard.WizardHelpers;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.wizards.datatransfer.ZipFileStructureProvider;

/**
 * @author hrentz
 *
 */
public class COptionsPage extends WizardPage {

	private IProjectPathProvider projectPathProvider;
	private Button copyRuntimeButton = null;
	private Combo platformCombo = null;
	private Text mainMethodName = null;

	public COptionsPage(String title, IProjectPathProvider projectPathProvider) {
		super(title);
		this.projectPathProvider = projectPathProvider;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		Composite buttonComposite = new Composite(parent, SWT.NONE);

		GridData gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING | GridData.HORIZONTAL_ALIGN_END);
		buttonComposite.setLayoutData(gd);
		buttonComposite.setLayout(new GridLayout(2, false));
		
		copyRuntimeButton = new Button(buttonComposite, SWT.CHECK);
		copyRuntimeButton.setText("&Copy C-Runtime into project");
		copyRuntimeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		gd = new GridData();
		gd.horizontalSpan = 2;
		copyRuntimeButton.setLayoutData(gd);
		
		Label l = new Label(buttonComposite, SWT.NONE);
		l.setText("Select active platform:");
		l.setLayoutData(new GridData(SWT.NONE));
		
		platformCombo = new Combo(buttonComposite, SWT.READ_ONLY);
		gd = new GridData(SWT.HORIZONTAL);
		gd.widthHint = 200;
		platformCombo.setLayoutData(gd);
		platformCombo.setVisibleItemCount(10);
		
		l = new Label(buttonComposite, SWT.NONE);
		l.setText("Main method name:");
		l.setLayoutData(new GridData(SWT.NONE));
		
		mainMethodName = new Text(buttonComposite, SWT.SINGLE | SWT.BORDER);
		mainMethodName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		mainMethodName.setText(AbstractGenerator.DEFAULT_MAIN_NAME);
		
		setErrorMessage(null);
		setMessage(null);
		setControl(buttonComposite);
	}
	
    @Override
    public void setVisible(boolean visible)
    {
		super.setVisible(visible);
		
		if (visible) {
			refresh();
		}
    }

	private void refresh() {
		copyRuntimeButton.setEnabled(false);
		platformCombo.setEnabled(false);
		platformCombo.removeAll();
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath chosenPath = projectPathProvider.getPath();
		IProject project = (chosenPath.segmentCount()==1)?
				workspace.getRoot().getProject(chosenPath.lastSegment())
				: workspace.getRoot().getFolder(chosenPath).getProject();
				
		try {
			if (project.hasNature("org.eclipse.cdt.core.cnature")) {
				copyRuntimeButton.setEnabled(true);
				platformCombo.setEnabled(true);
				
				List<String> platformNames = getPlatformNames();
				for (String name : platformNames) {
					platformCombo.add(name);
				}
				
				platformCombo.select(0);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private List<String> getPlatformNames() {
		List<String> result = new ArrayList<String>();

		ZipFile zipFile = WizardHelpers.getCRuntimeZip();
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
				children = structureProvider.getChildren(current);
				current = null;
				for (Object child : children) {
					if (child instanceof ZipEntry) {
						if (((ZipEntry) child).getName().equals("src/platforms/")) {
							current = (ZipEntry) child;
							break;
						}
					}
				}
			}
			if (current!=null) {
				children = structureProvider.getChildren(current);
				for (Object child : children) {
					if (child instanceof ZipEntry) {
						String name = ((ZipEntry) child).getName();
						if (name.endsWith("/")) {
							String[] split = name.split("/");
							result.add(split[split.length-1]);
						}
					}
				}
			}
			try {
				zipFile.close();
			} catch (IOException e) {
				// Ignore.
			}
		}
		
		return result;
	}
	
	public boolean getCopyRuntime() {
		if (copyRuntimeButton!=null && !copyRuntimeButton.isDisposed()) {
			return copyRuntimeButton.getSelection();
		}
		return false;
	}
	
	public String getPlatform() {
		if (platformCombo!=null && !platformCombo.isDisposed()) {
			if (platformCombo.getSelectionIndex()>=0) {
				return platformCombo.getText();
			}
		}
		
		return "";
	}
	
	public String getMainMethodName() {
		if (mainMethodName!=null && !mainMethodName.isDisposed()) {
			return mainMethodName.getText();
		}
		
		return AbstractGenerator.DEFAULT_MAIN_NAME;
	}
}
