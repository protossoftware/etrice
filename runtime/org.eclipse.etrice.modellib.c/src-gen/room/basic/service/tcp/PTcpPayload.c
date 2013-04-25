/**
 * @author generated by eTrice
 *
 * Source File of ProtocolClass PTcpPayload
 * 
 */

#include "PTcpPayload.h"
#include "debugging/etMSCLogger.h"


/*--------------------- port methods */

void PTcpPayloadPort_receive(const PTcpPayloadPort* self, DTcpPayload* data) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTcpPayloadPort", "receive")
		etPort_sendMessage(self, PTcpPayload_OUT_receive, sizeof(DTcpPayload), data);
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTcpPayloadReplPort_receive_broadcast(const PTcpPayloadReplPort* self, DTcpPayload* data) {
	int i;
	ET_MSC_LOGGER_SYNC_ENTRY("PTcpPayloadReplPort", "receive")
	for (i=0; i<((etReplPort*)self)->size; ++i) {
		etPort_sendMessage(((etPort*)&((etReplPort*)self)->ports[i]), PTcpPayload_OUT_receive, sizeof(DTcpPayload), data);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTcpPayloadReplPort_receive(const PTcpPayloadReplPort* self, int idx, DTcpPayload* data) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTcpPayloadReplPort", "receive")
	if (0<=idx && idx<((etReplPort*)self)->size) {
		etPort_sendMessage(((etPort*)&((etReplPort*)self)->ports[idx]), PTcpPayload_OUT_receive, sizeof(DTcpPayload), data);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

etInt32 PTcpPayloadReplPort_getReplication(const PTcpPayloadReplPort* self) {
	return ((etReplPort*)self)->size;
}



void PTcpPayloadConjPort_send(const PTcpPayloadConjPort* self, DTcpPayload* data) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTcpPayloadConjPort", "send")
		etPort_sendMessage(self, PTcpPayload_IN_send, sizeof(DTcpPayload), data);
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTcpPayloadConjReplPort_send_broadcast(const PTcpPayloadConjReplPort* self, DTcpPayload* data) {
	int i;
	ET_MSC_LOGGER_SYNC_ENTRY("PTcpPayloadConjReplPort", "send")
	for (i=0; i<((etReplPort*)self)->size; ++i) {
		etPort_sendMessage(((etPort*)&((etReplPort*)self)->ports[i]), PTcpPayload_IN_send, sizeof(DTcpPayload), data);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTcpPayloadConjReplPort_send(const PTcpPayloadConjReplPort* self, int idx, DTcpPayload* data) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTcpPayloadConjReplPort", "send")
	if (0<=idx && idx<((etReplPort*)self)->size) {
		etPort_sendMessage(((etPort*)&((etReplPort*)self)->ports[idx]), PTcpPayload_IN_send, sizeof(DTcpPayload), data);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

etInt32 PTcpPayloadConjReplPort_getReplication(const PTcpPayloadConjReplPort* self) {
	return ((etReplPort*)self)->size;
}



/*--------------------- debug helpers */

/* message names as strings for debugging (generate MSC) */
static const char* const PTcpPayload_messageStrings[] = {"MIN", "receive","send", "MAX"};

const char* PTcpPayload_getMessageString(int msg_id) {
	if (msg_id<PTcpPayload_MSG_MIN || msg_id>PTcpPayload_MSG_MAX+1){
		/* id out of range */
		return "Message ID out of range";
	}
	else{
		return PTcpPayload_messageStrings[msg_id];
	}
}
