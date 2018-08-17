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

	def generateCtorInitializerList(Iterable<? extends CharSequence> items){
		if(items.empty) return ''
		'''
			: «items.head»
			«FOR item : items.tail»
				, «item»
			«ENDFOR»
		'''
	}

	/*
	 *  Generate array and struct initialization
	 */
	def genExtraInitializers(Iterable<Attribute> attributes) {
		val extraInitAttrs = attributes.filter[initializerListValue == null && initValue != null && initValue.startsWith('{')]
		if(extraInitAttrs.empty) return ''
		'''
			// extra initialization
			«FOR it : extraInitAttrs.filter[size > 0]»
				«typeHelpers.getTypeName(it)» «name»InitValues[«size»] = «initValue»;
				«name» = «name»InitValues;
			«ENDFOR»
			«FOR it : extraInitAttrs.filter[size == 0]»
				«typeHelpers.getTypeName(it)» «name»InitValue = «initValue»;
				«name» = «name»InitValue;
			«ENDFOR»
		'''
	}

	def String getInitializerListValue(Attribute attribute) {
		val initValue = attribute.initValue
		return if(initValue != null && initValue.startsWith('{')) null else initValue
	}

	def protected getInitValue(Attribute attribute) {
		switch it : attribute {
			case defaultValueLiteral != null: defaultValueLiteral
			case type.ref: languageExt.nullPointer
			default: languageExt.defaultValue(type.type)
		}
	}

}
