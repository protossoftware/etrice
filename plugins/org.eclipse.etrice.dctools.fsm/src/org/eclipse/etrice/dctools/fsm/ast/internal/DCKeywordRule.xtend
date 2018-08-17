/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.fsm.ast.internal

import org.eclipse.etrice.dctools.fsm.ast.DCLanguage
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCToken
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCToken.Kind
import org.eclipse.jface.text.rules.WordRule

class DCKeywordRule extends WordRule {
	
	val keywordToken = new DCToken(Kind.KEYWORD)
	
	new(DCLanguage language) {
		super(new DCWordDetector(language.isCFamily))
		
		switch language {
			case C_LANGUAGE: DCKeywords.CKeywords.forEach[addWord(keywordToken)]
			case CPP_LANGUAGE: DCKeywords.cppKeywords.forEach[addWord(keywordToken)]
			case JAVA_LANGUAGE: DCKeywords.javaKeywords.forEach[addWord(keywordToken)]
			default: {
				// ignore
			}
		}
	}
	
	static def isCFamily(DCLanguage language) {
		language==DCLanguage.C_LANGUAGE || language==DCLanguage.CPP_LANGUAGE
	}
}
