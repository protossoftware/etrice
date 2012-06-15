package org.eclipse.etrice.integration.ConfigTest;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class ProtocolForConfig {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_outMess = 1;
	public static final int IN_inMessage = 2;
	public static final int MSG_MAX = 3;


	private static String messageStrings[] = {"MIN", "outMess", "inMessage","MAX"};

	public String getMessageString(int msg_id) {
		if (msg_id<MSG_MIN || msg_id>MSG_MAX+1){
			// id out of range
			return "Message ID out of range";
		}
		else{
			return messageStrings[msg_id];
		}
	}

	
	// port class
	static public class ProtocolForConfigPort extends PortBase {
		// constructors
		public ProtocolForConfigPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public ProtocolForConfigPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
					System.out.println("unknown");
				else {
					if (messageStrings[msg.getEvtId()] != "timerTick"){
						DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
					}
					switch (msg.getEvtId()) {
						case IN_inMessage:
						{
							// detail code
						}
						break;
						default:
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
					}
				}
		}
	
		/*--------------------- attributes ---------------------*/
		int channel;
		/*--------------------- operations ---------------------*/
		public int getChannel() {
			return channel;
		}
		
		// sent messages
		public void outMess(int data) {
				// out
		}
	}
	
	// replicated port class
	static public class ProtocolForConfigReplPort {
		private ArrayList<ProtocolForConfigPort> ports;
		private int replication;
	
		public ProtocolForConfigReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<ProtocolForConfig.ProtocolForConfigPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new ProtocolForConfigPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public ProtocolForConfigPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void outMess(int data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).outMess( data);
			}
		}
	}
	
	
	// port class
	static public class ProtocolForConfigConjPort extends PortBase {
		// constructors
		public ProtocolForConfigConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public ProtocolForConfigConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
					System.out.println("unknown");
				else {
					if (messageStrings[msg.getEvtId()] != "timerTick"){
						DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
					}
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
				}
		}
	
		
		// sent messages
		public void inMessage(int data) {
			if (messageStrings[ IN_inMessage] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_inMessage]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_inMessage, data));
		}
	}
	
	// replicated port class
	static public class ProtocolForConfigConjReplPort {
		private ArrayList<ProtocolForConfigConjPort> ports;
		private int replication;
	
		public ProtocolForConfigConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<ProtocolForConfig.ProtocolForConfigConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new ProtocolForConfigConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public ProtocolForConfigConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void inMessage(int data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).inMessage( data);
			}
		}
	}
	
}
