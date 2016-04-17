package org.eclipse.etrice.generator.ui.cdt;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin implements BundleActivator {

	private static Activator instance = null;
	
	public static 
	Activator getDefault() {
		return instance;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		instance = null;
		super.stop(context);
	}

}
