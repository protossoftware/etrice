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

package org.eclipse.etrice.expressions.detailcode

import com.google.common.collect.ImmutableList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Defines abstract syntax of detail expressions = <i>ExpressionFeature ('.' ExpressionFeature)* </i>
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
		val String id 					// name
		val ExpressionPostfix postfix	// follows name
		Object data						// business object
	}

	enum ExpressionPostfix {
		NONE,
		PARENTHESES,
		BRACKETS
	}
	
	static class EmptyDetailExpressionProvider implements IDetailExpressionProvider {

		val List<ExpressionFeature> EMPTY_LIST = ImmutableList.of

		override List<ExpressionFeature> getInitialFeatures() {
			return EMPTY_LIST;
		}

		override List<ExpressionFeature> getContextFeatures(ExpressionFeature ctx) {
			return EMPTY_LIST;
		}
	}
}
