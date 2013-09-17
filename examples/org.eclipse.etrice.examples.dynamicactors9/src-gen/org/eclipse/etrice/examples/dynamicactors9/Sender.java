package org.eclipse.etrice.examples.dynamicactors9;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.examples.dynamicactors9.PingPongProtocol.*;




public class Sender extends ActorClassBase {

	
	//--------------------- ports
	protected PingPongProtocolConjPort receiver = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	
	//--------------------- interface item IDs
	public static final int IFITEM_receiver = 1;
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Sender(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Sender");
		
		// initialize attributes

		// own ports
		receiver = new PingPongProtocolConjPort(this, "receiver", IFITEM_receiver);
		
		// own saps
		
		// own service implementations
		
		// sub actors

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public PingPongProtocolConjPort getReceiver (){
		return this.receiver;
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
	public static final int STATE_SendingPing = 2;
	public static final int STATE_ReceivedPong = 3;
	public static final int STATE_MAX = 4;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__SendingPing = 1;
	public static final int CHAIN_TRANS_tr0_FROM_SendingPing_TO_ReceivedPong_BY_pongreceiver = 2;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_receiver__pong = IFITEM_receiver + EVT_SHIFT*PingPongProtocol.OUT_pong;
	
	// state names
	protected static final String stateStrings[] = {
		"<no state>",
		"<top>",
		"SendingPing",
		"ReceivedPong"
	};
		
	// history
	protected int history[] = {NO_STATE, NO_STATE, NO_STATE, NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_SendingPing() {
		receiver.ping();
	}
	protected void entry_ReceivedPong() {
		System.out.println(((org.eclipse.etrice.runtime.java.messaging.RTObject)getRoot()).toStringRecursive());
		System.out.println("Done, enter 'quit' to exit");
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
				case STATE_SendingPing:
					this.history[STATE_TOP] = STATE_SendingPing;
					current = STATE_TOP;
					break;
				case STATE_ReceivedPong:
					this.history[STATE_TOP] = STATE_ReceivedPong;
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
			case CHAIN_TRANS_INITIAL_TO__SendingPing:
			{
				return STATE_SendingPing;
			}
			case CHAIN_TRANS_tr0_FROM_SendingPing_TO_ReceivedPong_BY_pongreceiver:
			{
				return STATE_ReceivedPong;
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
				case STATE_SendingPing:
					if (!(skip_entry)) entry_SendingPing();
					/* in leaf state: return state id */
					return STATE_SendingPing;
				case STATE_ReceivedPong:
					if (!(skip_entry)) entry_ReceivedPong();
					/* in leaf state: return state id */
					return STATE_ReceivedPong;
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
		int chain = CHAIN_TRANS_INITIAL_TO__SendingPing;
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
				case STATE_SendingPing:
					switch(trigger) {
							case TRIG_receiver__pong:
								{
									chain = CHAIN_TRANS_tr0_FROM_SendingPing_TO_ReceivedPong_BY_pongreceiver;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_ReceivedPong:
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
