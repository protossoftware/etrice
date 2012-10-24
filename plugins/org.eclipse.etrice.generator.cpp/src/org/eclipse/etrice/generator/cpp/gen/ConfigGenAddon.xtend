/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import java.util.List
import org.eclipse.etrice.core.config.AttrInstanceConfig
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.generator.generic.ConfigExtension
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.TypeHelpers


class ConfigGenAddon {
	
	@Inject extension CppExtensions stdExt
	@Inject extension TypeHelpers typeHelpers
	@Inject extension ProcedureHelpers helpers
	@Inject extension ConfigExtension configExt
	
	// For SubSystemClassGen
	
	def public applyInstanceConfig(String instance, String className, List<AttrInstanceConfig> attrConfigs){'''
		«FOR attrConfig : attrConfigs»
			«var a = attrConfig.attribute»
			«var aType = a.refType.type»
			«IF aType.primitive»
				«var values = attrConfig.value?.values»
				«IF values == null»
				«ELSEIF a.size == 0 || aType.characterType»
					«instance».«a.name.invokeSetter(className, (aType as PrimitiveType).toValueLiteral(values.get(0)))»;
				«ELSEIF a.size == values.size»
					«instance».«a.name.invokeSetter(className, "new "+aType.typeName+"[]"+(aType as PrimitiveType).toArrayValueLiteral(values))»;
				«ELSE»
					{
						«aType.typeName»[] array = «instance».«a.name.invokeGetter(className)»;
						for (int i=0;i<«a.size»;i++){
							array[i] = «(aType as PrimitiveType).toValueLiteral(values.get(0))»;
						}
					}
				«ENDIF»
			«ELSEIF aType.dataClass»
				«(instance+"."+a.name.invokeGetter(className)).applyInstanceConfig(aType.typeName, attrConfig.attributes)»
			«ENDIF»
		«ENDFOR»
	'''}
	
	// For ActorClassGen
	
	def public genDynConfigGetterSetter(ActorClass ac){'''
		«FOR a : ac.getDynConfigAttributes(true, false)»
			public «a.refType.type.typeName»«IF a.size>0»[]«ENDIF» get«a.name.toFirstUpper»(){
				if(lock_«a.name» == null)
					return «a.name»;
				else
					synchronized(lock_«a.name»){
						return «a.name»;
					}
			}
			public void set«a.name.toFirstUpper»(«a.refType.type.typeName»«IF a.size>0»[]«ENDIF» «a.name»){
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
		«FOR a : ac.getDynConfigAttributes(false, true)»
			public void setAndWrite«a.name.toFirstUpper»(«a.refType.type.typeName»«IF a.size>0»[]«ENDIF» «a.name»){
					set«a.name.toFirstUpper»(«a.name»);
					variableService.write(this.getInstancePath()+"/«a.name»", «a.name»);
			}
		«ENDFOR»
	'''}
	
	def public genMinMaxConstants(ActorClass ac){
		var attrConfigs = ac.allAttrConfigFlat.filter(c | c.min != null || c.max != null)
		'''
		«IF !attrConfigs.empty»
			//--------------------- attribute specifications
		«ENDIF»
			
		«FOR c : attrConfigs»
			«var aType = (c.attribute.refType.type as PrimitiveType)»
			«IF c.min != null»
				public static «aType.minMaxType» MIN«c.getPath(false, false, true, true).toPath("_")» = «aType.toValueLiteral(c.min.value)»;
			«ENDIF»
			«IF c.max != null»
				public static «aType.minMaxType» MAX«c.getPath(false, false, true, true).toPath("_")» = «aType.toValueLiteral(c.max.value)»;
			«ENDIF»
		«ENDFOR»
		'''
	}
	
	def private getMinMaxType(PrimitiveType type){
		switch(type.typeName){
			case "byte":
				return "int"
			case "short":
				return "int"
			case "float":
				return "double"
		}
		return type.typeName
	}
}