package org.eclipse.etrice.generator.ui.preferences;

import org.eclipse.etrice.generator.ui.Activator;
import org.eclipse.jface.preference.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class GeneratorPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public GeneratorPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getInstance().getPreferenceStore());
		setDescription("eTrice general generator preferences");
	}
	
	public void createFieldEditors() {
		addLabel("");
		
		addField(
				new BooleanFieldEditor(
						PreferenceConstants.GEN_USE_TRANSLATION,
						"Let wizard create new launchers with detail code translation on initially",
						getFieldEditorParent()));
		addField(
				new BooleanFieldEditor(
						PreferenceConstants.GEN_OLD_STYLE_TRANSITION_DATA,
						"Let wizard create new launchers with old style transition data generation on initially",
						getFieldEditorParent()));
		addField(
				new StringFieldEditor(
						PreferenceConstants.GEN_DIR,
						"The directory for &generated code:",
						getFieldEditorParent()));
		addField(
				new StringFieldEditor(
						PreferenceConstants.GEN_DOC_DIR,
						"The directory for generated &documentation:",
						getFieldEditorParent()));

//		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH, 
//				"&Directory preference:", getFieldEditorParent()));
//
	}

	private void addLabel(String message) {
		Label label = new Label(getFieldEditorParent(), SWT.None);
		GridData data = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false, 2, 1);
		label.setLayoutData(data);
		//label.setForeground(ColorConstants.red);
		if (message != null)
			label.setText(message);
	}

	public void init(IWorkbench workbench) {
	}
	
}