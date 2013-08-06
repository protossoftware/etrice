package org.eclipse.etrice.examples.dynamicactors8;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class PStep {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_hello = 1;
	public static final int IN_step = 2;
	public static final int IN_sayHello = 3;
	public static final int MSG_MAX = 4;


	private static String messageStrings[] = {"MIN", "hello", "step","sayHello","MAX"};

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
	static public class PStepPort extends PortBase {
		// constructors
		public PStepPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PStepPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void hello(String txt) {
			if (messageStrings[ OUT_hello] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_hello]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_hello, txt));
		}
	}
	
	// replicated port class
	static public class PStepReplPort extends ReplicatedPortBase {
	
		public PStepReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PStepPort get(int idx) {
			return (PStepPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PStepPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void hello(String txt){
			for (InterfaceItemBase item : getItems()) {
				((PStepPort)item).hello( txt);
			}
		}
	}
	
	
	// port class
	static public class PStepConjPort extends PortBase {
		// constructors
		public PStepConjPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PStepConjPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void step() {
			if (messageStrings[ IN_step] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_step]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_step));
		}
		public void sayHello() {
			if (messageStrings[ IN_sayHello] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_sayHello]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_sayHello));
		}
	}
	
	// replicated port class
	static public class PStepConjReplPort extends ReplicatedPortBase {
	
		public PStepConjReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PStepConjPort get(int idx) {
			return (PStepConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PStepConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void step(){
			for (InterfaceItemBase item : getItems()) {
				((PStepConjPort)item).step();
			}
		}
		public void sayHello(){
			for (InterfaceItemBase item : getItems()) {
				((PStepConjPort)item).sayHello();
			}
		}
	}
	
}
