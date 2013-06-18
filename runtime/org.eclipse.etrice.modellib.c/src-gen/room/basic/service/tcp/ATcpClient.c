/**
 * @author generated by eTrice
 *
 * Source File of ActorClass ATcpClient
 * 
 */

#include "ATcpClient.h"

#include "modelbase/etActor.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"
#include "etUnit/etUnit.h"
#include "osal/etMemory.h"

#include "room/basic/service/tcp/PTcpControl.h"
#include "room/basic/service/tcp/PTcpPayload.h"

/*--------------------- begin user code ---------------------*/
static int8* bufferProvider(void* slf, int* size) {
	ATcpClient* self = (ATcpClient*) slf;
	*size = 1000;
	return self->payload.data;
}

static int socketReceiver(void* slf, int channel, int size, const int8* data) {
	ATcpClient* self = (ATcpClient*) slf;
	self->payload.length = size;
	PTcpPayloadPort_receive(&self->constData->PayloadPort, &self->payload);
	return ETSOCKET_OK;
}
/*--------------------- end user code ---------------------*/

/* interface item IDs */
enum interface_items {
	IFITEM_ControlPort = 1,
	IFITEM_PayloadPort = 2
};

/* state IDs */
enum state_ids {
	NO_STATE = 0,
	STATE_TOP = 1,
	STATE_closed = 2,
	STATE_opened = 3,
	STATE_error = 4,
	STATE_MAX = 5
};

/* transition chains */
enum chain_ids {
	CHAIN_TRANS_INITIAL_TO__closed = 1,
	CHAIN_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort = 2,
	CHAIN_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort = 3,
	CHAIN_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3 = 4
};

/* triggers */
enum triggers {
	POLLING = 0,
	TRIG_PayloadPort__send = IFITEM_PayloadPort + EVT_SHIFT*PTcpPayload_IN_send,
	TRIG_ControlPort__close = IFITEM_ControlPort + EVT_SHIFT*PTcpControl_IN_close,
	TRIG_ControlPort__open = IFITEM_ControlPort + EVT_SHIFT*PTcpControl_IN_open
};


static void setState(ATcpClient* self, etInt16 new_state) {
	self->state = new_state;
}

static etInt16 getState(ATcpClient* self) {
	return self->state;
}

/* Entry and Exit Codes */

/* Action Codes */
static void action_TRANS_INITIAL_TO__closed(ATcpClient* self) {
	printf("Client Init!\n");
}
static void action_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort(ATcpClient* self, const InterfaceItemBase* ifitem, DTcpControl* data) {
	self->lastError /* ORIG: lastError */=0;
	/* connect to server */
	if (etConnectServer(self->client /* ORIG: client */, data->IPAddr, data->TcpPort)!=ETSOCKET_OK) self->lastError /* ORIG: lastError */ = 1;
}
static void action_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort(ATcpClient* self, const InterfaceItemBase* ifitem) {
	/* close read thread */
	etCloseSocket(self->client /* ORIG: client */);
}
static void action_TRANS_tr2_FROM_cp0_TO_opened(ATcpClient* self, const InterfaceItemBase* ifitem, DTcpControl* data) {
	PTcpControlPort_established(&self->constData->ControlPort) /* ORIG: ControlPort.established() */;
}
static void action_TRANS_socketError_FROM_cp0_TO_error_COND_socketError(ATcpClient* self, const InterfaceItemBase* ifitem, DTcpControl* data) {
	PTcpControlPort_error(&self->constData->ControlPort) /* ORIG: ControlPort.error() */;
	/* handle error */
}
static void action_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3(ATcpClient* self, const InterfaceItemBase* ifitem, DTcpPayload* data) {
	/* send payload
		out.write(data.getData(),0,data.length);
	*/
	etWriteSocket(self->client /* ORIG: client */, data->length, data->data);
}

/**
 * calls exit codes while exiting from the current state to one of its
 * parent states while remembering the history
 * @param current - the current state
 * @param to - the final parent state
 */
