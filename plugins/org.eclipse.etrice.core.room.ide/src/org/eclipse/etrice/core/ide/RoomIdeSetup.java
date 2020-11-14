/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.etrice.core.RoomRuntimeModule;
import org.eclipse.etrice.core.RoomStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class RoomIdeSetup extends RoomStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new RoomRuntimeModule(), new RoomIdeModule()));
	}
	
}
