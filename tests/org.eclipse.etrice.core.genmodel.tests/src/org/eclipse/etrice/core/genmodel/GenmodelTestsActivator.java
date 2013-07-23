package org.eclipse.etrice.core.genmodel;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class GenmodelTestsActivator extends Plugin implements BundleActivator {

	private static GenmodelTestsActivator instance = null;
	
	public static GenmodelTestsActivator getInstance() {
		return instance;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		instance = this;
	}

}
