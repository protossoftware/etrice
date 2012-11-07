package room.basic.service.timing;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

/*--------------------- begin user code ---------------------*/
import java.util.TimerTask;
/*--------------------- end user code ---------------------*/


public class PTimer {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_timeout = 1;
	public static final int OUT_internalTimeout = 2;
	public static final int IN_kill = 3;
	public static final int IN_internalStartTimer = 4;
	public static final int IN_internalStartTimeout = 5;
	public static final int MSG_MAX = 6;

	/*--------------------- begin user code ---------------------*/
	static protected class FireTimeoutTask extends TimerTask {
		
					private int time;
					private int id;
					private PTimerPort port;
		
					public FireTimeoutTask(int time, int id, PTimerPort port) {
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

	private static String messageStrings[] = {"MIN", "timeout","internalTimeout", "kill","internalStartTimer","internalStartTimeout","MAX"};

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
	static public class PTimerPort extends PortBase {
		/*--------------------- begin user code ---------------------*/
		private FireTimeoutTask task = null;
						
						public TimerTask getTask() { return task; }
		/*--------------------- end user code ---------------------*/
		// constructors
		public PTimerPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTimerPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			// initialize attributes
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
						case IN_internalStartTimer:
						{
							
											EventWithDataMessage dataMsg = (EventWithDataMessage) msg;
											TimerData td = (TimerData)dataMsg.getData();
											task = new FireTimeoutTask(td.time, td.id, this);
											getActor().receiveEvent(this, IN_internalStartTimer, td);
						}
						break;
						case IN_internalStartTimeout:
						{
							
											EventWithDataMessage dataMsg = (EventWithDataMessage) msg;
											TimerData td = (TimerData)dataMsg.getData();
											task = new FireTimeoutTask(td.time, td.id, this);
											getActor().receiveEvent(this, IN_internalStartTimeout, td);
						}
						break;
						case IN_kill:
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
		// TODO JH: Avoid collision attr getters/setter <-> user operations
		//--------------------- attribute setters and getters
		/*--------------------- operations ---------------------*/
		
		// sent messages
		public void timeout() {
			if (messageStrings[ OUT_timeout] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_timeout]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_timeout));
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
	static public class PTimerReplPort {
		private ArrayList<PTimerPort> ports;
		private int replication;
	
		public PTimerReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTimer.PTimerPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTimerPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimerPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void timeout(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).timeout();
			}
		}
		private void internalTimeout(TimerData td){
			for (int i=0; i<replication; ++i) {
				ports.get(i).internalTimeout( td);
			}
		}
	}
	
	
	// port class
	static public class PTimerConjPort extends PortBase {
		/*--------------------- begin user code ---------------------*/
		private int currentId = 0;
					private boolean active = false;
		/*--------------------- end user code ---------------------*/
		// constructors
		public PTimerConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PTimerConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			// initialize attributes
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
												getActor().receiveEvent(this, OUT_timeout, null);
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
		// TODO JH: Avoid collision attr getters/setter <-> user operations
		//--------------------- attribute setters and getters
		/*--------------------- operations ---------------------*/
		public void startTimer(int time_ms) {
			
							if (active) return;
							active = true;
			
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_internalStartTimer]);
							getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStartTimer, new TimerData(time_ms,++currentId)));
		}
		public void startTimeout(int time_ms) {
			
							if (active) return;
							active = true;
			
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_internalStartTimeout]);
							getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStartTimeout, new TimerData(time_ms,++currentId)));
		}
		
		// sent messages
		public void kill() {
				//conjugate PortClass kill
							DebuggingService.getInstance().addMessageAsyncOut(getAddress(),
									getPeerAddress(), messageStrings[IN_kill]);
				
							if (active) {
								active = false;
								TimerData td = new TimerData();
								td.setId(currentId);
								getPeerMsgReceiver().receive(
										new EventWithDataMessage(getPeerAddress(), IN_kill, td));
							}
		}
		private void internalStartTimer(TimerData td) {
			if (messageStrings[ IN_internalStartTimer] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_internalStartTimer]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStartTimer, td.deepCopy()));
		}
		public void internalStartTimer(int time, int id) {
			internalStartTimer(new TimerData(time, id));
		}
		private void internalStartTimeout(TimerData td) {
			if (messageStrings[ IN_internalStartTimeout] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_internalStartTimeout]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStartTimeout, td.deepCopy()));
		}
		public void internalStartTimeout(int time, int id) {
			internalStartTimeout(new TimerData(time, id));
		}
	}
	
	// replicated port class
	static public class PTimerConjReplPort {
		private ArrayList<PTimerConjPort> ports;
		private int replication;
	
		public PTimerConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PTimer.PTimerConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PTimerConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimerConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void kill(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).kill();
			}
		}
		private void internalStartTimer(TimerData td){
			for (int i=0; i<replication; ++i) {
				ports.get(i).internalStartTimer( td);
			}
		}
		private void internalStartTimeout(TimerData td){
			for (int i=0; i<replication; ++i) {
				ports.get(i).internalStartTimeout( td);
			}
		}
	}
	
}
