/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (refactoring, adapted for other target languages)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.ActorContainerClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.DetailCode
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RefableType
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.generator.base.AbstractGenerator

import org.eclipse.etrice.core.room.util.RoomHelpers

/**
 * A collection of methods for generation of user code, attributes with getters and setters
 * and operations.
 */
@Singleton
class ProcedureHelpers {

	@Inject protected extension RoomHelpers
	@Inject protected extension TypeHelpers
	@Inject protected ILanguageExtension languageExt
	@Inject protected ILogger logger

	/**
	 * @param dc a {@link DataClass}
	 * @param id 0, 1 or 2 for the corresponding user codes
	 * @return the generated code
	 */
	def userCode(DataClass dc, int id) {
		switch (id) {
			case 1: userCode(getDeepUserCode1(dc))
			case 2: userCode(getDeepUserCode2(dc))
			case 3: userCode(getDeepUserCode3(dc))
		}
	}

	/**
	 * @param pc a {@link ProtocolClass}
	 * @param id 0, 1 or 2 for the corresponding user codes
	 * @return the generated code
	 */
	def userCode(ProtocolClass pc, int id) {
		switch (id) {
			case 1: userCode(getDeepUserCode1(pc))
			case 2: userCode(getDeepUserCode2(pc))
			case 3: userCode(getDeepUserCode3(pc))
		}
	}

	/**
	 * @param ac an {@link ActorContainerClass}
	 * @param id 0, 1 or 2 for the corresponding user codes
	 * @return the generated code
	 */
	def userCode(ActorContainerClass ac, int id, boolean includeInherited) {
		if (includeInherited)
			switch (id) {
				case 1: userCode(getDeepUserCode1(ac))
				case 2: userCode(getDeepUserCode2(ac))
				case 3: userCode(getDeepUserCode3(ac))
			}
		else
			switch (id) {
				case 1: userCode(ac.userCode1)
				case 2: userCode(ac.userCode2)
				case 3: userCode(ac.userCode3)
			}
	}
	
	/**
	 * @param dc some {@link DetailCode}
	 * @return a string containing the expanded code surrounded by
	 * 		comments (no tag replacement will happen)
	 */
	def userCode(DetailCode dc) {
		userCode(getDetailCode(dc))
	}
	
	def private userCode(String code) {
	'''
		«IF code!=null && !code.empty»
			/*--------------------- begin user code ---------------------*/
			«code»
			/*--------------------- end user code ---------------------*/
		«ENDIF»
	'''
	}
	
	// Attributes
	
	/**
	 * @param EnumTest a list of {@link Attribute}s
	 * @return code declaring the attributes
	 */
	def attributes(List<Attribute> EnumTest) {
	'''
		/*--------------------- attributes ---------------------*/
		«FOR attribute : EnumTest»
			«attributeDeclaration(attribute)»
		«ENDFOR»
	'''
	}
	
	/**
	 * @param attribute an {@link Attribute}
	 * @return the code declaring the attribute
	 */
	def attributeDeclaration(Attribute attribute){
	'''
		«IF attribute.size==0»
			«attribute.type.type.typeName»«IF attribute.type.ref»«languageExt.pointerLiteral()»«ENDIF» «attribute.name»;
		«ELSE»
			«languageExt.arrayDeclaration(attribute.type.type.typeName, attribute.size, attribute.name, attribute.type.ref)»;
		«ENDIF» 	
	'''	
	}

	/**
	 * @param attribute an {@link Attribute}
	 * @return the code for an array initializer
	 */
	def arrayInitializer(Attribute att) {
		val dflt = if (att.defaultValueLiteral!=null) att.defaultValueLiteral else languageExt.defaultValue(att.type.type)

		if (dflt.startsWith("{")) {
			if (dflt.split(",").size!=att.size)
				logger.logInfo("WARNING: array size determined by initializer differs from attribute size ("+att.name+"["+att.size+"] <-> "+dflt+")")
				
			return dflt
		}

		var result = "{"
		var int i = 0
		while (i<att.size) {
			result = result + dflt
			i=i+1
			if (i<att.size)
				result = result + ", "
		}
		return result+"}"
	}
	
	// Attribute setters & getters
	
	/**
	 * @param EnumTest a list of {@link Attribute}s
	 * @param classname the name of the defining class
	 * @return code declaring setters and getters for the attributes
	 */	
	def attributeSettersGettersDeclaration(List<Attribute> EnumTest, String classname) {
	'''
		/* --------------------- attribute setters and getters */
		«FOR attribute : EnumTest»
			«setterHeader(attribute, classname)»;
			«getterHeader(attribute, classname)»;
		«ENDFOR»
	'''
	}

	/**
	 * @param EnumTest a list of {@link Attribute}s
	 * @param classname the name of the defining class
	 * @return code defining setters and getters for the attributes
	 */	
	def attributeSettersGettersImplementation(List<Attribute> EnumTest, String classname) {
	'''
		/* --------------------- attribute setters and getters */
		«FOR attribute : EnumTest»«setterHeader(attribute, classname)» {
			 «languageExt.memberAccess()»«attribute.name» = «attribute.name»;
		}
		«getterHeader(attribute, classname)» {
			return «languageExt.memberAccess()»«attribute.name»;
		}
		«ENDFOR»
	'''
	}
	
	/**
	 * @param attribute an {@link Attribute}
	 * @param classname the name of the defining class
	 * @return code for the attribute setter declaration
	 */	
	def private setterHeader(Attribute attribute, String classname){
		'''«languageExt.accessLevelPublic()»void set«attribute.name.toFirstUpper()» («languageExt.selfPointer(classname, true)»«attribute.type.type.typeName»«IF attribute.size!=0»[]«ENDIF» «attribute.name»)'''
	}
	
