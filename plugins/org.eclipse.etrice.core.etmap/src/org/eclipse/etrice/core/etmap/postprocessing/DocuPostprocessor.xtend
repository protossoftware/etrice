/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etmap.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import static extension org.eclipse.etrice.core.postprocessing.PostprocessingHelpers.*

class DocuPostprocessor {
		
	def process(GeneratedMetamodel metamodel) {
		val pckg = metamodel.EPackage
		
		//------------------------------------------------------------------
		var cls = pckg.getClass("MappingModel")
		cls.setDocumentation(
			'''
				The root object for the mapping model. It gives access to the mappings defined.
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The model name is a dot separated fully qualified name and is
				used to provide a name space.
			''')
		
		cls.getReference("imports").setDocumentation(
			'''
				A list of all imported models.
			''')
		
		cls.getReference("mappings").setDocumentation(
			'''
				A list of all defined mappings.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Mapping")
		cls.setDocumentation(
			'''
				This is the mapping of a logical system (defined in a ROOM model) to a
				physical system (defined in a physical model).
			''')
		
		cls.getReference("logicalSys").setDocumentation(
			'''
				This is the logical system being mapped.
			''')
		
		cls.getReference("physicalSys").setDocumentation(
			'''
				This is the physical system being mapped to.
			''')
		
		cls.getReference("subsysMappings").setDocumentation(
			'''
				This is a list of nested mappings of the sub systems of this system.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SubSystemMapping")
		cls.setDocumentation(
			'''
				This is the mapping of a sub system (defined in a ROOM model) to a
				node (defined in a physical model).
			''')
		
		cls.getReference("logicalSubSys").setDocumentation(
			'''
				This is the logical sub system being mapped.
			''')
		
		cls.getReference("node").setDocumentation(
			'''
				This is the node being mapped to.
			''')
		
		cls.getReference("threadMappings").setDocumentation(
			'''
				This is a list of nested mappings of logical to physical threads.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ThreadMapping")
		cls.setDocumentation(
			'''
				This is the mapping of a logical thread (defined in a ROOM model) to a
				physical thread (defined in a physical model).
			''')
		
		cls.getReference("logicalThread").setDocumentation(
			'''
				This is the logical thread being mapped.
			''')
		
		cls.getReference("physicalThread").setDocumentation(
			'''
				This is the physical thread being mapped to.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Import")
		cls.setDocumentation('''
			The import declares an imported model (given as a URI) and
			an optional imported namespace.
		''')
		
		cls.getAttribute("importedNamespace").setDocumentation(
			'''
				The imported name space has to be a dot separated qualified name followed by .*.
				Example: my.namespace.*
			''')
		
		cls.getAttribute("importURI").setDocumentation(
			'''
				The import URI can be a relative or absolute file system path.
				It may contain environment variables in ${} which will be expanded.
				<p>
				Examples:
				<ul>
				  <li>import model "AnotherModel.room"</li>
				  <li>import my.namespace.* from "AnotherModel.room"</li>
				  <li>import my.namespace.* from "../../AnotherProject/models/AnotherModel.room"</li>
				  <li>import my.namespace.* from "/${ROOM_MODELS}/SomeModel.room"</li>
				</ul>
				</p>
			''')
	}
	
}