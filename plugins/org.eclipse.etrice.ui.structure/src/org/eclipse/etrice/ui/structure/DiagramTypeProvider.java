/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure;

import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.ui.common.base.editor.AbstractBaseDiagramTypeProvider;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;
import com.google.inject.Injector;

//@SuppressWarnings("restriction")
public class DiagramTypeProvider extends AbstractBaseDiagramTypeProvider {

	private static final boolean USE_AUTO_UPDATE = true;

	public static final String PROVIDER_ID = "org.eclipse.etrice.ui.structure.diagramTypeProvider";
	
	private IToolBehaviorProvider[] toolBehaviorProviders;
	private ProviderDispatcher dispatcher;
	
	@Inject
	private IScopeProvider scopeProvider;

	public DiagramTypeProvider() {
		super();
        
		Injector injector = RoomUiModule.getInjector();
        injector.injectMembers(this);

        dispatcher = new ProviderDispatcher(this);
		setFeatureProvider(dispatcher.getFeatureProvider());
		
//		IEclipsePreferences node = new DefaultScope().getNode(GraphitiPlugin.PLUGIN_ID);
//		if (node!=null)
//			node.putBoolean(GFPreferences.RECURSIVE_CHECK_FOR_UPDATE_ACTIVE, true);
	}

	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders =
                new IToolBehaviorProvider[] {
            		dispatcher.getToolBehaviorProvider() };
        }
        return toolBehaviorProviders;
    }

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.dt.AbstractDiagramTypeProvider#isAutoUpdateAtStartup()
	 */
	@Override
	public boolean isAutoUpdateAtStartup() {
		return USE_AUTO_UPDATE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.dt.AbstractDiagramTypeProvider#isAutoUpdateAtReset()
	 */
	@Override
	public boolean isAutoUpdateAtReset() {
		return USE_AUTO_UPDATE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.dt.AbstractDiagramTypeProvider#isAutoUpdateAtRuntime()
	 */
	@Override
	public boolean isAutoUpdateAtRuntime() {
		return USE_AUTO_UPDATE;
	}
	
	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	@Override
	public DiagramAccessBase getDiagramAccess() {
		return new DiagramAccess();
	}
}
