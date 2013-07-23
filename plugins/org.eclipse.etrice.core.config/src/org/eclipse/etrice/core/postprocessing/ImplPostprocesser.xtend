/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import static extension org.eclipse.etrice.core.postprocessing.PostprocessingHelpers.*

class ImplPostProcessing {
	
	def process(GeneratedMetamodel metamodel) {
		var configPackage = metamodel.EPackage
		
		var configModel = configPackage.getClass("ConfigModel")
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
	}
	
}