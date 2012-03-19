package room.basic.service.tcp;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class PTcpPayload {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_receive = 1;
	public static final int IN_send = 2;
	public static final int MSG_MAX = 3;


	private static String messageStrings[] = {"MIN", "receive", "send","MAX"};

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
	static public class PTcpPayloadPort extends PortBase {
		// constructors
		public PTcpPayloadPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTcpPayloadPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void receive(DTcpPayload data) {
			if (messageStrings[ OUT_receive] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_receive]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_receive, data.deepCopy()));
		}
		public void receive(int connectionId, int length, byte[] data) {
			receive(new DTcpPayload(connectionId, length, data));
		}
	}
	
	// replicated port class
	static public class PTcpPayloadReplPort {
		private ArrayList<PTcpPayloadPort> ports;
		private int replication;
	
		public PTcpPayloadReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTcpPayload.PTcpPayloadPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTcpPayloadPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTcpPayloadPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void receive(DTcpPayload data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).receive( data);
			}
		}
	}
	
	
	// port class
	static public class PTcpPayloadConjPort extends PortBase {
		// constructors
		public PTcpPayloadConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTcpPayloadConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void send(DTcpPayload data) {
			if (messageStrings[ IN_send] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_send]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_send, data.deepCopy()));
		}
		public void send(int connectionId, int length, byte[] data) {
			send(new DTcpPayload(connectionId, length, data));
		}
	}
	
	// replicated port class
	static public class PTcpPayloadConjReplPort {
		private ArrayList<PTcpPayloadConjPort> ports;
		private int replication;
	
		public PTcpPayloadConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTcpPayload.PTcpPayloadConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTcpPayloadConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTcpPayloadConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void send(DTcpPayload data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).send( data);
			}
		}
	}
	
}
