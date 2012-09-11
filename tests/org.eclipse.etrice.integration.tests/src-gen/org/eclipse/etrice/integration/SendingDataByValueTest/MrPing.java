package org.eclipse.etrice.integration.SendingDataByValueTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.integration.SendingDataByValueTest.PingPongProtocol.*;

/*--------------------- begin user code ---------------------*/
import org.eclipse.etrice.integration.tests.helpers.*;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
/*--------------------- end user code ---------------------*/


public class MrPing extends ActorClassBase {

	/*--------------------- begin user code ---------------------*/
	private CRC16Generator crcGen = new CRC16Generator();
	/*--------------------- end user code ---------------------*/
	
	
	//--------------------- ports
	protected PingPongProtocolConjPort PingPongPort = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_PingPongPort = 1;

		
	/*--------------------- attributes ---------------------*/
	int i32Array[];
	PingPongData data;
	/*--------------------- operations ---------------------*/
	public void printData(PingPongData d) {
		System.out.printf("MrPing:\n");
		System.out.printf("i8Val: %d \n",d.getI8Val());
		System.out.printf("i16Val: %d \n",d.getI16Val());
		System.out.printf("i32Val: %d \n",d.getI32Val());
		System.out.printf("charVal: %c \n",d.getCharVal());
		System.out.printf("f32Val: %f \n",d.getF32Val());
		System.out.printf("f64Val: %f \n",d.getF64Val());
		System.out.printf("stringVal: %s \n",d.getStringVal());
		System.out.printf("i32Array: %d %d %d %d %d\n",d.getArrayFromInt32()[0],d.getArrayFromInt32()[1],d.getArrayFromInt32()[2],d.getArrayFromInt32()[3],d.getArrayFromInt32()[4] );
		System.out.printf("\n");
	}

	//--------------------- construction
	public MrPing(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("MrPing");
		
		// initialize attributes
		i32Array = new int[10];
		for (int i=0;i<10;i++){
			i32Array[i] = 0;
		}
		data = new PingPongData();

		// own ports
		PingPongPort = new PingPongProtocolConjPort(this, "PingPongPort", IFITEM_PingPongPort, 0, port_addr[IFITEM_PingPongPort][0], peer_addr[IFITEM_PingPongPort][0]); 
		
		// own saps
		
		// own service implementations
	}

	
	//--------------------- attribute setters and getters
	public void setI32Array (int[] i32Array) {
		 this.i32Array = i32Array;
	}
	public int[] getI32Array () {
		return this.i32Array;
	}
	public void setData (PingPongData data) {
		 this.data = data;
	}
	public PingPongData getData () {
		return this.data;
	}
	
	
	//--------------------- port getters
	public PingPongProtocolConjPort getPingPongPort (){
		return this.PingPongPort;
	}

	//--------------------- lifecycle functions
	public void init(){
		initUser();
	}

	public void start(){
		startUser();
	}

	public void stop(){
		stopUser();
	}
	
