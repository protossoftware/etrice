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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.common.ide.modelpath.ModelPathManager;
import org.eclipse.etrice.generator.base.io.IModelPath;
import org.eclipse.etrice.generator.base.io.ResourceSetModelPathProvider;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;

import com.google.inject.Inject;

/**
 * A project manager that installs the corresponding modelpath on the resource set of the project.
 */
public class ModelProjectManager extends ProjectManager {
	
	private static final Logger LOG = Logger.getLogger(ModelProjectManager.class);
	
	@Inject
	private ModelPathManager modelpathManager;
	
	@Override
	public XtextResourceSet createNewResourceSet(ResourceDescriptionsData newIndex) {
		XtextResourceSet resourceSet = super.createNewResourceSet(newIndex);
		resourceSet.eAdapters().add(new ResourceAddedAdapter());
		return resourceSet;
	}
	
	@Override
	protected XtextResourceSet createFreshResourceSet(ResourceDescriptionsData newIndex) {
		XtextResourceSet resourceSet = super.createFreshResourceSet(newIndex);
		if(getBaseDir() != null) {
			IModelPath modelpath = modelpathManager.getModelPath(getBaseDir().toString());
			ResourceSetModelPathProvider.install(resourceSet, modelpath);
		}
		return resourceSet;
	}
	
	/** Resource adapter that logs the uris of loaded resources */
	private class ResourceAddedAdapter extends AdapterImpl {
		@Override
		public void notifyChanged(Notification msg) {
			if(msg.getEventType() == Notification.ADD) {
				Resource addedResource = (Resource) msg.getNewValue();
				LOG.debug("Project " + getProjectDescription().getName() + " loaded resource " + addedResource.getURI());
			}
		}
	}
}
