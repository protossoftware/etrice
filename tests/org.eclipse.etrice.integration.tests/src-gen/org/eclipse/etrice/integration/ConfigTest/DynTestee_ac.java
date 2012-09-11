package org.eclipse.etrice.integration.ConfigTest;

import org.eclipse.etrice.runtime.java.config.DynConfigLock;
import org.eclipse.etrice.runtime.java.config.VariableService;
import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.ConfigTest.TestCommProtocol.*;

/*--------------------- begin user code ---------------------*/
import org.eclipse.etrice.runtime.java.messaging.RTServices;
/*--------------------- end user code ---------------------*/


public class DynTestee_ac extends ActorClassBase {

	
	private VariableService variableService;
	
	//--------------------- ports
	protected TestCommProtocolConjPort Conj_DynConfigPort = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_Conj_DynConfigPort = 1;

		
	/*--------------------- attributes ---------------------*/
	int int_i;
	Dyn_DC1 dc_i;
	int blockMe;
	boolean blocker;
	Dyn_DC1 dc_dump;
	int int_dump;
	private DynConfigLock lock_blocker;
	private DynConfigLock lock_dc_i;
	private DynConfigLock lock_int_i;
	private DynConfigLock lock_blockMe;
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public DynTestee_ac(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("DynTestee_ac");
		
		// initialize attributes
		int_i = 0;
		dc_i = new Dyn_DC1();
		blockMe = 0;
		blocker = false;
		dc_dump = new Dyn_DC1();
		int_dump = 0;

		// own ports
		Conj_DynConfigPort = new TestCommProtocolConjPort(this, "Conj_DynConfigPort", IFITEM_Conj_DynConfigPort, 0, port_addr[IFITEM_Conj_DynConfigPort][0], peer_addr[IFITEM_Conj_DynConfigPort][0]); 
		
		// own saps
		
		// own service implementations
	}

	public DynTestee_ac(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr, VariableService variableService){
		this(parent, name, port_addr, peer_addr);
		
		this.variableService = variableService;
		lock_blocker = new DynConfigLock();
		lock_dc_i = new DynConfigLock();
		lock_int_i = new DynConfigLock();
		lock_blockMe = new DynConfigLock();
	}
	
	//--------------------- attribute setters and getters
	public void setDc_dump (Dyn_DC1 dc_dump) {
		 this.dc_dump = dc_dump;
	}
	public Dyn_DC1 getDc_dump () {
		return this.dc_dump;
	}
	public void setInt_dump (int int_dump) {
		 this.int_dump = int_dump;
	}
	public int getInt_dump () {
		return this.int_dump;
	}
	
	public boolean getBlocker(){
		if(lock_blocker == null)
			return blocker;
		else
			synchronized(lock_blocker){
				return blocker;
			}
	}
	public void setBlocker(boolean blocker){
		if(lock_blocker == null)
			this.blocker = blocker;
		else
			synchronized(lock_blocker){
				this.blocker = blocker;
			}
	}
	public DynConfigLock getBlockerLock(){
		return lock_blocker;
	}	
	public Dyn_DC1 getDc_i(){
		if(lock_dc_i == null)
			return dc_i;
		else
			synchronized(lock_dc_i){
				return dc_i;
			}
	}
	public void setDc_i(Dyn_DC1 dc_i){
		if(lock_dc_i == null)
			this.dc_i = dc_i;
		else
			synchronized(lock_dc_i){
				this.dc_i = dc_i;
			}
	}
	public DynConfigLock getDc_iLock(){
		return lock_dc_i;
	}	
	public int getInt_i(){
		if(lock_int_i == null)
			return int_i;
		else
			synchronized(lock_int_i){
				return int_i;
			}
	}
	public void setInt_i(int int_i){
		if(lock_int_i == null)
			this.int_i = int_i;
		else
			synchronized(lock_int_i){
				this.int_i = int_i;
			}
	}
	public DynConfigLock getInt_iLock(){
		return lock_int_i;
	}	
	public int getBlockMe(){
		if(lock_blockMe == null)
			return blockMe;
		else
			synchronized(lock_blockMe){
				return blockMe;
			}
	}
	public void setBlockMe(int blockMe){
		if(lock_blockMe == null)
			this.blockMe = blockMe;
		else
			synchronized(lock_blockMe){
				this.blockMe = blockMe;
			}
	}
	public DynConfigLock getBlockMeLock(){
		return lock_blockMe;
	}	
	public void setAndWriteDc_dump(Dyn_DC1 dc_dump){
			setDc_dump(dc_dump);
			variableService.write(this.getInstancePath()+"/dc_dump", dc_dump);
	}
	public void setAndWriteInt_dump(int int_dump){
			setInt_dump(int_dump);
			variableService.write(this.getInstancePath()+"/int_dump", int_dump);
	}
	
