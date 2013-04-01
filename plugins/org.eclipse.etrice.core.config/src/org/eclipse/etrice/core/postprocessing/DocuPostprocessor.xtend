/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import static extension org.eclipse.etrice.core.postprocessing.PostprocessingHelpers.*

class DocuPostprocessor {
		
	def process(GeneratedMetamodel metamodel) {
		val pckg = metamodel.EPackage
		
		//------------------------------------------------------------------
		var cls = pckg.getClass("ConfigModel")
		cls.setDocumentation(
			'''
				The root object for the ROOM Config model. It gives access to
				the {@link SubSystemConfig sub system class},
				{@link ActorClassConfig actor class}, {@link ProtocolClassConfig protocol class} and
				{@link ActorInstanceConfig actor instance} configurations and the room model {@link Import imports}.
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The model name is a dot separated fully qualified name and is
				used to provide a name space.
			''')
		
		cls.getReference("imports").setDocumentation(
			'''
				This is a list of all imported room models. The config elements reference these imports.
			''')
		
		cls.getReference("configElements").setDocumentation(
			'''
				This is a list of all top level config elements
			''')
		
		//------------------------------------------------------------------
		
		cls = pckg.getClass("ConfigElement")
		cls.setDocumentation(
			'''
				This is the super class of the top level config elements
				<ul>
					<li>{@link SubSystemConfig}</li>
					<li>{@link ActorClassConfig}</li>
					<li>{@link ActorInstanceConfig}</li>
					<li>{@link ProtocolClassConfig}</li>
				</ul>
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("SubSystemConfig")
		cls.setDocumentation(
			'''
				This class defines settings with a sub system scope.
			'''
		)
		
		cls.getReference("root").setDocumentation(
			'''
				This is the logical system that contains the {@link #org.eclipse.etrice.core.room.SubSystemRef sub system reference}.
			''')
			
		cls.getReference("subSystem").setDocumentation(
			'''
				This is the sub system reference.
			''')
		
		cls.getReference("dynConfig").setDocumentation(
			'''
				This is the dynamic configuration. It is available within the {@link #getSubSystem sub system}.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("DynamicConfig")
		cls.setDocumentation(
			'''
				The dynamic configuration provides a configuration at runtime.
				The source of the configuration is abstracted by an interface.
				<br>
				This feature is experimental and implemented for target language java only.
			'''
		)
		
		cls.getAttribute("filePath").setDocumentation(
			'''
				This is the file path of the configuration. In this case the source of the configuration is a simple file.
			'''
		)
		
		cls.getAttribute("userCode1").setDocumentation(
			'''
				Defines the import statement for the implemenation of the configuration source.
			''')
			
		cls.getAttribute("userCode2").setDocumentation(
			'''
				This is the constructor statement for the implemenation of the configuration source.
			'''
		)
		
		cls.getAttribute("polling").setDocumentation(
			'''
				Defines the time interval in milliseconds to query changes from the configuration source.
			'''
		)
		
		//------------------------------------------------------------------
		
		cls = pckg.getClass("ActorClassConfig")
		cls.setDocumentation(
			'''
				This class models a configuration for an {@link org.eclipse.etrice.core.room.ActorClass actor class}.
				The configuration defines the default values for all instances of the {@link #getActor actor}.
				The values are applied at generation time.
				The config sub elements are:
				<ul>
					<li>{@link AttrClassConfig attribute class config}</li>
				</ul>				
			''')
		
		cls.getReference("actor").setDocumentation(
			'''
				This is the actor class.
			''')
		
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of all attribute configurations.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("ProtocolClassConfig")
		cls.setDocumentation(
			'''
				This class models a configuration for an {@link org.eclipse.etrice.core.room.ProtocolClass protocol class}.
				The config sub elements are:
				<ul>
					<li>a {@link PortClassConfig port class config} for the regular port class</li>
					<li>a {@link PortClassConfig port class config} for the conjugate port class</li>
				</ul>
			''')
		
		cls.getReference("protocol").setDocumentation(
			'''
				This is the protocol class.
			''')
		
		cls.getReference("regular").setDocumentation(
			'''
				This is the configuration for the regular part of the protocol.
			''')
		
		cls.getReference("conjugated").setDocumentation(
			'''
				This is the configuration for the conjugated part of the protocol.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("PortClassConfig")
		cls.setDocumentation(
			'''
				This class models a configuration for an {@link org.eclipse.etrice.core.room.PortClass port class}.
				The configuration defines the default values for all instances of the port.
				The values are applied at generation time.
				The config sub elements are:
				<ul>
					<li>{@link AttrClassConfig attribute class config}</li>
				</ul>
			''')
		
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of all attribute configurations.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("ActorInstanceConfig")
		cls.setDocumentation(
			'''
				This class models a configuration for an {@link org.eclipse.etrice.core.room.ActorRef actor instance}.
				The configuration defines values for this actor instance and overrides the default values from the corresponding class config.
				The values are applied at generation time.
				The config sub elements are:
				<ul>
					<li>{@link AttrInstanceConfig attribute instance config}</li>
				</ul>				
			''')
		
		cls.getReference("root").setDocumentation(
			'''
				This is the logical system that contains the {@link #getSubSystem sub system}.
			''')
			
		cls.getReference("subSystem").setDocumentation(
			'''
				This is the sub system that contains the {@link #getRefPath actor instance}.
			''')
			
		cls.getReference("path").setDocumentation(
			'''
				This is the path of the actor instance relative to the {@link #getSubSystem sub system}.
			''')
		
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of all attribute configurations.
			''')
			
		cls.getReference("ports").setDocumentation(
			'''
				This is a list of all port configurations.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("PortInstanceConfig")
		cls.setDocumentation(
			'''
				This class models a configuration for an {@link org.eclipse.etrice.core.room.InterfaceItem interface item} (e.g. port instance).
				The configuration defines values for this interface item and overrides the default values from the corresponding class config.
				The values are applied at generation time.
				The config sub elements are:
				<ul>
					<li>{@link AttrInstanceConfig attribute instance config}</li>
				</ul>				
			''')
			
		cls.getReference("item").setDocumentation(
			'''
				This is the interface item.
			''')
			
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of all attribute configurations.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("AttrConfig")
		cls.setDocumentation(
			'''
				It is the super class of
				<ul>
					<li>{@link AttrClassConfig}</li>
					<li>{@link AttrInstanceConfig}</li>
				</ul>				
			''')
			
		cls.getReference("attribute").setDocumentation(
			'''
				This is the attribute.
			''')
			
		cls.getReference("value").setDocumentation(
			'''
				This is the value of {@link #getAttribute attribute}.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("AttrClassConfig")
		cls.setDocumentation(
			'''
				This class models a configuration for an {@link org.eclipse.etrice.core.room.Attribute attribute}.
				The configuration defines a default value for all instances of the attribute.
				The values are applied at generation time.
				<br>If the type of the given {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} is
				<ul>
					<li>primitive, then a {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} might exist and {@link #getAttributes attributes} is empty</li>
					<li>compound attribute (e.g. {@link org.eclipse.etrice.core.room.DataClass data class}), then {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} is null and configurations for children {@link #getAttributes attributes} might exist</li>
				</ul>				
			''')
			
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of attribute configurations of children attributes, in case the {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} is compound.
			''')
		
		cls.getReference("min").setDocumentation(
			'''
				This is the lower bound of {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} , in case the {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} has a numerical value.
			''')
		
		cls.getReference("max").setDocumentation(
			'''
				This is the upper bound of {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} , in case the {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} has a numerical value.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("AttrInstanceConfig")
		cls.setDocumentation(
			'''
				This class models a configuration for an {@link org.eclipse.etrice.core.room.Attribute attribute}.
				The configuration defines values for this attribute instance and overrides the default values from the corresponding class config.
				The values are applied at generation time.
				<br>If the type of the given {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} is
				<ul>
					<li>primitive, then a {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} might exist and {@link #getAttributes attributes} is empty</li>
					<li>compound attribute (e.g. {@link org.eclipse.etrice.core.room.DataClass data class}), then {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} is null and configurations for children {@link #getAttributes attributes} might exist</li>
				</ul>				
			''')
			
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of attribute configurations of children attributes, in case the {@link org.eclipse.etrice.core.config.AttrConfig#getAttribute attribute} is compound.
			''')
			
		cls.getAttribute("dynConfig").setDocumentation(
			'''
				If the dynamic configuration options is activated for this attribute, then the values are set at runtime by the means of the {@link DynamicConfig dynamic config}.
			''')
			
		cls.getAttribute("readOnly").setDocumentation(
			'''
				Controls the behavior of the dynamic configuration. If set to false, then {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} is updated (overwritten) if changes occur in the external configuration, 
				otherwise set to true, then changes in {@link org.eclipse.etrice.core.config.AttrConfig#getValue value} (that occur from within the system) are recorded to the external configuration.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("LiteralArray")
		cls.setDocumentation(
			'''
				Aggregates one or more {@link Literal literals}.		
			''')
			
		cls.getReference("literals").setDocumentation(
			'''
				This is a list of literals.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("Literal")
		cls.setDocumentation(
			'''
				It is the super class of
				<ul>
					<li>{@link BooleanLiteral}</li>
					<li>{@link NumberLiteral}</li>
					<li>{@link StringLiteral}</li>
				</ul>
				that represents a primitive value.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("RefPath")
		cls.setDocumentation(
			'''
				A path of strings that are interpreted as {@link org.eclipse.etrice.core.room.ActorRef}s starting at a {@link org.eclipse.etrice.core.room.SubSystemClass}.
			''')
		
		cls.getAttribute("refs").setDocumentation(
			'''
				This is a path in the instance tree where each segment corresponds to the name of the
				corresponding {@link ActorContainerRef}.
			''')
			
		//------------------------------------------------------------------
		
		cls = pckg.getClass("Import")
		cls.setDocumentation(
			'''
				The import declares an imported {@link org.eclipse.etrice.core.room.RoomModel room model} (given as a URI) and
				an optional imported namespace.
			''')
		
		cls.getAttribute("importedNamespace").setDocumentation(
			'''
				The imported name space has to be a dot separated qualified name followed by .*.
				Example: my.namespace.*
			''')
		
		cls.getAttribute("importURI").setDocumentation(
			'''
				The import URI can be a relative or absolute file system path.
				It may contain environment variables in ${} which will be expanded.
				<p>
				Examples:
				<ul>
				  <li>import model "AnotherModel.room"</li>
				  <li>import my.namespace.* from "AnotherModel.room"</li>
				  <li>import my.namespace.* from "../../AnotherProject/models/AnotherModel.room"</li>
				  <li>import my.namespace.* from "/${ROOM_MODELS}/SomeModel.room"</li>
				</ul>
				</p>
			''')
		
	}
	
}