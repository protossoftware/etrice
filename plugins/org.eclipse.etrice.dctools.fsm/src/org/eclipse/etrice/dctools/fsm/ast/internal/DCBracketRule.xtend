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

import org.eclipse.jface.text.rules.IRule
import org.eclipse.jface.text.rules.ICharacterScanner
import org.eclipse.jface.text.rules.Token

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