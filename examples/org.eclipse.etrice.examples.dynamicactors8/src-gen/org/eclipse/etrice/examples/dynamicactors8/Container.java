package org.eclipse.etrice.examples.dynamicactors8;

import org.eclipse.etrice.runtime.java.modelbase.IPersistable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.DataPortBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.examples.dynamicactors8.PStep.*;

import org.eclipse.etrice.examples.dynamicactors8.OptionalInterface;
import org.eclipse.etrice.examples.dynamicactors8.OptionalInterface;

/*--------------------- begin user code ---------------------*/
import java.io.File;
/*--------------------- end user code ---------------------*/


public class Container extends ActorClassBase implements IPersistable {

	/*--------------------- begin user code ---------------------*/
	private static final String FIRST_OPT_OBJ = "firstOpt.obj";
	private static final String SECOND_OPT_OBJ = "secondOpt.obj";
	/*--------------------- end user code ---------------------*/
	
	//--------------------- ports
	protected PStepConjPort op = null;
	protected PStepConjReplPort opa = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	protected OptionalInterface opt = null;
	protected OptionalReplicatedInterface optarr = null;
	
	//--------------------- interface item IDs
	public static final int IFITEM_op = 1;
	public static final int IFITEM_opa = 2;
	
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/
	public void clean() {
		File f = new File(FIRST_OPT_OBJ);
		if (f.exists())
			f.delete();
	}

	//--------------------- construction
	public Container(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Container");
		
		// initialize attributes

		// own ports
		op = new PStepConjPort(this, "op", IFITEM_op);
		opa = new PStepConjReplPort(this, "opa", IFITEM_opa);
		
		// own saps
		
		// own service implementations
		
		// sub actors
		opt = new OptionalInterface(this, "opt");
		optarr = new OptionalReplicatedInterface(this, "optarr");
		
		// wiring
		InterfaceItemBase.connect(this, "opt/fct", "op");
		InterfaceItemBase.connect(this, "optarr/fct", "opa");
		

	}
	
