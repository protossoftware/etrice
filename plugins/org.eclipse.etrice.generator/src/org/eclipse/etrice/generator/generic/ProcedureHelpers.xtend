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
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.ActorContainerClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RefableType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.base.AbstractGenerator

/**
 * A collection of methods for generation of user code, attributes with getters and setters
 * and operations.
 */
@Singleton
class ProcedureHelpers {

	protected val NEWLINE = System.getProperty("line.separator")

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
	def attributes(List<Attribute> attributes) {
	'''
		/*--------------------- attributes ---------------------*/
		«FOR it : attributes»
			«attributeDeclaration»
		«ENDFOR»
	'''
	}

	/**
	 * @param attribute an {@link Attribute}
	 * @return the code declaring the attribute
	 */
	def attributeDeclaration(Attribute attribute) '''
		«languageExt.accessLevelPublic» «attribute.declarationString»;
	'''

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
	def attributeSettersGettersDeclaration(List<Attribute> attributes, String classname) {
	'''
		/* --------------------- attribute setters and getters */
		«FOR attribute : attributes»
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
	def attributeSettersGettersImplementation(List<Attribute> attributes, String classname){'''
		/* --------------------- attribute setters and getters */
		«FOR attribute : attributes»«setterHeader(attribute, classname)» {
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
	def protected setterHeader(Attribute attribute, String classname){
		'''«languageExt.accessLevelPublic()»void set«attribute.name.toFirstUpper()»(«languageExt.selfPointer(classname, true)»«argList(#[attribute])»)'''
	}

	/**
	 * @param attribute an {@link Attribute}
	 * @param classname the name of the defining class
	 * @return code for the attribute getter declaration
	 */
	def protected getterHeader(Attribute attribute, String classname){
		'''«languageExt.accessLevelPublic()»«attribute.signatureString» get«attribute.name.toFirstUpper()»(«languageExt.selfPointer(classname, false)»)'''
	}

	/**
	 * @param attributes a list of {@link Attribute}s
	 * @return an argument list for the attributes
	 */
	def argList(List<Attribute> attributes) {
		attributes.map[signatureString + ' ' + name].join(', ')
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
	def operationsDeclaration(List<? extends Operation> operations, String classname) '''
		/*--------------------- operations ---------------------*/
		«FOR operation : operations»
			«operationSignature(operation, classname, true)»;
		«ENDFOR»
	'''


	/**
	 * @param operations a list of {@link Operation}s
	 * @param classname the name of the type defining the getter
	 * @return code defining the operations
	 */
	def operationsImplementation(List<? extends Operation> operations, String classname) '''
		/*--------------------- operations ---------------------*/
		«FOR operation : operations»
			«operationSignature(operation, classname, false)» {
				«AbstractGenerator::getInstance().getTranslatedCode(operation.detailCode)»
			}
		«ENDFOR»
	'''

	def asBlock(CharSequence str)'''
		{
			«str»
		}
	'''

	/**
	 * invoke user structor, if (inherited) present - <b>C only</b>
	 *
	 * @param cls {@link ActorClass} or {@link DataClass}
	 * @param args self pointer to instance
	 */
	def invokeUserStructor(RoomClass cls, String args, boolean ctor) {
		if (cls.getStructors(!languageExt.usesInheritance).exists[isConstructor == ctor])
			return '''«languageExt.memberInDeclaration(cls.name, if(ctor) 'ctor' else 'dtor')»(«args»);'''

		return ''
	}


	/**
	 * declaration of user constructor + destructor, if (inherited) present - <b>C only</b>
	 *
	 * @param cls {@link ActorClass} or {@link DataClass}
	 */
	def userStructorsDeclaration(RoomClass cls) {
		val namePrefix = languageExt.operationScope(cls.name, true)
		val declBlock = newArrayList

		declBlock += '/*--------------------- user constructor/destructor ---------------------*/'
		if (cls.getStructors(!languageExt.usesInheritance).exists[constructor])
			declBlock += functionSignature(cls.name, namePrefix + 'ctor', 'void', '') + ';'
		if (cls.getStructors(!languageExt.usesInheritance).exists[!constructor])
			declBlock += functionSignature(cls.name, namePrefix + 'dtor', 'void', '') + ';'

		declBlock.join(NEWLINE)
	}

	/**
	 * implementation of user constructor + destructor, if (inherited) present - <b>C only</b>
	 *
	 * @param cls {@link ActorClass} or {@link DataClass}
	 */
	def userStructorsImplementation(RoomClass cls){
		val declBlock = newArrayList

		declBlock += '/*--------------------- user constructor/destructor ---------------------*/'
		declBlock += cls.userStuctorImplementation(true)
		declBlock += cls.userStuctorImplementation(false)

		declBlock.filterNull.join(NEWLINE)
	}

	def protected String userStuctorImplementation(RoomClass cls, boolean ctor) {
		val namePrefix = languageExt.operationScope(cls.name, false)
		if(!cls.getStructors(!languageExt.usesInheritance).exists[isConstructor == ctor])
			return null

		'''
			«functionSignature(cls.name, namePrefix + if(ctor) 'ctor' else 'dtor', 'void', '')»{
				«cls.userStructorBody(ctor)»
			}
		'''
	}

	/**
	 *  implementation of user structor, if (inherited) present
	 */
	def userStructorBody(RoomClass cls, boolean ctor){
		val comment = '''/* user defined «IF ctor»con«ELSE»de«ENDIF»structor body */'''

		val implementedStructors = cls.getStructors(!languageExt.usesInheritance).filter[isConstructor == ctor]
		val translatedCodes = implementedStructors.map[detailCode].map[
			AbstractGenerator::getInstance().getTranslatedCode(it)]

		return comment + NEWLINE + translatedCodes.map[if(translatedCodes.size > 1) asBlock else it].join
	}

	def protected getStructors(RoomClass cls, boolean inherited) {
		switch it : cls {
			ActorClass case !inherited: structors
			DataClass case !inherited: structors
			ActorClass case inherited: allStructors
			DataClass case inherited: allStructors
		}
	}

	/**
	 * @param operation an {@link Operation}
	 * @return the operation signature (with special care for
	 * 		constructor and destructor
	 */
	def protected operationSignature(Operation operation, String classname, boolean isDeclaration) {
		val arguments = '''«FOR argument : operation.arguments SEPARATOR ", "»«argument.refType.signatureString» «argument.name»«ENDFOR»'''
		val returnType = operation.returnType.signatureString
		functionSignature(classname, languageExt.operationScope(classname, isDeclaration)+operation.name, returnType, arguments)
	}

	/**
	 * @param type a {@link RefableType}
	 * @return a string for the type (also for pointers)
	 */
	def String signatureString(RefableType type) {
		switch it : type {
			case null: 'void'
			case isRef: type.type.typeName + languageExt.pointerLiteral
			default: type.type.typeName
		}
	}

	def String signatureString(Attribute attribute){
		switch it : attribute {
			case size > 0: languageExt.arrayType(type.type.typeName, size, type.ref)
			default: type.signatureString
		}
	}

	/**
	 * @param attribute a {@link Attribute}
	 * @return a string for <code>type name</code>
	 */
	def String declarationString(Attribute attribute){
		switch it : attribute {
			case size > 0: languageExt.arrayDeclaration(type.type.typeName, size, type.isRef, name)
			default: type.signatureString + ' ' + name
		}
	}

	def protected functionSignature(String className, String fullFctName, String returnType, String arguments){
		'''«languageExt.accessLevelPublic()» «returnType» «fullFctName»(«languageExt.selfPointer(className, !arguments.empty)»«arguments»)'''
	}

}
