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