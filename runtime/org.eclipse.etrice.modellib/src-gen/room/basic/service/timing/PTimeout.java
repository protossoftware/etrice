package room.basic.service.timing;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;

/*--------------------- begin user code ---------------------*/
	import java.util.TimerTask;
/*--------------------- end user code ---------------------*/


public class PTimeout {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_timeoutTick = 1;
	public static final int OUT_internalTimeout = 2;
	public static final int IN_Kill = 3;
	public static final int IN_internalStart = 4;
	public static final int MSG_MAX = 5;

	/*--------------------- begin user code ---------------------*/
		static protected class FireTimeoutTask extends TimerTask {
		
					private int time;
					private int id;
					private PTimeoutPort port;
		
					public FireTimeoutTask(int time, int id, PTimeoutPort port) {
						this.time = time;
						this.id = id;
						this.port = port;
					}
		
					@Override
					public void run() {
						TimerData td = new TimerData(0,id);
						port.internalTimeout(td);
					}
					
					public int getTime() {
						return time;
					}
					
					public int getId() {
						return id;
					}
				}
	/*--------------------- end user code ---------------------*/

	private static String messageStrings[] = {"MIN", "timeoutTick","internalTimeout", "Kill","internalStart","MAX"};

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
	static public class PTimeoutPort extends PortBase {
		/*--------------------- begin user code ---------------------*/
			private FireTimeoutTask task = null;
						
						public TimerTask getTask() { return task; }
		/*--------------------- end user code ---------------------*/
		// constructors
		public PTimeoutPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTimeoutPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
					switch (msg.getEvtId()) {
						case IN_internalStart:
						{
							
											EventWithDataMessage dataMsg = (EventWithDataMessage) msg;
											TimerData td = (TimerData)dataMsg.getData();
											task = new FireTimeoutTask(td.time, td.id, this);
											getActor().receiveEvent(this, IN_internalStart, td);
						}
						break;
						case IN_Kill:
						{
							//regular PortClass handle kill
											EventWithDataMessage dataMsg = (EventWithDataMessage) msg;
											TimerData td = (TimerData)dataMsg.getData();
											if (task!=null && task.getId()==td.getId()) {
												task.cancel();
											}
						}
						break;
						default:
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
					}
				}
		}
	
		/*--------------------- attributes ---------------------*/
		/*--------------------- operations ---------------------*/
		
		// sent messages
		public void timeoutTick() {
			if (messageStrings[ OUT_timeoutTick] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_timeoutTick]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_timeoutTick));
				}
		private void internalTimeout(TimerData td) {
			if (messageStrings[ OUT_internalTimeout] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_internalTimeout]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_internalTimeout, td.deepCopy()));
		}
		public void internalTimeout(int time, int id) {
			internalTimeout(new TimerData(time, id));
		}
	}
	
	// replicated port class
	static public class PTimeoutReplPort {
		private ArrayList<PTimeoutPort> ports;
		private int replication;
	
		public PTimeoutReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTimeout.PTimeoutPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTimeoutPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimeoutPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void timeoutTick(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).timeoutTick();
			}
		}
		private void internalTimeout(TimerData td){
			for (int i=0; i<replication; ++i) {
				ports.get(i).internalTimeout( td);
			}
		}
	}
	
	
	// port class
	static public class PTimeoutConjPort extends PortBase {
		/*--------------------- begin user code ---------------------*/
			private int currentId = 0;
					private boolean active = false;
		/*--------------------- end user code ---------------------*/
		// constructors
		public PTimeoutConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTimeoutConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
					switch (msg.getEvtId()) {
						case OUT_internalTimeout:
						{
							//conjugate PortClass handle timeout
											EventWithDataMessage dataMsg = (EventWithDataMessage) msg;
											TimerData td = (TimerData) dataMsg.getData();
											if (active && td.getId()==currentId) {
												active = false;
												getActor().receiveEvent(this, OUT_timeoutTick, null);
											}
						}
						break;
						default:
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
					}
				}
		}
	
		/*--------------------- attributes ---------------------*/
		/*--------------------- operations ---------------------*/
		public void Start(int time_ms) {
			
							if (active) return;
							active = true;
			
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_internalStart]);
							getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStart, new TimerData(time_ms,++currentId)));
		}
		
		// sent messages
		public void Kill() {
				//conjugate PortClass kill
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(),
									getPeerAddress(), messageStrings[IN_Kill]);
				
							if (active) {
								active = false;
								TimerData td = new TimerData();
								td.setId(currentId);
								getPeerMsgReceiver().receive(
										new EventWithDataMessage(getPeerAddress(), IN_Kill, td));
							}
		}
		private void internalStart(TimerData td) {
			if (messageStrings[ IN_internalStart] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_internalStart]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStart, td.deepCopy()));
		}
		public void internalStart(int time, int id) {
			internalStart(new TimerData(time, id));
		}
	}
	
	// replicated port class
	static public class PTimeoutConjReplPort {
		private ArrayList<PTimeoutConjPort> ports;
		private int replication;
	
		public PTimeoutConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTimeout.PTimeoutConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTimeoutConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimeoutConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void Kill(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).Kill();
			}
		}
		private void internalStart(TimerData td){
			for (int i=0; i<replication; ++i) {
				ports.get(i).internalStart( td);
			}
		}
	}
	
}
