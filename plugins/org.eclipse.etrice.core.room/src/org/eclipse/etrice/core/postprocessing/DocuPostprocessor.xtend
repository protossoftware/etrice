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

package org.eclipse.etrice.core.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.etrice.core.postprocessing.PostprocessingHelpers.*

/**
 * This post processor adds documentation to the generated EMF model.
 * By intention no {@code null} checks are performed. This way developers
 * find easier if the referenced class, attribute or reference isn't found.
 */
class DocuPostprocessor {
		
	def process(GeneratedMetamodel metamodel) {
		val pckg = metamodel.EPackage
		
		var cls = pckg.getClass("RoomModel")
		cls.setDocumentation(
			'''
				The root object for the ROOM model. It gives access to {@link Import imports} and
				the {@link SubSystemClass sub system},
				{@link ActorClass actor}, {@link ProtocolClass protocol} and
				{@link DataClass data} classes defined.
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The model name is a dot separated fully qualified name and is
				used to provide a name space. The generators may use that also
				to place the generated code into separate directories.
			''')
			
		cls = pckg.getClass("Import")
		cls.setDocumentation(
			'''
				The import references another ROOM model. Optionally it may import also
				the name space of the imported model.
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
			
		cls = pckg.getClass("DataClass")
		cls.setDocumentation(
			'''
				The data class in ROOM is a {@link ComplexType} which has {@link Attribute} members.
				It can be derived from a single base data class. 
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the data class by which it is referred to in the model.
			''')
		
		cls.getReference("base").setDocumentation(
			'''
				The base class from which all attributes and operations are inherited.
			''')
		
		cls.getReference("attributes").setDocumentation(
			'''
				Attributes are the data members of the data class.
			''')
		
		cls.getReference("operations").setDocumentation(
			'''
				Operations are the methods of the data class.
			''')
	}
	
}