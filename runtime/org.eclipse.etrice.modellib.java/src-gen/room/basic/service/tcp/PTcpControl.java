package room.basic.service.tcp;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



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
		public PTcpControlPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTcpControlPort(IEventReceiver actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
				}
		}
	
		
		// sent messages
		public void established() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_established));
				}
		public void error() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_error));
				}
	}
	
	// replicated port class
	static public class PTcpControlReplPort extends ReplicatedPortBase {
	
		public PTcpControlReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTcpControlPort get(int idx) {
			return (PTcpControlPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PTcpControlPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void established(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).established();
			}
		}
		public void error(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).error();
			}
		}
	}
	
	
	// port class
	static public class PTcpControlConjPort extends PortBase {
		// constructors
		public PTcpControlConjPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTcpControlConjPort(IEventReceiver actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
				}
		}
	
		
		// sent messages
		public void open(DTcpControl data) {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_open, data.deepCopy()));
		}
		public void open(String IPAddr, int TcpPort) {
			open(new DTcpControl(IPAddr, TcpPort));
		}
		public void close() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_close));
				}
	}
	
	// replicated port class
	static public class PTcpControlConjReplPort extends ReplicatedPortBase {
	
		public PTcpControlConjReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTcpControlConjPort get(int idx) {
			return (PTcpControlConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PTcpControlConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void open(DTcpControl data){
			for (int i=0; i<getReplication(); ++i) {
				get(i).open( data);
			}
		}
		public void close(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).close();
			}
		}
	}
	
}
