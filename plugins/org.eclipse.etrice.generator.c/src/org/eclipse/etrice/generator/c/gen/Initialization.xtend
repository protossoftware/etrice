/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/


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
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*
import org.eclipse.etrice.core.room.EnumerationType

class Initialization {
	
	@Inject CExtensions languageExt
	@Inject extension RoomExtensions
	@Inject extension TypeHelpers
	
	def generateAttributeInit(InstanceBase instance, List<Attribute> attributes){'''
		«FOR a : attributes SEPARATOR ','»
			«initAttributeArray(instance, new ArrayList<Attribute>.union(a))»
		«ENDFOR»
		'''		
	}
	
	def private String initAttributeArray(InstanceBase instance, List<Attribute> path){
		var a = path.last
		var COMMENT = '''		/* «a.name»«IF a.size>1»[«a.size»]«ENDIF» */'''.toString
		if(a.size == 0 || (!a.type.ref && a.type.type.enumerationOrPrimitive))
			initAttribute(instance, path)+COMMENT
		else 
		'''
			{ «FOR Integer i:1..a.size SEPARATOR ', '»«initAttribute(instance, path)»«ENDFOR» } «COMMENT»
		'''
	}
	
	def private initAttribute(InstanceBase instance, List<Attribute> path) {
		var a = path.last
		var aType = a.type.type
		if(a.type.ref){
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
				if(a.size > 0 && !aType.characterType && !value.trim.startsWith('{'))
					'''{ «FOR Integer i:1..a.size SEPARATOR ', '»«value»«ENDFOR» }'''
				else
					value
			}
			EnumerationType: {
				var value = languageExt.getDefaultValue(aType)
				if (a.size > 0 && !value.trim.startsWith('{'))
					'''{ «FOR Integer i:1..a.size SEPARATOR ', '»«value»«ENDFOR» }'''
				else
					value
			}
		}
	}
	
	def private getPrimitiveValue(InstanceBase instance, List<Attribute> path){
		var value = path.getAttrInstanceConfigValue(instance)
		if(value == null)
			value = switch instance {
				ActorInstance: path.getAttrClassConfigValue(instance.actorClass, true)
				InterfaceItemInstance: path.getAttrClassConfigValue(RoomHelpers::getPortClass(instance.interfaceItem))
			}
		if(value == null)
			value = path.last.defaultValueLiteral
		
		var type = path.last.type.type
		return if(value != null && type.primitive) languageExt.toValueLiteral(type as PrimitiveType, value)
				else if(value != null && type.enumeration) languageExt.toEnumLiteral(type as EnumerationType, value)
				else languageExt.defaultValue(type)
	}
}
