/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.modelpath;

import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.generator.base.io.IModelPath;
import org.eclipse.etrice.generator.base.io.ResourceSetModelPathProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.ui.resource.IResourceSetInitializer;

/**
 * Adds the modelpath to the resource set load options.
 */
public class ModelPathResourceSetInitializer implements IResourceSetInitializer {

	@Override
	public void initialize(ResourceSet resourceSet, IProject project) {
		if(project != null) {
			ModelPathDelegate modelPath = new ModelPathDelegate(project);
			resourceSet.getLoadOptions().put(ResourceSetModelPathProvider.LOAD_OPTION_MODELPATH, modelPath);
		}
	}
	
	private class ModelPathDelegate implements IModelPath {
		
		private IProject project;
		
		public ModelPathDelegate(IProject project) {
			this.project = project;
		}
		
		@Override
		public Stream<ModelFile> getFiles(QualifiedName name) {
			return ModelPathManager.INSTANCE.getModelPath(project).getFiles(name);
		}

		@Override
		public Stream<ModelFile> getAllFiles() {
			return ModelPathManager.INSTANCE.getModelPath(project).getAllFiles();
		}

		@Override
		public Optional<QualifiedName> getQualifiedName(URI uri) {
			return ModelPathManager.INSTANCE.getModelPath(project).getQualifiedName(uri);
		}
		
		@Override
		public boolean isEmpty() {
			return ModelPathManager.INSTANCE.getModelPath(project).isEmpty();
		}
	}
}
