package room.basic.service.timing;

import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.modelbase.PortBase;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedPortBase;
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
		public PTimerPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTimerPort(IEventReceiver actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
			// initialize attributes
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
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
		//--------------------- attribute setters and getters
		/*--------------------- operations ---------------------*/
		
		// sent messages
		public void timeout() {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_timeout));
				}
		private void internalTimeout(TimerData td) {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_internalTimeout, td.deepCopy()));
		}
		public void internalTimeout(int time, int id) {
			internalTimeout(new TimerData(time, id));
		}
	}
	
	// replicated port class
	static public class PTimerReplPort extends ReplicatedPortBase {
	
		public PTimerReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimerPort get(int idx) {
			return (PTimerPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PTimerPort(rcv, name, lid, idx);
		}
		
		// outgoing messages
		public void timeout(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).timeout();
			}
		}
		private void internalTimeout(TimerData td){
			for (int i=0; i<getReplication(); ++i) {
				get(i).internalTimeout( td);
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
		public PTimerConjPort(IEventReceiver actor, String name, int localId) {
			this(actor, name, localId, 0);
		}
		public PTimerConjPort(IEventReceiver actor, String name, int localId, int idx) {
			super(actor, name, localId, idx);
			// initialize attributes
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (0 < msg.getEvtId() && msg.getEvtId() < MSG_MAX) {
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
		//--------------------- attribute setters and getters
		/*--------------------- operations ---------------------*/
		public void startTimer(int time_ms) {
			
							if (active) return;
							active = true;
			
							getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStartTimer, new TimerData(time_ms,++currentId)));
		}
		public void startTimeout(int time_ms) {
			
							if (active) return;
							active = true;
			
							getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStartTimeout, new TimerData(time_ms,++currentId)));
		}
		
		// sent messages
		public void kill() {
				//conjugate PortClass kill
							if (active) {
								active = false;
								TimerData td = new TimerData();
								td.setId(currentId);
								getPeerMsgReceiver().receive(
										new EventWithDataMessage(getPeerAddress(), IN_kill, td));
							}
		}
		private void internalStartTimer(TimerData td) {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStartTimer, td.deepCopy()));
		}
		public void internalStartTimer(int time, int id) {
			internalStartTimer(new TimerData(time, id));
		}
		private void internalStartTimeout(TimerData td) {
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_internalStartTimeout, td.deepCopy()));
		}
		public void internalStartTimeout(int time, int id) {
			internalStartTimeout(new TimerData(time, id));
		}
	}
	
	// replicated port class
	static public class PTimerConjReplPort extends ReplicatedPortBase {
	
		public PTimerConjReplPort(IEventReceiver actor, String name, int localId) {
			super(actor, name, localId);
		}
		
		public int getReplication() {
			return getNInterfaceItems();
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PTimerConjPort get(int idx) {
			return (PTimerConjPort) getInterfaceItem(idx);
		}
		
		protected InterfaceItemBase createInterfaceItem(IEventReceiver rcv, String name, int lid, int idx) {
			return new PTimerConjPort(rcv, name, lid, idx);
		}
		
		// incoming messages
		public void kill(){
			for (int i=0; i<getReplication(); ++i) {
				get(i).kill();
			}
		}
		private void internalStartTimer(TimerData td){
			for (int i=0; i<getReplication(); ++i) {
				get(i).internalStartTimer( td);
			}
		}
		private void internalStartTimeout(TimerData td){
			for (int i=0; i<getReplication(); ++i) {
				get(i).internalStartTimeout( td);
			}
		}
	}
	
}
