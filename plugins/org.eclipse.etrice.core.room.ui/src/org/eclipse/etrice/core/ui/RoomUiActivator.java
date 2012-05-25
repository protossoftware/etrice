package org.eclipse.etrice.core.ui;

import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.etrice.core.ui.quickfix.QuickfixExtensionManager;
import org.osgi.framework.BundleContext;

public class RoomUiActivator extends RoomActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		QuickfixExtensionManager.getInstance().loadQuickfixExtensions();
	}
}
