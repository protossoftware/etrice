package org.eclipse.etrice.ui.structure.link;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import org.eclipse.etrice.ui.structure.Activator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.xtext.ui.resource.generic.EmfUiModule;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

public class ExecutableExtensionFactory extends
		AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return createInjector(override(
				override(new ResourceModule()).with(new SharedStateModule()))
				.with(new EmfUiModule(Activator.getDefault())));
	}

}
