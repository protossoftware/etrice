package room.basic.service.tcp;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



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
		public PTcpPayloadPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTcpPayloadPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
				DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
				if (msg instanceof EventWithDataMessage)
					getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
				else
					getActor().receiveEvent(this, msg.getEvtId(), null);
			}
	}
	
	
		// sent messages
		public void receive(DTcpPayload data) {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_receive]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_receive, data.deepCopy()));
		}
		public void receive(int connectionId, int length, byte[] data) {
			receive(new DTcpPayload(connectionId, length, data));
		}
	}
	
	// replicated port class
	static public class PTcpPayloadReplPort extends ReplicatedPortBase {
	
		public PTcpPayloadReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
	
		public int getReplication() {
			return getNInterfaceItems();
		}
	
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
		}
	
		public PTcpPayloadPort get(int idx) {
			return (PTcpPayloadPort) getInterfaceItem(idx);
		}
	
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PTcpPayloadPort(rcv, name, lid, idx);
		}
	
		// outgoing messages
		public void receive(DTcpPayload data){
			for (InterfaceItemBase item : getItems()) {
				((PTcpPayloadPort)item).receive( data);
			}
		}
	}
	
	
	// port class
	static public class PTcpPayloadConjPort extends PortBase {
		// constructors
		public PTcpPayloadConjPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTcpPayloadConjPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
				DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
				if (msg instanceof EventWithDataMessage)
					getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
				else
					getActor().receiveEvent(this, msg.getEvtId(), null);
			}
	}
	
	
		// sent messages
		public void send(DTcpPayload data) {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_send]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_send, data.deepCopy()));
		}
		public void send(int connectionId, int length, byte[] data) {
			send(new DTcpPayload(connectionId, length, data));
		}
	}
	
	// replicated port class
	static public class PTcpPayloadConjReplPort extends ReplicatedPortBase {
	
		public PTcpPayloadConjReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
	
		public int getReplication() {
			return getNInterfaceItems();
		}
	
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
		}
	
		public PTcpPayloadConjPort get(int idx) {
			return (PTcpPayloadConjPort) getInterfaceItem(idx);
		}
	
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PTcpPayloadConjPort(rcv, name, lid, idx);
		}
	
		// incoming messages
		public void send(DTcpPayload data){
			for (InterfaceItemBase item : getItems()) {
				((PTcpPayloadConjPort)item).send( data);
			}
		}
	}
	
}
