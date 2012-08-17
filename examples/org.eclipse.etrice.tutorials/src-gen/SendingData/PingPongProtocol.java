package SendingData;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class PingPongProtocol {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_pong = 1;
	public static final int OUT_pongSimple = 2;
	public static final int IN_ping = 3;
	public static final int IN_pingSimple = 4;
	public static final int MSG_MAX = 5;


	private static String messageStrings[] = {"MIN", "pong","pongSimple", "ping","pingSimple","MAX"};

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
	static public class PingPongProtocolPort extends PortBase {
		// constructors
		public PingPongProtocolPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PingPongProtocolPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void pong(DemoData data) {
			if (messageStrings[ OUT_pong] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_pong]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_pong, data.deepCopy()));
		}
		public void pong(int int32Val, byte[] int8Array, double float64Val, String stringVal) {
			pong(new DemoData(int32Val, int8Array, float64Val, stringVal));
		}
		public void pongSimple(int data) {
			if (messageStrings[ OUT_pongSimple] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_pongSimple]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_pongSimple, data));
		}
	}
	
	// replicated port class
	static public class PingPongProtocolReplPort {
		private ArrayList<PingPongProtocolPort> ports;
		private int replication;
	
		public PingPongProtocolReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PingPongProtocol.PingPongProtocolPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PingPongProtocolPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PingPongProtocolPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void pong(DemoData data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).pong( data);
			}
		}
		public void pongSimple(int data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).pongSimple( data);
			}
		}
	}
	
	
	// port class
	static public class PingPongProtocolConjPort extends PortBase {
		// constructors
		public PingPongProtocolConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PingPongProtocolConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void ping(DemoData data) {
			if (messageStrings[ IN_ping] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_ping]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_ping, data.deepCopy()));
		}
		public void ping(int int32Val, byte[] int8Array, double float64Val, String stringVal) {
			ping(new DemoData(int32Val, int8Array, float64Val, stringVal));
		}
		public void pingSimple(int data) {
			if (messageStrings[ IN_pingSimple] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_pingSimple]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_pingSimple, data));
		}
	}
	
	// replicated port class
	static public class PingPongProtocolConjReplPort {
		private ArrayList<PingPongProtocolConjPort> ports;
		private int replication;
	
		public PingPongProtocolConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PingPongProtocol.PingPongProtocolConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PingPongProtocolConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PingPongProtocolConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void ping(DemoData data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).ping( data);
			}
		}
		public void pingSimple(int data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).pingSimple( data);
			}
		}
	}
	
}
