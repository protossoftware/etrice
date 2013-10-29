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

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Henrik Rentz-Reichert
 *
 */
class EmptyProjectConfigPage extends WizardPage {
	
	private IProject runtimeProject;
	private Button jdtBuild;
	private Button mvnBuild;
	private boolean useJDTBuild;
	
	/**
	 * @param pageName
	 */
	EmptyProjectConfigPage(String pageName, IProject runtimeProject) {
		super(pageName);
		this.runtimeProject = runtimeProject;
	}
	
	@Override
	public void createControl(Composite parent) {
	    Composite composite = new Composite(parent, SWT.NULL);

	    initializeDialogUnits(parent);
	    composite.setLayout(new GridLayout());
	    composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
	    jdtBuild = new Button(composite, SWT.RADIO);
	    jdtBuild.setText("use &Eclipse JDT build");
	    jdtBuild.setSelection(true);
	    jdtBuild.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
			    setPageComplete(validatePage());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
	    mvnBuild = new Button(composite, SWT.RADIO);
	    mvnBuild.setText("use &Maven build");
	    
	    // Show description on opening
	    setErrorMessage(null);
	    setMessage(null);
	    setControl(composite);
	    Dialog.applyDialogFont(composite);
	    
	    setPageComplete(validatePage());
	}
	
	protected boolean validatePage() {
		if (jdtBuild.getSelection() && (runtimeProject==null || !runtimeProject.exists() || !runtimeProject.isAccessible())) {
			setErrorMessage("for JDT build the project 'org.eclipse.etrice.runtime.java' must be in the workspace");
			return false;
		}
		
		useJDTBuild = jdtBuild==null || jdtBuild.getSelection();
		
		setErrorMessage(null);
		
		return true;
	}
	
	public boolean useJDTBuild() {
		return useJDTBuild;
	}
	
	public boolean useMVNBuild() {
		return !useJDTBuild;
	}
}