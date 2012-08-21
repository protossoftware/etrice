package org.eclipse.etrice.integration.ChoicePointTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.ChoicePointTest.TestProtocol.*;

/*--------------------- begin user code ---------------------*/
import org.eclipse.etrice.integration.tests.helpers.*;
import org.eclipse.etrice.runtime.java.messaging.RTServices;
/*--------------------- end user code ---------------------*/


public class CPUser extends ActorClassBase {

	/*--------------------- begin user code ---------------------*/
	private CRC16Generator crcGen = new CRC16Generator();
	/*--------------------- end user code ---------------------*/
	
	
	//--------------------- ports
	protected TestProtocolPort TestPort1 = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_TestPort1 = 1;

		
	/*--------------------- attributes ---------------------*/
	int counter;
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public CPUser(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("CPUser");
		
		// initialize attributes
		counter = 0;

		// own ports
		TestPort1 = new TestProtocolPort(this, "TestPort1", IFITEM_TestPort1, 0, port_addr[IFITEM_TestPort1][0], peer_addr[IFITEM_TestPort1][0]); 
		
		// own saps
		
		// own service implementations
	}

	
	//--------------------- attributes getter and setter
	//--------------------- attribute setters and getters
	public void setCounter (int counter) {
		 this.counter = counter;
	}
	public int getCounter () {
		return this.counter;
	}
	
	
	//--------------------- port getters
	public TestProtocolPort getTestPort1 (){
		return this.TestPort1;
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
	public static final int STATE_state1 = 2;
	public static final int STATE_state0 = 3;
	public static final int STATE_state1_state0 = 4;
	public static final int STATE_testOk = 5;
	public static final int STATE_testFalse = 6;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__cp0 = 1;
	public static final int CHAIN_TRANS_tr1_FROM_state0_TO_cp1_BY_msg1TestPort1 = 2;
	public static final int CHAIN_TRANS_tr5_FROM_state1_TO_cp2_BY_msg1TestPort1 = 3;
	public static final int CHAIN_TRANS_tr7_FROM_state1_TO_state0_BY_msg1TestPort1 = 4;
	public static final int CHAIN_TRANS_tr8_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr8 = 5;
	public static final int CHAIN_state1_TRANS_INITIAL_TO__state0 = 6;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_TestPort1__msg1 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg1;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","state1",
	"state0",
	"state1_state0",
	"testOk",
	"testFalse"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_state0() {
		System.out.println("state0: entry code");
		crcGen.update(12);
	}
	protected void exit_state0() {
		System.out.println("state0: exit code");
		crcGen.update(13);
	}
	protected void entry_state1() {
		System.out.println("state1: entry code");
		crcGen.update(20);
	}
	protected void exit_state1() {
		System.out.println("state1: exit code");
		crcGen.update(21);
	}
	protected void entry_state1_state0() {
		System.out.println("state1\\0: entry code");
		System.out.printf("counter => %d\n",counter);
		crcGen.update(22);
	}
	protected void exit_state1_state0() {
		System.out.println("state1\\0: exit code");
		crcGen.update(23);
	}
	
	/* Action Codes */
	protected void action_TRANS_INITIAL_TO__cp0() {
		System.out.println("Top Level init transition");
		crcGen.update(10);
		counter = 0;
	}
	protected void action_TRANS_tr4_FROM_cp0_TO_state0() {
		System.out.println("choice0: else code");
		crcGen.update(17);
	}
	protected void action_TRANS_LastCheck_FROM_cp0_TO_state0_COND_LastCheck() {
		System.out.println("choice0: true code");
		crcGen.update(15);
	}
	protected void action_TRANS_tr1_FROM_state0_TO_cp1_BY_msg1TestPort1(InterfaceItemBase ifitem) {
		System.out.println("state0: msg1: transition code");
		crcGen.update(18);
	}
	protected void action_TRANS_tr2_FROM_cp1_TO_state0(InterfaceItemBase ifitem) {
		System.out.println("choice1: else code");
		crcGen.update(10);
		counter=3;
	}
	protected void action_TRANS_tr3_FROM_cp1_TO_state1_tp0_COND_tr3(InterfaceItemBase ifitem) {
		System.out.println("choice1: to entry state1 code");
		crcGen.update(30);
	}
	protected void action_TRANS_tr5_FROM_state1_TO_cp2_BY_msg1TestPort1(InterfaceItemBase ifitem) {
		System.out.println("state1: msg1: transition code");
		crcGen.update(30);
		System.out.printf("CRC: %d \n", crcGen.getCrc());
	}
	protected void action_TRANS_tr0_FROM_cp2_TO_testFalse(InterfaceItemBase ifitem) {
		System.out.println("Test false");
		RTServices.getInstance().getSubSystem().testFinished(1);
	}
	protected void action_TRANS_tr6_FROM_cp2_TO_testOk_COND_tr6(InterfaceItemBase ifitem) {
		System.out.println("Test ok");
		RTServices.getInstance().getSubSystem().testFinished(0);
	}
	protected void action_TRANS_tr11_FROM_cp1_TO_state1_COND_tr11(InterfaceItemBase ifitem) {
		System.out.println("choice1: history to State1 transition code");
		crcGen.update(25);
		counter = 1;
	}
	protected void action_TRANS_tr7_FROM_state1_TO_state0_BY_msg1TestPort1(InterfaceItemBase ifitem) {
		System.out.println("state1: msg1: transition code to state0");
		crcGen.update(51);
		counter=4;
	}
	protected void action_TRANS_tr8_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr8(InterfaceItemBase ifitem) {
		System.out.println("Handler: msg1 received ");
		crcGen.update(115);
		counter = 2;
	}
	protected void action_state1_TRANS_tr1_FROM_tp0_TO_cp0(InterfaceItemBase ifitem) {
		System.out.println("state1: tp0: transition code");
		crcGen.update(25);
	}
	protected void action_state1_TRANS_tr2_FROM_cp0_TO_state0(InterfaceItemBase ifitem) {
		System.out.println("state1: choice false code");
		crcGen.update(57);
	}
	protected void action_state1_TRANS_tr0_FROM_cp0_TO_state0_COND_tr0(InterfaceItemBase ifitem) {
		System.out.println("state1 choice: true code");
		crcGen.update(56);
	}
	protected void action_state1_TRANS_INITIAL_TO__state0() {
		System.out.println("state1 initial transition code");
		crcGen.update(53);
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
				case STATE_state0:
					if (!handler) exit_state0();
					this.history[STATE_TOP] = STATE_state0;
					current = STATE_TOP;
					break;
				case STATE_state1:
					if (!handler) exit_state1();
					this.history[STATE_TOP] = STATE_state1;
					current = STATE_TOP;
					break;
				case STATE_state1_state0:
					if (!handler) exit_state1_state0();
					this.history[STATE_state1] = STATE_state1_state0;
					current = STATE_state1;
					break;
				case STATE_testOk:
					this.history[STATE_TOP] = STATE_testOk;
					current = STATE_TOP;
					break;
				case STATE_testFalse:
					this.history[STATE_TOP] = STATE_testFalse;
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
			case CHAIN_TRANS_INITIAL_TO__cp0:
			{
				action_TRANS_INITIAL_TO__cp0();
				if (counter == 0) {
				action_TRANS_LastCheck_FROM_cp0_TO_state0_COND_LastCheck();
				return STATE_state0;}
				else {
				action_TRANS_tr4_FROM_cp0_TO_state0();
				return STATE_state0;}
			}
			case CHAIN_TRANS_tr1_FROM_state0_TO_cp1_BY_msg1TestPort1:
			{
				action_TRANS_tr1_FROM_state0_TO_cp1_BY_msg1TestPort1(ifitem);
				if (counter == 4) {
				action_TRANS_tr3_FROM_cp1_TO_state1_tp0_COND_tr3(ifitem);
				entry_state1();
				action_state1_TRANS_tr1_FROM_tp0_TO_cp0(ifitem);
				if (counter == 4) {
				action_state1_TRANS_tr0_FROM_cp0_TO_state0_COND_tr0(ifitem);
				return STATE_state1_state0;}
				else {
				action_state1_TRANS_tr2_FROM_cp0_TO_state0(ifitem);
				return STATE_state1_state0;}
				}
				else if (counter == 3) {
				action_TRANS_tr11_FROM_cp1_TO_state1_COND_tr11(ifitem);
				return STATE_state1;}
				else {
				action_TRANS_tr2_FROM_cp1_TO_state0(ifitem);
				return STATE_state0;}
			}
			case CHAIN_TRANS_tr5_FROM_state1_TO_cp2_BY_msg1TestPort1:
			{
				action_TRANS_tr5_FROM_state1_TO_cp2_BY_msg1TestPort1(ifitem);
				if (crcGen.getCrc()==26639) {
				action_TRANS_tr6_FROM_cp2_TO_testOk_COND_tr6(ifitem);
				return STATE_testOk;}
				else {
				action_TRANS_tr0_FROM_cp2_TO_testFalse(ifitem);
				return STATE_testFalse;}
			}
			case CHAIN_TRANS_tr7_FROM_state1_TO_state0_BY_msg1TestPort1:
			{
				action_TRANS_tr7_FROM_state1_TO_state0_BY_msg1TestPort1(ifitem);
				return STATE_state0;
			}
			case CHAIN_TRANS_tr8_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr8:
			{
				action_TRANS_tr8_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr8(ifitem);
				return STATE_TOP;
			}
			case CHAIN_state1_TRANS_INITIAL_TO__state0:
			{
				action_state1_TRANS_INITIAL_TO__state0();
				return STATE_state1_state0;
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
				case STATE_state0:
					if (!(skip_entry || handler)) entry_state0();
					// in leaf state: return state id
					return STATE_state0;
				case STATE_state1:
					if (!(skip_entry || handler)) entry_state1();
					// state has a sub graph
					// with init transition
					if (this.history[STATE_state1]==NO_STATE) {
						state = executeTransitionChain(CHAIN_state1_TRANS_INITIAL_TO__state0, null, null);
					}
					else {
						state = this.history[STATE_state1];
					}
					break;
				case STATE_state1_state0:
					if (!(skip_entry || handler)) entry_state1_state0();
					// in leaf state: return state id
					return STATE_state1_state0;
				case STATE_testOk:
					// in leaf state: return state id
					return STATE_testOk;
				case STATE_testFalse:
					// in leaf state: return state id
					return STATE_testFalse;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__cp0;
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
				case STATE_state0:
					switch(trigger) {
						case TRIG_TestPort1__msg1:
							{
								chain = CHAIN_TRANS_tr1_FROM_state0_TO_cp1_BY_msg1TestPort1;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_state1_state0:
					switch(trigger) {
						case TRIG_TestPort1__msg1:
							{ 
							if (counter==2)
							{
								chain = CHAIN_TRANS_tr5_FROM_state1_TO_cp2_BY_msg1TestPort1;
								catching_state = STATE_TOP;
							} else 
							if (counter==1)
							{
								chain = CHAIN_TRANS_tr7_FROM_state1_TO_state0_BY_msg1TestPort1;
								catching_state = STATE_TOP;
							} else 
							{
								chain = CHAIN_TRANS_tr8_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr8;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							}
							}
						break;
					}
					break;
				case STATE_testOk:
					switch(trigger) {
						case TRIG_TestPort1__msg1:
							{
								chain = CHAIN_TRANS_tr8_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr8;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_testFalse:
					switch(trigger) {
						case TRIG_TestPort1__msg1:
							{
								chain = CHAIN_TRANS_tr8_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr8;
								catching_state = STATE_TOP;
								is_handler = true;
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
