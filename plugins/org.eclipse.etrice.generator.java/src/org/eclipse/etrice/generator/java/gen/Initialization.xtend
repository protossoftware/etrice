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

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.ComplexType
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.etrice.generator.generic.ProcedureHelpers

@Singleton
class Initialization {

	@Inject extension TypeHelpers
	@Inject extension RoomExtensions
	@Inject ILanguageExtension languageExt
	@Inject IDataConfiguration dataConfigExt
	@Inject ProcedureHelpers procedureHelpers
	
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
		var aType = a.refType.type
		if(aType.dataClass){
			var result = 
				'''
					«FOR e : (aType as DataClass).attributes»
						«attributeInit(roomClass, path.union(e), useClassDefaultsOnly)»
					«ENDFOR»
				'''
			if(result.length > 0)
				return result
		}
		
		var value = getInitValueLiteral(roomClass, path)
		var getter = if(path.size > 1)procedureHelpers.invokeGetters(path.take(path.size-1), null)+"." else ""
		return 
		'''
			«IF value!=null»
				«IF a.size == 0 || aType.characterType»
					«getter»«procedureHelpers.invokeSetter(a.name,null,value)»;
				«ELSEIF value.startsWith("{")»
					«getter»«procedureHelpers.invokeSetter(a.name,null, '''new «aType.typeName»[] «value»''')»;
				«ELSE»
					{
						«aType.typeName»[] _«a.name» = new «aType.typeName»[«a.size»];
						for (int i=0;i<«a.size»;i++){
							_«a.name»[i] = «value»;
						}
						«getter»«procedureHelpers.invokeSetter(a.name,null,"_"+a.name)»;
					}
				«ENDIF»
			«ELSEIF path.size == 1 && (aType instanceof ComplexType || a.size>1 || !useClassDefaultsOnly)»
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
	
	def private getInitValueLiteral(EObject roomClass, List<Attribute> path){
		var a = path.last
		if(a.refType.type.primitive){
			var aType = a.refType.type as PrimitiveType
			var result = switch roomClass {
				ActorClass: dataConfigExt.getAttrClassConfigValue(roomClass, path)
				PortClass: 
					if(roomClass.eContainer instanceof ProtocolClass){
						var pc = roomClass.eContainer as ProtocolClass
						dataConfigExt.getAttrClassConfigValue(pc, pc.regular.equals(roomClass), path)
					}
			}
			if(result != null)
				return if(a.size == 0 || aType.characterType)
					languageExt.toValueLiteral(aType, result)
				else
					// array syntax ?
					'''{ «FOR s : result.split(",") SEPARATOR ' ,'»«languageExt.toValueLiteral(aType, s.trim)»«ENDFOR» }'''.toString
		}
		if(path.size == 1)
			a.defaultValueLiteral
	}
}