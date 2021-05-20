/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
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
package org.eclipse.etrice.generator.config

import com.google.inject.Inject
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import org.eclipse.emf.common.EMFPlugin
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.etrice.core.ConfigStandaloneSetup
import org.eclipse.etrice.core.common.base.BooleanLiteral
import org.eclipse.etrice.core.common.base.IntLiteral
import org.eclipse.etrice.core.common.base.Literal
import org.eclipse.etrice.core.common.base.RealLiteral
import org.eclipse.etrice.core.common.base.StringLiteral
import org.eclipse.etrice.core.config.ConfigValue
import org.eclipse.etrice.core.config.ConfigValueArray
import org.eclipse.etrice.core.config.EnumConfigValue
import org.eclipse.etrice.core.config.LiteralConfigValue
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.generator.base.logging.ILogger
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.config.util.DataConfigurationHelper

class DataConfiguration implements IDataConfiguration {

	@Inject
	protected extension DataConfigurationHelper
	
	@Inject
	protected ILogger logger;

	override doSetup() {
		if (!EMFPlugin::IS_ECLIPSE_RUNNING)
			ConfigStandaloneSetup::doSetup()

	}

	override setResources(ResourceSet resource, ILogger logger) {
		setConfigModels(resource, logger)
	}

	// static
	override getAttrClassConfigValue(ActorClass actor, List<Attribute> path) {
		actor.getAttrClassConfig(path)?.value?.toStringExpr
	}

	override getAttrClassConfigMaxValue(ActorClass actor, List<Attribute> path) {
		actor.getAttrClassConfig(path)?.max?.toStringExpr
	}

	override getAttrClassConfigMinValue(ActorClass actor, List<Attribute> path) {
		actor.getAttrClassConfig(path)?.min?.toStringExpr
	}

	def private getAttrClassConfig(ActorClass actor, List<Attribute> path) {
		var id = '''/«actor.name»/«path.toStringPath»'''.toString
		actorClassAttrMap.get(id)
	}

	override getAttrClassConfigValue(ProtocolClass pc, boolean regular, List<Attribute> path) {
		var id = '''/«pc.name»/«IF regular»regular«ELSE»conjugated«ENDIF»/«path.toStringPath»'''.toString
		protocolClassAttrMap.get(id)?.value?.toStringExpr
	}

	def private toStringPath(List<Attribute> path) {
		'''«FOR a : path SEPARATOR '/'»«a.name»«ENDFOR»'''.toString
	}

	override getAttrInstanceConfigValue(ActorInstance ai, List<Attribute> path) {
		var id = ai.path + "/" + path.toStringPath
		actorInstanceAttrMap.get(id)?.value?.toStringExpr
	}

	override getAttrInstanceConfigValue(InterfaceItemInstance item, List<Attribute> path) {
		actorInstanceAttrMap.get(item.path + "/" + path.toStringPath)?.value?.toStringExpr
	}

	// dynamic
	override getPollingTimerUser(SubSystemInstance subsystem) {
		val dynConf = subsystem.config?.dynConfig
		if (dynConf === null)
			0
		else
			dynConf.polling
	}

	override getUserCode1(SubSystemInstance subsystem) {
		var dynConfig = subsystem.config?.dynConfig
		return if (dynConfig?.filePath !== null)
			"import org.eclipse.etrice.runtime.java.config.ConfigSourceFile;" // TODO JH make lang independent
		else
			dynConfig?.userCode1
	}

	override getUserCode2(SubSystemInstance subsystem) {
		var dynConfig = subsystem.config?.dynConfig
		return if (dynConfig?.filePath !== null) '''new ConfigSourceFile("«dynConfig.filePath»")''' else
			dynConfig?.userCode2
	}

	override getDynConfigReadAttributes(ActorInstance ai) {
		val result = new ArrayList<Attribute>
		var configs = dynActorInstanceAttrMap.get(ai.path)
		configs?.forEach(c|if(c.readOnly) result.add(c.attribute))

		return result
	}

	override getDynConfigWriteAttributes(ActorInstance ai) {
		val result = new ArrayList<Attribute>
		var configs = dynActorInstanceAttrMap.get(ai.path)
		configs?.forEach(c|if(!c.readOnly) result.add(c.attribute))

		return result
	}

	override hasVariableService(SubSystemInstance subsystem) {
		subsystem.config?.dynConfig !== null
	}

	def private toStringExpr(ConfigValueArray literal) {
		'''«FOR l : literal.values SEPARATOR ','»«l.toStringExpr»«ENDFOR»'''.toString
	}

	def private toStringExpr(ConfigValue configValue) {
		switch (configValue) {
			LiteralConfigValue: configValue.value.toStringExpr
			EnumConfigValue: configValue.value.fullName
		}
	}

	def private toStringExpr(Literal literal) {
		switch (literal) {
			BooleanLiteral: literal.isTrue.toString
			IntLiteral: literal.value.toString
			RealLiteral: literal.value.toString
			StringLiteral: literal.value.toString
		}
	}

	def private getConfig(SubSystemInstance cc) {
		subSystemConfigMap.get(cc.path)
	}

	override getDynConfigReadAttributes(ActorClass actor) {
		val result = new HashSet<Attribute>
		val configs = dynActorClassAttrMap.get(actor)
		configs?.forEach(c|if(c.readOnly) result.add(c.attribute))
		return result.toList
	}

	override getDynConfigWriteAttributes(ActorClass actor) {
		val result = new HashSet<Attribute>
		val configs = dynActorClassAttrMap.get(actor)
		configs?.forEach(c|if(!c.readOnly) result.add(c.attribute))
		return result.toList
	}

}
