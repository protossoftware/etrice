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

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import java.util.List
import java.util.ArrayList

class ConfigGenAddon {
	
	@Inject extension JavaExtensions stdExt
	@Inject extension TypeHelpers typeHelpers
	@Inject extension ProcedureHelpers helpers
	@Inject IDataConfiguration dataConfigExt
	@Inject extension RoomExtensions
	
	// For SubSystemClassGen
	
	def public genActorInstanceConfig(ActorInstance ai){'''
		�FOR a : ai.actorClass.attributes�
			�applyInstanceConfig(ai, "inst", ai.path+"/"+a.name, a)�
		�ENDFOR�
		'''
	}
	
	def public applyInstanceConfig(ActorInstance ai, String invokes, String instancePath, Attribute a){
		var aType = a.refType.type
		if(aType.primitive){
			var value = dataConfigExt.getAttrInstanceConfigValue(ai, instancePath)
			if(value == null)
				''''''
			else if(a.size == 0 || aType.characterType)
				'''�invokes�.�a.name.invokeSetter(null, (aType as PrimitiveType).toValueLiteral(value))�;'''
			else if(a.size == value.split(",").size){
				var arrayExpr = '''�FOR s : value.split(",") SEPARATOR ','��(aType as PrimitiveType).toValueLiteral(s.trim)��ENDFOR�'''
				'''�invokes�.�a.name.invokeSetter(null, '''new �aType.typeName�[]�arrayExpr�'''.toString)�'''
			} else
				'''{
						�aType.typeName�[] array = �invokes�.�a.name.invokeGetter(null)�;
						for (int i=0;i<�a.size�;i++){
							array[i] = �(aType as PrimitiveType).toValueLiteral(value)�;
					}'''
		}
		else if (aType.dataClass)
			'''�FOR e : (aType as DataClass).attributes�
					�applyInstanceConfig(ai, invokes+"."+a.name.invokeGetter(null), instancePath+"/"+e.name, e)�
				�ENDFOR�'''
	}
	
	// For ActorClassGen
	
//	def public genDynConfigGetterSetter(ActorClass ac){'''
//		�FOR a : dataConfigExt.getAllDynConfigReadAttributes(ac)�
//			public �a.refType.type.typeName��IF a.size>0�[]�ENDIF� get�a.name.toFirstUpper�(){
//				if(lock_�a.name� == null)
//					return �a.name�;
//				else
//					synchronized(lock_�a.name�){
//						return �a.name�;
//					}
//			}
//			public void set�a.name.toFirstUpper�(�a.refType.type.typeName��IF a.size>0�[]�ENDIF� �a.name�){
//				if(lock_�a.name� == null)
//					this.�a.name� = �a.name�;
//				else
//					synchronized(lock_�a.name�){
//						this.�a.name� = �a.name�;
//					}
//			}
//			public DynConfigLock get�a.name.toFirstUpper�Lock(){
//				return lock_�a.name�;
//			}	
//		�ENDFOR�
//		�FOR a : dataConfigExt.getAllDynConfigWriteAttributes(ac)�
//			public void setAndWrite�a.name.toFirstUpper�(�a.refType.type.typeName��IF a.size>0�[]�ENDIF� �a.name�){
//					set�a.name.toFirstUpper�(�a.name�);
//					variableService.write(this.getInstancePath()+"/�a.name�", �a.name�);
//			}
//		�ENDFOR�
//	'''}

	def genDynConfigGetterSetter(ActorClass ac){
		
	}
	
	def public genMinMaxConstants(ActorClass ac){
		var result = '''
			�FOR a : ac.attributes�
				�genMinMaxConstantsRec(ac, a.name, new ArrayList<Attribute>().union(a))�
			�ENDFOR�
		'''
		if(result.length != 0)
			result = result+'''//--------------------- Attribute Specifications'''
		return result
	}
	
	def private genMinMaxConstantsRec(ActorClass ac, String varNamePath, List<Attribute> path){
		var temp = null as String
		if(path.last.refType.type.dataClass)
			'''
				�FOR e : (path.last.refType.type as DataClass).allAttributes�
					�genMinMaxConstantsRec(ac, varNamePath+"_"+e.name, path.union(e))�
				�ENDFOR�
			'''
		else {
			var aType = (path.last.refType.type as PrimitiveType)
			'''
				�IF (temp = dataConfigExt.getAttrClassConfigMinValue(ac, path)) != null�
					public static �aType.minMaxType� MIN_�varNamePath� = �aType.toValueLiteral(temp)�;
				�ENDIF�
				�IF (temp = dataConfigExt.getAttrClassConfigMaxValue(ac, path)) != null�
					public static �aType.minMaxType� MAX_�varNamePath� = �aType.toValueLiteral(temp)�;
				�ENDIF�
			'''
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