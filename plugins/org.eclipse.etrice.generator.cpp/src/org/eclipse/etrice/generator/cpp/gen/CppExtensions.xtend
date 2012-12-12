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
import java.util.List
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.xtext.util.Pair

@Singleton
class CppExtensions implements ILanguageExtension {

	@Inject IDiagnostician diagnostician
	@Inject extension TypeHelpers
	

	override String getTypedDataDefinition(Message m) {
		generateArglistAndTypedData(m.data).get(1)
	}


	def String getCppHeaderFileName(RoomClass rc) {rc.name+".h"}
	def String getCppSourceFileName(RoomClass rc) {rc.name+".cpp"}
	def String getInstSourceFileName(RoomClass rc) {rc.name+"_Inst.h"}
	def String getDispSourceFileName(RoomClass rc) {rc.name+"_Disp.h"}
	
	override String accessLevelPrivate() {""}
	override String accessLevelProtected() {""}
	override String accessLevelPublic() {""}
	
	override String memberAccess() {"this->"} 	 
	override String selfPointer(String classname, boolean hasArgs) {""}
	override String selfPointer(boolean hasArgs) { "" }
	
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
	
	override String genEnumeration(String name, List<Pair<String, String>> entries) {
		'''
		typedef enum {
		«FOR entry: entries»
			«entry.first» = «entry.second»,
		«ENDFOR» 
		} «name»;'''.toString
	}

	override String booleanConstant(boolean b) {
		b.toString
	}
	
	override String pointerLiteral() { "*" }
	override String nullPointer() { "0" }
	override String voidPointer() { "void*" }

	override String arrayDeclaration(String type, int size, String name, boolean isRef) {
		type+" "+name+"["+size+"]";
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
	

	override String toValueLiteral(PrimitiveType type, String value){
		throw new UnsupportedOperationException("TODO Config for Cpp");
	}

	override String defaultValue(DataType dt) {
		if (dt instanceof PrimitiveType) {
			return (dt as PrimitiveType).getDefaultValueLiteral
		}
		else if (dt instanceof ExternalType) {
			diagnostician.warning("initialize external type with default constructor"+dt.name, dt.eContainer, dt.eContainingFeature)
			return dt.typeName + "()"
		}
		else {
			val dc = dt as DataClass
			
			'''
				{
					«FOR att : dc.attributes SEPARATOR ","»
						«att.refType.type.initializationWithDefaultValues(att.size)»
					«ENDFOR»
				}
			'''
		}
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
		var deref = "*"
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
		
		if (data.getRefType().isRef()) {
			typeName = typeName+"*"
			castTypeName = castTypeName+"*"
		}
		else if (!(data.getRefType().getType() instanceof PrimitiveType)) {
			typeName = typeName+"*"
			castTypeName = castTypeName+"*"
		}
		else {
			castTypeName = typeName
			deref = ""
		}
			
		val typedData = typeName+" "+data.getName() + " = " + deref + "(("+castTypeName+") generic_data);\n"

		val dataArg = ", "+data.getName()
		val typedArgList = ", "+typeName+" "+data.getName()
		
		return newArrayList(dataArg, typedData, typedArgList);
	}
	
}
