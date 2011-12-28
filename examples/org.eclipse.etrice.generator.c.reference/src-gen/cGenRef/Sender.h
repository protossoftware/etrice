#ifndef _Sender_H_
#define _Sender_H_

#include "datatypes.h"

package cGenRef;




#include "CommunicationProtocol.h"



public class Sender extends ActorClassBase {

	
	//--------------------- ports
	protected CommunicationProtocolConjPort dataOut = null;
	//--------------------- saps
	//--------------------- services

	//--------------------- interface item IDs
	protected static final int IFITEM_dataOut = 1;
	
	//--------------------- attributes
	//--------------------- operations

	//--------------------- construction
	public Sender(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("Sender");
		
		// initialize attributes

		// own ports
		dataOut = new CommunicationProtocolConjPort(this, "dataOut", IFITEM_dataOut, 0, port_addr[IFITEM_dataOut][0], peer_addr[IFITEM_dataOut][0]); 
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

	//******************************************
	// START of generated code for FSM
	//******************************************
	
	// State IDs for FSM
	protected static final int STATE_SendingData = 2;
	protected static final int STATE_Done = 3;
		protected static final String stateStrings[] = {"<no state>","<top>","SendingData",
			"Done"
			};
	
	// history
	// TODOHRR: history defined in ActorClassBase, init in constructor
	//		history = new int[5];
	//		for (int i = 0; i < history.length; i++) {
	//			history[i] = NO_STATE;
	//		}
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	// transition chains
	protected static final int CHAIN_TRANS_INITIAL_TO__SendingData = 1;
	protected static final int CHAIN_TRANS_SendingData_TO_Done_BY_receivedDatadataOut = 2;
	
	// triggers for FSM
	protected static final int TRIG_dataOut__receivedData = IFITEM_dataOut + EVT_SHIFT*CommunicationProtocol.OUT_receivedData;
	
	// receiveEvent contains the main implementation of the FSM
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		boolean is_handler = false;
		boolean skip_entry = false;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (state) {
				case STATE_SendingData:
					switch(trigger) {
					case TRIG_dataOut__receivedData:
						{
							chain = CHAIN_TRANS_SendingData_TO_Done_BY_receivedDatadataOut;
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
			exitTo(state, catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			// TODOTS: model switch for activation
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	@Override
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__SendingData;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next, false, false);
		setState(next);
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
				case STATE_SendingData:
					history[STATE_TOP] = STATE_SendingData;
					current = STATE_TOP;
					break;
				case STATE_Done:
					history[STATE_TOP] = STATE_Done;
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
			case CHAIN_TRANS_INITIAL_TO__SendingData:
			{
				return STATE_SendingData;
			}
			case CHAIN_TRANS_SendingData_TO_Done_BY_receivedDatadataOut:
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
				case STATE_SendingData:
					if (!(skip_entry || handler)) entry_SendingData();
					// in leaf state: return state id
					return STATE_SendingData;
				case STATE_Done:
					// in leaf state: return state id
					return STATE_Done;
				case STATE_TOP:
					state = history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	//*** Entry and Exit Codes
	protected void entry_SendingData() {
		dataOut.sendData(1234);
	}
	
	//*** Action Codes
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};

#endif /* _Sender_H_ */

