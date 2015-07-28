/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.detailcode

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Defines detail expressions = <i>ExpressionFeature ('.' ExpressionFeature)* </i>
 */
interface IDetailExpressionProvider {

	static val char SEPARATOR = '.'

	/**
	 * A list of ExpressionFeatures, without preceding '.' and that can start a context
	 * @return not null
	 */
	def List<ExpressionFeature> getInitialFeatures()

	/**
	 * A list of ExpressionFeatures, that can follow ctx
	 * @param ctx having non-null entries
	 * @return not null
	 */
	def List<ExpressionFeature> getContextFeatures(ExpressionFeature ctx)

	/**
	 * ExpressionFeature = <i>id(postfix)?</i> with <i> postfix = '(' .* ')' | '[' .* ']'
	 */
	@Accessors // @Data
	static class ExpressionFeature {
		val String id
		val ExpressionPostfix postfix
		Object data
	}

	enum ExpressionPostfix {
		NONE,
		PARENTHESES,
		BRACKETS
	}
}
