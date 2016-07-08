/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.IDiagnostician
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.EnumLiteral
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.xtext.util.Pair
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions

@Singleton
class CppExtensions implements ILanguageExtension {

	@Inject IDiagnostician diagnostician
	@Inject extension TypeHelpers
	@Inject extension RoomHelpers
	@Inject extension RoomExtensions

	override String getTypedDataDefinition(EObject msg) {
		generateArglistAndTypedData((msg as Message).data).get(1)
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
	override String typeArrayModifier() { pointerLiteral }

	override String arrayDeclaration(String type, int size, String name, boolean isRef)'''
		«type»«IF isRef»*«ENDIF» «name»[«size»]
	'''

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

	override toEnumLiteral(EnumerationType type, String value) {
		throw new UnsupportedOperationException("TODO Config for Cpp")
	}

	override String defaultValue(DataType dt) {
		if (dt instanceof PrimitiveType) {
			return (dt as PrimitiveType).getDefaultValueLiteral
		}
		else if (dt instanceof EnumerationType) {
			return getDefaultValue(dt as EnumerationType)
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
						«att.type.type.initializationWithDefaultValues(att.size)»
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
		if (d==null || !(d instanceof VarDecl))
			return newArrayList("", "", "")

		val data = d as VarDecl
		if (data==null)
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
			if (ct!=null && !ct.isEmpty())
				ct
			else
				typeName
		}
		else if (data.getRefType().getType() instanceof EnumerationType) {
			(data.getRefType().getType() as EnumerationType).castType
		}
		else
			typeName
		castTypeName += '*'
		var deRef = '*' 
 
		if (data.getRefType().isRef()) {
			typeName = typeName+"*"
			deRef = '' 
		}

		val typedData = typeName+" "+data.getName() + " = "+deRef+"(static_cast<"+castTypeName+">(generic_data__et));\n"

		val dataArg = ", "+data.getName()
		val typedArgList = ", "+typeName+" "+data.getName()

		return newArrayList(dataArg, typedData, typedArgList);
	}

	override getTargetType(EnumerationType type) {
		if (type.getPrimitiveType()!=null)
			type.getPrimitiveType().getTargetName()
		else
			type.getName()
	}

	override getCastedValue(EnumLiteral literal) {
		val type = literal.eContainer() as EnumerationType
		val cast = type.targetType

		if (type.primitiveType!=null)
			Long.toString(literal.getLiteralValue())
		else
			"(("+cast+")"+Long.toString(literal.getLiteralValue())+")"
	}

	override getCastType(EnumerationType type) {
		if (type.getPrimitiveType()!=null)
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

}
