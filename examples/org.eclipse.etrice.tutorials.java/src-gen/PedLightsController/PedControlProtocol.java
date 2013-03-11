package PedLightsController;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class PedControlProtocol {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_setCarLights = 1;
	public static final int OUT_setPedLights = 2;
	public static final int IN_start = 3;
	public static final int MSG_MAX = 4;


	private static String messageStrings[] = {"MIN", "setCarLights","setPedLights", "start","MAX"};

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
	static public class PedControlProtocolPort extends PortBase {
		// constructors
		public PedControlProtocolPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PedControlProtocolPort(IEventReceiver actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
			DebuggingService.getInstance().addPortInstance(this);
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
		public void setCarLights(int state) {
			if (messageStrings[ OUT_setCarLights] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_setCarLights]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_setCarLights, state));
		}
		public void setPedLights(int state) {
			if (messageStrings[ OUT_setPedLights] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_setPedLights]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_setPedLights, state));
		}
	}
	
	// replicated port class
	static public class PedControlProtocolReplPort extends ReplicatedPortBase {
	
		public PedControlProtocolReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PedControlProtocolPort get(int idx) {
			return (PedControlProtocolPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PedControlProtocolPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void setCarLights(int state){
			for (int i=0; i<getReplication(); ++i) {
				get(i).setCarLights( state);
			}
		}
		public void setPedLights(int state){
			for (int i=0; i<getReplication(); ++i) {
				get(i).setPedLights( state);
			}
		}
	}
	
	
	// port class
	static public class PedControlProtocolConjPort extends PortBase {
		// constructors
		public PedControlProtocolConjPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PedControlProtocolConjPort(IEventReceiver actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
			DebuggingService.getInstance().addPortInstance(this);
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
		public void start() {
			if (messageStrings[ IN_start] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_start]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_start));
				}
	}
	
	// replicated port class
	static public class PedControlProtocolConjReplPort extends ReplicatedPortBase {
	
		public PedControlProtocolConjReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PedControlProtocolConjPort get(int idx) {
			return (PedControlProtocolConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PedControlProtocolConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void start(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).start();
			}
		}
	}
	
}
