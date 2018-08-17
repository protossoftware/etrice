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

package org.eclipse.etrice.dctools.fsm.ast.tokens

import org.eclipse.etrice.dctools.fsm.ast.tokens.DCBracketToken.BracketKind
import org.eclipse.xtend.lib.annotations.Data

@Data
class DCBracketToken extends DCToken {

	enum BracketKind {
		LEFT_ROUND, RIGHT_ROUND,
		LEFT_CURLY, RIGHT_CURLY,
		LEFT_SQUARE, RIGHT_SQUARE
	}
	
	static val leftRoundBracket = new DCBracketToken(BracketKind.LEFT_ROUND)
	static val rightRoundBracket = new DCBracketToken(BracketKind.RIGHT_ROUND)
	static val leftCurlyBracket = new DCBracketToken(BracketKind.LEFT_CURLY)
	static val rightCurlyBracket = new DCBracketToken(BracketKind.RIGHT_CURLY)
	static val leftSquareBracket = new DCBracketToken(BracketKind.LEFT_SQUARE)
	static val rightSquareBracket = new DCBracketToken(BracketKind.RIGHT_SQUARE)
	
	static val char2token = #{
		Character.valueOf('(') -> leftRoundBracket,
		Character.valueOf(')') -> rightRoundBracket,
		Character.valueOf('{') -> leftCurlyBracket,
		Character.valueOf('}') -> rightCurlyBracket,
		Character.valueOf('[') -> leftSquareBracket,
		Character.valueOf(']') -> rightSquareBracket
	}
	
	BracketKind bracketKind
	
	private new(BracketKind bk) {
		super(Kind.BRACKET)
		this.bracketKind = bk
	}
	
	static def getToken(char c) {
		char2token.get(c)
	}
}