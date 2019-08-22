package etrice.api.contracts.monitors;

import org.eclipse.etrice.runtime.java.messaging.*;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.*;

import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

import etrice.api.contracts.monitors.PContractMonitorControl.*;



public abstract class AContractMonitorBase extends ActorClassBase {


	//--------------------- ports
	protected PContractMonitorControlPort monitor_ctrl = null;

	//--------------------- saps

	//--------------------- services

	//--------------------- optional actors

	//--------------------- interface item IDs
	public static final int IFITEM_monitor_ctrl = 1;

	/*--------------------- attributes ---------------------*/
	public  boolean _violation;
	public  boolean forwardInvalidMessages;

	/*--------------------- operations ---------------------*/
	public  void onViolation(String comment) {
		_violation = true;
		DebuggingService.getInstance().addVisibleComment(comment + " location: " + this.getInstancePath()/* + " : " + ifitem.toString()*/);
		monitor_ctrl.violationOccured();
	}


	//--------------------- construction
	public AContractMonitorBase(IRTObject parent, String name) {
		super(parent, name);
		setClassName("AContractMonitorBase");

		// initialize attributes
		this.set_violation(false);
		this.setForwardInvalidMessages(false);

		// own ports
		monitor_ctrl = new PContractMonitorControlPort(this, "monitor_ctrl", IFITEM_monitor_ctrl);

		// own saps

		// own service implementations

		// sub actors

		// wiring


		/* user defined constructor body */

	}

	/* --------------------- attribute setters and getters */
	public void set_violation(boolean _violation) {
		 this._violation = _violation;
	}
	public boolean get_violation() {
		return this._violation;
	}
	public void setForwardInvalidMessages(boolean forwardInvalidMessages) {
		 this.forwardInvalidMessages = forwardInvalidMessages;
	}
	public boolean getForwardInvalidMessages() {
		return this.forwardInvalidMessages;
	}


	//--------------------- port getters
	public PContractMonitorControlPort getMonitor_ctrl (){
		return this.monitor_ctrl;
	}

	//--------------------- lifecycle functions
	public void stop(){
		super.stop();
	}

	public void destroy(){
		/* user defined destructor body */
		DebuggingService.getInstance().addMessageActorDestroy(this);
		super.destroy();
	}

	/* state IDs */
	public static final int STATE_MAX = 2;
	
	/* transition chains */
	public static final int CHAIN_TRANS__trStatus_FROM__trBase_TO__trBase_BY_getAndResetStatusmonitor_ctrl__trStatus = 1;
	public static final int CHAIN_TRANS__trForward_FROM__trBase_TO__trBase_BY_setForwardInvalidMessagesmonitor_ctrl__trForward = 2;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_monitor_ctrl__getAndResetStatus = IFITEM_monitor_ctrl + EVT_SHIFT*PContractMonitorControl.IN_getAndResetStatus;
	public static final int TRIG_monitor_ctrl__setForwardInvalidMessages = IFITEM_monitor_ctrl + EVT_SHIFT*PContractMonitorControl.IN_setForwardInvalidMessages;
	
	// state names
	protected static final String stateStrings[] = {
		"<no state>",
		"<top>",
	};
	
	// history
	protected int history[] = {NO_STATE, NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS__trStatus_FROM__trBase_TO__trBase_BY_getAndResetStatusmonitor_ctrl__trStatus(InterfaceItemBase ifitem) {
	    monitor_ctrl.violationStatus(_violation);
	    _violation = false;
	}
	protected void action_TRANS__trForward_FROM__trBase_TO__trBase_BY_setForwardInvalidMessagesmonitor_ctrl__trForward(InterfaceItemBase ifitem, boolean transitionData) {
	    forwardInvalidMessages = transitionData;
	}
	
	/* State Switch Methods */
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current__et - the current state
	 * @param to - the final parent state
	* @param handler__et - entry and exit codes are called only if not handler (for handler TransitionPoints)
	 */
	private void exitTo(int current__et, int to, boolean handler__et) {
		while (current__et!=to) {
			switch (current__et) {
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
			case AContractMonitorBase.CHAIN_TRANS__trForward_FROM__trBase_TO__trBase_BY_setForwardInvalidMessagesmonitor_ctrl__trForward:
			{
				boolean transitionData = (Boolean) generic_data__et;
				action_TRANS__trForward_FROM__trBase_TO__trBase_BY_setForwardInvalidMessagesmonitor_ctrl__trForward(ifitem, transitionData);
				return STATE_TOP + STATE_MAX;
			}
			case AContractMonitorBase.CHAIN_TRANS__trStatus_FROM__trBase_TO__trBase_BY_getAndResetStatusmonitor_ctrl__trStatus:
			{
				action_TRANS__trStatus_FROM__trBase_TO__trBase_BY_getAndResetStatusmonitor_ctrl__trStatus(ifitem);
				return STATE_TOP + STATE_MAX;
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
	* @param handler__et - entry code is executed if not handler
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state__et, boolean handler__et) {
		if (state__et >= STATE_MAX) {
			state__et =  (state__et - STATE_MAX);
		}
		while (true) {
			switch (state__et) {
				case STATE_TOP:
					state__et = this.history[STATE_TOP];
					break;
				default:
					/* should not occur */
					break;
			}
		}
		/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */
	}
	
	public void executeInitTransition() {
		/* no initial transition allowed for abstract actor class */
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEventInternal(InterfaceItemBase ifitem, int localId, int evt, Object generic_data__et) {
		int trigger__et = localId + EVT_SHIFT*evt;
		int chain__et = NOT_CAUGHT;
		int catching_state__et = NO_STATE;
		boolean is_handler__et = false;
	
		if (!handleSystemEvent(ifitem, evt, generic_data__et)) {
			switch (getState()) {
				default:
					/* should not occur */
					break;
			}
		}
		if (chain__et != NOT_CAUGHT) {
			exitTo(getState(), catching_state__et, is_handler__et);
			{
				int next__et = executeTransitionChain(chain__et, ifitem, generic_data__et);
				next__et = enterHistory(next__et, is_handler__et);
				setState(next__et);
			}
		}
	}
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data__et) {
		int localId = (ifitem==null)? 0 : ifitem.getLocalId();
		receiveEventInternal(ifitem, localId, evt, generic_data__et);
	}

};
