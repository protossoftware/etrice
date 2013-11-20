/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch.java;

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
public class JavaGeneratorConfigTab extends GeneratorConfigTab {

	public static final String PERSIST = "Persist";
	public static final String DATA_OBJ = "DataObj";
	
	private Button genPersist;

	private Button genDataObj;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	@Override
	public String getName() {
		return "Java Generator";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorConfigTab#addFurtherControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void addFurtherControls(Composite mainComposite) {

		genPersist = createCheckButton(mainComposite, "generate persistence interface");
		genPersist.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		genPersist.addSelectionListener(new UpdateConfig());

		genDataObj = createCheckButton(mainComposite, "generate store to/from POJO data objects");
		genDataObj.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		genDataObj.addSelectionListener(new UpdateConfig());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorConfigTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		
		try {
			genPersist.setSelection(configuration.getAttribute(PERSIST, false));
			genPersist.setSelection(configuration.getAttribute(DATA_OBJ, false));
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorConfigTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		
		configuration.setAttribute(PERSIST, genPersist.getSelection());
		configuration.setAttribute(DATA_OBJ, genDataObj.getSelection());
	}
}