	public void destroy(){
	}

	
	/* state IDs */
	public static final int STATE_waitForPong = 2;
	public static final int STATE_state0 = 3;
	public static final int STATE_state1 = 4;
	public static final int STATE_state2 = 5;
	public static final int STATE_TestFalse = 6;
	public static final int STATE_TestOk = 7;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__waitForPong = 1;
	public static final int CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_pongPingPongPort_tr0 = 2;
	public static final int CHAIN_TRANS_tr10_FROM_waitForPong_TO_cp0_BY_pongPingPongPort = 3;
	public static final int CHAIN_TRANS_tr1_FROM_tp0_TO_tp0_BY_pongSimplePingPongPort_tr1 = 4;
	public static final int CHAIN_TRANS_tr5_FROM_state0_TO_state1_BY_pongPingPongPort = 5;
	public static final int CHAIN_TRANS_tr6_FROM_state1_TO_state2_BY_pongSimplePingPongPort = 6;
	public static final int CHAIN_TRANS_tr7_FROM_state2_TO_cp1_BY_pongSimplePingPongPort = 7;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_PingPongPort__pong = IFITEM_PingPongPort + EVT_SHIFT*PingPongProtocol.OUT_pong;
	public static final int TRIG_PingPongPort__pongSimple = IFITEM_PingPongPort + EVT_SHIFT*PingPongProtocol.OUT_pongSimple;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","waitForPong",
	"state0",
	"state1",
	"state2",
	"TestFalse",
	"TestOk"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_INITIAL_TO__waitForPong() {
		int i;
		int[] intArray;
		this.data=new PingPongData();
		
		// send default data
		PingPongData d = new PingPongData();
		PingPongPort.ping(d);
		
		d.setI8Val((byte) 45);
		d.setI16Val((short) 34);
		d.setI32Val(2);
		d.setF32Val((float)3.14);
		d.setF64Val(7.12345);
		d.setStringVal("Hase !");
		
		d.getOwnType().setI8Val((byte)10);
		d.getOwnType().setI16Val((short)17);
		d.getOwnType().setI32Val(4711);
		d.getOwnType().setF32Val((float)3.0815);
		d.getOwnType().setF64Val(123.45678);
		d.getOwnType().setStringVal("Deep Hase !");
		intArray = d.getOwnType().getArrayFromInt32();
		for (i=0;i<intArray.length;i++) {intArray[i] = 10+i;}
		d.getOwnType().setArrayFromInt32(intArray);
		
		PingPongPort.ping(d);
		
		d.setI8Val((byte) 55);
		d.setI16Val((short) 44);
		d.setI32Val(3);
		d.setF32Val((float)24.4563458);
		d.setF64Val(2347.2342312345);
		d.setStringVal("Mein Hase !");
		
		d.getOwnType().setI8Val((byte)15);
		d.getOwnType().setI16Val((short)23);
		d.getOwnType().setI32Val(4812);
		d.getOwnType().setF32Val((float)2453.30815);
		d.getOwnType().setF64Val(125332.42342);
		d.getOwnType().setStringVal("Mein Deep Hase !");
		intArray = d.getOwnType().getArrayFromInt32();
		for (i=0;i<intArray.length;i++) {intArray[i] = 30+i;}
		d.getOwnType().setArrayFromInt32(intArray);
		
		PingPongPort.ping(d);
		PingPongPort.ping(data);
		
		data.setI8Val((byte) 67);
		data.setI16Val((short) 97);
		data.setI32Val(70);
		data.setF32Val((float)233.14);
		data.setF64Val(723434.12345);
		data.setStringVal("Falscher Hase !");
		
		crcGen.update(10);
	}
	protected void action_TRANS_tr0_FROM_tp0_TO_tp0_BY_pongPingPongPort_tr0(InterfaceItemBase ifitem, PingPongData p) {
		System.out.printf("Top Level : \n");
		printData(p);
		crcGen.update(20);
	}
	protected void action_TRANS_tr1_FROM_tp0_TO_tp0_BY_pongSimplePingPongPort_tr1(InterfaceItemBase ifitem, int p) {
		System.out.printf("Top Level Simple: \n");
		crcGen.update(35);
	}
	protected void action_TRANS_tr10_FROM_waitForPong_TO_cp0_BY_pongPingPongPort(InterfaceItemBase ifitem, PingPongData p) {
		printData(p);
		crcGen.update(11);
	}
	protected void action_TRANS_tr4_FROM_cp0_TO_waitForPong(InterfaceItemBase ifitem, PingPongData p) {
		crcGen.update(12);
	}
	protected void action_TRANS_tr3_FROM_cp0_TO_state0_COND_tr3(InterfaceItemBase ifitem, PingPongData p) {
		// send default values
		PingPongPort.ping(data);
		
		data.getOwnType().setI8Val((byte)10);
		data.getOwnType().setI16Val((short)17);
		data.getOwnType().setI32Val(4711);
		data.getOwnType().setF32Val((float)3.0815);
		data.getOwnType().setF64Val(123.45678);
		data.getOwnType().setStringVal("Deep Hase !");
		int[] intArray = data.getOwnType().getArrayFromInt32();
		for (int i=0;i<intArray.length;i++) {intArray[i] = 10+i;}
		data.getOwnType().setArrayFromInt32(intArray);
		int[] intArrayShort=data.getArrayFromInt32();
		for (int j=0;j<intArrayShort.length;j++) {intArray[j] = 10+j;}
		
		// use convenient function
		PingPongPort.ping((byte)45,(short)34,80,'c',(float)3.14,7.12345,"Hase !",intArrayShort,data.getOwnType());
		
		crcGen.update(13);
	}
	protected void action_TRANS_tr5_FROM_state0_TO_state1_BY_pongPingPongPort(InterfaceItemBase ifitem, PingPongData p) {
		printData(p);
		PingPongPort.pingSimple(12);
		PingPongPort.pingSimple(27);
		crcGen.update(14);
	}
	protected void action_TRANS_tr6_FROM_state1_TO_state2_BY_pongSimplePingPongPort(InterfaceItemBase ifitem, int p) {
		crcGen.update(15);
	}
	protected void action_TRANS_tr7_FROM_state2_TO_cp1_BY_pongSimplePingPongPort(InterfaceItemBase ifitem, int p) {
		crcGen.update(16);
		System.out.printf("CRC: %d \n", crcGen.getCrc());
	}
	protected void action_TRANS_tr8_FROM_cp1_TO_TestFalse(InterfaceItemBase ifitem, int p) {
		RTServices.getInstance().getSubSystem().testFinished(1);
	}
	protected void action_TRANS_tr9_FROM_cp1_TO_TestOk_COND_tr9(InterfaceItemBase ifitem, int p) {
		RTServices.getInstance().getSubSystem().testFinished(0);
	}
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
	 */
	private void exitTo(int current, int to, boolean handler) {
		while (current!=to) {
			switch (current) {
				case STATE_waitForPong:
					this.history[STATE_TOP] = STATE_waitForPong;
					current = STATE_TOP;
					break;
				case STATE_state0:
					this.history[STATE_TOP] = STATE_state0;
					current = STATE_TOP;
					break;
				case STATE_state1:
					this.history[STATE_TOP] = STATE_state1;
					current = STATE_TOP;
					break;
				case STATE_state2:
					this.history[STATE_TOP] = STATE_state2;
					current = STATE_TOP;
					break;
				case STATE_TestFalse:
					this.history[STATE_TOP] = STATE_TestFalse;
					current = STATE_TOP;
					break;
				case STATE_TestOk:
					this.history[STATE_TOP] = STATE_TestOk;
					current = STATE_TOP;
					break;
			}
		}
	}
	
