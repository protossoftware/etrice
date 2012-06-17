package org.eclipse.etrice.integration.tests;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class p_HFSM {
	// message IDs
	public static final int MSG_MIN = 0;
	public static final int OUT_init_action = 1;
	public static final int OUT_s1_entry = 2;
	public static final int OUT_s1_exit = 3;
	public static final int OUT_s2_entry = 4;
	public static final int OUT_s2_exit = 5;
	public static final int OUT_s3_entry = 6;
	public static final int OUT_s3_exit = 7;
	public static final int OUT_s4_entry = 8;
	public static final int OUT_s4_exit = 9;
	public static final int OUT_s2s1_entry = 10;
	public static final int OUT_s2s1_exit = 11;
	public static final int OUT_s2s2_entry = 12;
	public static final int OUT_s2s2_exit = 13;
	public static final int OUT_s1_m1_s2_action = 14;
	public static final int OUT_s2_m1_s2s1_action = 15;
	public static final int OUT_s2s1_m2_s2s2_action = 16;
	public static final int OUT_s2s2_m3_action = 17;
	public static final int OUT_s2_m4_s4_action = 18;
	public static final int OUT_s2_m5_s2_action = 19;
	public static final int OUT_s2_m6_s2_action = 20;
	public static final int OUT_s2__s3_action = 21;
	public static final int OUT_s2_m7_s2_action = 22;
	public static final int OUT_top_s8_top_action = 23;
	public static final int OUT_top_s9_top_action = 24;
	public static final int OUT_top_reset_s2_action = 25;
	public static final int IN_m1 = 26;
	public static final int IN_m2 = 27;
	public static final int IN_m3 = 28;
	public static final int IN_m4 = 29;
	public static final int IN_m5 = 30;
	public static final int IN_m6 = 31;
	public static final int IN_reset = 32;
	public static final int IN_m7 = 33;
	public static final int IN_m8 = 34;
	public static final int IN_m9 = 35;
	public static final int MSG_MAX = 36;


	private static String messageStrings[] = {"MIN", "init_action","s1_entry","s1_exit","s2_entry","s2_exit","s3_entry","s3_exit","s4_entry","s4_exit","s2s1_entry","s2s1_exit","s2s2_entry","s2s2_exit","s1_m1_s2_action","s2_m1_s2s1_action","s2s1_m2_s2s2_action","s2s2_m3_action","s2_m4_s4_action","s2_m5_s2_action","s2_m6_s2_action","s2__s3_action","s2_m7_s2_action","top_s8_top_action","top_s9_top_action","top_reset_s2_action", "m1","m2","m3","m4","m5","m6","reset","m7","m8","m9","MAX"};

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
	static public class p_HFSMPort extends PortBase {
		// constructors
		public p_HFSMPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public p_HFSMPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void init_action() {
			if (messageStrings[ OUT_init_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_init_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_init_action));
				}
		public void s1_entry() {
			if (messageStrings[ OUT_s1_entry] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s1_entry]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s1_entry));
				}
		public void s1_exit() {
			if (messageStrings[ OUT_s1_exit] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s1_exit]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s1_exit));
				}
		public void s2_entry() {
			if (messageStrings[ OUT_s2_entry] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2_entry]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2_entry));
				}
		public void s2_exit() {
			if (messageStrings[ OUT_s2_exit] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2_exit]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2_exit));
				}
		public void s3_entry() {
			if (messageStrings[ OUT_s3_entry] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s3_entry]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s3_entry));
				}
		public void s3_exit() {
			if (messageStrings[ OUT_s3_exit] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s3_exit]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s3_exit));
				}
		public void s4_entry() {
			if (messageStrings[ OUT_s4_entry] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s4_entry]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s4_entry));
				}
		public void s4_exit() {
			if (messageStrings[ OUT_s4_exit] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s4_exit]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s4_exit));
				}
		public void s2s1_entry() {
			if (messageStrings[ OUT_s2s1_entry] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2s1_entry]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2s1_entry));
				}
		public void s2s1_exit() {
			if (messageStrings[ OUT_s2s1_exit] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2s1_exit]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2s1_exit));
				}
		public void s2s2_entry() {
			if (messageStrings[ OUT_s2s2_entry] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2s2_entry]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2s2_entry));
				}
		public void s2s2_exit() {
			if (messageStrings[ OUT_s2s2_exit] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2s2_exit]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2s2_exit));
				}
		public void s1_m1_s2_action() {
			if (messageStrings[ OUT_s1_m1_s2_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s1_m1_s2_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s1_m1_s2_action));
				}
		public void s2_m1_s2s1_action() {
			if (messageStrings[ OUT_s2_m1_s2s1_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2_m1_s2s1_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2_m1_s2s1_action));
				}
		public void s2s1_m2_s2s2_action() {
			if (messageStrings[ OUT_s2s1_m2_s2s2_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2s1_m2_s2s2_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2s1_m2_s2s2_action));
				}
		public void s2s2_m3_action() {
			if (messageStrings[ OUT_s2s2_m3_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2s2_m3_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2s2_m3_action));
				}
		public void s2_m4_s4_action() {
			if (messageStrings[ OUT_s2_m4_s4_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2_m4_s4_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2_m4_s4_action));
				}
		public void s2_m5_s2_action() {
			if (messageStrings[ OUT_s2_m5_s2_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2_m5_s2_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2_m5_s2_action));
				}
		public void s2_m6_s2_action() {
			if (messageStrings[ OUT_s2_m6_s2_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2_m6_s2_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2_m6_s2_action));
				}
		public void s2__s3_action() {
			if (messageStrings[ OUT_s2__s3_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2__s3_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2__s3_action));
				}
		public void s2_m7_s2_action() {
			if (messageStrings[ OUT_s2_m7_s2_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_s2_m7_s2_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_s2_m7_s2_action));
				}
		public void top_s8_top_action() {
			if (messageStrings[ OUT_top_s8_top_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_top_s8_top_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_top_s8_top_action));
				}
		public void top_s9_top_action() {
			if (messageStrings[ OUT_top_s9_top_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_top_s9_top_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_top_s9_top_action));
				}
		public void top_reset_s2_action() {
			if (messageStrings[ OUT_top_reset_s2_action] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_top_reset_s2_action]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_top_reset_s2_action));
				}
	}
	
	// replicated port class
	static public class p_HFSMReplPort {
		private ArrayList<p_HFSMPort> ports;
		private int replication;
	
		public p_HFSMReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<p_HFSM.p_HFSMPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new p_HFSMPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public p_HFSMPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void init_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).init_action();
			}
		}
		public void s1_entry(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s1_entry();
			}
		}
		public void s1_exit(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s1_exit();
			}
		}
		public void s2_entry(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2_entry();
			}
		}
		public void s2_exit(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2_exit();
			}
		}
		public void s3_entry(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s3_entry();
			}
		}
		public void s3_exit(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s3_exit();
			}
		}
		public void s4_entry(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s4_entry();
			}
		}
		public void s4_exit(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s4_exit();
			}
		}
		public void s2s1_entry(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2s1_entry();
			}
		}
		public void s2s1_exit(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2s1_exit();
			}
		}
		public void s2s2_entry(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2s2_entry();
			}
		}
		public void s2s2_exit(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2s2_exit();
			}
		}
		public void s1_m1_s2_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s1_m1_s2_action();
			}
		}
		public void s2_m1_s2s1_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2_m1_s2s1_action();
			}
		}
		public void s2s1_m2_s2s2_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2s1_m2_s2s2_action();
			}
		}
		public void s2s2_m3_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2s2_m3_action();
			}
		}
		public void s2_m4_s4_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2_m4_s4_action();
			}
		}
		public void s2_m5_s2_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2_m5_s2_action();
			}
		}
		public void s2_m6_s2_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2_m6_s2_action();
			}
		}
		public void s2__s3_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2__s3_action();
			}
		}
		public void s2_m7_s2_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).s2_m7_s2_action();
			}
		}
		public void top_s8_top_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).top_s8_top_action();
			}
		}
		public void top_s9_top_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).top_s9_top_action();
			}
		}
		public void top_reset_s2_action(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).top_reset_s2_action();
			}
		}
	}
	
	
	// port class
	static public class p_HFSMConjPort extends PortBase {
		// constructors
		public p_HFSMConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			this(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public p_HFSMConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void m1() {
			if (messageStrings[ IN_m1] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_m1]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_m1));
				}
		public void m2() {
			if (messageStrings[ IN_m2] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_m2]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_m2));
				}
		public void m3() {
			if (messageStrings[ IN_m3] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_m3]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_m3));
				}
		public void m4() {
			if (messageStrings[ IN_m4] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_m4]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_m4));
				}
		public void m5() {
			if (messageStrings[ IN_m5] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_m5]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_m5));
				}
		public void m6() {
			if (messageStrings[ IN_m6] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_m6]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_m6));
				}
		public void reset() {
			if (messageStrings[ IN_reset] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_reset]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_reset));
				}
		public void m7() {
			if (messageStrings[ IN_m7] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_m7]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_m7));
				}
		public void m8() {
			if (messageStrings[ IN_m8] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_m8]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_m8));
				}
		public void m9() {
			if (messageStrings[ IN_m9] != "timerTick"){
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_m9]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_m9));
				}
	}
	
	// replicated port class
	static public class p_HFSMConjReplPort {
		private ArrayList<p_HFSMConjPort> ports;
		private int replication;
	
		public p_HFSMConjReplPort(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr==null? 0:addr.length;
			ports = new ArrayList<p_HFSM.p_HFSMConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new p_HFSMConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public p_HFSMConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void m1(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).m1();
			}
		}
		public void m2(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).m2();
			}
		}
		public void m3(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).m3();
			}
		}
		public void m4(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).m4();
			}
		}
		public void m5(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).m5();
			}
		}
		public void m6(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).m6();
			}
		}
		public void reset(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).reset();
			}
		}
		public void m7(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).m7();
			}
		}
		public void m8(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).m8();
			}
		}
		public void m9(){
			for (int i=0; i<replication; ++i) {
				ports.get(i).m9();
			}
		}
	}
	
}
