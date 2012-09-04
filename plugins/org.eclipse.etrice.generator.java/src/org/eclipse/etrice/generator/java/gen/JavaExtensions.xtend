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


package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator
import java.util.List
import org.eclipse.xtext.util.Pair


@Singleton
class JavaExtensions implements ILanguageExtension {

	@Inject AbstractTransitionChainGenerator chainGenerator
	

	override String getTypedDataDefinition(Message m) {
		return chainGenerator.generateTypedData(m.data)
	}


	def String getJavaFileName(RoomClass rc) {rc.name+".java"}
	
	def String toWrapper(String type){
		switch(type){
			case "int": "Integer"
			case "char" : "Character"
			default: type.toFirstUpper
		}
	}
	
	override String accessLevelPrivate() {"private "}
	override String accessLevelProtected() {"protected "}
	override String accessLevelPublic() {"public "}
	
	override String memberAccess() {"this."} 	 
	override String selfPointer(String classname, boolean hasArgs) {""}
	override String selfPointer(boolean hasArgs) { "" }
	
	override String operationScope(String classname, boolean isDeclaration) {""}
	

	override String memberInDeclaration(String namespace, String member) {
		return member
	}
	
	override String memberInUse(String namespace, String member) {
		return namespace+"."+member
	}
	
	override boolean usesInheritance() {
		return true
	}
	
	override String genEnumeration(String name, List<Pair<String, String>> entries) {
		'''
		«FOR entry: entries»
			public static final int «entry.first» = «entry.second»;
		«ENDFOR»
		'''.toString
	}

	override String booleanConstant(boolean b) {
		b.toString
	}
	
	override String pointerLiteral() { "" }
	override String nullPointer() { "null" }
	override String voidPointer() { "Object" }

	override String arrayDeclaration(String type, int size, String name, boolean isRef) {
		type+" "+name+"[]"
	}
	
	override String constructorName(String cls) {
		cls
	}
	override String destructorName(String cls) {
		cls+"_dtor"
	}
	override String constructorReturnType() {
		""
	}
	override String destructorReturnType() {
		"void"
	}
	override String toCharArrayExpr(String s){
		"\"" + s + "\".toCharArray()"
	}
	override String superCall(String baseClassName, String method, String args) {
		"super."+method+"("+args+");"
	}
	override String toValueLiteral(PrimitiveType type, String value){
		switch(type.targetName){
			case "boolean":
				return value
			case "byte":
				return "(byte)"+value
			case "short":
				return "(short)"+value
			case "int":
				return value
			case "long":
				return value+"L"
			case "float":
				return value+"f"
			case "double":
				return value+"d"
			case "char":{
				if(value.length == 1)
					return "'"+value+"'"
				else
					return value.toCharArrayExpr
			}
			case "String":
				return "\""+value+"\""
		}
		
		throw new UnsupportedOperationException(type.targetName)
	}
	
}
