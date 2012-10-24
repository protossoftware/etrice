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
						«a.name» = «value»;
					«ELSEIF value.startsWith("{")»
						«a.name» = new «aType.typeName»[] «value»;
					«ELSE»
						«a.name» = new «aType.typeName»[«a.size»];
						for (int i=0;i<«a.size»;i++){
							«a.name»[i] = «value»;
						}
					«ENDIF»
				«ELSEIF aType instanceof ComplexType || a.size>1 || !useClassDefaultsOnly»
					«IF a.size==0»
						«IF a.refType.isRef»
							«a.name» = «languageExt.nullPointer()»;
						«ELSE»
							«a.name» = «languageExt.defaultValue(aType)»;
						«ENDIF»
					«ELSE»
						«a.name» = new «aType.typeName»[«a.size»];
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
}