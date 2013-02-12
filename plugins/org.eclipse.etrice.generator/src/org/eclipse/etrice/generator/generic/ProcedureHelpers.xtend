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

import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*
import org.eclipse.etrice.core.room.PrimitiveType

@Singleton
class ProcedureHelpers {

	@Inject ILanguageExtension languageExt
	@Inject extension TypeHelpers
	@Inject ILogger logger

	def userCode(DataClass dc, int id) {
		switch (id) {
			case 1: userCode(getDeepUserCode1(dc))
			case 2: userCode(getDeepUserCode2(dc))
			case 3: userCode(getDeepUserCode3(dc))
		}
	}

	def userCode(ProtocolClass pc, int id) {
		switch (id) {
			case 1: userCode(getDeepUserCode1(pc))
			case 2: userCode(getDeepUserCode2(pc))
			case 3: userCode(getDeepUserCode3(pc))
		}
	}

	def userCode(ActorContainerClass ac, int id) {
		switch (id) {
			case 1: userCode(getDeepUserCode1(ac))
			case 2: userCode(getDeepUserCode2(ac))
			case 3: userCode(getDeepUserCode3(ac))
		}
	}
	
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
	/* TODO: add ref type */
	def attributes(List<Attribute> attribs) {'''
		/*--------------------- attributes ---------------------*/
		«FOR attribute : attribs»
			«attributeDeclaration(attribute)»
		«ENDFOR»
	'''
	}
	
	def attributeDeclaration(Attribute attribute){'''
		«IF attribute.size==0»
			«attribute.refType.type.typeName»«IF attribute.refType.ref»«languageExt.pointerLiteral()»«ENDIF» «attribute.name»;
		«ELSE»
			«languageExt.arrayDeclaration(attribute.refType.type.typeName, attribute.size, attribute.name, attribute.refType.ref)»;
		«ENDIF» 	
	'''	
	}

	def arrayInitializer(Attribute att) {
		var dflt = if (att.defaultValueLiteral!=null) att.defaultValueLiteral else languageExt.defaultValue(att.refType.type)

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
	def attributeSettersGettersDeclaration(List<Attribute> attribs, String classname) {'''
		//--------------------- attribute setters and getters
		«FOR attribute : attribs»
			«setterHeader(attribute, classname)»;
			«getterHeader(attribute, classname)»;
		«ENDFOR»
	'''
	}
	
	def attributeSettersGettersImplementation(List<Attribute> attribs, String classname) {'''
		//--------------------- attribute setters and getters
		«FOR attribute : attribs»«setterHeader(attribute, classname)» {
			 «languageExt.memberAccess()»«attribute.name» = «attribute.name»;
		}
		«getterHeader(attribute, classname)» {
			return «languageExt.memberAccess()»«attribute.name»;
		}
		«ENDFOR»
	'''
	}
	
	def private setterHeader(Attribute attribute, String classname){'''
		«languageExt.accessLevelPublic()»void set«attribute.name.toFirstUpper()» («languageExt.selfPointer(classname, true)»«attribute.refType.type.typeName»«IF attribute.size!=0»[]«ENDIF» «attribute.name»)'''
	}
	def private getterHeader(Attribute attribute, String classname){'''
		«languageExt.accessLevelPublic()»«attribute.refType.type.typeName»«IF attribute.size!=0»[]«ENDIF» get«attribute.name.toFirstUpper()» («languageExt.selfPointer(classname, false)»)'''
	}
	
	def argList(List<Attribute> attributes) {
		'''«FOR a : attributes SEPARATOR ", "»«a.refType.type.typeName»«IF a.size>0»[]«ENDIF» «a.name»«ENDFOR»'''
	}
	
	def invokeGetters(Iterable<Attribute> path, String classname){
		'''«FOR a : path SEPARATOR '.'»«invokeGetter(a.name, classname)»«ENDFOR»'''
	}

	// generic setters & getters
	
	def getterImplementation(String typeName, String name, String classname){'''
		«languageExt.accessLevelPublic()»«typeName» get«name.toFirstUpper()» («languageExt.selfPointer(classname, false)»){
			return «languageExt.memberAccess()»«name»;
		}'''
	}
	
	def invokeGetter(String name, String classname){
		'''get«name.toFirstUpper»(«languageExt.selfPointer(classname, true)»)'''
	}
	
	def invokeSetter(String name, String classname, String value){
		'''set«name.toFirstUpper»(«languageExt.selfPointer(classname, true)»«value»)'''
	}
	
	// Operations
	def operationsDeclaration(List<? extends Operation> operations, String classname) {'''
		/*--------------------- operations ---------------------*/
		«FOR operation : operations»
			«IF !(languageExt.usesInheritance && operation.constructor)»
				«operationSignature(operation, classname)»;
			«ENDIF»
		«ENDFOR»
		'''
	}

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

	def operationsImplementation(ActorClass ac) {
		operationsImplementation(ac.operations, ac.name)
	}
	
	def destructorCall(String classname) {
		languageExt.destructorName(classname)+"()"
	}
	
	def private operationSignature(Operation operation, String classname) {
		if (operation.constructor)
			classOperationSignature(classname, languageExt.constructorName(classname), "", languageExt.constructorReturnType)
		else if (operation.destructor)
			classOperationSignature(classname, languageExt.destructorName(classname), "", languageExt.destructorReturnType)
		else
			classOperationSignature(classname, operation.name, BuildArgumentList(operation.arguments).toString, dataTypeToString(operation.returntype))
	}

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
	
//	def attributeInitializer(Attribute a, String valueFromModel){
//		if(a.refType.type.primitive){
//			var aType = a.refType.type as PrimitiveType
//			var value = languageExt.toValueLiteral(aType, valueFromModel)
//			return switch null {
//				case a.size == 0 || aType.characterType:
//					value
//				case value.startsWith("{")
//			}
//		'''
//			«IF a.size == 0 || aType.characterType»
//					«getter»«procedureHelpers.invokeSetter(a.name,null,literalValue)»;
//				«ELSEIF literalValue.startsWith("{")»
//					«getter»«procedureHelpers.invokeSetter(a.name,null, '''new «aType.typeName»[] «literalValue»''')»;
//				«ELSE»
//					{
//						«aType.typeName»[] _«a.name» = new «aType.typeName»[«a.size»];
//						for (int i=0;i<«a.size»;i++){
//							_«a.name»[i] = «literalValue»;
//						}
//						«getter»«procedureHelpers.invokeSetter(a.name,null,"_"+a.name)»;
//					}
//			«ENDIF»
//		'''
//		}
//	}
//
//	def attributeDefaultInitialzier(Attribute a){
//		
//	}	
}
