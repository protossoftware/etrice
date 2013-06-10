package trafficlight.connector;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class PTrafficLightInterface {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_initialized = 1;
	public static final int OUT_request = 2;
	public static final int IN_initialize = 3;
	public static final int IN_pedRed = 4;
	public static final int IN_pedGreen = 5;
	public static final int IN_pedOff = 6;
	public static final int IN_carRed = 7;
	public static final int IN_carYellow = 8;
	public static final int IN_carGreen = 9;
	public static final int IN_carOff = 10;
	public static final int MSG_MAX = 11;


	private static String messageStrings[] = {"MIN", "initialized","request", "initialize","pedRed","pedGreen","pedOff","carRed","carYellow","carGreen","carOff","MAX"};

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
	static public class PTrafficLightInterfacePort extends PortBase {
		// constructors
		public PTrafficLightInterfacePort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTrafficLightInterfacePort(IEventReceiver actor, String name, int localId, int idx) {
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
		public void initialized() {
			if (messageStrings[ OUT_initialized] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_initialized]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_initialized));
				}
		public void request() {
			if (messageStrings[ OUT_request] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_request]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_request));
				}
	}
	
	// replicated port class
	static public class PTrafficLightInterfaceReplPort extends ReplicatedPortBase {
	
		public PTrafficLightInterfaceReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTrafficLightInterfacePort get(int idx) {
			return (PTrafficLightInterfacePort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PTrafficLightInterfacePort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void initialized(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).initialized();
			}
		}
		public void request(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).request();
			}
		}
	}
	
	
	// port class
	static public class PTrafficLightInterfaceConjPort extends PortBase {
		// constructors
		public PTrafficLightInterfaceConjPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTrafficLightInterfaceConjPort(IEventReceiver actor, String name, int localId, int idx) {
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
		public void initialize() {
			if (messageStrings[ IN_initialize] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_initialize]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_initialize));
				}
		public void pedRed() {
			if (messageStrings[ IN_pedRed] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_pedRed]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_pedRed));
				}
		public void pedGreen() {
			if (messageStrings[ IN_pedGreen] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_pedGreen]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_pedGreen));
				}
		public void pedOff() {
			if (messageStrings[ IN_pedOff] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_pedOff]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_pedOff));
				}
		public void carRed() {
			if (messageStrings[ IN_carRed] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_carRed]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_carRed));
				}
		public void carYellow() {
			if (messageStrings[ IN_carYellow] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_carYellow]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_carYellow));
				}
		public void carGreen() {
			if (messageStrings[ IN_carGreen] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_carGreen]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_carGreen));
				}
		public void carOff() {
			if (messageStrings[ IN_carOff] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_carOff]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_carOff));
				}
	}
	
	// replicated port class
	static public class PTrafficLightInterfaceConjReplPort extends ReplicatedPortBase {
	
		public PTrafficLightInterfaceConjReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTrafficLightInterfaceConjPort get(int idx) {
			return (PTrafficLightInterfaceConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PTrafficLightInterfaceConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void initialize(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).initialize();
			}
		}
		public void pedRed(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).pedRed();
			}
		}
		public void pedGreen(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).pedGreen();
			}
		}
		public void pedOff(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).pedOff();
			}
		}
		public void carRed(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).carRed();
			}
		}
		public void carYellow(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).carYellow();
			}
		}
		public void carGreen(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).carGreen();
			}
		}
		public void carOff(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).carOff();
			}
		}
	}
	
}
