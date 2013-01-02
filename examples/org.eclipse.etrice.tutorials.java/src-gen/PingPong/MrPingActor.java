package PingPong;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

import room.basic.service.timing.*;

import room.basic.service.timing.PTimer.*;
import PingPong.PingPongProtocol.*;



public class MrPingActor extends ActorClassBase {

	
	
	//--------------------- ports
	protected PingPongProtocolConjReplPort PingPongPort = null;
	
	//--------------------- saps
	protected PTimerConjPort timer = null;
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_PingPongPort = 1;
	public static final int IFITEM_timer = 2;

	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public MrPingActor(IRTObject parent, String name) {
		super(parent, name);
		setClassName("MrPingActor");
		
		// initialize attributes

		// own ports
		PingPongPort = new PingPongProtocolConjReplPort(this, "PingPongPort", IFITEM_PingPongPort); 
		
		// own saps
		timer = new PTimerConjPort(this, "timer", IFITEM_timer, 0); 
		
		// own service implementations
	}

	
	//--------------------- attribute setters and getters
	
	
	//--------------------- port getters
	public PingPongProtocolConjReplPort getPingPongPort (){
		return this.PingPongPort;
	}
	public PTimerConjPort getTimer (){
		return this.timer;
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
	public static final int STATE_waitForTimer = 2;
	public static final int STATE_waitForPong = 3;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__waitForTimer = 1;
	public static final int CHAIN_TRANS_tr1_FROM_waitForTimer_TO_waitForPong_BY_timeouttimer = 2;
	public static final int CHAIN_TRANS_tr2_FROM_waitForPong_TO_waitForTimer_BY_pongPingPongPort = 3;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_PingPongPort__pong = IFITEM_PingPongPort + EVT_SHIFT*PingPongProtocol.OUT_pong;
	public static final int TRIG_timer__timeout = IFITEM_timer + EVT_SHIFT*PTimer.OUT_timeout;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","waitForTimer",
	"waitForPong"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println("state switch of "+getInstancePath() + ": "
					+ stateStrings[this.state] + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_INITIAL_TO__waitForTimer() {
		timer.startTimeout(1000);
	}
	protected void action_TRANS_tr1_FROM_waitForTimer_TO_waitForPong_BY_timeouttimer(InterfaceItemBase ifitem) {
		PingPongPort.ping();
	}
	protected void action_TRANS_tr2_FROM_waitForPong_TO_waitForTimer_BY_pongPingPongPort(InterfaceItemBase ifitem) {
		timer.startTimeout(1000);
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
				case STATE_waitForTimer:
					this.history[STATE_TOP] = STATE_waitForTimer;
					current = STATE_TOP;
					break;
				case STATE_waitForPong:
					this.history[STATE_TOP] = STATE_waitForPong;
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
			case CHAIN_TRANS_INITIAL_TO__waitForTimer:
			{
				action_TRANS_INITIAL_TO__waitForTimer();
				return STATE_waitForTimer;
			}
			case CHAIN_TRANS_tr1_FROM_waitForTimer_TO_waitForPong_BY_timeouttimer:
			{
				action_TRANS_tr1_FROM_waitForTimer_TO_waitForPong_BY_timeouttimer(ifitem);
				return STATE_waitForPong;
			}
			case CHAIN_TRANS_tr2_FROM_waitForPong_TO_waitForTimer_BY_pongPingPongPort:
			{
				action_TRANS_tr2_FROM_waitForPong_TO_waitForTimer_BY_pongPingPongPort(ifitem);
				return STATE_waitForTimer;
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
				case STATE_waitForTimer:
					// in leaf state: return state id
					return STATE_waitForTimer;
				case STATE_waitForPong:
					// in leaf state: return state id
					return STATE_waitForPong;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__waitForTimer;
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
			switch (getState()) {
				case STATE_waitForTimer:
					switch(trigger) {
						case TRIG_timer__timeout:
							{
								chain = CHAIN_TRANS_tr1_FROM_waitForTimer_TO_waitForPong_BY_timeouttimer;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_waitForPong:
					switch(trigger) {
						case TRIG_PingPongPort__pong:
							{
								chain = CHAIN_TRANS_tr2_FROM_waitForPong_TO_waitForTimer_BY_pongPingPongPort;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(getState(), catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
