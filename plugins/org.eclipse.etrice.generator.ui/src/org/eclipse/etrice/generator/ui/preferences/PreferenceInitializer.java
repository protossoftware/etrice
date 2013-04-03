package org.eclipse.etrice.generator.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.etrice.generator.ui.Activator;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getInstance().getPreferenceStore();
		store.setDefault(PreferenceConstants.GEN_INCREMENTAL, true);
		store.setDefault(PreferenceConstants.GEN_DIR, "src-gen");
		store.setDefault(PreferenceConstants.GEN_INFO_DIR, "src-gen-info");
		store.setDefault(PreferenceConstants.GEN_DOC_DIR, "doc-gen");
	}

}
