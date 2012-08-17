package org.eclipse.etrice.abstractexec.behavior.tests;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class Activator extends Plugin implements BundleActivator {

	private static Activator instance = null;
	
	@Inject
	private Diagnostician diagnostician;
	
	public static Activator getInstance() {
		return instance;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		
		instance = this;
        
		Injector injector = RoomUiModule.getInjector();
        injector.injectMembers(this);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		instance = null;
		super.stop(bundleContext);
	}

	public Diagnostician getDiagnostician() {
		return diagnostician;
	}

}
