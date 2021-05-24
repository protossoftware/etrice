/*******************************************************************************
 * Copyright (c) 2021 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ide.server;

import java.util.concurrent.ExecutorService;

import org.eclipse.etrice.core.common.ide.modelpath.ModelPathManager;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.xtext.ide.ExecutorServiceProvider;
import org.eclipse.xtext.ide.server.BuildManager;
import org.eclipse.xtext.ide.server.IMultiRootWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.IProjectDescriptionFactory;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ResourceServiceProviderServiceLoader;
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Module for a language server that supports the modelpath import mechanism.
 * 
 * @see org.eclipse.xtext.ide.server.ServerModule
 */
public class ServerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ExecutorService.class).toProvider(ExecutorServiceProvider.class);

		bind(IResourceServiceProvider.Registry.class).toProvider(ResourceServiceProviderServiceLoader.class);
		bind(IContainer.Manager.class).to(ProjectDescriptionBasedContainerManager.class);
		
		bind(LanguageServer.class).to(LanguageServerImpl.class);
		bind(LanguageServerImpl.class).to(ModelLanguageServer.class);
		bind(WorkspaceManager.class).to(DependencyAwareWorkspaceManager.class);
		bind(IMultiRootWorkspaceConfigFactory.class).to(ModelWorkspaceConfigFactory.class);
		bind(BuildManager.class).to(DependencyAwareBuildManager.class);
		bind(ProjectManager.class).to(ModelProjectManager.class);
		bind(IProjectDescriptionFactory.class).to(ModelProjectDescriptionFactory.class);
		bind(ModelPathManager.class).in(Singleton.class);
	}
}
