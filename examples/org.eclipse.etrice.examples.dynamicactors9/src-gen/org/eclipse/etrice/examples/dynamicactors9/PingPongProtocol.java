package org.eclipse.etrice.examples.dynamicactors9;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class PingPongProtocol {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_pong = 1;
	public static final int IN_ping = 2;
	public static final int MSG_MAX = 3;


	private static String messageStrings[] = {"MIN", "pong", "ping","MAX"};

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
		public PingPongProtocolPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PingPongProtocolPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
			DebuggingService.getInstance().addPortInstance(this);
		}
		
		public void destroy() {
			DebuggingService.getInstance().removePortInstance(this);
			super.destroy();
		}
	
		@Override
		public void receive(Message m) {
			if (!(m instanceof EventMessage))
				return;
			EventMessage msg = (EventMessage) m;
			if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
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
		public void pong() {
			if (messageStrings[ OUT_pong] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_pong]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_pong));
		}
	}
	
	// replicated port class
	static public class PingPongProtocolReplPort extends ReplicatedPortBase {
	
		public PingPongProtocolReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PingPongProtocolPort get(int idx) {
			return (PingPongProtocolPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PingPongProtocolPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void pong(){
			for (InterfaceItemBase item : getItems()) {
				((PingPongProtocolPort)item).pong();
			}
		}
	}
	
	
	// port class
	static public class PingPongProtocolConjPort extends PortBase {
		// constructors
		public PingPongProtocolConjPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PingPongProtocolConjPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
			DebuggingService.getInstance().addPortInstance(this);
		}
		
		public void destroy() {
			DebuggingService.getInstance().removePortInstance(this);
			super.destroy();
		}
	
		@Override
		public void receive(Message m) {
			if (!(m instanceof EventMessage))
				return;
			EventMessage msg = (EventMessage) m;
			if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
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
		public void ping() {
			if (messageStrings[ IN_ping] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_ping]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_ping));
		}
	}
	
	// replicated port class
	static public class PingPongProtocolConjReplPort extends ReplicatedPortBase {
	
		public PingPongProtocolConjReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PingPongProtocolConjPort get(int idx) {
			return (PingPongProtocolConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PingPongProtocolConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void ping(){
			for (InterfaceItemBase item : getItems()) {
				((PingPongProtocolConjPort)item).ping();
			}
		}
	}
	
}
