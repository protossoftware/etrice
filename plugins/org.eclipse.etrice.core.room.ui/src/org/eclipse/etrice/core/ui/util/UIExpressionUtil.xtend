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

package org.eclipse.etrice.core.ui.util

import com.google.common.collect.ImmutableList
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.fsm.fSM.TransitionBase
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilder
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.ui.RoomUiModule
import org.eclipse.etrice.expressions.detailcode.DetailExpressionAssistParser
import org.eclipse.etrice.expressions.detailcode.DetailExpressionProvider
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature
import org.eclipse.jface.text.Document
import org.eclipse.xtext.nodemodel.ILeafNode

import static org.eclipse.xtext.EcoreUtil2.getContainerOfType
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.EmptyDetailExpressionProvider

/** 
 * Utility to create and cache DetailExpressionProvider
 */
class UIExpressionUtil {

	static class ExpressionCache {
		val genModelAccess = new GenModelAccess
		val Map<RoomClass, ImmutableList<ExpressionFeature>> classScopeCache = newHashMap
	}

	static class GenModelAccess {
	
		Map<ModelComponent, GraphContainer> cache = newHashMap
		
		def public GraphContainer get(ModelComponent mc) {
			if(!cache.containsKey(mc)) {
				val builder = new ExtendedFsmGenBuilder(RoomUiModule.injector);
				val gc = builder.createTransformedModel(mc)
				builder.withCommonData(gc)
				cache.put(mc, gc)
			}
			
			return cache.get(mc)
		}
		
	}
	
	static def IDetailExpressionProvider selectExpressionProvider(EObject ctx, ExpressionCache cache) {	
		// TODO intermediate fix for null from Dialogs	
		if(ctx === null)
			return new EmptyDetailExpressionProvider
			
		val exprProvider = RoomUiModule.getInjector().getInstance(DetailExpressionProvider) => [ prov |
			prov.model = ctx
		]
		// set cache
		val roomClass = getContainerOfType(ctx, RoomClass)
		if(roomClass !== null) {
			exprProvider.classScopeCache = cache.classScopeCache.get(roomClass)
			if(exprProvider.classScopeCache === null)
				cache.classScopeCache.put(roomClass, exprProvider.createAndSetClassScopeCache)
		}
		// set transitionData
		val transition = getContainerOfType(ctx, TransitionBase)
		if(transition !== null) {
			if(roomClass instanceof ActorClass) {
				val commonData = FsmGenExtensions.getLinkFor(cache.genModelAccess.get(roomClass), transition)?.commonData
				if(commonData instanceof MessageData)
					exprProvider.transitionEventData = commonData	
			}
		}
		
		return exprProvider
	}
	
	static def IDetailExpressionProvider selectExpressionProvider(EObject it) {
		return selectExpressionProvider(it, new ExpressionCache)
	}

	
	static def ExpressionFeature findAtOffset(ILeafNode leafNode, int offset) {
		// work in progress - show eObject for detail code
		val exprProvider = selectExpressionProvider(leafNode.semanticElement)
		
		// TODO explicit support for hover info in DetailExpressionAssistParser
		val text = leafNode.text
		val completeExprOffset = {
			var exprEndOfsset = offset - leafNode.offset
			while(text.length > exprEndOfsset && Character.isJavaIdentifierPart(text.charAt(exprEndOfsset))) 
				exprEndOfsset += 1
			exprEndOfsset
		}
		val parser = new DetailExpressionAssistParser(new Document(leafNode.text), completeExprOffset, exprProvider)
		val word = parser.computeIdentifierPrefix(completeExprOffset)
		switch contextFeature : parser.resolveLatestCompleted {
			case null: exprProvider.initialFeatures.findFirst[id == word]
			default: exprProvider.getContextFeatures(contextFeature).findFirst[id == word]
		}
	}

}
