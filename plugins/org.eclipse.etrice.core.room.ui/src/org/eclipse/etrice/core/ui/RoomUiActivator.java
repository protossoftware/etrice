package org.eclipse.etrice.core.ui;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.etrice.core.ui.preferences.ValidationExtensionPreferences;
import org.eclipse.etrice.core.ui.quickfix.QuickfixExtensionManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.BundleContext;

public class RoomUiActivator extends RoomActivator {

	private static RoomUiActivator plugin;
	private ScopedPreferenceStore preferenceStore = null;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);

		plugin = this;
		
		ValidationExtensionPreferences.initValidationPreferencesFromStore();
		QuickfixExtensionManager.getInstance().loadQuickfixExtensions();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public IPreferenceStore getPreferenceStore() {
		// Create the preference store lazily.
		if (preferenceStore == null) {
			preferenceStore  = new ScopedPreferenceStore(InstanceScope.INSTANCE, getBundle().getSymbolicName());
		}
		return preferenceStore;
	}

	public static RoomUiActivator getDefault() {
		return plugin;
	}
}
