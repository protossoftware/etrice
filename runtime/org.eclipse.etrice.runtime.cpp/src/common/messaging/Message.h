/*
 * Message.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#ifndef MESSAGE_H_
#define MESSAGE_H_

#include "common/messaging/Address.h"

namespace etRuntime {

class Message {
public:
	Message(Address addr) {};
	virtual ~Message();

private:
	Message();
};

} /* namespace etRuntime */
#endif /* MESSAGE_H_ */
