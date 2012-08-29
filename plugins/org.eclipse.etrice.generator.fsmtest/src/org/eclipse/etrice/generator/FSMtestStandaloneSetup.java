
package org.eclipse.etrice.generator;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class FSMtestStandaloneSetup extends FSMtestStandaloneSetupGenerated{

	public static void doSetup() {
		new FSMtestStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

