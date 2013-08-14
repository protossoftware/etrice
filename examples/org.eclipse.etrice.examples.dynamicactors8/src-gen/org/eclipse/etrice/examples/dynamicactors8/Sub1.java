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
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.examples.dynamicactors8.PStep.*;




public class Sub1 extends ActorClassBase implements IPersistable {

	
	//--------------------- ports
	protected PStepPort fct = null;
	protected PStepConjPort dp = null;
	
	//--------------------- saps
	
	//--------------------- services
	
	//--------------------- optional actors
	
	//--------------------- interface item IDs
	public static final int IFITEM_fct = 1;
	public static final int IFITEM_dp = 2;
	
	/*--------------------- attributes ---------------------*/
	int ival;
	short sval;
	byte bval;
	SomeData some[];
	OtherData other;
	DerivedData derived;
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Sub1(IRTObject parent, String name) {
		super(parent, name);
		setClassName("Sub1");
		
		// initialize attributes
		this.setIval(0);
		this.setSval((short)0);
		this.setBval((byte)0);
		{
			SomeData[] array = new SomeData[3];
			for (int i=0;i<3;i++){
				array[i] = new SomeData();
			}
			this.setSome(array);
		}
		this.setOther(new OtherData());
		this.setDerived(new DerivedData());

		// own ports
		fct = new PStepPort(this, "fct", IFITEM_fct);
		dp = new PStepConjPort(this, "dp", IFITEM_dp);
		
		// own saps
		
		// own service implementations
		
		// sub actors
		DebuggingService.getInstance().addMessageActorCreate(this, "deep");
		new DeepSub1(this, "deep");

	}
	
