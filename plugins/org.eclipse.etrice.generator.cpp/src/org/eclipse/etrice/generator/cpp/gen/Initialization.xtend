package org.eclipse.etrice.generator.cpp.gen

import org.eclipse.etrice.core.room.Attribute
import java.util.List
import com.google.inject.Inject
import org.eclipse.etrice.generator.generic.ConfigExtension
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.etrice.core.room.ComplexType
import org.eclipse.etrice.generator.generic.ILanguageExtension
import com.google.inject.Singleton

@Singleton
class Initialization {

	@Inject extension ConfigExtension
	@Inject extension TypeHelpers
	@Inject ILanguageExtension languageExt
	
	def attributeInitialization(List<Attribute> attribs, boolean useClassDefaultsOnly) {
		'''
			// initialize attributes
			«FOR a : attribs»
				«var aType = a.refType.type»
				«var value = a.initValueLiteral»
				«IF value!=null»
					«IF a.size == 0 || aType.characterType»
					«ELSEIF value.startsWith("{")»
						«initializeArrayWithValues(a.name, value.replace("{", "").replace("}", "").split(","))»
					«ELSE»
						for (int i=0;i<«a.size»;i++){
							«a.name»[i] = «value»;
						}
					«ENDIF»
				«ELSEIF aType instanceof ComplexType || a.size>1 || !useClassDefaultsOnly»
					«IF a.size==0»
					«ELSE»
						«IF !useClassDefaultsOnly»
							for (int i=0;i<«a.size»;i++){
								«a.name»[i] = «IF a.refType.isRef»«languageExt.nullPointer()»«ELSE»«languageExt.defaultValue(aType)»«ENDIF»;
							}
						«ENDIF»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		'''
	}
	
	def initializeArrayWithValues(String varName, String[] values) {
		'''
		«values.map(v | varName + "[" + values.indexOf(v) + "] = " + v + ";" ).join("\r\n")»
		'''
	}

	def attributeInitialization(Attribute a, boolean useClassDefaultsOnly) {
		var aType = a.refType.type
		var value = a.initValueLiteral
		if (value != null) {
				if (a.size == 0 || aType.characterType) {
					if (a.refType.isRef) 
						'''«a.name»(new «aType.name»(«value»))'''
					else
						'''«a.name»(«value»)'''
				}
				else if (value.startsWith("{")) {
					'''«a.name»()'''
				}
				else {
					'''«a.name»()'''
				}
		} 
		else if (aType instanceof ComplexType || a.size>1 || !useClassDefaultsOnly) {
			if (a.size==0) {
				if (a.refType.isRef)
					'''«a.name»(«languageExt.nullPointer()»)'''
				else
					'''«a.name»(«languageExt.defaultValue(aType)»)'''
			}
			else 
				'''«a.name»()'''
		}
	}

}