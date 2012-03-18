package org.eclipse.etrice.integration.tests;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.tests.p_HFSM.*;



public class a_HFSM extends ActorClassBase {

	
	//--------------------- ports
	protected p_HFSMPort fct = null;
	//--------------------- saps
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_fct = 1;
		
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public a_HFSM(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("a_HFSM");
		
		// initialize attributes

		// own ports
		fct = new p_HFSMPort(this, "fct", IFITEM_fct, 0, port_addr[IFITEM_fct][0], peer_addr[IFITEM_fct][0]); 
		// own saps
		// own service implementations
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
		destroyUser();
	}	

	
	/* state IDs */
	public static final int STATE_State2 = 2;
	public static final int STATE_State1 = 3;
	public static final int STATE_State2_State1 = 4;
	public static final int STATE_State2_State2 = 5;
	public static final int STATE_State3 = 6;
	public static final int STATE_State4 = 7;
	
	/* transition chains */
	public static final int CHAIN_State2_TRANS_State1_TO_State2_BY_m2fct = 1;
	public static final int CHAIN_State2_TRANS_State2_TO_tp1_BY_m3fct = 2;
	public static final int CHAIN_State2_TRANS_tp3_TO_tp3_BY_m5fct_tr3 = 3;
	public static final int CHAIN_State2_TRANS_tp4_TO_tp4_BY_m6fct_tr4 = 4;
	public static final int CHAIN_TRANS_INITIAL_TO__State1 = 5;
	public static final int CHAIN_TRANS_State1_TO_State2_tp0_BY_m1fct = 6;
	public static final int CHAIN_TRANS_State2_TO_State2_BY_m7fct_tr5 = 7;
	public static final int CHAIN_TRANS_State2_TO_State4_BY_m4fct = 8;
	public static final int CHAIN_TRANS_tp0_TO_State1_BY_resetfct = 9;
	public static final int CHAIN_TRANS_tp1_TO_tp1_BY_m8fct_tr6 = 10;
	public static final int CHAIN_TRANS_tp2_TO_tp2_BY_m9fct_tr7 = 11;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_fct__m1 = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_m1;
	public static final int TRIG_fct__m2 = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_m2;
	public static final int TRIG_fct__m3 = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_m3;
	public static final int TRIG_fct__m4 = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_m4;
	public static final int TRIG_fct__m5 = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_m5;
	public static final int TRIG_fct__m6 = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_m6;
	public static final int TRIG_fct__m7 = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_m7;
	public static final int TRIG_fct__m8 = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_m8;
	public static final int TRIG_fct__m9 = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_m9;
	public static final int TRIG_fct__reset = IFITEM_fct + EVT_SHIFT*p_HFSM.IN_reset;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","State2",
	"State1",
	"State2_State1",
	"State2_State2",
	"State3",
	"State4"
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
	protected void entry_State1() {
		fct.s1_entry();
	}
	protected void exit_State1() {
		fct.s1_exit();
	}
	protected void entry_State2() {
		fct.s2_entry();
	}
	protected void exit_State2() {
		fct.s2_exit();
	}
	protected void entry_State2_State1() {
		fct.s2s1_entry();
	}
	protected void exit_State2_State1() {
		fct.s2s1_exit();
	}
	protected void entry_State2_State2() {
		fct.s2s2_entry();
	}
	protected void exit_State2_State2() {
		fct.s2s2_exit();
	}
	protected void entry_State3() {
		fct.s3_entry();
	}
	protected void exit_State3() {
		fct.s3_exit();
	}
	protected void entry_State4() {
		fct.s4_entry();
	}
	protected void exit_State4() {
		fct.s4_exit();
	}
	
