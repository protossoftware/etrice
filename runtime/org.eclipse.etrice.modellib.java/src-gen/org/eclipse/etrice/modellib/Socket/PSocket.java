package org.eclipse.etrice.modellib.Socket;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class PSocket {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_connected = 1;
	public static final int OUT_disconnected = 2;
	public static final int OUT_receivedData = 3;
	public static final int OUT_sentData = 4;
	public static final int OUT_error = 5;
	public static final int IN_connect = 6;
	public static final int IN_disconnect = 7;
	public static final int IN_sendData = 8;
	public static final int MSG_MAX = 9;


	private static String messageStrings[] = {"MIN", "connected","disconnected","receivedData","sentData","error", "connect","disconnect","sendData","MAX"};

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
	static public class PSocketPort extends PortBase {
		// constructors
		public PSocketPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PSocketPort(IEventReceiver actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
				}
		}
	
		
		// sent messages
		public void connected() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_connected));
				}
		public void disconnected() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_disconnected));
				}
		public void receivedData() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_receivedData));
				}
		public void sentData() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_sentData));
				}
		public void error() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_error));
				}
	}
	
	// replicated port class
	static public class PSocketReplPort extends ReplicatedPortBase {
	
		public PSocketReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PSocketPort get(int idx) {
			return (PSocketPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PSocketPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void connected(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).connected();
			}
		}
		public void disconnected(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).disconnected();
			}
		}
		public void receivedData(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).receivedData();
			}
		}
		public void sentData(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).sentData();
			}
		}
		public void error(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).error();
			}
		}
	}
	
	
	// port class
	static public class PSocketConjPort extends PortBase {
		// constructors
		public PSocketConjPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PSocketConjPort(IEventReceiver actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
				}
		}
	
		
		// sent messages
		public void connect(DSocketConfiguration config) {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_connect, config.deepCopy()));
		}
		public void connect(String serverName, int portNumber, int protocol, boolean checkCookie, int mode) {
			connect(new DSocketConfiguration(serverName, portNumber, protocol, checkCookie, mode));
		}
		public void disconnect() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_disconnect));
				}
		public void sendData(DSocketData data) {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_sendData, data.deepCopy()));
		}
		public void sendData(int size, String data) {
			sendData(new DSocketData(size, data));
		}
	}
	
	// replicated port class
	static public class PSocketConjReplPort extends ReplicatedPortBase {
	
		public PSocketConjReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PSocketConjPort get(int idx) {
			return (PSocketConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PSocketConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void connect(DSocketConfiguration config){
			for (int i=0; i<getReplication(); ++i) {
				get(i).connect( config);
			}
		}
		public void disconnect(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).disconnect();
			}
		}
		public void sendData(DSocketData data){
			for (int i=0; i<getReplication(); ++i) {
				get(i).sendData( data);
			}
		}
	}
	
}
