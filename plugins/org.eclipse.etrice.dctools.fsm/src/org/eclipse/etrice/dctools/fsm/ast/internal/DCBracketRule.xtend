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

import org.eclipse.jface.text.rules.IRule
import org.eclipse.jface.text.rules.ICharacterScanner
import org.eclipse.jface.text.rules.Token
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCBracketToken

class DCBracketRule implements IRule {
	
	override evaluate(ICharacterScanner scanner) {
		val c = scanner.read
		val token = DCBracketToken.getToken(c as char)
		if (token!==null) {
			return token
		}
		
		scanner.unread
		return Token.UNDEFINED
	}
	
}