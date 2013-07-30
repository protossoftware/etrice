package org.eclipse.etrice.examples.dynamicactors1;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.examples.dynamicactors1.PC.*;

import org.eclipse.etrice.examples.dynamicactors1.OptionalInterface;



public class Container extends ActorClassBase {

	
	//--------------------- ports
	protected PCConjReplPort p0 = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	protected OptionalReplicatedInterface optarray = null;
	
	//--------------------- interface item IDs
	public static final int IFITEM_p0 = 1;
	
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
		p0 = new PCConjReplPort(this, "p0", IFITEM_p0);
		
		// own saps
		
		// own service implementations
		
		// sub actors
		optarray = new OptionalReplicatedInterface(this, "optarray");

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public PCConjReplPort getP0 (){
		return this.p0;
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
	public static final int STATE_CreateOptional2 = 2;
	public static final int STATE_CreateOptional1 = 3;
	public static final int STATE_ReceivedHelloAgain = 4;
	public static final int STATE_Destroy0 = 5;
	public static final int STATE_Destroy1Create2 = 6;
	public static final int STATE_Done = 7;
	public static final int STATE_MAX = 8;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__CreateOptional2 = 1;
	public static final int CHAIN_TRANS_tr0_FROM_CreateOptional2_TO_CreateOptional1_BY_hellop0 = 2;
	public static final int CHAIN_TRANS_tr1_FROM_ReceivedHelloAgain_TO_Destroy0_BY_hellop0 = 3;
	public static final int CHAIN_TRANS_tr2_FROM_CreateOptional1_TO_ReceivedHelloAgain_BY_hellop0 = 4;
	public static final int CHAIN_TRANS_tr3_FROM_Destroy0_TO_Destroy1Create2_BY_hellop0 = 5;
	public static final int CHAIN_TRANS_tr4_FROM_Destroy1Create2_TO_Done_BY_hellop0 = 6;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_p0__hello = IFITEM_p0 + EVT_SHIFT*PC.OUT_hello;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","CreateOptional2",
	"CreateOptional1",
	"ReceivedHelloAgain",
	"Destroy0",
	"Destroy1Create2",
	"Done"
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
	protected void entry_CreateOptional2() {
		dumpTree("before creation of Optional2");
		optarray.createOptionalActor("Optional2", getThread());
		dumpTree("after creation of Optional2");
		p0.sayHello();
	}
	protected void entry_CreateOptional1() {
		optarray.createOptionalActor("Optional1", getThread());
		p0.sayHello();
		dumpTree("after creation of Optional1");
	}
	protected void entry_Destroy0() {
		optarray.destroyOptionalActor(0);
		dumpTree("after deletion of Optional2");
		p0.sayHello();
	}
	protected void entry_Destroy1Create2() {
		optarray.destroyOptionalActor(1);
		dumpTree("after deletion of Optional1");
		
		optarray.createOptionalActor("Optional2", getThread());
		dumpTree("after second creation of Optional2");
		p0.sayHello();
	}
	
	/* Action Codes */
	protected void action_TRANS_tr0_FROM_CreateOptional2_TO_CreateOptional1_BY_hellop0(InterfaceItemBase ifitem, String txt) {
		System.out.println(txt+"\n");
	}
	protected void action_TRANS_tr2_FROM_CreateOptional1_TO_ReceivedHelloAgain_BY_hellop0(InterfaceItemBase ifitem, String txt) {
		System.out.println(txt+"\n");
	}
	protected void action_TRANS_tr1_FROM_ReceivedHelloAgain_TO_Destroy0_BY_hellop0(InterfaceItemBase ifitem, String txt) {
		System.out.println(txt+"\n");
	}
	protected void action_TRANS_tr3_FROM_Destroy0_TO_Destroy1Create2_BY_hellop0(InterfaceItemBase ifitem, String txt) {
		System.out.println(txt+"\n");
	}
	protected void action_TRANS_tr4_FROM_Destroy1Create2_TO_Done_BY_hellop0(InterfaceItemBase ifitem, String txt) {
		System.out.println(txt+"\n");
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
				case STATE_CreateOptional2:
					this.history[STATE_TOP] = STATE_CreateOptional2;
					current = STATE_TOP;
					break;
				case STATE_CreateOptional1:
					this.history[STATE_TOP] = STATE_CreateOptional1;
					current = STATE_TOP;
					break;
				case STATE_ReceivedHelloAgain:
					this.history[STATE_TOP] = STATE_ReceivedHelloAgain;
					current = STATE_TOP;
					break;
				case STATE_Destroy0:
					this.history[STATE_TOP] = STATE_Destroy0;
					current = STATE_TOP;
					break;
				case STATE_Destroy1Create2:
					this.history[STATE_TOP] = STATE_Destroy1Create2;
					current = STATE_TOP;
					break;
				case STATE_Done:
					this.history[STATE_TOP] = STATE_Done;
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
			case CHAIN_TRANS_INITIAL_TO__CreateOptional2:
			{
				return STATE_CreateOptional2;
			}
			case CHAIN_TRANS_tr0_FROM_CreateOptional2_TO_CreateOptional1_BY_hellop0:
			{
				String txt = (String) generic_data;
				action_TRANS_tr0_FROM_CreateOptional2_TO_CreateOptional1_BY_hellop0(ifitem, txt);
				return STATE_CreateOptional1;
			}
			case CHAIN_TRANS_tr2_FROM_CreateOptional1_TO_ReceivedHelloAgain_BY_hellop0:
			{
				String txt = (String) generic_data;
				action_TRANS_tr2_FROM_CreateOptional1_TO_ReceivedHelloAgain_BY_hellop0(ifitem, txt);
				return STATE_ReceivedHelloAgain;
			}
			case CHAIN_TRANS_tr1_FROM_ReceivedHelloAgain_TO_Destroy0_BY_hellop0:
			{
				String txt = (String) generic_data;
				action_TRANS_tr1_FROM_ReceivedHelloAgain_TO_Destroy0_BY_hellop0(ifitem, txt);
				return STATE_Destroy0;
			}
			case CHAIN_TRANS_tr3_FROM_Destroy0_TO_Destroy1Create2_BY_hellop0:
			{
				String txt = (String) generic_data;
				action_TRANS_tr3_FROM_Destroy0_TO_Destroy1Create2_BY_hellop0(ifitem, txt);
				return STATE_Destroy1Create2;
			}
			case CHAIN_TRANS_tr4_FROM_Destroy1Create2_TO_Done_BY_hellop0:
			{
				String txt = (String) generic_data;
				action_TRANS_tr4_FROM_Destroy1Create2_TO_Done_BY_hellop0(ifitem, txt);
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
				case STATE_CreateOptional2:
					if (!(skip_entry)) entry_CreateOptional2();
					/* in leaf state: return state id */
					return STATE_CreateOptional2;
				case STATE_CreateOptional1:
					if (!(skip_entry)) entry_CreateOptional1();
					/* in leaf state: return state id */
					return STATE_CreateOptional1;
				case STATE_ReceivedHelloAgain:
					/* in leaf state: return state id */
					return STATE_ReceivedHelloAgain;
				case STATE_Destroy0:
					if (!(skip_entry)) entry_Destroy0();
					/* in leaf state: return state id */
					return STATE_Destroy0;
				case STATE_Destroy1Create2:
					if (!(skip_entry)) entry_Destroy1Create2();
					/* in leaf state: return state id */
					return STATE_Destroy1Create2;
				case STATE_Done:
					/* in leaf state: return state id */
					return STATE_Done;
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
		int chain = CHAIN_TRANS_INITIAL_TO__CreateOptional2;
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
				case STATE_CreateOptional2:
					switch(trigger) {
							case TRIG_p0__hello:
								{
									chain = CHAIN_TRANS_tr0_FROM_CreateOptional2_TO_CreateOptional1_BY_hellop0;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_CreateOptional1:
					switch(trigger) {
							case TRIG_p0__hello:
								{
									chain = CHAIN_TRANS_tr2_FROM_CreateOptional1_TO_ReceivedHelloAgain_BY_hellop0;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_ReceivedHelloAgain:
					switch(trigger) {
							case TRIG_p0__hello:
								{
									chain = CHAIN_TRANS_tr1_FROM_ReceivedHelloAgain_TO_Destroy0_BY_hellop0;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Destroy0:
					switch(trigger) {
							case TRIG_p0__hello:
								{
									chain = CHAIN_TRANS_tr3_FROM_Destroy0_TO_Destroy1Create2_BY_hellop0;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Destroy1Create2:
					switch(trigger) {
							case TRIG_p0__hello:
								{
									chain = CHAIN_TRANS_tr4_FROM_Destroy1Create2_TO_Done_BY_hellop0;
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
