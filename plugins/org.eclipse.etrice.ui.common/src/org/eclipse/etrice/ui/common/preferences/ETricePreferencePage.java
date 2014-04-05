/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.preferences;

import org.eclipse.etrice.ui.common.Activator;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ETricePreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	private BooleanFieldEditor snap;
	private StringFieldEditor hor;
	private StringFieldEditor ver;
	private Button useGridCheck;
	private StringFieldEditor maxLineLength;
	private StringFieldEditor maxLines;

	public ETricePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("eTrice Preferences");
	}
	
	public void createFieldEditors() {
		addLabel("");
		addLabel("Textual Model Editor");
		BooleanFieldEditor autoSaveText = new BooleanFieldEditor(
				PreferenceConstants.SAVE_TEXT_ON_FOCUS_LOST,
				"Auto-save textual model when focus changes",
				getFieldEditorParent());
		addField(autoSaveText);
		
		addLabel("");
		addLabel("Diagram Editors");
		addField(
				new BooleanFieldEditor(
					PreferenceConstants.CONFIRM_DELETE,
					"&Confirm diagram element deletion",
					getFieldEditorParent()));
		
		BooleanFieldEditor autoSave = new BooleanFieldEditor(
				PreferenceConstants.SAVE_DIAG_ON_FOCUS_LOST,
				"Auto-save diagram when focus changes",
				getFieldEditorParent());
		addField(autoSave);
		
		maxLineLength = new StringFieldEditor(PreferenceConstants.MAX_LABEL_LINE_LENGTH, "Max Transition Lable Line Length::", getFieldEditorParent());
		addField(maxLineLength);
		
		maxLines = new StringFieldEditor(PreferenceConstants.MAX_LABEL_LINES, "Max Transition Lable Lines::", getFieldEditorParent());
		addField(maxLines);

		StringFieldEditor exportPath = new StringFieldEditor(PreferenceConstants.EXPORT_DIAGRAM_PATH, "&Export Diagram Path:", getFieldEditorParent());
		addField(exportPath);

		RadioGroupFieldEditor exportRelTo = new RadioGroupFieldEditor(
				PreferenceConstants.EXPORT_DIAGRAM_PATH_RELATIVE_TO,
				"Export Path Relative to",
				2,
				new String[][] {
					{"Project", PreferenceConstants.PATH_REL_TO_PROJECT},
					{"Model", PreferenceConstants.PATH_REL_TO_MODEL}
				},
				getFieldEditorParent(),
				true);
		addField(exportRelTo);

		RadioGroupFieldEditor imgFormat = new RadioGroupFieldEditor(
				PreferenceConstants.EXPORT_DIAGRAM_FORMAT,
				"Image Format for Export:",
				4,
				new String[][] {
					{"BMP", PreferenceConstants.FORMAT_BMP},
					{"GIF", PreferenceConstants.FORMAT_GIF},
					{"JPG", PreferenceConstants.FORMAT_JPG},
					{"PNG", PreferenceConstants.FORMAT_PNG}
				},
				getFieldEditorParent(),
				true);
		addField(imgFormat);
		
		BooleanFieldEditor useGrid = new BooleanFieldEditor(
			PreferenceConstants.USE_GRID,
			"Use &Grid (grid settings apply to new diagrams only)",
			getFieldEditorParent());
		addField(useGrid);
		
		snap = new BooleanFieldEditor(
			PreferenceConstants.SNAP_TO_GRID,
			"&Snap to Grid",
			getFieldEditorParent());
		addField(snap);
		
		hor = new StringFieldEditor(PreferenceConstants.HOR_GRID_UNIT, "&Horizontal Grid Unit [px]:", getFieldEditorParent());
		addField(hor);
		
		ver = new StringFieldEditor(PreferenceConstants.VER_GRID_UNIT, "&Vertical Grid Unit [px]:", getFieldEditorParent());
		addField(ver);

		useGridCheck = (Button) useGrid.getDescriptionControl(getFieldEditorParent());
		useGridCheck.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateGridFields();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateGridFields();
			}
		});
	}

	@Override
	protected void initialize() {
		super.initialize();
		updateGridFields();
	}
	
	private void updateGridFields() {
		boolean enabled = useGridCheck.getSelection();
		snap.setEnabled(enabled, getFieldEditorParent());
		hor.setEnabled(enabled, getFieldEditorParent());
		ver.setEnabled(enabled, getFieldEditorParent());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	private void addLabel(String message) {
		Label label = new Label(getFieldEditorParent(), SWT.None);
		GridData data = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false, 2, 1);
		label.setLayoutData(data);
		//label.setForeground(ColorConstants.red);
		if (message != null)
			label.setText(message);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		boolean ok = super.performOk();
		
		if (ok) {
			// TODO: apply to open editors
//			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
//			boolean snap = store.getBoolean(PreferenceConstants.SNAP_TO_GRID);
//			boolean useGrid = store.getBoolean(PreferenceConstants.USE_GRID);
//			int horUnit = useGrid? store.getInt(PreferenceConstants.HOR_GRID_UNIT) : 0;
//			int verUnit = useGrid? store.getInt(PreferenceConstants.VER_GRID_UNIT) : 0;
//
//			IWorkbench wb = PlatformUI.getWorkbench();
//			IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
//			IWorkbenchPage page = win.getActivePage();
//			IEditorReference[] editorReferences = page.getEditorReferences();
//			for (IEditorReference ref : editorReferences) {
//				IEditorPart editor = ref.getEditor(true);
//				if (editor instanceof RoomDiagramEditor) {
//					Diagram diagram = ((DiagramEditorInput)editor.getEditorInput()).getDiagram();
//					diagram.setSnapToGrid(snap);
//					diagram.setGridUnit(horUnit);
//					diagram.setVerticalGridUnit(verUnit);
//				}
//			}
		}
		
		return ok;
	}
}