/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Christian Hilden (initial contribution)
 * 
 *******************************************************************************/package org.eclipse.etrice.generator.launch.contractmonitor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.etrice.generator.launch.GeneratorConfigTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class ContractMonitorGeneratorConfigTab extends GeneratorConfigTab {

	public static final String TARGET_LANG = "TargetLanguage";
	
	private Text targetLang;
	
	@Override
	public String getName() {
		return "Contract Monitor Generator";
	}
	
	@Override
	protected void addFurtherControls(Composite mainComposite) {
		
		createSeparator(mainComposite, 2);		
		
		Label label = new Label(mainComposite, SWT.NONE);
		label.setText("Target language:");
		targetLang = new Text(mainComposite, SWT.SINGLE | SWT.BORDER);
		targetLang.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		targetLang.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validate();
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(OVERRIDE_DIRECTORIES, true);
		configuration.setAttribute(SRCGEN_PATH, "model-gen");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		try {
			targetLang.setText(configuration.getAttribute(TARGET_LANG, "c"));	
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {		
		super.performApply(configuration);
		
		configuration.setAttribute(TARGET_LANG, targetLang.getText());
	}

}
