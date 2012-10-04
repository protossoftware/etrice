package trafficlight.example;

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
import trafficlight.example.PTrafficLight.*;



public class TrafficController extends ActorClassBase {

	
	
	//--------------------- ports
	protected PTrafficLightConjPort light1 = null;
	protected PTrafficLightConjPort light2 = null;
	
	//--------------------- saps
	protected PTimerConjPort timeout = null;
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_light1 = 1;
	public static final int IFITEM_light2 = 2;
	public static final int IFITEM_timeout = 3;

		
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public TrafficController(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("TrafficController");
		
		// initialize attributes

		// own ports
		light1 = new PTrafficLightConjPort(this, "light1", IFITEM_light1, 0, port_addr[IFITEM_light1][0], peer_addr[IFITEM_light1][0]); 
		light2 = new PTrafficLightConjPort(this, "light2", IFITEM_light2, 0, port_addr[IFITEM_light2][0], peer_addr[IFITEM_light2][0]); 
		
		// own saps
		timeout = new PTimerConjPort(this, "timeout", IFITEM_timeout, 0, port_addr[IFITEM_timeout][0], peer_addr[IFITEM_timeout][0]); 
		
		// own service implementations
	}

	
	//--------------------- attribute setters and getters
	
	
	//--------------------- port getters
	public PTrafficLightConjPort getLight1 (){
		return this.light1;
	}
	public PTrafficLightConjPort getLight2 (){
		return this.light2;
	}
	public PTimerConjPort getTimeout (){
		return this.timeout;
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
	public static final int STATE_Idle = 2;
	public static final int STATE_Light1GreenForCars = 3;
	public static final int STATE_SwitchToLight1GreenForCars = 4;
	public static final int STATE_state0 = 5;
	public static final int STATE_state1 = 6;
	public static final int STATE_SwitchToLight2GreenForCars = 7;
	public static final int STATE_state2 = 8;
	public static final int STATE_state3 = 9;
	public static final int STATE_Light2GreenForCars = 10;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Idle = 1;
	public static final int CHAIN_TRANS_tr0_FROM_Idle_TO_SwitchToLight1GreenForCars_BY_timeouttimeout = 2;
	public static final int CHAIN_TRANS_tr10_FROM_Light2GreenForCars_TO_SwitchToLight1GreenForCars_BY_timeouttimeout = 3;
	public static final int CHAIN_TRANS_tr1_FROM_SwitchToLight1GreenForCars_TO_state0_BY_greenForCarDonelight1 = 4;
	public static final int CHAIN_TRANS_tr2_FROM_SwitchToLight1GreenForCars_TO_state1_BY_greenForPedDonelight2 = 5;
	public static final int CHAIN_TRANS_tr3_FROM_state1_TO_Light1GreenForCars_BY_greenForCarDonelight1 = 6;
	public static final int CHAIN_TRANS_tr4_FROM_state0_TO_Light1GreenForCars_BY_greenForPedDonelight2 = 7;
	public static final int CHAIN_TRANS_tr5_FROM_Light1GreenForCars_TO_SwitchToLight2GreenForCars_BY_timeouttimeout = 8;
	public static final int CHAIN_TRANS_tr6_FROM_SwitchToLight2GreenForCars_TO_state2_BY_greenForPedDonelight1 = 9;
	public static final int CHAIN_TRANS_tr7_FROM_SwitchToLight2GreenForCars_TO_state3_BY_greenForCarDonelight2 = 10;
	public static final int CHAIN_TRANS_tr8_FROM_state2_TO_Light2GreenForCars_BY_greenForCarDonelight2 = 11;
	public static final int CHAIN_TRANS_tr9_FROM_state3_TO_Light2GreenForCars_BY_greenForPedDonelight1 = 12;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_light1__greenForCarDone = IFITEM_light1 + EVT_SHIFT*PTrafficLight.OUT_greenForCarDone;
	public static final int TRIG_light1__greenForPedDone = IFITEM_light1 + EVT_SHIFT*PTrafficLight.OUT_greenForPedDone;
	public static final int TRIG_light2__greenForCarDone = IFITEM_light2 + EVT_SHIFT*PTrafficLight.OUT_greenForCarDone;
	public static final int TRIG_light2__greenForPedDone = IFITEM_light2 + EVT_SHIFT*PTrafficLight.OUT_greenForPedDone;
	public static final int TRIG_timeout__timeout = IFITEM_timeout + EVT_SHIFT*PTimer.OUT_timeout;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Idle",
	"Light1GreenForCars",
	"SwitchToLight1GreenForCars",
	"state0",
	"state1",
	"SwitchToLight2GreenForCars",
	"state2",
	"state3",
	"Light2GreenForCars"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_Idle() {
		timeout.startTimeout(3000);
	}
	protected void entry_Light1GreenForCars() {
		timeout.startTimeout(10000);
	}
	protected void entry_SwitchToLight1GreenForCars() {
		light1.greenForCar();
		light2.greenForPed();
	}
	protected void entry_SwitchToLight2GreenForCars() {
		light1.greenForPed();
		light2.greenForCar();
	}
	protected void entry_Light2GreenForCars() {
		timeout.startTimeout(10000);
	}
	
	/* Action Codes */
	
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
				case STATE_Idle:
					this.history[STATE_TOP] = STATE_Idle;
					current = STATE_TOP;
					break;
				case STATE_Light1GreenForCars:
					this.history[STATE_TOP] = STATE_Light1GreenForCars;
					current = STATE_TOP;
					break;
				case STATE_SwitchToLight1GreenForCars:
					this.history[STATE_TOP] = STATE_SwitchToLight1GreenForCars;
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
				case STATE_SwitchToLight2GreenForCars:
					this.history[STATE_TOP] = STATE_SwitchToLight2GreenForCars;
					current = STATE_TOP;
					break;
				case STATE_state2:
					this.history[STATE_TOP] = STATE_state2;
					current = STATE_TOP;
					break;
				case STATE_state3:
					this.history[STATE_TOP] = STATE_state3;
					current = STATE_TOP;
					break;
				case STATE_Light2GreenForCars:
					this.history[STATE_TOP] = STATE_Light2GreenForCars;
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
			case CHAIN_TRANS_INITIAL_TO__Idle:
			{
				return STATE_Idle;
			}
			case CHAIN_TRANS_tr0_FROM_Idle_TO_SwitchToLight1GreenForCars_BY_timeouttimeout:
			{
				return STATE_SwitchToLight1GreenForCars;
			}
			case CHAIN_TRANS_tr1_FROM_SwitchToLight1GreenForCars_TO_state0_BY_greenForCarDonelight1:
			{
				return STATE_state0;
			}
			case CHAIN_TRANS_tr2_FROM_SwitchToLight1GreenForCars_TO_state1_BY_greenForPedDonelight2:
			{
				return STATE_state1;
			}
			case CHAIN_TRANS_tr3_FROM_state1_TO_Light1GreenForCars_BY_greenForCarDonelight1:
			{
				return STATE_Light1GreenForCars;
			}
			case CHAIN_TRANS_tr4_FROM_state0_TO_Light1GreenForCars_BY_greenForPedDonelight2:
			{
				return STATE_Light1GreenForCars;
			}
			case CHAIN_TRANS_tr5_FROM_Light1GreenForCars_TO_SwitchToLight2GreenForCars_BY_timeouttimeout:
			{
				return STATE_SwitchToLight2GreenForCars;
			}
			case CHAIN_TRANS_tr6_FROM_SwitchToLight2GreenForCars_TO_state2_BY_greenForPedDonelight1:
			{
				return STATE_state2;
			}
			case CHAIN_TRANS_tr7_FROM_SwitchToLight2GreenForCars_TO_state3_BY_greenForCarDonelight2:
			{
				return STATE_state3;
			}
			case CHAIN_TRANS_tr8_FROM_state2_TO_Light2GreenForCars_BY_greenForCarDonelight2:
			{
				return STATE_Light2GreenForCars;
			}
			case CHAIN_TRANS_tr9_FROM_state3_TO_Light2GreenForCars_BY_greenForPedDonelight1:
			{
				return STATE_Light2GreenForCars;
			}
			case CHAIN_TRANS_tr10_FROM_Light2GreenForCars_TO_SwitchToLight1GreenForCars_BY_timeouttimeout:
			{
				return STATE_SwitchToLight1GreenForCars;
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
				case STATE_Idle:
					if (!(skip_entry || handler)) entry_Idle();
					// in leaf state: return state id
					return STATE_Idle;
				case STATE_Light1GreenForCars:
					if (!(skip_entry || handler)) entry_Light1GreenForCars();
					// in leaf state: return state id
					return STATE_Light1GreenForCars;
				case STATE_SwitchToLight1GreenForCars:
					if (!(skip_entry || handler)) entry_SwitchToLight1GreenForCars();
					// in leaf state: return state id
					return STATE_SwitchToLight1GreenForCars;
				case STATE_state0:
					// in leaf state: return state id
					return STATE_state0;
				case STATE_state1:
					// in leaf state: return state id
					return STATE_state1;
				case STATE_SwitchToLight2GreenForCars:
					if (!(skip_entry || handler)) entry_SwitchToLight2GreenForCars();
					// in leaf state: return state id
					return STATE_SwitchToLight2GreenForCars;
				case STATE_state2:
					// in leaf state: return state id
					return STATE_state2;
				case STATE_state3:
					// in leaf state: return state id
					return STATE_state3;
				case STATE_Light2GreenForCars:
					if (!(skip_entry || handler)) entry_Light2GreenForCars();
					// in leaf state: return state id
					return STATE_Light2GreenForCars;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__Idle;
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
				case STATE_Idle:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr0_FROM_Idle_TO_SwitchToLight1GreenForCars_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_Light1GreenForCars:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr5_FROM_Light1GreenForCars_TO_SwitchToLight2GreenForCars_BY_timeouttimeout;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_SwitchToLight1GreenForCars:
					switch(trigger) {
						case TRIG_light1__greenForCarDone:
							{
								chain = CHAIN_TRANS_tr1_FROM_SwitchToLight1GreenForCars_TO_state0_BY_greenForCarDonelight1;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_light2__greenForPedDone:
							{
								chain = CHAIN_TRANS_tr2_FROM_SwitchToLight1GreenForCars_TO_state1_BY_greenForPedDonelight2;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_state0:
					switch(trigger) {
						case TRIG_light2__greenForPedDone:
							{
								chain = CHAIN_TRANS_tr4_FROM_state0_TO_Light1GreenForCars_BY_greenForPedDonelight2;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_state1:
					switch(trigger) {
						case TRIG_light1__greenForCarDone:
							{
								chain = CHAIN_TRANS_tr3_FROM_state1_TO_Light1GreenForCars_BY_greenForCarDonelight1;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_SwitchToLight2GreenForCars:
					switch(trigger) {
						case TRIG_light1__greenForPedDone:
							{
								chain = CHAIN_TRANS_tr6_FROM_SwitchToLight2GreenForCars_TO_state2_BY_greenForPedDonelight1;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_light2__greenForCarDone:
							{
								chain = CHAIN_TRANS_tr7_FROM_SwitchToLight2GreenForCars_TO_state3_BY_greenForCarDonelight2;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_state2:
					switch(trigger) {
						case TRIG_light2__greenForCarDone:
							{
								chain = CHAIN_TRANS_tr8_FROM_state2_TO_Light2GreenForCars_BY_greenForCarDonelight2;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_state3:
					switch(trigger) {
						case TRIG_light1__greenForPedDone:
							{
								chain = CHAIN_TRANS_tr9_FROM_state3_TO_Light2GreenForCars_BY_greenForPedDonelight1;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_Light2GreenForCars:
					switch(trigger) {
						case TRIG_timeout__timeout:
							{
								chain = CHAIN_TRANS_tr10_FROM_Light2GreenForCars_TO_SwitchToLight1GreenForCars_BY_timeouttimeout;
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
