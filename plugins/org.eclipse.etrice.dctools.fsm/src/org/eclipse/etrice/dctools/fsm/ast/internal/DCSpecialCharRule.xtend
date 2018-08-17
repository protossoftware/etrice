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

import org.eclipse.etrice.dctools.fsm.ast.tokens.DCToken
import org.eclipse.etrice.dctools.fsm.ast.tokens.DCToken.Kind
import org.eclipse.jface.text.rules.ICharacterScanner
import org.eclipse.jface.text.rules.IRule
import org.eclipse.jface.text.rules.Token

class DCSpecialCharRule implements IRule {
	
	public static val char SEP = ';'
	public static val char PERIOD = '.'
	
	val period = new DCToken(Kind.PERIOD)
	val sep = new DCToken(Kind.STATEMENT_SEP)
	
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