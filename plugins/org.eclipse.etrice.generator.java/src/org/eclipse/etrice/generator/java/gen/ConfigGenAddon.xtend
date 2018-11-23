/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers

class ConfigGenAddon {
	
	@Inject extension JavaExtensions stdExt
	@Inject extension TypeHelpers typeHelpers
	@Inject extension ProcedureHelpers helpers
	@Inject IDataConfiguration dataConfigExt
	@Inject extension RoomHelpers
	@Inject extension RoomExtensions
	@Inject Initialization initGen
	
	// For SubSystemClassGen
	
	def genActorInstanceConfig(ActorInstance ai, String aiVariableName){'''
			«FOR a : ai.actorClass.allAttributes»
				«applyInstanceConfig(ai, aiVariableName, new ArrayList<Attribute>().union(a))»
			«ENDFOR»
			«FOR pi : ai.orderedIfItemInstances»
				«var attribs = getPortClass(pi.interfaceItem)?.attributes»
				«IF attribs !== null»
					«FOR a : attribs»
						«applyInstanceConfig(pi, aiVariableName+"."+invokeGetter(pi.name, null), new ArrayList<Attribute>().union(a))»
					«ENDFOR»
				«ENDIF»
			«ENDFOR»
		'''
	}
	
	def private CharSequence applyInstanceConfig(InstanceBase instance, String invokes, List<Attribute> path){
		var a = path.last
		var aType = a.type.type		
		switch aType {
			PrimitiveType: {
				var value = typeHelpers.getAttrInstanceConfigValue(path, instance)
				if(value !== null)
					initGen.genAttributeInitializer(a, toValueLiteral(aType, value), invokes)	
			}
			EnumerationType: {
				var value = typeHelpers.getAttrInstanceConfigValue(path, instance)
				if(value !== null)
					initGen.genAttributeInitializer(a, value, invokes)
			}
			DataClass:
				'''
					«FOR e : aType.allAttributes»
						«applyInstanceConfig(instance, invokes+"."+a.name.invokeGetter(null), path.union(e))»
					«ENDFOR»
				'''	
		}	
	}
	
	// For ActorClassGen
	
	def genDynConfigGetterSetter(ActorClass ac){'''
		«FOR a : dataConfigExt.getDynConfigReadAttributes(ac)»
			public «a.type.type.typeName»«IF a.size>0»[]«ENDIF» get«a.name.toFirstUpper»(){
				if(lock_«a.name» == null)
					return «a.name»;
				else
					synchronized(lock_«a.name»){
						return «a.name»;
					}
			}
			public void set«a.name.toFirstUpper»(«a.type.type.typeName»«IF a.size>0»[]«ENDIF» «a.name»){
				if(lock_«a.name» == null)
					this.«a.name» = «a.name»;
				else
					synchronized(lock_«a.name»){
						this.«a.name» = «a.name»;
					}
			}
			public DynConfigLock get«a.name.toFirstUpper»Lock(){
				return lock_«a.name»;
			}	
		«ENDFOR»
		«FOR a : dataConfigExt.getDynConfigWriteAttributes(ac)»
			public void setAndWrite«a.name.toFirstUpper»(«a.type.type.typeName»«IF a.size>0»[]«ENDIF» «a.name»){
					set«a.name.toFirstUpper»(«a.name»);
					getVariableService().write(this.getInstancePath()+"/«a.name»", «a.name»);
			}
		«ENDFOR»
	'''}
	
	def genMinMaxConstants(ActorClass ac){
		var result = '''
			«FOR a : ac.allAttributes»
				«genMinMaxConstantsRec(ac, a.name, new ArrayList<Attribute>().union(a))»
			«ENDFOR»
		'''
		if(result.length != 0)
			result = result+'''//--------------------- Attribute Specifications'''
		return result
	}
	
	def private CharSequence genMinMaxConstantsRec(ActorClass ac, String varNamePath, List<Attribute> path){
		var aType = path.last.type.type
		switch aType {
			DataClass:
				'''
					«FOR e : aType.allAttributes»
						«genMinMaxConstantsRec(ac, varNamePath+"_"+e.name, path.union(e))»
					«ENDFOR»
				'''
			PrimitiveType:{
				var temp = null as String
				'''
					«IF (temp = dataConfigExt.getAttrClassConfigMinValue(ac, path)) !== null»
						public static «aType.minMaxType» MIN_«varNamePath» = «aType.toValueLiteral(temp)»;
					«ENDIF»
					«IF (temp = dataConfigExt.getAttrClassConfigMaxValue(ac, path)) !== null»
						public static «aType.minMaxType» MAX_«varNamePath» = «aType.toValueLiteral(temp)»;
					«ENDIF»
				'''
			}
		}
	}
	
	def private getMinMaxType(PrimitiveType type){
		return switch(type.typeName){
			case "byte":
				"int"
			case "short":
				"int"
			case "float":
				"double"
			default:
				type.typeName
		}
	}
	
}
