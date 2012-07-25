package org.eclipse.etrice.integration.ConfigTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.ConfigTest.PortProtocol.*;

/*--------------------- begin user code ---------------------*/
import org.eclipse.etrice.runtime.java.messaging.RTServices;
/*--------------------- end user code ---------------------*/


public class Testee_ac extends ActorClassBase {

	
	//--------------------- ports
	protected PortProtocolPort Reg_port = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_Reg_port = 1;
		
	/*--------------------- attributes ---------------------*/
	boolean bool_r;
	boolean bool_c;
	boolean bool_i;
	int int_r;
	int int_c;
	int int_i;
	double float_r;
	double float_c;
	double float_i;
	char char_c;
	char char_i;
	char string_c[];
	char string_i[];
	int array1_r[];
	int array1_c[];
	int array1_i[];
	boolean array2_r[];
	boolean array2_c[];
	boolean array2_i[];
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Testee_ac(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("Testee_ac");
		
		// initialize attributes
		bool_r = true;
		bool_c = false;
		bool_i = false;
		int_r = 100;
		int_c = 210;
		int_i = 310;
		float_r = 11.11;
		float_c = 16777215;
		float_i = 0.0;
		char_c = 'A';
		char_i = 'B';
		string_c = "ROOM-Coon".toCharArray();
		string_i = "ROOM Gloom".toCharArray();
		array1_r = new int[1];
		for (int i=0;i<1;i++){
			array1_r[i] = 0;
		}
		array1_c = new int[1];
		for (int i=0;i<1;i++){
			array1_c[i] = 99;
		}
		array1_i = new int[1];
		for (int i=0;i<1;i++){
			array1_i[i] = 99;
		}
		array2_r = new boolean[] {true, true};
		array2_c = new boolean[] { false, false };
		array2_i = new boolean[] { false, false };

		// own ports
		Reg_port = new PortProtocolPort(this, "Reg_port", IFITEM_Reg_port, 0, port_addr[IFITEM_Reg_port][0], peer_addr[IFITEM_Reg_port][0]); 
		
		// own saps
		
		// own service implementations
	}
	//--------------------- attributes getter and setter
	//--------------------- attribute setters and getters
	public void setBool_r (boolean bool_r) {
		 this.bool_r = bool_r;
	}
	public boolean getBool_r () {
		return this.bool_r;
	}
	public void setBool_c (boolean bool_c) {
		 this.bool_c = bool_c;
	}
	public boolean getBool_c () {
		return this.bool_c;
	}
	public void setBool_i (boolean bool_i) {
		 this.bool_i = bool_i;
	}
	public boolean getBool_i () {
		return this.bool_i;
	}
	public void setInt_r (int int_r) {
		 this.int_r = int_r;
	}
	public int getInt_r () {
		return this.int_r;
	}
	public void setInt_c (int int_c) {
		 this.int_c = int_c;
	}
	public int getInt_c () {
		return this.int_c;
	}
	public void setInt_i (int int_i) {
		 this.int_i = int_i;
	}
	public int getInt_i () {
		return this.int_i;
	}
	public void setFloat_r (double float_r) {
		 this.float_r = float_r;
	}
	public double getFloat_r () {
		return this.float_r;
	}
	public void setFloat_c (double float_c) {
		 this.float_c = float_c;
	}
	public double getFloat_c () {
		return this.float_c;
	}
	public void setFloat_i (double float_i) {
		 this.float_i = float_i;
	}
	public double getFloat_i () {
		return this.float_i;
	}
	public void setChar_c (char char_c) {
		 this.char_c = char_c;
	}
	public char getChar_c () {
		return this.char_c;
	}
	public void setChar_i (char char_i) {
		 this.char_i = char_i;
	}
	public char getChar_i () {
		return this.char_i;
	}
	public void setString_c (char[] string_c) {
		 this.string_c = string_c;
	}
	public char[] getString_c () {
		return this.string_c;
	}
	public void setString_i (char[] string_i) {
		 this.string_i = string_i;
	}
	public char[] getString_i () {
		return this.string_i;
	}
	public void setArray1_r (int[] array1_r) {
		 this.array1_r = array1_r;
	}
	public int[] getArray1_r () {
		return this.array1_r;
	}
	public void setArray1_c (int[] array1_c) {
		 this.array1_c = array1_c;
	}
	public int[] getArray1_c () {
		return this.array1_c;
	}
	public void setArray1_i (int[] array1_i) {
		 this.array1_i = array1_i;
	}
	public int[] getArray1_i () {
		return this.array1_i;
	}
	public void setArray2_r (boolean[] array2_r) {
		 this.array2_r = array2_r;
	}
	public boolean[] getArray2_r () {
		return this.array2_r;
	}
	public void setArray2_c (boolean[] array2_c) {
		 this.array2_c = array2_c;
	}
	public boolean[] getArray2_c () {
		return this.array2_c;
	}
	public void setArray2_i (boolean[] array2_i) {
		 this.array2_i = array2_i;
	}
	public boolean[] getArray2_i () {
		return this.array2_i;
	}
	//--------------------- port getters
	public PortProtocolPort getReg_port (){
		return this.Reg_port;
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
	public static final int STATE_Testing = 2;
	public static final int STATE_Done = 3;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Testing = 1;
	public static final int CHAIN_TRANS_tr1_FROM_Testing_TO_Done_BY_portTestSuccReg_port = 2;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_Reg_port__portTestSucc = IFITEM_Reg_port + EVT_SHIFT*PortProtocol.IN_portTestSucc;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Testing",
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
	protected void entry_Testing() {
		if(Reg_port.varCheck())
			Reg_port.conjCheck();
	}
	protected void entry_Done() {
		if (bool_r != true || bool_c != false || bool_i != true )
			RTServices.getInstance().getSubSystem().testFinished(1);
		else if (int_r != 100 || int_c != 210 || int_i != 301)
			RTServices.getInstance().getSubSystem().testFinished(2);
		else if (float_r != 11.11 || float_c !=0xFFFFFF || float_i != 0.00001)
			RTServices.getInstance().getSubSystem().testFinished(3);
		//char_r != 'R'
		else if (char_c != 'A' || char_i != 'C')
			RTServices.getInstance().getSubSystem().testFinished(4);
		// string_r.equals("ROOM will bloom")
		else if (string_c.equals("ROOM-Coon") || string_i.equals("ROOM 2 Moon"))
			RTServices.getInstance().getSubSystem().testFinished(5);
		if(array1_r[0] != 0 || array1_c[0] != 99 || array1_i[0] != 4)
			RTServices.getInstance().getSubSystem().testFinished(6);
		if(array2_r[0] != true || array2_r[1] != true)
			RTServices.getInstance().getSubSystem().testFinished(7);
		if(array2_c[0] != false || array2_c[1] != false)
			RTServices.getInstance().getSubSystem().testFinished(8);
		if(array2_i[0] != false || array2_i[1] != true)
			RTServices.getInstance().getSubSystem().testFinished(9);
		else
			RTServices.getInstance().getSubSystem().testFinished(0);
	}
	
	/* Action Codes */
	
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
				case STATE_Testing:
					this.history[STATE_TOP] = STATE_Testing;
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
			case CHAIN_TRANS_INITIAL_TO__Testing:
			{
				return STATE_Testing;
			}
			case CHAIN_TRANS_tr1_FROM_Testing_TO_Done_BY_portTestSuccReg_port:
			{
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
				case STATE_Testing:
					if (!(skip_entry || handler)) entry_Testing();
					// in leaf state: return state id
					return STATE_Testing;
				case STATE_Done:
					if (!(skip_entry || handler)) entry_Done();
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
		int chain = CHAIN_TRANS_INITIAL_TO__Testing;
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
				case STATE_Testing:
					switch(trigger) {
						case TRIG_Reg_port__portTestSucc:
							{
								chain = CHAIN_TRANS_tr1_FROM_Testing_TO_Done_BY_portTestSuccReg_port;
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
