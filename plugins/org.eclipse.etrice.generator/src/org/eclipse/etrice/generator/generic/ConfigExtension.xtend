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
import org.eclipse.etrice.core.config.AttrInstanceConfig
import org.eclipse.etrice.core.config.BooleanLiteral
import org.eclipse.etrice.core.config.IntLiteral
import org.eclipse.etrice.core.config.Literal
import org.eclipse.etrice.core.config.RealLiteral
import org.eclipse.etrice.core.config.StringLiteral
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.generator.base.ConfigHelper
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance

@Singleton
class ConfigExtension {
	
	@Inject extension ILanguageExtension languageExt
		
	def String getConfigDefaultValue(Attribute attr){
		if (!(attr.eContainer instanceof ActorClass))
			return null;
		var ac = attr.eContainer as ActorClass;	
		var attrConfig = ac.classConfig?.attributes?.findFirst(attrConfig | attrConfig.attribute.equals(attr));
		
		return attrConfig?.value?.stringValue(attr);
	}
	
	def ActorClassConfig getClassConfig(ActorClass ac){
		ConfigHelper::classMap.get(ac)
	}
	
	
	def stringValue(Literal literal, Attribute attr){
		switch(literal){
			BooleanLiteral: literal.isTrue.toString
			IntLiteral: literal.value.toString
			RealLiteral: literal.value.toString
			StringLiteral: {
				var value = literal.value.toString;
					if(attr.size == 0)
						"'"+value+"'"
					else value.toCharArrayExpr
			}
		}
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
}