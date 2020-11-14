/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.common.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.etrice.core.common.BaseRuntimeModule;
import org.eclipse.etrice.core.common.BaseStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class BaseIdeSetup extends BaseStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new BaseRuntimeModule(), new BaseIdeModule()));
	}
	
}
