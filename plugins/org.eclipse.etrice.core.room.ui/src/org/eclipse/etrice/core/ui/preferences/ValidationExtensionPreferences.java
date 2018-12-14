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
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.preferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.etrice.core.ui.RoomUiActivator;
import org.eclipse.etrice.core.validation.ValidatorExtensionManager;
import org.eclipse.etrice.core.validation.ValidatorExtensionManager.Registry;
import org.eclipse.etrice.core.validation.ValidatorExtensionManager.ValidatorInfo;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ValidationExtensionPreferences extends PreferencePage implements IWorkbenchPreferencePage {

	private static final String VALIDATION_EXTENSIONS_EXCLUDED = "ValidationExtensionPreferences.excluded";
	private static final String SEP = "#";
	
	public static void initValidationPreferencesFromStore(){
		Set<String> excludedIds = readExcludedFromPreferences();
		Registry registry = ValidatorExtensionManager.Registry.getInstance();
		registry.setIncluded(new ArrayList<ValidatorInfo>());
		List<ValidatorInfo> all = registry.getInfos();
		for(ValidatorInfo val : all)
			if(!excludedIds.contains(val.getName()))
				registry.include(val);
	}
	
	private static IPreferenceStore getDefaultPreferenceStore(){
		return RoomUiActivator.getDefault().getPreferenceStore();
	}
	
	private static Set<String> readExcludedFromPreferences(){
		String stored = getDefaultPreferenceStore().getString(VALIDATION_EXTENSIONS_EXCLUDED);
		String[] excl = stored.split(SEP);
		HashSet<String> excludedIds = new HashSet<String>();
		for (String ex : excl) {
			excludedIds.add(ex);
		}
		
		return excludedIds;
	}

	private class ValidationExtensionContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return ValidatorExtensionManager.Registry.getInstance().getInfos().toArray();
		}
		
	}
	
	private class ValidationExtensionLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ValidatorInfo) {
				ValidatorInfo info = (ValidatorInfo) element;
				
				switch (columnIndex) {
				case 0: return info.getName();
				case 1: return info.getMode();
				case 2: return info.getDescription();
				}
			}
			return null;
		}
		
	}
	
	private CheckboxTableViewer viewer;
	
	/**
	 * 
	 */
	public ValidationExtensionPreferences() {
		setDescription("Preferences for ROOM model validation extensions");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(getDefaultPreferenceStore());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);

		Label label = new Label(composite, SWT.WRAP);
		label.setAlignment(SWT.LEFT);
		label.setText("Check active validators");

		Composite tableArea = new Composite(composite, SWT.NONE);
		
		Table table = new Table(tableArea, SWT.BORDER | SWT.MULTI | SWT.CHECK);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 150;
		gd.widthHint = 250;
		table.setLayoutData(gd);
		tableArea.setLayoutData(gd);

		TableColumn nameColumn= new TableColumn(table, SWT.NONE, 0);
		nameColumn.setText("Name");
		TableColumn modeColumn= new TableColumn(table, SWT.NONE, 1);
		modeColumn.setText("Mode");
		TableColumn descColumn= new TableColumn(table, SWT.NONE, 2);
		descColumn.setText("Description");
		
		viewer = new CheckboxTableViewer(table);
		viewer.setContentProvider(new ValidationExtensionContentProvider());
		viewer.setLabelProvider(new ValidationExtensionLabelProvider());
		viewer.setInput(ValidatorExtensionManager.Registry.getInstance().getInfos());
		viewer.getTable().setHeaderVisible(true);
		setChecks();
		
		// the table layout is crucial!
		TableColumnLayout layout = new TableColumnLayout();
		tableArea.setLayout(layout);

		layout.setColumnData(nameColumn, new ColumnWeightData(20));
		layout.setColumnData(modeColumn, new ColumnWeightData(20));
		layout.setColumnData(descColumn, new ColumnWeightData(80));

		GridLayout compositeLayout = new GridLayout(1, false);
		composite.setLayout(compositeLayout);
		
		return composite;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		updateExcluded();
		return super.performOk();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performApply()
	 */
	@Override
	protected void performApply() {
		updateExcluded();
		super.performApply();
	}

	private void setChecks() {
		Set<String> excludedIds = readExcludedFromPreferences();
		
		ArrayList<ValidatorInfo> allChecked = new ArrayList<ValidatorInfo>();
		for (ValidatorInfo vi : ValidatorExtensionManager.Registry.getInstance().getInfos()) {
			if (!excludedIds.contains(vi.getName()))
				allChecked.add(vi);
		}
		
		viewer.setCheckedElements(allChecked.toArray());
	}

	private void updateExcluded() {
		Object[] checked = viewer.getCheckedElements();
		HashSet<ValidatorInfo> included = new HashSet<ValidatorInfo>();
		for (Object object : checked) {
			included.add((ValidatorInfo)object);
		}
		
		Registry registry = ValidatorExtensionManager.Registry.getInstance();
		registry.setIncluded(included);
		
		StringBuilder ex = new StringBuilder();
		for (ValidatorInfo vi : registry.getExcludedInfos()) {
			ex.append(vi.getName()+SEP);
		}
		
		getPreferenceStore().setValue(VALIDATION_EXTENSIONS_EXCLUDED, ex.toString());
	}
}
