/**
 * @author generated by eTrice
 *
 * Source File of ProtocolClass PContractMonitorControl
 * 
 */

#include "PContractMonitorControl.h"
#include "debugging/etMSCLogger.h"
#include "PContractMonitorControl_Utils.h"


/*--------------------- port methods */

void PContractMonitorControlPort_violationStatus(const PContractMonitorControlPort* self, bool data__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlPort", "violationStatus")
		etPort_sendMessage(self, PContractMonitorControl_OUT_violationStatus, sizeof(bool), &data__et);
		ET_MSC_LOGGER_ASYNC_OUT(self->myInstName, "violationStatus", self->peerInstName)
	ET_MSC_LOGGER_SYNC_EXIT
}

void PContractMonitorControlReplPort_violationStatus_broadcast(const PContractMonitorControlReplPort* self, bool data__et) {
	int i;
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlReplPort", "violationStatus")
	for (i=0; i<((etReplPort*)self)->size; ++i) {
		etPort_sendMessage((&((etReplPort*)self)->ports[i].port), PContractMonitorControl_OUT_violationStatus, sizeof(bool), &data__et);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[i].port.myInstName, "violationStatus", ((etReplPort*)self)->ports[i].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void PContractMonitorControlReplPort_violationStatus(const PContractMonitorControlReplPort* self, int idx__et, bool data__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlReplPort", "violationStatus")
	if (0<=idx__et && idx__et<((etReplPort*)self)->size) {
		etPort_sendMessage((&((etReplPort*)self)->ports[idx__et].port), PContractMonitorControl_OUT_violationStatus, sizeof(bool), &data__et);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[idx__et].port.myInstName, "violationStatus", ((etReplPort*)self)->ports[idx__et].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}


void PContractMonitorControlPort_violationOccured(const PContractMonitorControlPort* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlPort", "violationOccured")
		etPort_sendMessage(self, PContractMonitorControl_OUT_violationOccured, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(self->myInstName, "violationOccured", self->peerInstName)
	ET_MSC_LOGGER_SYNC_EXIT
}

void PContractMonitorControlReplPort_violationOccured_broadcast(const PContractMonitorControlReplPort* self) {
	int i;
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlReplPort", "violationOccured")
	for (i=0; i<((etReplPort*)self)->size; ++i) {
		etPort_sendMessage((&((etReplPort*)self)->ports[i].port), PContractMonitorControl_OUT_violationOccured, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[i].port.myInstName, "violationOccured", ((etReplPort*)self)->ports[i].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void PContractMonitorControlReplPort_violationOccured(const PContractMonitorControlReplPort* self, int idx__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlReplPort", "violationOccured")
	if (0<=idx__et && idx__et<((etReplPort*)self)->size) {
		etPort_sendMessage((&((etReplPort*)self)->ports[idx__et].port), PContractMonitorControl_OUT_violationOccured, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[idx__et].port.myInstName, "violationOccured", ((etReplPort*)self)->ports[idx__et].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

etInt32 PContractMonitorControlReplPort_getReplication(const PContractMonitorControlReplPort* self) {
	return ((etReplPort*)self)->size;
}



void PContractMonitorControlConjPort_getAndResetStatus(const PContractMonitorControlConjPort* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlConjPort", "getAndResetStatus")
		etPort_sendMessage(self, PContractMonitorControl_IN_getAndResetStatus, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(self->myInstName, "getAndResetStatus", self->peerInstName)
	ET_MSC_LOGGER_SYNC_EXIT
}

void PContractMonitorControlConjReplPort_getAndResetStatus_broadcast(const PContractMonitorControlConjReplPort* self) {
	int i;
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlConjReplPort", "getAndResetStatus")
	for (i=0; i<((etReplPort*)self)->size; ++i) {
		etPort_sendMessage((&((etReplPort*)self)->ports[i].port), PContractMonitorControl_IN_getAndResetStatus, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[i].port.myInstName, "getAndResetStatus", ((etReplPort*)self)->ports[i].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void PContractMonitorControlConjReplPort_getAndResetStatus(const PContractMonitorControlConjReplPort* self, int idx__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlConjReplPort", "getAndResetStatus")
	if (0<=idx__et && idx__et<((etReplPort*)self)->size) {
		etPort_sendMessage((&((etReplPort*)self)->ports[idx__et].port), PContractMonitorControl_IN_getAndResetStatus, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[idx__et].port.myInstName, "getAndResetStatus", ((etReplPort*)self)->ports[idx__et].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}


void PContractMonitorControlConjPort_setForwardInvalidMessages(const PContractMonitorControlConjPort* self, bool data__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlConjPort", "setForwardInvalidMessages")
		etPort_sendMessage(self, PContractMonitorControl_IN_setForwardInvalidMessages, sizeof(bool), &data__et);
		ET_MSC_LOGGER_ASYNC_OUT(self->myInstName, "setForwardInvalidMessages", self->peerInstName)
	ET_MSC_LOGGER_SYNC_EXIT
}

void PContractMonitorControlConjReplPort_setForwardInvalidMessages_broadcast(const PContractMonitorControlConjReplPort* self, bool data__et) {
	int i;
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlConjReplPort", "setForwardInvalidMessages")
	for (i=0; i<((etReplPort*)self)->size; ++i) {
		etPort_sendMessage((&((etReplPort*)self)->ports[i].port), PContractMonitorControl_IN_setForwardInvalidMessages, sizeof(bool), &data__et);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[i].port.myInstName, "setForwardInvalidMessages", ((etReplPort*)self)->ports[i].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void PContractMonitorControlConjReplPort_setForwardInvalidMessages(const PContractMonitorControlConjReplPort* self, int idx__et, bool data__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PContractMonitorControlConjReplPort", "setForwardInvalidMessages")
	if (0<=idx__et && idx__et<((etReplPort*)self)->size) {
		etPort_sendMessage((&((etReplPort*)self)->ports[idx__et].port), PContractMonitorControl_IN_setForwardInvalidMessages, sizeof(bool), &data__et);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[idx__et].port.myInstName, "setForwardInvalidMessages", ((etReplPort*)self)->ports[idx__et].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

etInt32 PContractMonitorControlConjReplPort_getReplication(const PContractMonitorControlConjReplPort* self) {
	return ((etReplPort*)self)->size;
}



/*--------------------- debug helpers */

/* message names as strings for debugging (generate MSC) */
static const char* const PContractMonitorControl_messageStrings[] = {"MIN", "violationStatus","violationOccured","getAndResetStatus", "setForwardInvalidMessages", "MAX"};

const char* PContractMonitorControl_getMessageString(int msg_id) {
	if (msg_id<PContractMonitorControl_MSG_MIN || msg_id>PContractMonitorControl_MSG_MAX+1){
		/* id out of range */
		return "Message ID out of range";
	}
	else{
		return PContractMonitorControl_messageStrings[msg_id];
	}
}