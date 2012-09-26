

package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.CommunicationType
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.generator.generic.GenericProtocolClassGenerator
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.SAPRef
import org.eclipse.etrice.core.room.SPPRef


@Singleton
class ProtocolClassGen extends GenericProtocolClassGenerator {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension CppExtensions stdExt
	@Inject extension RoomExtensions roomExt
	@Inject extension ProcedureHelpers helpers
	@Inject extension TypeHelpers
	@Inject ILogger logger
	
	def doGenerate(Root root) { 
		for (pc: root.usedProtocolClasses) {
			var path = pc.generationTargetPath+pc.getPath

			logger.logInfo("generating ProtocolClass header '"+pc.getCppHeaderFileName+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(pc.getCppHeaderFileName, root.generateHeaderFile(pc))

			logger.logInfo("generating ProtocolClass source '"+pc.getCppSourceFileName+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(pc.getCppSourceFileName, root.generateSourceFile(pc))
		}
	}

	
	def private generateHeaderFile(Root root, ProtocolClass pc) {'''
		/**
		 * @author generated by eTrice
		 *
		 * Header File of ProtocolClass �pc.name�
		 * 
		 */

		�generateIncludeGuardBegin(pc.name)�
		
		#include "platforms/generic/etDatatypes.h"
		#include "common/messaging/IRTObject.h"
		#include "common/modelbase/PortBase.h"
		#include "common/modelbase/InterfaceItemBase.h"
		#include "common/messaging/Address.h"
		#include "common/messaging/Message.h"
		#include <vector>
		#include <string>
				
		namespace etRuntime {
			class IEventReceiver;
			
		}
		
		�helpers.userCode(pc.userCode1)�
		
		�FOR dataClass : root.getReferencedDataClasses(pc)�
		#include "�dataClass.path��dataClass.name�.h"
		�ENDFOR�

		class �pc.name� {
		   public:
		�IF pc.commType==CommunicationType::EVENT_DRIVEN�	   /* message IDs */
				�genMessageIDs(pc)�
				static bool isValidEvtID(int evtId) {
					return ((MSG_MIN < evtId) && (evtId < MSG_MAX));
				};
				static bool isValidOutgoingEvtID(int evtId) {
					return ((MSG_MIN < evtId) && (evtId < �IF pc.incomingMessages.size == 0�MSG_MAX�ELSE�IN_�pc.incomingMessages.get(0).name��ENDIF�));
				};
				static bool isValidIncomingEvtID(int evtId) {
					return ((�IF pc.incomingMessages.size == 0�MSG_MAX�ELSE�IN_�pc.incomingMessages.get(0).name��ENDIF� <= evtId) && (evtId < MSG_MAX));
				};
				static std::string getMessageString(int msg_id);
			
			private:
				static std::string s_messageStrings[];
		�ENDIF�
				�helpers.userCode(pc.userCode2)�
		};
		
		�portClassDeclaration(pc, false)�
		�portClassDeclaration(pc, true)�
		�generateIncludeGuardEnd(pc.name)�
	'''
	}
	
	def portClassDeclaration(ProtocolClass pc, Boolean conj) {
		var pclass = pc.getPortClass(conj)
		var portClassName = pc.getPortClassName(conj)
		var replPortClassName = pc.getPortClassName(conj, true)
	'''
	//------------------------------------------------------------------------------------------------------------
	// �IF conj�conjugated �ENDIF�port class
	//------------------------------------------------------------------------------------------------------------
	class �portClassName� : public etRuntime::PortBase {
		�IF pclass!=null�
			�helpers.userCode(pclass.userCode)�
		�ENDIF�
	   public:
		// constructors
		 �portClassName�(etRuntime::IEventReceiver& actor, etRuntime::IRTObject* parent, std::string name, int localId, etRuntime::Address addr, etRuntime::Address peerAddress); 
		 �portClassName�(etRuntime::IEventReceiver& actor, etRuntime::IRTObject* parent, std::string name, int localId, int idx, etRuntime::Address addr, etRuntime::Address peerAddress);
	
		 virtual void receive(etRuntime::Message* m);
		�IF pclass!=null�
			�helpers.attributes(pclass.attributes)�
			�helpers.operationsDeclaration(pclass.operations, portClassName)�
		�ENDIF�
		
		  // outgoing messages
		�FOR m : pc.getOutgoing(conj)�
		  	�sendMessageDeclaration(m,conj)�
		�ENDFOR�
	};
	
	//------------------------------------------------------------------------------------------------------------
	// �IF conj�conjugated �ENDIF�replicated port class
	//------------------------------------------------------------------------------------------------------------
	class �replPortClassName� {
		private:
		    int m_replication;
		    std::vector<�portClassName�> m_ports;
	
		public:
			�replPortClassName�(etRuntime::IEventReceiver& actor, etRuntime::IRTObject* parent, std::string name, int localId, std::vector<etRuntime::Address> addr, std::vector<etRuntime::Address> peerAddress);
			virtual ~�replPortClassName�() {};
			
			int getReplication() {	return m_replication; }
			int getIndexOf(const etRuntime::InterfaceItemBase& ifitem){ return ifitem.getIdx();	}
			�portClassName� get(int i) {return m_ports.at(i);}
			
			�IF pc.commType==CommunicationType::EVENT_DRIVEN�
				 // outgoing messages
				�FOR m : pc.getOutgoing(conj)�
				  	�sendMessageDeclaration(m,conj)�
				�ENDFOR�
			�ENDIF�
			
	};
	'''
	}

	def private generateSourceFile(Root root, ProtocolClass pc) {'''
		/**
		 * @author generated by eTrice
		 *
		 * Source File of ProtocolClass �pc.name�
		 * 
		 */

		#include "�pc.getCppHeaderFileName�"
		#include "common/debugging/DebuggingService.h"
		#include <iostream>

		using namespace etRuntime;
		
		�helpers.userCode(pc.userCode3)�
		
	�IF pc.commType==CommunicationType::EVENT_DRIVEN�
		�helpers.userCode(pc.userCode2)�
	
		�portClassImplementation(pc, false)�
		�portClassImplementation(pc, true)�
		
		/*--------------------- debug helpers */
		�generateDebugHelpersImplementation(root, pc)�
	�ENDIF�
		
		
	'''
	}
	

	def portClassImplementation(ProtocolClass pc, Boolean conj) {
		var pclass = pc.getPortClass(conj)
		var portClassName = pc.getPortClassName(conj)
		var replPortClassName = pc.getPortClassName(conj, true)
	'''
	//------------------------------------------------------------------------------------------------------------
	// �IF conj�conjugated �ENDIF�port class
	//------------------------------------------------------------------------------------------------------------
	
	�portClassName�::�portClassName�(etRuntime::IEventReceiver& actor, etRuntime::IRTObject* parent, std::string name, int localId, Address addr, Address peerAddress)
		: PortBase(actor, parent, name, localId, 0, addr, peerAddress)
	{
		DebuggingService::getInstance().addPortInstance(*this);
	}

	�portClassName�::�portClassName�(etRuntime::IEventReceiver& actor, etRuntime::IRTObject* parent, std::string name, int localId, int idx, Address addr, Address peerAddress)
		: PortBase(actor, parent, name, localId, idx, addr, peerAddress)
	{
		DebuggingService::getInstance().addPortInstance(*this);
	}
		
	void �portClassName�::receive(Message* msg) {
		if (! �pc.name�::isValidIncomingEvtID(msg->getEvtId())) {
			std::cout << "unknown" << std::endl;
		}
		else {
			if (msg->hasDebugFlagSet()) {			// TODO: model switch for activation of this flag
				DebuggingService::getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), �pc.name�::getMessageString(msg->getEvtId()));
			}
			
			�IF pc.handlesReceive(conj)�
			switch (msg.getEvtId()) {
				�FOR hdlr : pc.getReceiveHandlers(conj)�
					case �hdlr.msg.getCodeName()�:
					{
						�FOR command : hdlr.detailCode.commands�
							�command�
						�ENDFOR�
					}
					break;
				�ENDFOR�
				default:
			�ENDIF�	getActor().receiveEvent(*this, msg->getEvtId(),	msg->getData());
			�IF pc.handlesReceive(conj)�
			}
			�ENDIF�
		}
	};

	�IF pclass!=null�
		�helpers.operationsImplementation(pclass.operations, portClassName)�
	�ENDIF�
			
	// sent messages
	�FOR m : pc.getOutgoing(conj)�
		�sendMessage(m, pc.name, portClassName, conj)�
	�ENDFOR�
		
	//------------------------------------------------------------------------------------------------------------
	// �IF conj�conjugated �ENDIF�replicated port class
	//------------------------------------------------------------------------------------------------------------
	�replPortClassName�::�replPortClassName�(etRuntime::IEventReceiver& actor, etRuntime::IRTObject* parent, std::string name, int localId, std::vector<Address> addr, std::vector<Address> peerAddress) 
		: m_replication(addr.size()),
	  	  m_ports()
	{
		char numstr[10]; // enough to hold all numbers up to 32-bits
	
		m_ports.reserve(m_replication);
		for (int i = 0; i < m_replication; ++i) {
			snprintf(numstr, sizeof(numstr), "%d", i);
			m_ports.push_back(�portClassName�(actor, parent, name + numstr, localId, i, addr[i], peerAddress[i]));
		}
	};
	
		
	// outgoing messages
	�FOR m : pc.getOutgoing(conj)�
	�messageSignatureDefinition(m, replPortClassName)�{
		for (int i=0; i<m_replication; ++i) {
			m_ports.at(i).�messageCall(m)�;
		}
	}
	�ENDFOR�
	'''
	}
	

	
	

	def private messageCall(Message m) {
	'''�m.name�(�IF m.data!=null� �m.data.name��ENDIF�)'''
	}
	

	
	def private generateDebugHelpersImplementation(Root root, ProtocolClass pc){'''
		
���		TODO: make this optional or different for smaller footprint
		/* message names as strings for debugging (generate MSC) */
		std::string �pc.name�::s_messageStrings[] 
				= {"MIN", 
				   �FOR m : pc.getAllOutgoingMessages()�
				   "�m.name�",
				   �ENDFOR� 
				   �FOR m : pc.getAllIncomingMessages()�
				   "�m.name�",
				   �ENDFOR�
				   "MAX"};
		
		std::string �pc.name�::getMessageString(int msg_id) {
			if ((MSG_MIN < msg_id ) && ( msg_id < MSG_MAX )) {
				return s_messageStrings[msg_id];
			} else {
				// id out of range
				return "Message ID out of range";
			}
		}
		
		'''
	}
	 

	def messageSignature(Message m) {
		'''�IF m.priv�private:�ELSE�public:�ENDIF� void �m.name�(�IF m.data!=null��m.data.refType.type.typeName� �m.data.name��ENDIF�)'''
	}

	def messageSignatureExplicit(Message m) {
		var dc = (m.data.refType.type as DataClass)
		'''public: void �m.name�(�IF dc.base!=null��dc.base.typeName� _super, �ENDIF��FOR a : dc.attributes SEPARATOR ", "��a.refType.type.typeName��IF a.size>1�[]�ENDIF� �a.name��ENDFOR�)'''
	}

	def messageSignatureDefinition(Message m, String classPrefix) {
		'''void �classPrefix�::�m.name�(�IF m.data!=null��m.data.refType.type.typeName� �m.data.name��ENDIF�)'''
	}

	def messageSignatureExplicitDefinition(Message m, String classPrefix) {
		var dc = (m.data.refType.type as DataClass)
		'''void �classPrefix�::�m.name�(�IF dc.base!=null��dc.base.typeName� _super, �ENDIF��FOR a : dc.attributes SEPARATOR ", "��a.refType.type.typeName��IF a.size>1�[]�ENDIF� �a.name��ENDFOR�)'''
	}

//	def messageCall(Message m) {
//		'''�m.name�(�IF m.data!=null� �m.data.name��ENDIF�)'''
//	}
	
	def sendMessageDeclaration(Message m, boolean conj) {
		'''
			�messageSignature(m)�;
			�IF m.data!=null && m.data.refType.type instanceof DataClass�
				�messageSignatureExplicit(m)�;
			�ENDIF�
		'''
	}
	
	def sendMessage(Message m, String portClassName, String classPrefix, boolean conj) {
		var dir = if (conj) "IN" else "OUT"
		var hdlr = m.getSendHandler(conj)
		'''
			�messageSignatureDefinition(m, classPrefix)� {
				�IF hdlr!=null�
					�FOR command : hdlr.detailCode.commands�	�command�
					�ENDFOR�
				�ELSE�
					DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
																	   �portClassName�::getMessageString(�portClassName�::�dir�_�m.name�));
					if (getPeerAddress().isValid()){
						�IF m.data==null�getPeerMsgReceiver()->receive(new Message(getPeerAddress(), �portClassName�::�dir�_�m.name�));
						�ELSE�getPeerMsgReceiver()->receive(new Message(getPeerAddress(),�portClassName�::�dir�_�m.name�, 
						                                                reinterpret_cast<void*>(�IF (m.data.refType.ref && !(m.data.refType.type instanceof PrimitiveType))�&�ENDIF��m.data.name�),
						                                                sizeof(�m.data.refType.type.typeName�)));
						�ENDIF�
					}
				�ENDIF�
			}
			
			�IF m.data!=null && m.data.refType.type instanceof DataClass�
				�messageSignatureExplicitDefinition(m, classPrefix)� {
					�m.name�(�m.data.refType.type.name�(�IF (m.data.refType.type as DataClass).base!=null�_super, �ENDIF��FOR a : (m.data.refType.type as DataClass).attributes SEPARATOR ", "��a.name��ENDFOR�));
				}
			�ENDIF�
		'''
		//TODO derived data classes are not yet handled correctly
	}
	
	override getMessageID(Message msg, InterfaceItem item) {
		if (item instanceof Port) {
			var p = item as Port;
			var direction = if (p.isConjugated())"OUT_" else "IN_"
			return enumInUse(p.getProtocol().getName(), direction+msg.getName())
		}
		else if (item instanceof SAPRef) {
			var sap = item as SAPRef;
			return enumInUse(sap.getProtocol().getName(), "OUT_"+msg.getName())
		}
		else if (item instanceof SPPRef) {
			var spp = item as SPPRef;
			return enumInUse(spp.getProtocol().getName(), "IN_"+msg.getName())
		}

		return "unknown interface item";
	}
	
	def String enumInUse(String namespace, String member) {
		return namespace+"::"+member
	}
}