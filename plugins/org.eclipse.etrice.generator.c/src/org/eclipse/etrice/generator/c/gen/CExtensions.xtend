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
import java.util.List
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.LiteralType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.xtext.util.Pair

import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*
import org.eclipse.etrice.core.room.RoomModel

@Singleton
class CExtensions implements ILanguageExtension {

	@Inject IDiagnostician diagnostician

	override String getTypedDataDefinition(Message m) {
		generateArglistAndTypedData(m.data).get(1)
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
	
	override boolean usesPointers() {
		return true
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
	
	override String superCall(String baseClassName, String method, String args) {
		""
	}
	override String toValueLiteral(PrimitiveType type, String value){
		switch(type.targetName){
			// TODO JH: char* with length 1
			case type.targetName.equals("char") && value.length == 1:
				"'"+value+"'"
			case type.type == LiteralType::CHAR:
				"\""+value+"\""
			case value.contains(','): {
					var singleValues = value.replace('{', '').replace('}', '').trim.split(',')
					'''{ «FOR v: singleValues SEPARATOR ', '»«toValueLiteral(type, v.trim)»«ENDFOR» }'''.toString
				}
			case "boolean":
				value.toUpperCase
			default:
				value	
		}
	}

	override String defaultValue(DataType dt) {
		switch dt{
			PrimitiveType:
				toValueLiteral(dt, dt.defaultValueLiteral)
			ExternalType:{
				if (dt.defaultValueLiteral != null )
					return dt.getDefaultValueLiteral
				diagnostician.error("cannot initialize external type "+dt.name, dt.eContainer, dt.eContainingFeature)
				"cannot instantiate external data type "+dt.name
			}
			DataClass:			
			'''
				{
					«FOR att : dt.allAttributes SEPARATOR ","»
						«att.initializationWithDefaultValues»
					«ENDFOR»
				}
			'''
		}
	}
	
	override initializationWithDefaultValues(DataType dt, int size) {
		val dv = dt.defaultValue
		dv.initializer(size)
	}

	def private initializer(String dv, int size) {
		if (size>1) {
			var res = "{"
			var i = 0
			while (i<size) {
				res = res + dv
				i = i+1
				if (i<size)
					res = res + ","
			}
			res+"}"
		}
		else
			dv
	}
	
	def initializationWithDefaultValues(Attribute att) {
		val dv = att.defaultValueLiteral
		if (dv!=null) {
			if (dv.startsWith("{"))
				dv
			else
				dv.initializer(att.size)
		}
		else if (att.refType.ref) {
			"NULL".initializer(att.size)
		}
		else
			att.refType.type.initializationWithDefaultValues(att.size)
	}
	
	override generateArglistAndTypedData(VarDecl data) {
		if (data==null)
			return newArrayList("", "", "")
			
		var typeName = if (data.getRefType().getType() instanceof PrimitiveType)
			(data.getRefType().getType() as PrimitiveType).getTargetName()
		else
			data.getRefType().getType().getName()
			
		var castTypeName = if (data.getRefType().getType() instanceof PrimitiveType) {
			val ct = (data.getRefType().getType() as PrimitiveType).getCastName()
			if (ct!=null && !ct.isEmpty())
				ct
			else
				typeName
		}
		else
			typeName
		castTypeName = castTypeName+"*"
		var deRef = "*"
		
		val isRef = data.getRefType().isRef()
		val isPrim = (data.getRefType().getType() instanceof PrimitiveType)
		if (isRef) {
				typeName = typeName+"*"
				castTypeName = castTypeName+"*"
		}
		else {
			if (!isPrim) {
				typeName = typeName+"*"
				deRef = ""
			}
		}
			
		val typedData = typeName+" "+data.getName() + " = "+deRef+"(("+castTypeName+") generic_data);\n"

		val dataArg = ", "+data.getName()
		val typedArgList = ", "+typeName+" "+data.getName()
		
		return newArrayList(dataArg, typedData, typedArgList);
	}
	
	def getIncludePath(RoomClass rc) {
		"\""+(rc.eContainer as RoomModel).name.replaceAll("\\.","/")+"/"+rc.getCHeaderFileName+"\""
	}
}
