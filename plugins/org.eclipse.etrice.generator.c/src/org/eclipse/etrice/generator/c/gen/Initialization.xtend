package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers

class Initialization {
	
	@Inject CExtensions languageExt
	@Inject extension RoomExtensions
	@Inject extension TypeHelpers
	@Inject IDataConfiguration dataExt
	
	def generateAttributeInit(InstanceBase instance, List<Attribute> attributes){'''
		«FOR a : attributes SEPARATOR ','»
			«initAttributeArray(instance, new ArrayList<Attribute>.union(a))»
		«ENDFOR»
		'''		
	}
	
	def private initAttributeArray(InstanceBase instance, List<Attribute> path){
		var a = path.last
		var COMMENT = '''		/* «a.name»«IF a.size>1»[«a.size»]«ENDIF» */'''.toString
		if(a.size == 0 || a.refType.type.primitive)
			initAttribute(instance, path)+COMMENT
		else 
		'''
			{ «FOR Integer i:1..a.size SEPARATOR ', '»«initAttribute(instance, path)»«ENDFOR» } «COMMENT»
		'''
	}
	
	def private initAttribute(InstanceBase instance, List<Attribute> path) {
		var a = path.last
		var aType = a.refType.type
		if(a.refType.ref){
			return if(a.defaultValueLiteral != null)
				a.defaultValueLiteral
			else
				languageExt.nullPointer
		}
		switch aType{
			DataClass:
				'''
					{
						«FOR subA : (aType as DataClass).allAttributes SEPARATOR ','»
							«initAttributeArray(instance, path.union(subA))»
						«ENDFOR»
					}'''
			ExternalType:
				if(a.defaultValueLiteral != null)
					a.defaultValueLiteral
				else
					languageExt.defaultValue(aType)
			PrimitiveType: {
				var value = getPrimitiveValue(instance, path)
				if(a.size > 0 && aType.characterType && !value.trim.startsWith('{'))
					'''{ «FOR Integer i:1..a.size SEPARATOR ', '»«value»«ENDFOR» }'''
				else
					value
			}
		}
	}
	
	def private getPrimitiveValue(InstanceBase instance, List<Attribute> path){
		var value = switch instance {
			ActorInstance: dataExt.getAttrInstanceConfigValue(instance, path)
			InterfaceItemInstance: dataExt.getAttrInstanceConfigValue(instance, path)
		}
		if(value == null)
			value = switch instance {
			ActorInstance: dataExt.getAttrClassConfigValue(instance.actorClass, path)
			InterfaceItemInstance: dataExt.getAttrClassConfigValue(instance.protocol, !instance.conjugated, path)
		}
		if(value == null)
			value = path.last.defaultValueLiteral
		return if(value != null) languageExt.toValueLiteral(path.last.refType.type as PrimitiveType, value)
			else languageExt.defaultValue(path.last.refType.type)
	}
	
	

}