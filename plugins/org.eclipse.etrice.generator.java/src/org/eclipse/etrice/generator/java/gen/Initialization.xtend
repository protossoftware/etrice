/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import org.eclipse.etrice.core.room.Attribute
import java.util.List
import com.google.inject.Inject
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.etrice.core.room.ComplexType
import org.eclipse.etrice.generator.generic.ILanguageExtension
import com.google.inject.Singleton
import org.eclipse.etrice.generator.base.IDataConfiguration
import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.core.room.PrimitiveType

@Singleton
class Initialization {

	@Inject extension TypeHelpers
	@Inject extension RoomExtensions
	@Inject ILanguageExtension languageExt
	@Inject IDataConfiguration dataConfigExt
	
	def attributeInitialization(List<Attribute> attribs, EObject roomClass, boolean useClassDefaultsOnly) {
		'''
			// initialize attributes
			«FOR a : attribs»
				«attributeInit(roomClass, new ArrayList<Attribute>.union(a), useClassDefaultsOnly)»
			«ENDFOR»
		'''
	}
	
	def private attributeInit(EObject roomClass, List<Attribute> path, boolean useClassDefaultsOnly) {
		var a = path.last
		if(a.refType.type.dataClass){
			var result = '''«(a.refType.type as DataClass).attributes.forEach(e | attributeInit(roomClass, path.union(e), useClassDefaultsOnly))»'''
			if(result.length > 0)
				result
		}
		else {
		'''
			«var aType = a.refType.type»
			«var value = a.getInitValueLiteral(roomClass)»
			«IF value!=null»
				«IF a.size == 0 || aType.characterType»
					«a.name» = «value»;
				«ELSEIF value.startsWith("{")»
					«a.name» = new «aType.typeName»[] «value»;
				«ELSE»
					«a.name» = new «aType.typeName»[«a.size»];
					for (int i=0;i<«a.size»;i++){
						«a.name»[i] = «value»;
					}
				«ENDIF»
			«ELSEIF aType instanceof ComplexType || a.size>1 || !useClassDefaultsOnly»
				«IF a.size==0»
					«IF a.refType.isRef»
						«a.name» = «languageExt.nullPointer()»;
					«ELSE»
						«a.name» = «languageExt.defaultValue(aType)»;
					«ENDIF»
				«ELSE»
					«a.name» = new «aType.typeName»[«a.size»];
					«IF !useClassDefaultsOnly»
						for (int i=0;i<«a.size»;i++){
							«a.name»[i] = «IF a.refType.isRef»«languageExt.nullPointer()»«ELSE»«languageExt.defaultValue(aType)»«ENDIF»;
						}
					«ENDIF»
				«ENDIF»
			«ENDIF»
		'''
		}
	}
	
	def private getInitValueLiteral(Attribute a, EObject roomClass){
		if(a.refType.type.primitive){
			var aType = a.refType.type as PrimitiveType
			var result = switch roomClass {
				ActorClass: dataConfigExt.getAttrClassConfigValue(roomClass, new ArrayList<Attribute>.union(a))
				PortClass: dataConfigExt.getAttrClassConfigValue(roomClass, new ArrayList<Attribute>.union(a))
			}
			if(result != null)
				return if(a.size == 0 || aType.characterType)
					languageExt.toValueLiteral(aType, result)
				else
					// array syntax ?
					'''{ «FOR s : result.split(",") SEPARATOR ' ,'»«languageExt.toValueLiteral(aType, s.trim)»«ENDFOR» }'''.toString
		}
		a.defaultValueLiteral
	}
}