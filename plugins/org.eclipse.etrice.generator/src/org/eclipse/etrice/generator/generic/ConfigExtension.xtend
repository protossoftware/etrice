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
import java.util.List
import org.eclipse.etrice.core.config.ActorClassConfig
import org.eclipse.etrice.core.config.AttrClassConfig
import org.eclipse.etrice.core.config.AttrInstanceConfig
import org.eclipse.etrice.core.config.BooleanLiteral
import org.eclipse.etrice.core.config.Literal
import org.eclipse.etrice.core.config.IntLiteral
import org.eclipse.etrice.core.config.LiteralArray
import org.eclipse.etrice.core.config.PortInstanceConfig
import org.eclipse.etrice.core.config.ProtocolClassConfig
import org.eclipse.etrice.core.config.RealLiteral
import org.eclipse.etrice.core.config.StringLiteral
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.LiteralType
import org.eclipse.etrice.generator.base.ConfigHelper

@Singleton
class ConfigExtension {
	
	@Inject extension ILanguageExtension languageExt
					
	def getInitValue(Attribute a){
		var value = a.configDefaultValue
		if(value == null)
			value = a.defaultValueLiteral
		
		return value;
	}	
	
	def String getConfigDefaultValue(Attribute attr){
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
	
	def String getConfigValue(List<AttrClassConfig> attrConfigs, Attribute attr){
		attrConfigs.findFirst(attrConfig | attrConfig.attribute.equals(attr))?.value?.stringValue(attr);
	}
	
	
	def ActorClassConfig getClassConfig(ActorClass ac){
		ConfigHelper::actorMap.get(ac)
	}
	
	def ProtocolClassConfig getProtocolConfig(ProtocolClass prc){
		ConfigHelper::protocolMap.get(prc);
	}
	
	def stringValue(LiteralArray literalArray, Attribute attr){
		var string = ""
		if(attr.isArray && literalArray.literals.size > 1){
			string=string+'''{ «FOR literal : literalArray.literals»«literal.stringValue», «ENDFOR»'''
			string=string.substring(0, string.length-2)+''' }'''
		}	
		else
			string = literalArray.literals.get(0).stringValue
		
		return string
	}
	
	def private stringValue(Literal literal){
		switch(literal){
			BooleanLiteral: literal.isTrue.toString
			IntLiteral: literal.value.toString
			RealLiteral: literal.value.toString
			StringLiteral: {
				var value = literal.value.toString;
					if(value.length == 1)
						"'"+value+"'"
					else value.toCharArrayExpr
			}
		}
	}
	
	def boolean isArray(Attribute attr){
		var isChar = false
		if(attr.refType.type instanceof PrimitiveType){
			var primitive = attr.refType.type as PrimitiveType
			isChar = primitive.type == LiteralType::CHAR
		}
		
		!isChar && attr.size > 0
	}	
	
	def List<AttrInstanceConfig> getConfigAttributes(ActorInstance ai){
		var attrConfigs = new ArrayList<AttrInstanceConfig>();
		var config = ConfigHelper::instanceMap.get(ai.path);
		if(config != null){
			for(attrConfig : config.attributes)
				if(attrConfig.getValue != null)
					attrConfigs.add(attrConfig);
		}
		
		return attrConfigs;
	}
	
	def List<PortInstanceConfig> getConfigPorts(ActorInstance ai){
		var portConfigs = new ArrayList<PortInstanceConfig>();
		var config = ConfigHelper::instanceMap.get(ai.path);
		if(config != null){
			for(portConfig : config.ports)
				portConfigs.add(portConfig);
		}
		
		return portConfigs;
	}
}