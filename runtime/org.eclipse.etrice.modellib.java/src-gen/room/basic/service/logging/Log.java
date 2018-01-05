package room.basic.service.logging;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IInterfaceItemOwner;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;



public class Log {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int IN_open = 1;
	public static final int IN_close = 2;
	public static final int IN_internalLog = 3;
	public static final int MSG_MAX = 4;

	/*--------------------- begin user code ---------------------*/
	public static final int LOG_LEVEL_LOW = 1;
	public static final int LOG_LEVEL_MEDIUM = 2;
	public static final int LOG_LEVEL_HIGH = 3;
	/*--------------------- end user code ---------------------*/

	private static String messageStrings[] = {"MIN",  "open","close","internalLog","MAX"};

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
	static public class LogPort extends PortBase {
		// constructors
		public LogPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public LogPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
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
	}
	
	// replicated port class
	static public class LogReplPort extends ReplicatedPortBase {
	
		public LogReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
	
		public int getReplication() {
			return getNInterfaceItems();
		}
	
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
		}
	
		public LogPort get(int idx) {
			return (LogPort) getInterfaceItem(idx);
		}
	
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new LogPort(rcv, name, lid, idx);
		}
	
		// outgoing messages
	}
	
	
	// port class
	static public class LogConjPort extends PortBase {
		/*--------------------- begin user code ---------------------*/
		static int logLevel=0;
		InternalLogData d = new InternalLogData();
		/*--------------------- end user code ---------------------*/
		// constructors
		public LogConjPort(IInterfaceItemOwner actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public LogConjPort(IInterfaceItemOwner actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
			// initialize attributes
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
	
		/*--------------------- attributes ---------------------*/
		/* --------------------- attribute setters and getters */
		/*--------------------- operations ---------------------*/
		public  void setLogLevel(int l) {
			logLevel=l;
			if (logLevel > LOG_LEVEL_HIGH) logLevel=LOG_LEVEL_HIGH;
		}
		public  void log(int logLevel, String userString) {
			if (logLevel>LogConjPort.logLevel){
			d.userString=userString;
			d.timeStamp=System.currentTimeMillis();
			d.sender=getInstancePath();
			if (getPeerAddress()!=null)
			getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalLog, d.deepCopy()));
			}
		}
	
		// sent messages
		public void open(String transitionData) {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_open]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_open, transitionData));
		}
		public void close() {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_close]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_close));
		}
		private void internalLog(InternalLogData transitionData) {
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_internalLog]);
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalLog, transitionData.deepCopy()));
		}
		public void internalLog(String userString, String sender, long timeStamp) {
			internalLog(new InternalLogData(userString, sender, timeStamp));
		}
	}
	
	// replicated port class
	static public class LogConjReplPort extends ReplicatedPortBase {
	
		public LogConjReplPort(IInterfaceItemOwner actor, String name, int localId) {
			super(actor, name, localId);
		}
	
		public int getReplication() {
			return getNInterfaceItems();
		}
	
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
		}
	
		public LogConjPort get(int idx) {
			return (LogConjPort) getInterfaceItem(idx);
		}
	
		protected InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx) {
			return new LogConjPort(rcv, name, lid, idx);
		}
	
		// incoming messages
		public void open(String transitionData){
			for (InterfaceItemBase item : getItems()) {
				((LogConjPort)item).open( transitionData);
			}
		}
		public void close(){
			for (InterfaceItemBase item : getItems()) {
				((LogConjPort)item).close();
			}
		}
		private void internalLog(InternalLogData transitionData){
			for (InterfaceItemBase item : getItems()) {
				((LogConjPort)item).internalLog( transitionData);
			}
		}
	}
	
}
