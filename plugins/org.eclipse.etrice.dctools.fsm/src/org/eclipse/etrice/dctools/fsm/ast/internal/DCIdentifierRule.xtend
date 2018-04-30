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

import org.eclipse.etrice.dctools.fsm.ast.internal.DCToken.Kind
import org.eclipse.jface.text.rules.ICharacterScanner
import org.eclipse.jface.text.rules.IRule
import org.eclipse.jface.text.rules.Token

class DCIdentifierRule implements IRule {
	
	val detector = new DCWordDetector
	val token = new DCToken(Kind.IDENTIFIER)
	val buffer= new StringBuffer
	
	override evaluate(ICharacterScanner scanner) {
		buffer.setLength(0)
		
		var c = scanner.read
		if (c != ICharacterScanner.EOF && detector.isWordStart(c as char)) {
			do {
				buffer.append(c as char)
				c = scanner.read()
			}
			while (c != ICharacterScanner.EOF && detector.isWordPart(c as char))
			scanner.unread

			val id = buffer.toString
			if (!id.empty) {
				return token
			}
		}
		else {
			scanner.unread
		}
		
		for (var i= buffer.length() - 1; i >= 0; i--) {
			scanner.unread
		}
		return Token.UNDEFINED
	}
	
}