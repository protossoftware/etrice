/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.fsm.ast.nodes

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
abstract class DCAstTextNode extends DCAstNode {
	
	int begin
	int end
	
	new(DCAstNode parent, int readTokens, int begin, int end) {
		super(parent, readTokens)
		this.begin = begin
		this.end = end
	}
	
	abstract def String getText()
}