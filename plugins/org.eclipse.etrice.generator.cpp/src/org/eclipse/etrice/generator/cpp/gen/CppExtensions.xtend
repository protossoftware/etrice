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


package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator
import java.util.List
import org.eclipse.xtext.util.Pair
import org.eclipse.etrice.core.room.Port


@Singleton
class CppExtensions implements ILanguageExtension {

	@Inject AbstractTransitionChainGenerator chainGenerator
	

	override String getTypedDataDefinition(Message m) {
		return chainGenerator.generateTypedData(m.data)
	}


	def String getCppHeaderFileName(RoomClass rc) {rc.name+".h"}
	def String getCppSourceFileName(RoomClass rc) {rc.name+".cpp"}
	
	override String accessLevelPrivate() {""}
	override String accessLevelProtected() {""}
	override String accessLevelPublic() {""}
	
	override String memberAccess() {"this->"} 	 
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
		enum «name» {
		«FOR entry: entries»
			«entry.first» = «entry.second»,
		«ENDFOR» 
		};'''.toString
	}

	override String booleanConstant(boolean b) {
		b.toString
	}
	
	override String pointerLiteral() { "" }
	override String nullPointer() { "null" }
	override String voidPointer() { "Object" }

	override String arrayDeclaration(String type, int size, String name, boolean isRef) {
		type+" "+name+"[]";
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
	
	def getIncludeGuardString(String filename){
		'''_«filename.replaceAll("\\/.", "_").toUpperCase»_H_'''
	}

	def generateIncludeGuardBegin(String filename){'''
		#ifndef «filename.getIncludeGuardString»
		#define «filename.getIncludeGuardString»
		'''
	}

	def generateIncludeGuardEnd(String filename){'''
		#endif /* «filename.getIncludeGuardString» */
		'''
	}
	
	

	override superCall(String baseClassName, String method, String arguments) {
		baseClassName+"::"+method+"("+arguments+");"
	}
	
	override toCharArrayExpr(String s) {
		"\"" + s + "\"";
	}
	
		 
}
