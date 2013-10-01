package org.eclipse.etrice.examples.dynamicactors9;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.DataPortBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;

import room.basic.service.timing.*;

import room.basic.service.timing.PTimer.*;
import org.eclipse.etrice.examples.dynamicactors9.PingPongProtocol.*;




public class Receiver extends ActorClassBase {

	
	//--------------------- ports
	protected PingPongProtocolPort sender = null;
	
	//--------------------- saps
	protected PTimerConjPort timing = null;
	
	//--------------------- services
	
	//--------------------- optional actors
	
	//--------------------- interface item IDs
	public static final int IFITEM_sender = 1;
	public static final int IFITEM_timing = 2;
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Receiver(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Receiver");
		
		// initialize attributes

		// own ports
		sender = new PingPongProtocolPort(this, "sender", IFITEM_sender);
		
		// own saps
		timing = new PTimerConjPort(this, "timing", IFITEM_timing, 0);
		
		// own service implementations
		
		// sub actors
		
		// wiring
		

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public PingPongProtocolPort getSender (){
		return this.sender;
	}
	public PTimerConjPort getTiming (){
		return this.timing;
	}

	//--------------------- lifecycle functions
	public void stop(){
		stopUser();
		super.stop();
	}
	
	public void destroy() {
		DebuggingService.getInstance().addMessageActorDestroy(this);
		super.destroy();
	}

	/* state IDs */
	public static final int STATE_WaitingForPing = 2;
	public static final int STATE_WaitingForAWhile = 3;
	public static final int STATE_SentPong = 4;
	public static final int STATE_MAX = 5;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__WaitingForPing = 1;
	public static final int CHAIN_TRANS_tr0_FROM_WaitingForPing_TO_WaitingForAWhile_BY_pingsender = 2;
	public static final int CHAIN_TRANS_tr1_FROM_WaitingForAWhile_TO_SentPong_BY_timeouttiming = 3;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_sender__ping = IFITEM_sender + EVT_SHIFT*PingPongProtocol.IN_ping;
	public static final int TRIG_timing__timeout = IFITEM_timing + EVT_SHIFT*PTimer.OUT_timeout;
	public static final int TRIG_timing__internalTimer = IFITEM_timing + EVT_SHIFT*PTimer.OUT_internalTimer;
	public static final int TRIG_timing__internalTimeout = IFITEM_timing + EVT_SHIFT*PTimer.OUT_internalTimeout;
	
	// state names
	protected static final String stateStrings[] = {
		"<no state>",
		"<top>",
		"WaitingForPing",
		"WaitingForAWhile",
		"SentPong"
	};
		
	// history
	protected int history[] = {NO_STATE, NO_STATE, NO_STATE, NO_STATE, NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_WaitingForAWhile() {
		timing.startTimeout(1000);
	}
	protected void entry_SentPong() {
		sender.pong();
	}
	
	/* Action Codes */
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 */
	private void exitTo(int current, int to) {
		while (current!=to) {
			switch (current) {
				case STATE_WaitingForPing:
					this.history[STATE_TOP] = STATE_WaitingForPing;
					current = STATE_TOP;
					break;
				case STATE_WaitingForAWhile:
					this.history[STATE_TOP] = STATE_WaitingForAWhile;
					current = STATE_TOP;
					break;
				case STATE_SentPong:
					this.history[STATE_TOP] = STATE_SentPong;
					current = STATE_TOP;
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
	 * @param chain - the chain ID
	 * @param generic_data - the generic data pointer
	 * @return the +/- ID of the final state either with a positive sign, that indicates to execute the state's entry code, or a negative sign vice versa
	 */
	private int executeTransitionChain(int chain, InterfaceItemBase ifitem, Object generic_data) {
		switch (chain) {
			case CHAIN_TRANS_INITIAL_TO__WaitingForPing:
			{
				return STATE_WaitingForPing;
			}
			case CHAIN_TRANS_tr0_FROM_WaitingForPing_TO_WaitingForAWhile_BY_pingsender:
			{
				return STATE_WaitingForAWhile;
			}
			case CHAIN_TRANS_tr1_FROM_WaitingForAWhile_TO_SentPong_BY_timeouttiming:
			{
				return STATE_SentPong;
			}
				default:
					/* should not occur */
					break;
		}
		return NO_STATE;
	}
	
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state - the state which is entered
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state) {
		boolean skip_entry = false;
		if (state >= STATE_MAX) {
			state =  (state - STATE_MAX);
			skip_entry = true;
		}
		while (true) {
			switch (state) {
				case STATE_WaitingForPing:
					/* in leaf state: return state id */
					return STATE_WaitingForPing;
				case STATE_WaitingForAWhile:
					if (!(skip_entry)) entry_WaitingForAWhile();
					/* in leaf state: return state id */
					return STATE_WaitingForAWhile;
				case STATE_SentPong:
					if (!(skip_entry)) entry_SentPong();
					/* in leaf state: return state id */
					return STATE_SentPong;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
				default:
					/* should not occur */
					break;
			}
			skip_entry = false;
		}
		/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__WaitingForPing;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next);
		setState(next);
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (getState()) {
				case STATE_WaitingForPing:
					switch(trigger) {
							case TRIG_sender__ping:
								{
									chain = CHAIN_TRANS_tr0_FROM_WaitingForPing_TO_WaitingForAWhile_BY_pingsender;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_WaitingForAWhile:
					switch(trigger) {
							case TRIG_timing__timeout:
								{
									chain = CHAIN_TRANS_tr1_FROM_WaitingForAWhile_TO_SentPong_BY_timeouttiming;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_SentPong:
					break;
				default:
					/* should not occur */
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(getState(), catching_state);
			{
				int next = executeTransitionChain(chain, ifitem, generic_data);
				next = enterHistory(next);
				setState(next);
			}
		}
	}
};
