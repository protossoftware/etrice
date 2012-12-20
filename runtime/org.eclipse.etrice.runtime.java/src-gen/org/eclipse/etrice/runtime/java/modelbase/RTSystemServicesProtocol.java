package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.Message;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class RTSystemServicesProtocol {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int IN_executeInitialTransition = 1;
	public static final int IN_startDebugging = 2;
	public static final int IN_stopDebugging = 3;
	public static final int MSG_MAX = 4;


	private static String messageStrings[] = {"MIN",  "executeInitialTransition","startDebugging","stopDebugging","MAX"};

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
	static public class RTSystemServicesProtocolPort extends PortBase {
		// constructors
		public RTSystemServicesProtocolPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public RTSystemServicesProtocolPort(IEventReceiver actor, String name, int localId, int idx) {
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
	}
	
	// replicated port class
	static public class RTSystemServicesProtocolReplPort extends ReplicatedPortBase {
	
		public RTSystemServicesProtocolReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public RTSystemServicesProtocolPort get(int idx) {
			return (RTSystemServicesProtocolPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new RTSystemServicesProtocolPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
	}
	
	
	// port class
	static public class RTSystemServicesProtocolConjPort extends PortBase {
		// constructors
		public RTSystemServicesProtocolConjPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public RTSystemServicesProtocolConjPort(IEventReceiver actor, String name, int localId, int idx) {
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
		public void executeInitialTransition() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_executeInitialTransition));
				}
		public void startDebugging() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_startDebugging));
				}
		public void stopDebugging() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_stopDebugging));
				}
	}
	
	// replicated port class
	static public class RTSystemServicesProtocolConjReplPort extends ReplicatedPortBase {
	
		public RTSystemServicesProtocolConjReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public RTSystemServicesProtocolConjPort get(int idx) {
			return (RTSystemServicesProtocolConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new RTSystemServicesProtocolConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void executeInitialTransition(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).executeInitialTransition();
			}
		}
		public void startDebugging(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).startDebugging();
			}
		}
		public void stopDebugging(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).stopDebugging();
			}
		}
	}
	
}
