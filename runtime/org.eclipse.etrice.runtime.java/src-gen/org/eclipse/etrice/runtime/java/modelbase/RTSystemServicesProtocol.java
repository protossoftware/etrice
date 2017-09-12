package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
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
		public RTSystemServicesProtocolPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public RTSystemServicesProtocolPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
	}
	
	// replicated port class
	static public class RTSystemServicesProtocolReplPort extends ReplicatedPortBase {
	
		public RTSystemServicesProtocolReplPort(IInterfaceItemOwner actor, String name, int localId) {
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
	
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new RTSystemServicesProtocolPort(rcv, name, lid, idx);
		}
	
		// outgoing messages
	}
	
	
	// port class
	static public class RTSystemServicesProtocolConjPort extends PortBase {
		// constructors
		public RTSystemServicesProtocolConjPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public RTSystemServicesProtocolConjPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void executeInitialTransition() {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_executeInitialTransition]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_executeInitialTransition));
		}
		public void startDebugging() {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_startDebugging]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_startDebugging));
		}
		public void stopDebugging() {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_stopDebugging]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_stopDebugging));
		}
	}
	
	// replicated port class
	static public class RTSystemServicesProtocolConjReplPort extends ReplicatedPortBase {
	
		public RTSystemServicesProtocolConjReplPort(IInterfaceItemOwner actor, String name, int localId) {
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
	
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new RTSystemServicesProtocolConjPort(rcv, name, lid, idx);
		}
	
		// incoming messages
		public void executeInitialTransition(){
			for (InterfaceItemBase item : getItems()) {
				((RTSystemServicesProtocolConjPort)item).executeInitialTransition();
			}
		}
		public void startDebugging(){
			for (InterfaceItemBase item : getItems()) {
				((RTSystemServicesProtocolConjPort)item).startDebugging();
			}
		}
		public void stopDebugging(){
			for (InterfaceItemBase item : getItems()) {
				((RTSystemServicesProtocolConjPort)item).stopDebugging();
			}
		}
	}
	
}
