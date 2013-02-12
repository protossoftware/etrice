/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.DataClass

import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.Root

import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator


@Singleton
class ProtocolClassGen extends GenericProtocolClassGenerator {

	@Inject JavaIoFileSystemAccess fileAccess
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject extension ProcedureHelpers
	@Inject extension Initialization
	@Inject extension TypeHelpers
	@Inject extension DataClassGen
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (pc: root.usedProtocolClasses) {
			var path = pc.generationTargetPath+pc.getPath
			var file = pc.getJavaFileName
			logger.logInfo("generating ProtocolClass implementation '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generate(pc))
		}
	}
	
	def generate(Root root, ProtocolClass pc) {'''
		package «pc.getPackage()»;
		
		import java.util.ArrayList;
		
		import org.eclipse.etrice.runtime.java.messaging.Address;
		import org.eclipse.etrice.runtime.java.messaging.Message;
		import org.eclipse.etrice.runtime.java.modelbase.*;
		«IF GlobalSettings::generateMSCInstrumentation»
			import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
		«ENDIF»
		import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
		
		«pc.userCode(1)»
		
		«var models = root.getReferencedModels(pc)»
		«FOR model : models»import «model.name».*;
		«ENDFOR»
		
		public class «pc.name» {
			// message IDs
			«genMessageIDs(pc)»
		
			«pc.userCode(2)»
		
			private static String messageStrings[] = {"MIN", «FOR m : pc.getAllOutgoingMessages()»"«m.name»",«ENDFOR» «FOR m : pc.getAllIncomingMessages()»"«m.name»",«ENDFOR»"MAX"};
		
			public String getMessageString(int msg_id) {
				if (msg_id<MSG_MIN || msg_id>MSG_MAX+1){
					// id out of range
					return "Message ID out of range";
				}
				else{
					return messageStrings[msg_id];
				}
			}
		
			«portClass(pc, false)»
			«portClass(pc, true)»
		}
	'''
	}
	
