package org.eclipse.etrice.examples.dynamicactors4;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class PWorker {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_ok = 1;
	public static final int OUT_error = 2;
	public static final int IN_create = 3;
	public static final int MSG_MAX = 4;


	private static String messageStrings[] = {"MIN", "ok","error", "create","MAX"};

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
	static public class PWorkerPort extends PortBase {
		// constructors
		public PWorkerPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PWorkerPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void ok() {
			if (messageStrings[ OUT_ok] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_ok]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_ok));
		}
		public void error() {
			if (messageStrings[ OUT_error] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_error]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_error));
		}
	}
	
	// replicated port class
	static public class PWorkerReplPort extends ReplicatedPortBase {
	
		public PWorkerReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PWorkerPort get(int idx) {
			return (PWorkerPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PWorkerPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void ok(){
			for (InterfaceItemBase item : getItems()) {
				((PWorkerPort)item).ok();
			}
		}
		public void error(){
			for (InterfaceItemBase item : getItems()) {
				((PWorkerPort)item).error();
			}
		}
	}
	
	
	// port class
	static public class PWorkerConjPort extends PortBase {
		// constructors
		public PWorkerConjPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PWorkerConjPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void create(String ac) {
			if (messageStrings[ IN_create] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_create]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_create, ac));
		}
	}
	
	// replicated port class
	static public class PWorkerConjReplPort extends ReplicatedPortBase {
	
		public PWorkerConjReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PWorkerConjPort get(int idx) {
			return (PWorkerConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PWorkerConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void create(String ac){
			for (InterfaceItemBase item : getItems()) {
				((PWorkerConjPort)item).create( ac);
			}
		}
	}
	
}
