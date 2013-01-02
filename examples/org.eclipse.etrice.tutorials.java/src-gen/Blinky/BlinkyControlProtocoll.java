package Blinky;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class BlinkyControlProtocoll {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int IN_start = 1;
	public static final int IN_stop = 2;
	public static final int MSG_MAX = 3;


	private static String messageStrings[] = {"MIN",  "start","stop","MAX"};

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
	static public class BlinkyControlProtocollPort extends PortBase {
		// constructors
		public BlinkyControlProtocollPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public BlinkyControlProtocollPort(IEventReceiver actor, String name, int localId, int idx) {
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
	}
	
	// replicated port class
	static public class BlinkyControlProtocollReplPort extends ReplicatedPortBase {
	
		public BlinkyControlProtocollReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public BlinkyControlProtocollPort get(int idx) {
			return (BlinkyControlProtocollPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new BlinkyControlProtocollPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
	}
	
	
	// port class
	static public class BlinkyControlProtocollConjPort extends PortBase {
		// constructors
		public BlinkyControlProtocollConjPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public BlinkyControlProtocollConjPort(IEventReceiver actor, String name, int localId, int idx) {
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
		public void stop() {
			if (messageStrings[ IN_stop] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_stop]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_stop));
				}
	}
	
	// replicated port class
	static public class BlinkyControlProtocollConjReplPort extends ReplicatedPortBase {
	
		public BlinkyControlProtocollConjReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public BlinkyControlProtocollConjPort get(int idx) {
			return (BlinkyControlProtocollConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new BlinkyControlProtocollConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void start(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).start();
			}
		}
		public void stop(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).stop();
			}
		}
	}
	
}
