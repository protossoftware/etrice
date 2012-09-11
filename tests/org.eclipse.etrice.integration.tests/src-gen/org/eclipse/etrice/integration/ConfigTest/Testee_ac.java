package org.eclipse.etrice.integration.ConfigTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import org.eclipse.etrice.integration.ConfigTest.PortProtocol.*;
import org.eclipse.etrice.integration.ConfigTest.TestCommProtocol.*;

/*--------------------- begin user code ---------------------*/
import org.eclipse.etrice.runtime.java.messaging.RTServices;
/*--------------------- end user code ---------------------*/


public class Testee_ac extends ActorClassBase {

	
	
	//--------------------- ports
	protected TestCommProtocolPort Reg_dynConfigPort = null;
	protected PortProtocolPort Reg_port = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_Reg_dynConfigPort = 1;
	public static final int IFITEM_Reg_port = 2;

		
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
	char char_r;
	char char_c;
	char char_i;
	char charArray_r[];
	char charArray_c[];
	char charArray_i[];
	String string_r;
	String string_c;
	String string_i;
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
		float_c = 16777215d;
		float_i = 0.0d;
		char_r = 'R';
		char_c = 'A';
		char_i = 'B';
		charArray_r = "ROOM will bloom".toCharArray();
		charArray_c = "ROOM-Coon".toCharArray();
		charArray_i = "ROOM Gloom".toCharArray();
		string_r = ":/";
		string_c = ":-)";
		string_i = ":-]";
		array1_r = new int[1];
		for (int i=0;i<1;i++){
			array1_r[i] = 0;
		}
		array1_c = new int[] {99};
		array1_i = new int[] {99};
		array2_r = new boolean[] {true, true};
		array2_c = new boolean[] {false, false};
		array2_i = new boolean[] {false, false};

		// own ports
		Reg_dynConfigPort = new TestCommProtocolPort(this, "Reg_dynConfigPort", IFITEM_Reg_dynConfigPort, 0, port_addr[IFITEM_Reg_dynConfigPort][0], peer_addr[IFITEM_Reg_dynConfigPort][0]); 
		Reg_port = new PortProtocolPort(this, "Reg_port", IFITEM_Reg_port, 0, port_addr[IFITEM_Reg_port][0], peer_addr[IFITEM_Reg_port][0]); 
		
		// own saps
		
		// own service implementations
	}

	
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
	public void setChar_r (char char_r) {
		 this.char_r = char_r;
	}
	public char getChar_r () {
		return this.char_r;
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
	public void setCharArray_r (char[] charArray_r) {
		 this.charArray_r = charArray_r;
	}
	public char[] getCharArray_r () {
		return this.charArray_r;
	}
	public void setCharArray_c (char[] charArray_c) {
		 this.charArray_c = charArray_c;
	}
	public char[] getCharArray_c () {
		return this.charArray_c;
	}
	public void setCharArray_i (char[] charArray_i) {
		 this.charArray_i = charArray_i;
	}
	public char[] getCharArray_i () {
		return this.charArray_i;
	}
	public void setString_r (String string_r) {
		 this.string_r = string_r;
	}
	public String getString_r () {
		return this.string_r;
	}
	public void setString_c (String string_c) {
		 this.string_c = string_c;
	}
	public String getString_c () {
		return this.string_c;
	}
	public void setString_i (String string_i) {
		 this.string_i = string_i;
	}
	public String getString_i () {
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
	public TestCommProtocolPort getReg_dynConfigPort (){
		return this.Reg_dynConfigPort;
	}
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
	public static final int STATE_Testing1 = 2;
	public static final int STATE_Testing2 = 3;
	public static final int STATE_Done = 4;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Testing1 = 1;
	public static final int CHAIN_TRANS_tr1_FROM_Testing1_TO_Testing2_BY_portTestSuccReg_port = 2;
	public static final int CHAIN_TRANS_tr2_FROM_Testing2_TO_Done_BY_okReg_dynConfigPort = 3;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_Reg_dynConfigPort__ok = IFITEM_Reg_dynConfigPort + EVT_SHIFT*TestCommProtocol.IN_ok;
	public static final int TRIG_Reg_port__portTestSucc = IFITEM_Reg_port + EVT_SHIFT*PortProtocol.IN_portTestSucc;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Testing1",
	"Testing2",
	"Done"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_Testing1() {
		if(Reg_port.varCheck())
			Reg_port.conjCheck();
	}
	protected void entry_Testing2() {
		Reg_dynConfigPort.test();
	}
	protected void entry_Done() {
		if (bool_r != true || bool_c != false || bool_i != true )
			RTServices.getInstance().getSubSystem().testFinished(1);
		else if (int_r != 100 || int_c != 210 || int_i != 301)
			RTServices.getInstance().getSubSystem().testFinished(2);
		else if (float_r != 11.11 || float_c !=0xFFFFFF || float_i != 0.00001)
			RTServices.getInstance().getSubSystem().testFinished(3);
		else if (char_r != 'R' || char_c != 'A' || char_i != 'C')
			RTServices.getInstance().getSubSystem().testFinished(4);
		// string_r.equals("ROOM will bloom")
		else if (charArray_r.equals("ROOM will bloom") || charArray_c.equals("ROOM-Coon") || charArray_i.equals("ROOM 2 Moon"))
			RTServices.getInstance().getSubSystem().testFinished(5);
		else if (!string_r.equals(":/") || !string_c.equals(":-)") || !string_i.equals(":^]"))
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
				case STATE_Testing1:
					this.history[STATE_TOP] = STATE_Testing1;
					current = STATE_TOP;
					break;
				case STATE_Testing2:
					this.history[STATE_TOP] = STATE_Testing2;
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
			case CHAIN_TRANS_INITIAL_TO__Testing1:
			{
				return STATE_Testing1;
			}
			case CHAIN_TRANS_tr1_FROM_Testing1_TO_Testing2_BY_portTestSuccReg_port:
			{
				return STATE_Testing2;
			}
			case CHAIN_TRANS_tr2_FROM_Testing2_TO_Done_BY_okReg_dynConfigPort:
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
				case STATE_Testing1:
					if (!(skip_entry || handler)) entry_Testing1();
					// in leaf state: return state id
					return STATE_Testing1;
				case STATE_Testing2:
					if (!(skip_entry || handler)) entry_Testing2();
					// in leaf state: return state id
					return STATE_Testing2;
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
		int chain = CHAIN_TRANS_INITIAL_TO__Testing1;
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
				case STATE_Testing1:
					switch(trigger) {
						case TRIG_Reg_port__portTestSucc:
							{
								chain = CHAIN_TRANS_tr1_FROM_Testing1_TO_Testing2_BY_portTestSuccReg_port;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_Testing2:
					switch(trigger) {
						case TRIG_Reg_dynConfigPort__ok:
							{
								chain = CHAIN_TRANS_tr2_FROM_Testing2_TO_Done_BY_okReg_dynConfigPort;
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
