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



public class PMqtt {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_connected = 1;
	public static final int IN_connect = 2;
	public static final int IN_publish = 3;
	public static final int MSG_MAX = 4;


	private static String messageStrings[] = {"MIN", "connected", "connect","publish","MAX"};

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
	static public class PMqttPort extends PortBase {
		// constructors
		public PMqttPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PMqttPort(IEventReceiver actor, String name, int localId, int idx) {
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
		public void connected() {
			if (messageStrings[ OUT_connected] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_connected]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_connected));
				}
	}
	
	// replicated port class
	static public class PMqttReplPort extends ReplicatedPortBase {
	
		public PMqttReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PMqttPort get(int idx) {
			return (PMqttPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PMqttPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void connected(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).connected();
			}
		}
	}
	
	
	// port class
	static public class PMqttConjPort extends PortBase {
		// constructors
		public PMqttConjPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PMqttConjPort(IEventReceiver actor, String name, int localId, int idx) {
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
		public void connect(DMqttConfig config) {
			if (messageStrings[ IN_connect] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_connect]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_connect, config.deepCopy()));
		}
		public void connect(String url, String id) {
			connect(new DMqttConfig(url, id));
		}
		public void publish(DMqttMessage message) {
			if (messageStrings[ IN_publish] != "timerTick") {
				DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_publish]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_publish, message.deepCopy()));
		}
		public void publish(String topic, String payload, boolean retained, int qos) {
			publish(new DMqttMessage(topic, payload, retained, qos));
		}
	}
	
	// replicated port class
	static public class PMqttConjReplPort extends ReplicatedPortBase {
	
		public PMqttConjReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PMqttConjPort get(int idx) {
			return (PMqttConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PMqttConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void connect(DMqttConfig config){
			for (int i=0; i<getReplication(); ++i) {
				get(i).connect( config);
			}
		}
		public void publish(DMqttMessage message){
			for (int i=0; i<getReplication(); ++i) {
				get(i).publish( message);
			}
		}
	}
	
}
