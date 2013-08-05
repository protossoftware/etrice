package org.eclipse.etrice.examples.dynamicactors7;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.examples.dynamicactors7.PC.*;
import org.eclipse.etrice.examples.dynamicactors7.PCtrl.*;

import org.eclipse.etrice.examples.dynamicactors7.Optional1Interface;
import org.eclipse.etrice.examples.dynamicactors7.Optional2Interface;



public class Container extends ActorClassBase {

	
	//--------------------- ports
	protected PCtrlPort fct = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	protected Optional1Interface opt1 = null;
	protected Optional2Interface opt2 = null;
	
	//--------------------- interface item IDs
	public static final int IFITEM_fct = 1;
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/
	public void dumpTree(String msg) {
		System.out.println(msg);
		System.out.println(((org.eclipse.etrice.runtime.java.messaging.RTObject)getRoot()).toStringRecursive());
	}

	//--------------------- construction
	public Container(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Container");
		
		// initialize attributes

		// own ports
		fct = new PCtrlPort(this, "fct", IFITEM_fct);
		
		// own saps
		
		// own service implementations
		
		// sub actors
		opt1 = new Optional1Interface(this, "opt1");
		opt2 = new Optional2Interface(this, "opt2");

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public PCtrlPort getFct (){
		return this.fct;
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
	public static final int STATE_Ready = 2;
	public static final int STATE_MAX = 3;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Ready = 1;
	public static final int CHAIN_TRANS_tr0_FROM_Ready_TO_Ready_BY_createOptsfct_tr0 = 2;
	public static final int CHAIN_TRANS_tr1_FROM_Ready_TO_Ready_BY_destroyOptsfct_tr1 = 3;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_fct__createOpts = IFITEM_fct + EVT_SHIFT*PCtrl.IN_createOpts;
	public static final int TRIG_fct__destroyOpts = IFITEM_fct + EVT_SHIFT*PCtrl.IN_destroyOpts;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Ready"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_tr0_FROM_Ready_TO_Ready_BY_createOptsfct_tr0(InterfaceItemBase ifitem) {
		opt1.createOptionalActor("Optional1", getThread());
		opt2.createOptionalActor("Optional2", getThread());
		dumpTree("after creation of op1 and opt2");
		fct.done();
	}
	protected void action_TRANS_tr1_FROM_Ready_TO_Ready_BY_destroyOptsfct_tr1(InterfaceItemBase ifitem) {
		opt1.destroyOptionalActor();
		opt2.destroyOptionalActor();
		fct.done();
	}
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 */
	private void exitTo(int current, int to) {
		while (current!=to) {
			switch (current) {
				case STATE_Ready:
					this.history[STATE_TOP] = STATE_Ready;
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
			case CHAIN_TRANS_INITIAL_TO__Ready:
			{
				return STATE_Ready;
			}
			case CHAIN_TRANS_tr0_FROM_Ready_TO_Ready_BY_createOptsfct_tr0:
			{
				action_TRANS_tr0_FROM_Ready_TO_Ready_BY_createOptsfct_tr0(ifitem);
				return STATE_Ready;
			}
			case CHAIN_TRANS_tr1_FROM_Ready_TO_Ready_BY_destroyOptsfct_tr1:
			{
				action_TRANS_tr1_FROM_Ready_TO_Ready_BY_destroyOptsfct_tr1(ifitem);
				return STATE_Ready;
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
				case STATE_Ready:
					/* in leaf state: return state id */
					return STATE_Ready;
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
		int chain = CHAIN_TRANS_INITIAL_TO__Ready;
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
				case STATE_Ready:
					switch(trigger) {
							case TRIG_fct__createOpts:
								{
									chain = CHAIN_TRANS_tr0_FROM_Ready_TO_Ready_BY_createOptsfct_tr0;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct__destroyOpts:
								{
									chain = CHAIN_TRANS_tr1_FROM_Ready_TO_Ready_BY_destroyOptsfct_tr1;
									catching_state = STATE_TOP;
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
