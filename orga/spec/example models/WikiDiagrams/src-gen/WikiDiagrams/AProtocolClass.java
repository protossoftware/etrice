package WikiDiagrams;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class AProtocolClass {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_doneThis = 1;
	public static final int OUT_doneThat = 2;
	public static final int IN_doThis = 3;
	public static final int IN_doThat = 4;
	public static final int IN_reset = 5;
	public static final int IN_error = 6;
	public static final int MSG_MAX = 7;


	private static String messageStrings[] = {"MIN", "doneThis","doneThat", "doThis","doThat","reset","error","MAX"};

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
	static public class AProtocolClassPort extends PortBase {
		// constructors
		public AProtocolClassPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public AProtocolClassPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void doneThis() {
			if (messageStrings[ OUT_doneThis] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_doneThis]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_doneThis));
		}
		public void doneThat() {
			if (messageStrings[ OUT_doneThat] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_doneThat]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_doneThat));
		}
	}
	
	// replicated port class
	static public class AProtocolClassReplPort extends ReplicatedPortBase {
	
		public AProtocolClassReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public AProtocolClassPort get(int idx) {
			return (AProtocolClassPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new AProtocolClassPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void doneThis(){
			for (InterfaceItemBase item : getItems()) {
				((AProtocolClassPort)item).doneThis();
			}
		}
		public void doneThat(){
			for (InterfaceItemBase item : getItems()) {
				((AProtocolClassPort)item).doneThat();
			}
		}
	}
	
	
	// port class
	static public class AProtocolClassConjPort extends PortBase {
		// constructors
		public AProtocolClassConjPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public AProtocolClassConjPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
		public void doThis() {
			if (messageStrings[ IN_doThis] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_doThis]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_doThis));
		}
		public void doThat() {
			if (messageStrings[ IN_doThat] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_doThat]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_doThat));
		}
		public void reset() {
			if (messageStrings[ IN_reset] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_reset]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_reset));
		}
		public void error() {
			if (messageStrings[ IN_error] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_error]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_error));
		}
	}
	
	// replicated port class
	static public class AProtocolClassConjReplPort extends ReplicatedPortBase {
	
		public AProtocolClassConjReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public AProtocolClassConjPort get(int idx) {
			return (AProtocolClassConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new AProtocolClassConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void doThis(){
			for (InterfaceItemBase item : getItems()) {
				((AProtocolClassConjPort)item).doThis();
			}
		}
		public void doThat(){
			for (InterfaceItemBase item : getItems()) {
				((AProtocolClassConjPort)item).doThat();
			}
		}
		public void reset(){
			for (InterfaceItemBase item : getItems()) {
				((AProtocolClassConjPort)item).reset();
			}
		}
		public void error(){
			for (InterfaceItemBase item : getItems()) {
				((AProtocolClassConjPort)item).error();
			}
		}
	}
	
}
