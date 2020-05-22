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
package org.eclipse.etrice.expressions.ui.contentassist

import com.google.common.base.Strings
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.core.runtime.Assert
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionPostfix
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.jface.viewers.ILabelProvider
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.graphics.Point

@Singleton
class DetailExpressionProposalConfig{

//	static val String IMAGE_RT_METHOD = "icons/rt_method.png"

	@Inject
	protected ILabelProvider labelProvider

	@Inject
	protected RoomHelpers roomHelpers

	/**
	 * Return postfix string and its selection (relative start, length), e.g. <code>[argument]</code>
	 */
	def Pair<String, Point> getPostfixReplacement(ExpressionFeature feature) {
		feature.assertNotNull

		var String[] brackets = switch feature.postfix {
			case PARENTHESES: #['(', ')']
			case BRACKETS: #['[', ']']
			default: return "" -> null
		}
		var String replacement = switch data : feature.data {
			Operation:
				data.arguments.map[name].join(', ')
			Message case data.data !== null:
				ILanguageExtension.GENERIC_DATA_NAME
			Attribute, // fall through
			InterfaceItem:
				'0'
			default:
				''
		}

		val selection = if(!replacement.empty) new Point(1, replacement.length)
		brackets.head + replacement + brackets.last -> selection
	}

	/**
	 * Return completion string and its selection (relative start, length)
	 */
	def Pair<String, Point> getCompletion(ExpressionFeature feature) {
		feature.assertNotNull

		var postfix = getPostfixReplacement(feature)
		var point = postfix.value
		if (point !== null)
			point.x += feature.id.length

		return feature.id + postfix.key -> point
	}

	/**
	 * Text format:
	 * {@code completionInfo : typedInfo - classInfo}
	 */
	def String getDisplayString(ExpressionFeature feature) {
		feature.assertNotNull

		val data = feature.data

		var completionInfo = feature.id + feature.getPostfixReplacement.key
		var typedInfo = ""
		var classInfo = if(data instanceof EObject) data.eClass.name else ""
		switch data {
			Attribute:
				typedInfo = data?.type?.type?.name
			InterfaceItem:
				typedInfo = data.protocol?.name
//			RuntimeMethodExpressionData case feature.id == RuntimeDetailExpressionProvider.RT_METHOD_GET_REPLICATION:
//				typedInfo = 'int'
			VarDecl: {
				typedInfo = data?.refType?.type?.name
				classInfo = ""
			}
			MessageData: {
				typedInfo = data?.refType?.type?.name
			}
			default: {
				val label = labelProvider.getText(data)

				// if label starts with completion then label might be better
				if(label !== null && !Strings.commonPrefix(label, completionInfo).empty) completionInfo = label
			}
		}

		// mark port as broadcast
		if (feature.postfix == ExpressionPostfix.NONE) {
			switch data {
				SPP case data.isEventDriven /* fall through */ ,
				Port case data.isReplicated && data.isEventDriven:
					completionInfo = completionInfo + " (broadcast)"
			}
		}

		if(!typedInfo.empty) typedInfo = " : " + typedInfo
		if(!classInfo.empty) classInfo = " - " + classInfo

		return completionInfo + typedInfo + classInfo
	}

	def Image getImage(ExpressionFeature feature) {
		feature.assertNotNull

		switch feature.data {
			EObject: labelProvider.getImage(feature.data)
//			RuntimeMethodExpressionData: Activator.getImage(IMAGE_RT_METHOD)
		}
	}

//	/**
//	 * Filter by prefix
//	 */
//	def getContextFeaturesWithPrefix(ExpressionFeature ctx, String prefix) {
//		delegate.getContextFeatures(ctx).filter[id.startsWith(prefix)]
//	}
//
//	/**
//	 * Filter by prefix
//	 */
//	def getInitialFeaturesWithPrefix(String prefix) {
//		delegate.initialFeatures.filter[id.startsWith(prefix)]
//	}

	def protected assertNotNull(ExpressionFeature feature) {
		Assert.isTrue(!Strings.isNullOrEmpty(feature.id))
		Assert.isNotNull(feature.postfix)
		Assert.isNotNull(feature.data)
	}

}
