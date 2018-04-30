/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.fsm.ast.internal

import org.eclipse.jface.text.rules.IToken
import org.eclipse.xtend.lib.annotations.Data

@Data
class DCToken implements IToken {
	
	enum Kind {
		COMMENT,
		STRING,
		WHITESPACE,
		PERIOD,
		STATEMENT_SEP,
		BRACKET,
		NUMBER,
		KEYWORD,
		IDENTIFIER,
		OTHER,
		EOF
	}
	
	Kind kind
	
	override getData() {
		null
	}
	
	override isEOF() {
		kind===Kind.EOF
	}
	
	override isOther() {
		kind===Kind.OTHER
	}
	
	override isUndefined() {
		false
	}
	
	override isWhitespace() {
		kind===Kind.WHITESPACE
	}
	
}