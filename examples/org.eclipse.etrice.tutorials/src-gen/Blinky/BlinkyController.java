package Blinky;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;

import room.basic.service.timing.*;

import Blinky.BlinkyControlProtocoll.*;
import room.basic.service.timing.PTimeout.*;



public class BlinkyController extends ActorClassBase {

	
	//--------------------- ports
	protected BlinkyControlProtocollConjPort ControlPort = null;
	
	//--------------------- saps
	protected PTimeoutConjPort timer = null;
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_ControlPort = 1;
	public static final int IFITEM_timer = 2;
		
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public BlinkyController(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("BlinkyController");
		
		// initialize attributes

		// own ports
		ControlPort = new BlinkyControlProtocollConjPort(this, "ControlPort", IFITEM_ControlPort, 0, port_addr[IFITEM_ControlPort][0], peer_addr[IFITEM_ControlPort][0]); 
		
		// own saps
		timer = new PTimeoutConjPort(this, "timer", IFITEM_timer, 0, port_addr[IFITEM_timer][0], peer_addr[IFITEM_timer][0]); 
		
		// own service implementations
	}
	//--------------------- attributes getter and setter
	//--------------------- attribute setters and getters
	//--------------------- port getters
	public BlinkyControlProtocollConjPort getControlPort (){
		return this.ControlPort;
	}
	public PTimeoutConjPort getTimer (){
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
	public static final int STATE_on = 2;
	public static final int STATE_off = 3;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__on = 1;
	public static final int CHAIN_TRANS_goOff_FROM_on_TO_off_BY_timeoutTicktimer = 2;
	public static final int CHAIN_TRANS_goOn_FROM_off_TO_on_BY_timeoutTicktimer = 3;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_timer__timeoutTick = IFITEM_timer + EVT_SHIFT*PTimeout.OUT_timeoutTick;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","on",
	"off"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_INITIAL_TO__on() {
		timer.Start(5000);
		ControlPort.start();
	}
	protected void action_TRANS_goOff_FROM_on_TO_off_BY_timeoutTicktimer(InterfaceItemBase ifitem) {
		ControlPort.stop();
		timer.Start(5000);
	}
	protected void action_TRANS_goOn_FROM_off_TO_on_BY_timeoutTicktimer(InterfaceItemBase ifitem) {
		ControlPort.start();
		timer.Start(5000);
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
				case STATE_on:
					this.history[STATE_TOP] = STATE_on;
					current = STATE_TOP;
					break;
				case STATE_off:
					this.history[STATE_TOP] = STATE_off;
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
			case CHAIN_TRANS_INITIAL_TO__on:
			{
				action_TRANS_INITIAL_TO__on();
				return STATE_on;
			}
			case CHAIN_TRANS_goOff_FROM_on_TO_off_BY_timeoutTicktimer:
			{
				action_TRANS_goOff_FROM_on_TO_off_BY_timeoutTicktimer(ifitem);
				return STATE_off;
			}
			case CHAIN_TRANS_goOn_FROM_off_TO_on_BY_timeoutTicktimer:
			{
				action_TRANS_goOn_FROM_off_TO_on_BY_timeoutTicktimer(ifitem);
				return STATE_on;
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
				case STATE_on:
					// in leaf state: return state id
					return STATE_on;
				case STATE_off:
					// in leaf state: return state id
					return STATE_off;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__on;
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
				case STATE_on:
					switch(trigger) {
						case TRIG_timer__timeoutTick:
							{
								chain = CHAIN_TRANS_goOff_FROM_on_TO_off_BY_timeoutTicktimer;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_off:
					switch(trigger) {
						case TRIG_timer__timeoutTick:
							{
								chain = CHAIN_TRANS_goOn_FROM_off_TO_on_BY_timeoutTicktimer;
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
