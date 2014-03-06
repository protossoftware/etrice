package org.eclipse.etrice.core;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.etrice.core.scoping.ModelLocator;
import org.eclipse.etrice.core.validation.ValidatorExtensionManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class RoomActivator extends Plugin implements BundleActivator {

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		ValidatorExtensionManager.Registry.getInstance().loadValidatorExtensions();
		ModelLocator.getInstance().loadExtensions();
	}
}
