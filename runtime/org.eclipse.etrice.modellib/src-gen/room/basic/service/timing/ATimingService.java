package room.basic.service.timing;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import room.basic.service.timing.PTimeout.*;
import room.basic.service.timing.PTimer.*;

/*--------------------- begin user code ---------------------*/
	import java.util.Timer;
/*--------------------- end user code ---------------------*/


public class ATimingService extends ActorClassBase {

	/*--------------------- begin user code ---------------------*/
		private Timer timerService = null;
		private int taskCount = 0;
		private static final int PURGE_LIMIT = 1000;
	/*--------------------- end user code ---------------------*/
	
	//--------------------- ports
	//--------------------- saps
	//--------------------- services
	protected PTimerReplPort timer = null;
	protected PTimeoutReplPort timeout = null;

	//--------------------- interface item IDs
	public static final int IFITEM_timer = 1;
	public static final int IFITEM_timeout = 2;
		
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/
	public void stop() {
		System.out.println(toString() + "::stop()");
		timerService.cancel();
		timerService = null;
	}

	//--------------------- construction
	public ATimingService(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("ATimingService");
		
		// initialize attributes

		// own ports
		// own saps
		// own service implementations
		timer = new PTimerReplPort(this, "timer", IFITEM_timer, port_addr[IFITEM_timer], peer_addr[IFITEM_timer]); 
		timeout = new PTimeoutReplPort(this, "timeout", IFITEM_timeout, port_addr[IFITEM_timeout], peer_addr[IFITEM_timeout]); 
	}
	

	//--------------------- lifecycle functions
	public void init(){
		initUser();
	}

	public void start(){
		startUser();
	}

	
	public void destroy(){
		destroyUser();
	}	

	
	/* state IDs */
	public static final int STATE_Operational = 2;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Operational = 1;
	public static final int CHAIN_TRANS_Operational_TO_Operational_BY_Killtimeout_tr2 = 2;
	public static final int CHAIN_TRANS_Operational_TO_Operational_BY_Killtimer_tr4 = 3;
	public static final int CHAIN_TRANS_Operational_TO_Operational_BY_Starttimeout_tr1 = 4;
	public static final int CHAIN_TRANS_Operational_TO_Operational_BY_Starttimer_tr3 = 5;
	
	/* triggers */
	public static final int TRIG_timeout__Kill = IFITEM_timeout + EVT_SHIFT*PTimeout.IN_Kill;
	public static final int TRIG_timeout__Start = IFITEM_timeout + EVT_SHIFT*PTimeout.IN_Start;
	public static final int TRIG_timer__Kill = IFITEM_timer + EVT_SHIFT*PTimer.IN_Kill;
	public static final int TRIG_timer__Start = IFITEM_timer + EVT_SHIFT*PTimer.IN_Start;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Operational"
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
	protected void entry_Operational() {
		// prepare
	}
	
	/* Action Codes */
	protected void action_TRANS_INITIAL_TO__Operational() {
		timerService = new Timer();
	}
	protected void action_TRANS_Operational_TO_Operational_BY_Starttimeout_tr1(InterfaceItemBase ifitem, int time_ms) {
		// start timeout
		taskCount++;
		if (taskCount>PURGE_LIMIT) timerService.purge();
		timerService.schedule(((PTimeoutPort)ifitem).getTask(), time_ms);
	}
	protected void action_TRANS_Operational_TO_Operational_BY_Starttimer_tr3(InterfaceItemBase ifitem, int time_ms) {
		// start timer
		taskCount++;
		if (taskCount>PURGE_LIMIT) timerService.purge();
		timerService.scheduleAtFixedRate(((PTimerPort)ifitem).getTask(), time_ms, time_ms);
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
				case STATE_Operational:
					this.history[STATE_TOP] = STATE_Operational;
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
			case CHAIN_TRANS_INITIAL_TO__Operational:
			{
				action_TRANS_INITIAL_TO__Operational();
				return STATE_Operational;
			}
			case CHAIN_TRANS_Operational_TO_Operational_BY_Starttimeout_tr1:
			{
				int time_ms = (Integer) generic_data;
				action_TRANS_Operational_TO_Operational_BY_Starttimeout_tr1(ifitem, time_ms);
				return STATE_Operational;
			}
			case CHAIN_TRANS_Operational_TO_Operational_BY_Killtimeout_tr2:
			{
				return STATE_Operational;
			}
			case CHAIN_TRANS_Operational_TO_Operational_BY_Starttimer_tr3:
			{
				int time_ms = (Integer) generic_data;
				action_TRANS_Operational_TO_Operational_BY_Starttimer_tr3(ifitem, time_ms);
				return STATE_Operational;
			}
			case CHAIN_TRANS_Operational_TO_Operational_BY_Killtimer_tr4:
			{
				return STATE_Operational;
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
				case STATE_Operational:
					if (!(skip_entry || handler)) entry_Operational();
					// in leaf state: return state id
					return STATE_Operational;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__Operational;
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
				case STATE_Operational:
					switch(trigger) {
					case TRIG_timeout__Start:
						{
							chain = CHAIN_TRANS_Operational_TO_Operational_BY_Starttimeout_tr1;
							catching_state = STATE_TOP;
						}
					break;
					case TRIG_timeout__Kill:
						{
							chain = CHAIN_TRANS_Operational_TO_Operational_BY_Killtimeout_tr2;
							catching_state = STATE_TOP;
						}
					break;
					case TRIG_timer__Start:
						{
							chain = CHAIN_TRANS_Operational_TO_Operational_BY_Starttimer_tr3;
							catching_state = STATE_TOP;
						}
					break;
					case TRIG_timer__Kill:
						{
							chain = CHAIN_TRANS_Operational_TO_Operational_BY_Killtimer_tr4;
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
