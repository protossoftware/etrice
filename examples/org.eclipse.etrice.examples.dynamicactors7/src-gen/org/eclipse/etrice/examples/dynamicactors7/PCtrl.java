package org.eclipse.etrice.examples.dynamicactors7;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class PCtrl {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_done = 1;
	public static final int IN_createOpts = 2;
	public static final int IN_destroyOpts = 3;
	public static final int MSG_MAX = 4;


	private static String messageStrings[] = {"MIN", "done", "createOpts","destroyOpts","MAX"};

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
	static public class PCtrlPort extends PortBase {
		// constructors
		public PCtrlPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PCtrlPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void done() {
			if (messageStrings[ OUT_done] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_done]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_done));
		}
	}
	
	// replicated port class
	static public class PCtrlReplPort extends ReplicatedPortBase {
	
		public PCtrlReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PCtrlPort get(int idx) {
			return (PCtrlPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PCtrlPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void done(){
			for (InterfaceItemBase item : getItems()) {
				((PCtrlPort)item).done();
			}
		}
	}
	
	
	// port class
	static public class PCtrlConjPort extends PortBase {
		// constructors
		public PCtrlConjPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PCtrlConjPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void createOpts() {
			if (messageStrings[ IN_createOpts] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_createOpts]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_createOpts));
		}
		public void destroyOpts() {
			if (messageStrings[ IN_destroyOpts] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_destroyOpts]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_destroyOpts));
		}
	}
	
	// replicated port class
	static public class PCtrlConjReplPort extends ReplicatedPortBase {
	
		public PCtrlConjReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PCtrlConjPort get(int idx) {
			return (PCtrlConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PCtrlConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void createOpts(){
			for (InterfaceItemBase item : getItems()) {
				((PCtrlConjPort)item).createOpts();
			}
		}
		public void destroyOpts(){
			for (InterfaceItemBase item : getItems()) {
				((PCtrlConjPort)item).destroyOpts();
			}
		}
	}
	
}
