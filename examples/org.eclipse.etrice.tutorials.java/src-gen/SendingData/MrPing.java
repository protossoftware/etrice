package SendingData;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;


import SendingData.PingPongProtocol.*;



public class MrPing extends ActorClassBase {

	
	//--------------------- ports
	protected PingPongProtocolConjPort PingPongPort = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_PingPongPort = 1;

	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/
	public void printData(DemoData d) {
		System.out.printf("d.int32Val: %d\n",d.int32Val);
		System.out.printf("d.float64Val: %f\n",d.float64Val);
		System.out.printf("d.int8Array: ");
		for(int i = 0; i<d.int8Array.length; i++) {
		System.out.printf("%d ",d.int8Array[i]);}
		System.out.printf("\nd.stringVal: %s\n",d.stringVal);
	}

	//--------------------- construction
	public MrPing(IRTObject parent, String name) {
		super(parent, name);
		setClassName("MrPing");
		
		// initialize attributes

		// own ports
		PingPongPort = new PingPongProtocolConjPort(this, "PingPongPort", IFITEM_PingPongPort); 
		
		// own saps
		
		// own service implementations
		
		// sub actors

	}
	
	//--------------------- attribute setters and getters
	
	
	//--------------------- port getters
	public PingPongProtocolConjPort getPingPongPort (){
		return this.PingPongPort;
	}

	//--------------------- lifecycle functions
	public void stop(){
		stopUser();
		super.stop();
	}
	

	/* state IDs */
	public static final int STATE_waitForPong = 2;
	public static final int STATE_waitForPongSimple = 3;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__waitForPongSimple = 1;
	public static final int CHAIN_TRANS_next_FROM_waitForPongSimple_TO_waitForPong_BY_pongSimplePingPongPort = 2;
	public static final int CHAIN_TRANS_wait1_FROM_waitForPongSimple_TO_waitForPongSimple_BY_pongSimplePingPongPort_wait1 = 3;
	public static final int CHAIN_TRANS_wait2_FROM_waitForPong_TO_waitForPong_BY_pongPingPongPort_wait2 = 4;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_PingPongPort__pong = IFITEM_PingPongPort + EVT_SHIFT*PingPongProtocol.OUT_pong;
	public static final int TRIG_PingPongPort__pongSimple = IFITEM_PingPongPort + EVT_SHIFT*PingPongProtocol.OUT_pongSimple;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","waitForPong",
	"waitForPongSimple"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println("state switch of "+getInstancePath() + ": "
					+ stateStrings[this.state] + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_wait2_FROM_waitForPong_TO_waitForPong_BY_pongPingPongPort_wait2(InterfaceItemBase ifitem, DemoData data) {
		printData(data);
	}
	protected void action_TRANS_wait1_FROM_waitForPongSimple_TO_waitForPongSimple_BY_pongSimplePingPongPort_wait1(InterfaceItemBase ifitem, int data) {
		// keep in mind that MrPong increments
		PingPongPort.pingSimple(data);
		System.out.printf("data: %d\n",data);
	}
	protected void action_TRANS_next_FROM_waitForPongSimple_TO_waitForPong_BY_pongSimplePingPongPort(InterfaceItemBase ifitem, int data) {
		System.out.printf("data: %d\n",data);
		
		DemoData d = new DemoData();
		// send the default values
		PingPongPort.ping(d);
		d.int32Val=815;
		for (int i = 0; i<d.int8Array.length;i++){
			d.int8Array[i]=(byte)(i+100);
			}
		d.stringVal="some contents";
		d.float64Val=3.141234;
		PingPongPort.ping(d);
	}
	protected void action_TRANS_INITIAL_TO__waitForPongSimple() {
		PingPongPort.pingSimple(0);
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
				case STATE_waitForPong:
					this.history[STATE_TOP] = STATE_waitForPong;
					current = STATE_TOP;
					break;
				case STATE_waitForPongSimple:
					this.history[STATE_TOP] = STATE_waitForPongSimple;
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
			case CHAIN_TRANS_wait2_FROM_waitForPong_TO_waitForPong_BY_pongPingPongPort_wait2:
			{
				DemoData data = (DemoData) generic_data;
				action_TRANS_wait2_FROM_waitForPong_TO_waitForPong_BY_pongPingPongPort_wait2(ifitem, data);
				return STATE_waitForPong;
			}
			case CHAIN_TRANS_wait1_FROM_waitForPongSimple_TO_waitForPongSimple_BY_pongSimplePingPongPort_wait1:
			{
				int data = (Integer) generic_data;
				action_TRANS_wait1_FROM_waitForPongSimple_TO_waitForPongSimple_BY_pongSimplePingPongPort_wait1(ifitem, data);
				return STATE_waitForPongSimple;
			}
			case CHAIN_TRANS_next_FROM_waitForPongSimple_TO_waitForPong_BY_pongSimplePingPongPort:
			{
				int data = (Integer) generic_data;
				action_TRANS_next_FROM_waitForPongSimple_TO_waitForPong_BY_pongSimplePingPongPort(ifitem, data);
				return STATE_waitForPong;
			}
			case CHAIN_TRANS_INITIAL_TO__waitForPongSimple:
			{
				action_TRANS_INITIAL_TO__waitForPongSimple();
				return STATE_waitForPongSimple;
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
				case STATE_waitForPong:
					// in leaf state: return state id
					return STATE_waitForPong;
				case STATE_waitForPongSimple:
					// in leaf state: return state id
					return STATE_waitForPongSimple;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__waitForPongSimple;
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
			switch (getState()) {
				case STATE_waitForPong:
					switch(trigger) {
						case TRIG_PingPongPort__pong:
							{
								chain = CHAIN_TRANS_wait2_FROM_waitForPong_TO_waitForPong_BY_pongPingPongPort_wait2;
								catching_state = STATE_TOP;
							}
						break;
					}
					break;
				case STATE_waitForPongSimple:
					switch(trigger) {
						case TRIG_PingPongPort__pongSimple:
							{ int data = (Integer) generic_data;
							if (data < 10)
							{
								chain = CHAIN_TRANS_wait1_FROM_waitForPongSimple_TO_waitForPongSimple_BY_pongSimplePingPongPort_wait1;
								catching_state = STATE_TOP;
							} else 
							{
								chain = CHAIN_TRANS_next_FROM_waitForPongSimple_TO_waitForPong_BY_pongSimplePingPongPort;
								catching_state = STATE_TOP;
							}
							}
						break;
					}
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(getState(), catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