	//--------------------- port getters
	public TestCommProtocolConjPort getConj_DynConfigPort (){
		return this.Conj_DynConfigPort;
	}

	//--------------------- lifecycle functions
	public void init(){
		initUser();
	}

	public void start(){
		startUser();
	}

	public void stop(){
		stopUser();
	}
	
	public void destroy(){
	}

	
	/* state IDs */
	public static final int STATE_First = 2;
	public static final int STATE_Done = 3;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__First = 1;
	public static final int CHAIN_TRANS_tr0_FROM_First_TO_Done_BY_testConj_DynConfigPort = 2;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_Conj_DynConfigPort__test = IFITEM_Conj_DynConfigPort + EVT_SHIFT*TestCommProtocol.OUT_test;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","First",
	"Done"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_tr0_FROM_First_TO_Done_BY_testConj_DynConfigPort(InterfaceItemBase ifitem) {
		Dyn_DC1 tmp = new Dyn_DC1(123, new long[]{1000}, new Dyn_DC2(0.0e-100, "dummy out".toCharArray()));
		setAndWriteDc_dump(tmp);
		setAndWriteInt_dump(888);
		if(blocker)getBlockMeLock().forbidUpdate(); else getBlockMeLock().allowUpdate();
		int testValue = 0;
		if(int_i != 401 || getDc_i().getLong_array_i()[0] != 403)
			testValue = 30;
		if(getDc_i().getDc_i().getDouble_i() != 0.404)
			testValue = 31;
		if(!String.valueOf(getDc_i().getDc_i().getChar_i()).equals("instance4"))
			testValue = 32;
		System.out.println("blockMe: "+getBlockMe()+", blocker: "+getBlocker());
		if(testValue != 0)
			RTServices.getInstance().getSubSystem().testFinished(testValue);
		else
			Conj_DynConfigPort.ok();
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
				case STATE_First:
					this.history[STATE_TOP] = STATE_First;
					current = STATE_TOP;
					break;
				case STATE_Done:
					this.history[STATE_TOP] = STATE_Done;
					current = STATE_TOP;
					break;
			}
		}
	}
	
	/**
	 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
	 * matching the trigger of this chain. The ID of the final state is returned
	 * @param chain - the chain ID
	 * @param generic_data - the generic data pointer
	 * @return the ID of the final state
	 */
	private int executeTransitionChain(int chain, InterfaceItemBase ifitem, Object generic_data) {
		switch (chain) {
			case CHAIN_TRANS_INITIAL_TO__First:
			{
				return STATE_First;
			}
			case CHAIN_TRANS_tr0_FROM_First_TO_Done_BY_testConj_DynConfigPort:
			{
				action_TRANS_tr0_FROM_First_TO_Done_BY_testConj_DynConfigPort(ifitem);
				return STATE_Done;
			}
		}
		return NO_STATE;
	}
	
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state - the state which is entered
	 * @param handler - entry code is executed if not handler
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state, boolean handler, boolean skip_entry) {
		while (true) {
			switch (state) {
				case STATE_First:
					// in leaf state: return state id
					return STATE_First;
				case STATE_Done:
					// in leaf state: return state id
					return STATE_Done;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__First;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next, false, false);
		setState(next);
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		boolean is_handler = false;
		boolean skip_entry = false;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (this.state) {
				case STATE_First:
					switch(trigger) {
						case TRIG_Conj_DynConfigPort__test:
							{
								chain = CHAIN_TRANS_tr0_FROM_First_TO_Done_BY_testConj_DynConfigPort;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_Done:
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(this.state, catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