	/**
	 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
	 * matching the trigger of this chain. The ID of the final state is returned
	 * @param chain - the chain ID
	 * @param generic_data - the generic data pointer
	 * @return the ID of the final state
	 */
	private int executeTransitionChain(int chain, InterfaceItemBase ifitem, Object generic_data) {
		switch (chain) {
			case CHAIN_TRANS_INITIAL_TO__waitForPong:
			{
				action_TRANS_INITIAL_TO__waitForPong();
				return STATE_waitForPong;
			}
			case CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_pongPingPongPort_tr0:
			{
				PingPongData p = (PingPongData) generic_data;
				action_TRANS_tr0_FROM_tp0_TO_tp0_BY_pongPingPongPort_tr0(ifitem, p);
				return STATE_TOP;
			}
			case CHAIN_TRANS_tr1_FROM_tp0_TO_tp0_BY_pongSimplePingPongPort_tr1:
			{
				int p = (Integer) generic_data;
				action_TRANS_tr1_FROM_tp0_TO_tp0_BY_pongSimplePingPongPort_tr1(ifitem, p);
				return STATE_TOP;
			}
			case CHAIN_TRANS_tr10_FROM_waitForPong_TO_cp0_BY_pongPingPongPort:
			{
				PingPongData p = (PingPongData) generic_data;
				action_TRANS_tr10_FROM_waitForPong_TO_cp0_BY_pongPingPongPort(ifitem, p);
				if ((p.i32Val==2) && (p.i8Val==46)) {
				action_TRANS_tr3_FROM_cp0_TO_state0_COND_tr3(ifitem, p);
				return STATE_state0;}
				else {
				action_TRANS_tr4_FROM_cp0_TO_waitForPong(ifitem, p);
				return STATE_waitForPong;}
			}
			case CHAIN_TRANS_tr5_FROM_state0_TO_state1_BY_pongPingPongPort:
			{
				PingPongData p = (PingPongData) generic_data;
				action_TRANS_tr5_FROM_state0_TO_state1_BY_pongPingPongPort(ifitem, p);
				return STATE_state1;
			}
			case CHAIN_TRANS_tr6_FROM_state1_TO_state2_BY_pongSimplePingPongPort:
			{
				int p = (Integer) generic_data;
				action_TRANS_tr6_FROM_state1_TO_state2_BY_pongSimplePingPongPort(ifitem, p);
				return STATE_state2;
			}
			case CHAIN_TRANS_tr7_FROM_state2_TO_cp1_BY_pongSimplePingPongPort:
			{
				int p = (Integer) generic_data;
				action_TRANS_tr7_FROM_state2_TO_cp1_BY_pongSimplePingPongPort(ifitem, p);
				if ((p==28) && (crcGen.getCrc()==1187)) {
				action_TRANS_tr9_FROM_cp1_TO_TestOk_COND_tr9(ifitem, p);
				return STATE_TestOk;}
				else {
				action_TRANS_tr8_FROM_cp1_TO_TestFalse(ifitem, p);
				return STATE_TestFalse;}
			}
		}
		return NO_STATE;
	}
	
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state - the state which is entered
	 * @param handler - entry code is executed if not handler
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state, boolean handler, boolean skip_entry) {
		while (true) {
			switch (state) {
				case STATE_waitForPong:
					// in leaf state: return state id
					return STATE_waitForPong;
				case STATE_state0:
					// in leaf state: return state id
					return STATE_state0;
				case STATE_state1:
					// in leaf state: return state id
					return STATE_state1;
				case STATE_state2:
					// in leaf state: return state id
					return STATE_state2;
				case STATE_TestFalse:
					// in leaf state: return state id
					return STATE_TestFalse;
				case STATE_TestOk:
					// in leaf state: return state id
					return STATE_TestOk;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__waitForPong;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next, false, false);
		setState(next);
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		boolean is_handler = false;
		boolean skip_entry = false;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (this.state) {
				case STATE_waitForPong:
					switch(trigger) {
						case TRIG_PingPongPort__pong:
							{
								chain = CHAIN_TRANS_tr10_FROM_waitForPong_TO_cp0_BY_pongPingPongPort;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_PingPongPort__pongSimple:
							{
								chain = CHAIN_TRANS_tr1_FROM_tp0_TO_tp0_BY_pongSimplePingPongPort_tr1;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_state0:
					switch(trigger) {
						case TRIG_PingPongPort__pong:
							{ PingPongData p = (PingPongData) generic_data;
							if (p.getI32Val()==3)
							{
								chain = CHAIN_TRANS_tr5_FROM_state0_TO_state1_BY_pongPingPongPort;
								catching_state = STATE_TOP;
							} else 
							{
								chain = CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_pongPingPongPort_tr0;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
							}
						break;
						case TRIG_PingPongPort__pongSimple:
							{
								chain = CHAIN_TRANS_tr1_FROM_tp0_TO_tp0_BY_pongSimplePingPongPort_tr1;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_state1:
					switch(trigger) {
						case TRIG_PingPongPort__pongSimple:
							{
								chain = CHAIN_TRANS_tr6_FROM_state1_TO_state2_BY_pongSimplePingPongPort;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_PingPongPort__pong:
							{
								chain = CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_pongPingPongPort_tr0;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_state2:
					switch(trigger) {
						case TRIG_PingPongPort__pongSimple:
							{
								chain = CHAIN_TRANS_tr7_FROM_state2_TO_cp1_BY_pongSimplePingPongPort;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_PingPongPort__pong:
							{
								chain = CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_pongPingPongPort_tr0;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_TestFalse:
					switch(trigger) {
						case TRIG_PingPongPort__pong:
							{
								chain = CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_pongPingPongPort_tr0;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
						case TRIG_PingPongPort__pongSimple:
							{
								chain = CHAIN_TRANS_tr1_FROM_tp0_TO_tp0_BY_pongSimplePingPongPort_tr1;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_TestOk:
					switch(trigger) {
						case TRIG_PingPongPort__pong:
							{
								chain = CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_pongPingPongPort_tr0;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
						case TRIG_PingPongPort__pongSimple:
							{
								chain = CHAIN_TRANS_tr1_FROM_tp0_TO_tp0_BY_pongSimplePingPongPort_tr1;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
					}
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(this.state, catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
