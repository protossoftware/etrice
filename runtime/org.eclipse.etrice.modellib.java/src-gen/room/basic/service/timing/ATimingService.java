package room.basic.service.timing;

import org.eclipse.etrice.runtime.java.messaging.*;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.*;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

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

	//--------------------- optional actors

	//--------------------- interface item IDs
	public static final int IFITEM_timer = 1;

	/*--------------------- attributes ---------------------*/

	/*--------------------- operations ---------------------*/
	public  void stop() {
		System.out.println(toString() + "::stop()");
		timerService.cancel();
		timerService = null;
	}


	//--------------------- construction
	public ATimingService(IRTObject parent, String name) {
		super(parent, name);
		setClassName("ATimingService");

		// initialize attributes

		// own ports

		// own saps

		// own service implementations
		timer = new PTimerReplPort(this, "timer", IFITEM_timer);

		// sub actors

		// wiring


		/* user defined constructor body */

	}

	/* --------------------- attribute setters and getters */


	//--------------------- port getters
	public PTimerReplPort getTimer (){
		return this.timer;
	}

	//--------------------- lifecycle functions

	public void destroy(){
		/* user defined destructor body */
		DebuggingService.getInstance().addMessageActorDestroy(this);
		super.destroy();
	}

	/* state IDs */
	public static final int STATE_Operational = 2;
	public static final int STATE_MAX = 3;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Operational = 1;
	public static final int CHAIN_TRANS_tr1_FROM_Operational_TO_Operational_BY_internalStartTimertimer_tr1 = 2;
	public static final int CHAIN_TRANS_tr3_FROM_Operational_TO_Operational_BY_internalStartTimeouttimer_tr3 = 3;
	public static final int CHAIN_TRANS_tr4_FROM_Operational_TO_Operational_BY_killtimer_tr4 = 4;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_timer__kill = IFITEM_timer + EVT_SHIFT*PTimer.IN_kill;
	public static final int TRIG_timer__internalStartTimer = IFITEM_timer + EVT_SHIFT*PTimer.IN_internalStartTimer;
	public static final int TRIG_timer__internalStartTimeout = IFITEM_timer + EVT_SHIFT*PTimer.IN_internalStartTimeout;
	
	// state names
	protected static final String stateStrings[] = {
		"<no state>",
		"<top>",
		"Operational"
	};
	
	// history
	protected int history[] = {NO_STATE, NO_STATE, NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
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
	protected void action_TRANS_tr1_FROM_Operational_TO_Operational_BY_internalStartTimertimer_tr1(InterfaceItemBase ifitem, TimerData td) {
	    // start timer
	    taskCount++;
	    if (taskCount>PURGE_LIMIT) timerService.purge();
	    int t = td.getTime();
	    timerService.scheduleAtFixedRate(((PTimerPort)ifitem).getTask(),t,t);
	}
	protected void action_TRANS_tr3_FROM_Operational_TO_Operational_BY_internalStartTimeouttimer_tr3(InterfaceItemBase ifitem, TimerData td) {
	    // start timeout
	    taskCount++;
	    if (taskCount>PURGE_LIMIT) timerService.purge();
	    timerService.schedule(((PTimerPort)ifitem).getTask(), ((TimerData)td).getTime());
	}
	protected void action_TRANS_tr4_FROM_Operational_TO_Operational_BY_killtimer_tr4(InterfaceItemBase ifitem) {
	    // nothing to do to kill timer (handled by timer)
	}
	
	/* State Switch Methods */
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current__et - the current state
	 * @param to - the final parent state
	 */
	private void exitTo(int current__et, int to) {
		while (current__et!=to) {
			switch (current__et) {
				case STATE_Operational:
					this.history[STATE_TOP] = STATE_Operational;
					current__et = STATE_TOP;
					break;
				default:
					/* should not occur */
					break;
			}
		}
	}
	
	/**
	 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
	 * matching the trigger of this chain. The ID of the final state is returned
	 * @param chain__et - the chain ID
	 * @param generic_data__et - the generic data pointer
	 * @return the +/- ID of the final state either with a positive sign, that indicates to execute the state's entry code, or a negative sign vice versa
	 */
	private int executeTransitionChain(int chain__et, InterfaceItemBase ifitem, Object generic_data__et) {
		switch (chain__et) {
			case ATimingService.CHAIN_TRANS_INITIAL_TO__Operational:
			{
				action_TRANS_INITIAL_TO__Operational();
				return STATE_Operational;
			}
			case ATimingService.CHAIN_TRANS_tr1_FROM_Operational_TO_Operational_BY_internalStartTimertimer_tr1:
			{
				TimerData td = (TimerData) generic_data__et;
				action_TRANS_tr1_FROM_Operational_TO_Operational_BY_internalStartTimertimer_tr1(ifitem, td);
				return STATE_Operational;
			}
			case ATimingService.CHAIN_TRANS_tr3_FROM_Operational_TO_Operational_BY_internalStartTimeouttimer_tr3:
			{
				TimerData td = (TimerData) generic_data__et;
				action_TRANS_tr3_FROM_Operational_TO_Operational_BY_internalStartTimeouttimer_tr3(ifitem, td);
				return STATE_Operational;
			}
			case ATimingService.CHAIN_TRANS_tr4_FROM_Operational_TO_Operational_BY_killtimer_tr4:
			{
				action_TRANS_tr4_FROM_Operational_TO_Operational_BY_killtimer_tr4(ifitem);
				return STATE_Operational;
			}
				default:
					/* should not occur */
					break;
		}
		return NO_STATE;
	}
	
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state__et - the state which is entered
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state__et) {
		boolean skip_entry__et = false;
		if (state__et >= STATE_MAX) {
			state__et =  (state__et - STATE_MAX);
			skip_entry__et = true;
		}
		while (true) {
			switch (state__et) {
				case STATE_Operational:
					if (!(skip_entry__et)) entry_Operational();
					/* in leaf state: return state id */
					return STATE_Operational;
				case STATE_TOP:
					state__et = this.history[STATE_TOP];
					break;
				default:
					/* should not occur */
					break;
			}
			skip_entry__et = false;
		}
		/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */
	}
	
	public void executeInitTransition() {
		int chain__et = ATimingService.CHAIN_TRANS_INITIAL_TO__Operational;
		int next__et = executeTransitionChain(chain__et, null, null);
		next__et = enterHistory(next__et);
		setState(next__et);
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEventInternal(InterfaceItemBase ifitem, int localId, int evt, Object generic_data__et) {
		int trigger__et = localId + EVT_SHIFT*evt;
		int chain__et = NOT_CAUGHT;
		int catching_state__et = NO_STATE;
	
		if (!handleSystemEvent(ifitem, evt, generic_data__et)) {
			switch (getState()) {
			    case STATE_Operational:
			        switch(trigger__et) {
			                case TRIG_timer__internalStartTimer:
			                    {
			                        chain__et = ATimingService.CHAIN_TRANS_tr1_FROM_Operational_TO_Operational_BY_internalStartTimertimer_tr1;
			                        catching_state__et = STATE_TOP;
			                    }
			                break;
			                case TRIG_timer__internalStartTimeout:
			                    {
			                        chain__et = ATimingService.CHAIN_TRANS_tr3_FROM_Operational_TO_Operational_BY_internalStartTimeouttimer_tr3;
			                        catching_state__et = STATE_TOP;
			                    }
			                break;
			                case TRIG_timer__kill:
			                    {
			                        chain__et = ATimingService.CHAIN_TRANS_tr4_FROM_Operational_TO_Operational_BY_killtimer_tr4;
			                        catching_state__et = STATE_TOP;
			                    }
			                break;
			                default:
			                    /* should not occur */
			                    break;
			        }
			        break;
			    default:
			        /* should not occur */
			        break;
			}
		}
		if (chain__et != NOT_CAUGHT) {
			exitTo(getState(), catching_state__et);
			{
				int next__et = executeTransitionChain(chain__et, ifitem, generic_data__et);
				next__et = enterHistory(next__et);
				setState(next__et);
			}
		}
	}
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data__et) {
		int localId = (ifitem==null)? 0 : ifitem.getLocalId();
		receiveEventInternal(ifitem, localId, evt, generic_data__et);
	}

};
