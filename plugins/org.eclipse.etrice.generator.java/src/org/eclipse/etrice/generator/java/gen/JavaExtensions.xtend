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
import java.util.List
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.xtext.util.Pair
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.EnumerationType

import org.eclipse.etrice.core.room.EnumLiteral

@Singleton
class JavaExtensions implements ILanguageExtension {

	@Inject TypeHelpers typeHelpers

	override String getTypedDataDefinition(Message m) {
		generateArglistAndTypedData(m.data).get(1)
	}

	def String getJavaFileName(RoomClass rc) {rc.name+".java"}
	
	def String getJavaFactoryName(ActorClass rc) {rc.name+"Factory"}
	def String getJavaFactoryFileName(ActorClass rc) {rc.javaFactoryName+".java"}
	def String getJavaScalarInterfaceName(ActorClass rc) {rc.name+"Interface"}
	def String getJavaScalarInterfaceFileName(ActorClass rc) {rc.javaScalarInterfaceName+".java"}
	def String getJavaReplicatedInterfaceName(ActorClass rc) {rc.name+"ReplicatedInterface"}
	def String getJavaReplicatedInterfaceFileName(ActorClass rc) {rc.javaReplicatedInterfaceName+".java"}
	def String getJavaInterfaceName(ActorClass ac, boolean replicated) {
		if (replicated)
			ac.getJavaReplicatedInterfaceName
		else
			ac.javaScalarInterfaceName
	}
	def String getJavaInterfaceFileName(ActorClass ac, boolean replicated) {
		if (replicated)
			ac.getJavaReplicatedInterfaceFileName
		else
			ac.javaScalarInterfaceFileName
	}

	def String getJavaClassName(NodeRef nr, SubSystemInstance ssi) {
		"Node_"+nr.name+"_"+ssi.name;
	}

	def String getJavaFileName(NodeRef nr, SubSystemInstance ssi) {
		nr.getJavaClassName(ssi)+".java";
	}
		
	def String toWrapper(String type){
		switch(type){
			case "int": "Integer"
			case "char" : "Character"
			default: type.toFirstUpper
		}
	}
	
	def boolean needsInitialization(Attribute a){
		a.size > 0 || !typeHelpers.isEnumerationOrPrimitive(a.type.type) || typeHelpers.typeName(a.type.type).equals("String")
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
	
	override boolean usesPointers() {
		return false
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
	
	override String superCall(String baseClassName, String method, String args) {
		"super."+method+"("+args+");"
	}
	
	override toValueLiteral(PrimitiveType type, String value){
		if(!typeHelpers.isCharacterType(type) && (value.contains(',') || value.contains('{'))) {
			var singleValues = value.replace('{', '').replace('}', '').trim.split(',')
			'''{ «FOR v: singleValues SEPARATOR ', '»«castValue(type, v.trim)»«ENDFOR» }'''.toString
		}else
			castValue(type, value)	
	}
	
	override toEnumLiteral(EnumerationType type, String value){
		if(value.contains(',') || value.contains('{')) {
			var singleValues = value.replace('{', '').replace('}', '').trim.split(',')
			'''{ «FOR v: singleValues SEPARATOR ', '»«v.trim»«ENDFOR» }'''.toString
		} else
			value
	}
	
	def private castValue(PrimitiveType type, String value){
		switch(type.targetName){
			case "boolean":
				value.toLowerCase
			case "byte":
				"(byte)"+value
			case "short":
				"(short)"+value
			case "int":
				value
			case "long":
				value+"L"
			case "float":
				value+"f"
			case "double":
				value+"d"
			case "char":
				if(value.empty)
					"(char) 0"
				else if(value.length==1)
					"'"+value.charAt(0)+"'"
				else
					"\""+value.replace("\\", "\\\\").replace("\"", "\\\"")+"\".toCharArray()"
			case "String":
				"\""+value.replace("\\", "\\\\").replace("\"", "\\\"")+"\""
			default:
				throw new UnsupportedOperationException(type.targetName)
		}
	}

	override defaultValue(DataType dt) {
		switch dt {
			PrimitiveType:
				toValueLiteral(dt, dt.defaultValueLiteral)
			EnumerationType:
				getDefaultValue(dt)
			ExternalType:
				"new "+(dt as ExternalType).targetName+"()"
			default:
				"new "+dt.name+"()"
		}
	}
	
	def String getDefaultValue(EnumerationType type) {
		if (type.getLiterals().isEmpty())
			""
		else
			getCastedValue(type.getLiterals().get(0))
	}

	override initializationWithDefaultValues(DataType dt, int size) {
		val dv = dt.defaultValue
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

	override generateArglistAndTypedData(VarDecl data) {
		if (data==null)
			return newArrayList("", "", "")
		
		var typeName = data.refType.type.getName();
		var castTypeName = typeName;
		if (data.refType.type instanceof PrimitiveType) {
			typeName = (data.refType.type as PrimitiveType).getTargetName()
			val ct = (data.refType.type as PrimitiveType).getCastName()
			if (ct!=null && !ct.isEmpty())
				castTypeName = ct
		}
		else if (data.refType.type instanceof EnumerationType) {
			typeName = (data.refType.type as EnumerationType).targetType
			castTypeName = (data.refType.type as EnumerationType).castType
		}
		
		val typedData = typeName+" "+data.getName() + " = ("+castTypeName+") generic_data;\n";
		val dataArg = ", "+data.getName();
		val typedArgList = ", "+typeName+" "+data.getName();
		
		return newArrayList(dataArg, typedData, typedArgList);
	}
	
	override getTargetType(EnumerationType type) {
		if (type.getPrimitiveType()!=null)
			type.getPrimitiveType().getTargetName()
		else
			"int"
	}
	
	override getCastedValue(EnumLiteral literal) {
		val type = literal.eContainer() as EnumerationType
		val cast = type.targetType
		
		if (type.primitiveType==null)
			Long.toString(literal.getLiteralValue())
		else
			"(("+cast+")"+Long.toString(literal.getLiteralValue())+")"
	}
	
	override getCastType(EnumerationType type) {
		if (type.getPrimitiveType()!=null)
			type.getPrimitiveType().getCastName()
		else
			"int"
	}
	
}
