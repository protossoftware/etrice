package org.eclipse.etrice.ui.behavior.fsm.actioneditor.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.etrice.ui.behavior.fsm.Activator;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 * 
 * @author jayant
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/** the Id for ModelAwareActionCodeEditor's contribution. */
	public static final String MODEL_AWARE_ACTION_CODE_EDITOR_ID = "org.eclipse.etrice.ui.behavior.actioneditor.modelAwareActionCodeEditor";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		// Set the default preference value for Java Editor
		store.setDefault(PreferenceConstants.JAVA_EDITOR_PREFERENCE,
				MODEL_AWARE_ACTION_CODE_EDITOR_ID);

		// Set the default preference value for C++ Editor
		store.setDefault(PreferenceConstants.CPP_EDITOR_PREFERENCE,
				MODEL_AWARE_ACTION_CODE_EDITOR_ID);
	}
}
