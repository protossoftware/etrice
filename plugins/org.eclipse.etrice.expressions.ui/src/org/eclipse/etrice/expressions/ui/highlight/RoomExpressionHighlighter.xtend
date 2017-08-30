/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.expressions.ui.highlight

import com.google.inject.Inject
import java.util.List
import org.eclipse.etrice.expressions.ui.DetailExpressionUIProvider
import org.eclipse.xtend.lib.annotations.Accessors

class RoomExpressionHighlighter {
	
	@Accessors
	static class HighlightResult {
		val int offset
		val int length
		val String id
	}
	
	@Inject
	DetailExpressionUIProvider expressionProvider
	
	def List<HighlightResult> getHighlighting(String text, int offset) {
		val result = newArrayList
		
	
		
		
		
		result
	}
}
