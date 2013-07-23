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
import java.util.List
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.ComplexType
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers

@Singleton
class Initialization {

	@Inject extension TypeHelpers
	@Inject extension RoomExtensions
	@Inject ILanguageExtension languageExt
	@Inject IDataConfiguration dataConfigExt
	@Inject ProcedureHelpers procedureHelpers
	
	def attributeInitialization(List<Attribute> attribs, boolean useClassDefaultsOnly) {
		'''
			// initialize attributes
			«FOR a : attribs»
				«var aType = a.refType.type»
				«var value = a.defaultValueLiteral»
				«IF value!=null»
					«IF a.size == 0 || aType.characterType»
					«ELSEIF value.startsWith("{")»
						«initializeArrayWithValues(a.name, value.replace("{", "").replace("}", "").split(","))»
					«ELSE»
						for (int i=0;i<«a.size»;i++){
							«a.name»[i] = «value»;
						}
					«ENDIF»
				«ELSEIF aType instanceof ComplexType || a.size>1 || !useClassDefaultsOnly»
					«IF a.size==0»
					«ELSE»
						«IF !useClassDefaultsOnly»
							for (int i=0;i<«a.size»;i++){
								«a.name»[i] = «IF a.refType.isRef»«languageExt.nullPointer()»«ELSE»«languageExt.defaultValue(aType)»«ENDIF»;
							}
						«ENDIF»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		'''
	}
	
	def initializeArrayWithValues(String varName, String[] values) {
		'''
		«var i = -1»
		«FOR v : values»
			«varName»[«i=i+1»] = «v»;
		«ENDFOR»
		'''
	}

	def attributeInitialization(Attribute a, boolean useClassDefaultsOnly) {
		var aType = a.refType.type
		var value = a.defaultValueLiteral
		if (value != null) {
				if (a.size == 0 || aType.characterType) {
					if (a.refType.isRef) 
						'''«a.name»(new «aType.name»(«value»))'''
					else
						'''«a.name»(«value»)'''
				}
				else if (value.startsWith("{")) {
					'''«a.name»()'''
				}
				else {
					'''«a.name»()'''
				}
		} 
		else if (aType instanceof ComplexType || a.size>1 || !useClassDefaultsOnly) {
			if (a.size==0) {
				if (a.refType.isRef)
					'''«a.name»(«languageExt.nullPointer()»)'''
				else
					'''«a.name»(«languageExt.defaultValue(aType)»)'''
			}
			else 
				'''«a.name»()'''
		}
	}
	
	
}