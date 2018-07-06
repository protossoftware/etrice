package org.eclipse.etrice.dctools.tests;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.eclipse.core.runtime.Plugin;

public class DCToolsTestsActivator extends Plugin implements BundleActivator {

	private static DCToolsTestsActivator instance = null;
	
	public static DCToolsTestsActivator getInstance() {
		return instance;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		instance = this;
	}
}
