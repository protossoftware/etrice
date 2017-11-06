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
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.CommunicationType
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.etrice.generator.java.Main
import org.eclipse.etrice.core.genmodel.fsm.ILogger

@Singleton
class ProtocolClassGen extends GenericProtocolClassGenerator {

	@Inject IGeneratorFileIo fileIO
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject extension ProcedureHelpers
	@Inject extension Initialization
	@Inject extension TypeHelpers
	@Inject extension DataClassGen
	@Inject extension FileSystemHelpers
	@Inject ILogger logger

	def doGenerate(Root root) {
		for (pc: root.protocolClasses.filter(cl|cl.isValidGenerationLocation)) {
			val path = pc.generationTargetPath+pc.getPath
			val infopath = pc.generationInfoPath+pc.getPath
			val file = pc.getJavaFileName
			val contents =
			switch (pc.commType) {
				case CommunicationType::EVENT_DRIVEN:
					root.generate(pc)
				case CommunicationType::DATA_DRIVEN:
					root.generateDataDriven(pc)
				case CommunicationType::SYNCHRONOUS:
					""
			}
			if (contents.toString.empty)
				logger.logError("synchronous protocols not supported yet", pc)
			else
				fileIO.generateFile("generating ProtocolClass implementation", path, infopath, file, contents)
		}
	}

	def generate(Root root, ProtocolClass pc) {'''
		package «pc.getPackage()»;

		import org.eclipse.etrice.runtime.java.messaging.Message;
		import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
		import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
		import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
		import org.eclipse.etrice.runtime.java.modelbase.PortBase;
		import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
		«IF Main::settings.generateMSCInstrumentation»
			import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
		«ENDIF»
		import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

		«pc.userCode(1)»

		«var models = root.getReferencedModels(pc)»
		«FOR model : models»
			import «model.name».*;
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

	def portClass(ProtocolClass pc, boolean conj) {
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
			public «portClassName»(IInterfaceItemOwner actor, String name, int localId) {
				this(actor, name, localId, 0);
			}
			public «portClassName»(IInterfaceItemOwner actor, String name, int localId, int idx) {
				super(actor, name, localId, idx);
				«IF pclass!=null»
					«pclass.attributes.attributeInitialization(pclass, true)»
				«ENDIF»
				«IF Main::settings.generateMSCInstrumentation»
					DebuggingService.getInstance().addPortInstance(this);
				«ENDIF»
			}
			«IF Main::settings.generateMSCInstrumentation»

				public void destroy() {
					DebuggingService.getInstance().removePortInstance(this);
					super.destroy();
				}
			«ENDIF»

			@Override
			public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
					«IF Main::settings.generateMSCInstrumentation»
						DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
					«ENDIF»
					«IF pc.handlesReceive(conj)»
					switch (msg.getEvtId()) {
						«FOR hdlr : pc.getReceiveHandlers(conj)»
							case «hdlr.msg.getCodeName()»:
							{
								«FOR command : hdlr.detailCode.lines»
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
			«FOR m : pc.getAllMessages(conj)»
				«sendMessage(m, conj)»
			«ENDFOR»
		}

		// replicated port class
		static public class «replPortClassName» extends ReplicatedPortBase {

			public «replPortClassName»(IInterfaceItemOwner actor, String name, int localId) {
				super(actor, name, localId);
			}

			public int getReplication() {
				return getNInterfaceItems();
			}

			public int getIndexOf(InterfaceItemBase ifitem){
					return ifitem.getIdx();
			}

			public «portClassName» get(int idx) {
				return («portClassName») getInterfaceItem(idx);
			}

			protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
				return new «portClassName»(rcv, name, lid, idx);
			}

			«IF conj»
				// incoming messages
				«FOR m : pc.getAllIncomingMessages()»
					«messageSignature(m)»{
						for (InterfaceItemBase item : getItems()) {
							((«portClassName»)item).«messageCall(m)»;
						}
					}
				«ENDFOR»
			«ELSE»
				// outgoing messages
				«FOR m : pc.getAllOutgoingMessages()»
					«messageSignature(m)»{
						for (InterfaceItemBase item : getItems()) {
							((«portClassName»)item).«messageCall(m)»;
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
					«FOR command : hdlr.detailCode.lines»	«command»
					«ENDFOR»
				«ELSE»
					«IF Main::settings.generateMSCInstrumentation»
						DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[«dir»_«m.name»]);
					«ENDIF»
					if (getPeerAddress()!=null)
						«IF m.data==null»
							getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), «dir»_«m.name»));
						«ELSE»
							getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), «dir»_«m.name», «m.data.name»«IF (!m.data.refType.ref && !(m.data.refType.type.enumerationOrPrimitive))».deepCopy()«ENDIF»));
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

	def generateDataDriven(Root root, ProtocolClass pc) {
		val sentMsgs = pc.allIncomingMessages.filter(m|m.data!=null)
		val models = root.getReferencedModels(pc)
		'''
			package «pc.getPackage()»;

			import org.eclipse.etrice.runtime.java.messaging.IRTObject;
			import org.eclipse.etrice.runtime.java.modelbase.DataReceivePort;
			import org.eclipse.etrice.runtime.java.modelbase.DataSendPort;
			import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

			«pc.userCode(1)»

			«FOR model : models»
				import «model.name».*;
			«ENDFOR»

			public class «pc.name» {

				«pc.userCode(2)»

				// send port holds data
				static public class «pc.getPortClassName(true)» extends DataSendPort {
					«FOR msg : sentMsgs»
						private «msg.data.refType.type.typeName» «msg.name»;
					«ENDFOR»

					// constructor
					public «pc.getPortClassName(true)»(IRTObject parent, String name, int localId) {
						super(parent, name, localId);
					}

					// getters and setters
					«FOR msg : sentMsgs»
						public void «msg.name»(«msg.data.refType.type.typeName» «msg.name») {
							this.«msg.name» = «msg.name»;
						}
						public «msg.data.refType.type.typeName» «msg.name»() {
							return «msg.name»;
						}
					«ENDFOR»
				}

				// receive port accesses send port
				static public class «pc.getPortClassName(false)» extends DataReceivePort {
					private «pc.getPortClassName(true)» peer;

					// constructor
					public «pc.getPortClassName(false)»(IRTObject parent, String name, int localId) {
						super(parent, name, localId);
					}

					// getters
					«FOR msg : sentMsgs»
						public «msg.data.refType.type.typeName» «msg.name»() {
							if (peer==null)
								return «msg.data.refType.type.defaultValue»;
							return peer.«msg.name»();
						}
					«ENDFOR»

					protected void connect(DataSendPort dataSendPort) {
						if (dataSendPort instanceof «pc.getPortClassName(true)»)
							peer = («pc.getPortClassName(true)»)dataSendPort;
					}
				}
			}
		'''
	}
}
