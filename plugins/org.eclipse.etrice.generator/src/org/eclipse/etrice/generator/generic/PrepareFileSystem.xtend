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

package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import com.google.inject.Singleton
import java.io.File
import java.util.Collection
import java.util.HashSet
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.fsm.ILogger
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

/**
 * A class that is used to recursively erase all folders receiving generated code
 * an to place a readme file into those folders.
 */
@Singleton
class PrepareFileSystem {
	
	@Inject extension RoomExtensions
	@Inject JavaIoFileSystemAccess fileAccess
	@Inject ILogger logger
	
	def void prepareCodeTargetPaths(Resource resource) {
		var Set<String> pathes = new HashSet<String>();
		for (e: resource.contents){
			if (e instanceof Root) {
				for (mdl : (e as Root).models) {
					val tgtpath = mdl.generationTargetPath
					if (tgtpath!=null && !tgtpath.empty)
						pathes.add(tgtpath)
				}
			}
		}
		prepare(pathes)
	}
	
	def void prepareDocTargetPaths(Resource resource) {
		var Set<String> pathes = new HashSet<String>();
		for (e: resource.contents){
			if (e instanceof Root) {
				for (mdl : (e as Root).models) {
					val tgtpath = mdl.docGenerationTargetPath
					if (tgtpath!=null && !tgtpath.empty)
						pathes.add(tgtpath)
				}
			}
		}
		prepare(pathes)
	}
	
	/**
	 * Recursively erase all folders receiving generated code
	 * and place a readme file in those folders.
	 * The folders are determined from the used models of every generator
	 * model found in the resource.
	 * 
	 * @param resource a {@link Resource}
	 */
	def void prepare(Collection<String> pathes) {
		for (path : pathes) {
			logger.logInfo("clearing "+path)
			var f = new File(path)
			f.eraseContents
			fileAccess.setOutputPath(path)
			fileAccess.generateFile("readme.txt", readmeText)
		}
	}
	
	def private void eraseContents(File f) {
		if (f.directory) {
			var children = f.listFiles
			for (child : children) {
				if (!(child.directory && child.name.equals("images"))) {
					eraseContents(child)
					child.delete
				}
			}
		}
	}
	
	def private readmeText() {
		'''
			This directory is an eTrice code generation target.
			It will be erased every time the generator is executed.
			
			DO NOT PLACE OTHER FILES HERE!
		'''
	}
}