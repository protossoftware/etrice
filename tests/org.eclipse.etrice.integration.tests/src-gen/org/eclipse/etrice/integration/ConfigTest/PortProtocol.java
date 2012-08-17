package org.eclipse.etrice.integration.ConfigTest;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;

/*--------------------- begin user code ---------------------*/
import org.eclipse.etrice.runtime.java.messaging.RTServices;
/*--------------------- end user code ---------------------*/


public class PortProtocol {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_conjCheck = 1;
	public static final int IN_portTestSucc = 2;
	public static final int MSG_MAX = 3;


	private static String messageStrings[] = {"MIN", "conjCheck", "portTestSucc","MAX"};

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
	static public class PortProtocolPort extends PortBase {
		// constructors
		public PortProtocolPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PortProtocolPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			// initialize attributes
			float_r = 4;
			float_c = 3;
			float_i = 9;
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
	
		/*--------------------- attributes ---------------------*/
		float float_r;
		float float_c;
		float float_i;
		// TODO JH: Avoid collision attr getters/setter <-> user operations
		//--------------------- attribute setters and getters
		public void setFloat_r (float float_r) {
			 this.float_r = float_r;
		}
		public float getFloat_r () {
			return this.float_r;
		}
		public void setFloat_c (float float_c) {
			 this.float_c = float_c;
		}
		public float getFloat_c () {
			return this.float_c;
		}
		public void setFloat_i (float float_i) {
			 this.float_i = float_i;
		}
		public float getFloat_i () {
			return this.float_i;
		}
		/*--------------------- operations ---------------------*/
		public boolean varCheck() {
			int testValue = 0;
			if(float_r != 4 || float_c != 3 || float_i != 25)
				testValue = 20;
			if(testValue != 0)
				RTServices.getInstance().getSubSystem().testFinished(testValue);
			return testValue == 0;
		}
		
		// sent messages
		public void conjCheck() {
			if (messageStrings[ OUT_conjCheck] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_conjCheck]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_conjCheck));
				}
	}
	
	// replicated port class
	static public class PortProtocolReplPort {
		private ArrayList<PortProtocolPort> ports;
		private int replication;
	
		public PortProtocolReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PortProtocol.PortProtocolPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PortProtocolPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PortProtocolPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void conjCheck(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).conjCheck();
			}
		}
	}
	
	
	// port class
	static public class PortProtocolConjPort extends PortBase {
		// constructors
		public PortProtocolConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PortProtocolConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			// initialize attributes
			array1_r = new float[1];
			for (int i=0;i<1;i++){
				array1_r[i] = 1000;
			}
			array1_c = new float[1];
			for (int i=0;i<1;i++){
				array1_c[i] = 1;
			}
			array1_i = new float[1];
			for (int i=0;i<1;i++){
				array1_i[i] = 2;
			}
			array2_r = new long[] {11,22};
			array2_c = new long[] { 16, 32 };
			array2_i = new long[] { 16, 32 };
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
	
		/*--------------------- attributes ---------------------*/
		float array1_r[];
		float array1_c[];
		float array1_i[];
		long array2_r[];
		long array2_c[];
		long array2_i[];
		// TODO JH: Avoid collision attr getters/setter <-> user operations
		//--------------------- attribute setters and getters
		public void setArray1_r (float[] array1_r) {
			 this.array1_r = array1_r;
		}
		public float[] getArray1_r () {
			return this.array1_r;
		}
		public void setArray1_c (float[] array1_c) {
			 this.array1_c = array1_c;
		}
		public float[] getArray1_c () {
			return this.array1_c;
		}
		public void setArray1_i (float[] array1_i) {
			 this.array1_i = array1_i;
		}
		public float[] getArray1_i () {
			return this.array1_i;
		}
		public void setArray2_r (long[] array2_r) {
			 this.array2_r = array2_r;
		}
		public long[] getArray2_r () {
			return this.array2_r;
		}
		public void setArray2_c (long[] array2_c) {
			 this.array2_c = array2_c;
		}
		public long[] getArray2_c () {
			return this.array2_c;
		}
		public void setArray2_i (long[] array2_i) {
			 this.array2_i = array2_i;
		}
		public long[] getArray2_i () {
			return this.array2_i;
		}
		/*--------------------- operations ---------------------*/
		public boolean varCheck() {
			int testValue = 0;
			if(array1_r[0] != 1000 || array1_c[0] != 1 || array1_i[0] != 256)
				testValue = 10;
			if(array2_r[0] != 11 || array2_r[1] != 22)
				testValue = 11;
			if(array2_c[0] != 16 || array2_c[1] != 32)
				testValue = 12;
			if(array2_i[0] != 1 || array2_i[1] != 2)
				testValue = 13;
			if(testValue != 0)
				RTServices.getInstance().getSubSystem().testFinished(testValue);
			return testValue == 0;
		}
		
		// sent messages
		public void portTestSucc() {
			if (messageStrings[ IN_portTestSucc] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_portTestSucc]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_portTestSucc));
				}
	}
	
	// replicated port class
	static public class PortProtocolConjReplPort {
		private ArrayList<PortProtocolConjPort> ports;
		private int replication;
	
		public PortProtocolConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<PortProtocol.PortProtocolConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PortProtocolConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PortProtocolConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void portTestSucc(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).portTestSucc();
			}
		}
	}
	
}
