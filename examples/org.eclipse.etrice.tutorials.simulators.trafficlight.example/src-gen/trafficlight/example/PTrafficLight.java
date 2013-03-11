package trafficlight.example;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class PTrafficLight {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_greenForCarDone = 1;
	public static final int OUT_greenForPedDone = 2;
	public static final int IN_greenForCar = 3;
	public static final int IN_greenForPed = 4;
	public static final int MSG_MAX = 5;


	private static String messageStrings[] = {"MIN", "greenForCarDone","greenForPedDone", "greenForCar","greenForPed","MAX"};

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
	static public class PTrafficLightPort extends PortBase {
		// constructors
		public PTrafficLightPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTrafficLightPort(IEventReceiver actor, String name, int localId, int idx) {
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
		public void greenForCarDone() {
			if (messageStrings[ OUT_greenForCarDone] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_greenForCarDone]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_greenForCarDone));
				}
		public void greenForPedDone() {
			if (messageStrings[ OUT_greenForPedDone] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_greenForPedDone]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_greenForPedDone));
				}
	}
	
	// replicated port class
	static public class PTrafficLightReplPort extends ReplicatedPortBase {
	
		public PTrafficLightReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTrafficLightPort get(int idx) {
			return (PTrafficLightPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PTrafficLightPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void greenForCarDone(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).greenForCarDone();
			}
		}
		public void greenForPedDone(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).greenForPedDone();
			}
		}
	}
	
	
	// port class
	static public class PTrafficLightConjPort extends PortBase {
		// constructors
		public PTrafficLightConjPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTrafficLightConjPort(IEventReceiver actor, String name, int localId, int idx) {
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
		public void greenForCar() {
			if (messageStrings[ IN_greenForCar] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_greenForCar]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_greenForCar));
				}
		public void greenForPed() {
			if (messageStrings[ IN_greenForPed] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_greenForPed]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_greenForPed));
				}
	}
	
	// replicated port class
	static public class PTrafficLightConjReplPort extends ReplicatedPortBase {
	
		public PTrafficLightConjReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTrafficLightConjPort get(int idx) {
			return (PTrafficLightConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PTrafficLightConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void greenForCar(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).greenForCar();
			}
		}
		public void greenForPed(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).greenForPed();
			}
		}
	}
	
}
