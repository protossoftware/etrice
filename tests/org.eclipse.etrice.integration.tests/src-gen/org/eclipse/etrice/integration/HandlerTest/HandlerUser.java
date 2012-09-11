package org.eclipse.etrice.integration.HandlerTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.integration.HandlerTest.TestProtocol.*;

/*--------------------- begin user code ---------------------*/
import org.eclipse.etrice.runtime.java.messaging.RTServices;
/*--------------------- end user code ---------------------*/


public class HandlerUser extends ActorClassBase {

	
	
	//--------------------- ports
	protected TestProtocolPort TestPort1 = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_TestPort1 = 1;

		
	/*--------------------- attributes ---------------------*/
	int counter;
	int caseId;
	/*--------------------- operations ---------------------*/
	public void HandlerUser_dtor() {
		etUnit_closeAll(caseId);
	}

	//--------------------- construction
	public HandlerUser(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("HandlerUser");
		
		// initialize attributes
		counter = 0;
		caseId = 0;

		// own ports
		TestPort1 = new TestProtocolPort(this, "TestPort1", IFITEM_TestPort1, 0, port_addr[IFITEM_TestPort1][0], peer_addr[IFITEM_TestPort1][0]); 
		
		// own saps
		
		// own service implementations
		
		{
			// user defined constructor body
			caseId = etUnit_openAll("tmp", "HandlerTest.etu", "HandlerTest_suite", "HandlerTest_case");
		}
	}

	
	//--------------------- attribute setters and getters
	public void setCounter (int counter) {
		 this.counter = counter;
	}
	public int getCounter () {
		return this.counter;
	}
	public void setCaseId (int caseId) {
		 this.caseId = caseId;
	}
	public int getCaseId () {
		return this.caseId;
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
		HandlerUser_dtor();
	}

	
	/* state IDs */
	public static final int STATE_state0 = 2;
	public static final int STATE_state0_state1 = 3;
	public static final int STATE_state0_state1_state7 = 4;
	public static final int STATE_state0_state2 = 5;
	public static final int STATE_testOk = 6;
	public static final int STATE_state1 = 7;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__state0_tp2 = 1;
	public static final int CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr0 = 2;
	public static final int CHAIN_TRANS_tr1_FROM_tp1_TO_tp1_BY_msg1TestPort1_tr1 = 3;
	public static final int CHAIN_TRANS_tr4_FROM_tp1_TO_testOk_BY_msg6TestPort1 = 4;
	public static final int CHAIN_TRANS_tr5_FROM_tp1_TO_tp1_BY_msg2TestPort1_tr5 = 5;
	public static final int CHAIN_TRANS_tr6_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr6 = 6;
	public static final int CHAIN_TRANS_tr7_FROM_tp0_TO_state0_BY_msg1TestPort1 = 7;
	public static final int CHAIN_TRANS_tr9_FROM_state0_TO_cp1_BY_msg1TestPort1 = 8;
	public static final int CHAIN_state0_TRANS_INITIAL_TO__state2 = 9;
	public static final int CHAIN_state0_TRANS_tr0_FROM_state1_TO_state2_BY_msg5TestPort1 = 10;
	public static final int CHAIN_state0_TRANS_tr1_FROM_tp0_TO_tp0_BY_msg3TestPort1_tr1 = 11;
	public static final int CHAIN_state0_TRANS_tr2_FROM_tp1_TO_tp1_BY_msg4TestPort1_tr2 = 12;
	public static final int CHAIN_state0_TRANS_tr3_FROM_state2_TO_state2_BY_msg1TestPort1_tr3 = 13;
	public static final int CHAIN_state0_TRANS_tr5_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr5 = 14;
	public static final int CHAIN_state0_TRANS_tr6_FROM_state1_TO_state1_BY_msg1TestPort1_tr6 = 15;
	public static final int CHAIN_state0_TRANS_tr7_FROM_tp1_TO_state1_BY_msg2TestPort1 = 16;
	public static final int CHAIN_state0_TRANS_tr8_FROM_tp1_TO_state2_BY_msg2TestPort1 = 17;
	public static final int CHAIN_state0_state1_TRANS_INITIAL_TO__state7 = 18;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_TestPort1__msg1 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg1;
	public static final int TRIG_TestPort1__msg2 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg2;
	public static final int TRIG_TestPort1__msg3 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg3;
	public static final int TRIG_TestPort1__msg4 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg4;
	public static final int TRIG_TestPort1__msg5 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg5;
	public static final int TRIG_TestPort1__msg6 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg6;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","state0",
	"state0_state1",
	"state0_state1_state7",
	"state0_state2",
	"testOk",
	"state1"
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
	protected void entry_state0() {
		System.out.println("state 0 entry action");
		EXPECT_ORDER(caseId, "state state0 entry code", 13);
	}
	protected void exit_state0() {
		System.out.println("state 0 exit action");
		EXPECT_ORDER(caseId, "state state0 exit code", 14);
	}
	protected void entry_state0_state1() {
		System.out.println("state 0/1 entry action");
		EXPECT_ORDER(caseId, "state state0_state1 entry code", 16);
	}
	protected void exit_state0_state1() {
		System.out.println("state 0/1 exit action");
		EXPECT_ORDER(caseId, "state state0_state1 exit code", 17);
	}
	protected void entry_state0_state1_state7() {
		System.out.println("state 0/1/7 entry action");
		EXPECT_ORDER(caseId, "state state0_state1_state7 entry code", 23);
	}
	protected void exit_state0_state1_state7() {
		System.out.println("state 0/1/7 exit action");
		EXPECT_ORDER(caseId, "state state0_state1_state7 exit code", 24);
	}
	protected void entry_state0_state2() {
		System.out.println("state 0/2 entry action");
		EXPECT_ORDER(caseId, "state state0_state2 entry code", 18);
	}
	protected void exit_state0_state2() {
		System.out.println("state 0/2 exit action");
		EXPECT_ORDER(caseId, "state state0_state2 exit code", 19);
	}
	protected void entry_testOk() {
		System.out.println("Test ok");
		RTServices.getInstance().getSubSystem().testFinished(etUnit_isSuccess(caseId)?0:1);
	}
	protected void entry_state1() {
		System.out.println("state 1 entry action");
		EXPECT_ORDER(caseId, "state state1 entry code", 111);
	}
	protected void exit_state1() {
		System.out.println("state 1 exit action");
		EXPECT_ORDER(caseId, "state state1 exit code", 112);
	}
	
