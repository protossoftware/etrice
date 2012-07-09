package room.basic.service.tcp;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class PTcpControl {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_established = 1;
	public static final int OUT_error = 2;
	public static final int IN_open = 3;
	public static final int IN_close = 4;
	public static final int MSG_MAX = 5;


	private static String messageStrings[] = {"MIN", "established","error", "open","close","MAX"};

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
	static public class PTcpControlPort extends PortBase {
		// constructors
		public PTcpControlPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTcpControlPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void established() {
			if (messageStrings[ OUT_established] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_established]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_established));
				}
		public void error() {
			if (messageStrings[ OUT_error] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_error]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_error));
				}
	}
	
	// replicated port class
	static public class PTcpControlReplPort {
		private ArrayList<PTcpControlPort> ports;
		private int replication;
	
		public PTcpControlReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTcpControl.PTcpControlPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTcpControlPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTcpControlPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void established(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).established();
			}
		}
		public void error(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).error();
			}
		}
	}
	
	
	// port class
	static public class PTcpControlConjPort extends PortBase {
		// constructors
		public PTcpControlConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTcpControlConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void open(DTcpControl data) {
			if (messageStrings[ IN_open] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_open]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_open, data.deepCopy()));
		}
		public void open(String IPAddr, int TcpPort) {
			open(new DTcpControl(IPAddr, TcpPort));
		}
		public void close() {
			if (messageStrings[ IN_close] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_close]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_close));
				}
	}
	
	// replicated port class
	static public class PTcpControlConjReplPort {
		private ArrayList<PTcpControlConjPort> ports;
		private int replication;
	
		public PTcpControlConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTcpControl.PTcpControlConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTcpControlConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTcpControlConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void open(DTcpControl data){
			for (int i=0; i<replication; ++i) {
				ports.get(i).open( data);
			}
		}
		public void close(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).close();
			}
		}
	}
	
}
