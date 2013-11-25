/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

/*
	collection of convenience functions for code generation
*/


package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.common.base.LiteralType
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.core.room.RefableType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.EnumerationType

@Singleton
class TypeHelpers {

	@Inject ILanguageExtension languageExt
	@Inject IDataConfiguration dataConfigExt
	
	def String typeName(DataType type) {
		if (type instanceof PrimitiveType)
			return (type as PrimitiveType).targetName
		else if (type instanceof EnumerationType)
			return languageExt.getTargetType(type as EnumerationType)
		else if (type instanceof ExternalType)
			return (type as ExternalType).targetName
		else
			return type.name
	}
	
	def String getTypeName(DataType t) {
		typeName(t)
	}
	
	def String getTypeName(RefableType t) {
		typeName(t.getType())
	}
	
	def String getTypeName(Message m) {
		getTypeName(m.getData().getRefType())
	}
	
	def String getTypeName(Attribute att) {
		getTypeName(att.getType())
	}

	/**
	 * This function returns the name of the primitive type.
	 * It can be overridden to map room types to the target language. This (basic) implementation returns the room type
	 * 
	 * @param t
	 * @return
	 */
	def String getPrimitiveTypeName(RefableType t) {
		t.getType().getName()
	}

	def String getPrimitiveTypeName(Message m) {
		getPrimitiveTypeName(m.getData().getRefType())
	}
	
	def String getPrimitiveTypeName(Attribute att) {
		getPrimitiveTypeName(att.getType())
	}

	def String defaultValue(VarDecl a) {
		return languageExt.defaultValue(a.refType.type)
	}

	def String getArgumentList(VarDecl data) {
		languageExt.generateArglistAndTypedData(data).get(0)
	}

	def String getTypedDataDefinition(VarDecl data) {
		languageExt.generateArglistAndTypedData(data).get(1);
	}

	def String generateTypedArgumentList(VarDecl data) {
		languageExt.generateArglistAndTypedData(data).get(2);
	}
	
	def isPrimitive(DataType type){
		return type instanceof PrimitiveType
	}
	
	def isEnumeration(DataType type){
		return type instanceof EnumerationType
	}
	
	def isEnumerationOrPrimitive(DataType type){
		return type instanceof EnumerationType || type instanceof PrimitiveType
	}
	
	def isDataClass(DataType type){
		return type instanceof DataClass
	}
	
	def isCharacterType(PrimitiveType type){
		type.type == LiteralType::CHAR
	}
	
	def isCharacterType(DataType type){
		return type.primitive && (type as PrimitiveType).characterType
	}
	
	def String getAttrInstanceConfigValue(List<Attribute> attributePath, InstanceBase instance){
		switch instance {
			ActorInstance: dataConfigExt.getAttrInstanceConfigValue(instance, attributePath)
			InterfaceItemInstance: dataConfigExt.getAttrInstanceConfigValue(instance, attributePath)
		}
	}
	
	def String getAttrClassConfigValue(List<Attribute> attributePath, ActorClass actor, boolean inherite){
		var result = dataConfigExt.getAttrClassConfigValue(actor, attributePath)
		if(result == null && inherite){
			var base = actor.base
			while(base != null && result == null){
				result = dataConfigExt.getAttrClassConfigValue(base, attributePath)
				base = base.base
			}
		}
		
		return result
	}
	
	def String getAttrClassConfigValue(List<Attribute> attributePath, PortClass port){
		var pc = RoomHelpers::getProtocolClass(port)
		if(pc == null)
			return null
		return dataConfigExt.getAttrClassConfigValue(pc, port.equals(pc.regular), attributePath)
	}
}