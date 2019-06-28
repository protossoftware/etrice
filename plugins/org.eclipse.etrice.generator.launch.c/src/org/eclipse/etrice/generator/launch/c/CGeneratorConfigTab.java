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
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch.c;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.etrice.generator.launch.GeneratorConfigTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CGeneratorConfigTab extends GeneratorConfigTab {
	
	public static final String GEN_CPP_FILE_EXTENSIONS = "cppFileExtensions";
	
	private Button generateCppFileExtensions;

	@Override
	protected void addFurtherControls(Composite mainComposite) {
		super.addFurtherControls(mainComposite);
		

		createSeparator(mainComposite, 2);
		
		generateCppFileExtensions = createCheckButton(mainComposite, "generate with C++ file extensions");
		generateCppFileExtensions.setToolTipText("this options generates C source and header files with *.cpp and *.hpp extensions");
		generateCppFileExtensions.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		generateCppFileExtensions.addSelectionListener(new UpdateConfig());
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		
		try {
			generateCppFileExtensions.setSelection(configuration.getAttribute(GEN_CPP_FILE_EXTENSIONS, false));
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		
		configuration.setAttribute(GEN_CPP_FILE_EXTENSIONS, generateCppFileExtensions.getSelection());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	@Override
	public String getName() {
		return "C Generator";
	}
}