	/* --------------------- attribute setters and getters */
	
	
	//--------------------- port getters
	public PStepConjPort getOp (){
		return this.op;
	}
	public PStepConjReplPort getOpa (){
		return this.opa;
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
	public static final int STATE_Init = 2;
	public static final int STATE_DestroyAndCreate = 3;
	public static final int STATE_DestroyAndRestore = 4;
	public static final int STATE_Done = 5;
	public static final int STATE_LoadInArray = 6;
	public static final int STATE_ReceivedHello = 7;
	public static final int STATE_MAX = 8;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Init = 1;
	public static final int CHAIN_TRANS_tr0_FROM_Init_TO_DestroyAndCreate_BY_helloop = 2;
	public static final int CHAIN_TRANS_tr1_FROM_DestroyAndCreate_TO_DestroyAndRestore_BY_helloop = 3;
	public static final int CHAIN_TRANS_tr2_FROM_DestroyAndRestore_TO_LoadInArray_BY_helloop = 4;
	public static final int CHAIN_TRANS_tr3_FROM_LoadInArray_TO_ReceivedHello_BY_helloopa = 5;
	public static final int CHAIN_TRANS_tr4_FROM_ReceivedHello_TO_Done_BY_helloopa = 6;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_op__hello = IFITEM_op + EVT_SHIFT*PStep.OUT_hello;
	public static final int TRIG_opa__hello = IFITEM_opa + EVT_SHIFT*PStep.OUT_hello;
	
	// state names
	protected static final String stateStrings[] = {
		"<no state>",
		"<top>",
		"Init",
		"DestroyAndCreate",
		"DestroyAndRestore",
		"Done",
		"LoadInArray",
		"ReceivedHello"
	};
		
	// history
	protected int history[] = {NO_STATE, NO_STATE, NO_STATE, NO_STATE, NO_STATE, NO_STATE, NO_STATE, NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_Init() {
		clean();
		FilePersistor.createAndLoad(opt, getThread(), FIRST_OPT_OBJ, "Optional1");
		op.step();
		op.step();
		op.sayHello();
	}
	protected void entry_DestroyAndCreate() {
		FilePersistor.saveAndDestroy(opt, FIRST_OPT_OBJ);
		FilePersistor.createAndLoad(opt, getThread(), SECOND_OPT_OBJ, "Optional2");
		op.step();
		op.step();
		op.sayHello();
	}
	protected void entry_DestroyAndRestore() {
		FilePersistor.saveAndDestroy(opt, SECOND_OPT_OBJ);
		FilePersistor.createAndLoad(opt, getThread(), FIRST_OPT_OBJ, "Optional1");
		op.sayHello();
	}
	protected void entry_Done() {
		System.out.println("Done, enter 'quit' to exit");
	}
	protected void entry_LoadInArray() {
		FilePersistor.createAndLoad(optarr, getThread(), FIRST_OPT_OBJ, "Optional1");
		FilePersistor.createAndLoad(optarr, getThread(), SECOND_OPT_OBJ, "Optional2");
		opa.sayHello();
	}
	
	/* Action Codes */
	protected void action_TRANS_tr0_FROM_Init_TO_DestroyAndCreate_BY_helloop(InterfaceItemBase ifitem, String txt) {
		System.out.println("received "+txt);
	}
	protected void action_TRANS_tr1_FROM_DestroyAndCreate_TO_DestroyAndRestore_BY_helloop(InterfaceItemBase ifitem, String txt) {
		System.out.println("received "+txt);
	}
	protected void action_TRANS_tr2_FROM_DestroyAndRestore_TO_LoadInArray_BY_helloop(InterfaceItemBase ifitem, String txt) {
		System.out.println("received "+txt);
	}
	protected void action_TRANS_tr3_FROM_LoadInArray_TO_ReceivedHello_BY_helloopa(InterfaceItemBase ifitem, String txt) {
		System.out.println("received "+txt);
	}
	protected void action_TRANS_tr4_FROM_ReceivedHello_TO_Done_BY_helloopa(InterfaceItemBase ifitem, String txt) {
		System.out.println("received "+txt);
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
				case STATE_Init:
					this.history[STATE_TOP] = STATE_Init;
					current = STATE_TOP;
					break;
				case STATE_DestroyAndCreate:
					this.history[STATE_TOP] = STATE_DestroyAndCreate;
					current = STATE_TOP;
					break;
				case STATE_DestroyAndRestore:
					this.history[STATE_TOP] = STATE_DestroyAndRestore;
					current = STATE_TOP;
					break;
				case STATE_Done:
					this.history[STATE_TOP] = STATE_Done;
					current = STATE_TOP;
					break;
				case STATE_LoadInArray:
					this.history[STATE_TOP] = STATE_LoadInArray;
					current = STATE_TOP;
					break;
				case STATE_ReceivedHello:
					this.history[STATE_TOP] = STATE_ReceivedHello;
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
			case CHAIN_TRANS_INITIAL_TO__Init:
			{
				return STATE_Init;
			}
			case CHAIN_TRANS_tr0_FROM_Init_TO_DestroyAndCreate_BY_helloop:
			{
				String txt = (String) generic_data;
				action_TRANS_tr0_FROM_Init_TO_DestroyAndCreate_BY_helloop(ifitem, txt);
				return STATE_DestroyAndCreate;
			}
			case CHAIN_TRANS_tr1_FROM_DestroyAndCreate_TO_DestroyAndRestore_BY_helloop:
			{
				String txt = (String) generic_data;
				action_TRANS_tr1_FROM_DestroyAndCreate_TO_DestroyAndRestore_BY_helloop(ifitem, txt);
				return STATE_DestroyAndRestore;
			}
			case CHAIN_TRANS_tr2_FROM_DestroyAndRestore_TO_LoadInArray_BY_helloop:
			{
				String txt = (String) generic_data;
				action_TRANS_tr2_FROM_DestroyAndRestore_TO_LoadInArray_BY_helloop(ifitem, txt);
				return STATE_LoadInArray;
			}
			case CHAIN_TRANS_tr3_FROM_LoadInArray_TO_ReceivedHello_BY_helloopa:
			{
				String txt = (String) generic_data;
				action_TRANS_tr3_FROM_LoadInArray_TO_ReceivedHello_BY_helloopa(ifitem, txt);
				return STATE_ReceivedHello;
			}
			case CHAIN_TRANS_tr4_FROM_ReceivedHello_TO_Done_BY_helloopa:
			{
				String txt = (String) generic_data;
				action_TRANS_tr4_FROM_ReceivedHello_TO_Done_BY_helloopa(ifitem, txt);
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
				case STATE_Init:
					if (!(skip_entry)) entry_Init();
					/* in leaf state: return state id */
					return STATE_Init;
				case STATE_DestroyAndCreate:
					if (!(skip_entry)) entry_DestroyAndCreate();
					/* in leaf state: return state id */
					return STATE_DestroyAndCreate;
				case STATE_DestroyAndRestore:
					if (!(skip_entry)) entry_DestroyAndRestore();
					/* in leaf state: return state id */
					return STATE_DestroyAndRestore;
				case STATE_Done:
					if (!(skip_entry)) entry_Done();
					/* in leaf state: return state id */
					return STATE_Done;
				case STATE_LoadInArray:
					if (!(skip_entry)) entry_LoadInArray();
					/* in leaf state: return state id */
					return STATE_LoadInArray;
				case STATE_ReceivedHello:
					/* in leaf state: return state id */
					return STATE_ReceivedHello;
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
		int chain = CHAIN_TRANS_INITIAL_TO__Init;
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
				case STATE_Init:
					switch(trigger) {
							case TRIG_op__hello:
								{
									chain = CHAIN_TRANS_tr0_FROM_Init_TO_DestroyAndCreate_BY_helloop;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_DestroyAndCreate:
					switch(trigger) {
							case TRIG_op__hello:
								{
									chain = CHAIN_TRANS_tr1_FROM_DestroyAndCreate_TO_DestroyAndRestore_BY_helloop;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_DestroyAndRestore:
					switch(trigger) {
							case TRIG_op__hello:
								{
									chain = CHAIN_TRANS_tr2_FROM_DestroyAndRestore_TO_LoadInArray_BY_helloop;
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
				case STATE_LoadInArray:
					switch(trigger) {
							case TRIG_opa__hello:
								{
									chain = CHAIN_TRANS_tr3_FROM_LoadInArray_TO_ReceivedHello_BY_helloopa;
									catching_state = STATE_TOP;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_ReceivedHello:
					switch(trigger) {
							case TRIG_opa__hello:
								{
									chain = CHAIN_TRANS_tr4_FROM_ReceivedHello_TO_Done_BY_helloopa;
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
	
	@Override
	public void saveObject(ObjectOutput output) throws IOException {
		// state and history
		output.writeInt(getState());
		for (int h: history) output.writeInt(h);
		
		saveAttributes(output);
	}
	
	protected void saveAttributes(ObjectOutput output) throws IOException {
	}
	
	@Override
	public void loadObject(ObjectInput input) throws IOException, ClassNotFoundException {
		// state and history
		setState(input.readInt());
		for (int i=0; i<history.length; ++i) history[i] = input.readInt();
		
		loadAttributes(input);
	}
	
	protected void loadAttributes(ObjectInput input) throws IOException, ClassNotFoundException {
	}
};
