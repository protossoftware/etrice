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

/**
 * This post processor adds documentation to the generated EMF model.
 * By intention no {@code null} checks are performed. This way developers
 * find easier if the referenced class, attribute or reference isn't found.
 */
class DocuPostprocessor {
		
	def process(GeneratedMetamodel metamodel) {
		val pckg = metamodel.EPackage
		
		//------------------------------------------------------------------
		var cls = pckg.getClass("RoomModel")
		cls.setDocumentation(
			'''
				The root object for the ROOM model. It gives access to {@link Import imports} and
				the {@link SubSystemClass sub system},
				{@link ActorClass actor}, {@link ProtocolClass protocol} and
				{@link DataClass data} classes defined.
			''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The model name is a dot separated fully qualified name and is
				used to provide a name space. The generators may use that also
				to place the generated code into separate directories.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		cls.getReference("imports").setDocumentation(
			'''
				This is a list of all imported models.
			''')
		
		cls.getReference("primitiveTypes").setDocumentation(
			'''
				This is a list of all primitive types defined by this model.
			''')
		
		cls.getReference("externalTypes").setDocumentation(
			'''
				This is a list of all external types defined by this model.
			''')
		
		cls.getReference("dataClasses").setDocumentation(
			'''
				This is a list of all data classes defined by this model.
			''')
		
		cls.getReference("protocolClasses").setDocumentation(
			'''
				This is a list of all protocol classes defined by this model.
			''')
		
		cls.getReference("actorClasses").setDocumentation(
			'''
				This is a list of all actor classes defined by this model.
			''')
		
		cls.getReference("subSystemClasses").setDocumentation(
			'''
				This is a list of all sub system classes defined by this model.
			''')
		
		cls.getReference("systems").setDocumentation(
			'''
				This is a list of all logical systems defined by this model.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RoomClass")
		cls.setDocumentation('''
			This class is the super class of all classes
			of the ROOM class model:
			<ul>
			  <li>{@link DataType}</li>
			  <li>{@link GeneralProtocolClass}</li>
			  <li>{@link StructureClass}</li>
			</ul>
		''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StructureClass")
		cls.setDocumentation('''
			This class is the super class of the structural classes
			<ul>
			  <li>{@link ActorContainerClass}</li>
			  <li>{@link LogicalSystem}</li>
			</ul>
		''')
		
		cls.getReference("annotations").setDocumentation(
			'''
				This is a list of structure class annotations.
			''')
		
		cls.getReference("bindings").setDocumentation(
			'''
				This is a list of structure class bindings.
			''')
		
		cls.getReference("connections").setDocumentation(
			'''
				This is a list of structure class connections.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ActorContainerClass")
		cls.setDocumentation('''
			This class is the super class of the structural classes
			<ul>
			  <li>{@link ActorClass}</li>
			  <li>{@link SubSystemClass}</li>
			</ul>
		''')
		
		cls.getReference("serviceProvisionPoints").setDocumentation(
			'''
				This is a list of all interface SPPs.
			''')
		
		cls.getReference("actorRefs").setDocumentation(
			'''
				This is a list of all actor refs.
			''')
		
		cls.getReference("userCode1").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		cls.getReference("userCode2").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		cls.getReference("userCode3").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("VarDecl")
		cls.setDocumentation('''
			A variable declaration consists of a name and a type.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the variable is referred to in the model.
			''')
		
		cls.getReference("refType").setDocumentation(
			'''
				This is the data type of the variable.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RefableType")
		cls.setDocumentation('''
			This is a type with an optional reference attribute.
			If 'ref' is {@code true} then by reference semantic is chosen.
		''')
		
		cls.getReference("type").setDocumentation(
			'''
				This is the data type.
			''')
		
		cls.getAttribute("ref").setDocumentation(
			'''
				If {@code true} then by reference semantics is chosen, by value semantics else.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("DataType")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link PrimitiveType}</li>
			  <li>{@link ComplexType}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ComplexType")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link DataClass}</li>
			  <li>{@link ExternalType}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("PrimitiveType")
		cls.setDocumentation('''
			A primitive type describes a type like int, char, float
			and can represent the type with a certain precision
			in the target language
		''')
		
		cls.getAttribute("type").setDocumentation(
			'''
				This is one of the basic variable types.
			''')
		
		cls.getAttribute("targetName").setDocumentation(
			'''
				This is the type name in the target language.
			''')
		
		cls.getAttribute("castName").setDocumentation(
			'''
				This (optional) name is used for casts to this type.
			''')
		
		cls.getAttribute("defaultValueLiteral").setDocumentation(
			'''
				This is an optional default value literal.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ExternalType")
		cls.setDocumentation('''
			An external type is not defined in the ROOM model
			but only referenced. It can not be instantiated.
		''')
		
		cls.getAttribute("targetName").setDocumentation(
			'''
				This is the type name in the target language.
			''')
		
		cls.getAttribute("defaultValueLiteral").setDocumentation(
			'''
				This is an optional default value literal.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("DataClass")
		cls.setDocumentation('''
			Together with {@link ProtocolClass} and {@link ActorClass} one of
			the main class types of the ROOM language.
			
			<p>
			In ROOM this is the equivalent to a class in Java or C++.
			A data class can be derived from a base class (single
			inheritance), has {@link Attribute}s and {@link Operation}s.
			</p>
			
			<p>
			Additionally it can be annotated with generator specific
			meaning and user ocde can be added in several places
			(again generator specific).
			</p>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the data class by which it is referred to in the model.
			''')
		
		cls.getReference("base").setDocumentation(
			'''
				The base class from which all attributes and operations are inherited.
			''')
		
		cls.getReference("attributes").setDocumentation(
			'''
				Attributes are the data members of the data class.
			''')
		
		cls.getReference("operations").setDocumentation(
			'''
				Operations are the methods of the data class.
			''')
		
		cls.getReference("annotations").setDocumentation(
			'''
				This is a list of data class annotations.
			''')
		
		cls.getReference("userCode1").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		cls.getReference("userCode2").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		cls.getReference("userCode3").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Attribute")
		cls.setDocumentation('''
			An attribute is a named member of a
			<ul>
			  <li>{@link DataClass}</li>
			  <li>{@link ActorClass}</li>
			  <li>{@link PortClass}</li>
			</ul>
			<p>
			It can be of scalar or array type and is of a {@link RefableType}.
			It is possible to assign a default value literal.
			</p>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the attribute by which it is referred to in the model.
			''')
		
		cls.getAttribute("size").setDocumentation(
			'''
				The default is scalar ({@code size=1}), values {@code >1} indicate an array.
			''')
			
		cls.getReference("type").setDocumentation(
			'''
				This is the attribute's type.
			''')
		
		cls.getAttribute("defaultValueLiteral").setDocumentation(
			'''
				This is an optional default value literal.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Operation")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link StandardOperation}</li>
			  <li>{@link PortOperation}</li>
			</ul>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the operation by which it is referred to in the model.
			''')
		
		cls.getReference("arguments").setDocumentation(
			'''
				This is a list of arguments for the operation.
			''')
		
		cls.getReference("returnType").setDocumentation(
			'''
				This is an optional return type of the operation.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		cls.getReference("detailCode").setDocumentation(
			'''
				This is the operation body written in code generator target language.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StandardOperation")
		cls.setDocumentation('''
			The standard form of an operation as used by
			{@link ActorClass} and {@link DataClass}.
			<p>
			If the name coincides with it's containing classes name
			then it is a constructor (with void return type).
			If the name additionally is preceded by a tilde ~ then it
			is a destructor.
			</p>
			<p>
			The operation has a list of {@link VarDecl} arguments, an
			optional return {@link RefableType} and a body (specified
			as {@link DetailCode}).
			</p>
		''')
		
		cls.getAttribute("destructor").setDocumentation(
			'''
				If this flag is {@code true} <em>and</em> the name conincides with the class name
				it is treated as a destructor.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("PortOperation")
		cls.setDocumentation('''
			The port operation is very similar to the {@link StandardOperation}
			and is used in the {@link PortClass}. It is not possible to
			define constructor or destructor.
			<p>
			Optionally a {@link Message} can be specified which is sent
			when the method is invoked. For this reason these operations
			are also shown in the 'messages' dialog of the behavior editor.
			</p>
		''')
		
		cls.getReference("sendsMsg").setDocumentation(
			'''
				This optional reference to a message means that the operation sends a message.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("GeneralProtocolClass")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link ProtocolClass}</li>
			  <li>{@link CompoundProtocolClass}</li>
			</ul>
		''')
		
		cls.getReference("annotations").setDocumentation(
			'''
				This is a list of protocol class annotations.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ProtocolClass")
		cls.setDocumentation('''
			Together with {@link ActorClass} and {@link DataClass} one of
			the main class types of the ROOM language.
			<p>
			A protocol class specifies a directed {@link Port} interface
			by two sets of {@link Message}s: incoming and outgoing.
			</p>
			<p>
			A protocol class can derive from a base class (single inheritance).
			In this case it must only extend <em>one</em> of the message sets:
			incoming <em>or</em> outgoing.
			</p>
			<p>
			Optionally {@link PortClass}es may be defined for regular and
			conjugate {@link Port}s. These classes can be used to add specific
			behavior e.g. by adding message handlers. This kind of felxibility
			can be used in particular for the efficient implementation of
			services (SAPs and SPPs).
			</p>
			<p>
			Last not least a so called 'legal execution tree' can be specified
			using {@link ProtocolSemantics}.
			</p>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				The name of the protocol class by which it is referred to in the model.
			''')
		
		cls.getReference("base").setDocumentation(
			'''
				The base class from which all messages are inherited.
				The port classes and the semantics are not inherited.
			''')
		
		cls.getAttribute("commType").setDocumentation(
			'''
				This is the communication type of the protocol.
			''')
		
		cls.getReference("userCode1").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		cls.getReference("userCode2").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		cls.getReference("userCode3").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		cls.getReference("incomingMessages").setDocumentation(
			'''
				This is the set of incoming messages of this protocol.
			''')
		
		cls.getReference("outgoingMessages").setDocumentation(
			'''
				This is the set of outgoing messages of this protocol.
			''')
		
		cls.getReference("regular").setDocumentation(
			'''
				This is the optional regular port class specification.
			''')
		
		cls.getReference("conjugated").setDocumentation(
			'''
				This is the optional conjugate port class specification.
			''')
		
		cls.getReference("semantics").setDocumentation(
			'''
				This is the optional semantics specification for this protocol.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("CompoundProtocolClass")
		cls.setDocumentation('''
			This special protocol class is used to bundle several protocols
			in relay ports. This can be useful to avoid parallel chains
			of {@link Binding}s traversing the structural hierarchy.
			<p>
			The compound protocol class consists of several {@link SubProtocol}s.
			</p>
		''')
		
		cls.getReference("subProtocols").setDocumentation(
			'''
				This is a list of sub protocols.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SubProtocol")
		cls.setDocumentation('''
			The sub protocol is part of the {@link CompoundProtocolClass} and defines
			kind of a named channel for messages. The sub protocols are used to associate an
			end port with a particular channel.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the sub protocols or channels are distinguished.
			''')
		
		cls.getReference("protocol").setDocumentation(
			'''
				This is the protocol of this channel.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Message")
		cls.setDocumentation('''
			A message in ROOM is part of a {@link ProtocolClass}. Messages are exchanged via {@link Port}s.
			For event driven protocols the message is an object that is deliverd using a message
			service of the runtime. For data driven systems only messages holding data are valid. In this
			case the conjugate port is the one holding (and writing) the data and the regular port is
			reading the data.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the message is referred to in the model.
			''')
		
		cls.getAttribute("priv").setDocumentation(
			'''
				If this flag is {@code true} then the message is treated as private for this protocol
				and can only be sent by a PortClass.
			''')
		
		cls.getReference("data").setDocumentation(
			'''
				This is a reference to optional message data.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("PortClass")
		cls.setDocumentation('''
			A port class can be specified to customize the behavior of a {@link ProtocolClass}.
			There can be one for regular ports and another one for conjugate ports independently.
			
			<p>
			Port classes can be used to define attributes and operations and message handlers
			(or interceptors).
			</p>
		''')
		
		cls.getReference("operations").setDocumentation(
			'''
				This is a list of operations of this nested class.
			''')
		
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of attributes of this nested class.
			''')
		
		cls.getReference("userCode").setDocumentation(
			'''
				The user code is treated in a generator dependent way.
			''')
		
		cls.getReference("msgHandlers").setDocumentation(
			'''
				This is a list of message handlers.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("MessageHandler")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link InMessageHandler}</li>
			  <li>{@link OutMessageHandler}</li>
			</ul>
		''')
		
		cls.getReference("msg").setDocumentation(
			'''
				This is the message that is handled.
			''')
		
		cls.getReference("detailCode").setDocumentation(
			'''
				This is the handler code written in code generator target language.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("InMessageHandler")
		cls.setDocumentation('''
			Is a handler (or interceptor) for incoming messages. In the generated code the
			message is available. It is derived from {@link MsgHandler}.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("OutMessageHandler")
		cls.setDocumentation('''
			Is a handler (or interceptor) for outgoing messages. In the generated code the
			message is available. It is derived from {@link MsgHandler}.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ProtocolSemantics")
		cls.setDocumentation('''
			An optional semantics specification as part of a {@link ProtocolClass}.
			The semantic is defined as a <em>legal execution tree</em>.
			This tree is composed of incoming and outgoing messages and each path through
			this tree is a valid sequence of messages exchanged through a port instance.
			
			<p>
			The semantics are composed using {@link SemanticsRule]s.
			</p>
		''')
		
		cls.getReference("rules").setDocumentation(
			'''
				This is a list of semantic rules.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SemanticsRule")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link InSemanticsRule}</li>
			  <li>{@link OutSemanticsRule}</li>
			</ul>
		''')
		
		cls.getReference("msg").setDocumentation(
			'''
				The message to which this rule applies.
			''')
		
		cls.getReference("followUps").setDocumentation(
			'''
				The possible follow up rules.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("InSemanticsRule")
		cls.setDocumentation('''
			A {@link SemanticsRule} for incoming messages.
			The rule points to an incoming messages and allows follow-up rules.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("OutSemanticsRule")
		cls.setDocumentation('''
			A {@link SemanticsRule} for outgoing messages.
			The rule points to an outgoing messages and allows follow-up rules.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ActorClass")
		cls.setDocumentation('''
			Together with {@link ProtocolClass} and {@link DataClass} one of
			the main class types of the ROOM language.
			
			<p>
			The actor class in ROOM has three compartments which aren't represented as separate model objects.
			To understand to which compartment an attribute or reference belongs to here is a list
			<ul>
			  <li>Interface: everything which is visible from the outside from a model point of view
			  <ul>
			    <li>{@link #getIfPorts}: a list of all interface {@link Port}s</li>
			    <li>{@link ActorContainerClass#getIfSPPs}: a list of all interface {@link SPPRef}s</li>
			  </ul>
			  <li>Structure: all internal structural aspects of an actor class</li>
			  <ul>
			    <li>{@link #getUsercode1}-3: user defined code with generator dependent meaning</li>
			    <li>{@link #getInternalPorts}: a list of all internal end {@link Port}s</li>
			    <li>{@link #getExternalPorts}: a list of all {@link ExternalPort}s (the interface ports that
			       are end ports, not relay ports</li>
			    <li>{@link #getServiceImplementations}: a list of all {@link ServiceImplementation}s</li>
			    <li>{@link #getStrSAPs}: a list of all {@link SAPRef}s used by this actor class</li>
			    <li>{@link #getAttributes}: a list of all actor class {@link Attribute}s</li>
			    <li>{@link #getActorRefs}: a list of all referenced actor classes (an {@link ActorRef}
			       has the meaning of a composition)</li>
			    <li>{@link #getBindings}: a list of all port {@link Binding}s of this actor class</li>
			    <li>{@link #getConnections}: a list of all {@link LayerConnections}</li>
			  </ul>
			  <li>Behavior: the behavioral aspects of an actor class</li>
			  <ul>
			    <li>{@link #getOperations}: a list of {@link Operation}s</li>
			    <li>{@link #getStateMachine}: the {@link StateMachine} definition</li>
			  </ul>
			</ul>
			</p>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the actor class is referred to in the model.
			''')
		
		cls.getAttribute("abstract").setDocumentation(
			'''
				If {@code true} this actor class can not be instantiated and can only be base class
				for other actor classes.
			''')
		
		cls.getAttribute("commType").setDocumentation(
			'''
				The communication type of this actor class.
			''')
		
		cls.getReference("base").setDocumentation(
			'''
				The base class from which all attributes, operations, ports, SAPs
				and state machine are inherited.
			''')
		
		cls.getReference("interfacePorts").setDocumentation(
			'''
				This is a list containing all ports of the actor interface.
			''')
		
		cls.getReference("internalPorts").setDocumentation(
			'''
				This is a list containing all ports of the actor structure (internal end ports).
			''')
		
		cls.getReference("externalPorts").setDocumentation(
			'''
				This is a list containing all ports of the actor interface that are end ports.
			''')
		
		cls.getReference("structureDocu").setDocumentation(
			'''
				This is an optional documentation of the actor structure.
			''')
		
		cls.getReference("serviceImplementations").setDocumentation(
			'''
				This is a list of all service implementations.
			''')
		
		cls.getReference("serviceAccessPoints").setDocumentation(
			'''
				This is a list of all SAPs.
			''')
		
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of all actor class private attributes.
			''')
		
		cls.getReference("behaviorDocu").setDocumentation(
			'''
				This is an optional documentation of the actor behavior.
			''')
		
		cls.getReference("behaviorAnnotations").setDocumentation(
			'''
				This is a list of annotations to the actor behavior.
			''')
		
		cls.getReference("operations").setDocumentation(
			'''
				This is a list of all private operations of this actor class.
			''')
		
		cls.getReference("stateMachine").setDocumentation(
			'''
				This is the actor's optional state machine.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("InterfaceItem")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link Port}</li>
			  <li>{@link SAPRef}</li>
			  <li>{@link SPPRef}</li>
			</ul>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the interface item is referred to in the model.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Port")
		cls.setDocumentation('''
			A port defines a part of the interface of an {@link ActorClass} in a specific role.
			The port is associated with a {@link ProtocolClass}. If it is conjugated then the
			roles of incoming and outgoing messages of the protocol are inverted.
			
			<p>
			Ports can have a multiplicity. If it is greater one the port is called replicated.
			</p>
			
			<p>
			Whether a port is a relay port or not is a property that is derived from how it is
			referenced by its {@link ActorClass}:
			<ul>
			  <li>ports contained in the actor structure are called <em>internal end ports</em></li>
			  <li>ports contained in the actor interface and are also referenced by an {@link ExternalPort}
			     are called <em>external end ports</em></li>
			  <li>ports contained in the actor interface only are called <em>relay ports</em></li>
			</ul>
			Relay ports delegate to sub actors and end ports are connected to the actor's state machine.
			</p>
			
			@see {@link org.eclipse.etrice.core.room.util.RoomHelpers#isRelay(Port) RoomHelpers.isRelay(Port)}
			@see {@link org.eclipse.etrice.core.room.util.RoomHelpers#isInternal(Port) RoomHelpers.isInternal(Port)}
			@see {@link org.eclipse.etrice.core.room.util.RoomHelpers#isExternal(Port) RoomHelpers.isExternal(Port)}
		''')
		
		cls.getAttribute("conjugated").setDocumentation(
			'''
				If a port is conjugated then the roles of outgoing and incoming messages are interchanged.
			''')
		
		cls.getAttribute("multiplicity").setDocumentation(
			'''
				Ports with multiplicity >1 are called relay ports. A multiplicity of {@code -1} means replicated
				port with arbitrary multiplicity.
			''')
		
		cls.getReference("protocol").setDocumentation(
			'''
				This is the port's protocol class.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ExternalPort")
		cls.setDocumentation('''
			An external port is part of the actor structure and references an interface port.
			An interface port which is referenced by an external port is an external end port.
			If it is not referenced it is a relay port.
			
			@see {@link Port}
		''')
		
		cls.getReference("interfacePort").setDocumentation(
			'''
				This is the referenced interface port of the actor class which is now an external end port.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SAP")
		cls.setDocumentation('''
			A service access point is similar to a {@link Port} but is not explicitly bound to a peer.
			Rather, it is bound to a {@link ServiceImplementation} which is connected to one of the
			containing actors.
			
			<p>
			An SAP is associated with a {@link ProtocolClass} and is conjugate to this protocol.
			</p>
		''')
		
		cls.getReference("protocol").setDocumentation(
			'''
				This is the SAPRef's protocol class.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SPP")
		cls.setDocumentation('''
			A service provision point is used to connect an actor class with a {@link ServiceImplementation}.
			It can (similar to relay ports) delegate to another actor class (using a {@link LayerConnection})
			or connect to a {@link ServiceImplementation} of its actor class.
			
			<p>
			An SPP is associated with a {@link ProtocolClass} and is regular to this protocol.
			</p>
		''')
		
		cls.getReference("protocol").setDocumentation(
			'''
				This is the SAPRef's protocol class.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ServiceImplementation")
		cls.setDocumentation('''
			A service implementation can be reagrded as the replicated peer port of all {@link SAPRef}s
			that are bound to it following the service resolution logic.
		''')
		
		cls.getReference("spp").setDocumentation(
			'''
				This is the SPP connected to the service.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("LogicalSystem")
		cls.setDocumentation('''
			The top level structural class. It can only contain sub systems using {@link SubSystemRef}s.
			This way the logical system is composed of sub system instances. It also defines
			{@link Binding}s and {@link LayerConnection}s between those sub systems.
			
			<p>
			The logical system is the root of the instance tree of the generator model.
			Each {@link SubSystemRef} is turned into a {@link SubSystemInstance} and each
			{@link ActorRef} is turned into an {@link ActorInstance}.
			</p>
		''')
		
		cls.getReference("subSystems").setDocumentation(
			'''
				The list of all sub systems contained in the logical system.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ActorContainerRef")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link SubSystemRef}</li>
			  <li>{@link ActorRef}</li>
			</ul>
			The reference designates a specific role of the referenced structure class.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the actor container reference is referred to in the model.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SubSystemRef")
		cls.setDocumentation('''
			A means to compose {@link LogicalSystem}s of {@link SubSystemClass}es. Each ref will
			be turned into a sub system instance of the referenced type.
		''')
		
		cls.getReference("type").setDocumentation(
			'''
				The type of the reference.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SubSystemClass")
		cls.setDocumentation('''
			A sub system class corresponds to a process with a separate address space.
			It has no behavior of its own and is composed of {@link ActorClass}es.
			
			<p>
			Sub systems can be connected using {@link Port}s and {@link Binding}s.
			All ports of a sub system are relay ports.
			</p>
			
			<p>
			Sub systems can define an arbitrary number of logical threads onto which their actor
			instances are mapped.
			</p>
		''')
		
		cls.getReference("relayPorts").setDocumentation(
			'''
				This is a list of all relay ports of the sub system.
			''')
		
		cls.getReference("threads").setDocumentation(
			'''
				This is a list of all threads of the sub system.
			''')
		
		cls.getReference("threads").setDocumentation(
			'''
				This is a list of all actor instance mappings of the sub system.
			''')
		
		cls.getReference("actorInstanceMappings").setDocumentation(
			'''
				This is a list of actor instance mappings.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("LogicalThread")
		cls.setDocumentation('''
			A logical thread is addressed by the {@link ActorInstanceMapping}s of a {@link SubSystemClass}.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the thread is referred to in the model.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ActorInstanceMapping")
		cls.setDocumentation('''
			An actor instance mapping maps an actor instances (described as a path of actor references)
			to a {@link LogicalThread}
		''')
		
		cls.getReference("path").setDocumentation(
			'''
				This is the path of references starting at this sub system that uniquely references an actor instance.
			''')
		
		cls.getReference("thread").setDocumentation(
			'''
				This is the logical thread to which the referenced actor instance and all of its contained instances
				are mapped.
			''')
		
		cls.getReference("actorInstanceMappings").setDocumentation(
			'''
				This is a list of nested mappings which override parent mappings.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RefPath")
		cls.setDocumentation('''
			A path of strings that are interpreted as {@link ActorRef}s starting at a {@link SubSystemClass}.
		''')
		
		cls.getAttribute("refs").setDocumentation(
			'''
				This is a path in the instance tree where each segment corresponds to the name of the
				corresponding {@link ActorContainerRef}.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Binding")
		cls.setDocumentation('''
			A binding connects two {@link Port}s.
			To be able to distinguish the ports of two {@link ActorContainerRef}s of the same type
			a {@link BindingEndPoint} is needed for disambiguation.
		''')
		
		cls.getReference("endpoint1").setDocumentation(
			'''
				The first end point of a binding.
			''')
		
		cls.getReference("endpoint2").setDocumentation(
			'''
				The second end point of a binding.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("BindingEndPoint")
		cls.setDocumentation('''
			A binding end point is a pair of an {@link ActorContainerRef} and a {@link Port} and is used
			to uniquely describe a port of a sub actor. If the actor container ref is {@code null} then
			a port of the actor class itself is addressed.
		''')
		
		cls.getReference("actorRef").setDocumentation(
			'''
				The actor reference holding the bound port or {@code null} in case of a local port.
			''')
		
		cls.getReference("port").setDocumentation(
			'''
				This is the bound port.
			''')
		
		cls.getReference("sub").setDocumentation(
			'''
				This is the bound sub protocol or {@code null} if not applicable.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("LayerConnection")
		cls.setDocumentation('''
			Layer connections are used to connect {@link SAPRef}s and {@link ServiceImplementation}s.
			The source is described by a {@link SAPoint} and the target by a {@link SPPoint}.
		''')
		
		cls.getReference("from").setDocumentation(
			'''
				This is source point of the layer connection.
			''')
		
		cls.getReference("to").setDocumentation(
			'''
				This is target point of the layer connection.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SAPoint")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link RefSAPoint}</li>
			  <li>{@link RelaySAPoint}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RefSAPoint")
		cls.setDocumentation('''
			Links from a {@link ActorContainerRef}, i.e. from a sub actor.
		''')
		
		cls.getReference("ref").setDocumentation(
			'''
				This is the referenced actor container ref.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RelaySAPoint")
		cls.setDocumentation('''
			Links from a relay {@link SPPRef} of the actor class.
		''')
		
		cls.getReference("relay").setDocumentation(
			'''
				This is the referenced SPPRef.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SPPoint")
		cls.setDocumentation('''
			Links to a {@link SPPRef} of an {@link ActorContainerRef}, i.e. an SPPRef of a sub actor
		''')
		
		cls.getReference("ref").setDocumentation(
			'''
				This is the referenced actor container ref.
			''')
		
		cls.getReference("service").setDocumentation(
			'''
				This is the referenced service.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ActorRef")
		cls.setDocumentation('''
			A means to compose {@link SubSystemClass}es of {@link ActorClass}es. Each ref will
			be turned into an actor instance of the referenced type.
		''')
		
		cls.getReference("type").setDocumentation(
			'''
				This is the type (i.e. actor class) of the actor ref.
			''')
		
		cls.getAttribute("multiplicity").setDocumentation(
			'''
				If the size is >1 then this is a replicated actor.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StateGraphNode")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link State}</li>
			  <li>{@link ChoicePoint}</li>
			  <li>{@link TrPoint}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StateGraphItem")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link StateStateGraphNode}</li>
			  <li>{@link Transition}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("State")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link SimpleState}</li>
			  <li>{@link RefinedState}</li>
			</ul>
		''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		cls.getReference("entryCode").setDocumentation(
			'''
				This is an optional entry code written in the code generator's target language.
				It is executed when the state is entered.
			''')
		
		cls.getReference("exitCode").setDocumentation(
			'''
				This is an optional entry code written in the code generator's target language.
				It is executed when the state is left.
			''')
		
		cls.getReference("doCode").setDocumentation(
			'''
				This is an optional do code written in the code generator's target language.
				It is executed whenever the actor instance is polled (applies only to
				data driven and sync actor classes).
			''')
			
		cls.getReference("subgraph").setDocumentation(
			'''
				This is an optional sub state graph of this state.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StateGraph")
		cls.setDocumentation('''
			A state graph is a directed graph composed of
			{@link StateGraphNode}s as nodes and {@link Transitions} as edges.
		''')
			
		cls.getReference("states").setDocumentation(
			'''
				This is a list of all states of this state graph.
			''')
			
		cls.getReference("trPoints").setDocumentation(
			'''
				This is a list of all transition, entry and exit points of this state graph.
			''')
			
		cls.getReference("chPoints").setDocumentation(
			'''
				This is a list of all choice points of this state graph.
			''')
			
		cls.getReference("transitions").setDocumentation(
			'''
				This is a list of all transitions of this state graph.
			''')
			
		cls.getReference("refinedTransitions").setDocumentation(
			'''
				This is a list of all refined transitions of this state graph.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SimpleState")
		cls.setDocumentation('''
			A simple state is the standard case of a @link State}.
			It comprises and <em>entry</em>, <em>exit</em> and <em>do</em> code
			and it can contain another {@link StateGRaph} as sub state
			graph.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the state is referred to in the model.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RefinedState")
		cls.setDocumentation('''
			A refined state can be used only in a derived {@link ActorClass}.
			It refers to a {@link State} in the inherited state machine
			which is refined by adding detail code and/or
			{@link StateGRaphItem}s in the sub state graph.
		''')
			
		cls.getReference("target").setDocumentation(
			'''
				This is the referenced state in the base class state machine.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("DetailCode")
		cls.setDocumentation('''
			The detail code contains a list of strings which
			are considered verbatim code of the code generator
			target language.
			
			<p>
			The detail code is parsed by the {@link DetailCodeTranslator}
			which replaces certain frequent constructs like access of members
			and sending a message via a port by target language specific code.
			</p>
		''')
			
		cls.getAttribute("lines").setDocumentation(
			'''
				This is a list of commands in the code generator's target language.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TrPoint")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link TransitionPoint}</li>
			  <li>{@link EntryPoint}</li>
			  <li>{@link ExitPoint}</li>
			</ul>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the transition, entry or exit point is referred to in the model.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TransitionPoint")
		cls.setDocumentation('''
			A transition point is located at the border of a {@link State}
			and is not visible or accessible outside. It is used
			to globally handle messages. If a {@link Transition} starting
			at a transition point triggers then exit and entry codes
			are executed as usual as long as the handler flag of the
			transition point isn't set.
		''')
		
		cls.getAttribute("handler").setDocumentation(
			'''
				If this flag is {@code true} then for a transition triggerd from this point
				no exit and entry codes of the states left and entered are executed.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("EntryPoint")
		cls.setDocumentation('''
			An entry point is located at the border of a {@link State}
			and is visible and accessible outside. Outside
			it can be the target of a {@link Transition} and inside the source.
			If it is not connected in the interior then it is a
			<em>transition to history</em>.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ExitPoint")
		cls.setDocumentation('''
			An exit point is located at the border of a {@link State}
			and is visible and accessible outside. Outside
			it can be the source of a {@link Transition} and inside the target.
			If it is not connected in the interior then it is a
			<em>group transition</em>.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ChoicePoint")
		cls.setDocumentation('''
			A choice point corresponds to an {@code if else} construct.
			It is the target of one or more {@link Transition}s and the
			source of several {@link Transition}s.
			One outgoing transitions must be a {@link ContinuationTransition}
			and corresponds to the final else. It is called the
			<em>default branch</em> of the choice point.
			All other outgoing transitions have to be {@link CPBranchTransition}s.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				By this name the choice point is referred to in the model.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Transition")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link InitialTransition}</li>
			  <li>{@link NonInitialTransition}</li>
			</ul>
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				This is an optional name of the transition.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		cls.getReference("to").setDocumentation(
			'''
				This is the target node of the transition.
			''')
		
		cls.getReference("action").setDocumentation(
			'''
				This is an optional code in the code generator's target language.
				It is execute when the transition fires.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("NonInitialTransition")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link TransitionChainStartTransition}</li>
			  <li>{@link ContinuationTransition}</li>
			  <li>{@link CPBranchTransition}</li>
			</ul>
		''')
		
		cls.getReference("from").setDocumentation(
			'''
				This is the source node of the transition.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TransitionChainStartTransition")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link TriggeredTransition}</li>
			  <li>{@link GuardedTransition}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("InitialTransition")
		cls.setDocumentation('''
			There can be at most one initial transition in a {@link StateGraph}.
			It defines the starting point of the state graph and is traversed
			exactly once when the state graph is accessed for the first time.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ContinuationTransition")
		cls.setDocumentation('''
			Continuation transitions start at entry or exit points
			({@link EntryPoint}s or {@link ExitPoint}s) or form
			the default branch of a {@link ChoicePoint}.
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TriggeredTransition")
		cls.setDocumentation('''
			Triggered transitions start at a {@link State} or a {@link TransitionPoint}.
			It defines a list of {@link Trigger}s that specify the conditions
			when the transition fires and is traversed. This kind of
			transition is only allowed in event driven and mixed (async) state
			machines.
		''')
		
		cls.getReference("triggers").setDocumentation(
			'''
				This is a list of all triggers of the transition.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("GuardedTransition")
		cls.setDocumentation('''
			A guarded transition is very similar to a {@link CPBranchTransition}.
			It defines a guard condition which lets the transition fire if
			evaluated to {@code true}. This kind of transition is only
			allowed in data driven or moixed (async) state machines.
		''')
		
		cls.getReference("guard").setDocumentation(
			'''
				This is the guard condition of the transition specified in the code generator's target language.
				It has to evaluate to a boolean value.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("CPBranchTransition")
		cls.setDocumentation('''
			The choice point branch transitions is allowed only as outgoing
			transition of {@link ChoicePoint}s.
		''')
		
		cls.getReference("condition").setDocumentation(
			'''
				This is the condition of the choice point branch specified in the code generator's target language.
				It has to evaluate to a boolean value.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("RefinedTransition")
		cls.setDocumentation('''
			The refined transition is only allowed in {@link StateGraph}s
			of derived {@link ActorClass}es. It targets a {@link Transition}
			of the base class state machine.
		''')
		
		cls.getReference("action").setDocumentation(
			'''
				This is an optional code in the code generator's target language.
				It is execute when the transition fires.
			''')
			
		cls.getReference("target").setDocumentation(
			'''
				This is the referenced transition in the base class state machine.
			''')
		
		cls.getReference("docu").setDocumentation(
			'''
				This is an optional documentation.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TransitionTerminal")
		cls.setDocumentation('''
			The super class of
			<ul>
			  <li>{@link StateTerminal}</li>
			  <li>{@link TrPointTerminal}</li>
			  <li>{@link SubStateTrPointTerminal}</li>
			  <li>{@link ChoicepointTerminal}</li>
			</ul>
		''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("StateTerminal")
		cls.setDocumentation('''
			The terminal point (source or target) of a transition ending
			at a {@link State}.
		''')
			
		cls.getReference("state").setDocumentation(
			'''
				This is the target state.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("TrPointTerminal")
		cls.setDocumentation('''
			The terminal point (source or target) of a transition ending
			at a local {@link TrPoint}.
		''')
			
		cls.getReference("trPoint").setDocumentation(
			'''
				This is the target transition, entry or exit point.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("SubStateTrPointTerminal")
		cls.setDocumentation('''
			The terminal point (source or target) of a transition ending
			at a {@link TrPoint} of a sub {@link State}.
		''')
			
		cls.getReference("state").setDocumentation(
			'''
				This is the target state.
			''')
			
		cls.getReference("trPoint").setDocumentation(
			'''
				This is the target entry or exit point contained in the target state.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("ChoicepointTerminal")
		cls.setDocumentation('''
			The terminal point (source or target) of a transition ending
			at a {@link ChoicepointTerminal}.
		''')
			
		cls.getReference("cp").setDocumentation(
			'''
				This is the target choice point.
			''')
		
		//------------------------------------------------------------------
		cls = pckg.getClass("Trigger")
		cls.setDocumentation('''
			A transition trigger is a list of {@link MessageFromIf} pairs
			and an optional {@link Guard}.
		''')
			
		cls.getReference("msgFromIfPairs").setDocumentation(
			'''
				This is a list of message/interface item pairs.
			''')
		
		cls.getReference("guard").setDocumentation(
			'''
				This is an optional guard condition of the trigger specified in the code generator's target language.
				It has to evaluate to a boolean value.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("MessageFromIf")
		cls.setDocumentation('''
			A pair consisting of a {@link Message} arising from an
			{@link InterfaceItem}.
		''')
		
		cls.getReference("message").setDocumentation(
			'''
				This is the triggerering message (or event).
			''')
		
		cls.getReference("from").setDocumentation(
			'''
				This is the interface item where the message occurred.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("Guard")
		cls.setDocumentation('''
			A detail code that evaluates to a boolean in the target
			language.
		''')
		
		cls.getReference("guard").setDocumentation(
			'''
				This is a guard condition specified in the code generator's target language.
				It has to evaluate to a boolean value.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("Documentation")
		cls.setDocumentation('''
			A piece of documentation that can be optionally attached at
			certain places in the model.
		''')
		
		cls.getAttribute("lines").setDocumentation(
			'''
				This is the documentation's contents.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("Annotation")
		cls.setDocumentation('''
			An annotation similar to Java annotations that can be used
			to add {@link KeyValue} pairs to certain model items.
		''')
		
		cls.getAttribute("name").setDocumentation(
			'''
				This is the name of the annotation.
			''')
		
		cls.getReference("attributes").setDocumentation(
			'''
				This is a list of key/value pairs.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("KeyValue")
		cls.setDocumentation('''
			A key/value pair.
		''')
		
		cls.getAttribute("key").setDocumentation(
			'''
				This is the key of the pair.
			''')
		
		cls.getAttribute("value").setDocumentation(
			'''
				This is the value of the pair.
			''')

		//------------------------------------------------------------------
		cls = pckg.getClass("Import")
		cls.setDocumentation('''
			The import declares an imported model (given as a URI) and
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