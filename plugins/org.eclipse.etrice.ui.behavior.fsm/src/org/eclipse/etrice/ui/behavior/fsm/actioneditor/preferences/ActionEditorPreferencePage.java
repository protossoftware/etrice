package org.eclipse.etrice.ui.behavior.fsm.actioneditor.preferences;

import java.util.ArrayList;

import org.eclipse.etrice.ui.behavior.fsm.Activator;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.ActionCodeEditorRegistry;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.ActionCodeEditorRegistry.ActionCodeEditorRegistryEntry;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page for the Action Code Editor.
 * 
 * @author jayant
 */
public class ActionEditorPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public static final String CHOOSE_EDITOR_LANGUAGE = "Choose editor language:";
	public static final String CHOOSE_JAVA_EDITOR = "Choose editor for Java:";
	public static final String CHOOSE_CPP_EDITOR = "Choose editor for C/C++:";

	public ActionEditorPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("A preference page for choosing action code editors for target languages.");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {

		addField(new RadioGroupFieldEditor(
				PreferenceConstants.JAVA_EDITOR_LANGUAGE,
				CHOOSE_EDITOR_LANGUAGE,
				1,
				new String[][] {
						{"Java", PreferenceConstants.JAVA_LANGUAGE},
						{"C/C++", PreferenceConstants.CPP_LANGUAGE}
				},
				getFieldEditorParent()));
		
		// Choice for Java Editor
		addField(new RadioGroupFieldEditor(
				PreferenceConstants.JAVA_EDITOR_PREFERENCE,
				CHOOSE_JAVA_EDITOR,
				1,
				getChoicesForTargetLanguage(ActionCodeEditorRegistry.TARGET_LANGUAGE_JAVA),
				getFieldEditorParent()));

		// Choice for C/C++ editor
		addField(new RadioGroupFieldEditor(
				PreferenceConstants.CPP_EDITOR_PREFERENCE,
				CHOOSE_CPP_EDITOR,
				1,
				getChoicesForTargetLanguage(ActionCodeEditorRegistry.TARGET_LANGUAGE_CPP),
				getFieldEditorParent()));
	}

	/**
	 * Forms the label and value array for choosing editors for the given target
	 * language.
	 * 
	 * @param targetLanguage
	 *            the target language for the editor choice
	 * @return label and value array
	 */
	private String[][] getChoicesForTargetLanguage(String targetLanguage) {

		ActionCodeEditorRegistryEntry[] editors = ActionCodeEditorRegistry.INSTANCE
				.getEditorsForTargetLanguage(targetLanguage);

		ArrayList<String[]> editorChoices = new ArrayList<String[]>();
		for (ActionCodeEditorRegistryEntry javaEditor : editors) {
			String[] choice = new String[] { javaEditor.getName(),
					javaEditor.getId() };
			editorChoices.add(choice);
		}

		return (String[][]) editorChoices.toArray(new String[editorChoices
				.size()][]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}