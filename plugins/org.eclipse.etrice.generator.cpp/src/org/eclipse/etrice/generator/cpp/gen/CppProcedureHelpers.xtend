package org.eclipse.etrice.generator.cpp.gen

import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.generator.generic.ProcedureHelpers

class CppProcedureHelpers extends ProcedureHelpers {

	override protected getterHeader(Attribute attribute, String classname) {
		val constModifier = if(attribute.size == 0 && (attribute.type.type.isPrimitive || attribute.type.ref)) ' const' else ''
		super.getterHeader(attribute, classname) + constModifier
	}

	override declarationString(Attribute attribute) {
		switch it : attribute {
			// no reference
			case size > 0: super.declarationString(it)
			default: languageExt.getTypeSignature(type) + ' ' + name
		}
	}

	override signatureString(Attribute attribute) {
		switch it : attribute {
			case size > 0: super.signatureString(attribute) + '&'
			default: languageExt.getTypeSignature(type)
		}
	}

	/**
	 * @param attributes a list of {@link Attribute}s
	 * @return an argument list for the attributes with const except for ref {@link Attribute}s
	 */
	def constArgList(Iterable<Attribute> attributes) {
		attributes.map[(if(!type.ref) 'const ' else '' ) + signatureString + ' ' + name].join(', ')
	}

		


}