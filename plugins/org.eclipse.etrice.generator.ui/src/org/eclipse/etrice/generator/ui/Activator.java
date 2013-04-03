package org.eclipse.etrice.generator.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	private static Activator instance = null;
	
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

	public static Activator getInstance() {
		return instance;
	}

	public static void setInstance(Activator instance) {
		Activator.instance = instance;
	}
}
