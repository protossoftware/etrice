/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.ArrayList
import java.util.HashSet
import java.util.LinkedList
import java.util.List
import org.eclipse.etrice.core.config.ActorClassConfig
import org.eclipse.etrice.core.config.ActorInstanceConfig
import org.eclipse.etrice.core.config.AttrClassConfig
import org.eclipse.etrice.core.config.AttrConfig
import org.eclipse.etrice.core.config.AttrInstanceConfig
import org.eclipse.etrice.core.config.BooleanLiteral
import org.eclipse.etrice.core.config.IntLiteral
import org.eclipse.etrice.core.config.Literal
import org.eclipse.etrice.core.config.LiteralArray
import org.eclipse.etrice.core.config.PortInstanceConfig
import org.eclipse.etrice.core.config.ProtocolClassConfig
import org.eclipse.etrice.core.config.RealLiteral
import org.eclipse.etrice.core.config.StringLiteral
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.base.ConfigHelper

@Singleton
class ConfigExtension {
	@Inject ILanguageExtension languageExt

	// language operations
	
	def String toArrayValueLiteral(PrimitiveType type, String[] values){
		'''«FOR v : values BEFORE '{' SEPARATOR ', ' AFTER '}'»«languageExt.toValueLiteral(type, v)»«ENDFOR»'''.toString
	}

	// ConfigHelper
	def ActorClassConfig getClassConfig(ActorClass ac){
		ConfigHelper::ac2acConfMap.get(ac)
	}

	def ProtocolClassConfig getProtocolConfig(ProtocolClass prc){
		ConfigHelper::pc2pcConfMap.get(prc);
	}

	def getSubSystemConfig(SubSystemClass ssc){
		ConfigHelper::ssc2ssConfMap.get(ssc)
	}

	def ActorClassConfig getActorClassConfig(ActorInstanceConfig ai){
		ConfigHelper::ac2acConfMap.get(ConfigHelper::aiConf2acMap.get(ai))
	}

	// config operations
	
	def String getInitValueLiteral(Attribute a){
		var configValues = a.configClassValues
		var type = a.refType.type
		var configValue = switch type{
			case configValues == null:
				null
			PrimitiveType case a.size != configValues.size:
				languageExt.toValueLiteral(type, configValues.get(0))
			PrimitiveType:
				toArrayValueLiteral(type, configValues)
		}
		
		return if(configValue != null) configValue else a.defaultValueLiteral
	}

	def String[] getConfigClassValues(Attribute attr){
		if(attr.eContainer instanceof DataClass)
			return null
		
		if (attr.eContainer instanceof ActorClass) {
			var ac = attr.eContainer as ActorClass
			return ac.classConfig?.attributes?.getConfigValue(attr)
		} else
			if(attr.eContainer instanceof PortClass) {
				var pc = attr.eContainer as PortClass;
				var protocol = pc.eContainer as ProtocolClass
				var prcConfig = getProtocolConfig(protocol as ProtocolClass)
				if(pc.equals(protocol.regular)) {
					return prcConfig?.regular?.attributes?.getConfigValue(attr)
				} else
					return prcConfig?.conjugated?.attributes?.getConfigValue(attr)
			}
	}

	def String[] getConfigValue(List<AttrClassConfig> attrConfigs, Attribute attr){
		attrConfigs.findFirst(attrConfig | attrConfig.attribute.equals(attr))?.value?.getValues;
	}

	def String[] getValues(LiteralArray literalArray){
		val result = new ArrayList<String>()
		literalArray.literals.forEach(l | result.add(l.value))
		return if(!result.empty) result else null
	}

	def String getValue(Literal literal){
		return switch literal {
			BooleanLiteral:
				String::valueOf(literal.isTrue)
			IntLiteral:
				String::valueOf(literal.value)
			RealLiteral:
				String::valueOf(literal.value)
			StringLiteral:
				String::valueOf(literal.value)
		}
	}

	def List<AttrInstanceConfig> getConfigAttributes(ActorInstance ai){
		var config = ConfigHelper::path2aiConfMap.get(ai.path)
		return if(config != null) config.attributes else new ArrayList<AttrInstanceConfig>()
	}

	def List<PortInstanceConfig> getConfigPorts(ActorInstance ai){
		val result = new ArrayList<PortInstanceConfig>()
		var config = ConfigHelper::path2aiConfMap.get(ai.path)
		config?.ports?.forEach(portConf | result.add(portConf))
		return result
	}

	def hasVariableService(SubSystemClass ssc){
		ssc.getSubSystemConfig?.dynConfig != null
	}

	def List<AttrClassConfig> getAllAttrConfigFlat(ActorClass ac){
		var result = new ArrayList<AttrClassConfig>()
		if(ac.classConfig != null) {
			var stack = new LinkedList<AttrClassConfig>()
			stack.addAll(ac.classConfig.attributes)
			while(!stack.empty){
				var c = stack.pop
				result.add(c)
				stack.addAll(c.attributes)
			}
		}
		return result
	}

	def Iterable<AttrInstanceConfig> getAttrDynConfigs(SubSystemClass ssc, boolean read, boolean write){
		ConfigHelper::ssc2attrInstConfMap.get(ssc).filter(c |
			c.dynConfig && ((read && c.readOnly) || (write && !c.readOnly))
		)
	}

	def List<String> getPath(AttrConfig config, boolean ss, boolean actor, boolean dc, boolean attr){
		var result = new LinkedList<String>()
		var c = config
		while(c.eContainer instanceof AttrConfig){
			c = c.eContainer as AttrConfig
			if(dc)
				result.addFirst(c.attribute.name)
		}
		if(c.eContainer instanceof ActorInstanceConfig) {
			var aic = c.eContainer as ActorInstanceConfig
			if(actor)
				result.addAll(0, aic.path.refs)
			if(ss)
				result.addFirst(aic.root.name)
		} else
			if(c.eContainer instanceof ActorClassConfig) {
				var ac= c.eContainer as ActorClassConfig
				if(actor)
					result.addFirst(ac.actor.name)
			}
		if(attr)
			result.add(config.attribute.name)
		return result
	}

	def String toPath(Iterable<String> path, String pathDelim){
		ConfigHelper::toPath(path, pathDelim)
	}

	def getDynConfigAttributes(ActorClass ac, boolean read, boolean write){
		val result = new HashSet<Attribute>()
		ConfigHelper::ac2aiConfMap.get(ac)?.
			forEach(aiConf | aiConf.attributes.
				filter(c | c.dynConfig && ((read && c.readOnly) || (write && !c.readOnly))).
					forEach(dynConf | result.add(dynConf.attribute)))
		return result
	}
}
