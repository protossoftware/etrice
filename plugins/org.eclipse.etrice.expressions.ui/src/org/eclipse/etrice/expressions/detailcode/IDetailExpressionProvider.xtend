/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.expressions.detailcode

import com.google.common.collect.ImmutableList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.emf.ecore.EObject

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
		
		override toString() {
			id + switch postfix {
				case PARENTHESES: '()'
				case BRACKETS: '[]'
				default: ''
			} + ' - ' + if(data instanceof EObject) data.eClass.name else data
		}
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
