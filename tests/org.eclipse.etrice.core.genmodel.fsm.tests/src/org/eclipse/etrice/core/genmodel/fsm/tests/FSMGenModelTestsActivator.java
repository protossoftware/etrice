package org.eclipse.etrice.core.genmodel.fsm.tests;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.etrice.core.RoomStandaloneSetup;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class FSMGenModelTestsActivator extends Plugin implements BundleActivator {

	private static FSMGenModelTestsActivator instance = null;
	
	@Inject
	private Diagnostician diagnostician;
	
	public static FSMGenModelTestsActivator getInstance() {
		return instance;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		instance = this;
        
		Injector injector = new RoomStandaloneSetup().createInjectorAndDoEMFRegistration();
        injector.injectMembers(this);
	}

	public Diagnostician getDiagnostician() {
		return diagnostician;
	}

}
