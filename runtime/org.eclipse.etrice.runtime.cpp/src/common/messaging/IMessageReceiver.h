/*
 * IMessageReceiver.h
 *
 *  Created on: 08.06.2012
 *      Author: karlitsc
 */

#ifndef IMESSAGERECEIVER_H_
#define IMESSAGERECEIVER_H_

#include "common/messaging/Address.h"
#include "common/messaging/Message.h"

namespace etRuntime {

class IMessageReceiver {
public:
	IMessageReceiver();
	virtual ~IMessageReceiver();

	virtual void receive(Message* msg);
	virtual Address getAddress();

};

} /* namespace etRuntime */
#endif /* IMESSAGERECEIVER_H_ */
