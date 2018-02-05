/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.formatting2

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.common.base.Annotation
import org.eclipse.etrice.core.common.base.AnnotationType
import org.eclipse.etrice.core.common.base.Documentation
import org.eclipse.etrice.core.common.base.Import
import org.eclipse.etrice.core.common.services.BaseGrammarAccess
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument

class BaseFormatter extends AbstractFormatter2 {
	
	@Inject extension BaseGrammarAccess
	
	/**
	 *  recursive keyword formatting
	 */
	protected def void formatAllByKeywords(EObject it, extension IFormattableDocument document) {		
		allRegionsFor.keywordPairs('{', '}').forEach[
			key.prepend[oneSpace]
			interior[indent]
			value.prepend[newLine]
		]
		allRegionsFor.keywordPairs('(', ')').forEach[interior[noSpace]]
		allRegionsFor.keyword('(').prepend[noSpace lowPriority]
		
		allRegionsFor.keywords(',').forEach[append[oneSpace]]
		allRegionsFor.keywords('.').forEach[surround[noSpace]]
		
		allRegionsFor.keywords(':').forEach[prepend[noSpace] append[oneSpace]]
		
		// TIME
		allRegionsFor.keywords(getTIMEAccess.getSKeyword_0_1, getTIMEAccess.msKeyword_1_1, getTIMEAccess.usKeyword_2_1, getTIMEAccess.nsKeyword_3_1).forEach[
			if(previousHiddenRegion.length > 1) prepend[oneSpace] else prepend[noSpace]
			append[oneSpace lowPriority]
		]
	}
	
	def dispatch void format(Documentation it, extension IFormattableDocument document) {
		// TODO
	}
	
	def dispatch void format(Import it, extension IFormattableDocument document) {
		regionFor.keywords(importAccess.importKeyword_0, importAccess.modelKeyword_1_1).forEach[append[oneSpace]]
		regionFor.keyword(importAccess.fromKeyword_1_0_1).surround[oneSpace]
		eContents.forEach[format] // format children
	}
	
	def dispatch void format(AnnotationType it, extension IFormattableDocument document) {
		regionFor.keyword(annotationTypeAccess.annotationTypeKeyword_0).append[oneSpace]
		regionFor.keyword(annotationTypeAccess.targetKeyword_4).prepend[newLine]
		attributes.forEach[prepend[newLine]]
		eContents.forEach[format] // format children
	}
	
	def dispatch void format(Annotation it, extension IFormattableDocument document) {
		regionFor.keyword(annotationAccess.commercialAtKeyword_0).append[noSpace]
		if(attributes.size > 1) attributes.forEach[prepend[newLine]]	// separate lines for attributes only for more than one present attribute
		eContents.forEach[format] // format children
	}
	
}
		