	/* Action Codes */
	protected void action_TRANS_tr0_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr0(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level handler action no guard ");
		EXPECT_ORDER(caseId, "transition tr0: TRANS_tr0_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr0 action code", 11);
	}
	protected void action_TRANS_tr1_FROM_tp1_TO_tp1_BY_msg1TestPort1_tr1(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level self transition action P1=>3");
		EXPECT_ORDER(caseId, "transition tr1: TRANS_tr1_FROM_tp1_TO_tp1_BY_msg1TestPort1_tr1 action code", 12);
	}
	protected void action_TRANS_INITIAL_TO__state0_tp2() {
		System.out.println("top level initial transition");
		int list[] = {13,15,16,22,23,11,24,17,14,12,13,16,23,70,24,17,14,114,113,111,11,70,24,17,120,16,23,24,17,121,18,19,25,18,20,19,21,18,19,25,18,19,14,117};
		EXPECT_ORDER_START(caseId, list, list.length);
	}
	protected void action_TRANS_tr9_FROM_state0_TO_cp1_BY_msg1TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("tr9 transition action");
		EXPECT_ORDER(caseId, "transition tr9: TRANS_tr9_FROM_state0_TO_cp1_BY_msg1TestPort1 action code", 114);
	}
	protected void action_TRANS_tr5_FROM_tp1_TO_tp1_BY_msg2TestPort1_tr5(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level self transition action P1=>4");
		EXPECT_ORDER(caseId, "transition tr5: TRANS_tr5_FROM_tp1_TO_tp1_BY_msg2TestPort1_tr5 action code", 50);
	}
	protected void action_TRANS_tr7_FROM_tp0_TO_state0_BY_msg1TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level handler action p1=>7 ");
		EXPECT_ORDER(caseId, "transition tr7: TRANS_tr7_FROM_tp0_TO_state0_BY_msg1TestPort1 action code", 70);
	}
	protected void action_TRANS_tr6_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr6(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level handler action p1=>12 ");
		EXPECT_ORDER(caseId, "transition tr6: TRANS_tr6_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr6 action code", 110);
	}
	protected void action_TRANS_tr8_FROM_cp1_TO_state1(InterfaceItemBase ifitem, int p1) {
		System.out.println("tr8 transition action");
		EXPECT_ORDER(caseId, "transition tr8: TRANS_tr8_FROM_cp1_TO_state1 action code", 113);
	}
	protected void action_TRANS_tr10_FROM_cp1_TO_state0_COND_tr10(InterfaceItemBase ifitem, int p1) {
		System.out.println("tr4 transition action");
		EXPECT_ORDER(caseId, "transition tr10: TRANS_tr10_FROM_cp1_TO_state0_COND_tr10 action code", 115);
	}
	protected void action_TRANS_tr4_FROM_tp1_TO_testOk_BY_msg6TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("tp1 transition to choice action");
		EXPECT_ORDER_END(caseId, "transition tr4: TRANS_tr4_FROM_tp1_TO_testOk_BY_msg6TestPort1 action code", 117);
	}
	protected void action_state0_TRANS_tr1_FROM_tp0_TO_tp0_BY_msg3TestPort1_tr1(InterfaceItemBase ifitem) {
		System.out.println("state 0 handler action no guard");
		EXPECT_ORDER(caseId, "transition tr1: TRANS_tr1_FROM_tp0_TO_tp0_BY_msg3TestPort1_tr1 action code", 20);
	}
	protected void action_state0_TRANS_tr2_FROM_tp1_TO_tp1_BY_msg4TestPort1_tr2(InterfaceItemBase ifitem) {
		System.out.println("state 0 tp1 self transition action");
		EXPECT_ORDER(caseId, "transition tr2: TRANS_tr2_FROM_tp1_TO_tp1_BY_msg4TestPort1_tr2 action code", 21);
	}
	protected void action_state0_TRANS_tr3_FROM_state2_TO_state2_BY_msg1TestPort1_tr3(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0/2 self transition action");
		EXPECT_ORDER(caseId, "transition tr3: TRANS_tr3_FROM_state2_TO_state2_BY_msg1TestPort1_tr3 action code", 25);
	}
	protected void action_state0_TRANS_tr4_FROM_tp2_TO_state0_state1_tp0() {
		System.out.println("state 0 tp2 transition action");
		EXPECT_ORDER(caseId, "transition tr4: TRANS_tr4_FROM_tp2_TO_state0_state1_tp0 action code", 15);
	}
	protected void action_state0_TRANS_tr5_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr5(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0 handler action P1 => 5");
		EXPECT_ORDER(caseId, "transition tr5: TRANS_tr5_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr5 action code", 52);
	}
	protected void action_state0_TRANS_INITIAL_TO__state2() {
		System.out.println("state 0 initial transition");
		EXPECT_ORDER(caseId, "transition init: TRANS_INITIAL_TO__state2 action code", 53);
	}
	protected void action_state0_TRANS_tr6_FROM_state1_TO_state1_BY_msg1TestPort1_tr6(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0/1 self transition");
		EXPECT_ORDER(caseId, "transition tr6: TRANS_tr6_FROM_state1_TO_state1_BY_msg1TestPort1_tr6 action code", 54);
	}
	protected void action_state0_TRANS_tr7_FROM_tp1_TO_state1_BY_msg2TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0 tp1 p1=>5");
		EXPECT_ORDER(caseId, "transition tr7: TRANS_tr7_FROM_tp1_TO_state1_BY_msg2TestPort1 action code", 120);
	}
	protected void action_state0_TRANS_tr8_FROM_tp1_TO_state2_BY_msg2TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0 tp1 action P1 => 6");
		EXPECT_ORDER(caseId, "transition tr8: TRANS_tr8_FROM_tp1_TO_state2_BY_msg2TestPort1 action code", 121);
	}
	protected void action_state0_state1_TRANS_tr0_FROM_tp0_TO_state7() {
		System.out.println("state 0/1 transition entry action");
		EXPECT_ORDER(caseId, "transition tr0: TRANS_tr0_FROM_tp0_TO_state7 action code", 22);
	}
	protected void action_state0_state1_TRANS_INITIAL_TO__state7() {
		System.out.println("state 0/1 initial transition");
		EXPECT_ORDER(caseId, "transition init: TRANS_INITIAL_TO__state7 action code", 121);
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
				case STATE_state0_state1:
					if (!handler) exit_state0_state1();
					this.history[STATE_state0] = STATE_state0_state1;
					current = STATE_state0;
					break;
				case STATE_state0_state1_state7:
					if (!handler) exit_state0_state1_state7();
					this.history[STATE_state0_state1] = STATE_state0_state1_state7;
					current = STATE_state0_state1;
					break;
				case STATE_state0_state2:
					if (!handler) exit_state0_state2();
					this.history[STATE_state0] = STATE_state0_state2;
					current = STATE_state0;
					break;
				case STATE_testOk:
					this.history[STATE_TOP] = STATE_testOk;
					current = STATE_TOP;
					break;
				case STATE_state1:
					if (!handler) exit_state1();
					this.history[STATE_TOP] = STATE_state1;
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
			case CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr0:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tr0_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr0(ifitem, p1);
				return STATE_TOP;
			}
			case CHAIN_TRANS_tr1_FROM_tp1_TO_tp1_BY_msg1TestPort1_tr1:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tr1_FROM_tp1_TO_tp1_BY_msg1TestPort1_tr1(ifitem, p1);
				return STATE_TOP;
			}
			case CHAIN_TRANS_INITIAL_TO__state0_tp2:
			{
				action_TRANS_INITIAL_TO__state0_tp2();
				entry_state0();
				action_state0_TRANS_tr4_FROM_tp2_TO_state0_state1_tp0();
				entry_state0_state1();
				action_state0_state1_TRANS_tr0_FROM_tp0_TO_state7();
				return STATE_state0_state1_state7;
			}
			case CHAIN_TRANS_tr9_FROM_state0_TO_cp1_BY_msg1TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tr9_FROM_state0_TO_cp1_BY_msg1TestPort1(ifitem, p1);
				if (p1!=4) {
				action_TRANS_tr10_FROM_cp1_TO_state0_COND_tr10(ifitem, p1);
				return STATE_state0;}
				else {
				action_TRANS_tr8_FROM_cp1_TO_state1(ifitem, p1);
				return STATE_state1;}
			}
			case CHAIN_TRANS_tr5_FROM_tp1_TO_tp1_BY_msg2TestPort1_tr5:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tr5_FROM_tp1_TO_tp1_BY_msg2TestPort1_tr5(ifitem, p1);
				return STATE_TOP;
			}
			case CHAIN_TRANS_tr7_FROM_tp0_TO_state0_BY_msg1TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tr7_FROM_tp0_TO_state0_BY_msg1TestPort1(ifitem, p1);
				return STATE_state0;
			}
			case CHAIN_TRANS_tr6_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr6:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tr6_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr6(ifitem, p1);
				return STATE_TOP;
			}
			case CHAIN_TRANS_tr4_FROM_tp1_TO_testOk_BY_msg6TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tr4_FROM_tp1_TO_testOk_BY_msg6TestPort1(ifitem, p1);
				return STATE_testOk;
			}
			case CHAIN_state0_TRANS_tr0_FROM_state1_TO_state2_BY_msg5TestPort1:
			{
				int p1 = (Integer) generic_data;
				return STATE_state0_state2;
			}
			case CHAIN_state0_TRANS_tr1_FROM_tp0_TO_tp0_BY_msg3TestPort1_tr1:
			{
				action_state0_TRANS_tr1_FROM_tp0_TO_tp0_BY_msg3TestPort1_tr1(ifitem);
				return STATE_state0;
			}
			case CHAIN_state0_TRANS_tr2_FROM_tp1_TO_tp1_BY_msg4TestPort1_tr2:
			{
				action_state0_TRANS_tr2_FROM_tp1_TO_tp1_BY_msg4TestPort1_tr2(ifitem);
				return STATE_state0;
			}
			case CHAIN_state0_TRANS_tr3_FROM_state2_TO_state2_BY_msg1TestPort1_tr3:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_tr3_FROM_state2_TO_state2_BY_msg1TestPort1_tr3(ifitem, p1);
				return STATE_state0_state2;
			}
			case CHAIN_state0_TRANS_tr5_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr5:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_tr5_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr5(ifitem, p1);
				return STATE_state0;
			}
			case CHAIN_state0_TRANS_INITIAL_TO__state2:
			{
				action_state0_TRANS_INITIAL_TO__state2();
				return STATE_state0_state2;
			}
			case CHAIN_state0_TRANS_tr6_FROM_state1_TO_state1_BY_msg1TestPort1_tr6:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_tr6_FROM_state1_TO_state1_BY_msg1TestPort1_tr6(ifitem, p1);
				return STATE_state0_state1;
			}
			case CHAIN_state0_TRANS_tr7_FROM_tp1_TO_state1_BY_msg2TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_tr7_FROM_tp1_TO_state1_BY_msg2TestPort1(ifitem, p1);
				return STATE_state0_state1;
			}
			case CHAIN_state0_TRANS_tr8_FROM_tp1_TO_state2_BY_msg2TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_tr8_FROM_tp1_TO_state2_BY_msg2TestPort1(ifitem, p1);
				return STATE_state0_state2;
			}
			case CHAIN_state0_state1_TRANS_INITIAL_TO__state7:
			{
				action_state0_state1_TRANS_INITIAL_TO__state7();
				return STATE_state0_state1_state7;
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
					// state has a sub graph
					// with init transition
					if (this.history[STATE_state0]==NO_STATE) {
						state = executeTransitionChain(CHAIN_state0_TRANS_INITIAL_TO__state2, null, null);
					}
					else {
						state = this.history[STATE_state0];
					}
					break;
				case STATE_state0_state1:
					if (!(skip_entry || handler)) entry_state0_state1();
					// state has a sub graph
					// with init transition
					if (this.history[STATE_state0_state1]==NO_STATE) {
						state = executeTransitionChain(CHAIN_state0_state1_TRANS_INITIAL_TO__state7, null, null);
					}
					else {
						state = this.history[STATE_state0_state1];
					}
					break;
				case STATE_state0_state1_state7:
					if (!(skip_entry || handler)) entry_state0_state1_state7();
					// in leaf state: return state id
					return STATE_state0_state1_state7;
				case STATE_state0_state2:
					if (!(skip_entry || handler)) entry_state0_state2();
					// in leaf state: return state id
					return STATE_state0_state2;
				case STATE_testOk:
					if (!(skip_entry || handler)) entry_testOk();
					// in leaf state: return state id
					return STATE_testOk;
				case STATE_state1:
					if (!(skip_entry || handler)) entry_state1();
					// in leaf state: return state id
					return STATE_state1;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__state0_tp2;
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
				case STATE_state0_state1_state7:
					switch(trigger) {
						case TRIG_TestPort1__msg5:
							{
								chain = CHAIN_state0_TRANS_tr0_FROM_state1_TO_state2_BY_msg5TestPort1;
								catching_state = STATE_state0;
							}
						break;
						case TRIG_TestPort1__msg1:
							{ int p1 = (Integer) generic_data;
							if (p1==8)
							{
								chain = CHAIN_state0_TRANS_tr6_FROM_state1_TO_state1_BY_msg1TestPort1_tr6;
								catching_state = STATE_state0;
							} else 
							if (p1==5)
							{
								chain = CHAIN_state0_TRANS_tr5_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr5;
								catching_state = STATE_state0;
								is_handler = true;
								skip_entry = true;
							} else 
							if (p1==4)
							{
								chain = CHAIN_TRANS_tr9_FROM_state0_TO_cp1_BY_msg1TestPort1;
								catching_state = STATE_TOP;
							} else 
							if (p1==7)
							{
								chain = CHAIN_TRANS_tr7_FROM_tp0_TO_state0_BY_msg1TestPort1;
								catching_state = STATE_TOP;
								is_handler = true;
							} else 
							if (p1==12)
							{
								chain = CHAIN_TRANS_tr6_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr6;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							} else 
							if (p1==3)
							{
								chain = CHAIN_TRANS_tr1_FROM_tp1_TO_tp1_BY_msg1TestPort1_tr1;
								catching_state = STATE_TOP;
								skip_entry = true;
							} else 
							{
								chain = CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr0;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							}
							}
						break;
						case TRIG_TestPort1__msg3:
							{
								chain = CHAIN_state0_TRANS_tr1_FROM_tp0_TO_tp0_BY_msg3TestPort1_tr1;
								catching_state = STATE_state0;
								is_handler = true;
								skip_entry = true;
							}
						break;
						case TRIG_TestPort1__msg4:
							{
								chain = CHAIN_state0_TRANS_tr2_FROM_tp1_TO_tp1_BY_msg4TestPort1_tr2;
								catching_state = STATE_state0;
								skip_entry = true;
							}
						break;
						case TRIG_TestPort1__msg2:
							{ int p1 = (Integer) generic_data;
							if (p1==5)
							{
								chain = CHAIN_state0_TRANS_tr7_FROM_tp1_TO_state1_BY_msg2TestPort1;
								catching_state = STATE_state0;
							} else 
							if (p1==6)
							{
								chain = CHAIN_state0_TRANS_tr8_FROM_tp1_TO_state2_BY_msg2TestPort1;
								catching_state = STATE_state0;
							} else 
							if (p1==4)
							{
								chain = CHAIN_TRANS_tr5_FROM_tp1_TO_tp1_BY_msg2TestPort1_tr5;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
							}
						break;
						case TRIG_TestPort1__msg6:
							{
								chain = CHAIN_TRANS_tr4_FROM_tp1_TO_testOk_BY_msg6TestPort1;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_state0_state2:
					switch(trigger) {
						case TRIG_TestPort1__msg1:
							{
								chain = CHAIN_state0_TRANS_tr3_FROM_state2_TO_state2_BY_msg1TestPort1_tr3;
								catching_state = STATE_state0;
							}
						break;
						case TRIG_TestPort1__msg3:
							{
								chain = CHAIN_state0_TRANS_tr1_FROM_tp0_TO_tp0_BY_msg3TestPort1_tr1;
								catching_state = STATE_state0;
								is_handler = true;
								skip_entry = true;
							}
						break;
						case TRIG_TestPort1__msg4:
							{
								chain = CHAIN_state0_TRANS_tr2_FROM_tp1_TO_tp1_BY_msg4TestPort1_tr2;
								catching_state = STATE_state0;
								skip_entry = true;
							}
						break;
						case TRIG_TestPort1__msg2:
							{ int p1 = (Integer) generic_data;
							if (p1==5)
							{
								chain = CHAIN_state0_TRANS_tr7_FROM_tp1_TO_state1_BY_msg2TestPort1;
								catching_state = STATE_state0;
							} else 
							if (p1==6)
							{
								chain = CHAIN_state0_TRANS_tr8_FROM_tp1_TO_state2_BY_msg2TestPort1;
								catching_state = STATE_state0;
							} else 
							if (p1==4)
							{
								chain = CHAIN_TRANS_tr5_FROM_tp1_TO_tp1_BY_msg2TestPort1_tr5;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
							}
						break;
						case TRIG_TestPort1__msg6:
							{
								chain = CHAIN_TRANS_tr4_FROM_tp1_TO_testOk_BY_msg6TestPort1;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_testOk:
					switch(trigger) {
						case TRIG_TestPort1__msg1:
							{ int p1 = (Integer) generic_data;
							if (p1==7)
							{
								chain = CHAIN_TRANS_tr7_FROM_tp0_TO_state0_BY_msg1TestPort1;
								catching_state = STATE_TOP;
								is_handler = true;
							} else 
							if (p1==12)
							{
								chain = CHAIN_TRANS_tr6_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr6;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							} else 
							if (p1==3)
							{
								chain = CHAIN_TRANS_tr1_FROM_tp1_TO_tp1_BY_msg1TestPort1_tr1;
								catching_state = STATE_TOP;
								skip_entry = true;
							} else 
							{
								chain = CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr0;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							}
							}
						break;
						case TRIG_TestPort1__msg2:
							{ int p1 = (Integer) generic_data;
							if (p1==4)
							{
								chain = CHAIN_TRANS_tr5_FROM_tp1_TO_tp1_BY_msg2TestPort1_tr5;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
							}
						break;
						case TRIG_TestPort1__msg6:
							{
								chain = CHAIN_TRANS_tr4_FROM_tp1_TO_testOk_BY_msg6TestPort1;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_state1:
					switch(trigger) {
						case TRIG_TestPort1__msg1:
							{ int p1 = (Integer) generic_data;
							if (p1==7)
							{
								chain = CHAIN_TRANS_tr7_FROM_tp0_TO_state0_BY_msg1TestPort1;
								catching_state = STATE_TOP;
								is_handler = true;
							} else 
							if (p1==12)
							{
								chain = CHAIN_TRANS_tr6_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr6;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							} else 
							if (p1==3)
							{
								chain = CHAIN_TRANS_tr1_FROM_tp1_TO_tp1_BY_msg1TestPort1_tr1;
								catching_state = STATE_TOP;
								skip_entry = true;
							} else 
							{
								chain = CHAIN_TRANS_tr0_FROM_tp0_TO_tp0_BY_msg1TestPort1_tr0;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							}
							}
						break;
						case TRIG_TestPort1__msg2:
							{ int p1 = (Integer) generic_data;
							if (p1==4)
							{
								chain = CHAIN_TRANS_tr5_FROM_tp1_TO_tp1_BY_msg2TestPort1_tr5;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
							}
						break;
						case TRIG_TestPort1__msg6:
							{
								chain = CHAIN_TRANS_tr4_FROM_tp1_TO_testOk_BY_msg6TestPort1;
								catching_state = STATE_TOP;
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
