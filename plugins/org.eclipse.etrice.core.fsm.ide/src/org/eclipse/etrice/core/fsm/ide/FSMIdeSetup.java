/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.fsm.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.etrice.core.fsm.FSMRuntimeModule;
import org.eclipse.etrice.core.fsm.FSMStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class FSMIdeSetup extends FSMStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new FSMRuntimeModule(), new FSMIdeModule()));
	}
	
}