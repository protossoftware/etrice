package org.eclipse.etrice.examples.dynamicactors4;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.examples.dynamicactors4.PC.*;
import org.eclipse.etrice.examples.dynamicactors4.PWorker.*;




public class Controller extends ActorClassBase {

	
	//--------------------- ports
	protected PWorkerConjPort worker = null;
	protected PCConjPort opt = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	
	//--------------------- interface item IDs
	public static final int IFITEM_worker = 1;
	public static final int IFITEM_opt = 2;
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Controller(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Controller");
		
		// initialize attributes

		// own ports
		worker = new PWorkerConjPort(this, "worker", IFITEM_worker);
		opt = new PCConjPort(this, "opt", IFITEM_opt);
		
		// own saps
		
		// own service implementations
		
		// sub actors
		DebuggingService.getInstance().addMessageActorCreate(this, "worker");
		new Worker(this, "worker");

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public PWorkerConjPort getWorker (){
		return this.worker;
	}
	public PCConjPort getOpt (){
		return this.opt;
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
	public static final int STATE_createOpt1 = 2;
	public static final int STATE_SendHello = 3;
	public static final int STATE_TryCreateInvalid = 4;
	public static final int STATE_UnexpectedError = 5;
	public static final int STATE_ExpectedError = 6;
	public static final int STATE_MAX = 7;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__createOpt1 = 1;
	public static final int CHAIN_TRANS_tr0_FROM_createOpt1_TO_SendHello_BY_okworker = 2;
	public static final int CHAIN_TRANS_tr1_FROM_SendHello_TO_TryCreateInvalid_BY_helloopt = 3;
	public static final int CHAIN_TRANS_tr2_FROM_createOpt1_TO_UnexpectedError_BY_errorworker = 4;
	public static final int CHAIN_TRANS_tr3_FROM_TryCreateInvalid_TO_ExpectedError_BY_errorworker = 5;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_opt__hello = IFITEM_opt + EVT_SHIFT*PC.OUT_hello;
	public static final int TRIG_worker__error = IFITEM_worker + EVT_SHIFT*PWorker.OUT_error;
	public static final int TRIG_worker__ok = IFITEM_worker + EVT_SHIFT*PWorker.OUT_ok;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","createOpt1",
	"SendHello",
	"TryCreateInvalid",
	"UnexpectedError",
	"ExpectedError"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_createOpt1() {
		worker.create("Optional1");
	}
	protected void entry_SendHello() {
		opt.sayHello();
	}
	protected void entry_TryCreateInvalid() {
		worker.create("Optional");
	}
	protected void entry_ExpectedError() {
		System.out.println("Done, enter 'quit' to exit"); 
	}
	
	/* Action Codes */
	protected void action_TRANS_tr1_FROM_SendHello_TO_TryCreateInvalid_BY_helloopt(InterfaceItemBase ifitem, String txt) {
		System.out.println("controller received "+txt);
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
				case STATE_createOpt1:
					this.history[STATE_TOP] = STATE_createOpt1;
					current = STATE_TOP;
					break;
				case STATE_SendHello:
					this.history[STATE_TOP] = STATE_SendHello;
					current = STATE_TOP;
					break;
				case STATE_TryCreateInvalid:
					this.history[STATE_TOP] = STATE_TryCreateInvalid;
					current = STATE_TOP;
					break;
				case STATE_UnexpectedError:
					this.history[STATE_TOP] = STATE_UnexpectedError;
					current = STATE_TOP;
					break;
				case STATE_ExpectedError:
					this.history[STATE_TOP] = STATE_ExpectedError;
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
			case CHAIN_TRANS_INITIAL_TO__createOpt1:
			{
				return STATE_createOpt1;
			}
			case CHAIN_TRANS_tr0_FROM_createOpt1_TO_SendHello_BY_okworker:
			{
				return STATE_SendHello;
			}
			case CHAIN_TRANS_tr1_FROM_SendHello_TO_TryCreateInvalid_BY_helloopt:
			{
				String txt = (String) generic_data;
				action_TRANS_tr1_FROM_SendHello_TO_TryCreateInvalid_BY_helloopt(ifitem, txt);
				return STATE_TryCreateInvalid;
			}
			case CHAIN_TRANS_tr2_FROM_createOpt1_TO_UnexpectedError_BY_errorworker:
			{
				return STATE_UnexpectedError;
			}
			case CHAIN_TRANS_tr3_FROM_TryCreateInvalid_TO_ExpectedError_BY_errorworker:
			{
				return STATE_ExpectedError;
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
				case STATE_createOpt1:
					if (!(skip_entry)) entry_createOpt1();
					/* in leaf state: return state id */
					return STATE_createOpt1;
				case STATE_SendHello:
					if (!(skip_entry)) entry_SendHello();
					/* in leaf state: return state id */
					return STATE_SendHello;
				case STATE_TryCreateInvalid:
					if (!(skip_entry)) entry_TryCreateInvalid();
					/* in leaf state: return state id */
					return STATE_TryCreateInvalid;
				case STATE_UnexpectedError:
					/* in leaf state: return state id */
					return STATE_UnexpectedError;
				case STATE_ExpectedError:
					if (!(skip_entry)) entry_ExpectedError();
					/* in leaf state: return state id */
					return STATE_ExpectedError;
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
		int chain = CHAIN_TRANS_INITIAL_TO__createOpt1;
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
				case STATE_createOpt1:
					switch(trigger) {
							case TRIG_worker__ok:
								{
									chain = CHAIN_TRANS_tr0_FROM_createOpt1_TO_SendHello_BY_okworker;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_worker__error:
								{
									chain = CHAIN_TRANS_tr2_FROM_createOpt1_TO_UnexpectedError_BY_errorworker;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_SendHello:
					switch(trigger) {
							case TRIG_opt__hello:
								{
									chain = CHAIN_TRANS_tr1_FROM_SendHello_TO_TryCreateInvalid_BY_helloopt;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_TryCreateInvalid:
					switch(trigger) {
							case TRIG_worker__error:
								{
									chain = CHAIN_TRANS_tr3_FROM_TryCreateInvalid_TO_ExpectedError_BY_errorworker;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_UnexpectedError:
					break;
				case STATE_ExpectedError:
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
