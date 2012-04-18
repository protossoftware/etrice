/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.doc.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.generator.etricegen.Root
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.etrice.generator.generic.PrepareFileSystem


@Singleton
class MainGen implements IGenerator {
	
	@Inject InstanceDiagramGen instanceDiagramGen
	@Inject PrepareFileSystem prepFS
	@Inject DocGen docGen
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		prepFS.prepare(resource)
		for (e: resource.contents){
			if (e instanceof Root) {
				doGenerate(e as Root)
			}
		}
	}
	
	def void doGenerate(Root e) {
		instanceDiagramGen.doGenerate(e);
		docGen.doGenerate(e);
	}
}