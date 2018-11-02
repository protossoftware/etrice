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
 * 		Peter Karlitschek
 *
 *******************************************************************************/

/*
	collection of convenience functions for code generation
*/


package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.EnumLiteral
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.xtext.util.Pair
import org.eclipse.xtext.util.Strings
import org.eclipse.etrice.generator.cpp.Main
import org.eclipse.etrice.generator.cpp.setup.GeneratorOptionsHelper

@Singleton
class CppExtensions implements ILanguageExtension {

	@Inject IDiagnostician diagnostician
	@Inject extension TypeHelpers
	@Inject extension RoomHelpers
	@Inject extension RoomExtensions
	@Inject protected extension GeneratorOptionsHelper

	override String getTypedDataDefinition(EObject msg) {
		generateArglistAndTypedData((msg as Message).data).get(TypedDataKind.DECLARATION_AND_INITIALIZATION.ordinal)
	}

	def String getCppHeaderFileName(RoomClass rc) { rc.name + ".h" }

	def String getCppSourceFileName(RoomClass rc) { rc.name + ".cpp" }

	def String getCppClassName(NodeRef nr, SubSystemInstance ssi) {
		"Node_" + nr.name + "_" + ssi.name;
	}

	def String getCppHeaderFileName(NodeRef nr, SubSystemInstance ssi) {
		nr.getCppClassName(ssi) + ".h";
	}

	def String getCppSourceFileName(NodeRef nr, SubSystemInstance ssi) {
		nr.getCppClassName(ssi) + ".cpp";
	}

	override String accessLevelPrivate() {""}
	override String accessLevelProtected() {""}
	override String accessLevelPublic() {""}

	override String memberAccess() {"this->"}
	override String selfPointer(String classname, boolean hasArgs) {""}
	override String selfPointer(boolean hasArgs) { "" }
	
	override String scopeSeparator() {"::"}

	override String operationScope(String classname, boolean isDeclaration) {
		if (isDeclaration)
			""
		else
			classname+"::"
	}


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
		return true
	}

	override String genEnumeration(String name, List<Pair<String, String>> entries){
		if(entries.empty)
			return ''

		'''
			typedef enum {
				«FOR entry : entries SEPARATOR ','»
					«entry.first» = «entry.second»
				«ENDFOR»
			} «name»;
		'''
	}


	override String booleanConstant(boolean b) {
		b.toString
	}

	override String pointerLiteral() { "*" }
	override String nullPointer() { "0" }
	override String voidPointer() { "void*" }

	override String arrayType(String type, int size, boolean isRef){
		'''StaticArray<«type»«IF isRef»*«ENDIF», «size»>'''
	}

	override String arrayDeclaration(String type, int size, boolean isRef, String name){
		arrayType(type, size, isRef) + ' ' + name
	}

	def getIncludeGuardString(RoomClass roomClass, String appendSegments){
		'_' + (roomClass.package.split('\\.') + #[roomClass.name] + appendSegments.split('\\.')).filter[!empty].join('_').toUpperCase + '_H_'
	}

	def generateIncludeGuardBegin(RoomClass roomClass, String appendSegments)'''
		#ifndef «roomClass.getIncludeGuardString(appendSegments)»
		#define «roomClass.getIncludeGuardString(appendSegments)»
	'''

	def generateIncludeGuardEnd(RoomClass roomClass, String appendSegments)
		'''#endif /* «roomClass.getIncludeGuardString(appendSegments)» */'''

	def generateNamespaceBegin(RoomClass roomClass) {
		''	// roomClass.package.split('\\.').map[pkg|'''namespace «pkg» {'''].join(NEWLINE)
	}

	def generateNamespaceEnd(RoomClass roomClass) {
		''	// roomClass.package.split('\\.').map[pkg|'''} // namespace «pkg»'''].join(NEWLINE)
	}

	override superCall(String baseClassName, String method, String arguments) {
		baseClassName+"::"+method+"("+arguments+");"
	}

	override String toValueLiteral(PrimitiveType type, String value){
		throw new UnsupportedOperationException("TODO Config for Cpp");
	}

	override toEnumLiteral(EnumerationType type, String value) {
		throw new UnsupportedOperationException("TODO Config for Cpp")
	}

	override String defaultValue(DataType dt) {
		switch it: dt {
			PrimitiveType: defaultValueLiteral
			EnumerationType: {
				diagnostician.error('Enumeration not supported', dt, null)
				'/* TODO */' // defaultValue
				}
			ExternalType: defaultValueLiteral
		}
	}

	// TODO move to defaultValue(DataType dt)
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

		val castExpr = switch it : data.refType.type {
			PrimitiveType case !Strings.isEmpty(castName): castName
			EnumerationType: castType
			default: typeName
		} + '*'
		val typeExpr = data.refType.type.typeName + switch it : data.refType {
			case ref : '*'
			case type.isPrimitive: ''
			default : '&'
		}
		var deRef = if(!data.refType.ref) '*' else ''

		val dataName = if (Main.settings.isOldStyleTransitionData && data.deprecatedName!==null && !data.deprecatedName.trim.empty)
				data.deprecatedName
			else
				GENERIC_DATA_NAME
		val dataArg = ''', «dataName»'''
		val typedData = '''«typeExpr» «dataName» = «deRef»(static_cast<«castExpr»>(generic_data__et));''' + NEWLINE
		val typedArgList = ''', «typeExpr» «dataName»'''

		return #[dataArg, typedData, typedArgList]
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

		if (type.primitiveType!==null)
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
		"virtual "
	}

	/**
	 * check if there is an ImplementationSubclass annotation and return its fully qualified name or the actor class name
	 */
	def getImplementationClassName(ActorClass ac) {
	    val attributes = ac.getAttributes("ImplementationSubclass")
	    if (attributes.empty) {
	        ac.name
	    }
	    else {
	        attributes.filter[it.key=="fqnClassName"].head.value.literalToString
	    }
	}

	/**
	 * check if there is an ImplementationSubclass annotation. If it also has an includePath use it.
	 * If there is not includePath, use the class name as base file name.
	 * If there is no annotation use the default path.
	 */
	def getActorIncludePath(ActorClass ac) {
	    val attributes = ac.getAttributes("ImplementationSubclass")
	    if (attributes.empty) {
		    ac.path+ac.name+".h"
	    }
	    else {
	        val path = attributes.filter[it.key=="includePath"]
	        if (path.empty) {
		        val baseName = attributes.filter[it.key=="fqnClassName"].head.value.literalToString.split("::").last
			    baseName+".h"
	        }
	        else {
	            path.head.value.literalToString
	        }
	    }
	}

//	def targetFQN(RoomClass roomClass){
//		roomClass.targetPkg + '::' + roomClass.name
//	}
//
//	def targetPkg(RoomClass roomClass){
//		roomClass.package.replace('.', '::')
//	}

}