	def portClass(ProtocolClass pc, Boolean conj) {
		var pclass = pc.getPortClass(conj)
		var portClassName = pc.getPortClassName(conj)
		var replPortClassName = pc.getPortClassName(conj, true)
	'''
		
		// port class
		static public class «portClassName» extends PortBase {
			«IF pclass!=null»
				«pclass.userCode.userCode»
			«ENDIF»
			// constructors
			public «portClassName»(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
				this(actor, name, localId, 0, addr, peerAddress);
				«IF GlobalSettings::generateMSCInstrumentation»
					DebuggingService.getInstance().addPortInstance(this);
				«ENDIF»
			}
			public «portClassName»(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
				super(actor, name, localId, idx, addr, peerAddress);
				«IF pclass!=null»
					«pclass.attributes.attributeInitialization(pclass, true)»
				«ENDIF»
				«IF GlobalSettings::generateMSCInstrumentation»
					DebuggingService.getInstance().addPortInstance(this);
				«ENDIF»
			}
		
			@Override
			public void receive(Message m) {
					if (!(m instanceof EventMessage))
						return;
					EventMessage msg = (EventMessage) m;
					if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
						«IF GlobalSettings::generateMSCInstrumentation»
							if (messageStrings[msg.getEvtId()] != "timerTick"){
«««								TODOTS: model switch for activation
								DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
							}
						«ENDIF»
						«IF pc.handlesReceive(conj)»
						switch (msg.getEvtId()) {
							«FOR hdlr : pc.getReceiveHandlers(conj)»
								case «hdlr.msg.getCodeName()»:
								{
									«FOR command : hdlr.detailCode.commands»
										«command»
									«ENDFOR»
								}
								break;
							«ENDFOR»
							default:
						«ENDIF»
							if (msg instanceof EventWithDataMessage)
								getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
							else
								getActor().receiveEvent(this, msg.getEvtId(), null);
						«IF pc.handlesReceive(conj)»
						}
						«ENDIF»
					}
			}
		
			«IF pclass!=null»
				«pclass.attributes.attributes»
«««				// TODO JH: Avoid collision attr getters/setter <-> user operations
				«attributeSettersGettersImplementation(pclass.attributes, null)»
				«pclass.operations.operationsImplementation(portClassName)»
			«ENDIF»
			
			// sent messages
			«FOR m : pc.getOutgoing(conj)»
				«sendMessage(m, conj)»
			«ENDFOR»
		}
		
		// replicated port class
		static public class «replPortClassName» {
			private ArrayList<«portClassName»> ports;
			private int replication;
		
			public «replPortClassName»(IEventReceiver actor, String name, int localId, Address[] addr,
					Address[] peerAddress) {
				replication = addr==null? 0:addr.length;
				ports = new ArrayList<«pc.name».«portClassName»>(replication);
				for (int i=0; i<replication; ++i) {
					ports.add(new «portClassName»(
							actor, name+i, localId, i, addr[i], peerAddress[i]));
				}
			}
			
			public int getReplication() {
				return replication;
			}
			
			public int getIndexOf(InterfaceItemBase ifitem){
					return ifitem.getIdx();
				}
			
			public «portClassName» get(int i) {
				return ports.get(i);
			}
			
			«IF conj»
			// incoming messages
			«FOR m : pc.getAllIncomingMessages()»
			«messageSignature(m)»{
				for (int i=0; i<replication; ++i) {
					ports.get(i).«messageCall(m)»;
				}
			}
			«ENDFOR»
			«ELSE»
			// outgoing messages
			«FOR m : pc.getAllOutgoingMessages()»
			«messageSignature(m)»{
				for (int i=0; i<replication; ++i) {
					ports.get(i).«messageCall(m)»;
				}
			}
			«ENDFOR»
			«ENDIF»
		}
		
«««		// interface for port class
«««		public interface I«name»{
«««			«IF conj»
«««			// outgoing messages
«««			«FOR m : pc.getAllOutgoingMessages()» «messageSignature(m)»;
«««			«ENDFOR»
«««			«ELSE»
«««			// incoming messages
«««			«FOR m : pc.getAllIncomingMessages()» «messageSignature(m)»;
«««			«ENDFOR»
«««			«ENDIF»
«««		}
	'''
	}

	def messageSignature(Message m) {
		'''«IF m.priv»private«ELSE»public«ENDIF» void «m.name»(«IF m.data!=null»«m.data.refType.type.typeName» «m.data.name»«ENDIF»)'''
	}

	def messageSignatureExplicit(Message m) {
		var dc = (m.data.refType.type as DataClass)
		'''public void «m.name»(«dc.argList»)'''
	}

	def messageCall(Message m) {
		'''«m.name»(«IF m.data!=null» «m.data.name»«ENDIF»)'''
	}
	
	def sendMessage(Message m, boolean conj) {
		var dir = if (conj) "IN" else "OUT"
		var hdlr = m.getSendHandler(conj)
		'''
			«messageSignature(m)» {
				«IF hdlr!=null»
					«FOR command : hdlr.detailCode.commands»	«command»
					«ENDFOR»
				«ELSE»
					«IF GlobalSettings::generateMSCInstrumentation»
						if (messageStrings[ «dir»_«m.name»] != "timerTick") {
«««							TODOTS: model switch for activation
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[«dir»_«m.name»]);
						}
					«ENDIF»
					if (getPeerAddress()!=null)
						«IF m.data==null»getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), «dir»_«m.name»));
						«ELSE»getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), «dir»_«m.name», «m.data.name»«IF (!m.data.refType.ref && !(m.data.refType.type instanceof PrimitiveType))».deepCopy()«ENDIF»));
					«ENDIF»
				«ENDIF»
			}
			«IF m.data!=null && m.data.refType.type instanceof DataClass»
				«messageSignatureExplicit(m)» {
					«m.name»(new «m.data.refType.type.name»(«(m.data.refType.type as DataClass).paramList»));
				}
			«ENDIF»
		'''
	}
}