static void exitTo(ATcpClient* self, etInt16 current, etInt16 to) {
	while (current!=to) {
		switch (current) {
			case STATE_closed:
				self->history[STATE_TOP] = STATE_closed;
				current = STATE_TOP;
				break;
			case STATE_opened:
				self->history[STATE_TOP] = STATE_opened;
				current = STATE_TOP;
				break;
			case STATE_error:
				self->history[STATE_TOP] = STATE_error;
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
static etInt16 executeTransitionChain(ATcpClient* self, int chain, const InterfaceItemBase* ifitem, void* generic_data) {
	switch (chain) {
		case CHAIN_TRANS_INITIAL_TO__closed:
		{
			action_TRANS_INITIAL_TO__closed(self);
			return STATE_closed;
		}
		case CHAIN_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort:
		{
			DTcpControl* data = ((DTcpControl*) generic_data);
			action_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort(self, ifitem, data);
			if (self->lastError /* ORIG: lastError */!=0) {
			action_TRANS_socketError_FROM_cp0_TO_error_COND_socketError(self, ifitem, data);
			return STATE_error;}
			else {
			action_TRANS_tr2_FROM_cp0_TO_opened(self, ifitem, data);
			return STATE_opened;}
		}
		case CHAIN_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort:
		{
			action_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort(self, ifitem);
			return STATE_closed;
		}
		case CHAIN_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3:
		{
			DTcpPayload* data = ((DTcpPayload*) generic_data);
			action_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3(self, ifitem, data);
			return STATE_opened;
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
static etInt16 enterHistory(ATcpClient* self, etInt16 state) {
	boolean skip_entry = FALSE;
	if (state >= STATE_MAX) {
		state = (etInt16) (state - STATE_MAX);
		skip_entry = TRUE;
	}
	while (TRUE) {
		switch (state) {
			case STATE_closed:
				/* in leaf state: return state id */
				return STATE_closed;
			case STATE_opened:
				/* in leaf state: return state id */
				return STATE_opened;
			case STATE_error:
				/* in leaf state: return state id */
				return STATE_error;
			case STATE_TOP:
				state = self->history[STATE_TOP];
				break;
			default:
				/* should not occur */
				break;
		}
		skip_entry = FALSE;
	}
	/* return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true) */
}

static void ATcpClient_executeInitTransition(ATcpClient* self) {
	int chain = CHAIN_TRANS_INITIAL_TO__closed;
	etInt16 next = executeTransitionChain(self, chain, NULL, NULL);
	next = enterHistory(self, next);
	setState(self, next);
}

/* receiveEvent contains the main implementation of the FSM */
static void ATcpClient_receiveEvent(ATcpClient* self, InterfaceItemBase* ifitem, int evt, void* generic_data) {
	int trigger = ifitem->localId + EVT_SHIFT*evt;
	int chain = NOT_CAUGHT;
	etInt16 catching_state = NO_STATE;
	
	if (!handleSystemEvent(ifitem, evt, generic_data)) {
		switch (getState(self)) {
			case STATE_closed:
				switch(trigger) {
						case TRIG_ControlPort__open:
							{
								chain = CHAIN_TRANS_tr0_FROM_closed_TO_cp0_BY_openControlPort;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_opened:
				switch(trigger) {
						case TRIG_ControlPort__close:
							{
								chain = CHAIN_TRANS_tr1_FROM_opened_TO_closed_BY_closeControlPort;
								catching_state = STATE_TOP;
							}
						break;
						case TRIG_PayloadPort__send:
							{
								chain = CHAIN_TRANS_tr3_FROM_opened_TO_opened_BY_sendPayloadPort_tr3;
								catching_state = STATE_TOP;
							}
						break;
						default:
							/* should not occur */
							break;
				}
				break;
			case STATE_error:
				break;
			default:
				/* should not occur */
				break;
		}
	}
	if (chain != NOT_CAUGHT) {
		exitTo(self, getState(self), catching_state);
		{
			etInt16 next = executeTransitionChain(self, chain, ifitem, generic_data);
			next = enterHistory(self, next);
			setState(self, next);
		}
	}
}

void ATcpClient_init(ATcpClient* self){
	ET_MSC_LOGGER_SYNC_ENTRY("ATcpClient", "init")
	self->state = STATE_TOP;
	{
		int i;
		for (i=0; i<ATCPCLIENT_HISTORY_SIZE; ++i)
			self->history[i] = NO_STATE;
	}
	ATcpClient_executeInitTransition(self);
	ET_MSC_LOGGER_SYNC_EXIT
}


void ATcpClient_receiveMessage(void* self, void* ifitem, const etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("ATcpClient", "_receiveMessage")
	
	ATcpClient_receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage))));
	
	ET_MSC_LOGGER_SYNC_EXIT
}


/*--------------------- operations ---------------------*/
void ATcpClient_ctor(ATcpClient* self) {
	self->client /* ORIG: client */ = etCreateSocketConnectionData();
	self->client /* ORIG: client */->receiver = socketReceiver;
	self->client /* ORIG: client */->bufferProvider = bufferProvider;
	self->client /* ORIG: client */->userData = self;
}
void ATcpClient_dtor(ATcpClient* self) {
	etCloseSocket(self->client /* ORIG: client */);
	etFreeSocketConnectionData(self->client /* ORIG: client */);
}
void ATcpClient_stopUser(ATcpClient* self) {
	/* stop user: close socket */
}

