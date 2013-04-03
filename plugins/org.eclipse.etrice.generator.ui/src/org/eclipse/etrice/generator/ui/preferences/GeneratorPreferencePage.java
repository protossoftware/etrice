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
						PreferenceConstants.GEN_INCREMENTAL,
						"Generate &incrementally:",
						getFieldEditorParent()));
		addField(
				new StringFieldEditor(
						PreferenceConstants.GEN_DIR,
						"The directory for &generated code:",
						getFieldEditorParent()));
		addField(
				new StringFieldEditor(
						PreferenceConstants.GEN_INFO_DIR,
						"The directory for i&nformation about generated code:",
						getFieldEditorParent()));
		addField(
				new StringFieldEditor(
						PreferenceConstants.GEN_DOC_DIR,
						"The directory for generated &documentation:",
						getFieldEditorParent()));

//		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH, 
//				"&Directory preference:", getFieldEditorParent()));
//
//		addField(new RadioGroupFieldEditor(
//				PreferenceConstants.P_CHOICE,
//			"An example of a multiple-choice preference",
//			1,
//			new String[][] { { "&Choice 1", "choice1" }, {
//				"C&hoice 2", "choice2" }
//		}, getFieldEditorParent()));
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