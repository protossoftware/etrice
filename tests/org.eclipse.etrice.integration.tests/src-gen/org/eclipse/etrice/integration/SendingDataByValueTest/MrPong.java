package org.eclipse.etrice.integration.SendingDataByValueTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.SendingDataByValueTest.PingPongProtocol.*;



public class MrPong extends ActorClassBase {

	
	//--------------------- ports
	protected PingPongProtocolPort PingPongPort = null;
	//--------------------- saps
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_PingPongPort = 1;
		
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/
	public void printData(PingPongData d) {
		System.out.printf("\n");
		System.out.printf("i8Val: %d \n",d.getI8Val());
		System.out.printf("i16Val: %d \n",d.getI16Val());
		System.out.printf("i32Val: %d \n",d.getI32Val());
		System.out.printf("charVal: %c \n",d.getCharVal());
		System.out.printf("f32Val: %f \n",d.getF32Val());
		System.out.printf("f64Val: %f \n",d.getF64Val());
		System.out.printf("stringVal: %s \n",d.getStringVal());
		System.out.printf("i32Array: %d %d %d %d %d\n",d.getArrayFromInt32()[0],d.getArrayFromInt32()[1],d.getArrayFromInt32()[2],d.getArrayFromInt32()[3],d.getArrayFromInt32()[4] );
		System.out.printf("\n");
	}

	//--------------------- construction
	public MrPong(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("MrPong");
		
		// initialize attributes

		// own ports
		PingPongPort = new PingPongProtocolPort(this, "PingPongPort", IFITEM_PingPongPort, 0, port_addr[IFITEM_PingPongPort][0], peer_addr[IFITEM_PingPongPort][0]); 
		// own saps
		// own service implementations
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
		destroyUser();
	}	

	
	/* state IDs */
	public static final int STATE_reply = 2;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__reply = 1;
	public static final int CHAIN_TRANS_reply_TO_reply_BY_pingPingPongPort_tr0 = 2;
	public static final int CHAIN_TRANS_reply_TO_reply_BY_pingSimplePingPongPort_tr1 = 3;
	
	/* triggers */
	public static final int POLLING = 0;
	public static final int TRIG_PingPongPort__ping = IFITEM_PingPongPort + EVT_SHIFT*PingPongProtocol.IN_ping;
	public static final int TRIG_PingPongPort__pingSimple = IFITEM_PingPongPort + EVT_SHIFT*PingPongProtocol.IN_pingSimple;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","reply"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	
	/* Action Codes */
	protected void action_TRANS_reply_TO_reply_BY_pingPingPongPort_tr0(InterfaceItemBase ifitem, PingPongData p) {
		p.setI8Val((byte)(p.getI8Val()+1));
		
		
		PingPongPort.pong(p);
	}
	protected void action_TRANS_reply_TO_reply_BY_pingSimplePingPongPort_tr1(InterfaceItemBase ifitem, int p) {
		PingPongPort.pongSimple(++p);
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
				case STATE_reply:
					this.history[STATE_TOP] = STATE_reply;
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
			case CHAIN_TRANS_reply_TO_reply_BY_pingPingPongPort_tr0:
			{
				PingPongData p = (PingPongData) generic_data;
				action_TRANS_reply_TO_reply_BY_pingPingPongPort_tr0(ifitem, p);
				return STATE_reply;
			}
			case CHAIN_TRANS_reply_TO_reply_BY_pingSimplePingPongPort_tr1:
			{
				int p = (Integer) generic_data;
				action_TRANS_reply_TO_reply_BY_pingSimplePingPongPort_tr1(ifitem, p);
				return STATE_reply;
			}
			case CHAIN_TRANS_INITIAL_TO__reply:
			{
				return STATE_reply;
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
				case STATE_reply:
					// in leaf state: return state id
					return STATE_reply;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__reply;
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
				case STATE_reply:
					switch(trigger) {
						case TRIG_PingPongPort__ping:
							{
								chain = CHAIN_TRANS_reply_TO_reply_BY_pingPingPongPort_tr0;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_PingPongPort__pingSimple:
							{
								chain = CHAIN_TRANS_reply_TO_reply_BY_pingSimplePingPongPort_tr1;
								catching_state = STATE_TOP;
							}
						break;
					}
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