	/* Action Codes */
	protected void action_TRANS_INITIAL_TO__State1() {
		fct.init_action();
	}
	protected void action_TRANS_State1_TO_State2_tp0_BY_m1fct(InterfaceItemBase ifitem) {
		fct.s1_m1_s2_action();
	}
	protected void action_TRANS_State2_tp1_TO_State3(InterfaceItemBase ifitem) {
		fct.s2__s3_action();
	}
	protected void action_TRANS_State2_TO_State4_BY_m4fct(InterfaceItemBase ifitem) {
		fct.s2_m4_s4_action();
	}
	protected void action_TRANS_tp0_TO_State1_BY_resetfct(InterfaceItemBase ifitem) {
		fct.top_reset_s2_action();
	}
	protected void action_TRANS_State2_TO_State2_BY_m7fct_tr5(InterfaceItemBase ifitem) {
		fct.s2_m7_s2_action();
	}
	protected void action_TRANS_tp1_TO_tp1_BY_m8fct_tr6(InterfaceItemBase ifitem) {
		fct.top_s8_top_action();
	}
	protected void action_TRANS_tp2_TO_tp2_BY_m9fct_tr7(InterfaceItemBase ifitem) {
		fct.top_s9_top_action();
	}
	protected void action_State2_TRANS_tp0_TO_State1(InterfaceItemBase ifitem) {
		fct.s2_m1_s2s1_action();
	}
	protected void action_State2_TRANS_State1_TO_State2_BY_m2fct(InterfaceItemBase ifitem) {
		fct.s2s1_m2_s2s2_action();
	}
	protected void action_State2_TRANS_State2_TO_tp1_BY_m3fct(InterfaceItemBase ifitem) {
		fct.s2s2_m3_action();
	}
	protected void action_State2_TRANS_tp3_TO_tp3_BY_m5fct_tr3(InterfaceItemBase ifitem) {
		fct.s2_m5_s2_action();
	}
	protected void action_State2_TRANS_tp4_TO_tp4_BY_m6fct_tr4(InterfaceItemBase ifitem) {
		fct.s2_m6_s2_action();
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
				case STATE_State1:
					if (!handler) exit_State1();
					this.history[STATE_TOP] = STATE_State1;
					current = STATE_TOP;
					break;
				case STATE_State2:
					if (!handler) exit_State2();
					this.history[STATE_TOP] = STATE_State2;
					current = STATE_TOP;
					break;
				case STATE_State2_State1:
					if (!handler) exit_State2_State1();
					this.history[STATE_State2] = STATE_State2_State1;
					current = STATE_State2;
					break;
				case STATE_State2_State2:
					if (!handler) exit_State2_State2();
					this.history[STATE_State2] = STATE_State2_State2;
					current = STATE_State2;
					break;
				case STATE_State3:
					if (!handler) exit_State3();
					this.history[STATE_TOP] = STATE_State3;
					current = STATE_TOP;
					break;
				case STATE_State4:
					if (!handler) exit_State4();
					this.history[STATE_TOP] = STATE_State4;
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
			case CHAIN_TRANS_INITIAL_TO__State1:
			{
				action_TRANS_INITIAL_TO__State1();
				return STATE_State1;
			}
			case CHAIN_TRANS_State1_TO_State2_tp0_BY_m1fct:
			{
				action_TRANS_State1_TO_State2_tp0_BY_m1fct(ifitem);
				entry_State2();
				action_State2_TRANS_tp0_TO_State1(ifitem);
				return STATE_State2_State1;
			}
			case CHAIN_TRANS_State2_TO_State4_BY_m4fct:
			{
				action_TRANS_State2_TO_State4_BY_m4fct(ifitem);
				return STATE_State4;
			}
			case CHAIN_TRANS_tp0_TO_State1_BY_resetfct:
			{
				action_TRANS_tp0_TO_State1_BY_resetfct(ifitem);
				return STATE_State1;
			}
			case CHAIN_TRANS_State2_TO_State2_BY_m7fct_tr5:
			{
				action_TRANS_State2_TO_State2_BY_m7fct_tr5(ifitem);
				return STATE_State2;
			}
			case CHAIN_TRANS_tp1_TO_tp1_BY_m8fct_tr6:
			{
				action_TRANS_tp1_TO_tp1_BY_m8fct_tr6(ifitem);
				return STATE_TOP;
			}
			case CHAIN_TRANS_tp2_TO_tp2_BY_m9fct_tr7:
			{
				action_TRANS_tp2_TO_tp2_BY_m9fct_tr7(ifitem);
				return STATE_TOP;
			}
			case CHAIN_State2_TRANS_State1_TO_State2_BY_m2fct:
			{
				action_State2_TRANS_State1_TO_State2_BY_m2fct(ifitem);
				return STATE_State2_State2;
			}
			case CHAIN_State2_TRANS_State2_TO_tp1_BY_m3fct:
			{
				action_State2_TRANS_State2_TO_tp1_BY_m3fct(ifitem);
				exit_State2();
				action_TRANS_State2_tp1_TO_State3(ifitem);
				return STATE_State3;
			}
			case CHAIN_State2_TRANS_tp3_TO_tp3_BY_m5fct_tr3:
			{
				action_State2_TRANS_tp3_TO_tp3_BY_m5fct_tr3(ifitem);
				return STATE_State2;
			}
			case CHAIN_State2_TRANS_tp4_TO_tp4_BY_m6fct_tr4:
			{
				action_State2_TRANS_tp4_TO_tp4_BY_m6fct_tr4(ifitem);
				return STATE_State2;
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
				case STATE_State1:
					if (!(skip_entry || handler)) entry_State1();
					// in leaf state: return state id
					return STATE_State1;
				case STATE_State2:
					if (!(skip_entry || handler)) entry_State2();
					// state has a sub graph
					// without init transition
					state = this.history[STATE_State2];
					break;
				case STATE_State2_State1:
					if (!(skip_entry || handler)) entry_State2_State1();
					// in leaf state: return state id
					return STATE_State2_State1;
				case STATE_State2_State2:
					if (!(skip_entry || handler)) entry_State2_State2();
					// in leaf state: return state id
					return STATE_State2_State2;
				case STATE_State3:
					if (!(skip_entry || handler)) entry_State3();
					// in leaf state: return state id
					return STATE_State3;
				case STATE_State4:
					if (!(skip_entry || handler)) entry_State4();
					// in leaf state: return state id
					return STATE_State4;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__State1;
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
				case STATE_State1:
					switch(trigger) {
						case TRIG_fct__m1:
							{
								chain = CHAIN_TRANS_State1_TO_State2_tp0_BY_m1fct;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__reset:
							{
								chain = CHAIN_TRANS_tp0_TO_State1_BY_resetfct;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__m8:
							{
								chain = CHAIN_TRANS_tp1_TO_tp1_BY_m8fct_tr6;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
						case TRIG_fct__m9:
							{
								chain = CHAIN_TRANS_tp2_TO_tp2_BY_m9fct_tr7;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_State2_State1:
					switch(trigger) {
						case TRIG_fct__m2:
							{
								chain = CHAIN_State2_TRANS_State1_TO_State2_BY_m2fct;
								catching_state = STATE_State2;
							}
						break;
						case TRIG_fct__m5:
							{
								chain = CHAIN_State2_TRANS_tp3_TO_tp3_BY_m5fct_tr3;
								catching_state = STATE_State2;
								skip_entry = true;
							}
						break;
						case TRIG_fct__m6:
							{
								chain = CHAIN_State2_TRANS_tp4_TO_tp4_BY_m6fct_tr4;
								catching_state = STATE_State2;
								is_handler = true;
								skip_entry = true;
							}
						break;
						case TRIG_fct__m4:
							{
								chain = CHAIN_TRANS_State2_TO_State4_BY_m4fct;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__m7:
							{
								chain = CHAIN_TRANS_State2_TO_State2_BY_m7fct_tr5;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__reset:
							{
								chain = CHAIN_TRANS_tp0_TO_State1_BY_resetfct;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__m8:
							{
								chain = CHAIN_TRANS_tp1_TO_tp1_BY_m8fct_tr6;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
						case TRIG_fct__m9:
							{
								chain = CHAIN_TRANS_tp2_TO_tp2_BY_m9fct_tr7;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_State2_State2:
					switch(trigger) {
						case TRIG_fct__m3:
							{
								chain = CHAIN_State2_TRANS_State2_TO_tp1_BY_m3fct;
								catching_state = STATE_State2;
							}
						break;
						case TRIG_fct__m5:
							{
								chain = CHAIN_State2_TRANS_tp3_TO_tp3_BY_m5fct_tr3;
								catching_state = STATE_State2;
								skip_entry = true;
							}
						break;
						case TRIG_fct__m6:
							{
								chain = CHAIN_State2_TRANS_tp4_TO_tp4_BY_m6fct_tr4;
								catching_state = STATE_State2;
								is_handler = true;
								skip_entry = true;
							}
						break;
						case TRIG_fct__m4:
							{
								chain = CHAIN_TRANS_State2_TO_State4_BY_m4fct;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__m7:
							{
								chain = CHAIN_TRANS_State2_TO_State2_BY_m7fct_tr5;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__reset:
							{
								chain = CHAIN_TRANS_tp0_TO_State1_BY_resetfct;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__m8:
							{
								chain = CHAIN_TRANS_tp1_TO_tp1_BY_m8fct_tr6;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
						case TRIG_fct__m9:
							{
								chain = CHAIN_TRANS_tp2_TO_tp2_BY_m9fct_tr7;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_State3:
					switch(trigger) {
						case TRIG_fct__reset:
							{
								chain = CHAIN_TRANS_tp0_TO_State1_BY_resetfct;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__m8:
							{
								chain = CHAIN_TRANS_tp1_TO_tp1_BY_m8fct_tr6;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
						case TRIG_fct__m9:
							{
								chain = CHAIN_TRANS_tp2_TO_tp2_BY_m9fct_tr7;
								catching_state = STATE_TOP;
								is_handler = true;
								skip_entry = true;
							}
						break;
					}
					break;
				case STATE_State4:
					switch(trigger) {
						case TRIG_fct__reset:
							{
								chain = CHAIN_TRANS_tp0_TO_State1_BY_resetfct;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_fct__m8:
							{
								chain = CHAIN_TRANS_tp1_TO_tp1_BY_m8fct_tr6;
								catching_state = STATE_TOP;
								skip_entry = true;
							}
						break;
						case TRIG_fct__m9:
							{
								chain = CHAIN_TRANS_tp2_TO_tp2_BY_m9fct_tr7;
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
