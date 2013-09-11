/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 		Eyrak Paen
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import static extension org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers.*

class DocuPostprocessor {
	def process(GeneratedMetamodel metamodel) {
		val pckg = metamodel.EPackage
		//------------------------------------------------------------------
		var cls = pckg.getClass("LiteralArray")
		cls.setDocumentation(
			'''
				Aggregates one or more {@link Literal literals}.		
			''')
			
		cls.getReference("literals").setDocumentation(
			'''
				This is a list of literals.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("Literal")
		cls.setDocumentation(
			'''
				It is the super class of
				<ul>
					<li>{@link BooleanLiteral}</li>
					<li>{@link NumberLiteral}</li>
					<li>{@link StringLiteral}</li>
				</ul>
				that represents a primitive value.
			''')
	}
}