/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.etrice.generator.base.AbstractGeneratorOptions;
import org.eclipse.etrice.generator.ui.preferences.PreferenceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class GeneratorConfigTab extends AbstractLaunchConfigurationTab {

	protected class UpdateConfig implements SelectionListener {
		public UpdateConfig() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			validate();
			setDirty(true);
			updateLaunchConfigurationDialog();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			widgetSelected(e);
		}
	}

	public static final String GEN_MODEL_PATH = "GenModelPath";
	public static final String SAVE_GEN_MODEL = "SaveGenModel";
	public static final String MAIN_METHOD_NAME = "MainMethodName";
	public static final String LIB = "Lib";
	public static final String DEBUG = "Debug";
	public static final String MSC_INSTR = "MSC";
	public static final String VERBOSE = "Verbose";
	public static final String USE_TRAANSLATION = "UseTranslation";
	public static final String OLD_STYLE_TRANSITION_DATA = "OldStyleTransitionData";
	public static final String OVERRIDE_DIRECTORIES = "OverrideDirectories";
	public static final String GEN_DEPS_WITHIN_PROJECT = "GenerateDepsWithinProject";
	public static final String SRCGEN_PATH = "SrcgenPath";
	
	private Button libButton;
	private Button saveGenModel;
	private Text genModelPath;
	private Button debugButton;
	private Button mscButton;
	private Button verboseButton;
	private Button useTranslationButton;
	private Button generateDepsWithinProject;
	private Button overrideDirectories;
	private Text srcgenPath;
	private Text mainMethodName;
	private Button useOldStyleTransitionDataButton;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// Create main composite
		Composite mainComposite = new Composite(parent,SWT.NONE);
		setControl(mainComposite);
		
		GridLayout layout= new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		mainComposite.setLayout(layout);
		
		libButton = createCheckButton(mainComposite, "generate all classes as library");
		libButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		libButton.addSelectionListener(new UpdateConfig());

		saveGenModel = createCheckButton(mainComposite, "save generator model");
		saveGenModel.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		saveGenModel.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleSaveGenModelSelected();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleSaveGenModelSelected();
			}
			
		});
		Label label = new Label(mainComposite, SWT.NONE);
		label.setText("The file name for the generator model:");
		genModelPath = new Text(mainComposite, SWT.SINGLE | SWT.BORDER);
    	genModelPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		genModelPath.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validate();
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		});

		useTranslationButton = createCheckButton(mainComposite, "perform code translation");
		useTranslationButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		useTranslationButton.addSelectionListener(new UpdateConfig());

		useOldStyleTransitionDataButton = createCheckButton(mainComposite, "use old style transition data names");
		useOldStyleTransitionDataButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		useOldStyleTransitionDataButton.addSelectionListener(new UpdateConfig());

		debugButton = createCheckButton(mainComposite, "generate debug output");
		debugButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		debugButton.addSelectionListener(new UpdateConfig());

		mscButton = createCheckButton(mainComposite, "generate instrumentation for MSC logging");
		mscButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		mscButton.addSelectionListener(new UpdateConfig());
		
		verboseButton = createCheckButton(mainComposite, "generate instrumentation for verbose output");
		verboseButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		verboseButton.addSelectionListener(new UpdateConfig());
		
		label = new Label(mainComposite, SWT.NONE);
		label.setText("The main method name:");
		mainMethodName = new Text(mainComposite, SWT.SINGLE | SWT.BORDER);
		mainMethodName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		mainMethodName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validate();
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		});

		createSeparator(mainComposite, 2);
		
		generateDepsWithinProject = createCheckButton(mainComposite, "generate all dependencies within project");
		generateDepsWithinProject.setToolTipText("this options automatically generates all referenced model files in this project");
		generateDepsWithinProject.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		generateDepsWithinProject.addSelectionListener(new UpdateConfig());
		
		overrideDirectories = createCheckButton(mainComposite, "override generation directories");
		overrideDirectories.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		overrideDirectories.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleOverrideDirectories();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleOverrideDirectories();
			}
			
		});
		
		label = new Label(mainComposite, SWT.NONE);
		label.setText("The directory for &generated code:");
		srcgenPath = new Text(mainComposite, SWT.SINGLE | SWT.BORDER);
		srcgenPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		srcgenPath.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validate();
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		});
		
		addFurtherControls(mainComposite);
	}

	/**
	 * @param mainComposite
	 */
	protected void addFurtherControls(Composite mainComposite) {
	}

	protected void handleSaveGenModelSelected() {
		boolean save = saveGenModel.getSelection();
		genModelPath.setEnabled(save);
		validate();
		setDirty(true);
		updateLaunchConfigurationDialog();
	}

	protected void handleOverrideDirectories() {
		boolean override = overrideDirectories.getSelection();
		srcgenPath.setEnabled(override);
		if (!override) {
			ScopedPreferenceStore prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
			srcgenPath.setText(prefStore.getString(getSrcgenDirPreferenceConstantName()));
		}
		validate();
		setDirty(true);
		updateLaunchConfigurationDialog();
	}

	/**
	 * 
	 */
	protected void validate() {
		if (saveGenModel.getSelection())
			if (genModelPath.getText().trim().isEmpty()) {
				setErrorMessage("generator model path must not be empty");
				return;
			}
		setErrorMessage(null);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			// defaults: org.eclipse.etrice.generator.base.GlobalGeneratorSettings
			libButton.setSelection(configuration.getAttribute(LIB, false));
			boolean save = configuration.getAttribute(SAVE_GEN_MODEL, false);
			saveGenModel.setSelection(save);
			genModelPath.setEnabled(save);
			genModelPath.setText(configuration.getAttribute(GEN_MODEL_PATH, ""));
			mainMethodName.setText(configuration.getAttribute(MAIN_METHOD_NAME, AbstractGeneratorOptions.MAIN_NAME.getDefaultValue()));
			debugButton.setSelection(configuration.getAttribute(DEBUG, false));
			mscButton.setSelection(configuration.getAttribute(MSC_INSTR, false));
			verboseButton.setSelection(configuration.getAttribute(VERBOSE, false));
			
			ScopedPreferenceStore prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
			boolean useTranslation = prefStore.getBoolean(PreferenceConstants.GEN_USE_TRANSLATION);
			useTranslationButton.setSelection(configuration.getAttribute(USE_TRAANSLATION, useTranslation));
			
			boolean useOldStyleTransitionData = prefStore.getBoolean(PreferenceConstants.GEN_OLD_STYLE_TRANSITION_DATA);
			useOldStyleTransitionDataButton.setSelection(configuration.getAttribute(OLD_STYLE_TRANSITION_DATA, useOldStyleTransitionData));
			
			boolean override = configuration.getAttribute(OVERRIDE_DIRECTORIES, false);
			String srcgenDir = prefStore.getString(getSrcgenDirPreferenceConstantName());
			overrideDirectories.setSelection(override);
			srcgenPath.setEnabled(override);
			if (override) {
				srcgenPath.setText(configuration.getAttribute(SRCGEN_PATH, srcgenDir));
			}
			else {
				srcgenPath.setText(srcgenDir);
			}
			
			generateDepsWithinProject.setSelection(configuration.getAttribute(GEN_DEPS_WITHIN_PROJECT, true));
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	protected String getSrcgenDirPreferenceConstantName() {
		return PreferenceConstants.GEN_DIR;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(LIB, libButton.getSelection());
		configuration.setAttribute(SAVE_GEN_MODEL, saveGenModel.getSelection());
		configuration.setAttribute(GEN_MODEL_PATH, genModelPath.getText());
		configuration.setAttribute(MAIN_METHOD_NAME, mainMethodName.getText());
		configuration.setAttribute(DEBUG, debugButton.getSelection());
		configuration.setAttribute(MSC_INSTR, mscButton.getSelection());
		configuration.setAttribute(VERBOSE, verboseButton.getSelection());
		configuration.setAttribute(USE_TRAANSLATION, useTranslationButton.getSelection());
		configuration.setAttribute(OLD_STYLE_TRANSITION_DATA, useOldStyleTransitionDataButton.getSelection());
		
		boolean override = overrideDirectories.getSelection();
		configuration.setAttribute(OVERRIDE_DIRECTORIES, override);
		if (override) {
			configuration.setAttribute(SRCGEN_PATH, srcgenPath.getText());
		}
		
		configuration.setAttribute(GEN_DEPS_WITHIN_PROJECT, generateDepsWithinProject.getSelection());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#canSave()
	 */
	@Override
	public boolean canSave() {
		if (saveGenModel.getSelection())
			return !genModelPath.getText().trim().isEmpty();
		
		return true;
	}

}
