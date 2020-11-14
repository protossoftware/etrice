/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.etmap.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.etrice.core.etmap.ETMapRuntimeModule;
import org.eclipse.etrice.core.etmap.ETMapStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class ETMapIdeSetup extends ETMapStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new ETMapRuntimeModule(), new ETMapIdeModule()));
	}
	
}
