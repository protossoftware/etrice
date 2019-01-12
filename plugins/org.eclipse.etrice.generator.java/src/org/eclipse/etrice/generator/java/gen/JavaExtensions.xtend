/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.EnumLiteral
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RefableType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.etrice.generator.java.Main
import org.eclipse.etrice.generator.java.setup.GeneratorOptionsHelper
import org.eclipse.xtext.util.Pair

@Singleton
class JavaExtensions implements ILanguageExtension {
	
	@Inject TypeHelpers typeHelpers
	@Inject protected extension GeneratorOptionsHelper

	override String getTypedDataDefinition(EObject msg) {
	    if (msg instanceof Message) {
    		generateArglistAndTypedData(msg.data).get(TypedDataKind.DECLARATION_AND_INITIALIZATION.ordinal)
	    }
	    else {
	        ""
	    }
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

	override String scopeSeparator() {"."}

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
		'''
	}

	override String booleanConstant(boolean b) {
		b.toString
	}

	override String pointerLiteral() { "" }
	override String nullPointer() { "null" }
	override String voidPointer() { "Object" }

	override String arrayType(String type, int size, boolean isRef) {
		type+"[]"
	}

	override String arrayDeclaration(String type, int size, boolean isRef, String name) {
		type+" "+name+"[]"
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
			'''{ «FOR v: singleValues SEPARATOR ', '»«convertStringEnumLiteral(type, v.trim)»«ENDFOR» }'''.toString
		} else
			convertStringEnumLiteral(type, value)
	}

	def private convertStringEnumLiteral(EnumerationType type, String value){
		var v = value
		if (v.startsWith(type.name))
			v = v.substring(type.name.length+1)
		for(EnumLiteral l : type.literals)
			if(l.name.equals(v))
				return type.name+"."+l.name
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
				dt.defaultValue
			ExternalType:
				"new "+ dt.targetName+"()"
			default:
				"new "+ dt.name+"()"
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

	override generateArglistAndTypedData(EObject d) {
		// TODO 529445: d will be a RefableType, not MessageData
		if (d===null || !(d instanceof MessageData))
			return newArrayList("", "", "")

		val data = d as MessageData
		var typeName = data.refType.type.name
		var castTypeName = typeName
		if (data.refType.type instanceof PrimitiveType) {
			typeName = (data.refType.type as PrimitiveType).targetName
			val ct = (data.refType.type as PrimitiveType).castName
			if (ct!==null && !ct.isEmpty())
				castTypeName = ct
		}
		else if (data.refType.type instanceof EnumerationType) {
			typeName = (data.refType.type as EnumerationType).targetType
			castTypeName = (data.refType.type as EnumerationType).castType
		}

		val dataName = if (Main.settings.isOldStyleTransitionData && data.deprecatedName!==null && !data.deprecatedName.trim.empty)
				data.deprecatedName
			else
				GENERIC_DATA_NAME
		val dataArg = ", " + dataName
		val typedData = typeName + " " + dataName + " = ("+castTypeName+") generic_data__et;\n"
		val typedArgList = ", " + typeName + " " + dataName

		return newArrayList(dataArg, typedData, typedArgList)
	}

	override getTargetType(EnumerationType type) {
		if (type.primitiveType!==null)
			type.primitiveType.targetName
		else
			"int"
	}

	override getCastedValue(EnumLiteral literal) {
		val type = literal.eContainer() as EnumerationType
		val cast = type.targetType

		if (type.primitiveType===null)
			Long.toString(literal.literalValue)
		else
			"(("+cast+")"+Long.toString(literal.literalValue)+")"
	}

	override getCastType(EnumerationType type) {
		if (type.primitiveType!==null)
			type.primitiveType.castName
		else
			"int"
	}

	override makeOverridable() {
		// not needed for Java: empty string
		""
	}
	
	override String getTypeSignature(RefableType type) {
		switch it : type {
			case null: 'void'
			case isRef: type.type.dataTypeName + pointerLiteral
			default: type.type.dataTypeName
		}
	}
	
	override String getDataTypeName(DataType it) {
		switch it {
			PrimitiveType: targetName
			EnumerationType: targetType
			ExternalType: targetName
			default: name
		}
	}
	
	override toParameterDecl(VarDecl it) {
		switch it {
			case varargs : refType.typeSignature + '... ' + name
			default: refType.typeSignature + ' ' + name 
		}
	}

}
