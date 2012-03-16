package org.eclipse.etrice.integration.PingPongThreadTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.PingPongThreadTest.PingPongProtocol.*;



public class MrPongActor1 extends ActorClassBase {

	
	//--------------------- ports
	protected PingPongProtocolPort PingPongPort = null;
	//--------------------- saps
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_PingPongPort = 1;
		
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public MrPongActor1(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("MrPongActor1");
		
		// initialize attributes

		// own ports
		PingPongPort = new PingPongProtocolPort(this, "PingPongPort", IFITEM_PingPongPort, 0, port_addr[IFITEM_PingPongPort][0], peer_addr[IFITEM_PingPongPort][0]); 
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
	public static final int STATE_waitForPing = 2;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__waitForPing = 1;
	public static final int CHAIN_TRANS_waitForPing_TO_waitForPing_BY_pingPingPongPort_myTrigger = 2;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_PingPongPort__ping = IFITEM_PingPongPort + EVT_SHIFT*PingPongProtocol.IN_ping;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","waitForPing"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_waitForPing_TO_waitForPing_BY_pingPingPongPort_myTrigger(InterfaceItemBase ifitem) {
		PingPongPort.pong();
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
				case STATE_waitForPing:
					this.history[STATE_TOP] = STATE_waitForPing;
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
			case CHAIN_TRANS_INITIAL_TO__waitForPing:
			{
				return STATE_waitForPing;
			}
			case CHAIN_TRANS_waitForPing_TO_waitForPing_BY_pingPingPongPort_myTrigger:
			{
				action_TRANS_waitForPing_TO_waitForPing_BY_pingPingPongPort_myTrigger(ifitem);
				return STATE_waitForPing;
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
				case STATE_waitForPing:
					// in leaf state: return state id
					return STATE_waitForPing;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__waitForPing;
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
				case STATE_waitForPing:
					switch(trigger) {
						case TRIG_PingPongPort__ping:
							{
								chain = CHAIN_TRANS_waitForPing_TO_waitForPing_BY_pingPingPongPort_myTrigger;
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
