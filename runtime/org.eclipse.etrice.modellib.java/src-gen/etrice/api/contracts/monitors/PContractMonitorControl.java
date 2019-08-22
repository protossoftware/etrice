package etrice.api.contracts.monitors;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class PContractMonitorControl {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_violationStatus = 1;
	public static final int OUT_violationOccured = 2;
	public static final int IN_getAndResetStatus = 3;
	public static final int IN_setForwardInvalidMessages = 4;
	public static final int MSG_MAX = 5;


	private static String messageStrings[] = {"MIN", "violationStatus","violationOccured", "getAndResetStatus","setForwardInvalidMessages","MAX"};

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
	static public class PContractMonitorControlPort extends PortBase {
		// constructors
		public PContractMonitorControlPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PContractMonitorControlPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void violationStatus(boolean transitionData) {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_violationStatus]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_violationStatus, transitionData));
		}
		public void violationOccured() {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_violationOccured]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_violationOccured));
		}
	}
	
	// replicated port class
	static public class PContractMonitorControlReplPort extends ReplicatedPortBase {
	
		public PContractMonitorControlReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
	
		public int getReplication() {
			return getNInterfaceItems();
		}
	
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
		}
	
		public PContractMonitorControlPort get(int idx) {
			return (PContractMonitorControlPort) getInterfaceItem(idx);
		}
	
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PContractMonitorControlPort(rcv, name, lid, idx);
		}
	
		// outgoing messages
		public void violationStatus(boolean transitionData){
			for (InterfaceItemBase item : getItems()) {
				((PContractMonitorControlPort)item).violationStatus( transitionData);
			}
		}
		public void violationOccured(){
			for (InterfaceItemBase item : getItems()) {
				((PContractMonitorControlPort)item).violationOccured();
			}
		}
	}
	
	
	// port class
	static public class PContractMonitorControlConjPort extends PortBase {
		// constructors
		public PContractMonitorControlConjPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PContractMonitorControlConjPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void getAndResetStatus() {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_getAndResetStatus]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_getAndResetStatus));
		}
		public void setForwardInvalidMessages(boolean transitionData) {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_setForwardInvalidMessages]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_setForwardInvalidMessages, transitionData));
		}
	}
	
	// replicated port class
	static public class PContractMonitorControlConjReplPort extends ReplicatedPortBase {
	
		public PContractMonitorControlConjReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
	
		public int getReplication() {
			return getNInterfaceItems();
		}
	
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
		}
	
		public PContractMonitorControlConjPort get(int idx) {
			return (PContractMonitorControlConjPort) getInterfaceItem(idx);
		}
	
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new PContractMonitorControlConjPort(rcv, name, lid, idx);
		}
	
		// incoming messages
		public void getAndResetStatus(){
			for (InterfaceItemBase item : getItems()) {
				((PContractMonitorControlConjPort)item).getAndResetStatus();
			}
		}
		public void setForwardInvalidMessages(boolean transitionData){
			for (InterfaceItemBase item : getItems()) {
				((PContractMonitorControlConjPort)item).setForwardInvalidMessages( transitionData);
			}
		}
	}
	
}
