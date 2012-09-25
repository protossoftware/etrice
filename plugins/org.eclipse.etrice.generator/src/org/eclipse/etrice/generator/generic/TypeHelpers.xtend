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
import org.eclipse.etrice.core.room.LiteralType
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.VarDecl


@Singleton
class TypeHelpers {

	@Inject ILanguageExtension languageExt
	
	def String typeName(DataType type) {
		if (type instanceof PrimitiveType)
			return (type as PrimitiveType).targetName
		else if (type instanceof ExternalType)
			return (type as ExternalType).targetName
		else
			return type.name
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
	
	def isDataClass(DataType type){
		return type instanceof DataClass
	}
	
	def isCharacterType(PrimitiveType type){
		type.type == LiteralType::CHAR
	}
	
	def isCharacterType(DataType type){
		return type.primitive && (type as PrimitiveType).characterType
	}
}