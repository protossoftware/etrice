package trafficlight.example;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



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
		public PTrafficLightPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTrafficLightPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
					System.out.println("unknown");
				else {
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
			if (messageStrings[ OUT_greenForCarDone] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_greenForCarDone]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_greenForCarDone));
				}
		public void greenForPedDone() {
			if (messageStrings[ OUT_greenForPedDone] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_greenForPedDone]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_greenForPedDone));
				}
	}
	
	// replicated port class
	static public class PTrafficLightReplPort {
		private ArrayList<PTrafficLightPort> ports;
		private int replication;
	
		public PTrafficLightReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTrafficLight.PTrafficLightPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTrafficLightPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTrafficLightPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void greenForCarDone(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).greenForCarDone();
			}
		}
		public void greenForPedDone(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).greenForPedDone();
			}
		}
	}
	
	
	// port class
	static public class PTrafficLightConjPort extends PortBase {
		// constructors
		public PTrafficLightConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTrafficLightConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
					System.out.println("unknown");
				else {
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
			if (messageStrings[ IN_greenForCar] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_greenForCar]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_greenForCar));
				}
		public void greenForPed() {
			if (messageStrings[ IN_greenForPed] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_greenForPed]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_greenForPed));
				}
	}
	
	// replicated port class
	static public class PTrafficLightConjReplPort {
		private ArrayList<PTrafficLightConjPort> ports;
		private int replication;
	
		public PTrafficLightConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTrafficLight.PTrafficLightConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTrafficLightConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTrafficLightConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void greenForCar(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).greenForCar();
			}
		}
		public void greenForPed(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).greenForPed();
			}
		}
	}
	
}