	/* --------------------- attribute setters and getters */
	public void setIval (int ival) {
		 this.ival = ival;
	}
	public int getIval () {
		return this.ival;
	}
	public void setSval (short sval) {
		 this.sval = sval;
	}
	public short getSval () {
		return this.sval;
	}
	public void setBval (byte bval) {
		 this.bval = bval;
	}
	public byte getBval () {
		return this.bval;
	}
	public void setSome (SomeData[] some) {
		 this.some = some;
	}
	public SomeData[] getSome () {
		return this.some;
	}
	public void setOther (OtherData other) {
		 this.other = other;
	}
	public OtherData getOther () {
		return this.other;
	}
	public void setDerived (DerivedData derived) {
		 this.derived = derived;
	}
	public DerivedData getDerived () {
		return this.derived;
	}
	
	
	//--------------------- port getters
	public PStepPort getFct (){
		return this.fct;
	}
	public PStepConjPort getDp (){
		return this.dp;
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
	public static final int STATE_Step3 = 2;
	public static final int STATE_Step1 = 3;
	public static final int STATE_Step2 = 4;
	public static final int STATE_Step3_StepA = 5;
	public static final int STATE_Step3_StepB = 6;
	public static final int STATE_Step3_StepC = 7;
	public static final int STATE_MAX = 8;
	
	/* transition chains */
	public static final int CHAIN_Step3_TRANS_INITIAL_TO__StepA = 1;
	public static final int CHAIN_Step3_TRANS_tr0_FROM_StepA_TO_StepB_BY_stepfct = 2;
	public static final int CHAIN_Step3_TRANS_tr1_FROM_StepB_TO_StepC_BY_stepfct = 3;
	public static final int CHAIN_TRANS_INITIAL_TO__Step1 = 4;
	public static final int CHAIN_TRANS_tr0_FROM_Step1_TO_Step2_BY_stepfct = 5;
	public static final int CHAIN_TRANS_tr1_FROM_Step2_TO_Step3_BY_stepfct = 6;
	public static final int CHAIN_TRANS_tr2_FROM_tp0_TO_tp0_BY_sayHellofct_tr2 = 7;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_dp__hello = IFITEM_dp + EVT_SHIFT*PStep.OUT_hello;
	public static final int TRIG_fct__step = IFITEM_fct + EVT_SHIFT*PStep.IN_step;
	public static final int TRIG_fct__sayHello = IFITEM_fct + EVT_SHIFT*PStep.IN_sayHello;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Step3",
	"Step1",
	"Step2",
	"Step3_StepA",
	"Step3_StepB",
	"Step3_StepC"
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
	protected void entry_Step1() {
		ival = 1;
		sval = 2;
		bval = 3;
	}
	protected void entry_Step2() {
		ival = 123;
	}
	protected void entry_Step3_StepA() {
		sval = 456;
	}
	protected void entry_Step3_StepB() {
		bval = 13;
	}
	
	/* Action Codes */
	protected void action_TRANS_tr0_FROM_Step1_TO_Step2_BY_stepfct(InterfaceItemBase ifitem) {
		dp.step();
	}
	protected void action_TRANS_tr1_FROM_Step2_TO_Step3_BY_stepfct(InterfaceItemBase ifitem) {
		dp.step();
	}
	protected void action_TRANS_tr2_FROM_tp0_TO_tp0_BY_sayHellofct_tr2(InterfaceItemBase ifitem) {
		fct.hello(getClassName()+", state="+stateStrings[getState()]+", path= "+getInstancePath());
	}
	protected void action_Step3_TRANS_tr0_FROM_StepA_TO_StepB_BY_stepfct(InterfaceItemBase ifitem) {
		dp.step();
	}
	protected void action_Step3_TRANS_tr1_FROM_StepB_TO_StepC_BY_stepfct(InterfaceItemBase ifitem) {
		dp.step();
	}
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
	 */
	private void exitTo(int current, int to, boolean handler) {
		while (current!=to) {
			switch (current) {
				case STATE_Step1:
					this.history[STATE_TOP] = STATE_Step1;
					current = STATE_TOP;
					break;
				case STATE_Step2:
					this.history[STATE_TOP] = STATE_Step2;
					current = STATE_TOP;
					break;
				case STATE_Step3:
					this.history[STATE_TOP] = STATE_Step3;
					current = STATE_TOP;
					break;
				case STATE_Step3_StepA:
					this.history[STATE_Step3] = STATE_Step3_StepA;
					current = STATE_Step3;
					break;
				case STATE_Step3_StepB:
					this.history[STATE_Step3] = STATE_Step3_StepB;
					current = STATE_Step3;
					break;
				case STATE_Step3_StepC:
					this.history[STATE_Step3] = STATE_Step3_StepC;
					current = STATE_Step3;
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
			case CHAIN_TRANS_INITIAL_TO__Step1:
			{
				return STATE_Step1;
			}
			case CHAIN_TRANS_tr0_FROM_Step1_TO_Step2_BY_stepfct:
			{
				action_TRANS_tr0_FROM_Step1_TO_Step2_BY_stepfct(ifitem);
				return STATE_Step2;
			}
			case CHAIN_TRANS_tr1_FROM_Step2_TO_Step3_BY_stepfct:
			{
				action_TRANS_tr1_FROM_Step2_TO_Step3_BY_stepfct(ifitem);
				return STATE_Step3;
			}
			case CHAIN_TRANS_tr2_FROM_tp0_TO_tp0_BY_sayHellofct_tr2:
			{
				action_TRANS_tr2_FROM_tp0_TO_tp0_BY_sayHellofct_tr2(ifitem);
				return STATE_TOP + STATE_MAX;
			}
			case CHAIN_Step3_TRANS_INITIAL_TO__StepA:
			{
				return STATE_Step3_StepA;
			}
			case CHAIN_Step3_TRANS_tr0_FROM_StepA_TO_StepB_BY_stepfct:
			{
				action_Step3_TRANS_tr0_FROM_StepA_TO_StepB_BY_stepfct(ifitem);
				return STATE_Step3_StepB;
			}
			case CHAIN_Step3_TRANS_tr1_FROM_StepB_TO_StepC_BY_stepfct:
			{
				action_Step3_TRANS_tr1_FROM_StepB_TO_StepC_BY_stepfct(ifitem);
				return STATE_Step3_StepC;
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
	 * @param handler - entry code is executed if not handler
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state, boolean handler) {
		boolean skip_entry = false;
		if (state >= STATE_MAX) {
			state =  (state - STATE_MAX);
			skip_entry = true;
		}
		while (true) {
			switch (state) {
				case STATE_Step1:
					if (!(skip_entry || handler)) entry_Step1();
					/* in leaf state: return state id */
					return STATE_Step1;
				case STATE_Step2:
					if (!(skip_entry || handler)) entry_Step2();
					/* in leaf state: return state id */
					return STATE_Step2;
				case STATE_Step3:
					/* state has a sub graph */
					/* with init transition */
					if (this.history[STATE_Step3]==NO_STATE) {
						state = executeTransitionChain(CHAIN_Step3_TRANS_INITIAL_TO__StepA, null, null);
					}
					else {
						state = this.history[STATE_Step3];
					}
					break;
				case STATE_Step3_StepA:
					if (!(skip_entry || handler)) entry_Step3_StepA();
					/* in leaf state: return state id */
					return STATE_Step3_StepA;
				case STATE_Step3_StepB:
					if (!(skip_entry || handler)) entry_Step3_StepB();
					/* in leaf state: return state id */
					return STATE_Step3_StepB;
				case STATE_Step3_StepC:
					/* in leaf state: return state id */
					return STATE_Step3_StepC;
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
		int chain = CHAIN_TRANS_INITIAL_TO__Step1;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next, false);
		setState(next);
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		boolean is_handler = false;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (getState()) {
				case STATE_Step1:
					switch(trigger) {
							case TRIG_fct__step:
								{
									chain = CHAIN_TRANS_tr0_FROM_Step1_TO_Step2_BY_stepfct;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct__sayHello:
								{
									chain = CHAIN_TRANS_tr2_FROM_tp0_TO_tp0_BY_sayHellofct_tr2;
									catching_state = STATE_TOP;
									is_handler = true;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Step2:
					switch(trigger) {
							case TRIG_fct__step:
								{
									chain = CHAIN_TRANS_tr1_FROM_Step2_TO_Step3_BY_stepfct;
									catching_state = STATE_TOP;
								}
							break;
							case TRIG_fct__sayHello:
								{
									chain = CHAIN_TRANS_tr2_FROM_tp0_TO_tp0_BY_sayHellofct_tr2;
									catching_state = STATE_TOP;
									is_handler = true;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Step3_StepA:
					switch(trigger) {
							case TRIG_fct__step:
								{
									chain = CHAIN_Step3_TRANS_tr0_FROM_StepA_TO_StepB_BY_stepfct;
									catching_state = STATE_Step3;
								}
							break;
							case TRIG_fct__sayHello:
								{
									chain = CHAIN_TRANS_tr2_FROM_tp0_TO_tp0_BY_sayHellofct_tr2;
									catching_state = STATE_TOP;
									is_handler = true;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Step3_StepB:
					switch(trigger) {
							case TRIG_fct__step:
								{
									chain = CHAIN_Step3_TRANS_tr1_FROM_StepB_TO_StepC_BY_stepfct;
									catching_state = STATE_Step3;
								}
							break;
							case TRIG_fct__sayHello:
								{
									chain = CHAIN_TRANS_tr2_FROM_tp0_TO_tp0_BY_sayHellofct_tr2;
									catching_state = STATE_TOP;
									is_handler = true;
								}
							break;
							default:
								/* should not occur */
								break;
					}
					break;
				case STATE_Step3_StepC:
					switch(trigger) {
							case TRIG_fct__sayHello:
								{
									chain = CHAIN_TRANS_tr2_FROM_tp0_TO_tp0_BY_sayHellofct_tr2;
									catching_state = STATE_TOP;
									is_handler = true;
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
			exitTo(getState(), catching_state, is_handler);
			{
				int next = executeTransitionChain(chain, ifitem, generic_data);
				next = enterHistory(next, is_handler);
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
		output.write(ival);
		output.writeShort(sval);
		output.writeByte(bval);
		for (SomeData v: some) output.writeObject(v);
		output.writeObject(other);
		output.writeObject(derived);
	}
	
	@Override
	public void loadObject(ObjectInput input) throws IOException, ClassNotFoundException {
		// state and history
		setState(input.readInt());
		for (int i=0; i<history.length; ++i) history[i] = input.readInt();
		
		loadAttributes(input);
	}
	
	protected void loadAttributes(ObjectInput input) throws IOException, ClassNotFoundException {
		ival = input.read();
		sval = input.readShort();
		bval = input.readByte();
		for (int i=0; i< some.length; ++i) some[i] = (SomeData) input.readObject();
		other = (OtherData) input.readObject();
		derived = (DerivedData) input.readObject();
	}
};
