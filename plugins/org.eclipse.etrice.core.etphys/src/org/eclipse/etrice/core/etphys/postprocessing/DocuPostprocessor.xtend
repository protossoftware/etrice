/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etphys.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import static extension org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers.*

class DocuPostprocessor {
		
	def process(GeneratedMetamodel metamodel) {
		val pckg = metamodel.EPackage
		
		//------------------------------------------------------------------
		var cls = pckg.getClass("PhysicalModel")
		cls.setDocumentation(
			'''
				The root object for the physical model. It gives access to the systems, node classes
				and runtimes defined.
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
		
		cls.getReference("systems").setDocumentation(
			'''
				A list of all defined physical systems.
			''')
		
		cls.getReference("nodeClasses").setDocumentation(
			'''
				A list of all defined node classes.
			''')
			
		cls.getReference("runtimeClasses").setDocumentation(
			'''
				A list of all defined runtime classes.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("PhysicalSystem")
		cls.setDocumentation(
			'''
				This model object represents a complete physical system.
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the physical system by which it is referred to in the model.
			''')
			
		cls.getReference("nodeRefs").setDocumentation(
			'''
				A list of referenced nodes.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("NodeRef")
		cls.setDocumentation(
			'''
				This stands for a node instance in a specific role.
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the reference by which it is referred to in the model.
			''')
			
		cls.getReference("type").setDocumentation(
			'''
				The node class of this reference.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("NodeClass")
		cls.setDocumentation(
			'''
				This defines a node class.
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the node class by which it is referred to in the model.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		cls.getReference("runtime").setDocumentation(
			'''
				This is the associated runtime class.
			''')
		
		cls.getAttribute("priomin").setDocumentation(
			'''
				This is the minimal thread priority for this node type.
			''')
		
		cls.getAttribute("priomax").setDocumentation(
			'''
				This is the maximum thread priority for this node type.
			''')
			
		cls.getReference("threads").setDocumentation(
			'''
				This is a list of all threads defined for this node.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("PhysicalThread")
		cls.setDocumentation(
			'''
				This defines a physical thread running in a node.
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the thread by which it is referred to in the model.
			''')
		
		cls.getAttribute("default").setDocumentation(
			'''
				If this is {@code true} then this is the default thread.
			''')
		
		cls.getAttribute("execmode").setDocumentation(
			'''
				This is the execution mode of the thread.
			''')
		
		cls.getAttribute("prio").setDocumentation(
			'''
				This is the priority of the thread.
			''')
		
		cls.getAttribute("stacksize").setDocumentation(
			'''
				This is the stacksize of the thread.
			''')
		
		cls.getAttribute("msgblocksize").setDocumentation(
			'''
				This is the msgblocksize of the thread.
			''')
		
		cls.getAttribute("msgpoolsize").setDocumentation(
			'''
				This is the msgpoolsize of the thread.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RuntimeClass")
		cls.setDocumentation(
			'''
				This defines a runtime class.
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the runtime class by which it is referred to in the model.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		cls.getAttribute("threadModel").setDocumentation(
			'''
				This distinguishes single and multi threaded.
			''')

	}
	
}