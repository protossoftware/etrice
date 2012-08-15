package org.eclipse.etrice.integration.HandlerTest;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class TestProtocol {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int IN_msg1 = 1;
	public static final int IN_msg2 = 2;
	public static final int IN_msg3 = 3;
	public static final int IN_msg4 = 4;
	public static final int IN_msg5 = 5;
	public static final int IN_msg6 = 6;
	public static final int MSG_MAX = 7;


	private static String messageStrings[] = {"MIN",  "msg1","msg2","msg3","msg4","msg5","msg6","MAX"};

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
	static public class TestProtocolPort extends PortBase {
		// constructors
		public TestProtocolPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public TestProtocolPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
	}
	
	// replicated port class
	static public class TestProtocolReplPort {
		private ArrayList<TestProtocolPort> ports;
		private int replication;
	
		public TestProtocolReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<TestProtocol.TestProtocolPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new TestProtocolPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public TestProtocolPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
	}
	
	
	// port class
	static public class TestProtocolConjPort extends PortBase {
		// constructors
		public TestProtocolConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public TestProtocolConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void msg1(int p1) {
			if (messageStrings[ IN_msg1] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_msg1]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_msg1, p1));
		}
		public void msg2(int p1) {
			if (messageStrings[ IN_msg2] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_msg2]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_msg2, p1));
		}
		public void msg3() {
			if (messageStrings[ IN_msg3] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_msg3]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_msg3));
				}
		public void msg4() {
			if (messageStrings[ IN_msg4] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_msg4]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_msg4));
				}
		public void msg5(int p1) {
			if (messageStrings[ IN_msg5] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_msg5]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_msg5, p1));
		}
		public void msg6(int p1) {
			if (messageStrings[ IN_msg6] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_msg6]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_msg6, p1));
		}
	}
	
	// replicated port class
	static public class TestProtocolConjReplPort {
		private ArrayList<TestProtocolConjPort> ports;
		private int replication;
	
		public TestProtocolConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<TestProtocol.TestProtocolConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new TestProtocolConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public TestProtocolConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void msg1(int p1){
			for (int i=0; i<replication; ++i) {
				ports.get(i).msg1( p1);
			}
		}
		public void msg2(int p1){
			for (int i=0; i<replication; ++i) {
				ports.get(i).msg2( p1);
			}
		}
		public void msg3(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).msg3();
			}
		}
		public void msg4(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).msg4();
			}
		}
		public void msg5(int p1){
			for (int i=0; i<replication; ++i) {
				ports.get(i).msg5( p1);
			}
		}
		public void msg6(int p1){
			for (int i=0; i<replication; ++i) {
				ports.get(i).msg6( p1);
			}
		}
	}
	
}
