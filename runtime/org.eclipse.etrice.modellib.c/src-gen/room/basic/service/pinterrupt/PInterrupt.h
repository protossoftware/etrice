/**
 * @author generated by eTrice
 *
 * Header File of ProtocolClass PInterrupt
 * 
 */

#ifndef _ROOM_BASIC_SERVICE_PINTERRUPT_PINTERRUPT_H_
#define _ROOM_BASIC_SERVICE_PINTERRUPT_PINTERRUPT_H_

#include "etDatatypes.h"
#include "modelbase/etPort.h"


/* include all referenced room classes */


/* message IDs */
enum PInterrupt_msg_ids {
	PInterrupt_MSG_MIN = 0,
	PInterrupt_IN_event = 1,
	PInterrupt_MSG_MAX = 2
};

/*--------------------- port structs and methods */
typedef etPort PInterruptPort;
typedef etReplPort PInterruptReplPort;




etInt32 PInterruptReplPort_getReplication(const PInterruptReplPort* self);
typedef etPort PInterruptConjPort;
typedef etReplPort PInterruptConjReplPort;

/* variable part of PortClass (RAM) */
typedef struct PInterruptConjPort_var PInterruptConjPort_var; 
struct PInterruptConjPort_var {
	/*--------------------- attributes ---------------------*/
	 etMessage msg;
	 etHighPrioFunc callback;
	 uint8 enable;
};

void PInterruptConjPort_event(const PInterruptConjPort* self);
void PInterruptConjReplPort_event_broadcast(const PInterruptConjReplPort* self);
void PInterruptConjReplPort_event(const PInterruptConjReplPort* self, int idx);

/*--------------------- operations ---------------------*/
 PInterruptConjPort* PInterruptConjPort_export(PInterruptConjPort* self);
 void PInterruptConjPort_dispatch(PInterruptConjPort* self);
 void PInterruptConjPort_fire(PInterruptConjPort* self);

etInt32 PInterruptConjReplPort_getReplication(const PInterruptConjReplPort* self);

/*--------------------- debug helpers */

/* get message string for message id */
const char* PInterrupt_getMessageString(int msg_id);


#endif /* _ROOM_BASIC_SERVICE_PINTERRUPT_PINTERRUPT_H_ */

