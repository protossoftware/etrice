/**
 * @author generated by eTrice
 *
 * Source File of ActorClass Receiver
 * 
 */

#include "Receiver.h"

#include "modelbase/etActor.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"
#include "etUnit/etUnit.h"
#include "platform/etMemory.h"

#include "CommunicationProtocol.h"


/* interface item IDs */
enum interface_items {
	IFITEM_dataIn = 1
};

/* state IDs */
enum state_ids {
	NO_STATE = 0,
	STATE_TOP = 1,
	STATE_Idle = 2,
	STATE_DataReceived = 3
};

/* transition chains */
enum chain_ids {
	CHAIN_TRANS_INITIAL_TO__Idle = 1,
	CHAIN_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn = 2,
	CHAIN_TRANS_tr1_FROM_DataReceived_TO_DataReceived_BY_sendDatadataIn_tr1 = 3
};

/* triggers */
enum triggers {
	POLLING = 0,
	TRIG_dataIn__sendData = IFITEM_dataIn + EVT_SHIFT*CommunicationProtocol_IN_sendData
};


static void setState(Receiver* self, int new_state) {
	self->state = (etInt16) new_state;
}

static int getState(Receiver* self) {
	return self->state;
}

/* Entry and Exit Codes */

/* Action Codes */
static void action_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn(Receiver* self, const InterfaceItemBase* ifitem) {
	CommunicationProtocolPort_receivedData(&self->constData->dataIn) /* ORIG: dataIn.receivedData() */;
}
static void action_TRANS_tr1_FROM_DataReceived_TO_DataReceived_BY_sendDatadataIn_tr1(Receiver* self, const InterfaceItemBase* ifitem) {
	CommunicationProtocolPort_receivedData(&self->constData->dataIn) /* ORIG: dataIn.receivedData() */;
}

/**
 * calls exit codes while exiting from the current state to one of its
 * parent states while remembering the history
 * @param current - the current state
 * @param to - the final parent state
 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
 */
static void exitTo(Receiver* self, int current, int to, boolean handler) {
	while (current!=to) {
		switch (current) {
			case STATE_Idle:
				self->history[STATE_TOP] = STATE_Idle;
				current = STATE_TOP;
				break;
			case STATE_DataReceived:
				self->history[STATE_TOP] = STATE_DataReceived;
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
static int executeTransitionChain(Receiver* self, int chain, const InterfaceItemBase* ifitem, void* generic_data) {
	switch (chain) {
		case CHAIN_TRANS_INITIAL_TO__Idle:
		{
			return STATE_Idle;
		}
		case CHAIN_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn:
		{
			action_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn(self, ifitem);
			return STATE_DataReceived;
		}
		case CHAIN_TRANS_tr1_FROM_DataReceived_TO_DataReceived_BY_sendDatadataIn_tr1:
		{
			action_TRANS_tr1_FROM_DataReceived_TO_DataReceived_BY_sendDatadataIn_tr1(self, ifitem);
			return STATE_DataReceived;
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
static int enterHistory(Receiver* self, int state, boolean handler, boolean skip_entry) {
	while (TRUE) {
		switch (state) {
			case STATE_Idle:
				// in leaf state: return state id
				return STATE_Idle;
			case STATE_DataReceived:
				// in leaf state: return state id
				return STATE_DataReceived;
			case STATE_TOP:
				state = self->history[STATE_TOP];
				break;
		}
		skip_entry = FALSE;
	}
	//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
}

static void Receiver_executeInitTransition(Receiver* self) {
	int chain = CHAIN_TRANS_INITIAL_TO__Idle;
	int next = executeTransitionChain(self, chain, NULL, NULL);
	next = enterHistory(self, next, FALSE, FALSE);
	setState(self, next);
}

/* receiveEvent contains the main implementation of the FSM */
static void Receiver_receiveEvent(Receiver* self, InterfaceItemBase* ifitem, int evt, void* generic_data) {
	int trigger = ifitem->localId + EVT_SHIFT*evt;
	int chain = NOT_CAUGHT;
	int catching_state = NO_STATE;
	boolean is_handler = FALSE;
	boolean skip_entry = FALSE;
	
	if (!handleSystemEvent(ifitem, evt, generic_data)) {
		switch (getState(self)) {
			case STATE_Idle:
				switch(trigger) {
					case TRIG_dataIn__sendData:
						{
							chain = CHAIN_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn;
							catching_state = STATE_TOP;
						}
					break;
				}
				break;
			case STATE_DataReceived:
				switch(trigger) {
					case TRIG_dataIn__sendData:
						{
							chain = CHAIN_TRANS_tr1_FROM_DataReceived_TO_DataReceived_BY_sendDatadataIn_tr1;
							catching_state = STATE_TOP;
						}
					break;
				}
				break;
		}
	}
	if (chain != NOT_CAUGHT) {
		exitTo(self, getState(self), catching_state, is_handler);
		int next = executeTransitionChain(self, chain, ifitem, generic_data);
		next = enterHistory(self, next, is_handler, skip_entry);
		setState(self, next);
	}
}
	 
//******************************************
// END of generated code for FSM
//******************************************

void Receiver_init(Receiver* self){
	ET_MSC_LOGGER_SYNC_ENTRY("Receiver", "init")
	self->state = STATE_TOP;
	{
		int i;
		for (i=0; i<RECEIVER_HISTORY_SIZE; ++i)
			self->history[i] = NO_STATE;
	}
	Receiver_executeInitTransition(self);
	ET_MSC_LOGGER_SYNC_EXIT
}


void Receiver_receiveMessage(void* self, void* ifitem, const etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("Receiver", "_receiveMessage")
	
	Receiver_receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage))));
	
	ET_MSC_LOGGER_SYNC_EXIT
}


/*--------------------- operations ---------------------*/

