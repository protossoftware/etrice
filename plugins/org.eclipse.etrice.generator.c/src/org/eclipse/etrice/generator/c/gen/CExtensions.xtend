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
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.common.base.LiteralType
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.EnumLiteral
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.c.Main
import org.eclipse.etrice.generator.c.setup.GeneratorOptionsHelper
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.xtext.util.Pair
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.core.room.RefableType

@Singleton
class CExtensions implements ILanguageExtension {

	@Inject protected IDiagnostician diagnostician
	@Inject protected extension RoomHelpers
	@Inject protected extension GeneratorOptionsHelper

	override String getTypedDataDefinition(EObject msg) {
	    if (msg instanceof Message) {
    		generateArglistAndTypedData(msg.data).get(TypedDataKind.DECLARATION_AND_INITIALIZATION.ordinal)
	    }
	    else {
	        ""
	    }
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

	override String scopeSeparator() {""}
	
	override String operationScope(String classname, boolean isDeclaration) {classname+"_"}

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

	// used
	def String getCUtilsFileName(RoomClass rc) {
		return rc.name+"_Utils.h";
	}

	def String getInstSourceFileName(RoomClass rc) {
		return rc.name+"_Inst.h";
	}

	def String getDispSourceFileName(RoomClass rc) {
		return rc.name+"_Disp.h";
	}

	// used
	def String getCHeaderFileName(NodeRef nr, SubSystemInstance ssi) {
		return nr.name+"_"+ssi.name+".h";
	}

	def String getCSourceFileName(NodeRef nr, SubSystemInstance ssi) {
		return nr.name+"_"+ssi.name+".c";
	}

	def String getInstSourceFileName(NodeRef nr, SubSystemInstance ssi) {
		return nr.name+"_"+ssi.name+"_Inst.h";
	}

	def String getDispSourceFileName(NodeRef nr, SubSystemInstance ssi) {
		return nr.name+"_"+ssi.name+"_Disp.h";
	}

	def getIncludeGuardString(String filename){
		'''_«filename.toUpperCase»_H_'''
	}

	def generateIncludeGuardBegin(RoomClass rc) {
		val filename = (rc.eContainer as RoomModel).name.replaceAll("\\.","_")+"_"+rc.name
		filename.generateIncludeGuardBegin
	}

	def generateIncludeGuardEnd(RoomClass rc) {
		val filename = (rc.eContainer as RoomModel).name.replaceAll("\\.","_")+"_"+rc.name
		filename.generateIncludeGuardEnd
	}

	def generateIncludeGuardBegin(String filename) {
		'''
		#ifndef «filename.getIncludeGuardString»
		#define «filename.getIncludeGuardString»
		'''
	}

	def generateIncludeGuardEnd(String filename) {
		'''
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
		if (b) "ET_TRUE" else "ET_FALSE"
	}

	override String pointerLiteral() { "*" }
	override String nullPointer() { "NULL" }
	override String voidPointer() { "void*" }

	override String arrayType(String type, int size, boolean isRef)'''
			«type»«IF isRef»*«ENDIF»
		'''

	override String arrayDeclaration(String type, int size, boolean isRef, String name)'''
		«type»«IF isRef»*«ENDIF» «name»[«size»]
	'''

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
			case value.contains(',') || value.contains('{'): {
					var singleValues = value.replace('{', '').replace('}', '').trim.split(',')
					'''{ «FOR v: singleValues SEPARATOR ', '»«toValueLiteral(type, v.trim)»«ENDFOR» }'''.toString
				}
			case "boolean":
				if (value.equals("true")) "ET_TRUE" else "ET_FALSE"
			default:
				value
		}
	}

	override toEnumLiteral(EnumerationType type, String value) {
		if(value.contains(',') || value.contains('{')){
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
				return type.getName()+"_"+l.getName()
	}

	override String defaultValue(DataType dt) {
		switch dt{
			PrimitiveType:
				toValueLiteral(dt, dt.defaultValueLiteral)
			EnumerationType:
				getDefaultValue(dt)
			ExternalType:{
				if (dt.defaultValueLiteral !== null )
					return dt.getDefaultValueLiteral
				diagnostician.error("external type "+dt.name + "has no default initialization", dt.eContainer, dt.eContainingFeature)
				""
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

	def String getDefaultValue(EnumerationType type) {
		if (type.getLiterals().isEmpty())
			""
		else
			getCastedValue(type.getLiterals().get(0))
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
		if (dv!==null) {
			if (dv.startsWith("{"))
				dv
			else
				dv.initializer(att.size)
		}
		else if (att.type.ref) {
			"NULL".initializer(att.size)
		}
		else
			att.type.type.initializationWithDefaultValues(att.size)
	}

	override generateArglistAndTypedData(EObject d) {
		// TODO 529445: d will be a RefableType, not MessageData
		if (d===null || !(d instanceof MessageData))
			return newArrayList("", "", "")

		val data = d as MessageData
		if (data===null)
			return newArrayList("", "", "")

		var typeName = if (data.getRefType().getType() instanceof PrimitiveType)
			(data.getRefType().getType() as PrimitiveType).targetName
		else if (data.getRefType().getType() instanceof EnumerationType)
			(data.getRefType().getType() as EnumerationType).targetType
		else if (data.getRefType().getType() instanceof ExternalType)
			(data.getRefType().getType() as ExternalType).targetName
		else
			data.getRefType().getType().getName()

		var castTypeName = if (data.getRefType().getType() instanceof PrimitiveType) {
			val ct = (data.getRefType().getType() as PrimitiveType).getCastName()
			if (ct!==null && !ct.isEmpty())
				ct
			else
				typeName
		}
		else if (data.getRefType().getType() instanceof EnumerationType) {
			(data.getRefType().getType() as EnumerationType).castType
		}
		else
			typeName
		castTypeName = castTypeName+"*"
		var deRef = "*"

		val isRef = data.getRefType().isRef()
		val isPrim = (data.getRefType().getType() instanceof PrimitiveType || data.getRefType().getType() instanceof EnumerationType)
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

		val dataName = if (Main.settings.isOldStyleTransitionData && data.deprecatedName!==null && !data.deprecatedName.trim.empty)
				data.deprecatedName
			else
				GENERIC_DATA_NAME
		val dataArg = ", "+dataName
		val typedData = typeName+" "+dataName + " = "+deRef+"(("+castTypeName+") generic_data__et);\n"
		val typedArgList = ", "+typeName+" "+dataName

		return newArrayList(dataArg, typedData, typedArgList);
	}

	def getIncludePath(RoomClass rc) {
		"\""+(rc.eContainer as RoomModel).name.replaceAll("\\.","/")+"/"+rc.getCHeaderFileName+"\""
	}

	def getUtilsIncludePath(RoomClass rc) {
		"\""+(rc.eContainer as RoomModel).name.replaceAll("\\.","/")+"/"+rc.getCUtilsFileName+"\""
	}

	override getTargetType(EnumerationType type) {
		if (type.getPrimitiveType()!==null)
			type.getPrimitiveType().getTargetName()
		else
			type.getName()
	}

	override getCastedValue(EnumLiteral literal) {
		val type = literal.eContainer() as EnumerationType
		val cast = type.targetType

		if (type.primitiveType===null)
			Long.toString(literal.getLiteralValue())
		else
			"(("+cast+")"+Long.toString(literal.getLiteralValue())+")"
	}

	override getCastType(EnumerationType type) {
		if (type.getPrimitiveType()!==null)
			type.getPrimitiveType().getCastName()
		else
			type.getName()
	}

	override makeOverridable() {
		// not possible for C: empty string
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
			case varargs : '...'
			default: refType.typeSignature + ' ' + name 
		}
	}

}
