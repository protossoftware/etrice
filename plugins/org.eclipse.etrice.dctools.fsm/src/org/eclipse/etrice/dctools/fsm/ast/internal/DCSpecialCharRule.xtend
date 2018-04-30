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
import org.eclipse.etrice.dctools.fsm.ast.internal.DCToken.Kind

class DCSpecialCharRule implements IRule {
	
	val period = new DCToken(Kind.PERIOD)
	val sep = new DCToken(Kind.STATEMENT_SEP)
	
	val char SEP = ';'
	val char PERIOD = '.'
	
	override evaluate(ICharacterScanner scanner) {
		val c = scanner.read as char
		
		// Note: switch/case didn't work
		if (c==SEP) {
			sep
		}
		else if (c==PERIOD) {
			period
		}
		else {
			scanner.unread
			Token.UNDEFINED
		}
	}
	
}