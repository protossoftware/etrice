package WikiDiagrams;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.DataPortBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import WikiDiagrams.AProtocolClass.*;




public class ActorClass2 extends ActorClassBase {

	
	//--------------------- ports
	protected AProtocolClassPort fct1 = null;
	protected AProtocolClassPort fct2 = null;
	protected AProtocolClassConjPort fct = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	
	//--------------------- interface item IDs
	public static final int IFITEM_fct1 = 1;
	public static final int IFITEM_fct2 = 2;
	public static final int IFITEM_fct = 3;
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public ActorClass2(IRTObject parent, String name) {
		super(parent, name);
		setClassName("ActorClass2");
		
		// initialize attributes

		// own ports
		fct1 = new AProtocolClassPort(this, "fct1", IFITEM_fct1);
		fct2 = new AProtocolClassPort(this, "fct2", IFITEM_fct2);
		fct = new AProtocolClassConjPort(this, "fct", IFITEM_fct);
		
		// own saps
		
		// own service implementations
		
		// sub actors
		
		// wiring
		

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public AProtocolClassPort getFct1 (){
		return this.fct1;
	}
	public AProtocolClassPort getFct2 (){
		return this.fct2;
	}
	public AProtocolClassConjPort getFct (){
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
	public static final int STATE_Initial = 2;
	public static final int STATE_DoingThis = 3;
	public static final int STATE_DoingThat = 4;
	public static final int STATE_Error = 5;
	public static final int STATE_MAX = 6;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Initial = 1;
	public static final int CHAIN_TRANS_tr0_FROM_Initial_TO_DoingThis_BY_doThisfct1 = 2;
	public static final int CHAIN_TRANS_tr1_FROM_Initial_TO_DoingThat_BY_doThatfct1 = 3;
	public static final int CHAIN_TRANS_tr2_FROM_DoingThis_TO_Initial_BY_resetfct1 = 4;
	public static final int CHAIN_TRANS_tr3_FROM_DoingThat_TO_Initial_BY_resetfct1 = 5;
	public static final int CHAIN_TRANS_tr4_FROM_Initial_TO_Error_BY_errorfct1 = 6;
	public static final int CHAIN_TRANS_tr5_FROM_DoingThis_TO_Error_BY_errorfct1 = 7;
	public static final int CHAIN_TRANS_tr6_FROM_DoingThat_TO_Error_BY_errorfct1 = 8;
	public static final int CHAIN_TRANS_tr7_FROM_Error_TO_Initial_BY_errorfct1 = 9;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_fct1__doThis = IFITEM_fct1 + EVT_SHIFT*AProtocolClass.IN_doThis;
	public static final int TRIG_fct1__doThat = IFITEM_fct1 + EVT_SHIFT*AProtocolClass.IN_doThat;
	public static final int TRIG_fct1__reset = IFITEM_fct1 + EVT_SHIFT*AProtocolClass.IN_reset;
	public static final int TRIG_fct1__error = IFITEM_fct1 + EVT_SHIFT*AProtocolClass.IN_error;
	public static final int TRIG_fct2__doThis = IFITEM_fct2 + EVT_SHIFT*AProtocolClass.IN_doThis;
	public static final int TRIG_fct2__doThat = IFITEM_fct2 + EVT_SHIFT*AProtocolClass.IN_doThat;
	public static final int TRIG_fct2__reset = IFITEM_fct2 + EVT_SHIFT*AProtocolClass.IN_reset;
	public static final int TRIG_fct2__error = IFITEM_fct2 + EVT_SHIFT*AProtocolClass.IN_error;
	public static final int TRIG_fct__doneThis = IFITEM_fct + EVT_SHIFT*AProtocolClass.OUT_doneThis;
	public static final int TRIG_fct__doneThat = IFITEM_fct + EVT_SHIFT*AProtocolClass.OUT_doneThat;
	
	// state names
	protected static final String stateStrings[] = {
		"<no state>",
		"<top>",
		"Initial",
		"DoingThis",
		"DoingThat",
		"Error"
	};
		
	// history
	protected int history[] = {NO_STATE, NO_STATE, NO_STATE, NO_STATE, NO_STATE, NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
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
				case STATE_Initial:
					this.history[STATE_TOP] = STATE_Initial;
					current = STATE_TOP;
					break;
				case STATE_DoingThis:
					this.history[STATE_TOP] = STATE_DoingThis;
					current = STATE_TOP;
					break;
				case STATE_DoingThat:
					this.history[STATE_TOP] = STATE_DoingThat;
					current = STATE_TOP;
					break;
				case STATE_Error:
					this.history[STATE_TOP] = STATE_Error;
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
			case CHAIN_TRANS_INITIAL_TO__Initial:
			{
				return STATE_Initial;
			}
			case CHAIN_TRANS_tr0_FROM_Initial_TO_DoingThis_BY_doThisfct1:
			{
				return STATE_DoingThis;
			}
			case CHAIN_TRANS_tr1_FROM_Initial_TO_DoingThat_BY_doThatfct1:
			{
				return STATE_DoingThat;
			}
			case CHAIN_TRANS_tr2_FROM_DoingThis_TO_Initial_BY_resetfct1:
			{
				return STATE_Initial;
			}
			case CHAIN_TRANS_tr3_FROM_DoingThat_TO_Initial_BY_resetfct1:
			{
				return STATE_Initial;
			}
			case CHAIN_TRANS_tr4_FROM_Initial_TO_Error_BY_errorfct1:
			{
				return STATE_Error;
			}
			case CHAIN_TRANS_tr5_FROM_DoingThis_TO_Error_BY_errorfct1:
			{
				return STATE_Error;
			}
			case CHAIN_TRANS_tr6_FROM_DoingThat_TO_Error_BY_errorfct1:
			{
				return STATE_Error;
			}
			case CHAIN_TRANS_tr7_FROM_Error_TO_Initial_BY_errorfct1:
			{
				return STATE_Initial;
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
				case STATE_Initial:
					/* in leaf state: return state id */
					return STATE_Initial;
				case STATE_DoingThis:
					/* in leaf state: return state id */
					return STATE_DoingThis;
				case STATE_DoingThat:
					/* in leaf state: return state id */
					return STATE_DoingThat;
				case STATE_Error:
					/* in leaf state: return state id */
					return STATE_Error;
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
		int chain = CHAIN_TRANS_INITIAL_TO__Initial;
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
				case STATE_Initial:
					switch(trigger) {
							case TRIG_fct1__doThis:
								{
									chain = CHAIN_TRANS_tr0_FROM_Initial_TO_DoingThis_BY_doThisfct1;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct1__doThat:
								{
									chain = CHAIN_TRANS_tr1_FROM_Initial_TO_DoingThat_BY_doThatfct1;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct1__error:
								{
									chain = CHAIN_TRANS_tr4_FROM_Initial_TO_Error_BY_errorfct1;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_DoingThis:
					switch(trigger) {
							case TRIG_fct1__reset:
								{
									chain = CHAIN_TRANS_tr2_FROM_DoingThis_TO_Initial_BY_resetfct1;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct1__error:
								{
									chain = CHAIN_TRANS_tr5_FROM_DoingThis_TO_Error_BY_errorfct1;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_DoingThat:
					switch(trigger) {
							case TRIG_fct1__reset:
								{
									chain = CHAIN_TRANS_tr3_FROM_DoingThat_TO_Initial_BY_resetfct1;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct1__error:
								{
									chain = CHAIN_TRANS_tr6_FROM_DoingThat_TO_Error_BY_errorfct1;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Error:
					switch(trigger) {
							case TRIG_fct1__error:
								{
									chain = CHAIN_TRANS_tr7_FROM_Error_TO_Initial_BY_errorfct1;
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