	/**
	 * @param attribute an {@link Attribute}
	 * @param classname the name of the defining class
	 * @return code for the attribute getter declaration
	 */	
	def private getterHeader(Attribute attribute, String classname){
		'''«languageExt.accessLevelPublic()»«attribute.type.type.typeName»«IF attribute.size!=0»[]«ENDIF» get«attribute.name.toFirstUpper()» («languageExt.selfPointer(classname, false)»)'''
	}
	
	/**
	 * @param attributes a list of {@link Attribute}s
	 * @return an argument list for the attributes
	 */
	def argList(List<Attribute> attributes) {
		'''«FOR a : attributes SEPARATOR ", "»«a.type.type.typeName»«IF a.size>0»[]«ENDIF» «a.name»«ENDFOR»'''
	}
	
	/**
	 * @param EnumTest an iterable of {@link Attribute}s representing a path
	 * @param classname the name of the defining class
	 * @return the invocation code for the call of a setter
	 */	
	def invokeGetters(Iterable<Attribute> path, String classname){
		'''«FOR a : path SEPARATOR '.'»«invokeGetter(a.name, classname)»«ENDFOR»'''
	}

	// generic setters & getters
	
	/**
	 * @param typeName the type name of the attribute
	 * @param name the name of the attribute
	 * @param classname the name of the type defining the getter
	 * @return code defining the attribute getter
	 */
	def getterImplementation(String typeName, String name, String classname){
	'''
		«languageExt.accessLevelPublic()»«typeName» get«name.toFirstUpper()» («languageExt.selfPointer(classname, false)»){
			return «languageExt.memberAccess()»«name»;
		}
	'''
	}
	
	/**
	 * @param name the name of the attribute
	 * @param classname the name of the type defining the getter
	 * @return code defining the getter call
	 */
	def invokeGetter(String name, String classname){
		'''get«name.toFirstUpper»(«languageExt.selfPointer(classname, true)»)'''
	}
	
	/**
	 * @param name the name of the attribute
	 * @param classname the name of the type defining the getter
	 * @param value the value to be assigned
	 * @return code defining the setter call
	 */
	def invokeSetter(String name, String classname, String value){
		'''set«name.toFirstUpper»(«languageExt.selfPointer(classname, true)»«value»)'''
	}
	
	// Operations
	
	/**
	 * @param operations a list of {@link Operation}s
	 * @param classname the name of the type defining the getter
	 * @return code declaring the operations
	 */
	def operationsDeclaration(List<? extends Operation> operations, String classname) {'''
		/*--------------------- operations ---------------------*/
		«FOR operation : operations»
			«IF !(languageExt.usesInheritance && operation.constructor)»
				«operationSignature(operation, classname)»;
			«ENDIF»
		«ENDFOR»
		'''
	}

	/**
	 * @param operations a list of {@link Operation}s
	 * @param classname the name of the type defining the getter
	 * @return code defining the operations
	 */
	def operationsImplementation(List<? extends Operation> operations, String classname) {
	'''
		/*--------------------- operations ---------------------*/
		«FOR operation : operations»
			«IF !(languageExt.usesInheritance && operation.constructor)»
				«operationSignature(operation, classname)» {
					«AbstractGenerator::getInstance().getTranslatedCode(operation.detailCode)»
				}
			«ENDIF»
		«ENDFOR»
		'''
	}

	/**
	 * @param ac an {@link ActorClass}
	 * @return code defining all operations of the actor class
	 */
	def operationsImplementation(ActorClass ac) {
		operationsImplementation(ac.operations, ac.name)
	}
	
	/**
	 * @param classname the name of a class
	 * @return code calling the destructor of the class
	 */
	def destructorCall(String classname) {
		languageExt.destructorName(classname)+"()"
	}
	
	/**
	 * @param operation an {@link Operation}
	 * @return the operation signature (with special care for
	 * 		constructor and destructor
	 */
	def private operationSignature(Operation operation, String classname) {
		if (operation.constructor)
			classOperationSignature(classname, languageExt.constructorName(classname), "", languageExt.constructorReturnType)
		else if (operation.destructor)
			classOperationSignature(classname, languageExt.destructorName(classname), "", languageExt.destructorReturnType)
		else
			classOperationSignature(classname, operation.name, BuildArgumentList(operation.arguments).toString, dataTypeToString(operation.returnType))
	}

	/**
	 * @param type a {@link RefableType}
	 * @return a string for the type (also for pointers)
	 */
	def private dataTypeToString(RefableType type) {
		return if (type==null)
			"void"
		else 
			if (type.isRef){
				type.type.typeName+languageExt.pointerLiteral();
			}else{
				type.type.typeName
			}
	}
	
	/*
	 * builds comma separated argument list as string from EList<VarDecl> arguments
	 */
	def private BuildArgumentList(EList<VarDecl> arguments){
		'''«FOR argument : arguments SEPARATOR ", "»«argument.refType.type.typeName»«IF argument.refType.ref»«languageExt.pointerLiteral()»«ENDIF» «argument.name»«ENDFOR»'''
	}
	
	def private classOperationSignature(String classname, String operationname, String argumentList, String returnType){
		'''«languageExt.accessLevelPublic()»«returnType» «languageExt.memberInDeclaration(classname, operationname)»(«languageExt.selfPointer(classname, !argumentList.empty)»«argumentList»)'''
	}
	
}
