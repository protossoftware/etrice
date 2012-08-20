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


package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.ArrayList
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
	@Inject TypeHelpers typeHelpers
	@Inject RoomExtensions roomExt
	
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
		return ConfigHelper::ac2acConfMap.get(ConfigHelper::aiConf2acMap.get(ai))
	}
	
	// config operations
	
	def String getInitValueLiteral(Attribute a){
		var result = a.defaultValueLiteral
		var configValues = a.configClassValues
		
		if(configValues != null &&  a.refType.type instanceof PrimitiveType){
			var type = a.refType.type as PrimitiveType
			if(a.size != configValues.size)
				result = languageExt.toValueLiteral(type, configValues.get(0))
			else
				result = toArrayValueLiteral(type, configValues)
		}
		
		return result
	}
	
	def String[] getConfigClassValues(Attribute attr){
		if(attr.eContainer instanceof DataClass)
			return null;
			
		if (attr.eContainer instanceof ActorClass){
			var ac = attr.eContainer as ActorClass;	
			return ac.classConfig?.attributes?.getConfigValue(attr);
		}
		else if(attr.eContainer instanceof PortClass){
			var pc = attr.eContainer as PortClass;
			var protocol = pc.eContainer as ProtocolClass
			var prcConfig = getProtocolConfig(protocol as ProtocolClass);
			if(pc.equals(protocol.regular)){
				return prcConfig?.regular?.attributes?.getConfigValue(attr);
			} else
				return prcConfig?.conjugated?.attributes?.getConfigValue(attr);
		}
	}
	
	def String[] getConfigValue(List<AttrClassConfig> attrConfigs, Attribute attr){
		attrConfigs.findFirst(attrConfig | attrConfig.attribute.equals(attr))?.value?.getValues;
	}
	
	def String[] getValues(LiteralArray literalArray){
		var values = new ArrayList<String>();
		var literals = literalArray.literals
		if(literals.get(0) instanceof StringLiteral)
			values.add(literals.get(0).value)
		else
			for(l : literalArray.literals)
				values.add(l.value)
		
		if(values.empty)
			return null
		return values
	}
	
	def String getValue(Literal literal){
		switch literal{
			BooleanLiteral:
				return String::valueOf(literal.isTrue)
			IntLiteral:
				return String::valueOf(literal.value)
			RealLiteral:
				return String::valueOf(literal.value)
			StringLiteral:
				return String::valueOf(literal.value)
		}
		return null
	}
	
	def List<AttrInstanceConfig> getConfigAttributes(ActorInstance ai){
		var attrConfigs = new ArrayList<AttrInstanceConfig>()
		var config = ConfigHelper::path2aiConfMap.get(ai.path)
		if(config != null)
			return config.attributes
		
		return attrConfigs
	}
	
	def List<PortInstanceConfig> getConfigPorts(ActorInstance ai){
		var portConfigs = new ArrayList<PortInstanceConfig>()
		var config = ConfigHelper::path2aiConfMap.get(ai.path)
		if(config != null){
			for(portConfig : config.ports)
				portConfigs.add(portConfig)
		}
		
		return portConfigs
	}
	
	def hasVariableService(SubSystemClass ssc){
		ssc.getSubSystemConfig?.dynConfig != null
	}
	
	def List<AttrClassConfig> getAllAttrConfigFlat(ActorClass ac){
		var result = new ArrayList<AttrClassConfig>()
		if(ac.classConfig != null){
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
	
	def List<AttrInstanceConfig> getAttrDynConfigs(SubSystemClass ssc, boolean read, boolean write){
		var configs = ConfigHelper::ssc2attrInstConfMap.get(ssc)
		val result = new ArrayList<AttrInstanceConfig>(configs.size)
		if(configs != null)
			configs.forEach(c | if((read && c.readOnly) || (write && !c.readOnly)) result.add(c))
		
		return result
	}
		
	def List<String> getPath(AttrConfig config, boolean ss, boolean actor, boolean dc, boolean attr){
		var result = new LinkedList<String>()
		var c = config
		while(c.eContainer instanceof AttrConfig){
			c = c.eContainer as AttrConfig
			if(dc)
				result.addFirst(c.attribute.name)
		}
		if(c.eContainer instanceof ActorInstanceConfig){
			var aic = c.eContainer as ActorInstanceConfig
			if(actor)
				result.addAll(0, aic.path.refs)
			if(ss)
				result.addFirst(aic.root.name)
		} else if(c.eContainer instanceof ActorClassConfig){
			var ac= c.eContainer as ActorClassConfig
			if(actor)
				result.addFirst(ac.actor.name)
		}
		if(attr)
			result.add(config.attribute.name)
		
		return result
	}
	
	def String toPath(List<String> path, String pathDelim){
		ConfigHelper::toPath(path, pathDelim)
	}	
	
	def List<Attribute> getDynConfigAttributes(ActorClass ac, boolean read, boolean write){
		var attributes = new ArrayList<Attribute>()
		
		var instanceConfigs = ConfigHelper::ac2aiConfMap.get(ac)
		if(instanceConfigs != null){
			for(instanceConfig : instanceConfigs)
				for(attrConfig : instanceConfig.attributes)
					if(attrConfig.dynConfig)
						if((read && attrConfig.readOnly) || (write && !attrConfig.readOnly))
							attributes.add(attrConfig.attribute)
		}
					
		return attributes;
	}
	
	
	
	
}


