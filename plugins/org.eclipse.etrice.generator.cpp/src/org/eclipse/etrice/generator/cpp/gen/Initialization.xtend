/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Peter Karlitschek
 *
 *******************************************************************************/
package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.TypeHelpers

@Singleton
class Initialization {

	@Inject ILanguageExtension languageExt
	@Inject TypeHelpers typeHelpers

	def generateCtorInitializerList(Iterable<? extends CharSequence> items) '''
		«FOR s : items BEFORE ':' SEPARATOR ','»«s»
		«ENDFOR»
	'''

	def genArrayInitializers(Iterable<Attribute> attributes) {
		val arrayInitAttrs = attributes.filter[size > 0 && defaultValueLiteral != null && defaultValueLiteral.startsWith('{')]
		if(arrayInitAttrs.empty) return ''
		'''
			// array initialization
			«FOR it : arrayInitAttrs»
				«typeHelpers.getTypeName(it)» «name»InitValues[«size»] = «defaultValueLiteral»;
				«name» = «name»InitValues;
			«ENDFOR»
		'''
	}

	def String getInitializerListValue(Attribute attribute) {
		switch it : attribute {
			case defaultValueLiteral != null: if(defaultValueLiteral.startsWith('{')) null else defaultValueLiteral
			case type.ref: languageExt.nullPointer
			default: languageExt.defaultValue(type.type)
		}
	}

}
