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

/*--------------------- begin user code ---------------------*/
import org.eclipse.etrice.tutorials.PedLightGUI.*;
/*--------------------- end user code ---------------------*/


public class Blinky extends ActorClassBase {

	/*--------------------- begin user code ---------------------*/
	private PedestrianLightWndNoTcp light = new PedestrianLightWndNoTcp();
	private TrafficLight3 carLights;
	private TrafficLight2 pedLights;
	/*--------------------- end user code ---------------------*/
	
	//--------------------- ports
	protected BlinkyControlProtocollPort ControlPort = null;
	
	//--------------------- saps
	protected PTimeoutConjPort timer = null;
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_ControlPort = 1;
	public static final int IFITEM_timer = 2;
		
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/
	public void Blinky_dtor() {
		light.closeWindow();
	}

	//--------------------- construction
	public Blinky(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("Blinky");
		
		// initialize attributes

		// own ports
		ControlPort = new BlinkyControlProtocollPort(this, "ControlPort", IFITEM_ControlPort, 0, port_addr[IFITEM_ControlPort][0], peer_addr[IFITEM_ControlPort][0]); 
		
		// own saps
		timer = new PTimeoutConjPort(this, "timer", IFITEM_timer, 0, port_addr[IFITEM_timer][0], peer_addr[IFITEM_timer][0]); 
		
		// own service implementations
	}
	//--------------------- attribute setters and getters
	//--------------------- port getters
	public BlinkyControlProtocollPort getControlPort (){
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
		Blinky_dtor();
	}

	
	/* state IDs */
	public static final int STATE_blinking = 2;
	public static final int STATE_off = 3;
	public static final int STATE_blinking_on = 4;
	public static final int STATE_blinking_off = 5;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__off = 1;
	public static final int CHAIN_TRANS_tr0_FROM_off_TO_blinking_tp0_BY_startControlPort = 2;
	public static final int CHAIN_TRANS_tr1_FROM_blinking_TO_off_BY_stopControlPort = 3;
	public static final int CHAIN_blinking_TRANS_INITIAL_TO__on = 4;
	public static final int CHAIN_blinking_TRANS_tr1_FROM_on_TO_off_BY_timeoutTicktimer = 5;
	public static final int CHAIN_blinking_TRANS_tr2_FROM_off_TO_on_BY_timeoutTicktimer = 6;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_ControlPort__start = IFITEM_ControlPort + EVT_SHIFT*BlinkyControlProtocoll.IN_start;
	public static final int TRIG_ControlPort__stop = IFITEM_ControlPort + EVT_SHIFT*BlinkyControlProtocoll.IN_stop;
	public static final int TRIG_timer__timeoutTick = IFITEM_timer + EVT_SHIFT*PTimeout.OUT_timeoutTick;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","blinking",
	"off",
	"blinking_on",
	"blinking_off"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_blinking_on() {
		timer.Start(1000);
		carLights.setState(TrafficLight3.YELLOW);
	}
	protected void entry_blinking_off() {
		timer.Start(1000);
		carLights.setState(TrafficLight3.OFF);
	}
	
	/* Action Codes */
	protected void action_TRANS_INITIAL_TO__off() {
		carLights = light.getCarLights();
		pedLights = light.getPedLights();
		carLights.setState(TrafficLight3.OFF);
		pedLights.setState(TrafficLight2.OFF);
	}
	protected void action_TRANS_tr1_FROM_blinking_TO_off_BY_stopControlPort(InterfaceItemBase ifitem) {
		timer.Kill();
		carLights.setState(TrafficLight3.OFF);
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
				case STATE_off:
					this.history[STATE_TOP] = STATE_off;
					current = STATE_TOP;
					break;
				case STATE_blinking:
					this.history[STATE_TOP] = STATE_blinking;
					current = STATE_TOP;
					break;
				case STATE_blinking_on:
					this.history[STATE_blinking] = STATE_blinking_on;
					current = STATE_blinking;
					break;
				case STATE_blinking_off:
					this.history[STATE_blinking] = STATE_blinking_off;
					current = STATE_blinking;
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
			case CHAIN_TRANS_INITIAL_TO__off:
			{
				action_TRANS_INITIAL_TO__off();
				return STATE_off;
			}
			case CHAIN_TRANS_tr0_FROM_off_TO_blinking_tp0_BY_startControlPort:
			{
				return STATE_blinking_on;
			}
			case CHAIN_TRANS_tr1_FROM_blinking_TO_off_BY_stopControlPort:
			{
				action_TRANS_tr1_FROM_blinking_TO_off_BY_stopControlPort(ifitem);
				return STATE_off;
			}
			case CHAIN_blinking_TRANS_tr1_FROM_on_TO_off_BY_timeoutTicktimer:
			{
				return STATE_blinking_off;
			}
			case CHAIN_blinking_TRANS_tr2_FROM_off_TO_on_BY_timeoutTicktimer:
			{
				return STATE_blinking_on;
			}
			case CHAIN_blinking_TRANS_INITIAL_TO__on:
			{
				return STATE_blinking_on;
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
				case STATE_off:
					// in leaf state: return state id
					return STATE_off;
				case STATE_blinking:
					// state has a sub graph
					// with init transition
					if (this.history[STATE_blinking]==NO_STATE) {
						state = executeTransitionChain(CHAIN_blinking_TRANS_INITIAL_TO__on, null, null);
					}
					else {
						state = this.history[STATE_blinking];
					}
					break;
				case STATE_blinking_on:
					if (!(skip_entry || handler)) entry_blinking_on();
					// in leaf state: return state id
					return STATE_blinking_on;
				case STATE_blinking_off:
					if (!(skip_entry || handler)) entry_blinking_off();
					// in leaf state: return state id
					return STATE_blinking_off;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__off;
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
				case STATE_off:
					switch(trigger) {
						case TRIG_ControlPort__start:
							{
								chain = CHAIN_TRANS_tr0_FROM_off_TO_blinking_tp0_BY_startControlPort;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_blinking_on:
					switch(trigger) {
						case TRIG_timer__timeoutTick:
							{
								chain = CHAIN_blinking_TRANS_tr1_FROM_on_TO_off_BY_timeoutTicktimer;
								catching_state = STATE_blinking;
							}
						break;
						case TRIG_ControlPort__stop:
							{
								chain = CHAIN_TRANS_tr1_FROM_blinking_TO_off_BY_stopControlPort;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_blinking_off:
					switch(trigger) {
						case TRIG_timer__timeoutTick:
							{
								chain = CHAIN_blinking_TRANS_tr2_FROM_off_TO_on_BY_timeoutTicktimer;
								catching_state = STATE_blinking;
							}
						break;
						case TRIG_ControlPort__stop:
							{
								chain = CHAIN_TRANS_tr1_FROM_blinking_TO_off_BY_stopControlPort;
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
