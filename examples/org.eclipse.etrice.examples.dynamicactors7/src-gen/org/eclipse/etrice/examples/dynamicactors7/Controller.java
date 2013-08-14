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




public class Controller extends ActorClassBase {

	
	//--------------------- ports
	protected PCtrlConjPort pcont = null;
	protected PCConjPort pout = null;
	protected PCConjPort pin = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	
	//--------------------- interface item IDs
	public static final int IFITEM_pcont = 1;
	public static final int IFITEM_pout = 2;
	public static final int IFITEM_pin = 3;
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Controller(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Controller");
		
		// initialize attributes

		// own ports
		pcont = new PCtrlConjPort(this, "pcont", IFITEM_pcont);
		pout = new PCConjPort(this, "pout", IFITEM_pout);
		pin = new PCConjPort(this, "pin", IFITEM_pin);
		
		// own saps
		
		// own service implementations
		
		// sub actors
		DebuggingService.getInstance().addMessageActorCreate(this, "cont");
		new Container(this, "cont");

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public PCtrlConjPort getPcont (){
		return this.pcont;
	}
	public PCConjPort getPout (){
		return this.pout;
	}
	public PCConjPort getPin (){
		return this.pin;
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
	public static final int STATE_CreateOptionals = 2;
	public static final int STATE_Sending = 3;
	public static final int STATE_Done = 4;
	public static final int STATE_Destroy = 5;
	public static final int STATE_CreateAgain = 6;
	public static final int STATE_SendAgain = 7;
	public static final int STATE_MAX = 8;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__CreateOptionals = 1;
	public static final int CHAIN_TRANS_tr0_FROM_CreateOptionals_TO_Sending_BY_donepcont = 2;
	public static final int CHAIN_TRANS_tr1_FROM_Sending_TO_Destroy_BY_hellopin = 3;
	public static final int CHAIN_TRANS_tr2_FROM_Destroy_TO_CreateAgain_BY_donepcont = 4;
	public static final int CHAIN_TRANS_tr3_FROM_CreateAgain_TO_SendAgain_BY_donepcont = 5;
	public static final int CHAIN_TRANS_tr4_FROM_SendAgain_TO_Done_BY_hellopin = 6;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_pcont__done = IFITEM_pcont + EVT_SHIFT*PCtrl.OUT_done;
	public static final int TRIG_pout__hello = IFITEM_pout + EVT_SHIFT*PC.OUT_hello;
	public static final int TRIG_pin__hello = IFITEM_pin + EVT_SHIFT*PC.OUT_hello;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","CreateOptionals",
	"Sending",
	"Done",
	"Destroy",
	"CreateAgain",
	"SendAgain"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_CreateOptionals() {
		pcont.createOpts();
	}
	protected void entry_Sending() {
		pout.sayHello();
	}
	protected void entry_Done() {
		System.out.println("Done, enter 'quit' to exit");
	}
	protected void entry_Destroy() {
		pcont.destroyOpts();
	}
	protected void entry_CreateAgain() {
		pcont.createOpts();
	}
	protected void entry_SendAgain() {
		pout.sayHello();
	}
	
	/* Action Codes */
	protected void action_TRANS_tr1_FROM_Sending_TO_Destroy_BY_hellopin(InterfaceItemBase ifitem, String txt) {
		System.out.println("Controller received: "+txt);
	}
	protected void action_TRANS_tr4_FROM_SendAgain_TO_Done_BY_hellopin(InterfaceItemBase ifitem, String txt) {
		System.out.println("Controller received: "+txt);
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
				case STATE_CreateOptionals:
					this.history[STATE_TOP] = STATE_CreateOptionals;
					current = STATE_TOP;
					break;
				case STATE_Sending:
					this.history[STATE_TOP] = STATE_Sending;
					current = STATE_TOP;
					break;
				case STATE_Done:
					this.history[STATE_TOP] = STATE_Done;
					current = STATE_TOP;
					break;
				case STATE_Destroy:
					this.history[STATE_TOP] = STATE_Destroy;
					current = STATE_TOP;
					break;
				case STATE_CreateAgain:
					this.history[STATE_TOP] = STATE_CreateAgain;
					current = STATE_TOP;
					break;
				case STATE_SendAgain:
					this.history[STATE_TOP] = STATE_SendAgain;
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
			case CHAIN_TRANS_INITIAL_TO__CreateOptionals:
			{
				return STATE_CreateOptionals;
			}
			case CHAIN_TRANS_tr0_FROM_CreateOptionals_TO_Sending_BY_donepcont:
			{
				return STATE_Sending;
			}
			case CHAIN_TRANS_tr1_FROM_Sending_TO_Destroy_BY_hellopin:
			{
				String txt = (String) generic_data;
				action_TRANS_tr1_FROM_Sending_TO_Destroy_BY_hellopin(ifitem, txt);
				return STATE_Destroy;
			}
			case CHAIN_TRANS_tr2_FROM_Destroy_TO_CreateAgain_BY_donepcont:
			{
				return STATE_CreateAgain;
			}
			case CHAIN_TRANS_tr3_FROM_CreateAgain_TO_SendAgain_BY_donepcont:
			{
				return STATE_SendAgain;
			}
			case CHAIN_TRANS_tr4_FROM_SendAgain_TO_Done_BY_hellopin:
			{
				String txt = (String) generic_data;
				action_TRANS_tr4_FROM_SendAgain_TO_Done_BY_hellopin(ifitem, txt);
				return STATE_Done;
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
				case STATE_CreateOptionals:
					if (!(skip_entry)) entry_CreateOptionals();
					/* in leaf state: return state id */
					return STATE_CreateOptionals;
				case STATE_Sending:
					if (!(skip_entry)) entry_Sending();
					/* in leaf state: return state id */
					return STATE_Sending;
				case STATE_Done:
					if (!(skip_entry)) entry_Done();
					/* in leaf state: return state id */
					return STATE_Done;
				case STATE_Destroy:
					if (!(skip_entry)) entry_Destroy();
					/* in leaf state: return state id */
					return STATE_Destroy;
				case STATE_CreateAgain:
					if (!(skip_entry)) entry_CreateAgain();
					/* in leaf state: return state id */
					return STATE_CreateAgain;
				case STATE_SendAgain:
					if (!(skip_entry)) entry_SendAgain();
					/* in leaf state: return state id */
					return STATE_SendAgain;
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
		int chain = CHAIN_TRANS_INITIAL_TO__CreateOptionals;
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
				case STATE_CreateOptionals:
					switch(trigger) {
							case TRIG_pcont__done:
								{
									chain = CHAIN_TRANS_tr0_FROM_CreateOptionals_TO_Sending_BY_donepcont;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Sending:
					switch(trigger) {
							case TRIG_pin__hello:
								{
									chain = CHAIN_TRANS_tr1_FROM_Sending_TO_Destroy_BY_hellopin;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Done:
					break;
				case STATE_Destroy:
					switch(trigger) {
							case TRIG_pcont__done:
								{
									chain = CHAIN_TRANS_tr2_FROM_Destroy_TO_CreateAgain_BY_donepcont;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_CreateAgain:
					switch(trigger) {
							case TRIG_pcont__done:
								{
									chain = CHAIN_TRANS_tr3_FROM_CreateAgain_TO_SendAgain_BY_donepcont;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_SendAgain:
					switch(trigger) {
							case TRIG_pin__hello:
								{
									chain = CHAIN_TRANS_tr4_FROM_SendAgain_TO_Done_BY_hellopin;
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
