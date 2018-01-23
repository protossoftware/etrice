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

import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature
import org.eclipse.swt.graphics.RGB

/** Enables re-usability of scanner for xtext and jface editor */
abstract class AbstractHighlightStyles {
	
	// aligned with xtext
	public static val DEFAULT_RGB = new RGB(0, 0, 0)
	public static val TARGET_KEYWORD_RGB = new RGB(127, 0, 85)
	public static val COMMENT_RGB = new RGB(63, 127, 95)
	public static val STRING_RGB = new RGB(42, 0, 255)
	public static val NUMBER_RGB = new RGB(125, 125, 125)

	public static val SPECIAL_FEATURE_RGB = new RGB(220, 48, 0)
	public static val OPERATION_RGB = new RGB(204, 153, 0)
	public static val ATTRIBUTE_RGB = new RGB(105, 185, 0)
	public static val INTERFACE_ITEM_RGB = new RGB(200, 100, 0)
	
	def Object getDefault()
	def Object getTargetKeyword()
	def Object getComment()
	def Object getString()
	def Object getNumber()
	def Object getSpecialFeature()
	def Object getOperation()
	def Object getAttribute()
	def Object getInterfaceItem()
	
	def Object getStyle(ExpressionFeature feature) {
		// xtext uses ID
		switch feature.data {
			InterfaceItem:
				interfaceItem
			Attribute:
				attribute
			Operation:
				operation
			EObject:
				specialFeature // unknown model object == special
//			RuntimeMethodExpressionData:
//				operation
		}
	}
	
}
