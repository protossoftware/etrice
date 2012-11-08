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
	
	def attributeInitialization(List<Attribute> attribs, EObject roomClass, boolean useClassDefaultsOnly) {	
		var tmp = ''''''
		'''
			// initialize attributes
			«FOR a : attribs»
				«tmp = dataConfigurationInit(roomClass, new ArrayList<Attribute>.union(a))»
				«IF tmp.length==0»«(tmp = valueInit(new ArrayList<Attribute>.union(a), getRoomDefaulValue(a)))»«ENDIF»
				«IF tmp.length==0»«defaultInit(a, useClassDefaultsOnly)»«ENDIF»
			«ENDFOR»
		'''
	}	
	def private dataConfigurationInit(EObject roomClass, List<Attribute> path){
		var a = path.last
		var aType = a.refType.type
		if(aType.dataClass){
			return '''
				«FOR e : (aType as DataClass).attributes»
					«dataConfigurationInit(roomClass, path.union(e))»
				«ENDFOR»
			'''
		}
		else if(aType.primitive)
		 	return valueInit(path, getDataConfigValue(roomClass, path))
		''''''
	}
	
	def private valueInit(List<Attribute> path, String literalValue){
		if(literalValue == null) return ''''''
		var a = path.last
		var aType = a.refType.type
		var getter = if(path.size > 1)procedureHelpers.invokeGetters(path.take(path.size-1), null)+"." else ""
		'''
			«IF a.size == 0 || aType.characterType»
					«getter»«procedureHelpers.invokeSetter(a.name,null,literalValue)»;
				«ELSEIF literalValue.startsWith("{")»
					«getter»«procedureHelpers.invokeSetter(a.name,null, '''new «aType.typeName»[] «literalValue»''')»;
				«ELSE»
					{
						«aType.typeName»[] _«a.name» = new «aType.typeName»[«a.size»];
						for (int i=0;i<«a.size»;i++){
							_«a.name»[i] = «literalValue»;
						}
						«getter»«procedureHelpers.invokeSetter(a.name,null,"_"+a.name)»;
					}
			«ENDIF»
		'''
	}
	
	def private defaultInit(Attribute a, boolean useClassDefaultsOnly){
		'''
			«IF a.refType.type instanceof ComplexType || a.size>1 || !useClassDefaultsOnly»
				«IF a.size==0»
					«IF a.refType.isRef»
						«a.name» = «languageExt.nullPointer()»;
					«ELSE»
						«a.name» = «languageExt.defaultValue(a.refType.type)»;
					«ENDIF»
				«ELSE»
					«a.name» = new «a.refType.type.typeName»[«a.size»];
					«IF !useClassDefaultsOnly»
						for (int i=0;i<«a.size»;i++){
							«a.name»[i] = «IF a.refType.isRef»«languageExt.nullPointer()»«ELSE»«languageExt.defaultValue(a.refType.type)»«ENDIF»;
						}
					«ENDIF»
				«ENDIF»
			«ENDIF»
		'''
	}
	
	def String getRoomDefaulValue(Attribute a){ 
		if(a.refType.type.primitive && a.defaultValueLiteral != null)
			languageExt.toValueLiteral(a.refType.type as PrimitiveType, a.defaultValueLiteral)
	}
	
	def private String getDataConfigValue(EObject roomClass, List<Attribute> path){
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
				return languageExt.toValueLiteral(aType, result)
		}
	}
	
}