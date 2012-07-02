/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 * 
 *******************************************************************************/

/*
	collection of convenience functions for code generation
*/


package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.AbstractTransitionChainGenerator
import java.util.List
import org.eclipse.xtext.util.Pair



@Singleton
class CExtensions implements ILanguageExtension {

	@Inject AbstractTransitionChainGenerator chainGenerator
	

	override String getTypedDataDefinition(Message m) {
		return chainGenerator.generateTypedData(m)
	}

	// in C no access levels can be defined
	override String accessLevelPrivate(){"static "}
	override String accessLevelProtected(){"static "}
	override String accessLevelPublic(){""}
	
	override String memberAccess(){"self->"}
	override String selfPointer(String classname, boolean hasArgs){
		classname+
		if (hasArgs)
			"* self, "
		else
			"* self"
	}
	
	override String selfPointer(boolean hasArgs) { if (hasArgs) "self, " else "self" }

	override String operationScope(String classname, boolean isDeclaration){classname+"_"}

	override String memberInDeclaration(String namespace, String member) {
		return namespace+"_"+member
	}
	
	override String memberInUse(String namespace, String member) {
		return namespace+"_"+member
	}


	//****  C-Specific
	/* TODO: move specific code elsewhere */	
	// used
	def String getCHeaderFileName(RoomClass rc) {
		return rc.name+".h";
	}

	// used
	def String getCSourceFileName(RoomClass rc) {
		return rc.name+".c";
	}

	def String getInstSourceFileName(RoomClass rc) {
		return rc.name+"_Inst.h";
	}

	def String getDispSourceFileName(RoomClass rc) {
		return rc.name+"_Disp.h";
	}

	def getIncludeGuardString(String filename){
		'''_«filename.toUpperCase»_H_'''
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
	
	override boolean usesInheritance() {
		return false
	}
	
	override String genEnumeration(String name, List<Pair<String, String>> entries) {
		if (entries.empty)
			return "/* empty enum not generated */"
			
		'''
		enum «name» {
			«FOR entry: entries SEPARATOR ","»
				«entry.first» = «entry.second»
			«ENDFOR»
		};
		'''.toString
	}

	override String booleanConstant(boolean b) {
		if (b) "TRUE" else "FALSE"
	}
	
	override String pointerLiteral() { "*" }
	override String nullPointer() { "NULL" }
	override String voidPointer() { "void*" }
	
	override String arrayDeclaration(String type, int size, String name, boolean isRef) {
		if (isRef){
			type+"* "+name+"["+size+"]";
		}else {
			type+" "+name+"["+size+"]";
		}
	}
	
	override String constructorName(String cls) {
		"ctor"
	}
	override String destructorName(String cls) {
		"dtor"
	}
	override String constructorReturnType() {
		"void"
	}
	override String destructorReturnType() {
		"void"
	}
	override String toCharArrayExpr(String s){
		"\"" + s + "\"";
	}
	
	override String superCall(String baseClassName, String method, String args) {
		""
	}
}