/**
 * @author generated by eTrice
 *
 * Source File of ActorClass Tester
 * 
 */

#include "Tester.h"

#include "modelbase/etActor.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"
#include "platform/etMemory.h"

#include "PTestTrigger.h"


/* interface item IDs */
enum interface_items {
	IFITEM_testee = 1
};


/* state IDs */
enum state_ids {
	NO_STATE = 0,
	STATE_TOP = 1,
	STATE_State1 = 2,
	STATE_Done = 3
};

/* transition chains */
enum chain_ids {
	CHAIN_TRANS_INITIAL_TO__State1 = 1,
	CHAIN_TRANS_State1_TO_Done_BY_donetestee = 2
};

/* triggers */
enum triggers {
	POLLING = 0,
	TRIG_testee__done = IFITEM_testee + EVT_SHIFT*PTestTrigger_OUT_done
};


static void setState(Tester* self, int new_state) {
	self->state = new_state;
}

/* Entry and Exit Codes */
static void entry_State1(Tester* self) {
	PTestTriggerConjPort_trigger(&self->constData->testee) /* testee.trigger() */;
}

/* Action Codes */

/**
 * calls exit codes while exiting from the current state to one of its
 * parent states while remembering the history
 * @param current - the current state
 * @param to - the final parent state
 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
 */
static void exitTo(Tester* self, int current, int to, boolean handler) {
	while (current!=to) {
		switch (current) {
			case STATE_State1:
				self->history[STATE_TOP] = STATE_State1;
				current = STATE_TOP;
				break;
			case STATE_Done:
				self->history[STATE_TOP] = STATE_Done;
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
static int executeTransitionChain(Tester* self, int chain, InterfaceItemBase ifitem, void* generic_data) {
	switch (chain) {
		case CHAIN_TRANS_INITIAL_TO__State1:
		{
			return STATE_State1;
		}
		case CHAIN_TRANS_State1_TO_Done_BY_donetestee:
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
static int enterHistory(Tester* self, int state, boolean handler, boolean skip_entry) {
	while (TRUE) {
		switch (state) {
			case STATE_State1:
				if (!(skip_entry || handler)) entry_State1(self);
				// in leaf state: return state id
				return STATE_State1;
			case STATE_Done:
				// in leaf state: return state id
				return STATE_Done;
			case STATE_TOP:
				state = self->history[STATE_TOP];
				break;
		}
		skip_entry = FALSE;
	}
	//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
}

static void executeInitTransition(Tester* self) {
	int chain = CHAIN_TRANS_INITIAL_TO__State1;
	int next = executeTransitionChain(self, chain, NULL, NULL);
	next = enterHistory(self, next, FALSE, FALSE);
	setState(self, next);
}

/* receiveEvent contains the main implementation of the FSM */
static void receiveEvent(Tester* self, InterfaceItemBase ifitem, int evt, void* generic_data) {
	int trigger = ifitem->localId + EVT_SHIFT*evt;
	int chain = NOT_CAUGHT;
	int catching_state = NO_STATE;
	boolean is_handler = FALSE;
	boolean skip_entry = FALSE;
	
	if (!handleSystemEvent(ifitem, evt, generic_data)) {
		switch (self->state) {
			case STATE_State1:
				switch(trigger) {
					case TRIG_testee__done:
						{
							chain = CHAIN_TRANS_State1_TO_Done_BY_donetestee;
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
		exitTo(self, self->state, catching_state, is_handler);
		int next = executeTransitionChain(self, chain, ifitem, generic_data);
		next = enterHistory(self, next, is_handler, skip_entry);
		setState(self, next);
	}
}
	 
//******************************************
// END of generated code for FSM
//******************************************

void Tester_init(Tester* self){
	ET_MSC_LOGGER_SYNC_ENTRY("Tester", "init")
	self->state = STATE_TOP;
	{
		int i;
		for (i=0; i<TESTER_HISTORY_SIZE; ++i)
			self->history[i] = NO_STATE;
	}
	executeInitTransition(self);
	ET_MSC_LOGGER_SYNC_EXIT
}


void Tester_receiveMessage(void* self, void* ifitem, const etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("Tester", "_receiveMessage")
	
	receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage))));
	
	ET_MSC_LOGGER_SYNC_EXIT
}


/*--------------------- operations ---------------------*/
