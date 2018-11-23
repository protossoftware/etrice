/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.postprocessing

import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.emf.ecore.EcorePackage

import static extension org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers.*

class ImplPostProcessor {
	
	def process(GeneratedMetamodel metamodel) {
		val configPackage = metamodel.EPackage
		
		val configModel = configPackage.getClass("ConfigModel")
		configModel.addOperation(
				"getActorClassConfigs",
	       		configPackage.getEClassifier("ActorClassConfig"),
	       		UNBOUNDED_MULTIPLICITY,
	       		'''
	       		EList<ActorClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorClassConfig>();
	       		for(ConfigElement element : this.getConfigElements())
	       			if(element instanceof ActorClassConfig)
	       				list.add((ActorClassConfig) element);
	       		return list;
	       		''')
		configModel.addOperation(
		   		"getActorInstanceConfigs",
	       		configPackage.getEClassifier("ActorInstanceConfig"),
	       		UNBOUNDED_MULTIPLICITY,
	       		'''
				EList<ActorInstanceConfig> list = new org.eclipse.emf.common.util.BasicEList<ActorInstanceConfig>();
				for(ConfigElement element : this.getConfigElements())
					if(element instanceof ActorInstanceConfig)
						list.add((ActorInstanceConfig) element);
				return list;''')
		configModel.addOperation(
		   		"getProtocolClassConfigs",
	       		configPackage.getEClassifier("ProtocolClassConfig"),
	       		UNBOUNDED_MULTIPLICITY,
	       		'''
				EList<ProtocolClassConfig> list = new org.eclipse.emf.common.util.BasicEList<ProtocolClassConfig>();
				for(ConfigElement element : this.getConfigElements())
					if(element instanceof ProtocolClassConfig)
						list.add((ProtocolClassConfig) element);
				return list;
				''')
		configModel.addOperation(
		   		"getSubSystemConfigs",
	       		configPackage.getEClassifier("SubSystemConfig"),
	       		UNBOUNDED_MULTIPLICITY,
	       		'''
				EList<SubSystemConfig> list = new org.eclipse.emf.common.util.BasicEList<SubSystemConfig>();
				for(ConfigElement element : this.getConfigElements())
					if(element instanceof SubSystemConfig)
						list.add((SubSystemConfig) element);
				return list;''')
				
		val refSeg = configPackage.getClass("RefSegment")
		refSeg.getAttribute("idx").setDefaultValueLiteral("-1")
		refSeg.addOperation(
			"toString",
			EcorePackage::eINSTANCE.getEClassifier("EString"),
			1,
			'''
				return getRef() + ((getIdx()>=0)? ":"+getIdx() : "");
			'''
		)
	}
	
}