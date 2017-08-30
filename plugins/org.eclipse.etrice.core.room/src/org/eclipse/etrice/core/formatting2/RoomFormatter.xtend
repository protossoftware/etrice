/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.formatting2;

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.common.base.AnnotationType
import org.eclipse.etrice.core.common.base.Documentation
import org.eclipse.etrice.core.common.base.Import
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.fsm.formatting2.FSMFormatter
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.GeneralProtocolClass
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.core.services.RoomGrammarAccess
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.formatting2.IFormattableDocument

// In order to save effort, try writing generic rules. Use 'highPriority' to override them in specific rules.
class RoomFormatter extends FSMFormatter { 
	
	@Inject extension RoomGrammarAccess

	override void formatAllByKeywords(EObject it, extension IFormattableDocument document) {
		super.formatAllByKeywords(it, document)
		
		allRegionsFor.keywords('default', 'void', 'sends', 'sub', 'of', 'and', 'satisfied_by').forEach[
			surround[oneSpace]
		]
		allRegionsFor.keywords('/').forEach[surround[noSpace]]
		
		// all pure text keyword => append[oneSpace]
		val textKeywords = GrammarUtil.allRules(getGrammar).map[
			eAllContents.filter(Keyword).filter[value != 'ref'].filter[value.toCharArray.forall[Character.isLetter(it)]].toIterable
		].flatten
		allRegionsFor.keywords(textKeywords).forEach[append[oneSpace]]
	}

	def dispatch void format(RoomModel it, extension IFormattableDocument document) {
		formatAllByKeywords(document)
		
		// top level contents
		eContents.head.prepend[newLines = 2]
		eContents.tail.filter(DataClass).forEach[prepend[newLines = 2]]
		eContents.tail.filter(GeneralProtocolClass).forEach[prepend[newLines = 2]]
		eContents.tail.filter(ActorClass).forEach[prepend[newLines = 2]]
		eContents.tail.filter(SubSystemClass).forEach[prepend[newLines = 2]]
		eContents.tail.filter(AnnotationType).forEach[prepend[newLines = 2]]
		eContents.tail.filter(AnnotationType).forEach[prepend[newLines = 2]]
		eContents.tail.filter(Import).forEach[prependDefaultNewLines(document)]
		eContents.tail.filter(PrimitiveType).forEach[prependDefaultNewLines(document)]
		eContents.tail.filter(EnumerationType).forEach[prependDefaultNewLines(document)]
		eContents.tail.filter(ExternalType).forEach[prependDefaultNewLines(document)]
		
		eAllContents.forEach[
			format	// recursive
		]
	}	
	
	def dispatch void format(RoomClass it, extension IFormattableDocument document) {
		eContents.filter[!(it instanceof DetailCode || it instanceof Documentation)].forEach[prependDefaultNewLines(document)]
		regionFor.keywords('usercode1', 'usercode2', 'usercode3', 'incoming', 'outgoing', 'regular', 'conjugated', 'Interface', 'Structure', 'Behavior').forEach[prependDefaultNewLines(document)]
	}
	
	def dispatch void format(PortClass it, extension IFormattableDocument document) {
		eContents.filter[!(it instanceof DetailCode || it instanceof Documentation)].forEach[prependDefaultNewLines(document)]
	}
	
	def dispatch void format(Operation it, extension IFormattableDocument document) {
		arguments.forEach[append[noSpace]]
	}
	
	def dispatch void format(Attribute it, extension IFormattableDocument document) {
		regionFor.keywordPairs('[', ']').forEach[
			key.prepend[oneSpace]
			interior[noSpace]
		]
	}
}
