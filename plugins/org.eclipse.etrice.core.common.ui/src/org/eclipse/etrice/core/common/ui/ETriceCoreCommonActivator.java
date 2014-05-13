package org.eclipse.etrice.core.common.ui;

import org.eclipse.etrice.core.common.scoping.ModelLocator;
import org.eclipse.etrice.core.common.ui.internal.BaseActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;

public class ETriceCoreCommonActivator extends BaseActivator {

	/* (non-Javadoc)
	 * @see org.franca.core.dsl.ui.internal.FrancaIDLActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		Injector injector = getInjector(ORG_ECLIPSE_ETRICE_CORE_COMMON_BASE);
		ModelLocator ml = injector.getInstance(ModelLocator.class);
		ml.loadExtensions();
	}

}
